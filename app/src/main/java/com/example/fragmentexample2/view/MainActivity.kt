package com.example.fragmentexample2.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentContainerView
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import com.example.fragmentexample2.R
import com.example.fragmentexample2.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    lateinit var navigation: BottomNavigationView

    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        supportFragmentManager.commit {
            setReorderingAllowed(true)
            replace<FirstFragment>(R.id.fragment_container)
            addToBackStack("replacement")
        }


        navigation = findViewById(R.id.nav_menu)

        navigation.setOnItemSelectedListener { item ->

            when(item.itemId) {
                R.id.item_fragment1 -> {
                    supportFragmentManager.commit {
                        replace<FirstFragment>(R.id.fragment_container)
                        setReorderingAllowed(true)
                        addToBackStack("replacement")
                    }
                    return@setOnItemSelectedListener true
                }

                R.id.item_fragment2 -> {
                    supportFragmentManager.commit {
                        replace<SecondFragment>(R.id.fragment_container)
                        setReorderingAllowed(true)
                        addToBackStack("replacement")
                    }
                    return@setOnItemSelectedListener true
                }

                R.id.item_fragment3 -> {
                    supportFragmentManager.commit {
                        replace<ThirdFragment>(R.id.fragment_container)
                        setReorderingAllowed(true)
                        addToBackStack("replacement")
                    }
                    return@setOnItemSelectedListener true
                }


            }


            false
        }


    }
}
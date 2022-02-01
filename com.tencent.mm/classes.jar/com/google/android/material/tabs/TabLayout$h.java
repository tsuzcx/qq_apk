package com.google.android.material.tabs;

import androidx.viewpager.widget.ViewPager;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class TabLayout$h
  implements a
{
  private final ViewPager dyl;
  
  public TabLayout$h(ViewPager paramViewPager)
  {
    this.dyl = paramViewPager;
  }
  
  public void i(TabLayout.e parame)
  {
    AppMethodBeat.i(208940);
    this.dyl.setCurrentItem(parame.position);
    AppMethodBeat.o(208940);
  }
  
  public void j(TabLayout.e parame) {}
  
  public final void k(TabLayout.e parame) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.material.tabs.TabLayout.h
 * JD-Core Version:    0.7.0.1
 */
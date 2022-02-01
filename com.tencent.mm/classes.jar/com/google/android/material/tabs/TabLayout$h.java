package com.google.android.material.tabs;

import androidx.viewpager.widget.ViewPager;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class TabLayout$h
  implements a
{
  private final ViewPager bFl;
  
  public TabLayout$h(ViewPager paramViewPager)
  {
    this.bFl = paramViewPager;
  }
  
  public final void i(TabLayout.e parame)
  {
    AppMethodBeat.i(239856);
    this.bFl.setCurrentItem(parame.position);
    AppMethodBeat.o(239856);
  }
  
  public final void j(TabLayout.e parame) {}
  
  public final void k(TabLayout.e parame) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.google.android.material.tabs.TabLayout.h
 * JD-Core Version:    0.7.0.1
 */
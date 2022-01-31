package android.support.design.widget;

import android.support.v4.view.ViewPager;

public final class TabLayout$h
  implements TabLayout.b
{
  private final ViewPager lz;
  
  public TabLayout$h(ViewPager paramViewPager)
  {
    this.lz = paramViewPager;
  }
  
  public final void f(TabLayout.e parame)
  {
    this.lz.setCurrentItem(parame.mPosition);
  }
  
  public final void g(TabLayout.e parame) {}
  
  public final void h(TabLayout.e parame) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     android.support.design.widget.TabLayout.h
 * JD-Core Version:    0.7.0.1
 */
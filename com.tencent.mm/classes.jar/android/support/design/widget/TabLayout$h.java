package android.support.design.widget;

import android.support.v4.view.ViewPager;

public final class TabLayout$h
  implements TabLayout.b
{
  private final ViewPager kB;
  
  public TabLayout$h(ViewPager paramViewPager)
  {
    this.kB = paramViewPager;
  }
  
  public final void b(TabLayout.e parame)
  {
    this.kB.setCurrentItem(parame.mPosition);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     android.support.design.widget.TabLayout.h
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.finder.view.tabcomp;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.Window;
import com.tencent.mm.view.HardTouchableLayout;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/view/tabcomp/ITabContainer;", "", "getBackBtn", "Landroid/view/View;", "getLayoutId", "", "getTabLayout", "Landroid/support/design/widget/TabLayout;", "getTabLayoutContainer", "Lcom/tencent/mm/view/HardTouchableLayout;", "getViewPager", "Landroid/support/v4/view/ViewPager;", "onLayoutInflated", "", "window", "Landroid/view/Window;", "plugin-finder_release"})
public abstract interface g
{
  public abstract void c(Window paramWindow);
  
  public abstract TabLayout dHJ();
  
  public abstract HardTouchableLayout dHK();
  
  public abstract ViewPager dHL();
  
  public abstract View getBackBtn();
  
  public abstract int getLayoutId();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.tabcomp.g
 * JD-Core Version:    0.7.0.1
 */
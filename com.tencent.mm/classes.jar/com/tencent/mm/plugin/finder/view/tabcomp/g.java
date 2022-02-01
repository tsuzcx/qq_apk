package com.tencent.mm.plugin.finder.view.tabcomp;

import android.view.View;
import android.view.Window;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.tabs.TabLayout;
import com.tencent.mm.view.HardTouchableLayout;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/view/tabcomp/ITabContainer;", "", "getBackBtn", "Landroid/view/View;", "getLayoutId", "", "getTabLayout", "Lcom/google/android/material/tabs/TabLayout;", "getTabLayoutContainer", "Lcom/tencent/mm/view/HardTouchableLayout;", "getViewPager", "Landroidx/viewpager/widget/ViewPager;", "onLayoutInflated", "", "window", "Landroid/view/Window;", "plugin-finder_release"})
public abstract interface g
{
  public abstract void c(Window paramWindow);
  
  public abstract TabLayout ejU();
  
  public abstract HardTouchableLayout ejV();
  
  public abstract ViewPager ejW();
  
  public abstract View getBackBtn();
  
  public abstract int getLayoutId();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.tabcomp.g
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.finder.view.tabcomp;

import android.view.View;
import android.view.Window;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.tabs.TabLayout;
import com.tencent.mm.view.HardTouchableLayout;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/view/tabcomp/ITabContainer;", "", "getBackBtn", "Landroid/view/View;", "getFinderTabLayout", "Lcom/tencent/mm/plugin/finder/view/tabcomp/FinderTabLayout;", "getLayoutId", "", "getTabLayout", "Lcom/google/android/material/tabs/TabLayout;", "getTabLayoutContainer", "Lcom/tencent/mm/view/HardTouchableLayout;", "getViewPager", "Landroidx/viewpager/widget/ViewPager;", "onLayoutInflated", "", "window", "Landroid/view/Window;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract interface n
{
  public abstract void e(Window paramWindow);
  
  public abstract FinderTabLayout fmA();
  
  public abstract HardTouchableLayout fmB();
  
  public abstract ViewPager fmC();
  
  public abstract TabLayout fmz();
  
  public abstract View getBackBtn();
  
  public abstract int getLayoutId();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.tabcomp.n
 * JD-Core Version:    0.7.0.1
 */
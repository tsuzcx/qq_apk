package com.tencent.mm.plugin.finder.view.tabcomp;

import android.view.View;
import android.view.Window;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.tabs.TabLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.b.g;
import com.tencent.mm.view.HardTouchableLayout;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/view/tabcomp/FinderListTabContainer;", "Lcom/tencent/mm/plugin/finder/view/tabcomp/ITabContainer;", "()V", "finderTabLayout", "Lcom/google/android/material/tabs/TabLayout;", "getFinderTabLayout", "()Lcom/google/android/material/tabs/TabLayout;", "setFinderTabLayout", "(Lcom/google/android/material/tabs/TabLayout;)V", "fragmentViewPager", "Landroidx/viewpager/widget/ViewPager;", "getFragmentViewPager", "()Landroidx/viewpager/widget/ViewPager;", "setFragmentViewPager", "(Landroidx/viewpager/widget/ViewPager;)V", "layoutContainer", "Lcom/tencent/mm/view/HardTouchableLayout;", "getLayoutContainer", "()Lcom/tencent/mm/view/HardTouchableLayout;", "setLayoutContainer", "(Lcom/tencent/mm/view/HardTouchableLayout;)V", "getBackBtn", "Landroid/view/View;", "getLayoutId", "", "getTabLayout", "getTabLayoutContainer", "getViewPager", "onLayoutInflated", "", "window", "Landroid/view/Window;", "plugin-finder_release"})
public final class b
  implements g
{
  private TabLayout BfM;
  private HardTouchableLayout BfN;
  private ViewPager BfO;
  
  public final void c(Window paramWindow)
  {
    AppMethodBeat.i(279223);
    p.k(paramWindow, "window");
    this.BfM = ((TabLayout)paramWindow.findViewById(b.f.tabLayout));
    this.BfO = ((ViewPager)paramWindow.findViewById(b.f.viewPager));
    this.BfN = ((HardTouchableLayout)paramWindow.findViewById(b.f.tabLayoutContainer));
    AppMethodBeat.o(279223);
  }
  
  public final TabLayout ejU()
  {
    return this.BfM;
  }
  
  public final HardTouchableLayout ejV()
  {
    return this.BfN;
  }
  
  public final ViewPager ejW()
  {
    return this.BfO;
  }
  
  public final View getBackBtn()
  {
    return null;
  }
  
  public final int getLayoutId()
  {
    return b.g.finder_list_tab_common_ui;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.tabcomp.b
 * JD-Core Version:    0.7.0.1
 */
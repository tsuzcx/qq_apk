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

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/view/tabcomp/FinderTabContainer;", "Lcom/tencent/mm/plugin/finder/view/tabcomp/ITabContainer;", "()V", "finderTabLayout", "Lcom/google/android/material/tabs/TabLayout;", "getFinderTabLayout", "()Lcom/google/android/material/tabs/TabLayout;", "setFinderTabLayout", "(Lcom/google/android/material/tabs/TabLayout;)V", "fragmentViewPager", "Landroidx/viewpager/widget/ViewPager;", "getFragmentViewPager", "()Landroidx/viewpager/widget/ViewPager;", "setFragmentViewPager", "(Landroidx/viewpager/widget/ViewPager;)V", "layoutContainer", "Lcom/tencent/mm/view/HardTouchableLayout;", "getLayoutContainer", "()Lcom/tencent/mm/view/HardTouchableLayout;", "setLayoutContainer", "(Lcom/tencent/mm/view/HardTouchableLayout;)V", "tabBackBtn", "Landroid/view/View;", "getTabBackBtn", "()Landroid/view/View;", "setTabBackBtn", "(Landroid/view/View;)V", "getBackBtn", "getLayoutId", "", "getTabLayout", "getTabLayoutContainer", "getViewPager", "onLayoutInflated", "", "window", "Landroid/view/Window;", "plugin-finder_release"})
public class d
  implements g
{
  private TabLayout BfM;
  private HardTouchableLayout BfN;
  private ViewPager BfO;
  private View BfU;
  
  public final void c(Window paramWindow)
  {
    AppMethodBeat.i(242711);
    p.k(paramWindow, "window");
    this.BfU = paramWindow.findViewById(b.f.backBtn);
    this.BfM = ((TabLayout)paramWindow.findViewById(b.f.tabLayout));
    this.BfO = ((ViewPager)paramWindow.findViewById(b.f.viewPager));
    this.BfN = ((HardTouchableLayout)paramWindow.findViewById(b.f.tabLayoutContainer));
    AppMethodBeat.o(242711);
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
  
  public View getBackBtn()
  {
    return this.BfU;
  }
  
  public int getLayoutId()
  {
    return b.g.finder_wx_msg_tab_common_ui;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.tabcomp.d
 * JD-Core Version:    0.7.0.1
 */
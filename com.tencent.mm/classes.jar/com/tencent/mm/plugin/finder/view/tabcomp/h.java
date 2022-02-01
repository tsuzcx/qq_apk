package com.tencent.mm.plugin.finder.view.tabcomp;

import android.view.View;
import android.view.Window;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.tabs.TabLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.plugin.finder.e.f;
import com.tencent.mm.view.HardTouchableLayout;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/view/tabcomp/FinderListTabContainer;", "Lcom/tencent/mm/plugin/finder/view/tabcomp/ITabContainer;", "()V", "finderTabLayout", "Lcom/google/android/material/tabs/TabLayout;", "getFinderTabLayout", "()Lcom/google/android/material/tabs/TabLayout;", "setFinderTabLayout", "(Lcom/google/android/material/tabs/TabLayout;)V", "fragmentViewPager", "Landroidx/viewpager/widget/ViewPager;", "getFragmentViewPager", "()Landroidx/viewpager/widget/ViewPager;", "setFragmentViewPager", "(Landroidx/viewpager/widget/ViewPager;)V", "layoutContainer", "Lcom/tencent/mm/view/HardTouchableLayout;", "getLayoutContainer", "()Lcom/tencent/mm/view/HardTouchableLayout;", "setLayoutContainer", "(Lcom/tencent/mm/view/HardTouchableLayout;)V", "getBackBtn", "Landroid/view/View;", "Lcom/tencent/mm/plugin/finder/view/tabcomp/FinderTabLayout;", "getLayoutId", "", "getTabLayout", "getTabLayoutContainer", "getViewPager", "onLayoutInflated", "", "window", "Landroid/view/Window;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class h
  implements n
{
  private TabLayout GJj;
  private HardTouchableLayout GJk;
  private ViewPager GJl;
  
  public final void e(Window paramWindow)
  {
    AppMethodBeat.i(345556);
    s.u(paramWindow, "window");
    this.GJj = ((TabLayout)paramWindow.findViewById(e.e.tabLayout));
    this.GJl = ((ViewPager)paramWindow.findViewById(e.e.viewPager));
    this.GJk = ((HardTouchableLayout)paramWindow.findViewById(e.e.tabLayoutContainer));
    AppMethodBeat.o(345556);
  }
  
  public final FinderTabLayout fmA()
  {
    return null;
  }
  
  public final HardTouchableLayout fmB()
  {
    return this.GJk;
  }
  
  public final ViewPager fmC()
  {
    return this.GJl;
  }
  
  public final TabLayout fmz()
  {
    return this.GJj;
  }
  
  public final View getBackBtn()
  {
    return null;
  }
  
  public final int getLayoutId()
  {
    return e.f.finder_list_tab_common_ui;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.tabcomp.h
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.finder.view.tabcomp;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.view.HardTouchableLayout;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/view/tabcomp/FinderListTabContainer;", "Lcom/tencent/mm/plugin/finder/view/tabcomp/ITabContainer;", "()V", "finderTabLayout", "Landroid/support/design/widget/TabLayout;", "getFinderTabLayout", "()Landroid/support/design/widget/TabLayout;", "setFinderTabLayout", "(Landroid/support/design/widget/TabLayout;)V", "fragmentViewPager", "Landroid/support/v4/view/ViewPager;", "getFragmentViewPager", "()Landroid/support/v4/view/ViewPager;", "setFragmentViewPager", "(Landroid/support/v4/view/ViewPager;)V", "layoutContainer", "Lcom/tencent/mm/view/HardTouchableLayout;", "getLayoutContainer", "()Lcom/tencent/mm/view/HardTouchableLayout;", "setLayoutContainer", "(Lcom/tencent/mm/view/HardTouchableLayout;)V", "getBackBtn", "Landroid/view/View;", "getLayoutId", "", "getTabLayout", "getTabLayoutContainer", "getViewPager", "onLayoutInflated", "", "window", "Landroid/view/Window;", "plugin-finder_release"})
public final class b
  implements g
{
  private TabLayout wtv;
  private HardTouchableLayout wtw;
  private ViewPager wtx;
  
  public final void c(Window paramWindow)
  {
    AppMethodBeat.i(255290);
    p.h(paramWindow, "window");
    this.wtv = ((TabLayout)paramWindow.findViewById(2131308820));
    this.wtx = ((ViewPager)paramWindow.findViewById(2131309856));
    this.wtw = ((HardTouchableLayout)paramWindow.findViewById(2131308821));
    AppMethodBeat.o(255290);
  }
  
  public final TabLayout dHJ()
  {
    return this.wtv;
  }
  
  public final HardTouchableLayout dHK()
  {
    return this.wtw;
  }
  
  public final ViewPager dHL()
  {
    return this.wtx;
  }
  
  public final View getBackBtn()
  {
    return null;
  }
  
  public final int getLayoutId()
  {
    return 2131494361;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.tabcomp.b
 * JD-Core Version:    0.7.0.1
 */
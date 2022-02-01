package com.tencent.mm.plugin.finder.view.tabcomp;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.view.HardTouchableLayout;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/view/tabcomp/FinderTabContainer;", "Lcom/tencent/mm/plugin/finder/view/tabcomp/ITabContainer;", "()V", "finderTabLayout", "Landroid/support/design/widget/TabLayout;", "getFinderTabLayout", "()Landroid/support/design/widget/TabLayout;", "setFinderTabLayout", "(Landroid/support/design/widget/TabLayout;)V", "fragmentViewPager", "Landroid/support/v4/view/ViewPager;", "getFragmentViewPager", "()Landroid/support/v4/view/ViewPager;", "setFragmentViewPager", "(Landroid/support/v4/view/ViewPager;)V", "layoutContainer", "Lcom/tencent/mm/view/HardTouchableLayout;", "getLayoutContainer", "()Lcom/tencent/mm/view/HardTouchableLayout;", "setLayoutContainer", "(Lcom/tencent/mm/view/HardTouchableLayout;)V", "tabBackBtn", "Landroid/view/View;", "getTabBackBtn", "()Landroid/view/View;", "setTabBackBtn", "(Landroid/view/View;)V", "getBackBtn", "getLayoutId", "", "getTabLayout", "getTabLayoutContainer", "getViewPager", "onLayoutInflated", "", "window", "Landroid/view/Window;", "plugin-finder_release"})
public class d
  implements g
{
  private View wtD;
  private TabLayout wtv;
  private HardTouchableLayout wtw;
  private ViewPager wtx;
  
  public final void c(Window paramWindow)
  {
    AppMethodBeat.i(255302);
    p.h(paramWindow, "window");
    this.wtD = paramWindow.findViewById(2131297160);
    this.wtv = ((TabLayout)paramWindow.findViewById(2131308820));
    this.wtx = ((ViewPager)paramWindow.findViewById(2131309856));
    this.wtw = ((HardTouchableLayout)paramWindow.findViewById(2131308821));
    AppMethodBeat.o(255302);
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
  
  public View getBackBtn()
  {
    return this.wtD;
  }
  
  public int getLayoutId()
  {
    return 2131494678;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.tabcomp.d
 * JD-Core Version:    0.7.0.1
 */
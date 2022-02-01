package com.tencent.mm.plugin.finder.viewmodel.notifytab;

import android.view.Window;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.tabs.TabLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.plugin.finder.e.f;
import com.tencent.mm.plugin.finder.view.tabcomp.FinderTabLayout;
import com.tencent.mm.plugin.finder.view.tabcomp.j;
import com.tencent.mm.view.HardTouchableLayout;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/viewmodel/notifytab/FinderNotifyTabContainer;", "Lcom/tencent/mm/plugin/finder/view/tabcomp/FinderTabContainer;", "()V", "alignTabLayout", "Lcom/tencent/mm/plugin/finder/view/tabcomp/FinderTabLayout;", "getFinderTabLayout", "getLayoutId", "", "getTabLayout", "Lcom/google/android/material/tabs/TabLayout;", "onLayoutInflated", "", "window", "Landroid/view/Window;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  extends j
{
  private FinderTabLayout GWC;
  
  public final void e(Window paramWindow)
  {
    AppMethodBeat.i(337380);
    s.u(paramWindow, "window");
    hi(paramWindow.findViewById(e.e.backBtn));
    this.GWC = ((FinderTabLayout)paramWindow.findViewById(e.e.tabLayout));
    a((ViewPager)paramWindow.findViewById(e.e.viewPager));
    a((HardTouchableLayout)paramWindow.findViewById(e.e.tabLayoutContainer));
    AppMethodBeat.o(337380);
  }
  
  public final FinderTabLayout fmA()
  {
    return this.GWC;
  }
  
  public final TabLayout fmz()
  {
    return null;
  }
  
  public final int getLayoutId()
  {
    return e.f.finder_wx_msg_notify_ui;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.notifytab.b
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.finder.nearby.live.localcity;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.cm;
import com.tencent.mm.plugin.finder.b.j;
import com.tencent.mm.plugin.finder.nearby.base.AbsNearByFragment;
import com.tencent.mm.plugin.finder.nearby.report.e;
import com.tencent.mm.plugin.finder.viewmodel.component.aj;
import com.tencent.mm.protocal.protobuf.bcz;
import com.tencent.mm.ui.component.UIComponent;
import java.util.HashMap;
import java.util.Set;
import kotlin.a.ak;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/nearby/live/localcity/NearbyLiveLocalCityFragment;", "Lcom/tencent/mm/plugin/finder/nearby/base/AbsNearByFragment;", "()V", "isFirstOnResume", "", "tabInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLiveTabInfo;", "getTabInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderLiveTabInfo;", "setTabInfo", "(Lcom/tencent/mm/protocal/protobuf/FinderLiveTabInfo;)V", "getClickSubTabId", "", "getClickTabId", "getCommentScene", "", "getPageName", "getReportType", "importUIComponents", "", "Ljava/lang/Class;", "Lcom/tencent/mm/ui/component/UIComponent;", "onActionbarClick", "", "onActionbarDoubleClick", "onDestroy", "onPause", "onResume", "onUserVisibleFocused", "onUserVisibleUnFocused", "plugin-finder-nearby_release"})
public final class NearbyLiveLocalCityFragment
  extends AbsNearByFragment
{
  private HashMap _$_findViewCache;
  private bcz zDU;
  private boolean zEs = true;
  
  public NearbyLiveLocalCityFragment()
  {
    super(b.j.nearby_tab_live, 1006);
  }
  
  public final void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(203553);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(203553);
  }
  
  public final String akA()
  {
    AppMethodBeat.i(203551);
    StringBuilder localStringBuilder = new StringBuilder("112-");
    Object localObject = this.zDU;
    if (localObject != null) {}
    for (localObject = Integer.valueOf(((bcz)localObject).SOa);; localObject = "")
    {
      localObject = localObject;
      AppMethodBeat.o(203551);
      return localObject;
    }
  }
  
  public final void dLt()
  {
    AppMethodBeat.i(203545);
    super.dLt();
    a locala = ((c)component(c.class)).zEZ;
    if (locala == null) {
      p.bGy("liveFriendsPresenter");
    }
    if (locala != null)
    {
      locala.onActionbarClick(false);
      AppMethodBeat.o(203545);
      return;
    }
    AppMethodBeat.o(203545);
  }
  
  public final void dLu()
  {
    AppMethodBeat.i(203547);
    super.dLu();
    a locala = ((c)component(c.class)).zEZ;
    if (locala == null) {
      p.bGy("liveFriendsPresenter");
    }
    if (locala != null)
    {
      locala.onActionbarClick(true);
      AppMethodBeat.o(203547);
      return;
    }
    AppMethodBeat.o(203547);
  }
  
  public final String dLv()
  {
    return "8003";
  }
  
  public final String dLw()
  {
    AppMethodBeat.i(203549);
    Object localObject = this.zDU;
    if (localObject != null) {}
    for (localObject = Integer.valueOf(((bcz)localObject).SOa);; localObject = null)
    {
      String str = String.valueOf(localObject);
      localObject = str;
      if (str == null) {
        localObject = "";
      }
      AppMethodBeat.o(203549);
      return localObject;
    }
  }
  
  public final int duR()
  {
    return 3;
  }
  
  public final int getCommentScene()
  {
    return 112;
  }
  
  public final Set<Class<? extends UIComponent>> importUIComponents()
  {
    AppMethodBeat.i(203535);
    Set localSet = ak.setOf(new Class[] { aj.class, c.class });
    AppMethodBeat.o(203535);
    return localSet;
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(203543);
    super.onDestroy();
    com.tencent.mm.plugin.finder.nearby.live.report.a locala = com.tencent.mm.plugin.finder.nearby.live.report.a.zGc;
    com.tencent.mm.plugin.finder.nearby.live.report.a.reset();
    AppMethodBeat.o(203543);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(203539);
    super.onPause();
    if (getActivity() != null)
    {
      locala = com.tencent.mm.plugin.finder.nearby.live.report.a.zGc;
      com.tencent.mm.plugin.finder.nearby.live.report.a.c((AbsNearByFragment)this);
    }
    com.tencent.mm.plugin.finder.nearby.live.report.a locala = com.tencent.mm.plugin.finder.nearby.live.report.a.zGc;
    com.tencent.mm.plugin.finder.nearby.live.report.a.onPause();
    AppMethodBeat.o(203539);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(203538);
    super.onResume();
    if ((!this.zEs) && (getActivity() != null))
    {
      locala = com.tencent.mm.plugin.finder.nearby.live.report.a.zGc;
      com.tencent.mm.plugin.finder.nearby.live.report.a.b((AbsNearByFragment)this);
    }
    this.zEs = false;
    com.tencent.mm.plugin.finder.nearby.live.report.a locala = com.tencent.mm.plugin.finder.nearby.live.report.a.zGc;
    com.tencent.mm.plugin.finder.nearby.live.report.a.onResume();
    AppMethodBeat.o(203538);
  }
  
  public final void onUserVisibleFocused()
  {
    AppMethodBeat.i(203540);
    super.onUserVisibleFocused();
    if (this.zDU == null)
    {
      this.zDU = new bcz();
      localObject = this.zDU;
      if (localObject != null) {
        ((bcz)localObject).SOa = 88889;
      }
      localObject = "8003" + "-" + cm.bfE();
      com.tencent.mm.plugin.finder.nearby.live.report.a locala = com.tencent.mm.plugin.finder.nearby.live.report.a.zGc;
      com.tencent.mm.plugin.finder.nearby.live.report.a.a(e.zJs.agX(), (AbsNearByFragment)this, (String)localObject);
    }
    Object localObject = e.zJs;
    e.d((AbsNearByFragment)this);
    localObject = com.tencent.mm.plugin.finder.nearby.live.report.a.zGc;
    com.tencent.mm.plugin.finder.nearby.live.report.a.b((AbsNearByFragment)this);
    AppMethodBeat.o(203540);
  }
  
  public final void onUserVisibleUnFocused()
  {
    AppMethodBeat.i(203542);
    super.onUserVisibleUnFocused();
    Object localObject = e.zJs;
    e.e((AbsNearByFragment)this);
    localObject = com.tencent.mm.plugin.finder.nearby.live.report.a.zGc;
    com.tencent.mm.plugin.finder.nearby.live.report.a.c((AbsNearByFragment)this);
    AppMethodBeat.o(203542);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.nearby.live.localcity.NearbyLiveLocalCityFragment
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.finder.nearby.live.localcity;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.cn;
import com.tencent.mm.plugin.finder.e.h;
import com.tencent.mm.plugin.finder.nearby.base.AbsNearByFragment;
import com.tencent.mm.plugin.finder.nearby.report.g;
import com.tencent.mm.plugin.finder.viewmodel.component.as;
import com.tencent.mm.protocal.protobuf.bnn;
import com.tencent.mm.ui.component.UIComponent;
import java.util.Set;
import kotlin.Metadata;
import kotlin.a.ar;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/nearby/live/localcity/NearbyLiveLocalCityFragment;", "Lcom/tencent/mm/plugin/finder/nearby/base/AbsNearByFragment;", "()V", "isFirstOnResume", "", "tabInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLiveTabInfo;", "getTabInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderLiveTabInfo;", "setTabInfo", "(Lcom/tencent/mm/protocal/protobuf/FinderLiveTabInfo;)V", "getClickSubTabId", "", "getClickTabId", "getCommentScene", "", "getPageName", "getReportType", "importUIComponents", "", "Ljava/lang/Class;", "Lcom/tencent/mm/ui/component/UIComponent;", "onActionbarClick", "", "onActionbarDoubleClick", "onDestroy", "onPause", "onResume", "onUserVisibleFocused", "onUserVisibleUnFocused", "plugin-finder-nearby_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class NearbyLiveLocalCityFragment
  extends AbsNearByFragment
{
  private bnn EIq;
  private boolean isFirstOnResume = true;
  
  public NearbyLiveLocalCityFragment()
  {
    super(e.h.nearby_tab_live, 1006);
  }
  
  public final void eEq()
  {
    AppMethodBeat.i(340872);
    super.eEq();
    a locala2 = ((c)component(c.class)).EJO;
    a locala1 = locala2;
    if (locala2 == null)
    {
      s.bIx("liveFriendsPresenter");
      locala1 = null;
    }
    locala1.onActionbarClick(false);
    AppMethodBeat.o(340872);
  }
  
  public final void eEr()
  {
    AppMethodBeat.i(340879);
    super.eEr();
    a locala2 = ((c)component(c.class)).EJO;
    a locala1 = locala2;
    if (locala2 == null)
    {
      s.bIx("liveFriendsPresenter");
      locala1 = null;
    }
    locala1.onActionbarClick(true);
    AppMethodBeat.o(340879);
  }
  
  public final String eEt()
  {
    return "8003";
  }
  
  public final String eEu()
  {
    AppMethodBeat.i(340899);
    Object localObject = this.EIq;
    if (localObject == null) {}
    for (localObject = null;; localObject = Integer.valueOf(((bnn)localObject).ZVZ))
    {
      localObject = String.valueOf(localObject);
      if (localObject != null) {
        break;
      }
      AppMethodBeat.o(340899);
      return "";
    }
    AppMethodBeat.o(340899);
    return localObject;
  }
  
  public final String eEw()
  {
    AppMethodBeat.i(340908);
    StringBuilder localStringBuilder = new StringBuilder("112-");
    Object localObject = this.EIq;
    if (localObject == null) {}
    for (localObject = "";; localObject = Integer.valueOf(((bnn)localObject).ZVZ))
    {
      localObject = localObject;
      AppMethodBeat.o(340908);
      return localObject;
    }
  }
  
  public final int edC()
  {
    return 3;
  }
  
  public final int getCommentScene()
  {
    return 112;
  }
  
  public final Set<Class<? extends UIComponent>> importUIComponents()
  {
    AppMethodBeat.i(340836);
    Set localSet = ar.setOf(new Class[] { as.class, c.class });
    AppMethodBeat.o(340836);
    return localSet;
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(340864);
    super.onDestroy();
    com.tencent.mm.plugin.finder.nearby.live.report.a locala = com.tencent.mm.plugin.finder.nearby.live.report.a.ELu;
    com.tencent.mm.plugin.finder.nearby.live.report.a.reset();
    AppMethodBeat.o(340864);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(340849);
    super.onPause();
    if (getActivity() != null) {
      com.tencent.mm.plugin.finder.nearby.live.report.a.ELu.c((AbsNearByFragment)this);
    }
    com.tencent.mm.plugin.finder.nearby.live.report.a locala = com.tencent.mm.plugin.finder.nearby.live.report.a.ELu;
    com.tencent.mm.plugin.finder.nearby.live.report.a.onPause();
    AppMethodBeat.o(340849);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(340841);
    super.onResume();
    if ((!this.isFirstOnResume) && (getActivity() != null)) {
      com.tencent.mm.plugin.finder.nearby.live.report.a.ELu.b((AbsNearByFragment)this);
    }
    this.isFirstOnResume = false;
    com.tencent.mm.plugin.finder.nearby.live.report.a locala = com.tencent.mm.plugin.finder.nearby.live.report.a.ELu;
    com.tencent.mm.plugin.finder.nearby.live.report.a.onResume();
    AppMethodBeat.o(340841);
  }
  
  public final void onUserVisibleFocused()
  {
    AppMethodBeat.i(340853);
    super.onUserVisibleFocused();
    if (this.EIq == null)
    {
      this.EIq = new bnn();
      localObject = this.EIq;
      if (localObject != null) {
        ((bnn)localObject).ZVZ = 88889;
      }
      localObject = "8003" + '-' + cn.bDw();
      com.tencent.mm.plugin.finder.nearby.live.report.a locala = com.tencent.mm.plugin.finder.nearby.live.report.a.ELu;
      com.tencent.mm.plugin.finder.nearby.live.report.a.a(g.ERj.eeL(), (AbsNearByFragment)this, (String)localObject);
    }
    Object localObject = g.ERj;
    g.d((AbsNearByFragment)this);
    com.tencent.mm.plugin.finder.nearby.live.report.a.ELu.b((AbsNearByFragment)this);
    AppMethodBeat.o(340853);
  }
  
  public final void onUserVisibleUnFocused()
  {
    AppMethodBeat.i(340857);
    super.onUserVisibleUnFocused();
    g localg = g.ERj;
    g.e((AbsNearByFragment)this);
    com.tencent.mm.plugin.finder.nearby.live.report.a.ELu.c((AbsNearByFragment)this);
    AppMethodBeat.o(340857);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.nearby.live.localcity.NearbyLiveLocalCityFragment
 * JD-Core Version:    0.7.0.1
 */
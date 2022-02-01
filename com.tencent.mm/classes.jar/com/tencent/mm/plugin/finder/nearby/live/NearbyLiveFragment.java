package com.tencent.mm.plugin.finder.nearby.live;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.nearby.base.AbsNearByFragment;
import com.tencent.mm.plugin.finder.report.live.k;
import com.tencent.mm.plugin.finder.report.live.s.af;
import com.tencent.mm.plugin.finder.ui.f;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.component.UIComponent;
import java.util.HashMap;
import java.util.Set;
import kotlin.a.ak;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/nearby/live/NearbyLiveFragment;", "Lcom/tencent/mm/plugin/finder/nearby/base/AbsNearByFragment;", "()V", "getClickTabContextId", "", "getCommentScene", "", "getPageName", "getReportType", "importUIComponents", "", "Ljava/lang/Class;", "Lcom/tencent/mm/ui/component/UIComponent;", "onActionbarClick", "", "onActionbarDoubleClick", "onMenuClick", "plugin-finder_release"})
public final class NearbyLiveFragment
  extends AbsNearByFragment
{
  private HashMap _$_findViewCache;
  
  public NearbyLiveFragment()
  {
    super(2131763491, 1001);
  }
  
  public final void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(249055);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(249055);
  }
  
  public final String ack()
  {
    return "1001";
  }
  
  public final String afB()
  {
    return "76-1001";
  }
  
  public final int ddN()
  {
    return 3;
  }
  
  public final void dlk()
  {
    AppMethodBeat.i(249054);
    super.dlk();
    if (getActivity() == null)
    {
      Log.w("MicroMsg.UIComponentFragment", "onMenuClick()");
      AppMethodBeat.o(249054);
      return;
    }
    Object localObject = ((NearbyLiveUIC)component(NearbyLiveUIC.class)).uRi;
    if (localObject == null) {
      p.btv("livePostHelper");
    }
    ((f)localObject).prepare();
    localObject = k.vkd;
    k.a(s.af.vqn);
    AppMethodBeat.o(249054);
  }
  
  public final void dll()
  {
    AppMethodBeat.i(249052);
    super.dll();
    if (getActivity() == null)
    {
      Log.w("MicroMsg.UIComponentFragment", "onActionbarClick()");
      AppMethodBeat.o(249052);
      return;
    }
    d locald = ((NearbyLiveUIC)component(NearbyLiveUIC.class)).uRj;
    if (locald == null) {
      p.btv("liveFriendsPresenter");
    }
    if (locald != null)
    {
      locald.onActionbarClick(false);
      AppMethodBeat.o(249052);
      return;
    }
    AppMethodBeat.o(249052);
  }
  
  public final void dlm()
  {
    AppMethodBeat.i(249053);
    super.dlm();
    if (getActivity() == null)
    {
      Log.w("MicroMsg.UIComponentFragment", "onActionbarDoubleClick()");
      AppMethodBeat.o(249053);
      return;
    }
    d locald = ((NearbyLiveUIC)component(NearbyLiveUIC.class)).uRj;
    if (locald == null) {
      p.btv("liveFriendsPresenter");
    }
    if (locald != null)
    {
      locald.onActionbarClick(true);
      AppMethodBeat.o(249053);
      return;
    }
    AppMethodBeat.o(249053);
  }
  
  public final int getCommentScene()
  {
    return 76;
  }
  
  public final Set<Class<? extends UIComponent>> importUIComponents()
  {
    AppMethodBeat.i(249051);
    Set localSet = ak.setOf(new Class[] { FinderReporterUIC.class, NearbyLiveUIC.class });
    AppMethodBeat.o(249051);
    return localSet;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.nearby.live.NearbyLiveFragment
 * JD-Core Version:    0.7.0.1
 */
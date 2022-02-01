package com.tencent.mm.plugin.finder.nearby.video;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.nearby.base.AbsNearByFragment;
import com.tencent.mm.plugin.finder.nearby.report.d;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.ui.component.UIComponent;
import java.util.HashMap;
import java.util.Set;
import kotlin.a.ak;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/nearby/video/NearbyVideoFragment;", "Lcom/tencent/mm/plugin/finder/nearby/base/AbsNearByFragment;", "()V", "getClickTabContextId", "", "getCommentScene", "", "getPageName", "getReportType", "importUIComponents", "", "Ljava/lang/Class;", "Lcom/tencent/mm/ui/component/UIComponent;", "onActionbarClick", "", "onActionbarDoubleClick", "onMenuClick", "onUserVisibleFocused", "onUserVisibleUnFocused", "plugin-finder_release"})
public final class NearbyVideoFragment
  extends AbsNearByFragment
{
  private HashMap _$_findViewCache;
  
  public NearbyVideoFragment()
  {
    super(2131763493, 1002);
  }
  
  public final void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(249391);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(249391);
  }
  
  public final String ack()
  {
    return "1002";
  }
  
  public final String afB()
  {
    return "15-1002";
  }
  
  public final int ddN()
  {
    return 3;
  }
  
  public final void dlk()
  {
    AppMethodBeat.i(249388);
    super.dlk();
    AppMethodBeat.o(249388);
  }
  
  public final void dll()
  {
    AppMethodBeat.i(249386);
    super.dll();
    NearbyVideoPresenter localNearbyVideoPresenter = ((NearbyVideoUIC)component(NearbyVideoUIC.class)).uTB;
    if (localNearbyVideoPresenter != null)
    {
      localNearbyVideoPresenter.onActionbarClick(false);
      AppMethodBeat.o(249386);
      return;
    }
    AppMethodBeat.o(249386);
  }
  
  public final void dlm()
  {
    AppMethodBeat.i(249387);
    super.dlm();
    NearbyVideoPresenter localNearbyVideoPresenter = ((NearbyVideoUIC)component(NearbyVideoUIC.class)).uTB;
    if (localNearbyVideoPresenter != null)
    {
      localNearbyVideoPresenter.onActionbarClick(true);
      AppMethodBeat.o(249387);
      return;
    }
    AppMethodBeat.o(249387);
  }
  
  public final int getCommentScene()
  {
    return 15;
  }
  
  public final Set<Class<? extends UIComponent>> importUIComponents()
  {
    AppMethodBeat.i(249385);
    Set localSet = ak.setOf(new Class[] { FinderReporterUIC.class, NearbyVideoUIC.class });
    AppMethodBeat.o(249385);
    return localSet;
  }
  
  public final void onUserVisibleFocused()
  {
    AppMethodBeat.i(249389);
    super.onUserVisibleFocused();
    d locald = d.uTq;
    d.b((AbsNearByFragment)this);
    AppMethodBeat.o(249389);
  }
  
  public final void onUserVisibleUnFocused()
  {
    AppMethodBeat.i(249390);
    super.onUserVisibleUnFocused();
    d locald = d.uTq;
    d.c((AbsNearByFragment)this);
    AppMethodBeat.o(249390);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.nearby.video.NearbyVideoFragment
 * JD-Core Version:    0.7.0.1
 */
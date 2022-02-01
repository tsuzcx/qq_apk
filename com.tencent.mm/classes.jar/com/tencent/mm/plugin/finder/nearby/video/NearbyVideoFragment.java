package com.tencent.mm.plugin.finder.nearby.video;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.b.j;
import com.tencent.mm.plugin.finder.nearby.base.AbsNearByFragment;
import com.tencent.mm.plugin.finder.nearby.report.e;
import com.tencent.mm.plugin.finder.viewmodel.component.aj;
import com.tencent.mm.ui.component.UIComponent;
import java.util.HashMap;
import java.util.Set;
import kotlin.a.ak;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/nearby/video/NearbyVideoFragment;", "Lcom/tencent/mm/plugin/finder/nearby/base/AbsNearByFragment;", "()V", "getClickTabId", "", "getCommentScene", "", "getPageName", "getReportType", "importUIComponents", "", "Ljava/lang/Class;", "Lcom/tencent/mm/ui/component/UIComponent;", "onActionbarClick", "", "onActionbarDoubleClick", "onMenuClick", "onUserVisibleFocused", "onUserVisibleUnFocused", "plugin-finder-nearby_release"})
public final class NearbyVideoFragment
  extends AbsNearByFragment
{
  private HashMap _$_findViewCache;
  
  public NearbyVideoFragment()
  {
    super(b.j.nearby_tab_video, 1002);
  }
  
  public final void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(201409);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(201409);
  }
  
  public final String akA()
  {
    return "15-1002";
  }
  
  public final void dLs()
  {
    AppMethodBeat.i(201401);
    super.dLs();
    AppMethodBeat.o(201401);
  }
  
  public final void dLt()
  {
    AppMethodBeat.i(201398);
    super.dLt();
    NearbyVideoPresenter localNearbyVideoPresenter = ((d)component(d.class)).zJO;
    if (localNearbyVideoPresenter != null)
    {
      localNearbyVideoPresenter.onActionbarClick(false);
      AppMethodBeat.o(201398);
      return;
    }
    AppMethodBeat.o(201398);
  }
  
  public final void dLu()
  {
    AppMethodBeat.i(201400);
    super.dLu();
    NearbyVideoPresenter localNearbyVideoPresenter = ((d)component(d.class)).zJO;
    if (localNearbyVideoPresenter != null)
    {
      localNearbyVideoPresenter.onActionbarClick(true);
      AppMethodBeat.o(201400);
      return;
    }
    AppMethodBeat.o(201400);
  }
  
  public final String dLv()
  {
    return "1002";
  }
  
  public final int duR()
  {
    return 3;
  }
  
  public final int getCommentScene()
  {
    return 15;
  }
  
  public final Set<Class<? extends UIComponent>> importUIComponents()
  {
    AppMethodBeat.i(201396);
    Set localSet = ak.setOf(new Class[] { aj.class, d.class });
    AppMethodBeat.o(201396);
    return localSet;
  }
  
  public final void onUserVisibleFocused()
  {
    AppMethodBeat.i(201405);
    super.onUserVisibleFocused();
    e locale = e.zJs;
    e.d((AbsNearByFragment)this);
    AppMethodBeat.o(201405);
  }
  
  public final void onUserVisibleUnFocused()
  {
    AppMethodBeat.i(201407);
    super.onUserVisibleUnFocused();
    e locale = e.zJs;
    e.e((AbsNearByFragment)this);
    AppMethodBeat.o(201407);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.nearby.video.NearbyVideoFragment
 * JD-Core Version:    0.7.0.1
 */
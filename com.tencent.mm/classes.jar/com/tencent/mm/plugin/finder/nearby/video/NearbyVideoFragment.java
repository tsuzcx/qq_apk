package com.tencent.mm.plugin.finder.nearby.video;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.e.h;
import com.tencent.mm.plugin.finder.nearby.base.AbsNearByFragment;
import com.tencent.mm.plugin.finder.nearby.report.g;
import com.tencent.mm.plugin.finder.viewmodel.component.as;
import com.tencent.mm.ui.component.UIComponent;
import java.util.Set;
import kotlin.Metadata;
import kotlin.a.ar;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/nearby/video/NearbyVideoFragment;", "Lcom/tencent/mm/plugin/finder/nearby/base/AbsNearByFragment;", "()V", "getClickTabId", "", "getCommentScene", "", "getPageName", "getReportType", "importUIComponents", "", "Ljava/lang/Class;", "Lcom/tencent/mm/ui/component/UIComponent;", "isNeedSwitchTabOnResume", "", "onActionbarClick", "", "onActionbarDoubleClick", "onMenuClick", "onUserVisibleFocused", "onUserVisibleUnFocused", "plugin-finder-nearby_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class NearbyVideoFragment
  extends AbsNearByFragment
{
  public NearbyVideoFragment()
  {
    super(e.h.nearby_tab_video, 1002);
  }
  
  public final void eEp()
  {
    AppMethodBeat.i(340200);
    super.eEp();
    AppMethodBeat.o(340200);
  }
  
  public final void eEq()
  {
    AppMethodBeat.i(340181);
    super.eEq();
    NearbyVideoPresenter localNearbyVideoPresenter = ((d)component(d.class)).ERO;
    if (localNearbyVideoPresenter != null) {
      localNearbyVideoPresenter.onActionbarClick(false);
    }
    AppMethodBeat.o(340181);
  }
  
  public final void eEr()
  {
    AppMethodBeat.i(340192);
    super.eEr();
    NearbyVideoPresenter localNearbyVideoPresenter = ((d)component(d.class)).ERO;
    if (localNearbyVideoPresenter != null) {
      localNearbyVideoPresenter.onActionbarClick(true);
    }
    AppMethodBeat.o(340192);
  }
  
  public final boolean eEs()
  {
    return false;
  }
  
  public final String eEt()
  {
    return "1002";
  }
  
  public final String eEw()
  {
    AppMethodBeat.i(340234);
    String str = s.X("15-", "1002");
    AppMethodBeat.o(340234);
    return str;
  }
  
  public final int edC()
  {
    return 3;
  }
  
  public final int getCommentScene()
  {
    return 15;
  }
  
  public final Set<Class<? extends UIComponent>> importUIComponents()
  {
    AppMethodBeat.i(340175);
    Set localSet = ar.setOf(new Class[] { as.class, d.class });
    AppMethodBeat.o(340175);
    return localSet;
  }
  
  public final void onUserVisibleFocused()
  {
    AppMethodBeat.i(340207);
    super.onUserVisibleFocused();
    g localg = g.ERj;
    g.d((AbsNearByFragment)this);
    AppMethodBeat.o(340207);
  }
  
  public final void onUserVisibleUnFocused()
  {
    AppMethodBeat.i(340214);
    super.onUserVisibleUnFocused();
    g localg = g.ERj;
    g.e((AbsNearByFragment)this);
    AppMethodBeat.o(340214);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.nearby.video.NearbyVideoFragment
 * JD-Core Version:    0.7.0.1
 */
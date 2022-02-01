package com.tencent.mm.plugin.finder.nearby.live.square.tab;

import android.animation.AnimatorSet;
import android.arch.lifecycle.ViewModelProvider;
import android.support.v4.app.Fragment;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.finder.nearby.live.d;
import com.tencent.mm.plugin.finder.nearby.live.square.NearbyLiveSquareGuideUIC;
import com.tencent.mm.protocal.protobuf.axj;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.view.RefreshLoadMoreLayout.c;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/nearby/live/square/tab/NearbyLiveSquareTabPresenter;", "Lcom/tencent/mm/plugin/finder/nearby/live/NearbyLivePresenter;", "activity", "Lcom/tencent/mm/ui/MMActivity;", "fragment", "Landroid/support/v4/app/Fragment;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "tabInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLiveTabInfo;", "(Lcom/tencent/mm/ui/MMActivity;Landroid/support/v4/app/Fragment;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;Lcom/tencent/mm/protocal/protobuf/FinderLiveTabInfo;)V", "getCommentScene", "", "getHeaderInfo", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$FixedViewInfo;", "getLocalTypeFlag", "getTabType", "onDetach", "", "onRefreshEnd", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "", "plugin-finder_release"})
public final class b
  extends d
{
  public b(MMActivity paramMMActivity, Fragment paramFragment, bbn parambbn, axj paramaxj)
  {
    super(paramMMActivity, parambbn);
    AppMethodBeat.i(249240);
    this.fragment = paramFragment;
    this.uQK = paramaxj;
    AppMethodBeat.o(249240);
  }
  
  public final int dlq()
  {
    axj localaxj = this.uQK;
    if (localaxj != null) {}
    for (int i = localaxj.LHQ;; i = 0) {
      return i + 15;
    }
  }
  
  public final int getCommentScene()
  {
    return this.ttO.tCE;
  }
  
  public final int getTabType()
  {
    axj localaxj = this.uQK;
    if (localaxj != null) {}
    for (int i = localaxj.LHQ;; i = 0) {
      return i + 1001;
    }
  }
  
  public final void onDetach()
  {
    AppMethodBeat.i(249239);
    Object localObject = com.tencent.mm.ui.component.a.PRN;
    localObject = this.fragment;
    if (localObject == null) {
      p.hyc();
    }
    localObject = ((Fragment)localObject).getParentFragment();
    if (localObject == null) {
      p.hyc();
    }
    p.g(localObject, "fragment!!.parentFragment!!");
    localObject = ((NearbyLiveSquareGuideUIC)com.tencent.mm.ui.component.a.of((Fragment)localObject).get(NearbyLiveSquareGuideUIC.class)).uRs.uQy;
    if ((localObject != null) && (((AnimatorSet)localObject).isRunning()))
    {
      ((AnimatorSet)localObject).pause();
      ((AnimatorSet)localObject).cancel();
    }
    super.onDetach();
    AppMethodBeat.o(249239);
  }
  
  public final void onRefreshEnd(RefreshLoadMoreLayout.c<Object> paramc)
  {
    AppMethodBeat.i(249238);
    p.h(paramc, "reason");
    super.onRefreshEnd(paramc);
    paramc = g.aAh();
    p.g(paramc, "MMKernel.storage()");
    if (paramc.azQ().getBoolean(ar.a.OmS, true))
    {
      paramc = com.tencent.mm.ui.component.a.PRN;
      paramc = this.fragment;
      if (paramc == null) {
        p.hyc();
      }
      paramc = paramc.getParentFragment();
      if (paramc == null) {
        p.hyc();
      }
      p.g(paramc, "fragment!!.parentFragment!!");
      paramc = ((NearbyLiveSquareGuideUIC)com.tencent.mm.ui.component.a.of(paramc).get(NearbyLiveSquareGuideUIC.class)).uRs;
      AnimatorSet localAnimatorSet = paramc.uQy;
      if (localAnimatorSet != null) {
        localAnimatorSet.setStartDelay(100L);
      }
      paramc = paramc.uQy;
      if (paramc != null) {
        paramc.start();
      }
      paramc = g.aAh();
      p.g(paramc, "MMKernel.storage()");
      paramc.azQ().set(ar.a.OmS, Boolean.FALSE);
    }
    AppMethodBeat.o(249238);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.nearby.live.square.tab.b
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.finder.nearby.live.square.page;

import android.animation.AnimatorSet;
import androidx.fragment.app.Fragment;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.finder.nearby.guide.a;
import com.tencent.mm.plugin.finder.nearby.live.e;
import com.tencent.mm.plugin.finder.nearby.live.square.tab.d;
import com.tencent.mm.protocal.protobuf.bcz;
import com.tencent.mm.protocal.protobuf.bid;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.g;
import com.tencent.mm.ui.component.g.a;
import com.tencent.mm.view.RefreshLoadMoreLayout.c;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/nearby/live/square/page/NearbyLiveSquareTabPresenter;", "Lcom/tencent/mm/plugin/finder/nearby/live/NearbyLivePresenter;", "activity", "Lcom/tencent/mm/ui/MMActivity;", "fragment", "Landroidx/fragment/app/Fragment;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "tabInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLiveTabInfo;", "by_pass", "", "(Lcom/tencent/mm/ui/MMActivity;Landroidx/fragment/app/Fragment;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;Lcom/tencent/mm/protocal/protobuf/FinderLiveTabInfo;Ljava/lang/String;)V", "getCommentScene", "", "getHeaderInfo", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$FixedViewInfo;", "getLocalTypeFlag", "getTabType", "onDetach", "", "onRefreshEnd", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "", "plugin-finder-nearby_release"})
public final class b
  extends e
{
  public b(MMActivity paramMMActivity, Fragment paramFragment, bid parambid, bcz parambcz, String paramString)
  {
    super(paramMMActivity, parambid, paramString);
    AppMethodBeat.i(200990);
    this.fragment = paramFragment;
    this.zDU = parambcz;
    AppMethodBeat.o(200990);
  }
  
  public final int dLz()
  {
    bcz localbcz = this.zDU;
    if (localbcz != null) {}
    for (int i = localbcz.SOa;; i = 0) {
      return i + 15;
    }
  }
  
  public final int getCommentScene()
  {
    return this.xbu.xkX;
  }
  
  public final int getTabType()
  {
    bcz localbcz = this.zDU;
    if (localbcz != null) {}
    for (int i = localbcz.SOa;; i = 0) {
      return i + 1001;
    }
  }
  
  public final void onDetach()
  {
    AppMethodBeat.i(200985);
    Object localObject = g.Xox;
    localObject = this.fragment;
    if (localObject == null) {
      p.iCn();
    }
    localObject = ((Fragment)localObject).getParentFragment();
    if (localObject == null) {
      p.iCn();
    }
    p.j(localObject, "fragment!!.parentFragment!!");
    localObject = ((d)g.h((Fragment)localObject).i(d.class)).zHi.zDJ;
    if ((localObject != null) && (((AnimatorSet)localObject).isRunning()))
    {
      ((AnimatorSet)localObject).pause();
      ((AnimatorSet)localObject).cancel();
    }
    super.onDetach();
    AppMethodBeat.o(200985);
  }
  
  public final void onRefreshEnd(RefreshLoadMoreLayout.c<Object> paramc)
  {
    AppMethodBeat.i(200981);
    p.k(paramc, "reason");
    super.onRefreshEnd(paramc);
    paramc = h.aHG();
    p.j(paramc, "MMKernel.storage()");
    if (paramc.aHp().getBoolean(ar.a.VBS, true))
    {
      paramc = g.Xox;
      paramc = this.fragment;
      if (paramc == null) {
        p.iCn();
      }
      paramc = paramc.getParentFragment();
      if (paramc == null) {
        p.iCn();
      }
      p.j(paramc, "fragment!!.parentFragment!!");
      paramc = ((d)g.h(paramc).i(d.class)).zHi;
      AnimatorSet localAnimatorSet = paramc.zDJ;
      if (localAnimatorSet != null) {
        localAnimatorSet.setStartDelay(100L);
      }
      paramc = paramc.zDJ;
      if (paramc != null) {
        paramc.start();
      }
      paramc = h.aHG();
      p.j(paramc, "MMKernel.storage()");
      paramc.aHp().set(ar.a.VBS, Boolean.FALSE);
    }
    AppMethodBeat.o(200981);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.nearby.live.square.page.b
 * JD-Core Version:    0.7.0.1
 */
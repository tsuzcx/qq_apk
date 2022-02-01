package com.tencent.mm.plugin.finder.nearby.live.square.page;

import androidx.fragment.app.Fragment;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.nearby.live.e;
import com.tencent.mm.protocal.protobuf.bnn;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.k;
import com.tencent.mm.ui.component.k.b;
import com.tencent.mm.view.RefreshLoadMoreLayout.d;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/nearby/live/square/page/NearbyLiveSquareTabPresenter;", "Lcom/tencent/mm/plugin/finder/nearby/live/NearbyLivePresenter;", "activity", "Lcom/tencent/mm/ui/MMActivity;", "fragment", "Landroidx/fragment/app/Fragment;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "tabInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLiveTabInfo;", "by_pass", "", "(Lcom/tencent/mm/ui/MMActivity;Landroidx/fragment/app/Fragment;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;Lcom/tencent/mm/protocal/protobuf/FinderLiveTabInfo;Ljava/lang/String;)V", "getCommentScene", "", "getHeaderInfo", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$FixedViewInfo;", "getLocalTypeFlag", "getTabType", "onDetach", "", "onRefreshEnd", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "", "plugin-finder-nearby_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  extends e
{
  public c(MMActivity paramMMActivity, Fragment paramFragment, bui parambui, bnn parambnn, String paramString)
  {
    super(paramMMActivity, parambui, paramString);
    AppMethodBeat.i(341292);
    this.fragment = paramFragment;
    this.EIq = parambnn;
    AppMethodBeat.o(341292);
  }
  
  public final int eEC()
  {
    bnn localbnn = this.EIq;
    if (localbnn == null) {}
    for (int i = 0;; i = localbnn.ZVZ) {
      return i + 15;
    }
  }
  
  public final int getCommentScene()
  {
    return this.Auc.AJo;
  }
  
  public final int getTabType()
  {
    bnn localbnn = this.EIq;
    if (localbnn == null) {}
    for (int i = 0;; i = localbnn.ZVZ) {
      return i + 1001;
    }
  }
  
  public final void onDetach()
  {
    AppMethodBeat.i(341318);
    Object localObject = k.aeZF;
    localObject = this.fragment;
    s.checkNotNull(localObject);
    localObject = ((Fragment)localObject).getParentFragment();
    s.checkNotNull(localObject);
    s.s(localObject, "fragment!!.parentFragment!!");
    ((a)k.y((Fragment)localObject).q(a.class)).ELU.cancel();
    super.onDetach();
    AppMethodBeat.o(341318);
  }
  
  public final void onRefreshEnd(RefreshLoadMoreLayout.d<Object> paramd)
  {
    AppMethodBeat.i(341310);
    s.u(paramd, "reason");
    super.onRefreshEnd(paramd);
    paramd = b.ELW;
    if (!b.QN(this.Auc.AJo))
    {
      paramd = b.ELW;
      if (!b.QO(this.Auc.AJo))
      {
        paramd = this.fragment;
        if (paramd != null)
        {
          paramd = paramd.getParentFragment();
          if (paramd != null)
          {
            Object localObject1 = k.aeZF;
            localObject1 = (com.tencent.mm.plugin.finder.nearby.live.square.b)k.y(paramd).q(com.tencent.mm.plugin.finder.nearby.live.square.b.class);
            Object localObject2 = this.fragment;
            if (localObject2 == null)
            {
              paramd = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.finder.nearby.live.square.page.NearbyLiveSquareTabFragment");
              AppMethodBeat.o(341310);
              throw paramd;
            }
            localObject1 = ((com.tencent.mm.plugin.finder.nearby.live.square.b)localObject1).b((NearbyLiveSquareTabFragment)localObject2);
            localObject2 = k.aeZF;
            ((a)k.y(paramd).q(a.class)).ELU.a((NearbyLiveSquareTabFragment)localObject1);
          }
        }
      }
    }
    AppMethodBeat.o(341310);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.nearby.live.square.page.c
 * JD-Core Version:    0.7.0.1
 */
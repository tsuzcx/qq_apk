package com.tencent.mm.plugin.finder.nearby.live.localcity;

import androidx.fragment.app.Fragment;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.nearby.live.e;
import com.tencent.mm.protocal.protobuf.bnn;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.ui.MMActivity;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/nearby/live/localcity/NearbyLiveLocalCityPresenter;", "Lcom/tencent/mm/plugin/finder/nearby/live/NearbyLivePresenter;", "activity", "Lcom/tencent/mm/ui/MMActivity;", "fragment", "Landroidx/fragment/app/Fragment;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "tabInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLiveTabInfo;", "(Lcom/tencent/mm/ui/MMActivity;Landroidx/fragment/app/Fragment;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;Lcom/tencent/mm/protocal/protobuf/FinderLiveTabInfo;)V", "getCommentScene", "", "getHeaderInfo", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$FixedViewInfo;", "getLocalTypeFlag", "getTabType", "plugin-finder-nearby_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends e
{
  public a(MMActivity paramMMActivity, Fragment paramFragment, bui parambui, bnn parambnn)
  {
    super(paramMMActivity, parambui);
    AppMethodBeat.i(340828);
    this.fragment = paramFragment;
    this.EIq = parambnn;
    AppMethodBeat.o(340828);
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.nearby.live.localcity.a
 * JD-Core Version:    0.7.0.1
 */
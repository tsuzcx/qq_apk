package com.tencent.mm.plugin.finder.nearby.live.localcity;

import androidx.fragment.app.Fragment;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.nearby.live.e;
import com.tencent.mm.protocal.protobuf.bcz;
import com.tencent.mm.protocal.protobuf.bid;
import com.tencent.mm.ui.MMActivity;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/nearby/live/localcity/NearbyLiveLocalCityPresenter;", "Lcom/tencent/mm/plugin/finder/nearby/live/NearbyLivePresenter;", "activity", "Lcom/tencent/mm/ui/MMActivity;", "fragment", "Landroidx/fragment/app/Fragment;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "tabInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLiveTabInfo;", "(Lcom/tencent/mm/ui/MMActivity;Landroidx/fragment/app/Fragment;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;Lcom/tencent/mm/protocal/protobuf/FinderLiveTabInfo;)V", "getCommentScene", "", "getHeaderInfo", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$FixedViewInfo;", "getLocalTypeFlag", "getTabType", "plugin-finder-nearby_release"})
public final class a
  extends e
{
  public a(MMActivity paramMMActivity, Fragment paramFragment, bid parambid, bcz parambcz)
  {
    super(paramMMActivity, parambid);
    AppMethodBeat.i(203353);
    this.fragment = paramFragment;
    this.zDU = parambcz;
    AppMethodBeat.o(203353);
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.nearby.live.localcity.a
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.appbrand.ui.recommend;

import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.widget.recyclerview.LoadMoreRecyclerView.a;
import com.tencent.mm.sdk.platformtools.ab;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "<anonymous parameter 0>", "Lcom/tencent/mm/plugin/appbrand/widget/recyclerview/LoadMoreRecyclerView;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "onLoadMore"})
final class AppBrandRecommendUILogic$h
  implements LoadMoreRecyclerView.a
{
  AppBrandRecommendUILogic$h(AppBrandRecommendUILogic paramAppBrandRecommendUILogic) {}
  
  public final void aNj()
  {
    AppMethodBeat.i(135190);
    if (AppBrandRecommendUILogic.a(this.iWS).aNN())
    {
      ab.d(AppBrandRecommendUILogic.access$getTAG$cp(), "can load more: let's do fetch");
      AppBrandRecommendUILogic.b(this.iWS);
    }
    AppMethodBeat.o(135190);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.recommend.AppBrandRecommendUILogic.h
 * JD-Core Version:    0.7.0.1
 */
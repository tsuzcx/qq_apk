package com.tencent.mm.plugin.finder.convert;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.model.n;
import com.tencent.mm.plugin.finder.report.b;
import com.tencent.mm.plugin.finder.view.FinderMediaBanner;
import com.tencent.mm.plugin.finder.view.adapter.FinderMediaBannerAdapter;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.view.MediaBannerIndicator;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import d.g.b.k;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/convert/FinderFeedVideoConvert;", "Lcom/tencent/mm/plugin/finder/convert/FinderFeedConvert;", "Lcom/tencent/mm/plugin/finder/model/FinderFeedVideo;", "videoCore", "Lcom/tencent/mm/plugin/finder/video/FinderVideoCore;", "contract", "Lcom/tencent/mm/plugin/finder/feed/FinderFeedContract;", "safeMode", "", "tabType", "", "(Lcom/tencent/mm/plugin/finder/video/FinderVideoCore;Lcom/tencent/mm/plugin/finder/feed/FinderFeedContract;ZI)V", "renderScriptBlur", "Lcom/tencent/mm/ui/blur/RenderScriptBlur;", "convertMedia", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "type", "getLayoutId", "onAttachedToRecyclerView", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "adapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "onCreateViewHolder", "onDetachedFromRecyclerView", "onMediaClick", "view", "Landroid/view/View;", "finderObject", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "plugin-finder_release"})
public class r
  extends e<n>
{
  private final com.tencent.mm.plugin.finder.feed.c qqD;
  private final com.tencent.mm.plugin.finder.video.c qrq;
  private com.tencent.mm.ui.blur.e vfi;
  
  private r(com.tencent.mm.plugin.finder.video.c paramc, com.tencent.mm.plugin.finder.feed.c paramc1, boolean paramBoolean, int paramInt)
  {
    super(paramc1, paramBoolean, paramInt);
    AppMethodBeat.i(165434);
    this.qrq = paramc;
    this.qqD = paramc1;
    AppMethodBeat.o(165434);
  }
  
  public final void a(RecyclerView paramRecyclerView, WxRecyclerAdapter<?> paramWxRecyclerAdapter)
  {
    AppMethodBeat.i(197447);
    k.h(paramRecyclerView, "recyclerView");
    k.h(paramWxRecyclerAdapter, "adapter");
    super.a(paramRecyclerView, paramWxRecyclerAdapter);
    ad.i("Finder.FeedConvert", "[onAttachedToRecyclerView]...");
    this.vfi = new com.tencent.mm.ui.blur.e(aj.getContext());
    AppMethodBeat.o(197447);
  }
  
  public final void a(RecyclerView paramRecyclerView, com.tencent.mm.view.recyclerview.e parame, int paramInt)
  {
    AppMethodBeat.i(165431);
    k.h(paramRecyclerView, "recyclerView");
    k.h(parame, "holder");
    super.a(paramRecyclerView, parame, paramInt);
    parame = (FinderMediaBanner)parame.abq(2131302203);
    parame.setAdapter((RecyclerView.a)new FinderMediaBannerAdapter(this.qrq));
    parame.setViewPool(this.qqD.clM());
    parame.setParentRecyclerView(paramRecyclerView);
    parame.getIndicator().setShowOnlyOneIndicator(false);
    AppMethodBeat.o(165431);
  }
  
  public final void a(com.tencent.mm.view.recyclerview.e parame, View paramView, FinderObject paramFinderObject)
  {
    AppMethodBeat.i(165433);
    k.h(parame, "holder");
    k.h(paramView, "view");
    k.h(paramFinderObject, "finderObject");
    super.a(parame, paramView, paramFinderObject);
    parame = paramView.findViewById(2131304146);
    k.g(parame, "view.findViewById<View>(R.id.retry_btn)");
    if (parame.getVisibility() == 0)
    {
      AppMethodBeat.o(165433);
      return;
    }
    if (this.qrq.qTL != paramFinderObject.id)
    {
      AppMethodBeat.o(165433);
      return;
    }
    parame = b.qFq;
    b.b(paramFinderObject);
    AppMethodBeat.o(165433);
  }
  
  public final void d(RecyclerView paramRecyclerView)
  {
    AppMethodBeat.i(197448);
    k.h(paramRecyclerView, "recyclerView");
    super.d(paramRecyclerView);
    ad.i("Finder.FeedConvert", "[onDetachedFromRecyclerView]...");
    paramRecyclerView = this.vfi;
    if (paramRecyclerView != null)
    {
      paramRecyclerView.destroy();
      AppMethodBeat.o(197448);
      return;
    }
    AppMethodBeat.o(197448);
  }
  
  public final int getLayoutId()
  {
    return 2131492874;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.r
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.finder.convert;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.model.s;
import com.tencent.mm.plugin.finder.video.i;
import com.tencent.mm.plugin.finder.view.FinderMediaBanner;
import com.tencent.mm.plugin.finder.view.adapter.FinderMediaBannerAdapter;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.view.MediaBannerIndicator;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/convert/FinderFeedVideoConvert;", "Lcom/tencent/mm/plugin/finder/convert/FinderFeedConvert;", "Lcom/tencent/mm/plugin/finder/model/FinderFeedVideo;", "videoCore", "Lcom/tencent/mm/plugin/finder/video/FinderVideoCore;", "contract", "Lcom/tencent/mm/plugin/finder/feed/FinderFeedContract;", "safeMode", "", "tabType", "", "(Lcom/tencent/mm/plugin/finder/video/FinderVideoCore;Lcom/tencent/mm/plugin/finder/feed/FinderFeedContract;ZI)V", "renderScriptBlur", "Lcom/tencent/mm/ui/blur/RenderScriptBlur;", "convertMedia", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "type", "getLayoutId", "onAttachedToRecyclerView", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "adapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "onCreateViewHolder", "onDetachedFromRecyclerView", "onMediaClick", "view", "Landroid/view/View;", "finderObject", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "plugin-finder_release"})
public class w
  extends h<s>
{
  private final com.tencent.mm.plugin.finder.feed.h rMI;
  private com.tencent.mm.ui.blur.e rOE;
  private final i rOe;
  
  private w(i parami, com.tencent.mm.plugin.finder.feed.h paramh, boolean paramBoolean, int paramInt)
  {
    super(paramh, paramBoolean, paramInt);
    AppMethodBeat.i(165434);
    this.rOe = parami;
    this.rMI = paramh;
    AppMethodBeat.o(165434);
  }
  
  public final void a(RecyclerView paramRecyclerView, WxRecyclerAdapter<?> paramWxRecyclerAdapter)
  {
    AppMethodBeat.i(201407);
    p.h(paramRecyclerView, "recyclerView");
    p.h(paramWxRecyclerAdapter, "adapter");
    super.a(paramRecyclerView, paramWxRecyclerAdapter);
    ad.i("Finder.FeedConvert", "[onAttachedToRecyclerView]...");
    this.rOE = new com.tencent.mm.ui.blur.e(aj.getContext());
    AppMethodBeat.o(201407);
  }
  
  public final void a(RecyclerView paramRecyclerView, com.tencent.mm.view.recyclerview.e parame, int paramInt)
  {
    AppMethodBeat.i(165431);
    p.h(paramRecyclerView, "recyclerView");
    p.h(parame, "holder");
    super.a(paramRecyclerView, parame, paramInt);
    parame = (FinderMediaBanner)parame.Gd(2131302203);
    parame.setAdapter((RecyclerView.a)new FinderMediaBannerAdapter(this.rOe));
    parame.setViewPool(this.rMI.cAF());
    parame.setParentRecyclerView(paramRecyclerView);
    parame.getIndicator().setShowOnlyOneIndicator(false);
    AppMethodBeat.o(165431);
  }
  
  public final void a(com.tencent.mm.view.recyclerview.e parame, View paramView, FinderObject paramFinderObject)
  {
    AppMethodBeat.i(165433);
    p.h(parame, "holder");
    p.h(paramView, "view");
    p.h(paramFinderObject, "finderObject");
    super.a(parame, paramView, paramFinderObject);
    parame = paramView.findViewById(2131304146);
    p.g(parame, "view.findViewById<View>(R.id.retry_btn)");
    if (parame.getVisibility() == 0)
    {
      AppMethodBeat.o(165433);
      return;
    }
    if (this.rOe.sPc != paramFinderObject.id)
    {
      AppMethodBeat.o(165433);
      return;
    }
    parame = com.tencent.mm.plugin.finder.report.h.soM;
    com.tencent.mm.plugin.finder.report.h.g(paramFinderObject);
    AppMethodBeat.o(165433);
  }
  
  public final void d(RecyclerView paramRecyclerView)
  {
    AppMethodBeat.i(201408);
    p.h(paramRecyclerView, "recyclerView");
    super.d(paramRecyclerView);
    ad.i("Finder.FeedConvert", "[onDetachedFromRecyclerView]...");
    paramRecyclerView = this.rOE;
    if (paramRecyclerView != null)
    {
      paramRecyclerView.destroy();
      AppMethodBeat.o(201408);
      return;
    }
    AppMethodBeat.o(201408);
  }
  
  public final int getLayoutId()
  {
    return 2131492874;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.w
 * JD-Core Version:    0.7.0.1
 */
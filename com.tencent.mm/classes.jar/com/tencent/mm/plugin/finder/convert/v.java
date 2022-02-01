package com.tencent.mm.plugin.finder.convert;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.model.s;
import com.tencent.mm.plugin.finder.report.d;
import com.tencent.mm.plugin.finder.video.i;
import com.tencent.mm.plugin.finder.view.FinderMediaBanner;
import com.tencent.mm.plugin.finder.view.adapter.FinderMediaBannerAdapter;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.view.MediaBannerIndicator;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import d.g.b.k;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/convert/FinderFeedVideoConvert;", "Lcom/tencent/mm/plugin/finder/convert/FinderFeedConvert;", "Lcom/tencent/mm/plugin/finder/model/FinderFeedVideo;", "videoCore", "Lcom/tencent/mm/plugin/finder/video/FinderVideoCore;", "contract", "Lcom/tencent/mm/plugin/finder/feed/FinderFeedContract;", "safeMode", "", "tabType", "", "(Lcom/tencent/mm/plugin/finder/video/FinderVideoCore;Lcom/tencent/mm/plugin/finder/feed/FinderFeedContract;ZI)V", "renderScriptBlur", "Lcom/tencent/mm/ui/blur/RenderScriptBlur;", "convertMedia", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "type", "getLayoutId", "onAttachedToRecyclerView", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "adapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "onCreateViewHolder", "onDetachedFromRecyclerView", "onMediaClick", "view", "Landroid/view/View;", "finderObject", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "plugin-finder_release"})
public class v
  extends g<s>
{
  private final com.tencent.mm.plugin.finder.feed.g ram;
  private com.tencent.mm.ui.blur.e rbR;
  private final i rbo;
  
  private v(i parami, com.tencent.mm.plugin.finder.feed.g paramg, boolean paramBoolean, int paramInt)
  {
    super(paramg, paramBoolean, paramInt);
    AppMethodBeat.i(165434);
    this.rbo = parami;
    this.ram = paramg;
    AppMethodBeat.o(165434);
  }
  
  public final void a(RecyclerView paramRecyclerView, WxRecyclerAdapter<?> paramWxRecyclerAdapter)
  {
    AppMethodBeat.i(201322);
    k.h(paramRecyclerView, "recyclerView");
    k.h(paramWxRecyclerAdapter, "adapter");
    super.a(paramRecyclerView, paramWxRecyclerAdapter);
    ac.i("Finder.FeedConvert", "[onAttachedToRecyclerView]...");
    this.rbR = new com.tencent.mm.ui.blur.e(ai.getContext());
    AppMethodBeat.o(201322);
  }
  
  public final void a(RecyclerView paramRecyclerView, com.tencent.mm.view.recyclerview.e parame, int paramInt)
  {
    AppMethodBeat.i(165431);
    k.h(paramRecyclerView, "recyclerView");
    k.h(parame, "holder");
    super.a(paramRecyclerView, parame, paramInt);
    parame = (FinderMediaBanner)parame.adJ(2131302203);
    parame.setAdapter((RecyclerView.a)new FinderMediaBannerAdapter(this.rbo));
    parame.setViewPool(this.ram.cuu());
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
    if (this.rbo.rSu != paramFinderObject.id)
    {
      AppMethodBeat.o(165433);
      return;
    }
    parame = d.rxr;
    d.f(paramFinderObject);
    AppMethodBeat.o(165433);
  }
  
  public final void d(RecyclerView paramRecyclerView)
  {
    AppMethodBeat.i(201323);
    k.h(paramRecyclerView, "recyclerView");
    super.d(paramRecyclerView);
    ac.i("Finder.FeedConvert", "[onDetachedFromRecyclerView]...");
    paramRecyclerView = this.rbR;
    if (paramRecyclerView != null)
    {
      paramRecyclerView.destroy();
      AppMethodBeat.o(201323);
      return;
    }
    AppMethodBeat.o(201323);
  }
  
  public final int getLayoutId()
  {
    return 2131492874;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.v
 * JD-Core Version:    0.7.0.1
 */
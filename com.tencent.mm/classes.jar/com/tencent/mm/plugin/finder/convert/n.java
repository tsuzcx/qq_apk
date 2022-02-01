package com.tencent.mm.plugin.finder.convert;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.event.base.c;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.q;
import com.tencent.mm.plugin.finder.report.w;
import com.tencent.mm.plugin.finder.report.w.a;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.view.FinderMediaBanner;
import com.tencent.mm.plugin.finder.view.adapter.FinderMediaBannerAdapter;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.a;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.bvz;
import com.tencent.mm.view.MediaBanner.c;
import com.tencent.mm.view.recyclerview.e;
import d.g.b.p;
import d.l;
import java.util.Collection;
import java.util.LinkedList;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/convert/FinderFeedMixConvert;", "Lcom/tencent/mm/plugin/finder/convert/FinderFeedConvert;", "Lcom/tencent/mm/plugin/finder/model/FinderFeedMix;", "videoCore", "Lcom/tencent/mm/plugin/finder/video/FinderVideoCore;", "contract", "Lcom/tencent/mm/plugin/finder/feed/FinderFeedContract;", "safeMode", "", "tabType", "", "(Lcom/tencent/mm/plugin/finder/video/FinderVideoCore;Lcom/tencent/mm/plugin/finder/feed/FinderFeedContract;ZI)V", "convertMedia", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "type", "getLayoutId", "onCreateViewHolder", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "onMediaClick", "view", "Landroid/view/View;", "finderObject", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "Companion", "plugin-finder_release"})
public class n
  extends h<q>
{
  public static final n.a rWC;
  private final com.tencent.mm.plugin.finder.feed.h rUW;
  private final com.tencent.mm.plugin.finder.video.i rWB;
  
  static
  {
    AppMethodBeat.i(165404);
    rWC = new n.a((byte)0);
    AppMethodBeat.o(165404);
  }
  
  private n(com.tencent.mm.plugin.finder.video.i parami, com.tencent.mm.plugin.finder.feed.h paramh, boolean paramBoolean, int paramInt)
  {
    super(paramh, paramBoolean, paramInt);
    AppMethodBeat.i(165402);
    this.rWB = parami;
    this.rUW = paramh;
    AppMethodBeat.o(165402);
  }
  
  public final void a(RecyclerView paramRecyclerView, e parame, int paramInt)
  {
    AppMethodBeat.i(165399);
    p.h(paramRecyclerView, "recyclerView");
    p.h(parame, "holder");
    super.a(paramRecyclerView, parame, paramInt);
    FinderMediaBanner localFinderMediaBanner = (FinderMediaBanner)parame.GD(2131302203);
    localFinderMediaBanner.setAdapter((RecyclerView.a)new FinderMediaBannerAdapter(this.rWB));
    localFinderMediaBanner.setViewPool(this.rUW.cCr());
    localFinderMediaBanner.setParentRecyclerView(paramRecyclerView);
    localFinderMediaBanner.setPageChangeCallback((MediaBanner.c)new b(parame));
    AppMethodBeat.o(165399);
  }
  
  public final void a(e parame, View paramView, FinderObject paramFinderObject)
  {
    AppMethodBeat.i(165401);
    p.h(parame, "holder");
    p.h(paramView, "view");
    p.h(paramFinderObject, "finderObject");
    super.a(parame, paramView, paramFinderObject);
    parame = paramView.findViewById(2131303281);
    if (parame != null) {}
    for (parame = parame.getTag(); p.i(parame, Boolean.FALSE); parame = null)
    {
      AppMethodBeat.o(165401);
      return;
    }
    parame = paramView.findViewById(2131304146);
    if ((parame != null) && (parame.getVisibility() == 0))
    {
      AppMethodBeat.o(165401);
      return;
    }
    if (this.rWB.tap != paramFinderObject.id)
    {
      AppMethodBeat.o(165401);
      return;
    }
    parame = com.tencent.mm.plugin.finder.report.i.syT;
    com.tencent.mm.plugin.finder.report.i.g(paramFinderObject);
    AppMethodBeat.o(165401);
  }
  
  public final int getLayoutId()
  {
    return 2131492871;
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/finder/convert/FinderFeedMixConvert$onCreateViewHolder$1", "Lcom/tencent/mm/view/MediaBanner$IPageChangeCallback;", "onPageChange", "", "position", "", "isIdle", "", "plugin-finder_release"})
  public static final class b
    implements MediaBanner.c
  {
    b(e parame) {}
    
    public final void af(int paramInt, boolean paramBoolean)
    {
      AppMethodBeat.i(165398);
      q localq = (q)this.oTF.fUY();
      Object localObject1 = localq.feedObject.getMediaList().get(paramInt);
      p.g(localObject1, "feed.feedObject.mediaList[position]");
      localObject1 = (bvz)localObject1;
      Object localObject2 = FinderReporterUIC.tnG;
      localObject2 = this.oTF.getContext();
      p.g(localObject2, "holder.context");
      localObject2 = FinderReporterUIC.a.fc((Context)localObject2);
      if (localObject2 != null)
      {
        localObject2 = FinderReporterUIC.a((FinderReporterUIC)localObject2);
        if (localObject2 != null)
        {
          localObject2 = new w((c)localObject2).cGw();
          long l = localq.feedObject.getId();
          String str = localq.feedObject.getObjectNonceId();
          LinkedList localLinkedList = new LinkedList((Collection)localq.feedObject.getMediaList());
          p.g(localq, "feed");
          ((w.a)localObject2).a(l, (bvz)localObject1, str, paramInt, localLinkedList, (BaseFinderFeed)localq);
          AppMethodBeat.o(165398);
          return;
        }
      }
      AppMethodBeat.o(165398);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.n
 * JD-Core Version:    0.7.0.1
 */
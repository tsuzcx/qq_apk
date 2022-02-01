package com.tencent.mm.plugin.finder.convert;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.event.base.d;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.j;
import com.tencent.mm.plugin.finder.report.b;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.view.FinderMediaBanner;
import com.tencent.mm.plugin.finder.view.adapter.FinderMediaBannerAdapter;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.a;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.bmd;
import com.tencent.mm.view.MediaBanner.c;
import d.g.b.k;
import d.l;
import java.util.Collection;
import java.util.LinkedList;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/convert/FinderFeedMixConvert;", "Lcom/tencent/mm/plugin/finder/convert/FinderFeedConvert;", "Lcom/tencent/mm/plugin/finder/model/FinderFeedMix;", "videoCore", "Lcom/tencent/mm/plugin/finder/video/FinderVideoCore;", "contract", "Lcom/tencent/mm/plugin/finder/feed/FinderFeedContract;", "safeMode", "", "tabType", "", "(Lcom/tencent/mm/plugin/finder/video/FinderVideoCore;Lcom/tencent/mm/plugin/finder/feed/FinderFeedContract;ZI)V", "convertMedia", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "type", "getLayoutId", "onCreateViewHolder", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "onMediaClick", "view", "Landroid/view/View;", "finderObject", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "Companion", "plugin-finder_release"})
public class i
  extends e<j>
{
  public static final a qrr;
  private final com.tencent.mm.plugin.finder.feed.c qqD;
  private final com.tencent.mm.plugin.finder.video.c qrq;
  
  static
  {
    AppMethodBeat.i(165404);
    qrr = new a((byte)0);
    AppMethodBeat.o(165404);
  }
  
  private i(com.tencent.mm.plugin.finder.video.c paramc, com.tencent.mm.plugin.finder.feed.c paramc1, boolean paramBoolean, int paramInt)
  {
    super(paramc1, paramBoolean, paramInt);
    AppMethodBeat.i(165402);
    this.qrq = paramc;
    this.qqD = paramc1;
    AppMethodBeat.o(165402);
  }
  
  public final void a(RecyclerView paramRecyclerView, com.tencent.mm.view.recyclerview.e parame, int paramInt)
  {
    AppMethodBeat.i(165399);
    k.h(paramRecyclerView, "recyclerView");
    k.h(parame, "holder");
    super.a(paramRecyclerView, parame, paramInt);
    FinderMediaBanner localFinderMediaBanner = (FinderMediaBanner)parame.abq(2131302203);
    localFinderMediaBanner.setAdapter((RecyclerView.a)new FinderMediaBannerAdapter(this.qrq));
    localFinderMediaBanner.setViewPool(this.qqD.clM());
    localFinderMediaBanner.setParentRecyclerView(paramRecyclerView);
    localFinderMediaBanner.setPageChangeCallback((MediaBanner.c)new b(parame));
    AppMethodBeat.o(165399);
  }
  
  public final void a(com.tencent.mm.view.recyclerview.e parame, View paramView, FinderObject paramFinderObject)
  {
    AppMethodBeat.i(165401);
    k.h(parame, "holder");
    k.h(paramView, "view");
    k.h(paramFinderObject, "finderObject");
    super.a(parame, paramView, paramFinderObject);
    parame = paramView.findViewById(2131303281);
    if (parame != null) {}
    for (parame = parame.getTag(); k.g(parame, Boolean.FALSE); parame = null)
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
    if (this.qrq.qTL != paramFinderObject.id)
    {
      AppMethodBeat.o(165401);
      return;
    }
    parame = b.qFq;
    b.b(paramFinderObject);
    AppMethodBeat.o(165401);
  }
  
  public final int getLayoutId()
  {
    return 2131492871;
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/convert/FinderFeedMixConvert$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/finder/convert/FinderFeedMixConvert$onCreateViewHolder$1", "Lcom/tencent/mm/view/MediaBanner$IPageChangeCallback;", "onPageChange", "", "position", "", "isIdle", "", "plugin-finder_release"})
  public static final class b
    implements MediaBanner.c
  {
    b(com.tencent.mm.view.recyclerview.e parame) {}
    
    public final void ad(int paramInt, boolean paramBoolean)
    {
      AppMethodBeat.i(165398);
      j localj = (j)this.nGG.fjf();
      Object localObject1 = localj.feedObject.getMediaList().get(paramInt);
      k.g(localObject1, "feed.feedObject.mediaList[position]");
      localObject1 = (bmd)localObject1;
      Object localObject2 = FinderReporterUIC.Ljl;
      localObject2 = this.nGG.getContext();
      k.g(localObject2, "holder.context");
      localObject2 = FinderReporterUIC.a.lB((Context)localObject2);
      if (localObject2 != null)
      {
        localObject2 = FinderReporterUIC.a((FinderReporterUIC)localObject2);
        if (localObject2 != null)
        {
          localObject2 = new com.tencent.mm.plugin.finder.report.i((d)localObject2).coi();
          long l = localj.feedObject.getId();
          String str = localj.feedObject.getObjectNonceId();
          LinkedList localLinkedList = new LinkedList((Collection)localj.feedObject.getMediaList());
          k.g(localj, "feed");
          ((com.tencent.mm.plugin.finder.report.i.a)localObject2).a(l, (bmd)localObject1, str, paramInt, localLinkedList, (BaseFinderFeed)localj);
          AppMethodBeat.o(165398);
          return;
        }
      }
      AppMethodBeat.o(165398);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.i
 * JD-Core Version:    0.7.0.1
 */
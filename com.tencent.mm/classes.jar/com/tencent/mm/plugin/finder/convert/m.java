package com.tencent.mm.plugin.finder.convert;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.event.base.c;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.o;
import com.tencent.mm.plugin.finder.report.d;
import com.tencent.mm.plugin.finder.report.p;
import com.tencent.mm.plugin.finder.report.p.a;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.video.i;
import com.tencent.mm.plugin.finder.view.FinderMediaBanner;
import com.tencent.mm.plugin.finder.view.adapter.FinderMediaBannerAdapter;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.a;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.bqs;
import com.tencent.mm.view.MediaBanner.c;
import com.tencent.mm.view.recyclerview.e;
import d.g.b.k;
import d.l;
import java.util.Collection;
import java.util.LinkedList;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/convert/FinderFeedMixConvert;", "Lcom/tencent/mm/plugin/finder/convert/FinderFeedConvert;", "Lcom/tencent/mm/plugin/finder/model/FinderFeedMix;", "videoCore", "Lcom/tencent/mm/plugin/finder/video/FinderVideoCore;", "contract", "Lcom/tencent/mm/plugin/finder/feed/FinderFeedContract;", "safeMode", "", "tabType", "", "(Lcom/tencent/mm/plugin/finder/video/FinderVideoCore;Lcom/tencent/mm/plugin/finder/feed/FinderFeedContract;ZI)V", "convertMedia", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "type", "getLayoutId", "onCreateViewHolder", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "onMediaClick", "view", "Landroid/view/View;", "finderObject", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "Companion", "plugin-finder_release"})
public class m
  extends g<o>
{
  public static final m.a rbp;
  private final com.tencent.mm.plugin.finder.feed.g ram;
  private final i rbo;
  
  static
  {
    AppMethodBeat.i(165404);
    rbp = new m.a((byte)0);
    AppMethodBeat.o(165404);
  }
  
  private m(i parami, com.tencent.mm.plugin.finder.feed.g paramg, boolean paramBoolean, int paramInt)
  {
    super(paramg, paramBoolean, paramInt);
    AppMethodBeat.i(165402);
    this.rbo = parami;
    this.ram = paramg;
    AppMethodBeat.o(165402);
  }
  
  public final void a(RecyclerView paramRecyclerView, e parame, int paramInt)
  {
    AppMethodBeat.i(165399);
    k.h(paramRecyclerView, "recyclerView");
    k.h(parame, "holder");
    super.a(paramRecyclerView, parame, paramInt);
    FinderMediaBanner localFinderMediaBanner = (FinderMediaBanner)parame.adJ(2131302203);
    localFinderMediaBanner.setAdapter((RecyclerView.a)new FinderMediaBannerAdapter(this.rbo));
    localFinderMediaBanner.setViewPool(this.ram.cuu());
    localFinderMediaBanner.setParentRecyclerView(paramRecyclerView);
    localFinderMediaBanner.setPageChangeCallback((MediaBanner.c)new b(parame));
    AppMethodBeat.o(165399);
  }
  
  public final void a(e parame, View paramView, FinderObject paramFinderObject)
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
    if (this.rbo.rSu != paramFinderObject.id)
    {
      AppMethodBeat.o(165401);
      return;
    }
    parame = d.rxr;
    d.f(paramFinderObject);
    AppMethodBeat.o(165401);
  }
  
  public final int getLayoutId()
  {
    return 2131492871;
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/finder/convert/FinderFeedMixConvert$onCreateViewHolder$1", "Lcom/tencent/mm/view/MediaBanner$IPageChangeCallback;", "onPageChange", "", "position", "", "isIdle", "", "plugin-finder_release"})
  public static final class b
    implements MediaBanner.c
  {
    b(e parame) {}
    
    public final void ad(int paramInt, boolean paramBoolean)
    {
      AppMethodBeat.i(165398);
      o localo = (o)this.ojH.fzs();
      Object localObject1 = localo.feedObject.getMediaList().get(paramInt);
      k.g(localObject1, "feed.feedObject.mediaList[position]");
      localObject1 = (bqs)localObject1;
      Object localObject2 = FinderReporterUIC.seQ;
      localObject2 = this.ojH.getContext();
      k.g(localObject2, "holder.context");
      localObject2 = FinderReporterUIC.a.eV((Context)localObject2);
      if (localObject2 != null)
      {
        localObject2 = FinderReporterUIC.a((FinderReporterUIC)localObject2);
        if (localObject2 != null)
        {
          localObject2 = new p((c)localObject2).cxE();
          long l = localo.feedObject.getId();
          String str = localo.feedObject.getObjectNonceId();
          LinkedList localLinkedList = new LinkedList((Collection)localo.feedObject.getMediaList());
          k.g(localo, "feed");
          ((p.a)localObject2).a(l, (bqs)localObject1, str, paramInt, localLinkedList, (BaseFinderFeed)localo);
          AppMethodBeat.o(165398);
          return;
        }
      }
      AppMethodBeat.o(165398);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.m
 * JD-Core Version:    0.7.0.1
 */
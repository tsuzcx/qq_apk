package com.tencent.mm.plugin.finder.convert;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.event.base.c;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.report.v;
import com.tencent.mm.plugin.finder.report.v.a;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.video.i;
import com.tencent.mm.plugin.finder.view.FinderMediaBanner;
import com.tencent.mm.plugin.finder.view.adapter.FinderMediaBannerAdapter;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.a;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.bvf;
import com.tencent.mm.view.MediaBanner.c;
import com.tencent.mm.view.recyclerview.e;
import d.l;
import java.util.Collection;
import java.util.LinkedList;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/convert/FinderFeedMixConvert;", "Lcom/tencent/mm/plugin/finder/convert/FinderFeedConvert;", "Lcom/tencent/mm/plugin/finder/model/FinderFeedMix;", "videoCore", "Lcom/tencent/mm/plugin/finder/video/FinderVideoCore;", "contract", "Lcom/tencent/mm/plugin/finder/feed/FinderFeedContract;", "safeMode", "", "tabType", "", "(Lcom/tencent/mm/plugin/finder/video/FinderVideoCore;Lcom/tencent/mm/plugin/finder/feed/FinderFeedContract;ZI)V", "convertMedia", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "type", "getLayoutId", "onCreateViewHolder", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "onMediaClick", "view", "Landroid/view/View;", "finderObject", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "Companion", "plugin-finder_release"})
public class n
  extends h<com.tencent.mm.plugin.finder.model.p>
{
  public static final a rOf;
  private final com.tencent.mm.plugin.finder.feed.h rMI;
  private final i rOe;
  
  static
  {
    AppMethodBeat.i(165404);
    rOf = new a((byte)0);
    AppMethodBeat.o(165404);
  }
  
  private n(i parami, com.tencent.mm.plugin.finder.feed.h paramh, boolean paramBoolean, int paramInt)
  {
    super(paramh, paramBoolean, paramInt);
    AppMethodBeat.i(165402);
    this.rOe = parami;
    this.rMI = paramh;
    AppMethodBeat.o(165402);
  }
  
  public final void a(RecyclerView paramRecyclerView, e parame, int paramInt)
  {
    AppMethodBeat.i(165399);
    d.g.b.p.h(paramRecyclerView, "recyclerView");
    d.g.b.p.h(parame, "holder");
    super.a(paramRecyclerView, parame, paramInt);
    FinderMediaBanner localFinderMediaBanner = (FinderMediaBanner)parame.Gd(2131302203);
    localFinderMediaBanner.setAdapter((RecyclerView.a)new FinderMediaBannerAdapter(this.rOe));
    localFinderMediaBanner.setViewPool(this.rMI.cAF());
    localFinderMediaBanner.setParentRecyclerView(paramRecyclerView);
    localFinderMediaBanner.setPageChangeCallback((MediaBanner.c)new b(parame));
    AppMethodBeat.o(165399);
  }
  
  public final void a(e parame, View paramView, FinderObject paramFinderObject)
  {
    AppMethodBeat.i(165401);
    d.g.b.p.h(parame, "holder");
    d.g.b.p.h(paramView, "view");
    d.g.b.p.h(paramFinderObject, "finderObject");
    super.a(parame, paramView, paramFinderObject);
    parame = paramView.findViewById(2131303281);
    if (parame != null) {}
    for (parame = parame.getTag(); d.g.b.p.i(parame, Boolean.FALSE); parame = null)
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
    if (this.rOe.sPc != paramFinderObject.id)
    {
      AppMethodBeat.o(165401);
      return;
    }
    parame = com.tencent.mm.plugin.finder.report.h.soM;
    com.tencent.mm.plugin.finder.report.h.g(paramFinderObject);
    AppMethodBeat.o(165401);
  }
  
  public final int getLayoutId()
  {
    return 2131492871;
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/convert/FinderFeedMixConvert$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/finder/convert/FinderFeedMixConvert$onCreateViewHolder$1", "Lcom/tencent/mm/view/MediaBanner$IPageChangeCallback;", "onPageChange", "", "position", "", "isIdle", "", "plugin-finder_release"})
  public static final class b
    implements MediaBanner.c
  {
    b(e parame) {}
    
    public final void ad(int paramInt, boolean paramBoolean)
    {
      AppMethodBeat.i(165398);
      com.tencent.mm.plugin.finder.model.p localp = (com.tencent.mm.plugin.finder.model.p)this.oNd.fQC();
      Object localObject1 = localp.feedObject.getMediaList().get(paramInt);
      d.g.b.p.g(localObject1, "feed.feedObject.mediaList[position]");
      localObject1 = (bvf)localObject1;
      Object localObject2 = FinderReporterUIC.tcM;
      localObject2 = this.oNd.getContext();
      d.g.b.p.g(localObject2, "holder.context");
      localObject2 = FinderReporterUIC.a.eY((Context)localObject2);
      if (localObject2 != null)
      {
        localObject2 = FinderReporterUIC.a((FinderReporterUIC)localObject2);
        if (localObject2 != null)
        {
          localObject2 = new v((c)localObject2).cEA();
          long l = localp.feedObject.getId();
          String str = localp.feedObject.getObjectNonceId();
          LinkedList localLinkedList = new LinkedList((Collection)localp.feedObject.getMediaList());
          d.g.b.p.g(localp, "feed");
          ((v.a)localObject2).a(l, (bvf)localObject1, str, paramInt, localLinkedList, (BaseFinderFeed)localp);
          AppMethodBeat.o(165398);
          return;
        }
      }
      AppMethodBeat.o(165398);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.n
 * JD-Core Version:    0.7.0.1
 */
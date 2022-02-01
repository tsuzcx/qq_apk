package com.tencent.mm.plugin.finder.convert;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.event.base.c;
import com.tencent.mm.plugin.finder.feed.i;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.report.ag;
import com.tencent.mm.plugin.finder.report.ag.a;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.view.FinderMediaBanner;
import com.tencent.mm.plugin.finder.view.adapter.FinderMediaBannerAdapter;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.a;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.cjl;
import com.tencent.mm.view.MediaBanner.c;
import com.tencent.mm.view.recyclerview.h;
import java.util.Collection;
import java.util.LinkedList;
import kotlin.g.b.p;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/convert/FinderFeedMixConvert;", "Lcom/tencent/mm/plugin/finder/convert/FinderFeedConvert;", "Lcom/tencent/mm/plugin/finder/model/FinderFeedMix;", "videoCore", "Lcom/tencent/mm/plugin/finder/video/FinderVideoCore;", "contract", "Lcom/tencent/mm/plugin/finder/feed/FinderFeedContract;", "safeMode", "", "tabType", "", "(Lcom/tencent/mm/plugin/finder/video/FinderVideoCore;Lcom/tencent/mm/plugin/finder/feed/FinderFeedContract;ZI)V", "convertMedia", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "type", "getLayoutId", "onCreateViewHolder", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "onMediaClick", "view", "Landroid/view/View;", "finderObject", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "Companion", "plugin-finder_release"})
public class aa
  extends l<com.tencent.mm.plugin.finder.model.aa>
{
  public static final a tDy;
  private final i tAi;
  private final com.tencent.mm.plugin.finder.video.k tCD;
  
  static
  {
    AppMethodBeat.i(165404);
    tDy = new a((byte)0);
    AppMethodBeat.o(165404);
  }
  
  private aa(com.tencent.mm.plugin.finder.video.k paramk, i parami, boolean paramBoolean, int paramInt)
  {
    super(parami, paramBoolean, paramInt);
    AppMethodBeat.i(165402);
    this.tCD = paramk;
    this.tAi = parami;
    AppMethodBeat.o(165402);
  }
  
  public final void a(RecyclerView paramRecyclerView, h paramh, int paramInt)
  {
    AppMethodBeat.i(165399);
    p.h(paramRecyclerView, "recyclerView");
    p.h(paramh, "holder");
    super.a(paramRecyclerView, paramh, paramInt);
    FinderMediaBanner localFinderMediaBanner = (FinderMediaBanner)paramh.Mn(2131304549);
    localFinderMediaBanner.setAdapter((RecyclerView.a)new FinderMediaBannerAdapter(this.tCD));
    localFinderMediaBanner.setViewPool(this.tAi.dcf());
    localFinderMediaBanner.setParentRecyclerView(paramRecyclerView);
    localFinderMediaBanner.setPageChangeCallback((MediaBanner.c)new b(paramh));
    AppMethodBeat.o(165399);
  }
  
  public final void a(h paramh, View paramView, FinderObject paramFinderObject)
  {
    AppMethodBeat.i(165401);
    p.h(paramh, "holder");
    p.h(paramView, "view");
    p.h(paramFinderObject, "finderObject");
    super.a(paramh, paramView, paramFinderObject);
    paramh = paramView.findViewById(2131305954);
    if (paramh != null) {}
    for (paramh = paramh.getTag(); p.j(paramh, Boolean.FALSE); paramh = null)
    {
      AppMethodBeat.o(165401);
      return;
    }
    paramh = paramView.findViewById(2131307042);
    if ((paramh != null) && (paramh.getVisibility() == 0))
    {
      AppMethodBeat.o(165401);
      return;
    }
    if (this.tCD.weV != paramFinderObject.id)
    {
      AppMethodBeat.o(165401);
      return;
    }
    paramh = com.tencent.mm.plugin.finder.report.k.vfA;
    com.tencent.mm.plugin.finder.report.k.h(paramFinderObject);
    AppMethodBeat.o(165401);
  }
  
  public final int getLayoutId()
  {
    return 2131492886;
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/convert/FinderFeedMixConvert$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/convert/FinderFeedMixConvert$onCreateViewHolder$1", "Lcom/tencent/mm/view/MediaBanner$IPageChangeCallback;", "onPageChange", "", "position", "", "isIdle", "", "isAuto", "plugin-finder_release"})
  public static final class b
    implements MediaBanner.c
  {
    b(h paramh) {}
    
    public final void e(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
    {
      AppMethodBeat.i(243074);
      com.tencent.mm.plugin.finder.model.aa localaa = (com.tencent.mm.plugin.finder.model.aa)this.qhp.hgv();
      Object localObject1 = localaa.feedObject.getMediaList().get(paramInt);
      p.g(localObject1, "feed.feedObject.mediaList[position]");
      localObject1 = (cjl)localObject1;
      Object localObject2 = FinderReporterUIC.wzC;
      localObject2 = this.qhp.getContext();
      p.g(localObject2, "holder.context");
      localObject2 = FinderReporterUIC.a.fH((Context)localObject2);
      if (localObject2 != null)
      {
        localObject2 = FinderReporterUIC.a((FinderReporterUIC)localObject2);
        if (localObject2 != null)
        {
          localObject2 = new ag((c)localObject2).doV();
          long l = localaa.feedObject.getId();
          String str = localaa.feedObject.getObjectNonceId();
          LinkedList localLinkedList = new LinkedList((Collection)localaa.feedObject.getMediaList());
          p.g(localaa, "feed");
          ((ag.a)localObject2).a(l, (cjl)localObject1, str, paramInt, localLinkedList, (BaseFinderFeed)localaa, paramBoolean2);
          AppMethodBeat.o(243074);
          return;
        }
      }
      AppMethodBeat.o(243074);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.aa
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.finder.convert;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.c;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.report.i.a;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.view.FinderMediaBanner;
import com.tencent.mm.plugin.finder.view.adapter.FinderMediaBannerAdapter;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.a;
import com.tencent.mm.protocal.protobuf.bmd;
import com.tencent.mm.view.MediaBanner.c;
import com.tencent.mm.view.MediaBannerIndicator;
import d.g.b.k;
import d.l;
import java.util.Collection;
import java.util.LinkedList;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/convert/FinderFeedImageConvert;", "Lcom/tencent/mm/plugin/finder/convert/FinderFeedConvert;", "Lcom/tencent/mm/plugin/finder/model/FinderFeedImage;", "contract", "Lcom/tencent/mm/plugin/finder/feed/FinderFeedContract;", "safeMode", "", "tabType", "", "(Lcom/tencent/mm/plugin/finder/feed/FinderFeedContract;ZI)V", "convertMedia", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "type", "getLayoutId", "onCreateViewHolder", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "plugin-finder_release"})
public class g
  extends e<com.tencent.mm.plugin.finder.model.i>
{
  private final c qqD;
  
  public g(c paramc, boolean paramBoolean, int paramInt)
  {
    super(paramc, paramBoolean, paramInt);
    AppMethodBeat.i(165394);
    this.qqD = paramc;
    AppMethodBeat.o(165394);
  }
  
  public final void a(RecyclerView paramRecyclerView, com.tencent.mm.view.recyclerview.e parame, int paramInt)
  {
    AppMethodBeat.i(165392);
    k.h(paramRecyclerView, "recyclerView");
    k.h(parame, "holder");
    super.a(paramRecyclerView, parame, paramInt);
    FinderMediaBanner localFinderMediaBanner = (FinderMediaBanner)parame.abq(2131302203);
    localFinderMediaBanner.setAdapter((RecyclerView.a)new FinderMediaBannerAdapter());
    localFinderMediaBanner.setViewPool(this.qqD.clM());
    localFinderMediaBanner.setParentRecyclerView(paramRecyclerView);
    localFinderMediaBanner.getIndicator().setShowOnlyOneIndicator(true);
    localFinderMediaBanner.setPageChangeCallback((MediaBanner.c)new b(parame));
    AppMethodBeat.o(165392);
  }
  
  public final int getLayoutId()
  {
    return 2131492870;
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/finder/convert/FinderFeedImageConvert$onCreateViewHolder$1", "Lcom/tencent/mm/view/MediaBanner$IPageChangeCallback;", "onPageChange", "", "position", "", "isIdle", "", "plugin-finder_release"})
  public static final class b
    implements MediaBanner.c
  {
    b(com.tencent.mm.view.recyclerview.e parame) {}
    
    public final void ad(int paramInt, boolean paramBoolean)
    {
      AppMethodBeat.i(165391);
      com.tencent.mm.plugin.finder.model.i locali = (com.tencent.mm.plugin.finder.model.i)this.nGG.fjf();
      Object localObject1 = locali.feedObject.getMediaList().get(paramInt);
      k.g(localObject1, "feed.feedObject.mediaList[position]");
      localObject1 = (bmd)localObject1;
      Object localObject2 = FinderReporterUIC.Ljl;
      localObject2 = this.nGG.getContext();
      k.g(localObject2, "holder.context");
      localObject2 = FinderReporterUIC.a.lB((Context)localObject2);
      if (localObject2 != null)
      {
        localObject2 = new com.tencent.mm.plugin.finder.report.i(FinderReporterUIC.a((FinderReporterUIC)localObject2)).coi();
        long l = locali.feedObject.getId();
        String str = locali.feedObject.getObjectNonceId();
        LinkedList localLinkedList = new LinkedList((Collection)locali.feedObject.getMediaList());
        k.g(locali, "feed");
        ((i.a)localObject2).a(l, (bmd)localObject1, str, paramInt, localLinkedList, (BaseFinderFeed)locali);
        AppMethodBeat.o(165391);
        return;
      }
      AppMethodBeat.o(165391);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.g
 * JD-Core Version:    0.7.0.1
 */
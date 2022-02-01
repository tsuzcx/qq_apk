package com.tencent.mm.plugin.finder.convert;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.view.View;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.m;
import com.tencent.mm.plugin.finder.report.p;
import com.tencent.mm.plugin.finder.report.p.a;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.upload.action.g.a;
import com.tencent.mm.plugin.finder.view.FinderMediaBanner;
import com.tencent.mm.plugin.finder.view.adapter.FinderMediaBannerAdapter;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.a;
import com.tencent.mm.protocal.protobuf.bqs;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.view.MediaBanner.c;
import com.tencent.mm.view.MediaBannerIndicator;
import com.tencent.mm.view.recyclerview.e;
import d.g.b.k;
import d.l;
import java.util.Collection;
import java.util.LinkedList;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/convert/FinderFeedImageConvert;", "Lcom/tencent/mm/plugin/finder/convert/FinderFeedConvert;", "Lcom/tencent/mm/plugin/finder/model/FinderFeedImage;", "contract", "Lcom/tencent/mm/plugin/finder/feed/FinderFeedContract;", "safeMode", "", "tabType", "", "(Lcom/tencent/mm/plugin/finder/feed/FinderFeedContract;ZI)V", "convertMedia", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "type", "getLayoutId", "onCreateViewHolder", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "onMediaDoubleClick", "view", "Landroid/view/View;", "plugin-finder_release"})
public class j
  extends g<m>
{
  private final com.tencent.mm.plugin.finder.feed.g ram;
  
  public j(com.tencent.mm.plugin.finder.feed.g paramg, boolean paramBoolean, int paramInt)
  {
    super(paramg, paramBoolean, paramInt);
    AppMethodBeat.i(165394);
    this.ram = paramg;
    AppMethodBeat.o(165394);
  }
  
  public final void a(RecyclerView paramRecyclerView, e parame, int paramInt)
  {
    AppMethodBeat.i(165392);
    k.h(paramRecyclerView, "recyclerView");
    k.h(parame, "holder");
    super.a(paramRecyclerView, parame, paramInt);
    FinderMediaBanner localFinderMediaBanner = (FinderMediaBanner)parame.adJ(2131302203);
    localFinderMediaBanner.setAdapter((RecyclerView.a)new FinderMediaBannerAdapter());
    localFinderMediaBanner.setViewPool(this.ram.cuu());
    localFinderMediaBanner.setParentRecyclerView(paramRecyclerView);
    localFinderMediaBanner.getIndicator().setShowOnlyOneIndicator(true);
    localFinderMediaBanner.setPageChangeCallback((MediaBanner.c)new a(parame));
    AppMethodBeat.o(165392);
  }
  
  public final void a(e parame, View paramView)
  {
    AppMethodBeat.i(210183);
    k.h(parame, "holder");
    k.h(paramView, "view");
    parame = (BaseFinderFeed)parame.fzs();
    if (!parame.feedObject.isPostFinish())
    {
      AppMethodBeat.o(210183);
      return;
    }
    g.a locala = com.tencent.mm.plugin.finder.upload.action.g.rOb;
    if (!com.tencent.mm.plugin.finder.upload.action.g.cCH().j(parame.feedObject.getFeedObject())) {
      t.makeText(paramView.getContext(), (CharSequence)paramView.getContext().getString(2131766513), 0).show();
    }
    AppMethodBeat.o(210183);
  }
  
  public final int getLayoutId()
  {
    return 2131492870;
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/finder/convert/FinderFeedImageConvert$onCreateViewHolder$1", "Lcom/tencent/mm/view/MediaBanner$IPageChangeCallback;", "onPageChange", "", "position", "", "isIdle", "", "plugin-finder_release"})
  public static final class a
    implements MediaBanner.c
  {
    a(e parame) {}
    
    public final void ad(int paramInt, boolean paramBoolean)
    {
      AppMethodBeat.i(165391);
      m localm = (m)this.ojH.fzs();
      Object localObject1 = localm.feedObject.getMediaList().get(paramInt);
      k.g(localObject1, "feed.feedObject.mediaList[position]");
      localObject1 = (bqs)localObject1;
      Object localObject2 = FinderReporterUIC.seQ;
      localObject2 = this.ojH.getContext();
      k.g(localObject2, "holder.context");
      localObject2 = FinderReporterUIC.a.eV((Context)localObject2);
      if (localObject2 != null)
      {
        localObject2 = new p(FinderReporterUIC.a((FinderReporterUIC)localObject2)).cxE();
        long l = localm.feedObject.getId();
        String str = localm.feedObject.getObjectNonceId();
        LinkedList localLinkedList = new LinkedList((Collection)localm.feedObject.getMediaList());
        k.g(localm, "feed");
        ((p.a)localObject2).a(l, (bqs)localObject1, str, paramInt, localLinkedList, (BaseFinderFeed)localm);
        AppMethodBeat.o(165391);
        return;
      }
      AppMethodBeat.o(165391);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.j
 * JD-Core Version:    0.7.0.1
 */
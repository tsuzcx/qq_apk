package com.tencent.mm.plugin.finder.convert;

import android.content.Context;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.b.g;
import com.tencent.mm.plugin.finder.event.base.c;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.aa;
import com.tencent.mm.plugin.finder.report.n;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.view.FinderMediaBanner;
import com.tencent.mm.plugin.finder.view.adapter.FinderMediaBannerAdapter;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.csg;
import com.tencent.mm.view.MediaBanner.c;
import java.util.Collection;
import java.util.LinkedList;
import kotlin.g.b.p;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/convert/FinderFeedMixConvert;", "Lcom/tencent/mm/plugin/finder/convert/FinderFeedConvert;", "Lcom/tencent/mm/plugin/finder/model/FinderFeedMix;", "videoCore", "Lcom/tencent/mm/plugin/finder/video/FinderVideoCore;", "contract", "Lcom/tencent/mm/plugin/finder/feed/FinderFeedContract;", "safeMode", "", "tabType", "", "(Lcom/tencent/mm/plugin/finder/video/FinderVideoCore;Lcom/tencent/mm/plugin/finder/feed/FinderFeedContract;ZI)V", "convertMedia", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "type", "getLayoutId", "onCreateViewHolder", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "onMediaClick", "view", "Landroid/view/View;", "finderObject", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "Companion", "plugin-finder_release"})
public final class ab
  extends m<aa>
{
  public static final a xlZ;
  private final com.tencent.mm.plugin.finder.feed.i xhU;
  private final com.tencent.mm.plugin.finder.video.l xkW;
  
  static
  {
    AppMethodBeat.i(165404);
    xlZ = new a((byte)0);
    AppMethodBeat.o(165404);
  }
  
  private ab(com.tencent.mm.plugin.finder.video.l paraml, com.tencent.mm.plugin.finder.feed.i parami, boolean paramBoolean, int paramInt)
  {
    super(parami, paramBoolean, paramInt);
    AppMethodBeat.i(165402);
    this.xkW = paraml;
    this.xhU = parami;
    AppMethodBeat.o(165402);
  }
  
  public final void a(RecyclerView paramRecyclerView, com.tencent.mm.view.recyclerview.i parami, int paramInt)
  {
    AppMethodBeat.i(286141);
    p.k(paramRecyclerView, "recyclerView");
    p.k(parami, "holder");
    super.a(paramRecyclerView, parami, paramInt);
    FinderMediaBanner localFinderMediaBanner = (FinderMediaBanner)parami.RD(b.f.media_banner);
    localFinderMediaBanner.setAdapter((RecyclerView.a)new FinderMediaBannerAdapter(this.xkW));
    localFinderMediaBanner.setViewPool(this.xhU.dsv());
    localFinderMediaBanner.setParentRecyclerView(paramRecyclerView);
    localFinderMediaBanner.setPageChangeCallback((MediaBanner.c)new b(parami));
    AppMethodBeat.o(286141);
  }
  
  public final void a(com.tencent.mm.view.recyclerview.i parami, View paramView, FinderObject paramFinderObject)
  {
    AppMethodBeat.i(165401);
    p.k(parami, "holder");
    p.k(paramView, "view");
    p.k(paramFinderObject, "finderObject");
    super.a(parami, paramView, paramFinderObject);
    parami = paramView.findViewById(b.f.play_btn);
    if (parami != null) {}
    for (parami = parami.getTag(); p.h(parami, Boolean.FALSE); parami = null)
    {
      AppMethodBeat.o(165401);
      return;
    }
    parami = paramView.findViewById(b.f.retry_btn);
    if ((parami != null) && (parami.getVisibility() == 0))
    {
      AppMethodBeat.o(165401);
      return;
    }
    if (this.xkW.ANE != paramFinderObject.id)
    {
      AppMethodBeat.o(165401);
      return;
    }
    parami = n.zWF;
    n.m(paramFinderObject);
    AppMethodBeat.o(165401);
  }
  
  public final int getLayoutId()
  {
    return b.g._finder_feed_mix_item;
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/convert/FinderFeedMixConvert$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/convert/FinderFeedMixConvert$onCreateViewHolder$1", "Lcom/tencent/mm/view/MediaBanner$IPageChangeCallback;", "onPageChange", "", "position", "", "isIdle", "", "isAuto", "plugin-finder_release"})
  public static final class b
    implements MediaBanner.c
  {
    b(com.tencent.mm.view.recyclerview.i parami) {}
    
    public final void g(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
    {
      AppMethodBeat.i(282379);
      aa localaa = (aa)this.tDl.ihX();
      Object localObject1 = localaa.feedObject.getMediaList().get(paramInt);
      p.j(localObject1, "feed.feedObject.mediaList[position]");
      localObject1 = (csg)localObject1;
      Object localObject2 = com.tencent.mm.plugin.finder.viewmodel.component.aj.Bnu;
      localObject2 = this.tDl.getContext();
      p.j(localObject2, "holder.context");
      localObject2 = com.tencent.mm.plugin.finder.viewmodel.component.aj.a.fZ((Context)localObject2);
      if (localObject2 != null)
      {
        localObject2 = com.tencent.mm.plugin.finder.viewmodel.component.aj.a((com.tencent.mm.plugin.finder.viewmodel.component.aj)localObject2);
        if (localObject2 != null)
        {
          localObject2 = new com.tencent.mm.plugin.finder.report.aj((c)localObject2).dQy();
          long l = localaa.feedObject.getId();
          String str = localaa.feedObject.getObjectNonceId();
          LinkedList localLinkedList = new LinkedList((Collection)localaa.feedObject.getMediaList());
          p.j(localaa, "feed");
          ((com.tencent.mm.plugin.finder.report.aj.a)localObject2).a(l, (csg)localObject1, str, paramInt, localLinkedList, (BaseFinderFeed)localaa, paramBoolean2);
          AppMethodBeat.o(282379);
          return;
        }
      }
      AppMethodBeat.o(282379);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.ab
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.finder.cgi.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.co.f;
import com.tencent.mm.plugin.finder.cgi.g;
import com.tencent.mm.plugin.finder.cgi.g.a;
import com.tencent.mm.plugin.finder.cgi.g.c;
import com.tencent.mm.plugin.finder.feed.model.aa;
import com.tencent.mm.plugin.finder.feed.model.internal.d;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.dzp;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.h;
import d.g.a.s;
import d.g.b.k;
import d.l;
import java.util.List;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/cgi/fetcher/FinderTimelineFeedFetcher;", "Lcom/tencent/mm/plugin/finder/life/SupportLifecycle;", "tabType", "", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(ILcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "isGetHistory", "", "isHistoryFirstPage", "()Z", "setHistoryFirstPage", "(Z)V", "isShowHistoryTip", "setShowHistoryTip", "lifeCycleKeeper", "Lcom/tencent/mm/vending/lifecycle/LifeCycleKeeper;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycle;", "getLifeCycleKeeper", "()Lcom/tencent/mm/vending/lifecycle/LifeCycleKeeper;", "setLifeCycleKeeper", "(Lcom/tencent/mm/vending/lifecycle/LifeCycleKeeper;)V", "moreTopicCache", "Lcom/tencent/mm/plugin/finder/feed/model/FinderTimeLineMoreTopicCache;", "getMoreTopicCache", "()Lcom/tencent/mm/plugin/finder/feed/model/FinderTimeLineMoreTopicCache;", "setMoreTopicCache", "(Lcom/tencent/mm/plugin/finder/feed/model/FinderTimeLineMoreTopicCache;)V", "pageDataBuffer", "Lcom/tencent/mm/plugin/finder/feed/model/internal/PageDataBuffer;", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "Lcom/tencent/mm/plugin/finder/feed/model/FetchFinderTimelineInfo;", "getPageDataBuffer", "()Lcom/tencent/mm/plugin/finder/feed/model/internal/PageDataBuffer;", "getTabType", "()I", "check", "", "isNeedClear", "incrementSize", "retFlag", "pullType", "fetch", "callback", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderTimelineStream$Callback;", "consume", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderTimelineStream$ConsumeCallback;", "lastBuff", "Lcom/tencent/mm/protobuf/ByteString;", "isPreloadMore", "fetchHotRelatedList", "feedId", "", "nonceId", "", "isPrefetch", "getHistory", "isFirstHistoryPage", "extraList", "", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "innerFetch", "showErrorToast", "tip", "uniqueId", "Companion", "plugin-finder_release"})
public final class b
  extends com.tencent.mm.plugin.finder.life.a
{
  public static final a KKo;
  public final int IoU;
  public com.tencent.mm.vending.e.c<com.tencent.mm.vending.e.a> KJT;
  private volatile boolean KJU;
  boolean KJV;
  boolean KJW;
  aa KKm;
  public final d<BaseFinderFeed, com.tencent.mm.plugin.finder.feed.model.c> KKn;
  public final dzp contextObj;
  
  static
  {
    AppMethodBeat.i(197369);
    KKo = new a((byte)0);
    AppMethodBeat.o(197369);
  }
  
  public b(int paramInt, dzp paramdzp)
  {
    AppMethodBeat.i(197368);
    this.IoU = paramInt;
    this.contextObj = paramdzp;
    this.KJT = new com.tencent.mm.vending.e.c();
    this.KJV = true;
    this.KJW = true;
    this.KKn = new d(null, String.valueOf(this.IoU), 1);
    AppMethodBeat.o(197368);
  }
  
  private final void a(g.a parama, boolean paramBoolean1, int paramInt, List<? extends FinderObject> paramList, boolean paramBoolean2, boolean paramBoolean3)
  {
    AppMethodBeat.i(197365);
    new com.tencent.mm.plugin.finder.cgi.c(paramInt, this.IoU, (s)new b.g(this, paramList, paramBoolean1, paramInt, paramBoolean3, paramBoolean2, parama), this.contextObj).auK().a((com.tencent.mm.vending.e.b)this.KJT);
    AppMethodBeat.o(197365);
  }
  
  private static void aVf(String paramString)
  {
    AppMethodBeat.i(197367);
    ad.e("Finder.TimelineFeedFetcher", paramString);
    if ((h.IS_FLAVOR_PURPLE) || (h.DEBUG)) {
      com.tencent.mm.ad.c.g((d.g.a.a)new b.i(paramString));
    }
    AppMethodBeat.o(197367);
  }
  
  public final void a(g.a parama, int paramInt, g.c paramc, com.tencent.mm.bx.b paramb)
  {
    boolean bool = true;
    AppMethodBeat.i(197364);
    k.h(parama, "callback");
    if ((paramInt == 0) || (paramInt == 1)) {
      this.KJU = false;
    }
    if (!this.KJU)
    {
      parama = (g.a)new b.h(this, parama);
      int i = this.IoU;
      if (paramb == null) {}
      for (;;)
      {
        new g(parama, paramInt, i, paramc, paramb, bool, this.contextObj).auK().a((com.tencent.mm.vending.e.b)this.KJT);
        AppMethodBeat.o(197364);
        return;
        bool = false;
      }
    }
    a(this, parama, this.KJV, paramInt, null, false, this.KJW);
    this.KJV = false;
    AppMethodBeat.o(197364);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/cgi/fetcher/FinderTimelineFeedFetcher$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.a.b
 * JD-Core Version:    0.7.0.1
 */
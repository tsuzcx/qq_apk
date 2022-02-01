package com.tencent.mm.plugin.finder.feed.model;

import android.arch.lifecycle.ViewModelProvider;
import android.content.Context;
import android.content.res.Resources;
import android.os.SystemClock;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.LongSparseArray;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.cgi.n.a;
import com.tencent.mm.plugin.finder.cgi.n.c;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader.a;
import com.tencent.mm.plugin.finder.feed.model.internal.DataBuffer;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.feed.model.internal.f;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.al;
import com.tencent.mm.plugin.finder.report.e.a;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.data.k;
import com.tencent.mm.plugin.finder.storage.data.k.a;
import com.tencent.mm.plugin.finder.utils.p.a;
import com.tencent.mm.plugin.finder.viewmodel.FinderHomeTabStateVM;
import com.tencent.mm.plugin.finder.viewmodel.FinderHomeTabStateVM.a;
import com.tencent.mm.plugin.finder.viewmodel.FinderTabStreamUnreadVM;
import com.tencent.mm.plugin.finder.viewmodel.FinderTabStreamUnreadVM.c;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.aoi;
import com.tencent.mm.protocal.protobuf.aqy;
import com.tencent.mm.protocal.protobuf.cvp;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.view.RefreshLoadMoreLayout.c;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.d;
import d.g.b.q;
import d.v;
import d.z;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedDeque;

@d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/feed/model/FinderTimelineFeedLoader;", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "scene", "Lcom/tencent/mm/plugin/finder/feed/model/internal/FinderLoaderScene;", "firstLoad", "", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Lcom/tencent/mm/plugin/finder/feed/model/internal/FinderLoaderScene;ILcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "extraDataOp", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "", "getExtraDataOp", "()Lkotlin/jvm/functions/Function1;", "setExtraDataOp", "(Lkotlin/jvm/functions/Function1;)V", "getFirstLoad", "()I", "setFirstLoad", "(I)V", "postFeedFlag", "", "getPostFeedFlag", "()Z", "setPostFeedFlag", "(Z)V", "value", "Landroid/support/v7/widget/RecyclerView;", "recyclerView", "getRecyclerView", "()Landroid/support/v7/widget/RecyclerView;", "setRecyclerView", "(Landroid/support/v7/widget/RecyclerView;)V", "getScene", "()Lcom/tencent/mm/plugin/finder/feed/model/internal/FinderLoaderScene;", "streamFetcher", "Lcom/tencent/mm/plugin/finder/cgi/fetcher/FinderTimelineFeedFetcher;", "getStreamFetcher", "()Lcom/tencent/mm/plugin/finder/cgi/fetcher/FinderTimelineFeedFetcher;", "bufferSize", "createDataFetch", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataFetch;", "createDataMerger", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataMerger;", "isObservePostEvent", "onDead", "onFetchDone", "response", "onFetchInsertedDone", "onPostStart", "localId", "", "isFromSns", "preloadMoreToBuffer", "callback", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataCallback;", "printVisibleFeeds", "", "hasVisibleFeeds", "Landroid/util/LongSparseArray;", "requestRefresh", "unreadList", "", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "TimelineDataFetcher", "TimelineInsertRequest", "TimelineRequest", "TimelineResponse", "plugin-finder_release"})
public final class FinderTimelineFeedLoader
  extends BaseFinderFeedLoader
{
  public RecyclerView gmV;
  private final com.tencent.mm.plugin.finder.feed.model.internal.e sbM;
  public final com.tencent.mm.plugin.finder.cgi.fetcher.c sbQ;
  public boolean sbR;
  public d.g.a.b<? super IResponse<al>, z> sbS;
  public int sbT;
  
  public FinderTimelineFeedLoader(com.tencent.mm.plugin.finder.feed.model.internal.e parame, int paramInt, aqy paramaqy)
  {
    super(paramaqy);
    AppMethodBeat.i(202481);
    this.sbM = parame;
    this.sbT = paramInt;
    this.sbQ = new com.tencent.mm.plugin.finder.cgi.fetcher.c(this.sbM.value, paramaqy);
    AppMethodBeat.o(202481);
  }
  
  public final com.tencent.mm.plugin.finder.feed.model.internal.g<al> createDataFetch()
  {
    AppMethodBeat.i(202472);
    com.tencent.mm.plugin.finder.feed.model.internal.g localg = (com.tencent.mm.plugin.finder.feed.model.internal.g)new a(this.sbQ, this.sbM);
    AppMethodBeat.o(202472);
    return localg;
  }
  
  public final com.tencent.mm.plugin.finder.feed.model.internal.b<al> createDataMerger()
  {
    AppMethodBeat.i(202475);
    com.tencent.mm.plugin.finder.feed.model.internal.b localb = (com.tencent.mm.plugin.finder.feed.model.internal.b)new e(this);
    AppMethodBeat.o(202475);
    return localb;
  }
  
  public final void dE(List<? extends BaseFinderFeed> paramList)
  {
    AppMethodBeat.i(202474);
    paramList = new c(this.sbT, paramList);
    if (paramList.rZm) {}
    for (paramList.pullType = 4;; paramList.pullType = this.sbT)
    {
      ad.i(getTAG(), "[requestRefresh] pullType=" + paramList.pullType + "  hasPrefetch=" + paramList.rZl + " needToRefreshForPrefetch=" + paramList.rZm);
      super.request(paramList, (f)this);
      if (this.sbT == 0) {
        this.sbT = 1;
      }
      AppMethodBeat.o(202474);
      return;
    }
  }
  
  public final boolean isObservePostEvent()
  {
    AppMethodBeat.i(202476);
    if (this.sbM != com.tencent.mm.plugin.finder.feed.model.internal.e.scJ)
    {
      com.tencent.mm.plugin.finder.storage.b localb = com.tencent.mm.plugin.finder.storage.b.sxa;
      if (((Number)com.tencent.mm.plugin.finder.storage.b.cGS().value()).intValue() == 1) {}
    }
    else
    {
      AppMethodBeat.o(202476);
      return true;
    }
    AppMethodBeat.o(202476);
    return false;
  }
  
  public final void onDead()
  {
    AppMethodBeat.i(202480);
    super.onDead();
    this.sbQ.rIh.dead();
    AppMethodBeat.o(202480);
  }
  
  public final void onFetchDone(IResponse<al> paramIResponse)
  {
    AppMethodBeat.i(202473);
    d.g.b.p.h(paramIResponse, "response");
    super.onFetchDone(paramIResponse);
    com.tencent.mm.ad.c.g((d.g.a.a)FinderTimelineFeedLoader.f.scf);
    AppMethodBeat.o(202473);
  }
  
  public final void onFetchInsertedDone(IResponse<al> paramIResponse)
  {
    AppMethodBeat.i(202479);
    d.g.b.p.h(paramIResponse, "response");
    Object localObject = paramIResponse.getRequest();
    if ((localObject instanceof b))
    {
      if (!((b)localObject).sca) {
        super.onFetchInsertedDone(paramIResponse);
      }
      ad.i(getTAG(), "[onFetchInsertedDone] isPrefetch=" + ((b)localObject).sca);
    }
    AppMethodBeat.o(202479);
  }
  
  public final void onPostStart(long paramLong)
  {
    AppMethodBeat.i(202478);
    super.onPostStart(paramLong);
    this.sbR = true;
    ad.i(getTAG(), "onPostStart postFeedFlag true");
    AppMethodBeat.o(202478);
  }
  
  public final void onPostStart(long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(202477);
    super.onPostStart(paramLong, paramBoolean);
    this.sbR = true;
    AppMethodBeat.o(202477);
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/feed/model/FinderTimelineFeedLoader$TimelineDataFetcher;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataFetch;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycleKeeper;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycle;", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderTimelineStream$Callback;", "streamFetcher", "Lcom/tencent/mm/plugin/finder/cgi/fetcher/FinderTimelineFeedFetcher;", "scene", "Lcom/tencent/mm/plugin/finder/feed/model/internal/FinderLoaderScene;", "(Lcom/tencent/mm/plugin/finder/feed/model/FinderTimelineFeedLoader;Lcom/tencent/mm/plugin/finder/cgi/fetcher/FinderTimelineFeedFetcher;Lcom/tencent/mm/plugin/finder/feed/model/internal/FinderLoaderScene;)V", "taskExecutor", "Lcom/tencent/mm/loader/loader/SingleTaskExecutor;", "alive", "", "dead", "fetch", "request", "", "callback", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataCallback;", "fetchInit", "fetchLoadMore", "fetchRefresh", "keep", "p0", "onFetchDone", "info", "Lcom/tencent/mm/plugin/finder/feed/model/CgiFinderStreamResult;", "pullType", "", "plugin-finder_release"})
  public final class a
    extends com.tencent.mm.plugin.finder.feed.model.internal.g<al>
    implements n.a, com.tencent.mm.vending.e.b<com.tencent.mm.vending.e.a>
  {
    com.tencent.mm.loader.g.i rUM;
    private final com.tencent.mm.plugin.finder.feed.model.internal.e sbM;
    final com.tencent.mm.plugin.finder.cgi.fetcher.c sbQ;
    
    public a(com.tencent.mm.plugin.finder.feed.model.internal.e parame)
    {
      AppMethodBeat.i(202456);
      this.sbQ = parame;
      this.sbM = localObject;
      AppMethodBeat.o(202456);
    }
    
    public final void a(b paramb, int paramInt)
    {
      AppMethodBeat.i(202451);
      d.g.b.p.h(paramb, "info");
      AppMethodBeat.o(202451);
    }
    
    public final void alive()
    {
      AppMethodBeat.i(202453);
      super.alive();
      if (this.sbM == com.tencent.mm.plugin.finder.feed.model.internal.e.scG)
      {
        this.rUM = ((PluginFinder)com.tencent.mm.kernel.g.ad(PluginFinder.class)).getFollowTlSingleExecutor();
        locali = this.rUM;
        if (locali != null)
        {
          ad.i("Loader.SingleTaskExecutor", "[clean] name=" + locali.name);
          locali.hfC.clear();
          AppMethodBeat.o(202453);
          return;
        }
        AppMethodBeat.o(202453);
        return;
      }
      com.tencent.mm.loader.g.i locali = new com.tencent.mm.loader.g.i("SingleExecutor#TabType=" + this.sbQ.duh);
      locali.start();
      this.rUM = locali;
      AppMethodBeat.o(202453);
    }
    
    public final void dead()
    {
      AppMethodBeat.i(202454);
      super.dead();
      com.tencent.mm.loader.g.i locali = this.rUM;
      if (locali != null) {
        locali.reset();
      }
      this.rUM = null;
      AppMethodBeat.o(202454);
    }
    
    public final void fetch(final Object paramObject, f<al> paramf)
    {
      AppMethodBeat.i(202455);
      d.g.b.p.h(paramf, "callback");
      if ((paramObject instanceof FinderTimelineFeedLoader.c))
      {
        final long l = SystemClock.uptimeMillis();
        com.tencent.mm.loader.g.i locali = this.rUM;
        if (locali != null)
        {
          locali.a(new com.tencent.mm.loader.g.h((d.g.a.b)new a(this, paramObject, l, paramf)));
          AppMethodBeat.o(202455);
          return;
        }
      }
      AppMethodBeat.o(202455);
    }
    
    public final void fetchInit(f<al> paramf)
    {
      AppMethodBeat.i(202452);
      d.g.b.p.h(paramf, "callback");
      Object localObject2 = new LinkedList();
      Object localObject1 = com.tencent.mm.ui.component.a.KiD;
      localObject1 = ((FinderHomeTabStateVM)com.tencent.mm.ui.component.a.bi(PluginFinder.class).get(FinderHomeTabStateVM.class)).Gi(this.sbM.value);
      int i;
      Object localObject3;
      Object localObject4;
      Object localObject5;
      Object localObject6;
      label293:
      label310:
      boolean bool;
      label389:
      label425:
      long l;
      if (((FinderHomeTabStateVM.a)localObject1).sZm.isEmpty())
      {
        localObject1 = com.tencent.mm.plugin.finder.utils.p.sMo;
        i = com.tencent.mm.plugin.finder.utils.p.FT(this.sbM.value);
        localObject1 = k.sAe;
        localObject1 = com.tencent.mm.plugin.finder.utils.p.sMo;
        localObject1 = k.a.Fu(com.tencent.mm.plugin.finder.utils.p.FR(i));
        localObject3 = ((Iterable)localObject1).iterator();
        while (((Iterator)localObject3).hasNext())
        {
          localObject4 = (al)((Iterator)localObject3).next();
          if ((localObject4 instanceof BaseFinderFeed))
          {
            localObject5 = FinderTimelineFeedLoader.this.getContextObj();
            if (localObject5 != null)
            {
              localObject6 = com.tencent.mm.plugin.finder.report.h.soM;
              com.tencent.mm.plugin.finder.report.h.d(((al)localObject4).lP(), ((aqy)localObject5).rTD, ((BaseFinderFeed)localObject4).feedObject.getFeedObject().sessionBuffer);
            }
          }
        }
        ((LinkedList)localObject2).addAll((Collection)localObject1);
        localObject1 = FinderTimelineFeedLoader.this.getContextObj();
        if (localObject1 != null)
        {
          localObject3 = com.tencent.mm.ui.component.a.KiD;
          localObject3 = (FinderTabStreamUnreadVM)com.tencent.mm.ui.component.a.bi(PluginFinder.class).get(FinderTabStreamUnreadVM.class);
          i = ((aqy)localObject1).rTD;
          localObject1 = com.tencent.mm.plugin.finder.utils.p.sMo;
          ((FinderTabStreamUnreadVM)localObject3).j(i, com.tencent.mm.plugin.finder.utils.p.a((List)localObject2, BaseFinderFeed.class));
        }
        localObject1 = com.tencent.mm.plugin.finder.report.e.snY;
        int j = this.sbQ.duh;
        if (((Collection)localObject2).isEmpty()) {
          break label618;
        }
        i = 1;
        localObject1 = com.tencent.mm.plugin.finder.report.e.EL(j);
        if (localObject1 != null)
        {
          if (i == 0) {
            break label623;
          }
          i = 1;
          ((e.a)localObject1).Lkc = i;
        }
        localObject1 = (al)d.a.j.jd((List)localObject2);
        localObject3 = getTAG();
        localObject4 = new StringBuilder("fetchInit tabType=").append(this.sbQ.duh).append(" callInitData scene=").append(this.sbM).append(", contextObj=");
        if (FinderTimelineFeedLoader.this.getContextObj() != null) {
          break label628;
        }
        bool = true;
        localObject4 = ((StringBuilder)localObject4).append(bool).append("list first=");
        if (!(localObject1 instanceof BaseFinderFeed)) {
          break label634;
        }
        localObject1 = ((BaseFinderFeed)localObject1).feedObject.getNickName();
        localObject1 = ((StringBuilder)localObject4).append((String)localObject1).append(" => ");
        localObject4 = (al)d.a.j.jd((List)localObject2);
        if (localObject4 == null) {
          break label642;
        }
        l = ((al)localObject4).lP();
        label467:
        ad.i((String)localObject3, com.tencent.mm.ad.c.rc(l));
        localObject1 = new FinderTimelineFeedLoader.d(0, 0, "", (byte)0);
        localObject3 = (Iterable)localObject2;
        localObject2 = (Collection)new ArrayList();
        localObject3 = ((Iterable)localObject3).iterator();
      }
      label642:
      label652:
      for (;;)
      {
        label528:
        if (!((Iterator)localObject3).hasNext()) {
          break label654;
        }
        localObject4 = ((Iterator)localObject3).next();
        localObject5 = (al)localObject4;
        if ((localObject5 instanceof BaseFinderFeed)) {
          localObject6 = com.tencent.mm.plugin.finder.utils.p.sMo;
        }
        for (bool = com.tencent.mm.plugin.finder.utils.p.o(((BaseFinderFeed)localObject5).feedObject.getFeedObject());; bool = true)
        {
          if (!bool) {
            break label652;
          }
          ((Collection)localObject2).add(localObject4);
          break label528;
          ((LinkedList)localObject2).addAll((Collection)((FinderHomeTabStateVM.a)localObject1).sZm);
          break;
          label618:
          i = 0;
          break label293;
          label623:
          i = 0;
          break label310;
          label628:
          bool = false;
          break label389;
          label634:
          localObject1 = "";
          break label425;
          l = 0L;
          break label467;
        }
      }
      label654:
      ((FinderTimelineFeedLoader.d)localObject1).setIncrementList((List)localObject2);
      ((FinderTimelineFeedLoader.d)localObject1).setPullType(1000);
      paramf.onFetchDone((IResponse)localObject1);
      AppMethodBeat.o(202452);
    }
    
    public final void fetchLoadMore(f<al> paramf)
    {
      AppMethodBeat.i(202449);
      d.g.b.p.h(paramf, "callback");
      fetch(new FinderTimelineFeedLoader.c(2), paramf);
      AppMethodBeat.o(202449);
    }
    
    public final void fetchRefresh(f<al> paramf)
    {
      AppMethodBeat.i(202448);
      d.g.b.p.h(paramf, "callback");
      FinderTimelineFeedLoader.c localc = new FinderTimelineFeedLoader.c(FinderTimelineFeedLoader.this.sbT);
      if (localc.rZm) {}
      for (localc.pullType = 4;; localc.pullType = FinderTimelineFeedLoader.this.sbT)
      {
        if (FinderTimelineFeedLoader.this.sbT == 0) {
          FinderTimelineFeedLoader.this.sbT = 1;
        }
        ad.i(getTAG(), "[requestRefresh] pullType=" + localc.pullType + "  hasPrefetch=" + localc.rZl + " needToRefreshForPrefetch=" + localc.rZm);
        fetch(localc, paramf);
        AppMethodBeat.o(202448);
        return;
      }
    }
    
    public final void keep(com.tencent.mm.vending.e.a parama)
    {
      AppMethodBeat.i(202450);
      d.g.b.p.h(parama, "p0");
      AppMethodBeat.o(202450);
    }
    
    @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "task", "Lcom/tencent/mm/loader/loader/SingleTask;", "invoke"})
    static final class a
      extends q
      implements d.g.a.b<com.tencent.mm.loader.g.h, z>
    {
      a(FinderTimelineFeedLoader.a parama, Object paramObject, long paramLong, f paramf)
      {
        super();
      }
      
      @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/finder/feed/model/FinderTimelineFeedLoader$TimelineDataFetcher$fetch$1$1$1", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderTimelineStream$Callback;", "onFetchDone", "", "info", "Lcom/tencent/mm/plugin/finder/feed/model/CgiFinderStreamResult;", "pullType", "", "plugin-finder_release"})
      public static final class a
        implements n.a
      {
        a(FinderTimelineFeedLoader.a.a parama, com.tencent.mm.loader.g.h paramh) {}
        
        public final void a(b paramb, int paramInt)
        {
          AppMethodBeat.i(202444);
          d.g.b.p.h(paramb, "info");
          FinderTimelineFeedLoader.d locald = new FinderTimelineFeedLoader.d(paramb.errType, paramb.errCode, paramb.errMsg, (byte)0);
          locald.setIncrementList((List)paramb.saR);
          locald.setPullType(paramInt);
          locald.setHasMore(true);
          locald.setRequest(this.sbW.sbz);
          locald.scd = paramb.saY;
          this.sbW.sbA.onFetchDone((IResponse)locald);
          this.sbX.a(com.tencent.mm.loader.g.j.hfK);
          AppMethodBeat.o(202444);
        }
      }
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/feed/model/FinderTimelineFeedLoader$TimelineInsertRequest;", "Lcom/tencent/mm/plugin/finder/feed/model/FinderTimelineFeedLoader$TimelineRequest;", "pullType", "", "(I)V", "centerFeed", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "getCenterFeed", "()Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "setCenterFeed", "(Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;)V", "feed", "getFeed", "setFeed", "isConsume", "", "()Z", "setConsume", "(Z)V", "isPrefetch", "setPrefetch", "maxUnreadCount", "getMaxUnreadCount", "()I", "setMaxUnreadCount", "relatedEntranceInfo", "Lcom/tencent/mm/protocal/protobuf/FinderGetRelatedEntranceInfo;", "getRelatedEntranceInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderGetRelatedEntranceInfo;", "setRelatedEntranceInfo", "(Lcom/tencent/mm/protocal/protobuf/FinderGetRelatedEntranceInfo;)V", "toString", "", "plugin-finder_release"})
  public static final class b
    extends FinderTimelineFeedLoader.c
  {
    public aoi rIM;
    public BaseFinderFeed rQZ;
    public BaseFinderFeed rRn;
    public int sbY = -1;
    boolean sbZ = true;
    public boolean sca;
    
    public b()
    {
      super();
    }
    
    public final String toString()
    {
      AppMethodBeat.i(202457);
      Object localObject1 = new StringBuilder("feed=");
      Object localObject2 = this.rQZ;
      if (localObject2 != null)
      {
        localObject2 = ((BaseFinderFeed)localObject2).feedObject;
        if (localObject2 == null) {}
      }
      for (long l = ((FinderItem)localObject2).getId();; l = 0L)
      {
        localObject1 = com.tencent.mm.ad.c.rc(l) + ", keepUnreadSize=" + this.sbY;
        AppMethodBeat.o(202457);
        return localObject1;
      }
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/feed/model/FinderTimelineFeedLoader$TimelineRequest;", "", "pullType", "", "unreadList", "", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "(ILjava/util/List;)V", "hasPrefetch", "", "getHasPrefetch", "()Z", "setHasPrefetch", "(Z)V", "isPreloadMore", "setPreloadMore", "minDuration", "", "getMinDuration", "()J", "setMinDuration", "(J)V", "needToRefreshForPrefetch", "getNeedToRefreshForPrefetch", "setNeedToRefreshForPrefetch", "getPullType", "()I", "setPullType", "(I)V", "getUnreadList", "()Ljava/util/List;", "setUnreadList", "(Ljava/util/List;)V", "plugin-finder_release"})
  public static class c
  {
    int pullType;
    List<? extends BaseFinderFeed> rHC;
    public boolean rZl;
    public boolean rZm;
    public long scb;
    public boolean scc;
    
    public c(int paramInt, List<? extends BaseFinderFeed> paramList)
    {
      this.pullType = paramInt;
      this.rHC = paramList;
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/feed/model/FinderTimelineFeedLoader$TimelineResponse;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "errType", "", "errCode", "errMsg", "", "extraData", "", "(IILjava/lang/String;Ljava/lang/Object;)V", "dataBufferList", "Ljava/util/ArrayList;", "getDataBufferList", "()Ljava/util/ArrayList;", "setDataBufferList", "(Ljava/util/ArrayList;)V", "getExtraData", "()Ljava/lang/Object;", "setExtraData", "(Ljava/lang/Object;)V", "plugin-finder_release"})
  public static final class d
    extends IResponse<al>
  {
    public ArrayList<al> saZ;
    public Object scd = null;
    
    private d(int paramInt1, int paramInt2, String paramString)
    {
      super(paramInt2, paramString);
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/finder/feed/model/FinderTimelineFeedLoader$createDataMerger$1", "Lcom/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader$DefaultDataMerger;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "isDebug", "", "cleanDataList", "", "dataList", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataBuffer;", "finallyHandleMergeList", "srcList", "Ljava/util/ArrayList;", "newList", "Ljava/util/LinkedList;", "insertIndex", "", "cmd", "request", "", "findMergeIndex", "", "mergeDataAndNotify", "Lcom/tencent/mm/plugin/finder/feed/model/internal/MergeResult;", "insList", "isNeedClear", "mergeInsert", "response", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "next", "Lkotlin/Function1;", "mergeLoadMore", "mergeRefresh", "needCleanWhenRefresh", "plugin-finder_release"})
  public static final class e
    extends BaseFeedLoader<al>.a
  {
    private final boolean cFj;
    
    e()
    {
      super();
      AppMethodBeat.i(202468);
      if ((com.tencent.mm.sdk.platformtools.i.IS_FLAVOR_PURPLE) || (com.tencent.mm.sdk.platformtools.i.IS_FLAVOR_RED) || (com.tencent.mm.sdk.a.b.fjN())) {}
      for (boolean bool = true;; bool = false)
      {
        this.cFj = bool;
        AppMethodBeat.o(202468);
        return;
      }
    }
    
    public final void cleanDataList(DataBuffer<al> paramDataBuffer)
    {
      AppMethodBeat.i(202462);
      d.g.b.p.h(paramDataBuffer, "dataList");
      super.cleanDataList(paramDataBuffer);
      Object localObject = com.tencent.mm.ui.component.a.KiD;
      localObject = (FinderTabStreamUnreadVM)com.tencent.mm.ui.component.a.bi(PluginFinder.class).get(FinderTabStreamUnreadVM.class);
      int i = this.sbU.sbQ.duh;
      com.tencent.mm.plugin.finder.utils.p localp = com.tencent.mm.plugin.finder.utils.p.sMo;
      paramDataBuffer = com.tencent.mm.plugin.finder.utils.p.a((List)paramDataBuffer, BaseFinderFeed.class);
      d.g.b.p.h(paramDataBuffer, "deprecatedList");
      com.tencent.mm.ad.c.b(null, (d.g.a.a)new FinderTabStreamUnreadVM.c((FinderTabStreamUnreadVM)localObject, i, paramDataBuffer));
      AppMethodBeat.o(202462);
    }
    
    public final boolean finallyHandleMergeList(ArrayList<al> paramArrayList, LinkedList<al> paramLinkedList, int paramInt1, int paramInt2, Object paramObject)
    {
      AppMethodBeat.i(202466);
      d.g.b.p.h(paramArrayList, "srcList");
      d.g.b.p.h(paramLinkedList, "newList");
      long l;
      Object localObject1;
      Object localObject2;
      if ((paramInt2 == 8) && ((paramObject instanceof FinderTimelineFeedLoader.b)))
      {
        if ((paramInt1 <= 0) && (!((FinderTimelineFeedLoader.b)paramObject).sbZ))
        {
          paramArrayList = com.tencent.mm.plugin.finder.storage.data.g.szT;
          paramArrayList = ((FinderTimelineFeedLoader.b)paramObject).rQZ;
          if (paramArrayList != null)
          {
            paramArrayList = paramArrayList.feedObject;
            if (paramArrayList == null) {}
          }
          for (l = paramArrayList.getId();; l = 0L)
          {
            com.tencent.mm.plugin.finder.storage.data.g.xb(l);
            paramArrayList = com.tencent.mm.plugin.finder.utils.p.sMo;
            paramInt1 = this.sbU.sbQ.duh;
            paramArrayList = com.tencent.mm.plugin.finder.utils.p.sMo;
            com.tencent.mm.plugin.finder.utils.p.a(paramInt1, com.tencent.mm.plugin.finder.utils.p.a((List)paramLinkedList, BaseFinderFeed.class), this.sbU.getContextObj());
            paramLinkedList.clear();
            AppMethodBeat.o(202466);
            return false;
          }
        }
        localObject1 = this.sbU.gmV;
        if (localObject1 != null)
        {
          localObject1 = ((RecyclerView)localObject1).getAdapter();
          localObject2 = localObject1;
          if (!(localObject1 instanceof WxRecyclerAdapter)) {
            localObject2 = null;
          }
          localObject1 = (WxRecyclerAdapter)localObject2;
          if (localObject1 != null)
          {
            localObject1 = ((WxRecyclerAdapter)localObject1).LvS;
            if (localObject1 != null) {
              break label968;
            }
          }
          localObject1 = new LongSparseArray();
        }
      }
      label263:
      label284:
      label548:
      label937:
      label939:
      label962:
      label965:
      label968:
      for (;;)
      {
        LinkedList localLinkedList = new LinkedList((Collection)paramArrayList.subList(0, Math.min(paramInt1, paramArrayList.size())));
        Object localObject3;
        Object localObject4;
        if (paramInt1 < paramArrayList.size())
        {
          localObject2 = new LinkedList((Collection)paramArrayList.subList(paramInt1, paramArrayList.size()));
          paramInt1 = -1;
          localObject3 = (Iterable)localLinkedList;
          paramInt2 = 0;
          localObject3 = ((Iterable)localObject3).iterator();
          if (!((Iterator)localObject3).hasNext()) {
            break label359;
          }
          localObject4 = ((Iterator)localObject3).next();
          if (paramInt2 < 0) {
            d.a.j.gfB();
          }
          if (((LongSparseArray)localObject1).indexOfKey(((al)localObject4).lP()) < 0) {
            break label965;
          }
          paramInt1 = paramInt2;
        }
        for (;;)
        {
          paramInt2 += 1;
          break label284;
          localObject1 = null;
          break;
          localObject2 = new LinkedList();
          break label263;
          label359:
          if (paramInt1 >= 0) {}
          int j;
          Object localObject5;
          for (int i = localLinkedList.size() - paramInt1 - 1;; i = 0)
          {
            j = ((FinderTimelineFeedLoader.b)paramObject).sbY - i;
            localObject3 = new LinkedList();
            localObject4 = new LinkedList();
            ((LinkedList)localObject4).addAll((Collection)paramLinkedList);
            ((LinkedList)localObject4).addAll((Collection)localObject2);
            ((LinkedList)localObject3).addAll((Collection)localObject4);
            localObject2 = ((LinkedList)localObject3).iterator();
            d.g.b.p.g(localObject2, "increment.iterator()");
            paramInt2 = 0;
            for (;;)
            {
              if (!((Iterator)localObject2).hasNext()) {
                break label548;
              }
              localObject5 = ((Iterator)localObject2).next();
              d.g.b.p.g(localObject5, "iterator.next()");
              localObject5 = (al)localObject5;
              if ((!(localObject5 instanceof BaseFinderFeed)) || (((LongSparseArray)localObject1).indexOfKey(((BaseFinderFeed)localObject5).feedObject.getId()) >= 0)) {
                break label962;
              }
              if (paramInt2 < j) {
                break;
              }
              ((Iterator)localObject2).remove();
            }
          }
          paramInt2 += 1;
          for (;;)
          {
            break;
            localObject2 = ((LinkedList)localObject4).subList(((LinkedList)localObject3).size(), ((LinkedList)localObject4).size());
            d.g.b.p.g(localObject2, "after.subList(increment.size, after.size)");
            localObject5 = this.sbU.getTAG();
            StringBuilder localStringBuilder = new StringBuilder("[finallyHandleMergeList] feed=");
            Object localObject6 = ((FinderTimelineFeedLoader.b)paramObject).rQZ;
            if (localObject6 != null)
            {
              localObject6 = ((BaseFinderFeed)localObject6).feedObject;
              if (localObject6 != null)
              {
                l = ((FinderItem)localObject6).getId();
                ad.i((String)localObject5, com.tencent.mm.ad.c.rc(l) + ' ' + "rawBefore=" + localLinkedList.size() + " raw=" + paramArrayList.size() + " readIndex=" + paramInt1 + " unreadCount=" + i + " maxUnreadCount=" + ((FinderTimelineFeedLoader.b)paramObject).sbY + " limitUnreadCount=" + j + ' ' + "afterSize=" + ((LinkedList)localObject4).size() + " incrementCount=" + ((LinkedList)localObject3).size() + " remain=" + ((List)localObject2).size() + ' ' + "hasVisibleFeeds=" + FinderTimelineFeedLoader.a((LongSparseArray)localObject1));
                paramArrayList.clear();
                paramArrayList.addAll((Collection)localLinkedList);
                paramLinkedList.clear();
                paramLinkedList.addAll((Collection)localObject3);
                paramArrayList = com.tencent.mm.plugin.finder.utils.p.sMo;
                paramInt2 = this.sbU.sbQ.duh;
                paramLinkedList = (Iterable)localObject2;
                paramArrayList = (Collection)new ArrayList();
                paramLinkedList = paramLinkedList.iterator();
              }
            }
            for (;;)
            {
              label863:
              if (!paramLinkedList.hasNext()) {
                break label939;
              }
              paramObject = paramLinkedList.next();
              localObject2 = (al)paramObject;
              if (((localObject2 instanceof BaseFinderFeed)) && (((LongSparseArray)localObject1).indexOfKey(((al)localObject2).lP()) < 0)) {}
              for (paramInt1 = 1;; paramInt1 = 0)
              {
                if (paramInt1 == 0) {
                  break label937;
                }
                paramArrayList.add(paramObject);
                break label863;
                l = 0L;
                break;
              }
            }
            com.tencent.mm.plugin.finder.utils.p.a(paramInt2, (List)paramArrayList, this.sbU.getContextObj());
            AppMethodBeat.o(202466);
            return true;
          }
        }
      }
    }
    
    public final int findMergeIndex(ArrayList<al> paramArrayList, List<? extends al> paramList, int paramInt, Object paramObject)
    {
      AppMethodBeat.i(202465);
      d.g.b.p.h(paramArrayList, "srcList");
      d.g.b.p.h(paramList, "newList");
      Object localObject1;
      long l;
      int i;
      label128:
      label136:
      label166:
      label200:
      label237:
      Object localObject2;
      label265:
      label312:
      int j;
      if ((paramInt == 8) && ((paramObject instanceof FinderTimelineFeedLoader.b)))
      {
        paramList = (List)paramArrayList;
        paramInt = 0;
        paramList = paramList.iterator();
        if (paramList.hasNext())
        {
          localObject1 = (al)paramList.next();
          if ((localObject1 instanceof BaseFinderFeed))
          {
            l = ((BaseFinderFeed)localObject1).feedObject.getId();
            localObject1 = ((FinderTimelineFeedLoader.b)paramObject).rQZ;
            if (localObject1 != null)
            {
              localObject1 = ((BaseFinderFeed)localObject1).feedObject;
              if ((localObject1 != null) && (l == ((FinderItem)localObject1).getId()))
              {
                i = 1;
                if (i == 0) {
                  break label523;
                }
                i = paramInt;
                paramList = ((FinderTimelineFeedLoader.b)paramObject).rRn;
                if (paramList == null) {
                  break label536;
                }
                paramList = paramList.feedObject;
                if (paramList == null) {
                  break label536;
                }
                paramList = Long.valueOf(paramList.getId());
                localObject1 = this.sbU.gmV;
                if (localObject1 == null) {
                  break label541;
                }
                paramList = com.tencent.mm.plugin.finder.utils.p.sMo;
                paramList = Long.valueOf(com.tencent.mm.plugin.finder.utils.p.b((RecyclerView)localObject1, 0, 0, 14).dtq);
                localObject1 = ((FinderTimelineFeedLoader.b)paramObject).rQZ;
                if (localObject1 == null) {
                  break label544;
                }
                localObject1 = ((BaseFinderFeed)localObject1).feedObject;
                if (localObject1 == null) {
                  break label544;
                }
                localObject1 = Long.valueOf(((FinderItem)localObject1).getId());
                if (!(d.g.b.p.i(paramList, localObject1) ^ true)) {
                  break label1106;
                }
                localObject1 = (List)paramArrayList;
                paramInt = 0;
                localObject1 = ((List)localObject1).iterator();
                if (!((Iterator)localObject1).hasNext()) {
                  break label573;
                }
                localObject2 = (al)((Iterator)localObject1).next();
                if ((localObject2 instanceof BaseFinderFeed))
                {
                  l = ((BaseFinderFeed)localObject2).feedObject.getId();
                  if (paramList != null) {
                    break label550;
                  }
                }
                j = 0;
                label315:
                if (j == 0) {
                  break label566;
                }
                label320:
                ad.i(this.sbU.getTAG(), "[findMergeIndex] centerFeedId=" + i + " newCenterIndex=" + paramInt);
              }
            }
          }
        }
      }
      label523:
      label536:
      label541:
      label544:
      label550:
      label566:
      label573:
      label719:
      label1106:
      for (int m = paramInt;; m = i)
      {
        if (i != m) {
          com.tencent.mm.plugin.report.service.g.yhR.f(20198, new Object[] { Integer.valueOf(1) });
        }
        int i1;
        int k;
        int n;
        for (;;)
        {
          i1 = Math.max(m, i);
          paramInt = Math.max(0, Math.min(paramArrayList.size(), i1));
          paramList = ((Iterable)paramArrayList).iterator();
          k = 0;
          for (j = 0;; j = 2)
          {
            n = j;
            if (!paramList.hasNext()) {
              break label642;
            }
            localObject1 = paramList.next();
            n = k + 1;
            if (k < 0) {
              d.a.j.gfB();
            }
            localObject1 = (al)localObject1;
            if ((!(localObject1 instanceof BaseFinderFeed)) || (k < i1) || (!((BaseFinderFeed)localObject1).feedObject.isRelatedItem())) {
              break;
            }
            paramInt += 1;
            if (j != 0) {
              break label1103;
            }
            k = n;
          }
          i = 0;
          break label128;
          paramInt += 1;
          break;
          i = -1;
          break label136;
          paramList = null;
          break label166;
          break label200;
          localObject1 = null;
          break label237;
          if (l != paramList.longValue()) {
            break label312;
          }
          j = 1;
          break label315;
          paramInt += 1;
          break label265;
          paramInt = -1;
          break label320;
          com.tencent.mm.plugin.report.service.g.yhR.f(20198, new Object[] { Integer.valueOf(2) });
        }
        label729:
        label762:
        boolean bool;
        if (((localObject1 instanceof BaseFinderFeed)) && (k >= i1) && (!((BaseFinderFeed)localObject1).feedObject.isRelatedItem()))
        {
          n = j;
          if (j == 0) {
            n = 1;
          }
          if (n != 2) {
            break label1039;
          }
          j = 0;
          k = paramInt + j;
          paramInt = -2;
          localObject2 = this.sbU.gmV;
          if (localObject2 != null)
          {
            paramList = this.sbU.gmV;
            if (paramList == null) {
              break label1045;
            }
            paramList = paramList.getLayoutManager();
            localObject1 = paramList;
            if (!(paramList instanceof LinearLayoutManager)) {
              localObject1 = null;
            }
            paramList = (LinearLayoutManager)localObject1;
            if (paramList == null) {
              break label1050;
            }
            paramInt = paramList.km();
            if (paramList == null) {
              break label1055;
            }
            j = paramList.ko();
            paramList = com.tencent.mm.plugin.finder.utils.p.sMo;
            localObject2 = com.tencent.mm.plugin.finder.utils.p.b((RecyclerView)localObject2, paramInt, j, 8);
            paramList = this.sbU.gmV;
            if (paramList == null) {
              break label1061;
            }
            paramList = paramList.getAdapter();
            localObject1 = paramList;
            if (!(paramList instanceof WxRecyclerAdapter)) {
              localObject1 = null;
            }
            paramList = (WxRecyclerAdapter)localObject1;
            if (paramList == null) {
              break label1066;
            }
            paramInt = paramList.Lvi.size();
            paramInt = ((p.a)localObject2).sMq - paramInt;
            paramList = (FinderTimelineFeedLoader.b)paramObject;
            if (k <= paramInt) {
              break label1071;
            }
            bool = true;
            paramList.sbZ = bool;
            if (!((FinderTimelineFeedLoader.b)paramObject).sbZ) {
              ad.w(this.sbU.getTAG(), "[finallyHandleMergeList] insertIndex is invalid. resultIndex=" + k + " focusedPosition=" + paramInt);
            }
          }
          ad.i(this.sbU.getTAG(), "[findMergeIndex] tabType=" + this.sbU.sbQ.duh + " requestIndex=" + i + " centerIndex=" + m + " fixIndex=" + i1 + " resultIndex=" + k + ' ' + "focusedPosition=" + paramInt + " isConsume=" + ((FinderTimelineFeedLoader.b)paramObject).sbZ + " size=" + paramArrayList.size() + " source=" + n + ' ');
          if (!((FinderTimelineFeedLoader.b)paramObject).sbZ) {
            break label1077;
          }
          AppMethodBeat.o(202465);
          return k;
        }
        for (;;)
        {
          k = n;
          break;
          j = 1;
          break label651;
          paramList = null;
          break label691;
          paramInt = -1;
          break label719;
          j = -1;
          break label729;
          paramList = null;
          break label762;
          paramInt = 0;
          break label793;
          bool = false;
          break label816;
          AppMethodBeat.o(202465);
          return 0;
          paramInt = super.findMergeIndex(paramArrayList, paramList, paramInt, paramObject);
          AppMethodBeat.o(202465);
          return paramInt;
        }
      }
    }
    
    public final com.tencent.mm.plugin.finder.feed.model.internal.j mergeDataAndNotify(int paramInt, List<? extends al> paramList, boolean paramBoolean, Object paramObject)
    {
      AppMethodBeat.i(202464);
      label102:
      Object localObject2;
      label153:
      label204:
      label210:
      label216:
      label222:
      Iterator localIterator;
      if (((paramObject instanceof FinderTimelineFeedLoader.b)) && (this.sbU.gmV != null))
      {
        localObject1 = ((FinderTimelineFeedLoader.b)paramObject).rQZ;
        if (localObject1 != null)
        {
          localObject1 = ((BaseFinderFeed)localObject1).feedObject;
          if ((localObject1 != null) && (!((FinderItem)localObject1).isRelatedItem()))
          {
            localObject1 = ((FinderTimelineFeedLoader.b)paramObject).rQZ;
            long l;
            int i;
            if (localObject1 != null)
            {
              l = ((BaseFinderFeed)localObject1).lP();
              localObject1 = this.sbU.gmV;
              if (localObject1 == null) {
                break label204;
              }
              localObject1 = ((RecyclerView)localObject1).getAdapter();
              localObject2 = localObject1;
              if (!(localObject1 instanceof WxRecyclerAdapter)) {
                localObject2 = null;
              }
              localObject1 = (WxRecyclerAdapter)localObject2;
              if (localObject1 == null) {
                break label210;
              }
              localObject1 = (com.tencent.mm.view.recyclerview.e)d.c((d)localObject1, l);
              if (localObject1 == null) {
                break label210;
              }
              i = ((com.tencent.mm.view.recyclerview.e)localObject1).lN();
              localObject1 = this.sbU.gmV;
              if (localObject1 == null) {
                break label216;
              }
            }
            for (localObject1 = ((RecyclerView)localObject1).getLayoutManager();; localObject1 = null)
            {
              if (localObject1 != null) {
                break label222;
              }
              paramList = new v("null cannot be cast to non-null type android.support.v7.widget.LinearLayoutManager");
              AppMethodBeat.o(202464);
              throw paramList;
              l = 0L;
              break;
              localObject1 = null;
              break label102;
              i = -1;
              break label153;
            }
            localObject1 = (LinearLayoutManager)localObject1;
            int j = ((LinearLayoutManager)localObject1).km();
            int k = ((LinearLayoutManager)localObject1).ko();
            boolean bool;
            if ((i >= 0) && (j <= i) && (i <= k))
            {
              bool = true;
              ad.i(this.sbU.getTAG(), "[mergeDataAndNotify] tabType=" + this.sbU.sbQ.duh + " position=" + i + " first=" + j + " last=" + k + " isConsume=" + bool);
              if (!bool) {
                break label525;
              }
              paramObject = super.mergeDataAndNotify(paramInt, paramList, paramBoolean, paramObject);
              if (!this.cFj) {
                break label516;
              }
              localObject1 = this.sbU.getTAG() + "#insert";
              paramList = (Iterable)this.sbU.getDataList();
              localObject2 = (Collection)new ArrayList(d.a.j.a(paramList, 10));
              localIterator = paramList.iterator();
              label433:
              if (!localIterator.hasNext()) {
                break label503;
              }
              paramList = (al)localIterator.next();
              if (!(paramList instanceof BaseFinderFeed)) {
                break label496;
              }
            }
            label496:
            for (paramList = com.tencent.mm.ad.c.rc(((BaseFinderFeed)paramList).feedObject.getFeedObject().id);; paramList = "")
            {
              ((Collection)localObject2).add(paramList);
              break label433;
              bool = false;
              break;
            }
            label503:
            ad.i((String)localObject1, String.valueOf((List)localObject2));
            label516:
            AppMethodBeat.o(202464);
            return paramObject;
            label525:
            if (paramList != null)
            {
              paramObject = com.tencent.mm.plugin.finder.storage.data.g.szT;
              com.tencent.mm.plugin.finder.storage.data.g.xb(l);
              paramObject = com.tencent.mm.plugin.finder.utils.p.sMo;
              paramInt = this.sbU.sbQ.duh;
              paramObject = com.tencent.mm.plugin.finder.utils.p.sMo;
              com.tencent.mm.plugin.finder.utils.p.a(paramInt, com.tencent.mm.plugin.finder.utils.p.a(paramList, BaseFinderFeed.class), this.sbU.getContextObj());
            }
            paramList = new com.tencent.mm.plugin.finder.feed.model.internal.j(new LinkedList());
            AppMethodBeat.o(202464);
            return paramList;
          }
        }
      }
      Object localObject1 = super.mergeDataAndNotify(paramInt, paramList, paramBoolean, paramObject);
      if (this.cFj)
      {
        if (!(paramObject instanceof FinderTimelineFeedLoader.b)) {
          break label777;
        }
        paramObject = this.sbU.getTAG() + "#insert";
        paramList = (Iterable)this.sbU.getDataList();
        localObject2 = (Collection)new ArrayList(d.a.j.a(paramList, 10));
        localIterator = paramList.iterator();
        if (localIterator.hasNext())
        {
          paramList = (al)localIterator.next();
          if ((paramList instanceof BaseFinderFeed)) {}
          for (paramList = com.tencent.mm.ad.c.rc(((BaseFinderFeed)paramList).feedObject.getFeedObject().id);; paramList = "")
          {
            ((Collection)localObject2).add(paramList);
            break;
          }
        }
        ad.i(paramObject, String.valueOf((List)localObject2));
      }
      for (;;)
      {
        AppMethodBeat.o(202464);
        return localObject1;
        label777:
        if ((this.sbU.sbQ.duh == 4) && (paramInt == 1))
        {
          paramObject = this.sbU.getTAG() + "#loadMore";
          paramList = (Iterable)this.sbU.getDataList();
          localObject2 = (Collection)new ArrayList(d.a.j.a(paramList, 10));
          localIterator = paramList.iterator();
          if (localIterator.hasNext())
          {
            paramList = (al)localIterator.next();
            if ((paramList instanceof BaseFinderFeed)) {}
            for (paramList = com.tencent.mm.ad.c.rc(((BaseFinderFeed)paramList).feedObject.getFeedObject().id);; paramList = "")
            {
              ((Collection)localObject2).add(paramList);
              break;
            }
          }
          ad.i(paramObject, String.valueOf((List)localObject2));
        }
        else if ((this.sbU.sbQ.duh == 4) && (paramInt == 4))
        {
          paramObject = this.sbU.getTAG() + "#refresh";
          paramList = (Iterable)this.sbU.getDataList();
          localObject2 = (Collection)new ArrayList(d.a.j.a(paramList, 10));
          localIterator = paramList.iterator();
          if (localIterator.hasNext())
          {
            paramList = (al)localIterator.next();
            if ((paramList instanceof BaseFinderFeed)) {}
            for (paramList = com.tencent.mm.ad.c.rc(((BaseFinderFeed)paramList).feedObject.getFeedObject().id);; paramList = "")
            {
              ((Collection)localObject2).add(paramList);
              break;
            }
          }
          ad.i(paramObject, String.valueOf((List)localObject2));
        }
      }
    }
    
    public final void mergeInsert(IResponse<al> paramIResponse, d.g.a.b<? super IResponse<al>, z> paramb)
    {
      AppMethodBeat.i(202463);
      d.g.b.p.h(paramIResponse, "response");
      Object localObject = paramIResponse.getRequest();
      if ((localObject instanceof FinderTimelineFeedLoader.b))
      {
        if (!((FinderTimelineFeedLoader.b)localObject).sca) {
          super.mergeInsert(paramIResponse, paramb);
        }
        ad.i(this.sbU.getTAG(), "[onFetchInsertedDone] isPrefetch=" + ((FinderTimelineFeedLoader.b)localObject).sca);
      }
      AppMethodBeat.o(202463);
    }
    
    public final void mergeLoadMore(final IResponse<al> paramIResponse, final d.g.a.b<? super IResponse<al>, z> paramb)
    {
      int i = 1;
      AppMethodBeat.i(202461);
      d.g.b.p.h(paramIResponse, "response");
      if ((paramIResponse instanceof FinderTimelineFeedLoader.d)) {
        this.sbU.getDataListJustForAdapter().setBuffer((Collection)((FinderTimelineFeedLoader.d)paramIResponse).saZ);
      }
      final RefreshLoadMoreLayout.c localc = new RefreshLoadMoreLayout.c(paramIResponse.getPullType());
      localc.Lri = paramIResponse.getHasMore();
      Context localContext = aj.getContext();
      d.g.b.p.g(localContext, "MMApplicationContext.getContext()");
      localc.Lrh = ((CharSequence)localContext.getResources().getString(2131759370));
      localc.Lrg = 2;
      boolean bool;
      if (!paramIResponse.getHasMore())
      {
        bool = true;
        localc.iLW = bool;
        ad.i(this.sbU.getTAG(), "[onFetchLoadMoreDone]  reason=".concat(String.valueOf(localc)));
        if (!paramIResponse.getHasMore()) {
          break label194;
        }
      }
      for (;;)
      {
        com.tencent.mm.ad.c.g((d.g.a.a)new a(this, new com.tencent.mm.plugin.finder.feed.model.internal.l(i, paramIResponse.getIncrementList(), false, 12), localc, paramb, paramIResponse));
        AppMethodBeat.o(202461);
        return;
        bool = false;
        break;
        label194:
        i = 5;
      }
    }
    
    public final void mergeRefresh(final IResponse<al> paramIResponse, final d.g.a.b<? super IResponse<al>, z> paramb)
    {
      AppMethodBeat.i(202460);
      d.g.b.p.h(paramIResponse, "response");
      final RefreshLoadMoreLayout.c localc = new RefreshLoadMoreLayout.c(paramIResponse.getPullType());
      Object localObject;
      boolean bool;
      if ((paramIResponse.getErrType() == 0) && (paramIResponse.getErrCode() == 0))
      {
        localc.Lrg = 1;
        localObject = this.sbU.sbS;
        if (localObject != null) {
          ((d.g.a.b)localObject).invoke(paramIResponse);
        }
        if (paramIResponse.getPullType() == 0) {
          break label262;
        }
        bool = true;
        label79:
        localc.iLW = bool;
        localc.Lri = paramIResponse.getHasMore();
        if ((localc.actionType == 0) || (localc.actionType == 4) || (localc.actionType == 1))
        {
          if ((localc.Lrj <= 0) && (this.sbU.getDataListJustForAdapter().size() > 0)) {
            break label268;
          }
          localc.Lrh = null;
        }
        label148:
        ad.i(this.sbU.getTAG(), "[onFetchRefreshDone]  reason=".concat(String.valueOf(localc)));
        if (!paramIResponse.getHasMore()) {
          break label303;
        }
      }
      label262:
      label268:
      label303:
      for (int i = 4;; i = 6)
      {
        com.tencent.mm.ad.c.g((d.g.a.a)new b(this, new com.tencent.mm.plugin.finder.feed.model.internal.l(i, paramIResponse.getIncrementList(), paramIResponse.isNeedClear(), 8), localc, paramb, paramIResponse));
        AppMethodBeat.o(202460);
        return;
        localObject = aj.getContext();
        d.g.b.p.g(localObject, "MMApplicationContext.getContext()");
        localc.Lrh = ((CharSequence)((Context)localObject).getResources().getString(2131766505));
        localc.Lrg = -1;
        break;
        bool = false;
        break label79;
        localObject = aj.getContext();
        d.g.b.p.g(localObject, "MMApplicationContext.getContext()");
        localc.Lrh = ((CharSequence)((Context)localObject).getResources().getString(2131766856));
        break label148;
      }
    }
    
    public final boolean needCleanWhenRefresh(List<? extends al> paramList)
    {
      AppMethodBeat.i(202467);
      d.g.b.p.h(paramList, "newList");
      AppMethodBeat.o(202467);
      return true;
    }
    
    @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
    static final class a
      extends q
      implements d.g.a.a<z>
    {
      a(FinderTimelineFeedLoader.e parame, com.tencent.mm.plugin.finder.feed.model.internal.l paraml, RefreshLoadMoreLayout.c paramc, d.g.a.b paramb, IResponse paramIResponse)
      {
        super();
      }
    }
    
    @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
    static final class b
      extends q
      implements d.g.a.a<z>
    {
      b(FinderTimelineFeedLoader.e parame, com.tencent.mm.plugin.finder.feed.model.internal.l paraml, RefreshLoadMoreLayout.c paramc, d.g.a.b paramb, IResponse paramIResponse)
      {
        super();
      }
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/finder/feed/model/FinderTimelineFeedLoader$recyclerView$1", "Landroid/view/View$OnAttachStateChangeListener;", "onViewAttachedToWindow", "", "v", "Landroid/view/View;", "onViewDetachedFromWindow", "plugin-finder_release"})
  public static final class g
    implements View.OnAttachStateChangeListener
  {
    public g(RecyclerView paramRecyclerView) {}
    
    public final void onViewAttachedToWindow(View paramView)
    {
      Object localObject1 = null;
      AppMethodBeat.i(202471);
      d.g.b.p.h(paramView, "v");
      paramView = com.tencent.mm.plugin.finder.storage.data.g.szT;
      Object localObject2 = this.scg.getAdapter();
      paramView = (View)localObject2;
      if (!(localObject2 instanceof WxRecyclerAdapter)) {
        paramView = null;
      }
      localObject2 = (WxRecyclerAdapter)paramView;
      paramView = localObject1;
      if (localObject2 != null) {
        paramView = ((WxRecyclerAdapter)localObject2).LvS;
      }
      com.tencent.mm.plugin.finder.storage.data.g.c(paramView);
      AppMethodBeat.o(202471);
    }
    
    public final void onViewDetachedFromWindow(View paramView)
    {
      Object localObject1 = null;
      AppMethodBeat.i(202470);
      d.g.b.p.h(paramView, "v");
      paramView = com.tencent.mm.plugin.finder.storage.data.g.szT;
      Object localObject2 = this.scg.getAdapter();
      paramView = (View)localObject2;
      if (!(localObject2 instanceof WxRecyclerAdapter)) {
        paramView = null;
      }
      localObject2 = (WxRecyclerAdapter)paramView;
      paramView = localObject1;
      if (localObject2 != null) {
        paramView = ((WxRecyclerAdapter)localObject2).LvS;
      }
      com.tencent.mm.plugin.finder.storage.data.g.b(paramView);
      AppMethodBeat.o(202470);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.model.FinderTimelineFeedLoader
 * JD-Core Version:    0.7.0.1
 */
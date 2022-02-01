package com.tencent.mm.plugin.finder.feed.model;

import android.arch.lifecycle.ViewModelProvider;
import android.os.SystemClock;
import android.support.v7.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.g.h;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.cgi.n.a;
import com.tencent.mm.plugin.finder.cgi.n.c;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.feed.model.internal.e;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.am;
import com.tencent.mm.plugin.finder.report.f.a;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.data.d;
import com.tencent.mm.plugin.finder.storage.data.d.a;
import com.tencent.mm.plugin.finder.storage.data.k;
import com.tencent.mm.plugin.finder.storage.data.k.a;
import com.tencent.mm.plugin.finder.viewmodel.FinderHomeTabStateVM;
import com.tencent.mm.plugin.finder.viewmodel.FinderHomeTabStateVM.a;
import com.tencent.mm.plugin.finder.viewmodel.FinderTabStreamUnreadVM;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.aov;
import com.tencent.mm.protocal.protobuf.arn;
import com.tencent.mm.protocal.protobuf.cwj;
import com.tencent.mm.sdk.platformtools.ae;
import d.g.b.q;
import d.l;
import d.v;
import d.z;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedDeque;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/feed/model/FinderTimelineFeedLoader;", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "scene", "Lcom/tencent/mm/plugin/finder/feed/model/internal/FinderLoaderScene;", "firstLoad", "", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Lcom/tencent/mm/plugin/finder/feed/model/internal/FinderLoaderScene;ILcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "extraDataOp", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "", "getExtraDataOp", "()Lkotlin/jvm/functions/Function1;", "setExtraDataOp", "(Lkotlin/jvm/functions/Function1;)V", "getFirstLoad", "()I", "setFirstLoad", "(I)V", "postFeedFlag", "", "getPostFeedFlag", "()Z", "setPostFeedFlag", "(Z)V", "value", "Landroid/support/v7/widget/RecyclerView;", "recyclerView", "getRecyclerView", "()Landroid/support/v7/widget/RecyclerView;", "setRecyclerView", "(Landroid/support/v7/widget/RecyclerView;)V", "getScene", "()Lcom/tencent/mm/plugin/finder/feed/model/internal/FinderLoaderScene;", "streamFetcher", "Lcom/tencent/mm/plugin/finder/cgi/fetcher/FinderTimelineFeedFetcher;", "getStreamFetcher", "()Lcom/tencent/mm/plugin/finder/cgi/fetcher/FinderTimelineFeedFetcher;", "bufferSize", "createDataFetch", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataFetch;", "createDataMerger", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataMerger;", "isObservePostEvent", "onDead", "onFetchDone", "response", "onFetchInsertedDone", "onPostStart", "localId", "", "isFromSns", "preloadMoreToBuffer", "callback", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataCallback;", "printVisibleFeeds", "", "hasVisibleFeeds", "Landroid/util/LongSparseArray;", "requestRefresh", "unreadList", "", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "TimelineDataFetcher", "TimelineInsertRequest", "TimelineRequest", "TimelineResponse", "plugin-finder_release"})
public final class FinderTimelineFeedLoader
  extends BaseFinderFeedLoader
{
  public RecyclerView gpr;
  private final e skD;
  public final com.tencent.mm.plugin.finder.cgi.fetcher.c skH;
  public boolean skI;
  public d.g.a.b<? super IResponse<am>, z> skJ;
  public int skK;
  
  public FinderTimelineFeedLoader(e parame, int paramInt, arn paramarn)
  {
    super(paramarn);
    AppMethodBeat.i(202957);
    this.skD = parame;
    this.skK = paramInt;
    this.skH = new com.tencent.mm.plugin.finder.cgi.fetcher.c(this.skD.value, paramarn);
    AppMethodBeat.o(202957);
  }
  
  public final com.tencent.mm.plugin.finder.feed.model.internal.g<am> createDataFetch()
  {
    AppMethodBeat.i(202948);
    com.tencent.mm.plugin.finder.feed.model.internal.g localg = (com.tencent.mm.plugin.finder.feed.model.internal.g)new a(this.skH, this.skD);
    AppMethodBeat.o(202948);
    return localg;
  }
  
  public final com.tencent.mm.plugin.finder.feed.model.internal.b<am> createDataMerger()
  {
    AppMethodBeat.i(202951);
    com.tencent.mm.plugin.finder.feed.model.internal.b localb = (com.tencent.mm.plugin.finder.feed.model.internal.b)new FinderTimelineFeedLoader.e(this);
    AppMethodBeat.o(202951);
    return localb;
  }
  
  public final void dH(List<? extends BaseFinderFeed> paramList)
  {
    AppMethodBeat.i(202950);
    paramList = new c(this.skK, paramList);
    if (paramList.shY) {}
    for (paramList.pullType = 4;; paramList.pullType = this.skK)
    {
      ae.i(getTAG(), "[requestRefresh] pullType=" + paramList.pullType + "  hasPrefetch=" + paramList.shX + " needToRefreshForPrefetch=" + paramList.shY);
      super.request(paramList, (com.tencent.mm.plugin.finder.feed.model.internal.f)this);
      if (this.skK == 0) {
        this.skK = 1;
      }
      AppMethodBeat.o(202950);
      return;
    }
  }
  
  public final boolean isObservePostEvent()
  {
    AppMethodBeat.i(202952);
    if (this.skD != e.slA)
    {
      com.tencent.mm.plugin.finder.storage.b localb = com.tencent.mm.plugin.finder.storage.b.sHP;
      if (((Number)com.tencent.mm.plugin.finder.storage.b.cIR().value()).intValue() == 1) {}
    }
    else
    {
      AppMethodBeat.o(202952);
      return true;
    }
    AppMethodBeat.o(202952);
    return false;
  }
  
  public final void onDead()
  {
    AppMethodBeat.i(202956);
    super.onDead();
    this.skH.rQs.dead();
    AppMethodBeat.o(202956);
  }
  
  public final void onFetchDone(IResponse<am> paramIResponse)
  {
    AppMethodBeat.i(202949);
    d.g.b.p.h(paramIResponse, "response");
    super.onFetchDone(paramIResponse);
    com.tencent.mm.ac.c.h((d.g.a.a)FinderTimelineFeedLoader.f.skW);
    AppMethodBeat.o(202949);
  }
  
  public final void onFetchInsertedDone(IResponse<am> paramIResponse)
  {
    AppMethodBeat.i(202955);
    d.g.b.p.h(paramIResponse, "response");
    Object localObject = paramIResponse.getRequest();
    if ((localObject instanceof b))
    {
      if (!((b)localObject).skR) {
        super.onFetchInsertedDone(paramIResponse);
      }
      ae.i(getTAG(), "[onFetchInsertedDone] isPrefetch=" + ((b)localObject).skR);
    }
    AppMethodBeat.o(202955);
  }
  
  public final void onPostStart(long paramLong)
  {
    AppMethodBeat.i(202954);
    super.onPostStart(paramLong);
    this.skI = true;
    ae.i(getTAG(), "onPostStart postFeedFlag true");
    AppMethodBeat.o(202954);
  }
  
  public final void onPostStart(long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(202953);
    super.onPostStart(paramLong, paramBoolean);
    this.skI = true;
    AppMethodBeat.o(202953);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/feed/model/FinderTimelineFeedLoader$TimelineDataFetcher;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataFetch;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycleKeeper;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycle;", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderTimelineStream$Callback;", "streamFetcher", "Lcom/tencent/mm/plugin/finder/cgi/fetcher/FinderTimelineFeedFetcher;", "scene", "Lcom/tencent/mm/plugin/finder/feed/model/internal/FinderLoaderScene;", "(Lcom/tencent/mm/plugin/finder/feed/model/FinderTimelineFeedLoader;Lcom/tencent/mm/plugin/finder/cgi/fetcher/FinderTimelineFeedFetcher;Lcom/tencent/mm/plugin/finder/feed/model/internal/FinderLoaderScene;)V", "taskExecutor", "Lcom/tencent/mm/loader/loader/SingleTaskExecutor;", "alive", "", "dead", "fetch", "request", "", "callback", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataCallback;", "fetchInit", "fetchLoadMore", "fetchRefresh", "keep", "p0", "onFetchDone", "info", "Lcom/tencent/mm/plugin/finder/feed/model/CgiFinderStreamResult;", "pullType", "", "plugin-finder_release"})
  public final class a
    extends com.tencent.mm.plugin.finder.feed.model.internal.g<am>
    implements n.a, com.tencent.mm.vending.e.b<com.tencent.mm.vending.e.a>
  {
    com.tencent.mm.loader.g.i sdq;
    private final e skD;
    final com.tencent.mm.plugin.finder.cgi.fetcher.c skH;
    
    public a(e parame)
    {
      AppMethodBeat.i(202932);
      this.skH = parame;
      this.skD = localObject;
      AppMethodBeat.o(202932);
    }
    
    public final void a(b paramb, int paramInt)
    {
      AppMethodBeat.i(202927);
      d.g.b.p.h(paramb, "info");
      AppMethodBeat.o(202927);
    }
    
    public final void alive()
    {
      AppMethodBeat.i(202929);
      super.alive();
      if (this.skD == e.slx)
      {
        this.sdq = ((PluginFinder)com.tencent.mm.kernel.g.ad(PluginFinder.class)).getFollowTlSingleExecutor();
        locali = this.sdq;
        if (locali != null)
        {
          ae.i("Loader.SingleTaskExecutor", "[clean] name=" + locali.name);
          locali.hiq.clear();
          AppMethodBeat.o(202929);
          return;
        }
        AppMethodBeat.o(202929);
        return;
      }
      com.tencent.mm.loader.g.i locali = new com.tencent.mm.loader.g.i("SingleExecutor#TabType=" + this.skH.dvm);
      locali.start();
      this.sdq = locali;
      AppMethodBeat.o(202929);
    }
    
    public final void dead()
    {
      AppMethodBeat.i(202930);
      super.dead();
      com.tencent.mm.loader.g.i locali = this.sdq;
      if (locali != null) {
        locali.reset();
      }
      this.sdq = null;
      AppMethodBeat.o(202930);
    }
    
    public final void fetch(final Object paramObject, com.tencent.mm.plugin.finder.feed.model.internal.f<am> paramf)
    {
      AppMethodBeat.i(202931);
      d.g.b.p.h(paramf, "callback");
      if ((paramObject instanceof FinderTimelineFeedLoader.c))
      {
        final long l = SystemClock.uptimeMillis();
        com.tencent.mm.loader.g.i locali = this.sdq;
        if (locali != null)
        {
          locali.a(new h((d.g.a.b)new a(this, paramObject, l, paramf)));
          AppMethodBeat.o(202931);
          return;
        }
      }
      AppMethodBeat.o(202931);
    }
    
    public final void fetchInit(com.tencent.mm.plugin.finder.feed.model.internal.f<am> paramf)
    {
      AppMethodBeat.i(202928);
      d.g.b.p.h(paramf, "callback");
      Object localObject2 = new LinkedList();
      Object localObject1 = com.tencent.mm.ui.component.a.KEX;
      localObject1 = ((FinderHomeTabStateVM)com.tencent.mm.ui.component.a.bi(PluginFinder.class).get(FinderHomeTabStateVM.class)).GH(this.skD.value);
      int i;
      Object localObject3;
      Object localObject4;
      Object localObject5;
      Object localObject6;
      label503:
      boolean bool;
      label520:
      label599:
      label635:
      long l;
      if (((FinderHomeTabStateVM.a)localObject1).tkA.isEmpty())
      {
        localObject1 = com.tencent.mm.plugin.finder.utils.p.sXz;
        i = com.tencent.mm.plugin.finder.utils.p.Gs(this.skD.value);
        localObject1 = k.sLb;
        localObject1 = com.tencent.mm.plugin.finder.utils.p.sXz;
        localObject1 = k.a.FR(com.tencent.mm.plugin.finder.utils.p.Gq(i));
        localObject3 = ((Iterable)localObject1).iterator();
        while (((Iterator)localObject3).hasNext())
        {
          localObject4 = (am)((Iterator)localObject3).next();
          if ((localObject4 instanceof BaseFinderFeed))
          {
            localObject5 = FinderTimelineFeedLoader.this.getContextObj();
            if (localObject5 != null)
            {
              localObject6 = com.tencent.mm.plugin.finder.report.i.syT;
              com.tencent.mm.plugin.finder.report.i.d(((am)localObject4).lP(), ((arn)localObject5).sch, ((BaseFinderFeed)localObject4).feedObject.getFeedObject().sessionBuffer);
            }
          }
        }
        localObject3 = FinderTimelineFeedLoader.this.getContextObj();
        if (localObject3 != null)
        {
          localObject4 = d.sKD;
          i = ((arn)localObject3).sch;
          localObject4 = (Iterable)localObject1;
          localObject3 = (Collection)new ArrayList();
          localObject4 = ((Iterable)localObject4).iterator();
          while (((Iterator)localObject4).hasNext())
          {
            localObject5 = ((Iterator)localObject4).next();
            if (((am)localObject5 instanceof BaseFinderFeed)) {
              ((Collection)localObject3).add(localObject5);
            }
          }
          localObject4 = (Iterable)localObject3;
          localObject3 = (Collection)new ArrayList(d.a.j.a((Iterable)localObject4, 10));
          localObject4 = ((Iterable)localObject4).iterator();
          while (((Iterator)localObject4).hasNext())
          {
            localObject5 = (am)((Iterator)localObject4).next();
            if (localObject5 == null)
            {
              paramf = new v("null cannot be cast to non-null type com.tencent.mm.plugin.finder.model.BaseFinderFeed");
              AppMethodBeat.o(202928);
              throw paramf;
            }
            ((Collection)localObject3).add(((BaseFinderFeed)localObject5).feedObject.getFeedObject());
          }
          d.a.i(i, (List)localObject3);
        }
        ((LinkedList)localObject2).addAll((Collection)localObject1);
        localObject1 = FinderTimelineFeedLoader.this.getContextObj();
        if (localObject1 != null)
        {
          localObject3 = com.tencent.mm.ui.component.a.KEX;
          localObject3 = (FinderTabStreamUnreadVM)com.tencent.mm.ui.component.a.bi(PluginFinder.class).get(FinderTabStreamUnreadVM.class);
          i = ((arn)localObject1).sch;
          localObject1 = com.tencent.mm.plugin.finder.utils.p.sXz;
          ((FinderTabStreamUnreadVM)localObject3).k(i, com.tencent.mm.plugin.finder.utils.p.a((List)localObject2, BaseFinderFeed.class));
        }
        localObject1 = com.tencent.mm.plugin.finder.report.f.syc;
        int j = this.skH.dvm;
        if (((Collection)localObject2).isEmpty()) {
          break label828;
        }
        i = 1;
        localObject1 = com.tencent.mm.plugin.finder.report.f.Fe(j);
        if (localObject1 != null)
        {
          if (i == 0) {
            break label833;
          }
          i = 1;
          ((f.a)localObject1).syB = i;
        }
        localObject1 = (am)d.a.j.jm((List)localObject2);
        localObject3 = getTAG();
        localObject4 = new StringBuilder("fetchInit tabType=").append(this.skH.dvm).append(" callInitData scene=").append(this.skD).append(", contextObj=");
        if (FinderTimelineFeedLoader.this.getContextObj() != null) {
          break label838;
        }
        bool = true;
        localObject4 = ((StringBuilder)localObject4).append(bool).append(" list first=");
        if (!(localObject1 instanceof BaseFinderFeed)) {
          break label844;
        }
        localObject1 = ((BaseFinderFeed)localObject1).feedObject.getNickName();
        localObject1 = ((StringBuilder)localObject4).append((String)localObject1).append(" => ");
        localObject4 = (am)d.a.j.jm((List)localObject2);
        if (localObject4 == null) {
          break label852;
        }
        l = ((am)localObject4).lP();
        label677:
        ae.i((String)localObject3, com.tencent.mm.ac.c.rp(l));
        localObject1 = new FinderTimelineFeedLoader.d(0, 0, "", (byte)0);
        localObject3 = (Iterable)localObject2;
        localObject2 = (Collection)new ArrayList();
        localObject3 = ((Iterable)localObject3).iterator();
      }
      label828:
      label833:
      label838:
      label844:
      label852:
      label862:
      for (;;)
      {
        label738:
        if (!((Iterator)localObject3).hasNext()) {
          break label864;
        }
        localObject4 = ((Iterator)localObject3).next();
        localObject5 = (am)localObject4;
        if ((localObject5 instanceof BaseFinderFeed)) {
          localObject6 = com.tencent.mm.plugin.finder.utils.p.sXz;
        }
        for (bool = com.tencent.mm.plugin.finder.utils.p.o(((BaseFinderFeed)localObject5).feedObject.getFeedObject());; bool = true)
        {
          if (!bool) {
            break label862;
          }
          ((Collection)localObject2).add(localObject4);
          break label738;
          ((LinkedList)localObject2).addAll((Collection)((FinderHomeTabStateVM.a)localObject1).tkA);
          break;
          i = 0;
          break label503;
          i = 0;
          break label520;
          bool = false;
          break label599;
          localObject1 = "";
          break label635;
          l = 0L;
          break label677;
        }
      }
      label864:
      ((FinderTimelineFeedLoader.d)localObject1).setIncrementList((List)localObject2);
      ((FinderTimelineFeedLoader.d)localObject1).setPullType(1000);
      paramf.onFetchDone((IResponse)localObject1);
      AppMethodBeat.o(202928);
    }
    
    public final void fetchLoadMore(com.tencent.mm.plugin.finder.feed.model.internal.f<am> paramf)
    {
      AppMethodBeat.i(202925);
      d.g.b.p.h(paramf, "callback");
      fetch(new FinderTimelineFeedLoader.c(2), paramf);
      AppMethodBeat.o(202925);
    }
    
    public final void fetchRefresh(com.tencent.mm.plugin.finder.feed.model.internal.f<am> paramf)
    {
      AppMethodBeat.i(202924);
      d.g.b.p.h(paramf, "callback");
      FinderTimelineFeedLoader.c localc = new FinderTimelineFeedLoader.c(FinderTimelineFeedLoader.this.skK);
      if (localc.shY) {}
      for (localc.pullType = 4;; localc.pullType = FinderTimelineFeedLoader.this.skK)
      {
        if (FinderTimelineFeedLoader.this.skK == 0) {
          FinderTimelineFeedLoader.this.skK = 1;
        }
        ae.i(getTAG(), "[requestRefresh] pullType=" + localc.pullType + "  hasPrefetch=" + localc.shX + " needToRefreshForPrefetch=" + localc.shY);
        fetch(localc, paramf);
        AppMethodBeat.o(202924);
        return;
      }
    }
    
    public final void keep(com.tencent.mm.vending.e.a parama)
    {
      AppMethodBeat.i(202926);
      d.g.b.p.h(parama, "p0");
      AppMethodBeat.o(202926);
    }
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "task", "Lcom/tencent/mm/loader/loader/SingleTask;", "invoke"})
    static final class a
      extends q
      implements d.g.a.b<h, z>
    {
      a(FinderTimelineFeedLoader.a parama, Object paramObject, long paramLong, com.tencent.mm.plugin.finder.feed.model.internal.f paramf)
      {
        super();
      }
      
      @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/finder/feed/model/FinderTimelineFeedLoader$TimelineDataFetcher$fetch$1$1$1", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderTimelineStream$Callback;", "onFetchDone", "", "info", "Lcom/tencent/mm/plugin/finder/feed/model/CgiFinderStreamResult;", "pullType", "", "plugin-finder_release"})
      public static final class a
        implements n.a
      {
        a(FinderTimelineFeedLoader.a.a parama, h paramh) {}
        
        public final void a(b paramb, int paramInt)
        {
          AppMethodBeat.i(202920);
          d.g.b.p.h(paramb, "info");
          FinderTimelineFeedLoader.d locald = new FinderTimelineFeedLoader.d(paramb.errType, paramb.errCode, paramb.errMsg, (byte)0);
          locald.setIncrementList((List)paramb.sjH);
          locald.setPullType(paramInt);
          locald.setHasMore(true);
          locald.setRequest(this.skN.skq);
          locald.skU = paramb.sjN;
          this.skN.skr.onFetchDone((IResponse)locald);
          this.skO.a(com.tencent.mm.loader.g.j.hiy);
          AppMethodBeat.o(202920);
        }
      }
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/feed/model/FinderTimelineFeedLoader$TimelineInsertRequest;", "Lcom/tencent/mm/plugin/finder/feed/model/FinderTimelineFeedLoader$TimelineRequest;", "pullType", "", "(I)V", "centerFeed", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "getCenterFeed", "()Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "setCenterFeed", "(Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;)V", "feed", "getFeed", "setFeed", "isConsume", "", "()Z", "setConsume", "(Z)V", "isPrefetch", "setPrefetch", "maxUnreadCount", "getMaxUnreadCount", "()I", "setMaxUnreadCount", "relatedEntranceInfo", "Lcom/tencent/mm/protocal/protobuf/FinderGetRelatedEntranceInfo;", "getRelatedEntranceInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderGetRelatedEntranceInfo;", "setRelatedEntranceInfo", "(Lcom/tencent/mm/protocal/protobuf/FinderGetRelatedEntranceInfo;)V", "toString", "", "plugin-finder_release"})
  public static final class b
    extends FinderTimelineFeedLoader.c
  {
    public aov rQW;
    public BaseFinderFeed rZB;
    public BaseFinderFeed rZP;
    public int skP = -1;
    boolean skQ = true;
    public boolean skR;
    
    public b()
    {
      super();
    }
    
    public final String toString()
    {
      AppMethodBeat.i(202933);
      Object localObject1 = new StringBuilder("feed=");
      Object localObject2 = this.rZB;
      if (localObject2 != null)
      {
        localObject2 = ((BaseFinderFeed)localObject2).feedObject;
        if (localObject2 == null) {}
      }
      for (long l = ((FinderItem)localObject2).getId();; l = 0L)
      {
        localObject1 = com.tencent.mm.ac.c.rp(l) + ", keepUnreadSize=" + this.skP;
        AppMethodBeat.o(202933);
        return localObject1;
      }
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/feed/model/FinderTimelineFeedLoader$TimelineRequest;", "", "pullType", "", "unreadList", "", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "(ILjava/util/List;)V", "hasPrefetch", "", "getHasPrefetch", "()Z", "setHasPrefetch", "(Z)V", "isPreloadMore", "setPreloadMore", "minDuration", "", "getMinDuration", "()J", "setMinDuration", "(J)V", "needToRefreshForPrefetch", "getNeedToRefreshForPrefetch", "setNeedToRefreshForPrefetch", "getPullType", "()I", "setPullType", "(I)V", "getUnreadList", "()Ljava/util/List;", "setUnreadList", "(Ljava/util/List;)V", "plugin-finder_release"})
  public static class c
  {
    int pullType;
    List<? extends BaseFinderFeed> rPN;
    public boolean shX;
    public boolean shY;
    public long skS;
    public boolean skT;
    
    public c(int paramInt, List<? extends BaseFinderFeed> paramList)
    {
      this.pullType = paramInt;
      this.rPN = paramList;
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/feed/model/FinderTimelineFeedLoader$TimelineResponse;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "errType", "", "errCode", "errMsg", "", "extraData", "", "(IILjava/lang/String;Ljava/lang/Object;)V", "dataBufferList", "Ljava/util/ArrayList;", "getDataBufferList", "()Ljava/util/ArrayList;", "setDataBufferList", "(Ljava/util/ArrayList;)V", "getExtraData", "()Ljava/lang/Object;", "setExtraData", "(Ljava/lang/Object;)V", "plugin-finder_release"})
  public static final class d
    extends IResponse<am>
  {
    public ArrayList<am> sjO;
    public Object skU = null;
    
    private d(int paramInt1, int paramInt2, String paramString)
    {
      super(paramInt2, paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.model.FinderTimelineFeedLoader
 * JD-Core Version:    0.7.0.1
 */
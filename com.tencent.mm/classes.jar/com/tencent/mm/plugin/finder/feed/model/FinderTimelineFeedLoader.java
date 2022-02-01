package com.tencent.mm.plugin.finder.feed.model;

import android.content.Context;
import android.content.res.Resources;
import android.os.SystemClock;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.LongSparseArray;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.hn;
import com.tencent.mm.loader.g.i;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.cgi.ab.a;
import com.tencent.mm.plugin.finder.cgi.ab.c;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader.a;
import com.tencent.mm.plugin.finder.feed.model.internal.DataBuffer;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.feed.model.internal.e;
import com.tencent.mm.plugin.finder.feed.model.internal.f;
import com.tencent.mm.plugin.finder.feed.model.internal.k;
import com.tencent.mm.plugin.finder.feed.model.internal.n;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.bo;
import com.tencent.mm.plugin.finder.model.d.a;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.plugin.finder.utils.y.a;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.atn;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.protocal.protobuf.dpc;
import com.tencent.mm.sdk.crash.CrashReportFactory;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.view.RefreshLoadMoreLayout.c;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.List<+Lcom.tencent.mm.plugin.finder.model.bo;>;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/feed/model/FinderTimelineFeedLoader;", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "scene", "Lcom/tencent/mm/plugin/finder/feed/model/internal/FinderLoaderScene;", "firstLoad", "", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Lcom/tencent/mm/plugin/finder/feed/model/internal/FinderLoaderScene;ILcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "extraDataOp", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "", "getExtraDataOp", "()Lkotlin/jvm/functions/Function1;", "setExtraDataOp", "(Lkotlin/jvm/functions/Function1;)V", "getFirstLoad", "()I", "setFirstLoad", "(I)V", "postFeedFlag", "", "getPostFeedFlag", "()Z", "setPostFeedFlag", "(Z)V", "value", "Landroid/support/v7/widget/RecyclerView;", "recyclerView", "getRecyclerView", "()Landroid/support/v7/widget/RecyclerView;", "setRecyclerView", "(Landroid/support/v7/widget/RecyclerView;)V", "getScene", "()Lcom/tencent/mm/plugin/finder/feed/model/internal/FinderLoaderScene;", "streamFetcher", "Lcom/tencent/mm/plugin/finder/cgi/fetcher/FinderTimelineFeedFetcher;", "getStreamFetcher", "()Lcom/tencent/mm/plugin/finder/cgi/fetcher/FinderTimelineFeedFetcher;", "bufferSize", "colletExtraPageName", "", "createDataFetch", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataFetch;", "createDataMerger", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataMerger;", "getPageName", "isObservePostEvent", "onDead", "onFetchDone", "response", "onFetchInsertedDone", "onPostStart", "localId", "", "isFromSns", "preloadMoreToBuffer", "callback", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataCallback;", "printVisibleFeeds", "", "hasVisibleFeeds", "Landroid/util/LongSparseArray;", "requestRefresh", "unreadList", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "TimelineDataFetcher", "TimelineInsertRequest", "TimelineRequest", "TimelineResponse", "plugin-finder_release"})
public final class FinderTimelineFeedLoader
  extends BaseFinderFeedLoader
{
  public RecyclerView hak;
  private final e tVT;
  final com.tencent.mm.plugin.finder.cgi.fetcher.c tXp;
  public boolean tXq;
  public kotlin.g.a.b<? super IResponse<bo>, kotlin.x> tXr;
  public int tXs;
  
  public FinderTimelineFeedLoader(e parame, int paramInt, bbn parambbn)
  {
    super(parambbn);
    AppMethodBeat.i(244907);
    this.tVT = parame;
    this.tXs = paramInt;
    this.tXp = new com.tencent.mm.plugin.finder.cgi.fetcher.c(this.tVT.value, parambbn);
    AppMethodBeat.o(244907);
  }
  
  public final List<Integer> colletExtraPageName()
  {
    AppMethodBeat.i(244906);
    Object localObject = new ArrayList();
    ((ArrayList)localObject).add(Integer.valueOf(4));
    localObject = (List)localObject;
    AppMethodBeat.o(244906);
    return localObject;
  }
  
  public final com.tencent.mm.plugin.finder.feed.model.internal.g<bo> createDataFetch()
  {
    AppMethodBeat.i(244896);
    com.tencent.mm.plugin.finder.feed.model.internal.g localg = (com.tencent.mm.plugin.finder.feed.model.internal.g)new a(this.tXp, this.tVT);
    AppMethodBeat.o(244896);
    return localg;
  }
  
  public final com.tencent.mm.plugin.finder.feed.model.internal.b<bo> createDataMerger()
  {
    AppMethodBeat.i(244899);
    com.tencent.mm.plugin.finder.feed.model.internal.b localb = (com.tencent.mm.plugin.finder.feed.model.internal.b)new e(this);
    AppMethodBeat.o(244899);
    return localb;
  }
  
  public final void dX(List<? extends BaseFinderFeed> paramList)
  {
    AppMethodBeat.i(244898);
    paramList = new c(this.tXs, paramList);
    if (paramList.tXC) {}
    for (paramList.pullType = 4;; paramList.pullType = this.tXs)
    {
      Log.i(getTAG(), "[requestRefresh] pullType=" + paramList.pullType + "  hasPrefetch=" + paramList.tXB + " needToRefreshForPrefetch=" + paramList.tXC);
      super.request(paramList, (f)this);
      if (this.tXs == 0) {
        this.tXs = 1;
      }
      AppMethodBeat.o(244898);
      return;
    }
  }
  
  public final int getPageName()
  {
    AppMethodBeat.i(244905);
    y localy = y.vXH;
    int i = y.LL(this.tVT.value);
    localy = y.vXH;
    i = y.LJ(i);
    AppMethodBeat.o(244905);
    return i;
  }
  
  public final boolean isObservePostEvent()
  {
    AppMethodBeat.i(244900);
    if (this.tVT != e.tYo)
    {
      com.tencent.mm.plugin.finder.storage.c localc = com.tencent.mm.plugin.finder.storage.c.vCb;
      if (((Number)com.tencent.mm.plugin.finder.storage.c.dsx().value()).intValue() == 1) {}
    }
    else
    {
      AppMethodBeat.o(244900);
      return true;
    }
    AppMethodBeat.o(244900);
    return false;
  }
  
  public final void onDead()
  {
    AppMethodBeat.i(244904);
    super.onDead();
    this.tXp.ttK.dead();
    AppMethodBeat.o(244904);
  }
  
  public final void onFetchDone(IResponse<bo> paramIResponse)
  {
    AppMethodBeat.i(244897);
    p.h(paramIResponse, "response");
    super.onFetchDone(paramIResponse);
    com.tencent.mm.ac.d.h((kotlin.g.a.a)FinderTimelineFeedLoader.f.tXH);
    AppMethodBeat.o(244897);
  }
  
  public final void onFetchInsertedDone(IResponse<bo> paramIResponse)
  {
    AppMethodBeat.i(244903);
    p.h(paramIResponse, "response");
    Object localObject = paramIResponse.getRequest();
    if ((localObject instanceof b))
    {
      if (!((b)localObject).tXA) {
        super.onFetchInsertedDone(paramIResponse);
      }
      Log.i(getTAG(), "[onFetchInsertedDone] isPrefetch=" + ((b)localObject).tXA);
    }
    AppMethodBeat.o(244903);
  }
  
  public final void onPostStart(long paramLong)
  {
    AppMethodBeat.i(244902);
    super.onPostStart(paramLong);
    this.tXq = true;
    Log.i(getTAG(), "onPostStart postFeedFlag true");
    AppMethodBeat.o(244902);
  }
  
  public final void onPostStart(long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(244901);
    super.onPostStart(paramLong, paramBoolean);
    this.tXq = true;
    AppMethodBeat.o(244901);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/feed/model/FinderTimelineFeedLoader$TimelineDataFetcher;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataFetch;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycleKeeper;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycle;", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderTimelineStream$Callback;", "streamFetcher", "Lcom/tencent/mm/plugin/finder/cgi/fetcher/FinderTimelineFeedFetcher;", "scene", "Lcom/tencent/mm/plugin/finder/feed/model/internal/FinderLoaderScene;", "(Lcom/tencent/mm/plugin/finder/feed/model/FinderTimelineFeedLoader;Lcom/tencent/mm/plugin/finder/cgi/fetcher/FinderTimelineFeedFetcher;Lcom/tencent/mm/plugin/finder/feed/model/internal/FinderLoaderScene;)V", "taskExecutor", "Lcom/tencent/mm/loader/loader/SingleTaskExecutor;", "alive", "", "dead", "fetch", "request", "", "callback", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataCallback;", "fetchInit", "fetchLoadMore", "fetchRefresh", "keep", "p0", "onFetchDone", "info", "Lcom/tencent/mm/plugin/finder/feed/model/CgiFinderStreamResult;", "pullType", "", "plugin-finder_release"})
  public final class a
    extends com.tencent.mm.plugin.finder.feed.model.internal.g<bo>
    implements ab.a, com.tencent.mm.vending.e.b<com.tencent.mm.vending.e.a>
  {
    i tMX;
    private final e tVT;
    final com.tencent.mm.plugin.finder.cgi.fetcher.c tXp;
    
    public a(e parame)
    {
      AppMethodBeat.i(244877);
      this.tXp = parame;
      this.tVT = localObject;
      AppMethodBeat.o(244877);
    }
    
    public final void a(b paramb, int paramInt)
    {
      AppMethodBeat.i(244872);
      p.h(paramb, "info");
      AppMethodBeat.o(244872);
    }
    
    public final void alive()
    {
      AppMethodBeat.i(244874);
      super.alive();
      if (this.tVT == e.tYk)
      {
        this.tMX = ((PluginFinder)com.tencent.mm.kernel.g.ah(PluginFinder.class)).getFollowTlSingleExecutor();
        locali = this.tMX;
        if (locali != null)
        {
          locali.clean();
          AppMethodBeat.o(244874);
          return;
        }
        AppMethodBeat.o(244874);
        return;
      }
      i locali = new i("SingleExecutor#TabType=" + this.tXp.dLS);
      locali.start();
      this.tMX = locali;
      AppMethodBeat.o(244874);
    }
    
    public final void dead()
    {
      AppMethodBeat.i(244875);
      super.dead();
      i locali = this.tMX;
      if (locali != null) {
        locali.reset();
      }
      this.tMX = null;
      AppMethodBeat.o(244875);
    }
    
    public final void fetch(final Object paramObject, f<bo> paramf)
    {
      AppMethodBeat.i(244876);
      p.h(paramf, "callback");
      if ((paramObject instanceof FinderTimelineFeedLoader.c))
      {
        final long l = SystemClock.uptimeMillis();
        i locali = this.tMX;
        if (locali != null)
        {
          locali.a(new com.tencent.mm.loader.g.h((kotlin.g.a.b)new a(this, paramObject, l, paramf)));
          AppMethodBeat.o(244876);
          return;
        }
      }
      AppMethodBeat.o(244876);
    }
    
    public final void fetchInit(f<bo> paramf)
    {
      AppMethodBeat.i(244873);
      p.h(paramf, "callback");
      Object localObject2 = y.a(y.vXH, this.tVT.value, FinderTimelineFeedLoader.this.getContextObj(), FinderTimelineFeedLoader.this.getPageName(), false, this.tXp.dLS, 8);
      Object localObject1 = com.tencent.mm.plugin.finder.report.h.veu;
      int i = this.tXp.dLS;
      boolean bool;
      Object localObject3;
      Object localObject4;
      label149:
      label183:
      long l;
      if (!((Collection)localObject2).isEmpty())
      {
        bool = true;
        com.tencent.mm.plugin.finder.report.h.an(i, bool);
        localObject1 = (bo)kotlin.a.j.kt((List)localObject2);
        localObject3 = getTAG();
        localObject4 = new StringBuilder("fetchInit tabType=").append(this.tXp.dLS).append(" callInitData scene=").append(this.tVT).append(", contextObj=");
        if (FinderTimelineFeedLoader.this.getContextObj() != null) {
          break label359;
        }
        bool = true;
        localObject4 = ((StringBuilder)localObject4).append(bool).append(" list first=");
        if (!(localObject1 instanceof BaseFinderFeed)) {
          break label364;
        }
        localObject1 = ((BaseFinderFeed)localObject1).feedObject.getNickName();
        localObject1 = ((StringBuilder)localObject4).append((String)localObject1).append(" => ");
        localObject4 = (bo)kotlin.a.j.kt((List)localObject2);
        if (localObject4 == null) {
          break label372;
        }
        l = ((bo)localObject4).lT();
        label222:
        Log.i((String)localObject3, com.tencent.mm.ac.d.zs(l));
        localObject1 = new FinderTimelineFeedLoader.d(0, 0, "", (byte)0);
        localObject3 = (Iterable)localObject2;
        localObject2 = (Collection)new ArrayList();
        localObject3 = ((Iterable)localObject3).iterator();
      }
      label283:
      label359:
      label364:
      label372:
      label381:
      for (;;)
      {
        if (!((Iterator)localObject3).hasNext()) {
          break label383;
        }
        localObject4 = ((Iterator)localObject3).next();
        bo localbo = (bo)localObject4;
        if ((localbo instanceof BaseFinderFeed)) {
          y localy = y.vXH;
        }
        for (bool = y.r(((BaseFinderFeed)localbo).feedObject.getFeedObject());; bool = true)
        {
          if (!bool) {
            break label381;
          }
          ((Collection)localObject2).add(localObject4);
          break label283;
          bool = false;
          break;
          bool = false;
          break label149;
          localObject1 = "";
          break label183;
          l = 0L;
          break label222;
        }
      }
      label383:
      ((FinderTimelineFeedLoader.d)localObject1).setIncrementList((List)localObject2);
      ((FinderTimelineFeedLoader.d)localObject1).setPullType(1000);
      paramf.onFetchDone((IResponse)localObject1);
      AppMethodBeat.o(244873);
    }
    
    public final void fetchLoadMore(f<bo> paramf)
    {
      AppMethodBeat.i(244870);
      p.h(paramf, "callback");
      fetch(new FinderTimelineFeedLoader.c(2), paramf);
      AppMethodBeat.o(244870);
    }
    
    public final void fetchRefresh(f<bo> paramf)
    {
      AppMethodBeat.i(244869);
      p.h(paramf, "callback");
      FinderTimelineFeedLoader.c localc = new FinderTimelineFeedLoader.c(FinderTimelineFeedLoader.this.tXs);
      if (localc.tXC) {}
      for (localc.pullType = 4;; localc.pullType = FinderTimelineFeedLoader.this.tXs)
      {
        if (FinderTimelineFeedLoader.this.tXs == 0) {
          FinderTimelineFeedLoader.this.tXs = 1;
        }
        Log.i(getTAG(), "[requestRefresh] pullType=" + localc.pullType + "  hasPrefetch=" + localc.tXB + " needToRefreshForPrefetch=" + localc.tXC);
        fetch(localc, paramf);
        AppMethodBeat.o(244869);
        return;
      }
    }
    
    public final void keep(com.tencent.mm.vending.e.a parama)
    {
      AppMethodBeat.i(244871);
      p.h(parama, "p0");
      AppMethodBeat.o(244871);
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "task", "Lcom/tencent/mm/loader/loader/SingleTask;", "invoke"})
    static final class a
      extends q
      implements kotlin.g.a.b<com.tencent.mm.loader.g.h, kotlin.x>
    {
      a(FinderTimelineFeedLoader.a parama, Object paramObject, long paramLong, f paramf)
      {
        super();
      }
      
      @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/feed/model/FinderTimelineFeedLoader$TimelineDataFetcher$fetch$1$1$1", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderTimelineStream$Callback;", "onFetchDone", "", "info", "Lcom/tencent/mm/plugin/finder/feed/model/CgiFinderStreamResult;", "pullType", "", "plugin-finder_release"})
      public static final class a
        implements ab.a
      {
        a(FinderTimelineFeedLoader.a.a parama, com.tencent.mm.loader.g.h paramh) {}
        
        public final void a(b paramb, int paramInt)
        {
          AppMethodBeat.i(244865);
          p.h(paramb, "info");
          FinderTimelineFeedLoader.d locald = new FinderTimelineFeedLoader.d(paramb.errType, paramb.errCode, paramb.errMsg, (byte)0);
          locald.setIncrementList((List)paramb.tUz);
          locald.setPullType(paramInt);
          locald.setHasMore(true);
          locald.setRequest(this.tXv.tVH);
          locald.tXF = paramb.tUF;
          this.tXv.tVx.onFetchDone((IResponse)locald);
          this.tXw.a(com.tencent.mm.loader.g.j.ibw);
          AppMethodBeat.o(244865);
        }
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/feed/model/FinderTimelineFeedLoader$TimelineInsertRequest;", "Lcom/tencent/mm/plugin/finder/feed/model/FinderTimelineFeedLoader$TimelineRequest;", "pullType", "", "(I)V", "centerFeed", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "getCenterFeed", "()Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "setCenterFeed", "(Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;)V", "feed", "getFeed", "setFeed", "isConsume", "", "()Z", "setConsume", "(Z)V", "isPrefetch", "setPrefetch", "maxUnreadCount", "getMaxUnreadCount", "()I", "setMaxUnreadCount", "relatedEntranceInfo", "Lcom/tencent/mm/protocal/protobuf/FinderGetRelatedEntranceInfo;", "getRelatedEntranceInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderGetRelatedEntranceInfo;", "setRelatedEntranceInfo", "(Lcom/tencent/mm/protocal/protobuf/FinderGetRelatedEntranceInfo;)V", "toString", "", "plugin-finder_release"})
  public static final class b
    extends FinderTimelineFeedLoader.c
  {
    public BaseFinderFeed tNO;
    public boolean tXA;
    public int tXx = -1;
    public BaseFinderFeed tXy;
    boolean tXz = true;
    public atn tuo;
    
    public b()
    {
      super();
    }
    
    public final String toString()
    {
      AppMethodBeat.i(244878);
      Object localObject1 = new StringBuilder("feed=");
      Object localObject2 = this.tNO;
      if (localObject2 != null)
      {
        localObject2 = ((BaseFinderFeed)localObject2).feedObject;
        if (localObject2 == null) {}
      }
      for (long l = ((FinderItem)localObject2).getId();; l = 0L)
      {
        localObject1 = com.tencent.mm.ac.d.zs(l) + ", keepUnreadSize=" + this.tXx;
        AppMethodBeat.o(244878);
        return localObject1;
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/feed/model/FinderTimelineFeedLoader$TimelineRequest;", "", "pullType", "", "unreadList", "", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "(ILjava/util/List;)V", "hasPrefetch", "", "getHasPrefetch", "()Z", "setHasPrefetch", "(Z)V", "isPreloadMore", "setPreloadMore", "minDuration", "", "getMinDuration", "()J", "setMinDuration", "(J)V", "needToRefreshForPrefetch", "getNeedToRefreshForPrefetch", "setNeedToRefreshForPrefetch", "getPullType", "()I", "setPullType", "(I)V", "getUnreadList", "()Ljava/util/List;", "setUnreadList", "(Ljava/util/List;)V", "plugin-finder_release"})
  public static class c
  {
    int pullType;
    boolean tXB;
    boolean tXC;
    long tXD;
    boolean tXE;
    List<? extends BaseFinderFeed> tsE;
    
    public c(int paramInt, List<? extends BaseFinderFeed> paramList)
    {
      this.pullType = paramInt;
      this.tsE = paramList;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/feed/model/FinderTimelineFeedLoader$TimelineResponse;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "errType", "", "errCode", "errMsg", "", "extraData", "", "(IILjava/lang/String;Ljava/lang/Object;)V", "dataBufferList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getDataBufferList", "()Ljava/util/ArrayList;", "setDataBufferList", "(Ljava/util/ArrayList;)V", "getExtraData", "()Ljava/lang/Object;", "setExtraData", "(Ljava/lang/Object;)V", "plugin-finder_release"})
  public static final class d
    extends IResponse<bo>
  {
    ArrayList<bo> tUG;
    public Object tXF = null;
    
    private d(int paramInt1, int paramInt2, String paramString)
    {
      super(paramInt2, paramString);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/feed/model/FinderTimelineFeedLoader$createDataMerger$1", "Lcom/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader$DefaultDataMerger;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "isDebug", "", "cleanDataList", "", "dataList", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataBuffer;", "finallyHandleMergeList", "srcList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "newList", "Ljava/util/LinkedList;", "insertIndex", "", "cmd", "request", "", "findMergeIndex", "", "mergeDataAndNotify", "Lcom/tencent/mm/plugin/finder/feed/model/internal/MergeResult;", "insList", "isNeedClear", "mergeInsert", "response", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "next", "Lkotlin/Function1;", "mergeLoadMore", "mergeRefresh", "needCleanWhenRefresh", "notifyLiveListChange", "liveStatus", "username", "", "onDataReplace", "feed", "existIndex", "updateLiveList", "plugin-finder_release"})
  public static final class e
    extends BaseFeedLoader<bo>.a
  {
    private final boolean cWq;
    
    e()
    {
      super();
      AppMethodBeat.i(244892);
      if ((BuildInfo.IS_FLAVOR_PURPLE) || (BuildInfo.IS_FLAVOR_RED) || (CrashReportFactory.hasDebuger())) {}
      for (boolean bool = true;; bool = false)
      {
        this.cWq = bool;
        AppMethodBeat.o(244892);
        return;
      }
    }
    
    private static void aY(int paramInt, String paramString)
    {
      AppMethodBeat.i(244885);
      Object localObject = (CharSequence)paramString;
      if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {}
      for (int i = 1;; i = 0)
      {
        if (i == 0)
        {
          localObject = new hn();
          ((hn)localObject).dLW.dLY = 0;
          ((hn)localObject).dLW.liveStatus = paramInt;
          ((hn)localObject).dLW.username = paramString;
          ((hn)localObject).dLW.type = 9;
          EventCenter.instance.publish((IEvent)localObject);
        }
        AppMethodBeat.o(244885);
        return;
      }
    }
    
    private final boolean dY(List<? extends bo> paramList)
    {
      Object localObject1 = null;
      com.tencent.mm.plugin.finder.model.x localx = null;
      bo localbo = null;
      boolean bool3 = false;
      boolean bool2 = false;
      AppMethodBeat.i(244886);
      Object localObject2 = ((List)this.tXt.getDataList()).iterator();
      int i = 0;
      int j;
      label67:
      label81:
      label107:
      boolean bool1;
      if (((Iterator)localObject2).hasNext()) {
        if (((bo)((Iterator)localObject2).next() instanceof com.tencent.mm.plugin.finder.model.x))
        {
          j = i;
          if (paramList == null) {
            break label286;
          }
          localObject2 = paramList.iterator();
          i = 0;
          if (!((Iterator)localObject2).hasNext()) {
            break label281;
          }
          if (!((bo)((Iterator)localObject2).next() instanceof com.tencent.mm.plugin.finder.model.x)) {
            break label274;
          }
          if ((j != -1) || (i == -1)) {
            break label291;
          }
          bool1 = bool2;
          if (paramList != null)
          {
            localObject1 = (bo)paramList.get(i);
            bool1 = bool2;
            if (localObject1 != null)
            {
              this.tXt.getDataList().add(0, localObject1);
              this.tXt.dispatcher().onItemRangeInserted(0, 1);
              paramList = com.tencent.mm.plugin.finder.model.d.uNN;
              if ((localObject1 instanceof com.tencent.mm.plugin.finder.model.x)) {
                break label784;
              }
            }
          }
        }
      }
      label515:
      label778:
      label784:
      for (paramList = null;; paramList = (List<? extends bo>)localObject1)
      {
        localx = (com.tencent.mm.plugin.finder.model.x)paramList;
        paramList = localbo;
        if (localx != null) {
          paramList = localx.dtS;
        }
        paramList = d.a.ag(paramList);
        aY(1, paramList);
        Log.i(this.tXt.getTAG(), "[updateLiveList] add " + localObject1 + ", live update:true, incrementUsernameString:" + paramList);
        bool1 = true;
        AppMethodBeat.o(244886);
        return bool1;
        i += 1;
        break;
        j = -1;
        break label67;
        label274:
        i += 1;
        break label81;
        label281:
        i = -1;
        break label107;
        label286:
        i = -1;
        break label107;
        label291:
        if ((j != -1) && (i == -1))
        {
          paramList = this.tXt.getDataList().remove(j);
          p.g(paramList, "dataList.removeAt(oriLiveItemIndex)");
          localbo = (bo)paramList;
          this.tXt.dispatcher().onItemRangeRemoved(j, 1);
          paramList = com.tencent.mm.plugin.finder.model.d.uNN;
          if ((localbo instanceof com.tencent.mm.plugin.finder.model.x)) {
            break label778;
          }
        }
        for (paramList = null;; paramList = localbo)
        {
          localx = (com.tencent.mm.plugin.finder.model.x)paramList;
          paramList = (List<? extends bo>)localObject1;
          if (localx != null) {
            paramList = localx.dtS;
          }
          paramList = d.a.ag(paramList);
          aY(2, paramList);
          Log.i(this.tXt.getTAG(), "[updateLiveList] remove " + localbo + ", live update:false, removeUsernameString:" + paramList);
          bool1 = bool2;
          break;
          bool1 = bool2;
          if (j == -1) {
            break;
          }
          bool1 = bool2;
          if (i == -1) {
            break;
          }
          bool1 = bool2;
          if (paramList == null) {
            break;
          }
          localbo = (bo)paramList.get(i);
          bool1 = bool2;
          if (localbo == null) {
            break;
          }
          paramList = com.tencent.mm.plugin.finder.model.d.uNN;
          localObject1 = this.tXt.getDataList().get(j);
          paramList = (List<? extends bo>)localObject1;
          if (!(localObject1 instanceof com.tencent.mm.plugin.finder.model.x)) {
            paramList = null;
          }
          paramList = (com.tencent.mm.plugin.finder.model.x)paramList;
          if (paramList != null)
          {
            paramList = paramList.dtS;
            if ((localbo instanceof com.tencent.mm.plugin.finder.model.x)) {
              break label771;
            }
          }
          for (localObject1 = null;; localObject1 = localbo)
          {
            localObject2 = (com.tencent.mm.plugin.finder.model.x)localObject1;
            localObject1 = localx;
            if (localObject2 != null) {
              localObject1 = ((com.tencent.mm.plugin.finder.model.x)localObject2).dtS;
            }
            paramList = d.a.f(paramList, (ArrayList)localObject1);
            localObject1 = (Collection)paramList.uNK;
            if ((localObject1 == null) || (((Collection)localObject1).isEmpty()))
            {
              i = 1;
              label582:
              if (i != 0)
              {
                localObject1 = (Collection)paramList.ofD;
                if ((localObject1 != null) && (!((Collection)localObject1).isEmpty())) {
                  break label747;
                }
              }
            }
            label747:
            for (i = 1;; i = 0)
            {
              bool1 = bool3;
              if (i == 0) {
                bool1 = true;
              }
              aY(1, paramList.uNL);
              aY(2, paramList.uNM);
              this.tXt.getDataList().set(j, localbo);
              Log.i(this.tXt.getTAG(), "[updateLiveList] replace " + localbo + ", live update:" + bool1 + ", incrememnt username:" + paramList.uNL + ",remove username:" + paramList.uNM);
              if (!bool1) {
                break label752;
              }
              this.tXt.dispatcher().IN(j);
              break;
              paramList = null;
              break label515;
              i = 0;
              break label582;
            }
            label752:
            this.tXt.dispatcher().onItemRangeChanged(j, 1, Integer.valueOf(1));
            break;
          }
        }
      }
    }
    
    public final void cleanDataList(DataBuffer<bo> paramDataBuffer)
    {
      AppMethodBeat.i(244883);
      p.h(paramDataBuffer, "dataList");
      super.cleanDataList(paramDataBuffer);
      AppMethodBeat.o(244883);
    }
    
    public final boolean finallyHandleMergeList(ArrayList<bo> paramArrayList, LinkedList<bo> paramLinkedList, int paramInt1, int paramInt2, Object paramObject)
    {
      AppMethodBeat.i(244890);
      p.h(paramArrayList, "srcList");
      p.h(paramLinkedList, "newList");
      long l;
      Object localObject1;
      Object localObject2;
      if ((paramInt2 == 8) && ((paramObject instanceof FinderTimelineFeedLoader.b)))
      {
        if ((paramInt1 <= 0) && (!((FinderTimelineFeedLoader.b)paramObject).tXz))
        {
          paramArrayList = com.tencent.mm.plugin.finder.storage.data.h.vGk;
          paramArrayList = ((FinderTimelineFeedLoader.b)paramObject).tNO;
          if (paramArrayList != null)
          {
            paramArrayList = paramArrayList.feedObject;
            if (paramArrayList == null) {}
          }
          for (l = paramArrayList.getId();; l = 0L)
          {
            com.tencent.mm.plugin.finder.storage.data.h.FM(l);
            paramArrayList = y.vXH;
            paramInt1 = this.tXt.tXp.dLS;
            paramArrayList = y.vXH;
            y.a(paramInt1, y.a((List)paramLinkedList, BaseFinderFeed.class), this.tXt.getContextObj());
            paramLinkedList.clear();
            AppMethodBeat.o(244890);
            return false;
          }
        }
        localObject1 = this.tXt.hak;
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
            localObject1 = ((WxRecyclerAdapter)localObject1).Rrx;
            if (localObject1 != null) {
              break label974;
            }
          }
          localObject1 = new LongSparseArray();
        }
      }
      label268:
      label289:
      label553:
      label942:
      label944:
      label968:
      label971:
      label974:
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
            break label364;
          }
          localObject4 = ((Iterator)localObject3).next();
          if (paramInt2 < 0) {
            kotlin.a.j.hxH();
          }
          if (((LongSparseArray)localObject1).indexOfKey(((bo)localObject4).lT()) < 0) {
            break label971;
          }
          paramInt1 = paramInt2;
        }
        for (;;)
        {
          paramInt2 += 1;
          break label289;
          localObject1 = null;
          break;
          localObject2 = new LinkedList();
          break label268;
          label364:
          if (paramInt1 >= 0) {}
          int j;
          Object localObject5;
          for (int i = localLinkedList.size() - paramInt1 - 1;; i = 0)
          {
            j = ((FinderTimelineFeedLoader.b)paramObject).tXx - i;
            localObject3 = new LinkedList();
            localObject4 = new LinkedList();
            ((LinkedList)localObject4).addAll((Collection)paramLinkedList);
            ((LinkedList)localObject4).addAll((Collection)localObject2);
            ((LinkedList)localObject3).addAll((Collection)localObject4);
            localObject2 = ((LinkedList)localObject3).iterator();
            p.g(localObject2, "increment.iterator()");
            paramInt2 = 0;
            for (;;)
            {
              if (!((Iterator)localObject2).hasNext()) {
                break label553;
              }
              localObject5 = ((Iterator)localObject2).next();
              p.g(localObject5, "iterator.next()");
              localObject5 = (bo)localObject5;
              if ((!(localObject5 instanceof BaseFinderFeed)) || (((LongSparseArray)localObject1).indexOfKey(((BaseFinderFeed)localObject5).feedObject.getId()) >= 0)) {
                break label968;
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
            p.g(localObject2, "after.subList(increment.size, after.size)");
            localObject5 = this.tXt.getTAG();
            StringBuilder localStringBuilder = new StringBuilder("[finallyHandleMergeList] feed=");
            Object localObject6 = ((FinderTimelineFeedLoader.b)paramObject).tNO;
            if (localObject6 != null)
            {
              localObject6 = ((BaseFinderFeed)localObject6).feedObject;
              if (localObject6 != null)
              {
                l = ((FinderItem)localObject6).getId();
                Log.i((String)localObject5, com.tencent.mm.ac.d.zs(l) + ' ' + "rawBefore=" + localLinkedList.size() + " raw=" + paramArrayList.size() + " readIndex=" + paramInt1 + " unreadCount=" + i + " maxUnreadCount=" + ((FinderTimelineFeedLoader.b)paramObject).tXx + " limitUnreadCount=" + j + ' ' + "afterSize=" + ((LinkedList)localObject4).size() + " incrementCount=" + ((LinkedList)localObject3).size() + " remain=" + ((List)localObject2).size() + ' ' + "hasVisibleFeeds=" + FinderTimelineFeedLoader.a((LongSparseArray)localObject1));
                paramArrayList.clear();
                paramArrayList.addAll((Collection)localLinkedList);
                paramLinkedList.clear();
                paramLinkedList.addAll((Collection)localObject3);
                paramArrayList = y.vXH;
                paramInt2 = this.tXt.tXp.dLS;
                paramLinkedList = (Iterable)localObject2;
                paramArrayList = (Collection)new ArrayList();
                paramLinkedList = paramLinkedList.iterator();
              }
            }
            for (;;)
            {
              label868:
              if (!paramLinkedList.hasNext()) {
                break label944;
              }
              paramObject = paramLinkedList.next();
              localObject2 = (bo)paramObject;
              if (((localObject2 instanceof BaseFinderFeed)) && (((LongSparseArray)localObject1).indexOfKey(((bo)localObject2).lT()) < 0)) {}
              for (paramInt1 = 1;; paramInt1 = 0)
              {
                if (paramInt1 == 0) {
                  break label942;
                }
                paramArrayList.add(paramObject);
                break label868;
                l = 0L;
                break;
              }
            }
            y.a(paramInt2, (List)paramArrayList, this.tXt.getContextObj());
            AppMethodBeat.o(244890);
            return true;
          }
        }
      }
    }
    
    public final int findMergeIndex(ArrayList<bo> paramArrayList, List<? extends bo> paramList, int paramInt, Object paramObject)
    {
      AppMethodBeat.i(244889);
      p.h(paramArrayList, "srcList");
      p.h(paramList, "newList");
      Object localObject1;
      long l;
      int i;
      label130:
      label138:
      label168:
      label203:
      label240:
      Object localObject2;
      label268:
      label315:
      int j;
      if ((paramInt == 8) && ((paramObject instanceof FinderTimelineFeedLoader.b)))
      {
        paramList = (List)paramArrayList;
        paramInt = 0;
        paramList = paramList.iterator();
        if (paramList.hasNext())
        {
          localObject1 = (bo)paramList.next();
          if ((localObject1 instanceof BaseFinderFeed))
          {
            l = ((BaseFinderFeed)localObject1).feedObject.getId();
            localObject1 = ((FinderTimelineFeedLoader.b)paramObject).tNO;
            if (localObject1 != null)
            {
              localObject1 = ((BaseFinderFeed)localObject1).feedObject;
              if ((localObject1 != null) && (l == ((FinderItem)localObject1).getId()))
              {
                i = 1;
                if (i == 0) {
                  break label526;
                }
                i = paramInt;
                paramList = ((FinderTimelineFeedLoader.b)paramObject).tXy;
                if (paramList == null) {
                  break label539;
                }
                paramList = paramList.feedObject;
                if (paramList == null) {
                  break label539;
                }
                paramList = Long.valueOf(paramList.getId());
                localObject1 = this.tXt.hak;
                if (localObject1 == null) {
                  break label544;
                }
                paramList = y.vXH;
                paramList = Long.valueOf(y.a((RecyclerView)localObject1, 0, 0, null, 14).feedId);
                localObject1 = ((FinderTimelineFeedLoader.b)paramObject).tNO;
                if (localObject1 == null) {
                  break label547;
                }
                localObject1 = ((BaseFinderFeed)localObject1).feedObject;
                if (localObject1 == null) {
                  break label547;
                }
                localObject1 = Long.valueOf(((FinderItem)localObject1).getId());
                if (!(p.j(paramList, localObject1) ^ true)) {
                  break label1110;
                }
                localObject1 = (List)paramArrayList;
                paramInt = 0;
                localObject1 = ((List)localObject1).iterator();
                if (!((Iterator)localObject1).hasNext()) {
                  break label576;
                }
                localObject2 = (bo)((Iterator)localObject1).next();
                if ((localObject2 instanceof BaseFinderFeed))
                {
                  l = ((BaseFinderFeed)localObject2).feedObject.getId();
                  if (paramList != null) {
                    break label553;
                  }
                }
                j = 0;
                label318:
                if (j == 0) {
                  break label569;
                }
                label323:
                Log.i(this.tXt.getTAG(), "[findMergeIndex] centerFeedId=" + i + " newCenterIndex=" + paramInt);
              }
            }
          }
        }
      }
      label526:
      label539:
      label544:
      label547:
      label553:
      label569:
      label576:
      label722:
      label1107:
      label1110:
      for (int m = paramInt;; m = i)
      {
        if (i != m) {
          com.tencent.mm.plugin.report.service.h.CyF.a(20198, new Object[] { Integer.valueOf(1) });
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
              break label645;
            }
            localObject1 = paramList.next();
            n = k + 1;
            if (k < 0) {
              kotlin.a.j.hxH();
            }
            localObject1 = (bo)localObject1;
            if ((!(localObject1 instanceof BaseFinderFeed)) || (k < i1) || (!((BaseFinderFeed)localObject1).feedObject.isRelatedItem())) {
              break;
            }
            paramInt += 1;
            if (j != 0) {
              break label1107;
            }
            k = n;
          }
          i = 0;
          break label130;
          paramInt += 1;
          break;
          i = -1;
          break label138;
          paramList = null;
          break label168;
          break label203;
          localObject1 = null;
          break label240;
          if (l != paramList.longValue()) {
            break label315;
          }
          j = 1;
          break label318;
          paramInt += 1;
          break label268;
          paramInt = -1;
          break label323;
          com.tencent.mm.plugin.report.service.h.CyF.a(20198, new Object[] { Integer.valueOf(2) });
        }
        label732:
        label766:
        boolean bool;
        if (((localObject1 instanceof BaseFinderFeed)) && (k >= i1) && (!((BaseFinderFeed)localObject1).feedObject.isRelatedItem()))
        {
          n = j;
          if (j == 0) {
            n = 1;
          }
          if (n != 2) {
            break label1043;
          }
          j = 0;
          k = paramInt + j;
          paramInt = -2;
          localObject2 = this.tXt.hak;
          if (localObject2 != null)
          {
            paramList = this.tXt.hak;
            if (paramList == null) {
              break label1049;
            }
            paramList = paramList.getLayoutManager();
            localObject1 = paramList;
            if (!(paramList instanceof LinearLayoutManager)) {
              localObject1 = null;
            }
            paramList = (LinearLayoutManager)localObject1;
            if (paramList == null) {
              break label1054;
            }
            paramInt = paramList.ks();
            if (paramList == null) {
              break label1059;
            }
            j = paramList.ku();
            paramList = y.vXH;
            localObject2 = y.a((RecyclerView)localObject2, paramInt, j, null, 8);
            paramList = this.tXt.hak;
            if (paramList == null) {
              break label1065;
            }
            paramList = paramList.getAdapter();
            localObject1 = paramList;
            if (!(paramList instanceof WxRecyclerAdapter)) {
              localObject1 = null;
            }
            paramList = (WxRecyclerAdapter)localObject1;
            if (paramList == null) {
              break label1070;
            }
            paramInt = paramList.RqM.size();
            paramInt = ((y.a)localObject2).vXK - paramInt;
            paramList = (FinderTimelineFeedLoader.b)paramObject;
            if (k <= paramInt) {
              break label1075;
            }
            bool = true;
            paramList.tXz = bool;
            if (!((FinderTimelineFeedLoader.b)paramObject).tXz) {
              Log.w(this.tXt.getTAG(), "[finallyHandleMergeList] insertIndex is invalid. resultIndex=" + k + " focusedPosition=" + paramInt);
            }
          }
          Log.i(this.tXt.getTAG(), "[findMergeIndex] tabType=" + this.tXt.tXp.dLS + " requestIndex=" + i + " centerIndex=" + m + " fixIndex=" + i1 + " resultIndex=" + k + ' ' + "focusedPosition=" + paramInt + " isConsume=" + ((FinderTimelineFeedLoader.b)paramObject).tXz + " size=" + paramArrayList.size() + " source=" + n + ' ');
          if (!((FinderTimelineFeedLoader.b)paramObject).tXz) {
            break label1081;
          }
          AppMethodBeat.o(244889);
          return k;
        }
        for (;;)
        {
          k = n;
          break;
          j = 1;
          break label654;
          paramList = null;
          break label694;
          paramInt = -1;
          break label722;
          j = -1;
          break label732;
          paramList = null;
          break label766;
          paramInt = 0;
          break label797;
          bool = false;
          break label820;
          AppMethodBeat.o(244889);
          return 0;
          paramInt = super.findMergeIndex(paramArrayList, paramList, paramInt, paramObject);
          AppMethodBeat.o(244889);
          return paramInt;
        }
      }
    }
    
    public final k mergeDataAndNotify(int paramInt, List<? extends bo> paramList, boolean paramBoolean, Object paramObject)
    {
      AppMethodBeat.i(244887);
      Object localObject1;
      label102:
      Object localObject2;
      label153:
      label204:
      label210:
      label216:
      label222:
      Iterator localIterator;
      if (((paramObject instanceof FinderTimelineFeedLoader.b)) && (this.tXt.hak != null))
      {
        localObject1 = ((FinderTimelineFeedLoader.b)paramObject).tNO;
        if (localObject1 != null)
        {
          localObject1 = ((BaseFinderFeed)localObject1).feedObject;
          if ((localObject1 != null) && (!((FinderItem)localObject1).isRelatedItem()))
          {
            localObject1 = ((FinderTimelineFeedLoader.b)paramObject).tNO;
            long l;
            int i;
            if (localObject1 != null)
            {
              l = ((BaseFinderFeed)localObject1).lT();
              localObject1 = this.tXt.hak;
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
              localObject1 = (com.tencent.mm.view.recyclerview.h)com.tencent.mm.view.recyclerview.g.c((com.tencent.mm.view.recyclerview.g)localObject1, l);
              if (localObject1 == null) {
                break label210;
              }
              i = ((com.tencent.mm.view.recyclerview.h)localObject1).lR();
              localObject1 = this.tXt.hak;
              if (localObject1 == null) {
                break label216;
              }
            }
            for (localObject1 = ((RecyclerView)localObject1).getLayoutManager();; localObject1 = null)
            {
              if (localObject1 != null) {
                break label222;
              }
              paramList = new t("null cannot be cast to non-null type android.support.v7.widget.LinearLayoutManager");
              AppMethodBeat.o(244887);
              throw paramList;
              l = 0L;
              break;
              localObject1 = null;
              break label102;
              i = -1;
              break label153;
            }
            localObject1 = (LinearLayoutManager)localObject1;
            int j = ((LinearLayoutManager)localObject1).ks();
            int k = ((LinearLayoutManager)localObject1).ku();
            if ((i >= 0) && (j <= i) && (i <= k))
            {
              bool = true;
              Log.i(this.tXt.getTAG(), "[mergeDataAndNotify] tabType=" + this.tXt.tXp.dLS + " position=" + i + " first=" + j + " last=" + k + " isConsume=" + bool);
              if (!bool) {
                break label525;
              }
              paramObject = super.mergeDataAndNotify(paramInt, paramList, paramBoolean, paramObject);
              if (!this.cWq) {
                break label516;
              }
              localObject1 = this.tXt.getTAG() + "#insert";
              paramList = (Iterable)this.tXt.getDataList();
              localObject2 = (Collection)new ArrayList(kotlin.a.j.a(paramList, 10));
              localIterator = paramList.iterator();
              label433:
              if (!localIterator.hasNext()) {
                break label503;
              }
              paramList = (bo)localIterator.next();
              if (!(paramList instanceof BaseFinderFeed)) {
                break label496;
              }
            }
            label496:
            for (paramList = com.tencent.mm.ac.d.zs(((BaseFinderFeed)paramList).feedObject.getFeedObject().id);; paramList = "")
            {
              ((Collection)localObject2).add(paramList);
              break label433;
              bool = false;
              break;
            }
            label503:
            Log.i((String)localObject1, String.valueOf((List)localObject2));
            label516:
            AppMethodBeat.o(244887);
            return paramObject;
            label525:
            if (paramList != null)
            {
              paramObject = com.tencent.mm.plugin.finder.storage.data.h.vGk;
              com.tencent.mm.plugin.finder.storage.data.h.FM(l);
              paramObject = y.vXH;
              paramInt = this.tXt.tXp.dLS;
              paramObject = y.vXH;
              y.a(paramInt, y.a(paramList, BaseFinderFeed.class), this.tXt.getContextObj());
            }
            paramList = new k(new LinkedList());
            AppMethodBeat.o(244887);
            return paramList;
          }
        }
      }
      if (!paramBoolean) {}
      for (boolean bool = dY(paramList);; bool = false)
      {
        localObject2 = super.mergeDataAndNotify(paramInt, paramList, paramBoolean, paramObject);
        localObject1 = localObject2;
        if (paramList != null)
        {
          localObject1 = localObject2;
          if (!paramBoolean)
          {
            localObject1 = localObject2;
            if (paramInt == 4)
            {
              Log.i(this.tXt.getTAG(), "isNeedClear false, manual merge...");
              localObject1 = merge(paramList, 1, paramObject);
              ((k)localObject1).tYD = 0;
            }
          }
        }
        if (this.cWq)
        {
          if (!(paramObject instanceof FinderTimelineFeedLoader.b)) {
            break label856;
          }
          paramObject = this.tXt.getTAG() + "#insert";
          paramList = (Iterable)this.tXt.getDataList();
          localObject2 = (Collection)new ArrayList(kotlin.a.j.a(paramList, 10));
          localIterator = paramList.iterator();
          if (localIterator.hasNext())
          {
            paramList = (bo)localIterator.next();
            if ((paramList instanceof BaseFinderFeed)) {}
            for (paramList = com.tencent.mm.ac.d.zs(((BaseFinderFeed)paramList).feedObject.getFeedObject().id);; paramList = "")
            {
              ((Collection)localObject2).add(paramList);
              break;
            }
          }
          Log.i(paramObject, String.valueOf((List)localObject2));
        }
        for (;;)
        {
          ((k)localObject1).tYG |= bool;
          AppMethodBeat.o(244887);
          return localObject1;
          label856:
          if ((this.tXt.tXp.dLS == 4) && (paramInt == 1))
          {
            paramObject = this.tXt.getTAG() + "#loadMore";
            paramList = (Iterable)this.tXt.getDataList();
            localObject2 = (Collection)new ArrayList(kotlin.a.j.a(paramList, 10));
            localIterator = paramList.iterator();
            if (localIterator.hasNext())
            {
              paramList = (bo)localIterator.next();
              if ((paramList instanceof BaseFinderFeed)) {}
              for (paramList = com.tencent.mm.ac.d.zs(((BaseFinderFeed)paramList).feedObject.getFeedObject().id);; paramList = "")
              {
                ((Collection)localObject2).add(paramList);
                break;
              }
            }
            Log.i(paramObject, String.valueOf((List)localObject2));
          }
          else if ((this.tXt.tXp.dLS == 4) && (paramInt == 4))
          {
            paramObject = this.tXt.getTAG() + "#refresh";
            paramList = (Iterable)this.tXt.getDataList();
            localObject2 = (Collection)new ArrayList(kotlin.a.j.a(paramList, 10));
            localIterator = paramList.iterator();
            if (localIterator.hasNext())
            {
              paramList = (bo)localIterator.next();
              if ((paramList instanceof BaseFinderFeed)) {}
              for (paramList = com.tencent.mm.ac.d.zs(((BaseFinderFeed)paramList).feedObject.getFeedObject().id);; paramList = "")
              {
                ((Collection)localObject2).add(paramList);
                break;
              }
            }
            Log.i(paramObject, String.valueOf((List)localObject2));
          }
        }
      }
    }
    
    public final void mergeInsert(IResponse<bo> paramIResponse, kotlin.g.a.b<? super IResponse<bo>, kotlin.x> paramb)
    {
      AppMethodBeat.i(244884);
      p.h(paramIResponse, "response");
      Object localObject = paramIResponse.getRequest();
      if ((localObject instanceof FinderTimelineFeedLoader.b))
      {
        if (!((FinderTimelineFeedLoader.b)localObject).tXA) {
          super.mergeInsert(paramIResponse, paramb);
        }
        Log.i(this.tXt.getTAG(), "[onFetchInsertedDone] isPrefetch=" + ((FinderTimelineFeedLoader.b)localObject).tXA);
      }
      AppMethodBeat.o(244884);
    }
    
    public final void mergeLoadMore(final IResponse<bo> paramIResponse, final kotlin.g.a.b<? super IResponse<bo>, kotlin.x> paramb)
    {
      int i = 1;
      AppMethodBeat.i(244882);
      p.h(paramIResponse, "response");
      if ((paramIResponse instanceof FinderTimelineFeedLoader.d)) {
        this.tXt.getDataListJustForAdapter().setBuffer((Collection)((FinderTimelineFeedLoader.d)paramIResponse).tUG);
      }
      final RefreshLoadMoreLayout.c localc = new RefreshLoadMoreLayout.c(paramIResponse.getPullType());
      localc.Rmj = paramIResponse.getHasMore();
      Context localContext = MMApplicationContext.getContext();
      p.g(localContext, "MMApplicationContext.getContext()");
      localc.Rmi = ((CharSequence)localContext.getResources().getString(2131760624));
      localc.Rmh = 2;
      boolean bool;
      if (!paramIResponse.getHasMore())
      {
        bool = true;
        localc.jLE = bool;
        Log.i(this.tXt.getTAG(), "[onFetchLoadMoreDone]  reason=".concat(String.valueOf(localc)));
        if (!paramIResponse.getHasMore()) {
          break label194;
        }
      }
      for (;;)
      {
        com.tencent.mm.ac.d.h((kotlin.g.a.a)new a(this, new n(i, paramIResponse.getIncrementList(), false, 12), localc, paramb, paramIResponse));
        AppMethodBeat.o(244882);
        return;
        bool = false;
        break;
        label194:
        i = 5;
      }
    }
    
    public final void mergeRefresh(final IResponse<bo> paramIResponse, final kotlin.g.a.b<? super IResponse<bo>, kotlin.x> paramb)
    {
      AppMethodBeat.i(244881);
      p.h(paramIResponse, "response");
      final RefreshLoadMoreLayout.c localc = new RefreshLoadMoreLayout.c(paramIResponse.getPullType());
      Object localObject;
      boolean bool;
      if ((paramIResponse.getErrType() == 0) && (paramIResponse.getErrCode() == 0))
      {
        localc.Rmh = 1;
        localObject = this.tXt.tXr;
        if (localObject != null) {
          ((kotlin.g.a.b)localObject).invoke(paramIResponse);
        }
        if (paramIResponse.getPullType() == 0) {
          break label262;
        }
        bool = true;
        label79:
        localc.jLE = bool;
        localc.Rmj = paramIResponse.getHasMore();
        if ((localc.actionType == 0) || (localc.actionType == 4) || (localc.actionType == 1))
        {
          if ((localc.Rmk <= 0) && (this.tXt.getDataListJustForAdapter().size() > 0)) {
            break label268;
          }
          localc.Rmi = null;
        }
        label148:
        Log.i(this.tXt.getTAG(), "[onFetchRefreshDone]  reason=".concat(String.valueOf(localc)));
        if (!paramIResponse.getHasMore()) {
          break label303;
        }
      }
      label262:
      label268:
      label303:
      for (int i = 4;; i = 6)
      {
        com.tencent.mm.ac.d.h((kotlin.g.a.a)new b(this, new n(i, paramIResponse.getIncrementList(), paramIResponse.isNeedClear(), 8), localc, paramb, paramIResponse));
        AppMethodBeat.o(244881);
        return;
        localObject = MMApplicationContext.getContext();
        p.g(localObject, "MMApplicationContext.getContext()");
        localc.Rmi = ((CharSequence)((Context)localObject).getResources().getString(2131760634));
        localc.Rmh = -1;
        break;
        bool = false;
        break label79;
        localObject = MMApplicationContext.getContext();
        p.g(localObject, "MMApplicationContext.getContext()");
        localc.Rmi = ((CharSequence)((Context)localObject).getResources().getString(2131760635));
        break label148;
      }
    }
    
    public final boolean needCleanWhenRefresh(List<? extends bo> paramList)
    {
      AppMethodBeat.i(244891);
      p.h(paramList, "newList");
      AppMethodBeat.o(244891);
      return true;
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
    static final class a
      extends q
      implements kotlin.g.a.a<kotlin.x>
    {
      a(FinderTimelineFeedLoader.e parame, n paramn, RefreshLoadMoreLayout.c paramc, kotlin.g.a.b paramb, IResponse paramIResponse)
      {
        super();
      }
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
    static final class b
      extends q
      implements kotlin.g.a.a<kotlin.x>
    {
      b(FinderTimelineFeedLoader.e parame, n paramn, RefreshLoadMoreLayout.c paramc, kotlin.g.a.b paramb, IResponse paramIResponse)
      {
        super();
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/feed/model/FinderTimelineFeedLoader$recyclerView$1", "Landroid/view/View$OnAttachStateChangeListener;", "onViewAttachedToWindow", "", "v", "Landroid/view/View;", "onViewDetachedFromWindow", "plugin-finder_release"})
  public static final class g
    implements View.OnAttachStateChangeListener
  {
    public g(RecyclerView paramRecyclerView) {}
    
    public final void onViewAttachedToWindow(View paramView)
    {
      Object localObject1 = null;
      AppMethodBeat.i(244895);
      p.h(paramView, "v");
      paramView = com.tencent.mm.plugin.finder.storage.data.h.vGk;
      Object localObject2 = this.tXI.getAdapter();
      paramView = (View)localObject2;
      if (!(localObject2 instanceof WxRecyclerAdapter)) {
        paramView = null;
      }
      localObject2 = (WxRecyclerAdapter)paramView;
      paramView = localObject1;
      if (localObject2 != null) {
        paramView = ((WxRecyclerAdapter)localObject2).Rrx;
      }
      com.tencent.mm.plugin.finder.storage.data.h.c(paramView);
      AppMethodBeat.o(244895);
    }
    
    public final void onViewDetachedFromWindow(View paramView)
    {
      Object localObject1 = null;
      AppMethodBeat.i(244894);
      p.h(paramView, "v");
      paramView = com.tencent.mm.plugin.finder.storage.data.h.vGk;
      Object localObject2 = this.tXI.getAdapter();
      paramView = (View)localObject2;
      if (!(localObject2 instanceof WxRecyclerAdapter)) {
        paramView = null;
      }
      localObject2 = (WxRecyclerAdapter)paramView;
      paramView = localObject1;
      if (localObject2 != null) {
        paramView = ((WxRecyclerAdapter)localObject2).Rrx;
      }
      com.tencent.mm.plugin.finder.storage.data.h.b(paramView);
      AppMethodBeat.o(244894);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.model.FinderTimelineFeedLoader
 * JD-Core Version:    0.7.0.1
 */
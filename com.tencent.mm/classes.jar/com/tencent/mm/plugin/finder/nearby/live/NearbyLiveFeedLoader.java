package com.tencent.mm.plugin.finder.nearby.live;

import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.f.g;
import com.tencent.mm.model.cn;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.cgi.ar.c;
import com.tencent.mm.plugin.finder.cgi.bg;
import com.tencent.mm.plugin.finder.feed.au;
import com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader.a;
import com.tencent.mm.plugin.finder.feed.model.internal.DataBuffer;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.aa;
import com.tencent.mm.plugin.finder.model.bn;
import com.tencent.mm.plugin.finder.model.cc;
import com.tencent.mm.plugin.finder.model.x;
import com.tencent.mm.plugin.finder.nearby.preload.firstpage.a.a;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.data.k.a;
import com.tencent.mm.plugin.finder.storage.data.r;
import com.tencent.mm.plugin.finder.utils.av;
import com.tencent.mm.plugin.finder.viewmodel.n.a;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.bch;
import com.tencent.mm.protocal.protobuf.bip;
import com.tencent.mm.protocal.protobuf.bnn;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.protocal.protobuf.esc;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.component.k.b;
import com.tencent.mm.view.RefreshLoadMoreLayout.d;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.ah;
import kotlin.g.a.b<-Lcom.tencent.mm.plugin.finder.feed.model.internal.IResponse<Lcom.tencent.mm.plugin.finder.model.cc;>;Lkotlin.ah;>;
import kotlin.g.b.ah.d;
import kotlin.g.b.ah.f;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/nearby/live/NearbyLiveFeedLoader;", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "commentScene", "", "tabType", "localTypeFlag", "by_pass", "", "(Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;IIILjava/lang/String;)V", "getBy_pass", "()Ljava/lang/String;", "getCommentScene", "()I", "dataFetcher", "Lcom/tencent/mm/plugin/finder/nearby/live/NearbyLiveFeedLoader$FinderLiveDataFetcher;", "fetchEndCallback", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "", "getFetchEndCallback", "()Lkotlin/jvm/functions/Function1;", "setFetchEndCallback", "(Lkotlin/jvm/functions/Function1;)V", "fileCacheFlag", "finderStreamCardFeed", "Lcom/tencent/mm/plugin/finder/feed/FinderStreamCardFeed;", "initForceRequestSever", "", "initLastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "isFetchMoreFollowFeed", "isFetchingLoadMore", "lastResponseBuffer", "memoryCacheFlag", "objectId", "", "recommendFeedList", "Ljava/util/LinkedList;", "refreshPullType", "tabInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLiveTabInfo;", "getTabType", "checkIfAddOldRecommendList", "isFetchFollowMoreResp", "hasMoreFollowList", "checkIfClearRecommendList", "checkIfSaveRecommendList", "recommendList", "checkIfSetFetchMoreFollowFeed", "invokeSource", "createDataFetch", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataFetch;", "createDataMerger", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataMerger;", "getFinderStreamCardFeed", "getRefreshLastBuffer", "onFetchDone", "response", "requestInit", "requestLoadMore", "requestMoreFollowFeed", "finderStreamCard", "requestRefresh", "pullType", "lastBuffer", "forceRequestSever", "CgiConsumeCallback", "FinderLiveDataFetcher", "FinderLiveFriendsRequest", "FinderLiveFriendsResponse", "plugin-finder-nearby_release"}, k=1, mv={1, 5, 1}, xi=48)
public class NearbyLiveFeedLoader
  extends BaseFinderFeedLoader
{
  final int AJo;
  private com.tencent.mm.bx.b BiQ;
  final String EIo;
  private int EIp;
  private bnn EIq;
  int EIr;
  private int EIs;
  com.tencent.mm.bx.b EIt;
  private boolean EIu;
  private boolean EIv;
  private LinkedList<cc> EIw;
  boolean EIx;
  b EIy;
  au EIz;
  kotlin.g.a.b<? super IResponse<cc>, ah> fetchEndCallback;
  final int hJx;
  private long hKN;
  
  public NearbyLiveFeedLoader(bui parambui, int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    super(parambui);
    AppMethodBeat.i(340877);
    this.AJo = paramInt1;
    this.hJx = paramInt2;
    this.EIo = paramString;
    this.EIp = 1;
    this.EIr = this.hJx;
    this.EIs = paramInt3;
    this.EIw = new LinkedList();
    this.EIy = new b();
    setTAG(s.X("NearbyLiveFeedLoader.", Integer.valueOf(this.AJo)));
    AppMethodBeat.o(340877);
  }
  
  public final void a(int paramInt1, int paramInt2, bnn parambnn)
  {
    AppMethodBeat.i(340986);
    this.EIr = paramInt1;
    this.EIs = paramInt2;
    this.EIq = parambnn;
    super.requestInit(false);
    AppMethodBeat.o(340986);
  }
  
  public final void a(bnn parambnn, int paramInt, com.tencent.mm.bx.b paramb, boolean paramBoolean, long paramLong)
  {
    AppMethodBeat.i(340992);
    com.tencent.mm.plugin.finder.nearby.trace.b.a locala = com.tencent.mm.plugin.finder.nearby.trace.b.ERu;
    com.tencent.mm.plugin.finder.nearby.trace.b.a.Rm(this.EIr).ERw = System.currentTimeMillis();
    this.EIy.ama("requestRefresh");
    this.EIq = parambnn;
    this.EIp = paramInt;
    this.hKN = paramLong;
    this.BiQ = paramb;
    this.EIu = paramBoolean;
    super.requestRefresh();
    this.EIx = false;
    AppMethodBeat.o(340992);
  }
  
  public com.tencent.mm.plugin.finder.feed.model.internal.i<cc> createDataFetch()
  {
    return (com.tencent.mm.plugin.finder.feed.model.internal.i)this.EIy;
  }
  
  public com.tencent.mm.plugin.finder.feed.model.internal.d<cc> createDataMerger()
  {
    AppMethodBeat.i(340971);
    com.tencent.mm.plugin.finder.feed.model.internal.d locald = (com.tencent.mm.plugin.finder.feed.model.internal.d)new e(this);
    AppMethodBeat.o(340971);
    return locald;
  }
  
  public void onFetchDone(final IResponse<cc> paramIResponse)
  {
    AppMethodBeat.i(340979);
    s.u(paramIResponse, "response");
    com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new f(this, paramIResponse));
    Object localObject = com.tencent.mm.plugin.finder.nearby.report.b.EQs;
    int i = this.hJx;
    localObject = com.tencent.mm.plugin.finder.nearby.report.b.Rb(i);
    if (localObject != null)
    {
      Log.i("FinderNearbyLiveLoadingReporter", s.X("onDbStart tabType: ", Integer.valueOf(i)));
      ((com.tencent.mm.plugin.finder.nearby.report.b.a)localObject).EQE = cn.bDw();
    }
    super.onFetchDone(paramIResponse);
    localObject = com.tencent.mm.plugin.finder.nearby.report.b.EQs;
    i = this.hJx;
    localObject = com.tencent.mm.plugin.finder.nearby.report.b.Rb(i);
    if (localObject != null)
    {
      Log.i("FinderNearbyLiveLoadingReporter", s.X("onDbEnd tabType: ", Integer.valueOf(i)));
      ((com.tencent.mm.plugin.finder.nearby.report.b.a)localObject).EQF = cn.bDw();
      localObject = com.tencent.mm.plugin.finder.nearby.report.b.EQs;
      localObject = com.tencent.mm.plugin.finder.nearby.report.b.Rb(i);
      if (localObject != null)
      {
        ((com.tencent.mm.plugin.finder.nearby.report.b.a)localObject).EQG = cn.bDw();
        Log.i("FinderNearbyLiveLoadingReporter", s.X("onUIShowBegin tabType: ", Integer.valueOf(i)));
      }
    }
    localObject = com.tencent.mm.plugin.finder.nearby.trace.b.ERu;
    com.tencent.mm.plugin.finder.nearby.trace.b.a.Rm(this.EIr).ERz = System.currentTimeMillis();
    localObject = com.tencent.mm.plugin.finder.nearby.trace.c.ERD;
    com.tencent.mm.plugin.finder.nearby.trace.c.eGR().aDn("fetchLivesDone");
    if (isInitOperation(paramIResponse))
    {
      AppMethodBeat.o(340979);
      return;
    }
    AppMethodBeat.o(340979);
  }
  
  public void requestLoadMore(bnn parambnn)
  {
    AppMethodBeat.i(340997);
    if (this.EIx)
    {
      Log.i(getTAG(), "requestLoadMore return for isFetchingLoadMore");
      this.EIy.ama("requestLoadMore");
    }
    Log.i(getTAG(), s.X("requestLoadMore isFetchMoreFollowFeed:", Boolean.valueOf(this.EIv)));
    this.EIq = parambnn;
    if (this.EIv)
    {
      this.EIq = parambnn;
      super.requestInsert(new c(2, parambnn, this.EIt, this.EIr, this.hJx, this.AJo, this.EIo, 1, 0L, 256));
    }
    for (;;)
    {
      this.EIx = true;
      AppMethodBeat.o(340997);
      return;
      super.requestLoadMore(false);
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/nearby/live/NearbyLiveFeedLoader$CgiConsumeCallback;", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderTimelineStream$ConsumeCallback;", "taskExecutor", "Lcom/tencent/mm/loader/loader/SingleTaskExecutor;", "task", "Lcom/tencent/mm/loader/loader/SingleTask;", "(Lcom/tencent/mm/loader/loader/SingleTaskExecutor;Lcom/tencent/mm/loader/loader/SingleTask;)V", "getTask", "()Lcom/tencent/mm/loader/loader/SingleTask;", "getTaskExecutor", "()Lcom/tencent/mm/loader/loader/SingleTaskExecutor;", "isFetchConsume", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/ResponseProtoBuf;", "plugin-finder-nearby_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements ar.c
  {
    private final com.tencent.mm.loader.f.h ADY;
    final g Bgh;
    
    public a(com.tencent.mm.loader.f.h paramh, g paramg)
    {
      AppMethodBeat.i(340733);
      this.ADY = paramh;
      this.Bgh = paramg;
      AppMethodBeat.o(340733);
    }
    
    public final boolean b(esc paramesc)
    {
      AppMethodBeat.i(340740);
      s.u(paramesc, "resp");
      if ((this.ADY != null) && (this.ADY.nrw != this.Bgh.nrw))
      {
        this.Bgh.a(com.tencent.mm.loader.f.i.nrG);
        Log.w("CgiConsumeCallback", "[isFetchConsume] executorToken=" + this.ADY.nrw + " taskToken=" + this.Bgh.nrw);
        AppMethodBeat.o(340740);
        return true;
      }
      AppMethodBeat.o(340740);
      return false;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/nearby/live/NearbyLiveFeedLoader$FinderLiveDataFetcher;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataFetch;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "(Lcom/tencent/mm/plugin/finder/nearby/live/NearbyLiveFeedLoader;)V", "callBack", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataCallback;", "getCallBack", "()Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataCallback;", "setCallBack", "(Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataCallback;)V", "fetcher", "Lcom/tencent/mm/plugin/finder/nearby/live/NearbyLiveFeedFetcher;", "taskExecutor", "Lcom/tencent/mm/loader/loader/SingleTaskExecutor;", "alive", "", "dead", "fetch", "request", "", "callback", "isAuto", "", "fetchInit", "fetchLoadMore", "fetchRefresh", "reset", "invokeSource", "", "plugin-finder-nearby_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class b
    extends com.tencent.mm.plugin.finder.feed.model.internal.i<cc>
  {
    private com.tencent.mm.loader.f.h ADY;
    private c EIA;
    
    public b()
    {
      AppMethodBeat.i(340738);
      AppMethodBeat.o(340738);
    }
    
    public final void alive()
    {
      AppMethodBeat.i(340797);
      super.alive();
      this.EIA = new c(this.EIB.getContextObj());
      com.tencent.mm.loader.f.h localh = new com.tencent.mm.loader.f.h("FinderFollowTlSingleExecutor");
      localh.start();
      ah localah = ah.aiuX;
      this.ADY = localh;
      AppMethodBeat.o(340797);
    }
    
    public final void ama(String paramString)
    {
      Object localObject2 = null;
      AppMethodBeat.i(340810);
      s.u(paramString, "invokeSource");
      Object localObject1 = this.ADY;
      Object localObject3;
      if (localObject1 == null)
      {
        localObject1 = null;
        localObject3 = String.valueOf(localObject1);
        localObject1 = this.ADY;
        if (localObject1 != null) {
          ((com.tencent.mm.loader.f.h)localObject1).reset();
        }
        localObject1 = getTAG();
        localObject3 = new StringBuilder("reset ").append(paramString).append(" before toke:").append((String)localObject3).append(" after toke:");
        paramString = this.ADY;
        if (paramString != null) {
          break label119;
        }
      }
      label119:
      for (paramString = localObject2;; paramString = Integer.valueOf(paramString.nrw))
      {
        Log.i((String)localObject1, paramString);
        AppMethodBeat.o(340810);
        return;
        localObject1 = Integer.valueOf(((com.tencent.mm.loader.f.h)localObject1).nrw);
        break;
      }
    }
    
    public final void dead()
    {
      AppMethodBeat.i(340805);
      super.dead();
      Object localObject = this.EIA;
      if (localObject != null)
      {
        localObject = ((c)localObject).AAh;
        if (localObject != null) {
          ((com.tencent.mm.vending.e.c)localObject).dead();
        }
      }
      localObject = this.EIA;
      if (localObject != null) {
        ((c)localObject).EIn = null;
      }
      localObject = this.ADY;
      if (localObject != null) {
        ((com.tencent.mm.loader.f.h)localObject).reset();
      }
      this.ADY = null;
      AppMethodBeat.o(340805);
    }
    
    public final void fetch(final Object paramObject, final com.tencent.mm.plugin.finder.feed.model.internal.h<cc> paramh, boolean paramBoolean)
    {
      AppMethodBeat.i(340790);
      s.u(paramh, "callback");
      if ((paramObject instanceof NearbyLiveFeedLoader.c))
      {
        com.tencent.mm.loader.f.h localh = this.ADY;
        if (localh != null) {
          localh.a(new g((kotlin.g.a.b)new b(this, paramObject, this.EIB, paramh)));
        }
      }
      AppMethodBeat.o(340790);
    }
    
    public final void fetchInit(com.tencent.mm.plugin.finder.feed.model.internal.h<cc> paramh)
    {
      AppMethodBeat.i(340783);
      s.u(paramh, "callback");
      LinkedList localLinkedList = new LinkedList();
      try
      {
        Object localObject1 = com.tencent.mm.ui.component.k.aeZF;
        localObject1 = ((com.tencent.mm.plugin.finder.viewmodel.n)com.tencent.mm.ui.component.k.cn(PluginFinder.class).q(com.tencent.mm.plugin.finder.viewmodel.n.class)).Vb(NearbyLiveFeedLoader.f(this.EIB));
        if (((n.a)localObject1).GLv.isEmpty())
        {
          localLinkedList.addAll((Collection)k.a.a(com.tencent.mm.plugin.finder.storage.data.k.FNg, NearbyLiveFeedLoader.k(this.EIB)));
          Log.i(getTAG(), "load init data from FirstPage, size:" + localLinkedList.size() + ", memoryCacheFlag:" + NearbyLiveFeedLoader.f(this.EIB) + ", fileCacheFlag:" + NearbyLiveFeedLoader.k(this.EIB));
        }
        for (;;)
        {
          localObject2 = (Iterable)localLinkedList;
          localObject1 = this.EIB;
          localObject2 = ((Iterable)localObject2).iterator();
          while (((Iterator)localObject2).hasNext())
          {
            cc localcc = (cc)((Iterator)localObject2).next();
            if ((localcc instanceof BaseFinderFeed))
            {
              bui localbui = ((NearbyLiveFeedLoader)localObject1).getContextObj();
              if (localbui != null)
              {
                com.tencent.mm.plugin.finder.report.z localz = com.tencent.mm.plugin.finder.report.z.FrZ;
                com.tencent.mm.plugin.finder.report.z.a(((BaseFinderFeed)localcc).feedObject.getFeedObject(), localbui.AJo);
              }
            }
          }
          NearbyLiveFeedLoader.a(this.EIB, ((n.a)localObject1).lastBuffer);
          localLinkedList.addAll((Collection)((n.a)localObject1).GLv);
          if (((n.a)localObject1).GKC) {
            new com.tencent.mm.plugin.finder.cgi.h(2, ((n.a)localObject1).lastBuffer).bFJ();
          }
          Log.i(getTAG(), "load init data from cache, size:" + localLinkedList.size() + ", memoryCacheFlag:" + NearbyLiveFeedLoader.f(this.EIB) + ", fileCacheFlag:" + NearbyLiveFeedLoader.k(this.EIB) + " lastBuffer:" + NearbyLiveFeedLoader.j(this.EIB));
        }
      }
      finally
      {
        for (;;)
        {
          Log.printErrStackTrace(getTAG(), localThrowable, "load init data exception", new Object[0]);
        }
        NearbyLiveFeedLoader.d locald = new NearbyLiveFeedLoader.d(0, 0, "", (byte)0);
        Object localObject2 = this.EIB;
        locald.setPullType(1000);
        locald.setIncrementList((List)localLinkedList);
        locald.setLastBuffer(NearbyLiveFeedLoader.j((NearbyLiveFeedLoader)localObject2));
        paramh.onFetchDone((IResponse)locald);
        AppMethodBeat.o(340783);
      }
    }
    
    public final void fetchLoadMore(com.tencent.mm.plugin.finder.feed.model.internal.h<cc> paramh, boolean paramBoolean)
    {
      AppMethodBeat.i(340769);
      s.u(paramh, "callback");
      NearbyLiveFeedLoader.c localc = new NearbyLiveFeedLoader.c(2, NearbyLiveFeedLoader.d(this.EIB), NearbyLiveFeedLoader.j(this.EIB), NearbyLiveFeedLoader.f(this.EIB), this.EIB.hJx, this.EIB.AJo, this.EIB.EIo, 0, 0L, 384);
      com.tencent.mm.plugin.finder.feed.model.internal.i.fetch$default((com.tencent.mm.plugin.finder.feed.model.internal.i)this, localc, paramh, false, 4, null);
      AppMethodBeat.o(340769);
    }
    
    public final void fetchRefresh(final com.tencent.mm.plugin.finder.feed.model.internal.h<cc> paramh)
    {
      AppMethodBeat.i(340758);
      s.u(paramh, "callback");
      final NearbyLiveFeedLoader.c localc = new NearbyLiveFeedLoader.c(NearbyLiveFeedLoader.c(this.EIB), NearbyLiveFeedLoader.d(this.EIB), NearbyLiveFeedLoader.e(this.EIB), NearbyLiveFeedLoader.f(this.EIB), this.EIB.hJx, this.EIB.AJo, this.EIB.EIo, 0, NearbyLiveFeedLoader.g(this.EIB), 128);
      Object localObject1;
      Object localObject2;
      if ((NearbyLiveFeedLoader.c(this.EIB) == 0) && (NearbyLiveFeedLoader.d(this.EIB) != null) && (!NearbyLiveFeedLoader.h(this.EIB)))
      {
        localObject1 = com.tencent.mm.plugin.finder.nearby.preload.a.EPD;
        localObject1 = NearbyLiveFeedLoader.d(this.EIB);
        s.checkNotNull(localObject1);
        localObject2 = com.tencent.mm.plugin.finder.nearby.preload.a.b((bnn)localObject1);
        if (localObject2 != null)
        {
          localObject1 = this.EIB;
          a.a locala = ((com.tencent.mm.plugin.finder.nearby.preload.firstpage.a)localObject2).EPU;
          switch (a.$EnumSwitchMapping$0[locala.ordinal()])
          {
          }
        }
      }
      do
      {
        NearbyLiveFeedLoader.a(this.EIB, null);
        NearbyLiveFeedLoader.i(this.EIB);
        com.tencent.mm.plugin.finder.feed.model.internal.i.fetch$default((com.tencent.mm.plugin.finder.feed.model.internal.i)this, localc, paramh, false, 4, null);
        AppMethodBeat.o(340758);
        return;
        ((com.tencent.mm.plugin.finder.nearby.preload.firstpage.b)localObject2).at((kotlin.g.a.b)new c(this, localc, paramh, (NearbyLiveFeedLoader)localObject1));
        AppMethodBeat.o(340758);
        return;
        localObject2 = ((com.tencent.mm.plugin.finder.nearby.preload.firstpage.b)localObject2).eGz();
      } while (localObject2 == null);
      NearbyLiveFeedLoader.a((NearbyLiveFeedLoader)localObject1, ((IResponse)((com.tencent.mm.plugin.findersdk.b.i)localObject2).hKP).getLastBuffer());
      paramh.onFetchDone((IResponse)((com.tencent.mm.plugin.findersdk.b.i)localObject2).hKP);
      AppMethodBeat.o(340758);
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", "", "task", "Lcom/tencent/mm/loader/loader/SingleTask;"}, k=3, mv={1, 5, 1}, xi=48)
    static final class b
      extends u
      implements kotlin.g.a.b<g, ah>
    {
      b(NearbyLiveFeedLoader.b paramb, Object paramObject, NearbyLiveFeedLoader paramNearbyLiveFeedLoader, com.tencent.mm.plugin.finder.feed.model.internal.h<cc> paramh)
      {
        super();
      }
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/findersdk/cgi/PreloadResponse;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;"}, k=3, mv={1, 5, 1}, xi=48)
    static final class c
      extends u
      implements kotlin.g.a.b<com.tencent.mm.plugin.findersdk.b.i<IResponse<cc>>, ah>
    {
      c(NearbyLiveFeedLoader.b paramb, NearbyLiveFeedLoader.c paramc, com.tencent.mm.plugin.finder.feed.model.internal.h<cc> paramh, NearbyLiveFeedLoader paramNearbyLiveFeedLoader)
      {
        super();
      }
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/nearby/live/NearbyLiveFeedLoader$FinderLiveFriendsRequest;", "", "pullType", "", "tabInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLiveTabInfo;", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "memoryCacheFlag", "tabType", "commentScene", "by_pass", "", "only_follow_feed", "relatedObjectId", "", "(ILcom/tencent/mm/protocal/protobuf/FinderLiveTabInfo;Lcom/tencent/mm/protobuf/ByteString;IIILjava/lang/String;IJ)V", "getBy_pass", "()Ljava/lang/String;", "setBy_pass", "(Ljava/lang/String;)V", "getCommentScene", "()I", "getLastBuffer", "()Lcom/tencent/mm/protobuf/ByteString;", "setLastBuffer", "(Lcom/tencent/mm/protobuf/ByteString;)V", "getMemoryCacheFlag", "getOnly_follow_feed", "setOnly_follow_feed", "(I)V", "getPullType", "getRelatedObjectId", "()J", "setRelatedObjectId", "(J)V", "getTabInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderLiveTabInfo;", "getTabType", "toString", "plugin-finder-nearby_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
  {
    final int AJo;
    int EIF;
    long EIG;
    String EIo;
    final bnn EIq;
    public final int EIr;
    final int hJx;
    com.tencent.mm.bx.b lastBuffer;
    public final int pullType;
    
    private c(int paramInt1, bnn parambnn, com.tencent.mm.bx.b paramb, int paramInt2, int paramInt3, int paramInt4, String paramString, int paramInt5, long paramLong)
    {
      AppMethodBeat.i(340739);
      this.pullType = paramInt1;
      this.EIq = parambnn;
      this.lastBuffer = paramb;
      this.EIr = paramInt2;
      this.hJx = paramInt3;
      this.AJo = paramInt4;
      this.EIo = paramString;
      this.EIF = paramInt5;
      this.EIG = paramLong;
      AppMethodBeat.o(340739);
    }
    
    public final String toString()
    {
      Object localObject2 = null;
      AppMethodBeat.i(340753);
      StringBuilder localStringBuilder = new StringBuilder("pullType:").append(this.pullType).append("  tabId:");
      Object localObject1 = this.EIq;
      if (localObject1 == null)
      {
        localObject1 = null;
        localStringBuilder = localStringBuilder.append(localObject1).append(" tabName:");
        localObject1 = this.EIq;
        if (localObject1 != null) {
          break label149;
        }
      }
      label149:
      for (localObject1 = localObject2;; localObject1 = ((bnn)localObject1).ZWa)
      {
        localObject1 = localObject1 + " lastBuffer:" + this.lastBuffer + " memoryCacheFlag:" + this.EIr + " tabType:" + this.hJx + " commentScene:" + this.AJo + " relatedObjectId:" + this.EIG;
        AppMethodBeat.o(340753);
        return localObject1;
        localObject1 = Integer.valueOf(((bnn)localObject1).ZVZ);
        break;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/nearby/live/NearbyLiveFeedLoader$FinderLiveFriendsResponse;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "errType", "", "errCode", "errMsg", "", "jumpLiveTab", "Lcom/tencent/mm/protocal/protobuf/FinderJumpLiveTab;", "prefetchMinInterval", "(IILjava/lang/String;Lcom/tencent/mm/protocal/protobuf/FinderJumpLiveTab;I)V", "getJumpLiveTab", "()Lcom/tencent/mm/protocal/protobuf/FinderJumpLiveTab;", "setJumpLiveTab", "(Lcom/tencent/mm/protocal/protobuf/FinderJumpLiveTab;)V", "getPrefetchMinInterval", "()I", "setPrefetchMinInterval", "(I)V", "plugin-finder-nearby_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class d
    extends IResponse<cc>
  {
    bch EIH = null;
    public int EII = -1;
    
    private d(int paramInt1, int paramInt2, String paramString)
    {
      super(paramInt2, paramString);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/nearby/live/NearbyLiveFeedLoader$createDataMerger$1", "Lcom/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader$DefaultDataMerger;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "calculateIndex", "", "data", "Lcom/tencent/mm/plugin/finder/feed/model/internal/MergeInsertData;", "mergeLoadMore", "", "response", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "next", "Lkotlin/Function1;", "mergeRefresh", "plugin-finder-nearby_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class e
    extends BaseFeedLoader<cc>.a
  {
    e(NearbyLiveFeedLoader paramNearbyLiveFeedLoader)
    {
      super(false);
      AppMethodBeat.i(340719);
      AppMethodBeat.o(340719);
    }
    
    public final int calculateIndex(com.tencent.mm.plugin.finder.feed.model.internal.n paramn)
    {
      int k = 0;
      AppMethodBeat.i(340760);
      s.u(paramn, "data");
      Log.i(this.EIB.getTAG(), s.X("calculateIndex : ", Boolean.valueOf(paramn.BkB)));
      if (paramn.BkB)
      {
        paramn = ((List)this.EIB.getDataList()).iterator();
        i = 0;
        int j;
        if (paramn.hasNext())
        {
          cc localcc = (cc)paramn.next();
          if (((localcc instanceof bn)) && (((bn)localcc).eDD()))
          {
            j = 1;
            label102:
            if (j == 0) {
              break label149;
            }
            label106:
            paramn = Integer.valueOf(i);
            if (((Number)paramn).intValue() == -1) {
              break label161;
            }
            i = 1;
            label124:
            if (i == 0) {
              break label166;
            }
            label128:
            if (paramn != null) {
              break label171;
            }
          }
        }
        label149:
        label161:
        label166:
        label171:
        for (i = k;; i = paramn.intValue())
        {
          AppMethodBeat.o(340760);
          return i + 1;
          j = 0;
          break label102;
          i += 1;
          break;
          i = -1;
          break label106;
          i = 0;
          break label124;
          paramn = null;
          break label128;
        }
      }
      int i = super.calculateIndex(paramn);
      AppMethodBeat.o(340760);
      return i;
    }
    
    public final void mergeLoadMore(final IResponse<cc> paramIResponse, final kotlin.g.a.b<? super IResponse<cc>, ah> paramb)
    {
      AppMethodBeat.i(340754);
      s.u(paramIResponse, "response");
      Object localObject1 = paramIResponse.getRequest();
      if (localObject1 == null)
      {
        paramIResponse = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.finder.nearby.live.NearbyLiveFeedLoader.FinderLiveFriendsRequest");
        AppMethodBeat.o(340754);
        throw paramIResponse;
      }
      localObject1 = (NearbyLiveFeedLoader.c)localObject1;
      if (((NearbyLiveFeedLoader.c)localObject1).EIF == 0)
      {
        NearbyLiveFeedLoader.a(this.EIB, false, paramIResponse.getHasMore(), "mergeLoadMore0");
        super.mergeLoadMore(paramIResponse, paramb);
        com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new a(this.EIB));
        AppMethodBeat.o(340754);
        return;
      }
      final RefreshLoadMoreLayout.d locald;
      boolean bool;
      Object localObject2;
      int i;
      label220:
      Object localObject3;
      int j;
      label265:
      label270:
      label298:
      label364:
      final ah.d locald1;
      final ah.d locald2;
      final ah.d locald3;
      final ah.d locald4;
      Object localObject4;
      final LinkedList localLinkedList;
      if (((NearbyLiveFeedLoader.c)localObject1).EIF == 1)
      {
        NearbyLiveFeedLoader.a(this.EIB, true, paramIResponse.getHasMore(), "mergeLoadMore1");
        localObject1 = RefreshLoadMoreLayout.d.agJr;
        locald = new RefreshLoadMoreLayout.d(RefreshLoadMoreLayout.d.jMH());
        localObject1 = paramIResponse.getIncrementList();
        if (localObject1 != null) {
          break label719;
        }
        bool = true;
        locald.pzq = bool;
        locald.agJu = true;
        locald.agJs = 1;
        localObject2 = paramIResponse.getIncrementList();
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = (List)new LinkedList();
        }
        localObject2 = (List)this.EIB.getDataList();
        i = 0;
        localObject2 = ((List)localObject2).iterator();
        if (!((Iterator)localObject2).hasNext()) {
          break label744;
        }
        localObject3 = (cc)((Iterator)localObject2).next();
        if ((!(localObject3 instanceof au)) || (((au)localObject3).AYX != 4)) {
          break label731;
        }
        j = 1;
        if (j == 0) {
          break label737;
        }
        if (i <= 0) {
          break label749;
        }
        localObject3 = new LinkedList((Collection)this.EIB.getDataList().subList(0, i));
        if ((i <= 0) || (i + 1 >= this.EIB.getDataList().size())) {
          break label771;
        }
        localObject2 = NearbyLiveFeedLoader.a(this.EIB, paramIResponse.getHasMore(), new LinkedList((Collection)this.EIB.getDataList().subList(i + 1, this.EIB.getDataList().size())));
        locald1 = new ah.d();
        locald2 = new ah.d();
        locald3 = new ah.d();
        locald4 = new ah.d();
        localObject4 = new LinkedList((Collection)this.EIB.getDataList());
        localLinkedList = new LinkedList();
        localLinkedList.addAll((Collection)localObject3);
        localLinkedList.addAll((Collection)localObject1);
        if (paramIResponse.getHasMore()) {
          break label830;
        }
        localLinkedList.addAll((Collection)localObject2);
        if (i <= 0) {
          break label787;
        }
        locald3.aixb = i;
        locald4.aixb = 1;
        locald1.aixb = i;
        locald2.aixb = (((List)localObject1).size() + ((LinkedList)localObject2).size());
      }
      for (;;)
      {
        localObject1 = bg.ABl;
        localObject1 = bg.fU((List)localLinkedList);
        localObject3 = bg.ABl;
        localObject3 = bg.fU((List)localObject4);
        localObject4 = bg.ABl;
        localObject2 = bg.fU((List)localObject2);
        Log.i(this.EIB.getTAG(), "mergeLoadMore() hasMore:" + paramIResponse.getHasMore() + " moreFollowCardIndex:" + i + " removeIndex:" + locald3.aixb + "  removeSize:" + locald4.aixb + " insertIndex:" + locald1.aixb + "  insertSize:" + locald2.aixb + " newList:" + (String)localObject1 + " oldList:" + (String)localObject3 + " oldRecommendList:" + (String)localObject2);
        com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new b(this.EIB, localLinkedList, locald3, locald4, locald1, locald2, locald, paramb, paramIResponse));
        AppMethodBeat.o(340754);
        return;
        label719:
        bool = ((List)localObject1).isEmpty();
        break;
        label731:
        j = 0;
        break label265;
        label737:
        i += 1;
        break label220;
        label744:
        i = -1;
        break label270;
        label749:
        localObject3 = new LinkedList((Collection)this.EIB.getDataList());
        break label298;
        label771:
        localObject2 = NearbyLiveFeedLoader.a(this.EIB, paramIResponse.getHasMore());
        break label364;
        label787:
        locald3.aixb = -1;
        locald4.aixb = 0;
        locald1.aixb = ((LinkedList)localObject4).size();
        locald2.aixb = (((List)localObject1).size() + ((LinkedList)localObject2).size());
        continue;
        label830:
        if (i > 0)
        {
          locald3.aixb = i;
          locald4.aixb = (((LinkedList)localObject2).size() + 1);
          locald1.aixb = i;
          locald2.aixb = ((List)localObject1).size();
        }
        else
        {
          locald3.aixb = -1;
          locald4.aixb = 0;
          locald1.aixb = ((LinkedList)localObject4).size();
          locald2.aixb = ((List)localObject1).size();
        }
      }
    }
    
    public final void mergeRefresh(final IResponse<cc> paramIResponse, kotlin.g.a.b<? super IResponse<cc>, ah> paramb)
    {
      AppMethodBeat.i(340736);
      s.u(paramIResponse, "response");
      final long l = SystemClock.elapsedRealtime();
      NearbyLiveFeedLoader.a(this.EIB, false, paramIResponse.getHasMore(), "mergeRefresh");
      NearbyLiveFeedLoader.a(this.EIB);
      paramb = RefreshLoadMoreLayout.d.agJr;
      final RefreshLoadMoreLayout.d locald = new RefreshLoadMoreLayout.d(RefreshLoadMoreLayout.d.jMG());
      locald.agJu = paramIResponse.getHasMore();
      locald.extra = ((NearbyLiveFeedLoader.d)paramIResponse).EIH;
      int m = this.EIB.getDataList().size();
      Object localObject1 = paramIResponse.getIncrementList();
      paramb = (kotlin.g.a.b<? super IResponse<cc>, ah>)localObject1;
      if (localObject1 == null) {
        paramb = (List)new LinkedList();
      }
      localObject1 = new ah.f();
      ((ah.f)localObject1).aqH = new LinkedList();
      Object localObject2 = (cc)p.oL((List)this.EIB.getDataList());
      Object localObject3;
      if (localObject2 != null)
      {
        localObject3 = this.EIB;
        if ((localObject2 instanceof aa)) {
          ((LinkedList)((ah.f)localObject1).aqH).add(((NearbyLiveFeedLoader)localObject3).getDataList().get(0));
        }
      }
      ((LinkedList)((ah.f)localObject1).aqH).addAll((Collection)paramb);
      paramb = this.EIB;
      localObject2 = ((Iterable)((ah.f)localObject1).aqH).iterator();
      int i = 0;
      int j = 0;
      Object localObject4;
      Object localObject5;
      int k;
      if (((Iterator)localObject2).hasNext())
      {
        localObject3 = ((Iterator)localObject2).next();
        if (i < 0) {
          p.kkW();
        }
        localObject3 = (cc)localObject3;
        localObject4 = ((List)paramb.getDataList()).iterator();
        j = 0;
        if (((Iterator)localObject4).hasNext())
        {
          localObject5 = (cc)((Iterator)localObject4).next();
          if ((((cc)localObject5).a((com.tencent.mm.plugin.finder.feed.model.internal.k)localObject3) == 0) && ((localObject5 instanceof x)))
          {
            bip localbip = ((x)localObject5).feedObject.getLiveInfo();
            if ((localbip == null) || (localbip.liveStatus != 1)) {
              break label562;
            }
            k = 1;
            label358:
            if (k != 0) {}
          }
          else
          {
            if ((i != 0) || (!(localObject3 instanceof aa)) || (!(localObject5 instanceof aa))) {
              break label568;
            }
          }
          k = 1;
          label386:
          if (k != 0)
          {
            label391:
            if ((j != -1) && (j == i)) {
              break label674;
            }
            i -= 1;
          }
        }
      }
      for (;;)
      {
        paramb = new LinkedList();
        paramb.addAll((Collection)this.EIB.getDataList());
        j = ((LinkedList)((ah.f)localObject1).aqH).size();
        localObject2 = new ah.d();
        ((ah.d)localObject2).aixb = -1;
        localObject3 = new ah.d();
        localObject4 = new ah.d();
        ((ah.d)localObject4).aixb = -1;
        localObject5 = new ah.d();
        if (j > 0) {
          if (i + 1 == j)
          {
            ((ah.d)localObject4).aixb = (i + 1);
            ((ah.d)localObject5).aixb = (m - j);
          }
        }
        for (;;)
        {
          com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new c(this.EIB, (ah.f)localObject1, l, paramb, paramIResponse, (ah.d)localObject4, (ah.d)localObject5, (ah.d)localObject2, (ah.d)localObject3, locald));
          AppMethodBeat.o(340736);
          return;
          label562:
          k = 0;
          break label358;
          label568:
          k = 0;
          break label386;
          j += 1;
          break;
          j = -1;
          break label391;
          if (i + 1 > j)
          {
            Log.w(this.EIB.getTAG(), "数据出错，需要检查.");
          }
          else
          {
            ((ah.d)localObject4).aixb = (i + 1);
            ((ah.d)localObject5).aixb = (m - ((ah.d)localObject4).aixb);
            ((ah.d)localObject2).aixb = (i + 1);
            ((ah.d)localObject3).aixb = (j - ((ah.d)localObject2).aixb);
            continue;
            Log.w(this.EIB.getTAG(), "没有新的数据.");
          }
        }
        label674:
        j = i;
        i += 1;
        break;
        i = j;
      }
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends u
      implements kotlin.g.a.a<ah>
    {
      a(NearbyLiveFeedLoader paramNearbyLiveFeedLoader)
      {
        super();
      }
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class b
      extends u
      implements kotlin.g.a.a<ah>
    {
      b(NearbyLiveFeedLoader paramNearbyLiveFeedLoader, LinkedList<cc> paramLinkedList, ah.d paramd1, ah.d paramd2, ah.d paramd3, ah.d paramd4, RefreshLoadMoreLayout.d<Object> paramd, kotlin.g.a.b<? super IResponse<cc>, ah> paramb, IResponse<cc> paramIResponse)
      {
        super();
      }
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class c
      extends u
      implements kotlin.g.a.a<ah>
    {
      c(NearbyLiveFeedLoader paramNearbyLiveFeedLoader, ah.f<LinkedList<cc>> paramf, long paramLong, LinkedList<cc> paramLinkedList, IResponse<cc> paramIResponse, ah.d paramd1, ah.d paramd2, ah.d paramd3, ah.d paramd4, RefreshLoadMoreLayout.d<Object> paramd)
      {
        super();
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends u
    implements kotlin.g.a.a<ah>
  {
    f(NearbyLiveFeedLoader paramNearbyLiveFeedLoader, IResponse<cc> paramIResponse)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.nearby.live.NearbyLiveFeedLoader
 * JD-Core Version:    0.7.0.1
 */
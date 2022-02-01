package com.tencent.mm.plugin.finder.nearby.video;

import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.cgi.ar.a;
import com.tencent.mm.plugin.finder.cgi.ar.c;
import com.tencent.mm.plugin.finder.cgi.bg;
import com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader.a;
import com.tencent.mm.plugin.finder.feed.model.internal.DataBuffer;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.feed.model.internal.f;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.aa;
import com.tencent.mm.plugin.finder.model.cc;
import com.tencent.mm.plugin.finder.model.x;
import com.tencent.mm.plugin.finder.report.z;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.data.e.a;
import com.tencent.mm.plugin.finder.storage.data.k.a;
import com.tencent.mm.plugin.finder.utils.av;
import com.tencent.mm.plugin.finder.viewmodel.n;
import com.tencent.mm.plugin.finder.viewmodel.n.a;
import com.tencent.mm.protocal.protobuf.bip;
import com.tencent.mm.protocal.protobuf.bnn;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.protocal.protobuf.esc;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.component.k.b;
import com.tencent.mm.vending.e.c;
import com.tencent.mm.view.RefreshLoadMoreLayout.d;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.ah;
import kotlin.g.a.b<-Lcom.tencent.mm.plugin.finder.feed.model.internal.IResponse<Lcom.tencent.mm.plugin.finder.model.cc;>;Lkotlin.ah;>;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/nearby/video/NearbyVideoFeedLoader;", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "scene", "Lcom/tencent/mm/plugin/finder/feed/model/internal/FinderLoaderScene;", "firstLoad", "", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Lcom/tencent/mm/plugin/finder/feed/model/internal/FinderLoaderScene;ILcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "getFirstLoad", "()I", "setFirstLoad", "(I)V", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "getRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "setRecyclerView", "(Landroidx/recyclerview/widget/RecyclerView;)V", "getScene", "()Lcom/tencent/mm/plugin/finder/feed/model/internal/FinderLoaderScene;", "streamFetcher", "Lcom/tencent/mm/plugin/finder/nearby/video/NearbyVideoFeedFetcher;", "getStreamFetcher", "()Lcom/tencent/mm/plugin/finder/nearby/video/NearbyVideoFeedFetcher;", "colletExtraPageName", "", "createDataFetch", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataFetch;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "createDataMerger", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataMerger;", "getPageName", "handleFluentSwitch", "", "response", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "onDead", "preloadMoreToBuffer", "callback", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataCallback;", "printVisibleFeeds", "", "hasVisibleFeeds", "Landroid/util/LongSparseArray;", "requestLoadMore", "tabInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLiveTabInfo;", "requestRefresh", "unreadList", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "TimelineDataFetcher", "TimelineRequest", "TimelineResponse", "plugin-finder-nearby_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class NearbyVideoFeedLoader
  extends BaseFinderFeedLoader
{
  private final com.tencent.mm.plugin.finder.feed.model.internal.g BgY;
  int Bja;
  private final b ERH;
  
  public NearbyVideoFeedLoader(com.tencent.mm.plugin.finder.feed.model.internal.g paramg, int paramInt, bui parambui)
  {
    super(parambui);
    AppMethodBeat.i(340056);
    this.BgY = paramg;
    this.Bja = paramInt;
    this.ERH = new b(this.BgY.value, parambui);
    AppMethodBeat.o(340056);
  }
  
  public final List<Integer> colletExtraPageName()
  {
    AppMethodBeat.i(340094);
    Object localObject = new ArrayList();
    ((ArrayList)localObject).add(Integer.valueOf(4));
    localObject = (List)localObject;
    AppMethodBeat.o(340094);
    return localObject;
  }
  
  public final com.tencent.mm.plugin.finder.feed.model.internal.i<cc> createDataFetch()
  {
    AppMethodBeat.i(340065);
    com.tencent.mm.plugin.finder.feed.model.internal.i locali = (com.tencent.mm.plugin.finder.feed.model.internal.i)new a(this.ERH, this.BgY);
    AppMethodBeat.o(340065);
    return locali;
  }
  
  public final com.tencent.mm.plugin.finder.feed.model.internal.d<cc> createDataMerger()
  {
    AppMethodBeat.i(340073);
    com.tencent.mm.plugin.finder.feed.model.internal.d locald = (com.tencent.mm.plugin.finder.feed.model.internal.d)new d(this);
    AppMethodBeat.o(340073);
    return locald;
  }
  
  public final int getPageName()
  {
    AppMethodBeat.i(340085);
    av localav = av.GiL;
    int i = av.Ui(this.BgY.value);
    localav = av.GiL;
    i = av.Ug(i);
    AppMethodBeat.o(340085);
    return i;
  }
  
  public final void onDead()
  {
    AppMethodBeat.i(340077);
    super.onDead();
    this.ERH.AAh.dead();
    AppMethodBeat.o(340077);
  }
  
  public final void requestLoadMore(bnn parambnn)
  {
    AppMethodBeat.i(340070);
    super.requestLoadMore(false);
    AppMethodBeat.o(340070);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/nearby/video/NearbyVideoFeedLoader$TimelineDataFetcher;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataFetch;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycleKeeper;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycle;", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderTimelineStream$Callback;", "streamFetcher", "Lcom/tencent/mm/plugin/finder/nearby/video/NearbyVideoFeedFetcher;", "scene", "Lcom/tencent/mm/plugin/finder/feed/model/internal/FinderLoaderScene;", "(Lcom/tencent/mm/plugin/finder/nearby/video/NearbyVideoFeedLoader;Lcom/tencent/mm/plugin/finder/nearby/video/NearbyVideoFeedFetcher;Lcom/tencent/mm/plugin/finder/feed/model/internal/FinderLoaderScene;)V", "taskExecutor", "Lcom/tencent/mm/loader/loader/SingleTaskExecutor;", "alive", "", "dead", "fetch", "request", "", "callback", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataCallback;", "isAuto", "", "fetchInit", "fetchLoadMore", "fetchRefresh", "keep", "target", "onFetchDone", "info", "Lcom/tencent/mm/plugin/finder/feed/model/CgiFinderStreamResult;", "pullType", "", "plugin-finder-nearby_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class a
    extends com.tencent.mm.plugin.finder.feed.model.internal.i<cc>
    implements ar.a, com.tencent.mm.vending.e.b<com.tencent.mm.vending.e.a>
  {
    private com.tencent.mm.loader.f.h ADY;
    private final com.tencent.mm.plugin.finder.feed.model.internal.g BgY;
    private final b ERH;
    
    public a(com.tencent.mm.plugin.finder.feed.model.internal.g paramg)
    {
      AppMethodBeat.i(340072);
      this.ERH = paramg;
      this.BgY = localObject;
      AppMethodBeat.o(340072);
    }
    
    public final void a(com.tencent.mm.plugin.finder.feed.model.d paramd, int paramInt)
    {
      AppMethodBeat.i(340158);
      kotlin.g.b.s.u(paramd, "info");
      AppMethodBeat.o(340158);
    }
    
    public final void alive()
    {
      AppMethodBeat.i(340126);
      super.alive();
      com.tencent.mm.loader.f.h localh;
      if (this.BgY == com.tencent.mm.plugin.finder.feed.model.internal.g.Bkd)
      {
        this.ADY = ((PluginFinder)com.tencent.mm.kernel.h.az(PluginFinder.class)).getFollowTlSingleExecutor();
        localh = this.ADY;
        if (localh != null)
        {
          localh.clean();
          AppMethodBeat.o(340126);
        }
      }
      else
      {
        localh = new com.tencent.mm.loader.f.h(kotlin.g.b.s.X("SingleExecutor#TabType=", Integer.valueOf(this.ERH.hJx)));
        localh.start();
        ah localah = ah.aiuX;
        this.ADY = localh;
      }
      AppMethodBeat.o(340126);
    }
    
    public final void dead()
    {
      AppMethodBeat.i(340135);
      super.dead();
      com.tencent.mm.loader.f.h localh = this.ADY;
      if (localh != null) {
        localh.reset();
      }
      this.ADY = null;
      AppMethodBeat.o(340135);
    }
    
    public final void fetch(final Object paramObject, com.tencent.mm.plugin.finder.feed.model.internal.h<cc> paramh, boolean paramBoolean)
    {
      AppMethodBeat.i(340145);
      kotlin.g.b.s.u(paramh, "callback");
      if ((paramObject instanceof NearbyVideoFeedLoader.b))
      {
        final long l = SystemClock.uptimeMillis();
        com.tencent.mm.loader.f.h localh = this.ADY;
        if (localh != null) {
          localh.a(new com.tencent.mm.loader.f.g((kotlin.g.a.b)new a(this, paramObject, l, paramh, NearbyVideoFeedLoader.this)));
        }
      }
      AppMethodBeat.o(340145);
    }
    
    public final void fetchInit(com.tencent.mm.plugin.finder.feed.model.internal.h<cc> paramh)
    {
      AppMethodBeat.i(340117);
      kotlin.g.b.s.u(paramh, "callback");
      Object localObject2 = new LinkedList();
      Object localObject1 = com.tencent.mm.ui.component.k.aeZF;
      localObject1 = ((n)com.tencent.mm.ui.component.k.cn(PluginFinder.class).q(n.class)).Vb(this.BgY.value);
      Object localObject3;
      Object localObject4;
      Object localObject5;
      Object localObject6;
      boolean bool;
      label514:
      label591:
      label626:
      long l;
      if (((n.a)localObject1).GLv.isEmpty())
      {
        localObject1 = k.a.a(com.tencent.mm.plugin.finder.storage.data.k.FNg, NearbyVideoFeedLoader.this.getPageName());
        localObject3 = NearbyVideoFeedLoader.this;
        localObject4 = ((Iterable)localObject1).iterator();
        while (((Iterator)localObject4).hasNext())
        {
          localObject5 = (cc)((Iterator)localObject4).next();
          if ((localObject5 instanceof BaseFinderFeed))
          {
            localObject6 = ((NearbyVideoFeedLoader)localObject3).getContextObj();
            z localz;
            if (localObject6 != null)
            {
              localz = z.FrZ;
              z.a(((BaseFinderFeed)localObject5).feedObject.getFeedObject(), ((bui)localObject6).AJo);
            }
            localObject5 = ((Iterable)((BaseFinderFeed)localObject5).feedObject.getFoldedFeedList()).iterator();
            while (((Iterator)localObject5).hasNext())
            {
              localObject6 = (BaseFinderFeed)((Iterator)localObject5).next();
              localz = z.FrZ;
              z.a(((BaseFinderFeed)localObject6).feedObject.getFeedObject(), 14);
            }
          }
        }
        localObject3 = ((NearbyVideoFeedLoader)localObject3).getContextObj();
        if (localObject3 != null)
        {
          localObject4 = com.tencent.mm.plugin.finder.storage.data.e.FMN;
          i = ((bui)localObject3).AJo;
          localObject4 = (Iterable)localObject1;
          localObject3 = (Collection)new ArrayList();
          localObject4 = ((Iterable)localObject4).iterator();
          while (((Iterator)localObject4).hasNext())
          {
            localObject5 = ((Iterator)localObject4).next();
            if (((cc)localObject5 instanceof BaseFinderFeed)) {
              ((Collection)localObject3).add(localObject5);
            }
          }
          localObject4 = (Iterable)localObject3;
          localObject3 = (Collection)new ArrayList(p.a((Iterable)localObject4, 10));
          localObject4 = ((Iterable)localObject4).iterator();
          while (((Iterator)localObject4).hasNext()) {
            ((Collection)localObject3).add(((BaseFinderFeed)((Iterator)localObject4).next()).feedObject.getFeedObject());
          }
          e.a.H(i, (List)localObject3);
        }
        localObject3 = ah.aiuX;
        ((LinkedList)localObject2).addAll((Collection)localObject1);
        localObject1 = NearbyVideoFeedLoader.this.getContextObj();
        if (localObject1 != null)
        {
          localObject3 = com.tencent.mm.ui.component.k.aeZF;
          localObject3 = (com.tencent.mm.plugin.finder.viewmodel.h)com.tencent.mm.ui.component.k.cn(PluginFinder.class).q(com.tencent.mm.plugin.finder.viewmodel.h.class);
          i = ((bui)localObject1).AJo;
          localObject1 = av.GiL;
          ((com.tencent.mm.plugin.finder.viewmodel.h)localObject3).L(i, av.a((List)localObject2, BaseFinderFeed.class));
        }
        localObject1 = com.tencent.mm.plugin.finder.report.s.Fqv;
        int i = this.ERH.hJx;
        if (((Collection)localObject2).isEmpty()) {
          break label811;
        }
        bool = true;
        com.tencent.mm.plugin.finder.report.s.aK(i, bool);
        localObject1 = (cc)p.oL((List)localObject2);
        localObject3 = getTAG();
        localObject4 = new StringBuilder("fetchInit tabType=").append(this.ERH.hJx).append(" callInitData scene=").append(this.BgY).append(", contextObj=");
        if (NearbyVideoFeedLoader.this.getContextObj() != null) {
          break label816;
        }
        bool = true;
        localObject4 = ((StringBuilder)localObject4).append(bool).append(" list first=");
        if (!(localObject1 instanceof BaseFinderFeed)) {
          break label821;
        }
        localObject1 = ((BaseFinderFeed)localObject1).feedObject.getNickName();
        localObject1 = ((StringBuilder)localObject4).append((String)localObject1).append(" => ");
        localObject4 = (cc)p.oL((List)localObject2);
        if (localObject4 != null) {
          break label829;
        }
        l = 0L;
        label662:
        Log.i((String)localObject3, com.tencent.mm.ae.d.hF(l));
        localObject1 = new NearbyVideoFeedLoader.c(0, 0, "", (byte)0);
        localObject3 = (Iterable)localObject2;
        localObject2 = (Collection)new ArrayList();
        localObject3 = ((Iterable)localObject3).iterator();
      }
      label811:
      label816:
      label821:
      label829:
      label844:
      for (;;)
      {
        label723:
        if (!((Iterator)localObject3).hasNext()) {
          break label846;
        }
        localObject4 = ((Iterator)localObject3).next();
        localObject5 = (cc)localObject4;
        if ((localObject5 instanceof BaseFinderFeed)) {
          localObject6 = av.GiL;
        }
        for (bool = av.y(((BaseFinderFeed)localObject5).feedObject.getFeedObject());; bool = true)
        {
          if (!bool) {
            break label844;
          }
          ((Collection)localObject2).add(localObject4);
          break label723;
          ((LinkedList)localObject2).addAll((Collection)((n.a)localObject1).GLv);
          break;
          bool = false;
          break label514;
          bool = false;
          break label591;
          localObject1 = "";
          break label626;
          l = ((cc)localObject4).bZA();
          break label662;
        }
      }
      label846:
      ((NearbyVideoFeedLoader.c)localObject1).setIncrementList((List)localObject2);
      ((NearbyVideoFeedLoader.c)localObject1).setPullType(1000);
      paramh.onFetchDone((IResponse)localObject1);
      AppMethodBeat.o(340117);
    }
    
    public final void fetchLoadMore(com.tencent.mm.plugin.finder.feed.model.internal.h<cc> paramh, boolean paramBoolean)
    {
      AppMethodBeat.i(340097);
      kotlin.g.b.s.u(paramh, "callback");
      fetch(new NearbyVideoFeedLoader.b(2, (byte)0), paramh, paramBoolean);
      AppMethodBeat.o(340097);
    }
    
    public final void fetchRefresh(com.tencent.mm.plugin.finder.feed.model.internal.h<cc> paramh)
    {
      AppMethodBeat.i(340089);
      kotlin.g.b.s.u(paramh, "callback");
      NearbyVideoFeedLoader.b localb = new NearbyVideoFeedLoader.b(NearbyVideoFeedLoader.this.Bja, (byte)0);
      if (localb.Bji) {}
      for (localb.pullType = 4;; localb.pullType = NearbyVideoFeedLoader.this.Bja)
      {
        if (NearbyVideoFeedLoader.this.Bja == 0) {
          NearbyVideoFeedLoader.this.Bja = 1;
        }
        Log.i(getTAG(), "[requestRefresh] pullType=" + localb.pullType + "  hasPrefetch=" + localb.Bjh + " needToRefreshForPrefetch=" + localb.Bji);
        com.tencent.mm.plugin.finder.feed.model.internal.i.fetch$default((com.tencent.mm.plugin.finder.feed.model.internal.i)this, localb, paramh, false, 4, null);
        AppMethodBeat.o(340089);
        return;
      }
    }
    
    public final void keep(com.tencent.mm.vending.e.a parama) {}
    
    @Metadata(d1={""}, d2={"<anonymous>", "", "task", "Lcom/tencent/mm/loader/loader/SingleTask;"}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends u
      implements kotlin.g.a.b<com.tencent.mm.loader.f.g, ah>
    {
      a(NearbyVideoFeedLoader.a parama, Object paramObject, long paramLong, com.tencent.mm.plugin.finder.feed.model.internal.h<cc> paramh, NearbyVideoFeedLoader paramNearbyVideoFeedLoader)
      {
        super();
      }
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/nearby/video/NearbyVideoFeedLoader$TimelineRequest;", "", "pullType", "", "unreadList", "", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "(ILjava/util/List;)V", "hasPrefetch", "", "getHasPrefetch", "()Z", "setHasPrefetch", "(Z)V", "isPreloadMore", "setPreloadMore", "minDuration", "", "getMinDuration", "()J", "setMinDuration", "(J)V", "needToRefreshForPrefetch", "getNeedToRefreshForPrefetch", "setNeedToRefreshForPrefetch", "getPullType", "()I", "setPullType", "(I)V", "getUnreadList", "()Ljava/util/List;", "setUnreadList", "(Ljava/util/List;)V", "plugin-finder-nearby_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
  {
    List<? extends BaseFinderFeed> Ayr;
    boolean Bjh;
    boolean Bji;
    long Bjj;
    boolean Bjk;
    int pullType;
    
    private b(int paramInt)
    {
      this.pullType = paramInt;
      this.Ayr = null;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/nearby/video/NearbyVideoFeedLoader$TimelineResponse;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "errType", "", "errCode", "errMsg", "", "extraData", "", "(IILjava/lang/String;Ljava/lang/Object;)V", "dataBufferList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getDataBufferList", "()Ljava/util/ArrayList;", "setDataBufferList", "(Ljava/util/ArrayList;)V", "getExtraData", "()Ljava/lang/Object;", "setExtraData", "(Ljava/lang/Object;)V", "plugin-finder-nearby_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    extends IResponse<cc>
  {
    ArrayList<cc> BeE;
    Object extraData = null;
    
    private c(int paramInt1, int paramInt2, String paramString)
    {
      super(paramInt2, paramString);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/nearby/video/NearbyVideoFeedLoader$createDataMerger$1", "Lcom/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader$DefaultDataMerger;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "mergeRefresh", "", "response", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "next", "Lkotlin/Function1;", "plugin-finder-nearby_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class d
    extends BaseFeedLoader<cc>.a
  {
    d(NearbyVideoFeedLoader paramNearbyVideoFeedLoader)
    {
      super(false, 1, null);
      AppMethodBeat.i(340067);
      AppMethodBeat.o(340067);
    }
    
    public final void mergeRefresh(IResponse<cc> paramIResponse, kotlin.g.a.b<? super IResponse<cc>, ah> paramb)
    {
      AppMethodBeat.i(340101);
      kotlin.g.b.s.u(paramIResponse, "response");
      paramb = RefreshLoadMoreLayout.d.agJr;
      final RefreshLoadMoreLayout.d locald = new RefreshLoadMoreLayout.d(RefreshLoadMoreLayout.d.jMG());
      locald.agJu = paramIResponse.getHasMore();
      int m = this.ERI.getDataList().size();
      Object localObject1 = paramIResponse.getIncrementList();
      paramb = (kotlin.g.a.b<? super IResponse<cc>, ah>)localObject1;
      if (localObject1 == null) {
        paramb = (List)new LinkedList();
      }
      localObject1 = new LinkedList();
      Object localObject2 = (cc)p.oL((List)this.ERI.getDataList());
      Object localObject3;
      if (localObject2 != null)
      {
        localObject3 = this.ERI;
        if ((localObject2 instanceof aa)) {
          ((LinkedList)localObject1).add(((NearbyVideoFeedLoader)localObject3).getDataList().get(0));
        }
      }
      ((LinkedList)localObject1).addAll((Collection)paramb);
      paramb = this.ERI;
      localObject2 = ((Iterable)localObject1).iterator();
      int i = 0;
      int j = 0;
      for (;;)
      {
        int k;
        if (((Iterator)localObject2).hasNext())
        {
          localObject3 = ((Iterator)localObject2).next();
          if (i < 0) {
            p.kkW();
          }
          localObject3 = (cc)localObject3;
          Iterator localIterator = ((List)paramb.getDataList()).iterator();
          j = 0;
          if (localIterator.hasNext())
          {
            cc localcc = (cc)localIterator.next();
            if ((localcc.a((com.tencent.mm.plugin.finder.feed.model.internal.k)localObject3) == 0) && ((localcc instanceof x)))
            {
              bip localbip = ((x)localcc).feedObject.getLiveInfo();
              if ((localbip == null) || (localbip.liveStatus != 1)) {
                break label567;
              }
              k = 1;
              label291:
              if (k != 0) {}
            }
            else
            {
              if ((i != 0) || (!(localObject3 instanceof aa)) || (!(localcc instanceof aa))) {
                break label573;
              }
            }
            k = 1;
            label319:
            if (k != 0)
            {
              label324:
              if ((j != -1) && (j == i)) {
                break label832;
              }
              i -= 1;
            }
          }
        }
        for (;;)
        {
          paramb = new LinkedList();
          paramb.addAll((Collection)this.ERI.getDataList());
          this.ERI.getDataList().clear();
          this.ERI.getDataList().addAll((Collection)localObject1);
          j = ((LinkedList)localObject1).size();
          if (j > 0) {
            if (i + 1 == j)
            {
              i += 1;
              j = m - j;
              this.ERI.dispatcher().onItemRangeRemoved(i, j);
              if (BuildInfo.DEBUG)
              {
                localObject2 = this.ERI.getTAG();
                paramIResponse = new StringBuilder("mergeRefresh() hasMore:").append(paramIResponse.getHasMore()).append(" removeIndex:").append(i).append("  removeSize:").append(j).append(" newList:");
                localObject3 = bg.ABl;
                paramIResponse = paramIResponse.append(bg.fU((List)localObject1)).append(" oldList:");
                localObject1 = bg.ABl;
                Log.i((String)localObject2, bg.fU((List)paramb));
              }
            }
          }
          for (;;)
          {
            locald.agJv = 0;
            com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new a(this.ERI, locald));
            AppMethodBeat.o(340101);
            return;
            label567:
            k = 0;
            break label291;
            label573:
            k = 0;
            break label319;
            j += 1;
            break;
            j = -1;
            break label324;
            if (i + 1 > j)
            {
              Log.w(this.ERI.getTAG(), "数据出错，需要检查.");
            }
            else
            {
              k = i + 1;
              int n = m - k;
              if ((m > 0) && (n > 0)) {
                this.ERI.dispatcher().onItemRangeRemoved(k, n);
              }
              i += 1;
              j -= i;
              if (j > 0) {
                this.ERI.dispatcher().onItemRangeInserted(i, j);
              }
              if (BuildInfo.DEBUG)
              {
                localObject2 = this.ERI.getTAG();
                paramIResponse = new StringBuilder("mergeRefresh() hasMore:").append(paramIResponse.getHasMore()).append(" removeIndex:").append(k).append("  removeSize:").append(n).append(" insertIndex:").append(i).append("  insertSize:").append(j).append(" newList:");
                localObject3 = bg.ABl;
                paramIResponse = paramIResponse.append(bg.fU((List)localObject1)).append(" oldList:");
                localObject1 = bg.ABl;
                Log.i((String)localObject2, bg.fU((List)paramb));
                continue;
                Log.w(this.ERI.getTAG(), "没有新的数据.");
              }
            }
          }
          i = j;
        }
        label832:
        j = i;
        i += 1;
      }
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends u
      implements kotlin.g.a.a<ah>
    {
      a(NearbyVideoFeedLoader paramNearbyVideoFeedLoader, RefreshLoadMoreLayout.d<Object> paramd)
      {
        super();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.nearby.video.NearbyVideoFeedLoader
 * JD-Core Version:    0.7.0.1
 */
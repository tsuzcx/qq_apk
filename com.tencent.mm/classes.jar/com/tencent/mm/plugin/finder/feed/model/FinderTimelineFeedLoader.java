package com.tencent.mm.plugin.finder.feed.model;

import android.content.Context;
import android.content.res.Resources;
import android.os.SystemClock;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.hu;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.b.j;
import com.tencent.mm.plugin.finder.cgi.ab.a;
import com.tencent.mm.plugin.finder.cgi.ab.c;
import com.tencent.mm.plugin.finder.feed.aq;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader.a;
import com.tencent.mm.plugin.finder.feed.model.internal.DataBuffer;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.feed.model.internal.f;
import com.tencent.mm.plugin.finder.feed.model.internal.n;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.bu;
import com.tencent.mm.plugin.finder.model.d.a;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.utils.aj;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.bid;
import com.tencent.mm.protocal.protobuf.dyy;
import com.tencent.mm.sdk.crash.CrashReportFactory;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.component.g.a;
import com.tencent.mm.vending.e.c;
import com.tencent.mm.view.RefreshLoadMoreLayout.c;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.a.v;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/model/FinderTimelineFeedLoader;", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "scene", "Lcom/tencent/mm/plugin/finder/feed/model/internal/FinderLoaderScene;", "firstLoad", "", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "guideBarObjId", "", "(Lcom/tencent/mm/plugin/finder/feed/model/internal/FinderLoaderScene;ILcom/tencent/mm/protocal/protobuf/FinderReportContextObj;Ljava/lang/Long;)V", "extraDataOp", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "", "getExtraDataOp", "()Lkotlin/jvm/functions/Function1;", "setExtraDataOp", "(Lkotlin/jvm/functions/Function1;)V", "getFirstLoad", "()I", "setFirstLoad", "(I)V", "getGuideBarObjId", "()Ljava/lang/Long;", "Ljava/lang/Long;", "postFeedFlag", "", "getPostFeedFlag", "()Z", "setPostFeedFlag", "(Z)V", "recyclerViewRef", "Ljava/lang/ref/WeakReference;", "Landroidx/recyclerview/widget/RecyclerView;", "getRecyclerViewRef", "()Ljava/lang/ref/WeakReference;", "setRecyclerViewRef", "(Ljava/lang/ref/WeakReference;)V", "getScene", "()Lcom/tencent/mm/plugin/finder/feed/model/internal/FinderLoaderScene;", "streamFetcher", "Lcom/tencent/mm/plugin/finder/cgi/fetcher/FinderTimelineFeedFetcher;", "getStreamFetcher", "()Lcom/tencent/mm/plugin/finder/cgi/fetcher/FinderTimelineFeedFetcher;", "bufferSize", "clearAndNotify", "colletExtraPageName", "", "createDataFetch", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataFetch;", "createDataMerger", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataMerger;", "getPageName", "isObservePostEvent", "onDead", "onFetchDone", "response", "onPostStart", "localId", "isFromSns", "preloadMoreToBuffer", "callback", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataCallback;", "printVisibleFeeds", "", "hasVisibleFeeds", "Landroid/util/LongSparseArray;", "requestRefresh", "unreadList", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "CgiConsumeCallback", "TimelineDataFetcher", "TimelineRequest", "TimelineResponse", "plugin-finder_release"})
public final class FinderTimelineFeedLoader
  extends BaseFinderFeedLoader
{
  public WeakReference<RecyclerView> wlv;
  private final com.tencent.mm.plugin.finder.feed.model.internal.g xHL;
  final com.tencent.mm.plugin.finder.cgi.fetcher.d xJp;
  public boolean xJq;
  public kotlin.g.a.b<? super IResponse<bu>, kotlin.x> xJr;
  public int xJs;
  private final Long xfs;
  
  public FinderTimelineFeedLoader(com.tencent.mm.plugin.finder.feed.model.internal.g paramg, int paramInt, bid parambid, Long paramLong)
  {
    super(parambid);
    AppMethodBeat.i(270765);
    this.xHL = paramg;
    this.xJs = paramInt;
    this.xfs = paramLong;
    this.xJp = new com.tencent.mm.plugin.finder.cgi.fetcher.d(this.xHL.value, parambid, this.xfs);
    AppMethodBeat.o(270765);
  }
  
  public final List<Integer> colletExtraPageName()
  {
    AppMethodBeat.i(270763);
    Object localObject = new ArrayList();
    ((ArrayList)localObject).add(Integer.valueOf(4));
    localObject = (List)localObject;
    AppMethodBeat.o(270763);
    return localObject;
  }
  
  public final com.tencent.mm.plugin.finder.feed.model.internal.i<bu> createDataFetch()
  {
    AppMethodBeat.i(270754);
    com.tencent.mm.plugin.finder.feed.model.internal.i locali = (com.tencent.mm.plugin.finder.feed.model.internal.i)new b(this.xJp, this.xHL);
    AppMethodBeat.o(270754);
    return locali;
  }
  
  public final com.tencent.mm.plugin.finder.feed.model.internal.d<bu> createDataMerger()
  {
    AppMethodBeat.i(270757);
    com.tencent.mm.plugin.finder.feed.model.internal.d locald = (com.tencent.mm.plugin.finder.feed.model.internal.d)new e(this);
    AppMethodBeat.o(270757);
    return locald;
  }
  
  public final void duv()
  {
    AppMethodBeat.i(270764);
    getDataList().clear();
    Object localObject = this.wlv;
    if (localObject != null)
    {
      localObject = (RecyclerView)((WeakReference)localObject).get();
      if (localObject != null)
      {
        localObject = ((RecyclerView)localObject).getAdapter();
        if (localObject != null)
        {
          ((RecyclerView.a)localObject).notifyDataSetChanged();
          AppMethodBeat.o(270764);
          return;
        }
      }
    }
    AppMethodBeat.o(270764);
  }
  
  public final void eg(List<? extends BaseFinderFeed> paramList)
  {
    AppMethodBeat.i(270756);
    paramList = new c(this.xJs, paramList);
    if (paramList.xJx) {}
    for (paramList.pullType = 4;; paramList.pullType = this.xJs)
    {
      Log.i(getTAG(), "[requestRefresh] pullType=" + paramList.pullType + "  hasPrefetch=" + paramList.xJw + " needToRefreshForPrefetch=" + paramList.xJx);
      super.request(paramList, (com.tencent.mm.plugin.finder.feed.model.internal.h)this);
      if (this.xJs == 0) {
        this.xJs = 1;
      }
      AppMethodBeat.o(270756);
      return;
    }
  }
  
  public final int getPageName()
  {
    AppMethodBeat.i(270762);
    aj localaj = aj.AGc;
    int i = aj.QY(this.xHL.value);
    localaj = aj.AGc;
    i = aj.QW(i);
    AppMethodBeat.o(270762);
    return i;
  }
  
  public final boolean isObservePostEvent()
  {
    AppMethodBeat.i(270758);
    if (this.xHL != com.tencent.mm.plugin.finder.feed.model.internal.g.xKs)
    {
      com.tencent.mm.plugin.finder.storage.d locald = com.tencent.mm.plugin.finder.storage.d.AjH;
      if (((Number)com.tencent.mm.plugin.finder.storage.d.dTQ().aSr()).intValue() == 1) {}
    }
    else
    {
      AppMethodBeat.o(270758);
      return true;
    }
    AppMethodBeat.o(270758);
    return false;
  }
  
  public final void onDead()
  {
    AppMethodBeat.i(270761);
    super.onDead();
    this.xJp.xbq.dead();
    AppMethodBeat.o(270761);
  }
  
  public final void onFetchDone(IResponse<bu> paramIResponse)
  {
    AppMethodBeat.i(270755);
    p.k(paramIResponse, "response");
    super.onFetchDone(paramIResponse);
    com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)FinderTimelineFeedLoader.f.xJC);
    AppMethodBeat.o(270755);
  }
  
  public final void onPostStart(long paramLong)
  {
    AppMethodBeat.i(270760);
    super.onPostStart(paramLong);
    this.xJq = true;
    Log.i(getTAG(), "onPostStart postFeedFlag true");
    AppMethodBeat.o(270760);
  }
  
  public final void onPostStart(long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(270759);
    super.onPostStart(paramLong, paramBoolean);
    this.xJq = true;
    AppMethodBeat.o(270759);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/model/FinderTimelineFeedLoader$CgiConsumeCallback;", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderTimelineStream$ConsumeCallback;", "taskExecutor", "Lcom/tencent/mm/loader/loader/SingleTaskExecutor;", "task", "Lcom/tencent/mm/loader/loader/SingleTask;", "(Lcom/tencent/mm/loader/loader/SingleTaskExecutor;Lcom/tencent/mm/loader/loader/SingleTask;)V", "getTask", "()Lcom/tencent/mm/loader/loader/SingleTask;", "getTaskExecutor", "()Lcom/tencent/mm/loader/loader/SingleTaskExecutor;", "isFetchConsume", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/ResponseProtoBuf;", "plugin-finder_release"})
  static final class a
    implements ab.c
  {
    private final com.tencent.mm.loader.g.h xHa;
    private final com.tencent.mm.loader.g.i xeM;
    
    public a(com.tencent.mm.loader.g.i parami, com.tencent.mm.loader.g.h paramh)
    {
      AppMethodBeat.i(285441);
      this.xeM = parami;
      this.xHa = paramh;
      AppMethodBeat.o(285441);
    }
    
    public final boolean b(dyy paramdyy)
    {
      AppMethodBeat.i(285440);
      p.k(paramdyy, "resp");
      if ((this.xeM != null) && (this.xeM.kPS != this.xHa.kPS))
      {
        this.xHa.a(com.tencent.mm.loader.g.j.kQd);
        Log.w("CgiConsumeCallback", "[isFetchConsume] executorToken=" + this.xeM.kPS + " taskToken=" + this.xHa.kPS);
        AppMethodBeat.o(285440);
        return true;
      }
      AppMethodBeat.o(285440);
      return false;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/model/FinderTimelineFeedLoader$TimelineDataFetcher;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataFetch;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycleKeeper;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycle;", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderTimelineStream$Callback;", "streamFetcher", "Lcom/tencent/mm/plugin/finder/cgi/fetcher/FinderTimelineFeedFetcher;", "scene", "Lcom/tencent/mm/plugin/finder/feed/model/internal/FinderLoaderScene;", "(Lcom/tencent/mm/plugin/finder/feed/model/FinderTimelineFeedLoader;Lcom/tencent/mm/plugin/finder/cgi/fetcher/FinderTimelineFeedFetcher;Lcom/tencent/mm/plugin/finder/feed/model/internal/FinderLoaderScene;)V", "taskExecutor", "Lcom/tencent/mm/loader/loader/SingleTaskExecutor;", "alive", "", "dead", "fetch", "request", "", "callback", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataCallback;", "fetchInit", "fetchLoadMore", "fetchRefresh", "keep", "p0", "onFetchDone", "info", "Lcom/tencent/mm/plugin/finder/feed/model/CgiFinderStreamResult;", "pullType", "", "plugin-finder_release"})
  public final class b
    extends com.tencent.mm.plugin.finder.feed.model.internal.i<bu>
    implements ab.a, com.tencent.mm.vending.e.b<com.tencent.mm.vending.e.a>
  {
    private final com.tencent.mm.plugin.finder.feed.model.internal.g xHL;
    private final com.tencent.mm.plugin.finder.cgi.fetcher.d xJp;
    private com.tencent.mm.loader.g.i xeM;
    
    public b(com.tencent.mm.plugin.finder.feed.model.internal.g paramg)
    {
      AppMethodBeat.i(290757);
      this.xJp = paramg;
      this.xHL = localObject;
      AppMethodBeat.o(290757);
    }
    
    public final void a(d paramd, int paramInt)
    {
      AppMethodBeat.i(290752);
      p.k(paramd, "info");
      AppMethodBeat.o(290752);
    }
    
    public final void alive()
    {
      AppMethodBeat.i(290754);
      super.alive();
      if (this.xHL == com.tencent.mm.plugin.finder.feed.model.internal.g.xKo)
      {
        this.xeM = ((PluginFinder)com.tencent.mm.kernel.h.ag(PluginFinder.class)).getFollowTlSingleExecutor();
        locali = this.xeM;
        if (locali != null)
        {
          locali.clean();
          AppMethodBeat.o(290754);
          return;
        }
        AppMethodBeat.o(290754);
        return;
      }
      com.tencent.mm.loader.g.i locali = new com.tencent.mm.loader.g.i("SingleExecutor#TabType=" + this.xJp.fEH);
      locali.start();
      this.xeM = locali;
      AppMethodBeat.o(290754);
    }
    
    public final void dead()
    {
      AppMethodBeat.i(290755);
      super.dead();
      com.tencent.mm.loader.g.i locali = this.xeM;
      if (locali != null) {
        locali.reset();
      }
      this.xeM = null;
      AppMethodBeat.o(290755);
    }
    
    public final void fetch(final Object paramObject, com.tencent.mm.plugin.finder.feed.model.internal.h<bu> paramh)
    {
      AppMethodBeat.i(290756);
      p.k(paramh, "callback");
      if ((paramObject instanceof FinderTimelineFeedLoader.c))
      {
        final long l = SystemClock.uptimeMillis();
        com.tencent.mm.loader.g.i locali = this.xeM;
        if (locali != null)
        {
          locali.a(new com.tencent.mm.loader.g.h((kotlin.g.a.b)new a(this, paramObject, l, paramh)));
          AppMethodBeat.o(290756);
          return;
        }
      }
      AppMethodBeat.o(290756);
    }
    
    public final void fetchInit(com.tencent.mm.plugin.finder.feed.model.internal.h<bu> paramh)
    {
      AppMethodBeat.i(290753);
      p.k(paramh, "callback");
      Object localObject1 = aq.xBP;
      int i = this.xJp.fEH;
      label98:
      Object localObject2;
      boolean bool;
      label126:
      Object localObject3;
      Object localObject4;
      label200:
      label235:
      long l;
      if (i == 4)
      {
        localObject1 = com.tencent.mm.ui.component.g.Xox;
        localObject1 = com.tencent.mm.ui.component.g.bD(PluginFinder.class).i(com.tencent.mm.plugin.finder.viewmodel.b.class);
        p.j(localObject1, "UICProvider.of(PluginFin…meTabStateVM::class.java)");
        if ((((com.tencent.mm.plugin.finder.viewmodel.b)localObject1).OO(i)) && ((aq.dtr()) || ((aq.dts()) && (aq.Mz(i)))))
        {
          i = 1;
          if (i == 0) {
            break label416;
          }
          localObject1 = (List)v.aaAd;
          localObject2 = com.tencent.mm.plugin.finder.report.j.zVy;
          i = this.xJp.fEH;
          if (((Collection)localObject1).isEmpty()) {
            break label458;
          }
          bool = true;
          com.tencent.mm.plugin.finder.report.j.aq(i, bool);
          localObject2 = (bu)kotlin.a.j.lp((List)localObject1);
          localObject3 = getTAG();
          localObject4 = new StringBuilder("fetchInit tabType=").append(this.xJp.fEH).append(" callInitData scene=").append(this.xHL).append(", contextObj=");
          if (FinderTimelineFeedLoader.this.getContextObj() != null) {
            break label463;
          }
          bool = true;
          localObject4 = ((StringBuilder)localObject4).append(bool).append(" list first=");
          if (!(localObject2 instanceof BaseFinderFeed)) {
            break label468;
          }
          localObject2 = ((BaseFinderFeed)localObject2).feedObject.getNickName();
          localObject2 = ((StringBuilder)localObject4).append((String)localObject2).append(" => ");
          localObject4 = (bu)kotlin.a.j.lp((List)localObject1);
          if (localObject4 == null) {
            break label476;
          }
          l = ((bu)localObject4).mf();
          label274:
          Log.i((String)localObject3, com.tencent.mm.ae.d.Fw(l));
          localObject2 = new FinderTimelineFeedLoader.d(0, 0, "", (byte)0);
          localObject3 = (Iterable)localObject1;
          localObject1 = (Collection)new ArrayList();
          localObject3 = ((Iterable)localObject3).iterator();
        }
      }
      label335:
      label468:
      label476:
      label485:
      for (;;)
      {
        if (!((Iterator)localObject3).hasNext()) {
          break label487;
        }
        localObject4 = ((Iterator)localObject3).next();
        bu localbu = (bu)localObject4;
        if ((localbu instanceof BaseFinderFeed)) {
          aj localaj = aj.AGc;
        }
        for (bool = aj.w(((BaseFinderFeed)localbu).feedObject.getFeedObject());; bool = true)
        {
          if (!bool) {
            break label485;
          }
          ((Collection)localObject1).add(localObject4);
          break label335;
          i = 0;
          break;
          i = 0;
          break;
          localObject1 = aj.a(aj.AGc, this.xHL.value, FinderTimelineFeedLoader.this.getContextObj(), FinderTimelineFeedLoader.this.getPageName(), false, this.xJp.fEH, 8);
          break label98;
          bool = false;
          break label126;
          bool = false;
          break label200;
          localObject2 = "";
          break label235;
          l = 0L;
          break label274;
        }
      }
      label416:
      label458:
      label463:
      label487:
      ((FinderTimelineFeedLoader.d)localObject2).setIncrementList((List)localObject1);
      ((FinderTimelineFeedLoader.d)localObject2).setPullType(1000);
      paramh.onFetchDone((IResponse)localObject2);
      AppMethodBeat.o(290753);
    }
    
    public final void fetchLoadMore(com.tencent.mm.plugin.finder.feed.model.internal.h<bu> paramh)
    {
      AppMethodBeat.i(290750);
      p.k(paramh, "callback");
      fetch(new FinderTimelineFeedLoader.c(2), paramh);
      AppMethodBeat.o(290750);
    }
    
    public final void fetchRefresh(com.tencent.mm.plugin.finder.feed.model.internal.h<bu> paramh)
    {
      AppMethodBeat.i(290749);
      p.k(paramh, "callback");
      FinderTimelineFeedLoader.c localc = new FinderTimelineFeedLoader.c(FinderTimelineFeedLoader.this.xJs);
      if (localc.xJx) {}
      for (localc.pullType = 4;; localc.pullType = FinderTimelineFeedLoader.this.xJs)
      {
        if (FinderTimelineFeedLoader.this.xJs == 0) {
          FinderTimelineFeedLoader.this.xJs = 1;
        }
        Log.i(getTAG(), "[requestRefresh] pullType=" + localc.pullType + "  hasPrefetch=" + localc.xJw + " needToRefreshForPrefetch=" + localc.xJx);
        fetch(localc, paramh);
        AppMethodBeat.o(290749);
        return;
      }
    }
    
    public final void keep(com.tencent.mm.vending.e.a parama)
    {
      AppMethodBeat.i(290751);
      p.k(parama, "p0");
      AppMethodBeat.o(290751);
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "task", "Lcom/tencent/mm/loader/loader/SingleTask;", "invoke"})
    static final class a
      extends kotlin.g.b.q
      implements kotlin.g.a.b<com.tencent.mm.loader.g.h, kotlin.x>
    {
      a(FinderTimelineFeedLoader.b paramb, Object paramObject, long paramLong, com.tencent.mm.plugin.finder.feed.model.internal.h paramh)
      {
        super();
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/model/FinderTimelineFeedLoader$TimelineRequest;", "", "pullType", "", "unreadList", "", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "(ILjava/util/List;)V", "hasPrefetch", "", "getHasPrefetch", "()Z", "setHasPrefetch", "(Z)V", "isPreloadMore", "setPreloadMore", "minDuration", "", "getMinDuration", "()J", "setMinDuration", "(J)V", "needToRefreshForPrefetch", "getNeedToRefreshForPrefetch", "setNeedToRefreshForPrefetch", "getPullType", "()I", "setPullType", "(I)V", "getUnreadList", "()Ljava/util/List;", "setUnreadList", "(Ljava/util/List;)V", "plugin-finder_release"})
  public static final class c
  {
    int pullType;
    boolean xJw;
    boolean xJx;
    long xJy;
    boolean xJz;
    List<? extends BaseFinderFeed> xam;
    
    public c(int paramInt, List<? extends BaseFinderFeed> paramList)
    {
      this.pullType = paramInt;
      this.xam = paramList;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/model/FinderTimelineFeedLoader$TimelineResponse;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "errType", "", "errCode", "errMsg", "", "extraData", "", "(IILjava/lang/String;Ljava/lang/Object;)V", "dataBufferList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getDataBufferList", "()Ljava/util/ArrayList;", "setDataBufferList", "(Ljava/util/ArrayList;)V", "getExtraData", "()Ljava/lang/Object;", "setExtraData", "(Ljava/lang/Object;)V", "plugin-finder_release"})
  public static final class d
    extends IResponse<bu>
  {
    ArrayList<bu> xFM;
    public Object xJA = null;
    
    private d(int paramInt1, int paramInt2, String paramString)
    {
      super(paramInt2, paramString);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/feed/model/FinderTimelineFeedLoader$createDataMerger$1", "Lcom/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader$DefaultDataMerger;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "isDebug", "", "cleanDataList", "", "dataList", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataBuffer;", "mergeDataAndNotify", "Lcom/tencent/mm/plugin/finder/feed/model/internal/MergeResult;", "cmd", "", "insList", "", "isNeedClear", "request", "", "mergeLoadMore", "response", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "next", "Lkotlin/Function1;", "mergeRefresh", "needCleanWhenRefresh", "newList", "notifyLiveListChange", "liveStatus", "username", "", "onDataReplace", "feed", "existIndex", "updateLiveList", "plugin-finder_release"})
  public static final class e
    extends BaseFeedLoader<bu>.a
  {
    private final boolean dal;
    
    e()
    {
      super();
      AppMethodBeat.i(288835);
      if ((BuildInfo.IS_FLAVOR_PURPLE) || (BuildInfo.IS_FLAVOR_RED) || (CrashReportFactory.hasDebuger())) {}
      for (boolean bool = true;; bool = false)
      {
        this.dal = bool;
        AppMethodBeat.o(288835);
        return;
      }
    }
    
    private static void aX(int paramInt, String paramString)
    {
      AppMethodBeat.i(288831);
      Object localObject = (CharSequence)paramString;
      if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {}
      for (int i = 1;; i = 0)
      {
        if (i == 0)
        {
          localObject = new hu();
          ((hu)localObject).fEL.fEN = 0;
          ((hu)localObject).fEL.liveStatus = paramInt;
          ((hu)localObject).fEL.username = paramString;
          ((hu)localObject).fEL.type = 9;
          EventCenter.instance.publish((IEvent)localObject);
        }
        AppMethodBeat.o(288831);
        return;
      }
    }
    
    public final void cleanDataList(DataBuffer<bu> paramDataBuffer)
    {
      AppMethodBeat.i(288830);
      p.k(paramDataBuffer, "dataList");
      super.cleanDataList(paramDataBuffer);
      AppMethodBeat.o(288830);
    }
    
    public final n mergeDataAndNotify(int paramInt, List<? extends bu> paramList, boolean paramBoolean, Object paramObject)
    {
      Object localObject2 = null;
      com.tencent.mm.plugin.finder.model.x localx1 = null;
      Object localObject3 = null;
      AppMethodBeat.i(288832);
      int i;
      int j;
      if (!paramBoolean)
      {
        localObject1 = ((List)this.xJt.getDataList()).iterator();
        i = 0;
        if (((Iterator)localObject1).hasNext()) {
          if (((bu)((Iterator)localObject1).next() instanceof com.tencent.mm.plugin.finder.model.x))
          {
            j = i;
            label68:
            if (paramList == null) {
              break label502;
            }
            localObject1 = paramList.iterator();
            i = 0;
            label83:
            if (!((Iterator)localObject1).hasNext()) {
              break label496;
            }
            if (!((bu)((Iterator)localObject1).next() instanceof com.tencent.mm.plugin.finder.model.x)) {
              break label487;
            }
            label109:
            if ((j != -1) || (i == -1)) {
              break label514;
            }
            if (paramList == null) {
              break label508;
            }
            localObject2 = (bu)paramList.get(i);
            if (localObject2 == null) {
              break label508;
            }
            this.xJt.getDataList().add(0, localObject2);
            this.xJt.dispatcher().onItemRangeInserted(0, 1);
            localObject1 = com.tencent.mm.plugin.finder.model.d.zAb;
            if ((localObject2 instanceof com.tencent.mm.plugin.finder.model.x)) {
              break label1253;
            }
          }
        }
      }
      label460:
      label856:
      label996:
      label1253:
      for (Object localObject1 = null;; localObject1 = localObject2)
      {
        localx1 = (com.tencent.mm.plugin.finder.model.x)localObject1;
        localObject1 = localObject3;
        if (localx1 != null) {
          localObject1 = localx1.dKy();
        }
        localObject1 = d.a.an((ArrayList)localObject1);
        aX(1, (String)localObject1);
        Log.i(this.xJt.getTAG(), "[updateLiveList] add " + localObject2 + ", live update:true, incrementUsernameString:" + (String)localObject1);
        label487:
        label496:
        label502:
        label508:
        for (boolean bool = true;; bool = false)
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
                Log.i(this.xJt.getTAG(), "isNeedClear false, manual merge...");
                localObject1 = merge(paramList, 1, paramObject);
                ((n)localObject1).xKO = 0;
              }
            }
          }
          if (!this.dal) {
            break label1054;
          }
          if ((this.xJt.xJp.fEH != 4) || (paramInt != 1)) {
            break label1075;
          }
          paramObject = this.xJt.getTAG() + "#loadMore";
          paramList = (Iterable)this.xJt.getDataList();
          localObject2 = (Collection)new ArrayList(kotlin.a.j.a(paramList, 10));
          localObject3 = paramList.iterator();
          for (;;)
          {
            if (!((Iterator)localObject3).hasNext()) {
              break label1041;
            }
            paramList = (bu)((Iterator)localObject3).next();
            if (!(paramList instanceof BaseFinderFeed)) {
              break;
            }
            paramList = com.tencent.mm.ae.d.Fw(((BaseFinderFeed)paramList).feedObject.getFeedObject().id);
            ((Collection)localObject2).add(paramList);
          }
          i += 1;
          break;
          j = -1;
          break label68;
          i += 1;
          break label83;
          i = -1;
          break label109;
          i = -1;
          break label109;
        }
        if ((j != -1) && (i == -1))
        {
          localObject1 = this.xJt.getDataList().remove(j);
          p.j(localObject1, "dataList.removeAt(oriLiveItemIndex)");
          localObject3 = (bu)localObject1;
          this.xJt.dispatcher().onItemRangeRemoved(j, 1);
          localObject1 = com.tencent.mm.plugin.finder.model.d.zAb;
          if ((localObject3 instanceof com.tencent.mm.plugin.finder.model.x)) {
            break label1246;
          }
        }
        for (localObject1 = null;; localObject1 = localObject3)
        {
          localx1 = (com.tencent.mm.plugin.finder.model.x)localObject1;
          localObject1 = localObject2;
          if (localx1 != null) {
            localObject1 = localx1.dKy();
          }
          localObject1 = d.a.an((ArrayList)localObject1);
          aX(2, (String)localObject1);
          Log.i(this.xJt.getTAG(), "[updateLiveList] remove " + localObject3 + ", live update:false, removeUsernameString:" + (String)localObject1);
          bool = false;
          break;
          if ((j != -1) && (i != -1) && (paramList != null))
          {
            localObject3 = (bu)paramList.get(i);
            if (localObject3 != null)
            {
              localObject1 = com.tencent.mm.plugin.finder.model.d.zAb;
              localObject2 = this.xJt.getDataList().get(j);
              localObject1 = localObject2;
              if (!(localObject2 instanceof com.tencent.mm.plugin.finder.model.x)) {
                localObject1 = null;
              }
              localObject1 = (com.tencent.mm.plugin.finder.model.x)localObject1;
              if (localObject1 != null)
              {
                localObject1 = ((com.tencent.mm.plugin.finder.model.x)localObject1).dKy();
                label752:
                if ((localObject3 instanceof com.tencent.mm.plugin.finder.model.x)) {
                  break label1239;
                }
              }
            }
          }
          for (localObject2 = null;; localObject2 = localObject3)
          {
            com.tencent.mm.plugin.finder.model.x localx2 = (com.tencent.mm.plugin.finder.model.x)localObject2;
            localObject2 = localx1;
            if (localx2 != null) {
              localObject2 = localx2.dKy();
            }
            localObject1 = d.a.h((ArrayList)localObject1, (ArrayList)localObject2);
            localObject2 = (Collection)((com.tencent.mm.plugin.finder.model.d)localObject1).zzY;
            if ((localObject2 == null) || (((Collection)localObject2).isEmpty()))
            {
              i = 1;
              if (i != 0)
              {
                localObject2 = (Collection)((com.tencent.mm.plugin.finder.model.d)localObject1).rho;
                if ((localObject2 != null) && (!((Collection)localObject2).isEmpty())) {
                  break label996;
                }
                i = 1;
                if (i != 0) {
                  break label1002;
                }
              }
            }
            label1002:
            for (bool = true;; bool = false)
            {
              aX(1, ((com.tencent.mm.plugin.finder.model.d)localObject1).zzZ);
              aX(2, ((com.tencent.mm.plugin.finder.model.d)localObject1).zAa);
              this.xJt.getDataList().set(j, localObject3);
              Log.i(this.xJt.getTAG(), "[updateLiveList] replace " + localObject3 + ", live update:" + bool + ", incrememnt username:" + ((com.tencent.mm.plugin.finder.model.d)localObject1).zzZ + ",remove username:" + ((com.tencent.mm.plugin.finder.model.d)localObject1).zAa);
              if (!bool) {
                break label1008;
              }
              this.xJt.dispatcher().MF(j);
              break;
              localObject1 = null;
              break label752;
              i = 0;
              break label823;
              i = 0;
              break label856;
            }
            label1008:
            this.xJt.dispatcher().onItemRangeChanged(j, 1, Integer.valueOf(1));
            break;
            bool = false;
            break;
            paramList = "";
            break label460;
            Log.i(paramObject, String.valueOf((List)localObject2));
            for (;;)
            {
              ((n)localObject1).xKR |= bool;
              AppMethodBeat.o(288832);
              return localObject1;
              if ((this.xJt.xJp.fEH == 4) && (paramInt == 4))
              {
                paramObject = this.xJt.getTAG() + "#refresh";
                paramList = (Iterable)this.xJt.getDataList();
                localObject2 = (Collection)new ArrayList(kotlin.a.j.a(paramList, 10));
                localObject3 = paramList.iterator();
                if (((Iterator)localObject3).hasNext())
                {
                  paramList = (bu)((Iterator)localObject3).next();
                  if ((paramList instanceof BaseFinderFeed)) {}
                  for (paramList = com.tencent.mm.ae.d.Fw(((BaseFinderFeed)paramList).feedObject.getFeedObject().id);; paramList = "")
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
      }
    }
    
    public final void mergeLoadMore(final IResponse<bu> paramIResponse, final kotlin.g.a.b<? super IResponse<bu>, kotlin.x> paramb)
    {
      int i = 1;
      AppMethodBeat.i(288828);
      p.k(paramIResponse, "response");
      if ((paramIResponse instanceof FinderTimelineFeedLoader.d)) {
        this.xJt.getDataListJustForAdapter().setBuffer((Collection)((FinderTimelineFeedLoader.d)paramIResponse).xFM);
      }
      final RefreshLoadMoreLayout.c localc = new RefreshLoadMoreLayout.c(paramIResponse.getPullType());
      localc.YNF = paramIResponse.getHasMore();
      Context localContext = MMApplicationContext.getContext();
      p.j(localContext, "MMApplicationContext.getContext()");
      localc.YNE = ((CharSequence)localContext.getResources().getString(b.j.finder_timeline_history_footer_tip));
      localc.YND = 2;
      boolean bool;
      if (!paramIResponse.getHasMore())
      {
        bool = true;
        localc.mCI = bool;
        Log.i(this.xJt.getTAG(), "[onFetchLoadMoreDone]  reason=".concat(String.valueOf(localc)));
        if (!paramIResponse.getHasMore()) {
          break label194;
        }
      }
      for (;;)
      {
        com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new a(this, new com.tencent.mm.plugin.finder.feed.model.internal.q(i, paramIResponse.getIncrementList(), false, 12), localc, paramb, paramIResponse));
        AppMethodBeat.o(288828);
        return;
        bool = false;
        break;
        label194:
        i = 5;
      }
    }
    
    public final void mergeRefresh(final IResponse<bu> paramIResponse, final kotlin.g.a.b<? super IResponse<bu>, kotlin.x> paramb)
    {
      AppMethodBeat.i(288826);
      p.k(paramIResponse, "response");
      final RefreshLoadMoreLayout.c localc = new RefreshLoadMoreLayout.c(paramIResponse.getPullType());
      Object localObject;
      boolean bool;
      if ((paramIResponse.getErrType() == 0) && (paramIResponse.getErrCode() == 0))
      {
        localc.YND = 1;
        localObject = this.xJt.xJr;
        if (localObject != null) {
          ((kotlin.g.a.b)localObject).invoke(paramIResponse);
        }
        if (paramIResponse.getPullType() == 0) {
          break label276;
        }
        bool = true;
        label79:
        localc.mCI = bool;
        localc.YNF = paramIResponse.getHasMore();
        if ((paramIResponse.getErrType() == 0) && (paramIResponse.getErrCode() == 0) && ((localc.actionType == 0) || (localc.actionType == 4) || (localc.actionType == 1)))
        {
          if ((localc.YNG <= 0) && (this.xJt.getDataListJustForAdapter().size() > 0)) {
            break label282;
          }
          localc.YNE = null;
        }
        label162:
        Log.i(this.xJt.getTAG(), "[onFetchRefreshDone]  reason=".concat(String.valueOf(localc)));
        if (!paramIResponse.getHasMore()) {
          break label317;
        }
      }
      label276:
      label282:
      label317:
      for (int i = 4;; i = 6)
      {
        com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new b(this, new com.tencent.mm.plugin.finder.feed.model.internal.q(i, paramIResponse.getIncrementList(), paramIResponse.isNeedClear(), 8), localc, paramb, paramIResponse));
        AppMethodBeat.o(288826);
        return;
        localObject = MMApplicationContext.getContext();
        p.j(localObject, "MMApplicationContext.getContext()");
        localc.YNE = ((CharSequence)((Context)localObject).getResources().getString(b.j.finder_tl_no_more_refresh_nomore_err_header));
        localc.YND = -1;
        break;
        bool = false;
        break label79;
        localObject = MMApplicationContext.getContext();
        p.j(localObject, "MMApplicationContext.getContext()");
        localc.YNE = ((CharSequence)((Context)localObject).getResources().getString(b.j.finder_tl_no_more_refresh_nomore_newcontent_header));
        break label162;
      }
    }
    
    public final boolean needCleanWhenRefresh(List<? extends bu> paramList)
    {
      AppMethodBeat.i(288834);
      p.k(paramList, "newList");
      AppMethodBeat.o(288834);
      return true;
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
    static final class a
      extends kotlin.g.b.q
      implements kotlin.g.a.a<kotlin.x>
    {
      a(FinderTimelineFeedLoader.e parame, com.tencent.mm.plugin.finder.feed.model.internal.q paramq, RefreshLoadMoreLayout.c paramc, kotlin.g.a.b paramb, IResponse paramIResponse)
      {
        super();
      }
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
    static final class b
      extends kotlin.g.b.q
      implements kotlin.g.a.a<kotlin.x>
    {
      b(FinderTimelineFeedLoader.e parame, com.tencent.mm.plugin.finder.feed.model.internal.q paramq, RefreshLoadMoreLayout.c paramc, kotlin.g.a.b paramb, IResponse paramIResponse)
      {
        super();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.model.FinderTimelineFeedLoader
 * JD-Core Version:    0.7.0.1
 */
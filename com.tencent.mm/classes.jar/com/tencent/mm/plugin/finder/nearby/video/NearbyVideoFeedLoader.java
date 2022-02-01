package com.tencent.mm.plugin.finder.nearby.video;

import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.cgi.ab.a;
import com.tencent.mm.plugin.finder.cgi.ab.c;
import com.tencent.mm.plugin.finder.cgi.am;
import com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader.a;
import com.tencent.mm.plugin.finder.feed.model.internal.DataBuffer;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.bu;
import com.tencent.mm.plugin.finder.model.w;
import com.tencent.mm.plugin.finder.model.z;
import com.tencent.mm.plugin.finder.report.n;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.data.e;
import com.tencent.mm.plugin.finder.storage.data.e.a;
import com.tencent.mm.plugin.finder.storage.data.k.a;
import com.tencent.mm.plugin.finder.utils.aj;
import com.tencent.mm.plugin.finder.viewmodel.b.a;
import com.tencent.mm.protocal.protobuf.bac;
import com.tencent.mm.protocal.protobuf.bid;
import com.tencent.mm.protocal.protobuf.dyy;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.component.g.a;
import com.tencent.mm.vending.e.c;
import com.tencent.mm.view.RefreshLoadMoreLayout.c;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.a.b<-Lcom.tencent.mm.plugin.finder.feed.model.internal.IResponse<Lcom.tencent.mm.plugin.finder.model.bu;>;Lkotlin.x;>;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/nearby/video/NearbyVideoFeedLoader;", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "scene", "Lcom/tencent/mm/plugin/finder/feed/model/internal/FinderLoaderScene;", "firstLoad", "", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Lcom/tencent/mm/plugin/finder/feed/model/internal/FinderLoaderScene;ILcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "getFirstLoad", "()I", "setFirstLoad", "(I)V", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "getRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "setRecyclerView", "(Landroidx/recyclerview/widget/RecyclerView;)V", "getScene", "()Lcom/tencent/mm/plugin/finder/feed/model/internal/FinderLoaderScene;", "streamFetcher", "Lcom/tencent/mm/plugin/finder/nearby/video/NearbyVideoFeedFetcher;", "getStreamFetcher", "()Lcom/tencent/mm/plugin/finder/nearby/video/NearbyVideoFeedFetcher;", "colletExtraPageName", "", "createDataFetch", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataFetch;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "createDataMerger", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataMerger;", "getPageName", "onDead", "", "preloadMoreToBuffer", "callback", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataCallback;", "printVisibleFeeds", "", "hasVisibleFeeds", "Landroid/util/LongSparseArray;", "requestRefresh", "unreadList", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "TimelineDataFetcher", "TimelineRequest", "TimelineResponse", "plugin-finder-nearby_release"})
public final class NearbyVideoFeedLoader
  extends BaseFinderFeedLoader
{
  private final com.tencent.mm.plugin.finder.feed.model.internal.g xHL;
  int xJs;
  private final b zJG;
  
  public NearbyVideoFeedLoader(com.tencent.mm.plugin.finder.feed.model.internal.g paramg, int paramInt, bid parambid)
  {
    super(parambid);
    AppMethodBeat.i(200390);
    this.xHL = paramg;
    this.xJs = paramInt;
    this.zJG = new b(this.xHL.value, parambid);
    AppMethodBeat.o(200390);
  }
  
  public final List<Integer> colletExtraPageName()
  {
    AppMethodBeat.i(200388);
    Object localObject = new ArrayList();
    ((ArrayList)localObject).add(Integer.valueOf(4));
    localObject = (List)localObject;
    AppMethodBeat.o(200388);
    return localObject;
  }
  
  public final com.tencent.mm.plugin.finder.feed.model.internal.i<bu> createDataFetch()
  {
    AppMethodBeat.i(200377);
    com.tencent.mm.plugin.finder.feed.model.internal.i locali = (com.tencent.mm.plugin.finder.feed.model.internal.i)new a(this.zJG, this.xHL);
    AppMethodBeat.o(200377);
    return locali;
  }
  
  public final com.tencent.mm.plugin.finder.feed.model.internal.d<bu> createDataMerger()
  {
    AppMethodBeat.i(200378);
    com.tencent.mm.plugin.finder.feed.model.internal.d locald = (com.tencent.mm.plugin.finder.feed.model.internal.d)new d(this);
    AppMethodBeat.o(200378);
    return locald;
  }
  
  public final int getPageName()
  {
    AppMethodBeat.i(200384);
    aj localaj = aj.AGc;
    int i = aj.QY(this.xHL.value);
    localaj = aj.AGc;
    i = aj.QW(i);
    AppMethodBeat.o(200384);
    return i;
  }
  
  public final void onDead()
  {
    AppMethodBeat.i(200381);
    super.onDead();
    this.zJG.xbq.dead();
    AppMethodBeat.o(200381);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/nearby/video/NearbyVideoFeedLoader$TimelineDataFetcher;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataFetch;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycleKeeper;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycle;", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderTimelineStream$Callback;", "streamFetcher", "Lcom/tencent/mm/plugin/finder/nearby/video/NearbyVideoFeedFetcher;", "scene", "Lcom/tencent/mm/plugin/finder/feed/model/internal/FinderLoaderScene;", "(Lcom/tencent/mm/plugin/finder/nearby/video/NearbyVideoFeedLoader;Lcom/tencent/mm/plugin/finder/nearby/video/NearbyVideoFeedFetcher;Lcom/tencent/mm/plugin/finder/feed/model/internal/FinderLoaderScene;)V", "taskExecutor", "Lcom/tencent/mm/loader/loader/SingleTaskExecutor;", "alive", "", "dead", "fetch", "request", "", "callback", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataCallback;", "fetchInit", "fetchLoadMore", "fetchRefresh", "keep", "target", "onFetchDone", "info", "Lcom/tencent/mm/plugin/finder/feed/model/CgiFinderStreamResult;", "pullType", "", "plugin-finder-nearby_release"})
  public final class a
    extends com.tencent.mm.plugin.finder.feed.model.internal.i<bu>
    implements ab.a, com.tencent.mm.vending.e.b<com.tencent.mm.vending.e.a>
  {
    private final com.tencent.mm.plugin.finder.feed.model.internal.g xHL;
    private com.tencent.mm.loader.g.i xeM;
    private final b zJG;
    
    public a(com.tencent.mm.plugin.finder.feed.model.internal.g paramg)
    {
      AppMethodBeat.i(199636);
      this.zJG = paramg;
      this.xHL = localObject;
      AppMethodBeat.o(199636);
    }
    
    public final void a(com.tencent.mm.plugin.finder.feed.model.d paramd, int paramInt)
    {
      AppMethodBeat.i(199635);
      p.k(paramd, "info");
      AppMethodBeat.o(199635);
    }
    
    public final void alive()
    {
      AppMethodBeat.i(199629);
      super.alive();
      if (this.xHL == com.tencent.mm.plugin.finder.feed.model.internal.g.xKo)
      {
        this.xeM = ((PluginFinder)com.tencent.mm.kernel.h.ag(PluginFinder.class)).getFollowTlSingleExecutor();
        locali = this.xeM;
        if (locali != null)
        {
          locali.clean();
          AppMethodBeat.o(199629);
          return;
        }
        AppMethodBeat.o(199629);
        return;
      }
      com.tencent.mm.loader.g.i locali = new com.tencent.mm.loader.g.i("SingleExecutor#TabType=" + this.zJG.fEH);
      locali.start();
      this.xeM = locali;
      AppMethodBeat.o(199629);
    }
    
    public final void dead()
    {
      AppMethodBeat.i(199630);
      super.dead();
      com.tencent.mm.loader.g.i locali = this.xeM;
      if (locali != null) {
        locali.reset();
      }
      this.xeM = null;
      AppMethodBeat.o(199630);
    }
    
    public final void fetch(final Object paramObject, com.tencent.mm.plugin.finder.feed.model.internal.h<bu> paramh)
    {
      AppMethodBeat.i(199634);
      p.k(paramh, "callback");
      if ((paramObject instanceof NearbyVideoFeedLoader.b))
      {
        final long l = SystemClock.uptimeMillis();
        com.tencent.mm.loader.g.i locali = this.xeM;
        if (locali != null)
        {
          locali.a(new com.tencent.mm.loader.g.h((kotlin.g.a.b)new a(this, paramObject, l, paramh)));
          AppMethodBeat.o(199634);
          return;
        }
      }
      AppMethodBeat.o(199634);
    }
    
    public final void fetchInit(com.tencent.mm.plugin.finder.feed.model.internal.h<bu> paramh)
    {
      AppMethodBeat.i(199628);
      p.k(paramh, "callback");
      Object localObject2 = new LinkedList();
      Object localObject1 = com.tencent.mm.ui.component.g.Xox;
      localObject1 = ((com.tencent.mm.plugin.finder.viewmodel.b)com.tencent.mm.ui.component.g.bD(PluginFinder.class).i(com.tencent.mm.plugin.finder.viewmodel.b.class)).RI(this.xHL.value);
      Object localObject3;
      Object localObject4;
      Object localObject5;
      Object localObject6;
      boolean bool;
      label534:
      label611:
      long l;
      if (((b.a)localObject1).Bgw.isEmpty())
      {
        localObject1 = k.a.a(com.tencent.mm.plugin.finder.storage.data.k.Anu, NearbyVideoFeedLoader.this.getPageName());
        localObject3 = ((Iterable)localObject1).iterator();
        while (((Iterator)localObject3).hasNext())
        {
          localObject4 = (bu)((Iterator)localObject3).next();
          if ((localObject4 instanceof BaseFinderFeed))
          {
            localObject5 = NearbyVideoFeedLoader.this.getContextObj();
            if (localObject5 != null)
            {
              localObject6 = n.zWF;
              n.a(((BaseFinderFeed)localObject4).feedObject.getFeedObject(), ((bid)localObject5).xkX);
            }
            localObject4 = ((Iterable)((BaseFinderFeed)localObject4).feedObject.getFoldedFeedList()).iterator();
            while (((Iterator)localObject4).hasNext())
            {
              localObject5 = (BaseFinderFeed)((Iterator)localObject4).next();
              localObject6 = n.zWF;
              n.a(((BaseFinderFeed)localObject5).feedObject.getFeedObject(), 14);
            }
          }
        }
        localObject3 = NearbyVideoFeedLoader.this.getContextObj();
        if (localObject3 != null)
        {
          localObject4 = e.AmW;
          i = ((bid)localObject3).xkX;
          localObject4 = (Iterable)localObject1;
          localObject3 = (Collection)new ArrayList();
          localObject4 = ((Iterable)localObject4).iterator();
          while (((Iterator)localObject4).hasNext())
          {
            localObject5 = ((Iterator)localObject4).next();
            if (((bu)localObject5 instanceof BaseFinderFeed)) {
              ((Collection)localObject3).add(localObject5);
            }
          }
          localObject4 = (Iterable)localObject3;
          localObject3 = (Collection)new ArrayList(kotlin.a.j.a((Iterable)localObject4, 10));
          localObject4 = ((Iterable)localObject4).iterator();
          while (((Iterator)localObject4).hasNext())
          {
            localObject5 = (bu)((Iterator)localObject4).next();
            if (localObject5 == null)
            {
              paramh = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.model.BaseFinderFeed");
              AppMethodBeat.o(199628);
              throw paramh;
            }
            ((Collection)localObject3).add(((BaseFinderFeed)localObject5).feedObject.getFeedObject());
          }
          e.a.m(i, (List)localObject3);
        }
        ((LinkedList)localObject2).addAll((Collection)localObject1);
        localObject1 = NearbyVideoFeedLoader.this.getContextObj();
        if (localObject1 != null)
        {
          localObject3 = com.tencent.mm.ui.component.g.Xox;
          localObject3 = (com.tencent.mm.plugin.finder.viewmodel.f)com.tencent.mm.ui.component.g.bD(PluginFinder.class).i(com.tencent.mm.plugin.finder.viewmodel.f.class);
          i = ((bid)localObject1).xkX;
          localObject1 = aj.AGc;
          ((com.tencent.mm.plugin.finder.viewmodel.f)localObject3).r(i, aj.a((List)localObject2, BaseFinderFeed.class));
        }
        localObject1 = com.tencent.mm.plugin.finder.report.j.zVy;
        int i = this.zJG.fEH;
        if (((Collection)localObject2).isEmpty()) {
          break label837;
        }
        bool = true;
        com.tencent.mm.plugin.finder.report.j.aq(i, bool);
        localObject1 = (bu)kotlin.a.j.lp((List)localObject2);
        localObject3 = getTAG();
        localObject4 = new StringBuilder("fetchInit tabType=").append(this.zJG.fEH).append(" callInitData scene=").append(this.xHL).append(", contextObj=");
        if (NearbyVideoFeedLoader.this.getContextObj() != null) {
          break label842;
        }
        bool = true;
        localObject4 = ((StringBuilder)localObject4).append(bool).append(" list first=");
        if (!(localObject1 instanceof BaseFinderFeed)) {
          break label847;
        }
        localObject1 = ((BaseFinderFeed)localObject1).feedObject.getNickName();
        label646:
        localObject1 = ((StringBuilder)localObject4).append((String)localObject1).append(" => ");
        localObject4 = (bu)kotlin.a.j.lp((List)localObject2);
        if (localObject4 == null) {
          break label855;
        }
        l = ((bu)localObject4).mf();
        label688:
        Log.i((String)localObject3, com.tencent.mm.ae.d.Fw(l));
        localObject1 = new NearbyVideoFeedLoader.c(0, 0, "", (byte)0);
        localObject3 = (Iterable)localObject2;
        localObject2 = (Collection)new ArrayList();
        localObject3 = ((Iterable)localObject3).iterator();
      }
      label837:
      label842:
      label847:
      label855:
      label864:
      for (;;)
      {
        label749:
        if (!((Iterator)localObject3).hasNext()) {
          break label866;
        }
        localObject4 = ((Iterator)localObject3).next();
        localObject5 = (bu)localObject4;
        if ((localObject5 instanceof BaseFinderFeed)) {
          localObject6 = aj.AGc;
        }
        for (bool = aj.w(((BaseFinderFeed)localObject5).feedObject.getFeedObject());; bool = true)
        {
          if (!bool) {
            break label864;
          }
          ((Collection)localObject2).add(localObject4);
          break label749;
          ((LinkedList)localObject2).addAll((Collection)((b.a)localObject1).Bgw);
          break;
          bool = false;
          break label534;
          bool = false;
          break label611;
          localObject1 = "";
          break label646;
          l = 0L;
          break label688;
        }
      }
      label866:
      ((NearbyVideoFeedLoader.c)localObject1).setIncrementList((List)localObject2);
      ((NearbyVideoFeedLoader.c)localObject1).setPullType(1000);
      paramh.onFetchDone((IResponse)localObject1);
      AppMethodBeat.o(199628);
    }
    
    public final void fetchLoadMore(com.tencent.mm.plugin.finder.feed.model.internal.h<bu> paramh)
    {
      AppMethodBeat.i(199619);
      p.k(paramh, "callback");
      fetch(new NearbyVideoFeedLoader.b(2, (byte)0), paramh);
      AppMethodBeat.o(199619);
    }
    
    public final void fetchRefresh(com.tencent.mm.plugin.finder.feed.model.internal.h<bu> paramh)
    {
      AppMethodBeat.i(199616);
      p.k(paramh, "callback");
      NearbyVideoFeedLoader.b localb = new NearbyVideoFeedLoader.b(NearbyVideoFeedLoader.this.xJs, (byte)0);
      if (localb.xJx) {}
      for (localb.pullType = 4;; localb.pullType = NearbyVideoFeedLoader.this.xJs)
      {
        if (NearbyVideoFeedLoader.this.xJs == 0) {
          NearbyVideoFeedLoader.this.xJs = 1;
        }
        Log.i(getTAG(), "[requestRefresh] pullType=" + localb.pullType + "  hasPrefetch=" + localb.xJw + " needToRefreshForPrefetch=" + localb.xJx);
        fetch(localb, paramh);
        AppMethodBeat.o(199616);
        return;
      }
    }
    
    public final void keep(com.tencent.mm.vending.e.a parama) {}
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "task", "Lcom/tencent/mm/loader/loader/SingleTask;", "invoke"})
    static final class a
      extends q
      implements kotlin.g.a.b<com.tencent.mm.loader.g.h, x>
    {
      a(NearbyVideoFeedLoader.a parama, Object paramObject, long paramLong, com.tencent.mm.plugin.finder.feed.model.internal.h paramh)
      {
        super();
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/nearby/video/NearbyVideoFeedLoader$TimelineRequest;", "", "pullType", "", "unreadList", "", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "(ILjava/util/List;)V", "hasPrefetch", "", "getHasPrefetch", "()Z", "setHasPrefetch", "(Z)V", "isPreloadMore", "setPreloadMore", "minDuration", "", "getMinDuration", "()J", "setMinDuration", "(J)V", "needToRefreshForPrefetch", "getNeedToRefreshForPrefetch", "setNeedToRefreshForPrefetch", "getPullType", "()I", "setPullType", "(I)V", "getUnreadList", "()Ljava/util/List;", "setUnreadList", "(Ljava/util/List;)V", "plugin-finder-nearby_release"})
  public static final class b
  {
    int pullType;
    boolean xJw;
    boolean xJx;
    long xJy;
    boolean xJz;
    List<? extends BaseFinderFeed> xam;
    
    private b(int paramInt)
    {
      this.pullType = paramInt;
      this.xam = null;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/nearby/video/NearbyVideoFeedLoader$TimelineResponse;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "errType", "", "errCode", "errMsg", "", "extraData", "", "(IILjava/lang/String;Ljava/lang/Object;)V", "dataBufferList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getDataBufferList", "()Ljava/util/ArrayList;", "setDataBufferList", "(Ljava/util/ArrayList;)V", "getExtraData", "()Ljava/lang/Object;", "setExtraData", "(Ljava/lang/Object;)V", "plugin-finder-nearby_release"})
  public static final class c
    extends IResponse<bu>
  {
    ArrayList<bu> xFM;
    Object xJA = null;
    
    private c(int paramInt1, int paramInt2, String paramString)
    {
      super(paramInt2, paramString);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/nearby/video/NearbyVideoFeedLoader$createDataMerger$1", "Lcom/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader$DefaultDataMerger;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "mergeRefresh", "", "response", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "next", "Lkotlin/Function1;", "plugin-finder-nearby_release"})
  public static final class d
    extends BaseFeedLoader<bu>.a
  {
    d()
    {
      super();
    }
    
    public final void mergeRefresh(IResponse<bu> paramIResponse, kotlin.g.a.b<? super IResponse<bu>, x> paramb)
    {
      AppMethodBeat.i(203925);
      p.k(paramIResponse, "response");
      paramb = RefreshLoadMoreLayout.c.YNO;
      final RefreshLoadMoreLayout.c localc = new RefreshLoadMoreLayout.c(RefreshLoadMoreLayout.c.ihs());
      localc.YNF = paramIResponse.getHasMore();
      int m = this.zJH.getDataList().size();
      Object localObject1 = paramIResponse.getIncrementList();
      paramb = (kotlin.g.a.b<? super IResponse<bu>, x>)localObject1;
      if (localObject1 == null) {
        paramb = (List)new LinkedList();
      }
      localObject1 = new LinkedList();
      Object localObject2 = (bu)kotlin.a.j.lp((List)this.zJH.getDataList());
      if ((localObject2 != null) && ((localObject2 instanceof z))) {
        ((LinkedList)localObject1).add(this.zJH.getDataList().get(0));
      }
      ((LinkedList)localObject1).addAll((Collection)paramb);
      paramb = ((Iterable)localObject1).iterator();
      int i = 0;
      int j = 0;
      for (;;)
      {
        Object localObject3;
        int k;
        if (paramb.hasNext())
        {
          localObject2 = paramb.next();
          if (i < 0) {
            kotlin.a.j.iBO();
          }
          localObject2 = (bu)localObject2;
          localObject3 = ((List)this.zJH.getDataList()).iterator();
          j = 0;
          if (((Iterator)localObject3).hasNext())
          {
            bu localbu = (bu)((Iterator)localObject3).next();
            if ((localbu.a((com.tencent.mm.plugin.finder.feed.model.internal.k)localObject2) == 0) && ((localbu instanceof w)))
            {
              bac localbac = ((w)localbu).feedObject.getLiveInfo();
              if ((localbac != null) && (localbac.liveStatus == 1)) {}
            }
            else
            {
              if ((i != 0) || (!(localObject2 instanceof z)) || (!(localbu instanceof z))) {
                break label562;
              }
            }
            k = 1;
            label302:
            if (k != 0)
            {
              label307:
              if ((j != -1) && (j == i)) {
                break label840;
              }
              i -= 1;
            }
          }
        }
        for (;;)
        {
          paramb = new LinkedList();
          paramb.addAll((Collection)this.zJH.getDataList());
          this.zJH.getDataList().clear();
          this.zJH.getDataList().addAll((Collection)localObject1);
          j = ((LinkedList)localObject1).size();
          if (j > 0) {
            if (i + 1 == j)
            {
              i += 1;
              j = m - j;
              this.zJH.dispatcher().onItemRangeRemoved(i, j);
              if (BuildInfo.DEBUG)
              {
                localObject2 = this.zJH.getTAG();
                paramIResponse = new StringBuilder("mergeRefresh() hasMore:").append(paramIResponse.getHasMore()).append(' ').append("removeIndex:").append(i).append("  removeSize:").append(j).append(' ').append("newList:");
                localObject3 = am.xch;
                paramIResponse = paramIResponse.append(am.dX((List)localObject1)).append(' ').append("oldList:");
                localObject1 = am.xch;
                Log.i((String)localObject2, am.dX((List)paramb));
              }
            }
          }
          for (;;)
          {
            localc.YNG = 0;
            com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new a(this, localc));
            AppMethodBeat.o(203925);
            return;
            label562:
            k = 0;
            break label302;
            j += 1;
            break;
            j = -1;
            break label307;
            if (i + 1 > j)
            {
              Log.w(this.zJH.getTAG(), "数据出错，需要检查.");
            }
            else
            {
              k = i + 1;
              int n = m - k;
              if ((m > 0) && (n > 0)) {
                this.zJH.dispatcher().onItemRangeRemoved(k, n);
              }
              i += 1;
              j -= i;
              if (j > 0) {
                this.zJH.dispatcher().onItemRangeInserted(i, j);
              }
              if (BuildInfo.DEBUG)
              {
                localObject2 = this.zJH.getTAG();
                paramIResponse = new StringBuilder("mergeRefresh() hasMore:").append(paramIResponse.getHasMore()).append(' ').append("removeIndex:").append(k).append("  removeSize:").append(n).append(' ').append("insertIndex:").append(i).append("  insertSize:").append(j).append(' ').append("newList:");
                localObject3 = am.xch;
                paramIResponse = paramIResponse.append(am.dX((List)localObject1)).append(' ').append("oldList:");
                localObject1 = am.xch;
                Log.i((String)localObject2, am.dX((List)paramb));
                continue;
                Log.w(this.zJH.getTAG(), "没有新的数据.");
              }
            }
          }
          i = j;
        }
        label840:
        j = i;
        i += 1;
      }
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
    static final class a
      extends q
      implements kotlin.g.a.a<x>
    {
      a(NearbyVideoFeedLoader.d paramd, RefreshLoadMoreLayout.c paramc)
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
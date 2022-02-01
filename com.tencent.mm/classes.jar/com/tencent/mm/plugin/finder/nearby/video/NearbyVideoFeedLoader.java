package com.tencent.mm.plugin.finder.nearby.video;

import android.arch.lifecycle.ViewModelProvider;
import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.cgi.ab.a;
import com.tencent.mm.plugin.finder.cgi.ab.c;
import com.tencent.mm.plugin.finder.cgi.al;
import com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader.a;
import com.tencent.mm.plugin.finder.feed.model.internal.DataBuffer;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.feed.model.internal.f;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.bo;
import com.tencent.mm.plugin.finder.model.w;
import com.tencent.mm.plugin.finder.model.z;
import com.tencent.mm.plugin.finder.report.k;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.data.e.a;
import com.tencent.mm.plugin.finder.storage.data.l.a;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.plugin.finder.viewmodel.FinderHomeTabStateVM;
import com.tencent.mm.plugin.finder.viewmodel.FinderHomeTabStateVM.a;
import com.tencent.mm.plugin.finder.viewmodel.FinderTabStreamUnreadVM;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.awe;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.protocal.protobuf.dpc;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.view.RefreshLoadMoreLayout.c;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.a.b<-Lcom.tencent.mm.plugin.finder.feed.model.internal.IResponse<Lcom.tencent.mm.plugin.finder.model.bo;>;Lkotlin.x;>;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.t;
import kotlin.x;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/nearby/video/NearbyVideoFeedLoader;", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "scene", "Lcom/tencent/mm/plugin/finder/feed/model/internal/FinderLoaderScene;", "firstLoad", "", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Lcom/tencent/mm/plugin/finder/feed/model/internal/FinderLoaderScene;ILcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "getFirstLoad", "()I", "setFirstLoad", "(I)V", "value", "Landroid/support/v7/widget/RecyclerView;", "recyclerView", "getRecyclerView", "()Landroid/support/v7/widget/RecyclerView;", "setRecyclerView", "(Landroid/support/v7/widget/RecyclerView;)V", "getScene", "()Lcom/tencent/mm/plugin/finder/feed/model/internal/FinderLoaderScene;", "streamFetcher", "Lcom/tencent/mm/plugin/finder/nearby/video/NearbyVideoFeedFetcher;", "getStreamFetcher", "()Lcom/tencent/mm/plugin/finder/nearby/video/NearbyVideoFeedFetcher;", "colletExtraPageName", "", "createDataFetch", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataFetch;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "createDataMerger", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataMerger;", "getPageName", "onDead", "", "preloadMoreToBuffer", "callback", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataCallback;", "printVisibleFeeds", "", "hasVisibleFeeds", "Landroid/util/LongSparseArray;", "requestRefresh", "unreadList", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "TimelineDataFetcher", "TimelineRequest", "TimelineResponse", "plugin-finder_release"})
public final class NearbyVideoFeedLoader
  extends BaseFinderFeedLoader
{
  private final com.tencent.mm.plugin.finder.feed.model.internal.e tVT;
  int tXs;
  private final b uTt;
  
  public NearbyVideoFeedLoader(com.tencent.mm.plugin.finder.feed.model.internal.e parame, int paramInt, bbn parambbn)
  {
    super(parambbn);
    AppMethodBeat.i(249384);
    this.tVT = parame;
    this.tXs = paramInt;
    this.uTt = new b(this.tVT.value, parambbn);
    AppMethodBeat.o(249384);
  }
  
  public final List<Integer> colletExtraPageName()
  {
    AppMethodBeat.i(249383);
    Object localObject = new ArrayList();
    ((ArrayList)localObject).add(Integer.valueOf(4));
    localObject = (List)localObject;
    AppMethodBeat.o(249383);
    return localObject;
  }
  
  public final com.tencent.mm.plugin.finder.feed.model.internal.g<bo> createDataFetch()
  {
    AppMethodBeat.i(249379);
    com.tencent.mm.plugin.finder.feed.model.internal.g localg = (com.tencent.mm.plugin.finder.feed.model.internal.g)new a(this.uTt, this.tVT);
    AppMethodBeat.o(249379);
    return localg;
  }
  
  public final com.tencent.mm.plugin.finder.feed.model.internal.b<bo> createDataMerger()
  {
    AppMethodBeat.i(249380);
    com.tencent.mm.plugin.finder.feed.model.internal.b localb = (com.tencent.mm.plugin.finder.feed.model.internal.b)new d(this);
    AppMethodBeat.o(249380);
    return localb;
  }
  
  public final int getPageName()
  {
    AppMethodBeat.i(249382);
    y localy = y.vXH;
    int i = y.LL(this.tVT.value);
    localy = y.vXH;
    i = y.LJ(i);
    AppMethodBeat.o(249382);
    return i;
  }
  
  public final void onDead()
  {
    AppMethodBeat.i(249381);
    super.onDead();
    this.uTt.ttK.dead();
    AppMethodBeat.o(249381);
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/nearby/video/NearbyVideoFeedLoader$TimelineDataFetcher;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataFetch;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycleKeeper;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycle;", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderTimelineStream$Callback;", "streamFetcher", "Lcom/tencent/mm/plugin/finder/nearby/video/NearbyVideoFeedFetcher;", "scene", "Lcom/tencent/mm/plugin/finder/feed/model/internal/FinderLoaderScene;", "(Lcom/tencent/mm/plugin/finder/nearby/video/NearbyVideoFeedLoader;Lcom/tencent/mm/plugin/finder/nearby/video/NearbyVideoFeedFetcher;Lcom/tencent/mm/plugin/finder/feed/model/internal/FinderLoaderScene;)V", "taskExecutor", "Lcom/tencent/mm/loader/loader/SingleTaskExecutor;", "alive", "", "dead", "fetch", "request", "", "callback", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataCallback;", "fetchInit", "fetchLoadMore", "fetchRefresh", "keep", "target", "onFetchDone", "info", "Lcom/tencent/mm/plugin/finder/feed/model/CgiFinderStreamResult;", "pullType", "", "plugin-finder_release"})
  public final class a
    extends com.tencent.mm.plugin.finder.feed.model.internal.g<bo>
    implements ab.a, com.tencent.mm.vending.e.b<com.tencent.mm.vending.e.a>
  {
    com.tencent.mm.loader.g.i tMX;
    private final com.tencent.mm.plugin.finder.feed.model.internal.e tVT;
    final b uTt;
    
    public a(com.tencent.mm.plugin.finder.feed.model.internal.e parame)
    {
      AppMethodBeat.i(249376);
      this.uTt = parame;
      this.tVT = localObject;
      AppMethodBeat.o(249376);
    }
    
    public final void a(com.tencent.mm.plugin.finder.feed.model.b paramb, int paramInt)
    {
      AppMethodBeat.i(249375);
      p.h(paramb, "info");
      AppMethodBeat.o(249375);
    }
    
    public final void alive()
    {
      AppMethodBeat.i(249372);
      super.alive();
      if (this.tVT == com.tencent.mm.plugin.finder.feed.model.internal.e.tYk)
      {
        this.tMX = ((PluginFinder)com.tencent.mm.kernel.g.ah(PluginFinder.class)).getFollowTlSingleExecutor();
        locali = this.tMX;
        if (locali != null)
        {
          locali.clean();
          AppMethodBeat.o(249372);
          return;
        }
        AppMethodBeat.o(249372);
        return;
      }
      com.tencent.mm.loader.g.i locali = new com.tencent.mm.loader.g.i("SingleExecutor#TabType=" + this.uTt.dLS);
      locali.start();
      this.tMX = locali;
      AppMethodBeat.o(249372);
    }
    
    public final void dead()
    {
      AppMethodBeat.i(249373);
      super.dead();
      com.tencent.mm.loader.g.i locali = this.tMX;
      if (locali != null) {
        locali.reset();
      }
      this.tMX = null;
      AppMethodBeat.o(249373);
    }
    
    public final void fetch(final Object paramObject, f<bo> paramf)
    {
      AppMethodBeat.i(249374);
      p.h(paramf, "callback");
      if ((paramObject instanceof NearbyVideoFeedLoader.b))
      {
        final long l = SystemClock.uptimeMillis();
        com.tencent.mm.loader.g.i locali = this.tMX;
        if (locali != null)
        {
          locali.a(new com.tencent.mm.loader.g.h((kotlin.g.a.b)new a(this, paramObject, l, paramf)));
          AppMethodBeat.o(249374);
          return;
        }
      }
      AppMethodBeat.o(249374);
    }
    
    public final void fetchInit(f<bo> paramf)
    {
      AppMethodBeat.i(249371);
      p.h(paramf, "callback");
      Object localObject2 = new LinkedList();
      Object localObject1 = com.tencent.mm.ui.component.a.PRN;
      localObject1 = ((FinderHomeTabStateVM)com.tencent.mm.ui.component.a.bi(PluginFinder.class).get(FinderHomeTabStateVM.class)).Mq(this.tVT.value);
      Object localObject3;
      Object localObject4;
      Object localObject5;
      Object localObject6;
      boolean bool;
      label552:
      label629:
      long l;
      if (((FinderHomeTabStateVM.a)localObject1).wuc.isEmpty())
      {
        localObject1 = l.a.a(com.tencent.mm.plugin.finder.storage.data.l.vGw, NearbyVideoFeedLoader.this.getPageName());
        localObject3 = ((Iterable)localObject1).iterator();
        while (((Iterator)localObject3).hasNext())
        {
          localObject4 = (bo)((Iterator)localObject3).next();
          if ((localObject4 instanceof BaseFinderFeed))
          {
            localObject5 = NearbyVideoFeedLoader.this.getContextObj();
            if (localObject5 != null)
            {
              localObject6 = k.vfA;
              k.e(((bo)localObject4).lT(), ((bbn)localObject5).tCE, ((BaseFinderFeed)localObject4).feedObject.getFeedObject().sessionBuffer);
            }
            localObject4 = ((Iterable)((BaseFinderFeed)localObject4).feedObject.getFoldedFeedList()).iterator();
            while (((Iterator)localObject4).hasNext())
            {
              localObject5 = (BaseFinderFeed)((Iterator)localObject4).next();
              localObject6 = k.vfA;
              k.e(((BaseFinderFeed)localObject5).lT(), 14, ((BaseFinderFeed)localObject5).feedObject.getFeedObject().sessionBuffer);
            }
          }
        }
        localObject3 = NearbyVideoFeedLoader.this.getContextObj();
        if (localObject3 != null)
        {
          localObject4 = com.tencent.mm.plugin.finder.storage.data.e.vFX;
          i = ((bbn)localObject3).tCE;
          localObject4 = (Iterable)localObject1;
          localObject3 = (Collection)new ArrayList();
          localObject4 = ((Iterable)localObject4).iterator();
          while (((Iterator)localObject4).hasNext())
          {
            localObject5 = ((Iterator)localObject4).next();
            if (((bo)localObject5 instanceof BaseFinderFeed)) {
              ((Collection)localObject3).add(localObject5);
            }
          }
          localObject4 = (Iterable)localObject3;
          localObject3 = (Collection)new ArrayList(kotlin.a.j.a((Iterable)localObject4, 10));
          localObject4 = ((Iterable)localObject4).iterator();
          while (((Iterator)localObject4).hasNext())
          {
            localObject5 = (bo)((Iterator)localObject4).next();
            if (localObject5 == null)
            {
              paramf = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.model.BaseFinderFeed");
              AppMethodBeat.o(249371);
              throw paramf;
            }
            ((Collection)localObject3).add(((BaseFinderFeed)localObject5).feedObject.getFeedObject());
          }
          e.a.k(i, (List)localObject3);
        }
        ((LinkedList)localObject2).addAll((Collection)localObject1);
        localObject1 = NearbyVideoFeedLoader.this.getContextObj();
        if (localObject1 != null)
        {
          localObject3 = com.tencent.mm.ui.component.a.PRN;
          localObject3 = (FinderTabStreamUnreadVM)com.tencent.mm.ui.component.a.bi(PluginFinder.class).get(FinderTabStreamUnreadVM.class);
          i = ((bbn)localObject1).tCE;
          localObject1 = y.vXH;
          ((FinderTabStreamUnreadVM)localObject3).o(i, y.a((List)localObject2, BaseFinderFeed.class));
        }
        localObject1 = com.tencent.mm.plugin.finder.report.h.veu;
        int i = this.uTt.dLS;
        if (((Collection)localObject2).isEmpty()) {
          break label855;
        }
        bool = true;
        com.tencent.mm.plugin.finder.report.h.an(i, bool);
        localObject1 = (bo)kotlin.a.j.kt((List)localObject2);
        localObject3 = getTAG();
        localObject4 = new StringBuilder("fetchInit tabType=").append(this.uTt.dLS).append(" callInitData scene=").append(this.tVT).append(", contextObj=");
        if (NearbyVideoFeedLoader.this.getContextObj() != null) {
          break label860;
        }
        bool = true;
        localObject4 = ((StringBuilder)localObject4).append(bool).append(" list first=");
        if (!(localObject1 instanceof BaseFinderFeed)) {
          break label865;
        }
        localObject1 = ((BaseFinderFeed)localObject1).feedObject.getNickName();
        label664:
        localObject1 = ((StringBuilder)localObject4).append((String)localObject1).append(" => ");
        localObject4 = (bo)kotlin.a.j.kt((List)localObject2);
        if (localObject4 == null) {
          break label873;
        }
        l = ((bo)localObject4).lT();
        label706:
        Log.i((String)localObject3, com.tencent.mm.ac.d.zs(l));
        localObject1 = new NearbyVideoFeedLoader.c(0, 0, "", (byte)0);
        localObject3 = (Iterable)localObject2;
        localObject2 = (Collection)new ArrayList();
        localObject3 = ((Iterable)localObject3).iterator();
      }
      label855:
      label860:
      label865:
      label873:
      label882:
      for (;;)
      {
        label767:
        if (!((Iterator)localObject3).hasNext()) {
          break label884;
        }
        localObject4 = ((Iterator)localObject3).next();
        localObject5 = (bo)localObject4;
        if ((localObject5 instanceof BaseFinderFeed)) {
          localObject6 = y.vXH;
        }
        for (bool = y.r(((BaseFinderFeed)localObject5).feedObject.getFeedObject());; bool = true)
        {
          if (!bool) {
            break label882;
          }
          ((Collection)localObject2).add(localObject4);
          break label767;
          ((LinkedList)localObject2).addAll((Collection)((FinderHomeTabStateVM.a)localObject1).wuc);
          break;
          bool = false;
          break label552;
          bool = false;
          break label629;
          localObject1 = "";
          break label664;
          l = 0L;
          break label706;
        }
      }
      label884:
      ((NearbyVideoFeedLoader.c)localObject1).setIncrementList((List)localObject2);
      ((NearbyVideoFeedLoader.c)localObject1).setPullType(1000);
      paramf.onFetchDone((IResponse)localObject1);
      AppMethodBeat.o(249371);
    }
    
    public final void fetchLoadMore(f<bo> paramf)
    {
      AppMethodBeat.i(249370);
      p.h(paramf, "callback");
      fetch(new NearbyVideoFeedLoader.b(2, (byte)0), paramf);
      AppMethodBeat.o(249370);
    }
    
    public final void fetchRefresh(f<bo> paramf)
    {
      AppMethodBeat.i(249369);
      p.h(paramf, "callback");
      NearbyVideoFeedLoader.b localb = new NearbyVideoFeedLoader.b(NearbyVideoFeedLoader.this.tXs, (byte)0);
      if (localb.tXC) {}
      for (localb.pullType = 4;; localb.pullType = NearbyVideoFeedLoader.this.tXs)
      {
        if (NearbyVideoFeedLoader.this.tXs == 0) {
          NearbyVideoFeedLoader.this.tXs = 1;
        }
        Log.i(getTAG(), "[requestRefresh] pullType=" + localb.pullType + "  hasPrefetch=" + localb.tXB + " needToRefreshForPrefetch=" + localb.tXC);
        fetch(localb, paramf);
        AppMethodBeat.o(249369);
        return;
      }
    }
    
    public final void keep(com.tencent.mm.vending.e.a parama) {}
    
    @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "task", "Lcom/tencent/mm/loader/loader/SingleTask;", "invoke"})
    static final class a
      extends q
      implements kotlin.g.a.b<com.tencent.mm.loader.g.h, x>
    {
      a(NearbyVideoFeedLoader.a parama, Object paramObject, long paramLong, f paramf)
      {
        super();
      }
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/nearby/video/NearbyVideoFeedLoader$TimelineRequest;", "", "pullType", "", "unreadList", "", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "(ILjava/util/List;)V", "hasPrefetch", "", "getHasPrefetch", "()Z", "setHasPrefetch", "(Z)V", "isPreloadMore", "setPreloadMore", "minDuration", "", "getMinDuration", "()J", "setMinDuration", "(J)V", "needToRefreshForPrefetch", "getNeedToRefreshForPrefetch", "setNeedToRefreshForPrefetch", "getPullType", "()I", "setPullType", "(I)V", "getUnreadList", "()Ljava/util/List;", "setUnreadList", "(Ljava/util/List;)V", "plugin-finder_release"})
  public static final class b
  {
    int pullType;
    boolean tXB;
    boolean tXC;
    long tXD;
    boolean tXE;
    List<? extends BaseFinderFeed> tsE;
    
    private b(int paramInt)
    {
      this.pullType = paramInt;
      this.tsE = null;
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/nearby/video/NearbyVideoFeedLoader$TimelineResponse;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "errType", "", "errCode", "errMsg", "", "extraData", "", "(IILjava/lang/String;Ljava/lang/Object;)V", "dataBufferList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getDataBufferList", "()Ljava/util/ArrayList;", "setDataBufferList", "(Ljava/util/ArrayList;)V", "getExtraData", "()Ljava/lang/Object;", "setExtraData", "(Ljava/lang/Object;)V", "plugin-finder_release"})
  public static final class c
    extends IResponse<bo>
  {
    ArrayList<bo> tUG;
    Object tXF = null;
    
    private c(int paramInt1, int paramInt2, String paramString)
    {
      super(paramInt2, paramString);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/nearby/video/NearbyVideoFeedLoader$createDataMerger$1", "Lcom/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader$DefaultDataMerger;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "mergeRefresh", "", "response", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "next", "Lkotlin/Function1;", "plugin-finder_release"})
  public static final class d
    extends BaseFeedLoader<bo>.a
  {
    d()
    {
      super();
    }
    
    public final void mergeRefresh(IResponse<bo> paramIResponse, kotlin.g.a.b<? super IResponse<bo>, x> paramb)
    {
      AppMethodBeat.i(249378);
      p.h(paramIResponse, "response");
      paramb = RefreshLoadMoreLayout.c.Rms;
      final RefreshLoadMoreLayout.c localc = new RefreshLoadMoreLayout.c(RefreshLoadMoreLayout.c.hfT());
      localc.Rmj = paramIResponse.getHasMore();
      int m = this.uTu.getDataList().size();
      Object localObject1 = paramIResponse.getIncrementList();
      paramb = (kotlin.g.a.b<? super IResponse<bo>, x>)localObject1;
      if (localObject1 == null) {
        paramb = (List)new LinkedList();
      }
      localObject1 = new LinkedList();
      Object localObject2 = (bo)kotlin.a.j.kt((List)this.uTu.getDataList());
      if ((localObject2 != null) && ((localObject2 instanceof z))) {
        ((LinkedList)localObject1).add(this.uTu.getDataList().get(0));
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
            kotlin.a.j.hxH();
          }
          localObject2 = (bo)localObject2;
          localObject3 = ((List)this.uTu.getDataList()).iterator();
          j = 0;
          if (((Iterator)localObject3).hasNext())
          {
            bo localbo = (bo)((Iterator)localObject3).next();
            if ((localbo.a((com.tencent.mm.plugin.finder.feed.model.internal.i)localObject2) == 0) && ((localbo instanceof w)))
            {
              awe localawe = ((w)localbo).feedObject.getLiveInfo();
              if ((localawe != null) && (localawe.liveStatus == 1)) {}
            }
            else
            {
              if ((i != 0) || (!(localObject2 instanceof z)) || (!(localbo instanceof z))) {
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
          paramb.addAll((Collection)this.uTu.getDataList());
          this.uTu.getDataList().clear();
          this.uTu.getDataList().addAll((Collection)localObject1);
          j = ((LinkedList)localObject1).size();
          if (j > 0) {
            if (i + 1 == j)
            {
              i += 1;
              j = m - j;
              this.uTu.dispatcher().onItemRangeRemoved(i, j);
              if (BuildInfo.DEBUG)
              {
                localObject2 = this.uTu.getTAG();
                paramIResponse = new StringBuilder("mergeRefresh() hasMore:").append(paramIResponse.getHasMore()).append(' ').append("removeIndex:").append(i).append("  removeSize:").append(j).append(' ').append("newList:");
                localObject3 = al.tuv;
                paramIResponse = paramIResponse.append(al.dP((List)localObject1)).append(' ').append("oldList:");
                localObject1 = al.tuv;
                Log.i((String)localObject2, al.dP((List)paramb));
              }
            }
          }
          for (;;)
          {
            localc.Rmk = 0;
            com.tencent.mm.ac.d.h((kotlin.g.a.a)new a(this, localc));
            AppMethodBeat.o(249378);
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
              Log.w(this.uTu.getTAG(), "数据出错，需要检查.");
            }
            else
            {
              k = i + 1;
              int n = m - k;
              if ((m > 0) && (n > 0)) {
                this.uTu.dispatcher().onItemRangeRemoved(k, n);
              }
              i += 1;
              j -= i;
              if (j > 0) {
                this.uTu.dispatcher().onItemRangeInserted(i, j);
              }
              if (BuildInfo.DEBUG)
              {
                localObject2 = this.uTu.getTAG();
                paramIResponse = new StringBuilder("mergeRefresh() hasMore:").append(paramIResponse.getHasMore()).append(' ').append("removeIndex:").append(k).append("  removeSize:").append(n).append(' ').append("insertIndex:").append(i).append("  insertSize:").append(j).append(' ').append("newList:");
                localObject3 = al.tuv;
                paramIResponse = paramIResponse.append(al.dP((List)localObject1)).append(' ').append("oldList:");
                localObject1 = al.tuv;
                Log.i((String)localObject2, al.dP((List)paramb));
                continue;
                Log.w(this.uTu.getTAG(), "没有新的数据.");
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
    
    @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
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
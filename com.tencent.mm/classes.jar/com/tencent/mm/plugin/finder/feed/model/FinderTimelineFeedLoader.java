package com.tencent.mm.plugin.finder.feed.model;

import android.content.Context;
import android.content.res.Resources;
import android.os.SystemClock;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.if;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.cgi.aq.c;
import com.tencent.mm.plugin.finder.cgi.aq.d;
import com.tencent.mm.plugin.finder.cgi.ar.a;
import com.tencent.mm.plugin.finder.cgi.ar.c;
import com.tencent.mm.plugin.finder.cgi.fetcher.e;
import com.tencent.mm.plugin.finder.convert.cn;
import com.tencent.mm.plugin.finder.e.h;
import com.tencent.mm.plugin.finder.feed.ax;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader.a;
import com.tencent.mm.plugin.finder.feed.model.internal.DataBuffer;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.feed.model.internal.f;
import com.tencent.mm.plugin.finder.feed.model.internal.o;
import com.tencent.mm.plugin.finder.feed.model.internal.r;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.ai;
import com.tencent.mm.plugin.finder.model.cc;
import com.tencent.mm.plugin.finder.model.y;
import com.tencent.mm.plugin.finder.preload.tabPreload.g.g;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.utils.av;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.atz;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.protocal.protobuf.bwj;
import com.tencent.mm.protocal.protobuf.bwk;
import com.tencent.mm.protocal.protobuf.esc;
import com.tencent.mm.sdk.crash.CrashReportFactory;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.component.k.b;
import com.tencent.mm.view.RefreshLoadMoreLayout.d;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.ab;
import kotlin.a.p;
import kotlin.ah;
import kotlin.g.b.u;
import kotlinx.coroutines.ar;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/model/FinderTimelineFeedLoader;", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "scene", "Lcom/tencent/mm/plugin/finder/feed/model/internal/FinderLoaderScene;", "firstLoad", "", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "requestArgs", "Lcom/tencent/mm/plugin/finder/cgi/fetcher/FinderStreamRequestArgs;", "(Lcom/tencent/mm/plugin/finder/feed/model/internal/FinderLoaderScene;ILcom/tencent/mm/protocal/protobuf/FinderReportContextObj;Lcom/tencent/mm/plugin/finder/cgi/fetcher/FinderStreamRequestArgs;)V", "extraDataOp", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "", "getExtraDataOp", "()Lkotlin/jvm/functions/Function1;", "setExtraDataOp", "(Lkotlin/jvm/functions/Function1;)V", "getFirstLoad", "()I", "setFirstLoad", "(I)V", "isFinishFirstRefresh", "", "()Z", "setFinishFirstRefresh", "(Z)V", "postFeedFlag", "getPostFeedFlag", "setPostFeedFlag", "recyclerViewRef", "Ljava/lang/ref/WeakReference;", "Landroidx/recyclerview/widget/RecyclerView;", "getRecyclerViewRef", "()Ljava/lang/ref/WeakReference;", "setRecyclerViewRef", "(Ljava/lang/ref/WeakReference;)V", "getRequestArgs", "()Lcom/tencent/mm/plugin/finder/cgi/fetcher/FinderStreamRequestArgs;", "setRequestArgs", "(Lcom/tencent/mm/plugin/finder/cgi/fetcher/FinderStreamRequestArgs;)V", "getScene", "()Lcom/tencent/mm/plugin/finder/feed/model/internal/FinderLoaderScene;", "streamFetcher", "Lcom/tencent/mm/plugin/finder/cgi/fetcher/FinderTimelineFeedFetcher;", "getStreamFetcher", "()Lcom/tencent/mm/plugin/finder/cgi/fetcher/FinderTimelineFeedFetcher;", "bufferSize", "clearAndNotify", "colletExtraPageName", "", "createDataFetch", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataFetch;", "createDataMerger", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataMerger;", "getPageName", "isObservePostEvent", "onDataChanged", "onDead", "onFetchRefreshDone", "response", "onPostStart", "localId", "", "isFromSns", "preloadMoreToBuffer", "callback", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataCallback;", "printVisibleFeeds", "", "hasVisibleFeeds", "Landroid/util/LongSparseArray;", "requestRefresh", "unreadList", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "CgiConsumeCallback", "TimelineDataFetcher", "TimelineRequest", "TimelineResponse", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderTimelineFeedLoader
  extends BaseFinderFeedLoader
{
  com.tencent.mm.plugin.finder.cgi.fetcher.d AEF;
  final com.tencent.mm.plugin.finder.feed.model.internal.g BgY;
  public int Bja;
  public final e Bjb;
  public boolean Bjc;
  public boolean Bjd;
  public kotlin.g.a.b<? super IResponse<cc>, ah> Bje;
  public WeakReference<RecyclerView> zHB;
  
  public FinderTimelineFeedLoader(com.tencent.mm.plugin.finder.feed.model.internal.g paramg, int paramInt, bui parambui, com.tencent.mm.plugin.finder.cgi.fetcher.d paramd)
  {
    super(parambui);
    AppMethodBeat.i(366506);
    this.BgY = paramg;
    this.Bja = paramInt;
    this.AEF = paramd;
    this.Bjb = new e(this.BgY.value, parambui, this.AEF);
    AppMethodBeat.o(366506);
  }
  
  public final List<Integer> colletExtraPageName()
  {
    AppMethodBeat.i(366584);
    Object localObject = new ArrayList();
    ((ArrayList)localObject).add(Integer.valueOf(4));
    localObject = (List)localObject;
    AppMethodBeat.o(366584);
    return localObject;
  }
  
  public final com.tencent.mm.plugin.finder.feed.model.internal.i<cc> createDataFetch()
  {
    AppMethodBeat.i(366519);
    com.tencent.mm.plugin.finder.feed.model.internal.i locali = (com.tencent.mm.plugin.finder.feed.model.internal.i)new b(this.Bjb, this.BgY);
    AppMethodBeat.o(366519);
    return locali;
  }
  
  public final com.tencent.mm.plugin.finder.feed.model.internal.d<cc> createDataMerger()
  {
    AppMethodBeat.i(366544);
    com.tencent.mm.plugin.finder.feed.model.internal.d locald = (com.tencent.mm.plugin.finder.feed.model.internal.d)new e(this);
    AppMethodBeat.o(366544);
    return locald;
  }
  
  public final void edW()
  {
    AppMethodBeat.i(366590);
    getDataList().clear();
    Object localObject = this.zHB;
    if (localObject != null)
    {
      localObject = (RecyclerView)((WeakReference)localObject).get();
      if (localObject != null)
      {
        localObject = ((RecyclerView)localObject).getAdapter();
        if (localObject != null) {
          ((RecyclerView.a)localObject).bZE.notifyChanged();
        }
      }
    }
    AppMethodBeat.o(366590);
  }
  
  public final int getPageName()
  {
    AppMethodBeat.i(366580);
    av localav = av.GiL;
    int i = av.Ui(this.BgY.value);
    localav = av.GiL;
    i = av.Ug(i);
    AppMethodBeat.o(366580);
    return i;
  }
  
  public final void gf(List<? extends BaseFinderFeed> paramList)
  {
    AppMethodBeat.i(366534);
    paramList = new c(this.Bja, paramList);
    if (paramList.Bji) {}
    for (paramList.pullType = 4;; paramList.pullType = this.Bja)
    {
      Log.i(getTAG(), "[requestRefresh] tabtype=" + this.BgY.value + " pullType=" + paramList.pullType + "  hasPrefetch=" + paramList.Bjh + " needToRefreshForPrefetch=" + paramList.Bji);
      super.request(paramList, (com.tencent.mm.plugin.finder.feed.model.internal.h)this);
      if (this.Bja == 0)
      {
        this.Bja = 1;
        if (this.BgY.value == 4)
        {
          paramList = com.tencent.mm.ui.component.k.aeZF;
          paramList = com.tencent.mm.ui.component.k.cn(PluginFinder.class).q(com.tencent.mm.plugin.finder.viewmodel.d.class);
          kotlin.g.b.s.s(paramList, "UICProvider.of(PluginFin…meTabStateVM::class.java)");
          paramList = (com.tencent.mm.plugin.finder.viewmodel.d)paramList;
          com.tencent.mm.plugin.finder.viewmodel.d.a locala = paramList.UV(4);
          if ((locala.GKz >= 0L) && (paramList.Rp(4))) {
            locala.GKD = false;
          }
        }
      }
      AppMethodBeat.o(366534);
      return;
    }
  }
  
  public final boolean isObservePostEvent()
  {
    AppMethodBeat.i(366555);
    if (this.BgY != com.tencent.mm.plugin.finder.feed.model.internal.g.Bkh)
    {
      com.tencent.mm.plugin.finder.storage.d locald = com.tencent.mm.plugin.finder.storage.d.FAy;
      if (((Number)com.tencent.mm.plugin.finder.storage.d.eSi().bmg()).intValue() == 1) {}
    }
    else
    {
      AppMethodBeat.o(366555);
      return true;
    }
    AppMethodBeat.o(366555);
    return false;
  }
  
  public final void onDataChanged()
  {
    AppMethodBeat.i(366548);
    super.onDataChanged();
    AppMethodBeat.o(366548);
  }
  
  public final void onDead()
  {
    AppMethodBeat.i(366577);
    super.onDead();
    if ((this.Bjb.isLoading) && ((this.Bjb.AEJ == 0) || (this.Bjb.AEJ == 4) || (this.Bjb.AEJ == 1)))
    {
      int i = this.BgY.value;
      Object localObject = com.tencent.mm.ui.component.k.aeZF;
      localObject = ((com.tencent.mm.plugin.finder.preload.tabPreload.c)com.tencent.mm.ui.component.k.cn(PluginFinder.class).q(com.tencent.mm.plugin.finder.preload.tabPreload.c.class)).Rn(i);
      if (localObject != null) {
        ((com.tencent.mm.plugin.finder.preload.tabPreload.g)localObject).a(true, g.g.EWG);
      }
      Log.w(getTAG(), "[onDead] but finderstream is running. tabType=" + i + " pullType=" + this.Bjb.AEJ);
    }
    this.Bjb.AAh.dead();
    ar.a(this.Bjb.scope, kotlin.g.b.s.X(getTAG(), ":onDead"));
    AppMethodBeat.o(366577);
  }
  
  public final void onFetchRefreshDone(IResponse<cc> paramIResponse)
  {
    int k = 0;
    AppMethodBeat.i(166052);
    kotlin.g.b.s.u(paramIResponse, "response");
    super.onFetchRefreshDone(paramIResponse);
    Object localObject = this.AEF;
    int i;
    label151:
    if ((localObject != null) && (((com.tencent.mm.plugin.finder.cgi.fetcher.d)localObject).AAd == 1))
    {
      i = 1;
      int j = k;
      if (i != 0)
      {
        j = k;
        if (this.BgY.value == 4) {
          j = 1;
        }
      }
      if (j != 0) {
        this.Bjd = true;
      }
      if (!(paramIResponse instanceof d)) {
        break label193;
      }
      paramIResponse = (d)paramIResponse;
      label87:
      if ((paramIResponse != null) && (paramIResponse.getPullType() == 0))
      {
        paramIResponse = paramIResponse.getIncrementList();
        if (paramIResponse != null)
        {
          localObject = ((Iterable)paramIResponse).iterator();
          label118:
          if (!((Iterator)localObject).hasNext()) {
            break label203;
          }
          paramIResponse = (cc)((Iterator)localObject).next();
          if (!(paramIResponse instanceof BaseFinderFeed)) {
            break label198;
          }
          paramIResponse = (BaseFinderFeed)paramIResponse;
          if (paramIResponse == null) {
            break label201;
          }
        }
      }
    }
    for (;;)
    {
      if (paramIResponse != null)
      {
        localObject = com.tencent.mm.plugin.finder.extension.reddot.d.APW;
        com.tencent.mm.plugin.finder.extension.reddot.d.c(paramIResponse.feedObject.getFeedObject(), this.BgY.value);
      }
      AppMethodBeat.o(166052);
      return;
      i = 0;
      break;
      label193:
      paramIResponse = null;
      break label87;
      label198:
      paramIResponse = null;
      break label151;
      label201:
      break label118;
      label203:
      paramIResponse = null;
    }
  }
  
  public final void onPostStart(long paramLong)
  {
    AppMethodBeat.i(366569);
    super.onPostStart(paramLong);
    this.Bjc = true;
    Log.i(getTAG(), "onPostStart postFeedFlag true");
    AppMethodBeat.o(366569);
  }
  
  public final void onPostStart(long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(366561);
    super.onPostStart(paramLong, paramBoolean);
    this.Bjc = true;
    AppMethodBeat.o(366561);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/model/FinderTimelineFeedLoader$CgiConsumeCallback;", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderTimelineStream$ConsumeCallback;", "taskExecutor", "Lcom/tencent/mm/loader/loader/SingleTaskExecutor;", "task", "Lcom/tencent/mm/loader/loader/SingleTask;", "(Lcom/tencent/mm/loader/loader/SingleTaskExecutor;Lcom/tencent/mm/loader/loader/SingleTask;)V", "getTask", "()Lcom/tencent/mm/loader/loader/SingleTask;", "getTaskExecutor", "()Lcom/tencent/mm/loader/loader/SingleTaskExecutor;", "isFetchConsume", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/ResponseProtoBuf;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  static final class a
    implements ar.c
  {
    private final com.tencent.mm.loader.f.h ADY;
    private final com.tencent.mm.loader.f.g Bgh;
    
    public a(com.tencent.mm.loader.f.h paramh, com.tencent.mm.loader.f.g paramg)
    {
      AppMethodBeat.i(366356);
      this.ADY = paramh;
      this.Bgh = paramg;
      AppMethodBeat.o(366356);
    }
    
    public final boolean b(esc paramesc)
    {
      AppMethodBeat.i(366366);
      kotlin.g.b.s.u(paramesc, "resp");
      if ((this.ADY != null) && (this.ADY.nrw != this.Bgh.nrw))
      {
        this.Bgh.a(com.tencent.mm.loader.f.i.nrG);
        Log.w("CgiConsumeCallback", "[isFetchConsume] executorToken=" + this.ADY.nrw + " taskToken=" + this.Bgh.nrw);
        AppMethodBeat.o(366366);
        return true;
      }
      AppMethodBeat.o(366366);
      return false;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/model/FinderTimelineFeedLoader$TimelineDataFetcher;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataFetch;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycleKeeper;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycle;", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderTimelineStream$Callback;", "streamFetcher", "Lcom/tencent/mm/plugin/finder/cgi/fetcher/FinderTimelineFeedFetcher;", "scene", "Lcom/tencent/mm/plugin/finder/feed/model/internal/FinderLoaderScene;", "(Lcom/tencent/mm/plugin/finder/feed/model/FinderTimelineFeedLoader;Lcom/tencent/mm/plugin/finder/cgi/fetcher/FinderTimelineFeedFetcher;Lcom/tencent/mm/plugin/finder/feed/model/internal/FinderLoaderScene;)V", "taskExecutor", "Lcom/tencent/mm/loader/loader/SingleTaskExecutor;", "alive", "", "dead", "fetch", "request", "", "callback", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataCallback;", "isAuto", "", "fetchInit", "fetchLoadMore", "fetchRefresh", "keep", "p0", "onFetchDone", "info", "Lcom/tencent/mm/plugin/finder/feed/model/CgiFinderStreamResult;", "pullType", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class b
    extends com.tencent.mm.plugin.finder.feed.model.internal.i<cc>
    implements ar.a, com.tencent.mm.vending.e.b<com.tencent.mm.vending.e.a>
  {
    private com.tencent.mm.loader.f.h ADY;
    private final com.tencent.mm.plugin.finder.feed.model.internal.g BgY;
    private final e Bjb;
    
    public b(com.tencent.mm.plugin.finder.feed.model.internal.g paramg)
    {
      AppMethodBeat.i(366349);
      this.Bjb = paramg;
      this.BgY = localObject;
      AppMethodBeat.o(366349);
    }
    
    public final void a(d paramd, int paramInt)
    {
      AppMethodBeat.i(366389);
      kotlin.g.b.s.u(paramd, "info");
      AppMethodBeat.o(366389);
    }
    
    public final void alive()
    {
      AppMethodBeat.i(366415);
      super.alive();
      com.tencent.mm.loader.f.h localh;
      if (this.BgY == com.tencent.mm.plugin.finder.feed.model.internal.g.Bkd)
      {
        this.ADY = ((PluginFinder)com.tencent.mm.kernel.h.az(PluginFinder.class)).getFollowTlSingleExecutor();
        localh = this.ADY;
        if (localh != null)
        {
          localh.clean();
          AppMethodBeat.o(366415);
        }
      }
      else
      {
        localh = new com.tencent.mm.loader.f.h(kotlin.g.b.s.X("SingleExecutor#TabType=", Integer.valueOf(this.Bjb.hJx)));
        localh.start();
        ah localah = ah.aiuX;
        this.ADY = localh;
      }
      AppMethodBeat.o(366415);
    }
    
    public final void dead()
    {
      AppMethodBeat.i(366423);
      super.dead();
      com.tencent.mm.loader.f.h localh = this.ADY;
      if (localh != null) {
        localh.reset();
      }
      this.ADY = null;
      AppMethodBeat.o(366423);
    }
    
    public final void fetch(final Object paramObject, com.tencent.mm.plugin.finder.feed.model.internal.h<cc> paramh, final boolean paramBoolean)
    {
      AppMethodBeat.i(366430);
      kotlin.g.b.s.u(paramh, "callback");
      if ((paramObject instanceof FinderTimelineFeedLoader.c))
      {
        final long l = SystemClock.uptimeMillis();
        com.tencent.mm.loader.f.h localh = this.ADY;
        if (localh != null) {
          localh.a(new com.tencent.mm.loader.f.g((kotlin.g.a.b)new a(this, paramObject, l, paramh, paramBoolean)));
        }
      }
      AppMethodBeat.o(366430);
    }
    
    public final void fetchInit(com.tencent.mm.plugin.finder.feed.model.internal.h<cc> paramh)
    {
      AppMethodBeat.i(366408);
      kotlin.g.b.s.u(paramh, "callback");
      Object localObject1 = FinderTimelineFeedLoader.this.AEF;
      int i;
      label53:
      int j;
      label125:
      Object localObject2;
      label162:
      label196:
      boolean bool;
      label225:
      Object localObject3;
      Object localObject4;
      label301:
      label337:
      long l;
      if ((localObject1 != null) && (((com.tencent.mm.plugin.finder.cgi.fetcher.d)localObject1).AAd == 1))
      {
        i = 1;
        if ((i == 0) || (this.Bjb.hJx != 4)) {
          break label537;
        }
        i = 1;
        localObject1 = ax.AZe;
        j = this.Bjb.hJx;
        localObject1 = com.tencent.mm.ui.component.k.aeZF;
        localObject1 = com.tencent.mm.ui.component.k.cn(PluginFinder.class).q(com.tencent.mm.plugin.finder.viewmodel.d.class);
        kotlin.g.b.s.s(localObject1, "UICProvider.of(PluginFin…meTabStateVM::class.java)");
        if ((!((com.tencent.mm.plugin.finder.viewmodel.d)localObject1).Rp(j)) || ((!ax.NG(j)) && ((!ax.NH(j)) || (!ax.NI(j))))) {
          break label542;
        }
        j = 1;
        if ((j == 0) && (i == 0)) {
          break label563;
        }
        if (i == 0) {
          break label552;
        }
        localObject1 = FinderTimelineFeedLoader.this.AEF;
        if ((localObject1 == null) || (((com.tencent.mm.plugin.finder.cgi.fetcher.d)localObject1).AEE != true)) {
          break label547;
        }
        i = 1;
        if (i == 0) {
          break label552;
        }
        localObject1 = av.GiL;
        localObject1 = av.a(114, FinderTimelineFeedLoader.this.getContextObj(), FinderTimelineFeedLoader.this.getPageName(), false, false, 24);
        localObject2 = com.tencent.mm.plugin.finder.report.s.Fqv;
        i = this.Bjb.hJx;
        if (((Collection)localObject1).isEmpty()) {
          break label629;
        }
        bool = true;
        com.tencent.mm.plugin.finder.report.s.aK(i, bool);
        localObject2 = (cc)p.oL((List)localObject1);
        localObject3 = getTAG();
        localObject4 = new StringBuilder("fetchInit tabType=").append(this.Bjb.hJx).append(" callInitData scene=").append(this.BgY).append(", contextObj=");
        if (FinderTimelineFeedLoader.this.getContextObj() != null) {
          break label635;
        }
        bool = true;
        localObject4 = ((StringBuilder)localObject4).append(bool).append(" list first=");
        if (!(localObject2 instanceof BaseFinderFeed)) {
          break label641;
        }
        localObject2 = ((BaseFinderFeed)localObject2).feedObject.getNickName();
        localObject2 = ((StringBuilder)localObject4).append((String)localObject2).append(" => ");
        localObject4 = (cc)p.oL((List)localObject1);
        if (localObject4 != null) {
          break label649;
        }
        l = 0L;
        label370:
        Log.i((String)localObject3, com.tencent.mm.ae.d.hF(l));
        localObject2 = cn.AMo;
        if (!cn.Nk(this.Bjb.hJx)) {
          break label702;
        }
        localObject1 = cn.AMo;
        localObject1 = cn.dYb();
      }
      label537:
      label542:
      label547:
      label552:
      label563:
      label702:
      for (;;)
      {
        localObject2 = new FinderTimelineFeedLoader.d(0, 0, "", (byte)0);
        localObject3 = (Iterable)localObject1;
        localObject1 = (Collection)new ArrayList();
        localObject3 = ((Iterable)localObject3).iterator();
        for (;;)
        {
          label459:
          if (!((Iterator)localObject3).hasNext()) {
            break label667;
          }
          localObject4 = ((Iterator)localObject3).next();
          cc localcc = (cc)localObject4;
          if ((localcc instanceof BaseFinderFeed)) {
            av localav = av.GiL;
          }
          for (bool = av.y(((BaseFinderFeed)localcc).feedObject.getFeedObject());; bool = true)
          {
            if (!bool) {
              break label665;
            }
            ((Collection)localObject1).add(localObject4);
            break label459;
            i = 0;
            break;
            i = 0;
            break label53;
            j = 0;
            break label125;
            i = 0;
            break label162;
            localObject1 = (List)ab.aivy;
            break label196;
            localObject1 = av.GiL;
            i = this.BgY.value;
            localObject1 = FinderTimelineFeedLoader.this.getContextObj();
            j = FinderTimelineFeedLoader.this.getPageName();
            if (FinderTimelineFeedLoader.this.Bja == 0) {}
            for (bool = true;; bool = false)
            {
              localObject1 = av.a(i, (bui)localObject1, j, false, bool, 8);
              break;
            }
            label629:
            bool = false;
            break label225;
            label635:
            bool = false;
            break label301;
            localObject2 = "";
            break label337;
            l = ((cc)localObject4).bZA();
            break label370;
          }
        }
        ((FinderTimelineFeedLoader.d)localObject2).setIncrementList((List)localObject1);
        ((FinderTimelineFeedLoader.d)localObject2).setPullType(1000);
        paramh.onFetchDone((IResponse)localObject2);
        AppMethodBeat.o(366408);
        return;
      }
    }
    
    public final void fetchLoadMore(com.tencent.mm.plugin.finder.feed.model.internal.h<cc> paramh, boolean paramBoolean)
    {
      AppMethodBeat.i(366379);
      kotlin.g.b.s.u(paramh, "callback");
      fetch(new FinderTimelineFeedLoader.c(2), paramh, paramBoolean);
      AppMethodBeat.o(366379);
    }
    
    public final void fetchRefresh(com.tencent.mm.plugin.finder.feed.model.internal.h<cc> paramh)
    {
      AppMethodBeat.i(366372);
      kotlin.g.b.s.u(paramh, "callback");
      FinderTimelineFeedLoader.c localc = new FinderTimelineFeedLoader.c(FinderTimelineFeedLoader.this.Bja);
      if (localc.Bji) {}
      for (localc.pullType = 4;; localc.pullType = FinderTimelineFeedLoader.this.Bja)
      {
        if (FinderTimelineFeedLoader.this.Bja == 0) {
          FinderTimelineFeedLoader.this.Bja = 1;
        }
        Log.i(getTAG(), "[requestRefresh] pullType=" + localc.pullType + "  hasPrefetch=" + localc.Bjh + " needToRefreshForPrefetch=" + localc.Bji);
        com.tencent.mm.plugin.finder.feed.model.internal.i.fetch$default((com.tencent.mm.plugin.finder.feed.model.internal.i)this, localc, paramh, false, 4, null);
        AppMethodBeat.o(366372);
        return;
      }
    }
    
    public final void keep(com.tencent.mm.vending.e.a parama)
    {
      AppMethodBeat.i(366384);
      kotlin.g.b.s.u(parama, "p0");
      AppMethodBeat.o(366384);
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", "", "task", "Lcom/tencent/mm/loader/loader/SingleTask;"}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends u
      implements kotlin.g.a.b<com.tencent.mm.loader.f.g, ah>
    {
      a(FinderTimelineFeedLoader.b paramb, Object paramObject, long paramLong, com.tencent.mm.plugin.finder.feed.model.internal.h<cc> paramh, boolean paramBoolean)
      {
        super();
      }
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/model/FinderTimelineFeedLoader$TimelineRequest;", "", "pullType", "", "unreadList", "", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "(ILjava/util/List;)V", "hasPrefetch", "", "getHasPrefetch", "()Z", "setHasPrefetch", "(Z)V", "isPreloadMore", "setPreloadMore", "minDuration", "", "getMinDuration", "()J", "setMinDuration", "(J)V", "needToRefreshForPrefetch", "getNeedToRefreshForPrefetch", "setNeedToRefreshForPrefetch", "getPullType", "()I", "setPullType", "(I)V", "requestId", "getRequestId", "setRequestId", "sceneStatus", "Lcom/tencent/mm/protocal/protobuf/FinderStreamSceneStatus;", "getSceneStatus", "()Lcom/tencent/mm/protocal/protobuf/FinderStreamSceneStatus;", "setSceneStatus", "(Lcom/tencent/mm/protocal/protobuf/FinderStreamSceneStatus;)V", "getUnreadList", "()Ljava/util/List;", "setUnreadList", "(Ljava/util/List;)V", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
  {
    List<? extends BaseFinderFeed> Ayr;
    boolean Bjh;
    boolean Bji;
    long Bjj;
    boolean Bjk;
    public long Bjl;
    public bwj Bjm;
    int pullType;
    
    public c(int paramInt, List<? extends BaseFinderFeed> paramList)
    {
      this.pullType = paramInt;
      this.Ayr = paramList;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/model/FinderTimelineFeedLoader$TimelineResponse;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "errType", "", "errCode", "errMsg", "", "extraData", "", "(IILjava/lang/String;Ljava/lang/Object;)V", "dataBufferList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getDataBufferList", "()Ljava/util/ArrayList;", "setDataBufferList", "(Ljava/util/ArrayList;)V", "getExtraData", "()Ljava/lang/Object;", "setExtraData", "(Ljava/lang/Object;)V", "tipsShowInfo", "Lcom/tencent/mm/protocal/protobuf/FinderStreamTipsShowInfo;", "getTipsShowInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderStreamTipsShowInfo;", "setTipsShowInfo", "(Lcom/tencent/mm/protocal/protobuf/FinderStreamTipsShowInfo;)V", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class d
    extends IResponse<cc>
  {
    ArrayList<cc> BeE;
    public bwk Bjn;
    public Object extraData = null;
    
    private d(int paramInt1, int paramInt2, String paramString)
    {
      super(paramInt2, paramString);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/feed/model/FinderTimelineFeedLoader$createDataMerger$1", "Lcom/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader$DefaultDataMerger;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "isDebug", "", "checkFeedState", "", "response", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "", "isFirstShareToTimeline", "finderSharePreloadCore", "Lcom/tencent/mm/plugin/finder/preload/FinderSharePreloadCore;", "cleanDataList", "dataList", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataBuffer;", "mergeDataAndNotify", "Lcom/tencent/mm/plugin/finder/feed/model/internal/MergeResult;", "cmd", "", "insList", "", "isNeedClear", "request", "mergeLoadMore", "next", "Lkotlin/Function1;", "mergeRefresh", "needCleanWhenRefresh", "newList", "notifyLiveListChange", "liveStatus", "username", "", "onDataReplace", "feed", "existIndex", "updateLiveList", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class e
    extends BaseFeedLoader<cc>.a
  {
    private final boolean eYL;
    
    e(FinderTimelineFeedLoader paramFinderTimelineFeedLoader)
    {
      super(false, 1, null);
      AppMethodBeat.i(366361);
      if ((BuildInfo.IS_FLAVOR_PURPLE) || (BuildInfo.IS_FLAVOR_RED) || (CrashReportFactory.hasDebuger())) {
        bool = true;
      }
      this.eYL = bool;
      AppMethodBeat.o(366361);
    }
    
    private static void bt(int paramInt, String paramString)
    {
      AppMethodBeat.i(366370);
      Object localObject = (CharSequence)paramString;
      if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {}
      for (int i = 1;; i = 0)
      {
        if (i == 0)
        {
          localObject = new if();
          ((if)localObject).hJB.hJD = 0;
          ((if)localObject).hJB.liveStatus = paramInt;
          ((if)localObject).hJB.username = paramString;
          ((if)localObject).hJB.type = 9;
          ((if)localObject).publish();
        }
        AppMethodBeat.o(366370);
        return;
      }
    }
    
    public final void cleanDataList(DataBuffer<cc> paramDataBuffer)
    {
      AppMethodBeat.i(366413);
      kotlin.g.b.s.u(paramDataBuffer, "dataList");
      super.cleanDataList(paramDataBuffer);
      AppMethodBeat.o(366413);
    }
    
    public final o mergeDataAndNotify(int paramInt, List<? extends cc> paramList, boolean paramBoolean, Object paramObject)
    {
      AppMethodBeat.i(366450);
      boolean bool = false;
      Object localObject1;
      int i;
      int j;
      label66:
      label81:
      label107:
      Object localObject2;
      Object localObject3;
      if (!paramBoolean)
      {
        localObject1 = (List)this.Bjf.getDataList();
        i = 0;
        localObject1 = ((List)localObject1).iterator();
        if (((Iterator)localObject1).hasNext()) {
          if (((cc)((Iterator)localObject1).next() instanceof y))
          {
            j = i;
            if (paramList == null) {
              break label603;
            }
            localObject1 = paramList.iterator();
            i = 0;
            if (!((Iterator)localObject1).hasNext()) {
              break label603;
            }
            if (!((cc)((Iterator)localObject1).next() instanceof y)) {
              break label594;
            }
            if ((j != -1) || (i == -1)) {
              break label625;
            }
            if (paramList == null) {
              break label1937;
            }
            localObject2 = (cc)paramList.get(i);
            if (localObject2 == null) {
              break label1937;
            }
            localObject3 = this.Bjf;
            ((FinderTimelineFeedLoader)localObject3).getDataList().add(0, localObject2);
            ((FinderTimelineFeedLoader)localObject3).dispatcher().onItemRangeInserted(0, 1);
            localObject1 = com.tencent.mm.plugin.finder.model.d.ECf;
            if (!(localObject2 instanceof y)) {
              break label609;
            }
            localObject1 = (y)localObject2;
            label188:
            if (localObject1 != null) {
              break label615;
            }
            localObject1 = null;
            label196:
            localObject1 = com.tencent.mm.plugin.finder.model.d.a.au((ArrayList)localObject1);
            bt(1, (String)localObject1);
            Log.i(((FinderTimelineFeedLoader)localObject3).getTAG(), "[updateLiveList] add " + localObject2 + ", live update:true, incrementUsernameString:" + (String)localObject1);
            bool = true;
          }
        }
      }
      for (;;)
      {
        label249:
        if (paramList == null) {}
        label567:
        label594:
        label603:
        label609:
        label615:
        label625:
        Object localObject4;
        for (localObject1 = null;; localObject1 = new ArrayList((Collection)paramList))
        {
          localObject2 = localObject1;
          if (localObject1 == null) {
            localObject2 = new ArrayList();
          }
          if (paramInt == 4)
          {
            localObject1 = com.tencent.mm.plugin.finder.storage.d.FAy;
            if (((Number)com.tencent.mm.plugin.finder.storage.d.eYf().bmg()).intValue() == 1)
            {
              localObject1 = this.Bjf.zHB;
              if (localObject1 != null)
              {
                localObject1 = (RecyclerView)((WeakReference)localObject1).get();
                if (localObject1 != null)
                {
                  localObject3 = this.Bjf;
                  if (((FinderTimelineFeedLoader)localObject3).getDataList().size() > 0)
                  {
                    if (!(p.oL((List)localObject2) instanceof ai)) {
                      break label1160;
                    }
                    Log.w(((FinderTimelineFeedLoader)localObject3).getTAG(), "mergeDataAndNotify: first item is FinderFoldedFeed, do not add history feed");
                  }
                }
              }
            }
          }
          localObject3 = super.mergeDataAndNotify(paramInt, (List)localObject2, paramBoolean, paramObject);
          localObject1 = localObject3;
          if (paramList != null)
          {
            localObject1 = localObject3;
            if (!paramBoolean)
            {
              localObject1 = localObject3;
              if (paramInt == 4)
              {
                Log.i(this.Bjf.getTAG(), "isNeedClear false, manual merge...");
                localObject1 = merge((List)localObject2, 1, paramObject);
                ((o)localObject1).apS = 0;
              }
            }
          }
          if (!this.eYL) {
            break label1749;
          }
          if ((this.Bjf.Bjb.hJx != 4) || (paramInt != 1)) {
            break label1770;
          }
          paramObject = kotlin.g.b.s.X(this.Bjf.getTAG(), "#loadMore");
          paramList = (Iterable)this.Bjf.getDataList();
          localObject2 = (Collection)new ArrayList(p.a(paramList, 10));
          localObject3 = paramList.iterator();
          for (;;)
          {
            if (!((Iterator)localObject3).hasNext()) {
              break label1736;
            }
            paramList = (cc)((Iterator)localObject3).next();
            if (!(paramList instanceof BaseFinderFeed)) {
              break;
            }
            paramList = com.tencent.mm.ae.d.hF(((BaseFinderFeed)paramList).feedObject.getFeedObject().id);
            ((Collection)localObject2).add(paramList);
          }
          i += 1;
          break;
          j = -1;
          break label66;
          i += 1;
          break label81;
          i = -1;
          break label107;
          localObject1 = null;
          break label188;
          localObject1 = ((y)localObject1).eDm();
          break label196;
          if ((j != -1) && (i == -1))
          {
            localObject1 = this.Bjf.getDataList().remove(j);
            kotlin.g.b.s.s(localObject1, "dataList.removeAt(oriLiveItemIndex)");
            localObject2 = (cc)localObject1;
            this.Bjf.dispatcher().onItemRangeRemoved(j, 1);
            localObject1 = com.tencent.mm.plugin.finder.model.d.ECf;
            if ((localObject2 instanceof y))
            {
              localObject1 = (y)localObject2;
              label699:
              if (localObject1 != null) {
                break label771;
              }
            }
            label771:
            for (localObject1 = null;; localObject1 = ((y)localObject1).eDm())
            {
              localObject1 = com.tencent.mm.plugin.finder.model.d.a.au((ArrayList)localObject1);
              bt(2, (String)localObject1);
              Log.i(this.Bjf.getTAG(), "[updateLiveList] remove " + localObject2 + ", live update:false, removeUsernameString:" + (String)localObject1);
              bool = false;
              break;
              localObject1 = null;
              break label699;
            }
          }
          if ((j == -1) || (i == -1) || (paramList == null)) {
            break label1937;
          }
          localObject3 = (cc)paramList.get(i);
          if (localObject3 == null) {
            break label1937;
          }
          localObject4 = this.Bjf;
          localObject1 = com.tencent.mm.plugin.finder.model.d.ECf;
          localObject1 = ((FinderTimelineFeedLoader)localObject4).getDataList().get(j);
          if ((localObject1 instanceof y))
          {
            localObject1 = (y)localObject1;
            label853:
            if (localObject1 != null) {
              break label1082;
            }
            localObject1 = null;
            label861:
            if (!(localObject3 instanceof y)) {
              break label1092;
            }
            localObject2 = (y)localObject3;
            label876:
            if (localObject2 != null) {
              break label1098;
            }
            localObject2 = null;
            label884:
            localObject1 = com.tencent.mm.plugin.finder.model.d.a.i((ArrayList)localObject1, (ArrayList)localObject2);
            localObject2 = (Collection)((com.tencent.mm.plugin.finder.model.d)localObject1).ECg;
            if ((localObject2 != null) && (!((Collection)localObject2).isEmpty())) {
              break label1108;
            }
            i = 1;
            label921:
            if (i != 0)
            {
              localObject2 = (Collection)((com.tencent.mm.plugin.finder.model.d)localObject1).upm;
              if ((localObject2 != null) && (!((Collection)localObject2).isEmpty())) {
                break label1114;
              }
              i = 1;
              label954:
              if (i != 0) {
                break label1120;
              }
            }
          }
          label1082:
          label1092:
          label1098:
          label1108:
          label1114:
          label1120:
          for (bool = true;; bool = false)
          {
            bt(1, ((com.tencent.mm.plugin.finder.model.d)localObject1).ECh);
            bt(2, ((com.tencent.mm.plugin.finder.model.d)localObject1).ECi);
            ((FinderTimelineFeedLoader)localObject4).getDataList().set(j, localObject3);
            Log.i(((FinderTimelineFeedLoader)localObject4).getTAG(), "[updateLiveList] replace " + localObject3 + ", live update:" + bool + ", incrememnt username:" + ((com.tencent.mm.plugin.finder.model.d)localObject1).ECh + ",remove username:" + ((com.tencent.mm.plugin.finder.model.d)localObject1).ECi);
            if (!bool) {
              break label1126;
            }
            ((FinderTimelineFeedLoader)localObject4).dispatcher().Oc(j);
            break;
            localObject1 = null;
            break label853;
            localObject1 = ((y)localObject1).eDm();
            break label861;
            localObject2 = null;
            break label876;
            localObject2 = ((y)localObject2).eDm();
            break label884;
            i = 0;
            break label921;
            i = 0;
            break label954;
          }
          label1126:
          ((FinderTimelineFeedLoader)localObject4).dispatcher().onItemRangeChanged(j, 1, Integer.valueOf(1));
          break label249;
        }
        label1160:
        localObject1 = ((RecyclerView)localObject1).getLayoutManager();
        if ((localObject1 instanceof LinearLayoutManager))
        {
          localObject1 = (LinearLayoutManager)localObject1;
          label1182:
          if (localObject1 == null) {
            break label1537;
          }
          j = kotlin.k.k.qu(Math.min(((LinearLayoutManager)localObject1).Ju(), ((FinderTimelineFeedLoader)localObject3).getDataList().size() - 1), 0);
          Log.i(((FinderTimelineFeedLoader)localObject3).getTAG(), "mergeDataAndNotify: leaveIndex = " + j + ", size = " + ((FinderTimelineFeedLoader)localObject3).getDataList().size());
          localObject4 = (List)new ArrayList();
          if (j >= 0) {
            i = 0;
          }
        }
        for (;;)
        {
          localObject1 = ((FinderTimelineFeedLoader)localObject3).getDataList().get(i);
          label1301:
          label1345:
          int m;
          if ((localObject1 instanceof BaseFinderFeed))
          {
            localObject1 = (BaseFinderFeed)localObject1;
            if (localObject1 != null)
            {
              ((BaseFinderFeed)localObject1).isHistoryFeed = true;
              ((List)localObject4).add(localObject1);
            }
            if (i != j) {
              break label1928;
            }
            if (((Collection)localObject4).isEmpty()) {
              break label1545;
            }
            i = 1;
            if (i == 0) {
              break label1549;
            }
            Log.i(((FinderTimelineFeedLoader)localObject3).getTAG(), "mergeDataAndNotify: historySize = " + ((List)localObject4).size() + ", feedIds = " + p.a((Iterable)localObject4, null, null, null, 0, null, (kotlin.g.a.b)b.Bjo, 31));
            m = ((List)localObject4).size();
            if (m <= 0) {
              break label1702;
            }
          }
          int k;
          label1537:
          label1921:
          for (i = 0;; i = k)
          {
            k = i + 1;
            Object localObject5 = (Iterable)localObject2;
            localObject1 = (Collection)new ArrayList();
            localObject5 = ((Iterable)localObject5).iterator();
            label1545:
            label1549:
            label1555:
            for (;;)
            {
              label1462:
              if (!((Iterator)localObject5).hasNext()) {
                break label1557;
              }
              Object localObject6 = ((Iterator)localObject5).next();
              if (((cc)localObject6).bZA() == ((cc)((List)localObject4).get(i)).bZA()) {}
              for (j = 1;; j = 0)
              {
                if (j == 0) {
                  break label1555;
                }
                ((Collection)localObject1).add(localObject6);
                break label1462;
                localObject1 = null;
                break label1182;
                break;
                localObject1 = null;
                break label1301;
                i = 0;
                break label1345;
                break;
              }
            }
            label1557:
            localObject1 = (List)localObject1;
            if (!((Collection)localObject1).isEmpty())
            {
              j = 1;
              label1580:
              if (j != 0)
              {
                Log.i(((FinderTimelineFeedLoader)localObject3).getTAG(), kotlin.g.b.s.X("mergeDataAndNotify: repeat feed deleted, feedId = ", com.tencent.mm.ae.d.hF(((cc)((List)localObject4).get(i)).bZA())));
                ((ArrayList)localObject2).removeAll((Collection)localObject1);
                localObject5 = p.oK((List)localObject1);
                localObject1 = (cc)localObject5;
                if (!(localObject1 instanceof BaseFinderFeed)) {
                  break label1723;
                }
              }
            }
            label1702:
            label1723:
            for (localObject1 = (BaseFinderFeed)localObject1;; localObject1 = null)
            {
              if (localObject1 != null) {
                ((BaseFinderFeed)localObject1).isHistoryFeed = true;
              }
              localObject1 = ah.aiuX;
              kotlin.g.b.s.s(localObject5, "filterFeeds.first().appl…                        }");
              ((List)localObject4).set(i, localObject5);
              if (k < m) {
                break label1921;
              }
              ((ArrayList)localObject2).addAll(0, (Collection)localObject4);
              break;
              j = 0;
              break label1580;
            }
            paramList = "";
            break label567;
            label1736:
            Log.i(paramObject, String.valueOf((List)localObject2));
            for (;;)
            {
              label1749:
              ((o)localObject1).BkF |= bool;
              AppMethodBeat.o(366450);
              return localObject1;
              label1770:
              if ((this.Bjf.Bjb.hJx == 4) && (paramInt == 4))
              {
                paramObject = kotlin.g.b.s.X(this.Bjf.getTAG(), "#refresh");
                paramList = (Iterable)this.Bjf.getDataList();
                localObject2 = (Collection)new ArrayList(p.a(paramList, 10));
                localObject3 = paramList.iterator();
                if (((Iterator)localObject3).hasNext())
                {
                  paramList = (cc)((Iterator)localObject3).next();
                  if ((paramList instanceof BaseFinderFeed)) {}
                  for (paramList = com.tencent.mm.ae.d.hF(((BaseFinderFeed)paramList).feedObject.getFeedObject().id);; paramList = "")
                  {
                    ((Collection)localObject2).add(paramList);
                    break;
                  }
                }
                Log.i(paramObject, String.valueOf((List)localObject2));
              }
            }
          }
          label1928:
          i += 1;
        }
        label1937:
        bool = false;
      }
    }
    
    public final void mergeLoadMore(final IResponse<cc> paramIResponse, final kotlin.g.a.b<? super IResponse<cc>, ah> paramb)
    {
      int i = 1;
      AppMethodBeat.i(366405);
      kotlin.g.b.s.u(paramIResponse, "response");
      if ((paramIResponse instanceof FinderTimelineFeedLoader.d)) {
        this.Bjf.getDataListJustForAdapter().setBuffer((Collection)((FinderTimelineFeedLoader.d)paramIResponse).BeE);
      }
      final RefreshLoadMoreLayout.d locald = new RefreshLoadMoreLayout.d(paramIResponse.getPullType());
      locald.agJu = paramIResponse.getHasMore();
      locald.agJt = ((CharSequence)MMApplicationContext.getContext().getResources().getString(e.h.finder_timeline_history_footer_tip));
      locald.agJs = 2;
      boolean bool;
      if (!paramIResponse.getHasMore())
      {
        bool = true;
        locald.pzq = bool;
        Log.i(this.Bjf.getTAG(), "[onFetchLoadMoreDone] tabtype=" + this.Bjf.BgY.value + " reason=" + locald);
        if (!paramIResponse.getHasMore()) {
          break label212;
        }
      }
      for (;;)
      {
        com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new c(this, new r(i, paramIResponse.getIncrementList(), false, 12), locald, this.Bjf, paramb, paramIResponse));
        AppMethodBeat.o(366405);
        return;
        bool = false;
        break;
        label212:
        i = 5;
      }
    }
    
    public final void mergeRefresh(final IResponse<cc> paramIResponse, final kotlin.g.a.b<? super IResponse<cc>, ah> paramb)
    {
      AppMethodBeat.i(366395);
      kotlin.g.b.s.u(paramIResponse, "response");
      final RefreshLoadMoreLayout.d locald = new RefreshLoadMoreLayout.d(paramIResponse.getPullType());
      Object localObject;
      final boolean bool;
      label85:
      com.tencent.mm.plugin.finder.cgi.fetcher.d locald1;
      label168:
      int i;
      label274:
      label305:
      long l;
      if ((paramIResponse.getErrType() == 0) && (paramIResponse.getErrCode() == 0))
      {
        locald.agJs = 1;
        locald.extraData = paramIResponse;
        localObject = this.Bjf.Bje;
        if (localObject != null) {
          ((kotlin.g.a.b)localObject).invoke(paramIResponse);
        }
        if (paramIResponse.getPullType() == 0) {
          break label430;
        }
        bool = true;
        locald.pzq = bool;
        locald.agJu = paramIResponse.getHasMore();
        if ((paramIResponse.getErrType() == 0) && (paramIResponse.getErrCode() == 0) && ((locald.actionType == 0) || (locald.actionType == 4) || (locald.actionType == 1)))
        {
          if ((locald.agJv <= 0) && (this.Bjf.getDataListJustForAdapter().size() > 0)) {
            break label436;
          }
          locald.agJt = null;
        }
        Log.i(this.Bjf.getTAG(), "[onFetchRefreshDone] tabtype=" + this.Bjf.BgY.value + " reason=" + locald);
        localObject = com.tencent.mm.ui.component.k.aeZF;
        localObject = com.tencent.mm.ui.component.k.cn(PluginFinder.class).q(com.tencent.mm.plugin.finder.preload.c.class);
        kotlin.g.b.s.s(localObject, "UICProvider.of(PluginFin…ePreloadCore::class.java)");
        localObject = (com.tencent.mm.plugin.finder.preload.c)localObject;
        locald1 = this.Bjf.AEF;
        if ((locald1 == null) || (locald1.AAd != 1)) {
          break label459;
        }
        i = 1;
        if ((i == 0) || (this.Bjf.BgY.value != 4) || (this.Bjf.Bjd)) {
          break label464;
        }
        bool = true;
        locald1 = this.Bjf.AEF;
        if (locald1 != null) {
          break label470;
        }
        l = 0L;
        label322:
        if (com.tencent.mm.plugin.finder.preload.c.po(l) == null) {
          break label480;
        }
        i = 1;
        label332:
        if ((!bool) || (i == 0)) {
          break label485;
        }
        locald.agJx = true;
        i = 9;
      }
      for (;;)
      {
        com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new d(this, paramIResponse, locald, bool, (com.tencent.mm.plugin.finder.preload.c)localObject, new r(i, paramIResponse.getIncrementList(), paramIResponse.isNeedClear(), 8), this.Bjf, paramb));
        AppMethodBeat.o(366395);
        return;
        locald.agJt = ((CharSequence)MMApplicationContext.getContext().getResources().getString(e.h.finder_tl_no_more_refresh_nomore_err_header));
        locald.agJs = -1;
        break;
        label430:
        bool = false;
        break label85;
        label436:
        locald.agJt = ((CharSequence)MMApplicationContext.getContext().getResources().getString(e.h.finder_tl_no_more_refresh_nomore_newcontent_header));
        break label168;
        label459:
        i = 0;
        break label274;
        label464:
        bool = false;
        break label305;
        label470:
        l = locald1.hKN;
        break label322;
        label480:
        i = 0;
        break label332;
        label485:
        if (paramIResponse.getHasMore())
        {
          locald.agJx = false;
          i = 4;
        }
        else
        {
          locald.agJx = false;
          i = 6;
        }
      }
    }
    
    public final boolean needCleanWhenRefresh(List<? extends cc> paramList)
    {
      AppMethodBeat.i(366457);
      kotlin.g.b.s.u(paramList, "newList");
      AppMethodBeat.o(366457);
      return true;
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", "", "feed", "Lcom/tencent/mm/plugin/finder/model/RVFeed;"}, k=3, mv={1, 5, 1}, xi=48)
    static final class b
      extends u
      implements kotlin.g.a.b<cc, CharSequence>
    {
      public static final b Bjo;
      
      static
      {
        AppMethodBeat.i(366485);
        Bjo = new b();
        AppMethodBeat.o(366485);
      }
      
      b()
      {
        super();
      }
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class c
      extends u
      implements kotlin.g.a.a<ah>
    {
      c(FinderTimelineFeedLoader.e parame, r<cc> paramr, RefreshLoadMoreLayout.d<Object> paramd, FinderTimelineFeedLoader paramFinderTimelineFeedLoader, kotlin.g.a.b<? super IResponse<cc>, ah> paramb, IResponse<cc> paramIResponse)
      {
        super();
      }
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class d
      extends u
      implements kotlin.g.a.a<ah>
    {
      d(FinderTimelineFeedLoader.e parame, IResponse<cc> paramIResponse, RefreshLoadMoreLayout.d<Object> paramd, boolean paramBoolean, com.tencent.mm.plugin.finder.preload.c paramc, r<cc> paramr, FinderTimelineFeedLoader paramFinderTimelineFeedLoader, kotlin.g.a.b<? super IResponse<cc>, ah> paramb)
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
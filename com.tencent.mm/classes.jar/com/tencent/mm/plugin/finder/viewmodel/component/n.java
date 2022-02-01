package com.tencent.mm.plugin.finder.viewmodel.component;

import android.os.SystemClock;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.if;
import com.tencent.mm.loader.g.h;
import com.tencent.mm.plugin.finder.cgi.fetcher.b.b;
import com.tencent.mm.plugin.finder.cgi.fetcher.b.c;
import com.tencent.mm.plugin.finder.feed.model.FinderTimelineFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.DataBuffer;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.bu;
import com.tencent.mm.plugin.finder.report.t;
import com.tencent.mm.plugin.finder.report.t.a;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.logic.c;
import com.tencent.mm.plugin.finder.utils.aj;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.asd;
import com.tencent.mm.protocal.protobuf.bid;
import com.tencent.mm.protocal.protobuf.bku;
import com.tencent.mm.protocal.protobuf.emr;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.ResultKt;
import kotlin.g.a.m;
import kotlin.g.b.aa.f;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;
import kotlinx.coroutines.ak;
import kotlinx.coroutines.al;
import kotlinx.coroutines.bc;
import kotlinx.coroutines.ct;
import kotlinx.coroutines.w;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderEnhanceFeedUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "fragment", "Landroidx/fragment/app/Fragment;", "(Landroidx/fragment/app/Fragment;)V", "adapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "getAdapter", "()Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "adapter$delegate", "Lkotlin/Lazy;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "enhanceCgiStats", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/Stats;", "enhanceFetcher", "Lcom/tencent/mm/plugin/finder/cgi/fetcher/FinderEnhanceStreamFetcher;", "feedLoader", "Lcom/tencent/mm/plugin/finder/feed/model/FinderTimelineFeedLoader;", "getFeedLoader", "()Lcom/tencent/mm/plugin/finder/feed/model/FinderTimelineFeedLoader;", "setFeedLoader", "(Lcom/tencent/mm/plugin/finder/feed/model/FinderTimelineFeedLoader;)V", "layoutManager", "Landroidx/recyclerview/widget/LinearLayoutManager;", "getLayoutManager", "()Landroidx/recyclerview/widget/LinearLayoutManager;", "layoutManager$delegate", "preloadVideoWorker", "Lcom/tencent/mm/plugin/finder/preload/worker/VideoPreloadWorker;", "getPreloadVideoWorker", "()Lcom/tencent/mm/plugin/finder/preload/worker/VideoPreloadWorker;", "preloadVideoWorker$delegate", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "getRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "recyclerView$delegate", "token", "Ljava/util/concurrent/atomic/AtomicInteger;", "unreadVM", "Lcom/tencent/mm/plugin/finder/viewmodel/FinderTabStreamUnreadVM;", "getUnreadVM", "()Lcom/tencent/mm/plugin/finder/viewmodel/FinderTabStreamUnreadVM;", "unreadVM$delegate", "addEnhanceStats", "", "stat", "addEnhanceStatsList", "stats", "", "calValidPosition", "", "requestObj", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "(Lcom/tencent/mm/protocal/protobuf/FinderObject;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getLoaderCurrentFeeds", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getLoaderCurrentUnreadFeeds", "Lcom/tencent/mm/protocal/protobuf/FinderUnreadItem;", "getRecentEnhanceStats", "handleResp", "tabType", "errType", "errCode", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderEnhanceResp;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "pendingReportUnread", "(IIILcom/tencent/mm/protocal/protobuf/FinderEnhanceResp;Lcom/tencent/mm/protocal/protobuf/FinderObject;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;Ljava/util/LinkedList;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertEnhanceObj", "insertList", "index", "onCleared", "onDispatch", "event", "Lcom/tencent/mm/plugin/finder/event/base/Event;", "generateStats", "Lkotlin/Function0;", "Lkotlin/Pair;", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "onEventHappen", "type", "Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderEnhanceFeedUIC$EventType;", "feed", "preloadVideoData", "", "firstObj", "(Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;ILcom/tencent/mm/protocal/protobuf/FinderObject;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "reportUnreadFeed", "pendingList", "(Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "uniqueId", "", "Companion", "Cost", "EventType", "PreloadCallback", "plugin-finder_release"})
public final class n
  extends UIComponent
{
  private static final ConcurrentSkipListSet<Long> BiZ;
  public static final b Bja;
  public final LinkedList<emr> BiT;
  private final AtomicInteger BiU;
  private final com.tencent.mm.plugin.finder.cgi.fetcher.b BiV;
  private final ak BiW;
  private final kotlin.f BiX;
  private final kotlin.f BiY;
  public FinderTimelineFeedLoader xCg;
  private final kotlin.f xoT;
  private final kotlin.f zQC;
  private final kotlin.f zQD;
  
  static
  {
    AppMethodBeat.i(222106);
    Bja = new b((byte)0);
    BiZ = new ConcurrentSkipListSet();
    AppMethodBeat.o(222106);
  }
  
  public n(Fragment paramFragment)
  {
    super(paramFragment);
    AppMethodBeat.i(222103);
    this.BiT = new LinkedList();
    this.BiU = new AtomicInteger();
    this.BiV = new com.tencent.mm.plugin.finder.cgi.fetcher.b();
    this.BiW = al.c(ct.iRW().plus((kotlin.d.f)bc.iRs()));
    this.xoT = kotlin.g.ar((kotlin.g.a.a)o.Bju);
    this.BiX = kotlin.g.ar((kotlin.g.a.a)r.Bjw);
    this.zQD = kotlin.g.ar((kotlin.g.a.a)new p(paramFragment));
    this.BiY = kotlin.g.ar((kotlin.g.a.a)new f(this));
    this.zQC = kotlin.g.ar((kotlin.g.a.a)new l(this));
    BiZ.clear();
    AppMethodBeat.o(222103);
  }
  
  private final String I(FinderObject paramFinderObject)
  {
    AppMethodBeat.i(222035);
    paramFinderObject = com.tencent.mm.ae.d.Fw(paramFinderObject.id) + '#' + paramFinderObject.nickname + '@' + this.BiU.incrementAndGet();
    AppMethodBeat.o(222035);
    return paramFinderObject;
  }
  
  private final com.tencent.mm.plugin.finder.preload.worker.b ekt()
  {
    AppMethodBeat.i(222027);
    com.tencent.mm.plugin.finder.preload.worker.b localb = (com.tencent.mm.plugin.finder.preload.worker.b)this.xoT.getValue();
    AppMethodBeat.o(222027);
    return localb;
  }
  
  private final com.tencent.mm.plugin.finder.viewmodel.f eku()
  {
    AppMethodBeat.i(222029);
    com.tencent.mm.plugin.finder.viewmodel.f localf = (com.tencent.mm.plugin.finder.viewmodel.f)this.BiX.getValue();
    AppMethodBeat.o(222029);
    return localf;
  }
  
  private final List<emr> ekv()
  {
    AppMethodBeat.i(222097);
    synchronized (this.BiT)
    {
      LinkedList localLinkedList = new LinkedList((Collection)this.BiT);
      ??? = (List)localLinkedList;
      AppMethodBeat.o(222097);
      return ???;
    }
  }
  
  private final LinearLayoutManager getLayoutManager()
  {
    AppMethodBeat.i(222030);
    LinearLayoutManager localLinearLayoutManager = (LinearLayoutManager)this.zQC.getValue();
    AppMethodBeat.o(222030);
    return localLinearLayoutManager;
  }
  
  public final void onCleared()
  {
    AppMethodBeat.i(222033);
    super.onCleared();
    al.a(this.BiW, "Finder.EnhanceFeedUIC#destory");
    ekt().dMP();
    AppMethodBeat.o(222033);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareByDescending$1"})
  public static final class a<T>
    implements Comparator<T>
  {
    public final int compare(T paramT1, T paramT2)
    {
      AppMethodBeat.i(287129);
      int i = kotlin.b.a.a((Comparable)Long.valueOf(((emr)paramT2).Upt), (Comparable)Long.valueOf(((emr)paramT1).Upt));
      AppMethodBeat.o(287129);
      return i;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderEnhanceFeedUIC$Companion;", "", "()V", "AT_LEAST_FEED_COUNT", "", "RECENT_FEED_STATS_COUNT", "TAG", "", "enhanceFeedSet", "Ljava/util/concurrent/ConcurrentSkipListSet;", "", "getEnhanceFeedSet", "()Ljava/util/concurrent/ConcurrentSkipListSet;", "plugin-finder_release"})
  public static final class b {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderEnhanceFeedUIC$Cost;", "", "feedId", "", "(J)V", "count", "", "getCount", "()I", "setCount", "(I)V", "value", "errorType", "getErrorType", "setErrorType", "eventEndTime", "getEventEndTime", "()J", "setEventEndTime", "eventStartTime", "getEventStartTime", "setEventStartTime", "getFeedId", "fetchEndTime", "getFetchEndTime", "setFetchEndTime", "fetchStartTime", "getFetchStartTime", "setFetchStartTime", "preloadEndTime", "getPreloadEndTime", "setPreloadEndTime", "preloadStartTime", "getPreloadStartTime", "setPreloadStartTime", "component1", "copy", "equals", "", "other", "hashCode", "publishEvent", "", "action", "toString", "", "plugin-finder_release"})
  public static final class c
  {
    public long Bjb;
    long Bjc;
    long Bjd;
    long Bje;
    long Bjf;
    private long Bjg;
    int count;
    private final long feedId;
    private int fyO;
    
    public c(long paramLong)
    {
      this.feedId = paramLong;
    }
    
    public final void NB(long paramLong)
    {
      AppMethodBeat.i(268347);
      this.Bjg = paramLong;
      RN(6);
      AppMethodBeat.o(268347);
    }
    
    public final void RM(int paramInt)
    {
      AppMethodBeat.i(268348);
      this.fyO = paramInt;
      RN(paramInt);
      AppMethodBeat.o(268348);
    }
    
    public final void RN(int paramInt)
    {
      AppMethodBeat.i(268349);
      Object localObject = com.tencent.mm.plugin.finder.storage.d.AjH;
      if (((Number)com.tencent.mm.plugin.finder.storage.d.dYg().aSr()).intValue() != 1)
      {
        AppMethodBeat.o(268349);
        return;
      }
      localObject = new if();
      ((if)localObject).fFl.action = paramInt;
      ((if)localObject).fFl.feedId = this.feedId;
      ((if)localObject).fFl.fFm = (this.Bjg - this.Bjb);
      ((if)localObject).fFl.fFn = (this.Bjd - this.Bjc);
      ((if)localObject).fFl.fFo = (this.Bjf - this.Bje);
      ((if)localObject).fFl.count = this.count;
      EventCenter.instance.publish((IEvent)localObject);
      AppMethodBeat.o(268349);
    }
    
    public final boolean equals(Object paramObject)
    {
      if (this != paramObject)
      {
        if ((paramObject instanceof c))
        {
          paramObject = (c)paramObject;
          if (this.feedId != paramObject.feedId) {}
        }
      }
      else {
        return true;
      }
      return false;
    }
    
    public final int hashCode()
    {
      long l = this.feedId;
      return (int)(l ^ l >>> 32);
    }
    
    public final String toString()
    {
      AppMethodBeat.i(268350);
      String str = "{allCost=" + (this.Bjg - this.Bjb) + "ms, cgi=" + (this.Bjd - this.Bjc) + "ms, preload=" + (this.Bjf - this.Bje) + "ms}";
      AppMethodBeat.o(268350);
      return str;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderEnhanceFeedUIC$EventType;", "", "(Ljava/lang/String;I)V", "LIKE", "FORWARD", "SWITCH_FEED", "DEFAULT", "plugin-finder_release"})
  public static enum d
  {
    static
    {
      AppMethodBeat.i(229865);
      d locald1 = new d("LIKE", 0);
      Bjh = locald1;
      d locald2 = new d("FORWARD", 1);
      Bji = locald2;
      d locald3 = new d("SWITCH_FEED", 2);
      Bjj = locald3;
      d locald4 = new d("DEFAULT", 3);
      Bjk = locald4;
      Bjl = new d[] { locald1, locald2, locald3, locald4 };
      AppMethodBeat.o(229865);
    }
    
    private d() {}
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "invoke"})
  static final class f
    extends q
    implements kotlin.g.a.a<WxRecyclerAdapter<bu>>
  {
    f(n paramn)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"calValidPosition", "", "requestObj", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "continuation", "Lkotlin/coroutines/Continuation;", ""})
  static final class g
    extends kotlin.d.b.a.d
  {
    Object L$0;
    int label;
    Object oDA;
    int rdc;
    
    g(n paramn, kotlin.d.d paramd)
    {
      super();
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(285249);
      this.result = paramObject;
      this.label |= 0x80000000;
      paramObject = this.Bjm.a(null, this);
      AppMethodBeat.o(285249);
      return paramObject;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"})
  static final class h
    extends kotlin.d.b.a.j
    implements m<ak, kotlin.d.d<? super LinkedList<bu>>, Object>
  {
    int label;
    private ak p$;
    
    h(n paramn, aa.f paramf, kotlin.d.d paramd)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<x> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(277590);
      p.k(paramd, "completion");
      paramd = new h(this.Bjm, this.Bjo, paramd);
      paramd.p$ = ((ak)paramObject);
      AppMethodBeat.o(277590);
      return paramd;
    }
    
    public final Object invoke(Object paramObject1, Object paramObject2)
    {
      AppMethodBeat.i(277591);
      paramObject1 = ((h)create(paramObject1, (kotlin.d.d)paramObject2)).invokeSuspend(x.aazN);
      AppMethodBeat.o(277591);
      return paramObject1;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(277589);
      kotlin.d.a.a locala = kotlin.d.a.a.aaAA;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(277589);
        throw paramObject;
      }
      ResultKt.throwOnFailure(paramObject);
      paramObject = this.Bjm.xCg;
      if (paramObject == null)
      {
        paramObject = (LinkedList)this.Bjo.aaBC;
        AppMethodBeat.o(277589);
        return paramObject;
      }
      paramObject = paramObject.getListOfType(bu.class);
      ((LinkedList)this.Bjo.aaBC).addAll((Collection)paramObject);
      paramObject = (LinkedList)this.Bjo.aaBC;
      AppMethodBeat.o(277589);
      return paramObject;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "Lcom/tencent/mm/protocal/protobuf/FinderUnreadItem;", "kotlin.jvm.PlatformType", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"})
  static final class i
    extends kotlin.d.b.a.j
    implements m<ak, kotlin.d.d<? super List<? extends bku>>, Object>
  {
    int label;
    private ak p$;
    
    i(n paramn, aa.f paramf, int paramInt, kotlin.d.d paramd)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<x> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(268275);
      p.k(paramd, "completion");
      paramd = new i(this.Bjm, this.Bjo, this.xeP, paramd);
      paramd.p$ = ((ak)paramObject);
      AppMethodBeat.o(268275);
      return paramd;
    }
    
    public final Object invoke(Object paramObject1, Object paramObject2)
    {
      AppMethodBeat.i(268276);
      paramObject1 = ((i)create(paramObject1, (kotlin.d.d)paramObject2)).invokeSuspend(x.aazN);
      AppMethodBeat.o(268276);
      return paramObject1;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(268273);
      Object localObject1 = kotlin.d.a.a.aaAA;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(268273);
        throw paramObject;
      }
      ResultKt.throwOnFailure(paramObject);
      paramObject = this.Bjm.xCg;
      if (paramObject == null)
      {
        paramObject = (LinkedList)this.Bjo.aaBC;
        AppMethodBeat.o(268273);
        return paramObject;
      }
      localObject1 = paramObject.getListOfType(BaseFinderFeed.class);
      Object localObject2 = aj.AGc;
      ((List)localObject1).addAll((Collection)aj.a(paramObject.getDataList().getBuffer(), BaseFinderFeed.class));
      paramObject = (LinkedList)this.Bjo.aaBC;
      localObject2 = aj.AGc;
      localObject2 = (Iterable)aj.t((List)localObject1, this.xeP);
      localObject1 = (Collection)new ArrayList(kotlin.a.j.a((Iterable)localObject2, 10));
      localObject2 = ((Iterable)localObject2).iterator();
      Object localObject3;
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = ((BaseFinderFeed)((Iterator)localObject2).next()).feedObject.getFinderObject();
        bku localbku = new bku();
        localbku.xbk = ((FinderObject)localObject3).id;
        localbku.objectNonceId = ((FinderObject)localObject3).objectNonceId;
        localbku.fEH = this.xeP;
        ((Collection)localObject1).add(localbku);
      }
      paramObject.addAll((Collection)localObject1);
      localObject1 = (Iterable)this.Bjo.aaBC;
      paramObject = (Collection)new ArrayList();
      localObject1 = ((Iterable)localObject1).iterator();
      label362:
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = ((Iterator)localObject1).next();
        localObject3 = (bku)localObject2;
        if (!n.f(this.Bjm).as(this.xeP, ((bku)localObject3).xbk)) {}
        for (int i = 1;; i = 0)
        {
          if (i == 0) {
            break label362;
          }
          paramObject.add(localObject2);
          break;
        }
      }
      paramObject = (List)paramObject;
      AppMethodBeat.o(268273);
      return paramObject;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"handleResp", "", "tabType", "", "errType", "errCode", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderEnhanceResp;", "requestObj", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "pendingReportUnread", "Ljava/util/LinkedList;", "continuation", "Lkotlin/coroutines/Continuation;", ""})
  static final class j
    extends kotlin.d.b.a.d
  {
    Object L$0;
    int label;
    Object oDA;
    Object pGq;
    Object pGr;
    Object rdb;
    int rdc;
    int rdd;
    int sPA;
    Object sPl;
    
    j(n paramn, kotlin.d.d paramd)
    {
      super();
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(280339);
      this.result = paramObject;
      this.label |= 0x80000000;
      paramObject = this.Bjm.a(0, 0, 0, null, null, null, null, this);
      AppMethodBeat.o(280339);
      return paramObject;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"})
  static final class k
    extends kotlin.d.b.a.j
    implements m<ak, kotlin.d.d<? super Long>, Object>
  {
    int label;
    private ak p$;
    
    k(n paramn, kotlin.d.d paramd)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<x> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(266002);
      p.k(paramd, "completion");
      paramd = new k(this.Bjm, paramd);
      paramd.p$ = ((ak)paramObject);
      AppMethodBeat.o(266002);
      return paramd;
    }
    
    public final Object invoke(Object paramObject1, Object paramObject2)
    {
      AppMethodBeat.i(266003);
      paramObject1 = ((k)create(paramObject1, (kotlin.d.d)paramObject2)).invokeSuspend(x.aazN);
      AppMethodBeat.o(266003);
      return paramObject1;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(266001);
      kotlin.d.a.a locala = kotlin.d.a.a.aaAA;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(266001);
        throw paramObject;
      }
      ResultKt.throwOnFailure(paramObject);
      paramObject = n.d(this.Bjm);
      int i;
      if (paramObject != null)
      {
        i = paramObject.kK();
        paramObject = n.e(this.Bjm);
        if (paramObject == null) {
          break label120;
        }
        paramObject = paramObject.cK(i);
        if (paramObject == null) {
          break label120;
        }
      }
      label120:
      for (long l = kotlin.d.b.a.b.Xu(paramObject.mf()).longValue();; l = -1L)
      {
        paramObject = kotlin.d.b.a.b.Xu(l);
        AppMethodBeat.o(266001);
        return paramObject;
        i = -1;
        break;
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroidx/recyclerview/widget/LinearLayoutManager;", "invoke"})
  static final class l
    extends q
    implements kotlin.g.a.a<LinearLayoutManager>
  {
    l(n paramn)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"})
  public static final class m
    extends kotlin.d.b.a.j
    implements m<ak, kotlin.d.d<? super x>, Object>
  {
    Object L$0;
    int label;
    Object oDA;
    private ak p$;
    Object pGq;
    Object pGr;
    boolean pdt;
    Object rdb;
    Object sPl;
    Object sPm;
    
    public m(n paramn, emr paramemr, FinderItem paramFinderItem, n.c paramc, int paramInt, bid parambid, kotlin.d.d paramd)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<x> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(285575);
      p.k(paramd, "completion");
      paramd = new m(this.Bjm, this.xpl, this.xLU, this.Bjp, this.xeP, this.$contextObj, paramd);
      paramd.p$ = ((ak)paramObject);
      AppMethodBeat.o(285575);
      return paramd;
    }
    
    public final Object invoke(Object paramObject1, Object paramObject2)
    {
      AppMethodBeat.i(285576);
      paramObject1 = ((m)create(paramObject1, (kotlin.d.d)paramObject2)).invokeSuspend(x.aazN);
      AppMethodBeat.o(285576);
      return paramObject1;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(285572);
      kotlin.d.a.a locala = kotlin.d.a.a.aaAA;
      ak localak;
      Object localObject1;
      Object localObject2;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(285572);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        localak = this.p$;
        paramObject = t.zXK;
        t.a.a(this.xpl, "Finder.EnhanceFeedUIC");
        n.a(this.Bjm, this.xpl);
        paramObject = new aa.f();
        paramObject.aaBC = this.xLU.getFeedObject();
        localObject1 = this.Bjm;
        this.L$0 = localak;
        this.oDA = paramObject;
        this.label = 1;
        localObject1 = ((n)localObject1).e(this);
        if (localObject1 == locala)
        {
          AppMethodBeat.o(285572);
          return locala;
        }
        break;
      case 1: 
        localObject2 = (aa.f)this.oDA;
        localak = (ak)this.L$0;
        ResultKt.throwOnFailure(paramObject);
        localObject1 = paramObject;
        paramObject = localObject2;
      }
      for (;;)
      {
        localObject2 = (List)localObject1;
        localObject1 = this.Bjp;
        ((n.c)localObject1).Bjc = SystemClock.uptimeMillis();
        ((n.c)localObject1).RN(2);
        localObject1 = n.b(this.Bjm);
        int i = this.xeP;
        Object localObject3 = this.$contextObj;
        Object localObject4 = (FinderObject)paramObject.aaBC;
        Object localObject5 = n.c(this.Bjm);
        this.L$0 = localak;
        this.oDA = paramObject;
        this.pGq = localObject2;
        this.label = 2;
        ((com.tencent.mm.plugin.finder.cgi.fetcher.b)localObject1).xeM.clean();
        Object localObject6 = new aa.f();
        ((aa.f)localObject6).aaBC = kotlinx.coroutines.a.i.aFQ(0);
        ((com.tencent.mm.plugin.finder.cgi.fetcher.b)localObject1).xeM.a((h)new b.b((kotlinx.coroutines.a.g)((aa.f)localObject6).aaBC, (kotlin.g.a.b)new b.c(i, (bid)localObject3, (FinderObject)localObject4, (List)localObject5, (List)localObject2, (aa.f)localObject6)));
        localObject1 = ((kotlinx.coroutines.a.g)((aa.f)localObject6).aaBC).q(this);
        if (localObject1 == locala)
        {
          AppMethodBeat.o(285572);
          return locala;
          localObject3 = (List)this.pGq;
          localObject2 = (aa.f)this.oDA;
          localak = (ak)this.L$0;
          ResultKt.throwOnFailure(paramObject);
          localObject1 = paramObject;
          paramObject = localObject3;
        }
        for (;;)
        {
          Object localObject7 = (com.tencent.mm.an.c.a)localObject1;
          localObject1 = this.Bjp;
          ((n.c)localObject1).Bjd = SystemClock.uptimeMillis();
          ((n.c)localObject1).RN(3);
          localObject4 = new aa.f();
          ((aa.f)localObject4).aaBC = new LinkedList();
          localObject1 = new aa.f();
          localObject3 = this.Bjm;
          i = this.xeP;
          int j = ((com.tencent.mm.an.c.a)localObject7).errType;
          int k = ((com.tencent.mm.an.c.a)localObject7).errCode;
          localObject5 = ((com.tencent.mm.an.c.a)localObject7).lBJ;
          p.j(localObject5, "result.resp");
          localObject5 = (asd)localObject5;
          localObject6 = (FinderObject)((aa.f)localObject2).aaBC;
          bid localbid = this.$contextObj;
          LinkedList localLinkedList = (LinkedList)((aa.f)localObject4).aaBC;
          this.L$0 = localak;
          this.oDA = localObject2;
          this.pGq = paramObject;
          this.pGr = localObject7;
          this.rdb = localObject4;
          this.sPl = localObject1;
          this.sPm = localObject1;
          this.label = 3;
          localObject5 = ((n)localObject3).a(i, j, k, (asd)localObject5, (FinderObject)localObject6, localbid, localLinkedList, this);
          if (localObject5 == locala)
          {
            AppMethodBeat.o(285572);
            return locala;
            localObject5 = (aa.f)this.sPm;
            localObject7 = (aa.f)this.sPl;
            localObject4 = (aa.f)this.rdb;
            localObject1 = (com.tencent.mm.an.c.a)this.pGr;
            localObject6 = (List)this.pGq;
            localObject2 = (aa.f)this.oDA;
            localak = (ak)this.L$0;
            ResultKt.throwOnFailure(paramObject);
            localObject3 = paramObject;
            paramObject = localObject6;
            localObject6 = localObject5;
            localObject5 = localObject3;
            localObject3 = localObject7;
          }
          for (;;)
          {
            ((aa.f)localObject6).aaBC = ((List)localObject5);
            if (((List)((aa.f)localObject3).aaBC).isEmpty())
            {
              this.Bjp.NB(SystemClock.uptimeMillis());
              Log.w("Finder.EnhanceFeedUIC", "[onEventHappen] #1 failure! " + this.Bjp + " requestObj=" + n.a(this.Bjm, (FinderObject)((aa.f)localObject2).aaBC));
              this.Bjp.RM(-1);
              localObject5 = this.Bjm;
              localObject6 = this.$contextObj;
              localObject7 = (List)((aa.f)localObject4).aaBC;
              this.L$0 = localak;
              this.oDA = localObject2;
              this.pGq = paramObject;
              this.pGr = localObject1;
              this.rdb = localObject4;
              this.sPl = localObject3;
              this.label = 4;
              if (((n)localObject5).a((bid)localObject6, (List)localObject7, this) == locala)
              {
                AppMethodBeat.o(285572);
                return locala;
                ResultKt.throwOnFailure(paramObject);
              }
              paramObject = x.aazN;
              AppMethodBeat.o(285572);
              return paramObject;
            }
            localObject5 = this.Bjp;
            ((n.c)localObject5).Bje = SystemClock.uptimeMillis();
            ((n.c)localObject5).RN(4);
            localObject5 = this.Bjm;
            localObject6 = this.$contextObj;
            i = this.xeP;
            localObject7 = (FinderObject)kotlin.a.j.lo((List)((aa.f)localObject3).aaBC);
            this.L$0 = localak;
            this.oDA = localObject2;
            this.pGq = paramObject;
            this.pGr = localObject1;
            this.rdb = localObject4;
            this.sPl = localObject3;
            this.label = 5;
            localObject6 = ((n)localObject5).a((bid)localObject6, i, (FinderObject)localObject7, this);
            if (localObject6 == locala)
            {
              AppMethodBeat.o(285572);
              return locala;
              localObject4 = (aa.f)this.sPl;
              localObject3 = (aa.f)this.rdb;
              localObject1 = (com.tencent.mm.an.c.a)this.pGr;
              localObject5 = (List)this.pGq;
              localObject6 = (aa.f)this.oDA;
              localak = (ak)this.L$0;
              ResultKt.throwOnFailure(paramObject);
              localObject2 = paramObject;
              paramObject = localObject5;
              localObject5 = localObject2;
              localObject2 = localObject6;
            }
            for (;;)
            {
              boolean bool = ((Boolean)localObject5).booleanValue();
              localObject5 = this.Bjp;
              ((n.c)localObject5).Bjf = SystemClock.uptimeMillis();
              ((n.c)localObject5).RN(5);
              if (!bool)
              {
                Log.w("Finder.EnhanceFeedUIC", "[onEventHappen] #2 failure! " + this.Bjp + " requestObj=" + n.a(this.Bjm, (FinderObject)((aa.f)localObject2).aaBC));
                this.Bjp.RM(-2);
                localObject5 = this.Bjm;
                localObject6 = this.$contextObj;
                localObject7 = (List)((aa.f)localObject3).aaBC;
                this.L$0 = localak;
                this.oDA = localObject2;
                this.pGq = paramObject;
                this.pGr = localObject1;
                this.rdb = localObject3;
                this.sPl = localObject4;
                this.pdt = bool;
                this.label = 6;
                if (((n)localObject5).a((bid)localObject6, (List)localObject7, this) == locala)
                {
                  AppMethodBeat.o(285572);
                  return locala;
                  ResultKt.throwOnFailure(paramObject);
                }
                paramObject = x.aazN;
                AppMethodBeat.o(285572);
                return paramObject;
              }
              localObject5 = (kotlin.d.f)bc.iRr();
              localObject6 = (m)new kotlin.d.b.a.j((aa.f)localObject2, (aa.f)localObject3)
              {
                Object L$0;
                int label;
                private ak p$;
                int rdc;
                
                public final kotlin.d.d<x> create(Object paramAnonymousObject, kotlin.d.d<?> paramAnonymousd)
                {
                  AppMethodBeat.i(284014);
                  p.k(paramAnonymousd, "completion");
                  paramAnonymousd = new 1(this.Bjq, this.Bjr, this.Bjs, this.Bjt, paramAnonymousd);
                  paramAnonymousd.p$ = ((ak)paramAnonymousObject);
                  AppMethodBeat.o(284014);
                  return paramAnonymousd;
                }
                
                public final Object invoke(Object paramAnonymousObject1, Object paramAnonymousObject2)
                {
                  AppMethodBeat.i(284015);
                  paramAnonymousObject1 = ((1)create(paramAnonymousObject1, (kotlin.d.d)paramAnonymousObject2)).invokeSuspend(x.aazN);
                  AppMethodBeat.o(284015);
                  return paramAnonymousObject1;
                }
                
                public final Object invokeSuspend(Object paramAnonymousObject)
                {
                  AppMethodBeat.i(284013);
                  Object localObject3 = kotlin.d.a.a.aaAA;
                  int i;
                  switch (this.label)
                  {
                  default: 
                    paramAnonymousObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    AppMethodBeat.o(284013);
                    throw paramAnonymousObject;
                  case 0: 
                    ResultKt.throwOnFailure(paramAnonymousObject);
                    paramAnonymousObject = this.p$;
                    localObject1 = this.Bjq.Bjm;
                    localObject2 = (FinderObject)this.Bjr.aaBC;
                    this.L$0 = paramAnonymousObject;
                    this.label = 1;
                    localObject2 = ((n)localObject1).a((FinderObject)localObject2, this);
                    localObject1 = localObject2;
                    if (localObject2 == localObject3)
                    {
                      AppMethodBeat.o(284013);
                      return localObject3;
                    }
                  case 1: 
                    localObject2 = (ak)this.L$0;
                    ResultKt.throwOnFailure(paramAnonymousObject);
                    localObject1 = paramAnonymousObject;
                    paramAnonymousObject = localObject2;
                    i = ((Number)localObject1).intValue();
                    if (i >= 0) {
                      break label317;
                    }
                    this.Bjq.Bjp.NB(SystemClock.uptimeMillis());
                    Log.w("Finder.EnhanceFeedUIC", "[onEventHappen] #3 failure! " + this.Bjq.Bjp + " requestObj=" + n.a(this.Bjq.Bjm, (FinderObject)this.Bjr.aaBC));
                    this.Bjq.Bjp.RM(-3);
                    localObject1 = this.Bjq.Bjm;
                    localObject2 = this.Bjq.$contextObj;
                    List localList = (List)this.Bjs.aaBC;
                    this.L$0 = paramAnonymousObject;
                    this.rdc = i;
                    this.label = 2;
                    if (((n)localObject1).a((bid)localObject2, localList, this) != localObject3) {
                      break label306;
                    }
                    AppMethodBeat.o(284013);
                    return localObject3;
                  }
                  ResultKt.throwOnFailure(paramAnonymousObject);
                  label306:
                  paramAnonymousObject = x.aazN;
                  AppMethodBeat.o(284013);
                  return paramAnonymousObject;
                  label317:
                  paramAnonymousObject = ((Iterable)this.Bjt.aaBC).iterator();
                  while (paramAnonymousObject.hasNext())
                  {
                    localObject1 = (FinderObject)paramAnonymousObject.next();
                    localObject2 = n.Bja;
                    n.ekw().add(kotlin.d.b.a.b.Xu(((FinderObject)localObject1).id));
                  }
                  paramAnonymousObject = c.AnK;
                  Object localObject1 = (Iterable)com.tencent.mm.plugin.finder.storage.logic.c.a.a((List)this.Bjt.aaBC, this.Bjq.xeP, this.Bjq.$contextObj);
                  paramAnonymousObject = (Collection)new ArrayList(kotlin.a.j.a((Iterable)localObject1, 10));
                  localObject1 = ((Iterable)localObject1).iterator();
                  while (((Iterator)localObject1).hasNext())
                  {
                    localObject2 = (FinderItem)((Iterator)localObject1).next();
                    localObject3 = c.AnK;
                    paramAnonymousObject.add(com.tencent.mm.plugin.finder.storage.logic.c.a.a((FinderItem)localObject2));
                  }
                  paramAnonymousObject = (List)paramAnonymousObject;
                  n.a(this.Bjq.Bjm, paramAnonymousObject, i);
                  this.Bjq.Bjp.count = paramAnonymousObject.size();
                  this.Bjq.Bjp.NB(SystemClock.uptimeMillis());
                  paramAnonymousObject = new StringBuilder("[onEventHappen] successfully! ").append(this.Bjq.Bjp).append(" insertPos=").append(i).append(" requestObj=").append(n.a(this.Bjq.Bjm, (FinderObject)this.Bjr.aaBC)).append(' ').append("unreadFeedList=");
                  Object localObject2 = (Iterable)this.Bjt.aaBC;
                  localObject1 = (Collection)new ArrayList(kotlin.a.j.a((Iterable)localObject2, 10));
                  localObject2 = ((Iterable)localObject2).iterator();
                  while (((Iterator)localObject2).hasNext()) {
                    ((Collection)localObject1).add(((FinderObject)((Iterator)localObject2).next()).nickname);
                  }
                  Log.i("Finder.EnhanceFeedUIC", (List)localObject1);
                  paramAnonymousObject = x.aazN;
                  AppMethodBeat.o(284013);
                  return paramAnonymousObject;
                }
              };
              this.L$0 = localak;
              this.oDA = localObject2;
              this.pGq = paramObject;
              this.pGr = localObject1;
              this.rdb = localObject3;
              this.sPl = localObject4;
              this.pdt = bool;
              this.label = 7;
              if (kotlinx.coroutines.i.a((kotlin.d.f)localObject5, (m)localObject6, this) == locala)
              {
                AppMethodBeat.o(285572);
                return locala;
                ResultKt.throwOnFailure(paramObject);
              }
              paramObject = x.aazN;
              AppMethodBeat.o(285572);
              return paramObject;
              localObject5 = localObject3;
              localObject3 = localObject4;
              localObject4 = localObject5;
              localObject5 = localObject6;
            }
            localObject3 = localObject1;
            localObject6 = localObject1;
            localObject1 = localObject7;
          }
          localObject3 = paramObject;
          paramObject = localObject2;
          localObject2 = localObject3;
        }
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"preloadVideoData", "", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "tabType", "", "firstObj", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "continuation", "Lkotlin/coroutines/Continuation;", ""})
  static final class n
    extends kotlin.d.b.a.d
  {
    Object L$0;
    int label;
    Object oDA;
    Object pGq;
    Object pGr;
    Object rdb;
    int rdc;
    Object sPl;
    Object sPm;
    Object sPn;
    
    n(n paramn, kotlin.d.d paramd)
    {
      super();
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(269405);
      this.result = paramObject;
      this.label |= 0x80000000;
      paramObject = this.Bjm.a(null, 0, null, this);
      AppMethodBeat.o(269405);
      return paramObject;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/plugin/finder/preload/worker/VideoPreloadWorker;", "invoke"})
  static final class o
    extends q
    implements kotlin.g.a.a<com.tencent.mm.plugin.finder.preload.worker.b>
  {
    public static final o Bju;
    
    static
    {
      AppMethodBeat.i(286227);
      Bju = new o();
      AppMethodBeat.o(286227);
    }
    
    o()
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroidx/recyclerview/widget/RecyclerView;", "invoke"})
  static final class p
    extends q
    implements kotlin.g.a.a<RecyclerView>
  {
    p(Fragment paramFragment)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"})
  static final class q
    extends kotlin.d.b.a.j
    implements m<ak, kotlin.d.d<? super x>, Object>
  {
    Object L$0;
    int label;
    Object oDA;
    private ak p$;
    
    q(n paramn, List paramList, bid parambid, kotlin.d.d paramd)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<x> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(285940);
      p.k(paramd, "completion");
      paramd = new q(this.Bjm, this.Bjv, this.$contextObj, paramd);
      paramd.p$ = ((ak)paramObject);
      AppMethodBeat.o(285940);
      return paramd;
    }
    
    public final Object invoke(Object paramObject1, Object paramObject2)
    {
      AppMethodBeat.i(285941);
      paramObject1 = ((q)create(paramObject1, (kotlin.d.d)paramObject2)).invokeSuspend(x.aazN);
      AppMethodBeat.o(285941);
      return paramObject1;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(285939);
      Object localObject3 = kotlin.d.a.a.aaAA;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(285939);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        localObject1 = this.p$;
        paramObject = new LinkedList();
        localObject2 = this.Bjm;
        this.L$0 = localObject1;
        this.oDA = paramObject;
        this.label = 1;
        localObject2 = ((n)localObject2).e(this);
        localObject1 = localObject2;
        if (localObject2 == localObject3)
        {
          AppMethodBeat.o(285939);
          return localObject3;
        }
        break;
      case 1: 
        localObject2 = (LinkedList)this.oDA;
        ResultKt.throwOnFailure(paramObject);
        localObject1 = paramObject;
        paramObject = localObject2;
      }
      Object localObject1 = (List)localObject1;
      localObject3 = (Iterable)this.Bjv;
      Object localObject2 = (Collection)new ArrayList();
      localObject3 = ((Iterable)localObject3).iterator();
      int i;
      label298:
      label310:
      label313:
      while (((Iterator)localObject3).hasNext())
      {
        Object localObject4 = ((Iterator)localObject3).next();
        FinderObject localFinderObject = (FinderObject)localObject4;
        Iterator localIterator = ((List)localObject1).iterator();
        i = 0;
        label213:
        int j;
        if (localIterator.hasNext()) {
          if (((bku)localIterator.next()).xbk == localFinderObject.id)
          {
            j = 1;
            label247:
            if (j == 0) {
              break label298;
            }
            label251:
            if ((i >= 0) || (n.f(this.Bjm).as(4, localFinderObject.id))) {
              break label310;
            }
          }
        }
        for (i = 1;; i = 0)
        {
          if (i == 0) {
            break label313;
          }
          ((Collection)localObject2).add(localObject4);
          break;
          j = 0;
          break label247;
          i += 1;
          break label213;
          i = -1;
          break label251;
        }
      }
      localObject1 = ((Iterable)localObject2).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject3 = (FinderObject)((Iterator)localObject1).next();
        localObject2 = new bku();
        ((bku)localObject2).xbk = ((FinderObject)localObject3).id;
        ((bku)localObject2).objectNonceId = ((FinderObject)localObject3).objectNonceId;
        localObject3 = com.tencent.mm.plugin.finder.report.n.zWF;
        ((bku)localObject2).sessionBuffer = com.tencent.mm.plugin.finder.report.n.N(((bku)localObject2).xbk, this.$contextObj.xkX);
        ((bku)localObject2).fEH = 4;
        paramObject.add(localObject2);
      }
      if (!((Collection)paramObject).isEmpty()) {
        i = 1;
      }
      while (i != 0)
      {
        localObject1 = new StringBuilder("[reportUnreadFeed] (").append(this.Bjv.size()).append(" => ").append(paramObject.size()).append(") list=");
        localObject3 = (Iterable)paramObject;
        localObject2 = (Collection)new ArrayList(kotlin.a.j.a((Iterable)localObject3, 10));
        localObject3 = ((Iterable)localObject3).iterator();
        for (;;)
        {
          if (((Iterator)localObject3).hasNext())
          {
            ((Collection)localObject2).add(com.tencent.mm.ae.d.Fw(((bku)((Iterator)localObject3).next()).xbk));
            continue;
            i = 0;
            break;
          }
        }
        Log.i("Finder.EnhanceFeedUIC", (List)localObject2);
        new com.tencent.mm.plugin.finder.cgi.b((List)paramObject, this.$contextObj).bhW();
      }
      paramObject = x.aazN;
      AppMethodBeat.o(285939);
      return paramObject;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/plugin/finder/viewmodel/FinderTabStreamUnreadVM;", "invoke"})
  static final class r
    extends q
    implements kotlin.g.a.a<com.tencent.mm.plugin.finder.viewmodel.f>
  {
    public static final r Bjw;
    
    static
    {
      AppMethodBeat.i(279096);
      Bjw = new r();
      AppMethodBeat.o(279096);
    }
    
    r()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.component.n
 * JD-Core Version:    0.7.0.1
 */
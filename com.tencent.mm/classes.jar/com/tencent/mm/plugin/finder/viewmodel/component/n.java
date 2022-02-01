package com.tencent.mm.plugin.finder.viewmodel.component;

import android.os.SystemClock;
import androidx.compose.a.q.a..ExternalSyntheticBackport0;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.b.a;
import com.tencent.mm.autogen.a.is;
import com.tencent.mm.plugin.finder.cgi.c;
import com.tencent.mm.plugin.finder.cgi.fetcher.b.b;
import com.tencent.mm.plugin.finder.cgi.fetcher.b.c;
import com.tencent.mm.plugin.finder.feed.model.FinderTimelineFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.DataBuffer;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.cc;
import com.tencent.mm.plugin.finder.preload.e;
import com.tencent.mm.plugin.finder.report.af;
import com.tencent.mm.plugin.finder.report.af.a;
import com.tencent.mm.plugin.finder.report.z;
import com.tencent.mm.plugin.finder.storage.FeedData;
import com.tencent.mm.plugin.finder.storage.FeedData.a;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.FinderItem.a;
import com.tencent.mm.plugin.finder.storage.logic.d.a;
import com.tencent.mm.plugin.finder.utils.av;
import com.tencent.mm.plugin.finder.utils.m.a;
import com.tencent.mm.plugin.finder.utils.m.b;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.awp;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.protocal.protobuf.byg;
import com.tencent.mm.protocal.protobuf.dzj;
import com.tencent.mm.protocal.protobuf.fhp;
import com.tencent.mm.protocal.protobuf.fvu;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.component.UIComponent;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ConcurrentSkipListSet;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.a.p;
import kotlin.d.d<-Ljava.lang.Boolean;>;
import kotlin.d.d<-Ljava.lang.Integer;>;
import kotlin.d.f;
import kotlin.g.a.m;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.r;
import kotlinx.coroutines.aq;
import kotlinx.coroutines.bg;
import kotlinx.coroutines.l;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderEnhanceFeedUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "fragment", "Landroidx/fragment/app/Fragment;", "(Landroidx/fragment/app/Fragment;)V", "enhanceCgiStats", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/Stats;", "enhanceFetcher", "Lcom/tencent/mm/plugin/finder/cgi/fetcher/FinderEnhanceStreamFetcher;", "enhanceTargetFeedSet", "Ljava/util/concurrent/ConcurrentSkipListSet;", "", "feedLoader", "Lcom/tencent/mm/plugin/finder/feed/model/FinderTimelineFeedLoader;", "getFeedLoader", "()Lcom/tencent/mm/plugin/finder/feed/model/FinderTimelineFeedLoader;", "setFeedLoader", "(Lcom/tencent/mm/plugin/finder/feed/model/FinderTimelineFeedLoader;)V", "ignoreThisScrollEvent", "", "isRunningTag", "", "lastCenterFeedId", "lastCenterPosition", "", "layoutManager", "Landroidx/recyclerview/widget/LinearLayoutManager;", "getLayoutManager", "()Landroidx/recyclerview/widget/LinearLayoutManager;", "layoutManager$delegate", "Lkotlin/Lazy;", "preloadVideoWorker", "Lcom/tencent/mm/plugin/finder/preload/worker/VideoPreloadWorker;", "getPreloadVideoWorker", "()Lcom/tencent/mm/plugin/finder/preload/worker/VideoPreloadWorker;", "preloadVideoWorker$delegate", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "getRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "recyclerView$delegate", "unreadVM", "Lcom/tencent/mm/plugin/finder/viewmodel/FinderTabStreamUnreadVM;", "getUnreadVM", "()Lcom/tencent/mm/plugin/finder/viewmodel/FinderTabStreamUnreadVM;", "unreadVM$delegate", "addEnhanceStats", "", "stat", "addEnhanceStatsList", "stats", "", "calValidPosition", "requestObj", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "pendingList", "(Lcom/tencent/mm/protocal/protobuf/FinderObject;Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "checkEnable", "type", "Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderEnhanceFeedUIC$EventType;", "feed", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "getLoaderCurrentFeeds", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getLoaderCurrentUnreadFeeds", "Lcom/tencent/mm/protocal/protobuf/FinderUnreadItem;", "getRecentEnhanceStats", "handleResp", "tabType", "errType", "errCode", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderEnhanceResp;", "pendingReportUnread", "insertEnhanceObj", "insertList", "index", "onCleared", "onDispatch", "event", "Lcom/tencent/mm/plugin/finder/event/base/Event;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "generateStats", "Lkotlin/Function0;", "Lkotlin/Pair;", "onEventHappen", "preloadVideoData", "firstObj", "(Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;ILcom/tencent/mm/protocal/protobuf/FinderObject;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "reportUnreadFeed", "(Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "uniqueId", "Companion", "Cost", "EventType", "PreloadCallback", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class n
  extends UIComponent
{
  public static final a GOb;
  private static final ConcurrentSkipListSet<Long> GOi;
  public long AIv;
  private final kotlin.j AMt;
  public FinderTimelineFeedLoader AZs;
  private final kotlin.j Bab;
  private final kotlin.j CNQ;
  private final kotlin.j EKZ;
  public final ConcurrentSkipListSet<Long> GOc;
  public final LinkedList<fhp> GOd;
  private final com.tencent.mm.plugin.finder.cgi.fetcher.b GOe;
  public volatile String GOf;
  public int GOg;
  public boolean GOh;
  
  static
  {
    AppMethodBeat.i(337991);
    GOb = new a((byte)0);
    GOi = new ConcurrentSkipListSet();
    AppMethodBeat.o(337991);
  }
  
  public n(Fragment paramFragment)
  {
    super(paramFragment);
    AppMethodBeat.i(337759);
    this.GOc = new ConcurrentSkipListSet();
    this.GOd = new LinkedList();
    this.GOe = new com.tencent.mm.plugin.finder.cgi.fetcher.b();
    this.AMt = kotlin.k.cm((kotlin.g.a.a)n.GOH);
    this.Bab = kotlin.k.cm((kotlin.g.a.a)q.GOJ);
    this.CNQ = kotlin.k.cm((kotlin.g.a.a)new o(paramFragment));
    this.EKZ = kotlin.k.cm((kotlin.g.a.a)new j(this));
    this.GOf = "";
    GOi.clear();
    this.GOg = -1;
    AppMethodBeat.o(337759);
  }
  
  public static String O(FinderObject paramFinderObject)
  {
    AppMethodBeat.i(337785);
    paramFinderObject = com.tencent.mm.ae.d.hF(paramFinderObject.id) + '#' + paramFinderObject.nickname;
    AppMethodBeat.o(337785);
    return paramFinderObject;
  }
  
  private final Object a(FinderObject paramFinderObject, List<? extends FinderObject> paramList, kotlin.d.d<? super Integer> paramd)
  {
    AppMethodBeat.i(337803);
    if ((paramd instanceof g))
    {
      localObject1 = (g)paramd;
      if ((((g)localObject1).label & 0x80000000) != 0) {
        ((g)localObject1).label += -2147483648;
      }
    }
    kotlin.d.a.a locala;
    for (paramd = (kotlin.d.d<? super Integer>)localObject1;; paramd = new g(this, paramd))
    {
      localObject1 = paramd.result;
      locala = kotlin.d.a.a.aiwj;
      switch (paramd.label)
      {
      default: 
        paramFinderObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(337803);
        throw paramFinderObject;
      }
    }
    ResultKt.throwOnFailure(localObject1);
    int k = 4;
    paramd.L$0 = this;
    paramd.Uf = paramFinderObject;
    paramd.VC = paramList;
    paramd.aai = 4;
    paramd.label = 1;
    Object localObject1 = new LinkedList();
    Object localObject2 = l.a((f)bg.kCh(), (m)new h(this, (LinkedList)localObject1, null), paramd);
    localObject1 = localObject2;
    paramd = this;
    if (localObject2 == locala)
    {
      AppMethodBeat.o(337803);
      return locala;
      k = paramd.aai;
      paramList = (List)paramd.VC;
      paramFinderObject = (FinderObject)paramd.Uf;
      paramd = (n)paramd.L$0;
      ResultKt.throwOnFailure(localObject1);
    }
    localObject1 = (List)localObject1;
    localObject2 = paramd.getLayoutManager();
    int j;
    label276:
    long l1;
    label301:
    long l2;
    if (localObject2 == null)
    {
      j = -1;
      localObject2 = paramd.getLayoutManager();
      if (localObject2 != null) {
        break label445;
      }
      i = -1;
      if (j == -1) {
        break label455;
      }
      l1 = ((cc)((List)localObject1).get(j)).bZA();
      if (i == -1) {
        break label461;
      }
      l2 = ((cc)((List)localObject1).get(i)).bZA();
      label326:
      paramList = paramList.iterator();
      i = 0;
      label336:
      if (!paramList.hasNext()) {
        break label482;
      }
      localObject2 = (FinderObject)paramList.next();
      if ((!paramd.fnu().az(k, ((FinderObject)localObject2).id)) && (((FinderObject)localObject2).id != l2) && (((FinderObject)localObject2).id != l1)) {
        break label467;
      }
      m = 1;
      label398:
      if (m == 0) {
        break label473;
      }
    }
    for (;;)
    {
      if (i < 0) {
        break label488;
      }
      Log.w("Finder.EnhanceFeedUIC", s.X("[calValidPosition] failure!  pendingList contains has read feed. requestObj=", O(paramFinderObject)));
      AppMethodBeat.o(337803);
      return Integer.valueOf(-1);
      j = ((LinearLayoutManager)localObject2).Jw();
      break;
      label445:
      i = ((LinearLayoutManager)localObject2).Ju();
      break label276;
      label455:
      l1 = 0L;
      break label301;
      label461:
      l2 = 0L;
      break label326;
      label467:
      m = 0;
      break label398;
      label473:
      i += 1;
      break label336;
      label482:
      i = -1;
    }
    label488:
    paramList = ((List)localObject1).iterator();
    int i = 0;
    if (paramList.hasNext()) {
      if (((cc)paramList.next()).bZA() == paramFinderObject.id)
      {
        m = 1;
        label533:
        if (m == 0) {
          break label701;
        }
        label538:
        paramList = ((List)localObject1).listIterator(((List)localObject1).size());
        while (paramList.hasPrevious())
        {
          localObject1 = (cc)paramList.previous();
          if (paramd.fnu().az(k, ((cc)localObject1).bZA()))
          {
            k = paramList.nextIndex();
            label600:
            if ((j == -1) || (i == -1)) {
              break label722;
            }
          }
        }
      }
    }
    label701:
    label722:
    for (int m = 1;; m = 0)
    {
      if (m != 0) {
        break label728;
      }
      Log.w("Finder.EnhanceFeedUIC", "[calValidPosition] failure! requestPos=" + i + " lastVisiblePos=" + j + " lastReadPos=" + k + " requestObj=" + O(paramFinderObject) + ' ');
      AppMethodBeat.o(337803);
      return Integer.valueOf(-1);
      m = 0;
      break label533;
      i += 1;
      break;
      i = -1;
      break label538;
      k = -1;
      break label600;
    }
    label728:
    Log.i("Finder.EnhanceFeedUIC", "[calValidPosition] requestPos=" + i + " lastVisiblePos=" + j + " lastReadPos=" + k + " requestObj=" + O(paramFinderObject) + ' ');
    AppMethodBeat.o(337803);
    return Integer.valueOf(k);
  }
  
  private final Object a(bui parambui, int paramInt, FinderObject paramFinderObject, kotlin.d.d<? super Boolean> paramd)
  {
    AppMethodBeat.i(337821);
    Object localObject;
    if ((paramd instanceof m))
    {
      localObject = (m)paramd;
      if ((((m)localObject).label & 0x80000000) != 0) {
        ((m)localObject).label += -2147483648;
      }
    }
    kotlin.d.a.a locala;
    for (paramd = (kotlin.d.d<? super Boolean>)localObject;; paramd = new m(this, paramd))
    {
      localObject = paramd.result;
      locala = kotlin.d.a.a.aiwj;
      switch (paramd.label)
      {
      default: 
        parambui = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(337821);
        throw parambui;
      }
    }
    ResultKt.throwOnFailure(localObject);
    if (paramFinderObject != null)
    {
      localObject = paramFinderObject.objectDesc;
      int i;
      if ((localObject != null) && (((FinderObjectDesc)localObject).mediaType == 4))
      {
        i = 1;
        if (i == 0) {
          break label336;
        }
        localObject = paramFinderObject;
      }
      for (;;)
      {
        if (localObject != null)
        {
          localObject = FinderItem.Companion;
          localObject = FinderItem.a.e(paramFinderObject, paramInt);
          ((FinderItem)localObject).setReplaceLongVideoToNormal(true);
          paramFinderObject = new com.tencent.mm.plugin.finder.model.ah((FinderItem)localObject);
          List localList = p.listOf(new r(paramFinderObject, paramFinderObject.feedObject.getMediaList()));
          paramFinderObject = new d();
          fnt().EXc.add(paramFinderObject);
          com.tencent.mm.plugin.finder.preload.worker.b localb = fnt();
          paramInt = parambui.AJo;
          parambui = FeedData.Companion;
          localb.a(paramInt, FeedData.a.n((FinderItem)localObject), p.J((Collection)localList), 0);
          parambui = paramFinderObject.ADZ;
          paramd.L$0 = this;
          paramd.Uf = paramFinderObject;
          paramd.label = 1;
          localObject = parambui.aA(paramd);
          paramd = (kotlin.d.d<? super Boolean>)localObject;
          parambui = this;
          if (localObject == locala)
          {
            AppMethodBeat.o(337821);
            return locala;
            i = 0;
            break;
            label336:
            localObject = null;
            continue;
            paramFinderObject = (d)paramd.Uf;
            parambui = (n)paramd.L$0;
            ResultKt.throwOnFailure(localObject);
            paramd = (kotlin.d.d<? super Boolean>)localObject;
          }
          paramd = (r)paramd;
          parambui.fnt().EXc.remove(paramFinderObject);
          parambui = paramd.bsC;
          AppMethodBeat.o(337821);
          return parambui;
        }
      }
    }
    parambui = Boolean.FALSE;
    AppMethodBeat.o(337821);
    return parambui;
  }
  
  public static boolean a(c paramc, FinderItem paramFinderItem, fhp paramfhp)
  {
    boolean bool = false;
    AppMethodBeat.i(337842);
    Object localObject1 = paramFinderItem.getPosTriggerConfig();
    switch (e.$EnumSwitchMapping$0[paramc.ordinal()])
    {
    default: 
      AppMethodBeat.o(337842);
      return false;
    case 1: 
      paramc = com.tencent.mm.plugin.finder.storage.d.FAy;
      if (((Number)com.tencent.mm.plugin.finder.storage.d.eYi().bmg()).intValue() > 0)
      {
        AppMethodBeat.o(337842);
        return true;
      }
      AppMethodBeat.o(337842);
      return false;
    case 2: 
      bool = ((m.b)localObject1).Czb;
      AppMethodBeat.o(337842);
      return bool;
    case 3: 
      bool = ((m.b)localObject1).Ggu;
      AppMethodBeat.o(337842);
      return bool;
    }
    Object localObject2;
    int i;
    label217:
    int j;
    if (((m.b)localObject1).Ggv)
    {
      localObject1 = (Iterable)((m.b)localObject1).Ggw;
      paramc = (Collection)new ArrayList();
      localObject1 = ((Iterable)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = ((Iterator)localObject1).next();
        if (((m.a)localObject2).Ggr == 3) {}
        for (i = 1;; i = 0)
        {
          if (i == 0) {
            break label217;
          }
          paramc.add(localObject2);
          break;
        }
      }
      paramc = (List)paramc;
      bool = paramc.isEmpty();
      paramc = ((Iterable)paramc).iterator();
      for (;;)
      {
        if (paramc.hasNext())
        {
          localObject1 = (m.a)paramc.next();
          localObject2 = paramfhp.abIj;
          if (localObject2 == null)
          {
            i = 0;
            localObject2 = paramfhp.abIi;
            if (localObject2 != null) {
              break label410;
            }
            j = 0;
            label289:
            Log.i("Finder.EnhanceFeedUIC", "[checkEnable] requestObj=" + O(paramFinderItem.getFeedObject()) + " maxVidPlay=" + i + '(' + ((m.a)localObject1).Ggs + "), stayTime=" + j + '(' + ((m.a)localObject1).Ggt + ')');
            if ((i < ((m.a)localObject1).Ggs) || (j < ((m.a)localObject1).Ggt)) {
              continue;
            }
            bool = true;
          }
        }
      }
    }
    for (;;)
    {
      AppMethodBeat.o(337842);
      return bool;
      i = ((dzj)localObject2).abeg;
      break;
      label410:
      j = ((fvu)localObject2).QXQ;
      break label289;
    }
  }
  
  private final com.tencent.mm.plugin.finder.preload.worker.b fnt()
  {
    AppMethodBeat.i(337764);
    com.tencent.mm.plugin.finder.preload.worker.b localb = (com.tencent.mm.plugin.finder.preload.worker.b)this.AMt.getValue();
    AppMethodBeat.o(337764);
    return localb;
  }
  
  private final com.tencent.mm.plugin.finder.viewmodel.h fnu()
  {
    AppMethodBeat.i(337773);
    com.tencent.mm.plugin.finder.viewmodel.h localh = (com.tencent.mm.plugin.finder.viewmodel.h)this.Bab.getValue();
    AppMethodBeat.o(337773);
    return localh;
  }
  
  private final List<fhp> fnv()
  {
    AppMethodBeat.i(337827);
    synchronized (this.GOd)
    {
      LinkedList localLinkedList = new LinkedList((Collection)this.GOd);
      ??? = (List)localLinkedList;
      AppMethodBeat.o(337827);
      return ???;
    }
  }
  
  private final LinearLayoutManager getLayoutManager()
  {
    AppMethodBeat.i(337778);
    LinearLayoutManager localLinearLayoutManager = (LinearLayoutManager)this.EKZ.getValue();
    AppMethodBeat.o(337778);
    return localLinearLayoutManager;
  }
  
  public final void onCleared()
  {
    AppMethodBeat.i(337997);
    super.onCleared();
    fnt().eHU();
    AppMethodBeat.o(337997);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderEnhanceFeedUIC$Companion;", "", "()V", "AT_LEAST_FEED_COUNT", "", "RECENT_FEED_STATS_COUNT", "TAG", "", "enhanceReturnFeedSet", "Ljava/util/concurrent/ConcurrentSkipListSet;", "", "getEnhanceReturnFeedSet", "()Ljava/util/concurrent/ConcurrentSkipListSet;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderEnhanceFeedUIC$Cost;", "", "feedId", "", "(J)V", "count", "", "getCount", "()I", "setCount", "(I)V", "value", "errorType", "getErrorType", "setErrorType", "eventEndTime", "getEventEndTime", "()J", "setEventEndTime", "eventStartTime", "getEventStartTime", "setEventStartTime", "getFeedId", "fetchEndTime", "getFetchEndTime", "setFetchEndTime", "fetchStartTime", "getFetchStartTime", "setFetchStartTime", "preloadEndTime", "getPreloadEndTime", "setPreloadEndTime", "preloadStartTime", "getPreloadStartTime", "setPreloadStartTime", "uiStartTime", "getUiStartTime", "setUiStartTime", "component1", "copy", "equals", "", "other", "hashCode", "publishEvent", "", "action", "toString", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
  {
    public long GOj;
    long GOk;
    long GOl;
    long GOm;
    long GOn;
    private long GOo;
    long GOp;
    int count;
    private final long feedId;
    private int hDx;
    
    public b(long paramLong)
    {
      this.feedId = paramLong;
    }
    
    public final void Vd(int paramInt)
    {
      AppMethodBeat.i(337728);
      this.hDx = paramInt;
      Ve(paramInt);
      AppMethodBeat.o(337728);
    }
    
    public final void Ve(int paramInt)
    {
      AppMethodBeat.i(337736);
      Object localObject = com.tencent.mm.plugin.finder.storage.d.FAy;
      if (((Number)com.tencent.mm.plugin.finder.storage.d.eXl().bmg()).intValue() != 1)
      {
        AppMethodBeat.o(337736);
        return;
      }
      localObject = new is();
      ((is)localObject).hKg.action = paramInt;
      ((is)localObject).hKg.feedId = this.feedId;
      ((is)localObject).hKg.hKh = (this.GOo - this.GOj);
      ((is)localObject).hKg.hKi = (this.GOl - this.GOk);
      ((is)localObject).hKg.hKj = (this.GOn - this.GOm);
      ((is)localObject).hKg.count = this.count;
      ((is)localObject).publish();
      AppMethodBeat.o(337736);
    }
    
    public final boolean equals(Object paramObject)
    {
      if (this == paramObject) {}
      do
      {
        return true;
        if (!(paramObject instanceof b)) {
          return false;
        }
        paramObject = (b)paramObject;
      } while (this.feedId == paramObject.feedId);
      return false;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(337753);
      int i = q.a..ExternalSyntheticBackport0.m(this.feedId);
      AppMethodBeat.o(337753);
      return i;
    }
    
    public final void rf(long paramLong)
    {
      AppMethodBeat.i(337719);
      this.GOo = paramLong;
      Ve(6);
      AppMethodBeat.o(337719);
    }
    
    public final String toString()
    {
      AppMethodBeat.i(337746);
      String str = "{allCost=" + (this.GOo - this.GOj) + "ms, cgi=" + (this.GOl - this.GOk) + "ms, preload=" + (this.GOn - this.GOm) + "ms, ui=" + (this.GOo - this.GOp) + "ms}";
      AppMethodBeat.o(337746);
      return str;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderEnhanceFeedUIC$EventType;", "", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "LIKE", "FORWARD", "SWITCH_FEED", "LONG_CLICK_AVATAR", "DEFAULT", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static enum c
  {
    final int value;
    
    static
    {
      AppMethodBeat.i(337765);
      GOq = new c("LIKE", 0, 1);
      GOr = new c("FORWARD", 1, 2);
      GOs = new c("SWITCH_FEED", 2, 3);
      GOt = new c("LONG_CLICK_AVATAR", 3, 4);
      GOu = new c("DEFAULT", 4, 0);
      GOv = new c[] { GOq, GOr, GOs, GOt, GOu };
      AppMethodBeat.o(337765);
    }
    
    private c(int paramInt)
    {
      this.value = paramInt;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderEnhanceFeedUIC$PreloadCallback;", "Lcom/tencent/mm/plugin/finder/preload/IVideoPreloadCallback;", "(Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderEnhanceFeedUIC;)V", "channel", "Lkotlinx/coroutines/channels/Channel;", "Lkotlin/Pair;", "", "", "getChannel", "()Lkotlinx/coroutines/channels/Channel;", "onCancel", "", "mediaId", "task", "Lcom/tencent/mm/plugin/finder/preload/PreloadCDNTask;", "onFailure", "msg", "onFormatChange", "onPending", "progress", "", "targetPercent", "fileFormat", "codingFormat", "onProgress", "receivedSize", "", "onReject", "onSuccessfully", "isAllCompleted", "percent", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class d
    implements e
  {
    final kotlinx.coroutines.a.h<r<Boolean, String>> ADZ;
    
    public d()
    {
      AppMethodBeat.i(337691);
      this.ADZ = kotlinx.coroutines.a.k.a(0, null, 7);
      AppMethodBeat.o(337691);
    }
    
    public final void B(String paramString, int paramInt, long paramLong)
    {
      AppMethodBeat.i(337706);
      s.u(paramString, "mediaId");
      AppMethodBeat.o(337706);
    }
    
    public final void a(String paramString1, int paramInt, String paramString2, String paramString3, com.tencent.mm.plugin.finder.preload.g paramg)
    {
      AppMethodBeat.i(337701);
      s.u(paramString1, "mediaId");
      s.u(paramString2, "fileFormat");
      s.u(paramString3, "codingFormat");
      s.u(paramg, "task");
      AppMethodBeat.o(337701);
    }
    
    public final void a(final String paramString, com.tencent.mm.plugin.finder.preload.g paramg)
    {
      AppMethodBeat.i(337737);
      s.u(paramString, "mediaId");
      s.u(paramg, "task");
      kotlinx.coroutines.j.a(this.GOw.getLifecycleScope(), null, null, (m)new c(this, paramString, null), 3);
      AppMethodBeat.o(337737);
    }
    
    public final void a(final String paramString1, String paramString2, com.tencent.mm.plugin.finder.preload.g paramg)
    {
      AppMethodBeat.i(337720);
      s.u(paramString1, "mediaId");
      s.u(paramString2, "msg");
      s.u(paramg, "task");
      kotlinx.coroutines.j.a(this.GOw.getLifecycleScope(), null, null, (m)new a(this, paramString1, null), 3);
      AppMethodBeat.o(337720);
    }
    
    public final void a(final String paramString, boolean paramBoolean, int paramInt, com.tencent.mm.plugin.finder.preload.g paramg, long paramLong)
    {
      AppMethodBeat.i(337713);
      s.u(paramString, "mediaId");
      s.u(paramg, "task");
      kotlinx.coroutines.j.a(this.GOw.getLifecycleScope(), null, null, (m)new d(this, paramString, null), 3);
      AppMethodBeat.o(337713);
    }
    
    public final void azf(final String paramString)
    {
      AppMethodBeat.i(337729);
      s.u(paramString, "mediaId");
      kotlinx.coroutines.j.a(this.GOw.getLifecycleScope(), null, null, (m)new b(this, paramString, null), 3);
      AppMethodBeat.o(337729);
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends kotlin.d.b.a.k
      implements m<aq, kotlin.d.d<? super kotlin.ah>, Object>
    {
      int label;
      
      a(n.d paramd, String paramString, kotlin.d.d<? super a> paramd1)
      {
        super(paramd1);
      }
      
      public final kotlin.d.d<kotlin.ah> create(Object paramObject, kotlin.d.d<?> paramd)
      {
        AppMethodBeat.i(337416);
        paramObject = (kotlin.d.d)new a(this.GOx, paramString1, paramd);
        AppMethodBeat.o(337416);
        return paramObject;
      }
      
      public final Object invokeSuspend(Object paramObject)
      {
        AppMethodBeat.i(337411);
        kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
        switch (this.label)
        {
        default: 
          paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
          AppMethodBeat.o(337411);
          throw paramObject;
        case 0: 
          ResultKt.throwOnFailure(paramObject);
          paramObject = this.GOx.ADZ;
          r localr = new r(Boolean.FALSE, paramString1);
          kotlin.d.d locald = (kotlin.d.d)this;
          this.label = 1;
          if (paramObject.b(localr, locald) == locala)
          {
            AppMethodBeat.o(337411);
            return locala;
          }
          break;
        case 1: 
          ResultKt.throwOnFailure(paramObject);
        }
        paramObject = kotlin.ah.aiuX;
        AppMethodBeat.o(337411);
        return paramObject;
      }
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
    static final class b
      extends kotlin.d.b.a.k
      implements m<aq, kotlin.d.d<? super kotlin.ah>, Object>
    {
      int label;
      
      b(n.d paramd, String paramString, kotlin.d.d<? super b> paramd1)
      {
        super(paramd1);
      }
      
      public final kotlin.d.d<kotlin.ah> create(Object paramObject, kotlin.d.d<?> paramd)
      {
        AppMethodBeat.i(337429);
        paramObject = (kotlin.d.d)new b(this.GOx, paramString, paramd);
        AppMethodBeat.o(337429);
        return paramObject;
      }
      
      public final Object invokeSuspend(Object paramObject)
      {
        AppMethodBeat.i(337422);
        kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
        switch (this.label)
        {
        default: 
          paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
          AppMethodBeat.o(337422);
          throw paramObject;
        case 0: 
          ResultKt.throwOnFailure(paramObject);
          paramObject = this.GOx.ADZ;
          r localr = new r(Boolean.FALSE, paramString);
          kotlin.d.d locald = (kotlin.d.d)this;
          this.label = 1;
          if (paramObject.b(localr, locald) == locala)
          {
            AppMethodBeat.o(337422);
            return locala;
          }
          break;
        case 1: 
          ResultKt.throwOnFailure(paramObject);
        }
        paramObject = kotlin.ah.aiuX;
        AppMethodBeat.o(337422);
        return paramObject;
      }
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
    static final class c
      extends kotlin.d.b.a.k
      implements m<aq, kotlin.d.d<? super kotlin.ah>, Object>
    {
      int label;
      
      c(n.d paramd, String paramString, kotlin.d.d<? super c> paramd1)
      {
        super(paramd1);
      }
      
      public final kotlin.d.d<kotlin.ah> create(Object paramObject, kotlin.d.d<?> paramd)
      {
        AppMethodBeat.i(337428);
        paramObject = (kotlin.d.d)new c(this.GOx, paramString, paramd);
        AppMethodBeat.o(337428);
        return paramObject;
      }
      
      public final Object invokeSuspend(Object paramObject)
      {
        AppMethodBeat.i(337420);
        kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
        switch (this.label)
        {
        default: 
          paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
          AppMethodBeat.o(337420);
          throw paramObject;
        case 0: 
          ResultKt.throwOnFailure(paramObject);
          paramObject = this.GOx.ADZ;
          r localr = new r(Boolean.FALSE, paramString);
          kotlin.d.d locald = (kotlin.d.d)this;
          this.label = 1;
          if (paramObject.b(localr, locald) == locala)
          {
            AppMethodBeat.o(337420);
            return locala;
          }
          break;
        case 1: 
          ResultKt.throwOnFailure(paramObject);
        }
        paramObject = kotlin.ah.aiuX;
        AppMethodBeat.o(337420);
        return paramObject;
      }
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
    static final class d
      extends kotlin.d.b.a.k
      implements m<aq, kotlin.d.d<? super kotlin.ah>, Object>
    {
      int label;
      
      d(n.d paramd, String paramString, kotlin.d.d<? super d> paramd1)
      {
        super(paramd1);
      }
      
      public final kotlin.d.d<kotlin.ah> create(Object paramObject, kotlin.d.d<?> paramd)
      {
        AppMethodBeat.i(337455);
        paramObject = (kotlin.d.d)new d(this.GOx, paramString, paramd);
        AppMethodBeat.o(337455);
        return paramObject;
      }
      
      public final Object invokeSuspend(Object paramObject)
      {
        AppMethodBeat.i(337448);
        kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
        switch (this.label)
        {
        default: 
          paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
          AppMethodBeat.o(337448);
          throw paramObject;
        case 0: 
          ResultKt.throwOnFailure(paramObject);
          paramObject = this.GOx.ADZ;
          r localr = new r(Boolean.TRUE, paramString);
          kotlin.d.d locald = (kotlin.d.d)this;
          this.label = 1;
          if (paramObject.b(localr, locald) == locala)
          {
            AppMethodBeat.o(337448);
            return locala;
          }
          break;
        case 1: 
          ResultKt.throwOnFailure(paramObject);
        }
        paramObject = kotlin.ah.aiuX;
        AppMethodBeat.o(337448);
        return paramObject;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareByDescending$1"}, k=3, mv={1, 5, 1})
  public static final class f<T>
    implements Comparator
  {
    public final int compare(T paramT1, T paramT2)
    {
      AppMethodBeat.i(337697);
      int i = kotlin.b.a.b((Comparable)Long.valueOf(((fhp)paramT2).abIr), (Comparable)Long.valueOf(((fhp)paramT1).abIr));
      AppMethodBeat.o(337697);
      return i;
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class g
    extends kotlin.d.b.a.d
  {
    Object L$0;
    Object Uf;
    Object VC;
    int aai;
    int label;
    
    g(n paramn, kotlin.d.d<? super g> paramd)
    {
      super();
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(337681);
      this.result = paramObject;
      this.label |= 0x80000000;
      paramObject = n.a(this.GOw, null, null, (kotlin.d.d)this);
      AppMethodBeat.o(337681);
      return paramObject;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class h
    extends kotlin.d.b.a.k
    implements m<aq, kotlin.d.d<? super LinkedList<cc>>, Object>
  {
    int label;
    
    h(n paramn, LinkedList<cc> paramLinkedList, kotlin.d.d<? super h> paramd)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<kotlin.ah> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(337683);
      paramObject = (kotlin.d.d)new h(this.GOw, this.GOy, paramd);
      AppMethodBeat.o(337683);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(337677);
      kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(337677);
        throw paramObject;
      }
      ResultKt.throwOnFailure(paramObject);
      paramObject = this.GOw.AZs;
      if (paramObject == null)
      {
        paramObject = this.GOy;
        AppMethodBeat.o(337677);
        return paramObject;
      }
      paramObject = paramObject.getListOfType(cc.class);
      this.GOy.addAll((Collection)paramObject);
      paramObject = this.GOy;
      AppMethodBeat.o(337677);
      return paramObject;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lcom/tencent/mm/protocal/protobuf/FinderUnreadItem;", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class i
    extends kotlin.d.b.a.k
    implements m<aq, kotlin.d.d<? super List<? extends byg>>, Object>
  {
    int label;
    
    i(n paramn, LinkedList<byg> paramLinkedList, int paramInt, kotlin.d.d<? super i> paramd)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<kotlin.ah> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(337696);
      paramObject = (kotlin.d.d)new i(this.GOw, this.GOy, this.AEa, paramd);
      AppMethodBeat.o(337696);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(337687);
      Object localObject1 = kotlin.d.a.a.aiwj;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(337687);
        throw paramObject;
      }
      ResultKt.throwOnFailure(paramObject);
      paramObject = this.GOw.AZs;
      if (paramObject == null)
      {
        paramObject = this.GOy;
        AppMethodBeat.o(337687);
        return paramObject;
      }
      localObject1 = paramObject.getListOfType(BaseFinderFeed.class);
      Object localObject2 = av.GiL;
      ((List)localObject1).addAll((Collection)av.a(paramObject.getDataList().getBuffer(), BaseFinderFeed.class));
      paramObject = this.GOy;
      localObject2 = av.GiL;
      localObject2 = (Iterable)av.M((List)localObject1, this.AEa);
      int i = this.AEa;
      localObject1 = (Collection)new ArrayList(p.a((Iterable)localObject2, 10));
      localObject2 = ((Iterable)localObject2).iterator();
      Object localObject3;
      byg localbyg;
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = ((BaseFinderFeed)((Iterator)localObject2).next()).feedObject.getFinderObject();
        localbyg = new byg();
        localbyg.hKN = ((FinderObject)localObject3).id;
        localbyg.objectNonceId = ((FinderObject)localObject3).objectNonceId;
        localbyg.hJx = i;
        ((Collection)localObject1).add(localbyg);
      }
      paramObject.addAll((Collection)localObject1);
      localObject2 = (Iterable)this.GOy;
      paramObject = this.GOw;
      int j = this.AEa;
      localObject1 = (Collection)new ArrayList();
      localObject2 = ((Iterable)localObject2).iterator();
      label363:
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = ((Iterator)localObject2).next();
        localbyg = (byg)localObject3;
        if (!n.d(paramObject).az(j, localbyg.hKN)) {}
        for (i = 1;; i = 0)
        {
          if (i == 0) {
            break label363;
          }
          ((Collection)localObject1).add(localObject3);
          break;
        }
      }
      paramObject = (List)localObject1;
      AppMethodBeat.o(337687);
      return paramObject;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroidx/recyclerview/widget/LinearLayoutManager;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class j
    extends u
    implements kotlin.g.a.a<LinearLayoutManager>
  {
    j(n paramn)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  public static final class k
    extends kotlin.d.b.a.k
    implements m<aq, kotlin.d.d<? super kotlin.ah>, Object>
  {
    Object L$0;
    Object Uf;
    Object VC;
    int label;
    
    public k(fhp paramfhp, n paramn, n.b paramb, n.c paramc, int paramInt, bui parambui, FinderObject paramFinderObject, FinderItem paramFinderItem, kotlin.d.d<? super k> paramd)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<kotlin.ah> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(337899);
      paramObject = (kotlin.d.d)new k(this.AMI, this.GOw, this.GOz, this.GOA, this.AEa, this.$contextObj, this.GOB, this.Bmb, paramd);
      AppMethodBeat.o(337899);
      return paramObject;
    }
    
    public final Object invokeSuspend(final Object paramObject)
    {
      AppMethodBeat.i(337889);
      kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
      Object localObject1;
      int i;
      int j;
      Object localObject2;
      Object localObject3;
      Object localObject4;
      Object localObject5;
      Object localObject6;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(337889);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        paramObject = af.FsA;
        af.a.a(this.AMI, "Finder.EnhanceFeedUIC");
        n.a(this.GOw, this.AMI);
        paramObject = this.GOw;
        localObject1 = (kotlin.d.d)this;
        this.label = 1;
        localObject1 = n.a(paramObject, (kotlin.d.d)localObject1);
        paramObject = localObject1;
        if (localObject1 == locala)
        {
          AppMethodBeat.o(337889);
          return locala;
        }
      case 1: 
        ResultKt.throwOnFailure(paramObject);
        paramObject = (List)paramObject;
        localObject1 = this.GOz;
        ((n.b)localObject1).GOk = SystemClock.uptimeMillis();
        ((n.b)localObject1).Ve(2);
        localObject1 = n.a(this.GOw);
        i = this.GOA.value;
        j = this.AEa;
        localObject2 = this.$contextObj;
        localObject3 = this.GOB;
        localObject4 = n.b(this.GOw);
        localObject5 = (kotlin.d.d)this;
        this.label = 2;
        ((com.tencent.mm.plugin.finder.cgi.fetcher.b)localObject1).ADY.clean();
        localObject6 = kotlinx.coroutines.a.k.a(0, null, 7);
        ((com.tencent.mm.plugin.finder.cgi.fetcher.b)localObject1).ADY.a((com.tencent.mm.loader.f.g)new b.b((kotlinx.coroutines.a.h)localObject6, (kotlin.g.a.b)new b.c(j, (bui)localObject2, (FinderObject)localObject3, (List)localObject4, paramObject, i, (kotlinx.coroutines.a.h)localObject6)));
        localObject1 = ((kotlinx.coroutines.a.h)localObject6).aA((kotlin.d.d)localObject5);
        paramObject = localObject1;
        if (localObject1 == locala)
        {
          AppMethodBeat.o(337889);
          return locala;
        }
      case 2: 
        ResultKt.throwOnFailure(paramObject);
        localObject1 = (b.a)paramObject;
        paramObject = this.GOz;
        paramObject.GOl = SystemClock.uptimeMillis();
        paramObject.Ve(3);
        paramObject = new LinkedList();
        localObject2 = this.GOw;
        localObject3 = this.GOA;
        i = this.AEa;
        j = ((b.a)localObject1).errType;
        int k = ((b.a)localObject1).errCode;
        localObject1 = ((b.a)localObject1).ott;
        s.s(localObject1, "result.resp");
        localObject1 = n.a((n)localObject2, (n.c)localObject3, i, j, k, (awp)localObject1, this.GOB, paramObject);
        if (((List)localObject1).isEmpty())
        {
          this.GOz.rf(SystemClock.uptimeMillis());
          Log.w("Finder.EnhanceFeedUIC", "[onEventHappen] #1 failure[最终条数不够]! " + this.GOz + " requestObj=" + n.P(this.GOB));
          this.GOz.Vd(-1);
          localObject1 = this.GOw;
          localObject2 = this.$contextObj;
          paramObject = (List)paramObject;
          localObject3 = (kotlin.d.d)this;
          this.label = 3;
          if (n.a((n)localObject1, (bui)localObject2, paramObject, (kotlin.d.d)localObject3) == locala)
          {
            AppMethodBeat.o(337889);
            return locala;
          }
        }
      case 3: 
        ResultKt.throwOnFailure(paramObject);
        if (this.GOA == n.c.GOt) {
          com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)n.k.1.GOC);
        }
        paramObject = kotlin.ah.aiuX;
        AppMethodBeat.o(337889);
        return paramObject;
        localObject2 = this.GOz;
        ((n.b)localObject2).GOm = SystemClock.uptimeMillis();
        ((n.b)localObject2).Ve(4);
        localObject2 = com.tencent.mm.plugin.finder.storage.logic.d.FND;
        localObject3 = (Iterable)d.a.a((List)localObject1, this.AEa, this.$contextObj);
        localObject2 = (Collection)new ArrayList(p.a((Iterable)localObject3, 10));
        localObject3 = ((Iterable)localObject3).iterator();
        while (((Iterator)localObject3).hasNext())
        {
          localObject4 = (FinderItem)((Iterator)localObject3).next();
          localObject5 = com.tencent.mm.plugin.finder.storage.logic.d.FND;
          ((Collection)localObject2).add(d.a.a((FinderItem)localObject4));
        }
        localObject2 = (List)localObject2;
        localObject3 = this.GOw;
        localObject4 = this.$contextObj;
        i = this.AEa;
        localObject5 = (FinderObject)p.oK((List)localObject1);
        localObject6 = (kotlin.d.d)this;
        this.L$0 = paramObject;
        this.Uf = localObject1;
        this.VC = localObject2;
        this.label = 4;
        localObject3 = n.a((n)localObject3, (bui)localObject4, i, (FinderObject)localObject5, (kotlin.d.d)localObject6);
        if (localObject3 == locala)
        {
          AppMethodBeat.o(337889);
          return locala;
        }
        break;
      case 4: 
        localObject2 = (List)this.VC;
        localObject1 = (List)this.Uf;
        localObject4 = (LinkedList)this.L$0;
        ResultKt.throwOnFailure(paramObject);
        localObject3 = paramObject;
        paramObject = localObject4;
      }
      for (;;)
      {
        boolean bool = ((Boolean)localObject3).booleanValue();
        localObject3 = this.GOz;
        ((n.b)localObject3).GOn = SystemClock.uptimeMillis();
        ((n.b)localObject3).Ve(5);
        if (!bool)
        {
          Log.w("Finder.EnhanceFeedUIC", "[onEventHappen] #2 failure[预加载失败]! " + this.GOz + " requestObj=" + n.P(this.GOB));
          this.GOz.Vd(-2);
          localObject1 = this.GOw;
          localObject2 = this.$contextObj;
          paramObject = (List)paramObject;
          localObject3 = (kotlin.d.d)this;
          this.L$0 = null;
          this.Uf = null;
          this.VC = null;
          this.label = 5;
          if (n.a((n)localObject1, (bui)localObject2, paramObject, (kotlin.d.d)localObject3) == locala)
          {
            AppMethodBeat.o(337889);
            return locala;
            ResultKt.throwOnFailure(paramObject);
          }
          paramObject = kotlin.ah.aiuX;
          AppMethodBeat.o(337889);
          return paramObject;
        }
        localObject4 = (Iterable)localObject2;
        localObject3 = (Collection)new ArrayList(p.a((Iterable)localObject4, 10));
        localObject4 = ((Iterable)localObject4).iterator();
        while (((Iterator)localObject4).hasNext()) {
          ((Collection)localObject3).add(com.tencent.mm.ae.d.hF(((BaseFinderFeed)((Iterator)localObject4).next()).feedObject.field_id));
        }
        Log.i("Finder.EnhanceFeedUIC", s.X("[onEventHappen] pendingInsert=", (List)localObject3));
        localObject3 = (f)bg.kCh();
        paramObject = (m)new kotlin.d.b.a.k(this.GOz, this.GOw)
        {
          int label;
          
          public final kotlin.d.d<kotlin.ah> create(Object paramAnonymousObject, kotlin.d.d<?> paramAnonymousd)
          {
            AppMethodBeat.i(338210);
            paramAnonymousObject = (kotlin.d.d)new 2(this.GOz, this.GOw, this.GOB, this.GOD, this.$contextObj, paramObject, this.GOA, this.GOF, this.Bmb, paramAnonymousd);
            AppMethodBeat.o(338210);
            return paramAnonymousObject;
          }
          
          public final Object invokeSuspend(Object paramAnonymousObject)
          {
            AppMethodBeat.i(338198);
            kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
            Object localObject1;
            Object localObject2;
            kotlin.d.d locald;
            final int i;
            switch (this.label)
            {
            default: 
              paramAnonymousObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
              AppMethodBeat.o(338198);
              throw paramAnonymousObject;
            case 0: 
              ResultKt.throwOnFailure(paramAnonymousObject);
              this.GOz.GOp = SystemClock.uptimeMillis();
              paramAnonymousObject = this.GOw;
              localObject1 = this.GOB;
              localObject2 = this.GOD;
              locald = (kotlin.d.d)this;
              this.label = 1;
              localObject1 = n.a(paramAnonymousObject, (FinderObject)localObject1, (List)localObject2, locald);
              paramAnonymousObject = localObject1;
              if (localObject1 == locala)
              {
                AppMethodBeat.o(338198);
                return locala;
              }
            case 1: 
              ResultKt.throwOnFailure(paramAnonymousObject);
              i = ((Number)paramAnonymousObject).intValue();
              if (i < 0)
              {
                this.GOz.rf(SystemClock.uptimeMillis());
                Log.w("Finder.EnhanceFeedUIC", "[onEventHappen] #3 failure[位置不合适插入]! insertPos=" + i + ' ' + this.GOz + " requestObj=" + n.P(this.GOB));
                this.GOz.Vd(-3);
                paramAnonymousObject = this.GOw;
                localObject1 = this.$contextObj;
                localObject2 = (List)paramObject;
                locald = (kotlin.d.d)this;
                this.label = 2;
                if (n.a(paramAnonymousObject, (bui)localObject1, (List)localObject2, locald) == locala)
                {
                  AppMethodBeat.o(338198);
                  return locala;
                }
              }
            case 2: 
              ResultKt.throwOnFailure(paramAnonymousObject);
              paramAnonymousObject = kotlin.ah.aiuX;
              AppMethodBeat.o(338198);
              return paramAnonymousObject;
              n.a(this.GOw, this.GOA, this.GOF, i);
              n.c(this.GOw).add(kotlin.d.b.a.b.BF(this.Bmb.field_id));
              this.GOz.count = this.GOF.size();
              this.GOz.rf(SystemClock.uptimeMillis());
              paramAnonymousObject = (f)bg.kCi();
              localObject1 = (m)new kotlin.d.b.a.k(this.GOD, i)
              {
                int label;
                
                public final kotlin.d.d<kotlin.ah> create(Object paramAnonymous2Object, kotlin.d.d<?> paramAnonymous2d)
                {
                  AppMethodBeat.i(338721);
                  paramAnonymous2Object = (kotlin.d.d)new 1(this.GOD, i, this.GOz, this.GOw, this.GOB, paramAnonymous2d);
                  AppMethodBeat.o(338721);
                  return paramAnonymous2Object;
                }
                
                public final Object invokeSuspend(Object paramAnonymous2Object)
                {
                  AppMethodBeat.i(338713);
                  Object localObject1 = kotlin.d.a.a.aiwj;
                  switch (this.label)
                  {
                  default: 
                    paramAnonymous2Object = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    AppMethodBeat.o(338713);
                    throw paramAnonymous2Object;
                  }
                  ResultKt.throwOnFailure(paramAnonymous2Object);
                  paramAnonymous2Object = ((Iterable)this.GOD).iterator();
                  while (paramAnonymous2Object.hasNext())
                  {
                    localObject1 = (FinderObject)paramAnonymous2Object.next();
                    localObject2 = n.GOb;
                    n.fnw().add(kotlin.d.b.a.b.BF(((FinderObject)localObject1).id));
                  }
                  paramAnonymous2Object = new StringBuilder("[onEventHappen] successfully insert of ").append(i).append("! ").append(this.GOz).append(" requestObj=").append(n.P(this.GOB)).append(" insert=");
                  Object localObject2 = (Iterable)this.GOD;
                  localObject1 = (Collection)new ArrayList(p.a((Iterable)localObject2, 10));
                  localObject2 = ((Iterable)localObject2).iterator();
                  while (((Iterator)localObject2).hasNext()) {
                    ((Collection)localObject1).add(n.P((FinderObject)((Iterator)localObject2).next()));
                  }
                  Log.i("Finder.EnhanceFeedUIC", (List)localObject1);
                  paramAnonymous2Object = kotlin.ah.aiuX;
                  AppMethodBeat.o(338713);
                  return paramAnonymous2Object;
                }
              };
              localObject2 = (kotlin.d.d)this;
              this.label = 3;
              if (l.a(paramAnonymousObject, (m)localObject1, (kotlin.d.d)localObject2) != locala) {
                break label412;
              }
              AppMethodBeat.o(338198);
              return locala;
            }
            ResultKt.throwOnFailure(paramAnonymousObject);
            label412:
            paramAnonymousObject = kotlin.ah.aiuX;
            AppMethodBeat.o(338198);
            return paramAnonymousObject;
          }
        };
        localObject1 = (kotlin.d.d)this;
        this.L$0 = null;
        this.Uf = null;
        this.VC = null;
        this.label = 6;
        if (l.a((f)localObject3, paramObject, (kotlin.d.d)localObject1) == locala)
        {
          AppMethodBeat.o(337889);
          return locala;
          ResultKt.throwOnFailure(paramObject);
        }
        paramObject = kotlin.ah.aiuX;
        AppMethodBeat.o(337889);
        return paramObject;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", ""}, k=3, mv={1, 5, 1}, xi=48)
  public static final class l
    extends u
    implements kotlin.g.a.b<Throwable, kotlin.ah>
  {
    public l(n paramn)
    {
      super();
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class m
    extends kotlin.d.b.a.d
  {
    Object L$0;
    Object Uf;
    int label;
    
    m(n paramn, kotlin.d.d<? super m> paramd)
    {
      super();
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(337811);
      this.result = paramObject;
      this.label |= 0x80000000;
      paramObject = n.a(this.GOw, null, 0, null, (kotlin.d.d)this);
      AppMethodBeat.o(337811);
      return paramObject;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/finder/preload/worker/VideoPreloadWorker;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class n
    extends u
    implements kotlin.g.a.a<com.tencent.mm.plugin.finder.preload.worker.b>
  {
    public static final n GOH;
    
    static
    {
      AppMethodBeat.i(337762);
      GOH = new n();
      AppMethodBeat.o(337762);
    }
    
    n()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroidx/recyclerview/widget/RecyclerView;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class o
    extends u
    implements kotlin.g.a.a<RecyclerView>
  {
    o(Fragment paramFragment)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class p
    extends kotlin.d.b.a.k
    implements m<aq, kotlin.d.d<? super kotlin.ah>, Object>
  {
    Object L$0;
    int label;
    
    p(n paramn, List<? extends FinderObject> paramList, bui parambui, kotlin.d.d<? super p> paramd)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<kotlin.ah> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(337812);
      paramObject = (kotlin.d.d)new p(this.GOw, this.GOI, this.$contextObj, paramd);
      AppMethodBeat.o(337812);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(337804);
      Object localObject3 = kotlin.d.a.a.aiwj;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(337804);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        paramObject = new LinkedList();
        localObject1 = this.GOw;
        localObject2 = (kotlin.d.d)this;
        this.L$0 = paramObject;
        this.label = 1;
        localObject2 = n.a((n)localObject1, (kotlin.d.d)localObject2);
        localObject1 = localObject2;
        if (localObject2 == localObject3)
        {
          AppMethodBeat.o(337804);
          return localObject3;
        }
        break;
      case 1: 
        localObject2 = (LinkedList)this.L$0;
        ResultKt.throwOnFailure(paramObject);
        localObject1 = paramObject;
        paramObject = localObject2;
      }
      Object localObject1 = (List)localObject1;
      Object localObject4 = (Iterable)this.GOI;
      Object localObject2 = this.GOw;
      localObject3 = (Collection)new ArrayList();
      localObject4 = ((Iterable)localObject4).iterator();
      label297:
      label309:
      label312:
      while (((Iterator)localObject4).hasNext())
      {
        Object localObject5 = ((Iterator)localObject4).next();
        FinderObject localFinderObject = (FinderObject)localObject5;
        Iterator localIterator = ((List)localObject1).iterator();
        i = 0;
        label214:
        int j;
        if (localIterator.hasNext()) {
          if (((byg)localIterator.next()).hKN == localFinderObject.id)
          {
            j = 1;
            label248:
            if (j == 0) {
              break label297;
            }
            label252:
            if ((i >= 0) || (n.d((n)localObject2).az(4, localFinderObject.id))) {
              break label309;
            }
          }
        }
        for (i = 1;; i = 0)
        {
          if (i == 0) {
            break label312;
          }
          ((Collection)localObject3).add(localObject5);
          break;
          j = 0;
          break label248;
          i += 1;
          break label214;
          i = -1;
          break label252;
        }
      }
      localObject2 = (Iterable)localObject3;
      localObject1 = this.$contextObj;
      localObject2 = ((Iterable)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject4 = (FinderObject)((Iterator)localObject2).next();
        localObject3 = new byg();
        ((byg)localObject3).hKN = ((FinderObject)localObject4).id;
        ((byg)localObject3).objectNonceId = ((FinderObject)localObject4).objectNonceId;
        localObject4 = z.FrZ;
        ((byg)localObject3).sessionBuffer = z.p(((byg)localObject3).hKN, ((bui)localObject1).AJo);
        ((byg)localObject3).hJx = 4;
        paramObject.add(localObject3);
      }
      localObject1 = new StringBuilder("[reportUnreadFeed] (").append(this.GOI.size()).append(" => ").append(paramObject.size()).append(") list=");
      localObject3 = (Iterable)paramObject;
      localObject2 = (Collection)new ArrayList(p.a((Iterable)localObject3, 10));
      localObject3 = ((Iterable)localObject3).iterator();
      while (((Iterator)localObject3).hasNext()) {
        ((Collection)localObject2).add(com.tencent.mm.ae.d.hF(((byg)((Iterator)localObject3).next()).hKN));
      }
      Log.i("Finder.EnhanceFeedUIC", (List)localObject2);
      if (!((Collection)paramObject).isEmpty()) {}
      for (int i = 1;; i = 0)
      {
        if (i != 0) {
          new c((List)paramObject, this.$contextObj).bFJ();
        }
        paramObject = kotlin.ah.aiuX;
        AppMethodBeat.o(337804);
        return paramObject;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/finder/viewmodel/FinderTabStreamUnreadVM;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class q
    extends u
    implements kotlin.g.a.a<com.tencent.mm.plugin.finder.viewmodel.h>
  {
    public static final q GOJ;
    
    static
    {
      AppMethodBeat.i(337749);
      GOJ = new q();
      AppMethodBeat.o(337749);
    }
    
    q()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.component.n
 * JD-Core Version:    0.7.0.1
 */
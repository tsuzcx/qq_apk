package com.tencent.mm.plugin.finder.feed.model;

import android.app.Activity;
import android.os.Message;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.event.base.h;
import com.tencent.mm.plugin.finder.feed.al;
import com.tencent.mm.plugin.finder.feed.model.internal.DataBuffer;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.bu;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.protocal.protobuf.bbh;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandler.Callback;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.Vector;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.g.a.m;
import kotlin.g.b.aa.f;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.k.e;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/model/FinderLiveNoticePreLoader;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycleKeeper;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycle;", "Lcom/tencent/mm/plugin/finder/event/base/EventObserver;", "activity", "Landroid/app/Activity;", "(Landroid/app/Activity;)V", "fragment", "Landroidx/fragment/app/Fragment;", "(Landroidx/fragment/app/Fragment;)V", "NOTIFY_BY_CLICK", "", "NOTIFY_SIGNAL", "PRELOAD_LIMIT", "REQUEASR_SIGNAL", "TAG", "", "TAG$1", "getData", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "firstItemPos", "lastItemPos", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "handler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "getHandler", "()Lcom/tencent/mm/sdk/platformtools/MMHandler;", "handler$delegate", "Lkotlin/Lazy;", "lifeCycleKeeperStore", "Ljava/util/concurrent/CopyOnWriteArraySet;", "loadedList", "Ljava/util/Vector;", "", "loadingList", "preLoaderMap", "Ljava/util/HashMap;", "Lcom/tencent/mm/plugin/finder/feed/model/IFinderBatchSyncLoader;", "Lkotlin/collections/HashMap;", "singleFeedReporter", "Lcom/tencent/mm/plugin/finder/feed/FinderSingleFeedReportHandler;", "clearCache", "", "id", "type", "dispatchAttach", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "dispatchDetach", "getCacheInfo", "Lcom/tencent/mm/plugin/finder/feed/model/IFinderCache;", "getOrRequestNoticeInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLiveNoticeInfo;", "userName", "keep", "target", "notify", "noticeInfos", "Lkotlin/Pair;", "notifyWithCache", "onAttach", "onDetach", "onEventHappen", "ev", "Lcom/tencent/mm/plugin/finder/event/base/Event;", "preLoadFinderLiveNoticeInfo", "ids", "publishEvent", "nameList", "", "requestLoad", "feedId", "nonceId", "(Ljava/lang/Long;Ljava/lang/String;I)V", "requestSignNoticeInfo", "(Ljava/lang/Long;Ljava/lang/String;)V", "setUxInfo", "uxInfo", "Companion", "plugin-finder_release"})
public final class k
  extends com.tencent.mm.plugin.finder.event.base.d
  implements com.tencent.mm.vending.e.b<com.tencent.mm.vending.e.a>
{
  public static final a xIe;
  private Activity activity;
  private Fragment fragment;
  private final String jGx;
  private final kotlin.f ocu;
  private final int xFX;
  public final int xFY;
  private Vector<Long> xGp;
  private final int xHY;
  private m<? super Integer, ? super Integer, ? extends LinkedList<bu>> xHZ;
  private final Vector<Long> xIa;
  private al xIb;
  private final HashMap<Integer, n<Long>> xIc;
  private final int xId;
  private final CopyOnWriteArraySet<com.tencent.mm.vending.e.a> xvE;
  
  static
  {
    AppMethodBeat.i(265734);
    xIe = new a((byte)0);
    AppMethodBeat.o(265734);
  }
  
  public k(Activity paramActivity)
  {
    AppMethodBeat.i(265732);
    this.jGx = "FinderLiveNoticePreLoader";
    this.xHY = 5;
    this.xvE = new CopyOnWriteArraySet();
    this.xGp = new Vector();
    this.xIa = new Vector();
    this.xIc = new HashMap();
    this.xId = 1;
    this.xFX = 2;
    this.xFY = 3;
    this.ocu = kotlin.g.ar((kotlin.g.a.a)new b(this));
    this.activity = paramActivity;
    com.tencent.mm.plugin.finder.storage.d locald = com.tencent.mm.plugin.finder.storage.d.AjH;
    if (((Number)com.tencent.mm.plugin.finder.storage.d.dXq().aSr()).intValue() == 2) {
      ((Map)this.xIc).put(Integer.valueOf(1), new f(paramActivity));
    }
    ((Map)this.xIc).put(Integer.valueOf(2), new f(paramActivity));
    if (!(paramActivity instanceof MMActivity)) {
      paramActivity = null;
    }
    for (;;)
    {
      paramActivity = (MMActivity)paramActivity;
      if (paramActivity != null)
      {
        this.xIb = new al(paramActivity);
        AppMethodBeat.o(265732);
        return;
      }
      AppMethodBeat.o(265732);
      return;
    }
  }
  
  public k(Fragment paramFragment)
  {
    AppMethodBeat.i(265733);
    this.jGx = "FinderLiveNoticePreLoader";
    this.xHY = 5;
    this.xvE = new CopyOnWriteArraySet();
    this.xGp = new Vector();
    this.xIa = new Vector();
    this.xIc = new HashMap();
    this.xId = 1;
    this.xFX = 2;
    this.xFY = 3;
    this.ocu = kotlin.g.ar((kotlin.g.a.a)new b(this));
    this.fragment = paramFragment;
    Object localObject = com.tencent.mm.plugin.finder.storage.d.AjH;
    if (((Number)com.tencent.mm.plugin.finder.storage.d.dXq().aSr()).intValue() == 2) {
      ((Map)this.xIc).put(Integer.valueOf(1), new f(paramFragment));
    }
    ((Map)this.xIc).put(Integer.valueOf(2), new f(paramFragment));
    localObject = paramFragment.getActivity();
    paramFragment = (Fragment)localObject;
    if (!(localObject instanceof MMActivity)) {
      paramFragment = null;
    }
    paramFragment = (MMActivity)paramFragment;
    if (paramFragment != null)
    {
      this.xIb = new al(paramFragment);
      AppMethodBeat.o(265733);
      return;
    }
    AppMethodBeat.o(265733);
  }
  
  public static bbh aBH(String paramString)
  {
    AppMethodBeat.i(265721);
    p.k(paramString, "userName");
    j localj = j.xGH;
    paramString = j.aBF(paramString);
    AppMethodBeat.o(265721);
    return paramString;
  }
  
  private final void af(final LinkedList<kotlin.o<Long, String>> paramLinkedList)
  {
    Object localObject3;
    int i;
    for (;;)
    {
      try
      {
        AppMethodBeat.i(265725);
        Log.i(this.jGx, "request id size = " + paramLinkedList.size());
        localObject1 = (Iterable)paramLinkedList;
        paramLinkedList = (Collection)new ArrayList();
        localObject1 = ((Iterable)localObject1).iterator();
        if (!((Iterator)localObject1).hasNext()) {
          break;
        }
        localObject2 = ((Iterator)localObject1).next();
        localObject3 = (kotlin.o)localObject2;
        if (!this.xIa.contains(((kotlin.o)localObject3).Mx))
        {
          i = 1;
          if (i != 0) {
            paramLinkedList.add(localObject2);
          }
        }
        else
        {
          i = 0;
        }
      }
      finally {}
    }
    Object localObject1 = new LinkedList((Collection)paramLinkedList);
    Log.i(this.jGx, "idsToFillLoading id size = " + ((LinkedList)localObject1).size());
    paramLinkedList = new aa.f();
    Object localObject2 = (Iterable)localObject1;
    localObject1 = (Collection)new ArrayList();
    localObject2 = ((Iterable)localObject2).iterator();
    kotlin.o localo;
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = ((Iterator)localObject2).next();
      localo = (kotlin.o)localObject3;
      if (this.xGp.contains(localo.Mx)) {
        break label690;
      }
      i = 1;
      label244:
      if (i == 0) {
        break label693;
      }
      ((Collection)localObject1).add(localObject3);
    }
    paramLinkedList.aaBC = new LinkedList((Collection)localObject1);
    Log.i(this.jGx, "real request id size = " + ((LinkedList)paramLinkedList.aaBC).size());
    if (!((Collection)paramLinkedList.aaBC).isEmpty())
    {
      i = 1;
      label331:
      if (i != 0)
      {
        localObject1 = this.xGp;
        localObject3 = (Iterable)paramLinkedList.aaBC;
        localObject2 = (Collection)new ArrayList(kotlin.a.j.a((Iterable)localObject3, 10));
        localObject3 = ((Iterable)localObject3).iterator();
        while (((Iterator)localObject3).hasNext()) {
          ((Collection)localObject2).add(Long.valueOf(((Number)((kotlin.o)((Iterator)localObject3).next()).Mx).longValue()));
        }
        ((Vector)localObject1).addAll((Collection)localObject2);
        localObject2 = (Iterable)paramLinkedList.aaBC;
        localObject1 = (Collection)new ArrayList();
        localObject2 = ((Iterable)localObject2).iterator();
      }
    }
    label652:
    label690:
    label693:
    label709:
    label714:
    label717:
    for (;;)
    {
      label468:
      if (((Iterator)localObject2).hasNext())
      {
        localObject3 = ((Iterator)localObject2).next();
        localo = (kotlin.o)localObject3;
        if (((Number)localo.Mx).longValue() == 0L) {
          break label714;
        }
        if (((CharSequence)localo.My).length() <= 0) {
          break label709;
        }
        i = 1;
      }
      for (;;)
      {
        if (i == 0) {
          break label717;
        }
        ((Collection)localObject1).add(localObject3);
        break label468;
        paramLinkedList.aaBC = new LinkedList((Collection)localObject1);
        if (!((Collection)paramLinkedList.aaBC).isEmpty())
        {
          i = 1;
          if (i == 0) {
            break label652;
          }
          new com.tencent.mm.plugin.finder.cgi.g((List)paramLinkedList.aaBC, 0, 0, null, null, 62).bhW().h((com.tencent.mm.vending.c.a)new d(this, paramLinkedList)).a((com.tencent.mm.vending.e.b)this);
          AppMethodBeat.o(265725);
        }
        for (;;)
        {
          return;
          i = 0;
          break;
          Log.i(this.jGx, "idsToRequest is empty #1");
          AppMethodBeat.o(265725);
          continue;
          Log.i(this.jGx, "idsToRequest is empty #2");
          AppMethodBeat.o(265725);
        }
        i = 0;
        break label244;
        break;
        i = 0;
        break label331;
        for (;;)
        {
          if (i == 0) {
            break label714;
          }
          i = 1;
          break;
          i = 0;
        }
        i = 0;
      }
    }
  }
  
  private final void b(m<? super Integer, ? super Integer, ? extends LinkedList<bu>> paramm, RecyclerView paramRecyclerView)
  {
    AppMethodBeat.i(265718);
    Iterator localIterator = ((Map)this.xIc).entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      ((n)localEntry.getValue()).a(paramm, paramRecyclerView, ((Number)localEntry.getKey()).intValue());
    }
    AppMethodBeat.o(265718);
  }
  
  private final void duu()
  {
    AppMethodBeat.i(265720);
    Iterator localIterator = ((Map)this.xIc).entrySet().iterator();
    while (localIterator.hasNext()) {
      ((n)((Map.Entry)localIterator.next()).getValue()).onDetach();
    }
    AppMethodBeat.o(265720);
  }
  
  public final o I(long paramLong, int paramInt)
  {
    AppMethodBeat.i(265722);
    if (this.xIc.containsKey(Integer.valueOf(paramInt)))
    {
      Object localObject = (n)this.xIc.get(Integer.valueOf(paramInt));
      if (localObject != null)
      {
        localObject = ((n)localObject).t(Long.valueOf(paramLong), paramInt);
        AppMethodBeat.o(265722);
        return localObject;
      }
      AppMethodBeat.o(265722);
      return null;
    }
    AppMethodBeat.o(265722);
    return null;
  }
  
  public final void J(long paramLong, int paramInt)
  {
    AppMethodBeat.i(265723);
    Log.i(this.jGx, "clearCache: id:" + paramLong + " type:" + paramInt);
    n localn = (n)this.xIc.get(Integer.valueOf(paramInt));
    if (localn != null)
    {
      localn.s(Long.valueOf(paramLong), paramInt);
      AppMethodBeat.o(265723);
      return;
    }
    AppMethodBeat.o(265723);
  }
  
  public final void a(final com.tencent.mm.plugin.finder.event.base.b paramb)
  {
    AppMethodBeat.i(265729);
    p.k(paramb, "ev");
    Log.i(this.jGx, "onEventHappen ev: ".concat(String.valueOf(paramb)));
    if (((paramb instanceof h)) && (((h)paramb).type != 9))
    {
      final int i = ((h)paramb).xrh;
      final int j = i + this.xHY;
      Log.i(this.jGx, "onEventHappen :" + paramb + " firstItemPos:" + i + " lastItemPos:" + j);
      if (i > j)
      {
        AppMethodBeat.o(265729);
        return;
      }
      com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new c(this, i, j, paramb));
    }
    n localn = (n)this.xIc.get(Integer.valueOf(1));
    if (localn != null)
    {
      localn.a(paramb);
      AppMethodBeat.o(265729);
      return;
    }
    AppMethodBeat.o(265729);
  }
  
  public final void a(Long paramLong, String paramString)
  {
    AppMethodBeat.i(265730);
    if ((paramLong != null) && (paramString != null))
    {
      paramLong = new LinkedList((Collection)kotlin.a.j.listOf(new kotlin.o(Long.valueOf(((Number)paramLong).longValue()), paramString)));
      btS().sendMessage(btS().obtainMessage(this.xId, paramLong));
    }
    AppMethodBeat.o(265730);
  }
  
  public final void a(m<? super Integer, ? super Integer, ? extends LinkedList<bu>> paramm, RecyclerView paramRecyclerView)
  {
    AppMethodBeat.i(265716);
    Log.i(this.jGx, "onAttach");
    this.xHZ = paramm;
    b(paramm, paramRecyclerView);
    paramm = this.xIb;
    if (paramm != null)
    {
      paramm.m(paramRecyclerView);
      AppMethodBeat.o(265716);
      return;
    }
    AppMethodBeat.o(265716);
  }
  
  public final void b(Long paramLong, String paramString)
  {
    AppMethodBeat.i(265731);
    Log.i(this.jGx, "requestLoad feedId :" + paramLong + " nonceId :" + paramString + " type:1");
    if ((paramLong != null) && (paramString != null))
    {
      long l = ((Number)paramLong).longValue();
      paramLong = (n)this.xIc.get(Integer.valueOf(1));
      if (paramLong != null)
      {
        paramLong.e(Long.valueOf(l), paramString);
        AppMethodBeat.o(265731);
        return;
      }
    }
    AppMethodBeat.o(265731);
  }
  
  public final MMHandler btS()
  {
    AppMethodBeat.i(265715);
    MMHandler localMMHandler = (MMHandler)this.ocu.getValue();
    AppMethodBeat.o(265715);
    return localMMHandler;
  }
  
  public final void keep(com.tencent.mm.vending.e.a parama)
  {
    AppMethodBeat.i(265727);
    this.xvE.add(parama);
    AppMethodBeat.o(265727);
  }
  
  public final void onDetach()
  {
    AppMethodBeat.i(265719);
    Log.i(this.jGx, "onDetach");
    this.xHZ = null;
    duu();
    Object localObject = this.xIb;
    if (localObject != null) {
      ((al)localObject).onDetach();
    }
    this.xIb = null;
    localObject = ((Iterable)this.xvE).iterator();
    while (((Iterator)localObject).hasNext()) {
      ((com.tencent.mm.vending.e.a)((Iterator)localObject).next()).dead();
    }
    this.xvE.clear();
    this.xGp.clear();
    btS().removeMessages(this.xId);
    btS().removeMessages(this.xFX);
    this.xIa.clear();
    this.fragment = null;
    this.activity = null;
    AppMethodBeat.o(265719);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/model/FinderLiveNoticePreLoader$Companion;", "", "()V", "TAG", "", "filterData", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "feedLoader", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "firstItemPos", "", "lastItemPos", "nameList2Str", "nameList", "", "str2NameList", "str", "plugin-finder_release"})
  public static final class a
  {
    public static LinkedList<bu> a(BaseFinderFeedLoader paramBaseFinderFeedLoader, int paramInt1, int paramInt2)
    {
      Object localObject = null;
      AppMethodBeat.i(290145);
      int j;
      int i;
      if (paramBaseFinderFeedLoader != null)
      {
        DataBuffer localDataBuffer = paramBaseFinderFeedLoader.getDataListJustForAdapter();
        if (localDataBuffer != null)
        {
          j = localDataBuffer.size();
          if (paramInt2 < j) {
            break label90;
          }
          i = j - 1;
          label41:
          Log.i("Finder.filterData", "filterData firstItemPos:" + paramInt1 + " lastItemPos:" + paramInt2);
          if (paramInt1 >= 0) {
            break label105;
          }
        }
      }
      label77:
      label90:
      label105:
      while ((j <= paramInt1) || (paramBaseFinderFeedLoader == null))
      {
        paramBaseFinderFeedLoader = null;
        AppMethodBeat.o(290145);
        return paramBaseFinderFeedLoader;
        j = 0;
        break;
        if (paramInt2 < paramInt1)
        {
          i = paramInt1;
          break label41;
        }
        i = paramInt2;
        break label41;
      }
      for (;;)
      {
        try
        {
          paramBaseFinderFeedLoader = paramBaseFinderFeedLoader.getDataListJustForAdapter();
          if (paramBaseFinderFeedLoader == null) {
            break;
          }
          if (paramBaseFinderFeedLoader.size() > i)
          {
            paramInt2 = 1;
            break label209;
            if (paramBaseFinderFeedLoader == null) {
              break;
            }
            paramBaseFinderFeedLoader = kotlin.a.j.a((List)paramBaseFinderFeedLoader, new e(paramInt1, i));
            if (paramBaseFinderFeedLoader == null) {
              break;
            }
            paramBaseFinderFeedLoader = new LinkedList((Collection)paramBaseFinderFeedLoader);
            break label77;
          }
          paramInt2 = 0;
        }
        catch (Exception paramBaseFinderFeedLoader)
        {
          Log.printErrStackTrace("Finder.filterData", (Throwable)paramBaseFinderFeedLoader, "filterData fail", new Object[0]);
          paramBaseFinderFeedLoader = localObject;
        }
        paramBaseFinderFeedLoader = null;
        continue;
        break label77;
        label209:
        if (paramInt2 == 0) {}
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "invoke"})
  static final class b
    extends q
    implements kotlin.g.a.a<MMHandler>
  {
    b(k paramk)
    {
      super();
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/os/Message;", "kotlin.jvm.PlatformType", "handleMessage"})
    static final class a
      implements MMHandler.Callback
    {
      a(k.b paramb) {}
      
      public final boolean handleMessage(Message paramMessage)
      {
        AppMethodBeat.i(271591);
        int i = paramMessage.what;
        Object localObject;
        if (i == k.f(this.xIg.xIf))
        {
          localObject = this.xIg.xIf;
          paramMessage = paramMessage.obj;
          if (paramMessage == null)
          {
            paramMessage = new t("null cannot be cast to non-null type java.util.LinkedList<kotlin.Pair<kotlin.Long, kotlin.String>>");
            AppMethodBeat.o(271591);
            throw paramMessage;
          }
          k.b((k)localObject, (LinkedList)paramMessage);
        }
        for (;;)
        {
          AppMethodBeat.o(271591);
          return true;
          if (i == k.i(this.xIg.xIf))
          {
            paramMessage = paramMessage.obj;
            if (paramMessage == null)
            {
              paramMessage = new t("null cannot be cast to non-null type java.util.LinkedList<kotlin.Pair<kotlin.String, com.tencent.mm.protocal.protobuf.FinderLiveNoticeInfo>>");
              AppMethodBeat.o(271591);
              throw paramMessage;
            }
            localObject = (Iterable)paramMessage;
            paramMessage = (Collection)new ArrayList(kotlin.a.j.a((Iterable)localObject, 10));
            localObject = ((Iterable)localObject).iterator();
            while (((Iterator)localObject).hasNext()) {
              paramMessage.add((String)((kotlin.o)((Iterator)localObject).next()).Mx);
            }
            paramMessage = (List)paramMessage;
            if (!((Collection)paramMessage).isEmpty())
            {
              i = 1;
              label198:
              if (i == 0) {
                break label218;
              }
            }
            for (;;)
            {
              if (paramMessage == null) {
                break label221;
              }
              k.ef(paramMessage);
              break;
              i = 0;
              break label198;
              label218:
              paramMessage = null;
            }
          }
          else
          {
            label221:
            if (i == k.j(this.xIg.xIf))
            {
              paramMessage = paramMessage.obj;
              if (paramMessage == null)
              {
                paramMessage = new t("null cannot be cast to non-null type kotlin.String");
                AppMethodBeat.o(271591);
                throw paramMessage;
              }
              k.ef(kotlin.a.j.listOf((String)paramMessage));
            }
          }
        }
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class c
    extends q
    implements kotlin.g.a.a<x>
  {
    c(k paramk, int paramInt1, int paramInt2, com.tencent.mm.plugin.finder.event.base.b paramb)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/FinderBatchGetObjectAsyncLoadInfoResponse;", "kotlin.jvm.PlatformType", "call"})
  static final class d<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    d(k paramk, aa.f paramf) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.model.k
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.finder.feed.model;

import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.event.base.h;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.bo;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.protocal.protobuf.awt;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandler.Callback;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.a.j;
import kotlin.g;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.g.b.z.f;
import kotlin.l;
import kotlin.o;
import kotlin.t;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/feed/model/FinderLiveNoticePreLoader;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycleKeeper;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycle;", "Lcom/tencent/mm/plugin/finder/event/base/EventObserver;", "()V", "NOTIFY_BY_CLICK", "", "NOTIFY_SIGNAL", "REQUEASR_SIGNAL", "TAG", "", "getData", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "firstItemPos", "lastItemPos", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "handler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "getHandler", "()Lcom/tencent/mm/sdk/platformtools/MMHandler;", "handler$delegate", "Lkotlin/Lazy;", "lifeCycleKeeperStore", "Ljava/util/concurrent/CopyOnWriteArraySet;", "loadedList", "Ljava/util/Vector;", "", "loadingList", "getOrRequestNoticeInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLiveNoticeInfo;", "userName", "keep", "", "target", "notify", "noticeInfos", "Lkotlin/Pair;", "notifyWithCache", "onAttach", "onDetach", "onEventHappen", "ev", "Lcom/tencent/mm/plugin/finder/event/base/Event;", "preLoadFinderLiveNoticeInfo", "ids", "publishEvent", "nameList", "", "requestSignNoticeInfo", "feedId", "nonceId", "(Ljava/lang/Long;Ljava/lang/String;)V", "Companion", "plugin-finder_release"})
public final class f
  extends com.tencent.mm.plugin.finder.event.base.d
  implements com.tencent.mm.vending.e.b<com.tencent.mm.vending.e.a>
{
  public static final a tWl;
  private final String TAG;
  private final kotlin.f lhN;
  private final CopyOnWriteArraySet<com.tencent.mm.vending.e.a> tLP;
  private Vector<Long> tUP;
  private m<? super Integer, ? super Integer, ? extends LinkedList<bo>> tWg;
  private final Vector<Long> tWh;
  private final int tWi;
  private final int tWj;
  public final int tWk;
  
  static
  {
    AppMethodBeat.i(244734);
    tWl = new a((byte)0);
    AppMethodBeat.o(244734);
  }
  
  public f()
  {
    AppMethodBeat.i(244733);
    this.TAG = "FinderLiveNoticePreLoader";
    this.tLP = new CopyOnWriteArraySet();
    this.tUP = new Vector();
    this.tWh = new Vector();
    this.tWi = 1;
    this.tWj = 2;
    this.tWk = 3;
    this.lhN = g.ah((kotlin.g.a.a)new b(this));
    AppMethodBeat.o(244733);
  }
  
  private final void ag(final LinkedList<o<Long, String>> paramLinkedList)
  {
    Object localObject3;
    int i;
    for (;;)
    {
      try
      {
        AppMethodBeat.i(244729);
        Log.i(this.TAG, "request id size = " + paramLinkedList.size());
        localObject1 = (Iterable)paramLinkedList;
        paramLinkedList = (Collection)new ArrayList();
        localObject1 = ((Iterable)localObject1).iterator();
        if (!((Iterator)localObject1).hasNext()) {
          break;
        }
        localObject2 = ((Iterator)localObject1).next();
        localObject3 = (o)localObject2;
        if (!this.tWh.contains(((o)localObject3).first))
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
    Log.i(this.TAG, "idsToFillLoading id size = " + ((LinkedList)localObject1).size());
    paramLinkedList = new z.f();
    Object localObject2 = (Iterable)localObject1;
    localObject1 = (Collection)new ArrayList();
    localObject2 = ((Iterable)localObject2).iterator();
    o localo;
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = ((Iterator)localObject2).next();
      localo = (o)localObject3;
      if (this.tUP.contains(localo.first)) {
        break label670;
      }
      i = 1;
      label241:
      if (i == 0) {
        break label673;
      }
      ((Collection)localObject1).add(localObject3);
    }
    paramLinkedList.SYG = new LinkedList((Collection)localObject1);
    Log.i(this.TAG, "real request id size = " + ((LinkedList)paramLinkedList.SYG).size());
    if (!((Collection)paramLinkedList.SYG).isEmpty())
    {
      i = 1;
      label327:
      if (i != 0)
      {
        localObject1 = this.tUP;
        localObject3 = (Iterable)paramLinkedList.SYG;
        localObject2 = (Collection)new ArrayList(j.a((Iterable)localObject3, 10));
        localObject3 = ((Iterable)localObject3).iterator();
        while (((Iterator)localObject3).hasNext()) {
          ((Collection)localObject2).add(Long.valueOf(((Number)((o)((Iterator)localObject3).next()).first).longValue()));
        }
        ((Vector)localObject1).addAll((Collection)localObject2);
        localObject2 = (Iterable)paramLinkedList.SYG;
        localObject1 = (Collection)new ArrayList();
        localObject2 = ((Iterable)localObject2).iterator();
      }
    }
    label670:
    label673:
    label689:
    label694:
    label697:
    for (;;)
    {
      label464:
      if (((Iterator)localObject2).hasNext())
      {
        localObject3 = ((Iterator)localObject2).next();
        localo = (o)localObject3;
        if (((Number)localo.first).longValue() == 0L) {
          break label694;
        }
        if (((CharSequence)localo.second).length() <= 0) {
          break label689;
        }
        i = 1;
      }
      for (;;)
      {
        if (i == 0) {
          break label697;
        }
        ((Collection)localObject1).add(localObject3);
        break label464;
        paramLinkedList.SYG = new LinkedList((Collection)localObject1);
        if (!((Collection)paramLinkedList.SYG).isEmpty())
        {
          i = 1;
          if (i == 0) {
            break label634;
          }
          new com.tencent.mm.plugin.finder.cgi.f((List)paramLinkedList.SYG).aYI().h((com.tencent.mm.vending.c.a)new d(this, paramLinkedList));
          AppMethodBeat.o(244729);
        }
        for (;;)
        {
          return;
          i = 0;
          break;
          label634:
          Log.i(this.TAG, "idsToRequest is empty #1");
          AppMethodBeat.o(244729);
          continue;
          Log.i(this.TAG, "idsToRequest is empty #2");
          AppMethodBeat.o(244729);
        }
        i = 0;
        break label241;
        break;
        i = 0;
        break label327;
        for (;;)
        {
          if (i == 0) {
            break label694;
          }
          i = 1;
          break;
          i = 0;
        }
        i = 0;
      }
    }
  }
  
  public static awt atq(String paramString)
  {
    AppMethodBeat.i(244728);
    p.h(paramString, "userName");
    e locale = e.tUY;
    paramString = e.ato(paramString);
    AppMethodBeat.o(244728);
    return paramString;
  }
  
  public final void a(com.tencent.mm.plugin.finder.event.base.b paramb)
  {
    AppMethodBeat.i(244731);
    p.h(paramb, "ev");
    if ((paramb instanceof h))
    {
      final int i = ((h)paramb).tIy;
      final int j = ((h)paramb).tIA;
      if (i > j)
      {
        AppMethodBeat.o(244731);
        return;
      }
      com.tencent.mm.ac.d.h((kotlin.g.a.a)new c(this, i, j));
    }
    AppMethodBeat.o(244731);
  }
  
  public final void a(Long paramLong, String paramString)
  {
    AppMethodBeat.i(244732);
    if ((paramLong != null) && (paramString != null))
    {
      paramLong = new LinkedList((Collection)j.listOf(new o(Long.valueOf(((Number)paramLong).longValue()), paramString)));
      bkj().sendMessage(bkj().obtainMessage(this.tWi, paramLong));
    }
    AppMethodBeat.o(244732);
  }
  
  public final MMHandler bkj()
  {
    AppMethodBeat.i(244725);
    MMHandler localMMHandler = (MMHandler)this.lhN.getValue();
    AppMethodBeat.o(244725);
    return localMMHandler;
  }
  
  public final void e(m<? super Integer, ? super Integer, ? extends LinkedList<bo>> paramm)
  {
    AppMethodBeat.i(244726);
    Log.i(this.TAG, "onAttach");
    this.tWg = paramm;
    AppMethodBeat.o(244726);
  }
  
  public final void keep(com.tencent.mm.vending.e.a parama)
  {
    AppMethodBeat.i(244730);
    this.tLP.add(parama);
    AppMethodBeat.o(244730);
  }
  
  public final void onDetach()
  {
    AppMethodBeat.i(244727);
    Log.i(this.TAG, "onDetach");
    this.tWg = null;
    Iterator localIterator = ((Iterable)this.tLP).iterator();
    while (localIterator.hasNext()) {
      ((com.tencent.mm.vending.e.a)localIterator.next()).dead();
    }
    this.tLP.clear();
    this.tUP.clear();
    bkj().removeMessages(this.tWi);
    bkj().removeMessages(this.tWj);
    this.tWh.clear();
    AppMethodBeat.o(244727);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/feed/model/FinderLiveNoticePreLoader$Companion;", "", "()V", "nameList2Str", "", "nameList", "", "str2NameList", "str", "plugin-finder_release"})
  public static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "invoke"})
  static final class b
    extends q
    implements kotlin.g.a.a<MMHandler>
  {
    b(f paramf)
    {
      super();
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/os/Message;", "kotlin.jvm.PlatformType", "handleMessage"})
    static final class a
      implements MMHandler.Callback
    {
      a(f.b paramb) {}
      
      public final boolean handleMessage(Message paramMessage)
      {
        AppMethodBeat.i(244720);
        int i = paramMessage.what;
        Object localObject;
        if (i == f.f(this.tWn.tWm))
        {
          localObject = this.tWn.tWm;
          paramMessage = paramMessage.obj;
          if (paramMessage == null)
          {
            paramMessage = new t("null cannot be cast to non-null type java.util.LinkedList<kotlin.Pair<kotlin.Long, kotlin.String>>");
            AppMethodBeat.o(244720);
            throw paramMessage;
          }
          f.b((f)localObject, (LinkedList)paramMessage);
        }
        for (;;)
        {
          AppMethodBeat.o(244720);
          return true;
          if (i == f.g(this.tWn.tWm))
          {
            paramMessage = paramMessage.obj;
            if (paramMessage == null)
            {
              paramMessage = new t("null cannot be cast to non-null type java.util.LinkedList<kotlin.Pair<kotlin.String, com.tencent.mm.protocal.protobuf.FinderLiveNoticeInfo>>");
              AppMethodBeat.o(244720);
              throw paramMessage;
            }
            localObject = (Iterable)paramMessage;
            paramMessage = (Collection)new ArrayList(j.a((Iterable)localObject, 10));
            localObject = ((Iterable)localObject).iterator();
            while (((Iterator)localObject).hasNext()) {
              paramMessage.add((String)((o)((Iterator)localObject).next()).first);
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
              f.dW(paramMessage);
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
            if (i == f.h(this.tWn.tWm))
            {
              paramMessage = paramMessage.obj;
              if (paramMessage == null)
              {
                paramMessage = new t("null cannot be cast to non-null type kotlin.String");
                AppMethodBeat.o(244720);
                throw paramMessage;
              }
              f.dW(j.listOf((String)paramMessage));
            }
          }
        }
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class c
    extends q
    implements kotlin.g.a.a<x>
  {
    c(f paramf, int paramInt1, int paramInt2)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/FinderBatchGetObjectAsyncLoadInfoResponse;", "kotlin.jvm.PlatformType", "call"})
  static final class d<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    d(f paramf, z.f paramf1) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.model.f
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.finder.model;

import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.k.i;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.cgi.dy;
import com.tencent.mm.plugin.finder.event.base.g;
import com.tencent.mm.plugin.finder.report.z;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.data.e;
import com.tencent.mm.plugin.finder.storage.data.e.a;
import com.tencent.mm.plugin.finder.utils.av;
import com.tencent.mm.plugin.finder.utils.bm;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.bow;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.protocal.protobuf.dmk;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.ui.component.k.b;
import com.tencent.mm.vfs.y;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.a;
import kotlin.g.b.u;
import kotlin.j;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/model/FinderMarkReadLogic;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "ADD", "", "READ", "REMOVE", "SAVE", "SEND", "STOP", "TAG", "", "feedCountThreshold", "getFeedCountThreshold", "()I", "feedCountThreshold$delegate", "Lkotlin/Lazy;", "markReadItemList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/MarkReadStat;", "getMarkReadItemList", "()Ljava/util/LinkedList;", "setMarkReadItemList", "(Ljava/util/LinkedList;)V", "startCount", "Ljava/util/concurrent/atomic/AtomicInteger;", "streamMarkReadFeedMap", "Ljava/util/HashMap;", "", "Lcom/tencent/mm/plugin/finder/model/StreamMarkReadStat;", "Lkotlin/collections/HashMap;", "timer", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "addCrossFeedList", "", "acrossFeedList", "", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "addCrossFeedListFromFeedData", "acrossFeedDataList", "Lcom/tencent/mm/plugin/finder/event/base/FlowScrollEventFeedData;", "addMarReadItemList", "itemList", "checkSend", "collectReadFeedList", "containItems", "", "scene", "objectId", "fillMarkReadScene", "markReadStat", "commentScene", "fromCommentScene", "filterTabMarkReadItem", "getStreamMarkReadList", "tabType", "nextSend", "onFinish", "onSceneEnd", "errType", "errCode", "errMsg", "Lcom/tencent/mm/modelbase/NetSceneBase;", "onStreamCgiBack", "feedList", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "read", "readFromFile", "save", "saveToFile", "send", "startTimer", "stopTimer", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ay
  implements com.tencent.mm.am.h
{
  public static final ay EDk;
  private static LinkedList<dmk> EDl;
  private static final j EDm;
  private static final MMHandler EDn;
  private static AtomicInteger EDo;
  private static HashMap<Integer, HashMap<Long, cf>> EDp;
  
  static
  {
    AppMethodBeat.i(178325);
    EDk = new ay();
    EDl = new LinkedList();
    EDm = kotlin.k.cm((a)a.EDq);
    com.tencent.mm.kernel.h.aZW().a(3520, (com.tencent.mm.am.h)EDk);
    EDn = new MMHandler("Finder.FinderMarkReadLogic", ay..ExternalSyntheticLambda0.INSTANCE);
    EDo = new AtomicInteger(0);
    EDp = new HashMap();
    AppMethodBeat.o(178325);
  }
  
  public static void D(int paramInt, List<? extends FinderObject> paramList)
  {
    AppMethodBeat.i(331972);
    kotlin.g.b.s.u(paramList, "feedList");
    Object localObject1;
    switch (paramInt)
    {
    case 2: 
    default: 
      AppMethodBeat.o(331972);
      return;
    case 3: 
      paramInt = 17;
      localObject1 = (HashMap)EDp.get(Integer.valueOf(paramInt));
      if (localObject1 != null) {
        break;
      }
    }
    Object localObject2;
    Object localObject3;
    for (int i = 0;; i = ((HashMap)localObject1).size())
    {
      localObject1 = ((Iterable)paramList).iterator();
      for (;;)
      {
        if (!((Iterator)localObject1).hasNext()) {
          break label296;
        }
        localObject2 = (FinderObject)((Iterator)localObject1).next();
        localObject3 = (HashMap)EDp.get(Integer.valueOf(paramInt));
        if (localObject3 != null) {
          break;
        }
        paramList = null;
        if (paramList == null)
        {
          paramList = (Map)EDp;
          localObject3 = new HashMap();
          ((HashMap)localObject3).put(Long.valueOf(((FinderObject)localObject2).id), new cf(((FinderObject)localObject2).id));
          paramList.put(Integer.valueOf(paramInt), localObject3);
        }
      }
      paramInt = 18;
      break;
      paramInt = 20;
      break;
    }
    paramList = (cf)((HashMap)localObject3).get(Long.valueOf(((FinderObject)localObject2).id));
    if (paramList == null) {}
    for (paramList = null;; paramList = ah.aiuX)
    {
      if (paramList == null) {
        ((Map)localObject3).put(Long.valueOf(((FinderObject)localObject2).id), new cf(((FinderObject)localObject2).id));
      }
      paramList = ah.aiuX;
      break;
      Log.i("Finder.FinderMarkReadLogic", kotlin.g.b.s.X("already in mark read map isRead:", Boolean.valueOf(paramList.EDT)));
    }
    label296:
    paramList = (HashMap)EDp.get(Integer.valueOf(paramInt));
    if ((paramList != null) && (paramList.size() > 50))
    {
      localObject2 = new LinkedList();
      ((LinkedList)localObject2).addAll(paramList.values());
      kotlin.a.p.N((List)localObject2);
      paramList = (Map)EDp;
      localObject1 = new HashMap();
      localObject2 = ((LinkedList)localObject2).subList(0, 50);
      kotlin.g.b.s.s(localObject2, "list.subList(0, 50)");
      localObject2 = ((Iterable)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (cf)((Iterator)localObject2).next();
        ((HashMap)localObject1).put(Long.valueOf(((cf)localObject3).feedId), localObject3);
      }
      paramList.put(Integer.valueOf(paramInt), localObject1);
    }
    paramList = (HashMap)EDp.get(Integer.valueOf(paramInt));
    if (paramList == null) {}
    for (paramInt = 0;; paramInt = paramList.size())
    {
      Log.i("Finder.FinderMarkReadLogic", "onStreamCgiBack beforeSize:" + i + " afterSize:" + paramInt);
      AppMethodBeat.o(331972);
      return;
    }
  }
  
  public static void Px()
  {
    AppMethodBeat.i(178319);
    EDn.sendEmptyMessage(3);
    AppMethodBeat.o(178319);
  }
  
  public static LinkedList<dmk> Qt(int paramInt)
  {
    int j = 0;
    AppMethodBeat.i(331984);
    LinkedList localLinkedList = new LinkedList();
    switch (paramInt)
    {
    case 2: 
    default: 
      i = 0;
    }
    for (;;)
    {
      localObject2 = (HashMap)EDp.get(Integer.valueOf(i));
      if (localObject2 == null) {
        break label333;
      }
      localObject1 = new LinkedList();
      localObject3 = (Map)localObject2;
      localObject2 = (Map)new LinkedHashMap();
      localObject3 = ((Map)localObject3).entrySet().iterator();
      while (((Iterator)localObject3).hasNext())
      {
        Map.Entry localEntry = (Map.Entry)((Iterator)localObject3).next();
        if (((cf)localEntry.getValue()).EDT) {
          ((Map)localObject2).put(localEntry.getKey(), localEntry.getValue());
        }
      }
      i = 17;
      continue;
      i = 18;
      continue;
      i = 20;
    }
    Object localObject2 = ((Map)localObject2).entrySet().iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((LinkedList)localObject1).add(((Map.Entry)((Iterator)localObject2).next()).getValue());
    }
    kotlin.a.p.N((List)localObject1);
    Object localObject1 = ((Iterable)localObject1).iterator();
    int i = j;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = ((Iterator)localObject1).next();
      if (i < 0) {
        kotlin.a.p.kkW();
      }
      localObject2 = (cf)localObject2;
      if ((i < 20) && (localObject2 != null))
      {
        localObject2 = ((cf)localObject2).EDU;
        if (localObject2 != null) {
          localLinkedList.add(localObject2);
        }
      }
      i += 1;
    }
    label333:
    localObject1 = new StringBuilder("getStreamMarkReadList ").append(paramInt).append(' ');
    Object localObject3 = (Iterable)localLinkedList;
    localObject2 = (Collection)new ArrayList(kotlin.a.p.a((Iterable)localObject3, 10));
    localObject3 = ((Iterable)localObject3).iterator();
    while (((Iterator)localObject3).hasNext()) {
      ((Collection)localObject2).add(d.hF(((dmk)((Iterator)localObject3).next()).hKN));
    }
    Log.i("Finder.FinderMarkReadLogic", (List)localObject2);
    AppMethodBeat.o(331984);
    return localLinkedList;
  }
  
  private static void a(dmk paramdmk, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(331997);
    kotlin.g.b.s.u(paramdmk, "markReadStat");
    paramdmk.aaSt = paramInt1;
    switch (paramInt1)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(331997);
      return;
      paramdmk.scene = 1;
      paramdmk.AcJ = 1;
      AppMethodBeat.o(331997);
      return;
      paramdmk.scene = 1;
      paramdmk.AcJ = 2;
      AppMethodBeat.o(331997);
      return;
      paramdmk.scene = 1;
      paramdmk.AcJ = 3;
      AppMethodBeat.o(331997);
      return;
      paramdmk.scene = 9;
      AppMethodBeat.o(331997);
      return;
      paramdmk.scene = 10;
      AppMethodBeat.o(331997);
      return;
      paramdmk.scene = 2;
      AppMethodBeat.o(331997);
      return;
      paramdmk.scene = 3;
      AppMethodBeat.o(331997);
      return;
      paramdmk.scene = 4;
      AppMethodBeat.o(331997);
      return;
      paramdmk.scene = 6;
      paramdmk.AcJ = 4;
      AppMethodBeat.o(331997);
      return;
      paramdmk.scene = 7;
      paramdmk.AcJ = 4;
      AppMethodBeat.o(331997);
      return;
      if (paramInt2 != 34)
      {
        paramdmk.scene = 5;
        AppMethodBeat.o(331997);
        return;
        if (paramInt2 != 34) {}
      }
      else
      {
        paramdmk.scene = 8;
      }
    }
  }
  
  private static void a(LinkedList<dmk> paramLinkedList, List<? extends cc> paramList, bui parambui)
  {
    AppMethodBeat.i(332028);
    kotlin.g.b.s.u(paramLinkedList, "itemList");
    kotlin.g.b.s.u(parambui, "contextObj");
    aN(paramLinkedList);
    if ((parambui.AJo == 17) || (parambui.AJo == 18))
    {
      paramLinkedList = com.tencent.mm.ui.component.k.aeZF;
      ((com.tencent.mm.plugin.finder.viewmodel.h)com.tencent.mm.ui.component.k.cn(PluginFinder.class).q(com.tencent.mm.plugin.finder.viewmodel.h.class)).L(parambui.AJo, paramList);
      AppMethodBeat.o(332028);
      return;
    }
    if (parambui.AJo == 51)
    {
      paramList = com.tencent.mm.ui.component.k.aeZF;
      ((com.tencent.mm.plugin.finder.viewmodel.f)com.tencent.mm.ui.component.k.cn(PluginFinder.class).q(com.tencent.mm.plugin.finder.viewmodel.f.class)).hN((List)paramLinkedList);
    }
    AppMethodBeat.o(332028);
  }
  
  public static void a(List<? extends cc> paramList, bui parambui)
  {
    AppMethodBeat.i(332010);
    kotlin.g.b.s.u(parambui, "contextObj");
    Object localObject1 = (Collection)paramList;
    if ((localObject1 == null) || (((Collection)localObject1).isEmpty())) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(332010);
      return;
    }
    localObject1 = new LinkedList();
    Iterator localIterator = ((Iterable)paramList).iterator();
    while (localIterator.hasNext())
    {
      cc localcc = (cc)localIterator.next();
      if (localcc.bZA() != 0L)
      {
        Object localObject2;
        if (!(localcc instanceof BaseFinderFeed))
        {
          localObject2 = av.GiL;
          if (!av.ffO().contains(Integer.valueOf(localcc.bZB()))) {}
        }
        else
        {
          localObject2 = new dmk();
          ((dmk)localObject2).hKN = localcc.bZA();
          a((dmk)localObject2, parambui.AJo, parambui.hLK);
          z localz = z.FrZ;
          ((dmk)localObject2).sessionBuffer = z.p(localcc.bZA(), parambui.AJo);
          ((LinkedList)localObject1).add(localObject2);
        }
      }
    }
    a((LinkedList)localObject1, paramList, parambui);
    AppMethodBeat.o(332010);
  }
  
  public static void aN(LinkedList<dmk> paramLinkedList)
  {
    AppMethodBeat.i(178320);
    kotlin.g.b.s.u(paramLinkedList, "itemList");
    Log.i("Finder.FinderMarkReadLogic", kotlin.g.b.s.X("addMarkReadItemList ", Integer.valueOf(paramLinkedList.size())));
    Message localMessage = EDn.obtainMessage(0);
    localMessage.obj = paramLinkedList;
    localMessage.sendToTarget();
    AppMethodBeat.o(178320);
  }
  
  private static boolean an(int paramInt, long paramLong)
  {
    AppMethodBeat.i(178323);
    Iterator localIterator = ((Iterable)EDl).iterator();
    while (localIterator.hasNext())
    {
      dmk localdmk = (dmk)localIterator.next();
      if ((localdmk.scene == paramInt) && (localdmk.hKN == paramLong))
      {
        AppMethodBeat.o(178323);
        return true;
      }
    }
    AppMethodBeat.o(178323);
    return false;
  }
  
  public static void b(List<g> paramList, bui parambui)
  {
    AppMethodBeat.i(332022);
    kotlin.g.b.s.u(parambui, "contextObj");
    Object localObject1 = (Collection)paramList;
    if ((localObject1 == null) || (((Collection)localObject1).isEmpty())) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(332022);
      return;
    }
    Object localObject2 = (Iterable)paramList;
    localObject1 = (Collection)new ArrayList(kotlin.a.p.a((Iterable)localObject2, 10));
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((Collection)localObject1).add(((g)((Iterator)localObject2).next()).AOm);
    }
    localObject1 = (List)localObject1;
    localObject2 = new LinkedList();
    paramList = ((Iterable)paramList).iterator();
    while (paramList.hasNext())
    {
      g localg = (g)paramList.next();
      if (localg.AOm.bZA() != 0L)
      {
        Object localObject3;
        if (!(localg.AOm instanceof BaseFinderFeed))
        {
          localObject3 = av.GiL;
          if (!av.ffO().contains(Integer.valueOf(localg.AOm.bZB()))) {}
        }
        else
        {
          localObject3 = new dmk();
          ((dmk)localObject3).aaSv = localg.AOn;
          ((dmk)localObject3).hKN = localg.AOm.bZA();
          a((dmk)localObject3, parambui.AJo, parambui.hLK);
          z localz = z.FrZ;
          ((dmk)localObject3).sessionBuffer = z.p(localg.AOm.bZA(), parambui.AJo);
          ((LinkedList)localObject2).add(localObject3);
        }
      }
    }
    a((LinkedList)localObject2, (List)localObject1, parambui);
    AppMethodBeat.o(332022);
  }
  
  private static void eDu()
  {
    AppMethodBeat.i(178318);
    EDn.removeMessages(1);
    int i = i.aRC().getInt("FinderMarkReadReportIntervalSecond", 60);
    EDn.sendEmptyMessageDelayed(1, i * 1000L);
    AppMethodBeat.o(178318);
  }
  
  private static void eDv()
  {
    AppMethodBeat.i(331929);
    Object localObject1 = new bow();
    ((bow)localObject1).ZXp = EDl;
    localObject1 = ((bow)localObject1).toByteArray();
    Object localObject2 = bm.GlZ;
    localObject2 = kotlin.g.b.s.X(bm.fir(), "markread.info");
    if (y.ZC((String)localObject2)) {
      y.ew((String)localObject2, true);
    }
    bm localbm = bm.GlZ;
    if (!y.ZC(bm.fir()))
    {
      localbm = bm.GlZ;
      y.bDX(bm.fir());
    }
    y.f((String)localObject2, (byte[])localObject1, localObject1.length);
    Log.i("Finder.FinderMarkReadLogic", kotlin.g.b.s.X("saveToFile ", localObject2));
    AppMethodBeat.o(331929);
  }
  
  private static final boolean q(Message paramMessage)
  {
    AppMethodBeat.i(332042);
    kotlin.g.b.s.u(paramMessage, "it");
    Object localObject1;
    int i;
    Object localObject2;
    int j;
    label528:
    int k;
    if (paramMessage.what == 0) {
      if ((paramMessage.obj instanceof LinkedList))
      {
        paramMessage = paramMessage.obj;
        if (paramMessage == null)
        {
          paramMessage = new NullPointerException("null cannot be cast to non-null type java.util.LinkedList<com.tencent.mm.protocal.protobuf.MarkReadStat>");
          AppMethodBeat.o(332042);
          throw paramMessage;
        }
        localObject1 = ((Iterable)paramMessage).iterator();
        i = 0;
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (dmk)((Iterator)localObject1).next();
          StringBuilder localStringBuilder;
          av localav;
          if (!an(((dmk)localObject2).scene, ((dmk)localObject2).hKN))
          {
            j = i + 1;
            EDl.add(localObject2);
            paramMessage = (HashMap)EDp.get(Integer.valueOf(((dmk)localObject2).aaSt));
            if (paramMessage != null)
            {
              paramMessage = (cf)paramMessage.get(Long.valueOf(((dmk)localObject2).hKN));
              if (paramMessage != null)
              {
                paramMessage.EDT = true;
                paramMessage.EDU = ((dmk)localObject2);
              }
            }
            paramMessage = e.FMN;
            paramMessage = e.a.jn(((dmk)localObject2).hKN);
            if (paramMessage == null) {}
            for (paramMessage = null;; paramMessage = ah.aiuX)
            {
              i = j;
              if (paramMessage != null) {
                break;
              }
              Log.d("Finder.FinderMarkReadLogic", kotlin.g.b.s.X("mark read ", d.hF(((dmk)localObject2).hKN)));
              i = j;
              break;
              localStringBuilder = new StringBuilder("mark read scene:").append(((dmk)localObject2).scene).append(" subScene:").append(((dmk)localObject2).AcJ).append(" commScene:").append(((dmk)localObject2).aaSt).append(' ').append(d.hF(((dmk)localObject2).hKN)).append(" nickname:").append(paramMessage.getNickName()).append(" desc:");
              localav = av.GiL;
              Log.d("Finder.FinderMarkReadLogic", av.aBL(paramMessage.getDescription()) + " expose:" + ((dmk)localObject2).aaSu);
            }
          }
          paramMessage = e.FMN;
          paramMessage = e.a.jn(((dmk)localObject2).hKN);
          if (paramMessage == null) {}
          for (paramMessage = null;; paramMessage = ah.aiuX)
          {
            if (paramMessage != null) {
              break label528;
            }
            Log.d("Finder.FinderMarkReadLogic", kotlin.g.b.s.X("contains read ", d.hF(((dmk)localObject2).hKN)));
            break;
            localStringBuilder = new StringBuilder("contains read scene:").append(((dmk)localObject2).scene).append(" subScene:").append(((dmk)localObject2).AcJ).append(" commScene:").append(((dmk)localObject2).aaSt).append(' ').append(d.hF(((dmk)localObject2).hKN)).append(" nickname:").append(paramMessage.getNickName()).append(" desc:");
            localav = av.GiL;
            Log.d("Finder.FinderMarkReadLogic", av.aBL(paramMessage.getDescription()) + " expose:" + ((dmk)localObject2).aaSu);
          }
        }
        k = EDl.size();
        if ((k > 1000) && (1000 <= k)) {
          j = 1000;
        }
      }
    }
    for (;;)
    {
      EDl.removeFirst();
      if (j == k)
      {
        Log.i("Finder.FinderMarkReadLogic", "final add " + i + ' ' + k + ' ' + EDl.size());
        eDv();
        if ((i > 0) && (EDl.size() >= ((Number)EDm.getValue()).intValue()))
        {
          Log.i("Finder.FinderMarkReadLogic", kotlin.g.b.s.X("checkSend: size = ", Integer.valueOf(EDl.size())));
          EDn.removeMessages(1);
          EDn.sendEmptyMessage(1);
        }
        for (;;)
        {
          AppMethodBeat.o(332042);
          return false;
          if (paramMessage.what == 1)
          {
            if (EDl.size() > 0)
            {
              EDk.send();
              eDu();
            }
          }
          else if (paramMessage.what == 2)
          {
            if ((paramMessage.obj instanceof LinkedList))
            {
              localObject1 = EDl;
              paramMessage = paramMessage.obj;
              if (paramMessage == null)
              {
                paramMessage = new NullPointerException("null cannot be cast to non-null type java.util.LinkedList<com.tencent.mm.protocal.protobuf.MarkReadStat>");
                AppMethodBeat.o(332042);
                throw paramMessage;
              }
              ((LinkedList)localObject1).removeAll((Collection)paramMessage);
              eDv();
            }
          }
          else if (paramMessage.what == 3)
          {
            paramMessage = bm.GlZ;
            paramMessage = kotlin.g.b.s.X(bm.fir(), "markread.info");
            if (y.ZC(paramMessage))
            {
              localObject1 = y.bi(paramMessage, 0, -1);
              localObject2 = new bow();
              try
              {
                ((bow)localObject2).parseFrom((byte[])localObject1);
                localObject1 = ((bow)localObject2).ZXp;
                kotlin.g.b.s.s(localObject1, "saveObj.readStats");
                EDl = (LinkedList)localObject1;
                Log.i("Finder.FinderMarkReadLogic", kotlin.g.b.s.X("readFromFile ", paramMessage));
              }
              catch (Exception localException)
              {
                for (;;)
                {
                  Log.printErrStackTrace("Finder.FinderMarkReadLogic", (Throwable)localException, "read", new Object[0]);
                }
              }
            }
          }
          else if (paramMessage.what == 4)
          {
            eDv();
          }
          else if (paramMessage.what == 5)
          {
            EDk.send();
            EDp = new HashMap();
          }
        }
      }
      j += 1;
    }
  }
  
  private final void send()
  {
    AppMethodBeat.i(331915);
    int i = 0;
    while (i < EDl.size())
    {
      Object localObject1 = new LinkedList();
      if (EDl.size() > i + 50) {
        ((LinkedList)localObject1).addAll((Collection)EDl.subList(i, i + 50));
      }
      Object localObject2;
      Collection localCollection;
      for (;;)
      {
        localObject2 = new StringBuilder("start to send new cgi ").append(((LinkedList)localObject1).size()).append(' ');
        Object localObject3 = (Iterable)EDl;
        localCollection = (Collection)new ArrayList(kotlin.a.p.a((Iterable)localObject3, 10));
        localObject3 = ((Iterable)localObject3).iterator();
        while (((Iterator)localObject3).hasNext()) {
          localCollection.add(d.hF(((dmk)((Iterator)localObject3).next()).hKN));
        }
        localObject2 = EDl;
        ((LinkedList)localObject1).addAll((Collection)((LinkedList)localObject2).subList(i, ((LinkedList)localObject2).size()));
      }
      Log.i("Finder.FinderMarkReadLogic", (List)localCollection);
      localObject1 = new dy((LinkedList)localObject1);
      com.tencent.mm.kernel.h.aZW().a(3520, (com.tencent.mm.am.h)this);
      com.tencent.mm.kernel.h.aZW().a((com.tencent.mm.am.p)localObject1, 0);
      i += 50;
    }
    AppMethodBeat.o(331915);
  }
  
  public static void startTimer()
  {
    AppMethodBeat.i(331949);
    Log.i("Finder.FinderMarkReadLogic", kotlin.g.b.s.X("start success ", Integer.valueOf(EDo.incrementAndGet())));
    eDu();
    AppMethodBeat.o(331949);
  }
  
  public static void stopTimer()
  {
    AppMethodBeat.i(178322);
    int i = EDo.decrementAndGet();
    if (i == 0)
    {
      Log.i("Finder.FinderMarkReadLogic", "really stop");
      EDn.removeMessages(1);
      EDn.sendEmptyMessage(5);
      AppMethodBeat.o(178322);
      return;
    }
    Log.i("Finder.FinderMarkReadLogic", kotlin.g.b.s.X("not really stop ", Integer.valueOf(i)));
    AppMethodBeat.o(178322);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.am.p paramp)
  {
    AppMethodBeat.i(178324);
    Log.i("Finder.FinderMarkReadLogic", "onSceneEnd errType:" + paramInt1 + " errCode:" + paramInt2);
    if ((paramp != null) && ((paramp instanceof dy)) && (paramInt1 == 0) && (paramInt2 == 0))
    {
      paramString = EDn.obtainMessage(2);
      paramString.obj = ((dy)paramp).ADI;
      paramString.sendToTarget();
    }
    AppMethodBeat.o(178324);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements a<Integer>
  {
    public static final a EDq;
    
    static
    {
      AppMethodBeat.i(332116);
      EDq = new a();
      AppMethodBeat.o(332116);
    }
    
    a()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.model.ay
 * JD-Core Version:    0.7.0.1
 */
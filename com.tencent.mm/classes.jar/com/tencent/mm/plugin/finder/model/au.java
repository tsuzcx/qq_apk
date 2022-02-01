package com.tencent.mm.plugin.finder.model;

import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.cgi.cw;
import com.tencent.mm.plugin.finder.report.n;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.data.e;
import com.tencent.mm.plugin.finder.storage.data.e.a;
import com.tencent.mm.plugin.finder.utils.aj;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.bid;
import com.tencent.mm.protocal.protobuf.cve;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandler.Callback;
import com.tencent.mm.ui.component.g.a;
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
import kotlin.a.j;
import kotlin.g.a.a;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/model/FinderMarkReadLogic;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "ADD", "", "getADD", "()I", "READ", "getREAD", "REMOVE", "getREMOVE", "SAVE", "getSAVE", "SEND", "getSEND", "STOP", "getSTOP", "TAG", "", "getTAG", "()Ljava/lang/String;", "feedCountThreshold", "getFeedCountThreshold", "feedCountThreshold$delegate", "Lkotlin/Lazy;", "markReadItemList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/MarkReadStat;", "getMarkReadItemList", "()Ljava/util/LinkedList;", "setMarkReadItemList", "(Ljava/util/LinkedList;)V", "startCount", "Ljava/util/concurrent/atomic/AtomicInteger;", "streamMarkReadFeedMap", "Ljava/util/HashMap;", "", "Lcom/tencent/mm/plugin/finder/model/StreamMarkReadStat;", "Lkotlin/collections/HashMap;", "timer", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "addCrossFeedList", "", "acrossFeedList", "", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "addMarReadItemList", "itemList", "checkSend", "containItems", "", "scene", "objectId", "fillMarkReadScene", "markReadStat", "commentScene", "fromCommentScene", "filterTabMarkReadItem", "getStreamMarkReadList", "tabType", "nextSend", "onFinish", "onSceneEnd", "errType", "errCode", "errMsg", "Lcom/tencent/mm/modelbase/NetSceneBase;", "onStreamCgiBack", "feedList", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "read", "readFromFile", "save", "saveToFile", "send", "startTimer", "stopTimer", "plugin-finder_release"})
public final class au
  implements i
{
  private static final int ADD = 0;
  private static final String TAG = "Finder.FinderMarkReadLogic";
  private static LinkedList<cve> zAV;
  private static final int zAW = 1;
  private static final int zAX = 2;
  private static final int zAY = 3;
  private static final int zAZ = 4;
  private static final int zBa = 5;
  private static final kotlin.f zBb;
  private static final MMHandler zBc;
  private static AtomicInteger zBd;
  private static HashMap<Integer, HashMap<Long, bw>> zBe;
  public static final au zBf;
  
  static
  {
    AppMethodBeat.i(178325);
    au localau = new au();
    zBf = localau;
    TAG = "Finder.FinderMarkReadLogic";
    zAV = new LinkedList();
    zAW = 1;
    zAX = 2;
    zAY = 3;
    zAZ = 4;
    zBa = 5;
    zBb = kotlin.g.ar((a)au.a.zBg);
    com.tencent.mm.kernel.h.aGY().a(3520, (i)localau);
    zBc = new MMHandler(TAG, (MMHandler.Callback)b.zBh);
    zBd = new AtomicInteger(0);
    zBe = new HashMap();
    AppMethodBeat.o(178325);
  }
  
  public static LinkedList<cve> Og(int paramInt)
  {
    int j = 0;
    AppMethodBeat.i(281340);
    LinkedList localLinkedList = new LinkedList();
    switch (paramInt)
    {
    case 2: 
    default: 
      i = 0;
    }
    for (;;)
    {
      localObject2 = (HashMap)zBe.get(Integer.valueOf(i));
      if (localObject2 == null) {
        break label347;
      }
      localObject1 = new LinkedList();
      p.j(localObject2, "markReadMap");
      localObject3 = (Map)localObject2;
      localObject2 = (Map)new LinkedHashMap();
      localObject3 = ((Map)localObject3).entrySet().iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localObject4 = (Map.Entry)((Iterator)localObject3).next();
        if (((bw)((Map.Entry)localObject4).getValue()).zBw) {
          ((Map)localObject2).put(((Map.Entry)localObject4).getKey(), ((Map.Entry)localObject4).getValue());
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
    j.lm((List)localObject1);
    Object localObject1 = ((Iterable)localObject1).iterator();
    int i = j;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = ((Iterator)localObject1).next();
      j = i + 1;
      if (i < 0) {
        j.iBO();
      }
      localObject2 = (bw)localObject2;
      if ((i < 20) && (localObject2 != null))
      {
        localObject2 = ((bw)localObject2).zBx;
        if (localObject2 != null)
        {
          localLinkedList.add(localObject2);
          i = j;
          continue;
        }
      }
      i = j;
    }
    label347:
    localObject1 = TAG;
    localObject2 = new StringBuilder("getStreamMarkReadList ").append(paramInt).append(' ');
    Object localObject4 = (Iterable)localLinkedList;
    Object localObject3 = (Collection)new ArrayList(j.a((Iterable)localObject4, 10));
    localObject4 = ((Iterable)localObject4).iterator();
    while (((Iterator)localObject4).hasNext()) {
      ((Collection)localObject3).add(com.tencent.mm.ae.d.Fw(((cve)((Iterator)localObject4).next()).xbk));
    }
    Log.i((String)localObject1, (List)localObject3);
    AppMethodBeat.o(281340);
    return localLinkedList;
  }
  
  private static void a(cve paramcve, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(281341);
    p.k(paramcve, "markReadStat");
    paramcve.TCM = paramInt1;
    switch (paramInt1)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(281341);
      return;
      paramcve.scene = 1;
      paramcve.wGA = 1;
      AppMethodBeat.o(281341);
      return;
      paramcve.scene = 1;
      paramcve.wGA = 2;
      AppMethodBeat.o(281341);
      return;
      paramcve.scene = 1;
      paramcve.wGA = 3;
      AppMethodBeat.o(281341);
      return;
      paramcve.scene = 9;
      AppMethodBeat.o(281341);
      return;
      paramcve.scene = 10;
      AppMethodBeat.o(281341);
      return;
      paramcve.scene = 2;
      AppMethodBeat.o(281341);
      return;
      paramcve.scene = 3;
      AppMethodBeat.o(281341);
      return;
      paramcve.scene = 4;
      AppMethodBeat.o(281341);
      return;
      paramcve.scene = 6;
      paramcve.wGA = 4;
      AppMethodBeat.o(281341);
      return;
      paramcve.scene = 7;
      paramcve.wGA = 4;
      AppMethodBeat.o(281341);
      return;
      if (paramInt2 != 34)
      {
        paramcve.scene = 5;
        AppMethodBeat.o(281341);
        return;
        if (paramInt2 != 34) {}
      }
      else
      {
        paramcve.scene = 8;
      }
    }
  }
  
  public static void a(List<? extends bu> paramList, bid parambid)
  {
    AppMethodBeat.i(281343);
    p.k(parambid, "contextObj");
    Object localObject1 = new LinkedList();
    if (paramList != null)
    {
      Iterator localIterator = ((Iterable)paramList).iterator();
      while (localIterator.hasNext())
      {
        bu localbu = (bu)localIterator.next();
        if (localbu.mf() != 0L)
        {
          Object localObject2;
          if (!(localbu instanceof BaseFinderFeed))
          {
            localObject2 = aj.AGc;
            if (!aj.edV().contains(Integer.valueOf(localbu.bAQ()))) {}
          }
          else
          {
            localObject2 = new cve();
            ((cve)localObject2).xbk = localbu.mf();
            a((cve)localObject2, parambid.xkX, parambid.fGo);
            n localn = n.zWF;
            ((cve)localObject2).sessionBuffer = n.N(localbu.mf(), parambid.xkX);
            ((LinkedList)localObject1).add(localObject2);
          }
        }
      }
    }
    aI((LinkedList)localObject1);
    if ((parambid.xkX == 17) || (parambid.xkX == 18))
    {
      localObject1 = com.tencent.mm.ui.component.g.Xox;
      ((com.tencent.mm.plugin.finder.viewmodel.f)com.tencent.mm.ui.component.g.bD(PluginFinder.class).i(com.tencent.mm.plugin.finder.viewmodel.f.class)).r(parambid.xkX, paramList);
      AppMethodBeat.o(281343);
      return;
    }
    if (parambid.xkX == 51)
    {
      paramList = com.tencent.mm.ui.component.g.Xox;
      ((com.tencent.mm.plugin.finder.viewmodel.d)com.tencent.mm.ui.component.g.bD(PluginFinder.class).i(com.tencent.mm.plugin.finder.viewmodel.d.class)).fb((List)localObject1);
    }
    AppMethodBeat.o(281343);
  }
  
  public static void aI(LinkedList<cve> paramLinkedList)
  {
    AppMethodBeat.i(178320);
    p.k(paramLinkedList, "itemList");
    Log.i(TAG, "addMarkReadItemList " + paramLinkedList.size());
    Message localMessage = zBc.obtainMessage(ADD);
    localMessage.obj = paramLinkedList;
    localMessage.sendToTarget();
    AppMethodBeat.o(178320);
  }
  
  public static boolean aj(int paramInt, long paramLong)
  {
    AppMethodBeat.i(178323);
    Iterator localIterator = ((Iterable)zAV).iterator();
    while (localIterator.hasNext())
    {
      cve localcve = (cve)localIterator.next();
      if ((localcve.scene == paramInt) && (localcve.xbk == paramLong))
      {
        AppMethodBeat.o(178323);
        return true;
      }
    }
    AppMethodBeat.o(178323);
    return false;
  }
  
  public static LinkedList<cve> dKB()
  {
    return zAV;
  }
  
  public static int dKC()
  {
    return ADD;
  }
  
  public static int dKD()
  {
    return zAW;
  }
  
  public static int dKE()
  {
    return zAX;
  }
  
  public static int dKF()
  {
    return zAY;
  }
  
  public static int dKG()
  {
    return zAZ;
  }
  
  public static int dKH()
  {
    return zBa;
  }
  
  private static void dKI()
  {
    AppMethodBeat.i(178318);
    zBc.removeMessages(zAW);
    int i = com.tencent.mm.n.h.axc().getInt("FinderMarkReadReportIntervalSecond", 60);
    zBc.sendEmptyMessageDelayed(zAW, i * 1000L);
    AppMethodBeat.o(178318);
  }
  
  public static String getTAG()
  {
    return TAG;
  }
  
  public static void j(int paramInt, List<? extends FinderObject> paramList)
  {
    int j = 0;
    AppMethodBeat.i(281339);
    p.k(paramList, "feedList");
    Object localObject1;
    int i;
    switch (paramInt)
    {
    case 2: 
    default: 
      AppMethodBeat.o(281339);
      return;
    case 3: 
      paramInt = 17;
      localObject1 = (HashMap)zBe.get(Integer.valueOf(paramInt));
      if (localObject1 != null)
      {
        i = ((HashMap)localObject1).size();
        label84:
        paramList = ((Iterable)paramList).iterator();
      }
      break;
    }
    Object localObject2;
    Object localObject3;
    for (;;)
    {
      if (!paramList.hasNext()) {
        break label305;
      }
      localObject1 = (FinderObject)paramList.next();
      localObject2 = (HashMap)zBe.get(Integer.valueOf(paramInt));
      if (localObject2 != null)
      {
        localObject3 = (bw)((HashMap)localObject2).get(Long.valueOf(((FinderObject)localObject1).id));
        if (localObject3 != null)
        {
          Log.i(TAG, "already in mark read map isRead:" + ((bw)localObject3).zBw);
          continue;
          paramInt = 18;
          break;
          paramInt = 20;
          break;
          i = 0;
          break label84;
        }
        p.j(localObject2, "markReadMap");
        ((Map)localObject2).put(Long.valueOf(((FinderObject)localObject1).id), new bw(((FinderObject)localObject1).id));
        continue;
      }
      localObject2 = (Map)zBe;
      localObject3 = new HashMap();
      ((HashMap)localObject3).put(Long.valueOf(((FinderObject)localObject1).id), new bw(((FinderObject)localObject1).id));
      ((Map)localObject2).put(Integer.valueOf(paramInt), localObject3);
    }
    label305:
    paramList = (HashMap)zBe.get(Integer.valueOf(paramInt));
    if ((paramList != null) && (paramList.size() > 50))
    {
      localObject2 = new LinkedList();
      ((LinkedList)localObject2).addAll(paramList.values());
      j.lm((List)localObject2);
      paramList = (Map)zBe;
      localObject1 = new HashMap();
      localObject2 = ((LinkedList)localObject2).subList(0, 50);
      p.j(localObject2, "list.subList(0, 50)");
      localObject2 = ((Iterable)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (bw)((Iterator)localObject2).next();
        ((HashMap)localObject1).put(Long.valueOf(((bw)localObject3).feedId), localObject3);
      }
      paramList.put(Integer.valueOf(paramInt), localObject1);
    }
    paramList = (HashMap)zBe.get(Integer.valueOf(paramInt));
    paramInt = j;
    if (paramList != null) {
      paramInt = paramList.size();
    }
    Log.i(TAG, "onStreamCgiBack beforeSize:" + i + " afterSize:" + paramInt);
    AppMethodBeat.o(281339);
  }
  
  public static void qm()
  {
    AppMethodBeat.i(178319);
    zBc.sendEmptyMessage(zAY);
    AppMethodBeat.o(178319);
  }
  
  public static void startTimer()
  {
    AppMethodBeat.i(281335);
    int i = zBd.incrementAndGet();
    Log.i(TAG, "start success ".concat(String.valueOf(i)));
    dKI();
    AppMethodBeat.o(281335);
  }
  
  public static void stopTimer()
  {
    AppMethodBeat.i(178322);
    int i = zBd.decrementAndGet();
    if (i == 0)
    {
      Log.i(TAG, "really stop");
      zBc.removeMessages(zAW);
      zBc.sendEmptyMessage(zBa);
      AppMethodBeat.o(178322);
      return;
    }
    Log.i(TAG, "not really stop ".concat(String.valueOf(i)));
    AppMethodBeat.o(178322);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(178324);
    Log.i(TAG, "onSceneEnd errType:" + paramInt1 + " errCode:" + paramInt2);
    if (paramq != null)
    {
      if (((paramq instanceof cw)) && (paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = zBc.obtainMessage(zAX);
        paramString.obj = ((cw)paramq).xev;
        paramString.sendToTarget();
      }
      AppMethodBeat.o(178324);
      return;
    }
    AppMethodBeat.o(178324);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/os/Message;", "kotlin.jvm.PlatformType", "handleMessage"})
  static final class b
    implements MMHandler.Callback
  {
    public static final b zBh;
    
    static
    {
      AppMethodBeat.i(178317);
      zBh = new b();
      AppMethodBeat.o(178317);
    }
    
    public final boolean handleMessage(Message paramMessage)
    {
      AppMethodBeat.i(178316);
      int i = paramMessage.what;
      Object localObject1 = au.zBf;
      if (i == au.dKC()) {
        if ((paramMessage.obj instanceof LinkedList))
        {
          paramMessage = paramMessage.obj;
          if (paramMessage == null)
          {
            paramMessage = new kotlin.t("null cannot be cast to non-null type java.util.LinkedList<com.tencent.mm.protocal.protobuf.MarkReadStat>");
            AppMethodBeat.o(178316);
            throw paramMessage;
          }
          paramMessage = ((Iterable)paramMessage).iterator();
          i = 0;
          while (paramMessage.hasNext())
          {
            localObject1 = (cve)paramMessage.next();
            localObject2 = au.zBf;
            Object localObject3;
            StringBuilder localStringBuilder;
            aj localaj;
            if (!au.aj(((cve)localObject1).scene, ((cve)localObject1).xbk))
            {
              i += 1;
              localObject2 = au.zBf;
              au.dKB().add(localObject1);
              localObject2 = au.zBf;
              au.a((cve)localObject1);
              localObject2 = e.AmW;
              localObject2 = e.a.MH(((cve)localObject1).xbk);
              if (localObject2 != null)
              {
                localObject3 = au.zBf;
                localObject3 = au.getTAG();
                localStringBuilder = new StringBuilder("mark read scene:").append(((cve)localObject1).scene).append(" subScene:").append(((cve)localObject1).wGA).append(" commScene:").append(((cve)localObject1).TCM).append(' ').append(com.tencent.mm.ae.d.Fw(((cve)localObject1).xbk)).append(" nickname:").append(((FinderItem)localObject2).getNickName()).append(" desc:");
                localaj = aj.AGc;
                Log.d((String)localObject3, aj.aFM(((FinderItem)localObject2).getDescription()) + " expose:" + ((cve)localObject1).TCN);
              }
              else
              {
                localObject2 = au.zBf;
                Log.d(au.getTAG(), "mark read " + com.tencent.mm.ae.d.Fw(((cve)localObject1).xbk));
              }
            }
            else
            {
              localObject2 = e.AmW;
              localObject2 = e.a.MH(((cve)localObject1).xbk);
              if (localObject2 != null)
              {
                localObject3 = au.zBf;
                localObject3 = au.getTAG();
                localStringBuilder = new StringBuilder("contains read scene:").append(((cve)localObject1).scene).append(" subScene:").append(((cve)localObject1).wGA).append(" commScene:").append(((cve)localObject1).TCM).append(' ').append(com.tencent.mm.ae.d.Fw(((cve)localObject1).xbk)).append(" nickname:").append(((FinderItem)localObject2).getNickName()).append(" desc:");
                localaj = aj.AGc;
                Log.d((String)localObject3, aj.aFM(((FinderItem)localObject2).getDescription()) + " expose:" + ((cve)localObject1).TCN);
              }
              else
              {
                localObject2 = au.zBf;
                Log.d(au.getTAG(), "contains read " + com.tencent.mm.ae.d.Fw(((cve)localObject1).xbk));
              }
            }
          }
          paramMessage = au.zBf;
          int k = au.dKB().size();
          if ((k > 1000) && (1000 <= k))
          {
            int j = 1000;
            for (;;)
            {
              paramMessage = au.zBf;
              au.dKB().removeFirst();
              if (j == k) {
                break;
              }
              j += 1;
            }
          }
          paramMessage = au.zBf;
          paramMessage = au.getTAG();
          localObject1 = new StringBuilder("final add ").append(i).append(' ').append(k).append(' ');
          Object localObject2 = au.zBf;
          Log.i(paramMessage, au.dKB().size());
          paramMessage = au.zBf;
          au.dKJ();
          if (i > 0)
          {
            paramMessage = au.zBf;
            au.dKK();
          }
        }
      }
      for (;;)
      {
        AppMethodBeat.o(178316);
        return false;
        i = paramMessage.what;
        localObject1 = au.zBf;
        if (i == au.dKD())
        {
          paramMessage = au.zBf;
          if (au.dKB().size() > 0)
          {
            au.a(au.zBf);
            paramMessage = au.zBf;
            au.dKL();
          }
        }
        else
        {
          i = paramMessage.what;
          localObject1 = au.zBf;
          if (i == au.dKE())
          {
            if ((paramMessage.obj instanceof LinkedList))
            {
              localObject1 = au.zBf;
              localObject1 = au.dKB();
              paramMessage = paramMessage.obj;
              if (paramMessage == null)
              {
                paramMessage = new kotlin.t("null cannot be cast to non-null type java.util.LinkedList<com.tencent.mm.protocal.protobuf.MarkReadStat>");
                AppMethodBeat.o(178316);
                throw paramMessage;
              }
              ((LinkedList)localObject1).removeAll((Collection)paramMessage);
              paramMessage = au.zBf;
              au.dKJ();
            }
          }
          else
          {
            i = paramMessage.what;
            localObject1 = au.zBf;
            if (i == au.dKF())
            {
              paramMessage = au.zBf;
              au.dKM();
            }
            else
            {
              i = paramMessage.what;
              localObject1 = au.zBf;
              if (i == au.dKG())
              {
                paramMessage = au.zBf;
                au.dKJ();
              }
              else
              {
                i = paramMessage.what;
                paramMessage = au.zBf;
                if (i == au.dKH())
                {
                  au.a(au.zBf);
                  paramMessage = au.zBf;
                  au.m(new HashMap());
                }
              }
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.model.au
 * JD-Core Version:    0.7.0.1
 */
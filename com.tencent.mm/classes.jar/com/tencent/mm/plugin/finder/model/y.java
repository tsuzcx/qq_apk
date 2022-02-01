package com.tencent.mm.plugin.finder.model;

import android.arch.lifecycle.ViewModelProvider;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.n.e;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.cgi.bh;
import com.tencent.mm.plugin.finder.report.i;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.data.d;
import com.tencent.mm.plugin.finder.storage.data.d.a;
import com.tencent.mm.plugin.finder.viewmodel.FinderTabStreamUnreadVM;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.arn;
import com.tencent.mm.protocal.protobuf.byu;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.aq.a;
import com.tencent.mm.ui.component.a;
import d.a.j;
import d.l;
import d.v;
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

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/model/FinderMarkReadLogic;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "ADD", "", "getADD", "()I", "READ", "getREAD", "REMOVE", "getREMOVE", "SAVE", "getSAVE", "SEND", "getSEND", "STOP", "getSTOP", "TAG", "", "getTAG", "()Ljava/lang/String;", "markReadItemList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/MarkReadStat;", "getMarkReadItemList", "()Ljava/util/LinkedList;", "setMarkReadItemList", "(Ljava/util/LinkedList;)V", "startCount", "Ljava/util/concurrent/atomic/AtomicInteger;", "streamMarkReadFeedMap", "Ljava/util/HashMap;", "", "Lcom/tencent/mm/plugin/finder/model/StreamMarkReadStat;", "Lkotlin/collections/HashMap;", "timer", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "addCrossFeedList", "", "acrossFeedList", "", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "addMarReadItemList", "itemList", "containItems", "", "scene", "objectId", "filterTabMarkReadItem", "markReadStat", "getStreamMarkReadList", "tabType", "nextSend", "onFinish", "onSceneEnd", "errType", "errCode", "errMsg", "Lcom/tencent/mm/modelbase/NetSceneBase;", "onStreamCgiBack", "feedList", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "read", "readFromFile", "save", "saveToFile", "send", "startTimer", "stopTimer", "plugin-finder_release"})
public final class y
  implements f
{
  private static final int ADD = 0;
  private static final int STOP = 5;
  private static final String TAG = "Finder.FinderMarkReadLogic";
  private static LinkedList<byu> sto;
  private static final int stp = 1;
  private static final int stq = 2;
  private static final int str = 3;
  private static final int sts = 4;
  private static final aq stt;
  private static AtomicInteger stu;
  private static HashMap<Integer, HashMap<Long, ao>> stv;
  public static final y stw;
  
  static
  {
    AppMethodBeat.i(178325);
    y localy = new y();
    stw = localy;
    TAG = "Finder.FinderMarkReadLogic";
    sto = new LinkedList();
    stp = 1;
    stq = 2;
    str = 3;
    sts = 4;
    STOP = 5;
    com.tencent.mm.kernel.g.ajj().a(3520, (f)localy);
    stt = new aq(TAG, (aq.a)a.stx);
    stu = new AtomicInteger(0);
    stv = new HashMap();
    AppMethodBeat.o(178325);
  }
  
  public static LinkedList<byu> EU(int paramInt)
  {
    int j = 0;
    AppMethodBeat.i(203451);
    LinkedList localLinkedList = new LinkedList();
    switch (paramInt)
    {
    case 2: 
    default: 
      i = 0;
    }
    for (;;)
    {
      localObject2 = (HashMap)stv.get(Integer.valueOf(i));
      if (localObject2 == null) {
        break label347;
      }
      localObject1 = new LinkedList();
      d.g.b.p.g(localObject2, "markReadMap");
      localObject3 = (Map)localObject2;
      localObject2 = (Map)new LinkedHashMap();
      localObject3 = ((Map)localObject3).entrySet().iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localObject4 = (Map.Entry)((Iterator)localObject3).next();
        if (((ao)((Map.Entry)localObject4).getValue()).stB) {
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
    j.sort((List)localObject1);
    Object localObject1 = ((Iterable)localObject1).iterator();
    int i = j;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = ((Iterator)localObject1).next();
      j = i + 1;
      if (i < 0) {
        j.gkd();
      }
      localObject2 = (ao)localObject2;
      if ((i < 20) && (localObject2 != null))
      {
        localObject2 = ((ao)localObject2).stC;
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
      ((Collection)localObject3).add(c.rp(((byu)((Iterator)localObject4).next()).rRn));
    }
    ae.i((String)localObject1, (List)localObject3);
    AppMethodBeat.o(203451);
    return localLinkedList;
  }
  
  public static void a(List<? extends BaseFinderFeed> paramList, arn paramarn)
  {
    AppMethodBeat.i(203452);
    d.g.b.p.h(paramarn, "contextObj");
    Object localObject1 = new LinkedList();
    if (paramList != null)
    {
      localObject2 = ((Iterable)paramList).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        BaseFinderFeed localBaseFinderFeed = (BaseFinderFeed)((Iterator)localObject2).next();
        if (localBaseFinderFeed.lP() != 0L)
        {
          byu localbyu = new byu();
          localbyu.rRn = localBaseFinderFeed.lP();
          switch (paramarn.sch)
          {
          }
          for (;;)
          {
            localbyu.Hlw = paramarn.sch;
            i locali = i.syT;
            localbyu.sessionBuffer = i.I(localBaseFinderFeed.lP(), paramarn.sch);
            ((LinkedList)localObject1).add(localbyu);
            break;
            localbyu.scene = 1;
            localbyu.otZ = 1;
            continue;
            localbyu.scene = 1;
            localbyu.otZ = 2;
            continue;
            localbyu.scene = 1;
            localbyu.otZ = 3;
            continue;
            localbyu.scene = 2;
            continue;
            localbyu.scene = 3;
            continue;
            localbyu.scene = 4;
            continue;
            localbyu.scene = 6;
            localbyu.otZ = 4;
            continue;
            localbyu.scene = 7;
            localbyu.otZ = 4;
            continue;
            if (paramarn.tnf != 34)
            {
              localbyu.scene = 5;
              continue;
              if (paramarn.tnf != 34) {}
            }
            else
            {
              localbyu.scene = 8;
            }
          }
        }
      }
    }
    d.g.b.p.h(localObject1, "itemList");
    ae.i(TAG, "addMarkReadItemList " + ((LinkedList)localObject1).size());
    Object localObject2 = stt.obtainMessage(ADD);
    ((Message)localObject2).obj = localObject1;
    ((Message)localObject2).sendToTarget();
    if ((paramarn.sch == 17) || (paramarn.sch == 18))
    {
      localObject1 = a.KEX;
      ((FinderTabStreamUnreadVM)a.bi(PluginFinder.class).get(FinderTabStreamUnreadVM.class)).k(paramarn.sch, paramList);
    }
    AppMethodBeat.o(203452);
  }
  
  public static boolean ad(int paramInt, long paramLong)
  {
    AppMethodBeat.i(178323);
    Iterator localIterator = ((Iterable)sto).iterator();
    while (localIterator.hasNext())
    {
      byu localbyu = (byu)localIterator.next();
      if ((localbyu.scene == paramInt) && (localbyu.rRn == paramLong))
      {
        AppMethodBeat.o(178323);
        return true;
      }
    }
    AppMethodBeat.o(178323);
    return false;
  }
  
  public static int cEA()
  {
    return stp;
  }
  
  public static int cEB()
  {
    return stq;
  }
  
  public static int cEC()
  {
    return str;
  }
  
  public static int cED()
  {
    return sts;
  }
  
  public static int cEE()
  {
    return STOP;
  }
  
  private static void cEF()
  {
    AppMethodBeat.i(178318);
    stt.removeMessages(stp);
    int i = com.tencent.mm.n.g.acL().getInt("FinderMarkReadReportIntervalSecond", 60);
    stt.sendEmptyMessageDelayed(stp, i * 1000L);
    AppMethodBeat.o(178318);
  }
  
  public static LinkedList<byu> cEy()
  {
    return sto;
  }
  
  public static int cEz()
  {
    return ADD;
  }
  
  public static String getTAG()
  {
    return TAG;
  }
  
  public static void h(int paramInt, List<? extends FinderObject> paramList)
  {
    int j = 0;
    AppMethodBeat.i(203450);
    d.g.b.p.h(paramList, "feedList");
    Object localObject1;
    int i;
    switch (paramInt)
    {
    case 2: 
    default: 
      AppMethodBeat.o(203450);
      return;
    case 3: 
      paramInt = 17;
      localObject1 = (HashMap)stv.get(Integer.valueOf(paramInt));
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
      localObject2 = (HashMap)stv.get(Integer.valueOf(paramInt));
      if (localObject2 != null)
      {
        localObject3 = (ao)((HashMap)localObject2).get(Long.valueOf(((FinderObject)localObject1).id));
        if (localObject3 != null)
        {
          ae.i(TAG, "already in mark read map isRead:" + ((ao)localObject3).stB);
          continue;
          paramInt = 18;
          break;
          paramInt = 20;
          break;
          i = 0;
          break label84;
        }
        d.g.b.p.g(localObject2, "markReadMap");
        ((Map)localObject2).put(Long.valueOf(((FinderObject)localObject1).id), new ao(((FinderObject)localObject1).id));
        continue;
      }
      localObject2 = (Map)stv;
      localObject3 = new HashMap();
      ((HashMap)localObject3).put(Long.valueOf(((FinderObject)localObject1).id), new ao(((FinderObject)localObject1).id));
      ((Map)localObject2).put(Integer.valueOf(paramInt), localObject3);
    }
    label305:
    paramList = (HashMap)stv.get(Integer.valueOf(paramInt));
    if ((paramList != null) && (paramList.size() > 50))
    {
      localObject2 = new LinkedList();
      ((LinkedList)localObject2).addAll(paramList.values());
      j.sort((List)localObject2);
      paramList = (Map)stv;
      localObject1 = new HashMap();
      localObject2 = ((LinkedList)localObject2).subList(0, 50);
      d.g.b.p.g(localObject2, "list.subList(0, 50)");
      localObject2 = ((Iterable)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (ao)((Iterator)localObject2).next();
        ((HashMap)localObject1).put(Long.valueOf(((ao)localObject3).duw), localObject3);
      }
      paramList.put(Integer.valueOf(paramInt), localObject1);
    }
    paramList = (HashMap)stv.get(Integer.valueOf(paramInt));
    paramInt = j;
    if (paramList != null) {
      paramInt = paramList.size();
    }
    ae.i(TAG, "onStreamCgiBack beforeSize:" + i + " afterSize:" + paramInt);
    AppMethodBeat.o(203450);
  }
  
  public static void startTimer()
  {
    AppMethodBeat.i(203449);
    int i = stu.incrementAndGet();
    ae.i(TAG, "start success ".concat(String.valueOf(i)));
    cEF();
    AppMethodBeat.o(203449);
  }
  
  public static void stopTimer()
  {
    AppMethodBeat.i(178322);
    int i = stu.decrementAndGet();
    if (i == 0)
    {
      ae.i(TAG, "really stop");
      stt.removeMessages(stp);
      stt.sendEmptyMessage(STOP);
      AppMethodBeat.o(178322);
      return;
    }
    ae.i(TAG, "not really stop ".concat(String.valueOf(i)));
    AppMethodBeat.o(178322);
  }
  
  public static void sv()
  {
    AppMethodBeat.i(178319);
    stt.sendEmptyMessage(str);
    AppMethodBeat.o(178319);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(178324);
    ae.i(TAG, "onSceneEnd errType:" + paramInt1 + " errCode:" + paramInt2);
    if (paramn != null)
    {
      if (((paramn instanceof bh)) && (paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = stt.obtainMessage(stq);
        paramString.obj = ((bh)paramn).rSv;
        paramString.sendToTarget();
      }
      AppMethodBeat.o(178324);
      return;
    }
    AppMethodBeat.o(178324);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/os/Message;", "kotlin.jvm.PlatformType", "handleMessage"})
  static final class a
    implements aq.a
  {
    public static final a stx;
    
    static
    {
      AppMethodBeat.i(178317);
      stx = new a();
      AppMethodBeat.o(178317);
    }
    
    public final boolean handleMessage(Message paramMessage)
    {
      AppMethodBeat.i(178316);
      int i = paramMessage.what;
      Object localObject1 = y.stw;
      if (i == y.cEz()) {
        if ((paramMessage.obj instanceof LinkedList))
        {
          paramMessage = paramMessage.obj;
          if (paramMessage == null)
          {
            paramMessage = new v("null cannot be cast to non-null type java.util.LinkedList<com.tencent.mm.protocal.protobuf.MarkReadStat>");
            AppMethodBeat.o(178316);
            throw paramMessage;
          }
          paramMessage = ((Iterable)paramMessage).iterator();
          i = 0;
          int j;
          while (paramMessage.hasNext())
          {
            localObject1 = (byu)paramMessage.next();
            localObject2 = y.stw;
            j = i;
            if (!y.ad(((byu)localObject1).scene, ((byu)localObject1).rRn))
            {
              i += 1;
              localObject2 = y.stw;
              y.cEy().add(localObject1);
              localObject2 = y.stw;
              y.a((byu)localObject1);
              localObject2 = d.sKD;
              localObject2 = d.a.xk(((byu)localObject1).rRn);
              if (localObject2 != null)
              {
                Object localObject3 = y.stw;
                localObject3 = y.getTAG();
                localObject1 = new StringBuilder("mark read ").append(c.rp(((byu)localObject1).rRn)).append(" nickname ").append(((FinderItem)localObject2).getNickName()).append(' ');
                com.tencent.mm.plugin.finder.utils.p localp = com.tencent.mm.plugin.finder.utils.p.sXz;
                ae.d((String)localObject3, com.tencent.mm.plugin.finder.utils.p.ajY(((FinderItem)localObject2).getDescription()));
              }
              else
              {
                localObject2 = y.stw;
                ae.d(y.getTAG(), "mark read " + c.rp(((byu)localObject1).rRn));
                j = i;
              }
            }
            else
            {
              i = j;
            }
          }
          paramMessage = y.stw;
          int k = y.cEy().size();
          if ((k > 1000) && (1000 <= k))
          {
            j = 1000;
            for (;;)
            {
              paramMessage = y.stw;
              y.cEy().removeFirst();
              if (j == k) {
                break;
              }
              j += 1;
            }
          }
          paramMessage = y.stw;
          paramMessage = y.getTAG();
          localObject1 = new StringBuilder("final add ").append(i).append(' ').append(k).append(' ');
          Object localObject2 = y.stw;
          ae.i(paramMessage, y.cEy().size());
          paramMessage = y.stw;
          y.cEG();
        }
      }
      for (;;)
      {
        AppMethodBeat.o(178316);
        return false;
        i = paramMessage.what;
        localObject1 = y.stw;
        if (i == y.cEA())
        {
          paramMessage = y.stw;
          if (y.cEy().size() > 0)
          {
            y.a(y.stw);
            paramMessage = y.stw;
            y.cEH();
          }
        }
        else
        {
          i = paramMessage.what;
          localObject1 = y.stw;
          if (i == y.cEB())
          {
            if ((paramMessage.obj instanceof LinkedList))
            {
              localObject1 = y.stw;
              localObject1 = y.cEy();
              paramMessage = paramMessage.obj;
              if (paramMessage == null)
              {
                paramMessage = new v("null cannot be cast to non-null type java.util.LinkedList<com.tencent.mm.protocal.protobuf.MarkReadStat>");
                AppMethodBeat.o(178316);
                throw paramMessage;
              }
              ((LinkedList)localObject1).removeAll((Collection)paramMessage);
              paramMessage = y.stw;
              y.cEG();
            }
          }
          else
          {
            i = paramMessage.what;
            localObject1 = y.stw;
            if (i == y.cEC())
            {
              paramMessage = y.stw;
              y.cEI();
            }
            else
            {
              i = paramMessage.what;
              localObject1 = y.stw;
              if (i == y.cED())
              {
                paramMessage = y.stw;
                y.cEG();
              }
              else
              {
                i = paramMessage.what;
                paramMessage = y.stw;
                if (i == y.cEE())
                {
                  y.a(y.stw);
                  paramMessage = y.stw;
                  y.j(new HashMap());
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
 * Qualified Name:     com.tencent.mm.plugin.finder.model.y
 * JD-Core Version:    0.7.0.1
 */
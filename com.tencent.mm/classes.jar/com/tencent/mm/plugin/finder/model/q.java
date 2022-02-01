package com.tencent.mm.plugin.finder.model;

import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.m.e;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.data.b;
import com.tencent.mm.plugin.finder.storage.data.b.a;
import com.tencent.mm.plugin.finder.utils.i;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.bow;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.ap.a;
import d.a.j;
import d.g.b.k;
import d.l;
import d.v;
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

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/model/FinderMarkReadLogic;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "ADD", "", "getADD", "()I", "READ", "getREAD", "REMOVE", "getREMOVE", "SAVE", "getSAVE", "SEND", "getSEND", "STOP", "getSTOP", "TAG", "", "getTAG", "()Ljava/lang/String;", "markReadItemList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/MarkReadStat;", "getMarkReadItemList", "()Ljava/util/LinkedList;", "setMarkReadItemList", "(Ljava/util/LinkedList;)V", "startCount", "Ljava/util/concurrent/atomic/AtomicInteger;", "streamMarkReadFeedMap", "Ljava/util/HashMap;", "", "Lcom/tencent/mm/plugin/finder/model/StreamMarkReadStat;", "Lkotlin/collections/HashMap;", "timer", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "addCrossFeedList", "", "acrossFeedList", "", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "commentScene", "addMarReadItemList", "itemList", "containItems", "", "scene", "objectId", "filterTabMarkReadItem", "markReadStat", "getStreamMarkReadList", "tabType", "nextSend", "onFinish", "onSceneEnd", "errType", "errCode", "errMsg", "Lcom/tencent/mm/modelbase/NetSceneBase;", "onStreamCgiBack", "feedList", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "read", "readFromFile", "save", "saveToFile", "send", "startTimer", "stopTimer", "plugin-finder_release"})
public final class q
  implements com.tencent.mm.al.g
{
  private static final int ADD = 0;
  private static HashMap<Integer, HashMap<Long, af>> KTt;
  private static final int STOP = 5;
  private static final String TAG = "Finder.FinderMarkReadLogic";
  private static LinkedList<bow> qDH;
  private static final int qDI = 1;
  private static final int qDJ = 2;
  private static final int qDK = 3;
  private static final int qDL = 4;
  private static final ap qDM;
  private static AtomicInteger qDN;
  public static final q qDO;
  
  static
  {
    AppMethodBeat.i(178325);
    q localq = new q();
    qDO = localq;
    TAG = "Finder.FinderMarkReadLogic";
    qDH = new LinkedList();
    qDI = 1;
    qDJ = 2;
    qDK = 3;
    qDL = 4;
    STOP = 5;
    com.tencent.mm.kernel.g.aeS().a(3520, (com.tencent.mm.al.g)localq);
    qDM = new ap(TAG, (ap.a)a.qDP);
    qDN = new AtomicInteger(0);
    KTt = new HashMap();
    AppMethodBeat.o(178325);
  }
  
  public static boolean ac(int paramInt, long paramLong)
  {
    AppMethodBeat.i(178323);
    Iterator localIterator = ((Iterable)qDH).iterator();
    while (localIterator.hasNext())
    {
      bow localbow = (bow)localIterator.next();
      if ((localbow.scene == paramInt) && (localbow.objectId == paramLong))
      {
        AppMethodBeat.o(178323);
        return true;
      }
    }
    AppMethodBeat.o(178323);
    return false;
  }
  
  public static LinkedList<bow> ahm(int paramInt)
  {
    int j = 0;
    AppMethodBeat.i(198639);
    LinkedList localLinkedList = new LinkedList();
    switch (paramInt)
    {
    case 2: 
    default: 
      i = 0;
    }
    for (;;)
    {
      localObject2 = (HashMap)KTt.get(Integer.valueOf(i));
      if (localObject2 == null) {
        break label338;
      }
      localObject1 = new LinkedList();
      k.g(localObject2, "markReadMap");
      Object localObject3 = (Map)localObject2;
      localObject2 = (Map)new LinkedHashMap();
      localObject3 = ((Map)localObject3).entrySet().iterator();
      while (((Iterator)localObject3).hasNext())
      {
        Map.Entry localEntry = (Map.Entry)((Iterator)localObject3).next();
        if (((af)localEntry.getValue()).KTu) {
          ((Map)localObject2).put(localEntry.getKey(), localEntry.getValue());
        }
      }
      i = 17;
      continue;
      i = 18;
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
        j.fvx();
      }
      localObject2 = (af)localObject2;
      if ((i < 20) && (localObject2 != null))
      {
        localObject2 = ((af)localObject2).KTv;
        if (localObject2 != null)
        {
          localLinkedList.add(localObject2);
          i = j;
          continue;
        }
      }
      i = j;
    }
    label338:
    ad.i(TAG, "getStreamMarkReadList " + paramInt + ' ' + localLinkedList.size());
    AppMethodBeat.o(198639);
    return localLinkedList;
  }
  
  public static LinkedList<bow> cna()
  {
    return qDH;
  }
  
  public static int cnb()
  {
    return ADD;
  }
  
  public static int cnc()
  {
    return qDI;
  }
  
  public static int cnd()
  {
    return qDJ;
  }
  
  public static int cne()
  {
    return qDK;
  }
  
  public static int cnf()
  {
    return qDL;
  }
  
  public static int cng()
  {
    return STOP;
  }
  
  private static void cnh()
  {
    AppMethodBeat.i(178318);
    qDM.removeMessages(qDI);
    int i = com.tencent.mm.m.g.Zd().getInt("FinderMarkReadReportIntervalSecond", 60);
    qDM.sendEmptyMessageDelayed(qDI, i * 1000L);
    AppMethodBeat.o(178318);
  }
  
  public static String getTAG()
  {
    return TAG;
  }
  
  public static void n(List<? extends BaseFinderFeed> paramList, int paramInt)
  {
    AppMethodBeat.i(198640);
    LinkedList localLinkedList = new LinkedList();
    if (paramList != null)
    {
      paramList = ((Iterable)paramList).iterator();
      while (paramList.hasNext())
      {
        BaseFinderFeed localBaseFinderFeed = (BaseFinderFeed)paramList.next();
        if (localBaseFinderFeed.bMs() != 0L)
        {
          bow localbow = new bow();
          localbow.objectId = localBaseFinderFeed.bMs();
          switch (paramInt)
          {
          }
          for (;;)
          {
            localbow.LzO = paramInt;
            localLinkedList.add(localbow);
            break;
            localbow.scene = 1;
            localbow.niJ = 1;
            continue;
            localbow.scene = 1;
            localbow.niJ = 2;
            continue;
            localbow.scene = 1;
            localbow.niJ = 3;
            continue;
            localbow.scene = 2;
            continue;
            localbow.scene = 3;
            continue;
            localbow.scene = 4;
            continue;
            localbow.scene = 5;
            continue;
            localbow.scene = 6;
            localbow.niJ = 4;
            continue;
            localbow.scene = 7;
            localbow.niJ = 4;
          }
        }
      }
    }
    k.h(localLinkedList, "itemList");
    ad.i(TAG, "addMarkReadItemList " + localLinkedList.size());
    paramList = qDM.obtainMessage(ADD);
    paramList.obj = localLinkedList;
    paramList.sendToTarget();
    AppMethodBeat.o(198640);
  }
  
  public static void p(int paramInt, List<? extends FinderObject> paramList)
  {
    int j = 0;
    AppMethodBeat.i(198638);
    k.h(paramList, "feedList");
    Object localObject1;
    int i;
    switch (paramInt)
    {
    case 2: 
    default: 
      AppMethodBeat.o(198638);
      return;
    case 3: 
      paramInt = 17;
      localObject1 = (HashMap)KTt.get(Integer.valueOf(paramInt));
      if (localObject1 != null)
      {
        i = ((HashMap)localObject1).size();
        label80:
        paramList = ((Iterable)paramList).iterator();
      }
      break;
    }
    Object localObject2;
    Object localObject3;
    for (;;)
    {
      if (!paramList.hasNext()) {
        break label296;
      }
      localObject1 = (FinderObject)paramList.next();
      localObject2 = (HashMap)KTt.get(Integer.valueOf(paramInt));
      if (localObject2 != null)
      {
        localObject3 = (af)((HashMap)localObject2).get(Long.valueOf(((FinderObject)localObject1).id));
        if (localObject3 != null)
        {
          ad.i(TAG, "already in mark read map isRead:" + ((af)localObject3).KTu);
          continue;
          paramInt = 18;
          break;
          i = 0;
          break label80;
        }
        k.g(localObject2, "markReadMap");
        ((Map)localObject2).put(Long.valueOf(((FinderObject)localObject1).id), new af(((FinderObject)localObject1).id));
        continue;
      }
      localObject2 = (Map)KTt;
      localObject3 = new HashMap();
      ((HashMap)localObject3).put(Long.valueOf(((FinderObject)localObject1).id), new af(((FinderObject)localObject1).id));
      ((Map)localObject2).put(Integer.valueOf(paramInt), localObject3);
    }
    label296:
    paramList = (HashMap)KTt.get(Integer.valueOf(paramInt));
    if ((paramList != null) && (paramList.size() > 50))
    {
      localObject2 = new LinkedList();
      ((LinkedList)localObject2).addAll(paramList.values());
      j.sort((List)localObject2);
      paramList = (Map)KTt;
      localObject1 = new HashMap();
      localObject2 = ((LinkedList)localObject2).subList(0, 50);
      k.g(localObject2, "list.subList(0, 50)");
      localObject2 = ((Iterable)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (af)((Iterator)localObject2).next();
        ((HashMap)localObject1).put(Long.valueOf(((af)localObject3).feedId), localObject3);
      }
      paramList.put(Integer.valueOf(paramInt), localObject1);
    }
    paramList = (HashMap)KTt.get(Integer.valueOf(paramInt));
    paramInt = j;
    if (paramList != null) {
      paramInt = paramList.size();
    }
    ad.i(TAG, "onStreamCgiBack beforeSize:" + i + " afterSize:" + paramInt);
    AppMethodBeat.o(198638);
  }
  
  public static void qN()
  {
    AppMethodBeat.i(178319);
    qDM.sendEmptyMessage(qDK);
    AppMethodBeat.o(178319);
  }
  
  public static void startTimer()
  {
    AppMethodBeat.i(198637);
    int i = qDN.incrementAndGet();
    ad.i(TAG, "start success ".concat(String.valueOf(i)));
    cnh();
    AppMethodBeat.o(198637);
  }
  
  public static void stopTimer()
  {
    AppMethodBeat.i(178322);
    int i = qDN.decrementAndGet();
    if (i == 0)
    {
      ad.i(TAG, "really stop");
      qDM.removeMessages(qDI);
      qDM.sendEmptyMessage(STOP);
      AppMethodBeat.o(178322);
      return;
    }
    ad.i(TAG, "not really stop ".concat(String.valueOf(i)));
    AppMethodBeat.o(178322);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(178324);
    ad.i(TAG, "onSceneEnd errType:" + paramInt1 + " errCode:" + paramInt2);
    if (paramn != null)
    {
      if (((paramn instanceof com.tencent.mm.plugin.finder.cgi.af)) && (paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = qDM.obtainMessage(qDJ);
        paramString.obj = ((com.tencent.mm.plugin.finder.cgi.af)paramn).qpM;
        paramString.sendToTarget();
      }
      AppMethodBeat.o(178324);
      return;
    }
    AppMethodBeat.o(178324);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/os/Message;", "kotlin.jvm.PlatformType", "handleMessage"})
  static final class a
    implements ap.a
  {
    public static final a qDP;
    
    static
    {
      AppMethodBeat.i(178317);
      qDP = new a();
      AppMethodBeat.o(178317);
    }
    
    public final boolean handleMessage(Message paramMessage)
    {
      AppMethodBeat.i(178316);
      int i = paramMessage.what;
      Object localObject1 = q.qDO;
      if (i == q.cnb()) {
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
            localObject1 = (bow)paramMessage.next();
            localObject2 = q.qDO;
            j = i;
            if (!q.ac(((bow)localObject1).scene, ((bow)localObject1).objectId))
            {
              i += 1;
              localObject2 = q.qDO;
              q.cna().add(localObject1);
              localObject2 = q.qDO;
              q.a((bow)localObject1);
              j = i;
              if (com.tencent.mm.util.c.fgW())
              {
                localObject2 = b.qKl;
                localObject2 = b.a.qC(((bow)localObject1).objectId);
                j = i;
                if (localObject2 != null)
                {
                  Object localObject3 = q.qDO;
                  localObject3 = q.getTAG();
                  localObject1 = new StringBuilder("mark read ").append(com.tencent.mm.ad.c.ly(((bow)localObject1).objectId)).append(' ');
                  i locali = i.qTa;
                  ad.i((String)localObject3, i.ZV(((FinderItem)localObject2).getDescription()));
                  continue;
                }
              }
            }
            i = j;
          }
          paramMessage = q.qDO;
          int k = q.cna().size();
          if ((k > 1000) && (1000 <= k))
          {
            j = 1000;
            for (;;)
            {
              paramMessage = q.qDO;
              q.cna().removeFirst();
              if (j == k) {
                break;
              }
              j += 1;
            }
          }
          paramMessage = q.qDO;
          paramMessage = q.getTAG();
          localObject1 = new StringBuilder("final add ").append(i).append(' ').append(k).append(' ');
          Object localObject2 = q.qDO;
          ad.i(paramMessage, q.cna().size());
          paramMessage = q.qDO;
          q.cni();
        }
      }
      for (;;)
      {
        AppMethodBeat.o(178316);
        return false;
        i = paramMessage.what;
        localObject1 = q.qDO;
        if (i == q.cnc())
        {
          paramMessage = q.qDO;
          if (q.cna().size() > 0)
          {
            q.a(q.qDO);
            paramMessage = q.qDO;
            q.cnj();
          }
        }
        else
        {
          i = paramMessage.what;
          localObject1 = q.qDO;
          if (i == q.cnd())
          {
            if ((paramMessage.obj instanceof LinkedList))
            {
              localObject1 = q.qDO;
              localObject1 = q.cna();
              paramMessage = paramMessage.obj;
              if (paramMessage == null)
              {
                paramMessage = new v("null cannot be cast to non-null type java.util.LinkedList<com.tencent.mm.protocal.protobuf.MarkReadStat>");
                AppMethodBeat.o(178316);
                throw paramMessage;
              }
              ((LinkedList)localObject1).removeAll((Collection)paramMessage);
              paramMessage = q.qDO;
              q.cni();
            }
          }
          else
          {
            i = paramMessage.what;
            localObject1 = q.qDO;
            if (i == q.cne())
            {
              paramMessage = q.qDO;
              q.cnk();
            }
            else
            {
              i = paramMessage.what;
              localObject1 = q.qDO;
              if (i == q.cnf())
              {
                paramMessage = q.qDO;
                q.cni();
              }
              else
              {
                i = paramMessage.what;
                paramMessage = q.qDO;
                if (i == q.cng())
                {
                  q.a(q.qDO);
                  paramMessage = q.qDO;
                  q.q(new HashMap());
                }
              }
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.model.q
 * JD-Core Version:    0.7.0.1
 */
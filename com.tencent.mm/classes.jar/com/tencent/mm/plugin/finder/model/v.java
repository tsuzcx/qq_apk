package com.tencent.mm.plugin.finder.model;

import android.arch.lifecycle.ViewModelProvider;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.c;
import com.tencent.mm.ak.q;
import com.tencent.mm.m.e;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.cgi.ay;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.data.d.a;
import com.tencent.mm.plugin.finder.viewmodel.FinderTabStreamUnreadVM;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.anm;
import com.tencent.mm.protocal.protobuf.btm;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.ao.a;
import com.tencent.mm.ui.component.a;
import d.a.j;
import d.g.b.k;
import d.l;
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

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/model/FinderMarkReadLogic;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "ADD", "", "getADD", "()I", "READ", "getREAD", "REMOVE", "getREMOVE", "SAVE", "getSAVE", "SEND", "getSEND", "STOP", "getSTOP", "TAG", "", "getTAG", "()Ljava/lang/String;", "markReadItemList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/MarkReadStat;", "getMarkReadItemList", "()Ljava/util/LinkedList;", "setMarkReadItemList", "(Ljava/util/LinkedList;)V", "startCount", "Ljava/util/concurrent/atomic/AtomicInteger;", "streamMarkReadFeedMap", "Ljava/util/HashMap;", "", "Lcom/tencent/mm/plugin/finder/model/StreamMarkReadStat;", "Lkotlin/collections/HashMap;", "timer", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "addCrossFeedList", "", "acrossFeedList", "", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "addMarReadItemList", "itemList", "containItems", "", "scene", "objectId", "filterTabMarkReadItem", "markReadStat", "getStreamMarkReadList", "tabType", "nextSend", "onFinish", "onSceneEnd", "errType", "errCode", "errMsg", "Lcom/tencent/mm/modelbase/NetSceneBase;", "onStreamCgiBack", "feedList", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "read", "readFromFile", "save", "saveToFile", "send", "startTimer", "stopTimer", "plugin-finder_release"})
public final class v
  implements com.tencent.mm.ak.g
{
  private static final int ADD = 0;
  private static final int STOP = 5;
  private static final String TAG = "Finder.FinderMarkReadLogic";
  private static LinkedList<btm> ruW;
  private static final int ruX = 1;
  private static final int ruY = 2;
  private static final int ruZ = 3;
  private static final int rva = 4;
  private static final ao rvb;
  private static AtomicInteger rvc;
  private static HashMap<Integer, HashMap<Long, af>> rvd;
  public static final v rve;
  
  static
  {
    AppMethodBeat.i(178325);
    v localv = new v();
    rve = localv;
    TAG = "Finder.FinderMarkReadLogic";
    ruW = new LinkedList();
    ruX = 1;
    ruY = 2;
    ruZ = 3;
    rva = 4;
    STOP = 5;
    com.tencent.mm.kernel.g.agi().a(3520, (com.tencent.mm.ak.g)localv);
    rvb = new ao(TAG, (ao.a)a.rvf);
    rvc = new AtomicInteger(0);
    rvd = new HashMap();
    AppMethodBeat.o(178325);
  }
  
  public static LinkedList<btm> DN(int paramInt)
  {
    int j = 0;
    AppMethodBeat.i(202566);
    LinkedList localLinkedList = new LinkedList();
    switch (paramInt)
    {
    case 2: 
    default: 
      i = 0;
    }
    for (;;)
    {
      localObject2 = (HashMap)rvd.get(Integer.valueOf(i));
      if (localObject2 == null) {
        break label347;
      }
      localObject1 = new LinkedList();
      k.g(localObject2, "markReadMap");
      localObject3 = (Map)localObject2;
      localObject2 = (Map)new LinkedHashMap();
      localObject3 = ((Map)localObject3).entrySet().iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localObject4 = (Map.Entry)((Iterator)localObject3).next();
        if (((af)((Map.Entry)localObject4).getValue()).rvi) {
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
        j.fOc();
      }
      localObject2 = (af)localObject2;
      if ((i < 20) && (localObject2 != null))
      {
        localObject2 = ((af)localObject2).rvj;
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
      ((Collection)localObject3).add(c.pb(((btm)((Iterator)localObject4).next()).qXP));
    }
    ac.i((String)localObject1, (List)localObject3);
    AppMethodBeat.o(202566);
    return localLinkedList;
  }
  
  public static void a(List<? extends BaseFinderFeed> paramList, anm paramanm)
  {
    AppMethodBeat.i(202567);
    k.h(paramanm, "contextObj");
    Object localObject1 = new LinkedList();
    if (paramList != null)
    {
      localObject2 = ((Iterable)paramList).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        BaseFinderFeed localBaseFinderFeed = (BaseFinderFeed)((Iterator)localObject2).next();
        if (localBaseFinderFeed.lx() != 0L)
        {
          btm localbtm = new btm();
          localbtm.qXP = localBaseFinderFeed.lx();
          switch (paramanm.rfR)
          {
          }
          for (;;)
          {
            localbtm.Fiu = paramanm.rfR;
            com.tencent.mm.plugin.finder.report.d locald = com.tencent.mm.plugin.finder.report.d.rxr;
            localbtm.sessionBuffer = com.tencent.mm.plugin.finder.report.d.G(localBaseFinderFeed.lx(), paramanm.rfR);
            ((LinkedList)localObject1).add(localbtm);
            break;
            localbtm.scene = 1;
            localbtm.nLC = 1;
            continue;
            localbtm.scene = 1;
            localbtm.nLC = 2;
            continue;
            localbtm.scene = 1;
            localbtm.nLC = 3;
            continue;
            localbtm.scene = 2;
            continue;
            localbtm.scene = 3;
            continue;
            localbtm.scene = 4;
            continue;
            localbtm.scene = 6;
            localbtm.nLC = 4;
            continue;
            localbtm.scene = 7;
            localbtm.nLC = 4;
            continue;
            if (paramanm.seo != 34)
            {
              localbtm.scene = 5;
              continue;
              if (paramanm.seo != 34) {}
            }
            else
            {
              localbtm.scene = 8;
            }
          }
        }
      }
    }
    k.h(localObject1, "itemList");
    ac.i(TAG, "addMarkReadItemList " + ((LinkedList)localObject1).size());
    Object localObject2 = rvb.obtainMessage(ADD);
    ((Message)localObject2).obj = localObject1;
    ((Message)localObject2).sendToTarget();
    if ((paramanm.rfR == 17) || (paramanm.rfR == 18))
    {
      localObject1 = a.IrY;
      ((FinderTabStreamUnreadVM)a.bg(PluginFinder.class).get(FinderTabStreamUnreadVM.class)).i(paramanm.rfR, paramList);
    }
    AppMethodBeat.o(202567);
  }
  
  public static boolean ab(int paramInt, long paramLong)
  {
    AppMethodBeat.i(178323);
    Iterator localIterator = ((Iterable)ruW).iterator();
    while (localIterator.hasNext())
    {
      btm localbtm = (btm)localIterator.next();
      if ((localbtm.scene == paramInt) && (localbtm.qXP == paramLong))
      {
        AppMethodBeat.o(178323);
        return true;
      }
    }
    AppMethodBeat.o(178323);
    return false;
  }
  
  public static int cwA()
  {
    return rva;
  }
  
  public static int cwB()
  {
    return STOP;
  }
  
  private static void cwC()
  {
    AppMethodBeat.i(178318);
    rvb.removeMessages(ruX);
    int i = com.tencent.mm.m.g.ZY().getInt("FinderMarkReadReportIntervalSecond", 60);
    rvb.sendEmptyMessageDelayed(ruX, i * 1000L);
    AppMethodBeat.o(178318);
  }
  
  public static LinkedList<btm> cwv()
  {
    return ruW;
  }
  
  public static int cww()
  {
    return ADD;
  }
  
  public static int cwx()
  {
    return ruX;
  }
  
  public static int cwy()
  {
    return ruY;
  }
  
  public static int cwz()
  {
    return ruZ;
  }
  
  public static String getTAG()
  {
    return TAG;
  }
  
  public static void h(int paramInt, List<? extends FinderObject> paramList)
  {
    int j = 0;
    AppMethodBeat.i(202565);
    k.h(paramList, "feedList");
    Object localObject1;
    int i;
    switch (paramInt)
    {
    case 2: 
    default: 
      AppMethodBeat.o(202565);
      return;
    case 3: 
      paramInt = 17;
      localObject1 = (HashMap)rvd.get(Integer.valueOf(paramInt));
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
      localObject2 = (HashMap)rvd.get(Integer.valueOf(paramInt));
      if (localObject2 != null)
      {
        localObject3 = (af)((HashMap)localObject2).get(Long.valueOf(((FinderObject)localObject1).id));
        if (localObject3 != null)
        {
          ac.i(TAG, "already in mark read map isRead:" + ((af)localObject3).rvi);
          continue;
          paramInt = 18;
          break;
          paramInt = 20;
          break;
          i = 0;
          break label84;
        }
        k.g(localObject2, "markReadMap");
        ((Map)localObject2).put(Long.valueOf(((FinderObject)localObject1).id), new af(((FinderObject)localObject1).id));
        continue;
      }
      localObject2 = (Map)rvd;
      localObject3 = new HashMap();
      ((HashMap)localObject3).put(Long.valueOf(((FinderObject)localObject1).id), new af(((FinderObject)localObject1).id));
      ((Map)localObject2).put(Integer.valueOf(paramInt), localObject3);
    }
    label305:
    paramList = (HashMap)rvd.get(Integer.valueOf(paramInt));
    if ((paramList != null) && (paramList.size() > 50))
    {
      localObject2 = new LinkedList();
      ((LinkedList)localObject2).addAll(paramList.values());
      j.sort((List)localObject2);
      paramList = (Map)rvd;
      localObject1 = new HashMap();
      localObject2 = ((LinkedList)localObject2).subList(0, 50);
      k.g(localObject2, "list.subList(0, 50)");
      localObject2 = ((Iterable)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (af)((Iterator)localObject2).next();
        ((HashMap)localObject1).put(Long.valueOf(((af)localObject3).dig), localObject3);
      }
      paramList.put(Integer.valueOf(paramInt), localObject1);
    }
    paramList = (HashMap)rvd.get(Integer.valueOf(paramInt));
    paramInt = j;
    if (paramList != null) {
      paramInt = paramList.size();
    }
    ac.i(TAG, "onStreamCgiBack beforeSize:" + i + " afterSize:" + paramInt);
    AppMethodBeat.o(202565);
  }
  
  public static void qX()
  {
    AppMethodBeat.i(178319);
    rvb.sendEmptyMessage(ruZ);
    AppMethodBeat.o(178319);
  }
  
  public static void startTimer()
  {
    AppMethodBeat.i(202564);
    int i = rvc.incrementAndGet();
    ac.i(TAG, "start success ".concat(String.valueOf(i)));
    cwC();
    AppMethodBeat.o(202564);
  }
  
  public static void stopTimer()
  {
    AppMethodBeat.i(178322);
    int i = rvc.decrementAndGet();
    if (i == 0)
    {
      ac.i(TAG, "really stop");
      rvb.removeMessages(ruX);
      rvb.sendEmptyMessage(STOP);
      AppMethodBeat.o(178322);
      return;
    }
    ac.i(TAG, "not really stop ".concat(String.valueOf(i)));
    AppMethodBeat.o(178322);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.n paramn)
  {
    AppMethodBeat.i(178324);
    ac.i(TAG, "onSceneEnd errType:" + paramInt1 + " errCode:" + paramInt2);
    if (paramn != null)
    {
      if (((paramn instanceof ay)) && (paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = rvb.obtainMessage(ruY);
        paramString.obj = ((ay)paramn).qYS;
        paramString.sendToTarget();
      }
      AppMethodBeat.o(178324);
      return;
    }
    AppMethodBeat.o(178324);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/os/Message;", "kotlin.jvm.PlatformType", "handleMessage"})
  static final class a
    implements ao.a
  {
    public static final a rvf;
    
    static
    {
      AppMethodBeat.i(178317);
      rvf = new a();
      AppMethodBeat.o(178317);
    }
    
    public final boolean handleMessage(Message paramMessage)
    {
      AppMethodBeat.i(178316);
      int i = paramMessage.what;
      Object localObject1 = v.rve;
      if (i == v.cww()) {
        if ((paramMessage.obj instanceof LinkedList))
        {
          paramMessage = paramMessage.obj;
          if (paramMessage == null)
          {
            paramMessage = new d.v("null cannot be cast to non-null type java.util.LinkedList<com.tencent.mm.protocal.protobuf.MarkReadStat>");
            AppMethodBeat.o(178316);
            throw paramMessage;
          }
          paramMessage = ((Iterable)paramMessage).iterator();
          i = 0;
          int j;
          while (paramMessage.hasNext())
          {
            localObject1 = (btm)paramMessage.next();
            localObject2 = v.rve;
            j = i;
            if (!v.ab(((btm)localObject1).scene, ((btm)localObject1).qXP))
            {
              i += 1;
              localObject2 = v.rve;
              v.cwv().add(localObject1);
              localObject2 = v.rve;
              v.a((btm)localObject1);
              localObject2 = com.tencent.mm.plugin.finder.storage.data.d.rEF;
              localObject2 = d.a.uS(((btm)localObject1).qXP);
              if (localObject2 != null)
              {
                Object localObject3 = v.rve;
                localObject3 = v.getTAG();
                localObject1 = new StringBuilder("mark read ").append(c.pb(((btm)localObject1).qXP)).append(' ');
                com.tencent.mm.plugin.finder.utils.n localn = com.tencent.mm.plugin.finder.utils.n.rPN;
                ac.d((String)localObject3, com.tencent.mm.plugin.finder.utils.n.aeH(((FinderItem)localObject2).getDescription()));
              }
              else
              {
                localObject2 = v.rve;
                ac.d(v.getTAG(), "mark read " + c.pb(((btm)localObject1).qXP));
                j = i;
              }
            }
            else
            {
              i = j;
            }
          }
          paramMessage = v.rve;
          int k = v.cwv().size();
          if ((k > 1000) && (1000 <= k))
          {
            j = 1000;
            for (;;)
            {
              paramMessage = v.rve;
              v.cwv().removeFirst();
              if (j == k) {
                break;
              }
              j += 1;
            }
          }
          paramMessage = v.rve;
          paramMessage = v.getTAG();
          localObject1 = new StringBuilder("final add ").append(i).append(' ').append(k).append(' ');
          Object localObject2 = v.rve;
          ac.i(paramMessage, v.cwv().size());
          paramMessage = v.rve;
          v.cwD();
        }
      }
      for (;;)
      {
        AppMethodBeat.o(178316);
        return false;
        i = paramMessage.what;
        localObject1 = v.rve;
        if (i == v.cwx())
        {
          paramMessage = v.rve;
          if (v.cwv().size() > 0)
          {
            v.a(v.rve);
            paramMessage = v.rve;
            v.cwE();
          }
        }
        else
        {
          i = paramMessage.what;
          localObject1 = v.rve;
          if (i == v.cwy())
          {
            if ((paramMessage.obj instanceof LinkedList))
            {
              localObject1 = v.rve;
              localObject1 = v.cwv();
              paramMessage = paramMessage.obj;
              if (paramMessage == null)
              {
                paramMessage = new d.v("null cannot be cast to non-null type java.util.LinkedList<com.tencent.mm.protocal.protobuf.MarkReadStat>");
                AppMethodBeat.o(178316);
                throw paramMessage;
              }
              ((LinkedList)localObject1).removeAll((Collection)paramMessage);
              paramMessage = v.rve;
              v.cwD();
            }
          }
          else
          {
            i = paramMessage.what;
            localObject1 = v.rve;
            if (i == v.cwz())
            {
              paramMessage = v.rve;
              v.cwF();
            }
            else
            {
              i = paramMessage.what;
              localObject1 = v.rve;
              if (i == v.cwA())
              {
                paramMessage = v.rve;
                v.cwD();
              }
              else
              {
                i = paramMessage.what;
                paramMessage = v.rve;
                if (i == v.cwB())
                {
                  v.a(v.rve);
                  paramMessage = v.rve;
                  v.i(new HashMap());
                }
              }
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.model.v
 * JD-Core Version:    0.7.0.1
 */
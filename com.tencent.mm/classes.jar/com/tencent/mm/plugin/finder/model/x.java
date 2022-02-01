package com.tencent.mm.plugin.finder.model;

import android.arch.lifecycle.ViewModelProvider;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ad.c;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.n.e;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.cgi.bg;
import com.tencent.mm.plugin.finder.report.h;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.data.d;
import com.tencent.mm.plugin.finder.storage.data.d.a;
import com.tencent.mm.plugin.finder.viewmodel.FinderTabStreamUnreadVM;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.aqy;
import com.tencent.mm.protocal.protobuf.bya;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.ap.a;
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

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/model/FinderMarkReadLogic;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "ADD", "", "getADD", "()I", "READ", "getREAD", "REMOVE", "getREMOVE", "SAVE", "getSAVE", "SEND", "getSEND", "STOP", "getSTOP", "TAG", "", "getTAG", "()Ljava/lang/String;", "markReadItemList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/MarkReadStat;", "getMarkReadItemList", "()Ljava/util/LinkedList;", "setMarkReadItemList", "(Ljava/util/LinkedList;)V", "startCount", "Ljava/util/concurrent/atomic/AtomicInteger;", "streamMarkReadFeedMap", "Ljava/util/HashMap;", "", "Lcom/tencent/mm/plugin/finder/model/StreamMarkReadStat;", "Lkotlin/collections/HashMap;", "timer", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "addCrossFeedList", "", "acrossFeedList", "", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "addMarReadItemList", "itemList", "containItems", "", "scene", "objectId", "filterTabMarkReadItem", "markReadStat", "getStreamMarkReadList", "tabType", "nextSend", "onFinish", "onSceneEnd", "errType", "errCode", "errMsg", "Lcom/tencent/mm/modelbase/NetSceneBase;", "onStreamCgiBack", "feedList", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "read", "readFromFile", "save", "saveToFile", "send", "startTimer", "stopTimer", "plugin-finder_release"})
public final class x
  implements f
{
  private static final int ADD = 0;
  private static final int STOP = 5;
  private static final String TAG = "Finder.FinderMarkReadLogic";
  private static LinkedList<bya> skr;
  private static final int sks = 1;
  private static final int skt = 2;
  private static final int sku = 3;
  private static final int skv = 4;
  private static final ap skw;
  private static AtomicInteger skx;
  private static HashMap<Integer, HashMap<Long, an>> sky;
  public static final x skz;
  
  static
  {
    AppMethodBeat.i(178325);
    x localx = new x();
    skz = localx;
    TAG = "Finder.FinderMarkReadLogic";
    skr = new LinkedList();
    sks = 1;
    skt = 2;
    sku = 3;
    skv = 4;
    STOP = 5;
    com.tencent.mm.kernel.g.aiU().a(3520, (f)localx);
    skw = new ap(TAG, (ap.a)a.skA);
    skx = new AtomicInteger(0);
    sky = new HashMap();
    AppMethodBeat.o(178325);
  }
  
  public static LinkedList<bya> EH(int paramInt)
  {
    int j = 0;
    AppMethodBeat.i(202967);
    LinkedList localLinkedList = new LinkedList();
    switch (paramInt)
    {
    case 2: 
    default: 
      i = 0;
    }
    for (;;)
    {
      localObject2 = (HashMap)sky.get(Integer.valueOf(i));
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
        if (((an)((Map.Entry)localObject4).getValue()).skE) {
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
        j.gfB();
      }
      localObject2 = (an)localObject2;
      if ((i < 20) && (localObject2 != null))
      {
        localObject2 = ((an)localObject2).skF;
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
      ((Collection)localObject3).add(c.rc(((bya)((Iterator)localObject4).next()).rIZ));
    }
    ad.i((String)localObject1, (List)localObject3);
    AppMethodBeat.o(202967);
    return localLinkedList;
  }
  
  public static void a(List<? extends BaseFinderFeed> paramList, aqy paramaqy)
  {
    AppMethodBeat.i(202968);
    d.g.b.p.h(paramaqy, "contextObj");
    Object localObject1 = new LinkedList();
    if (paramList != null)
    {
      localObject2 = ((Iterable)paramList).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        BaseFinderFeed localBaseFinderFeed = (BaseFinderFeed)((Iterator)localObject2).next();
        if (localBaseFinderFeed.lP() != 0L)
        {
          bya localbya = new bya();
          localbya.rIZ = localBaseFinderFeed.lP();
          switch (paramaqy.rTD)
          {
          }
          for (;;)
          {
            localbya.GRV = paramaqy.rTD;
            h localh = h.soM;
            localbya.sessionBuffer = h.I(localBaseFinderFeed.lP(), paramaqy.rTD);
            ((LinkedList)localObject1).add(localbya);
            break;
            localbya.scene = 1;
            localbya.ooi = 1;
            continue;
            localbya.scene = 1;
            localbya.ooi = 2;
            continue;
            localbya.scene = 1;
            localbya.ooi = 3;
            continue;
            localbya.scene = 2;
            continue;
            localbya.scene = 3;
            continue;
            localbya.scene = 4;
            continue;
            localbya.scene = 6;
            localbya.ooi = 4;
            continue;
            localbya.scene = 7;
            localbya.ooi = 4;
            continue;
            if (paramaqy.tcl != 34)
            {
              localbya.scene = 5;
              continue;
              if (paramaqy.tcl != 34) {}
            }
            else
            {
              localbya.scene = 8;
            }
          }
        }
      }
    }
    d.g.b.p.h(localObject1, "itemList");
    ad.i(TAG, "addMarkReadItemList " + ((LinkedList)localObject1).size());
    Object localObject2 = skw.obtainMessage(ADD);
    ((Message)localObject2).obj = localObject1;
    ((Message)localObject2).sendToTarget();
    if ((paramaqy.rTD == 17) || (paramaqy.rTD == 18))
    {
      localObject1 = a.KiD;
      ((FinderTabStreamUnreadVM)a.bi(PluginFinder.class).get(FinderTabStreamUnreadVM.class)).j(paramaqy.rTD, paramList);
    }
    AppMethodBeat.o(202968);
  }
  
  public static boolean ae(int paramInt, long paramLong)
  {
    AppMethodBeat.i(178323);
    Iterator localIterator = ((Iterable)skr).iterator();
    while (localIterator.hasNext())
    {
      bya localbya = (bya)localIterator.next();
      if ((localbya.scene == paramInt) && (localbya.rIZ == paramLong))
      {
        AppMethodBeat.o(178323);
        return true;
      }
    }
    AppMethodBeat.o(178323);
    return false;
  }
  
  public static LinkedList<bya> cCL()
  {
    return skr;
  }
  
  public static int cCM()
  {
    return ADD;
  }
  
  public static int cCN()
  {
    return sks;
  }
  
  public static int cCO()
  {
    return skt;
  }
  
  public static int cCP()
  {
    return sku;
  }
  
  public static int cCQ()
  {
    return skv;
  }
  
  public static int cCR()
  {
    return STOP;
  }
  
  private static void cCS()
  {
    AppMethodBeat.i(178318);
    skw.removeMessages(sks);
    int i = com.tencent.mm.n.g.acA().getInt("FinderMarkReadReportIntervalSecond", 60);
    skw.sendEmptyMessageDelayed(sks, i * 1000L);
    AppMethodBeat.o(178318);
  }
  
  public static String getTAG()
  {
    return TAG;
  }
  
  public static void h(int paramInt, List<? extends FinderObject> paramList)
  {
    int j = 0;
    AppMethodBeat.i(202966);
    d.g.b.p.h(paramList, "feedList");
    Object localObject1;
    int i;
    switch (paramInt)
    {
    case 2: 
    default: 
      AppMethodBeat.o(202966);
      return;
    case 3: 
      paramInt = 17;
      localObject1 = (HashMap)sky.get(Integer.valueOf(paramInt));
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
      localObject2 = (HashMap)sky.get(Integer.valueOf(paramInt));
      if (localObject2 != null)
      {
        localObject3 = (an)((HashMap)localObject2).get(Long.valueOf(((FinderObject)localObject1).id));
        if (localObject3 != null)
        {
          ad.i(TAG, "already in mark read map isRead:" + ((an)localObject3).skE);
          continue;
          paramInt = 18;
          break;
          paramInt = 20;
          break;
          i = 0;
          break label84;
        }
        d.g.b.p.g(localObject2, "markReadMap");
        ((Map)localObject2).put(Long.valueOf(((FinderObject)localObject1).id), new an(((FinderObject)localObject1).id));
        continue;
      }
      localObject2 = (Map)sky;
      localObject3 = new HashMap();
      ((HashMap)localObject3).put(Long.valueOf(((FinderObject)localObject1).id), new an(((FinderObject)localObject1).id));
      ((Map)localObject2).put(Integer.valueOf(paramInt), localObject3);
    }
    label305:
    paramList = (HashMap)sky.get(Integer.valueOf(paramInt));
    if ((paramList != null) && (paramList.size() > 50))
    {
      localObject2 = new LinkedList();
      ((LinkedList)localObject2).addAll(paramList.values());
      j.sort((List)localObject2);
      paramList = (Map)sky;
      localObject1 = new HashMap();
      localObject2 = ((LinkedList)localObject2).subList(0, 50);
      d.g.b.p.g(localObject2, "list.subList(0, 50)");
      localObject2 = ((Iterable)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (an)((Iterator)localObject2).next();
        ((HashMap)localObject1).put(Long.valueOf(((an)localObject3).dtq), localObject3);
      }
      paramList.put(Integer.valueOf(paramInt), localObject1);
    }
    paramList = (HashMap)sky.get(Integer.valueOf(paramInt));
    paramInt = j;
    if (paramList != null) {
      paramInt = paramList.size();
    }
    ad.i(TAG, "onStreamCgiBack beforeSize:" + i + " afterSize:" + paramInt);
    AppMethodBeat.o(202966);
  }
  
  public static void startTimer()
  {
    AppMethodBeat.i(202965);
    int i = skx.incrementAndGet();
    ad.i(TAG, "start success ".concat(String.valueOf(i)));
    cCS();
    AppMethodBeat.o(202965);
  }
  
  public static void stopTimer()
  {
    AppMethodBeat.i(178322);
    int i = skx.decrementAndGet();
    if (i == 0)
    {
      ad.i(TAG, "really stop");
      skw.removeMessages(sks);
      skw.sendEmptyMessage(STOP);
      AppMethodBeat.o(178322);
      return;
    }
    ad.i(TAG, "not really stop ".concat(String.valueOf(i)));
    AppMethodBeat.o(178322);
  }
  
  public static void sv()
  {
    AppMethodBeat.i(178319);
    skw.sendEmptyMessage(sku);
    AppMethodBeat.o(178319);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(178324);
    ad.i(TAG, "onSceneEnd errType:" + paramInt1 + " errCode:" + paramInt2);
    if (paramn != null)
    {
      if (((paramn instanceof bg)) && (paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = skw.obtainMessage(skt);
        paramString.obj = ((bg)paramn).rKj;
        paramString.sendToTarget();
      }
      AppMethodBeat.o(178324);
      return;
    }
    AppMethodBeat.o(178324);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/os/Message;", "kotlin.jvm.PlatformType", "handleMessage"})
  static final class a
    implements ap.a
  {
    public static final a skA;
    
    static
    {
      AppMethodBeat.i(178317);
      skA = new a();
      AppMethodBeat.o(178317);
    }
    
    public final boolean handleMessage(Message paramMessage)
    {
      AppMethodBeat.i(178316);
      int i = paramMessage.what;
      Object localObject1 = x.skz;
      if (i == x.cCM()) {
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
            localObject1 = (bya)paramMessage.next();
            localObject2 = x.skz;
            j = i;
            if (!x.ae(((bya)localObject1).scene, ((bya)localObject1).rIZ))
            {
              i += 1;
              localObject2 = x.skz;
              x.cCL().add(localObject1);
              localObject2 = x.skz;
              x.a((bya)localObject1);
              localObject2 = d.szI;
              localObject2 = d.a.wT(((bya)localObject1).rIZ);
              if (localObject2 != null)
              {
                Object localObject3 = x.skz;
                localObject3 = x.getTAG();
                localObject1 = new StringBuilder("mark read ").append(c.rc(((bya)localObject1).rIZ)).append(" nickname ").append(((FinderItem)localObject2).getNickName()).append(' ');
                com.tencent.mm.plugin.finder.utils.p localp = com.tencent.mm.plugin.finder.utils.p.sMo;
                ad.d((String)localObject3, com.tencent.mm.plugin.finder.utils.p.ajb(((FinderItem)localObject2).getDescription()));
              }
              else
              {
                localObject2 = x.skz;
                ad.d(x.getTAG(), "mark read " + c.rc(((bya)localObject1).rIZ));
                j = i;
              }
            }
            else
            {
              i = j;
            }
          }
          paramMessage = x.skz;
          int k = x.cCL().size();
          if ((k > 1000) && (1000 <= k))
          {
            j = 1000;
            for (;;)
            {
              paramMessage = x.skz;
              x.cCL().removeFirst();
              if (j == k) {
                break;
              }
              j += 1;
            }
          }
          paramMessage = x.skz;
          paramMessage = x.getTAG();
          localObject1 = new StringBuilder("final add ").append(i).append(' ').append(k).append(' ');
          Object localObject2 = x.skz;
          ad.i(paramMessage, x.cCL().size());
          paramMessage = x.skz;
          x.cCT();
        }
      }
      for (;;)
      {
        AppMethodBeat.o(178316);
        return false;
        i = paramMessage.what;
        localObject1 = x.skz;
        if (i == x.cCN())
        {
          paramMessage = x.skz;
          if (x.cCL().size() > 0)
          {
            x.a(x.skz);
            paramMessage = x.skz;
            x.cCU();
          }
        }
        else
        {
          i = paramMessage.what;
          localObject1 = x.skz;
          if (i == x.cCO())
          {
            if ((paramMessage.obj instanceof LinkedList))
            {
              localObject1 = x.skz;
              localObject1 = x.cCL();
              paramMessage = paramMessage.obj;
              if (paramMessage == null)
              {
                paramMessage = new v("null cannot be cast to non-null type java.util.LinkedList<com.tencent.mm.protocal.protobuf.MarkReadStat>");
                AppMethodBeat.o(178316);
                throw paramMessage;
              }
              ((LinkedList)localObject1).removeAll((Collection)paramMessage);
              paramMessage = x.skz;
              x.cCT();
            }
          }
          else
          {
            i = paramMessage.what;
            localObject1 = x.skz;
            if (i == x.cCP())
            {
              paramMessage = x.skz;
              x.cCV();
            }
            else
            {
              i = paramMessage.what;
              localObject1 = x.skz;
              if (i == x.cCQ())
              {
                paramMessage = x.skz;
                x.cCT();
              }
              else
              {
                i = paramMessage.what;
                paramMessage = x.skz;
                if (i == x.cCR())
                {
                  x.a(x.skz);
                  paramMessage = x.skz;
                  x.i(new HashMap());
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
 * Qualified Name:     com.tencent.mm.plugin.finder.model.x
 * JD-Core Version:    0.7.0.1
 */
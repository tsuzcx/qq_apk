package com.tencent.mm.plugin.finder.model;

import android.arch.lifecycle.ViewModelProvider;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.n.f;
import com.tencent.mm.n.h;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.cgi.cq;
import com.tencent.mm.plugin.finder.report.k;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.data.e;
import com.tencent.mm.plugin.finder.storage.data.e.a;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.plugin.finder.viewmodel.FinderStreamCardVM;
import com.tencent.mm.plugin.finder.viewmodel.FinderTabStreamUnreadVM;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.protocal.protobuf.cmm;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandler.Callback;
import com.tencent.mm.ui.component.a;
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
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/model/FinderMarkReadLogic;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "ADD", "", "getADD", "()I", "READ", "getREAD", "REMOVE", "getREMOVE", "SAVE", "getSAVE", "SEND", "getSEND", "STOP", "getSTOP", "TAG", "", "getTAG", "()Ljava/lang/String;", "markReadItemList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/MarkReadStat;", "getMarkReadItemList", "()Ljava/util/LinkedList;", "setMarkReadItemList", "(Ljava/util/LinkedList;)V", "startCount", "Ljava/util/concurrent/atomic/AtomicInteger;", "streamMarkReadFeedMap", "Ljava/util/HashMap;", "", "Lcom/tencent/mm/plugin/finder/model/StreamMarkReadStat;", "Lkotlin/collections/HashMap;", "timer", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "addCrossFeedList", "", "acrossFeedList", "", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "addMarReadItemList", "itemList", "containItems", "", "scene", "objectId", "fillMarkReadScene", "markReadStat", "commentScene", "fromCommentScene", "filterTabMarkReadItem", "getStreamMarkReadList", "tabType", "nextSend", "onFinish", "onSceneEnd", "errType", "errCode", "errMsg", "Lcom/tencent/mm/modelbase/NetSceneBase;", "onStreamCgiBack", "feedList", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "read", "readFromFile", "save", "saveToFile", "send", "startTimer", "stopTimer", "plugin-finder_release"})
public final class as
  implements i
{
  private static final int ADD = 0;
  private static final int STOP = 5;
  private static final String TAG = "Finder.FinderMarkReadLogic";
  private static LinkedList<cmm> uOD;
  private static final int uOE = 1;
  private static final int uOF = 2;
  private static final int uOG = 3;
  private static final int uOH = 4;
  private static final MMHandler uOI;
  private static AtomicInteger uOJ;
  private static HashMap<Integer, HashMap<Long, bq>> uOK;
  public static final as uOL;
  
  static
  {
    AppMethodBeat.i(178325);
    as localas = new as();
    uOL = localas;
    TAG = "Finder.FinderMarkReadLogic";
    uOD = new LinkedList();
    uOE = 1;
    uOF = 2;
    uOG = 3;
    uOH = 4;
    STOP = 5;
    g.azz().a(3520, (i)localas);
    uOI = new MMHandler(TAG, (MMHandler.Callback)a.uOM);
    uOJ = new AtomicInteger(0);
    uOK = new HashMap();
    AppMethodBeat.o(178325);
  }
  
  public static LinkedList<cmm> Jt(int paramInt)
  {
    int j = 0;
    AppMethodBeat.i(248801);
    LinkedList localLinkedList = new LinkedList();
    switch (paramInt)
    {
    case 2: 
    default: 
      i = 0;
    }
    for (;;)
    {
      localObject2 = (HashMap)uOK.get(Integer.valueOf(i));
      if (localObject2 == null) {
        break label347;
      }
      localObject1 = new LinkedList();
      p.g(localObject2, "markReadMap");
      localObject3 = (Map)localObject2;
      localObject2 = (Map)new LinkedHashMap();
      localObject3 = ((Map)localObject3).entrySet().iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localObject4 = (Map.Entry)((Iterator)localObject3).next();
        if (((bq)((Map.Entry)localObject4).getValue()).uPa) {
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
        j.hxH();
      }
      localObject2 = (bq)localObject2;
      if ((i < 20) && (localObject2 != null))
      {
        localObject2 = ((bq)localObject2).uPb;
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
      ((Collection)localObject3).add(d.zs(((cmm)((Iterator)localObject4).next()).hFK));
    }
    Log.i((String)localObject1, (List)localObject3);
    AppMethodBeat.o(248801);
    return localLinkedList;
  }
  
  private static void a(cmm paramcmm, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(248802);
    p.h(paramcmm, "markReadStat");
    paramcmm.MrI = paramInt1;
    switch (paramInt1)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(248802);
      return;
      paramcmm.scene = 1;
      paramcmm.pHw = 1;
      AppMethodBeat.o(248802);
      return;
      paramcmm.scene = 1;
      paramcmm.pHw = 2;
      AppMethodBeat.o(248802);
      return;
      paramcmm.scene = 1;
      paramcmm.pHw = 3;
      AppMethodBeat.o(248802);
      return;
      paramcmm.scene = 9;
      AppMethodBeat.o(248802);
      return;
      paramcmm.scene = 10;
      AppMethodBeat.o(248802);
      return;
      paramcmm.scene = 2;
      AppMethodBeat.o(248802);
      return;
      paramcmm.scene = 3;
      AppMethodBeat.o(248802);
      return;
      paramcmm.scene = 4;
      AppMethodBeat.o(248802);
      return;
      paramcmm.scene = 6;
      paramcmm.pHw = 4;
      AppMethodBeat.o(248802);
      return;
      paramcmm.scene = 7;
      paramcmm.pHw = 4;
      AppMethodBeat.o(248802);
      return;
      if (paramInt2 != 34)
      {
        paramcmm.scene = 5;
        AppMethodBeat.o(248802);
        return;
        if (paramInt2 != 34) {}
      }
      else
      {
        paramcmm.scene = 8;
      }
    }
  }
  
  public static void a(List<? extends bo> paramList, bbn parambbn)
  {
    AppMethodBeat.i(248804);
    p.h(parambbn, "contextObj");
    Object localObject1 = new LinkedList();
    if (paramList != null)
    {
      Iterator localIterator = ((Iterable)paramList).iterator();
      while (localIterator.hasNext())
      {
        bo localbo = (bo)localIterator.next();
        if (localbo.lT() != 0L)
        {
          Object localObject2;
          if (!(localbo instanceof BaseFinderFeed))
          {
            localObject2 = y.vXH;
            if (!y.dCz().contains(Integer.valueOf(localbo.cxn()))) {}
          }
          else
          {
            localObject2 = new cmm();
            ((cmm)localObject2).hFK = localbo.lT();
            a((cmm)localObject2, parambbn.tCE, parambbn.tyh);
            k localk = k.vfA;
            ((cmm)localObject2).sessionBuffer = k.G(localbo.lT(), parambbn.tCE);
            ((LinkedList)localObject1).add(localObject2);
          }
        }
      }
    }
    ar((LinkedList)localObject1);
    if ((parambbn.tCE == 17) || (parambbn.tCE == 18))
    {
      localObject1 = a.PRN;
      ((FinderTabStreamUnreadVM)a.bi(PluginFinder.class).get(FinderTabStreamUnreadVM.class)).o(parambbn.tCE, paramList);
      AppMethodBeat.o(248804);
      return;
    }
    if (parambbn.tCE == 51)
    {
      paramList = a.PRN;
      ((FinderStreamCardVM)a.bi(PluginFinder.class).get(FinderStreamCardVM.class)).eH((List)localObject1);
    }
    AppMethodBeat.o(248804);
  }
  
  public static boolean ag(int paramInt, long paramLong)
  {
    AppMethodBeat.i(178323);
    Iterator localIterator = ((Iterable)uOD).iterator();
    while (localIterator.hasNext())
    {
      cmm localcmm = (cmm)localIterator.next();
      if ((localcmm.scene == paramInt) && (localcmm.hFK == paramLong))
      {
        AppMethodBeat.o(178323);
        return true;
      }
    }
    AppMethodBeat.o(178323);
    return false;
  }
  
  public static void ar(LinkedList<cmm> paramLinkedList)
  {
    AppMethodBeat.i(178320);
    p.h(paramLinkedList, "itemList");
    Log.i(TAG, "addMarkReadItemList " + paramLinkedList.size());
    Message localMessage = uOI.obtainMessage(ADD);
    localMessage.obj = paramLinkedList;
    localMessage.sendToTarget();
    AppMethodBeat.o(178320);
  }
  
  public static LinkedList<cmm> dkC()
  {
    return uOD;
  }
  
  public static int dkD()
  {
    return ADD;
  }
  
  public static int dkE()
  {
    return uOE;
  }
  
  public static int dkF()
  {
    return uOF;
  }
  
  public static int dkG()
  {
    return uOG;
  }
  
  public static int dkH()
  {
    return uOH;
  }
  
  public static int dkI()
  {
    return STOP;
  }
  
  private static void dkJ()
  {
    AppMethodBeat.i(178318);
    uOI.removeMessages(uOE);
    int i = h.aqJ().getInt("FinderMarkReadReportIntervalSecond", 60);
    uOI.sendEmptyMessageDelayed(uOE, i * 1000L);
    AppMethodBeat.o(178318);
  }
  
  public static String getTAG()
  {
    return TAG;
  }
  
  public static void h(int paramInt, List<? extends FinderObject> paramList)
  {
    int j = 0;
    AppMethodBeat.i(248800);
    p.h(paramList, "feedList");
    Object localObject1;
    int i;
    switch (paramInt)
    {
    case 2: 
    default: 
      AppMethodBeat.o(248800);
      return;
    case 3: 
      paramInt = 17;
      localObject1 = (HashMap)uOK.get(Integer.valueOf(paramInt));
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
      localObject2 = (HashMap)uOK.get(Integer.valueOf(paramInt));
      if (localObject2 != null)
      {
        localObject3 = (bq)((HashMap)localObject2).get(Long.valueOf(((FinderObject)localObject1).id));
        if (localObject3 != null)
        {
          Log.i(TAG, "already in mark read map isRead:" + ((bq)localObject3).uPa);
          continue;
          paramInt = 18;
          break;
          paramInt = 20;
          break;
          i = 0;
          break label84;
        }
        p.g(localObject2, "markReadMap");
        ((Map)localObject2).put(Long.valueOf(((FinderObject)localObject1).id), new bq(((FinderObject)localObject1).id));
        continue;
      }
      localObject2 = (Map)uOK;
      localObject3 = new HashMap();
      ((HashMap)localObject3).put(Long.valueOf(((FinderObject)localObject1).id), new bq(((FinderObject)localObject1).id));
      ((Map)localObject2).put(Integer.valueOf(paramInt), localObject3);
    }
    label305:
    paramList = (HashMap)uOK.get(Integer.valueOf(paramInt));
    if ((paramList != null) && (paramList.size() > 50))
    {
      localObject2 = new LinkedList();
      ((LinkedList)localObject2).addAll(paramList.values());
      j.sort((List)localObject2);
      paramList = (Map)uOK;
      localObject1 = new HashMap();
      localObject2 = ((LinkedList)localObject2).subList(0, 50);
      p.g(localObject2, "list.subList(0, 50)");
      localObject2 = ((Iterable)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (bq)((Iterator)localObject2).next();
        ((HashMap)localObject1).put(Long.valueOf(((bq)localObject3).feedId), localObject3);
      }
      paramList.put(Integer.valueOf(paramInt), localObject1);
    }
    paramList = (HashMap)uOK.get(Integer.valueOf(paramInt));
    paramInt = j;
    if (paramList != null) {
      paramInt = paramList.size();
    }
    Log.i(TAG, "onStreamCgiBack beforeSize:" + i + " afterSize:" + paramInt);
    AppMethodBeat.o(248800);
  }
  
  public static void startTimer()
  {
    AppMethodBeat.i(248799);
    int i = uOJ.incrementAndGet();
    Log.i(TAG, "start success ".concat(String.valueOf(i)));
    dkJ();
    AppMethodBeat.o(248799);
  }
  
  public static void stopTimer()
  {
    AppMethodBeat.i(178322);
    int i = uOJ.decrementAndGet();
    if (i == 0)
    {
      Log.i(TAG, "really stop");
      uOI.removeMessages(uOE);
      uOI.sendEmptyMessage(STOP);
      AppMethodBeat.o(178322);
      return;
    }
    Log.i(TAG, "not really stop ".concat(String.valueOf(i)));
    AppMethodBeat.o(178322);
  }
  
  public static void sy()
  {
    AppMethodBeat.i(178319);
    uOI.sendEmptyMessage(uOG);
    AppMethodBeat.o(178319);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(178324);
    Log.i(TAG, "onSceneEnd errType:" + paramInt1 + " errCode:" + paramInt2);
    if (paramq != null)
    {
      if (((paramq instanceof cq)) && (paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = uOI.obtainMessage(uOF);
        paramString.obj = ((cq)paramq).twF;
        paramString.sendToTarget();
      }
      AppMethodBeat.o(178324);
      return;
    }
    AppMethodBeat.o(178324);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/os/Message;", "kotlin.jvm.PlatformType", "handleMessage"})
  static final class a
    implements MMHandler.Callback
  {
    public static final a uOM;
    
    static
    {
      AppMethodBeat.i(178317);
      uOM = new a();
      AppMethodBeat.o(178317);
    }
    
    public final boolean handleMessage(Message paramMessage)
    {
      AppMethodBeat.i(178316);
      int i = paramMessage.what;
      Object localObject1 = as.uOL;
      if (i == as.dkD()) {
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
            localObject1 = (cmm)paramMessage.next();
            localObject2 = as.uOL;
            Object localObject3;
            StringBuilder localStringBuilder;
            y localy;
            if (!as.ag(((cmm)localObject1).scene, ((cmm)localObject1).hFK))
            {
              i += 1;
              localObject2 = as.uOL;
              as.dkC().add(localObject1);
              localObject2 = as.uOL;
              as.a((cmm)localObject1);
              localObject2 = e.vFX;
              localObject2 = e.a.Fy(((cmm)localObject1).hFK);
              if (localObject2 != null)
              {
                localObject3 = as.uOL;
                localObject3 = as.getTAG();
                localStringBuilder = new StringBuilder("mark read scene:").append(((cmm)localObject1).scene).append(" subScene:").append(((cmm)localObject1).pHw).append(" commScene:").append(((cmm)localObject1).MrI).append(' ').append(d.zs(((cmm)localObject1).hFK)).append(" nickname:").append(((FinderItem)localObject2).getNickName()).append(" desc:");
                localy = y.vXH;
                Log.d((String)localObject3, y.awq(((FinderItem)localObject2).getDescription()) + " expose:" + ((cmm)localObject1).MrJ);
              }
              else
              {
                localObject2 = as.uOL;
                Log.d(as.getTAG(), "mark read " + d.zs(((cmm)localObject1).hFK));
              }
            }
            else
            {
              localObject2 = e.vFX;
              localObject2 = e.a.Fy(((cmm)localObject1).hFK);
              if (localObject2 != null)
              {
                localObject3 = as.uOL;
                localObject3 = as.getTAG();
                localStringBuilder = new StringBuilder("contains read scene:").append(((cmm)localObject1).scene).append(" subScene:").append(((cmm)localObject1).pHw).append(" commScene:").append(((cmm)localObject1).MrI).append(' ').append(d.zs(((cmm)localObject1).hFK)).append(" nickname:").append(((FinderItem)localObject2).getNickName()).append(" desc:");
                localy = y.vXH;
                Log.d((String)localObject3, y.awq(((FinderItem)localObject2).getDescription()) + " expose:" + ((cmm)localObject1).MrJ);
              }
              else
              {
                localObject2 = as.uOL;
                Log.d(as.getTAG(), "contains read " + d.zs(((cmm)localObject1).hFK));
              }
            }
          }
          paramMessage = as.uOL;
          int k = as.dkC().size();
          if ((k > 1000) && (1000 <= k))
          {
            int j = 1000;
            for (;;)
            {
              paramMessage = as.uOL;
              as.dkC().removeFirst();
              if (j == k) {
                break;
              }
              j += 1;
            }
          }
          paramMessage = as.uOL;
          paramMessage = as.getTAG();
          localObject1 = new StringBuilder("final add ").append(i).append(' ').append(k).append(' ');
          Object localObject2 = as.uOL;
          Log.i(paramMessage, as.dkC().size());
          paramMessage = as.uOL;
          as.dkK();
        }
      }
      for (;;)
      {
        AppMethodBeat.o(178316);
        return false;
        i = paramMessage.what;
        localObject1 = as.uOL;
        if (i == as.dkE())
        {
          paramMessage = as.uOL;
          if (as.dkC().size() > 0)
          {
            as.a(as.uOL);
            paramMessage = as.uOL;
            as.dkL();
          }
        }
        else
        {
          i = paramMessage.what;
          localObject1 = as.uOL;
          if (i == as.dkF())
          {
            if ((paramMessage.obj instanceof LinkedList))
            {
              localObject1 = as.uOL;
              localObject1 = as.dkC();
              paramMessage = paramMessage.obj;
              if (paramMessage == null)
              {
                paramMessage = new kotlin.t("null cannot be cast to non-null type java.util.LinkedList<com.tencent.mm.protocal.protobuf.MarkReadStat>");
                AppMethodBeat.o(178316);
                throw paramMessage;
              }
              ((LinkedList)localObject1).removeAll((Collection)paramMessage);
              paramMessage = as.uOL;
              as.dkK();
            }
          }
          else
          {
            i = paramMessage.what;
            localObject1 = as.uOL;
            if (i == as.dkG())
            {
              paramMessage = as.uOL;
              as.dkM();
            }
            else
            {
              i = paramMessage.what;
              localObject1 = as.uOL;
              if (i == as.dkH())
              {
                paramMessage = as.uOL;
                as.dkK();
              }
              else
              {
                i = paramMessage.what;
                paramMessage = as.uOL;
                if (i == as.dkI())
                {
                  as.a(as.uOL);
                  paramMessage = as.uOL;
                  as.k(new HashMap());
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
 * Qualified Name:     com.tencent.mm.plugin.finder.model.as
 * JD-Core Version:    0.7.0.1
 */
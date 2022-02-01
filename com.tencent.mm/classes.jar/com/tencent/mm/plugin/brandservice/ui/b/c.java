package com.tencent.mm.plugin.brandservice.ui.b;

import android.os.Looper;
import android.os.MessageQueue;
import android.os.MessageQueue.IdleHandler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.q;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.ao.af;
import com.tencent.mm.bb.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.brandservice.b;
import com.tencent.mm.plugin.brandservice.ui.timeline.item.j;
import com.tencent.mm.protocal.protobuf.eqb;
import com.tencent.mm.protocal.protobuf.eqc;
import com.tencent.mm.protocal.protobuf.eqe;
import com.tencent.mm.protocal.protobuf.eqf;
import com.tencent.mm.protocal.protobuf.eqg;
import com.tencent.mm.protocal.protobuf.pk;
import com.tencent.mm.protocal.protobuf.pl;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.r;
import com.tencent.mm.storage.z;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class c
{
  private static Map<Long, Integer> sTp;
  private static LinkedList<Long> sTq;
  
  static
  {
    AppMethodBeat.i(6257);
    sTp = new HashMap();
    sTq = new LinkedList();
    AppMethodBeat.o(6257);
  }
  
  public static boolean Hw(int paramInt)
  {
    AppMethodBeat.i(6245);
    if (System.currentTimeMillis() / 1000L - paramInt > a.sTj)
    {
      AppMethodBeat.o(6245);
      return true;
    }
    AppMethodBeat.o(6245);
    return false;
  }
  
  private static void L(LinkedList<eqe> paramLinkedList)
  {
    AppMethodBeat.i(6254);
    if (Util.isNullOrNil(paramLinkedList))
    {
      AppMethodBeat.o(6254);
      return;
    }
    LinkedList localLinkedList = new LinkedList();
    synchronized (sTq)
    {
      if (Util.isNullOrNil(sTq)) {
        break label160;
      }
      localObject2 = new LinkedList();
      Iterator localIterator = paramLinkedList.iterator();
      while (localIterator.hasNext())
      {
        eqe localeqe = (eqe)localIterator.next();
        if (sTq.contains(Long.valueOf(localeqe.RXN))) {
          ((LinkedList)localObject2).add(localeqe);
        }
      }
    }
    paramLinkedList.removeAll((Collection)localObject2);
    if (Util.isNullOrNil(paramLinkedList))
    {
      Log.d("MicroMsg.ConversationAdapter", "doUpdateRecommendCard is doing return %d", new Object[] { Integer.valueOf(((LinkedList)localObject2).size()) });
      AppMethodBeat.o(6254);
      return;
    }
    label160:
    Object localObject2 = paramLinkedList.iterator();
    while (((Iterator)localObject2).hasNext()) {
      localLinkedList.add(Long.valueOf(((eqe)((Iterator)localObject2).next()).RXN));
    }
    sTq.addAll(localLinkedList);
    ??? = new d.a();
    ((d.a)???).lBU = new pk();
    ((d.a)???).lBV = new pl();
    ((d.a)???).uri = "/cgi-bin/mmbiz-bin/timeline/bizrecommendcard";
    ((d.a)???).funcId = 2787;
    ??? = ((d.a)???).bgN();
    localObject2 = (pk)d.b.b(((d)???).lBR);
    ((pk)localObject2).RXR = paramLinkedList;
    com.tencent.mm.an.aa.a((d)???, new c.4(localLinkedList, (pk)localObject2));
    AppMethodBeat.o(6254);
  }
  
  private static eqe a(eqg parameqg, z paramz)
  {
    AppMethodBeat.i(6255);
    if ((parameqg == null) || (parameqg.UsD == null) || (paramz == null))
    {
      Log.i("MicroMsg.ConversationAdapter", "getTLRecCardLite invalid data");
      AppMethodBeat.o(6255);
      return null;
    }
    eqe localeqe = new eqe();
    if (!Util.isNullOrNil(parameqg.UsD.RXM))
    {
      Iterator localIterator = parameqg.UsD.RXM.iterator();
      while (localIterator.hasNext())
      {
        eqc localeqc = (eqc)localIterator.next();
        localeqe.RVG.add(localeqc.RTk);
      }
    }
    localeqe.RTS = paramz.field_talker;
    localeqe.RXN = paramz.field_msgId;
    localeqe.SwF = parameqg.UsD.SwF;
    localeqe.RVf = parameqg.style;
    if (parameqg.UsD.Usz != null) {
      localeqe.UsB = parameqg.UsD.Usz.SwF;
    }
    AppMethodBeat.o(6255);
    return localeqe;
  }
  
  public static void a(List<z> paramList, final Runnable paramRunnable)
  {
    AppMethodBeat.i(6248);
    Looper.myQueue().addIdleHandler(new MessageQueue.IdleHandler()
    {
      public final boolean queueIdle()
      {
        AppMethodBeat.i(261686);
        Looper.myQueue().removeIdleHandler(this);
        b.am(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(264469);
            Iterator localIterator = c.2.this.pzd.iterator();
            while (localIterator.hasNext())
            {
              z localz = (z)localIterator.next();
              if (localz.hwA()) {
                ((com.tencent.mm.plugin.biz.a.a)h.ae(com.tencent.mm.plugin.biz.a.a.class)).b(localz.field_msgId, localz.field_content);
              }
            }
            c.cK(c.2.this.pzd);
            c.cL(c.2.this.pzd);
            MMHandlerThread.postToMainThread(c.2.this.val$callback);
            AppMethodBeat.o(264469);
          }
        });
        AppMethodBeat.o(261686);
        return false;
      }
    });
    AppMethodBeat.o(6248);
  }
  
  public static String aqF(String paramString)
  {
    AppMethodBeat.i(6250);
    if (paramString != null)
    {
      paramString = paramString.replaceAll("(?m)^\\s*$(\\n|\\r\\n)", "");
      AppMethodBeat.o(6250);
      return paramString;
    }
    AppMethodBeat.o(6250);
    return null;
  }
  
  public static boolean b(com.tencent.mm.cd.a parama1, com.tencent.mm.cd.a parama2)
  {
    AppMethodBeat.i(6249);
    if ((parama1 == null) && (parama2 == null))
    {
      AppMethodBeat.o(6249);
      return true;
    }
    if ((parama1 == null) || (parama2 == null))
    {
      AppMethodBeat.o(6249);
      return false;
    }
    try
    {
      boolean bool = Util.isEqual(parama1.toByteArray(), parama2.toByteArray());
      AppMethodBeat.o(6249);
      return bool;
    }
    catch (IOException parama1)
    {
      Log.i("MicroMsg.ConversationAdapter", "isMsgStatInfoProtoEqual exp %s", new Object[] { parama1.getMessage() });
      AppMethodBeat.o(6249);
    }
    return false;
  }
  
  public static String cEq()
  {
    AppMethodBeat.i(6244);
    Object localObject2 = null;
    f localf = com.tencent.mm.bb.a.bnA();
    Object localObject1 = localObject2;
    if (localf != null)
    {
      localObject1 = localObject2;
      if (localf.lVt != null)
      {
        localObject1 = localObject2;
        if (localf.lVr == 0)
        {
          localObject1 = localObject2;
          if (com.tencent.mm.bb.a.bnx()) {
            localObject1 = localf.lVt;
          }
        }
      }
    }
    AppMethodBeat.o(6244);
    return localObject1;
  }
  
  public static void cI(List<z> paramList)
  {
    AppMethodBeat.i(6247);
    if (Util.isNullOrNil(paramList))
    {
      AppMethodBeat.o(6247);
      return;
    }
    LinkedList localLinkedList1 = new LinkedList();
    LinkedList localLinkedList2 = new LinkedList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      z localz = (z)paramList.next();
      if ((!sTp.containsKey(Long.valueOf(localz.field_msgId))) || (Hw(((Integer)sTp.get(Long.valueOf(localz.field_msgId))).intValue()))) {
        if (localz.hwA())
        {
          q localq = new q();
          localq.msgId = localz.field_msgId;
          localq.lpy = localz.field_content;
          localLinkedList1.add(localq);
          sTp.put(Long.valueOf(localz.field_msgId), Integer.valueOf((int)(System.currentTimeMillis() / 1000L)));
        }
        else
        {
          sTp.put(Long.valueOf(localz.field_msgId), Integer.valueOf((int)(System.currentTimeMillis() / 1000L)));
          localLinkedList2.add(localz);
        }
      }
    }
    if (localLinkedList1.size() > 0) {
      ((com.tencent.mm.plugin.brandservice.a.c)h.ae(com.tencent.mm.plugin.brandservice.a.c.class)).l(localLinkedList1, 90);
    }
    AppMethodBeat.o(6247);
  }
  
  public static void cJ(List<z> paramList)
  {
    AppMethodBeat.i(6251);
    b.am(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(6241);
        c.cK(this.pzd);
        AppMethodBeat.o(6241);
      }
    });
    AppMethodBeat.o(6251);
  }
  
  public static void cK(List<z> paramList)
  {
    AppMethodBeat.i(6252);
    int i = MultiProcessMMKV.getSingleMMKV("brandService").decodeInt("BizRecommendCardRefreshIntervalSec", 300);
    LinkedList localLinkedList = new LinkedList();
    long l = System.currentTimeMillis();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Object localObject = (z)paramList.next();
      if ((((z)localObject).hwB()) && (!j.k((z)localObject)))
      {
        eqg localeqg = ((z)localObject).hwL();
        if ((localeqg != null) && (localeqg.UsD != null) && (Math.abs(l - localeqg.lastUpdateTime) / 1000L > i))
        {
          localObject = a(localeqg, (z)localObject);
          if (localObject != null) {
            localLinkedList.add(localObject);
          }
        }
      }
    }
    if (!Util.isNullOrNil(localLinkedList)) {
      L(localLinkedList);
    }
    AppMethodBeat.o(6252);
  }
  
  public static void cL(List<z> paramList)
  {
    AppMethodBeat.i(264434);
    LinkedList localLinkedList = new LinkedList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      z localz = (z)paramList.next();
      r localr = r.VcW;
      if ((r.hvM()) && (localz.hwC()))
      {
        localLinkedList.add(localz);
        r.VcW.B(localz);
      }
      else
      {
        localr = r.VcW;
        if ((r.hvP()) && (localz.hwB())) {
          r.VcW.B(localz);
        }
      }
    }
    AppMethodBeat.o(264434);
  }
  
  public static void cM(List<z> paramList)
  {
    AppMethodBeat.i(264435);
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Object localObject = (z)paramList.next();
      r localr = r.VcW;
      if ((r.hvM()) && (((z)localObject).hwC()))
      {
        ((com.tencent.mm.plugin.brandservice.a.c)h.ae(com.tencent.mm.plugin.brandservice.a.c.class)).cyJ();
        AppMethodBeat.o(264435);
        return;
      }
      localr = r.VcW;
      if ((r.hvP()) && (((z)localObject).hwB()))
      {
        localObject = ((z)localObject).hwL();
        if ((localObject != null) && (((eqg)localObject).style == 1001))
        {
          ((com.tencent.mm.plugin.brandservice.a.c)h.ae(com.tencent.mm.plugin.brandservice.a.c.class)).cyJ();
          AppMethodBeat.o(264435);
          return;
        }
      }
    }
    AppMethodBeat.o(264435);
  }
  
  public static void w(z paramz)
  {
    AppMethodBeat.i(6246);
    if ((paramz == null) || (!paramz.hwA()))
    {
      AppMethodBeat.o(6246);
      return;
    }
    b.am(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(6239);
        if ((c.sTp.containsKey(Long.valueOf(this.sgW.field_msgId))) && (!c.Hw(((Integer)c.sTp.get(Long.valueOf(this.sgW.field_msgId))).intValue())))
        {
          AppMethodBeat.o(6239);
          return;
        }
        List localList1 = af.bjB().bg(5, this.sgW.field_orderFlag);
        List localList2 = af.bjB().Ux(this.sgW.field_orderFlag);
        LinkedList localLinkedList = new LinkedList();
        localLinkedList.addAll(localList1);
        localLinkedList.add(this.sgW);
        localLinkedList.addAll(localList2);
        c.cI(localLinkedList);
        AppMethodBeat.o(6239);
      }
    });
    AppMethodBeat.o(6246);
  }
  
  public static void x(z paramz)
  {
    AppMethodBeat.i(6253);
    if ((paramz == null) || (!paramz.hwB()))
    {
      AppMethodBeat.o(6253);
      return;
    }
    eqg localeqg = paramz.hwL();
    if (j.k(paramz))
    {
      AppMethodBeat.o(6253);
      return;
    }
    int i = MultiProcessMMKV.getSingleMMKV("brandService").decodeInt("BizRecommendCardRefreshIntervalSec", 300);
    LinkedList localLinkedList = new LinkedList();
    long l = System.currentTimeMillis();
    if ((localeqg != null) && (localeqg.UsD != null) && (Math.abs(l - localeqg.lastUpdateTime) / 1000L > i))
    {
      paramz = a(localeqg, paramz);
      if (paramz != null) {
        localLinkedList.add(paramz);
      }
    }
    if (!Util.isNullOrNil(localLinkedList)) {
      L(localLinkedList);
    }
    AppMethodBeat.o(6253);
  }
  
  public static void y(z paramz)
  {
    AppMethodBeat.i(264438);
    if ((paramz == null) || (!paramz.hwB()))
    {
      AppMethodBeat.o(264438);
      return;
    }
    b.am(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(263675);
        if ((c.sTp.containsKey(Long.valueOf(this.sgW.field_msgId))) && (!c.Hw(((Integer)c.sTp.get(Long.valueOf(this.sgW.field_msgId))).intValue())))
        {
          AppMethodBeat.o(263675);
          return;
        }
        Object localObject1 = af.bjB().bg(5, this.sgW.field_orderFlag);
        Object localObject3 = af.bjB().Ux(this.sgW.field_orderFlag);
        Object localObject2 = new LinkedList();
        ((List)localObject2).addAll((Collection)localObject1);
        ((List)localObject2).add(this.sgW);
        ((List)localObject2).addAll((Collection)localObject3);
        if (Util.isNullOrNil((List)localObject2))
        {
          AppMethodBeat.o(263675);
          return;
        }
        localObject1 = new LinkedList();
        localObject2 = ((List)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (z)((Iterator)localObject2).next();
          if (((!c.sTp.containsKey(Long.valueOf(((z)localObject3).field_msgId))) || (c.Hw(((Integer)c.sTp.get(Long.valueOf(((z)localObject3).field_msgId))).intValue()))) && (((z)localObject3).Vei != null) && (((z)localObject3).Vei.UsD != null) && (!Util.isNullOrNil(((z)localObject3).Vei.UsD.RXM)) && (((z)localObject3).hwB()) && ((((z)localObject3).Vei.style == 3) || (((z)localObject3).Vei.style == 5)))
          {
            int i = 0;
            while (i < ((z)localObject3).Vei.UsD.RXM.size())
            {
              eqc localeqc = (eqc)((z)localObject3).Vei.UsD.RXM.get(i);
              q localq = new q();
              localq.Url = localeqc.RTk;
              localq.lpx = localeqc.lpx;
              localq.lpw = 1;
              ((List)localObject1).add(localq);
              i += 1;
            }
            c.sTp.put(Long.valueOf(((z)localObject3).field_msgId), Integer.valueOf((int)(System.currentTimeMillis() / 1000L)));
          }
        }
        if (((List)localObject1).size() > 0) {
          ((com.tencent.mm.plugin.brandservice.a.c)h.ae(com.tencent.mm.plugin.brandservice.a.c.class)).cp((List)localObject1);
        }
        AppMethodBeat.o(263675);
      }
    });
    AppMethodBeat.o(264438);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.b.c
 * JD-Core Version:    0.7.0.1
 */
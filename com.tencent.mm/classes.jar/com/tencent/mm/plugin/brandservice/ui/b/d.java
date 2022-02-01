package com.tencent.mm.plugin.brandservice.ui.b;

import android.os.Looper;
import android.os.MessageQueue;
import android.os.MessageQueue.IdleHandler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.p;
import com.tencent.mm.am.z;
import com.tencent.mm.am.z.a;
import com.tencent.mm.an.af;
import com.tencent.mm.cp.g;
import com.tencent.mm.message.q;
import com.tencent.mm.plugin.brandservice.ui.timeline.item.j;
import com.tencent.mm.protocal.protobuf.fle;
import com.tencent.mm.protocal.protobuf.flf;
import com.tencent.mm.protocal.protobuf.flg;
import com.tencent.mm.protocal.protobuf.flh;
import com.tencent.mm.protocal.protobuf.fli;
import com.tencent.mm.protocal.protobuf.flj;
import com.tencent.mm.protocal.protobuf.qt;
import com.tencent.mm.protocal.protobuf.qu;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ac;
import com.tencent.mm.storage.ac.7;
import com.tencent.mm.storage.ac.8;
import com.tencent.mm.storage.r;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class d
{
  private static Map<Long, Integer> vYF;
  private static LinkedList<Long> vYG;
  
  static
  {
    AppMethodBeat.i(6257);
    vYF = new HashMap();
    vYG = new LinkedList();
    AppMethodBeat.o(6257);
  }
  
  public static boolean HY(int paramInt)
  {
    AppMethodBeat.i(6245);
    if (System.currentTimeMillis() / 1000L - paramInt > b.vYz)
    {
      AppMethodBeat.o(6245);
      return true;
    }
    AppMethodBeat.o(6245);
    return false;
  }
  
  private static void O(LinkedList<flh> paramLinkedList)
  {
    AppMethodBeat.i(6254);
    if (Util.isNullOrNil(paramLinkedList))
    {
      AppMethodBeat.o(6254);
      return;
    }
    LinkedList localLinkedList = new LinkedList();
    synchronized (vYG)
    {
      if (Util.isNullOrNil(vYG)) {
        break label160;
      }
      localObject2 = new LinkedList();
      Iterator localIterator = paramLinkedList.iterator();
      while (localIterator.hasNext())
      {
        flh localflh = (flh)localIterator.next();
        if (vYG.contains(Long.valueOf(localflh.YVJ))) {
          ((LinkedList)localObject2).add(localflh);
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
      localLinkedList.add(Long.valueOf(((flh)((Iterator)localObject2).next()).YVJ));
    }
    vYG.addAll(localLinkedList);
    ??? = new c.a();
    ((c.a)???).otE = new qt();
    ((c.a)???).otF = new qu();
    ((c.a)???).uri = "/cgi-bin/mmbiz-bin/timeline/bizrecommendcard";
    ((c.a)???).funcId = 2787;
    ??? = ((c.a)???).bEF();
    localObject2 = (qt)c.b.b(((com.tencent.mm.am.c)???).otB);
    ((qt)localObject2).YVN = paramLinkedList;
    z.a((com.tencent.mm.am.c)???, new z.a()
    {
      public final int callback(int paramAnonymousInt1, int paramAnonymousInt2, String arg3, com.tencent.mm.am.c paramAnonymousc, p paramAnonymousp)
      {
        AppMethodBeat.i(6242);
        Log.i("MicroMsg.ConversationAdapter", "[TRACE_BIZRECCARD] doUpdateRecommendCard check result errType:%d errCode:%d msg:%s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), ??? });
        synchronized (d.dhT())
        {
          d.dhT().removeAll(d.this);
          if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
          {
            AppMethodBeat.o(6242);
            return 0;
          }
        }
        paramAnonymousc = (qu)c.c.b(paramAnonymousc.otC);
        if (paramAnonymousc == null)
        {
          AppMethodBeat.o(6242);
          return 0;
        }
        MultiProcessMMKV.getSingleMMKV("brandService").encode("BizRecommendCardRefreshIntervalSec", Math.min(300, paramAnonymousc.YRq));
        if (paramAnonymousc.YVN == null)
        {
          Log.i("MicroMsg.ConversationAdapter", "response.RecCard is null");
          AppMethodBeat.o(6242);
          return 0;
        }
        ??? = new LinkedList();
        paramAnonymousp = paramAnonymousc.YVN.iterator();
        while (paramAnonymousp.hasNext())
        {
          fle localfle = (fle)paramAnonymousp.next();
          Iterator localIterator = this.vYJ.YVN.iterator();
          while (localIterator.hasNext())
          {
            flh localflh = (flh)localIterator.next();
            if (Util.isEqual(localflh.YVJ, localfle.YVJ)) {
              if (localfle.abLF == null)
              {
                Log.i("MicroMsg.ConversationAdapter", "doUpdateRecommendCard BizInfo is null");
              }
              else if ((localfle.abLF.YFu & 0x1) != 0)
              {
                af.bHl().yQ(localfle.YVJ);
                com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(1149L, 5L, 1L, false);
                Log.w("MicroMsg.ConversationAdapter", "doUpdateRecommendCard delete card by flag %d, msgId %d", new Object[] { Integer.valueOf(localfle.abLF.YFu), Long.valueOf(localfle.YVJ) });
              }
              else if (Util.isNullOrNil(localfle.abLF.UserName))
              {
                Log.i("MicroMsg.ConversationAdapter", "doUpdateRecommendCard UserName is null");
              }
              else if ((Util.isNullOrNil(localfle.YVI)) || (localfle.YVI.get(0) == null) || (Util.isNullOrNil(((flf)localfle.YVI.get(0)).YQK)))
              {
                Log.i("MicroMsg.ConversationAdapter", "doUpdateRecommendCard ContentUrl is null");
              }
              else if (!Util.isEqual(localfle.Zxo, localflh.Zxo))
              {
                ???.add(localfle);
              }
              else
              {
                Log.i("MicroMsg.ConversationAdapter", "doUpdateRecommendCard VersionInfo isEqual");
                if ((localfle.abLG != null) && (!Util.isEqual(localfle.abLG.Zxo, localflh.abLI)))
                {
                  ???.add(localfle);
                  Log.i("MicroMsg.ConversationAdapter", "doUpdateRecommendCard UserVersionInfo update");
                }
              }
            }
          }
        }
        Log.i("MicroMsg.ConversationAdapter", "doUpdateRecommendCard updateList size %d, RecCard.size %d", new Object[] { Integer.valueOf(???.size()), Integer.valueOf(paramAnonymousc.YVN.size()) });
        if (!Util.isNullOrNil(???))
        {
          paramAnonymousc = af.bHl();
          if (!Util.isNullOrNil(???))
          {
            paramAnonymousp = new LinkedList();
            g.jPX().h(new ac.8(paramAnonymousc, ???, paramAnonymousp)).b(new ac.7(paramAnonymousc, paramAnonymousp));
          }
        }
        AppMethodBeat.o(6242);
        return 0;
      }
    });
    AppMethodBeat.o(6254);
  }
  
  private static flh a(flj paramflj, ab paramab)
  {
    AppMethodBeat.i(6255);
    if ((paramflj == null) || (paramflj.abLK == null) || (paramab == null))
    {
      Log.i("MicroMsg.ConversationAdapter", "getTLRecCardLite invalid data");
      AppMethodBeat.o(6255);
      return null;
    }
    flh localflh = new flh();
    if (!Util.isNullOrNil(paramflj.abLK.YVI))
    {
      Iterator localIterator = paramflj.abLK.YVI.iterator();
      while (localIterator.hasNext())
      {
        flf localflf = (flf)localIterator.next();
        localflh.YTk.add(localflf.YQK);
      }
    }
    localflh.YRs = paramab.field_talker;
    localflh.YVJ = paramab.field_msgId;
    localflh.Zxo = paramflj.abLK.Zxo;
    localflh.bcb = paramflj.style;
    if (paramflj.abLK.abLG != null) {
      localflh.abLI = paramflj.abLK.abLG.Zxo;
    }
    AppMethodBeat.o(6255);
    return localflh;
  }
  
  public static void a(List<ab> paramList, final Runnable paramRunnable)
  {
    AppMethodBeat.i(6248);
    Looper.myQueue().addIdleHandler(new MessageQueue.IdleHandler()
    {
      public final boolean queueIdle()
      {
        AppMethodBeat.i(301637);
        Looper.myQueue().removeIdleHandler(this);
        com.tencent.mm.plugin.brandservice.b.au(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(301634);
            Iterator localIterator = d.this.iterator();
            while (localIterator.hasNext())
            {
              ab localab = (ab)localIterator.next();
              if (localab.iYe()) {
                ((com.tencent.mm.plugin.biz.a.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.biz.a.a.class)).c(localab.field_msgId, localab.field_content);
              }
            }
            d.eF(d.this);
            d.eG(d.this);
            MMHandlerThread.postToMainThread(d.2.this.val$callback);
            AppMethodBeat.o(301634);
          }
        });
        AppMethodBeat.o(301637);
        return false;
      }
    });
    AppMethodBeat.o(6248);
  }
  
  public static String ake(String paramString)
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
  
  public static boolean b(com.tencent.mm.bx.a parama1, com.tencent.mm.bx.a parama2)
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
  
  public static String dhS()
  {
    AppMethodBeat.i(6244);
    Object localObject2 = null;
    com.tencent.mm.aw.f localf = com.tencent.mm.aw.a.bLn();
    Object localObject1 = localObject2;
    if (localf != null)
    {
      localObject1 = localObject2;
      if (localf.oOv != null)
      {
        localObject1 = localObject2;
        if (localf.oOt == 0)
        {
          localObject1 = localObject2;
          if (com.tencent.mm.aw.a.bLk()) {
            localObject1 = localf.oOv;
          }
        }
      }
    }
    AppMethodBeat.o(6244);
    return localObject1;
  }
  
  public static void eD(List<ab> paramList)
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
      ab localab = (ab)paramList.next();
      if ((!vYF.containsKey(Long.valueOf(localab.field_msgId))) || (HY(((Integer)vYF.get(Long.valueOf(localab.field_msgId))).intValue()))) {
        if (localab.iYe())
        {
          q localq = new q();
          localq.msgId = localab.field_msgId;
          localq.nUB = localab.field_content;
          localLinkedList1.add(localq);
          vYF.put(Long.valueOf(localab.field_msgId), Integer.valueOf((int)(System.currentTimeMillis() / 1000L)));
        }
        else
        {
          vYF.put(Long.valueOf(localab.field_msgId), Integer.valueOf((int)(System.currentTimeMillis() / 1000L)));
          localLinkedList2.add(localab);
        }
      }
    }
    if (localLinkedList1.size() > 0) {
      ((com.tencent.mm.plugin.brandservice.api.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.brandservice.api.c.class)).u(localLinkedList1, 90);
    }
    AppMethodBeat.o(6247);
  }
  
  public static void eE(List<ab> paramList)
  {
    AppMethodBeat.i(6251);
    com.tencent.mm.plugin.brandservice.b.au(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(6241);
        d.eF(d.this);
        AppMethodBeat.o(6241);
      }
    });
    AppMethodBeat.o(6251);
  }
  
  public static void eF(List<ab> paramList)
  {
    AppMethodBeat.i(6252);
    int i = MultiProcessMMKV.getSingleMMKV("brandService").decodeInt("BizRecommendCardRefreshIntervalSec", 300);
    LinkedList localLinkedList = new LinkedList();
    long l = System.currentTimeMillis();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Object localObject = (ab)paramList.next();
      if ((((ab)localObject).iYf()) && (!j.j((ab)localObject)))
      {
        flj localflj = ((ab)localObject).iYp();
        if ((localflj != null) && (localflj.abLK != null) && (Math.abs(l - localflj.lastUpdateTime) / 1000L > i))
        {
          localObject = a(localflj, (ab)localObject);
          if (localObject != null) {
            localLinkedList.add(localObject);
          }
        }
      }
    }
    if (!Util.isNullOrNil(localLinkedList)) {
      O(localLinkedList);
    }
    AppMethodBeat.o(6252);
  }
  
  public static void eG(List<ab> paramList)
  {
    AppMethodBeat.i(301667);
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      ab localab = (ab)paramList.next();
      r localr = r.acDM;
      if ((r.iXl()) && (localab.iYg()))
      {
        r.acDM.B(localab);
      }
      else
      {
        localr = r.acDM;
        if ((r.iXo()) && (localab.iYf())) {
          r.acDM.B(localab);
        }
      }
    }
    AppMethodBeat.o(301667);
  }
  
  public static void eH(List<ab> paramList)
  {
    AppMethodBeat.i(301672);
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Object localObject = (ab)paramList.next();
      r localr = r.acDM;
      if ((r.iXl()) && (((ab)localObject).iYg()))
      {
        ((com.tencent.mm.plugin.brandservice.api.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.brandservice.api.c.class)).dbH();
        AppMethodBeat.o(301672);
        return;
      }
      localr = r.acDM;
      if ((r.iXo()) && (((ab)localObject).iYf()))
      {
        localObject = ((ab)localObject).iYp();
        if ((localObject != null) && (((flj)localObject).style == 1001))
        {
          ((com.tencent.mm.plugin.brandservice.api.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.brandservice.api.c.class)).dbH();
          AppMethodBeat.o(301672);
          return;
        }
      }
    }
    AppMethodBeat.o(301672);
  }
  
  public static void v(ab paramab)
  {
    AppMethodBeat.i(6246);
    if ((paramab == null) || (!paramab.iYe()))
    {
      AppMethodBeat.o(6246);
      return;
    }
    com.tencent.mm.plugin.brandservice.b.au(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(6239);
        if ((d.aYC().containsKey(Long.valueOf(d.this.field_msgId))) && (!d.HY(((Integer)d.aYC().get(Long.valueOf(d.this.field_msgId))).intValue())))
        {
          AppMethodBeat.o(6239);
          return;
        }
        List localList1 = af.bHl().bp(5, d.this.field_orderFlag);
        List localList2 = af.bHl().yG(d.this.field_orderFlag);
        LinkedList localLinkedList = new LinkedList();
        localLinkedList.addAll(localList1);
        localLinkedList.add(d.this);
        localLinkedList.addAll(localList2);
        d.eD(localLinkedList);
        AppMethodBeat.o(6239);
      }
    });
    AppMethodBeat.o(6246);
  }
  
  public static void w(ab paramab)
  {
    AppMethodBeat.i(6253);
    if ((paramab == null) || (!paramab.iYf()))
    {
      AppMethodBeat.o(6253);
      return;
    }
    flj localflj = paramab.iYp();
    if (j.j(paramab))
    {
      AppMethodBeat.o(6253);
      return;
    }
    int i = MultiProcessMMKV.getSingleMMKV("brandService").decodeInt("BizRecommendCardRefreshIntervalSec", 300);
    LinkedList localLinkedList = new LinkedList();
    long l = System.currentTimeMillis();
    if ((localflj != null) && (localflj.abLK != null) && (Math.abs(l - localflj.lastUpdateTime) / 1000L > i))
    {
      paramab = a(localflj, paramab);
      if (paramab != null) {
        localLinkedList.add(paramab);
      }
    }
    if (!Util.isNullOrNil(localLinkedList)) {
      O(localLinkedList);
    }
    AppMethodBeat.o(6253);
  }
  
  public static void x(ab paramab)
  {
    AppMethodBeat.i(301689);
    if ((paramab == null) || (!paramab.iYf()))
    {
      AppMethodBeat.o(301689);
      return;
    }
    com.tencent.mm.plugin.brandservice.b.au(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(301636);
        if ((d.aYC().containsKey(Long.valueOf(d.this.field_msgId))) && (!d.HY(((Integer)d.aYC().get(Long.valueOf(d.this.field_msgId))).intValue())))
        {
          AppMethodBeat.o(301636);
          return;
        }
        Object localObject1 = af.bHl().bp(5, d.this.field_orderFlag);
        Object localObject3 = af.bHl().yG(d.this.field_orderFlag);
        Object localObject2 = new LinkedList();
        ((List)localObject2).addAll((Collection)localObject1);
        ((List)localObject2).add(d.this);
        ((List)localObject2).addAll((Collection)localObject3);
        if (Util.isNullOrNil((List)localObject2))
        {
          AppMethodBeat.o(301636);
          return;
        }
        localObject1 = new LinkedList();
        localObject2 = ((List)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (ab)((Iterator)localObject2).next();
          if (((!d.aYC().containsKey(Long.valueOf(((ab)localObject3).field_msgId))) || (d.HY(((Integer)d.aYC().get(Long.valueOf(((ab)localObject3).field_msgId))).intValue()))) && (((ab)localObject3).acFD != null) && (((ab)localObject3).acFD.abLK != null) && (!Util.isNullOrNil(((ab)localObject3).acFD.abLK.YVI)) && (((ab)localObject3).iYf()) && ((((ab)localObject3).acFD.style == 3) || (((ab)localObject3).acFD.style == 5)))
          {
            int i = 0;
            while (i < ((ab)localObject3).acFD.abLK.YVI.size())
            {
              flf localflf = (flf)((ab)localObject3).acFD.abLK.YVI.get(i);
              q localq = new q();
              localq.Url = localflf.YQK;
              localq.nUA = localflf.nUA;
              localq.nUz = 1;
              ((List)localObject1).add(localq);
              i += 1;
            }
            d.aYC().put(Long.valueOf(((ab)localObject3).field_msgId), Integer.valueOf((int)(System.currentTimeMillis() / 1000L)));
          }
        }
        if (((List)localObject1).size() > 0) {
          ((com.tencent.mm.plugin.brandservice.api.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.brandservice.api.c.class)).eh((List)localObject1);
        }
        AppMethodBeat.o(301636);
      }
    });
    AppMethodBeat.o(301689);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.b.d
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.expt.model;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.g.a;
import com.tencent.mm.am.g.b;
import com.tencent.mm.autogen.a.adp;
import com.tencent.mm.autogen.a.cx;
import com.tencent.mm.autogen.a.gh;
import com.tencent.mm.autogen.a.og;
import com.tencent.mm.autogen.a.pm;
import com.tencent.mm.autogen.a.pn;
import com.tencent.mm.autogen.a.po;
import com.tencent.mm.autogen.a.pp;
import com.tencent.mm.autogen.a.ww;
import com.tencent.mm.autogen.a.wx;
import com.tencent.mm.autogen.a.wy;
import com.tencent.mm.autogen.a.wz;
import com.tencent.mm.autogen.a.xa;
import com.tencent.mm.autogen.a.xb;
import com.tencent.mm.autogen.mmdata.rpt.by;
import com.tencent.mm.autogen.mmdata.rpt.uk;
import com.tencent.mm.autogen.mmdata.rpt.ul;
import com.tencent.mm.kernel.f.c;
import com.tencent.mm.model.cl;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.expt.ui.ExptAppDebugUI;
import com.tencent.mm.plugin.expt.ui.ExptDebugUI;
import com.tencent.mm.plugin.messenger.foundation.a.v;
import com.tencent.mm.pointers.PBool;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.protocal.protobuf.fp;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.util.b.a;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;

public final class a
  implements com.tencent.mm.kernel.api.c, com.tencent.mm.plugin.expt.b.c
{
  private static a zLX;
  private int interval;
  private int osL;
  private final IListener<adp> qmv;
  public com.tencent.mm.plugin.expt.f.d zLY;
  public com.tencent.mm.plugin.expt.f.b zLZ;
  private final com.tencent.mm.b.f<Integer, com.tencent.mm.plugin.expt.e.c> zMa;
  private final com.tencent.mm.b.f<String, Integer> zMb;
  private final com.tencent.mm.plugin.messenger.foundation.a.s zMc;
  private final com.tencent.mm.am.h zMd;
  private final IListener<og> zMe;
  
  private a()
  {
    AppMethodBeat.i(122324);
    this.osL = 0;
    this.interval = 0;
    this.zMa = new com.tencent.mm.memory.a.c(500);
    this.zMb = new com.tencent.mm.memory.a.c(1000);
    this.qmv = new ExptService.1(this, com.tencent.mm.app.f.hfK);
    this.zMc = new com.tencent.mm.plugin.messenger.foundation.a.s()
    {
      public final g.b a(String paramAnonymousString, Map<String, String> paramAnonymousMap, g.a paramAnonymousa)
      {
        AppMethodBeat.i(122318);
        if (!"expt".equals(paramAnonymousString))
        {
          Log.w("MicroMsg.ExptService.Write", "receive expt xml but subtype[%s] is error", new Object[] { paramAnonymousString });
          AppMethodBeat.o(122318);
          return null;
        }
        if ((paramAnonymousMap == null) || (paramAnonymousMap.size() <= 0))
        {
          Log.w("MicroMsg.ExptService.Write", "receive expt xml but map is null");
          AppMethodBeat.o(122318);
          return null;
        }
        paramAnonymousString = (String)paramAnonymousMap.get(".sysmsg.content");
        if (Util.isNullOrNil(paramAnonymousString)) {
          Log.w("MicroMsg.ExptService.Write", "receive expt xml but content is null");
        }
        int i;
        do
        {
          i = 0;
          if (i == 0) {
            break;
          }
          AppMethodBeat.o(122318);
          return null;
          paramAnonymousMap = new com.tencent.mm.plugin.expt.e.a();
        } while ((!paramAnonymousMap.TZ(paramAnonymousString)) || (paramAnonymousMap.zNh != 1) || (paramAnonymousMap.zNd <= 0));
        paramAnonymousa = new LinkedList();
        LinkedList localLinkedList = new LinkedList();
        if (paramAnonymousMap.zNe < 0)
        {
          com.tencent.mm.plugin.report.service.h.OAn.p(863L, 164L, 1L);
          paramAnonymousa.add(Integer.valueOf(paramAnonymousMap.zNd));
        }
        for (;;)
        {
          a.b(0, paramAnonymousa, localLinkedList);
          i = 1;
          break;
          com.tencent.mm.plugin.report.service.h.OAn.p(863L, 165L, 1L);
          localLinkedList.add(paramAnonymousMap);
        }
        a.this.atm(paramAnonymousString);
        AppMethodBeat.o(122318);
        return null;
      }
    };
    this.zMd = new com.tencent.mm.am.h()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.am.p paramAnonymousp)
      {
        AppMethodBeat.i(122319);
        Log.i("MicroMsg.ExptService.Write", "scene[%d] errType[%d] errCode[%d] errMsg[%s]", new Object[] { Integer.valueOf(paramAnonymousp.hashCode()), Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
        if ((paramAnonymousp instanceof b)) {
          a.d(a.this);
        }
        AppMethodBeat.o(122319);
      }
    };
    this.zMe = new ExptService.4(this, com.tencent.mm.app.f.hfK);
    AppMethodBeat.o(122324);
  }
  
  public static void Md(int paramInt)
  {
    AppMethodBeat.i(299500);
    com.tencent.mm.kernel.h.aZW().a(new b(paramInt), 0);
    AppMethodBeat.o(299500);
  }
  
  public static com.tencent.mm.plugin.expt.e.a Mf(int paramInt)
  {
    AppMethodBeat.i(369876);
    com.tencent.mm.plugin.expt.e.a locala = com.tencent.mm.plugin.expt.e.b.dNr().Mh(paramInt);
    AppMethodBeat.o(369876);
    return locala;
  }
  
  public static void a(int paramInt, List<Integer> paramList, List<com.tencent.mm.plugin.expt.e.c> paramList1, List<fp> paramList2)
  {
    AppMethodBeat.i(299490);
    long l = Util.currentTicks();
    int k = 0;
    if (paramInt == 1)
    {
      com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(863L, 7L, 1L, false);
      localObject1 = dMQ();
      i = ((a)localObject1).zLY.dNJ();
      Log.i("MicroMsg.ExptService.Write", "delete all expt count[%d] map count[%d]", new Object[] { Integer.valueOf(i), Integer.valueOf(((a)localObject1).zLZ.dNJ()) });
      ((a)localObject1).dMP();
      if (com.tencent.mm.plugin.expt.f.c.dNK().dNL())
      {
        localObject1 = com.tencent.mm.plugin.expt.f.c.atj();
        if (localObject1 != null) {
          ((MultiProcessMMKV)localObject1).clear().commit();
        }
      }
      k = 1;
      Log.i("MicroMsg.ExptService.Write", "check need del all expt count[%d] cost[%d]", new Object[] { Integer.valueOf(i), Long.valueOf(Util.ticksToNow(l)) });
    }
    Object localObject1 = new HashSet();
    LinkedList localLinkedList1 = new LinkedList();
    LinkedList localLinkedList2 = new LinkedList();
    int j = 0;
    int i = j;
    Object localObject2;
    Object localObject3;
    com.tencent.mm.plugin.expt.e.c localc;
    if (paramList != null)
    {
      i = j;
      if (paramList.size() > 0)
      {
        Log.i("MicroMsg.ExptService.Write", "delete expt [%s]", new Object[] { Arrays.toString(paramList.toArray()) });
        localObject2 = paramList.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (Integer)((Iterator)localObject2).next();
          localc = dMQ().Mc(((Integer)localObject3).intValue());
          if (localc != null)
          {
            a(localc, localLinkedList1, localLinkedList2, true);
            dMQ();
            a(localc, true);
            ((HashSet)localObject1).add(localc);
            com.tencent.mm.plugin.report.f.Ozc.b(17582, new Object[] { localObject3 });
          }
        }
        localObject2 = dMQ();
        j = ((a)localObject2).zLY.fw(paramList);
        Log.i("MicroMsg.ExptService.Write", "delete expt ids deleteCount[%d] deleteMapCount[%d]", new Object[] { Integer.valueOf(j), Integer.valueOf(((a)localObject2).zLZ.fz(paramList)) });
        ((a)localObject2).dMP();
        com.tencent.mm.plugin.expt.f.c.dNK().fB(paramList);
        i = j;
        if (j >= 10)
        {
          com.tencent.mm.plugin.report.f.Ozc.idkeyStat(863L, 13L, 1L, false);
          i = j;
        }
      }
    }
    if ((paramList1 != null) && (paramList1.size() > 0))
    {
      localObject2 = new uk();
      localObject3 = paramList1.iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localc = (com.tencent.mm.plugin.expt.e.c)((Iterator)localObject3).next();
        if (localc != null)
        {
          Log.i("MicroMsg.ExptService.Write", "get expt item [%s]", new Object[] { localc.toString() });
          a(localc, localLinkedList1, localLinkedList2, false);
          dMQ();
          a(localc, false);
          ((HashSet)localObject1).add(localc);
          ((uk)localObject2).jHp = localc.field_exptId;
          ((uk)localObject2).jHq = localc.field_groupId;
          ((uk)localObject2).jHr = localc.field_exptSeq;
          ((uk)localObject2).gNE();
        }
      }
    }
    for (j = dMQ().fv(paramList1);; j = 0)
    {
      if ((k != 0) || (i > 0) || (j > 0))
      {
        dMQ();
        dMR();
      }
      if (!((HashSet)localObject1).isEmpty())
      {
        dMQ();
        b((HashSet)localObject1, null);
      }
      if (paramList2 != null)
      {
        a(localLinkedList1, paramList2, localLinkedList2);
        l = Util.ticksToNow(l);
        if (paramList == null) {
          break label747;
        }
        k = paramList.size();
        label638:
        if (paramList1 == null) {
          break label753;
        }
      }
      label747:
      label753:
      for (int m = paramList1.size();; m = 0)
      {
        Log.i("MicroMsg.ExptService.Write", "udpate expt cost[%s] flag[%d] deleteExptList[svr:%d local:%d] replaceExptList[svr:%d local:%d]", new Object[] { Long.valueOf(l), Integer.valueOf(paramInt), Integer.valueOf(k), Integer.valueOf(i), Integer.valueOf(m), Integer.valueOf(j) });
        AppMethodBeat.o(299490);
        return;
        if ((localLinkedList1.size() <= 0) && (localLinkedList2.size() <= 0)) {
          break;
        }
        a(localLinkedList1, null, localLinkedList2);
        break;
        k = 0;
        break label638;
      }
    }
  }
  
  private static void a(com.tencent.mm.plugin.expt.e.c paramc, List<com.tencent.mm.plugin.expt.e.c> paramList, List<Integer> paramList1, boolean paramBoolean)
  {
    AppMethodBeat.i(299510);
    if ((paramc != null) && (paramc.dNw()))
    {
      if (paramBoolean)
      {
        paramList1.add(Integer.valueOf(paramc.field_exptId));
        AppMethodBeat.o(299510);
        return;
      }
      paramList.add(paramc);
    }
    AppMethodBeat.o(299510);
  }
  
  private static void a(com.tencent.mm.plugin.expt.e.c paramc, boolean paramBoolean)
  {
    AppMethodBeat.i(299517);
    if (paramc == null)
    {
      AppMethodBeat.o(299517);
      return;
    }
    if (!paramc.dND())
    {
      AppMethodBeat.o(299517);
      return;
    }
    if (paramc.dNx())
    {
      dMQ();
      bn(paramc.dNH(), paramc.dNF());
    }
    if (paramc.dNy())
    {
      dMQ();
      ato(paramc.dNH());
    }
    if (paramc.dNz())
    {
      dMQ();
      d(paramc.dNG(), paramc.dNH(), paramc.dNF());
    }
    if ((paramc != null) && (paramc.dNA()))
    {
      dMQ();
      e(paramc.field_exptId, paramc.dNH(), paramBoolean);
    }
    if ((paramc != null) && (paramc.dNB()))
    {
      dMQ();
      f(paramc.field_exptId, paramc.dNH(), paramBoolean);
    }
    if ((paramc != null) && (paramc.dNC()))
    {
      dMQ();
      g(paramc.field_exptId, paramc.dNH(), paramBoolean);
    }
    AppMethodBeat.o(299517);
  }
  
  private static void a(List<com.tencent.mm.plugin.expt.e.c> paramList, List<fp> paramList1, List<Integer> paramList2)
  {
    AppMethodBeat.i(122344);
    LinkedList localLinkedList = new LinkedList();
    paramList = paramList.iterator();
    Object localObject1;
    Object localObject2;
    while (paramList.hasNext())
    {
      localObject1 = (com.tencent.mm.plugin.expt.e.c)paramList.next();
      if ((localObject1 != null) && (((com.tencent.mm.plugin.expt.e.c)localObject1).dNw()))
      {
        localObject2 = new com.tencent.mm.plugin.welab.b.c();
        ((com.tencent.mm.plugin.welab.b.c)localObject2).zNd = ((com.tencent.mm.plugin.expt.e.c)localObject1).field_exptId;
        ((com.tencent.mm.plugin.welab.b.c)localObject2).kW = ((com.tencent.mm.plugin.expt.e.c)localObject1).field_groupId;
        ((com.tencent.mm.plugin.welab.b.c)localObject2).startTime = ((com.tencent.mm.plugin.expt.e.c)localObject1).field_startTime;
        ((com.tencent.mm.plugin.welab.b.c)localObject2).endTime = ((com.tencent.mm.plugin.expt.e.c)localObject1).field_endTime;
        ((com.tencent.mm.plugin.welab.b.c)localObject2).zNf = ((com.tencent.mm.plugin.expt.e.c)localObject1).field_exptContent;
        ((com.tencent.mm.plugin.welab.b.c)localObject2).zNe = ((com.tencent.mm.plugin.expt.e.c)localObject1).field_exptSeq;
        ((com.tencent.mm.plugin.welab.b.c)localObject2).map = ((com.tencent.mm.plugin.expt.e.c)localObject1).dNo();
        localLinkedList.add(localObject2);
      }
    }
    paramList = new LinkedList();
    if (paramList1 != null)
    {
      paramList1 = paramList1.iterator();
      while (paramList1.hasNext())
      {
        localObject1 = (fp)paramList1.next();
        localObject2 = new com.tencent.mm.plugin.welab.b.d();
        ((com.tencent.mm.plugin.welab.b.d)localObject2).appId = ((fp)localObject1).appid;
        ((com.tencent.mm.plugin.welab.b.d)localObject2).status = ((fp)localObject1).status;
        paramList.add(localObject2);
      }
    }
    ((com.tencent.mm.plugin.welab.b.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.welab.b.a.class)).g(localLinkedList, paramList, paramList2);
    AppMethodBeat.o(122344);
  }
  
  private int atl(String paramString)
  {
    AppMethodBeat.i(122332);
    Integer localInteger = (Integer)this.zMb.get(paramString);
    if (localInteger != null)
    {
      i = localInteger.intValue();
      AppMethodBeat.o(122332);
      return i;
    }
    int i = this.zLZ.atl(paramString);
    this.zMb.put(paramString, Integer.valueOf(i));
    AppMethodBeat.o(122332);
    return i;
  }
  
  private static void atn(String paramString)
  {
    AppMethodBeat.i(299484);
    Log.v("MicroMsg.ExptService.Write", "notifyExptKeyChange [%s]", new Object[] { paramString });
    cx localcx = new cx();
    localcx.hCR.hCS = paramString;
    localcx.publish();
    AppMethodBeat.o(299484);
  }
  
  private static void ato(String paramString)
  {
    AppMethodBeat.i(299523);
    Log.i("MicroMsg.ExptService.Write", "notify session uba config json[%b] isDel[%b]", new Object[] { Boolean.valueOf(Util.isNullOrNil(paramString)), Boolean.FALSE });
    xa localxa = new xa();
    localxa.iaA.hMi = paramString;
    localxa.iaA.iat = Boolean.FALSE;
    localxa.publish();
    AppMethodBeat.o(299523);
  }
  
  public static void b(int paramInt, List<Integer> paramList, List<com.tencent.mm.plugin.expt.e.a> paramList1)
  {
    AppMethodBeat.i(299566);
    long l1 = Util.currentTicks();
    HashSet localHashSet = new HashSet();
    if (paramInt == 1) {
      com.tencent.mm.plugin.expt.e.b.dNr().dNu();
    }
    by localby = new by();
    Iterator localIterator;
    Object localObject1;
    long l2;
    Object localObject2;
    if ((paramList != null) && (paramList.size() > 0))
    {
      localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        i = ((Integer)localIterator.next()).intValue();
        localby.iuL = i;
        localby.iuM = 0;
        localby.ipH = 3;
        localby.gNE();
        localObject1 = com.tencent.mm.plugin.expt.e.b.dNr().Mh(i);
        localHashSet.add(localObject1);
        if ((localObject1 != null) && (((com.tencent.mm.plugin.expt.e.a)localObject1).dNp()))
        {
          dMQ();
          l2 = ((com.tencent.mm.plugin.expt.e.a)localObject1).zNd;
          Log.i("MicroMsg.ExptService.Write", "notifyNewEdgeScriptDelete configID [%d]", new Object[] { Long.valueOf(l2) });
          localObject2 = new pm();
          ((pm)localObject2).hSJ.hSK = l2;
          ((pm)localObject2).publish();
        }
        if ((localObject1 != null) && (((com.tencent.mm.plugin.expt.e.a)localObject1).dNq()))
        {
          dMQ();
          l2 = ((com.tencent.mm.plugin.expt.e.a)localObject1).zNd;
          Log.i("MicroMsg.ExptService.Write", "notifyNewEdgeSqlDelete configID [%d]", new Object[] { Long.valueOf(l2) });
          localObject1 = new po();
          ((po)localObject1).hSN.hSK = l2;
          ((po)localObject1).publish();
        }
      }
    }
    if ((paramList1 != null) && (paramList1.size() > 0))
    {
      localIterator = paramList1.iterator();
      while (localIterator.hasNext())
      {
        localObject1 = (com.tencent.mm.plugin.expt.e.a)localIterator.next();
        localHashSet.add(localObject1);
        localby.iuL = ((com.tencent.mm.plugin.expt.e.a)localObject1).zNd;
        localby.iuM = ((com.tencent.mm.plugin.expt.e.a)localObject1).zNe;
        localby.ipH = 2;
        localby.gNE();
        if (((com.tencent.mm.plugin.expt.e.a)localObject1).dNp())
        {
          dMQ();
          l2 = ((com.tencent.mm.plugin.expt.e.a)localObject1).zNd;
          Log.i("MicroMsg.ExptService.Write", "notifyNewEdgeScriptUpdate configID [%d]", new Object[] { Long.valueOf(l2) });
          localObject2 = new pn();
          ((pn)localObject2).hSL.hSK = l2;
          ((pn)localObject2).hSL.hSM = ((com.tencent.mm.plugin.expt.e.a)localObject1);
          ((pn)localObject2).publish();
        }
        if (((com.tencent.mm.plugin.expt.e.a)localObject1).dNq())
        {
          dMQ();
          l2 = ((com.tencent.mm.plugin.expt.e.a)localObject1).zNd;
          Log.i("MicroMsg.ExptService.Write", "notifyNewEdgeSqlUpdate configID [%d]", new Object[] { Long.valueOf(l2) });
          localObject2 = new pp();
          ((pp)localObject2).hSO.hSK = l2;
          ((pp)localObject2).hSO.hSM = ((com.tencent.mm.plugin.expt.e.a)localObject1);
          ((pp)localObject2).publish();
        }
      }
    }
    int i = com.tencent.mm.plugin.expt.e.b.dNr().fw(paramList);
    int j = com.tencent.mm.plugin.expt.e.b.dNr().fv(paramList1);
    dMR();
    b(null, localHashSet);
    Log.i("MicroMsg.ExptService.Write", "update Expt app flag = %d, delCount = %d, replaceCount = %d cost = %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i), Integer.valueOf(j), Long.valueOf(Util.ticksToNow(l1)) });
    AppMethodBeat.o(299566);
  }
  
  private static void b(HashSet<com.tencent.mm.plugin.expt.e.c> paramHashSet, HashSet<com.tencent.mm.plugin.expt.e.a> paramHashSet1)
  {
    AppMethodBeat.i(299481);
    long l = Util.currentTicks();
    int i;
    int j;
    if (paramHashSet != null)
    {
      paramHashSet = paramHashSet.iterator();
      for (i = 0; paramHashSet.hasNext(); i = j)
      {
        Object localObject = (com.tencent.mm.plugin.expt.e.c)paramHashSet.next();
        j = i;
        if (localObject != null)
        {
          localObject = ((com.tencent.mm.plugin.expt.e.c)localObject).dNo();
          j = i;
          if (localObject != null)
          {
            localObject = ((HashMap)localObject).keySet().iterator();
            for (;;)
            {
              j = i;
              if (!((Iterator)localObject).hasNext()) {
                break;
              }
              atn((String)((Iterator)localObject).next());
              i += 1;
            }
          }
        }
      }
    }
    for (int k = i;; k = 0)
    {
      if (paramHashSet1 != null)
      {
        paramHashSet = paramHashSet1.iterator();
        for (i = 0;; i = j)
        {
          j = i;
          if (!paramHashSet.hasNext()) {
            break;
          }
          paramHashSet1 = (com.tencent.mm.plugin.expt.e.a)paramHashSet.next();
          j = i;
          if (paramHashSet1 != null)
          {
            paramHashSet1 = paramHashSet1.dNo();
            j = i;
            if (paramHashSet1 != null)
            {
              paramHashSet1 = paramHashSet1.keySet().iterator();
              for (;;)
              {
                j = i;
                if (!paramHashSet1.hasNext()) {
                  break;
                }
                atn((String)paramHashSet1.next());
                i += 1;
              }
            }
          }
        }
      }
      j = 0;
      Log.i("MicroMsg.ExptService.Write", "notifyExptChange cost[%d] notifyExptCount[%d] notifyExptAppCount[%d]", new Object[] { Long.valueOf(Util.ticksToNow(l)), Integer.valueOf(k), Integer.valueOf(j) });
      AppMethodBeat.o(299481);
      return;
    }
  }
  
  private static void bn(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(299522);
    Log.i("MicroMsg.ExptService.Write", "notify session config json[%b] needReport[%b] isDel[%b]", new Object[] { Boolean.valueOf(Util.isNullOrNil(paramString)), Boolean.valueOf(paramBoolean), Boolean.FALSE });
    ww localww = new ww();
    localww.iar.hMi = paramString;
    localww.iar.iat = Boolean.valueOf(Util.isNullOrNil(paramString));
    localww.iar.ias = Boolean.valueOf(paramBoolean);
    localww.publish();
    AppMethodBeat.o(299522);
  }
  
  private static void d(long paramLong, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(299530);
    Log.i("MicroMsg.ExptService.Write", "notify session page config sessionPageId [%d] json[%s] needReport[%b] isDel[%b]", new Object[] { Long.valueOf(paramLong), paramString, Boolean.valueOf(paramBoolean), Boolean.FALSE });
    wz localwz = new wz();
    localwz.iax.iav = paramLong;
    localwz.iax.hMi = paramString;
    localwz.iax.iat = Boolean.FALSE;
    localwz.iax.iaz = Boolean.valueOf(paramBoolean);
    localwz.iax.iay = new ArrayList();
    localwz.iax.version = 1;
    localwz.publish();
    AppMethodBeat.o(299530);
  }
  
  private void dMO()
  {
    this.interval = 0;
    this.osL = 0;
  }
  
  private void dMP()
  {
    try
    {
      AppMethodBeat.i(122322);
      this.zMa.clear();
      this.zMb.clear();
      AppMethodBeat.o(122322);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static a dMQ()
  {
    AppMethodBeat.i(122323);
    if (zLX == null) {
      zLX = new a();
    }
    a locala = zLX;
    AppMethodBeat.o(122323);
    return locala;
  }
  
  private static void dMR()
  {
    AppMethodBeat.i(122337);
    new gh().publish();
    AppMethodBeat.o(122337);
  }
  
  private boolean dMT()
  {
    return (this.zLY == null) || (this.zLZ == null);
  }
  
  public static ArrayList<Integer> dMU()
  {
    AppMethodBeat.i(299571);
    Object localObject = com.tencent.mm.plugin.expt.e.b.dNr().dNv();
    ArrayList localArrayList = new ArrayList();
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        localArrayList.add(Integer.valueOf(((com.tencent.mm.plugin.expt.e.a)((Iterator)localObject).next()).zNd));
      }
    }
    AppMethodBeat.o(299571);
    return localArrayList;
  }
  
  private static void e(long paramLong, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(299536);
    Log.i("MicroMsg.ExptService.Write", "notify session view black list config sessionPageId [%d] json[%s] isDel[%b]", new Object[] { Long.valueOf(paramLong), paramString, Boolean.valueOf(paramBoolean) });
    xb localxb = new xb();
    localxb.iaB.iat = Boolean.valueOf(paramBoolean);
    localxb.iaB.hMi = paramString;
    localxb.iaB.iav = paramLong;
    localxb.publish();
    AppMethodBeat.o(299536);
  }
  
  private static void f(long paramLong, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(299542);
    Log.i("MicroMsg.ExptService.Write", "notify session edge script config sessionPageId [%d] json[%s] isDel[%b]", new Object[] { Long.valueOf(paramLong), paramString, Boolean.valueOf(paramBoolean) });
    wx localwx = new wx();
    localwx.iau.iat = Boolean.valueOf(paramBoolean);
    localwx.iau.hMi = paramString;
    localwx.iau.iav = paramLong;
    localwx.publish();
    AppMethodBeat.o(299542);
  }
  
  private int fv(List<com.tencent.mm.plugin.expt.e.c> paramList)
  {
    AppMethodBeat.i(122341);
    if ((paramList == null) || (paramList.size() <= 0))
    {
      AppMethodBeat.o(122341);
      return 0;
    }
    List localList = this.zLY.fC(paramList);
    LinkedList localLinkedList1 = new LinkedList();
    LinkedList localLinkedList2 = new LinkedList();
    int k;
    label144:
    label241:
    int j;
    int i;
    if (localList != null)
    {
      k = localList.size();
      Iterator localIterator1 = localList.iterator();
      while (localIterator1.hasNext())
      {
        com.tencent.mm.plugin.expt.e.c localc = (com.tencent.mm.plugin.expt.e.c)localIterator1.next();
        this.zMa.put(Integer.valueOf(localc.field_exptId), localc);
        Object localObject = localc.dNo();
        if (localObject != null)
        {
          Iterator localIterator2 = ((HashMap)localObject).keySet().iterator();
          String str;
          if (localIterator2.hasNext())
          {
            str = (String)localIterator2.next();
            localObject = this.zLZ.ats(str);
            if (localObject == null) {
              break label241;
            }
            if (((com.tencent.mm.plugin.expt.f.a)localObject).field_exptId == localc.field_exptId) {
              break label404;
            }
            ((com.tencent.mm.plugin.expt.f.a)localObject).field_exptId = localc.field_exptId;
            localLinkedList1.add(localObject);
          }
          for (;;)
          {
            this.zMb.put(((com.tencent.mm.plugin.expt.f.a)localObject).field_exptKey, Integer.valueOf(((com.tencent.mm.plugin.expt.f.a)localObject).field_exptId));
            break label144;
            break;
            localObject = new com.tencent.mm.plugin.expt.f.a();
            ((com.tencent.mm.plugin.expt.f.a)localObject).field_exptId = localc.field_exptId;
            ((com.tencent.mm.plugin.expt.f.a)localObject).field_exptKey = str;
            localLinkedList2.add(localObject);
          }
        }
      }
      j = this.zLZ.fx(localLinkedList2);
      i = this.zLZ.fy(localLinkedList1);
      if (!com.tencent.mm.plugin.expt.f.c.dNK().fA(localList)) {
        com.tencent.mm.plugin.report.service.h.OAn.kJ(863, 14);
      }
    }
    for (;;)
    {
      Log.i("MicroMsg.ExptService.Write", "replace ExptIds args[%d] db[%d] exptMap insert[list:%d  db:%d], update[list:%d db:%d]", new Object[] { Integer.valueOf(paramList.size()), Integer.valueOf(k), Integer.valueOf(localLinkedList2.size()), Integer.valueOf(j), Integer.valueOf(localLinkedList1.size()), Integer.valueOf(i) });
      AppMethodBeat.o(122341);
      return k;
      label404:
      break;
      i = 0;
      j = 0;
      k = 0;
    }
  }
  
  private static void g(long paramLong, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(299547);
    Log.i("MicroMsg.ExptService.Write", "notify session edge sql config sessionPageId [%d] json[%s] isDel[%b]", new Object[] { Long.valueOf(paramLong), paramString, Boolean.valueOf(paramBoolean) });
    wy localwy = new wy();
    localwy.iaw.iat = Boolean.valueOf(paramBoolean);
    localwy.iaw.hMi = paramString;
    localwy.iaw.iav = paramLong;
    localwy.publish();
    AppMethodBeat.o(299547);
  }
  
  public static void he(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(299554);
    if (paramInt1 <= 0)
    {
      AppMethodBeat.o(299554);
      return;
    }
    if (paramInt2 <= 0)
    {
      AppMethodBeat.o(299554);
      return;
    }
    if (((Integer)com.tencent.mm.kernel.h.baE().ban().get(at.a.acWA, Integer.valueOf(86400))).intValue() == paramInt1)
    {
      AppMethodBeat.o(299554);
      return;
    }
    int i = ((Integer)com.tencent.mm.kernel.h.baE().ban().get(at.a.acWB, Integer.valueOf(0))).intValue();
    int j = (int)Util.nowSecond();
    if (j - i >= paramInt1)
    {
      paramInt2 = Math.min(i, j + paramInt2 - paramInt1);
      com.tencent.mm.kernel.h.baE().ban().set(at.a.acWB, Integer.valueOf(paramInt2));
    }
    com.tencent.mm.kernel.h.baE().ban().set(at.a.acWA, Integer.valueOf(paramInt1));
    AppMethodBeat.o(299554);
  }
  
  private String hv(String paramString1, String paramString2)
  {
    AppMethodBeat.i(299474);
    long l = Util.currentTicks();
    if (paramString1 == null)
    {
      AppMethodBeat.o(299474);
      return paramString2;
    }
    Object localObject1 = new PString();
    int i = com.tencent.mm.plugin.expt.e.b.dNr().a(paramString1, paramString2, (PString)localObject1);
    if (i > 0)
    {
      com.tencent.mm.plugin.expt.a.a.dHH();
      com.tencent.mm.plugin.expt.a.a.Lr(i);
      Log.i("MicroMsg.ExptService", "API check ExptApp from mmkv result[%s, %d] key[%s] def[%s] cost[%d]", new Object[] { ((PString)localObject1).value, Integer.valueOf(i), paramString1, paramString2, Long.valueOf(Util.ticksToNow(l)) });
      paramString1 = ((PString)localObject1).value;
      AppMethodBeat.o(299474);
      return paramString1;
    }
    if (dMT())
    {
      com.tencent.mm.plugin.expt.f.c.dNK();
      localObject1 = com.tencent.mm.plugin.expt.f.c.hx(paramString1, paramString2);
      Log.i("MicroMsg.ExptService", "API check Expt from mmkv result[%s] key[%s] def[%s] cost[%d]", new Object[] { localObject1, paramString1, paramString2, Long.valueOf(Util.ticksToNow(l)) });
      AppMethodBeat.o(299474);
      return localObject1;
    }
    i = atl(paramString1);
    localObject1 = new ul();
    PBool localPBool = new PBool();
    Object localObject2 = a(i, true, (ul)localObject1, localPBool);
    if ((localObject2 == null) || (((HashMap)localObject2).size() <= 0))
    {
      AppMethodBeat.o(299474);
      return paramString2;
    }
    localObject2 = (String)((HashMap)localObject2).get(paramString1);
    if ((!Util.isNullOrNil((String)localObject2)) && (localPBool.value)) {
      ((ul)localObject1).Ai(paramString1).Aj((String)localObject2).gNG();
    }
    Log.i("MicroMsg.ExptService", "API Got Expt result[%s] exptId[%d] key[%s] defStr[%s] cost[%d]", new Object[] { localObject2, Integer.valueOf(i), paramString1, paramString2, Long.valueOf(Util.ticksToNow(l)) });
    if (!Util.isNullOrNil((String)localObject2))
    {
      AppMethodBeat.o(299474);
      return localObject2;
    }
    AppMethodBeat.o(299474);
    return paramString2;
  }
  
  public static void pd(boolean paramBoolean)
  {
    AppMethodBeat.i(299558);
    aq localaq = com.tencent.mm.kernel.h.baE().ban();
    at.a locala = at.a.acWD;
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      localaq.set(locala, Integer.valueOf(i));
      AppMethodBeat.o(299558);
      return;
    }
  }
  
  public final void K(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(122325);
    paramIntent.setClass(paramContext, ExptDebugUI.class);
    paramIntent = new com.tencent.mm.hellhoundlib.b.a().cG(paramIntent);
    com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramIntent.aYi(), "com/tencent/mm/plugin/expt/model/ExptService", "showExptUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)paramIntent.sb(0));
    com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/plugin/expt/model/ExptService", "showExptUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(122325);
  }
  
  public final void L(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(299594);
    paramIntent.setClass(paramContext, ExptAppDebugUI.class);
    paramIntent = new com.tencent.mm.hellhoundlib.b.a().cG(paramIntent);
    com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramIntent.aYi(), "com/tencent/mm/plugin/expt/model/ExptService", "showExptAppUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)paramIntent.sb(0));
    com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/plugin/expt/model/ExptService", "showExptAppUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(299594);
  }
  
  public final com.tencent.mm.plugin.expt.e.c Mc(int paramInt)
  {
    AppMethodBeat.i(122331);
    com.tencent.mm.plugin.expt.e.c localc = (com.tencent.mm.plugin.expt.e.c)this.zMa.get(Integer.valueOf(paramInt));
    if (localc != null)
    {
      AppMethodBeat.o(122331);
      return localc;
    }
    localc = this.zLY.Mk(paramInt);
    if (localc != null) {
      this.zMa.put(Integer.valueOf(paramInt), localc);
    }
    AppMethodBeat.o(122331);
    return localc;
  }
  
  public final void Me(int paramInt)
  {
    AppMethodBeat.i(299668);
    if (!a(c.a.zqy, true))
    {
      AppMethodBeat.o(299668);
      return;
    }
    com.tencent.mm.kernel.h.aZW().a(new c(paramInt), 0);
    AppMethodBeat.o(299668);
  }
  
  public final float a(c.a parama, float paramFloat)
  {
    AppMethodBeat.i(122327);
    parama = b(parama, "");
    if (Util.isNullOrNil(parama))
    {
      AppMethodBeat.o(122327);
      return paramFloat;
    }
    paramFloat = Util.getFloat(parama, paramFloat);
    AppMethodBeat.o(122327);
    return paramFloat;
  }
  
  public final int a(c.a parama, int paramInt)
  {
    AppMethodBeat.i(122328);
    parama = b(parama, "");
    if (Util.isNullOrNil(parama))
    {
      AppMethodBeat.o(122328);
      return paramInt;
    }
    paramInt = Util.getInt(parama, paramInt);
    AppMethodBeat.o(122328);
    return paramInt;
  }
  
  public final int a(c.a parama, b.a parama1, int paramInt)
  {
    AppMethodBeat.i(299672);
    com.tencent.mm.util.i locali = com.tencent.mm.util.i.agtt;
    paramInt = a(parama, ((Integer)com.tencent.mm.util.i.a(parama1, Integer.valueOf(paramInt))).intValue());
    AppMethodBeat.o(299672);
    return paramInt;
  }
  
  public final long a(c.a parama, long paramLong)
  {
    AppMethodBeat.i(122329);
    parama = b(parama, "");
    if (Util.isNullOrNil(parama))
    {
      AppMethodBeat.o(122329);
      return paramLong;
    }
    paramLong = Util.getLong(parama, paramLong);
    AppMethodBeat.o(122329);
    return paramLong;
  }
  
  public final String a(c.a parama, String paramString)
  {
    AppMethodBeat.i(369877);
    parama = b(parama, paramString);
    AppMethodBeat.o(369877);
    return parama;
  }
  
  public final HashMap<String, String> a(int paramInt, boolean paramBoolean, ul paramul, PBool paramPBool)
  {
    AppMethodBeat.i(122333);
    if (this.zLY == null)
    {
      Log.e("MicroMsg.ExptService", "Expt service is not init here! exptId[%d]", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(122333);
      return null;
    }
    if (paramInt <= 0)
    {
      AppMethodBeat.o(122333);
      return null;
    }
    long l = Util.currentTicks();
    Object localObject1 = null;
    Object localObject2 = null;
    com.tencent.mm.plugin.expt.e.c localc = Mc(paramInt);
    if ((localc == null) || (Util.isNullOrNil(localc.field_exptContent)))
    {
      Log.w("MicroMsg.ExptService", "expt item is null or expt content is null.");
      if (localObject1 == null) {
        break label325;
      }
    }
    label325:
    for (paramul = (ul)localObject1;; paramul = Integer.valueOf(0))
    {
      Log.v("MicroMsg.ExptService", "get expt [%d] map[%s] expt[%s] cost[%d]", new Object[] { Integer.valueOf(paramInt), paramul, localObject2, Long.valueOf(Util.ticksToNow(l)) });
      AppMethodBeat.o(122333);
      return localObject1;
      String str = localc.field_exptContent;
      if ((paramBoolean) && (!localc.isReady()))
      {
        Log.w("MicroMsg.ExptService", "expt time is invalid time[%d %d] seq[%d]", new Object[] { Long.valueOf(localc.field_startTime), Long.valueOf(localc.field_endTime), Integer.valueOf(localc.field_exptSeq) });
        localObject2 = str;
        break;
      }
      HashMap localHashMap = localc.dNo();
      localObject2 = str;
      localObject1 = localHashMap;
      if (!localc.dNE()) {
        break;
      }
      paramPBool.value = true;
      localObject2 = str;
      localObject1 = localHashMap;
      if (paramul == null) {
        break;
      }
      paramul.jHp = localc.field_exptId;
      paramul.jHq = localc.field_groupId;
      paramul.jHr = localc.field_exptSeq;
      paramul.jbA = localc.field_startTime;
      paramul.jHs = localc.field_endTime;
      localObject2 = str;
      localObject1 = localHashMap;
      break;
    }
  }
  
  public final boolean a(c.a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(122326);
    parama = b(parama, "");
    if (Util.isNullOrNil(parama))
    {
      AppMethodBeat.o(122326);
      return paramBoolean;
    }
    if (paramBoolean) {}
    for (int i = 1; Util.getInt(parama, i) != 0; i = 0)
    {
      AppMethodBeat.o(122326);
      return true;
    }
    AppMethodBeat.o(122326);
    return false;
  }
  
  public final String aqb(String paramString)
  {
    AppMethodBeat.i(299676);
    paramString = hv(paramString, null);
    AppMethodBeat.o(299676);
    return paramString;
  }
  
  public final void atm(String paramString)
  {
    AppMethodBeat.i(122336);
    if (Util.isNullOrNil(paramString))
    {
      Log.w("MicroMsg.ExptService", "receive expt xml but content is null");
      AppMethodBeat.o(122336);
      return;
    }
    LinkedList localLinkedList1 = new LinkedList();
    LinkedList localLinkedList2 = new LinkedList();
    com.tencent.mm.plugin.expt.e.c localc = new com.tencent.mm.plugin.expt.e.c();
    if (localc.TZ(paramString)) {
      if (localc.field_exptId == 0) {
        com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(863L, 9L, 1L, false);
      }
    }
    label398:
    for (;;)
    {
      try
      {
        int i = new JSONObject(paramString).optInt("TryGetTime");
        if (i > 0) {
          break label398;
        }
        i = 1;
        com.tencent.mm.kernel.h.baC();
        paramString = new com.tencent.mm.b.p(com.tencent.mm.kernel.b.getUin());
        int j = (int)Math.abs(paramString.longValue() % i);
        int k = (int)Util.nowSecond() + j * 60 - 86400;
        int m = ((Integer)com.tencent.mm.kernel.h.baE().ban().get(at.a.acWz, Integer.valueOf(0))).intValue();
        int n = Math.min(m, k);
        com.tencent.mm.kernel.h.baE().ban().set(at.a.acWz, Integer.valueOf(n));
        dMO();
        Log.i("MicroMsg.ExptService.Write", "reset get expt time tryGetTime[%d] uin[%d] hashTime[%d] needUpdateTime[%d] lastTime[%d] fixLastUpdateTime[%d]", new Object[] { Integer.valueOf(i), Long.valueOf(paramString.longValue()), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(n) });
        AppMethodBeat.o(122336);
        return;
      }
      catch (Exception paramString)
      {
        Log.printErrStackTrace("MicroMsg.ExptService", paramString, "on get xml msg reset get expt time error [%s]", new Object[] { paramString.toString() });
        AppMethodBeat.o(122336);
        return;
      }
      if (localc.field_exptSeq < 0)
      {
        com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(863L, 3L, 1L, false);
        localLinkedList1.add(Integer.valueOf(localc.field_exptId));
      }
      for (;;)
      {
        a(0, localLinkedList1, localLinkedList2, null);
        Log.i("MicroMsg.ExptService.Write", "received expt xml [%s] ", new Object[] { paramString });
        AppMethodBeat.o(122336);
        return;
        com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(863L, 4L, 1L, false);
        localLinkedList2.add(localc);
      }
    }
  }
  
  public final String b(c.a parama, String paramString)
  {
    AppMethodBeat.i(299617);
    if (parama == null) {}
    for (parama = null;; parama = parama.name())
    {
      parama = hv(parama, paramString);
      AppMethodBeat.o(299617);
      return parama;
    }
  }
  
  public final ArrayList<Integer> dMS()
  {
    AppMethodBeat.i(299661);
    if (this.zLY != null)
    {
      ArrayList localArrayList = this.zLY.dNN();
      AppMethodBeat.o(299661);
      return localArrayList;
    }
    AppMethodBeat.o(299661);
    return null;
  }
  
  public final void onAccountInitialized(f.c paramc)
  {
    AppMethodBeat.i(122334);
    Log.i("MicroMsg.ExptService", "onAccountInitialized, %d", new Object[] { Integer.valueOf(hashCode()) });
    Log.v("MicroMsg.ExptService", "add listener ");
    if (MMApplicationContext.isMainProcess())
    {
      this.qmv.alive();
      this.zMe.alive();
      com.tencent.mm.kernel.h.aZW().a(2738, this.zMd);
      ((v)com.tencent.mm.kernel.h.az(v.class)).getSysCmdMsgExtension().a("expt", this.zMc);
    }
    if (paramc != null) {}
    try
    {
      if (paramc.mDg)
      {
        Log.i("MicroMsg.ExptService", "client upgrade now, reset last update time. previous version [%d]", new Object[] { Integer.valueOf(paramc.mDh) });
        this.osL = 0;
        com.tencent.mm.kernel.h.baE().ban().set(at.a.acWz, Integer.valueOf(0));
        Me(3);
      }
      paramc = com.tencent.mm.plugin.expt.shell.a.zNo;
      com.tencent.mm.plugin.expt.shell.a.setup();
      AppMethodBeat.o(122334);
      return;
    }
    catch (Exception paramc)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.ExptService", paramc, "onAccountInitialized error[%s]", new Object[] { paramc.toString() });
      }
    }
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(122335);
    Log.i("MicroMsg.ExptService", "onAccountRelease");
    dMP();
    this.qmv.dead();
    this.zMe.dead();
    com.tencent.mm.kernel.h.aZW().b(2738, this.zMd);
    ((v)com.tencent.mm.kernel.h.az(v.class)).getSysCmdMsgExtension().b("expt", this.zMc);
    com.tencent.threadpool.h.ahAA.bFQ("manual_get_expt");
    com.tencent.mm.plugin.expt.shell.a locala = com.tencent.mm.plugin.expt.shell.a.zNo;
    com.tencent.mm.plugin.expt.shell.a.destroy();
    AppMethodBeat.o(122335);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.model.a
 * JD-Core Version:    0.7.0.1
 */
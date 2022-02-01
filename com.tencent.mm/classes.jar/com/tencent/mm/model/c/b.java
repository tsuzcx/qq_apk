package com.tencent.mm.model.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.aa;
import com.tencent.mm.ak.aa.a;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.protobuf.akc;
import com.tencent.mm.protocal.protobuf.bhl;
import com.tencent.mm.protocal.protobuf.bhm;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;

public final class b
{
  private static boolean gc = false;
  
  static void aXm()
  {
    int j = 1;
    AppMethodBeat.i(153110);
    if (!g.aAc())
    {
      Log.i("MicroMsg.ABTestUpdater", "Update aborted, Account not ready.");
      AppMethodBeat.o(153110);
      return;
    }
    Object localObject = (Long)g.aAh().azQ().get(ar.a.NUI, null);
    if (localObject == null) {}
    int i;
    for (long l1 = 0L; l1 == 0L; l1 = ((Long)localObject).longValue())
    {
      i = new Random().nextInt(86400);
      sy(i);
      aXo();
      aXq();
      Log.i("MicroMsg.ABTestUpdater", "First update ignored. Next update: %d", new Object[] { Integer.valueOf(i) });
      i = j;
      if (i != 0) {
        break label260;
      }
      Log.v("MicroMsg.ABTestUpdater", "No need to update");
      AppMethodBeat.o(153110);
      return;
    }
    localObject = (Integer)g.aAh().azQ().get(ar.a.NUJ, null);
    label160:
    long l2;
    long l3;
    if ((localObject == null) || (((Integer)localObject).intValue() == 0))
    {
      i = 86400;
      l2 = i;
      l3 = System.currentTimeMillis() / 1000L;
      if (l3 <= l1 + l2) {
        break label254;
      }
    }
    label254:
    for (boolean bool = true;; bool = false)
    {
      Log.i("MicroMsg.ABTestUpdater", "Need Update: %b, Last Update Time: %d, Update Interval: %d, Current Time: %d", new Object[] { Boolean.valueOf(bool), Long.valueOf(l1), Long.valueOf(l2), Long.valueOf(l3) });
      i = j;
      if (l3 > l1 + l2) {
        break;
      }
      i = 0;
      break;
      i = ((Integer)localObject).intValue();
      break label160;
    }
    label260:
    if (gc)
    {
      Log.i("MicroMsg.ABTestUpdater", "Updating");
      AppMethodBeat.o(153110);
      return;
    }
    update();
    AppMethodBeat.o(153110);
  }
  
  static void aXn()
  {
    AppMethodBeat.i(153111);
    if (!g.aAc())
    {
      Log.i("MicroMsg.ABTestUpdater", "UpdateWithoutIntervalLimit aborted, Account not ready.");
      AppMethodBeat.o(153111);
      return;
    }
    if (gc)
    {
      Log.i("MicroMsg.ABTestUpdater", "UpdateWithoutIntervalLimit, Already Updating");
      AppMethodBeat.o(153111);
      return;
    }
    Log.i("MicroMsg.ABTestUpdater", "UpdateWithoutIntervalLimit, before do update");
    update();
    AppMethodBeat.o(153111);
  }
  
  private static void aXo()
  {
    AppMethodBeat.i(153114);
    long l = System.currentTimeMillis() / 1000L;
    g.aAh().azQ().set(ar.a.NUI, Long.valueOf(l));
    AppMethodBeat.o(153114);
  }
  
  private static int aXp()
  {
    AppMethodBeat.i(153116);
    Integer localInteger = (Integer)g.aAh().azQ().get(ar.a.NUH, null);
    if (localInteger == null)
    {
      AppMethodBeat.o(153116);
      return 0;
    }
    int i = localInteger.intValue();
    AppMethodBeat.o(153116);
    return i;
  }
  
  private static void aXq()
  {
    AppMethodBeat.i(153117);
    g.aAh().azQ().gBI();
    AppMethodBeat.o(153117);
  }
  
  private static String c(LinkedList<akc> paramLinkedList)
  {
    AppMethodBeat.i(153112);
    Iterator localIterator = paramLinkedList.iterator();
    akc localakc;
    for (paramLinkedList = ""; localIterator.hasNext(); paramLinkedList = paramLinkedList + localakc.Lqu + ":" + localakc.priority + "|") {
      localakc = (akc)localIterator.next();
    }
    AppMethodBeat.o(153112);
    return paramLinkedList;
  }
  
  private static void sy(int paramInt)
  {
    AppMethodBeat.i(153115);
    int i = 0;
    if (paramInt == 0) {}
    for (i = 86400;; i = new Random().nextInt(126000) + 3600) {
      do
      {
        g.aAh().azQ().set(ar.a.NUJ, Integer.valueOf(i));
        AppMethodBeat.o(153115);
        return;
      } while ((paramInt >= 3600) && (paramInt <= 129600));
    }
  }
  
  private static void update()
  {
    AppMethodBeat.i(153113);
    gc = true;
    Object localObject = new d.a();
    ((d.a)localObject).iLN = new bhl();
    ((d.a)localObject).iLO = new bhm();
    ((d.a)localObject).uri = "/cgi-bin/mmux-bin/getabtest";
    ((d.a)localObject).funcId = 1801;
    localObject = ((d.a)localObject).aXF();
    bhl localbhl = (bhl)((com.tencent.mm.ak.d)localObject).iLK.iLR;
    localbhl.LRW = aXp();
    localbhl.LRX = d.aXu().gzx();
    localbhl.LRX.addAll(d.aXv().gzx());
    Log.i("MicroMsg.ABTestUpdater", "update abtest: %s", new Object[] { c(localbhl.LRX) });
    aa.a((com.tencent.mm.ak.d)localObject, new aa.a()
    {
      public final int a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.ak.d paramAnonymousd, q paramAnonymousq)
      {
        AppMethodBeat.i(153109);
        b.TT();
        if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
        {
          Log.e("MicroMsg.ABTestUpdater", "Update Error: %d, %d, next update will be performed %d(s) later", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), Integer.valueOf(86400) });
          b.access$100();
          b.sz(86400);
          b.access$300();
          AppMethodBeat.o(153109);
          return 0;
        }
        paramAnonymousString = (bhm)paramAnonymousd.iLL.iLR;
        b.access$100();
        b.sA(paramAnonymousString.Timestamp);
        b.sz(paramAnonymousString.LSa);
        b.at(paramAnonymousString.LSb);
        b.au(paramAnonymousString.LRZ);
        b.access$300();
        Log.i("MicroMsg.ABTestUpdater", "Update Interval: %d", new Object[] { Integer.valueOf(paramAnonymousString.LSa) });
        AppMethodBeat.o(153109);
        return 0;
      }
    }, true);
    AppMethodBeat.o(153113);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.model.c.b
 * JD-Core Version:    0.7.0.1
 */
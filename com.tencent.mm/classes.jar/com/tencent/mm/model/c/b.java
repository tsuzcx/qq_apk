package com.tencent.mm.model.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.x;
import com.tencent.mm.ak.x.a;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.protobuf.ahq;
import com.tencent.mm.protocal.protobuf.awb;
import com.tencent.mm.protocal.protobuf.awc;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;

public final class b
{
  private static boolean ga = false;
  
  static void aDA()
  {
    int j = 1;
    AppMethodBeat.i(153110);
    if (!g.ajM())
    {
      ae.i("MicroMsg.ABTestUpdater", "Update aborted, Account not ready.");
      AppMethodBeat.o(153110);
      return;
    }
    Object localObject = (Long)g.ajR().ajA().get(am.a.IMG, null);
    if (localObject == null) {}
    int i;
    for (long l1 = 0L; l1 == 0L; l1 = ((Long)localObject).longValue())
    {
      i = new Random().nextInt(86400);
      oK(i);
      aDC();
      aDE();
      ae.i("MicroMsg.ABTestUpdater", "First update ignored. Next update: %d", new Object[] { Integer.valueOf(i) });
      i = j;
      if (i != 0) {
        break label260;
      }
      ae.v("MicroMsg.ABTestUpdater", "No need to update");
      AppMethodBeat.o(153110);
      return;
    }
    localObject = (Integer)g.ajR().ajA().get(am.a.IMH, null);
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
      ae.i("MicroMsg.ABTestUpdater", "Need Update: %b, Last Update Time: %d, Update Interval: %d, Current Time: %d", new Object[] { Boolean.valueOf(bool), Long.valueOf(l1), Long.valueOf(l2), Long.valueOf(l3) });
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
    if (ga)
    {
      ae.i("MicroMsg.ABTestUpdater", "Updating");
      AppMethodBeat.o(153110);
      return;
    }
    update();
    AppMethodBeat.o(153110);
  }
  
  static void aDB()
  {
    AppMethodBeat.i(153111);
    if (!g.ajM())
    {
      ae.i("MicroMsg.ABTestUpdater", "UpdateWithoutIntervalLimit aborted, Account not ready.");
      AppMethodBeat.o(153111);
      return;
    }
    if (ga)
    {
      ae.i("MicroMsg.ABTestUpdater", "UpdateWithoutIntervalLimit, Already Updating");
      AppMethodBeat.o(153111);
      return;
    }
    ae.i("MicroMsg.ABTestUpdater", "UpdateWithoutIntervalLimit, before do update");
    update();
    AppMethodBeat.o(153111);
  }
  
  private static void aDC()
  {
    AppMethodBeat.i(153114);
    long l = System.currentTimeMillis() / 1000L;
    g.ajR().ajA().set(am.a.IMG, Long.valueOf(l));
    AppMethodBeat.o(153114);
  }
  
  private static int aDD()
  {
    AppMethodBeat.i(153116);
    Integer localInteger = (Integer)g.ajR().ajA().get(am.a.IMF, null);
    if (localInteger == null)
    {
      AppMethodBeat.o(153116);
      return 0;
    }
    int i = localInteger.intValue();
    AppMethodBeat.o(153116);
    return i;
  }
  
  private static void aDE()
  {
    AppMethodBeat.i(153117);
    g.ajR().ajA().fuc();
    AppMethodBeat.o(153117);
  }
  
  private static String c(LinkedList<ahq> paramLinkedList)
  {
    AppMethodBeat.i(153112);
    Iterator localIterator = paramLinkedList.iterator();
    ahq localahq;
    for (paramLinkedList = ""; localIterator.hasNext(); paramLinkedList = paramLinkedList + localahq.GuP + ":" + localahq.priority + "|") {
      localahq = (ahq)localIterator.next();
    }
    AppMethodBeat.o(153112);
    return paramLinkedList;
  }
  
  private static void oK(int paramInt)
  {
    AppMethodBeat.i(153115);
    int i = 0;
    if (paramInt == 0) {}
    for (i = 86400;; i = new Random().nextInt(126000) + 3600) {
      do
      {
        g.ajR().ajA().set(am.a.IMH, Integer.valueOf(i));
        AppMethodBeat.o(153115);
        return;
      } while ((paramInt >= 3600) && (paramInt <= 129600));
    }
  }
  
  private static void update()
  {
    AppMethodBeat.i(153113);
    ga = true;
    Object localObject = new b.a();
    ((b.a)localObject).hQF = new awb();
    ((b.a)localObject).hQG = new awc();
    ((b.a)localObject).uri = "/cgi-bin/mmux-bin/getabtest";
    ((b.a)localObject).funcId = 1801;
    localObject = ((b.a)localObject).aDS();
    awb localawb = (awb)((com.tencent.mm.ak.b)localObject).hQD.hQJ;
    localawb.GNQ = aDD();
    localawb.GNR = d.aDI().fsw();
    localawb.GNR.addAll(d.aDJ().fsw());
    ae.i("MicroMsg.ABTestUpdater", "update abtest: %s", new Object[] { c(localawb.GNR) });
    x.a((com.tencent.mm.ak.b)localObject, new x.a()
    {
      public final int a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.ak.b paramAnonymousb, n paramAnonymousn)
      {
        AppMethodBeat.i(153109);
        b.JG();
        if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
        {
          ae.e("MicroMsg.ABTestUpdater", "Update Error: %d, %d, next update will be performed %d(s) later", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), Integer.valueOf(86400) });
          b.access$100();
          b.oL(86400);
          b.access$300();
          AppMethodBeat.o(153109);
          return 0;
        }
        paramAnonymousString = (awc)paramAnonymousb.hQE.hQJ;
        b.access$100();
        b.oM(paramAnonymousString.Timestamp);
        b.oL(paramAnonymousString.GNU);
        b.ak(paramAnonymousString.GNV);
        b.al(paramAnonymousString.GNT);
        b.access$300();
        ae.i("MicroMsg.ABTestUpdater", "Update Interval: %d", new Object[] { Integer.valueOf(paramAnonymousString.GNU) });
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
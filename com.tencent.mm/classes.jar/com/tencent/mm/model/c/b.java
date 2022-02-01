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
import com.tencent.mm.protocal.protobuf.aex;
import com.tencent.mm.protocal.protobuf.arp;
import com.tencent.mm.protocal.protobuf.arq;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;

public final class b
{
  private static boolean eg = false;
  
  static void aAh()
  {
    int j = 1;
    AppMethodBeat.i(153110);
    if (!g.agM())
    {
      ac.i("MicroMsg.ABTestUpdater", "Update aborted, Account not ready.");
      AppMethodBeat.o(153110);
      return;
    }
    Object localObject = (Long)g.agR().agA().get(ah.a.GFS, null);
    if (localObject == null) {}
    int i;
    for (long l1 = 0L; l1 == 0L; l1 = ((Long)localObject).longValue())
    {
      i = new Random().nextInt(86400);
      oh(i);
      aAj();
      aAl();
      ac.i("MicroMsg.ABTestUpdater", "First update ignored. Next update: %d", new Object[] { Integer.valueOf(i) });
      i = j;
      if (i != 0) {
        break label260;
      }
      ac.v("MicroMsg.ABTestUpdater", "No need to update");
      AppMethodBeat.o(153110);
      return;
    }
    localObject = (Integer)g.agR().agA().get(ah.a.GFT, null);
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
      ac.i("MicroMsg.ABTestUpdater", "Need Update: %b, Last Update Time: %d, Update Interval: %d, Current Time: %d", new Object[] { Boolean.valueOf(bool), Long.valueOf(l1), Long.valueOf(l2), Long.valueOf(l3) });
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
    if (eg)
    {
      ac.i("MicroMsg.ABTestUpdater", "Updating");
      AppMethodBeat.o(153110);
      return;
    }
    update();
    AppMethodBeat.o(153110);
  }
  
  static void aAi()
  {
    AppMethodBeat.i(153111);
    if (!g.agM())
    {
      ac.i("MicroMsg.ABTestUpdater", "UpdateWithoutIntervalLimit aborted, Account not ready.");
      AppMethodBeat.o(153111);
      return;
    }
    if (eg)
    {
      ac.i("MicroMsg.ABTestUpdater", "UpdateWithoutIntervalLimit, Already Updating");
      AppMethodBeat.o(153111);
      return;
    }
    ac.i("MicroMsg.ABTestUpdater", "UpdateWithoutIntervalLimit, before do update");
    update();
    AppMethodBeat.o(153111);
  }
  
  private static void aAj()
  {
    AppMethodBeat.i(153114);
    long l = System.currentTimeMillis() / 1000L;
    g.agR().agA().set(ah.a.GFS, Long.valueOf(l));
    AppMethodBeat.o(153114);
  }
  
  private static int aAk()
  {
    AppMethodBeat.i(153116);
    Integer localInteger = (Integer)g.agR().agA().get(ah.a.GFR, null);
    if (localInteger == null)
    {
      AppMethodBeat.o(153116);
      return 0;
    }
    int i = localInteger.intValue();
    AppMethodBeat.o(153116);
    return i;
  }
  
  private static void aAl()
  {
    AppMethodBeat.i(153117);
    g.agR().agA().faa();
    AppMethodBeat.o(153117);
  }
  
  private static String c(LinkedList<aex> paramLinkedList)
  {
    AppMethodBeat.i(153112);
    Iterator localIterator = paramLinkedList.iterator();
    aex localaex;
    for (paramLinkedList = ""; localIterator.hasNext(); paramLinkedList = paramLinkedList + localaex.EuO + ":" + localaex.priority + "|") {
      localaex = (aex)localIterator.next();
    }
    AppMethodBeat.o(153112);
    return paramLinkedList;
  }
  
  private static void oh(int paramInt)
  {
    AppMethodBeat.i(153115);
    int i = 0;
    if (paramInt == 0) {}
    for (i = 86400;; i = new Random().nextInt(126000) + 3600) {
      do
      {
        g.agR().agA().set(ah.a.GFT, Integer.valueOf(i));
        AppMethodBeat.o(153115);
        return;
      } while ((paramInt >= 3600) && (paramInt <= 129600));
    }
  }
  
  private static void update()
  {
    AppMethodBeat.i(153113);
    eg = true;
    Object localObject = new b.a();
    ((b.a)localObject).hvt = new arp();
    ((b.a)localObject).hvu = new arq();
    ((b.a)localObject).uri = "/cgi-bin/mmux-bin/getabtest";
    ((b.a)localObject).funcId = 1801;
    localObject = ((b.a)localObject).aAz();
    arp localarp = (arp)((com.tencent.mm.ak.b)localObject).hvr.hvw;
    localarp.ELo = aAk();
    localarp.ELp = d.aAp().eYT();
    localarp.ELp.addAll(d.aAq().eYT());
    ac.i("MicroMsg.ABTestUpdater", "update abtest: %s", new Object[] { c(localarp.ELp) });
    x.a((com.tencent.mm.ak.b)localObject, new x.a()
    {
      public final int a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.ak.b paramAnonymousb, n paramAnonymousn)
      {
        AppMethodBeat.i(153109);
        b.adZ();
        if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
        {
          ac.e("MicroMsg.ABTestUpdater", "Update Error: %d, %d, next update will be performed %d(s) later", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), Integer.valueOf(86400) });
          b.access$100();
          b.oi(86400);
          b.access$300();
          AppMethodBeat.o(153109);
          return 0;
        }
        paramAnonymousString = (arq)paramAnonymousb.hvs.hvw;
        b.access$100();
        b.oj(paramAnonymousString.Timestamp);
        b.oi(paramAnonymousString.ELs);
        b.aj(paramAnonymousString.ELt);
        b.ak(paramAnonymousString.ELr);
        b.access$300();
        ac.i("MicroMsg.ABTestUpdater", "Update Interval: %d", new Object[] { Integer.valueOf(paramAnonymousString.ELs) });
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
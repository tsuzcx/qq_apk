package com.tencent.mm.model.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.n;
import com.tencent.mm.al.x;
import com.tencent.mm.al.x.a;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.protobuf.ady;
import com.tencent.mm.protocal.protobuf.aol;
import com.tencent.mm.protocal.protobuf.aom;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;

public final class b
{
  private static boolean arf = false;
  
  static void atq()
  {
    int j = 1;
    AppMethodBeat.i(153110);
    if (!g.afw())
    {
      ad.i("MicroMsg.ABTestUpdater", "Update aborted, Account not ready.");
      AppMethodBeat.o(153110);
      return;
    }
    Object localObject = (Long)g.afB().afk().get(ae.a.Fid, null);
    if (localObject == null) {}
    int i;
    for (long l1 = 0L; l1 == 0L; l1 = ((Long)localObject).longValue())
    {
      i = new Random().nextInt(86400);
      nt(i);
      ats();
      atu();
      ad.i("MicroMsg.ABTestUpdater", "First update ignored. Next update: %d", new Object[] { Integer.valueOf(i) });
      i = j;
      if (i != 0) {
        break label260;
      }
      ad.v("MicroMsg.ABTestUpdater", "No need to update");
      AppMethodBeat.o(153110);
      return;
    }
    localObject = (Integer)g.afB().afk().get(ae.a.Fie, null);
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
      ad.i("MicroMsg.ABTestUpdater", "Need Update: %b, Last Update Time: %d, Update Interval: %d, Current Time: %d", new Object[] { Boolean.valueOf(bool), Long.valueOf(l1), Long.valueOf(l2), Long.valueOf(l3) });
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
    if (arf)
    {
      ad.i("MicroMsg.ABTestUpdater", "Updating");
      AppMethodBeat.o(153110);
      return;
    }
    update();
    AppMethodBeat.o(153110);
  }
  
  static void atr()
  {
    AppMethodBeat.i(153111);
    if (!g.afw())
    {
      ad.i("MicroMsg.ABTestUpdater", "UpdateWithoutIntervalLimit aborted, Account not ready.");
      AppMethodBeat.o(153111);
      return;
    }
    if (arf)
    {
      ad.i("MicroMsg.ABTestUpdater", "UpdateWithoutIntervalLimit, Already Updating");
      AppMethodBeat.o(153111);
      return;
    }
    ad.i("MicroMsg.ABTestUpdater", "UpdateWithoutIntervalLimit, before do update");
    update();
    AppMethodBeat.o(153111);
  }
  
  private static void ats()
  {
    AppMethodBeat.i(153114);
    long l = System.currentTimeMillis() / 1000L;
    g.afB().afk().set(ae.a.Fid, Long.valueOf(l));
    AppMethodBeat.o(153114);
  }
  
  private static int att()
  {
    AppMethodBeat.i(153116);
    Integer localInteger = (Integer)g.afB().afk().get(ae.a.Fic, null);
    if (localInteger == null)
    {
      AppMethodBeat.o(153116);
      return 0;
    }
    int i = localInteger.intValue();
    AppMethodBeat.o(153116);
    return i;
  }
  
  private static void atu()
  {
    AppMethodBeat.i(153117);
    g.afB().afk().eKy();
    AppMethodBeat.o(153117);
  }
  
  private static String c(LinkedList<ady> paramLinkedList)
  {
    AppMethodBeat.i(153112);
    Iterator localIterator = paramLinkedList.iterator();
    ady localady;
    for (paramLinkedList = ""; localIterator.hasNext(); paramLinkedList = paramLinkedList + localady.DbI + ":" + localady.priority + "|") {
      localady = (ady)localIterator.next();
    }
    AppMethodBeat.o(153112);
    return paramLinkedList;
  }
  
  private static void nt(int paramInt)
  {
    AppMethodBeat.i(153115);
    int i = 0;
    if (paramInt == 0) {}
    for (i = 86400;; i = new Random().nextInt(126000) + 3600) {
      do
      {
        g.afB().afk().set(ae.a.Fie, Integer.valueOf(i));
        AppMethodBeat.o(153115);
        return;
      } while ((paramInt >= 3600) && (paramInt <= 129600));
    }
  }
  
  private static void update()
  {
    AppMethodBeat.i(153113);
    arf = true;
    Object localObject = new b.a();
    ((b.a)localObject).gUU = new aol();
    ((b.a)localObject).gUV = new aom();
    ((b.a)localObject).uri = "/cgi-bin/mmux-bin/getabtest";
    ((b.a)localObject).funcId = 1801;
    localObject = ((b.a)localObject).atI();
    aol localaol = (aol)((com.tencent.mm.al.b)localObject).gUS.gUX;
    localaol.Dqm = att();
    localaol.Dqn = d.aty().eJw();
    localaol.Dqn.addAll(d.atz().eJw());
    ad.i("MicroMsg.ABTestUpdater", "update abtest: %s", new Object[] { c(localaol.Dqn) });
    x.a((com.tencent.mm.al.b)localObject, new x.a()
    {
      public final int a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.al.b paramAnonymousb, n paramAnonymousn)
      {
        AppMethodBeat.i(153109);
        b.acT();
        if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
        {
          ad.e("MicroMsg.ABTestUpdater", "Update Error: %d, %d, next update will be performed %d(s) later", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), Integer.valueOf(86400) });
          b.access$100();
          b.nu(86400);
          b.access$300();
          AppMethodBeat.o(153109);
          return 0;
        }
        paramAnonymousString = (aom)paramAnonymousb.gUT.gUX;
        b.access$100();
        b.nv(paramAnonymousString.Timestamp);
        b.nu(paramAnonymousString.Dqq);
        b.am(paramAnonymousString.Dqr);
        b.an(paramAnonymousString.Dqp);
        b.access$300();
        ad.i("MicroMsg.ABTestUpdater", "Update Interval: %d", new Object[] { Integer.valueOf(paramAnonymousString.Dqq) });
        AppMethodBeat.o(153109);
        return 0;
      }
    }, true);
    AppMethodBeat.o(153113);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.model.c.b
 * JD-Core Version:    0.7.0.1
 */
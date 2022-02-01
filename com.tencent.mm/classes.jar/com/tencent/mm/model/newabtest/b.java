package com.tencent.mm.model.newabtest;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.p;
import com.tencent.mm.am.z;
import com.tencent.mm.am.z.a;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.protocal.protobuf.aoq;
import com.tencent.mm.protocal.protobuf.cdj;
import com.tencent.mm.protocal.protobuf.cdk;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;

public final class b
{
  private static boolean bzr = false;
  
  static void bEl()
  {
    int j = 1;
    AppMethodBeat.i(153110);
    if (!h.baz())
    {
      Log.i("MicroMsg.ABTestUpdater", "Update aborted, Account not ready.");
      AppMethodBeat.o(153110);
      return;
    }
    Object localObject = (Long)h.baE().ban().get(at.a.acKc, null);
    if (localObject == null) {}
    int i;
    for (long l1 = 0L; l1 == 0L; l1 = ((Long)localObject).longValue())
    {
      i = new Random().nextInt(86400);
      vE(i);
      bEn();
      bEp();
      Log.i("MicroMsg.ABTestUpdater", "First update ignored. Next update: %d", new Object[] { Integer.valueOf(i) });
      i = j;
      if (i != 0) {
        break label260;
      }
      Log.v("MicroMsg.ABTestUpdater", "No need to update");
      AppMethodBeat.o(153110);
      return;
    }
    localObject = (Integer)h.baE().ban().get(at.a.acKd, null);
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
    if (bzr)
    {
      Log.i("MicroMsg.ABTestUpdater", "Updating");
      AppMethodBeat.o(153110);
      return;
    }
    update();
    AppMethodBeat.o(153110);
  }
  
  static void bEm()
  {
    AppMethodBeat.i(153111);
    if (!h.baz())
    {
      Log.i("MicroMsg.ABTestUpdater", "UpdateWithoutIntervalLimit aborted, Account not ready.");
      AppMethodBeat.o(153111);
      return;
    }
    if (bzr)
    {
      Log.i("MicroMsg.ABTestUpdater", "UpdateWithoutIntervalLimit, Already Updating");
      AppMethodBeat.o(153111);
      return;
    }
    Log.i("MicroMsg.ABTestUpdater", "UpdateWithoutIntervalLimit, before do update");
    update();
    AppMethodBeat.o(153111);
  }
  
  private static void bEn()
  {
    AppMethodBeat.i(153114);
    long l = System.currentTimeMillis() / 1000L;
    h.baE().ban().set(at.a.acKc, Long.valueOf(l));
    AppMethodBeat.o(153114);
  }
  
  private static int bEo()
  {
    AppMethodBeat.i(153116);
    Integer localInteger = (Integer)h.baE().ban().get(at.a.acKb, null);
    if (localInteger == null)
    {
      AppMethodBeat.o(153116);
      return 0;
    }
    int i = localInteger.intValue();
    AppMethodBeat.o(153116);
    return i;
  }
  
  private static void bEp()
  {
    AppMethodBeat.i(153117);
    h.baE().ban().iZy();
    AppMethodBeat.o(153117);
  }
  
  private static String c(LinkedList<aoq> paramLinkedList)
  {
    AppMethodBeat.i(153112);
    Iterator localIterator = paramLinkedList.iterator();
    aoq localaoq;
    for (paramLinkedList = ""; localIterator.hasNext(); paramLinkedList = paramLinkedList + localaoq.ZqW + ":" + localaoq.priority + "|") {
      localaoq = (aoq)localIterator.next();
    }
    AppMethodBeat.o(153112);
    return paramLinkedList;
  }
  
  private static void update()
  {
    AppMethodBeat.i(153113);
    bzr = true;
    Object localObject = new c.a();
    ((c.a)localObject).otE = new cdj();
    ((c.a)localObject).otF = new cdk();
    ((c.a)localObject).uri = "/cgi-bin/mmux-bin/getabtest";
    ((c.a)localObject).funcId = 1801;
    localObject = ((c.a)localObject).bEF();
    cdj localcdj = (cdj)c.b.b(((c)localObject).otB);
    localcdj.aanJ = bEo();
    localcdj.aanK = d.bEt().iWX();
    localcdj.aanK.addAll(d.bEu().iWX());
    Log.i("MicroMsg.ABTestUpdater", "update abtest: %s", new Object[] { c(localcdj.aanK) });
    z.a((c)localObject, new z.a()
    {
      public final int callback(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, c paramAnonymousc, p paramAnonymousp)
      {
        AppMethodBeat.i(153109);
        b.aAs();
        if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
        {
          Log.e("MicroMsg.ABTestUpdater", "Update Error: %d, %d, next update will be performed %d(s) later", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), Integer.valueOf(86400) });
          b.access$100();
          b.access$200(86400);
          b.access$300();
          AppMethodBeat.o(153109);
          return 0;
        }
        paramAnonymousString = (cdk)c.c.b(paramAnonymousc.otC);
        b.access$100();
        b.vF(paramAnonymousString.Zvi);
        b.access$200(paramAnonymousString.aanN);
        b.bW(paramAnonymousString.aanO);
        b.bX(paramAnonymousString.aanM);
        b.access$300();
        Log.i("MicroMsg.ABTestUpdater", "Update Interval: %d", new Object[] { Integer.valueOf(paramAnonymousString.aanN) });
        AppMethodBeat.o(153109);
        return 0;
      }
    }, true);
    AppMethodBeat.o(153113);
  }
  
  private static void vE(int paramInt)
  {
    AppMethodBeat.i(153115);
    int i = 0;
    if (paramInt == 0) {}
    for (i = 86400;; i = new Random().nextInt(126000) + 3600) {
      do
      {
        h.baE().ban().set(at.a.acKd, Integer.valueOf(i));
        AppMethodBeat.o(153115);
        return;
      } while ((paramInt >= 3600) && (paramInt <= 129600));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.model.newabtest.b
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.model.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.aa;
import com.tencent.mm.an.aa.a;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.q;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.protocal.protobuf.alf;
import com.tencent.mm.protocal.protobuf.bow;
import com.tencent.mm.protocal.protobuf.box;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;

public final class b
{
  private static boolean Tb = false;
  
  static void bgt()
  {
    int j = 1;
    AppMethodBeat.i(153110);
    if (!h.aHB())
    {
      Log.i("MicroMsg.ABTestUpdater", "Update aborted, Account not ready.");
      AppMethodBeat.o(153110);
      return;
    }
    Object localObject = (Long)h.aHG().aHp().get(ar.a.ViI, null);
    if (localObject == null) {}
    int i;
    for (long l1 = 0L; l1 == 0L; l1 = ((Long)localObject).longValue())
    {
      i = new Random().nextInt(86400);
      vv(i);
      bgv();
      bgx();
      Log.i("MicroMsg.ABTestUpdater", "First update ignored. Next update: %d", new Object[] { Integer.valueOf(i) });
      i = j;
      if (i != 0) {
        break label260;
      }
      Log.v("MicroMsg.ABTestUpdater", "No need to update");
      AppMethodBeat.o(153110);
      return;
    }
    localObject = (Integer)h.aHG().aHp().get(ar.a.ViJ, null);
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
    if (Tb)
    {
      Log.i("MicroMsg.ABTestUpdater", "Updating");
      AppMethodBeat.o(153110);
      return;
    }
    update();
    AppMethodBeat.o(153110);
  }
  
  static void bgu()
  {
    AppMethodBeat.i(153111);
    if (!h.aHB())
    {
      Log.i("MicroMsg.ABTestUpdater", "UpdateWithoutIntervalLimit aborted, Account not ready.");
      AppMethodBeat.o(153111);
      return;
    }
    if (Tb)
    {
      Log.i("MicroMsg.ABTestUpdater", "UpdateWithoutIntervalLimit, Already Updating");
      AppMethodBeat.o(153111);
      return;
    }
    Log.i("MicroMsg.ABTestUpdater", "UpdateWithoutIntervalLimit, before do update");
    update();
    AppMethodBeat.o(153111);
  }
  
  private static void bgv()
  {
    AppMethodBeat.i(153114);
    long l = System.currentTimeMillis() / 1000L;
    h.aHG().aHp().set(ar.a.ViI, Long.valueOf(l));
    AppMethodBeat.o(153114);
  }
  
  private static int bgw()
  {
    AppMethodBeat.i(153116);
    Integer localInteger = (Integer)h.aHG().aHp().get(ar.a.ViH, null);
    if (localInteger == null)
    {
      AppMethodBeat.o(153116);
      return 0;
    }
    int i = localInteger.intValue();
    AppMethodBeat.o(153116);
    return i;
  }
  
  private static void bgx()
  {
    AppMethodBeat.i(153117);
    h.aHG().aHp().hxT();
    AppMethodBeat.o(153117);
  }
  
  private static String c(LinkedList<alf> paramLinkedList)
  {
    AppMethodBeat.i(153112);
    Iterator localIterator = paramLinkedList.iterator();
    alf localalf;
    for (paramLinkedList = ""; localIterator.hasNext(); paramLinkedList = paramLinkedList + localalf.SrR + ":" + localalf.priority + "|") {
      localalf = (alf)localIterator.next();
    }
    AppMethodBeat.o(153112);
    return paramLinkedList;
  }
  
  private static void update()
  {
    AppMethodBeat.i(153113);
    Tb = true;
    Object localObject = new d.a();
    ((d.a)localObject).lBU = new bow();
    ((d.a)localObject).lBV = new box();
    ((d.a)localObject).uri = "/cgi-bin/mmux-bin/getabtest";
    ((d.a)localObject).funcId = 1801;
    localObject = ((d.a)localObject).bgN();
    bow localbow = (bow)d.b.b(((com.tencent.mm.an.d)localObject).lBR);
    localbow.TaH = bgw();
    localbow.TaI = d.bgB().hvx();
    localbow.TaI.addAll(d.bgC().hvx());
    Log.i("MicroMsg.ABTestUpdater", "update abtest: %s", new Object[] { c(localbow.TaI) });
    aa.a((com.tencent.mm.an.d)localObject, new aa.a()
    {
      public final int a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.an.d paramAnonymousd, q paramAnonymousq)
      {
        AppMethodBeat.i(153109);
        b.Yy();
        if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
        {
          Log.e("MicroMsg.ABTestUpdater", "Update Error: %d, %d, next update will be performed %d(s) later", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), Integer.valueOf(86400) });
          b.access$100();
          b.access$200(86400);
          b.access$300();
          AppMethodBeat.o(153109);
          return 0;
        }
        paramAnonymousString = (box)d.c.b(paramAnonymousd.lBS);
        b.access$100();
        b.vx(paramAnonymousString.Svi);
        b.access$200(paramAnonymousString.TaL);
        b.ar(paramAnonymousString.TaM);
        b.as(paramAnonymousString.TaK);
        b.access$300();
        Log.i("MicroMsg.ABTestUpdater", "Update Interval: %d", new Object[] { Integer.valueOf(paramAnonymousString.TaL) });
        AppMethodBeat.o(153109);
        return 0;
      }
    }, true);
    AppMethodBeat.o(153113);
  }
  
  private static void vv(int paramInt)
  {
    AppMethodBeat.i(153115);
    int i = 0;
    if (paramInt == 0) {}
    for (i = 86400;; i = new Random().nextInt(126000) + 3600) {
      do
      {
        h.aHG().aHp().set(ar.a.ViJ, Integer.valueOf(i));
        AppMethodBeat.o(153115);
        return;
      } while ((paramInt >= 3600) && (paramInt <= 129600));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.model.c.b
 * JD-Core Version:    0.7.0.1
 */
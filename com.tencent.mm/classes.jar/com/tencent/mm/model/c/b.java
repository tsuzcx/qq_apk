package com.tencent.mm.model.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.w;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.protobuf.aaj;
import com.tencent.mm.protocal.protobuf.afh;
import com.tencent.mm.protocal.protobuf.afi;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.d;
import com.tencent.mm.storage.z;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;

public final class b
{
  private static boolean ajS = false;
  
  static void abO()
  {
    int j = 1;
    AppMethodBeat.i(118161);
    if (!g.RG())
    {
      ab.i("MicroMsg.ABTestUpdater", "Update aborted, Account not ready.");
      AppMethodBeat.o(118161);
      return;
    }
    Object localObject = (Long)g.RL().Ru().get(ac.a.yzI, null);
    if (localObject == null) {}
    int i;
    for (long l1 = 0L; l1 == 0L; l1 = ((Long)localObject).longValue())
    {
      i = new Random().nextInt(86400);
      kL(i);
      abQ();
      abS();
      ab.i("MicroMsg.ABTestUpdater", "First update ignored. Next update: %d", new Object[] { Integer.valueOf(i) });
      i = j;
      if (i != 0) {
        break label260;
      }
      ab.v("MicroMsg.ABTestUpdater", "No need to update");
      AppMethodBeat.o(118161);
      return;
    }
    localObject = (Integer)g.RL().Ru().get(ac.a.yzJ, null);
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
      ab.i("MicroMsg.ABTestUpdater", "Need Update: %b, Last Update Time: %d, Update Interval: %d, Current Time: %d", new Object[] { Boolean.valueOf(bool), Long.valueOf(l1), Long.valueOf(l2), Long.valueOf(l3) });
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
    if (ajS)
    {
      ab.i("MicroMsg.ABTestUpdater", "Updating");
      AppMethodBeat.o(118161);
      return;
    }
    update();
    AppMethodBeat.o(118161);
  }
  
  static void abP()
  {
    AppMethodBeat.i(118162);
    if (!g.RG())
    {
      ab.i("MicroMsg.ABTestUpdater", "UpdateWithoutIntervalLimit aborted, Account not ready.");
      AppMethodBeat.o(118162);
      return;
    }
    if (ajS)
    {
      ab.i("MicroMsg.ABTestUpdater", "UpdateWithoutIntervalLimit, Already Updating");
      AppMethodBeat.o(118162);
      return;
    }
    ab.i("MicroMsg.ABTestUpdater", "UpdateWithoutIntervalLimit, before do update");
    update();
    AppMethodBeat.o(118162);
  }
  
  private static void abQ()
  {
    AppMethodBeat.i(118165);
    long l = System.currentTimeMillis() / 1000L;
    g.RL().Ru().set(ac.a.yzI, Long.valueOf(l));
    AppMethodBeat.o(118165);
  }
  
  private static int abR()
  {
    AppMethodBeat.i(118167);
    Integer localInteger = (Integer)g.RL().Ru().get(ac.a.yzH, null);
    if (localInteger == null)
    {
      AppMethodBeat.o(118167);
      return 0;
    }
    int i = localInteger.intValue();
    AppMethodBeat.o(118167);
    return i;
  }
  
  private static void abS()
  {
    AppMethodBeat.i(118168);
    g.RL().Ru().dww();
    AppMethodBeat.o(118168);
  }
  
  private static String c(LinkedList<aaj> paramLinkedList)
  {
    AppMethodBeat.i(118163);
    Iterator localIterator = paramLinkedList.iterator();
    aaj localaaj;
    for (paramLinkedList = ""; localIterator.hasNext(); paramLinkedList = paramLinkedList + localaaj.wPe + ":" + localaaj.priority + "|") {
      localaaj = (aaj)localIterator.next();
    }
    AppMethodBeat.o(118163);
    return paramLinkedList;
  }
  
  private static void kL(int paramInt)
  {
    AppMethodBeat.i(118166);
    int i = 0;
    if (paramInt == 0) {}
    for (i = 86400;; i = new Random().nextInt(126000) + 3600) {
      do
      {
        g.RL().Ru().set(ac.a.yzJ, Integer.valueOf(i));
        AppMethodBeat.o(118166);
        return;
      } while ((paramInt >= 3600) && (paramInt <= 129600));
    }
  }
  
  private static void update()
  {
    AppMethodBeat.i(118164);
    ajS = true;
    Object localObject = new b.a();
    ((b.a)localObject).fsX = new afh();
    ((b.a)localObject).fsY = new afi();
    ((b.a)localObject).uri = "/cgi-bin/mmux-bin/getabtest";
    ((b.a)localObject).funcId = 1801;
    localObject = ((b.a)localObject).ado();
    afh localafh = (afh)((com.tencent.mm.ai.b)localObject).fsV.fta;
    localafh.wYB = abR();
    localafh.wYC = c.abU().dvL();
    localafh.wYC.addAll(c.abV().dvL());
    ab.i("MicroMsg.ABTestUpdater", "update abtest: %s", new Object[] { c(localafh.wYC) });
    w.a((com.tencent.mm.ai.b)localObject, new b.1(), true);
    AppMethodBeat.o(118164);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.model.c.b
 * JD-Core Version:    0.7.0.1
 */
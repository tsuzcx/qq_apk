package com.tencent.mm.model.c;

import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.w;
import com.tencent.mm.ah.w.a;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.c.aap;
import com.tencent.mm.protocal.c.aaq;
import com.tencent.mm.protocal.c.we;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.d;
import com.tencent.mm.storage.z;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;

public final class b
{
  private static boolean ahC = false;
  
  static void IR()
  {
    int j = 1;
    if (!g.DK())
    {
      y.i("MicroMsg.ABTestUpdater", "Update aborted, Account not ready.");
      return;
    }
    Object localObject = (Long)g.DP().Dz().get(ac.a.upI, null);
    if (localObject == null) {}
    int i;
    for (long l1 = 0L; l1 == 0L; l1 = ((Long)localObject).longValue())
    {
      i = new Random().nextInt(86400);
      hY(i);
      IT();
      IU();
      y.i("MicroMsg.ABTestUpdater", "First update ignored. Next update: %d", new Object[] { Integer.valueOf(i) });
      i = j;
      if (i != 0) {
        break label245;
      }
      y.v("MicroMsg.ABTestUpdater", "No need to update");
      return;
    }
    localObject = (Integer)g.DP().Dz().get(ac.a.upJ, null);
    label145:
    long l2;
    long l3;
    if ((localObject == null) || (((Integer)localObject).intValue() == 0))
    {
      i = 86400;
      l2 = i;
      l3 = System.currentTimeMillis() / 1000L;
      if (l3 <= l1 + l2) {
        break label239;
      }
    }
    label239:
    for (boolean bool = true;; bool = false)
    {
      y.i("MicroMsg.ABTestUpdater", "Need Update: %b, Last Update Time: %d, Update Interval: %d, Current Time: %d", new Object[] { Boolean.valueOf(bool), Long.valueOf(l1), Long.valueOf(l2), Long.valueOf(l3) });
      i = j;
      if (l3 > l1 + l2) {
        break;
      }
      i = 0;
      break;
      i = ((Integer)localObject).intValue();
      break label145;
    }
    label245:
    if (ahC)
    {
      y.i("MicroMsg.ABTestUpdater", "Updating");
      return;
    }
    update();
  }
  
  static void IS()
  {
    if (!g.DK())
    {
      y.i("MicroMsg.ABTestUpdater", "UpdateWithoutIntervalLimit aborted, Account not ready.");
      return;
    }
    if (ahC)
    {
      y.i("MicroMsg.ABTestUpdater", "UpdateWithoutIntervalLimit, Already Updating");
      return;
    }
    y.i("MicroMsg.ABTestUpdater", "UpdateWithoutIntervalLimit, before do update");
    update();
  }
  
  private static void IT()
  {
    long l = System.currentTimeMillis() / 1000L;
    g.DP().Dz().c(ac.a.upI, Long.valueOf(l));
  }
  
  private static void IU()
  {
    g.DP().Dz().mC(true);
  }
  
  private static void hY(int paramInt)
  {
    int i = 0;
    if (paramInt == 0) {}
    for (i = 86400;; i = new Random().nextInt(126000) + 3600) {
      do
      {
        g.DP().Dz().c(ac.a.upJ, Integer.valueOf(i));
        return;
      } while ((paramInt >= 3600) && (paramInt <= 129600));
    }
  }
  
  private static void update()
  {
    ahC = true;
    Object localObject1 = new b.a();
    ((b.a)localObject1).ecH = new aap();
    ((b.a)localObject1).ecI = new aaq();
    ((b.a)localObject1).uri = "/cgi-bin/mmux-bin/getabtest";
    ((b.a)localObject1).ecG = 1801;
    com.tencent.mm.ah.b localb = ((b.a)localObject1).Kt();
    localObject1 = (aap)localb.ecE.ecN;
    Object localObject2 = (Integer)g.DP().Dz().get(ac.a.upH, null);
    if (localObject2 == null) {}
    for (int i = 0;; i = ((Integer)localObject2).intValue())
    {
      ((aap)localObject1).tak = i;
      ((aap)localObject1).tal = c.IX().ctp();
      ((aap)localObject1).tal.addAll(c.IY().ctp());
      localObject2 = ((aap)localObject1).tal.iterator();
      we localwe;
      for (localObject1 = ""; ((Iterator)localObject2).hasNext(); localObject1 = (String)localObject1 + localwe.sQD + ":" + localwe.priority + "|") {
        localwe = (we)((Iterator)localObject2).next();
      }
    }
    y.i("MicroMsg.ABTestUpdater", "update abtest: %s", new Object[] { localObject1 });
    w.a(localb, new w.a()
    {
      public final int a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.ah.b paramAnonymousb, m paramAnonymousm)
      {
        b.BF();
        if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
        {
          y.e("MicroMsg.ABTestUpdater", "Update Error: %d, %d, next update will be performed %d(s) later", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), Integer.valueOf(86400) });
          b.access$100();
          b.hZ(86400);
          b.IV();
          return 0;
        }
        paramAnonymousString = (aaq)paramAnonymousb.ecF.ecN;
        b.access$100();
        b.ia(paramAnonymousString.sSK);
        b.hZ(paramAnonymousString.tao);
        b.O(paramAnonymousString.tap);
        b.P(paramAnonymousString.tan);
        b.IV();
        y.i("MicroMsg.ABTestUpdater", "Update Interval: %d", new Object[] { Integer.valueOf(paramAnonymousString.tao) });
        return 0;
      }
    }, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.model.c.b
 * JD-Core Version:    0.7.0.1
 */
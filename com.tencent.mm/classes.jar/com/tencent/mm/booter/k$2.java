package com.tencent.mm.booter;

import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.h.a.dq;
import com.tencent.mm.m.g;
import com.tencent.mm.model.au;
import com.tencent.mm.protocal.c.apy;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.am.a;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

final class k$2
  implements am.a
{
  public final boolean tC()
  {
    try
    {
      au.Hx();
      Boolean localBoolean = Boolean.valueOf(bk.a((Boolean)com.tencent.mm.model.c.Dz().get(ac.a.ure, null), false));
      Object localObject2 = g.AB().Aq();
      if (localObject2 != null)
      {
        localObject2 = ((List)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          String str = (String)((Iterator)localObject2).next();
          y.i("MicroMsg.PostTaskStartRangeForIBeacon", "op=false,isInShakeUI:" + localBoolean + ",iBeacon = %s", new Object[] { str });
          dq localdq = new dq();
          localdq.bKd.bKf = str;
          localdq.bKd.bKc = false;
          if (!localBoolean.booleanValue()) {
            a.udP.m(localdq);
          }
        }
      }
      return false;
    }
    catch (Exception localException)
    {
      y.e("MicroMsg.PostTaskStartRangeForIBeacon", localException.getMessage());
    }
    Object localObject1 = new apy();
    ((apy)localObject1).latitude = k.wh();
    ((apy)localObject1).longitude = k.wi();
    au.Hx();
    long l = bk.a((Long)com.tencent.mm.model.c.Dz().get(ac.a.uqV, null), 0L);
    if ((k.wj().size() > 0) && (!k.wk().booleanValue()) && (k.wl().size() > 0))
    {
      k.b(Boolean.valueOf(true));
      localObject1 = new com.tencent.mm.modelmulti.c(k.wl(), l, (apy)localObject1);
      y.d("MicroMsg.PostTaskStartRangeForIBeacon", "[shakezb]PostTaskStartRangeForIBeacon[kevinkma] shopId " + l + ",beaconInfos size " + k.wl().size() + ",info:" + k.wl().toString());
      au.Dk().a(1708, new k.2.1(this, (com.tencent.mm.modelmulti.c)localObject1));
      au.Dk().a((m)localObject1, 0);
    }
    for (;;)
    {
      k.wj().clear();
      k.wl().clear();
      a.udP.d(k.wm());
      return false;
      au.Hx();
      com.tencent.mm.model.c.Dz().c(ac.a.ura, "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.booter.k.2
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.exdevice.model;

import com.tencent.mm.ah.p;
import com.tencent.mm.h.a.ub;
import com.tencent.mm.h.a.ub.a;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.exdevice.b.k.f;
import com.tencent.mm.plugin.exdevice.h.b;
import com.tencent.mm.plugin.exdevice.service.d;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

final class af$1
  extends com.tencent.mm.sdk.b.c<ub>
{
  af$1(af paramaf)
  {
    this.udX = ub.class.getName().hashCode();
  }
  
  private boolean a(ub paramub)
  {
    boolean bool = true;
    if ((paramub instanceof ub)) {
      switch (paramub.cez.bHz)
      {
      }
    }
    do
    {
      return false;
      y.i("MicroMsg.WearHardDeviceLogic", "receive register deviceId=%s", new Object[] { paramub.cez.bwK });
      i.jvG.a(ae.getContext(), new af.1.1(this, paramub));
      return false;
      b localb = ad.aLL().BG(paramub.cez.bwK);
      paramub = paramub.cez;
      if (localb != null) {}
      for (;;)
      {
        paramub.bKQ = bool;
        return false;
        bool = false;
      }
      y.i("MicroMsg.WearHardDeviceLogic", "receive send deviceId=%s", new Object[] { paramub.cez.bwK });
      au.Dk().a(538, this.jwU);
      paramub = new w(0L, paramub.cez.bJp, paramub.cez.bwK, k.f.aLp(), bk.UY(), paramub.cez.data, 1);
      au.Dk().a(paramub, 0);
      return false;
      au.Dk().a(541, this.jwU);
      paramub = new r("AndroidWear", paramub.cez.bJp, paramub.cez.bwK, 1, new byte[0]);
      au.Dk().a(paramub, 0);
      return false;
    } while (bk.bu(ae.getContext(), ae.getPackageName() + ":exdevice"));
    d.db(ae.getContext());
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.model.af.1
 * JD-Core Version:    0.7.0.1
 */
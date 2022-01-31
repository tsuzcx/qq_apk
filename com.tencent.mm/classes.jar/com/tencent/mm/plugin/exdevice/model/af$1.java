package com.tencent.mm.plugin.exdevice.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.g.a.vx;
import com.tencent.mm.g.a.vx.a;
import com.tencent.mm.model.aw;
import com.tencent.mm.plugin.exdevice.b.k.f;
import com.tencent.mm.plugin.exdevice.h.b;
import com.tencent.mm.plugin.exdevice.service.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;

final class af$1
  extends com.tencent.mm.sdk.b.c<vx>
{
  af$1(af paramaf)
  {
    AppMethodBeat.i(19407);
    this.__eventId = vx.class.getName().hashCode();
    AppMethodBeat.o(19407);
  }
  
  private boolean a(vx paramvx)
  {
    boolean bool = true;
    AppMethodBeat.i(19408);
    if ((paramvx instanceof vx)) {
      switch (paramvx.cNm.coO)
      {
      }
    }
    for (;;)
    {
      AppMethodBeat.o(19408);
      return false;
      ab.i("MicroMsg.WearHardDeviceLogic", "receive register deviceId=%s", new Object[] { paramvx.cNm.bYu });
      i.lFf.a(ah.getContext(), new af.1.1(this, paramvx));
      continue;
      b localb = ad.bpY().LI(paramvx.cNm.bYu);
      paramvx = paramvx.cNm;
      if (localb != null) {}
      for (;;)
      {
        paramvx.csk = bool;
        break;
        bool = false;
      }
      ab.i("MicroMsg.WearHardDeviceLogic", "receive send deviceId=%s", new Object[] { paramvx.cNm.bYu });
      aw.Rc().a(538, this.lGt);
      paramvx = new w(0L, paramvx.cNm.cqJ, paramvx.cNm.bYu, k.f.bpC(), bo.aoy(), paramvx.cNm.data, 1);
      aw.Rc().a(paramvx, 0);
      continue;
      aw.Rc().a(541, this.lGt);
      paramvx = new r("AndroidWear", paramvx.cNm.cqJ, paramvx.cNm.bYu, 1, new byte[0]);
      aw.Rc().a(paramvx, 0);
      continue;
      if (!bo.bH(ah.getContext(), ah.getPackageName() + ":exdevice")) {
        d.dN(ah.getContext());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.model.af.1
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.exdevice.model;

import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.s;
import com.tencent.mm.autogen.a.adt;
import com.tencent.mm.autogen.a.adt.a;
import com.tencent.mm.model.bh;
import com.tencent.mm.plugin.exdevice.c.k.f;
import com.tencent.mm.plugin.exdevice.i.b;
import com.tencent.mm.plugin.exdevice.i.c;
import com.tencent.mm.plugin.exdevice.service.d;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;

class WearHardDeviceLogic$1
  extends IListener<adt>
{
  WearHardDeviceLogic$1(aj paramaj, q paramq)
  {
    super(paramq);
    AppMethodBeat.i(274582);
    this.__eventId = adt.class.getName().hashCode();
    AppMethodBeat.o(274582);
  }
  
  private boolean a(final adt paramadt)
  {
    boolean bool = true;
    AppMethodBeat.i(23475);
    if ((paramadt instanceof adt)) {
      switch (paramadt.iie.hAf)
      {
      }
    }
    for (;;)
    {
      AppMethodBeat.o(23475);
      return false;
      Log.i("MicroMsg.WearHardDeviceLogic", "receive register deviceId=%s", new Object[] { paramadt.iie.hEl });
      k.yrL.a(MMApplicationContext.getContext(), new k.a()
      {
        public final void oz(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(23474);
          if (!paramAnonymousBoolean)
          {
            Log.e("MicroMsg.WearHardDeviceLogic", "GetBoundDeviceLogic Fail, deviceId=%s|deviceType=%s", new Object[] { paramadt.iie.hEl, paramadt.iie.hEr });
            aj.bj(paramadt.iie.hEl, false);
            AppMethodBeat.o(23474);
            return;
          }
          aj.bj(paramadt.iie.hEl, true);
          AppMethodBeat.o(23474);
        }
      });
      continue;
      b localb = ah.dFO().apI(paramadt.iie.hEl);
      paramadt = paramadt.iie;
      if (localb != null) {}
      for (;;)
      {
        paramadt.isSuccess = bool;
        break;
        bool = false;
      }
      Log.i("MicroMsg.WearHardDeviceLogic", "receive send deviceId=%s", new Object[] { paramadt.iie.hEl });
      bh.aZW().a(538, this.yte);
      paramadt = new z(0L, paramadt.iie.hEr, paramadt.iie.hEl, k.f.dFp(), Util.nowMilliSecond(), paramadt.iie.data, 1);
      bh.aZW().a(paramadt, 0);
      continue;
      bh.aZW().a(541, this.yte);
      paramadt = new u("AndroidWear", paramadt.iie.hEr, paramadt.iie.hEl, 1, new byte[0]);
      bh.aZW().a(paramadt, 0);
      continue;
      if (!Util.isProcessRunning(MMApplicationContext.getContext(), MMApplicationContext.getPackageName() + ":exdevice")) {
        d.ge(MMApplicationContext.getContext());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.model.WearHardDeviceLogic.1
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.exdevice.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.g.a.xx;
import com.tencent.mm.g.a.xx.a;
import com.tencent.mm.model.az;
import com.tencent.mm.plugin.exdevice.c.k.f;
import com.tencent.mm.plugin.exdevice.i.b;
import com.tencent.mm.plugin.exdevice.service.d;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;

public final class af
  implements g
{
  com.tencent.mm.sdk.b.c fjL;
  
  public af()
  {
    AppMethodBeat.i(23477);
    this.fjL = new com.tencent.mm.sdk.b.c()
    {
      private boolean a(final xx paramAnonymousxx)
      {
        boolean bool = true;
        AppMethodBeat.i(23475);
        if ((paramAnonymousxx instanceof xx)) {
          switch (paramAnonymousxx.dEk.dbV)
          {
          }
        }
        for (;;)
        {
          AppMethodBeat.o(23475);
          return false;
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WearHardDeviceLogic", "receive register deviceId=%s", new Object[] { paramAnonymousxx.dEk.cLR });
          i.oVR.a(aj.getContext(), new i.a()
          {
            public final void jY(boolean paramAnonymous2Boolean)
            {
              AppMethodBeat.i(23474);
              if (!paramAnonymous2Boolean)
              {
                com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.WearHardDeviceLogic", "GetBoundDeviceLogic Fail, deviceId=%s|deviceType=%s", new Object[] { paramAnonymousxx.dEk.cLR, paramAnonymousxx.dEk.dfF });
                af.aN(paramAnonymousxx.dEk.cLR, false);
                AppMethodBeat.o(23474);
                return;
              }
              af.aN(paramAnonymousxx.dEk.cLR, true);
              AppMethodBeat.o(23474);
            }
          });
          continue;
          b localb = ad.bZG().UR(paramAnonymousxx.dEk.cLR);
          paramAnonymousxx = paramAnonymousxx.dEk;
          if (localb != null) {}
          for (;;)
          {
            paramAnonymousxx.dhg = bool;
            break;
            bool = false;
          }
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WearHardDeviceLogic", "receive send deviceId=%s", new Object[] { paramAnonymousxx.dEk.cLR });
          az.aeS().a(538, af.this);
          paramAnonymousxx = new w(0L, paramAnonymousxx.dEk.dfF, paramAnonymousxx.dEk.cLR, k.f.bZj(), bt.eGO(), paramAnonymousxx.dEk.data, 1);
          az.aeS().a(paramAnonymousxx, 0);
          continue;
          az.aeS().a(541, af.this);
          paramAnonymousxx = new r("AndroidWear", paramAnonymousxx.dEk.dfF, paramAnonymousxx.dEk.cLR, 1, new byte[0]);
          az.aeS().a(paramAnonymousxx, 0);
          continue;
          if (!bt.isProcessRunning(aj.getContext(), aj.getPackageName() + ":exdevice")) {
            d.ex(aj.getContext());
          }
        }
      }
    };
    a.ESL.c(this.fjL);
    AppMethodBeat.o(23477);
  }
  
  private static void aL(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(23479);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WearHardDeviceLogic", "publish auth response deviceId=%s | isSuccess=%b", new Object[] { paramString, Boolean.valueOf(paramBoolean) });
    xx localxx = new xx();
    localxx.dEk.dbV = 8;
    localxx.dEk.dhg = paramBoolean;
    localxx.dEk.cLR = paramString;
    a.ESL.l(localxx);
    AppMethodBeat.o(23479);
  }
  
  private static void aM(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(23480);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WearHardDeviceLogic", "publish send response deviceId=%s | isSuccess=%b", new Object[] { paramString, Boolean.valueOf(paramBoolean) });
    xx localxx = new xx();
    localxx.dEk.dbV = 5;
    localxx.dEk.dhg = paramBoolean;
    localxx.dEk.cLR = paramString;
    a.ESL.l(localxx);
    AppMethodBeat.o(23480);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(23478);
    if ((paramn instanceof r))
    {
      az.aeS().b(541, this);
      paramString = (r)paramn;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        aL(paramString.oWh, true);
        AppMethodBeat.o(23478);
        return;
      }
      aL(paramString.oWh, false);
      AppMethodBeat.o(23478);
      return;
    }
    if ((paramn instanceof w))
    {
      az.aeS().b(538, this);
      paramString = (w)paramn;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        aM(paramString.oWj, true);
        AppMethodBeat.o(23478);
        return;
      }
      aM(paramString.oWj, false);
    }
    AppMethodBeat.o(23478);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.model.af
 * JD-Core Version:    0.7.0.1
 */
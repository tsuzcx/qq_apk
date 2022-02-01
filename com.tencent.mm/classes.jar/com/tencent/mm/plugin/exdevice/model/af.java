package com.tencent.mm.plugin.exdevice.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.yi;
import com.tencent.mm.g.a.yi.a;
import com.tencent.mm.model.az;
import com.tencent.mm.plugin.exdevice.c.k.f;
import com.tencent.mm.plugin.exdevice.i.b;
import com.tencent.mm.plugin.exdevice.service.d;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;

public final class af
  implements g
{
  com.tencent.mm.sdk.b.c fnf;
  
  public af()
  {
    AppMethodBeat.i(23477);
    this.fnf = new com.tencent.mm.sdk.b.c()
    {
      private boolean a(final yi paramAnonymousyi)
      {
        boolean bool = true;
        AppMethodBeat.i(23475);
        if ((paramAnonymousyi instanceof yi)) {
          switch (paramAnonymousyi.dBW.cZu)
          {
          }
        }
        for (;;)
        {
          AppMethodBeat.o(23475);
          return false;
          ac.i("MicroMsg.WearHardDeviceLogic", "receive register deviceId=%s", new Object[] { paramAnonymousyi.dBW.cIZ });
          i.pzc.a(ai.getContext(), new i.a()
          {
            public final void kC(boolean paramAnonymous2Boolean)
            {
              AppMethodBeat.i(23474);
              if (!paramAnonymous2Boolean)
              {
                ac.e("MicroMsg.WearHardDeviceLogic", "GetBoundDeviceLogic Fail, deviceId=%s|deviceType=%s", new Object[] { paramAnonymousyi.dBW.cIZ, paramAnonymousyi.dBW.dda });
                af.aO(paramAnonymousyi.dBW.cIZ, false);
                AppMethodBeat.o(23474);
                return;
              }
              af.aO(paramAnonymousyi.dBW.cIZ, true);
              AppMethodBeat.o(23474);
            }
          });
          continue;
          b localb = ad.cgP().Zd(paramAnonymousyi.dBW.cIZ);
          paramAnonymousyi = paramAnonymousyi.dBW;
          if (localb != null) {}
          for (;;)
          {
            paramAnonymousyi.deB = bool;
            break;
            bool = false;
          }
          ac.i("MicroMsg.WearHardDeviceLogic", "receive send deviceId=%s", new Object[] { paramAnonymousyi.dBW.cIZ });
          az.agi().a(538, af.this);
          paramAnonymousyi = new w(0L, paramAnonymousyi.dBW.dda, paramAnonymousyi.dBW.cIZ, k.f.cgs(), bs.eWj(), paramAnonymousyi.dBW.data, 1);
          az.agi().a(paramAnonymousyi, 0);
          continue;
          az.agi().a(541, af.this);
          paramAnonymousyi = new r("AndroidWear", paramAnonymousyi.dBW.dda, paramAnonymousyi.dBW.cIZ, 1, new byte[0]);
          az.agi().a(paramAnonymousyi, 0);
          continue;
          if (!bs.isProcessRunning(ai.getContext(), ai.getPackageName() + ":exdevice")) {
            d.eF(ai.getContext());
          }
        }
      }
    };
    a.GpY.c(this.fnf);
    AppMethodBeat.o(23477);
  }
  
  private static void aM(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(23479);
    ac.i("MicroMsg.WearHardDeviceLogic", "publish auth response deviceId=%s | isSuccess=%b", new Object[] { paramString, Boolean.valueOf(paramBoolean) });
    yi localyi = new yi();
    localyi.dBW.cZu = 8;
    localyi.dBW.deB = paramBoolean;
    localyi.dBW.cIZ = paramString;
    a.GpY.l(localyi);
    AppMethodBeat.o(23479);
  }
  
  private static void aN(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(23480);
    ac.i("MicroMsg.WearHardDeviceLogic", "publish send response deviceId=%s | isSuccess=%b", new Object[] { paramString, Boolean.valueOf(paramBoolean) });
    yi localyi = new yi();
    localyi.dBW.cZu = 5;
    localyi.dBW.deB = paramBoolean;
    localyi.dBW.cIZ = paramString;
    a.GpY.l(localyi);
    AppMethodBeat.o(23480);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(23478);
    if ((paramn instanceof r))
    {
      az.agi().b(541, this);
      paramString = (r)paramn;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        aM(paramString.pzs, true);
        AppMethodBeat.o(23478);
        return;
      }
      aM(paramString.pzs, false);
      AppMethodBeat.o(23478);
      return;
    }
    if ((paramn instanceof w))
    {
      az.agi().b(538, this);
      paramString = (w)paramn;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        aN(paramString.pzu, true);
        AppMethodBeat.o(23478);
        return;
      }
      aN(paramString.pzu, false);
    }
    AppMethodBeat.o(23478);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.model.af
 * JD-Core Version:    0.7.0.1
 */
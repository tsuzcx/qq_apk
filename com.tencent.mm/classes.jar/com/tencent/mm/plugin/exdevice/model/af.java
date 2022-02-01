package com.tencent.mm.plugin.exdevice.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.zi;
import com.tencent.mm.g.a.zi.a;
import com.tencent.mm.model.bc;
import com.tencent.mm.plugin.exdevice.c.k.f;
import com.tencent.mm.plugin.exdevice.i.b;
import com.tencent.mm.plugin.exdevice.service.d;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;

public final class af
  implements f
{
  com.tencent.mm.sdk.b.c fHr;
  
  public af()
  {
    AppMethodBeat.i(23477);
    this.fHr = new com.tencent.mm.sdk.b.c()
    {
      private boolean a(final zi paramAnonymouszi)
      {
        boolean bool = true;
        AppMethodBeat.i(23475);
        if ((paramAnonymouszi instanceof zi)) {
          switch (paramAnonymouszi.dPz.dlO)
          {
          }
        }
        for (;;)
        {
          AppMethodBeat.o(23475);
          return false;
          ae.i("MicroMsg.WearHardDeviceLogic", "receive register deviceId=%s", new Object[] { paramAnonymouszi.dPz.cVh });
          i.qjm.a(ak.getContext(), new i.a()
          {
            public final void kN(boolean paramAnonymous2Boolean)
            {
              AppMethodBeat.i(23474);
              if (!paramAnonymous2Boolean)
              {
                ae.e("MicroMsg.WearHardDeviceLogic", "GetBoundDeviceLogic Fail, deviceId=%s|deviceType=%s", new Object[] { paramAnonymouszi.dPz.cVh, paramAnonymouszi.dPz.dpB });
                af.aS(paramAnonymouszi.dPz.cVh, false);
                AppMethodBeat.o(23474);
                return;
              }
              af.aS(paramAnonymouszi.dPz.cVh, true);
              AppMethodBeat.o(23474);
            }
          });
          continue;
          b localb = ad.cmJ().adA(paramAnonymouszi.dPz.cVh);
          paramAnonymouszi = paramAnonymouszi.dPz;
          if (localb != null) {}
          for (;;)
          {
            paramAnonymouszi.drc = bool;
            break;
            bool = false;
          }
          ae.i("MicroMsg.WearHardDeviceLogic", "receive send deviceId=%s", new Object[] { paramAnonymouszi.dPz.cVh });
          bc.ajj().a(538, af.this);
          paramAnonymouszi = new w(0L, paramAnonymouszi.dPz.dpB, paramAnonymouszi.dPz.cVh, k.f.cmm(), bu.fpO(), paramAnonymouszi.dPz.data, 1);
          bc.ajj().a(paramAnonymouszi, 0);
          continue;
          bc.ajj().a(541, af.this);
          paramAnonymouszi = new r("AndroidWear", paramAnonymouszi.dPz.dpB, paramAnonymouszi.dPz.cVh, 1, new byte[0]);
          bc.ajj().a(paramAnonymouszi, 0);
          continue;
          if (!bu.isProcessRunning(ak.getContext(), ak.getPackageName() + ":exdevice")) {
            d.eJ(ak.getContext());
          }
        }
      }
    };
    a.IvT.c(this.fHr);
    AppMethodBeat.o(23477);
  }
  
  private static void aQ(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(23479);
    ae.i("MicroMsg.WearHardDeviceLogic", "publish auth response deviceId=%s | isSuccess=%b", new Object[] { paramString, Boolean.valueOf(paramBoolean) });
    zi localzi = new zi();
    localzi.dPz.dlO = 8;
    localzi.dPz.drc = paramBoolean;
    localzi.dPz.cVh = paramString;
    a.IvT.l(localzi);
    AppMethodBeat.o(23479);
  }
  
  private static void aR(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(23480);
    ae.i("MicroMsg.WearHardDeviceLogic", "publish send response deviceId=%s | isSuccess=%b", new Object[] { paramString, Boolean.valueOf(paramBoolean) });
    zi localzi = new zi();
    localzi.dPz.dlO = 5;
    localzi.dPz.drc = paramBoolean;
    localzi.dPz.cVh = paramString;
    a.IvT.l(localzi);
    AppMethodBeat.o(23480);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(23478);
    if ((paramn instanceof r))
    {
      bc.ajj().b(541, this);
      paramString = (r)paramn;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        aQ(paramString.qjC, true);
        AppMethodBeat.o(23478);
        return;
      }
      aQ(paramString.qjC, false);
      AppMethodBeat.o(23478);
      return;
    }
    if ((paramn instanceof w))
    {
      bc.ajj().b(538, this);
      paramString = (w)paramn;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        aR(paramString.qjE, true);
        AppMethodBeat.o(23478);
        return;
      }
      aR(paramString.qjE, false);
    }
    AppMethodBeat.o(23478);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.model.af
 * JD-Core Version:    0.7.0.1
 */
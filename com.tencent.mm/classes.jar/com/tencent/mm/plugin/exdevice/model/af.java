package com.tencent.mm.plugin.exdevice.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.g.a.zc;
import com.tencent.mm.g.a.zc.a;
import com.tencent.mm.model.ba;
import com.tencent.mm.plugin.exdevice.c.k.f;
import com.tencent.mm.plugin.exdevice.i.b;
import com.tencent.mm.plugin.exdevice.service.d;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;

public final class af
  implements f
{
  com.tencent.mm.sdk.b.c fFn;
  
  public af()
  {
    AppMethodBeat.i(23477);
    this.fFn = new com.tencent.mm.sdk.b.c()
    {
      private boolean a(final zc paramAnonymouszc)
      {
        boolean bool = true;
        AppMethodBeat.i(23475);
        if ((paramAnonymouszc instanceof zc)) {
          switch (paramAnonymouszc.dOj.dkM)
          {
          }
        }
        for (;;)
        {
          AppMethodBeat.o(23475);
          return false;
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WearHardDeviceLogic", "receive register deviceId=%s", new Object[] { paramAnonymouszc.dOj.cUi });
          i.qcH.a(aj.getContext(), new i.a()
          {
            public final void kN(boolean paramAnonymous2Boolean)
            {
              AppMethodBeat.i(23474);
              if (!paramAnonymous2Boolean)
              {
                com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.WearHardDeviceLogic", "GetBoundDeviceLogic Fail, deviceId=%s|deviceType=%s", new Object[] { paramAnonymouszc.dOj.cUi, paramAnonymouszc.dOj.dow });
                af.aQ(paramAnonymouszc.dOj.cUi, false);
                AppMethodBeat.o(23474);
                return;
              }
              af.aQ(paramAnonymouszc.dOj.cUi, true);
              AppMethodBeat.o(23474);
            }
          });
          continue;
          b localb = ad.clt().acJ(paramAnonymouszc.dOj.cUi);
          paramAnonymouszc = paramAnonymouszc.dOj;
          if (localb != null) {}
          for (;;)
          {
            paramAnonymouszc.dpX = bool;
            break;
            bool = false;
          }
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WearHardDeviceLogic", "receive send deviceId=%s", new Object[] { paramAnonymouszc.dOj.cUi });
          ba.aiU().a(538, af.this);
          paramAnonymouszc = new w(0L, paramAnonymouszc.dOj.dow, paramAnonymouszc.dOj.cUi, k.f.ckW(), bt.flT(), paramAnonymouszc.dOj.data, 1);
          ba.aiU().a(paramAnonymouszc, 0);
          continue;
          ba.aiU().a(541, af.this);
          paramAnonymouszc = new r("AndroidWear", paramAnonymouszc.dOj.dow, paramAnonymouszc.dOj.cUi, 1, new byte[0]);
          ba.aiU().a(paramAnonymouszc, 0);
          continue;
          if (!bt.isProcessRunning(aj.getContext(), aj.getPackageName() + ":exdevice")) {
            d.eF(aj.getContext());
          }
        }
      }
    };
    a.IbL.c(this.fFn);
    AppMethodBeat.o(23477);
  }
  
  private static void aO(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(23479);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WearHardDeviceLogic", "publish auth response deviceId=%s | isSuccess=%b", new Object[] { paramString, Boolean.valueOf(paramBoolean) });
    zc localzc = new zc();
    localzc.dOj.dkM = 8;
    localzc.dOj.dpX = paramBoolean;
    localzc.dOj.cUi = paramString;
    a.IbL.l(localzc);
    AppMethodBeat.o(23479);
  }
  
  private static void aP(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(23480);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WearHardDeviceLogic", "publish send response deviceId=%s | isSuccess=%b", new Object[] { paramString, Boolean.valueOf(paramBoolean) });
    zc localzc = new zc();
    localzc.dOj.dkM = 5;
    localzc.dOj.dpX = paramBoolean;
    localzc.dOj.cUi = paramString;
    a.IbL.l(localzc);
    AppMethodBeat.o(23480);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(23478);
    if ((paramn instanceof r))
    {
      ba.aiU().b(541, this);
      paramString = (r)paramn;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        aO(paramString.qcX, true);
        AppMethodBeat.o(23478);
        return;
      }
      aO(paramString.qcX, false);
      AppMethodBeat.o(23478);
      return;
    }
    if ((paramn instanceof w))
    {
      ba.aiU().b(538, this);
      paramString = (w)paramn;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        aP(paramString.qcZ, true);
        AppMethodBeat.o(23478);
        return;
      }
      aP(paramString.qcZ, false);
    }
    AppMethodBeat.o(23478);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.model.af
 * JD-Core Version:    0.7.0.1
 */
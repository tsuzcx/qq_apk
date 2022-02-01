package com.tencent.mm.plugin.exdevice.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.g.a.aap;
import com.tencent.mm.g.a.aap.a;
import com.tencent.mm.model.bg;
import com.tencent.mm.plugin.exdevice.c.k.f;
import com.tencent.mm.plugin.exdevice.i.b;
import com.tencent.mm.plugin.exdevice.i.c;
import com.tencent.mm.plugin.exdevice.service.d;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;

public final class af
  implements com.tencent.mm.ak.i
{
  IListener gmC;
  
  public af()
  {
    AppMethodBeat.i(23477);
    this.gmC = new IListener()
    {
      private boolean a(final aap paramAnonymousaap)
      {
        boolean bool = true;
        AppMethodBeat.i(23475);
        if ((paramAnonymousaap instanceof aap)) {
          switch (paramAnonymousaap.ehC.dDe)
          {
          }
        }
        for (;;)
        {
          AppMethodBeat.o(23475);
          return false;
          Log.i("MicroMsg.WearHardDeviceLogic", "receive register deviceId=%s", new Object[] { paramAnonymousaap.ehC.dGL });
          i.rAi.a(MMApplicationContext.getContext(), new i.a()
          {
            public final void lP(boolean paramAnonymous2Boolean)
            {
              AppMethodBeat.i(23474);
              if (!paramAnonymous2Boolean)
              {
                Log.e("MicroMsg.WearHardDeviceLogic", "GetBoundDeviceLogic Fail, deviceId=%s|deviceType=%s", new Object[] { paramAnonymousaap.ehC.dGL, paramAnonymousaap.ehC.dGP });
                af.aU(paramAnonymousaap.ehC.dGL, false);
                AppMethodBeat.o(23474);
                return;
              }
              af.aU(paramAnonymousaap.ehC.dGL, true);
              AppMethodBeat.o(23474);
            }
          });
          continue;
          b localb = ad.cKL().anJ(paramAnonymousaap.ehC.dGL);
          paramAnonymousaap = paramAnonymousaap.ehC;
          if (localb != null) {}
          for (;;)
          {
            paramAnonymousaap.isSuccess = bool;
            break;
            bool = false;
          }
          Log.i("MicroMsg.WearHardDeviceLogic", "receive send deviceId=%s", new Object[] { paramAnonymousaap.ehC.dGL });
          bg.azz().a(538, af.this);
          paramAnonymousaap = new w(0L, paramAnonymousaap.ehC.dGP, paramAnonymousaap.ehC.dGL, k.f.cKo(), Util.nowMilliSecond(), paramAnonymousaap.ehC.data, 1);
          bg.azz().a(paramAnonymousaap, 0);
          continue;
          bg.azz().a(541, af.this);
          paramAnonymousaap = new r("AndroidWear", paramAnonymousaap.ehC.dGP, paramAnonymousaap.ehC.dGL, 1, new byte[0]);
          bg.azz().a(paramAnonymousaap, 0);
          continue;
          if (!Util.isProcessRunning(MMApplicationContext.getContext(), MMApplicationContext.getPackageName() + ":exdevice")) {
            d.fd(MMApplicationContext.getContext());
          }
        }
      }
    };
    EventCenter.instance.addListener(this.gmC);
    AppMethodBeat.o(23477);
  }
  
  private static void aS(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(23479);
    Log.i("MicroMsg.WearHardDeviceLogic", "publish auth response deviceId=%s | isSuccess=%b", new Object[] { paramString, Boolean.valueOf(paramBoolean) });
    aap localaap = new aap();
    localaap.ehC.dDe = 8;
    localaap.ehC.isSuccess = paramBoolean;
    localaap.ehC.dGL = paramString;
    EventCenter.instance.publish(localaap);
    AppMethodBeat.o(23479);
  }
  
  private static void aT(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(23480);
    Log.i("MicroMsg.WearHardDeviceLogic", "publish send response deviceId=%s | isSuccess=%b", new Object[] { paramString, Boolean.valueOf(paramBoolean) });
    aap localaap = new aap();
    localaap.ehC.dDe = 5;
    localaap.ehC.isSuccess = paramBoolean;
    localaap.ehC.dGL = paramString;
    EventCenter.instance.publish(localaap);
    AppMethodBeat.o(23480);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(23478);
    if ((paramq instanceof r))
    {
      bg.azz().b(541, this);
      paramString = (r)paramq;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        aS(paramString.rAx, true);
        AppMethodBeat.o(23478);
        return;
      }
      aS(paramString.rAx, false);
      AppMethodBeat.o(23478);
      return;
    }
    if ((paramq instanceof w))
    {
      bg.azz().b(538, this);
      paramString = (w)paramq;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        aT(paramString.rAz, true);
        AppMethodBeat.o(23478);
        return;
      }
      aT(paramString.rAz, false);
    }
    AppMethodBeat.o(23478);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.model.af
 * JD-Core Version:    0.7.0.1
 */
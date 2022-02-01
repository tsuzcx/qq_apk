package com.tencent.mm.plugin.exdevice.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.f.a.abw;
import com.tencent.mm.f.a.abw.a;
import com.tencent.mm.model.bh;
import com.tencent.mm.plugin.exdevice.c.k.f;
import com.tencent.mm.plugin.exdevice.i.b;
import com.tencent.mm.plugin.exdevice.i.c;
import com.tencent.mm.plugin.exdevice.service.d;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;

public final class ag
  implements com.tencent.mm.an.i
{
  IListener iQL;
  
  public ag()
  {
    AppMethodBeat.i(23477);
    this.iQL = new IListener()
    {
      private boolean a(final abw paramAnonymousabw)
      {
        boolean bool = true;
        AppMethodBeat.i(23475);
        if ((paramAnonymousabw instanceof abw)) {
          switch (paramAnonymousabw.gbS.fvK)
          {
          }
        }
        for (;;)
        {
          AppMethodBeat.o(23475);
          return false;
          Log.i("MicroMsg.WearHardDeviceLogic", "receive register deviceId=%s", new Object[] { paramAnonymousabw.gbS.fzB });
          i.vfP.a(MMApplicationContext.getContext(), new i.a()
          {
            public final void na(boolean paramAnonymous2Boolean)
            {
              AppMethodBeat.i(23474);
              if (!paramAnonymous2Boolean)
              {
                Log.e("MicroMsg.WearHardDeviceLogic", "GetBoundDeviceLogic Fail, deviceId=%s|deviceType=%s", new Object[] { paramAnonymousabw.gbS.fzB, paramAnonymousabw.gbS.fzF });
                ag.aX(paramAnonymousabw.gbS.fzB, false);
                AppMethodBeat.o(23474);
                return;
              }
              ag.aX(paramAnonymousabw.gbS.fzB, true);
              AppMethodBeat.o(23474);
            }
          });
          continue;
          b localb = ae.cZx().avI(paramAnonymousabw.gbS.fzB);
          paramAnonymousabw = paramAnonymousabw.gbS;
          if (localb != null) {}
          for (;;)
          {
            paramAnonymousabw.isSuccess = bool;
            break;
            bool = false;
          }
          Log.i("MicroMsg.WearHardDeviceLogic", "receive send deviceId=%s", new Object[] { paramAnonymousabw.gbS.fzB });
          bh.aGY().a(538, ag.this);
          paramAnonymousabw = new x(0L, paramAnonymousabw.gbS.fzF, paramAnonymousabw.gbS.fzB, k.f.cYY(), Util.nowMilliSecond(), paramAnonymousabw.gbS.data, 1);
          bh.aGY().a(paramAnonymousabw, 0);
          continue;
          bh.aGY().a(541, ag.this);
          paramAnonymousabw = new s("AndroidWear", paramAnonymousabw.gbS.fzF, paramAnonymousabw.gbS.fzB, 1, new byte[0]);
          bh.aGY().a(paramAnonymousabw, 0);
          continue;
          if (!Util.isProcessRunning(MMApplicationContext.getContext(), MMApplicationContext.getPackageName() + ":exdevice")) {
            d.fh(MMApplicationContext.getContext());
          }
        }
      }
    };
    EventCenter.instance.addListener(this.iQL);
    AppMethodBeat.o(23477);
  }
  
  private static void aV(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(23479);
    Log.i("MicroMsg.WearHardDeviceLogic", "publish auth response deviceId=%s | isSuccess=%b", new Object[] { paramString, Boolean.valueOf(paramBoolean) });
    abw localabw = new abw();
    localabw.gbS.fvK = 8;
    localabw.gbS.isSuccess = paramBoolean;
    localabw.gbS.fzB = paramString;
    EventCenter.instance.publish(localabw);
    AppMethodBeat.o(23479);
  }
  
  private static void aW(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(23480);
    Log.i("MicroMsg.WearHardDeviceLogic", "publish send response deviceId=%s | isSuccess=%b", new Object[] { paramString, Boolean.valueOf(paramBoolean) });
    abw localabw = new abw();
    localabw.gbS.fvK = 5;
    localabw.gbS.isSuccess = paramBoolean;
    localabw.gbS.fzB = paramString;
    EventCenter.instance.publish(localabw);
    AppMethodBeat.o(23480);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(23478);
    if ((paramq instanceof s))
    {
      bh.aGY().b(541, this);
      paramString = (s)paramq;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        aV(paramString.vge, true);
        AppMethodBeat.o(23478);
        return;
      }
      aV(paramString.vge, false);
      AppMethodBeat.o(23478);
      return;
    }
    if ((paramq instanceof x))
    {
      bh.aGY().b(538, this);
      paramString = (x)paramq;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        aW(paramString.vgg, true);
        AppMethodBeat.o(23478);
        return;
      }
      aW(paramString.vgg, false);
    }
    AppMethodBeat.o(23478);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.model.ag
 * JD-Core Version:    0.7.0.1
 */
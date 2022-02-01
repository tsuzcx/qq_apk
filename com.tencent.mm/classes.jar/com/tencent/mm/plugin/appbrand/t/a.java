package com.tencent.mm.plugin.appbrand.t;

import android.app.Activity;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.a.b;
import com.tencent.mm.plugin.appbrand.a.c.a;
import com.tencent.mm.plugin.appbrand.a.d;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.jsapi.j;
import com.tencent.mm.sdk.platformtools.Log;

final class a
  extends com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.logic.c
{
  private volatile b qlj;
  private c.a qlk;
  private Intent qll;
  
  public a(String paramString, Activity paramActivity, e parame)
  {
    super(paramString, paramActivity, parame);
    AppMethodBeat.i(209050);
    this.qlj = b.nKP;
    this.qlk = null;
    this.qll = null;
    M(QK());
    AppMethodBeat.o(209050);
  }
  
  private void K(Intent paramIntent)
  {
    AppMethodBeat.i(209054);
    Log.i("MicroMsg.AppBrand.WxaNFCReadWriteManager", "realTryDispatchNfcTagDiscovered");
    super.F(paramIntent);
    AppMethodBeat.o(209054);
  }
  
  private void M(e parame)
  {
    AppMethodBeat.i(209053);
    parame = N(parame);
    if (parame == null)
    {
      Log.w("MicroMsg.AppBrand.WxaNFCReadWriteManager", "tryListenRunningStateChange, runningStateController is null");
      AppMethodBeat.o(209053);
      return;
    }
    b localb = parame.nKU.bIg();
    Log.i("MicroMsg.AppBrand.WxaNFCReadWriteManager", "tryListenRunningStateChange, curRunningState: ".concat(String.valueOf(localb)));
    this.qlj = localb;
    parame.a(ccy());
    AppMethodBeat.o(209053);
  }
  
  private static com.tencent.mm.plugin.appbrand.a.c N(e parame)
  {
    AppMethodBeat.i(209057);
    if (!(parame instanceof j))
    {
      Log.w("MicroMsg.AppBrand.WxaNFCReadWriteManager", "getRunningStateController, component is not AppBrandComponentWithExtra");
      AppMethodBeat.o(209057);
      return null;
    }
    parame = ((j)parame).getRuntime();
    if (parame == null)
    {
      Log.w("MicroMsg.AppBrand.WxaNFCReadWriteManager", "getRunningStateController, runtime is null");
      AppMethodBeat.o(209057);
      return null;
    }
    parame = parame.ntR;
    AppMethodBeat.o(209057);
    return parame;
  }
  
  private c.a ccx()
  {
    try
    {
      c.a locala = this.qlk;
      return locala;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private c.a ccy()
  {
    try
    {
      AppMethodBeat.i(209055);
      if (this.qlk == null) {
        this.qlk = new c.a()
        {
          public final void a(String paramAnonymousString, b paramAnonymousb)
          {
            AppMethodBeat.i(209249);
            Log.i("MicroMsg.AppBrand.WxaNFCReadWriteManager", "onRunningStateChanged, appId: %s, state: %s", new Object[] { paramAnonymousString, paramAnonymousb });
            if (!a.a(a.this).equals(paramAnonymousString))
            {
              AppMethodBeat.o(209249);
              return;
            }
            a.a(a.this, paramAnonymousb);
            if ((a.b(a.this) != null) && (b.nKP == paramAnonymousb))
            {
              a.a(a.this, a.b(a.this));
              a.c(a.this);
            }
            AppMethodBeat.o(209249);
          }
        };
      }
      c.a locala = this.qlk;
      AppMethodBeat.o(209055);
      return locala;
    }
    finally {}
  }
  
  public final void F(Intent paramIntent)
  {
    AppMethodBeat.i(209052);
    b localb = this.qlj;
    Log.i("MicroMsg.AppBrand.WxaNFCReadWriteManager", "tryDispatchNfcTagDiscovered, curRunningState: ".concat(String.valueOf(localb)));
    if (b.nKP == localb)
    {
      K(paramIntent);
      AppMethodBeat.o(209052);
      return;
    }
    Log.i("MicroMsg.AppBrand.WxaNFCReadWriteManager", "tryDispatchNfcTagDiscovered, dispatch pending");
    this.qll = paramIntent;
    AppMethodBeat.o(209052);
  }
  
  public final void iA(boolean paramBoolean)
  {
    AppMethodBeat.i(209051);
    Log.i("MicroMsg.AppBrand.WxaNFCReadWriteManager", "setRequireForegroundDispatch, requireForegroundDispatch: ".concat(String.valueOf(paramBoolean)));
    super.iA(paramBoolean);
    if (paramBoolean)
    {
      M(QK());
      AppMethodBeat.o(209051);
      return;
    }
    Object localObject = QK();
    c.a locala = ccx();
    if (locala == null)
    {
      Log.i("MicroMsg.AppBrand.WxaNFCReadWriteManager", "stopListenRunningStateChangeIfNeed, not need");
      AppMethodBeat.o(209051);
      return;
    }
    localObject = N((e)localObject);
    if (localObject == null)
    {
      Log.w("MicroMsg.AppBrand.WxaNFCReadWriteManager", "stopListenRunningStateChangeIfNeed, runningStateController is null");
      AppMethodBeat.o(209051);
      return;
    }
    this.qlj = b.nKP;
    ((com.tencent.mm.plugin.appbrand.a.c)localObject).b(locala);
    AppMethodBeat.o(209051);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.t.a
 * JD-Core Version:    0.7.0.1
 */
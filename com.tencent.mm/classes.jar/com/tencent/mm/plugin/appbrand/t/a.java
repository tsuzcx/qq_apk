package com.tencent.mm.plugin.appbrand.t;

import android.app.Activity;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.a.b;
import com.tencent.mm.plugin.appbrand.a.c.a;
import com.tencent.mm.plugin.appbrand.a.d;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.k;
import com.tencent.mm.sdk.platformtools.Log;

final class a
  extends com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.logic.c
{
  private volatile b njL;
  private c.a njM;
  private Intent njN;
  
  public a(String paramString, Activity paramActivity, f paramf)
  {
    super(paramString, paramActivity, paramf);
    AppMethodBeat.i(240905);
    this.njL = b.kQH;
    this.njM = null;
    this.njN = null;
    J(this.lqg);
    AppMethodBeat.o(240905);
  }
  
  private void J(Intent paramIntent)
  {
    AppMethodBeat.i(240909);
    Log.i("MicroMsg.AppBrand.WxaNFCReadWriteManager", "realTryDispatchNfcTagDiscovered");
    super.E(paramIntent);
    AppMethodBeat.o(240909);
  }
  
  private void J(f paramf)
  {
    AppMethodBeat.i(240908);
    paramf = K(paramf);
    if (paramf == null)
    {
      Log.w("MicroMsg.AppBrand.WxaNFCReadWriteManager", "tryListenRunningStateChange, runningStateController is null");
      AppMethodBeat.o(240908);
      return;
    }
    b localb = paramf.kQM.bwY();
    Log.i("MicroMsg.AppBrand.WxaNFCReadWriteManager", "tryListenRunningStateChange, curRunningState: ".concat(String.valueOf(localb)));
    this.njL = localb;
    paramf.a(bPQ());
    AppMethodBeat.o(240908);
  }
  
  private static com.tencent.mm.plugin.appbrand.a.c K(f paramf)
  {
    AppMethodBeat.i(240911);
    if (!(paramf instanceof k))
    {
      Log.w("MicroMsg.AppBrand.WxaNFCReadWriteManager", "getRunningStateController, component is not AppBrandComponentWithExtra");
      AppMethodBeat.o(240911);
      return null;
    }
    paramf = ((k)paramf).getRuntime();
    if (paramf == null)
    {
      Log.w("MicroMsg.AppBrand.WxaNFCReadWriteManager", "getRunningStateController, runtime is null");
      AppMethodBeat.o(240911);
      return null;
    }
    paramf = paramf.kAH;
    AppMethodBeat.o(240911);
    return paramf;
  }
  
  private c.a bPP()
  {
    try
    {
      c.a locala = this.njM;
      return locala;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private c.a bPQ()
  {
    try
    {
      AppMethodBeat.i(240910);
      if (this.njM == null) {
        this.njM = new c.a()
        {
          public final void a(String paramAnonymousString, b paramAnonymousb)
          {
            AppMethodBeat.i(240904);
            Log.i("MicroMsg.AppBrand.WxaNFCReadWriteManager", "onRunningStateChanged, appId: %s, state: %s", new Object[] { paramAnonymousString, paramAnonymousb });
            if (!a.a(a.this).equals(paramAnonymousString))
            {
              AppMethodBeat.o(240904);
              return;
            }
            a.a(a.this, paramAnonymousb);
            if ((a.b(a.this) != null) && (b.kQH == paramAnonymousb))
            {
              a.a(a.this, a.b(a.this));
              a.c(a.this);
            }
            AppMethodBeat.o(240904);
          }
        };
      }
      c.a locala = this.njM;
      AppMethodBeat.o(240910);
      return locala;
    }
    finally {}
  }
  
  public final void E(Intent paramIntent)
  {
    AppMethodBeat.i(240907);
    b localb = this.njL;
    Log.i("MicroMsg.AppBrand.WxaNFCReadWriteManager", "tryDispatchNfcTagDiscovered, curRunningState: ".concat(String.valueOf(localb)));
    if (b.kQH == localb)
    {
      J(paramIntent);
      AppMethodBeat.o(240907);
      return;
    }
    Log.i("MicroMsg.AppBrand.WxaNFCReadWriteManager", "tryDispatchNfcTagDiscovered, dispatch pending");
    this.njN = paramIntent;
    AppMethodBeat.o(240907);
  }
  
  public final void hK(boolean paramBoolean)
  {
    AppMethodBeat.i(240906);
    Log.i("MicroMsg.AppBrand.WxaNFCReadWriteManager", "setRequireForegroundDispatch, requireForegroundDispatch: ".concat(String.valueOf(paramBoolean)));
    super.hK(paramBoolean);
    if (paramBoolean)
    {
      J(this.lqg);
      AppMethodBeat.o(240906);
      return;
    }
    Object localObject = this.lqg;
    c.a locala = bPP();
    if (locala == null)
    {
      Log.i("MicroMsg.AppBrand.WxaNFCReadWriteManager", "stopListenRunningStateChangeIfNeed, not need");
      AppMethodBeat.o(240906);
      return;
    }
    localObject = K((f)localObject);
    if (localObject == null)
    {
      Log.w("MicroMsg.AppBrand.WxaNFCReadWriteManager", "stopListenRunningStateChangeIfNeed, runningStateController is null");
      AppMethodBeat.o(240906);
      return;
    }
    this.njL = b.kQH;
    ((com.tencent.mm.plugin.appbrand.a.c)localObject).b(locala);
    AppMethodBeat.o(240906);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.t.a
 * JD-Core Version:    0.7.0.1
 */
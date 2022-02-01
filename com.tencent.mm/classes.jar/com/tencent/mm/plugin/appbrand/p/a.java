package com.tencent.mm.plugin.appbrand.p;

import android.app.Activity;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.a.b;
import com.tencent.mm.plugin.appbrand.a.c.a;
import com.tencent.mm.plugin.appbrand.a.d;
import com.tencent.mm.plugin.appbrand.jsapi.h;
import com.tencent.mm.sdk.platformtools.ae;

final class a
  extends com.tencent.mm.plugin.appbrand.jsapi.nfc.a.a.c
{
  private volatile b mca;
  private c.a mcb;
  private Intent mcc;
  
  public a(String paramString, Activity paramActivity, com.tencent.mm.plugin.appbrand.jsapi.c paramc)
  {
    super(paramString, paramActivity, paramc);
    AppMethodBeat.i(209709);
    this.mca = b.jOa;
    this.mcb = null;
    this.mcc = null;
    H(this.kmw);
    AppMethodBeat.o(209709);
  }
  
  private void H(com.tencent.mm.plugin.appbrand.jsapi.c paramc)
  {
    AppMethodBeat.i(209712);
    paramc = I(paramc);
    if (paramc == null)
    {
      ae.w("MicroMsg.AppBrand.WxaNFCReadWriteManager", "tryListenRunningStateChange, runningStateController is null");
      AppMethodBeat.o(209712);
      return;
    }
    b localb = paramc.jOf.bbI();
    ae.i("MicroMsg.AppBrand.WxaNFCReadWriteManager", "tryListenRunningStateChange, curRunningState: ".concat(String.valueOf(localb)));
    this.mca = localb;
    paramc.a(buj());
    AppMethodBeat.o(209712);
  }
  
  private static com.tencent.mm.plugin.appbrand.a.c I(com.tencent.mm.plugin.appbrand.jsapi.c paramc)
  {
    AppMethodBeat.i(209715);
    if (!(paramc instanceof h))
    {
      ae.w("MicroMsg.AppBrand.WxaNFCReadWriteManager", "getRunningStateController, component is not AppBrandComponentWithExtra");
      AppMethodBeat.o(209715);
      return null;
    }
    paramc = ((h)paramc).getRuntime();
    if (paramc == null)
    {
      ae.w("MicroMsg.AppBrand.WxaNFCReadWriteManager", "getRunningStateController, runtime is null");
      AppMethodBeat.o(209715);
      return null;
    }
    paramc = paramc.jzQ;
    AppMethodBeat.o(209715);
    return paramc;
  }
  
  private void J(Intent paramIntent)
  {
    AppMethodBeat.i(209713);
    ae.i("MicroMsg.AppBrand.WxaNFCReadWriteManager", "realTryDispatchNfcTagDiscovered");
    super.E(paramIntent);
    AppMethodBeat.o(209713);
  }
  
  private c.a bui()
  {
    try
    {
      c.a locala = this.mcb;
      return locala;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private c.a buj()
  {
    try
    {
      AppMethodBeat.i(209714);
      if (this.mcb == null) {
        this.mcb = new c.a()
        {
          public final void a(String paramAnonymousString, b paramAnonymousb)
          {
            AppMethodBeat.i(209708);
            ae.i("MicroMsg.AppBrand.WxaNFCReadWriteManager", "onRunningStateChanged, appId: %s, state: %s", new Object[] { paramAnonymousString, paramAnonymousb });
            if (!a.a(a.this).equals(paramAnonymousString))
            {
              AppMethodBeat.o(209708);
              return;
            }
            a.a(a.this, paramAnonymousb);
            if ((a.b(a.this) != null) && (b.jOa == paramAnonymousb))
            {
              a.a(a.this, a.b(a.this));
              a.c(a.this);
            }
            AppMethodBeat.o(209708);
          }
        };
      }
      c.a locala = this.mcb;
      AppMethodBeat.o(209714);
      return locala;
    }
    finally {}
  }
  
  public final void E(Intent paramIntent)
  {
    AppMethodBeat.i(209711);
    b localb = this.mca;
    ae.i("MicroMsg.AppBrand.WxaNFCReadWriteManager", "tryDispatchNfcTagDiscovered, curRunningState: ".concat(String.valueOf(localb)));
    if (b.jOa == localb)
    {
      J(paramIntent);
      AppMethodBeat.o(209711);
      return;
    }
    ae.i("MicroMsg.AppBrand.WxaNFCReadWriteManager", "tryDispatchNfcTagDiscovered, dispatch pending");
    this.mcc = paramIntent;
    AppMethodBeat.o(209711);
  }
  
  public final void gN(boolean paramBoolean)
  {
    AppMethodBeat.i(209710);
    ae.i("MicroMsg.AppBrand.WxaNFCReadWriteManager", "setRequireForegroundDispatch, requireForegroundDispatch: ".concat(String.valueOf(paramBoolean)));
    super.gN(paramBoolean);
    if (paramBoolean)
    {
      H(this.kmw);
      AppMethodBeat.o(209710);
      return;
    }
    Object localObject = this.kmw;
    c.a locala = bui();
    if (locala == null)
    {
      ae.i("MicroMsg.AppBrand.WxaNFCReadWriteManager", "stopListenRunningStateChangeIfNeed, not need");
      AppMethodBeat.o(209710);
      return;
    }
    localObject = I((com.tencent.mm.plugin.appbrand.jsapi.c)localObject);
    if (localObject == null)
    {
      ae.w("MicroMsg.AppBrand.WxaNFCReadWriteManager", "stopListenRunningStateChangeIfNeed, runningStateController is null");
      AppMethodBeat.o(209710);
      return;
    }
    this.mca = b.jOa;
    ((com.tencent.mm.plugin.appbrand.a.c)localObject).b(locala);
    AppMethodBeat.o(209710);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.p.a
 * JD-Core Version:    0.7.0.1
 */
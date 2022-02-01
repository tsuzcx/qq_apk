package com.tencent.mm.plugin.appbrand.p;

import android.app.Activity;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.a.b;
import com.tencent.mm.plugin.appbrand.a.c.a;
import com.tencent.mm.plugin.appbrand.a.d;
import com.tencent.mm.plugin.appbrand.jsapi.h;
import com.tencent.mm.sdk.platformtools.ad;

final class a
  extends com.tencent.mm.plugin.appbrand.jsapi.nfc.a.a.c
{
  private volatile b lXt;
  private c.a lXu;
  private Intent lXv;
  
  public a(String paramString, Activity paramActivity, com.tencent.mm.plugin.appbrand.jsapi.c paramc)
  {
    super(paramString, paramActivity, paramc);
    AppMethodBeat.i(198650);
    this.lXt = b.jKO;
    this.lXu = null;
    this.lXv = null;
    G(this.kjg);
    AppMethodBeat.o(198650);
  }
  
  private void G(com.tencent.mm.plugin.appbrand.jsapi.c paramc)
  {
    AppMethodBeat.i(198653);
    paramc = H(paramc);
    if (paramc == null)
    {
      ad.w("MicroMsg.AppBrand.WxaNFCReadWriteManager", "tryListenRunningStateChange, runningStateController is null");
      AppMethodBeat.o(198653);
      return;
    }
    b localb = paramc.jKT.bbg();
    ad.i("MicroMsg.AppBrand.WxaNFCReadWriteManager", "tryListenRunningStateChange, curRunningState: ".concat(String.valueOf(localb)));
    this.lXt = localb;
    paramc.a(bty());
    AppMethodBeat.o(198653);
  }
  
  private static com.tencent.mm.plugin.appbrand.a.c H(com.tencent.mm.plugin.appbrand.jsapi.c paramc)
  {
    AppMethodBeat.i(198656);
    if (!(paramc instanceof h))
    {
      ad.w("MicroMsg.AppBrand.WxaNFCReadWriteManager", "getRunningStateController, component is not AppBrandComponentWithExtra");
      AppMethodBeat.o(198656);
      return null;
    }
    paramc = ((h)paramc).getRuntime();
    if (paramc == null)
    {
      ad.w("MicroMsg.AppBrand.WxaNFCReadWriteManager", "getRunningStateController, runtime is null");
      AppMethodBeat.o(198656);
      return null;
    }
    paramc = paramc.jwS;
    AppMethodBeat.o(198656);
    return paramc;
  }
  
  private void J(Intent paramIntent)
  {
    AppMethodBeat.i(198654);
    ad.i("MicroMsg.AppBrand.WxaNFCReadWriteManager", "realTryDispatchNfcTagDiscovered");
    super.E(paramIntent);
    AppMethodBeat.o(198654);
  }
  
  private c.a btx()
  {
    try
    {
      c.a locala = this.lXu;
      return locala;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private c.a bty()
  {
    try
    {
      AppMethodBeat.i(198655);
      if (this.lXu == null) {
        this.lXu = new c.a()
        {
          public final void a(String paramAnonymousString, b paramAnonymousb)
          {
            AppMethodBeat.i(198649);
            ad.i("MicroMsg.AppBrand.WxaNFCReadWriteManager", "onRunningStateChanged, appId: %s, state: %s", new Object[] { paramAnonymousString, paramAnonymousb });
            if (!a.a(a.this).equals(paramAnonymousString))
            {
              AppMethodBeat.o(198649);
              return;
            }
            a.a(a.this, paramAnonymousb);
            if ((a.b(a.this) != null) && (b.jKO == paramAnonymousb))
            {
              a.a(a.this, a.b(a.this));
              a.c(a.this);
            }
            AppMethodBeat.o(198649);
          }
        };
      }
      c.a locala = this.lXu;
      AppMethodBeat.o(198655);
      return locala;
    }
    finally {}
  }
  
  public final void E(Intent paramIntent)
  {
    AppMethodBeat.i(198652);
    b localb = this.lXt;
    ad.i("MicroMsg.AppBrand.WxaNFCReadWriteManager", "tryDispatchNfcTagDiscovered, curRunningState: ".concat(String.valueOf(localb)));
    if (b.jKO == localb)
    {
      J(paramIntent);
      AppMethodBeat.o(198652);
      return;
    }
    ad.i("MicroMsg.AppBrand.WxaNFCReadWriteManager", "tryDispatchNfcTagDiscovered, dispatch pending");
    this.lXv = paramIntent;
    AppMethodBeat.o(198652);
  }
  
  public final void gO(boolean paramBoolean)
  {
    AppMethodBeat.i(198651);
    ad.i("MicroMsg.AppBrand.WxaNFCReadWriteManager", "setRequireForegroundDispatch, requireForegroundDispatch: ".concat(String.valueOf(paramBoolean)));
    super.gO(paramBoolean);
    if (paramBoolean)
    {
      G(this.kjg);
      AppMethodBeat.o(198651);
      return;
    }
    Object localObject = this.kjg;
    c.a locala = btx();
    if (locala == null)
    {
      ad.i("MicroMsg.AppBrand.WxaNFCReadWriteManager", "stopListenRunningStateChangeIfNeed, not need");
      AppMethodBeat.o(198651);
      return;
    }
    localObject = H((com.tencent.mm.plugin.appbrand.jsapi.c)localObject);
    if (localObject == null)
    {
      ad.w("MicroMsg.AppBrand.WxaNFCReadWriteManager", "stopListenRunningStateChangeIfNeed, runningStateController is null");
      AppMethodBeat.o(198651);
      return;
    }
    this.lXt = b.jKO;
    ((com.tencent.mm.plugin.appbrand.a.c)localObject).b(locala);
    AppMethodBeat.o(198651);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.p.a
 * JD-Core Version:    0.7.0.1
 */
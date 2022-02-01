package com.tencent.mm.plugin.appbrand.game.f;

import android.util.Base64;
import com.tencent.luggage.game.page.d;
import com.tencent.magicbrush.ui.MagicBrushView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.game.e.b.a;
import com.tencent.mm.plugin.appbrand.jsapi.r;
import com.tencent.mm.plugin.appbrand.page.ah;
import com.tencent.mm.plugin.appbrand.page.u;
import com.tencent.mm.plugin.appbrand.page.x;
import com.tencent.mm.protocal.protobuf.foo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import java.lang.ref.WeakReference;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import java.util.HashMap;
import java.util.Map;

public final class b
{
  WeakReference<AppBrandRuntime> csN;
  public foo onW;
  public MMHandler onX;
  public PublicKey onY;
  
  b(foo paramfoo, AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(45170);
    this.onW = paramfoo;
    this.csN = new WeakReference(paramAppBrandRuntime);
    this.onX = new MMHandler("canvas_security_guard");
    if ((this.onW != null) && (this.onW.UMK != null) && (this.onW.UMK.UH != null))
    {
      paramfoo = Base64.decode(new String(this.onW.UMK.UH).replace("\n", "").replace("-----BEGIN PUBLIC KEY-----", "").replace("-----END PUBLIC KEY-----", ""), 0);
      try
      {
        paramfoo = new X509EncodedKeySpec(paramfoo);
        this.onY = KeyFactory.getInstance("RSA").generatePublic(paramfoo);
        Log.d("MicroMsg.WAGameCanvasSecurityGuard", "hy: sample config: %s", new Object[] { this.onW.UMJ });
        AppMethodBeat.o(45170);
        return;
      }
      catch (Throwable paramfoo)
      {
        for (;;)
        {
          Log.printErrStackTrace("MicroMsg.WAGameCanvasSecurityGuard", paramfoo, "hy: can not retrieve rsa key!", new Object[0]);
          this.onY = null;
        }
      }
    }
    Log.w("MicroMsg.WAGameCanvasSecurityGuard", "hy: no pubkey retrieved");
    this.onY = null;
    AppMethodBeat.o(45170);
  }
  
  final ah bDv()
  {
    AppMethodBeat.i(180199);
    if ((this.csN.get() != null) && (((AppBrandRuntime)this.csN.get()).bBX() != null) && (((AppBrandRuntime)this.csN.get()).bBX().getCurrentPage() != null) && ((((AppBrandRuntime)this.csN.get()).bBX().getCurrentPage().getCurrentPageView() instanceof ah)))
    {
      ah localah = (ah)((AppBrandRuntime)this.csN.get()).bBX().getCurrentPage().getCurrentPageView();
      AppMethodBeat.o(180199);
      return localah;
    }
    Log.w("MicroMsg.WAGameCanvasSecurityGuard", "hy: runtime released");
    AppMethodBeat.o(180199);
    return null;
  }
  
  public final boolean bOH()
  {
    return (this.onW != null) && (this.onW.UMB);
  }
  
  public final d bOI()
  {
    AppMethodBeat.i(45171);
    if (bDv() != null)
    {
      d locald = (d)bDv().R(d.class);
      AppMethodBeat.o(45171);
      return locald;
    }
    Log.w("MicroMsg.WAGameCanvasSecurityGuard", "hy: GamePageLogicExt not found");
    AppMethodBeat.o(45171);
    return null;
  }
  
  public final boolean bOJ()
  {
    AppMethodBeat.i(45172);
    if ((bOI() != null) && (bOI().PI() != null) && (!bOI().PI().getMagicBrush().isDestroyed()))
    {
      AppMethodBeat.o(45172);
      return true;
    }
    AppMethodBeat.o(45172);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.f.b
 * JD-Core Version:    0.7.0.1
 */
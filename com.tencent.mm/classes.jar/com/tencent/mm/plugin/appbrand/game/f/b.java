package com.tencent.mm.plugin.appbrand.game.f;

import android.util.Base64;
import com.tencent.magicbrush.ui.MagicBrushView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.game.e.b.a;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.plugin.appbrand.page.ad;
import com.tencent.mm.plugin.appbrand.page.q;
import com.tencent.mm.plugin.appbrand.page.t;
import com.tencent.mm.protocal.protobuf.eiv;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import java.lang.ref.WeakReference;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import java.util.HashMap;
import java.util.Map;

public final class b
{
  WeakReference<AppBrandRuntime> ciI;
  public eiv kpq;
  public aq kpr;
  public PublicKey kps;
  
  b(eiv parameiv, AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(45170);
    this.kpq = parameiv;
    this.ciI = new WeakReference(paramAppBrandRuntime);
    this.kpr = new aq("canvas_security_guard");
    if ((this.kpq != null) && (this.kpq.Imd != null) && (this.kpq.Imd.zr != null))
    {
      parameiv = Base64.decode(new String(this.kpq.Imd.zr).replace("\n", "").replace("-----BEGIN PUBLIC KEY-----", "").replace("-----END PUBLIC KEY-----", ""), 0);
      try
      {
        parameiv = new X509EncodedKeySpec(parameiv);
        this.kps = KeyFactory.getInstance("RSA").generatePublic(parameiv);
        ae.d("MicroMsg.WAGameCanvasSecurityGuard", "hy: sample config: %s", new Object[] { this.kpq.Imc });
        AppMethodBeat.o(45170);
        return;
      }
      catch (Throwable parameiv)
      {
        for (;;)
        {
          ae.printErrStackTrace("MicroMsg.WAGameCanvasSecurityGuard", parameiv, "hy: can not retrieve rsa key!", new Object[0]);
          this.kps = null;
        }
      }
    }
    ae.w("MicroMsg.WAGameCanvasSecurityGuard", "hy: no pubkey retrieved");
    this.kps = null;
    AppMethodBeat.o(45170);
  }
  
  final ad aXu()
  {
    AppMethodBeat.i(180199);
    if ((this.ciI.get() != null) && (((AppBrandRuntime)this.ciI.get()).aWm() != null) && (((AppBrandRuntime)this.ciI.get()).aWm().getCurrentPage() != null) && ((((AppBrandRuntime)this.ciI.get()).aWm().getCurrentPage().getCurrentPageView() instanceof ad)))
    {
      ad localad = (ad)((AppBrandRuntime)this.ciI.get()).aWm().getCurrentPage().getCurrentPageView();
      AppMethodBeat.o(180199);
      return localad;
    }
    ae.w("MicroMsg.WAGameCanvasSecurityGuard", "hy: runtime released");
    AppMethodBeat.o(180199);
    return null;
  }
  
  public final boolean bhV()
  {
    return (this.kpq != null) && (this.kpq.IlU);
  }
  
  public final com.tencent.luggage.game.page.d bhW()
  {
    AppMethodBeat.i(45171);
    if (aXu() != null)
    {
      com.tencent.luggage.game.page.d locald = (com.tencent.luggage.game.page.d)aXu().Q(com.tencent.luggage.game.page.d.class);
      AppMethodBeat.o(45171);
      return locald;
    }
    ae.w("MicroMsg.WAGameCanvasSecurityGuard", "hy: GamePageLogicExt not found");
    AppMethodBeat.o(45171);
    return null;
  }
  
  public final boolean bhX()
  {
    AppMethodBeat.i(45172);
    if ((bhW() != null) && (bhW().getMagicBrushView() != null) && (!bhW().getMagicBrushView().getMagicBrush().isDestroyed()))
    {
      AppMethodBeat.o(45172);
      return true;
    }
    AppMethodBeat.o(45172);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.f.b
 * JD-Core Version:    0.7.0.1
 */
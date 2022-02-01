package com.tencent.mm.plugin.appbrand.game.f;

import android.util.Base64;
import com.tencent.luggage.game.page.d;
import com.tencent.magicbrush.e;
import com.tencent.magicbrush.ui.MagicBrushView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.game.e.b.a;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.s;
import com.tencent.mm.plugin.appbrand.page.ag;
import com.tencent.mm.plugin.appbrand.page.t;
import com.tencent.mm.plugin.appbrand.page.w;
import com.tencent.mm.protocal.protobuf.fdn;
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
  WeakReference<AppBrandRuntime> cuB;
  public fdn lsZ;
  public MMHandler lta;
  public PublicKey ltb;
  
  b(fdn paramfdn, AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(45170);
    this.lsZ = paramfdn;
    this.cuB = new WeakReference(paramAppBrandRuntime);
    this.lta = new MMHandler("canvas_security_guard");
    if ((this.lsZ != null) && (this.lsZ.Nzg != null) && (this.lsZ.Nzg.zy != null))
    {
      paramfdn = Base64.decode(new String(this.lsZ.Nzg.zy).replace("\n", "").replace("-----BEGIN PUBLIC KEY-----", "").replace("-----END PUBLIC KEY-----", ""), 0);
      try
      {
        paramfdn = new X509EncodedKeySpec(paramfdn);
        this.ltb = KeyFactory.getInstance("RSA").generatePublic(paramfdn);
        Log.d("MicroMsg.WAGameCanvasSecurityGuard", "hy: sample config: %s", new Object[] { this.lsZ.Nzf });
        AppMethodBeat.o(45170);
        return;
      }
      catch (Throwable paramfdn)
      {
        for (;;)
        {
          Log.printErrStackTrace("MicroMsg.WAGameCanvasSecurityGuard", paramfdn, "hy: can not retrieve rsa key!", new Object[0]);
          this.ltb = null;
        }
      }
    }
    Log.w("MicroMsg.WAGameCanvasSecurityGuard", "hy: no pubkey retrieved");
    this.ltb = null;
    AppMethodBeat.o(45170);
  }
  
  public final boolean bDk()
  {
    return (this.lsZ != null) && (this.lsZ.NyX);
  }
  
  public final d bDl()
  {
    AppMethodBeat.i(45171);
    if (bsz() != null)
    {
      d locald = (d)bsz().S(d.class);
      AppMethodBeat.o(45171);
      return locald;
    }
    Log.w("MicroMsg.WAGameCanvasSecurityGuard", "hy: GamePageLogicExt not found");
    AppMethodBeat.o(45171);
    return null;
  }
  
  public final boolean bDm()
  {
    AppMethodBeat.i(45172);
    if ((bDl() != null) && (bDl().MQ() != null) && (!bDl().MQ().getMagicBrush().isDestroyed()))
    {
      AppMethodBeat.o(45172);
      return true;
    }
    AppMethodBeat.o(45172);
    return false;
  }
  
  final ag bsz()
  {
    AppMethodBeat.i(180199);
    if ((this.cuB.get() != null) && (((AppBrandRuntime)this.cuB.get()).brh() != null) && (((AppBrandRuntime)this.cuB.get()).brh().getCurrentPage() != null) && ((((AppBrandRuntime)this.cuB.get()).brh().getCurrentPage().getCurrentPageView() instanceof ag)))
    {
      ag localag = (ag)((AppBrandRuntime)this.cuB.get()).brh().getCurrentPage().getCurrentPageView();
      AppMethodBeat.o(180199);
      return localag;
    }
    Log.w("MicroMsg.WAGameCanvasSecurityGuard", "hy: runtime released");
    AppMethodBeat.o(180199);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.f.b
 * JD-Core Version:    0.7.0.1
 */
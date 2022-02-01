package com.tencent.mm.plugin.appbrand.game.f;

import android.util.Base64;
import com.tencent.magicbrush.ui.MagicBrushView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.game.e.b.a;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.plugin.appbrand.page.ae;
import com.tencent.mm.plugin.appbrand.page.r;
import com.tencent.mm.plugin.appbrand.page.u;
import com.tencent.mm.protocal.protobuf.ehe;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import java.lang.ref.WeakReference;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import java.util.HashMap;
import java.util.Map;

public final class b
{
  WeakReference<AppBrandRuntime> ciG;
  public ehe kma;
  public ap kmb;
  public PublicKey kmc;
  
  b(ehe paramehe, AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(45170);
    this.kma = paramehe;
    this.ciG = new WeakReference(paramAppBrandRuntime);
    this.kmb = new ap("canvas_security_guard");
    if ((this.kma != null) && (this.kma.HRW != null) && (this.kma.HRW.zr != null))
    {
      paramehe = Base64.decode(new String(this.kma.HRW.zr).replace("\n", "").replace("-----BEGIN PUBLIC KEY-----", "").replace("-----END PUBLIC KEY-----", ""), 0);
      try
      {
        paramehe = new X509EncodedKeySpec(paramehe);
        this.kmc = KeyFactory.getInstance("RSA").generatePublic(paramehe);
        ad.d("MicroMsg.WAGameCanvasSecurityGuard", "hy: sample config: %s", new Object[] { this.kma.HRV });
        AppMethodBeat.o(45170);
        return;
      }
      catch (Throwable paramehe)
      {
        for (;;)
        {
          ad.printErrStackTrace("MicroMsg.WAGameCanvasSecurityGuard", paramehe, "hy: can not retrieve rsa key!", new Object[0]);
          this.kmc = null;
        }
      }
    }
    ad.w("MicroMsg.WAGameCanvasSecurityGuard", "hy: no pubkey retrieved");
    this.kmc = null;
    AppMethodBeat.o(45170);
  }
  
  final ae aWZ()
  {
    AppMethodBeat.i(180199);
    if ((this.ciG.get() != null) && (((AppBrandRuntime)this.ciG.get()).aVN() != null) && (((AppBrandRuntime)this.ciG.get()).aVN().getCurrentPage() != null) && ((((AppBrandRuntime)this.ciG.get()).aVN().getCurrentPage().getCurrentPageView() instanceof ae)))
    {
      ae localae = (ae)((AppBrandRuntime)this.ciG.get()).aVN().getCurrentPage().getCurrentPageView();
      AppMethodBeat.o(180199);
      return localae;
    }
    ad.w("MicroMsg.WAGameCanvasSecurityGuard", "hy: runtime released");
    AppMethodBeat.o(180199);
    return null;
  }
  
  public final boolean bhn()
  {
    return (this.kma != null) && (this.kma.HRN);
  }
  
  public final com.tencent.luggage.game.page.d bho()
  {
    AppMethodBeat.i(45171);
    if (aWZ() != null)
    {
      com.tencent.luggage.game.page.d locald = (com.tencent.luggage.game.page.d)aWZ().Q(com.tencent.luggage.game.page.d.class);
      AppMethodBeat.o(45171);
      return locald;
    }
    ad.w("MicroMsg.WAGameCanvasSecurityGuard", "hy: GamePageLogicExt not found");
    AppMethodBeat.o(45171);
    return null;
  }
  
  public final boolean bhp()
  {
    AppMethodBeat.i(45172);
    if ((bho() != null) && (bho().getMagicBrushView() != null) && (!bho().getMagicBrushView().getMagicBrush().isDestroyed()))
    {
      AppMethodBeat.o(45172);
      return true;
    }
    AppMethodBeat.o(45172);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.f.b
 * JD-Core Version:    0.7.0.1
 */
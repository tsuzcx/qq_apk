package com.tencent.mm.plugin.appbrand.game.f;

import android.util.Base64;
import com.tencent.magicbrush.ui.MagicBrushView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.game.e.b.a;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.plugin.appbrand.page.ae;
import com.tencent.mm.plugin.appbrand.page.q;
import com.tencent.mm.plugin.appbrand.page.t;
import com.tencent.mm.protocal.protobuf.dvj;
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
  WeakReference<AppBrandRuntime> cbr;
  public dvj jru;
  public ap jrv;
  public PublicKey jrw;
  
  b(dvj paramdvj, AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(45170);
    this.jru = paramdvj;
    this.cbr = new WeakReference(paramAppBrandRuntime);
    this.jrv = new ap("canvas_security_guard");
    if ((this.jru != null) && (this.jru.EJx != null) && (this.jru.EJx.wA != null))
    {
      paramdvj = Base64.decode(new String(this.jru.EJx.wA).replace("\n", "").replace("-----BEGIN PUBLIC KEY-----", "").replace("-----END PUBLIC KEY-----", ""), 0);
      try
      {
        paramdvj = new X509EncodedKeySpec(paramdvj);
        this.jrw = KeyFactory.getInstance("RSA").generatePublic(paramdvj);
        ad.d("MicroMsg.WAGameCanvasSecurityGuard", "hy: sample config: %s", new Object[] { this.jru.EJw });
        AppMethodBeat.o(45170);
        return;
      }
      catch (Throwable paramdvj)
      {
        for (;;)
        {
          ad.printErrStackTrace("MicroMsg.WAGameCanvasSecurityGuard", paramdvj, "hy: can not retrieve rsa key!", new Object[0]);
          this.jrw = null;
        }
      }
    }
    ad.w("MicroMsg.WAGameCanvasSecurityGuard", "hy: no pubkey retrieved");
    this.jrw = null;
    AppMethodBeat.o(45170);
  }
  
  final ae aMZ()
  {
    AppMethodBeat.i(180199);
    if ((this.cbr.get() != null) && (((AppBrandRuntime)this.cbr.get()).aLK() != null) && (((AppBrandRuntime)this.cbr.get()).aLK().getCurrentPage() != null) && ((((AppBrandRuntime)this.cbr.get()).aLK().getCurrentPage().getCurrentPageView() instanceof ae)))
    {
      ae localae = (ae)((AppBrandRuntime)this.cbr.get()).aLK().getCurrentPage().getCurrentPageView();
      AppMethodBeat.o(180199);
      return localae;
    }
    ad.w("MicroMsg.WAGameCanvasSecurityGuard", "hy: runtime released");
    AppMethodBeat.o(180199);
    return null;
  }
  
  public final boolean aWL()
  {
    return (this.jru != null) && (this.jru.EJo);
  }
  
  public final com.tencent.luggage.game.page.d aWM()
  {
    AppMethodBeat.i(45171);
    if (aMZ() != null)
    {
      com.tencent.luggage.game.page.d locald = (com.tencent.luggage.game.page.d)aMZ().Q(com.tencent.luggage.game.page.d.class);
      AppMethodBeat.o(45171);
      return locald;
    }
    ad.w("MicroMsg.WAGameCanvasSecurityGuard", "hy: GamePageLogicExt not found");
    AppMethodBeat.o(45171);
    return null;
  }
  
  public final boolean aWN()
  {
    AppMethodBeat.i(45172);
    if ((aWM() != null) && (aWM().Cn() != null) && (!aWM().Cn().getMagicBrush().isDestroyed()))
    {
      AppMethodBeat.o(45172);
      return true;
    }
    AppMethodBeat.o(45172);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.f.b
 * JD-Core Version:    0.7.0.1
 */
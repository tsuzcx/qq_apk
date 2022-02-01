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
import com.tencent.mm.protocal.protobuf.eba;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import java.lang.ref.WeakReference;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import java.util.HashMap;
import java.util.Map;

public final class b
{
  WeakReference<AppBrandRuntime> bYo;
  public eba jRM;
  public ao jRN;
  public PublicKey jRO;
  
  b(eba parameba, AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(45170);
    this.jRM = parameba;
    this.bYo = new WeakReference(paramAppBrandRuntime);
    this.jRN = new ao("canvas_security_guard");
    if ((this.jRM != null) && (this.jRM.GgJ != null) && (this.jRM.GgJ.xy != null))
    {
      parameba = Base64.decode(new String(this.jRM.GgJ.xy).replace("\n", "").replace("-----BEGIN PUBLIC KEY-----", "").replace("-----END PUBLIC KEY-----", ""), 0);
      try
      {
        parameba = new X509EncodedKeySpec(parameba);
        this.jRO = KeyFactory.getInstance("RSA").generatePublic(parameba);
        ac.d("MicroMsg.WAGameCanvasSecurityGuard", "hy: sample config: %s", new Object[] { this.jRM.GgI });
        AppMethodBeat.o(45170);
        return;
      }
      catch (Throwable parameba)
      {
        for (;;)
        {
          ac.printErrStackTrace("MicroMsg.WAGameCanvasSecurityGuard", parameba, "hy: can not retrieve rsa key!", new Object[0]);
          this.jRO = null;
        }
      }
    }
    ac.w("MicroMsg.WAGameCanvasSecurityGuard", "hy: no pubkey retrieved");
    this.jRO = null;
    AppMethodBeat.o(45170);
  }
  
  final ae aTP()
  {
    AppMethodBeat.i(180199);
    if ((this.bYo.get() != null) && (((AppBrandRuntime)this.bYo.get()).aSA() != null) && (((AppBrandRuntime)this.bYo.get()).aSA().getCurrentPage() != null) && ((((AppBrandRuntime)this.bYo.get()).aSA().getCurrentPage().getCurrentPageView() instanceof ae)))
    {
      ae localae = (ae)((AppBrandRuntime)this.bYo.get()).aSA().getCurrentPage().getCurrentPageView();
      AppMethodBeat.o(180199);
      return localae;
    }
    ac.w("MicroMsg.WAGameCanvasSecurityGuard", "hy: runtime released");
    AppMethodBeat.o(180199);
    return null;
  }
  
  public final boolean bdJ()
  {
    return (this.jRM != null) && (this.jRM.GgA);
  }
  
  public final com.tencent.luggage.game.page.d bdK()
  {
    AppMethodBeat.i(45171);
    if (aTP() != null)
    {
      com.tencent.luggage.game.page.d locald = (com.tencent.luggage.game.page.d)aTP().Q(com.tencent.luggage.game.page.d.class);
      AppMethodBeat.o(45171);
      return locald;
    }
    ac.w("MicroMsg.WAGameCanvasSecurityGuard", "hy: GamePageLogicExt not found");
    AppMethodBeat.o(45171);
    return null;
  }
  
  public final boolean bdL()
  {
    AppMethodBeat.i(45172);
    if ((bdK() != null) && (bdK().BR() != null) && (!bdK().BR().getMagicBrush().isDestroyed()))
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
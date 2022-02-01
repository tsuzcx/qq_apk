package com.tencent.mm.plugin.appbrand.game.f;

import android.util.Base64;
import com.tencent.luggage.game.page.d;
import com.tencent.magicbrush.e;
import com.tencent.magicbrush.ui.MagicBrushView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.page.ah;
import com.tencent.mm.plugin.appbrand.page.u;
import com.tencent.mm.plugin.appbrand.page.x;
import com.tencent.mm.protocal.protobuf.glo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import java.lang.ref.WeakReference;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;

public final class b
{
  WeakReference<AppBrandRuntime> ekH;
  public glo rrF;
  public MMHandler rrG;
  public PublicKey rrH;
  
  b(glo paramglo, AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(45170);
    this.rrF = paramglo;
    this.ekH = new WeakReference(paramAppBrandRuntime);
    this.rrG = new MMHandler("canvas_security_guard");
    if ((this.rrF != null) && (this.rrF.achf != null) && (this.rrF.achf.Op != null))
    {
      paramglo = Base64.decode(new String(this.rrF.achf.Op).replace("\n", "").replace("-----BEGIN PUBLIC KEY-----", "").replace("-----END PUBLIC KEY-----", ""), 0);
      try
      {
        paramglo = new X509EncodedKeySpec(paramglo);
        this.rrH = KeyFactory.getInstance("RSA").generatePublic(paramglo);
        Log.d("MicroMsg.WAGameCanvasSecurityGuard", "hy: sample config: %s", new Object[] { this.rrF.ache });
        AppMethodBeat.o(45170);
        return;
      }
      finally
      {
        for (;;)
        {
          Log.printErrStackTrace("MicroMsg.WAGameCanvasSecurityGuard", paramglo, "hy: can not retrieve rsa key!", new Object[0]);
          this.rrH = null;
        }
      }
    }
    Log.w("MicroMsg.WAGameCanvasSecurityGuard", "hy: no pubkey retrieved");
    this.rrH = null;
    AppMethodBeat.o(45170);
  }
  
  final ah ccK()
  {
    AppMethodBeat.i(180199);
    if ((this.ekH.get() != null) && (((AppBrandRuntime)this.ekH.get()).getPageContainer() != null) && (((AppBrandRuntime)this.ekH.get()).getPageContainer().getCurrentPage() != null) && ((((AppBrandRuntime)this.ekH.get()).getPageContainer().getCurrentPage().getCurrentPageView() instanceof ah)))
    {
      ah localah = (ah)((AppBrandRuntime)this.ekH.get()).getPageContainer().getCurrentPage().getCurrentPageView();
      AppMethodBeat.o(180199);
      return localah;
    }
    Log.w("MicroMsg.WAGameCanvasSecurityGuard", "hy: runtime released");
    AppMethodBeat.o(180199);
    return null;
  }
  
  public final boolean coV()
  {
    return (this.rrF != null) && (this.rrF.acgV);
  }
  
  public final d coW()
  {
    AppMethodBeat.i(45171);
    if (ccK() != null)
    {
      d locald = (d)ccK().aa(d.class);
      AppMethodBeat.o(45171);
      return locald;
    }
    Log.w("MicroMsg.WAGameCanvasSecurityGuard", "hy: GamePageLogicExt not found");
    AppMethodBeat.o(45171);
    return null;
  }
  
  public final boolean coX()
  {
    AppMethodBeat.i(45172);
    if ((coW() != null) && (coW().apS() != null) && (!coW().apS().getMagicBrush().isDestroyed()))
    {
      AppMethodBeat.o(45172);
      return true;
    }
    AppMethodBeat.o(45172);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.f.b
 * JD-Core Version:    0.7.0.1
 */
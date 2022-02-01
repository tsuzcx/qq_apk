package com.tencent.mm.plugin.appbrand.floatball;

import android.app.Activity;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.ball.f.b;
import com.tencent.mm.plugin.ball.model.BallInfo;
import com.tencent.mm.sdk.platformtools.ad;

public final class d
{
  public f kjA;
  public g kjB;
  public h kjC;
  public a kjD;
  public c kjz;
  
  public static void a(com.tencent.mm.plugin.ball.service.a parama, AppBrandInitConfig paramAppBrandInitConfig)
  {
    int i = 0;
    AppMethodBeat.i(188152);
    if (!(paramAppBrandInitConfig instanceof AppBrandInitConfigWC))
    {
      AppMethodBeat.o(188152);
      return;
    }
    paramAppBrandInitConfig = (AppBrandInitConfigWC)paramAppBrandInitConfig;
    ad.i("MicroMsg.AppBrandFloatBallLogic", "setReportInfo, floatBallHelper:%s, configAppName:%s", new Object[] { parama, paramAppBrandInitConfig.doD });
    parama.bKG().dwX = paramAppBrandInitConfig.appId;
    parama.bKG().hPO = paramAppBrandInitConfig.doD;
    parama.bKG().nGd = String.valueOf(paramAppBrandInitConfig.cmr);
    parama = parama.bKG();
    if (paramAppBrandInitConfig.cmC == null) {}
    for (;;)
    {
      parama.nGb = i;
      AppMethodBeat.o(188152);
      return;
      i = paramAppBrandInitConfig.cmC.scene;
    }
  }
  
  public final void r(o paramo)
  {
    AppMethodBeat.i(188151);
    ad.i("MicroMsg.AppBrandFloatBallLogic", "destroy, runtime:%s", new Object[] { paramo.mAppId });
    if (this.kjz != null) {
      this.kjz.onDestroy();
    }
    if (this.kjA != null) {
      this.kjA.onDestroy();
    }
    if (this.kjB != null) {
      this.kjB.onDestroy();
    }
    if (this.kjD != null) {
      this.kjD.onDestroy();
    }
    if (this.kjC != null) {
      this.kjC.onDestroy();
    }
    AppMethodBeat.o(188151);
  }
  
  public final boolean sx(int paramInt)
  {
    AppMethodBeat.i(188150);
    if ((this.kjz != null) && (this.kjz.sv(paramInt)))
    {
      AppMethodBeat.o(188150);
      return true;
    }
    if ((this.kjA != null) && (this.kjA.sv(paramInt)))
    {
      AppMethodBeat.o(188150);
      return true;
    }
    if ((this.kjB != null) && (this.kjB.sv(paramInt)))
    {
      AppMethodBeat.o(188150);
      return true;
    }
    if ((this.kjD != null) && (this.kjD.sv(paramInt)))
    {
      AppMethodBeat.o(188150);
      return true;
    }
    if ((this.kjC != null) && (this.kjC.sv(paramInt)))
    {
      AppMethodBeat.o(188150);
      return true;
    }
    AppMethodBeat.o(188150);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.floatball.d
 * JD-Core Version:    0.7.0.1
 */
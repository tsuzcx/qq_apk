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
  public c jpd;
  public f jpe;
  public g jpf;
  public a jpg;
  
  public static void a(com.tencent.mm.plugin.ball.service.a parama, AppBrandInitConfig paramAppBrandInitConfig)
  {
    int i = 0;
    AppMethodBeat.i(195734);
    if (!(paramAppBrandInitConfig instanceof AppBrandInitConfigWC))
    {
      AppMethodBeat.o(195734);
      return;
    }
    paramAppBrandInitConfig = (AppBrandInitConfigWC)paramAppBrandInitConfig;
    ad.i("MicroMsg.AppBrandFloatBallLogic", "setReportInfo, floatBallHelper:%s, configAppName:%s", new Object[] { parama, paramAppBrandInitConfig.dfM });
    parama.bzz().dnC = paramAppBrandInitConfig.appId;
    parama.bzz().gWU = paramAppBrandInitConfig.dfM;
    parama.bzz().mDA = String.valueOf(paramAppBrandInitConfig.cfd);
    parama = parama.bzz();
    if (paramAppBrandInitConfig.cfo == null) {}
    for (;;)
    {
      parama.mDy = i;
      AppMethodBeat.o(195734);
      return;
      i = paramAppBrandInitConfig.cfo.scene;
    }
  }
  
  public final void A(o paramo)
  {
    AppMethodBeat.i(195733);
    ad.i("MicroMsg.AppBrandFloatBallLogic", "destroy, runtime:%s", new Object[] { paramo.mAppId });
    if (this.jpd != null) {
      this.jpd.onDestroy();
    }
    if (this.jpe != null) {
      this.jpe.onDestroy();
    }
    if (this.jpf != null) {
      this.jpf.onDestroy();
    }
    if (this.jpg != null) {
      this.jpg.onDestroy();
    }
    AppMethodBeat.o(195733);
  }
  
  public final boolean ri(int paramInt)
  {
    AppMethodBeat.i(195732);
    if ((this.jpd != null) && (this.jpd.rg(paramInt)))
    {
      AppMethodBeat.o(195732);
      return true;
    }
    if ((this.jpe != null) && (this.jpe.rg(paramInt)))
    {
      AppMethodBeat.o(195732);
      return true;
    }
    if ((this.jpf != null) && (this.jpf.rg(paramInt)))
    {
      AppMethodBeat.o(195732);
      return true;
    }
    if ((this.jpg != null) && (this.jpg.rg(paramInt)))
    {
      AppMethodBeat.o(195732);
      return true;
    }
    AppMethodBeat.o(195732);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.floatball.d
 * JD-Core Version:    0.7.0.1
 */
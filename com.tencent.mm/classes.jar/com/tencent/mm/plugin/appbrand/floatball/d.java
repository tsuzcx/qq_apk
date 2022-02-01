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
import com.tencent.mm.sdk.platformtools.ac;

public final class d
{
  public c jPp;
  public f jPq;
  public g jPr;
  public h jPs;
  public a jPt;
  
  public static void a(com.tencent.mm.plugin.ball.service.a parama, AppBrandInitConfig paramAppBrandInitConfig)
  {
    int i = 0;
    AppMethodBeat.i(186456);
    if (!(paramAppBrandInitConfig instanceof AppBrandInitConfigWC))
    {
      AppMethodBeat.o(186456);
      return;
    }
    paramAppBrandInitConfig = (AppBrandInitConfigWC)paramAppBrandInitConfig;
    ac.i("MicroMsg.AppBrandFloatBallLogic", "setReportInfo, floatBallHelper:%s, configAppName:%s", new Object[] { parama, paramAppBrandInitConfig.ddh });
    parama.bGv().dlk = paramAppBrandInitConfig.appId;
    parama.bGv().hxt = paramAppBrandInitConfig.ddh;
    parama.bGv().nfH = String.valueOf(paramAppBrandInitConfig.cca);
    parama = parama.bGv();
    if (paramAppBrandInitConfig.ccl == null) {}
    for (;;)
    {
      parama.nfF = i;
      AppMethodBeat.o(186456);
      return;
      i = paramAppBrandInitConfig.ccl.scene;
    }
  }
  
  public final void A(o paramo)
  {
    AppMethodBeat.i(186455);
    ac.i("MicroMsg.AppBrandFloatBallLogic", "destroy, runtime:%s", new Object[] { paramo.mAppId });
    if (this.jPp != null) {
      this.jPp.onDestroy();
    }
    if (this.jPq != null) {
      this.jPq.onDestroy();
    }
    if (this.jPr != null) {
      this.jPr.onDestroy();
    }
    if (this.jPt != null) {
      this.jPt.onDestroy();
    }
    if (this.jPs != null) {
      this.jPs.onDestroy();
    }
    AppMethodBeat.o(186455);
  }
  
  public final boolean rV(int paramInt)
  {
    AppMethodBeat.i(186454);
    if ((this.jPp != null) && (this.jPp.rT(paramInt)))
    {
      AppMethodBeat.o(186454);
      return true;
    }
    if ((this.jPq != null) && (this.jPq.rT(paramInt)))
    {
      AppMethodBeat.o(186454);
      return true;
    }
    if ((this.jPr != null) && (this.jPr.rT(paramInt)))
    {
      AppMethodBeat.o(186454);
      return true;
    }
    if ((this.jPt != null) && (this.jPt.rT(paramInt)))
    {
      AppMethodBeat.o(186454);
      return true;
    }
    if ((this.jPs != null) && (this.jPs.rT(paramInt)))
    {
      AppMethodBeat.o(186454);
      return true;
    }
    AppMethodBeat.o(186454);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.floatball.d
 * JD-Core Version:    0.7.0.1
 */
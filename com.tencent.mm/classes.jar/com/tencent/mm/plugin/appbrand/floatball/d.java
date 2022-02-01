package com.tencent.mm.plugin.appbrand.floatball;

import android.app.Activity;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.p;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.ball.f.b;
import com.tencent.mm.plugin.ball.model.BallInfo;
import com.tencent.mm.sdk.platformtools.ae;

public final class d
{
  public c kmP;
  public f kmQ;
  public g kmR;
  public h kmS;
  public a kmT;
  
  public static void a(com.tencent.mm.plugin.ball.service.a parama, AppBrandInitConfig paramAppBrandInitConfig)
  {
    int i = 0;
    AppMethodBeat.i(222278);
    if (!(paramAppBrandInitConfig instanceof AppBrandInitConfigWC))
    {
      AppMethodBeat.o(222278);
      return;
    }
    paramAppBrandInitConfig = (AppBrandInitConfigWC)paramAppBrandInitConfig;
    ae.i("MicroMsg.AppBrandFloatBallLogic", "setReportInfo, floatBallHelper:%s, configAppName:%s", new Object[] { parama, paramAppBrandInitConfig.dpI });
    parama.bLD().dyc = paramAppBrandInitConfig.appId;
    parama.bLD().hSG = paramAppBrandInitConfig.dpI;
    parama.bLD().nLD = String.valueOf(paramAppBrandInitConfig.cmt);
    parama = parama.bLD();
    if (paramAppBrandInitConfig.cmE == null) {}
    for (;;)
    {
      parama.nLB = i;
      AppMethodBeat.o(222278);
      return;
      i = paramAppBrandInitConfig.cmE.scene;
    }
  }
  
  public final void s(p paramp)
  {
    AppMethodBeat.i(222277);
    ae.i("MicroMsg.AppBrandFloatBallLogic", "destroy, runtime:%s", new Object[] { paramp.mAppId });
    if (this.kmP != null) {
      this.kmP.onDestroy();
    }
    if (this.kmQ != null) {
      this.kmQ.onDestroy();
    }
    if (this.kmR != null) {
      this.kmR.onDestroy();
    }
    if (this.kmT != null) {
      this.kmT.onDestroy();
    }
    if (this.kmS != null) {
      this.kmS.onDestroy();
    }
    AppMethodBeat.o(222277);
  }
  
  public final boolean sA(int paramInt)
  {
    AppMethodBeat.i(222276);
    if ((this.kmP != null) && (this.kmP.sy(paramInt)))
    {
      AppMethodBeat.o(222276);
      return true;
    }
    if ((this.kmQ != null) && (this.kmQ.sy(paramInt)))
    {
      AppMethodBeat.o(222276);
      return true;
    }
    if ((this.kmR != null) && (this.kmR.sy(paramInt)))
    {
      AppMethodBeat.o(222276);
      return true;
    }
    if ((this.kmT != null) && (this.kmT.sy(paramInt)))
    {
      AppMethodBeat.o(222276);
      return true;
    }
    if ((this.kmS != null) && (this.kmS.sy(paramInt)))
    {
      AppMethodBeat.o(222276);
      return true;
    }
    AppMethodBeat.o(222276);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.floatball.d
 * JD-Core Version:    0.7.0.1
 */
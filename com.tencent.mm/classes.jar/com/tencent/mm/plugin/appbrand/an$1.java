package com.tencent.mm.plugin.appbrand;

import android.graphics.Bitmap;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.luggage.sdk.d.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.launching.report.AppBrandRuntimeReloadReportBundle;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySession;
import com.tencent.mm.plugin.appbrand.ui.h;
import com.tencent.mm.sdk.platformtools.ad;

public final class an$1
  implements Runnable
{
  public an$1(o paramo, AppBrandInitConfigWC paramAppBrandInitConfigWC) {}
  
  public final void run()
  {
    AppMethodBeat.i(43985);
    ad.i("MicroMsg.AppBrand.RuntimeRestartHelper", "performRestart OnUiThread appId[%s]", new Object[] { this.jvI.mAppId });
    try
    {
      Bitmap localBitmap = an.I(this.jvI);
      h.a(this.jvI, localBitmap);
      this.jBp.cmC = this.jvI.Fb().cmC;
      this.jBp.resetSession();
      this.jBp.jXM = new AppBrandRuntimeReloadReportBundle(this.jvI.aXc().jXD.lEv, "updateApp");
      this.jvI.a(this.jBp, "updateApp");
      AppMethodBeat.o(43985);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ad.e("MicroMsg.AppBrand.RuntimeRestartHelper", "performRestart  takeSnapshot appId[%s], e[%s]", new Object[] { this.jvI.mAppId, localException });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.an.1
 * JD-Core Version:    0.7.0.1
 */
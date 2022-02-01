package com.tencent.mm.plugin.appbrand.report.quality;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.AppBrandGlobalSystemConfig;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.mm.plugin.appbrand.debugger.DebuggerShell;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.Random;

final class a$3
  implements Runnable
{
  a$3(QualitySessionRuntime paramQualitySessionRuntime, AppBrandSysConfigWC paramAppBrandSysConfigWC) {}
  
  public final void run()
  {
    AppMethodBeat.i(48186);
    if (this.mun.jCo.isDestroyed())
    {
      AppMethodBeat.o(48186);
      return;
    }
    e locale;
    if (!this.mun.ciC)
    {
      locale = this.mun.mvu;
      QualitySessionRuntime localQualitySessionRuntime = this.mun;
      AppBrandSysConfigWC localAppBrandSysConfigWC = this.muo;
      ad.i("MicroMsg.AppBrandRuntimeEventReporter", "AppBrandRuntimeEventReporter.mayStartDependOnClientSampleRate");
      int i = localQualitySessionRuntime.jCo.aXc().uin;
      double d1 = localAppBrandSysConfigWC.cnf.jWO;
      double d2 = new Random(i ^ System.nanoTime()).nextDouble();
      boolean bool2 = DebuggerShell.bew();
      if ((d2 <= d1) || (bool2)) {}
      for (boolean bool1 = true;; bool1 = false)
      {
        ad.i("MicroMsg.AppBrandRuntimeEventReporter", "shouldEnableReport() returned: [%b], localRandom = [%f] serverPercent = [%f] monkeyMode[%b]", new Object[] { Boolean.valueOf(bool1), Double.valueOf(d2), Double.valueOf(d1), Boolean.valueOf(bool2) });
        if (!bool1) {
          break;
        }
        try
        {
          locale.a(localQualitySessionRuntime, localAppBrandSysConfigWC.cnf.jWP, e.a.muB, false);
          return;
        }
        finally
        {
          AppMethodBeat.o(48186);
        }
      }
    }
    AppMethodBeat.o(48186);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.quality.a.3
 * JD-Core Version:    0.7.0.1
 */
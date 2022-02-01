package com.tencent.mm.plugin.appbrand.report.quality;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.config.AppBrandGlobalSystemConfig;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.mm.plugin.appbrand.debugger.DebuggerShell;
import com.tencent.mm.plugin.appbrand.w;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Random;
import java.util.concurrent.atomic.AtomicBoolean;

final class b$3
  implements Runnable
{
  b$3(QualitySessionRuntime paramQualitySessionRuntime, AppBrandSysConfigWC paramAppBrandSysConfigWC) {}
  
  public final void run()
  {
    AppMethodBeat.i(48186);
    if (this.tRn.qxC.qsE.get())
    {
      AppMethodBeat.o(48186);
      return;
    }
    e locale;
    if (!this.tRn.ekt)
    {
      locale = this.tRn.tSt;
      QualitySessionRuntime localQualitySessionRuntime = this.tRn;
      AppBrandSysConfigWC localAppBrandSysConfigWC = this.tRo;
      Log.i("MicroMsg.AppBrandRuntimeEventReporter", "AppBrandRuntimeEventReporter.mayStartDependOnClientSampleRate");
      int i = localQualitySessionRuntime.qxC.getInitConfig().uin;
      double d1 = localAppBrandSysConfigWC.eqf.qXf;
      double d2 = new Random(i ^ System.nanoTime()).nextDouble();
      boolean bool2 = DebuggerShell.cls();
      if ((d2 <= d1) || (bool2)) {}
      for (boolean bool1 = true;; bool1 = false)
      {
        Log.i("MicroMsg.AppBrandRuntimeEventReporter", "shouldEnableReport() returned: [%b], localRandom = [%f] serverPercent = [%f] monkeyMode[%b]", new Object[] { Boolean.valueOf(bool1), Double.valueOf(d2), Double.valueOf(d1), Boolean.valueOf(bool2) });
        if (!bool1) {
          break;
        }
        try
        {
          locale.a(localQualitySessionRuntime, localAppBrandSysConfigWC.eqf.qXg, e.a.tRB, false);
          return;
        }
        finally
        {
          AppMethodBeat.o(48186);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.quality.b.3
 * JD-Core Version:    0.7.0.1
 */
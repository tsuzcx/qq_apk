package com.tencent.mm.plugin.appbrand.performance;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class AppBrandPerformanceManager$a$2
  implements f.a
{
  AppBrandPerformanceManager$a$2(AppBrandPerformanceManager.a parama) {}
  
  public final void u(double paramDouble)
  {
    AppMethodBeat.i(102215);
    if (Math.round(AppBrandPerformanceManager.a.a(this.iAQ)) != Math.round(paramDouble))
    {
      AppBrandPerformanceManager.a.a(this.iAQ, paramDouble);
      String str = Math.round(AppBrandPerformanceManager.a.a(this.iAQ)) + " fps";
      AppBrandPerformanceManager.a(this.iAQ.bEZ, 303, str);
      c.a(this.iAQ.mAppId, "Hardware", "FPS", AppBrandPerformanceManager.a.a(this.iAQ));
    }
    AppMethodBeat.o(102215);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.performance.AppBrandPerformanceManager.a.2
 * JD-Core Version:    0.7.0.1
 */
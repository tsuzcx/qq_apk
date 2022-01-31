package com.tencent.mm.plugin.appbrand.performance;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.e.c;
import com.tencent.mm.plugin.appbrand.e.d;

final class AppBrandPerformanceManager$a$3
  extends e.c
{
  AppBrandPerformanceManager$a$3(AppBrandPerformanceManager.a parama) {}
  
  public final void a(e.d paramd)
  {
    AppMethodBeat.i(102217);
    super.a(paramd);
    paramd = this.iAQ;
    paramd.mPaused = true;
    if ((AppBrandPerformanceManager.a.aKh()) && (paramd.iAN != null)) {
      paramd.iAN.stop();
    }
    AppMethodBeat.o(102217);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(102216);
    super.onDestroy();
    this.iAQ.stop();
    AppMethodBeat.o(102216);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(102218);
    super.onResume();
    AppBrandPerformanceManager.a locala = this.iAQ;
    locala.mPaused = false;
    if ((AppBrandPerformanceManager.a.aKh()) && (locala.iAN != null)) {
      locala.iAN.start();
    }
    AppMethodBeat.o(102218);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.performance.AppBrandPerformanceManager.a.3
 * JD-Core Version:    0.7.0.1
 */
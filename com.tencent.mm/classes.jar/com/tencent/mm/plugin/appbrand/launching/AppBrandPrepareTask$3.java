package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.report.e;
import com.tencent.mm.plugin.report.service.h;

final class AppBrandPrepareTask$3
  implements Runnable
{
  AppBrandPrepareTask$3(AppBrandPrepareTask paramAppBrandPrepareTask) {}
  
  public final void run()
  {
    AppMethodBeat.i(131734);
    int i = 369;
    if (this.ijW.bAa) {
      i = 777;
    }
    h.qsU.idkeyStat(i, 3L, 1L, false);
    e.b(AppBrandPrepareTask.PrepareParams.a(this.ijW.ijT), 0, AppBrandPrepareTask.PrepareParams.b(this.ijW.ijT), i, 3);
    AppMethodBeat.o(131734);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.AppBrandPrepareTask.3
 * JD-Core Version:    0.7.0.1
 */
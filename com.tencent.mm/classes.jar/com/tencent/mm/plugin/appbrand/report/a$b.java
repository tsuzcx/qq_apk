package com.tencent.mm.plugin.appbrand.report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.aw.a;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/appbrand/report/AppBrandCrossProcessSafeReporter$periodReportTimer$1", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler$CallBack;", "onTimerExpired", "", "plugin-appbrand-integration_release"})
public final class a$b
  implements aw.a
{
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(50998);
    a.bxS();
    AppMethodBeat.o(50998);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.a.b
 * JD-Core Version:    0.7.0.1
 */
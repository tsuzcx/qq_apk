package com.tencent.mm.plugin.appbrand.report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ap.a;

final class AppBrandIDKeyBatchReport$b$2
  implements ap.a
{
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(132521);
    ab.d("MicroMsg.AppBrandIDKeyBatchReport", "startReport run in TimerTask!");
    AppBrandIDKeyBatchReport.b.access$300();
    AppMethodBeat.o(132521);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.AppBrandIDKeyBatchReport.b.2
 * JD-Core Version:    0.7.0.1
 */
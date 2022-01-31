package com.tencent.mm.plugin.appbrand.report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ap.a;

final class AppBrandIDKeyBatchReport$b$1
  implements ap.a
{
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(132520);
    AppBrandIDKeyBatchReport.b.BI();
    ab.d("MicroMsg.AppBrandIDKeyBatchReport", "on timer expired in monitor timer!");
    AppMethodBeat.o(132520);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.AppBrandIDKeyBatchReport.b.1
 * JD-Core Version:    0.7.0.1
 */
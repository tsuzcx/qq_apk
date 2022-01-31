package com.tencent.mm.plugin.appbrand.report.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.g.d;
import java.util.concurrent.ThreadFactory;

final class i$1
  implements ThreadFactory
{
  public final Thread newThread(Runnable paramRunnable)
  {
    AppMethodBeat.i(132615);
    paramRunnable = d.a(paramRunnable, "AppBrandJsApiInvokeReportWorkerThread", 1);
    if (paramRunnable.isDaemon()) {
      paramRunnable.setDaemon(false);
    }
    AppMethodBeat.o(132615);
    return paramRunnable;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.model.i.1
 * JD-Core Version:    0.7.0.1
 */
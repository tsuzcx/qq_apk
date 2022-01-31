package com.tencent.mm.plugin.appbrand.report.model;

import com.tencent.mm.sdk.f.e;
import java.util.concurrent.ThreadFactory;

final class i$1
  implements ThreadFactory
{
  public final Thread newThread(Runnable paramRunnable)
  {
    paramRunnable = e.c(paramRunnable, "AppBrandJsApiInvokeReportWorkerThread", 1);
    if (paramRunnable.isDaemon()) {
      paramRunnable.setDaemon(false);
    }
    return paramRunnable;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.model.i.1
 * JD-Core Version:    0.7.0.1
 */
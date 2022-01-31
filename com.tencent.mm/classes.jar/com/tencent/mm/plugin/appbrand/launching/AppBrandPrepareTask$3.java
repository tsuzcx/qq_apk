package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.mm.plugin.appbrand.report.c;
import com.tencent.mm.plugin.report.service.h;

final class AppBrandPrepareTask$3
  implements Runnable
{
  AppBrandPrepareTask$3(AppBrandPrepareTask paramAppBrandPrepareTask) {}
  
  public final void run()
  {
    int i = 369;
    if (this.gJq.gJp) {
      i = 777;
    }
    h.nFQ.a(i, 3L, 1L, false);
    c.a(AppBrandPrepareTask.PrepareParams.a(this.gJq.gJm), 0, AppBrandPrepareTask.PrepareParams.b(this.gJq.gJm), i, 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.AppBrandPrepareTask.3
 * JD-Core Version:    0.7.0.1
 */
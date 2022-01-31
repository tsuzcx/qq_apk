package com.tencent.mm.plugin.appbrand.performance;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.storage.GetStorageSizeTask;
import com.tencent.mm.sdk.platformtools.bo;

final class AppBrandPerformanceManager$a$1
  implements Runnable
{
  AppBrandPerformanceManager$a$1(AppBrandPerformanceManager.a parama, GetStorageSizeTask paramGetStorageSizeTask) {}
  
  public final void run()
  {
    AppMethodBeat.i(102214);
    AppBrandPerformanceManager.a(this.iAQ.bEZ, 401, bo.hk(this.iAP.size));
    this.iAP.aBk();
    AppMethodBeat.o(102214);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.performance.AppBrandPerformanceManager.a.1
 * JD-Core Version:    0.7.0.1
 */
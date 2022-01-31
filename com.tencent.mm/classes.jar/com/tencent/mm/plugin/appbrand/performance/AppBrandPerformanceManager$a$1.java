package com.tencent.mm.plugin.appbrand.performance;

import com.tencent.mm.plugin.appbrand.jsapi.storage.JsApiGetStorageInfoTask;
import com.tencent.mm.sdk.platformtools.bk;

final class AppBrandPerformanceManager$a$1
  implements Runnable
{
  AppBrandPerformanceManager$a$1(AppBrandPerformanceManager.a parama, JsApiGetStorageInfoTask paramJsApiGetStorageInfoTask) {}
  
  public final void run()
  {
    AppBrandPerformanceManager.m(this.gWk.mAppId, 401, bk.cm(this.gBZ.size));
    this.gBZ.ahD();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.performance.AppBrandPerformanceManager.a.1
 * JD-Core Version:    0.7.0.1
 */
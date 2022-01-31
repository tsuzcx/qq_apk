package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

final class AppBrandPrepareTask$4
  implements Runnable
{
  AppBrandPrepareTask$4(AppBrandPrepareTask paramAppBrandPrepareTask, WxaPkgWrappingInfo paramWxaPkgWrappingInfo) {}
  
  public final void run()
  {
    y.i("MicroMsg.AppBrandPrepareTask", "runInClientProcess, prepare done, appPkg [%d | %s]", new Object[] { Integer.valueOf(this.gJr.fEN), bk.hs(this.gJr.fEO) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.AppBrandPrepareTask.4
 * JD-Core Version:    0.7.0.1
 */
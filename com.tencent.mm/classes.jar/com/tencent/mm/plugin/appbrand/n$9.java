package com.tencent.mm.plugin.appbrand;

import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.menu.WxaMenuHelper.GetCopyPathMenuExpireTimeTask;

final class n$9
  implements Runnable
{
  n$9(n paramn) {}
  
  public final void run()
  {
    AppBrandSysConfigWC localAppBrandSysConfigWC = this.fzM.aaa();
    WxaMenuHelper.GetCopyPathMenuExpireTimeTask localGetCopyPathMenuExpireTimeTask = new WxaMenuHelper.GetCopyPathMenuExpireTimeTask(this.fzM.mAppId);
    AppBrandMainProcessService.b(localGetCopyPathMenuExpireTimeTask);
    localAppBrandSysConfigWC.fQp = WxaMenuHelper.GetCopyPathMenuExpireTimeTask.a(localGetCopyPathMenuExpireTimeTask);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.n.9
 * JD-Core Version:    0.7.0.1
 */
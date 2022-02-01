package com.tencent.mm.plugin.appbrand;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.menu.WxaMenuHelper.GetCopyPathMenuExpireTimeTask;

final class o$3
  implements Runnable
{
  o$3(o paramo) {}
  
  public final void run()
  {
    AppMethodBeat.i(43865);
    AppBrandSysConfigWC localAppBrandSysConfigWC = this.iGA.aNb();
    WxaMenuHelper.GetCopyPathMenuExpireTimeTask localGetCopyPathMenuExpireTimeTask = new WxaMenuHelper.GetCopyPathMenuExpireTimeTask(this.iGA.mAppId);
    AppBrandMainProcessService.b(localGetCopyPathMenuExpireTimeTask);
    localAppBrandSysConfigWC.cfQ = WxaMenuHelper.GetCopyPathMenuExpireTimeTask.a(localGetCopyPathMenuExpireTimeTask);
    AppMethodBeat.o(43865);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.o.3
 * JD-Core Version:    0.7.0.1
 */
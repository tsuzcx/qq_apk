package com.tencent.mm.plugin.appbrand;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.menu.WxaMenuHelper.GetCopyPathMenuExpireTimeTask;

final class o$4
  implements Runnable
{
  o$4(o paramo) {}
  
  public final void run()
  {
    AppMethodBeat.i(187884);
    AppBrandSysConfigWC localAppBrandSysConfigWC = this.jzB.aXb();
    WxaMenuHelper.GetCopyPathMenuExpireTimeTask localGetCopyPathMenuExpireTimeTask = new WxaMenuHelper.GetCopyPathMenuExpireTimeTask(this.jzB.mAppId);
    AppBrandMainProcessService.b(localGetCopyPathMenuExpireTimeTask);
    localAppBrandSysConfigWC.cne = WxaMenuHelper.GetCopyPathMenuExpireTimeTask.a(localGetCopyPathMenuExpireTimeTask);
    AppMethodBeat.o(187884);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.o.4
 * JD-Core Version:    0.7.0.1
 */
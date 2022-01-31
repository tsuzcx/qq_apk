package com.tencent.mm.plugin.appbrand;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.menu.WxaMenuHelper.GetCopyPathMenuExpireTimeTask;

final class o$17
  implements Runnable
{
  o$17(o paramo) {}
  
  public final void run()
  {
    AppMethodBeat.i(129003);
    AppBrandSysConfigWC localAppBrandSysConfigWC = this.gRv.atR();
    WxaMenuHelper.GetCopyPathMenuExpireTimeTask localGetCopyPathMenuExpireTimeTask = new WxaMenuHelper.GetCopyPathMenuExpireTimeTask(this.gRv.mAppId);
    AppBrandMainProcessService.b(localGetCopyPathMenuExpireTimeTask);
    localAppBrandSysConfigWC.bDH = WxaMenuHelper.GetCopyPathMenuExpireTimeTask.a(localGetCopyPathMenuExpireTimeTask);
    AppMethodBeat.o(129003);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.o.17
 * JD-Core Version:    0.7.0.1
 */
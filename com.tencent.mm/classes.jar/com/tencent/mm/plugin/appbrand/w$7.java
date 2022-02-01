package com.tencent.mm.plugin.appbrand;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.mm.plugin.appbrand.menu.WxaMenuHelper.GetCopyPathMenuExpireTimeTask;

final class w$7
  implements Runnable
{
  w$7(w paramw) {}
  
  public final void run()
  {
    AppMethodBeat.i(160525);
    AppBrandSysConfigWC localAppBrandSysConfigWC = this.qvY.ccM();
    WxaMenuHelper.GetCopyPathMenuExpireTimeTask localGetCopyPathMenuExpireTimeTask = new WxaMenuHelper.GetCopyPathMenuExpireTimeTask(this.qvY.mAppId);
    localGetCopyPathMenuExpireTimeTask.cpB();
    localAppBrandSysConfigWC.eqe = WxaMenuHelper.GetCopyPathMenuExpireTimeTask.a(localGetCopyPathMenuExpireTimeTask);
    AppMethodBeat.o(160525);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.w.7
 * JD-Core Version:    0.7.0.1
 */
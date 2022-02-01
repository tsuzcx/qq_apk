package com.tencent.mm.plugin.appbrand.task;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.backgroundrunning.service.AppBrandForegroundNotificationService;
import com.tencent.mm.plugin.appbrand.keepalive.AppBrandKeepAliveService;
import com.tencent.mm.plugin.appbrand.loading.AppBrandProcessTriggerService0;
import com.tencent.mm.plugin.appbrand.ui.AppBrandPluginUI;
import com.tencent.mm.plugin.appbrand.ui.AppBrandPreLoadingForPluginUI;
import com.tencent.mm.sdk.platformtools.Log;

public final class d
  extends n
{
  d()
  {
    super(AppBrandPluginUI.class, AppBrandTaskPreloadReceiver.class, AppBrandKeepAliveService.class, AppBrandForegroundNotificationService.class, AppBrandProcessTriggerService0.class, AppBrandPreLoadingForPluginUI.class);
    AppMethodBeat.i(227436);
    super.z(g.nPD);
    AppMethodBeat.o(227436);
  }
  
  protected final boolean c(g paramg)
  {
    return paramg != g.nPE;
  }
  
  final void iB(boolean paramBoolean)
  {
    AppMethodBeat.i(227437);
    if (!bWp()) {}
    for (int i = 1; i != 0; i = 0)
    {
      Log.e("MicroMsg.AppBrandPluginUITask", "preload, already attached");
      AppMethodBeat.o(227437);
      return;
    }
    super.z(g.nPD);
    super.iB(true);
    AppMethodBeat.o(227437);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.task.d
 * JD-Core Version:    0.7.0.1
 */
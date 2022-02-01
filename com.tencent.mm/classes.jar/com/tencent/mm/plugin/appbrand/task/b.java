package com.tencent.mm.plugin.appbrand.task;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.backgroundrunning.service.AppBrandForegroundNotificationService;
import com.tencent.mm.plugin.appbrand.keepalive.AppBrandKeepAliveService;
import com.tencent.mm.plugin.appbrand.loading.AppBrandProcessTriggerService0;
import com.tencent.mm.plugin.appbrand.ui.AppBrandPluginUI;
import com.tencent.mm.plugin.appbrand.ui.AppBrandPreLoadingForPluginUI;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.LinkedHashMap;

public final class b
  extends i
{
  b()
  {
    super(AppBrandPluginUI.class, AppBrandTaskPreloadReceiver.class, AppBrandKeepAliveService.class, AppBrandForegroundNotificationService.class, AppBrandProcessTriggerService0.class, AppBrandPreLoadingForPluginUI.class);
    AppMethodBeat.i(222977);
    super.l(e.mDe);
    AppMethodBeat.o(222977);
  }
  
  final void OC()
  {
    AppMethodBeat.i(48360);
    if (!this.mDD.isEmpty()) {}
    for (int i = 1; i != 0; i = 0)
    {
      ae.e("MicroMsg.AppBrandPluginUITask", "preload, already attached");
      AppMethodBeat.o(48360);
      return;
    }
    super.l(e.mDe);
    super.OC();
    AppMethodBeat.o(48360);
  }
  
  protected final boolean b(e parame)
  {
    return parame != e.mDf;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.task.b
 * JD-Core Version:    0.7.0.1
 */
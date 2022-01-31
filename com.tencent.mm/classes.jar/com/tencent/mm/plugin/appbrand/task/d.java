package com.tencent.mm.plugin.appbrand.task;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.keepalive.AppBrandKeepAliveService;
import com.tencent.mm.plugin.appbrand.ui.AppBrandPluginUI;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.LinkedHashMap;

final class d
  extends j
{
  d()
  {
    super(AppBrandPluginUI.class, AppBrandTaskPreloadReceiver.class, AppBrandKeepAliveService.class);
  }
  
  final void Do()
  {
    AppMethodBeat.i(143571);
    if (!this.iLj.isEmpty()) {}
    for (int i = 1; i != 0; i = 0)
    {
      ab.e("MicroMsg.AppBrandPluginUITask", "preload, already attached");
      AppMethodBeat.o(143571);
      return;
    }
    super.f(g.iKS);
    super.Do();
    AppMethodBeat.o(143571);
  }
  
  protected final boolean a(g paramg)
  {
    return paramg != g.iKT;
  }
  
  final void aLF() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.task.d
 * JD-Core Version:    0.7.0.1
 */
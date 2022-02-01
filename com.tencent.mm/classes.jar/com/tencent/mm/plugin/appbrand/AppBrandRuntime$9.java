package com.tencent.mm.plugin.appbrand;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService.a;

final class AppBrandRuntime$9
  extends AppBrandMainProcessService.a
{
  private boolean jAo = false;
  
  AppBrandRuntime$9(AppBrandRuntime paramAppBrandRuntime) {}
  
  public final void KW(String paramString)
  {
    AppMethodBeat.i(134451);
    if (this.jAo) {
      AppBrandRuntime.t(this.jAl);
    }
    this.jAo = false;
    AppMethodBeat.o(134451);
  }
  
  public final void onDisconnected(String paramString)
  {
    this.jAo = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.AppBrandRuntime.9
 * JD-Core Version:    0.7.0.1
 */
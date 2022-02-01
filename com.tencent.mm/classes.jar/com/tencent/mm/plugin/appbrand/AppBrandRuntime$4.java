package com.tencent.mm.plugin.appbrand;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ui.ah;

final class AppBrandRuntime$4
  implements Runnable
{
  AppBrandRuntime$4(AppBrandRuntime paramAppBrandRuntime, int paramInt) {}
  
  public final void run()
  {
    AppMethodBeat.i(134446);
    if (this.qsZ.qsl != null) {
      this.qsZ.qsl.setProgress(this.val$progress);
    }
    AppMethodBeat.o(134446);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.AppBrandRuntime.4
 * JD-Core Version:    0.7.0.1
 */
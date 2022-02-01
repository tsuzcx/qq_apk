package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.backgroundfetch.b;
import com.tencent.mm.plugin.appbrand.backgroundfetch.j;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;

final class e$1
  implements Runnable
{
  e$1(AppBrandInitConfigWC paramAppBrandInitConfigWC, AppBrandStatObject paramAppBrandStatObject) {}
  
  public final void run()
  {
    AppMethodBeat.i(320862);
    b.a(this.sVV.appId, this.sVV.username, this.sVV.eul, this.sVV.qAF, this.sVW.scene, new j());
    AppMethodBeat.o(320862);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.e.1
 * JD-Core Version:    0.7.0.1
 */
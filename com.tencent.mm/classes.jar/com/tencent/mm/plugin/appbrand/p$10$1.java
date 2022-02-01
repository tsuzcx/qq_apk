package com.tencent.mm.plugin.appbrand;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.platform.window.e.a;
import com.tencent.mm.plugin.appbrand.platform.window.e.b;
import com.tencent.mm.sdk.platformtools.ae;

final class p$10$1
  implements e.a
{
  p$10$1(p.10 param10) {}
  
  public final void a(e.b paramb, boolean paramBoolean)
  {
    AppMethodBeat.i(224350);
    ae.i("MicroMsg.AppBrandRuntimeWC", "startPrepareOrientation, onOrientationChanged appId[%s], orientation[%s] success[%b]", new Object[] { this.jPm.jCE.mAppId, paramb, Boolean.valueOf(paramBoolean) });
    if (this.jPm.jCM != null) {
      this.jPm.jCM.run();
    }
    AppMethodBeat.o(224350);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.p.10.1
 * JD-Core Version:    0.7.0.1
 */
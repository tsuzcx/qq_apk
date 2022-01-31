package com.tencent.mm.plugin.appbrand.config.a;

import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class a$2
  implements b.a
{
  a$2(a parama, a.d paramd, Activity paramActivity) {}
  
  public final void ayM()
  {
    AppMethodBeat.i(86905);
    ab.e("MicroMsg.AppBrandDeviceOrientationHandler", "hy: activity not turn to correct orientation for long time, request[%s]", new Object[] { this.hkC });
    if (this.hkC.hkL != null) {
      this.hkC.hkL.a(this.hkC.hkM, false);
    }
    AppMethodBeat.o(86905);
  }
  
  public final void ayN()
  {
    AppMethodBeat.i(86906);
    ab.d("MicroMsg.AppBrandDeviceOrientationHandler", "hy: trigger retry, request[%s]", new Object[] { this.hkC });
    if (!this.val$activity.isDestroyed()) {
      a.c(this.val$activity, this.hkC.hkM.hkJ);
    }
    AppMethodBeat.o(86906);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.config.a.a.2
 * JD-Core Version:    0.7.0.1
 */
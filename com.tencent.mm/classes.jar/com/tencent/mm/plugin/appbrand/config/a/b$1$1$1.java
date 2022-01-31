package com.tencent.mm.plugin.appbrand.config.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.Timer;

final class b$1$1$1
  implements Runnable
{
  b$1$1$1(b.1.1 param1) {}
  
  public final void run()
  {
    AppMethodBeat.i(86930);
    ab.w("MicroMsg.AppBrandDeviceOrientationRetrier", "hy: still not cancelled, trigger retry");
    b localb = this.hkT.hkS.hkR;
    localb.hkN += 1;
    if (this.hkT.hkS.hkR.hkN > 3)
    {
      if (this.hkT.hkS.hkR.hkO != null) {
        this.hkT.hkS.hkR.hkO.ayM();
      }
      this.hkT.hkS.hkR.hkP.cancel();
      AppMethodBeat.o(86930);
      return;
    }
    if (this.hkT.hkS.hkR.hkO != null) {
      this.hkT.hkS.hkR.hkO.ayN();
    }
    AppMethodBeat.o(86930);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.config.a.b.1.1.1
 * JD-Core Version:    0.7.0.1
 */
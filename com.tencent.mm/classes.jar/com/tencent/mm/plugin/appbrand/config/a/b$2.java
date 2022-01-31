package com.tencent.mm.plugin.appbrand.config.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class b$2
  implements Runnable
{
  b$2(b paramb) {}
  
  public final void run()
  {
    AppMethodBeat.i(86933);
    ab.i("MicroMsg.AppBrandDeviceOrientationRetrier", "cancelTikTok reset");
    b.a(this.hkR);
    AppMethodBeat.o(86933);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.config.a.b.2
 * JD-Core Version:    0.7.0.1
 */
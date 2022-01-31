package com.tencent.mm.plugin.appbrand.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class c$3
  implements Runnable
{
  c$3(c paramc) {}
  
  public final void run()
  {
    AppMethodBeat.i(132936);
    c.f(this.iMp);
    ab.i("MicroMsg.AppBrandGameUILoadingSplash", "mCustomSplashScreenDelayTimeEnd");
    if (c.g(this.iMp)) {
      c.d(this.iMp);
    }
    AppMethodBeat.o(132936);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.c.3
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.appbrand.launching;

import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class g$4
  implements Runnable
{
  g$4(g paramg, HandlerThread paramHandlerThread) {}
  
  public final void run()
  {
    AppMethodBeat.i(131778);
    try
    {
      g.a(this.ikV, this.ikV.aGM());
      this.ikW.quit();
      AppMethodBeat.o(131778);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ab.printErrStackTrace("MicroMsg.AppBrand.AppLaunchPrepareProcess[applaunch]", localException, "call() exp ", new Object[0]);
        ah.oH(2131296725);
        g.a(this.ikV, g.aGP());
        g.d(this.ikV);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.g.4
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.appbrand.report.quality;

import android.os.Handler;
import com.tencent.luggage.g.d;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class e$b
  implements Runnable
{
  private long cco = 0L;
  private e.a iIx = null;
  private boolean iIy = false;
  
  private e$b(e parame) {}
  
  public final void run()
  {
    AppMethodBeat.i(132690);
    if (this.iIz.iIs == null)
    {
      AppMethodBeat.o(132690);
      return;
    }
    if (this.iIx == null) {
      d.e("MicroMsg.AppBrandRuntimeEventReporter", "hy: null type! could not happen");
    }
    this.iIz.a(this.iIx, this.iIy);
    this.iIz.handler.postDelayed(this.iIz.iIr, this.cco);
    AppMethodBeat.o(132690);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.quality.e.b
 * JD-Core Version:    0.7.0.1
 */
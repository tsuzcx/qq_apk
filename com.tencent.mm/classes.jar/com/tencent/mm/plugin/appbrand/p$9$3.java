package com.tencent.mm.plugin.appbrand;

import com.tencent.luggage.sdk.d.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.a;

final class p$9$3
  implements Runnable
{
  p$9$3(p.9 param9) {}
  
  public final void run()
  {
    AppMethodBeat.i(224340);
    if (!this.jCN.jCE.isDestroyed())
    {
      a locala = this.jCN.jCE.getAppConfig();
      if (locala != null) {
        p.j(this.jCN.jCE).a(locala);
      }
    }
    AppMethodBeat.o(224340);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.p.9.3
 * JD-Core Version:    0.7.0.1
 */
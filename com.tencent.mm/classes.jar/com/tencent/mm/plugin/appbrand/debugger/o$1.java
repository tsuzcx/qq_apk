package com.tencent.mm.plugin.appbrand.debugger;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.h;
import com.tencent.mm.plugin.appbrand.h.d;

final class o$1
  implements w.a
{
  o$1(o paramo) {}
  
  public final void bAM()
  {
    AppMethodBeat.i(147014);
    this.liz.destroy();
    h.a(o.c(this.liz).getAppId(), h.d.kzP);
    if (o.c(this.liz).NP() != null) {
      o.c(this.liz).NP().finish();
    }
    AppMethodBeat.o(147014);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.debugger.o.1
 * JD-Core Version:    0.7.0.1
 */
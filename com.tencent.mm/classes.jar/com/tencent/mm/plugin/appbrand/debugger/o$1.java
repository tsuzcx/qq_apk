package com.tencent.mm.plugin.appbrand.debugger;

import com.tencent.luggage.sdk.b.a.c.c;
import com.tencent.luggage.sdk.d.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.h;
import com.tencent.mm.plugin.appbrand.h.d;

final class o$1
  implements w.a
{
  o$1(o paramo) {}
  
  public final void bft()
  {
    AppMethodBeat.i(147014);
    this.keQ.destroy();
    h.a(this.keQ.keN.getAppId(), h.d.jzh);
    if (this.keQ.keN.Eq() != null) {
      this.keQ.keN.Eq().finish();
    }
    AppMethodBeat.o(147014);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.debugger.o.1
 * JD-Core Version:    0.7.0.1
 */
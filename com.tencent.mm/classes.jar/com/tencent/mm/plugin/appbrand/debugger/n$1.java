package com.tencent.mm.plugin.appbrand.debugger;

import com.tencent.luggage.sdk.b.a.c.c;
import com.tencent.luggage.sdk.d.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.e;
import com.tencent.mm.plugin.appbrand.e.d;

final class n$1
  implements u.a
{
  n$1(n paramn) {}
  
  public final void azc()
  {
    AppMethodBeat.i(101828);
    this.hlT.destroy();
    e.a(this.hlT.hlQ.getAppId(), e.d.gPe);
    if (this.hlT.hlQ.wj() != null) {
      this.hlT.hlQ.wj().finish();
    }
    AppMethodBeat.o(101828);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.debugger.n.1
 * JD-Core Version:    0.7.0.1
 */
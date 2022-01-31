package com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.vending.g.b;

final class h$4$3
  implements c.b
{
  h$4$3(h.4 param4, b paramb) {}
  
  public final void cancel()
  {
    AppMethodBeat.i(140846);
    this.bDR.cK(new Exception("cancel"));
    AppMethodBeat.o(140846);
  }
  
  public final void proceed()
  {
    AppMethodBeat.i(140845);
    this.bDR.C(new Object[] { Boolean.TRUE });
    AppMethodBeat.o(140845);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator.h.4.3
 * JD-Core Version:    0.7.0.1
 */
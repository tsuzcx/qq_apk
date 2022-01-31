package com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator;

import com.tencent.luggage.sdk.d.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.i;
import com.tencent.mm.plugin.appbrand.s.j;
import com.tencent.mm.vending.g.d.a;

final class h$1
  implements d.a
{
  h$1(h paramh, c.c paramc, b paramb, j paramj) {}
  
  public final void aX(Object paramObject)
  {
    AppMethodBeat.i(101985);
    if (this.hTl != null)
    {
      if (!(paramObject instanceof Exception)) {
        break label60;
      }
      paramObject = ((Exception)paramObject).getMessage();
    }
    for (;;)
    {
      this.hTl.i(false, paramObject);
      this.hTm.k(new h.1.1(this), 0L);
      AppMethodBeat.o(101985);
      return;
      label60:
      if (paramObject == null) {
        paramObject = "internal error";
      } else {
        paramObject = paramObject.toString();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator.h.1
 * JD-Core Version:    0.7.0.1
 */
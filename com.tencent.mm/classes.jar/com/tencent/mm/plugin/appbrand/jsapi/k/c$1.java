package com.tencent.mm.plugin.appbrand.jsapi.k;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.b.b;
import com.tencent.mm.plugin.appbrand.b.c.a;
import com.tencent.mm.plugin.cloudvoip.cloudvoice.c.o;
import com.tencent.mm.plugin.cloudvoip.cloudvoice.c.o.a;
import com.tencent.mm.sdk.platformtools.ab;

final class c$1
  implements c.a
{
  c$1(c paramc) {}
  
  public final void a(String paramString, b paramb)
  {
    AppMethodBeat.i(131386);
    if ((paramb == b.gYf) && (c.a(this.hVB).equals(paramString)))
    {
      ab.i(c.access$100(), "hy: appbrand change to background");
      this.hVB.ec(false);
      o.kKN.a(new c.1.1(this), o.a.kMi);
    }
    AppMethodBeat.o(131386);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.k.c.1
 * JD-Core Version:    0.7.0.1
 */
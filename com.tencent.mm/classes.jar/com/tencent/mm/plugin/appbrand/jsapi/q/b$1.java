package com.tencent.mm.plugin.appbrand.jsapi.q;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.e;
import com.tencent.mm.plugin.appbrand.jsapi.c;

final class b$1
  extends b.b
{
  b$1(b paramb, c paramc1, c paramc2, l paraml)
  {
    super(paramc1);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(126369);
    e.b(this.hxW.getAppId(), this);
    this.hYu.a(this);
    AppMethodBeat.o(126369);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.q.b.1
 * JD-Core Version:    0.7.0.1
 */
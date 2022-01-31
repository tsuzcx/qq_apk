package com.tencent.mm.plugin.appbrand.jsapi.q;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.e;

final class c$1
  extends c.b
{
  c$1(c paramc, com.tencent.mm.plugin.appbrand.jsapi.c paramc1, com.tencent.mm.plugin.appbrand.jsapi.c paramc2, l paraml)
  {
    super(paramc1);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(126372);
    e.b(this.hxW.getAppId(), this);
    this.hYu.a(this);
    AppMethodBeat.o(126372);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.q.c.1
 * JD-Core Version:    0.7.0.1
 */
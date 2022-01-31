package com.tencent.mm.plugin.appbrand.jsapi.q;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.e;
import com.tencent.mm.plugin.appbrand.jsapi.c;

final class f$1
  extends f.b
{
  f$1(f paramf, c paramc1, c paramc2, l paraml)
  {
    super(paramc1);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(126382);
    e.b(this.hxW.getAppId(), this);
    this.hYu.a(this);
    AppMethodBeat.o(126382);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.q.f.1
 * JD-Core Version:    0.7.0.1
 */
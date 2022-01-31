package com.tencent.mm.plugin.appbrand.jsapi.t;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.sdk.platformtools.ab;

final class e$2
  extends c.a
{
  e$2(e parame, com.tencent.mm.plugin.appbrand.jsapi.c paramc, int paramInt, c paramc1) {}
  
  public final void Es()
  {
    AppMethodBeat.i(145920);
    ab.i("MicroMsg.JsApiStartPlayVoice", "onCompletion");
    this.hKB.h(this.bAX, this.ifn.j("ok", null));
    this.ifm.b(this);
    AppMethodBeat.o(145920);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.t.e.2
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.appbrand.jsapi.m;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import java.util.Map;

final class c$1
  implements b.a
{
  c$1(c paramc, com.tencent.mm.plugin.appbrand.service.c paramc1, int paramInt) {}
  
  public final void a(int paramInt, String paramString, Map<String, Object> paramMap)
  {
    AppMethodBeat.i(131411);
    switch (paramInt)
    {
    default: 
      this.hxC.h(this.bAX, this.hWo.j("fail", null));
      AppMethodBeat.o(131411);
      return;
    }
    this.hxC.h(this.bAX, this.hWo.j("ok", null));
    AppMethodBeat.o(131411);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.m.c.1
 * JD-Core Version:    0.7.0.1
 */
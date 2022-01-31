package com.tencent.mm.plugin.appbrand.jsapi.m;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.service.c;
import java.util.Map;

final class f$1
  implements b.a
{
  f$1(f paramf, c paramc, int paramInt) {}
  
  public final void a(int paramInt, String paramString, Map<String, Object> paramMap)
  {
    AppMethodBeat.i(131417);
    switch (paramInt)
    {
    default: 
      this.hxC.h(this.bAX, this.hWr.j("fail:".concat(String.valueOf(paramString)), null));
      AppMethodBeat.o(131417);
      return;
    }
    this.hxC.h(this.bAX, this.hWr.j("ok", paramMap));
    AppMethodBeat.o(131417);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.m.f.1
 * JD-Core Version:    0.7.0.1
 */
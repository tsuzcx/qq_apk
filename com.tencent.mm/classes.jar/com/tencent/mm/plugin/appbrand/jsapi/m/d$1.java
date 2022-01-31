package com.tencent.mm.plugin.appbrand.jsapi.m;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.service.c;
import java.util.Map;

final class d$1
  implements b.a
{
  d$1(d paramd, c paramc, int paramInt) {}
  
  public final void a(int paramInt, String paramString, Map<String, Object> paramMap)
  {
    AppMethodBeat.i(131413);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(131413);
      return;
      this.hxC.h(this.bAX, this.hWp.j("ok", null));
      AppMethodBeat.o(131413);
      return;
      this.hxC.h(this.bAX, this.hWp.j("fail:".concat(String.valueOf(paramString)), null));
      AppMethodBeat.o(131413);
      return;
      this.hxC.h(this.bAX, this.hWp.j("cancel", null));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.m.d.1
 * JD-Core Version:    0.7.0.1
 */
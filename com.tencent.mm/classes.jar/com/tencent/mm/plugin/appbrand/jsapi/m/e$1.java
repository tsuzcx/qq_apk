package com.tencent.mm.plugin.appbrand.jsapi.m;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.h;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import java.util.Map;

final class e$1
  implements b.a
{
  e$1(e parame, h paramh, int paramInt) {}
  
  public final void a(int paramInt, String paramString, Map<String, Object> paramMap)
  {
    AppMethodBeat.i(131415);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(131415);
      return;
      this.hxk.h(this.bAX, this.hWq.j("ok", null));
      AppMethodBeat.o(131415);
      return;
      this.hxk.h(this.bAX, this.hWq.j("fail:".concat(String.valueOf(paramString)), null));
      AppMethodBeat.o(131415);
      return;
      this.hxk.h(this.bAX, this.hWq.j("cancel", null));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.m.e.1
 * JD-Core Version:    0.7.0.1
 */
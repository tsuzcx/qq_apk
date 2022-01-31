package com.tencent.mm.plugin.appbrand.jsapi.m;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.service.c;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Map;

final class h$1
  implements b.a
{
  h$1(h paramh, c paramc, int paramInt) {}
  
  public final void a(int paramInt, String paramString, Map<String, Object> paramMap)
  {
    AppMethodBeat.i(131421);
    switch (paramInt)
    {
    default: 
      this.hxC.h(this.bAX, this.hWu.j("cancel", null));
      AppMethodBeat.o(131421);
      return;
    case 1: 
      this.hxC.h(this.bAX, this.hWu.j("ok", null));
      AppMethodBeat.o(131421);
      return;
    }
    if (bo.isNullOrNil(paramString))
    {
      this.hxC.h(this.bAX, this.hWu.j("fail", null));
      AppMethodBeat.o(131421);
      return;
    }
    this.hxC.h(this.bAX, this.hWu.j(String.format("fail %s", new Object[] { paramString }), null));
    AppMethodBeat.o(131421);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.m.h.1
 * JD-Core Version:    0.7.0.1
 */
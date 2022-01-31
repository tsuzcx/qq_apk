package com.tencent.mm.plugin.appbrand.jsapi.m;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.service.c;
import java.util.HashMap;
import java.util.Map;

final class i$1
  implements b.b
{
  i$1(i parami, c paramc, int paramInt) {}
  
  public final void j(boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(131423);
    if (paramBoolean)
    {
      HashMap localHashMap = new HashMap(1);
      localHashMap.put("token", paramString);
      this.hxC.h(this.bAX, this.hWv.j("ok", localHashMap));
      AppMethodBeat.o(131423);
      return;
    }
    this.hxC.h(this.bAX, this.hWv.j("fail", null));
    AppMethodBeat.o(131423);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.m.i.1
 * JD-Core Version:    0.7.0.1
 */
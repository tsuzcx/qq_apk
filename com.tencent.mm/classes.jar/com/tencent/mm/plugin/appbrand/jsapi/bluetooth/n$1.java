package com.tencent.mm.plugin.appbrand.jsapi.bluetooth;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.b;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.j;
import java.util.HashMap;
import java.util.Map;

final class n$1
  implements b
{
  n$1(n paramn, com.tencent.mm.plugin.appbrand.jsapi.c paramc, int paramInt) {}
  
  public final void a(j paramj)
  {
    AppMethodBeat.i(94204);
    switch (paramj.errCode)
    {
    default: 
      HashMap localHashMap = new HashMap();
      localHashMap.put("errCode", Integer.valueOf(paramj.errCode));
      this.hxW.h(this.bAX, this.hFI.j(paramj.errMsg, localHashMap));
      c.kS(43);
      AppMethodBeat.o(94204);
      return;
    }
    paramj = new HashMap();
    paramj.put("errCode", Integer.valueOf(0));
    this.hxW.h(this.bAX, this.hFI.j("ok", paramj));
    c.kS(42);
    AppMethodBeat.o(94204);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.n.1
 * JD-Core Version:    0.7.0.1
 */
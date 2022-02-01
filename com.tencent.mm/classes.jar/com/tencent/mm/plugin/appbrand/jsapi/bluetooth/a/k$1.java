package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.c;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.b;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.j;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import java.util.HashMap;
import java.util.Map;

final class k$1
  implements b
{
  k$1(k paramk, e parame, int paramInt) {}
  
  public final void a(j paramj)
  {
    AppMethodBeat.i(144503);
    switch (paramj.errCode)
    {
    default: 
      HashMap localHashMap = new HashMap();
      localHashMap.put("errCode", Integer.valueOf(paramj.errCode));
      this.cyJ.j(this.cuf, this.oHm.m(paramj.errMsg, localHashMap));
      c.rE(43);
      AppMethodBeat.o(144503);
      return;
    }
    paramj = new HashMap();
    paramj.put("errCode", Integer.valueOf(0));
    this.cyJ.j(this.cuf, this.oHm.m("ok", paramj));
    c.rE(42);
    AppMethodBeat.o(144503);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.a.k.1
 * JD-Core Version:    0.7.0.1
 */
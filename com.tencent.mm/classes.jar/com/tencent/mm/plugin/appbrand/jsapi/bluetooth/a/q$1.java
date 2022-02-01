package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.c;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.b;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.j;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import java.util.HashMap;
import java.util.Map;

final class q$1
  implements b
{
  q$1(q paramq, e parame, int paramInt) {}
  
  public final void a(j paramj)
  {
    AppMethodBeat.i(144526);
    switch (paramj.errCode)
    {
    default: 
      HashMap localHashMap = new HashMap();
      localHashMap.put("errCode", Integer.valueOf(paramj.errCode));
      this.cyJ.j(this.cuf, this.oHx.m(paramj.errMsg, localHashMap));
      c.rE(58);
      AppMethodBeat.o(144526);
      return;
    }
    paramj = new HashMap();
    paramj.put("errCode", Integer.valueOf(0));
    this.cyJ.j(this.cuf, this.oHx.m("ok", paramj));
    c.rE(58);
    AppMethodBeat.o(144526);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.a.q.1
 * JD-Core Version:    0.7.0.1
 */
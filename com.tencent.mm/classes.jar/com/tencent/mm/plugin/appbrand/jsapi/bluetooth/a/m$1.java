package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.c;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.b;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.j;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import java.util.HashMap;
import java.util.Map;

final class m$1
  implements b
{
  m$1(m paramm, e parame, int paramInt) {}
  
  public final void a(j paramj)
  {
    AppMethodBeat.i(144516);
    switch (paramj.errCode)
    {
    default: 
      HashMap localHashMap = new HashMap();
      localHashMap.put("errCode", Integer.valueOf(paramj.errCode));
      this.cyJ.j(this.cuf, this.oHs.m(paramj.errMsg, localHashMap));
      c.rE(43);
      AppMethodBeat.o(144516);
      return;
    }
    paramj = new HashMap();
    paramj.put("errCode", Integer.valueOf(0));
    this.cyJ.j(this.cuf, this.oHs.m("ok", paramj));
    c.rE(42);
    AppMethodBeat.o(144516);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.a.m.1
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.b;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.j;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.Map;

final class c$1
  implements b
{
  c$1(c paramc, String paramString, e parame, int paramInt) {}
  
  public final void a(j paramj)
  {
    AppMethodBeat.i(144496);
    Log.i("MicroMsg.JsApiCreateBLEConnection", "appId:%s createBLEConnection result:%s", new Object[] { this.val$appId, paramj });
    switch (paramj.errCode)
    {
    default: 
      HashMap localHashMap = new HashMap();
      localHashMap.put("errCode", Integer.valueOf(paramj.errCode));
      this.cyJ.j(this.cuf, this.oHc.m(paramj.errMsg, localHashMap));
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.c.rE(27);
      AppMethodBeat.o(144496);
      return;
    }
    paramj = new HashMap();
    paramj.put("errCode", Integer.valueOf(0));
    this.cyJ.j(this.cuf, this.oHc.m("ok", paramj));
    com.tencent.mm.plugin.appbrand.jsapi.bluetooth.c.rE(26);
    AppMethodBeat.o(144496);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.a.c.1
 * JD-Core Version:    0.7.0.1
 */
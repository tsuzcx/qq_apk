package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.c;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.b;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.j;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.Map;

final class o$1
  implements b
{
  o$1(o paramo, e parame, int paramInt) {}
  
  public final void a(j paramj)
  {
    AppMethodBeat.i(144518);
    Log.i("MicroMsg.JsApiStartBluetoothDevicesDiscovery", "[onScanResult]result:%s", new Object[] { paramj });
    switch (paramj.errCode)
    {
    default: 
      HashMap localHashMap = new HashMap();
      localHashMap.put("errCode", Integer.valueOf(paramj.errCode));
      localHashMap.put("isDiscovering", Boolean.FALSE);
      this.cyJ.j(this.cuf, this.oHv.m(paramj.errMsg, localHashMap));
      c.rE(13);
      AppMethodBeat.o(144518);
      return;
    }
    paramj = new HashMap();
    paramj.put("errCode", Integer.valueOf(0));
    paramj.put("isDiscovering", Boolean.TRUE);
    this.cyJ.j(this.cuf, this.oHv.m("ok", paramj));
    c.rE(12);
    AppMethodBeat.o(144518);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.a.o.1
 * JD-Core Version:    0.7.0.1
 */
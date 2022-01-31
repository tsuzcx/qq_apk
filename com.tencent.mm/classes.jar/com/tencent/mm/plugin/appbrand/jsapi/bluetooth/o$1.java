package com.tencent.mm.plugin.appbrand.jsapi.bluetooth;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.b;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.j;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.HashMap;
import java.util.Map;

final class o$1
  implements b
{
  o$1(o paramo, com.tencent.mm.plugin.appbrand.jsapi.c paramc, int paramInt) {}
  
  public final void a(j paramj)
  {
    AppMethodBeat.i(94206);
    ab.i("MicroMsg.JsApiStartBluetoothDevicesDiscovery", "[onScanResult]result:%s", new Object[] { paramj });
    switch (paramj.errCode)
    {
    default: 
      HashMap localHashMap = new HashMap();
      localHashMap.put("errCode", Integer.valueOf(paramj.errCode));
      localHashMap.put("isDiscovering", Boolean.FALSE);
      this.hxW.h(this.bAX, this.hFJ.j(paramj.errMsg, localHashMap));
      c.kS(13);
      AppMethodBeat.o(94206);
      return;
    }
    paramj = new HashMap();
    paramj.put("errCode", Integer.valueOf(0));
    paramj.put("isDiscovering", Boolean.TRUE);
    this.hxW.h(this.bAX, this.hFJ.j("ok", paramj));
    c.kS(12);
    AppMethodBeat.o(94206);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.o.1
 * JD-Core Version:    0.7.0.1
 */
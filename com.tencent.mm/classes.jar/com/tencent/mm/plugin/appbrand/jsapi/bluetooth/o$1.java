package com.tencent.mm.plugin.appbrand.jsapi.bluetooth;

import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.b;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.j;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashMap;
import java.util.Map;

final class o$1
  implements b
{
  o$1(o paramo, com.tencent.mm.plugin.appbrand.jsapi.c paramc, int paramInt) {}
  
  public final void a(j paramj)
  {
    y.i("MicroMsg.JsApiStartBluetoothDevicesDiscovery", "[onScanResult]result:%s", new Object[] { paramj });
    switch (paramj.errCode)
    {
    default: 
      HashMap localHashMap = new HashMap();
      localHashMap.put("errCode", Integer.valueOf(paramj.errCode));
      localHashMap.put("isDiscovering", Boolean.valueOf(false));
      this.ggH.C(this.dIS, this.glK.h(paramj.aox, localHashMap));
      c.jdMethod_if(13);
      return;
    }
    paramj = new HashMap();
    paramj.put("errCode", Integer.valueOf(0));
    paramj.put("isDiscovering", Boolean.valueOf(true));
    this.ggH.C(this.dIS, this.glK.h("ok", paramj));
    c.jdMethod_if(12);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.o.1
 * JD-Core Version:    0.7.0.1
 */
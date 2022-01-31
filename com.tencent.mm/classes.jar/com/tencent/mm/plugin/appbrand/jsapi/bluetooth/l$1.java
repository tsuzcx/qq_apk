package com.tencent.mm.plugin.appbrand.jsapi.bluetooth;

import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.b;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.j;
import java.util.HashMap;
import java.util.Map;

final class l$1
  implements b
{
  l$1(l paraml, com.tencent.mm.plugin.appbrand.jsapi.c paramc, int paramInt) {}
  
  public final void a(j paramj)
  {
    switch (paramj.errCode)
    {
    default: 
      HashMap localHashMap = new HashMap();
      localHashMap.put("errCode", Integer.valueOf(paramj.errCode));
      this.ggH.C(this.dIS, this.glD.h(paramj.aox, localHashMap));
      c.jdMethod_if(43);
      return;
    }
    paramj = new HashMap();
    paramj.put("errCode", Integer.valueOf(0));
    this.ggH.C(this.dIS, this.glD.h("ok", paramj));
    c.jdMethod_if(42);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.l.1
 * JD-Core Version:    0.7.0.1
 */
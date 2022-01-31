package com.tencent.mm.plugin.appbrand.jsapi.bluetooth;

import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.b;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.j;
import com.tencent.mm.plugin.appbrand.jsapi.i;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashMap;
import java.util.Map;

final class l$2
  implements b
{
  l$2(l paraml, String paramString, com.tencent.mm.plugin.appbrand.jsapi.c paramc, int paramInt) {}
  
  public final void a(j paramj)
  {
    y.i("MicroMsg.JsApiNotifyBLECharacteristicValueChanged", "appId:%s notifyBLECharacteristicValueChanged result:%s", new Object[] { this.val$appId, paramj });
    switch (paramj.errCode)
    {
    default: 
      new HashMap().put("errCode", Integer.valueOf(paramj.errCode));
      this.ggH.C(this.dIS, this.glD.h(paramj.aox, null));
      c.jdMethod_if(43);
      return;
    }
    new HashMap().put("errCode", Integer.valueOf(0));
    this.ggH.C(this.dIS, this.glD.h("ok", null));
    c.jdMethod_if(42);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.l.2
 * JD-Core Version:    0.7.0.1
 */
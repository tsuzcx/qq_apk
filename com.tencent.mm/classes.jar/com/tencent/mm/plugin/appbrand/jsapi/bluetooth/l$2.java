package com.tencent.mm.plugin.appbrand.jsapi.bluetooth;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.b;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.j;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.HashMap;
import java.util.Map;

final class l$2
  implements b
{
  l$2(l paraml, String paramString, com.tencent.mm.plugin.appbrand.jsapi.c paramc, int paramInt) {}
  
  public final void a(j paramj)
  {
    AppMethodBeat.i(94192);
    ab.i("MicroMsg.JsApiNotifyBLECharacteristicValueChanged", "appId:%s notifyBLECharacteristicValueChanged result:%s", new Object[] { this.val$appId, paramj });
    switch (paramj.errCode)
    {
    default: 
      new HashMap().put("errCode", Integer.valueOf(paramj.errCode));
      this.hxW.h(this.bAX, this.hFC.j(paramj.errMsg, null));
      c.kS(43);
      AppMethodBeat.o(94192);
      return;
    }
    new HashMap().put("errCode", Integer.valueOf(0));
    this.hxW.h(this.bAX, this.hFC.j("ok", null));
    c.kS(42);
    AppMethodBeat.o(94192);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.l.2
 * JD-Core Version:    0.7.0.1
 */
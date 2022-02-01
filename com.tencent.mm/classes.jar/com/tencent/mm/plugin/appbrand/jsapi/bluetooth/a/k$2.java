package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.c;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.b;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.j;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.jsapi.o;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.Map;

final class k$2
  implements b
{
  k$2(k paramk, String paramString, e parame, int paramInt) {}
  
  public final void a(j paramj)
  {
    AppMethodBeat.i(144504);
    Log.i("MicroMsg.JsApiNotifyBLECharacteristicValueChanged", "appId:%s notifyBLECharacteristicValueChanged result:%s", new Object[] { this.val$appId, paramj });
    switch (paramj.errCode)
    {
    default: 
      new HashMap().put("errCode", Integer.valueOf(paramj.errCode));
      this.cyJ.j(this.cuf, this.oHm.h(paramj.errMsg, null));
      c.rE(43);
      AppMethodBeat.o(144504);
      return;
    }
    new HashMap().put("errCode", Integer.valueOf(0));
    this.cyJ.j(this.cuf, this.oHm.h("ok", null));
    c.rE(42);
    AppMethodBeat.o(144504);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.a.k.2
 * JD-Core Version:    0.7.0.1
 */
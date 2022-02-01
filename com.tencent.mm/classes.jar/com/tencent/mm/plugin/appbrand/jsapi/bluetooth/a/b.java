package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.a;

import android.annotation.TargetApi;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.a;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.j;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.jsapi.o;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONObject;

@TargetApi(18)
public final class b
  extends com.tencent.mm.plugin.appbrand.jsapi.c
{
  private static final int CTRL_INDEX = 174;
  private static final String NAME = "closeBluetoothAdapter";
  
  public final void a(e parame, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(144495);
    com.tencent.mm.plugin.appbrand.jsapi.bluetooth.c.rE(116);
    paramJSONObject = parame.getAppId();
    Log.i("MicroMsg.JsApiCloseBluetoothAdapter", "appId:%s closeBluetoothAdapter!", new Object[] { paramJSONObject });
    paramJSONObject = a.ahr(paramJSONObject);
    Log.i("MicroMsg.JsApiCloseBluetoothAdapter", "result:%s", new Object[] { paramJSONObject });
    switch (paramJSONObject.errCode)
    {
    default: 
      parame.j(paramInt, h(paramJSONObject.errMsg, null));
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.c.rE(118);
      AppMethodBeat.o(144495);
      return;
    }
    parame.j(paramInt, h("ok", null));
    com.tencent.mm.plugin.appbrand.jsapi.bluetooth.c.rE(117);
    AppMethodBeat.o(144495);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.a.b
 * JD-Core Version:    0.7.0.1
 */
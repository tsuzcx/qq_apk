package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.a;

import android.annotation.TargetApi;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.j;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.sdk.platformtools.ac;
import org.json.JSONObject;

@TargetApi(18)
public final class b
  extends com.tencent.mm.plugin.appbrand.jsapi.a
{
  private static final int CTRL_INDEX = 174;
  private static final String NAME = "closeBluetoothAdapter";
  
  public final void a(com.tencent.mm.plugin.appbrand.jsapi.c paramc, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(144495);
    com.tencent.mm.plugin.appbrand.jsapi.bluetooth.c.lA(116);
    paramJSONObject = paramc.getAppId();
    ac.i("MicroMsg.JsApiCloseBluetoothAdapter", "appId:%s closeBluetoothAdapter!", new Object[] { paramJSONObject });
    paramJSONObject = com.tencent.mm.plugin.appbrand.jsapi.bluetooth.a.LY(paramJSONObject);
    ac.i("MicroMsg.JsApiCloseBluetoothAdapter", "result:%s", new Object[] { paramJSONObject });
    switch (paramJSONObject.errCode)
    {
    default: 
      paramc.h(paramInt, e(paramJSONObject.errMsg, null));
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.c.lA(118);
      AppMethodBeat.o(144495);
      return;
    }
    paramc.h(paramInt, e("ok", null));
    com.tencent.mm.plugin.appbrand.jsapi.bluetooth.c.lA(117);
    AppMethodBeat.o(144495);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.a.b
 * JD-Core Version:    0.7.0.1
 */
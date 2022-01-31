package com.tencent.mm.plugin.appbrand.jsapi.bluetooth;

import android.annotation.TargetApi;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.j;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.sdk.platformtools.ab;
import org.json.JSONObject;

@TargetApi(18)
public final class e
  extends com.tencent.mm.plugin.appbrand.jsapi.a
{
  private static final int CTRL_INDEX = 174;
  private static final String NAME = "closeBluetoothAdapter";
  
  public final void a(com.tencent.mm.plugin.appbrand.jsapi.c paramc, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(94183);
    c.kS(116);
    paramJSONObject = paramc.getAppId();
    ab.i("MicroMsg.JsApiCloseBluetoothAdapter", "appId:%s closeBluetoothAdapter!", new Object[] { paramJSONObject });
    paramJSONObject = a.BV(paramJSONObject);
    ab.i("MicroMsg.JsApiCloseBluetoothAdapter", "result:%s", new Object[] { paramJSONObject });
    switch (paramJSONObject.errCode)
    {
    default: 
      paramc.h(paramInt, j(paramJSONObject.errMsg, null));
      c.kS(118);
      AppMethodBeat.o(94183);
      return;
    }
    paramc.h(paramInt, j("ok", null));
    c.kS(117);
    AppMethodBeat.o(94183);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.e
 * JD-Core Version:    0.7.0.1
 */
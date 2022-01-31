package com.tencent.mm.plugin.appbrand.jsapi.bluetooth;

import android.annotation.TargetApi;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.j;
import com.tencent.mm.plugin.appbrand.jsapi.i;
import com.tencent.mm.sdk.platformtools.y;
import org.json.JSONObject;

@TargetApi(18)
public final class e
  extends com.tencent.mm.plugin.appbrand.jsapi.a
{
  private static final int CTRL_INDEX = 174;
  private static final String NAME = "closeBluetoothAdapter";
  
  public final void a(com.tencent.mm.plugin.appbrand.jsapi.c paramc, JSONObject paramJSONObject, int paramInt)
  {
    c.jdMethod_if(116);
    paramJSONObject = paramc.getAppId();
    y.i("MicroMsg.JsApiCloseBluetoothAdapter", "appId:%s closeBluetoothAdapter!", new Object[] { paramJSONObject });
    paramJSONObject = a.tW(paramJSONObject);
    y.i("MicroMsg.JsApiCloseBluetoothAdapter", "result:%s", new Object[] { paramJSONObject });
    switch (paramJSONObject.errCode)
    {
    default: 
      paramc.C(paramInt, h(paramJSONObject.aox, null));
      c.jdMethod_if(118);
      return;
    }
    paramc.C(paramInt, h("ok", null));
    c.jdMethod_if(117);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.e
 * JD-Core Version:    0.7.0.1
 */
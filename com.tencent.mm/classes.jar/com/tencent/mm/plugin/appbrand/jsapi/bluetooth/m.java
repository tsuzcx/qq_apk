package com.tencent.mm.plugin.appbrand.jsapi.bluetooth;

import android.annotation.TargetApi;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.j;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

@TargetApi(18)
public final class m
  extends com.tencent.mm.plugin.appbrand.jsapi.a
{
  private static final int CTRL_INDEX = 173;
  private static final String NAME = "openBluetoothAdapter";
  
  public final void a(com.tencent.mm.plugin.appbrand.jsapi.c paramc, JSONObject paramJSONObject, int paramInt)
  {
    c.jdMethod_if(0);
    paramJSONObject = paramc.getAppId();
    y.i("MicroMsg.JsApiOpenBluetoothAdapter", "appid:%s openBluetoothAdapter!", new Object[] { paramJSONObject });
    paramJSONObject = a.a(paramJSONObject, new m.1(this, paramc), new m.2(this, paramc), new m.3(this, paramc));
    HashMap localHashMap = new HashMap();
    switch (paramJSONObject.errCode)
    {
    default: 
      localHashMap.put("errCode", Integer.valueOf(paramJSONObject.errCode));
      paramc.C(paramInt, h(paramJSONObject.aox, localHashMap));
      c.jdMethod_if(2);
      return;
    case 0: 
      localHashMap.put("errCode", Integer.valueOf(0));
      paramc.C(paramInt, h("ok", localHashMap));
      c.jdMethod_if(1);
      return;
    case 10009: 
      localHashMap.put("errCode", Integer.valueOf(10009));
      paramc.C(paramInt, h("fail:system not support", localHashMap));
      c.bU(2, 8);
      return;
    }
    localHashMap.put("errCode", Integer.valueOf(10001));
    paramc.C(paramInt, h("fail:not available", localHashMap));
    c.bU(2, 7);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.m
 * JD-Core Version:    0.7.0.1
 */
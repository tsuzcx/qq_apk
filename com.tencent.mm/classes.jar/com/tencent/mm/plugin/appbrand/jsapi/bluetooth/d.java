package com.tencent.mm.plugin.appbrand.jsapi.bluetooth;

import android.annotation.TargetApi;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.j;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

@TargetApi(18)
public final class d
  extends com.tencent.mm.plugin.appbrand.jsapi.a
{
  private static final int CTRL_INDEX = 181;
  private static final String NAME = "closeBLEConnection";
  
  public final void a(final com.tencent.mm.plugin.appbrand.jsapi.c paramc, JSONObject paramJSONObject, final int paramInt)
  {
    c.jdMethod_if(91);
    if (paramJSONObject == null)
    {
      y.e("MicroMsg.JsApiCloseBLEConnection", "JsApiCloseBLEConnection data is null");
      paramJSONObject = new HashMap();
      paramJSONObject.put("errCode", Integer.valueOf(10013));
      paramc.C(paramInt, h("fail:invalid data", paramJSONObject));
      c.bU(93, 94);
      return;
    }
    y.i("MicroMsg.JsApiCloseBLEConnection", "appId:%s createBLEConnection data %s", new Object[] { paramc.getAppId(), paramJSONObject.toString() });
    b localb = a.tV(paramc.getAppId());
    if (localb == null)
    {
      y.e("MicroMsg.JsApiCloseBLEConnection", "bleWorker is null, may not open ble");
      paramJSONObject = new HashMap();
      paramJSONObject.put("errCode", Integer.valueOf(10000));
      paramc.C(paramInt, h("fail:not init", paramJSONObject));
      c.bU(93, 96);
      return;
    }
    if (!com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.b.aiB())
    {
      y.e("MicroMsg.JsApiCloseBLEConnection", "adapter is null or not enabled!");
      paramJSONObject = new HashMap();
      paramJSONObject.put("errCode", Integer.valueOf(10001));
      paramc.C(paramInt, h("fail:not available", paramJSONObject));
      c.bU(93, 98);
      return;
    }
    String str = paramJSONObject.optString("deviceId");
    boolean bool1 = paramJSONObject.optBoolean("debug", false);
    boolean bool2 = paramJSONObject.optBoolean("mainThread", true);
    boolean bool3 = paramJSONObject.optBoolean("serial", true);
    paramJSONObject = new com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.a.a();
    paramJSONObject.apo = bool1;
    paramJSONObject.glS = bool2;
    paramJSONObject.glU = bool3;
    localb.a(str, paramJSONObject, new com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.b()
    {
      public final void a(j paramAnonymousj)
      {
        switch (paramAnonymousj.errCode)
        {
        default: 
          HashMap localHashMap = new HashMap();
          localHashMap.put("errCode", Integer.valueOf(paramAnonymousj.errCode));
          paramc.C(paramInt, d.this.h(paramAnonymousj.aox, localHashMap));
          c.jdMethod_if(93);
          return;
        }
        paramAnonymousj = new HashMap();
        paramAnonymousj.put("errCode", Integer.valueOf(0));
        paramc.C(paramInt, d.this.h("ok", paramAnonymousj));
        c.jdMethod_if(92);
      }
    });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.d
 * JD-Core Version:    0.7.0.1
 */
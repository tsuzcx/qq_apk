package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.a;

import android.annotation.TargetApi;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.j;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

@TargetApi(18)
public final class c
  extends com.tencent.mm.plugin.appbrand.jsapi.a
{
  private static final int CTRL_INDEX = 180;
  private static final String NAME = "createBLEConnection";
  
  public final void a(final com.tencent.mm.plugin.appbrand.jsapi.c paramc, JSONObject paramJSONObject, final int paramInt)
  {
    AppMethodBeat.i(144497);
    com.tencent.mm.plugin.appbrand.jsapi.bluetooth.c.lA(25);
    if (paramJSONObject == null)
    {
      ac.e("MicroMsg.JsApiCreateBLEConnection", "createBLEConnection data is null, err");
      paramJSONObject = new HashMap();
      paramJSONObject.put("errCode", Integer.valueOf(10013));
      paramc.h(paramInt, k("fail:invalid data", paramJSONObject));
      AppMethodBeat.o(144497);
      return;
    }
    final String str1 = paramc.getAppId();
    ac.i("MicroMsg.JsApiCreateBLEConnection", "appId:%s createBLEConnection data %s", new Object[] { str1, paramJSONObject.toString() });
    com.tencent.mm.plugin.appbrand.jsapi.bluetooth.b localb = com.tencent.mm.plugin.appbrand.jsapi.bluetooth.a.LX(paramc.getAppId());
    if (localb == null)
    {
      ac.e("MicroMsg.JsApiCreateBLEConnection", "bleWorker is null, may not open ble");
      paramJSONObject = new HashMap();
      paramJSONObject.put("errCode", Integer.valueOf(10000));
      paramc.h(paramInt, k("fail:not init", paramJSONObject));
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.c.dL(27, 30);
      AppMethodBeat.o(144497);
      return;
    }
    if (!com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.c.bfV())
    {
      ac.e("MicroMsg.JsApiCreateBLEConnection", "bleWorker is disable, may not open ble");
      paramJSONObject = new HashMap();
      paramJSONObject.put("errCode", Integer.valueOf(10001));
      paramc.h(paramInt, k("fail:not available", paramJSONObject));
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.c.dL(27, 32);
      AppMethodBeat.o(144497);
      return;
    }
    boolean bool1 = paramJSONObject.optBoolean("debug", false);
    boolean bool2 = paramJSONObject.optBoolean("mainThread", true);
    boolean bool3 = paramJSONObject.optBoolean("serial", true);
    long l1 = paramJSONObject.optLong("timeout", 20000L);
    boolean bool4 = paramJSONObject.optBoolean("autoConnect", false);
    String str2 = paramJSONObject.optString("transport", "LE");
    long l2 = paramJSONObject.optLong("discoverDelay", 0L);
    paramJSONObject = paramJSONObject.optString("deviceId");
    com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.a.b localb1 = new com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.a.b(paramJSONObject);
    localb1.aNj = bool1;
    localb1.kjt = bool2;
    localb1.kjv = bool3;
    localb1.kkl = l1;
    localb1.kjT = bool4;
    localb1.kjU = str2;
    localb1.kjV = l2;
    localb.a(paramJSONObject, localb1, new com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.b()
    {
      public final void a(j paramAnonymousj)
      {
        AppMethodBeat.i(144496);
        ac.i("MicroMsg.JsApiCreateBLEConnection", "appId:%s createBLEConnection result:%s", new Object[] { str1, paramAnonymousj });
        switch (paramAnonymousj.errCode)
        {
        default: 
          HashMap localHashMap = new HashMap();
          localHashMap.put("errCode", Integer.valueOf(paramAnonymousj.errCode));
          paramc.h(paramInt, c.this.k(paramAnonymousj.errMsg, localHashMap));
          com.tencent.mm.plugin.appbrand.jsapi.bluetooth.c.lA(27);
          AppMethodBeat.o(144496);
          return;
        }
        paramAnonymousj = new HashMap();
        paramAnonymousj.put("errCode", Integer.valueOf(0));
        paramc.h(paramInt, c.this.k("ok", paramAnonymousj));
        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.c.lA(26);
        AppMethodBeat.o(144496);
      }
    });
    AppMethodBeat.o(144497);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.a.c
 * JD-Core Version:    0.7.0.1
 */
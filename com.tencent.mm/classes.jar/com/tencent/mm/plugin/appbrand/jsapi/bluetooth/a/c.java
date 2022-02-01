package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.a;

import android.annotation.TargetApi;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.j;
import com.tencent.mm.sdk.platformtools.ae;
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
    com.tencent.mm.plugin.appbrand.jsapi.bluetooth.c.md(25);
    if (paramJSONObject == null)
    {
      ae.e("MicroMsg.JsApiCreateBLEConnection", "createBLEConnection data is null, err");
      paramJSONObject = new HashMap();
      paramJSONObject.put("errCode", Integer.valueOf(10013));
      paramc.h(paramInt, n("fail:invalid data", paramJSONObject));
      AppMethodBeat.o(144497);
      return;
    }
    final String str1 = paramc.getAppId();
    ae.i("MicroMsg.JsApiCreateBLEConnection", "appId:%s createBLEConnection data %s", new Object[] { str1, paramJSONObject.toString() });
    com.tencent.mm.plugin.appbrand.jsapi.bluetooth.b localb = com.tencent.mm.plugin.appbrand.jsapi.bluetooth.a.Qb(paramc.getAppId());
    if (localb == null)
    {
      ae.e("MicroMsg.JsApiCreateBLEConnection", "bleWorker is null, may not open ble");
      paramJSONObject = new HashMap();
      paramJSONObject.put("errCode", Integer.valueOf(10000));
      paramc.h(paramInt, n("fail:not init", paramJSONObject));
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.c.dN(27, 30);
      AppMethodBeat.o(144497);
      return;
    }
    if (!com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.c.bki())
    {
      ae.e("MicroMsg.JsApiCreateBLEConnection", "bleWorker is disable, may not open ble");
      paramJSONObject = new HashMap();
      paramJSONObject.put("errCode", Integer.valueOf(10001));
      paramc.h(paramInt, n("fail:not available", paramJSONObject));
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.c.dN(27, 32);
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
    String str3 = paramJSONObject.optString("connectionPriority", null);
    paramJSONObject = paramJSONObject.optString("deviceId");
    com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.a.b localb1 = new com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.a.b(paramJSONObject);
    localb1.aXD = bool1;
    localb1.kHG = bool2;
    localb1.kHI = bool3;
    localb1.kIA = l1;
    localb1.kIg = bool4;
    localb1.kIh = str2;
    localb1.kIi = l2;
    localb1.kIj = str3;
    localb.a(paramJSONObject, localb1, new com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.b()
    {
      public final void a(j paramAnonymousj)
      {
        AppMethodBeat.i(144496);
        ae.i("MicroMsg.JsApiCreateBLEConnection", "appId:%s createBLEConnection result:%s", new Object[] { str1, paramAnonymousj });
        switch (paramAnonymousj.errCode)
        {
        default: 
          HashMap localHashMap = new HashMap();
          localHashMap.put("errCode", Integer.valueOf(paramAnonymousj.errCode));
          paramc.h(paramInt, c.this.n(paramAnonymousj.errMsg, localHashMap));
          com.tencent.mm.plugin.appbrand.jsapi.bluetooth.c.md(27);
          AppMethodBeat.o(144496);
          return;
        }
        paramAnonymousj = new HashMap();
        paramAnonymousj.put("errCode", Integer.valueOf(0));
        paramc.h(paramInt, c.this.n("ok", paramAnonymousj));
        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.c.md(26);
        AppMethodBeat.o(144496);
      }
    });
    AppMethodBeat.o(144497);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.a.c
 * JD-Core Version:    0.7.0.1
 */
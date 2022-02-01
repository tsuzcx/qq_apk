package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.a;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.h;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.k;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.g.a.c;
import com.tencent.mm.plugin.appbrand.jsapi.g.a.e;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class c
  extends com.tencent.mm.plugin.appbrand.jsapi.c
{
  private static final int CTRL_INDEX = 180;
  private static final String NAME = "createBLEConnection";
  
  protected void a(f paramf, String paramString, boolean paramBoolean) {}
  
  public final void a(final f paramf, JSONObject paramJSONObject, final int paramInt)
  {
    AppMethodBeat.i(144497);
    h.rG(25);
    if (paramJSONObject == null)
    {
      Log.e("MicroMsg.JsApiCreateBLEConnection", "createBLEConnection data is null, err");
      paramJSONObject = new HashMap();
      paramJSONObject.put("errCode", Integer.valueOf(10013));
      paramf.callback(paramInt, a("fail:invalid data", a.e.rVz, paramJSONObject));
      AppMethodBeat.o(144497);
      return;
    }
    final String str1 = paramf.getAppId();
    Log.i("MicroMsg.JsApiCreateBLEConnection", "appId:%s createBLEConnection data %s", new Object[] { str1, paramJSONObject.toString() });
    com.tencent.mm.plugin.appbrand.jsapi.bluetooth.b localb = a.aan(paramf.getAppId());
    if (localb == null)
    {
      Log.e("MicroMsg.JsApiCreateBLEConnection", "bleWorker is null, may not open ble");
      paramJSONObject = new HashMap();
      paramJSONObject.put("errCode", Integer.valueOf(10000));
      paramf.callback(paramInt, a(a.c.rUE, paramJSONObject));
      h.fr(27, 30);
      AppMethodBeat.o(144497);
      return;
    }
    if (!com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.c.cru())
    {
      Log.e("MicroMsg.JsApiCreateBLEConnection", "bleWorker is disable, may not open ble");
      paramJSONObject = new HashMap();
      paramJSONObject.put("errCode", Integer.valueOf(10001));
      paramf.callback(paramInt, a("fail:not available", a.c.rUF, paramJSONObject));
      h.fr(27, 32);
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
    final String str4 = paramJSONObject.optString("deviceId");
    boolean bool5 = paramJSONObject.optBoolean("doDiscover", true);
    Log.i("MicroMsg.JsApiCreateBLEConnection", "deviceId: %s, doDiscover: %b", new Object[] { str4, Boolean.valueOf(bool5) });
    paramJSONObject = new com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.a.b(str4);
    paramJSONObject.debug = bool1;
    paramJSONObject.rMf = bool2;
    paramJSONObject.rMh = bool3;
    paramJSONObject.rNh = l1;
    paramJSONObject.rMM = bool4;
    paramJSONObject.rMN = str2;
    paramJSONObject.rMO = l2;
    paramJSONObject.rMP = str3;
    paramJSONObject.rMQ = bool5;
    localb.a(str4, paramJSONObject, new com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.b()
    {
      public final void onResult(k paramAnonymousk)
      {
        AppMethodBeat.i(144496);
        Log.i("MicroMsg.JsApiCreateBLEConnection", "appId:%s createBLEConnection result:%s", new Object[] { str1, paramAnonymousk });
        switch (paramAnonymousk.errCode)
        {
        default: 
          HashMap localHashMap = new HashMap();
          localHashMap.put("errCode", Integer.valueOf(paramAnonymousk.errCode));
          paramf.callback(paramInt, c.this.a(paramAnonymousk.errMsg, paramAnonymousk.rKn, localHashMap));
          c.this.a(paramf, str4, false);
          h.rG(27);
          AppMethodBeat.o(144496);
          return;
        }
        paramAnonymousk = new HashMap();
        paramAnonymousk.put("errCode", Integer.valueOf(0));
        paramf.callback(paramInt, c.this.a(null, a.e.rVt, paramAnonymousk));
        c.this.a(paramf, str4, true);
        h.rG(26);
        AppMethodBeat.o(144496);
      }
    });
    AppMethodBeat.o(144497);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.a.c
 * JD-Core Version:    0.7.0.1
 */
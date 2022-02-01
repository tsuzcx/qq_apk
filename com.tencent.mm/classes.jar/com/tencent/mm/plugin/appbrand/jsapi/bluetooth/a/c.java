package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.a;

import android.annotation.TargetApi;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.a;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.j;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

@TargetApi(18)
public final class c
  extends d
{
  private static final int CTRL_INDEX = 180;
  private static final String NAME = "createBLEConnection";
  
  public final void a(final f paramf, JSONObject paramJSONObject, final int paramInt)
  {
    AppMethodBeat.i(144497);
    com.tencent.mm.plugin.appbrand.jsapi.bluetooth.c.pl(25);
    if (paramJSONObject == null)
    {
      Log.e("MicroMsg.JsApiCreateBLEConnection", "createBLEConnection data is null, err");
      paramJSONObject = new HashMap();
      paramJSONObject.put("errCode", Integer.valueOf(10013));
      paramf.i(paramInt, n("fail:invalid data", paramJSONObject));
      AppMethodBeat.o(144497);
      return;
    }
    final String str1 = paramf.getAppId();
    Log.i("MicroMsg.JsApiCreateBLEConnection", "appId:%s createBLEConnection data %s", new Object[] { str1, paramJSONObject.toString() });
    com.tencent.mm.plugin.appbrand.jsapi.bluetooth.b localb = a.ZC(paramf.getAppId());
    if (localb == null)
    {
      Log.e("MicroMsg.JsApiCreateBLEConnection", "bleWorker is null, may not open ble");
      paramJSONObject = new HashMap();
      paramJSONObject.put("errCode", Integer.valueOf(10000));
      paramf.i(paramInt, n("fail:not init", paramJSONObject));
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.c.dY(27, 30);
      AppMethodBeat.o(144497);
      return;
    }
    if (!com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.c.bFE())
    {
      Log.e("MicroMsg.JsApiCreateBLEConnection", "bleWorker is disable, may not open ble");
      paramJSONObject = new HashMap();
      paramJSONObject.put("errCode", Integer.valueOf(10001));
      paramf.i(paramInt, n("fail:not available", paramJSONObject));
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.c.dY(27, 32);
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
    localb1.aXs = bool1;
    localb1.lMh = bool2;
    localb1.lMj = bool3;
    localb1.lNf = l1;
    localb1.lMK = bool4;
    localb1.lML = str2;
    localb1.lMM = l2;
    localb1.lMN = str3;
    localb.a(paramJSONObject, localb1, new com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.b()
    {
      public final void a(j paramAnonymousj)
      {
        AppMethodBeat.i(144496);
        Log.i("MicroMsg.JsApiCreateBLEConnection", "appId:%s createBLEConnection result:%s", new Object[] { str1, paramAnonymousj });
        switch (paramAnonymousj.errCode)
        {
        default: 
          HashMap localHashMap = new HashMap();
          localHashMap.put("errCode", Integer.valueOf(paramAnonymousj.errCode));
          paramf.i(paramInt, c.this.n(paramAnonymousj.errMsg, localHashMap));
          com.tencent.mm.plugin.appbrand.jsapi.bluetooth.c.pl(27);
          AppMethodBeat.o(144496);
          return;
        }
        paramAnonymousj = new HashMap();
        paramAnonymousj.put("errCode", Integer.valueOf(0));
        paramf.i(paramInt, c.this.n("ok", paramAnonymousj));
        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.c.pl(26);
        AppMethodBeat.o(144496);
      }
    });
    AppMethodBeat.o(144497);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.a.c
 * JD-Core Version:    0.7.0.1
 */
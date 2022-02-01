package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.a;

import android.annotation.TargetApi;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.a;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

@TargetApi(18)
public final class c
  extends com.tencent.mm.plugin.appbrand.jsapi.c
{
  private static final int CTRL_INDEX = 180;
  private static final String NAME = "createBLEConnection";
  
  public final void a(e parame, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(144497);
    com.tencent.mm.plugin.appbrand.jsapi.bluetooth.c.rE(25);
    if (paramJSONObject == null)
    {
      Log.e("MicroMsg.JsApiCreateBLEConnection", "createBLEConnection data is null, err");
      paramJSONObject = new HashMap();
      paramJSONObject.put("errCode", Integer.valueOf(10013));
      parame.j(paramInt, m("fail:invalid data", paramJSONObject));
      AppMethodBeat.o(144497);
      return;
    }
    String str1 = parame.getAppId();
    Log.i("MicroMsg.JsApiCreateBLEConnection", "appId:%s createBLEConnection data %s", new Object[] { str1, paramJSONObject.toString() });
    com.tencent.mm.plugin.appbrand.jsapi.bluetooth.b localb = a.ahq(parame.getAppId());
    if (localb == null)
    {
      Log.e("MicroMsg.JsApiCreateBLEConnection", "bleWorker is null, may not open ble");
      paramJSONObject = new HashMap();
      paramJSONObject.put("errCode", Integer.valueOf(10000));
      parame.j(paramInt, m("fail:not init", paramJSONObject));
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.c.ex(27, 30);
      AppMethodBeat.o(144497);
      return;
    }
    if (!com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.c.bRm())
    {
      Log.e("MicroMsg.JsApiCreateBLEConnection", "bleWorker is disable, may not open ble");
      paramJSONObject = new HashMap();
      paramJSONObject.put("errCode", Integer.valueOf(10001));
      parame.j(paramInt, m("fail:not available", paramJSONObject));
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.c.ex(27, 32);
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
    String str4 = paramJSONObject.optString("deviceId");
    boolean bool5 = paramJSONObject.optBoolean("doDiscover", true);
    Log.i("MicroMsg.JsApiCreateBLEConnection", "deviceId: %s, doDiscover: %b", new Object[] { str4, Boolean.valueOf(bool5) });
    paramJSONObject = new com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.a.b(str4);
    paramJSONObject.aGM = bool1;
    paramJSONObject.oIw = bool2;
    paramJSONObject.oIy = bool3;
    paramJSONObject.oJt = l1;
    paramJSONObject.oJa = bool4;
    paramJSONObject.oJb = str2;
    paramJSONObject.oJc = l2;
    paramJSONObject.oJd = str3;
    paramJSONObject.oJe = bool5;
    localb.a(str4, paramJSONObject, new c.1(this, str1, parame, paramInt));
    AppMethodBeat.o(144497);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.a.c
 * JD-Core Version:    0.7.0.1
 */
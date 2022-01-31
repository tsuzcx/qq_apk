package com.tencent.mm.plugin.appbrand.jsapi.bluetooth;

import android.annotation.TargetApi;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

@TargetApi(18)
public final class f
  extends com.tencent.mm.plugin.appbrand.jsapi.a
{
  private static final int CTRL_INDEX = 180;
  private static final String NAME = "createBLEConnection";
  
  public final void a(com.tencent.mm.plugin.appbrand.jsapi.c paramc, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(94185);
    c.kS(25);
    if (paramJSONObject == null)
    {
      ab.e("MicroMsg.JsApiCreateBLEConnection", "createBLEConnection data is null, err");
      paramJSONObject = new HashMap();
      paramJSONObject.put("errCode", Integer.valueOf(10013));
      paramc.h(paramInt, j("fail:invalid data", paramJSONObject));
      AppMethodBeat.o(94185);
      return;
    }
    String str1 = paramc.getAppId();
    ab.i("MicroMsg.JsApiCreateBLEConnection", "appId:%s createBLEConnection data %s", new Object[] { str1, paramJSONObject.toString() });
    b localb = a.BU(paramc.getAppId());
    if (localb == null)
    {
      ab.e("MicroMsg.JsApiCreateBLEConnection", "bleWorker is null, may not open ble");
      paramJSONObject = new HashMap();
      paramJSONObject.put("errCode", Integer.valueOf(10000));
      paramc.h(paramInt, j("fail:not init", paramJSONObject));
      c.df(27, 30);
      AppMethodBeat.o(94185);
      return;
    }
    if (!com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.b.aCw())
    {
      ab.e("MicroMsg.JsApiCreateBLEConnection", "bleWorker is disable, may not open ble");
      paramJSONObject = new HashMap();
      paramJSONObject.put("errCode", Integer.valueOf(10001));
      paramc.h(paramInt, j("fail:not available", paramJSONObject));
      c.df(27, 32);
      AppMethodBeat.o(94185);
      return;
    }
    boolean bool1 = paramJSONObject.optBoolean("debug", false);
    boolean bool2 = paramJSONObject.optBoolean("mainThread", true);
    boolean bool3 = paramJSONObject.optBoolean("serial", true);
    long l = paramJSONObject.optLong("timeout", 20000L);
    boolean bool4 = paramJSONObject.optBoolean("autoConnect", false);
    String str2 = paramJSONObject.optString("transport", "LE");
    paramJSONObject = paramJSONObject.optString("deviceId");
    com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.a.b localb1 = new com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.a.b(paramJSONObject);
    localb1.arI = bool1;
    localb1.hFR = bool2;
    localb1.hFT = bool3;
    localb1.hGz = l;
    localb1.hGq = bool4;
    localb1.hGr = str2;
    localb.a(paramJSONObject, localb1, new f.1(this, str1, paramc, paramInt));
    AppMethodBeat.o(94185);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.f
 * JD-Core Version:    0.7.0.1
 */
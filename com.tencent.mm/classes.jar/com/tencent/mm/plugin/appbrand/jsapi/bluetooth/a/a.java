package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.a;

import android.annotation.TargetApi;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.j;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

@TargetApi(18)
public final class a
  extends com.tencent.mm.plugin.appbrand.jsapi.a
{
  private static final int CTRL_INDEX = 181;
  private static final String NAME = "closeBLEConnection";
  
  public final void a(final com.tencent.mm.plugin.appbrand.jsapi.c paramc, JSONObject paramJSONObject, final int paramInt)
  {
    AppMethodBeat.i(144494);
    com.tencent.mm.plugin.appbrand.jsapi.bluetooth.c.md(91);
    if (paramJSONObject == null)
    {
      ae.e("MicroMsg.JsApiCloseBLEConnection", "JsApiCloseBLEConnection data is null");
      paramJSONObject = new HashMap();
      paramJSONObject.put("errCode", Integer.valueOf(10013));
      paramc.h(paramInt, n("fail:invalid data", paramJSONObject));
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.c.dN(93, 94);
      AppMethodBeat.o(144494);
      return;
    }
    ae.i("MicroMsg.JsApiCloseBLEConnection", "appId:%s closeBLEConnection data %s", new Object[] { paramc.getAppId(), paramJSONObject.toString() });
    com.tencent.mm.plugin.appbrand.jsapi.bluetooth.b localb = com.tencent.mm.plugin.appbrand.jsapi.bluetooth.a.Qb(paramc.getAppId());
    if (localb == null)
    {
      ae.e("MicroMsg.JsApiCloseBLEConnection", "bleWorker is null, may not open ble");
      paramJSONObject = new HashMap();
      paramJSONObject.put("errCode", Integer.valueOf(10000));
      paramc.h(paramInt, n("fail:not init", paramJSONObject));
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.c.dN(93, 96);
      AppMethodBeat.o(144494);
      return;
    }
    if (!com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.c.bki())
    {
      ae.e("MicroMsg.JsApiCloseBLEConnection", "adapter is null or not enabled!");
      paramJSONObject = new HashMap();
      paramJSONObject.put("errCode", Integer.valueOf(10001));
      paramc.h(paramInt, n("fail:not available", paramJSONObject));
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.c.dN(93, 98);
      AppMethodBeat.o(144494);
      return;
    }
    String str = paramJSONObject.optString("deviceId");
    boolean bool1 = paramJSONObject.optBoolean("debug", false);
    boolean bool2 = paramJSONObject.optBoolean("mainThread", true);
    boolean bool3 = paramJSONObject.optBoolean("serial", true);
    paramJSONObject = new com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.a.a();
    paramJSONObject.aXD = bool1;
    paramJSONObject.kHG = bool2;
    paramJSONObject.kHI = bool3;
    localb.a(str, paramJSONObject, new com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.b()
    {
      public final void a(j paramAnonymousj)
      {
        AppMethodBeat.i(144493);
        switch (paramAnonymousj.errCode)
        {
        default: 
          HashMap localHashMap = new HashMap();
          localHashMap.put("errCode", Integer.valueOf(paramAnonymousj.errCode));
          paramc.h(paramInt, a.this.n(paramAnonymousj.errMsg, localHashMap));
          com.tencent.mm.plugin.appbrand.jsapi.bluetooth.c.md(93);
          AppMethodBeat.o(144493);
          return;
        }
        paramAnonymousj = new HashMap();
        paramAnonymousj.put("errCode", Integer.valueOf(0));
        paramc.h(paramInt, a.this.n("ok", paramAnonymousj));
        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.c.md(92);
        AppMethodBeat.o(144493);
      }
    });
    AppMethodBeat.o(144494);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.a.a
 * JD-Core Version:    0.7.0.1
 */
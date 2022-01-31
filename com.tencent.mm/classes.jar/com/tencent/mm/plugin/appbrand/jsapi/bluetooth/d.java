package com.tencent.mm.plugin.appbrand.jsapi.bluetooth;

import android.annotation.TargetApi;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.j;
import com.tencent.mm.sdk.platformtools.ab;
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
    AppMethodBeat.i(94182);
    c.kS(91);
    if (paramJSONObject == null)
    {
      ab.e("MicroMsg.JsApiCloseBLEConnection", "JsApiCloseBLEConnection data is null");
      paramJSONObject = new HashMap();
      paramJSONObject.put("errCode", Integer.valueOf(10013));
      paramc.h(paramInt, j("fail:invalid data", paramJSONObject));
      c.df(93, 94);
      AppMethodBeat.o(94182);
      return;
    }
    ab.i("MicroMsg.JsApiCloseBLEConnection", "appId:%s closeBLEConnection data %s", new Object[] { paramc.getAppId(), paramJSONObject.toString() });
    b localb = a.BU(paramc.getAppId());
    if (localb == null)
    {
      ab.e("MicroMsg.JsApiCloseBLEConnection", "bleWorker is null, may not open ble");
      paramJSONObject = new HashMap();
      paramJSONObject.put("errCode", Integer.valueOf(10000));
      paramc.h(paramInt, j("fail:not init", paramJSONObject));
      c.df(93, 96);
      AppMethodBeat.o(94182);
      return;
    }
    if (!com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.b.aCw())
    {
      ab.e("MicroMsg.JsApiCloseBLEConnection", "adapter is null or not enabled!");
      paramJSONObject = new HashMap();
      paramJSONObject.put("errCode", Integer.valueOf(10001));
      paramc.h(paramInt, j("fail:not available", paramJSONObject));
      c.df(93, 98);
      AppMethodBeat.o(94182);
      return;
    }
    String str = paramJSONObject.optString("deviceId");
    boolean bool1 = paramJSONObject.optBoolean("debug", false);
    boolean bool2 = paramJSONObject.optBoolean("mainThread", true);
    boolean bool3 = paramJSONObject.optBoolean("serial", true);
    paramJSONObject = new com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.a.a();
    paramJSONObject.arI = bool1;
    paramJSONObject.hFR = bool2;
    paramJSONObject.hFT = bool3;
    localb.a(str, paramJSONObject, new com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.b()
    {
      public final void a(j paramAnonymousj)
      {
        AppMethodBeat.i(94181);
        switch (paramAnonymousj.errCode)
        {
        default: 
          HashMap localHashMap = new HashMap();
          localHashMap.put("errCode", Integer.valueOf(paramAnonymousj.errCode));
          paramc.h(paramInt, d.this.j(paramAnonymousj.errMsg, localHashMap));
          c.kS(93);
          AppMethodBeat.o(94181);
          return;
        }
        paramAnonymousj = new HashMap();
        paramAnonymousj.put("errCode", Integer.valueOf(0));
        paramc.h(paramInt, d.this.j("ok", paramAnonymousj));
        c.kS(92);
        AppMethodBeat.o(94181);
      }
    });
    AppMethodBeat.o(94182);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.d
 * JD-Core Version:    0.7.0.1
 */
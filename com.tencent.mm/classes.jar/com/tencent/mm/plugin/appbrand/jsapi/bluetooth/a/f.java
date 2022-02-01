package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.a;

import android.annotation.TargetApi;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.a;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.j;
import com.tencent.mm.plugin.appbrand.jsapi.o;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@TargetApi(18)
public final class f
  extends com.tencent.mm.plugin.appbrand.jsapi.c
{
  private static final int CTRL_INDEX = 182;
  private static final String NAME = "getBLEDeviceServices";
  
  final void a(com.tencent.mm.plugin.appbrand.jsapi.e parame, int paramInt, List<com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.e> paramList)
  {
    AppMethodBeat.i(199265);
    Object localObject = new HashMap();
    if ((paramList == null) || (paramList.size() <= 0))
    {
      Log.e("MicroMsg.JsApiGetBLEDeviceServices", "not found services");
      ((Map)localObject).put("errCode", Integer.valueOf(10004));
      parame.j(paramInt, m("fail:no service", (Map)localObject));
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.c.ex(138, 144);
      AppMethodBeat.o(199265);
      return;
    }
    localObject = new JSONArray();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.e locale = (com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.e)paramList.next();
      if (Util.isNullOrNil(locale.uuid)) {
        Log.e("MicroMsg.JsApiGetBLEDeviceServices", "get uuid is null");
      } else {
        try
        {
          if (locale.jsonObject == null)
          {
            locale.jsonObject = new JSONObject();
            locale.jsonObject.put("uuid", locale.uuid);
            locale.jsonObject.put("isPrimary", locale.oJH);
          }
          ((JSONArray)localObject).put(locale.jsonObject);
        }
        catch (JSONException localJSONException2)
        {
          Log.e("MicroMsg.JsApiGetBLEDeviceServices", "JSONException %s", new Object[] { localJSONException2.getMessage() });
        }
      }
    }
    paramList = new JSONObject();
    try
    {
      paramList.put("errMsg", getName() + ":ok");
      paramList.put("services", localObject);
      paramList.put("errCode", 0);
      Log.i("MicroMsg.JsApiGetBLEDeviceServices", "retJson %s", new Object[] { paramList.toString() });
      parame.j(paramInt, paramList.toString());
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.c.rE(137);
      AppMethodBeat.o(199265);
      return;
    }
    catch (JSONException localJSONException1)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.JsApiGetBLEDeviceServices", localJSONException1, "", new Object[0]);
      }
    }
  }
  
  public final void a(final com.tencent.mm.plugin.appbrand.jsapi.e parame, JSONObject paramJSONObject, final int paramInt)
  {
    AppMethodBeat.i(144499);
    com.tencent.mm.plugin.appbrand.jsapi.bluetooth.c.rE(136);
    if (paramJSONObject == null)
    {
      Log.e("MicroMsg.JsApiGetBLEDeviceServices", "getBLEDeviceServices data is null");
      parame.j(paramInt, h("fail:invalid data", null));
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.c.ex(138, 139);
      AppMethodBeat.o(144499);
      return;
    }
    final String str1 = parame.getAppId();
    Log.i("MicroMsg.JsApiGetBLEDeviceServices", "appId:%s getBLEDeviceServices data %s", new Object[] { str1, paramJSONObject.toString() });
    final com.tencent.mm.plugin.appbrand.jsapi.bluetooth.b localb = a.ahq(parame.getAppId());
    if (localb == null)
    {
      Log.e("MicroMsg.JsApiGetBLEDeviceServices", "bleWorker is null, may not open ble");
      paramJSONObject = new HashMap();
      paramJSONObject.put("errCode", Integer.valueOf(10000));
      parame.j(paramInt, m("fail:not init", paramJSONObject));
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.c.ex(138, 141);
      AppMethodBeat.o(144499);
      return;
    }
    if (!com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.c.bRm())
    {
      Log.e("MicroMsg.JsApiGetBLEDeviceServices", "adapter is null or not enabled!");
      paramJSONObject = new HashMap();
      paramJSONObject.put("errCode", Integer.valueOf(10001));
      parame.j(paramInt, m("fail:not available", paramJSONObject));
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.c.ex(138, 145);
      AppMethodBeat.o(144499);
      return;
    }
    final String str2 = paramJSONObject.optString("deviceId");
    boolean bool = paramJSONObject.optBoolean("doDiscover", false);
    Log.i("MicroMsg.JsApiGetBLEDeviceServices", "deviceId: %s, doDiscover: %b", new Object[] { str2, Boolean.valueOf(bool) });
    if (bool)
    {
      localb.a(str2, new com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.a.c(str2), new com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.b()
      {
        public final void a(j paramAnonymousj)
        {
          AppMethodBeat.i(199136);
          Log.i("MicroMsg.JsApiGetBLEDeviceServices", "appId:%s getBLEDeviceServices result:%s", new Object[] { str1, paramAnonymousj });
          switch (paramAnonymousj.errCode)
          {
          default: 
            HashMap localHashMap = new HashMap();
            localHashMap.put("errCode", Integer.valueOf(paramAnonymousj.errCode));
            parame.j(paramInt, f.this.m(paramAnonymousj.errMsg, localHashMap));
            com.tencent.mm.plugin.appbrand.jsapi.bluetooth.c.rE(138);
            AppMethodBeat.o(199136);
            return;
          }
          paramAnonymousj = localb.aq(str2, false);
          f.this.a(parame, paramInt, paramAnonymousj);
          AppMethodBeat.o(199136);
        }
      });
      AppMethodBeat.o(144499);
      return;
    }
    a(parame, paramInt, localb.aq(str2, true));
    AppMethodBeat.o(144499);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.a.f
 * JD-Core Version:    0.7.0.1
 */
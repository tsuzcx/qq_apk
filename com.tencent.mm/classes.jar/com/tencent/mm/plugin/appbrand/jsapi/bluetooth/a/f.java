package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.a;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.h;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.e;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.k;
import com.tencent.mm.plugin.appbrand.jsapi.g.a.c;
import com.tencent.mm.plugin.appbrand.jsapi.g.a.e;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class f
  extends com.tencent.mm.plugin.appbrand.jsapi.c
{
  private static final int CTRL_INDEX = 182;
  private static final String NAME = "getBLEDeviceServices";
  
  final void a(com.tencent.mm.plugin.appbrand.jsapi.f paramf, int paramInt, List<e> paramList)
  {
    AppMethodBeat.i(329665);
    Object localObject = new HashMap();
    if ((paramList == null) || (paramList.size() <= 0))
    {
      Log.e("MicroMsg.JsApiGetBLEDeviceServices", "not found services");
      ((Map)localObject).put("errCode", Integer.valueOf(10004));
      paramf.callback(paramInt, a("fail:no service", a.c.rUG, (Map)localObject));
      h.fr(138, 144);
      AppMethodBeat.o(329665);
      return;
    }
    localObject = new JSONArray();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      e locale = (e)paramList.next();
      if (Util.isNullOrNil(locale.uuid)) {
        Log.e("MicroMsg.JsApiGetBLEDeviceServices", "get uuid is null");
      } else {
        try
        {
          if (locale.rNs == null)
          {
            locale.rNs = new JSONObject();
            locale.rNs.put("uuid", locale.uuid);
            locale.rNs.put("isPrimary", locale.rNy);
          }
          ((JSONArray)localObject).put(locale.rNs);
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
      paramList.put("services", localObject);
      paramList.put("errCode", 0);
      Log.i("MicroMsg.JsApiGetBLEDeviceServices", "retJson %s", new Object[] { paramList.toString() });
      paramf.callback(paramInt, a(null, a.e.rVt, paramList));
      h.rG(137);
      AppMethodBeat.o(329665);
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
  
  public final void a(final com.tencent.mm.plugin.appbrand.jsapi.f paramf, JSONObject paramJSONObject, final int paramInt)
  {
    AppMethodBeat.i(144499);
    h.rG(136);
    if (paramJSONObject == null)
    {
      Log.e("MicroMsg.JsApiGetBLEDeviceServices", "getBLEDeviceServices data is null");
      paramf.callback(paramInt, a("fail:invalid data", a.e.rVz, null));
      h.fr(138, 139);
      AppMethodBeat.o(144499);
      return;
    }
    final String str1 = paramf.getAppId();
    Log.i("MicroMsg.JsApiGetBLEDeviceServices", "appId:%s getBLEDeviceServices data %s", new Object[] { str1, paramJSONObject.toString() });
    final com.tencent.mm.plugin.appbrand.jsapi.bluetooth.b localb = a.aan(paramf.getAppId());
    if (localb == null)
    {
      Log.e("MicroMsg.JsApiGetBLEDeviceServices", "bleWorker is null, may not open ble");
      paramJSONObject = new HashMap();
      paramJSONObject.put("errCode", Integer.valueOf(10000));
      paramf.callback(paramInt, a(a.c.rUE, paramJSONObject));
      h.fr(138, 141);
      AppMethodBeat.o(144499);
      return;
    }
    if (!com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.c.cru())
    {
      Log.e("MicroMsg.JsApiGetBLEDeviceServices", "adapter is null or not enabled!");
      paramJSONObject = new HashMap();
      paramJSONObject.put("errCode", Integer.valueOf(10001));
      paramf.callback(paramInt, a("fail:not available", a.c.rUF, paramJSONObject));
      h.fr(138, 145);
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
        public final void onResult(k paramAnonymousk)
        {
          AppMethodBeat.i(329678);
          Log.i("MicroMsg.JsApiGetBLEDeviceServices", "appId:%s getBLEDeviceServices result:%s", new Object[] { str1, paramAnonymousk });
          switch (paramAnonymousk.errCode)
          {
          default: 
            HashMap localHashMap = new HashMap();
            localHashMap.put("errCode", Integer.valueOf(paramAnonymousk.errCode));
            paramf.callback(paramInt, f.this.a(paramAnonymousk.errMsg, paramAnonymousk.rKn, localHashMap));
            h.rG(138);
            AppMethodBeat.o(329678);
            return;
          }
          paramAnonymousk = localb.aB(str2, false);
          f.this.a(paramf, paramInt, paramAnonymousk);
          AppMethodBeat.o(329678);
        }
      });
      AppMethodBeat.o(144499);
      return;
    }
    a(paramf, paramInt, localb.aB(str2, true));
    AppMethodBeat.o(144499);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.a.f
 * JD-Core Version:    0.7.0.1
 */
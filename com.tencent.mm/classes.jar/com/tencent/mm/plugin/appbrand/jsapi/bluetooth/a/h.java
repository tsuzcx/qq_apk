package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.a;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.d;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.g.a.c;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class h
  extends com.tencent.mm.plugin.appbrand.jsapi.c
{
  private static final int CTRL_INDEX = 178;
  private static final String NAME = "getBluetoothDevices";
  
  public final void a(f paramf, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(144501);
    com.tencent.mm.plugin.appbrand.jsapi.bluetooth.h.rG(166);
    Object localObject3 = paramf.getAppId();
    if (paramJSONObject == null) {}
    com.tencent.mm.plugin.appbrand.jsapi.bluetooth.b localb;
    for (Object localObject1 = "";; localObject1 = paramJSONObject)
    {
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.JsApiGetBluetoothDevices", "appId:%s getBluetoothDevices data:%s", new Object[] { localObject3, localObject1 });
      localb = a.aan((String)localObject3);
      if (localb != null) {
        break;
      }
      com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.JsApiGetBluetoothDevices", "bleWorker is null, may not open ble");
      paramJSONObject = new HashMap();
      paramJSONObject.put("errCode", Integer.valueOf(10000));
      paramf.callback(paramInt, a(a.c.rUE, paramJSONObject));
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.h.fr(168, 170);
      AppMethodBeat.o(144501);
      return;
    }
    if (!com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.c.cru())
    {
      com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.JsApiGetBluetoothDevices", "adapter is null or not enabled!");
      paramJSONObject = new HashMap();
      paramJSONObject.put("errCode", Integer.valueOf(10001));
      paramf.callback(paramInt, a("fail:not available", a.c.rUF, paramJSONObject));
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.h.fr(168, 172);
      AppMethodBeat.o(144501);
      return;
    }
    localObject1 = localb.cqF();
    JSONArray localJSONArray;
    if (localObject1 != null)
    {
      localObject1 = ((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.b)localObject1).rMs.crl();
      localObject3 = new JSONObject();
      localJSONArray = new JSONArray();
      if (localObject1 == null) {
        break label348;
      }
      if (paramJSONObject == null) {
        break label450;
      }
    }
    label450:
    for (boolean bool = paramJSONObject.optBoolean("useOldImpl", false);; bool = false)
    {
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.JsApiGetBluetoothDevices", "useOldImpl: ".concat(String.valueOf(bool)));
      ((List)localObject1).addAll(localb.jd(bool));
      paramJSONObject = ((List)localObject1).iterator();
      for (;;)
      {
        if (paramJSONObject.hasNext())
        {
          localObject1 = (d)paramJSONObject.next();
          try
          {
            localJSONArray.put(((d)localObject1).cqc());
          }
          catch (JSONException localJSONException)
          {
            com.tencent.mm.sdk.platformtools.Log.printErrStackTrace("MicroMsg.JsApiGetBluetoothDevices", localJSONException, "", new Object[0]);
          }
          continue;
          Object localObject2 = null;
          break;
        }
      }
      try
      {
        label348:
        ((JSONObject)localObject3).put("errMsg", getName() + ":ok");
        ((JSONObject)localObject3).put("devices", localJSONArray);
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.JsApiGetBluetoothDevices", "retJson %s", new Object[] { localObject3 });
        paramf.callback(paramInt, ((JSONObject)localObject3).toString());
        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.h.rG(167);
        AppMethodBeat.o(144501);
        return;
      }
      catch (JSONException paramJSONObject)
      {
        for (;;)
        {
          com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.JsApiGetBluetoothDevices", "put json value error : %s", new Object[] { android.util.Log.getStackTraceString(paramJSONObject) });
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.a.h
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.a;

import android.annotation.TargetApi;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@TargetApi(18)
public final class h
  extends com.tencent.mm.plugin.appbrand.jsapi.d
{
  private static final int CTRL_INDEX = 178;
  private static final String NAME = "getBluetoothDevices";
  
  public final void a(f paramf, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(144501);
    com.tencent.mm.plugin.appbrand.jsapi.bluetooth.c.pl(166);
    Object localObject3 = paramf.getAppId();
    if (paramJSONObject == null) {}
    com.tencent.mm.plugin.appbrand.jsapi.bluetooth.b localb;
    for (Object localObject1 = "";; localObject1 = paramJSONObject)
    {
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.JsApiGetBluetoothDevices", "appId:%s getBluetoothDevices data:%s", new Object[] { localObject3, localObject1 });
      localb = com.tencent.mm.plugin.appbrand.jsapi.bluetooth.a.ZC((String)localObject3);
      if (localb != null) {
        break;
      }
      com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.JsApiGetBluetoothDevices", "bleWorker is null, may not open ble");
      paramJSONObject = new HashMap();
      paramJSONObject.put("errCode", Integer.valueOf(10000));
      paramf.i(paramInt, n("fail:not init", paramJSONObject));
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.c.dY(168, 170);
      AppMethodBeat.o(144501);
      return;
    }
    if (!com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.c.bFE())
    {
      com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.JsApiGetBluetoothDevices", "adapter is null or not enabled!");
      paramJSONObject = new HashMap();
      paramJSONObject.put("errCode", Integer.valueOf(10001));
      paramf.i(paramInt, n("fail:not available", paramJSONObject));
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.c.dY(168, 172);
      AppMethodBeat.o(144501);
      return;
    }
    localObject1 = localb.bFg();
    JSONArray localJSONArray;
    if (localObject1 != null)
    {
      localObject1 = ((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.b)localObject1).lMs.bFw();
      localObject3 = new JSONObject();
      localJSONArray = new JSONArray();
      if (localObject1 == null) {
        break label344;
      }
      if (paramJSONObject == null) {
        break label446;
      }
    }
    label446:
    for (boolean bool = paramJSONObject.optBoolean("useOldImpl", false);; bool = false)
    {
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.JsApiGetBluetoothDevices", "useOldImpl: ".concat(String.valueOf(bool)));
      ((List)localObject1).addAll(localb.hn(bool));
      paramJSONObject = ((List)localObject1).iterator();
      for (;;)
      {
        if (paramJSONObject.hasNext())
        {
          localObject1 = (com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.d)paramJSONObject.next();
          try
          {
            localJSONArray.put(((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.d)localObject1).bEw());
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
        label344:
        ((JSONObject)localObject3).put("errMsg", getName() + ":ok");
        ((JSONObject)localObject3).put("devices", localJSONArray);
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.JsApiGetBluetoothDevices", "retJson %s", new Object[] { localObject3 });
        paramf.i(paramInt, ((JSONObject)localObject3).toString());
        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.c.pl(167);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.a.h
 * JD-Core Version:    0.7.0.1
 */
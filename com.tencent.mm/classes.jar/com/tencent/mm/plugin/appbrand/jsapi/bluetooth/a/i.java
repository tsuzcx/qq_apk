package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.a;

import android.annotation.TargetApi;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.a;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.b;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.d;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.jsapi.o;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@TargetApi(18)
public final class i
  extends com.tencent.mm.plugin.appbrand.jsapi.c
{
  private static final int CTRL_INDEX = 179;
  private static final String NAME = "getConnectedBluetoothDevices";
  
  public final void a(e parame, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(144502);
    com.tencent.mm.plugin.appbrand.jsapi.bluetooth.c.rE(191);
    Log.i("MicroMsg.JsApiGetConnectedBluetoothDevices", "getConnectedBluetoothDevices!");
    Log.i("MicroMsg.JsApiGetConnectedBluetoothDevices", "appId:%s getConnectedBluetoothDevices data %s", new Object[] { parame.getAppId(), paramJSONObject.toString() });
    Object localObject3 = a.ahq(parame.getAppId());
    if (localObject3 == null)
    {
      Log.e("MicroMsg.JsApiGetConnectedBluetoothDevices", "bleWorker is null, may not open ble");
      paramJSONObject = new HashMap();
      paramJSONObject.put("errCode", Integer.valueOf(10000));
      parame.j(paramInt, m("fail:not init", paramJSONObject));
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.c.ex(193, 195);
      AppMethodBeat.o(144502);
      return;
    }
    if (!com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.c.bRm())
    {
      Log.e("MicroMsg.JsApiGetConnectedBluetoothDevices", "adapter is null or not enabled!");
      paramJSONObject = new HashMap();
      paramJSONObject.put("errCode", Integer.valueOf(10001));
      parame.j(paramInt, m("fail:not available", paramJSONObject));
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.c.ex(193, 197);
      AppMethodBeat.o(144502);
      return;
    }
    Object localObject4 = paramJSONObject.optJSONArray("services");
    Object localObject2;
    if (localObject4 != null)
    {
      int j = ((JSONArray)localObject4).length();
      localObject2 = new ArrayList(j);
      int i = 0;
      for (;;)
      {
        localObject1 = localObject2;
        if (i >= j) {
          break;
        }
        localObject1 = ((JSONArray)localObject4).optString(i);
        if (localObject1 != null) {
          ((List)localObject2).add(localObject1);
        }
        i += 1;
      }
    }
    Object localObject1 = null;
    boolean bool = paramJSONObject.optBoolean("useOldImpl", false);
    Log.i("MicroMsg.JsApiGetConnectedBluetoothDevices", "useOldImpl: ".concat(String.valueOf(bool)));
    localObject1 = ((b)localObject3).a((List)localObject1, bool);
    if (localObject1 == null)
    {
      Log.e("MicroMsg.JsApiGetConnectedBluetoothDevices", "bluetoothDevices is empty!");
      parame.j(paramInt, h("fail:internal error", null));
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.c.ex(193, 198);
      AppMethodBeat.o(144502);
      return;
    }
    paramJSONObject = new JSONArray();
    localObject1 = ((List)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject3 = (d)((Iterator)localObject1).next();
      localObject2 = ((d)localObject3).fzB;
      localObject3 = ((d)localObject3).name;
      localObject4 = new JSONObject();
      try
      {
        ((JSONObject)localObject4).put("deviceId", localObject2);
        ((JSONObject)localObject4).put("name", localObject3);
        paramJSONObject.put(localObject4);
      }
      catch (JSONException localJSONException)
      {
        Log.e("MicroMsg.JsApiGetConnectedBluetoothDevices", "put JSON data error : %s", new Object[] { localJSONException });
      }
    }
    localObject1 = new JSONObject();
    try
    {
      ((JSONObject)localObject1).put("errMsg", getName() + ":ok");
      ((JSONObject)localObject1).put("devices", paramJSONObject);
      Log.i("MicroMsg.JsApiGetConnectedBluetoothDevices", "retJson %s", new Object[] { ((JSONObject)localObject1).toString() });
      parame.j(paramInt, ((JSONObject)localObject1).toString());
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.c.rE(192);
      AppMethodBeat.o(144502);
      return;
    }
    catch (JSONException paramJSONObject)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.JsApiGetConnectedBluetoothDevices", paramJSONObject, "", new Object[0]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.a.i
 * JD-Core Version:    0.7.0.1
 */
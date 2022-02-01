package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.a;

import android.annotation.TargetApi;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.b;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.d;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.sdk.platformtools.ad;
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
  extends com.tencent.mm.plugin.appbrand.jsapi.a
{
  private static final int CTRL_INDEX = 179;
  private static final String NAME = "getConnectedBluetoothDevices";
  
  public final void a(com.tencent.mm.plugin.appbrand.jsapi.c paramc, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(144502);
    com.tencent.mm.plugin.appbrand.jsapi.bluetooth.c.ma(191);
    ad.i("MicroMsg.JsApiGetConnectedBluetoothDevices", "getConnectedBluetoothDevices!");
    ad.i("MicroMsg.JsApiGetConnectedBluetoothDevices", "appId:%s getConnectedBluetoothDevices data %s", new Object[] { paramc.getAppId(), paramJSONObject.toString() });
    Object localObject2 = com.tencent.mm.plugin.appbrand.jsapi.bluetooth.a.Pt(paramc.getAppId());
    if (localObject2 == null)
    {
      ad.e("MicroMsg.JsApiGetConnectedBluetoothDevices", "bleWorker is null, may not open ble");
      paramJSONObject = new HashMap();
      paramJSONObject.put("errCode", Integer.valueOf(10000));
      paramc.h(paramInt, m("fail:not init", paramJSONObject));
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.c.dN(193, 195);
      AppMethodBeat.o(144502);
      return;
    }
    if (!com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.c.bjz())
    {
      ad.e("MicroMsg.JsApiGetConnectedBluetoothDevices", "adapter is null or not enabled!");
      paramJSONObject = new HashMap();
      paramJSONObject.put("errCode", Integer.valueOf(10001));
      paramc.h(paramInt, m("fail:not available", paramJSONObject));
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.c.dN(193, 197);
      AppMethodBeat.o(144502);
      return;
    }
    Object localObject3 = paramJSONObject.optJSONArray("services");
    if (localObject3 != null)
    {
      int j = ((JSONArray)localObject3).length();
      localObject1 = new ArrayList(j);
      int i = 0;
      for (;;)
      {
        paramJSONObject = (JSONObject)localObject1;
        if (i >= j) {
          break;
        }
        paramJSONObject = ((JSONArray)localObject3).optString(i);
        if (paramJSONObject != null) {
          ((List)localObject1).add(paramJSONObject);
        }
        i += 1;
      }
    }
    paramJSONObject = null;
    Object localObject1 = ((b)localObject2).bm(paramJSONObject);
    if (localObject1 == null)
    {
      ad.e("MicroMsg.JsApiGetConnectedBluetoothDevices", "bluetoothDevices is empty!");
      paramc.h(paramInt, e("fail:internal error", null));
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.c.dN(193, 198);
      AppMethodBeat.o(144502);
      return;
    }
    paramJSONObject = new JSONArray();
    localObject1 = ((List)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject3 = (d)((Iterator)localObject1).next();
      localObject2 = ((d)localObject3).cUi;
      localObject3 = ((d)localObject3).name;
      JSONObject localJSONObject = new JSONObject();
      try
      {
        localJSONObject.put("deviceId", localObject2);
        localJSONObject.put("name", localObject3);
        paramJSONObject.put(localJSONObject);
      }
      catch (JSONException localJSONException)
      {
        ad.e("MicroMsg.JsApiGetConnectedBluetoothDevices", "put JSON data error : %s", new Object[] { localJSONException });
      }
    }
    localObject1 = new JSONObject();
    try
    {
      ((JSONObject)localObject1).put("errMsg", getName() + ":ok");
      ((JSONObject)localObject1).put("devices", paramJSONObject);
      ad.i("MicroMsg.JsApiGetConnectedBluetoothDevices", "retJson %s", new Object[] { ((JSONObject)localObject1).toString() });
      paramc.h(paramInt, ((JSONObject)localObject1).toString());
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.c.ma(192);
      AppMethodBeat.o(144502);
      return;
    }
    catch (JSONException paramJSONObject)
    {
      for (;;)
      {
        ad.printErrStackTrace("MicroMsg.JsApiGetConnectedBluetoothDevices", paramJSONObject, "", new Object[0]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.a.i
 * JD-Core Version:    0.7.0.1
 */
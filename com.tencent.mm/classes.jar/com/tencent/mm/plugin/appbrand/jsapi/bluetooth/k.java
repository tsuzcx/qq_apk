package com.tencent.mm.plugin.appbrand.jsapi.bluetooth;

import android.annotation.TargetApi;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.d;
import com.tencent.mm.plugin.appbrand.jsapi.i;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@TargetApi(18)
public final class k
  extends com.tencent.mm.plugin.appbrand.jsapi.a
{
  private static final int CTRL_INDEX = 179;
  private static final String NAME = "getConnectedBluetoothDevices";
  
  public final void a(com.tencent.mm.plugin.appbrand.jsapi.c paramc, JSONObject paramJSONObject, int paramInt)
  {
    c.jdMethod_if(191);
    y.i("MicroMsg.JsApiGetConnectedBluetoothDevices", "getConnectedBluetoothDevices!");
    y.i("MicroMsg.JsApiGetConnectedBluetoothDevices", "appId:%s getBLEDeviceCharacteristics data %s", new Object[] { paramc.getAppId(), paramJSONObject.toString() });
    paramJSONObject = a.tV(paramc.getAppId());
    if (paramJSONObject == null)
    {
      y.e("MicroMsg.JsApiGetConnectedBluetoothDevices", "bleWorker is null, may not open ble");
      paramJSONObject = new HashMap();
      paramJSONObject.put("errCode", Integer.valueOf(10000));
      paramc.C(paramInt, h("fail:not init", paramJSONObject));
      c.bU(193, 195);
      return;
    }
    if (!com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.b.aiB())
    {
      y.e("MicroMsg.JsApiGetConnectedBluetoothDevices", "adapter is null or not enabled!");
      paramJSONObject = new HashMap();
      paramJSONObject.put("errCode", Integer.valueOf(10001));
      paramc.C(paramInt, h("fail:not available", paramJSONObject));
      c.bU(193, 197);
      return;
    }
    Object localObject1 = paramJSONObject.air();
    if (localObject1 == null)
    {
      y.e("MicroMsg.JsApiGetConnectedBluetoothDevices", "bluetoothDevices is empty!");
      paramc.C(paramInt, h("fail:internal error", null));
      c.bU(193, 198);
      return;
    }
    paramJSONObject = new JSONArray();
    localObject1 = ((List)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = (d)((Iterator)localObject1).next();
      String str = ((d)localObject2).bwK;
      localObject2 = ((d)localObject2).name;
      JSONObject localJSONObject = new JSONObject();
      try
      {
        localJSONObject.put("deviceId", str);
        localJSONObject.put("name", localObject2);
        paramJSONObject.put(localJSONObject);
      }
      catch (JSONException localJSONException)
      {
        y.e("MicroMsg.JsApiGetConnectedBluetoothDevices", "put JSON data error : %s", new Object[] { localJSONException });
      }
    }
    localObject1 = new JSONObject();
    try
    {
      ((JSONObject)localObject1).put("errMsg", getName() + ":ok");
      ((JSONObject)localObject1).put("devices", paramJSONObject);
      y.i("MicroMsg.JsApiGetConnectedBluetoothDevices", "retJson %s", new Object[] { ((JSONObject)localObject1).toString() });
      paramc.C(paramInt, ((JSONObject)localObject1).toString());
      c.jdMethod_if(192);
      return;
    }
    catch (JSONException paramJSONObject)
    {
      for (;;)
      {
        y.printErrStackTrace("MicroMsg.JsApiGetConnectedBluetoothDevices", paramJSONObject, "", new Object[0]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.k
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.appbrand.jsapi.bluetooth;

import android.annotation.TargetApi;
import android.os.ParcelUuid;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.a;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.i;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.scan.ScanFilterCompat.a;
import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

@TargetApi(18)
public final class o
  extends com.tencent.mm.plugin.appbrand.jsapi.a
{
  private static final int CTRL_INDEX = 176;
  private static final String NAME = "startBluetoothDevicesDiscovery";
  
  public final void a(com.tencent.mm.plugin.appbrand.jsapi.c paramc, JSONObject paramJSONObject, int paramInt)
  {
    c.jdMethod_if(11);
    if (paramJSONObject == null)
    {
      y.e("MicroMsg.JsApiStartBluetoothDevicesDiscovery", "startBluetoothDevicesDiscovery data is null");
      paramJSONObject = new HashMap();
      paramJSONObject.put("errCode", Integer.valueOf(10013));
      paramc.C(paramInt, h("fail:invalid data", paramJSONObject));
      c.bU(13, 14);
      return;
    }
    y.i("MicroMsg.JsApiStartBluetoothDevicesDiscovery", "appId:%s startBluetoothDevicesDiscovery data:%s", new Object[] { paramc.getAppId(), paramJSONObject });
    Object localObject3 = a.tV(paramc.getAppId());
    if (localObject3 == null)
    {
      y.e("MicroMsg.JsApiStartBluetoothDevicesDiscovery", "bleWorker is null, may not open ble");
      paramJSONObject = new HashMap();
      paramJSONObject.put("errCode", Integer.valueOf(10000));
      paramc.C(paramInt, h("fail:not init", paramJSONObject));
      c.bU(13, 16);
      return;
    }
    if (!com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.b.aiB())
    {
      y.e("MicroMsg.JsApiStartBluetoothDevicesDiscovery", "adapter is null or not enabled!");
      paramJSONObject = new HashMap();
      paramJSONObject.put("errCode", Integer.valueOf(10001));
      paramc.C(paramInt, h("fail:not available", paramJSONObject));
      c.bU(13, 18);
      return;
    }
    if (!com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.b.aiB())
    {
      y.e("MicroMsg.JsApiStartBluetoothDevicesDiscovery", "adapter is null or not enabled!");
      paramJSONObject = new HashMap();
      paramJSONObject.put("errCode", Integer.valueOf(10001));
      paramc.C(paramInt, h("fail:not available", paramJSONObject));
      c.bU(13, 18);
      return;
    }
    boolean bool = paramJSONObject.optBoolean("allowDuplicatesKey");
    int j = paramJSONObject.optInt("interval");
    String str = paramJSONObject.optString("", "middle");
    Object localObject1 = null;
    if (paramJSONObject.has("services"))
    {
      localObject2 = new ArrayList();
      try
      {
        paramJSONObject = new JSONArray(paramJSONObject.optString("services"));
        int i = 0;
        for (;;)
        {
          localObject1 = localObject2;
          if (i >= paramJSONObject.length()) {
            break;
          }
          localObject1 = ParcelUuid.fromString(paramJSONObject.getString(i).toUpperCase());
          ((List)localObject2).add(new ScanFilterCompat.a().a((ParcelUuid)localObject1).aix());
          i += 1;
        }
        paramJSONObject = new a.a();
      }
      catch (Exception paramJSONObject)
      {
        y.e("MicroMsg.JsApiStartBluetoothDevicesDiscovery", "get uuid error!");
        paramJSONObject = new HashMap();
        paramJSONObject.put("isDiscovering", Boolean.valueOf(false));
        paramJSONObject.put("errCode", Integer.valueOf(10004));
        paramc.C(paramInt, h("fail:no service", paramJSONObject));
        c.jdMethod_if(13);
        return;
      }
    }
    paramJSONObject.dDr = j;
    paramJSONObject.glO = bool;
    paramJSONObject.glX = str;
    paramJSONObject = paramJSONObject.ais();
    if (((b)localObject3).glx != null)
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i("MicroMsg.Ble.BleManager", "initBleConfig:%s", new Object[] { paramJSONObject });
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.a(paramJSONObject);
    }
    paramJSONObject = new o.1(this, paramc, paramInt);
    Object localObject2 = new o.2(this, paramc);
    if (((b)localObject3).glx != null)
    {
      localObject3 = ((b)localObject3).glx;
      if (((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.b)localObject3).gmc != null) {
        ((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.b)localObject3).gmc.a(paramJSONObject, (List)localObject1, (i)localObject2);
      }
    }
    m.c.a(paramc, true, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.o
 * JD-Core Version:    0.7.0.1
 */
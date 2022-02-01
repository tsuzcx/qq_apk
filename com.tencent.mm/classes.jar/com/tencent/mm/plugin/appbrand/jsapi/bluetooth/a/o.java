package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.a;

import android.annotation.TargetApi;
import android.os.ParcelUuid;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.a;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.i;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.scan.ScanFilterCompat.a;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

@TargetApi(18)
public final class o
  extends com.tencent.mm.plugin.appbrand.jsapi.c
{
  private static final int CTRL_INDEX = 176;
  private static final String NAME = "startBluetoothDevicesDiscovery";
  
  public final void a(e parame, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(144524);
    com.tencent.mm.plugin.appbrand.jsapi.bluetooth.c.rE(11);
    if (paramJSONObject == null)
    {
      Log.e("MicroMsg.JsApiStartBluetoothDevicesDiscovery", "startBluetoothDevicesDiscovery data is null");
      paramJSONObject = new HashMap();
      paramJSONObject.put("errCode", Integer.valueOf(10013));
      parame.j(paramInt, m("fail:invalid data", paramJSONObject));
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.c.ex(13, 14);
      AppMethodBeat.o(144524);
      return;
    }
    Log.i("MicroMsg.JsApiStartBluetoothDevicesDiscovery", "appId:%s startBluetoothDevicesDiscovery data:%s", new Object[] { parame.getAppId(), paramJSONObject });
    Object localObject3 = com.tencent.mm.plugin.appbrand.jsapi.bluetooth.a.ahq(parame.getAppId());
    if (localObject3 == null)
    {
      Log.e("MicroMsg.JsApiStartBluetoothDevicesDiscovery", "bleWorker is null, may not open ble");
      paramJSONObject = new HashMap();
      paramJSONObject.put("errCode", Integer.valueOf(10000));
      parame.j(paramInt, m("fail:not init", paramJSONObject));
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.c.ex(13, 16);
      AppMethodBeat.o(144524);
      return;
    }
    if (!com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.c.bRm())
    {
      Log.e("MicroMsg.JsApiStartBluetoothDevicesDiscovery", "adapter is null or not enabled!");
      paramJSONObject = new HashMap();
      paramJSONObject.put("errCode", Integer.valueOf(10001));
      parame.j(paramInt, m("fail:not available", paramJSONObject));
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.c.ex(13, 18);
      AppMethodBeat.o(144524);
      return;
    }
    if (!com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.c.bRm())
    {
      Log.e("MicroMsg.JsApiStartBluetoothDevicesDiscovery", "adapter is null or not enabled!");
      paramJSONObject = new HashMap();
      paramJSONObject.put("errCode", Integer.valueOf(10001));
      parame.j(paramInt, m("fail:not available", paramJSONObject));
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.c.ex(13, 18);
      AppMethodBeat.o(144524);
      return;
    }
    boolean bool1 = paramJSONObject.optBoolean("allowDuplicatesKey");
    int j = paramJSONObject.optInt("interval");
    String str = paramJSONObject.optString("powerLevel", "medium");
    boolean bool2 = paramJSONObject.optBoolean("customParsePacket", true);
    boolean bool3 = paramJSONObject.optBoolean("refreshCache", true);
    boolean bool4 = paramJSONObject.optBoolean("scanWorkaround", true);
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
          ((List)localObject2).add(new ScanFilterCompat.a().a((ParcelUuid)localObject1).bRe());
          i += 1;
        }
        paramJSONObject = new a.a();
      }
      catch (Exception paramJSONObject)
      {
        Log.e("MicroMsg.JsApiStartBluetoothDevicesDiscovery", "get uuid error!");
        paramJSONObject = new HashMap();
        paramJSONObject.put("isDiscovering", Boolean.FALSE);
        paramJSONObject.put("errCode", Integer.valueOf(10004));
        parame.j(paramInt, m("fail:no service", paramJSONObject));
        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.c.rE(13);
        AppMethodBeat.o(144524);
        return;
      }
    }
    paramJSONObject.interval = j;
    paramJSONObject.oIs = bool1;
    paramJSONObject.oIB = str;
    paramJSONObject.oIF = bool2;
    paramJSONObject.oID = bool3;
    paramJSONObject.oIG = bool4;
    paramJSONObject = paramJSONObject.bQR();
    if (((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.b)localObject3).bQK() != null)
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i("MicroMsg.Ble.BleManager", "initBleConfig:%s", new Object[] { paramJSONObject });
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.a(paramJSONObject);
    }
    paramJSONObject = new o.1(this, parame, paramInt);
    Object localObject2 = new o.2(this, parame);
    localObject3 = ((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.b)localObject3).bQK();
    if (localObject3 != null) {
      ((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.b)localObject3).oII.a(paramJSONObject, (List)localObject1, (i)localObject2);
    }
    l.c.a(parame, true, true);
    AppMethodBeat.o(144524);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.a.o
 * JD-Core Version:    0.7.0.1
 */
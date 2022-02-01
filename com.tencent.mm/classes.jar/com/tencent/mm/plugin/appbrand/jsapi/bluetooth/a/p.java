package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.a;

import android.os.ParcelUuid;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.h;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.a;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.j;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.k;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.scan.ScanFilterCompat.a;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.g.a.c;
import com.tencent.mm.plugin.appbrand.jsapi.g.a.e;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public final class p
  extends com.tencent.mm.plugin.appbrand.jsapi.c
{
  private static final int CTRL_INDEX = 176;
  private static final String NAME = "startBluetoothDevicesDiscovery";
  
  public final void a(final f paramf, JSONObject paramJSONObject, final int paramInt)
  {
    AppMethodBeat.i(144524);
    h.rG(11);
    if (paramJSONObject == null)
    {
      Log.e("MicroMsg.JsApiStartBluetoothDevicesDiscovery", "startBluetoothDevicesDiscovery data is null");
      paramJSONObject = new HashMap();
      paramJSONObject.put("errCode", Integer.valueOf(10013));
      paramf.callback(paramInt, a("fail:invalid data", a.e.rVz, paramJSONObject));
      h.fr(13, 14);
      AppMethodBeat.o(144524);
      return;
    }
    Log.i("MicroMsg.JsApiStartBluetoothDevicesDiscovery", "appId:%s startBluetoothDevicesDiscovery data:%s", new Object[] { paramf.getAppId(), paramJSONObject });
    Object localObject3 = com.tencent.mm.plugin.appbrand.jsapi.bluetooth.a.aan(paramf.getAppId());
    if (localObject3 == null)
    {
      Log.e("MicroMsg.JsApiStartBluetoothDevicesDiscovery", "bleWorker is null, may not open ble");
      paramJSONObject = new HashMap();
      paramJSONObject.put("errCode", Integer.valueOf(10000));
      paramf.callback(paramInt, a(a.c.rUE, paramJSONObject));
      h.fr(13, 16);
      AppMethodBeat.o(144524);
      return;
    }
    if (!com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.c.cru())
    {
      Log.e("MicroMsg.JsApiStartBluetoothDevicesDiscovery", "adapter is null or not enabled!");
      paramJSONObject = new HashMap();
      paramJSONObject.put("errCode", Integer.valueOf(10001));
      paramf.callback(paramInt, a("fail:not available", a.c.rUF, paramJSONObject));
      h.fr(13, 18);
      AppMethodBeat.o(144524);
      return;
    }
    boolean bool1 = paramJSONObject.optBoolean("allowDuplicatesKey");
    int j = paramJSONObject.optInt("interval");
    String str = paramJSONObject.optString("powerLevel", "medium");
    boolean bool2 = paramJSONObject.optBoolean("customParsePacket", true);
    boolean bool3 = paramJSONObject.optBoolean("refreshCache", com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.cqZ());
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
          ((List)localObject2).add(new ScanFilterCompat.a().a((ParcelUuid)localObject1).crm());
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
        paramf.callback(paramInt, a("fail:no service", a.e.rVz, paramJSONObject));
        h.rG(13);
        AppMethodBeat.o(144524);
        return;
      }
    }
    paramJSONObject.interval = j;
    paramJSONObject.rMb = bool1;
    paramJSONObject.rMk = str;
    paramJSONObject.rMo = bool2;
    paramJSONObject.rMm = bool3;
    paramJSONObject.rMp = bool4;
    paramJSONObject = paramJSONObject.cra();
    if (((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.b)localObject3).cqF() != null)
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i("MicroMsg.Ble.BleManager", "initBleConfig:%s", new Object[] { paramJSONObject });
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.a(paramJSONObject);
    }
    paramJSONObject = new com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.b()
    {
      public final void onResult(k paramAnonymousk)
      {
        AppMethodBeat.i(144518);
        Log.i("MicroMsg.JsApiStartBluetoothDevicesDiscovery", "[onScanResult]result:%s", new Object[] { paramAnonymousk });
        switch (paramAnonymousk.errCode)
        {
        default: 
          HashMap localHashMap = new HashMap();
          localHashMap.put("errCode", Integer.valueOf(paramAnonymousk.errCode));
          localHashMap.put("isDiscovering", Boolean.FALSE);
          paramf.callback(paramInt, p.this.a(paramAnonymousk.errMsg, paramAnonymousk.rKn, localHashMap));
          h.rG(13);
          AppMethodBeat.o(144518);
          return;
        }
        paramAnonymousk = new HashMap();
        paramAnonymousk.put("errCode", Integer.valueOf(0));
        paramAnonymousk.put("isDiscovering", Boolean.TRUE);
        paramf.callback(paramInt, p.this.a(null, a.e.rVt, paramAnonymousk));
        h.rG(12);
        AppMethodBeat.o(144518);
      }
    };
    Object localObject2 = new p.2(this, paramf);
    localObject3 = ((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.b)localObject3).cqF();
    if (localObject3 != null) {
      ((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.b)localObject3).rMs.a(paramJSONObject, (List)localObject1, (j)localObject2);
    }
    m.d.a(paramf, true, true);
    AppMethodBeat.o(144524);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.a.p
 * JD-Core Version:    0.7.0.1
 */
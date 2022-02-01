package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.a;

import android.annotation.TargetApi;
import android.util.Log;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.d;
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
public final class h
  extends com.tencent.mm.plugin.appbrand.jsapi.a
{
  private static final int CTRL_INDEX = 178;
  private static final String NAME = "getBluetoothDevices";
  
  public final void a(com.tencent.mm.plugin.appbrand.jsapi.c paramc, JSONObject paramJSONObject, int paramInt)
  {
    JSONArray localJSONArray = null;
    AppMethodBeat.i(144501);
    com.tencent.mm.plugin.appbrand.jsapi.bluetooth.c.ma(166);
    Object localObject2 = paramc.getAppId();
    Object localObject1 = paramJSONObject;
    if (paramJSONObject == null) {
      localObject1 = "";
    }
    ad.i("MicroMsg.JsApiGetBluetoothDevices", "appId:%s getBluetoothDevices data:%s", new Object[] { localObject2, localObject1 });
    localObject2 = com.tencent.mm.plugin.appbrand.jsapi.bluetooth.a.Pt((String)localObject2);
    if (localObject2 == null)
    {
      ad.e("MicroMsg.JsApiGetBluetoothDevices", "bleWorker is null, may not open ble");
      paramJSONObject = new HashMap();
      paramJSONObject.put("errCode", Integer.valueOf(10000));
      paramc.h(paramInt, m("fail:not init", paramJSONObject));
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.c.dN(168, 170);
      AppMethodBeat.o(144501);
      return;
    }
    if (!com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.c.bjz())
    {
      ad.e("MicroMsg.JsApiGetBluetoothDevices", "adapter is null or not enabled!");
      paramJSONObject = new HashMap();
      paramJSONObject.put("errCode", Integer.valueOf(10001));
      paramc.h(paramInt, m("fail:not available", paramJSONObject));
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.c.dN(168, 172);
      AppMethodBeat.o(144501);
      return;
    }
    paramJSONObject = localJSONArray;
    if (((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.b)localObject2).kCW != null)
    {
      localObject1 = ((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.b)localObject2).kCW;
      paramJSONObject = localJSONArray;
      if (((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.b)localObject1).kEB != null) {
        paramJSONObject = new ArrayList(((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.b)localObject1).kEB.kcN.values());
      }
    }
    localObject1 = new JSONObject();
    localJSONArray = new JSONArray();
    if (paramJSONObject != null)
    {
      paramJSONObject.addAll(((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.b)localObject2).bjg());
      paramJSONObject = paramJSONObject.iterator();
      while (paramJSONObject.hasNext())
      {
        localObject2 = (d)paramJSONObject.next();
        try
        {
          localJSONArray.put(((d)localObject2).biz());
        }
        catch (JSONException localJSONException)
        {
          ad.printErrStackTrace("MicroMsg.JsApiGetBluetoothDevices", localJSONException, "", new Object[0]);
        }
      }
    }
    try
    {
      ((JSONObject)localObject1).put("errMsg", getName() + ":ok");
      ((JSONObject)localObject1).put("devices", localJSONArray);
      ad.i("MicroMsg.JsApiGetBluetoothDevices", "retJson %s", new Object[] { localObject1 });
      paramc.h(paramInt, ((JSONObject)localObject1).toString());
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.c.ma(167);
      AppMethodBeat.o(144501);
      return;
    }
    catch (JSONException paramJSONObject)
    {
      for (;;)
      {
        ad.e("MicroMsg.JsApiGetBluetoothDevices", "put json value error : %s", new Object[] { Log.getStackTraceString(paramJSONObject) });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.a.h
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.appbrand.jsapi.bluetooth;

import android.annotation.TargetApi;
import android.util.Log;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.d;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@TargetApi(18)
public final class j
  extends com.tencent.mm.plugin.appbrand.jsapi.a
{
  private static final int CTRL_INDEX = 178;
  private static final String NAME = "getBluetoothDevices";
  
  public final void a(com.tencent.mm.plugin.appbrand.jsapi.c paramc, JSONObject paramJSONObject, int paramInt)
  {
    JSONArray localJSONArray = null;
    AppMethodBeat.i(94189);
    c.kS(166);
    Object localObject2 = paramc.getAppId();
    Object localObject1 = paramJSONObject;
    if (paramJSONObject == null) {
      localObject1 = "";
    }
    ab.i("MicroMsg.JsApiGetBluetoothDevices", "appId:%s getBluetoothDevices data:%s", new Object[] { localObject2, localObject1 });
    localObject2 = a.BU((String)localObject2);
    if (localObject2 == null)
    {
      ab.e("MicroMsg.JsApiGetBluetoothDevices", "bleWorker is null, may not open ble");
      paramJSONObject = new HashMap();
      paramJSONObject.put("errCode", Integer.valueOf(10000));
      paramc.h(paramInt, j("fail:not init", paramJSONObject));
      c.df(168, 170);
      AppMethodBeat.o(94189);
      return;
    }
    if (!com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.b.aCw())
    {
      ab.e("MicroMsg.JsApiGetBluetoothDevices", "adapter is null or not enabled!");
      paramJSONObject = new HashMap();
      paramJSONObject.put("errCode", Integer.valueOf(10001));
      paramc.h(paramInt, j("fail:not available", paramJSONObject));
      c.df(168, 172);
      AppMethodBeat.o(94189);
      return;
    }
    paramJSONObject = localJSONArray;
    if (((b)localObject2).hFw != null)
    {
      localObject1 = ((b)localObject2).hFw;
      paramJSONObject = localJSONArray;
      if (((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.b)localObject1).hGb != null) {
        paramJSONObject = new ArrayList(((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.b)localObject1).hGb.hHi.values());
      }
    }
    localObject1 = new JSONObject();
    localJSONArray = new JSONArray();
    if (paramJSONObject != null)
    {
      paramJSONObject.addAll(((b)localObject2).aCl());
      paramJSONObject = paramJSONObject.iterator();
      while (paramJSONObject.hasNext())
      {
        localObject2 = (d)paramJSONObject.next();
        try
        {
          localJSONArray.put(((d)localObject2).aBI());
        }
        catch (JSONException localJSONException)
        {
          ab.printErrStackTrace("MicroMsg.JsApiGetBluetoothDevices", localJSONException, "", new Object[0]);
        }
      }
    }
    try
    {
      ((JSONObject)localObject1).put("errMsg", getName() + ":ok");
      ((JSONObject)localObject1).put("devices", localJSONArray);
      ab.i("MicroMsg.JsApiGetBluetoothDevices", "retJson %s", new Object[] { localObject1 });
      paramc.h(paramInt, ((JSONObject)localObject1).toString());
      c.kS(167);
      AppMethodBeat.o(94189);
      return;
    }
    catch (JSONException paramJSONObject)
    {
      for (;;)
      {
        ab.e("MicroMsg.JsApiGetBluetoothDevices", "put json value error : %s", new Object[] { Log.getStackTraceString(paramJSONObject) });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.j
 * JD-Core Version:    0.7.0.1
 */
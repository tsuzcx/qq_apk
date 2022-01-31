package com.tencent.mm.plugin.appbrand.jsapi.c;

import android.annotation.TargetApi;
import com.tencent.mm.plugin.appbrand.jsapi.ac;
import com.tencent.mm.plugin.appbrand.jsapi.i;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

@TargetApi(18)
public final class d
  extends com.tencent.mm.plugin.appbrand.jsapi.a
{
  private static final int CTRL_INDEX = 222;
  private static final String NAME = "stopBeaconDiscovery";
  
  public final void a(com.tencent.mm.plugin.appbrand.jsapi.c paramc, JSONObject paramJSONObject, int paramInt)
  {
    com.tencent.luggage.j.c.i("MicroMsg.JsApiStopBeaconDiscovery", "stopBeaconDiscovery!");
    paramJSONObject = a.ub(paramc.getAppId());
    if (paramJSONObject == null)
    {
      com.tencent.luggage.j.c.e("MicroMsg.JsApiStopBeaconDiscovery", "beaconWorker is null");
      paramJSONObject = new HashMap();
      paramJSONObject.put("errCode", Integer.valueOf(11004));
      paramc.C(paramInt, h("fail:not start", paramJSONObject));
      return;
    }
    if (paramJSONObject.un())
    {
      a.remove(paramc.getAppId());
      new HashMap().put("errCode", Integer.valueOf(0));
      paramc.C(paramInt, h("ok", null));
    }
    for (;;)
    {
      paramJSONObject = new d.a((byte)0);
      JSONObject localJSONObject = new JSONObject();
      try
      {
        localJSONObject.put("available", a.glv);
        localJSONObject.put("discovering", false);
        com.tencent.luggage.j.c.i("MicroMsg.JsApiStopBeaconDiscovery", "OnBeaconServiceChangedEvent %s", new Object[] { localJSONObject.toString() });
        paramJSONObject.b(paramc, paramc.ahJ()).tM(localJSONObject.toString()).dispatch();
        return;
        paramJSONObject = new HashMap();
        paramJSONObject.put("errCode", Integer.valueOf(11004));
        paramc.C(paramInt, h("fail:not start", paramJSONObject));
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          com.tencent.luggage.j.c.e("MicroMsg.JsApiStopBeaconDiscovery", "put JSON data error : %s", new Object[] { localJSONException });
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.c.d
 * JD-Core Version:    0.7.0.1
 */
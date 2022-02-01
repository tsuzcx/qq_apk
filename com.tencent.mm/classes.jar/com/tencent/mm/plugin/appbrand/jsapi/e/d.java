package com.tencent.mm.plugin.appbrand.jsapi.e;

import android.annotation.TargetApi;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.at;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.sdk.platformtools.ad;
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
  
  public final void a(c paramc, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(144681);
    ad.i("MicroMsg.JsApiStopBeaconDiscovery", "stopBeaconDiscovery!");
    paramJSONObject = a.PD(paramc.getAppId());
    if (paramJSONObject == null)
    {
      ad.e("MicroMsg.JsApiStopBeaconDiscovery", "beaconWorker is null");
      paramJSONObject = new HashMap();
      paramJSONObject.put("errCode", Integer.valueOf(11004));
      paramc.h(paramInt, m("fail:not start", paramJSONObject));
      AppMethodBeat.o(144681);
      return;
    }
    if (paramJSONObject.Gv())
    {
      a.remove(paramc.getAppId());
      new HashMap().put("errCode", Integer.valueOf(0));
      paramc.h(paramInt, e("ok", null));
    }
    for (;;)
    {
      paramJSONObject = new a((byte)0);
      JSONObject localJSONObject = new JSONObject();
      try
      {
        localJSONObject.put("available", a.kCU);
        localJSONObject.put("discovering", false);
        ad.i("MicroMsg.JsApiStopBeaconDiscovery", "OnBeaconServiceChangedEvent %s", new Object[] { localJSONObject.toString() });
        paramJSONObject.b(paramc, paramc.aXC()).Pi(localJSONObject.toString()).bir();
        AppMethodBeat.o(144681);
        return;
        paramJSONObject = new HashMap();
        paramJSONObject.put("errCode", Integer.valueOf(11004));
        paramc.h(paramInt, m("fail:not start", paramJSONObject));
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          ad.e("MicroMsg.JsApiStopBeaconDiscovery", "put JSON data error : %s", new Object[] { localJSONException });
        }
      }
    }
  }
  
  static final class a
    extends at
  {
    private static final int CTRL_INDEX = 225;
    private static final String NAME = "onBeaconServiceChanged";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.e.d
 * JD-Core Version:    0.7.0.1
 */
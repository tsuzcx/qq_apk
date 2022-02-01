package com.tencent.mm.plugin.appbrand.jsapi.g;

import android.annotation.TargetApi;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.bc;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

@TargetApi(18)
public final class d
  extends com.tencent.mm.plugin.appbrand.jsapi.d
{
  private static final int CTRL_INDEX = 222;
  private static final String NAME = "stopBeaconDiscovery";
  
  public final void a(f paramf, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(144681);
    Log.i("MicroMsg.JsApiStopBeaconDiscovery", "stopBeaconDiscovery!");
    paramJSONObject = a.ZM(paramf.getAppId());
    if (paramJSONObject == null)
    {
      Log.e("MicroMsg.JsApiStopBeaconDiscovery", "beaconWorker is null");
      paramJSONObject = new HashMap();
      paramJSONObject.put("errCode", Integer.valueOf(11004));
      paramf.i(paramInt, n("fail:not start", paramJSONObject));
      AppMethodBeat.o(144681);
      return;
    }
    if (paramJSONObject.Qt())
    {
      a.remove(paramf.getAppId());
      new HashMap().put("errCode", Integer.valueOf(0));
      paramf.i(paramInt, h("ok", null));
    }
    for (;;)
    {
      paramJSONObject = new a((byte)0);
      JSONObject localJSONObject = new JSONObject();
      try
      {
        localJSONObject.put("available", a.lKK);
        localJSONObject.put("discovering", false);
        Log.i("MicroMsg.JsApiStopBeaconDiscovery", "OnBeaconServiceChangedEvent %s", new Object[] { localJSONObject.toString() });
        paramJSONObject.b(paramf, paramf.getComponentId()).Zh(localJSONObject.toString()).bEo();
        AppMethodBeat.o(144681);
        return;
        paramJSONObject = new HashMap();
        paramJSONObject.put("errCode", Integer.valueOf(11004));
        paramf.i(paramInt, n("fail:not start", paramJSONObject));
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          Log.e("MicroMsg.JsApiStopBeaconDiscovery", "put JSON data error : %s", new Object[] { localJSONException });
        }
      }
    }
  }
  
  static final class a
    extends bc
  {
    private static final int CTRL_INDEX = 225;
    private static final String NAME = "onBeaconServiceChanged";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.g.d
 * JD-Core Version:    0.7.0.1
 */
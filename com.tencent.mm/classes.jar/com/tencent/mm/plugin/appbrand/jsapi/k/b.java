package com.tencent.mm.plugin.appbrand.jsapi.k;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public final class b
  extends c
{
  private static final int CTRL_INDEX = 223;
  private static final String NAME = "getBeacons";
  
  public final void a(f paramf, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(144674);
    Log.d("MicroMsg.JsApiGetBeacons", "getBeacons!");
    paramJSONObject = new JSONArray();
    Object localObject = a.aaz(paramf.getAppId());
    if (localObject != null)
    {
      localObject = ((a.a)localObject).rZj;
      Log.d("MicroMsg.JsApiGetBeacons", "getBeaconInfo, beaconInfos: ".concat(String.valueOf(localObject)));
      if ((localObject != null) && (((Map)localObject).size() > 0))
      {
        localObject = ((Map)localObject).values().iterator();
        while (((Iterator)localObject).hasNext()) {
          paramJSONObject.put((JSONObject)((Iterator)localObject).next());
        }
      }
    }
    else
    {
      Log.e("MicroMsg.JsApiGetBeacons", "not found device");
    }
    localObject = new HashMap();
    ((Map)localObject).put("beacons", paramJSONObject);
    paramf.callback(paramInt, m("ok", (Map)localObject));
    AppMethodBeat.o(144674);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.k.b
 * JD-Core Version:    0.7.0.1
 */
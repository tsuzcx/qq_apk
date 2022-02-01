package com.tencent.mm.plugin.appbrand.jsapi.ag.d.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.k.a.b.t;
import com.tencent.mm.plugin.appbrand.jsapi.k.a.b.z;
import com.tencent.mm.plugin.appbrand.jsapi.k.t.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import org.json.JSONException;
import org.json.JSONObject;

public final class b$5
  implements b.z
{
  public b$5(b paramb, int paramInt, f paramf) {}
  
  public final void a(b.t paramt)
  {
    AppMethodBeat.i(139547);
    t.g localg = new t.g();
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("mapId", this.lYe);
      localJSONObject.put("latitude", paramt.latitude);
      localJSONObject.put("longitude", paramt.longitude);
      localJSONObject.put("name", paramt.name);
      if (!Util.isNullOrNil(paramt.buildingId))
      {
        localJSONObject.put("buildingId", paramt.buildingId);
        localJSONObject.put("floorName", paramt.floorName);
      }
      localg.Zh(localJSONObject.toString());
      this.lBw.a(localg, null);
      Log.v("MicroMsg.JsApiInsertXWebMap", "OnMapPoiClick %s", new Object[] { localJSONObject.toString() });
      AppMethodBeat.o(139547);
      return;
    }
    catch (JSONException paramt)
    {
      for (;;)
      {
        Log.e("MicroMsg.JsApiInsertXWebMap", "put JSON data error : %s", new Object[] { paramt });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ag.d.a.b.5
 * JD-Core Version:    0.7.0.1
 */
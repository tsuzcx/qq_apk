package com.tencent.mm.plugin.appbrand.jsapi.aa.d.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.g.a.b.r;
import com.tencent.mm.plugin.appbrand.jsapi.g.a.b.x;
import com.tencent.mm.plugin.appbrand.jsapi.g.q.g;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import org.json.JSONException;
import org.json.JSONObject;

public final class b$5
  implements b.x
{
  public b$5(b paramb, int paramInt, c paramc) {}
  
  public final void a(b.r paramr)
  {
    AppMethodBeat.i(139547);
    q.g localg = new q.g();
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("mapId", this.jTj);
      localJSONObject.put("latitude", paramr.latitude);
      localJSONObject.put("longitude", paramr.longitude);
      localJSONObject.put("name", paramr.name);
      if (!bt.isNullOrNil(paramr.buildingId))
      {
        localJSONObject.put("buildingId", paramr.buildingId);
        localJSONObject.put("floorName", paramr.floorName);
      }
      localg.HK(localJSONObject.toString());
      this.jza.b(localg);
      ad.v("MicroMsg.JsApiInsertXWebMap", "OnMapPoiClick %s", new Object[] { localJSONObject.toString() });
      AppMethodBeat.o(139547);
      return;
    }
    catch (JSONException paramr)
    {
      for (;;)
      {
        ad.e("MicroMsg.JsApiInsertXWebMap", "put JSON data error : %s", new Object[] { paramr });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.aa.d.a.b.5
 * JD-Core Version:    0.7.0.1
 */
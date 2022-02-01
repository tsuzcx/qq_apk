package com.tencent.mm.plugin.appbrand.jsapi.ad.d.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.i.a.b.t;
import com.tencent.mm.plugin.appbrand.jsapi.i.a.b.z;
import com.tencent.mm.plugin.appbrand.jsapi.i.t.g;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import org.json.JSONException;
import org.json.JSONObject;

public final class b$5
  implements b.z
{
  public b$5(b paramb, int paramInt, c paramc) {}
  
  public final void a(b.t paramt)
  {
    AppMethodBeat.i(139547);
    t.g localg = new t.g();
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("mapId", this.kSZ);
      localJSONObject.put("latitude", paramt.latitude);
      localJSONObject.put("longitude", paramt.longitude);
      localJSONObject.put("name", paramt.name);
      if (!bu.isNullOrNil(paramt.buildingId))
      {
        localJSONObject.put("buildingId", paramt.buildingId);
        localJSONObject.put("floorName", paramt.floorName);
      }
      localg.PQ(localJSONObject.toString());
      this.kxj.b(localg);
      ae.v("MicroMsg.JsApiInsertXWebMap", "OnMapPoiClick %s", new Object[] { localJSONObject.toString() });
      AppMethodBeat.o(139547);
      return;
    }
    catch (JSONException paramt)
    {
      for (;;)
      {
        ae.e("MicroMsg.JsApiInsertXWebMap", "put JSON data error : %s", new Object[] { paramt });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ad.d.a.b.5
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.appbrand.jsapi.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.jsapi.g.a.b.p;
import com.tencent.mm.plugin.appbrand.jsapi.g.a.b.v;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import org.json.JSONException;
import org.json.JSONObject;

final class o$7
  implements b.v
{
  o$7(o paramo, int paramInt, e parame) {}
  
  public final void a(b.p paramp)
  {
    AppMethodBeat.i(93858);
    o.e locale = new o.e();
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("mapId", this.hEO);
      localJSONObject.put("latitude", paramp.latitude);
      localJSONObject.put("longitude", paramp.longitude);
      localJSONObject.put("name", paramp.name);
      if (!bo.isNullOrNil(paramp.buildingId))
      {
        localJSONObject.put("buildingId", paramp.buildingId);
        localJSONObject.put("floorName", paramp.floorName);
      }
      locale.BN(localJSONObject.toString());
      this.hNZ.b(locale);
      ab.v("MicroMsg.JsApiInsertMap", "OnMapPoiClick %s", new Object[] { localJSONObject.toString() });
      AppMethodBeat.o(93858);
      return;
    }
    catch (JSONException paramp)
    {
      for (;;)
      {
        ab.e("MicroMsg.JsApiInsertMap", "put JSON data error : %s", new Object[] { paramp });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.g.o.7
 * JD-Core Version:    0.7.0.1
 */
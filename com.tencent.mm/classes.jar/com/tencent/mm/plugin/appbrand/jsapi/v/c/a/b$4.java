package com.tencent.mm.plugin.appbrand.jsapi.v.c.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.g.a.b.p;
import com.tencent.mm.plugin.appbrand.jsapi.g.a.b.v;
import com.tencent.mm.plugin.appbrand.jsapi.g.o.e;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import org.json.JSONException;
import org.json.JSONObject;

public final class b$4
  implements b.v
{
  public b$4(b paramb, int paramInt, c paramc) {}
  
  public final void a(b.p paramp)
  {
    AppMethodBeat.i(155145);
    o.e locale = new o.e();
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("mapId", this.hNS);
      localJSONObject.put("latitude", paramp.latitude);
      localJSONObject.put("longitude", paramp.longitude);
      localJSONObject.put("name", paramp.name);
      if (!bo.isNullOrNil(paramp.buildingId))
      {
        localJSONObject.put("buildingId", paramp.buildingId);
        localJSONObject.put("floorName", paramp.floorName);
      }
      locale.BN(localJSONObject.toString());
      this.hza.b(locale);
      ab.v("MicroMsg.JsApiInsertXWebMap", "OnMapPoiClick %s", new Object[] { localJSONObject.toString() });
      AppMethodBeat.o(155145);
      return;
    }
    catch (JSONException paramp)
    {
      for (;;)
      {
        ab.e("MicroMsg.JsApiInsertXWebMap", "put JSON data error : %s", new Object[] { paramp });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.v.c.a.b.4
 * JD-Core Version:    0.7.0.1
 */
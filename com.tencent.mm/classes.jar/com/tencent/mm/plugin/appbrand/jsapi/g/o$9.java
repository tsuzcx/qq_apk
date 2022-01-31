package com.tencent.mm.plugin.appbrand.jsapi.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.jsapi.g.a.b.e;
import com.tencent.mm.plugin.appbrand.jsapi.g.a.b.f;
import com.tencent.mm.plugin.appbrand.jsapi.g.a.b.t;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

final class o$9
  implements b.t
{
  o$9(o paramo, int paramInt, e parame) {}
  
  public final void a(b.e parame)
  {
    AppMethodBeat.i(93862);
    o.c localc = new o.c();
    JSONObject localJSONObject1 = new JSONObject();
    JSONArray localJSONArray;
    try
    {
      localJSONObject1.put("mapId", this.hEO);
      if (parame != null)
      {
        localJSONObject1.put("buildingId", parame.buildingId);
        localJSONObject1.put("buildingName", parame.buildingName);
        if ((parame.hPg != null) && (parame.hPg.size() > 0))
        {
          localJSONArray = new JSONArray();
          Iterator localIterator = parame.hPg.iterator();
          while (localIterator.hasNext())
          {
            b.f localf = (b.f)localIterator.next();
            JSONObject localJSONObject2 = new JSONObject();
            localJSONObject2.put("name", localf.floorName);
            localJSONArray.put(localJSONObject2);
          }
        }
      }
      else
      {
        localc.BN(localJSONObject1.toString());
      }
    }
    catch (JSONException parame)
    {
      ab.e("MicroMsg.JsApiInsertMap", "put JSON data error : %s", new Object[] { parame });
    }
    for (;;)
    {
      this.hNZ.b(localc);
      ab.v("MicroMsg.JsApiInsertMap", "OnMapIndoorStateChange:%s", new Object[] { localJSONObject1.toString() });
      AppMethodBeat.o(93862);
      return;
      localJSONObject1.put("floorList", localJSONArray);
      localJSONObject1.put("floorIndex", parame.hPh);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.g.o.9
 * JD-Core Version:    0.7.0.1
 */
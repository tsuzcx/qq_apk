package com.tencent.mm.plugin.appbrand.jsapi.ad.d.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.i.a.b.f;
import com.tencent.mm.plugin.appbrand.jsapi.i.a.b.g;
import com.tencent.mm.plugin.appbrand.jsapi.i.a.b.x;
import com.tencent.mm.plugin.appbrand.jsapi.i.t.d;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class b$7
  implements b.x
{
  public b$7(b paramb, int paramInt, c paramc) {}
  
  public final void a(b.f paramf)
  {
    AppMethodBeat.i(139551);
    t.d locald = new t.d();
    JSONObject localJSONObject1 = new JSONObject();
    JSONArray localJSONArray;
    try
    {
      localJSONObject1.put("mapId", this.kSZ);
      if (paramf != null)
      {
        localJSONObject1.put("buildingId", paramf.buildingId);
        localJSONObject1.put("buildingName", paramf.buildingName);
        if ((paramf.kVr != null) && (paramf.kVr.size() > 0))
        {
          localJSONArray = new JSONArray();
          Iterator localIterator = paramf.kVr.iterator();
          while (localIterator.hasNext())
          {
            b.g localg = (b.g)localIterator.next();
            JSONObject localJSONObject2 = new JSONObject();
            localJSONObject2.put("name", localg.floorName);
            localJSONArray.put(localJSONObject2);
          }
        }
      }
      else
      {
        locald.PQ(localJSONObject1.toString());
      }
    }
    catch (JSONException paramf)
    {
      ae.e("MicroMsg.JsApiInsertXWebMap", "put JSON data error : %s", new Object[] { paramf });
    }
    for (;;)
    {
      this.kxj.b(locald);
      this.kxj.a(locald);
      ae.v("MicroMsg.JsApiInsertXWebMap", "OnMapIndoorStateChange:%s", new Object[] { localJSONObject1.toString() });
      AppMethodBeat.o(139551);
      return;
      localJSONObject1.put("floorList", localJSONArray);
      localJSONObject1.put("floorIndex", paramf.kVs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ad.d.a.b.7
 * JD-Core Version:    0.7.0.1
 */
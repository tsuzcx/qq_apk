package com.tencent.mm.plugin.appbrand.jsapi.aa.d.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.g.a.b.e;
import com.tencent.mm.plugin.appbrand.jsapi.g.a.b.f;
import com.tencent.mm.plugin.appbrand.jsapi.g.a.b.v;
import com.tencent.mm.plugin.appbrand.jsapi.g.q.d;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class b$7
  implements b.v
{
  public b$7(b paramb, int paramInt, c paramc) {}
  
  public final void a(b.e parame)
  {
    AppMethodBeat.i(139551);
    q.d locald = new q.d();
    JSONObject localJSONObject1 = new JSONObject();
    JSONArray localJSONArray;
    try
    {
      localJSONObject1.put("mapId", this.jTj);
      if (parame != null)
      {
        localJSONObject1.put("buildingId", parame.buildingId);
        localJSONObject1.put("buildingName", parame.buildingName);
        if ((parame.jUT != null) && (parame.jUT.size() > 0))
        {
          localJSONArray = new JSONArray();
          Iterator localIterator = parame.jUT.iterator();
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
        locald.HK(localJSONObject1.toString());
      }
    }
    catch (JSONException parame)
    {
      ad.e("MicroMsg.JsApiInsertXWebMap", "put JSON data error : %s", new Object[] { parame });
    }
    for (;;)
    {
      this.jza.b(locald);
      this.jza.a(locald);
      ad.v("MicroMsg.JsApiInsertXWebMap", "OnMapIndoorStateChange:%s", new Object[] { localJSONObject1.toString() });
      AppMethodBeat.o(139551);
      return;
      localJSONObject1.put("floorList", localJSONArray);
      localJSONObject1.put("floorIndex", parame.jUU);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.aa.d.a.b.7
 * JD-Core Version:    0.7.0.1
 */
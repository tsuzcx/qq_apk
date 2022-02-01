package com.tencent.mm.plugin.appbrand.jsapi.ag.d.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.k.a.b.f;
import com.tencent.mm.plugin.appbrand.jsapi.k.a.b.g;
import com.tencent.mm.plugin.appbrand.jsapi.k.a.b.x;
import com.tencent.mm.plugin.appbrand.jsapi.k.t.d;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class b$7
  implements b.x
{
  public b$7(b paramb, int paramInt, f paramf) {}
  
  public final void a(b.f paramf)
  {
    AppMethodBeat.i(139551);
    t.d locald = new t.d();
    JSONObject localJSONObject1 = new JSONObject();
    JSONArray localJSONArray;
    try
    {
      localJSONObject1.put("mapId", this.lYe);
      if (paramf != null)
      {
        localJSONObject1.put("buildingId", paramf.buildingId);
        localJSONObject1.put("buildingName", paramf.buildingName);
        if ((paramf.maA != null) && (paramf.maA.size() > 0))
        {
          localJSONArray = new JSONArray();
          Iterator localIterator = paramf.maA.iterator();
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
        locald.Zh(localJSONObject1.toString());
      }
    }
    catch (JSONException paramf)
    {
      Log.e("MicroMsg.JsApiInsertXWebMap", "put JSON data error : %s", new Object[] { paramf });
    }
    for (;;)
    {
      this.lBw.a(locald, null);
      this.lBw.a(locald);
      Log.v("MicroMsg.JsApiInsertXWebMap", "OnMapIndoorStateChange:%s", new Object[] { localJSONObject1.toString() });
      AppMethodBeat.o(139551);
      return;
      localJSONObject1.put("floorList", localJSONArray);
      localJSONObject1.put("floorIndex", paramf.maB);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ag.d.a.b.7
 * JD-Core Version:    0.7.0.1
 */
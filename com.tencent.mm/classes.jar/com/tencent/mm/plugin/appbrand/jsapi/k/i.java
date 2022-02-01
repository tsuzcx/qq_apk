package com.tencent.mm.plugin.appbrand.jsapi.k;

import android.graphics.Color;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ac.g;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.k.a.b.ab;
import com.tencent.mm.plugin.appbrand.jsapi.k.a.b.i;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class i
  extends b
{
  public static final int CTRL_INDEX = 492;
  public static final String NAME = "addMapPolygons";
  
  public final void a(f paramf, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(143662);
    super.a(paramf, paramJSONObject, paramInt);
    if (paramJSONObject == null)
    {
      Log.e("MicroMsg.JsApiAddMapPolygons", "data is null");
      paramf.i(paramInt, h("fail:invalid data", null));
      AppMethodBeat.o(143662);
      return;
    }
    Log.i("MicroMsg.JsApiAddMapPolygons", "data:%s", new Object[] { paramJSONObject });
    com.tencent.mm.plugin.appbrand.jsapi.k.a.b localb = h(paramf, paramJSONObject);
    if (localb == null)
    {
      Log.e("MicroMsg.JsApiAddMapPolygons", "mapView is null, return");
      paramf.i(paramInt, h("fail:mapview is null", null));
      AppMethodBeat.o(143662);
      return;
    }
    try
    {
      if (paramJSONObject.has("polygons"))
      {
        localb.bHe();
        paramJSONObject = new JSONArray(paramJSONObject.optString("polygons"));
        int i = 0;
        while (i < paramJSONObject.length())
        {
          JSONObject localJSONObject1 = (JSONObject)paramJSONObject.get(i);
          ArrayList localArrayList = new ArrayList();
          Object localObject = new JSONArray(localJSONObject1.optString("points"));
          int j = 0;
          while (j < ((JSONArray)localObject).length())
          {
            JSONObject localJSONObject2 = ((JSONArray)localObject).getJSONObject(j);
            localArrayList.add(new b.i(Util.getDouble(localJSONObject2.optString("latitude"), 0.0D), Util.getDouble(localJSONObject2.optString("longitude"), 0.0D)) {});
            j += 1;
          }
          j = g.cu(localJSONObject1.optString("fillColor", ""), Color.parseColor("#000000"));
          int k = g.cu(localJSONObject1.optString("strokeColor", ""), Color.parseColor("#000000"));
          int m = g.a(localJSONObject1, "strokeWidth", 0);
          int n = localJSONObject1.optInt("zIndex", 0);
          localObject = new b.ab();
          ((b.ab)localObject).maG = new ArrayList();
          ((b.ab)localObject).maG.addAll(localArrayList);
          ((b.ab)localObject).fillColor = j;
          ((b.ab)localObject).strokeWidth = m;
          ((b.ab)localObject).strokeColor = k;
          ((b.ab)localObject).zIndex = n;
          ((b.ab)localObject).mau = localJSONObject1.optString("level");
          localb.a((b.ab)localObject);
          i += 1;
        }
      }
      Log.e("MicroMsg.JsApiAddMapPolygons", "data has not lines info");
      a(paramf, paramInt, h("ok", null), true, localb.bGX());
      AppMethodBeat.o(143662);
      return;
    }
    catch (Exception paramJSONObject)
    {
      Log.e("MicroMsg.JsApiAddMapPolygons", "parse lines error, exception : %s", new Object[] { paramJSONObject });
      a(paramf, paramInt, h("fail:internal error", null), false, localb.bGX());
      AppMethodBeat.o(143662);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.k.i
 * JD-Core Version:    0.7.0.1
 */
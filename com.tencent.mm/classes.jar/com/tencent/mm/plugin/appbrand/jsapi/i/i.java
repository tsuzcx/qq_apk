package com.tencent.mm.plugin.appbrand.jsapi.i;

import android.graphics.Color;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.i.a.b.ab;
import com.tencent.mm.plugin.appbrand.jsapi.i.a.b.i;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.y.g;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class i
  extends b
{
  public static final int CTRL_INDEX = 492;
  public static final String NAME = "addMapPolygons";
  
  public final void a(c paramc, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(143662);
    super.a(paramc, paramJSONObject, paramInt);
    if (paramJSONObject == null)
    {
      ae.e("MicroMsg.JsApiAddMapPolygons", "data is null");
      paramc.h(paramInt, e("fail:invalid data", null));
      AppMethodBeat.o(143662);
      return;
    }
    ae.i("MicroMsg.JsApiAddMapPolygons", "data:%s", new Object[] { paramJSONObject });
    com.tencent.mm.plugin.appbrand.jsapi.i.a.b localb = h(paramc, paramJSONObject);
    if (localb == null)
    {
      ae.e("MicroMsg.JsApiAddMapPolygons", "mapView is null, return");
      paramc.h(paramInt, e("fail:mapview is null", null));
      AppMethodBeat.o(143662);
      return;
    }
    try
    {
      if (paramJSONObject.has("polygons"))
      {
        localb.blI();
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
            localArrayList.add(new b.i(bu.getDouble(localJSONObject2.optString("latitude"), 0.0D), bu.getDouble(localJSONObject2.optString("longitude"), 0.0D)) {});
            j += 1;
          }
          j = g.ck(localJSONObject1.optString("fillColor", ""), Color.parseColor("#000000"));
          int k = g.ck(localJSONObject1.optString("strokeColor", ""), Color.parseColor("#000000"));
          int m = g.a(localJSONObject1, "strokeWidth", 0);
          int n = localJSONObject1.optInt("zIndex", 0);
          localObject = new b.ab();
          ((b.ab)localObject).kVx = new ArrayList();
          ((b.ab)localObject).kVx.addAll(localArrayList);
          ((b.ab)localObject).fillColor = j;
          ((b.ab)localObject).strokeWidth = m;
          ((b.ab)localObject).strokeColor = k;
          ((b.ab)localObject).zIndex = n;
          ((b.ab)localObject).kVm = localJSONObject1.optString("level");
          localb.a((b.ab)localObject);
          i += 1;
        }
      }
      ae.e("MicroMsg.JsApiAddMapPolygons", "data has not lines info");
      a(paramc, paramInt, e("ok", null), true, localb.blB());
      AppMethodBeat.o(143662);
      return;
    }
    catch (Exception paramJSONObject)
    {
      ae.e("MicroMsg.JsApiAddMapPolygons", "parse lines error, exception : %s", new Object[] { paramJSONObject });
      a(paramc, paramInt, e("fail:internal error", null), false, localb.blB());
      AppMethodBeat.o(143662);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.i.i
 * JD-Core Version:    0.7.0.1
 */
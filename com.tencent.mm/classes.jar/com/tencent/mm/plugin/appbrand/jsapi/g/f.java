package com.tencent.mm.plugin.appbrand.jsapi.g;

import android.graphics.Color;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.g.a.b;
import com.tencent.mm.plugin.appbrand.jsapi.g.a.b.w;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.s.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class f
  extends a
{
  public static final int CTRL_INDEX = 492;
  public static final String NAME = "addMapPolygons";
  
  public final void a(c paramc, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(93843);
    super.a(paramc, paramJSONObject, paramInt);
    if (paramJSONObject == null)
    {
      ab.e("MicroMsg.JsApiAddMapPolygons", "data is null");
      paramc.h(paramInt, j("fail:invalid data", null));
      AppMethodBeat.o(93843);
      return;
    }
    ab.i("MicroMsg.JsApiAddMapPolygons", "data:%s", new Object[] { paramJSONObject });
    b localb = f(paramc, paramJSONObject);
    if (localb == null)
    {
      ab.e("MicroMsg.JsApiAddMapPolygons", "mapView is null, return");
      paramc.h(paramInt, j("fail:mapview is null", null));
      AppMethodBeat.o(93843);
      return;
    }
    try
    {
      if (paramJSONObject.has("polygons"))
      {
        localb.aDE();
        paramJSONObject = new JSONArray(paramJSONObject.optString("polygons"));
        int i = 0;
        while (i < paramJSONObject.length())
        {
          Object localObject = (JSONObject)paramJSONObject.get(i);
          ArrayList localArrayList = new ArrayList();
          JSONArray localJSONArray = new JSONArray(((JSONObject)localObject).optString("points"));
          int j = 0;
          while (j < localJSONArray.length())
          {
            JSONObject localJSONObject = localJSONArray.getJSONObject(j);
            float f1 = bo.getFloat(localJSONObject.optString("latitude"), 0.0F);
            float f2 = bo.getFloat(localJSONObject.optString("longitude"), 0.0F);
            localArrayList.add(new f.1(this, f1, f2));
            j += 1;
          }
          j = g.bA(((JSONObject)localObject).optString("fillColor", ""), Color.parseColor("#000000"));
          int k = g.bA(((JSONObject)localObject).optString("strokeColor", ""), Color.parseColor("#000000"));
          int m = g.a((JSONObject)localObject, "strokeWidth", 0);
          int n = ((JSONObject)localObject).optInt("zIndex", 0);
          localObject = new b.w();
          ((b.w)localObject).hPm = new ArrayList();
          ((b.w)localObject).hPm.addAll(localArrayList);
          ((b.w)localObject).fillColor = j;
          ((b.w)localObject).strokeWidth = m;
          ((b.w)localObject).strokeColor = k;
          ((b.w)localObject).zIndex = n;
          localb.a((b.w)localObject);
          i += 1;
        }
      }
      ab.e("MicroMsg.JsApiAddMapPolygons", "data has not lines info");
      a(paramc, paramInt, j("ok", null), true, localb.aDx());
      AppMethodBeat.o(93843);
      return;
    }
    catch (Exception paramJSONObject)
    {
      ab.e("MicroMsg.JsApiAddMapPolygons", "parse lines error, exception : %s", new Object[] { paramJSONObject });
      a(paramc, paramInt, j("fail:internal error", null), false, localb.aDx());
      AppMethodBeat.o(93843);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.g.f
 * JD-Core Version:    0.7.0.1
 */
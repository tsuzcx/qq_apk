package com.tencent.mm.plugin.appbrand.jsapi.i;

import android.graphics.Color;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.i.a.b.ab;
import com.tencent.mm.plugin.appbrand.jsapi.i.a.b.i;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.z.g;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
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
      ad.e("MicroMsg.JsApiAddMapPolygons", "data is null");
      paramc.h(paramInt, e("fail:invalid data", null));
      AppMethodBeat.o(143662);
      return;
    }
    ad.i("MicroMsg.JsApiAddMapPolygons", "data:%s", new Object[] { paramJSONObject });
    com.tencent.mm.plugin.appbrand.jsapi.i.a.b localb = h(paramc, paramJSONObject);
    if (localb == null)
    {
      ad.e("MicroMsg.JsApiAddMapPolygons", "mapView is null, return");
      paramc.h(paramInt, e("fail:mapview is null", null));
      AppMethodBeat.o(143662);
      return;
    }
    try
    {
      if (paramJSONObject.has("polygons"))
      {
        localb.bkY();
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
            localArrayList.add(new b.i(bt.getDouble(localJSONObject.optString("latitude"), 0.0D), bt.getDouble(localJSONObject.optString("longitude"), 0.0D)) {});
            j += 1;
          }
          j = g.cg(((JSONObject)localObject).optString("fillColor", ""), Color.parseColor("#000000"));
          int k = g.cg(((JSONObject)localObject).optString("strokeColor", ""), Color.parseColor("#000000"));
          int m = g.a((JSONObject)localObject, "strokeWidth", 0);
          int n = ((JSONObject)localObject).optInt("zIndex", 0);
          localObject = new b.ab();
          ((b.ab)localObject).kRO = new ArrayList();
          ((b.ab)localObject).kRO.addAll(localArrayList);
          ((b.ab)localObject).fillColor = j;
          ((b.ab)localObject).strokeWidth = m;
          ((b.ab)localObject).strokeColor = k;
          ((b.ab)localObject).zIndex = n;
          localb.a((b.ab)localObject);
          i += 1;
        }
      }
      ad.e("MicroMsg.JsApiAddMapPolygons", "data has not lines info");
      a(paramc, paramInt, e("ok", null), true, localb.bkR());
      AppMethodBeat.o(143662);
      return;
    }
    catch (Exception paramJSONObject)
    {
      ad.e("MicroMsg.JsApiAddMapPolygons", "parse lines error, exception : %s", new Object[] { paramJSONObject });
      a(paramc, paramInt, e("fail:internal error", null), false, localb.bkR());
      AppMethodBeat.o(143662);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.i.i
 * JD-Core Version:    0.7.0.1
 */
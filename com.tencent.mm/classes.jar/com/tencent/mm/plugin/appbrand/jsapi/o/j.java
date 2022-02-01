package com.tencent.mm.plugin.appbrand.jsapi.o;

import android.graphics.Color;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.af.i;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.o.a.b.ab;
import com.tencent.mm.plugin.appbrand.jsapi.o.a.b.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class j
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
      paramf.callback(paramInt, ZP("fail:invalid data"));
      AppMethodBeat.o(143662);
      return;
    }
    Log.i("MicroMsg.JsApiAddMapPolygons", "data:%s", new Object[] { paramJSONObject });
    com.tencent.mm.plugin.appbrand.jsapi.o.a.b localb = g(paramf, paramJSONObject);
    if (localb == null)
    {
      Log.e("MicroMsg.JsApiAddMapPolygons", "mapView is null, return");
      paramf.callback(paramInt, ZP("fail:mapview is null"));
      AppMethodBeat.o(143662);
      return;
    }
    try
    {
      if (paramJSONObject.has("polygons"))
      {
        localb.csT();
        JSONArray localJSONArray1 = new JSONArray(paramJSONObject.optString("polygons"));
        int i = 0;
        while (i < localJSONArray1.length())
        {
          JSONObject localJSONObject = (JSONObject)localJSONArray1.get(i);
          ArrayList localArrayList = new ArrayList();
          paramJSONObject = new JSONArray(localJSONObject.optString("points"));
          int j = 0;
          while (j < paramJSONObject.length())
          {
            localObject = paramJSONObject.getJSONObject(j);
            localArrayList.add(new b.i(Util.getDouble(((JSONObject)localObject).optString("latitude"), 0.0D), Util.getDouble(((JSONObject)localObject).optString("longitude"), 0.0D)) {});
            j += 1;
          }
          int k = i.dq(localJSONObject.optString("fillColor", ""), Color.parseColor("#000000"));
          int m = i.dq(localJSONObject.optString("strokeColor", ""), Color.parseColor("#000000"));
          int n = i.a(localJSONObject, "strokeWidth", 0);
          int i1 = localJSONObject.optInt("zIndex", 0);
          paramJSONObject = null;
          if (localJSONObject.has("dashArray"))
          {
            JSONArray localJSONArray2 = new JSONArray(localJSONObject.optString("dashArray"));
            localObject = new int[localJSONArray2.length()];
            j = 0;
            for (;;)
            {
              paramJSONObject = (JSONObject)localObject;
              if (j >= localJSONArray2.length()) {
                break;
              }
              localObject[j] = localJSONArray2.getInt(j);
              j += 1;
            }
          }
          Object localObject = new b.ab();
          ((b.ab)localObject).sdW = new ArrayList();
          ((b.ab)localObject).sdW.addAll(localArrayList);
          ((b.ab)localObject).fillColor = k;
          ((b.ab)localObject).strokeWidth = n;
          ((b.ab)localObject).strokeColor = m;
          ((b.ab)localObject).zIndex = i1;
          ((b.ab)localObject).sdL = localJSONObject.optString("level");
          ((b.ab)localObject).sev = paramJSONObject;
          localb.a((b.ab)localObject);
          i += 1;
        }
      }
      Log.e("MicroMsg.JsApiAddMapPolygons", "data has not lines info");
      a(paramf, paramInt, ZP("ok"), true, localb.csM());
      AppMethodBeat.o(143662);
      return;
    }
    catch (Exception paramJSONObject)
    {
      Log.e("MicroMsg.JsApiAddMapPolygons", "parse lines error, exception : %s", new Object[] { paramJSONObject });
      a(paramf, paramInt, ZP("fail:internal error"), false, localb.csM());
      AppMethodBeat.o(143662);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.o.j
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.appbrand.jsapi.g;

import android.graphics.Color;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.aa.g;
import com.tencent.mm.plugin.appbrand.g.a;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.g.a.b.h;
import com.tencent.mm.plugin.appbrand.jsapi.g.a.b.j;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class f
  extends b
{
  public static final int CTRL_INDEX = 134;
  public static final String NAME = "addMapLines";
  
  public final void a(c paramc, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(143660);
    super.a(paramc, paramJSONObject, paramInt);
    if (paramJSONObject == null)
    {
      ad.e("MicroMsg.JsApiAddMapLines", "data is null");
      paramc.h(paramInt, e("fail:invalid data", null));
      AppMethodBeat.o(143660);
      return;
    }
    ad.i("MicroMsg.JsApiAddMapLines", "data:%s", new Object[] { paramJSONObject });
    com.tencent.mm.plugin.appbrand.jsapi.g.a.b localb = h(paramc, paramJSONObject);
    if (localb == null)
    {
      ad.e("MicroMsg.JsApiAddMapLines", "mapView is null, return");
      paramc.h(paramInt, e("fail:mapview is null", null));
      AppMethodBeat.o(143660);
      return;
    }
    try
    {
      if (paramJSONObject.has("lines"))
      {
        if (paramJSONObject.optBoolean("clear", true)) {
          localb.bax();
        }
        paramJSONObject = new JSONArray(paramJSONObject.optString("lines"));
        int i = 0;
        while (i < paramJSONObject.length())
        {
          Object localObject1 = (JSONObject)paramJSONObject.get(i);
          Object localObject2 = new ArrayList();
          Object localObject3 = new JSONArray(((JSONObject)localObject1).optString("points"));
          int j = 0;
          while (j < ((JSONArray)localObject3).length())
          {
            localObject4 = ((JSONArray)localObject3).getJSONObject(j);
            ((List)localObject2).add(new b.h(bt.getDouble(((JSONObject)localObject4).optString("latitude"), 0.0D), bt.getDouble(((JSONObject)localObject4).optString("longitude"), 0.0D)) {});
            j += 1;
          }
          Object localObject4 = ((JSONObject)localObject1).optString("id");
          j = g.bY(((JSONObject)localObject1).optString("color", ""), Color.parseColor("#000000"));
          int k = ((JSONObject)localObject1).optInt("style", -1);
          int m = g.a((JSONObject)localObject1, "width", 0);
          boolean bool1 = ((JSONObject)localObject1).optBoolean("dottedLine", false);
          int n = g.bY(((JSONObject)localObject1).optString("borderColor", ""), Color.parseColor("#000000"));
          int i1 = g.a((JSONObject)localObject1, "borderWidth", 0);
          boolean bool2 = ((JSONObject)localObject1).optBoolean("arrowLine", false);
          String str = ((JSONObject)localObject1).optString("arrowIconPath", "");
          int i2 = g.a((JSONObject)localObject1, "arrowGap", 0);
          localObject3 = new b.j();
          ((b.j)localObject3).id = ((String)localObject4);
          ((b.j)localObject3).style = k;
          ((b.j)localObject3).jUZ = new ArrayList();
          ((b.j)localObject3).jUZ.addAll((Collection)localObject2);
          ((b.j)localObject3).color = j;
          ((b.j)localObject3).width = m;
          ((b.j)localObject3).jVa = bool1;
          ((b.j)localObject3).borderColor = n;
          ((b.j)localObject3).borderWidth = i1;
          ((b.j)localObject3).jVb = bool2;
          ((b.j)localObject3).jVd = i2;
          if (bool2) {
            ((b.j)localObject3).jVc = ((com.tencent.mm.plugin.appbrand.g.b)paramc.K(com.tencent.mm.plugin.appbrand.g.b.class)).b(paramc, str);
          }
          localObject2 = ((JSONObject)localObject1).optString("buildingId");
          localObject1 = ((JSONObject)localObject1).optString("floorName");
          ((b.j)localObject3).buildingId = ((String)localObject2);
          ((b.j)localObject3).floorName = ((String)localObject1);
          localb.a((b.j)localObject3, (a)paramc.K(a.class));
          i += 1;
        }
      }
      ad.e("MicroMsg.JsApiAddMapLines", "data has not lines info");
      a(paramc, paramInt, e("ok", null), true, localb.bat());
      AppMethodBeat.o(143660);
      return;
    }
    catch (Exception paramJSONObject)
    {
      ad.e("MicroMsg.JsApiAddMapLines", "parse lines error, exception : %s", new Object[] { paramJSONObject });
      a(paramc, paramInt, e("fail:internal error", null), false, localb.bat());
      AppMethodBeat.o(143660);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.g.f
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.appbrand.jsapi.g;

import android.graphics.Color;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.g.a.b.j;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.s.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class d
  extends a
{
  public static final int CTRL_INDEX = 134;
  public static final String NAME = "addMapLines";
  
  public final void a(c paramc, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(93841);
    super.a(paramc, paramJSONObject, paramInt);
    if (paramJSONObject == null)
    {
      ab.e("MicroMsg.JsApiAddMapLines", "data is null");
      paramc.h(paramInt, j("fail:invalid data", null));
      AppMethodBeat.o(93841);
      return;
    }
    ab.i("MicroMsg.JsApiAddMapLines", "data:%s", new Object[] { paramJSONObject });
    com.tencent.mm.plugin.appbrand.jsapi.g.a.b localb = f(paramc, paramJSONObject);
    if (localb == null)
    {
      ab.e("MicroMsg.JsApiAddMapLines", "mapView is null, return");
      paramc.h(paramInt, j("fail:mapview is null", null));
      AppMethodBeat.o(93841);
      return;
    }
    try
    {
      if (paramJSONObject.has("lines"))
      {
        if (paramJSONObject.optBoolean("clear", true)) {
          localb.aDB();
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
            float f1 = bo.getFloat(((JSONObject)localObject4).optString("latitude"), 0.0F);
            float f2 = bo.getFloat(((JSONObject)localObject4).optString("longitude"), 0.0F);
            ((List)localObject2).add(new d.1(this, f1, f2));
            j += 1;
          }
          Object localObject4 = ((JSONObject)localObject1).optString("id");
          j = g.bA(((JSONObject)localObject1).optString("color", ""), Color.parseColor("#000000"));
          int k = ((JSONObject)localObject1).optInt("style", -1);
          int m = g.a((JSONObject)localObject1, "width", 0);
          boolean bool1 = ((JSONObject)localObject1).optBoolean("dottedLine", false);
          int n = g.bA(((JSONObject)localObject1).optString("borderColor", ""), Color.parseColor("#000000"));
          int i1 = g.a((JSONObject)localObject1, "borderWidth", 0);
          boolean bool2 = ((JSONObject)localObject1).optBoolean("arrowLine", false);
          String str = ((JSONObject)localObject1).optString("arrowIconPath", "");
          int i2 = g.a((JSONObject)localObject1, "arrowGap", 0);
          localObject3 = new b.j();
          ((b.j)localObject3).id = ((String)localObject4);
          ((b.j)localObject3).style = k;
          ((b.j)localObject3).hPm = new ArrayList();
          ((b.j)localObject3).hPm.addAll((Collection)localObject2);
          ((b.j)localObject3).color = j;
          ((b.j)localObject3).width = m;
          ((b.j)localObject3).hPn = bool1;
          ((b.j)localObject3).borderColor = n;
          ((b.j)localObject3).borderWidth = i1;
          ((b.j)localObject3).hPo = bool2;
          ((b.j)localObject3).hPq = i2;
          if (bool2) {
            ((b.j)localObject3).hPp = ((com.tencent.mm.plugin.appbrand.e.b)paramc.q(com.tencent.mm.plugin.appbrand.e.b.class)).b(paramc, str);
          }
          localObject2 = ((JSONObject)localObject1).optString("buildingId");
          localObject1 = ((JSONObject)localObject1).optString("floorName");
          ((b.j)localObject3).buildingId = ((String)localObject2);
          ((b.j)localObject3).floorName = ((String)localObject1);
          localb.a((b.j)localObject3, (com.tencent.mm.plugin.appbrand.e.a)paramc.q(com.tencent.mm.plugin.appbrand.e.a.class));
          i += 1;
        }
      }
      ab.e("MicroMsg.JsApiAddMapLines", "data has not lines info");
      a(paramc, paramInt, j("ok", null), true, localb.aDx());
      AppMethodBeat.o(93841);
      return;
    }
    catch (Exception paramJSONObject)
    {
      ab.e("MicroMsg.JsApiAddMapLines", "parse lines error, exception : %s", new Object[] { paramJSONObject });
      a(paramc, paramInt, j("fail:internal error", null), false, localb.aDx());
      AppMethodBeat.o(93841);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.g.d
 * JD-Core Version:    0.7.0.1
 */
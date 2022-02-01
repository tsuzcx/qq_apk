package com.tencent.mm.plugin.appbrand.jsapi.f;

import android.graphics.Color;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.g.a;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.f.a.b.h;
import com.tencent.mm.plugin.appbrand.jsapi.f.a.b.j;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.z.g;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
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
      ac.e("MicroMsg.JsApiAddMapLines", "data is null");
      paramc.h(paramInt, e("fail:invalid data", null));
      AppMethodBeat.o(143660);
      return;
    }
    ac.i("MicroMsg.JsApiAddMapLines", "data:%s", new Object[] { paramJSONObject });
    com.tencent.mm.plugin.appbrand.jsapi.f.a.b localb = h(paramc, paramJSONObject);
    if (localb == null)
    {
      ac.e("MicroMsg.JsApiAddMapLines", "mapView is null, return");
      paramc.h(paramInt, e("fail:mapview is null", null));
      AppMethodBeat.o(143660);
      return;
    }
    try
    {
      if (paramJSONObject.has("lines"))
      {
        if (paramJSONObject.optBoolean("clear", true)) {
          localb.bhq();
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
            ((List)localObject2).add(new b.h(bs.getDouble(((JSONObject)localObject4).optString("latitude"), 0.0D), bs.getDouble(((JSONObject)localObject4).optString("longitude"), 0.0D)) {});
            j += 1;
          }
          Object localObject4 = new ArrayList();
          if (((JSONObject)localObject1).has("colorList"))
          {
            localObject3 = new JSONArray(((JSONObject)localObject1).optString("colorList"));
            j = 0;
            while (j < ((JSONArray)localObject3).length())
            {
              ((List)localObject4).add(Integer.valueOf(g.cd(((JSONArray)localObject3).getString(j), Color.parseColor("#000000"))));
              j += 1;
            }
            if ((((List)localObject4).size() > 0) && (((List)localObject4).size() < ((List)localObject2).size() - 1))
            {
              k = ((Integer)((List)localObject4).get(((List)localObject4).size() - 1)).intValue();
              j = ((List)localObject4).size();
            }
            while (j < ((List)localObject2).size() - 1)
            {
              ((List)localObject4).add(Integer.valueOf(k));
              j += 1;
              continue;
              if ((((List)localObject4).size() > ((List)localObject2).size()) && (((List)localObject2).size() > 0))
              {
                j = ((List)localObject4).size() - 1;
                while (j > ((List)localObject2).size() - 1)
                {
                  ((List)localObject4).remove(j);
                  j -= 1;
                }
              }
            }
            ac.i("MicroMsg.JsApiAddMapLines", "colorList size:%d ", new Object[] { Integer.valueOf(((List)localObject4).size()) });
          }
          String str1 = ((JSONObject)localObject1).optString("id");
          j = g.cd(((JSONObject)localObject1).optString("color", ""), Color.parseColor("#000000"));
          int k = ((JSONObject)localObject1).optInt("style", -1);
          int m = g.a((JSONObject)localObject1, "width", 0);
          boolean bool1 = ((JSONObject)localObject1).optBoolean("dottedLine", false);
          int n = g.cd(((JSONObject)localObject1).optString("borderColor", ""), Color.parseColor("#000000"));
          int i1 = g.a((JSONObject)localObject1, "borderWidth", 0);
          boolean bool2 = ((JSONObject)localObject1).optBoolean("arrowLine", false);
          String str2 = ((JSONObject)localObject1).optString("arrowIconPath", "");
          int i2 = g.a((JSONObject)localObject1, "arrowGap", 0);
          localObject3 = new b.j();
          ((b.j)localObject3).id = str1;
          ((b.j)localObject3).style = k;
          ((b.j)localObject3).kvK = new ArrayList();
          ((b.j)localObject3).kvK.addAll((Collection)localObject2);
          ((b.j)localObject3).kvP = ((List)localObject4);
          ((b.j)localObject3).color = j;
          ((b.j)localObject3).width = m;
          ((b.j)localObject3).kvL = bool1;
          ((b.j)localObject3).borderColor = n;
          ((b.j)localObject3).borderWidth = i1;
          ((b.j)localObject3).kvM = bool2;
          ((b.j)localObject3).kvO = i2;
          if (bool2) {
            ((b.j)localObject3).kvN = ((com.tencent.mm.plugin.appbrand.g.b)paramc.K(com.tencent.mm.plugin.appbrand.g.b.class)).b(paramc, str2);
          }
          localObject2 = ((JSONObject)localObject1).optString("buildingId");
          localObject1 = ((JSONObject)localObject1).optString("floorName");
          ((b.j)localObject3).buildingId = ((String)localObject2);
          ((b.j)localObject3).floorName = ((String)localObject1);
          localb.a((b.j)localObject3, (a)paramc.K(a.class));
          i += 1;
        }
      }
      ac.e("MicroMsg.JsApiAddMapLines", "data has not lines info");
      a(paramc, paramInt, e("ok", null), true, localb.bhm());
      AppMethodBeat.o(143660);
      return;
    }
    catch (Exception paramJSONObject)
    {
      ac.e("MicroMsg.JsApiAddMapLines", "parse lines error, exception : %s", new Object[] { paramJSONObject });
      a(paramc, paramInt, e("fail:internal error", null), false, localb.bhm());
      AppMethodBeat.o(143660);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.f.f
 * JD-Core Version:    0.7.0.1
 */
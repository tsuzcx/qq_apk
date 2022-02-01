package com.tencent.mm.plugin.appbrand.jsapi.i;

import android.graphics.Color;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.f.a;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.i.a.b.i;
import com.tencent.mm.plugin.appbrand.jsapi.i.a.b.k;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class g
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
      ae.e("MicroMsg.JsApiAddMapLines", "data is null");
      paramc.h(paramInt, e("fail:invalid data", null));
      AppMethodBeat.o(143660);
      return;
    }
    ae.i("MicroMsg.JsApiAddMapLines", "data:%s", new Object[] { paramJSONObject });
    com.tencent.mm.plugin.appbrand.jsapi.i.a.b localb = h(paramc, paramJSONObject);
    if (localb == null)
    {
      ae.e("MicroMsg.JsApiAddMapLines", "mapView is null, return");
      paramc.h(paramInt, e("fail:mapview is null", null));
      AppMethodBeat.o(143660);
      return;
    }
    try
    {
      if (paramJSONObject.has("lines"))
      {
        if (paramJSONObject.optBoolean("clear", true)) {
          localb.blF();
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
            ((List)localObject2).add(new b.i(bu.getDouble(((JSONObject)localObject4).optString("latitude"), 0.0D), bu.getDouble(((JSONObject)localObject4).optString("longitude"), 0.0D)) {});
            j += 1;
          }
          ArrayList localArrayList = new ArrayList();
          if (((JSONObject)localObject1).has("colorList"))
          {
            localObject3 = new JSONArray(((JSONObject)localObject1).optString("colorList"));
            j = 0;
            while (j < ((JSONArray)localObject3).length())
            {
              localArrayList.add(Integer.valueOf(com.tencent.mm.plugin.appbrand.y.g.ck(((JSONArray)localObject3).getString(j), Color.parseColor("#000000"))));
              j += 1;
            }
            if ((localArrayList.size() > 0) && (localArrayList.size() < ((List)localObject2).size() - 1))
            {
              k = ((Integer)localArrayList.get(localArrayList.size() - 1)).intValue();
              j = localArrayList.size();
            }
            while (j < ((List)localObject2).size() - 1)
            {
              localArrayList.add(Integer.valueOf(k));
              j += 1;
              continue;
              if ((localArrayList.size() > ((List)localObject2).size()) && (((List)localObject2).size() > 0))
              {
                j = localArrayList.size() - 1;
                while (j > ((List)localObject2).size() - 1)
                {
                  localArrayList.remove(j);
                  j -= 1;
                }
              }
            }
            ae.i("MicroMsg.JsApiAddMapLines", "colorList size:%d ", new Object[] { Integer.valueOf(localArrayList.size()) });
          }
          String str1 = ((JSONObject)localObject1).optString("id");
          j = com.tencent.mm.plugin.appbrand.y.g.ck(((JSONObject)localObject1).optString("color", ""), Color.parseColor("#000000"));
          int k = ((JSONObject)localObject1).optInt("style", -1);
          int m = com.tencent.mm.plugin.appbrand.y.g.a((JSONObject)localObject1, "width", 0);
          boolean bool1 = ((JSONObject)localObject1).optBoolean("dottedLine", false);
          int n = com.tencent.mm.plugin.appbrand.y.g.ck(((JSONObject)localObject1).optString("borderColor", ""), Color.parseColor("#000000"));
          int i1 = com.tencent.mm.plugin.appbrand.y.g.a((JSONObject)localObject1, "borderWidth", 0);
          boolean bool2 = ((JSONObject)localObject1).optBoolean("arrowLine", false);
          String str2 = ((JSONObject)localObject1).optString("arrowIconPath", "");
          int i2 = com.tencent.mm.plugin.appbrand.y.g.a((JSONObject)localObject1, "arrowGap", 0);
          localObject3 = ((JSONObject)localObject1).optString("level");
          Object localObject4 = new b.k();
          ((b.k)localObject4).id = str1;
          ((b.k)localObject4).style = k;
          ((b.k)localObject4).kVx = new ArrayList();
          ((b.k)localObject4).kVx.addAll((Collection)localObject2);
          ((b.k)localObject4).kVC = localArrayList;
          ((b.k)localObject4).color = j;
          ((b.k)localObject4).width = m;
          ((b.k)localObject4).kVy = bool1;
          ((b.k)localObject4).borderColor = n;
          ((b.k)localObject4).borderWidth = i1;
          ((b.k)localObject4).kVz = bool2;
          ((b.k)localObject4).kVB = i2;
          if (bool2) {
            ((b.k)localObject4).kVA = ((com.tencent.mm.plugin.appbrand.f.b)paramc.K(com.tencent.mm.plugin.appbrand.f.b.class)).b(paramc, str2);
          }
          localObject2 = ((JSONObject)localObject1).optString("buildingId");
          localObject1 = ((JSONObject)localObject1).optString("floorName");
          ((b.k)localObject4).buildingId = ((String)localObject2);
          ((b.k)localObject4).floorName = ((String)localObject1);
          ((b.k)localObject4).kVm = ((String)localObject3);
          localb.a((b.k)localObject4, (a)paramc.K(a.class));
          i += 1;
        }
      }
      ae.e("MicroMsg.JsApiAddMapLines", "data has not lines info");
      a(paramc, paramInt, e("ok", null), true, localb.blB());
      AppMethodBeat.o(143660);
      return;
    }
    catch (Exception paramJSONObject)
    {
      ae.e("MicroMsg.JsApiAddMapLines", "parse lines error, exception : %s", new Object[] { paramJSONObject });
      a(paramc, paramInt, e("fail:internal error", null), false, localb.blB());
      AppMethodBeat.o(143660);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.i.g
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.appbrand.jsapi.l;

import android.graphics.Color;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.f.a;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.jsapi.l.a.b.i;
import com.tencent.mm.plugin.appbrand.jsapi.l.a.b.k;
import com.tencent.mm.plugin.appbrand.jsapi.o;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
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
  
  public final void a(e parame, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(143660);
    super.a(parame, paramJSONObject, paramInt);
    if (paramJSONObject == null)
    {
      Log.e("MicroMsg.JsApiAddMapLines", "data is null");
      parame.j(paramInt, h("fail:invalid data", null));
      AppMethodBeat.o(143660);
      return;
    }
    Log.i("MicroMsg.JsApiAddMapLines", "data:%s", new Object[] { paramJSONObject });
    com.tencent.mm.plugin.appbrand.jsapi.l.a.b localb = g(parame, paramJSONObject);
    if (localb == null)
    {
      Log.e("MicroMsg.JsApiAddMapLines", "mapView is null, return");
      parame.j(paramInt, h("fail:mapview is null", null));
      AppMethodBeat.o(143660);
      return;
    }
    try
    {
      if (paramJSONObject.has("lines"))
      {
        if (paramJSONObject.optBoolean("clear", true)) {
          localb.bSJ();
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
            ((List)localObject2).add(new b.i(Util.getDouble(((JSONObject)localObject4).optString("latitude"), 0.0D), Util.getDouble(((JSONObject)localObject4).optString("longitude"), 0.0D)) {});
            j += 1;
          }
          ArrayList localArrayList = new ArrayList();
          if (((JSONObject)localObject1).has("colorList"))
          {
            localObject3 = new JSONArray(((JSONObject)localObject1).optString("colorList"));
            j = 0;
            while (j < ((JSONArray)localObject3).length())
            {
              localArrayList.add(Integer.valueOf(com.tencent.mm.plugin.appbrand.ac.g.cO(((JSONArray)localObject3).getString(j), Color.parseColor("#000000"))));
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
            Log.i("MicroMsg.JsApiAddMapLines", "colorList size:%d ", new Object[] { Integer.valueOf(localArrayList.size()) });
          }
          String str1 = ((JSONObject)localObject1).optString("id");
          j = com.tencent.mm.plugin.appbrand.ac.g.cO(((JSONObject)localObject1).optString("color", ""), Color.parseColor("#000000"));
          int k = ((JSONObject)localObject1).optInt("style", -1);
          int m = com.tencent.mm.plugin.appbrand.ac.g.a((JSONObject)localObject1, "width", 0);
          boolean bool1 = ((JSONObject)localObject1).optBoolean("dottedLine", false);
          int n = com.tencent.mm.plugin.appbrand.ac.g.cO(((JSONObject)localObject1).optString("borderColor", ""), Color.parseColor("#000000"));
          int i1 = com.tencent.mm.plugin.appbrand.ac.g.a((JSONObject)localObject1, "borderWidth", 0);
          boolean bool2 = ((JSONObject)localObject1).optBoolean("arrowLine", false);
          String str2 = ((JSONObject)localObject1).optString("arrowIconPath", "");
          int i2 = com.tencent.mm.plugin.appbrand.ac.g.a((JSONObject)localObject1, "arrowGap", 0);
          localObject3 = ((JSONObject)localObject1).optString("level");
          Object localObject4 = new b.k();
          ((b.k)localObject4).id = str1;
          ((b.k)localObject4).style = k;
          ((b.k)localObject4).oYw = new ArrayList();
          ((b.k)localObject4).oYw.addAll((Collection)localObject2);
          ((b.k)localObject4).oYB = localArrayList;
          ((b.k)localObject4).enableGradient = ((JSONObject)localObject1).optBoolean("enableGradient", false);
          ((b.k)localObject4).color = j;
          ((b.k)localObject4).width = m;
          ((b.k)localObject4).oYx = bool1;
          ((b.k)localObject4).borderColor = n;
          ((b.k)localObject4).borderWidth = i1;
          ((b.k)localObject4).oYy = bool2;
          ((b.k)localObject4).oYA = i2;
          if (bool2) {
            ((b.k)localObject4).oYz = ((com.tencent.mm.plugin.appbrand.f.b)parame.K(com.tencent.mm.plugin.appbrand.f.b.class)).b(parame, str2);
          }
          localObject2 = ((JSONObject)localObject1).optString("buildingId");
          localObject1 = ((JSONObject)localObject1).optString("floorName");
          ((b.k)localObject4).buildingId = ((String)localObject2);
          ((b.k)localObject4).floorName = ((String)localObject1);
          ((b.k)localObject4).oYl = ((String)localObject3);
          localb.a((b.k)localObject4, (a)parame.K(a.class));
          i += 1;
        }
      }
      Log.e("MicroMsg.JsApiAddMapLines", "data has not lines info");
      a(parame, paramInt, h("ok", null), true, localb.bSF());
      AppMethodBeat.o(143660);
      return;
    }
    catch (Exception paramJSONObject)
    {
      Log.e("MicroMsg.JsApiAddMapLines", "parse lines error, exception : %s", new Object[] { paramJSONObject });
      a(parame, paramInt, h("fail:internal error", null), false, localb.bSF());
      AppMethodBeat.o(143660);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.l.g
 * JD-Core Version:    0.7.0.1
 */
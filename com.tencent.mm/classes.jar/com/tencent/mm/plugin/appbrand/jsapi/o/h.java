package com.tencent.mm.plugin.appbrand.jsapi.o;

import android.graphics.Color;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.af.i;
import com.tencent.mm.plugin.appbrand.f.a;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.o.a.b.i;
import com.tencent.mm.plugin.appbrand.jsapi.o.a.b.k;
import com.tencent.mm.plugin.appbrand.jsapi.o.a.b.k.a;
import com.tencent.mm.plugin.appbrand.jsapi.o.a.b.k.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class h
  extends b
{
  public static final int CTRL_INDEX = 134;
  public static final String NAME = "addMapLines";
  
  public final void a(f paramf, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(143660);
    super.a(paramf, paramJSONObject, paramInt);
    if (paramJSONObject == null)
    {
      Log.e("MicroMsg.JsApiAddMapLines", "data is null");
      paramf.callback(paramInt, ZP("fail:invalid data"));
      AppMethodBeat.o(143660);
      return;
    }
    Log.i("MicroMsg.JsApiAddMapLines", "data:%s", new Object[] { paramJSONObject });
    com.tencent.mm.plugin.appbrand.jsapi.o.a.b localb = g(paramf, paramJSONObject);
    if (localb == null)
    {
      Log.e("MicroMsg.JsApiAddMapLines", "mapView is null, return");
      paramf.callback(paramInt, ZP("fail:mapview is null"));
      AppMethodBeat.o(143660);
      return;
    }
    for (;;)
    {
      try
      {
        if (paramJSONObject.has("lines"))
        {
          if (paramJSONObject.optBoolean("clear", true)) {
            localb.csQ();
          }
          JSONArray localJSONArray = new JSONArray(paramJSONObject.optString("lines"));
          int i = 0;
          if (i < localJSONArray.length())
          {
            Object localObject1 = (JSONObject)localJSONArray.get(i);
            Object localObject2 = new ArrayList();
            paramJSONObject = new JSONArray(((JSONObject)localObject1).optString("points"));
            int j = 0;
            if (j < paramJSONObject.length())
            {
              localObject3 = paramJSONObject.getJSONObject(j);
              ((List)localObject2).add(new b.i(Util.getDouble(((JSONObject)localObject3).optString("latitude"), 0.0D), Util.getDouble(((JSONObject)localObject3).optString("longitude"), 0.0D)) {});
              j += 1;
              continue;
            }
            ArrayList localArrayList1 = new ArrayList();
            if (((JSONObject)localObject1).has("colorList"))
            {
              paramJSONObject = new JSONArray(((JSONObject)localObject1).optString("colorList"));
              j = 0;
              if (j < paramJSONObject.length())
              {
                localArrayList1.add(Integer.valueOf(i.dq(paramJSONObject.getString(j), Color.parseColor("#000000"))));
                j += 1;
                continue;
              }
              if ((localArrayList1.size() > 0) && (localArrayList1.size() < ((List)localObject2).size() - 1))
              {
                k = ((Integer)localArrayList1.get(localArrayList1.size() - 1)).intValue();
                j = localArrayList1.size();
                if (j < ((List)localObject2).size() - 1)
                {
                  localArrayList1.add(Integer.valueOf(k));
                  j += 1;
                  continue;
                }
              }
              else if ((localArrayList1.size() > ((List)localObject2).size()) && (((List)localObject2).size() > 0))
              {
                j = localArrayList1.size() - 1;
                if (j > ((List)localObject2).size() - 1)
                {
                  localArrayList1.remove(j);
                  j -= 1;
                  continue;
                }
              }
              Log.i("MicroMsg.JsApiAddMapLines", "colorList size:%d ", new Object[] { Integer.valueOf(localArrayList1.size()) });
            }
            String str1 = ((JSONObject)localObject1).optString("id");
            int k = i.dq(((JSONObject)localObject1).optString("color", ""), Color.parseColor("#000000"));
            int m = ((JSONObject)localObject1).optInt("style", -1);
            int n = i.a((JSONObject)localObject1, "width", 0);
            boolean bool1 = ((JSONObject)localObject1).optBoolean("dottedLine", false);
            int i1 = i.dq(((JSONObject)localObject1).optString("borderColor", ""), Color.parseColor("#000000"));
            int i2 = i.a((JSONObject)localObject1, "borderWidth", 0);
            boolean bool2 = ((JSONObject)localObject1).optBoolean("arrowLine", false);
            String str2 = ((JSONObject)localObject1).optString("arrowIconPath", "");
            int i3 = i.a((JSONObject)localObject1, "arrowGap", 0);
            Object localObject3 = ((JSONObject)localObject1).optString("level");
            if (!((JSONObject)localObject1).has("textStyle")) {
              break label1160;
            }
            paramJSONObject = new b.k.b();
            paramJSONObject.textColor = i.dq(((JSONObject)localObject1).optString("textColor", ""), Color.parseColor("#000000"));
            paramJSONObject.strokeColor = i.dq(((JSONObject)localObject1).optString("strokeColor", ""), Color.parseColor("#FFFFFF"));
            paramJSONObject.fontSize = ((JSONObject)localObject1).optInt("fontSize", 14);
            ArrayList localArrayList2 = new ArrayList();
            if (((JSONObject)localObject1).has("segmentTexts"))
            {
              localObject4 = new JSONArray(((JSONObject)localObject1).optString("segmentTexts"));
              j = 0;
              if (j < ((JSONArray)localObject4).length())
              {
                JSONObject localJSONObject = ((JSONArray)localObject4).getJSONObject(j);
                b.k.a locala = new b.k.a();
                locala.name = localJSONObject.optString("name");
                locala.startIndex = localJSONObject.optInt("startIndex", 0);
                locala.endIndex = localJSONObject.optInt("endIndex", 0);
                localArrayList2.add(locala);
                j += 1;
                continue;
              }
            }
            Object localObject4 = new b.k();
            ((b.k)localObject4).id = str1;
            ((b.k)localObject4).style = m;
            ((b.k)localObject4).sdW = new ArrayList();
            ((b.k)localObject4).sdW.addAll((Collection)localObject2);
            ((b.k)localObject4).seb = localArrayList1;
            ((b.k)localObject4).enableGradient = ((JSONObject)localObject1).optBoolean("enableGradient", false);
            ((b.k)localObject4).color = k;
            ((b.k)localObject4).width = n;
            ((b.k)localObject4).sdX = bool1;
            ((b.k)localObject4).borderColor = i1;
            ((b.k)localObject4).borderWidth = i2;
            ((b.k)localObject4).sdY = bool2;
            ((b.k)localObject4).sea = i3;
            if (bool2) {
              ((b.k)localObject4).sdZ = ((com.tencent.mm.plugin.appbrand.f.b)paramf.T(com.tencent.mm.plugin.appbrand.f.b.class)).b(paramf, str2);
            }
            localObject2 = ((JSONObject)localObject1).optString("buildingId");
            localObject1 = ((JSONObject)localObject1).optString("floorName");
            ((b.k)localObject4).buildingId = ((String)localObject2);
            ((b.k)localObject4).floorName = ((String)localObject1);
            ((b.k)localObject4).sdL = ((String)localObject3);
            ((b.k)localObject4).textStyle = paramJSONObject;
            ((b.k)localObject4).segmentTexts = localArrayList2;
            localb.a((b.k)localObject4, (a)paramf.T(a.class));
            i += 1;
            continue;
          }
        }
        else
        {
          Log.e("MicroMsg.JsApiAddMapLines", "data has not lines info");
        }
        a(paramf, paramInt, ZP("ok"), true, localb.csM());
        AppMethodBeat.o(143660);
        return;
      }
      catch (Exception paramJSONObject)
      {
        Log.e("MicroMsg.JsApiAddMapLines", "parse lines error, exception : %s", new Object[] { paramJSONObject });
        a(paramf, paramInt, ZP("fail:internal error"), false, localb.csM());
        AppMethodBeat.o(143660);
        return;
      }
      label1160:
      paramJSONObject = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.o.h
 * JD-Core Version:    0.7.0.1
 */
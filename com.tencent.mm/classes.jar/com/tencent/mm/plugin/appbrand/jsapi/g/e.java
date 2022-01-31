package com.tencent.mm.plugin.appbrand.jsapi.g;

import android.graphics.Color;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.g.a.b.r;
import com.tencent.mm.plugin.appbrand.jsapi.g.a.b.r.a;
import com.tencent.mm.plugin.appbrand.jsapi.g.a.b.r.b;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.s.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class e
  extends a
{
  public static final int CTRL_INDEX = 133;
  public static final String NAME = "addMapMarkers";
  
  public final void a(c paramc, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(93842);
    super.a(paramc, paramJSONObject, paramInt);
    if (paramJSONObject == null)
    {
      ab.e("MicroMsg.JsApiAddMapMarkers", "data is null");
      paramc.h(paramInt, j("fail:invalid data", null));
      AppMethodBeat.o(93842);
      return;
    }
    ab.i("MicroMsg.JsApiAddMapMarkers", "data:%s", new Object[] { paramJSONObject });
    com.tencent.mm.plugin.appbrand.jsapi.g.a.b localb = f(paramc, paramJSONObject);
    if (localb == null)
    {
      ab.e("MicroMsg.JsApiAddMapMarkers", "mapView is null, return");
      paramc.h(paramInt, j("fail:mapview is null", null));
      AppMethodBeat.o(93842);
      return;
    }
    boolean bool = paramJSONObject.optBoolean("clear", true);
    ab.i("MicroMsg.JsApiAddMapMarkers", "clear:%b", new Object[] { Boolean.valueOf(bool) });
    if (bool) {
      localb.aDC();
    }
    if (paramJSONObject.has("markers"))
    {
      int i;
      try
      {
        paramJSONObject = new JSONArray(paramJSONObject.optString("markers"));
        if (paramJSONObject == null)
        {
          ab.e("MicroMsg.JsApiAddMapMarkers", "markersArray is null, return");
          paramc.h(paramInt, j("fail:internal error", null));
          AppMethodBeat.o(93842);
          return;
        }
      }
      catch (JSONException paramJSONObject)
      {
        for (;;)
        {
          paramJSONObject = null;
        }
        i = 0;
      }
      for (;;)
      {
        if (i < paramJSONObject.length()) {
          try
          {
            localObject1 = (JSONObject)paramJSONObject.get(i);
            if (localObject1 != null)
            {
              localr = new b.r();
              str1 = ((JSONObject)localObject1).optString("id");
              float f1 = bo.getFloat(((JSONObject)localObject1).optString("latitude"), 0.0F);
              float f2 = bo.getFloat(((JSONObject)localObject1).optString("longitude"), 0.0F);
              double d1 = f1;
              double d2 = f2;
              localr.latitude = d1;
              localr.longitude = d2;
              localObject3 = ((JSONObject)localObject1).optString("iconPath");
              f1 = g.a((JSONObject)localObject1, "width", 0.0F);
              f2 = g.a((JSONObject)localObject1, "height", 0.0F);
              if ((!bo.isNullOrNil((String)localObject3)) && (paramc.q(com.tencent.mm.plugin.appbrand.e.b.class) != null))
              {
                localr.hPe = ((com.tencent.mm.plugin.appbrand.e.b)paramc.q(com.tencent.mm.plugin.appbrand.e.b.class)).b(paramc, (String)localObject3);
                localr.hPs = f1;
                localr.hPt = f2;
              }
              localr.rotate = ((float)((JSONObject)localObject1).optDouble("rotate", 0.0D));
              localr.alpha = ((float)((JSONObject)localObject1).optDouble("alpha", 1.0D));
              localr.data = ((JSONObject)localObject1).optString("data");
              localr.hPu = ((JSONObject)localObject1).optString("ariaLabel");
              if (!((JSONObject)localObject1).has("anchor")) {}
            }
          }
          catch (JSONException localJSONException3)
          {
            try
            {
              localObject3 = new JSONObject(((JSONObject)localObject1).optString("anchor"));
              if (localObject3 != null)
              {
                localr.O((float)((JSONObject)localObject3).optDouble("x", 0.5D), (float)((JSONObject)localObject3).optDouble("y", 1.0D));
                localr.zIndex = ((JSONObject)localObject1).optInt("zIndex", 0);
                localObject3 = ((JSONObject)localObject1).optString("label");
                if (bo.isNullOrNil((String)localObject3)) {}
              }
            }
            catch (JSONException localJSONException3)
            {
              try
              {
                localObject3 = new JSONObject((String)localObject3);
                if (localObject3 != null)
                {
                  str2 = ((JSONObject)localObject3).optString("content");
                  j = g.bA(((JSONObject)localObject3).optString("color", "#000000"), Color.parseColor("#000000"));
                  k = ((JSONObject)localObject3).optInt("fontSize", 12);
                  m = g.a((JSONObject)localObject3, "anchorX", g.a((JSONObject)localObject3, "x", 0));
                  n = g.a((JSONObject)localObject3, "anchorY", g.a((JSONObject)localObject3, "y", 0));
                  i1 = ((JSONObject)localObject3).optInt("borderRadius", 0);
                  int i2 = g.f((JSONObject)localObject3, "borderWidth");
                  int i3 = g.Fm(((JSONObject)localObject3).optString("borderColor"));
                  int i4 = g.bA(((JSONObject)localObject3).optString("bgColor", ""), Color.parseColor("#000000"));
                  int i5 = g.a((JSONObject)localObject3, "padding", 0);
                  localr.hPw = new b.r.b(str2, j, k, m, n, i4, i1, i2, i3, ((JSONObject)localObject3).optString("textAlign", ""), i5);
                }
                localObject3 = ((JSONObject)localObject1).optString("callout");
                if (bo.isNullOrNil((String)localObject3)) {}
              }
              catch (JSONException localJSONException3)
              {
                try
                {
                  for (;;)
                  {
                    b.r localr;
                    String str1;
                    String str2;
                    int j;
                    int k;
                    int m;
                    int n;
                    int i1;
                    Object localObject3 = new JSONObject((String)localObject3);
                    if (localObject3 != null)
                    {
                      str2 = ((JSONObject)localObject3).optString("content");
                      j = g.bA(((JSONObject)localObject3).optString("color", "#000000"), Color.parseColor("#000000"));
                      k = ((JSONObject)localObject3).optInt("fontSize", 12);
                      m = ((JSONObject)localObject3).optInt("borderRadius", 0);
                      n = g.f((JSONObject)localObject3, "borderWidth");
                      i1 = g.Fm(((JSONObject)localObject3).optString("borderColor"));
                      localr.hPv = new b.r.a(str2, j, k, m, g.bA(((JSONObject)localObject3).optString("bgColor", "#000000"), Color.parseColor("#000000")), n, i1, g.a((JSONObject)localObject3, "padding", 0), g.bA(((JSONObject)localObject3).optString("shadowColor", "#000000"), Color.parseColor("#000000")), ((JSONObject)localObject3).optInt("shadowOpacity"), ((JSONObject)localObject3).optInt("shadowOffsetX"), ((JSONObject)localObject3).optInt("shadowOffsetY"), ((JSONObject)localObject3).optInt("display", 0), ((JSONObject)localObject3).optString("textAlign", ""));
                    }
                    localObject3 = ((JSONObject)localObject1).optString("buildingId");
                    Object localObject1 = ((JSONObject)localObject1).optString("floorName");
                    localr.buildingId = ((String)localObject3);
                    localr.floorName = ((String)localObject1);
                    localb.a(str1, localr, (com.tencent.mm.plugin.appbrand.e.a)paramc.q(com.tencent.mm.plugin.appbrand.e.a.class));
                    i += 1;
                    break;
                    localJSONException1 = localJSONException1;
                    ab.printErrStackTrace("MicroMsg.JsApiAddMapMarkers", localJSONException1, "", new Object[0]);
                    Object localObject2 = null;
                    continue;
                    localJSONException2 = localJSONException2;
                    Object localObject4 = null;
                    continue;
                    localr.O(0.5F, 1.0F);
                  }
                  localJSONException3 = localJSONException3;
                  Object localObject5 = null;
                }
                catch (JSONException localJSONException4)
                {
                  for (;;)
                  {
                    Object localObject6 = null;
                  }
                }
              }
            }
          }
        }
      }
    }
    a(paramc, paramInt, j("ok", null), true, localb.aDx());
    AppMethodBeat.o(93842);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.g.e
 * JD-Core Version:    0.7.0.1
 */
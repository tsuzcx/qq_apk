package com.tencent.mm.plugin.appbrand.jsapi.w;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class f
{
  public static void b(View paramView, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(137891);
    if ((paramView == null) || (paramJSONObject == null))
    {
      AppMethodBeat.o(137891);
      return;
    }
    int j = com.tencent.mm.plugin.appbrand.z.g.Rq(paramJSONObject.optString("bgColor"));
    int k = com.tencent.mm.plugin.appbrand.z.g.Rq(paramJSONObject.optString("borderColor"));
    float f1 = com.tencent.mm.plugin.appbrand.z.g.a(paramJSONObject, "borderWidth", 0.0F);
    float f2 = com.tencent.mm.plugin.appbrand.z.g.a(paramJSONObject, "borderRadius", 0.0F);
    Object localObject1 = new float[4];
    if (paramJSONObject.has("borderRadius")) {}
    for (;;)
    {
      try
      {
        localObject3 = paramJSONObject.getJSONArray("borderRadius");
        if ((localObject3 == null) || (((JSONArray)localObject3).length() <= 0)) {
          continue;
        }
        i = 0;
        if (i < ((JSONArray)localObject3).length())
        {
          f3 = (float)((JSONArray)localObject3).getDouble(i);
          if (i < 4)
          {
            localObject1[i] = com.tencent.mm.plugin.appbrand.z.g.aG(f3);
            i += 1;
            continue;
          }
        }
      }
      catch (Exception localException)
      {
        Object localObject3;
        int i;
        float f3;
        localObject2 = null;
        continue;
        j = 0;
        continue;
      }
      if ((paramView instanceof g))
      {
        localObject3 = (g)paramView;
        ((g)localObject3).setBgColor(j);
        ((g)localObject3).setBorderColor(k);
        ((g)localObject3).setBorderRadius(f2);
        ((g)localObject3).setBorderWidth(f1);
        ((g)localObject3).setBorderRadius((float[])localObject1);
        j = 1;
        try
        {
          f1 = (float)paramJSONObject.getDouble("opacity");
          i = j;
          if (f1 >= 0.0F)
          {
            i = j;
            if (f1 <= 1.0F)
            {
              paramView.setAlpha(f1);
              i = 1;
            }
          }
        }
        catch (JSONException localJSONException)
        {
          int m;
          Object localObject2;
          i = j;
          continue;
        }
        localObject1 = paramJSONObject.optJSONArray("padding");
        if ((localObject1 != null) && (((JSONArray)localObject1).length() == 4))
        {
          j = com.tencent.mm.plugin.appbrand.z.g.c((JSONArray)localObject1, 0);
          k = com.tencent.mm.plugin.appbrand.z.g.c((JSONArray)localObject1, 1);
          m = com.tencent.mm.plugin.appbrand.z.g.c((JSONArray)localObject1, 2);
          paramView.setPadding(com.tencent.mm.plugin.appbrand.z.g.c((JSONArray)localObject1, 3), j, k, m);
        }
        f1 = (float)paramJSONObject.optDouble("rotate", 0.0D);
        f2 = (float)paramJSONObject.optDouble("scaleX", 1.0D);
        f3 = (float)paramJSONObject.optDouble("scaleY", 1.0D);
        if (paramJSONObject.has("rotate"))
        {
          paramView.setRotation(f1);
          i = 1;
        }
        if (paramJSONObject.has("scaleX"))
        {
          paramView.setScaleX(f2);
          i = 1;
        }
        if (paramJSONObject.has("scaleY"))
        {
          paramView.setScaleY(f3);
          i = 1;
        }
        if (i != 0) {
          paramView.invalidate();
        }
        AppMethodBeat.o(137891);
        return;
        localObject1 = null;
        continue;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.w.f
 * JD-Core Version:    0.7.0.1
 */
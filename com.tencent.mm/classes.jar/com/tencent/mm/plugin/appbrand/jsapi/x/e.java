package com.tencent.mm.plugin.appbrand.jsapi.x;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.aa.g;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class e
{
  public static void b(View paramView, JSONObject paramJSONObject)
  {
    int k = 1;
    AppMethodBeat.i(137891);
    if ((paramView == null) || (paramJSONObject == null))
    {
      AppMethodBeat.o(137891);
      return;
    }
    int i = g.Nh(paramJSONObject.optString("bgColor"));
    int j = g.Nh(paramJSONObject.optString("borderColor"));
    float f1 = g.a(paramJSONObject, "borderRadius", 0.0F);
    float f2 = g.a(paramJSONObject, "borderWidth", 0.0F);
    Object localObject;
    if ((paramView instanceof f))
    {
      localObject = (f)paramView;
      ((f)localObject).setBgColor(i);
      ((f)localObject).setBorderColor(j);
      ((f)localObject).setBorderRadius(f1);
      ((f)localObject).setBorderWidth(f2);
    }
    for (j = 1;; j = 0)
    {
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
        for (;;)
        {
          int m;
          int n;
          float f3;
          i = j;
        }
      }
      localObject = paramJSONObject.optJSONArray("padding");
      if ((localObject != null) && (((JSONArray)localObject).length() == 4))
      {
        j = g.c((JSONArray)localObject, 0);
        m = g.c((JSONArray)localObject, 1);
        n = g.c((JSONArray)localObject, 2);
        paramView.setPadding(g.c((JSONArray)localObject, 3), j, m, n);
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
        i = k;
        if (i != 0) {
          paramView.invalidate();
        }
        AppMethodBeat.o(137891);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.x.e
 * JD-Core Version:    0.7.0.1
 */
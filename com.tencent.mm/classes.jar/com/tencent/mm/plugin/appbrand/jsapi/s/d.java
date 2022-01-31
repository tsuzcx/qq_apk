package com.tencent.mm.plugin.appbrand.jsapi.s;

import android.view.View;
import com.tencent.mm.plugin.appbrand.u.h;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class d
{
  public static void a(View paramView, JSONObject paramJSONObject)
  {
    int k = 1;
    if ((paramView == null) || (paramJSONObject == null)) {
      return;
    }
    int i = h.wE(paramJSONObject.optString("bgColor"));
    int j = h.wE(paramJSONObject.optString("borderColor"));
    float f1 = h.a(paramJSONObject, "borderRadius", 0.0F);
    float f2 = h.a(paramJSONObject, "borderWidth", 0.0F);
    Object localObject;
    if ((paramView instanceof e))
    {
      localObject = (e)paramView;
      ((e)localObject).setBgColor(i);
      ((e)localObject).setBorderColor(j);
      ((e)localObject).setBorderRadius(f1);
      ((e)localObject).setBorderWidth(f2);
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
        j = h.a((JSONArray)localObject, 0);
        m = h.a((JSONArray)localObject, 1);
        n = h.a((JSONArray)localObject, 2);
        paramView.setPadding(h.a((JSONArray)localObject, 3), j, m, n);
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
        if (i == 0) {
          break;
        }
        paramView.invalidate();
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.s.d
 * JD-Core Version:    0.7.0.1
 */
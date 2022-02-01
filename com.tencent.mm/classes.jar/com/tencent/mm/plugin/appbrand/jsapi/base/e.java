package com.tencent.mm.plugin.appbrand.jsapi.base;

import android.text.TextUtils;
import com.tencent.mm.plugin.appbrand.af.i;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class e<CONTEXT extends f>
  extends c<CONTEXT>
{
  protected static float[] aa(JSONObject paramJSONObject)
  {
    float f2 = (0.0F / 0.0F);
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject(paramJSONObject.optString("position"));
        float f3 = i.a(localJSONObject, "left", 0.0F);
        float f4 = i.a(localJSONObject, "top", 0.0F);
        float f5 = i.a(localJSONObject, "width", 0.0F);
        float f6 = i.a(localJSONObject, "height", 0.0F);
        f1 = f2;
        if (paramJSONObject != null)
        {
          if (TextUtils.isEmpty("zIndex")) {
            f1 = f2;
          }
        }
        else {
          return new float[] { f3, f4, f5, f6, f1 };
        }
      }
      catch (Exception paramJSONObject)
      {
        return null;
      }
      double d = paramJSONObject.optDouble("zIndex", (0.0D / 0.0D));
      float f1 = f2;
      if (!Double.isNaN(d)) {
        f1 = (float)d;
      }
    }
  }
  
  protected static int ab(JSONObject paramJSONObject)
  {
    try
    {
      boolean bool = paramJSONObject.getBoolean("hide");
      if (bool) {
        return 4;
      }
      return 0;
    }
    catch (JSONException paramJSONObject) {}
    return -1;
  }
  
  protected static Boolean ac(JSONObject paramJSONObject)
  {
    try
    {
      boolean bool = paramJSONObject.getBoolean("fixed");
      return Boolean.valueOf(bool);
    }
    catch (JSONException paramJSONObject) {}
    return null;
  }
  
  protected static Boolean ad(JSONObject paramJSONObject)
  {
    try
    {
      boolean bool = paramJSONObject.getBoolean("fullscreen");
      return Boolean.valueOf(bool);
    }
    catch (JSONException paramJSONObject) {}
    return null;
  }
  
  protected int V(JSONObject paramJSONObject)
  {
    throw new JSONException("viewId do not exist, override the method getViewId(data).");
  }
  
  protected Boolean W(JSONObject paramJSONObject)
  {
    return null;
  }
  
  public final boolean cpE()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.base.e
 * JD-Core Version:    0.7.0.1
 */
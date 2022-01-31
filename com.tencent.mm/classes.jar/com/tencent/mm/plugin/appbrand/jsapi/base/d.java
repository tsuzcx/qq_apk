package com.tencent.mm.plugin.appbrand.jsapi.base;

import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.u.h;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class d<CONTEXT extends c>
  extends a<CONTEXT>
{
  protected static float[] q(JSONObject paramJSONObject)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject(paramJSONObject.optString("position"));
      return new float[] { h.a(localJSONObject, "left", 0.0F), h.a(localJSONObject, "top", 0.0F), h.a(localJSONObject, "width", 0.0F), h.a(localJSONObject, "height", 0.0F), paramJSONObject.optInt("zIndex", 0) };
    }
    catch (Exception paramJSONObject) {}
    return null;
  }
  
  protected static int r(JSONObject paramJSONObject)
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
  
  protected static Boolean s(JSONObject paramJSONObject)
  {
    try
    {
      boolean bool = paramJSONObject.getBoolean("fixed");
      return Boolean.valueOf(bool);
    }
    catch (JSONException paramJSONObject) {}
    return null;
  }
  
  public int p(JSONObject paramJSONObject)
  {
    throw new JSONException("viewId do not exist, override the method getViewId(data).");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.base.d
 * JD-Core Version:    0.7.0.1
 */
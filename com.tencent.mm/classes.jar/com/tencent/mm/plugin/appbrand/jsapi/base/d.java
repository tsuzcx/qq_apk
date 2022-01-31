package com.tencent.mm.plugin.appbrand.jsapi.base;

import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.s.g;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class d<CONTEXT extends c>
  extends a<CONTEXT>
{
  protected static Boolean A(JSONObject paramJSONObject)
  {
    try
    {
      boolean bool = paramJSONObject.getBoolean("fullscreen");
      return Boolean.valueOf(bool);
    }
    catch (JSONException paramJSONObject) {}
    return null;
  }
  
  protected static float[] x(JSONObject paramJSONObject)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject(paramJSONObject.optString("position"));
      return new float[] { g.a(localJSONObject, "left", 0.0F), g.a(localJSONObject, "top", 0.0F), g.a(localJSONObject, "width", 0.0F), g.a(localJSONObject, "height", 0.0F), paramJSONObject.optInt("zIndex", 0) };
    }
    catch (Exception paramJSONObject) {}
    return null;
  }
  
  protected static int y(JSONObject paramJSONObject)
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
  
  protected static Boolean z(JSONObject paramJSONObject)
  {
    try
    {
      boolean bool = paramJSONObject.getBoolean("fixed");
      return Boolean.valueOf(bool);
    }
    catch (JSONException paramJSONObject) {}
    return null;
  }
  
  protected int w(JSONObject paramJSONObject)
  {
    throw new JSONException("viewId do not exist, override the method getViewId(data).");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.base.d
 * JD-Core Version:    0.7.0.1
 */
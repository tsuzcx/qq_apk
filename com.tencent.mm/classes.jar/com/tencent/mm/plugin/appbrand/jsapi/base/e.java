package com.tencent.mm.plugin.appbrand.jsapi.base;

import com.tencent.mm.plugin.appbrand.ac.g;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class e<CONTEXT extends f>
  extends d<CONTEXT>
{
  protected static float[] L(JSONObject paramJSONObject)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject(paramJSONObject.optString("position"));
      return new float[] { g.a(localJSONObject, "left", 0.0F), g.a(localJSONObject, "top", 0.0F), g.a(localJSONObject, "width", 0.0F), g.a(localJSONObject, "height", 0.0F), paramJSONObject.optInt("zIndex", 0) };
    }
    catch (Exception paramJSONObject) {}
    return null;
  }
  
  protected static int M(JSONObject paramJSONObject)
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
  
  protected static Boolean N(JSONObject paramJSONObject)
  {
    try
    {
      boolean bool = paramJSONObject.getBoolean("fixed");
      return Boolean.valueOf(bool);
    }
    catch (JSONException paramJSONObject) {}
    return null;
  }
  
  protected static Boolean O(JSONObject paramJSONObject)
  {
    try
    {
      boolean bool = paramJSONObject.getBoolean("fullscreen");
      return Boolean.valueOf(bool);
    }
    catch (JSONException paramJSONObject) {}
    return null;
  }
  
  protected int H(JSONObject paramJSONObject)
  {
    throw new JSONException("viewId do not exist, override the method getViewId(data).");
  }
  
  protected Boolean I(JSONObject paramJSONObject)
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.base.e
 * JD-Core Version:    0.7.0.1
 */
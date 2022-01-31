package com.tencent.mm.plugin.appbrand.jsapi.s;

import com.tencent.mm.plugin.appbrand.u.h;
import org.json.JSONException;
import org.json.JSONObject;

public final class c$f
{
  public int id;
  public float x;
  public float y;
  
  public c$f() {}
  
  public c$f(int paramInt, float paramFloat1, float paramFloat2)
  {
    this.id = paramInt;
    this.x = paramFloat1;
    this.y = paramFloat2;
  }
  
  public final void a(int paramInt, float paramFloat1, float paramFloat2)
  {
    this.id = paramInt;
    this.x = paramFloat1;
    this.y = paramFloat2;
  }
  
  public final JSONObject rB()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("id", this.id);
      localJSONObject.put("x", h.al(this.x));
      localJSONObject.put("y", h.al(this.y));
      return localJSONObject;
    }
    catch (JSONException localJSONException) {}
    return localJSONObject;
  }
  
  public final String toString()
  {
    return rB().toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.s.c.f
 * JD-Core Version:    0.7.0.1
 */
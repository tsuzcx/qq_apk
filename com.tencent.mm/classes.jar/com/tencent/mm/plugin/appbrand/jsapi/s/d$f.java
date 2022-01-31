package com.tencent.mm.plugin.appbrand.jsapi.s;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.s.g;
import org.json.JSONException;
import org.json.JSONObject;

public final class d$f
{
  public int id;
  public float x;
  public float y;
  
  public d$f() {}
  
  public d$f(int paramInt, float paramFloat1, float paramFloat2)
  {
    this.id = paramInt;
    this.x = paramFloat1;
    this.y = paramFloat2;
  }
  
  public final void b(int paramInt, float paramFloat1, float paramFloat2)
  {
    this.id = paramInt;
    this.x = paramFloat1;
    this.y = paramFloat2;
  }
  
  public final JSONObject toJSONObject()
  {
    AppMethodBeat.i(91076);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("id", this.id);
      localJSONObject.put("x", g.az(this.x));
      localJSONObject.put("y", g.az(this.y));
      label54:
      AppMethodBeat.o(91076);
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      break label54;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(91077);
    String str = toJSONObject().toString();
    AppMethodBeat.o(91077);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.s.d.f
 * JD-Core Version:    0.7.0.1
 */
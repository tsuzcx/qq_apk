package com.tencent.mm.plugin.appbrand.jsapi.x;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.aa.g;
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
    AppMethodBeat.i(140687);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("id", this.id);
      localJSONObject.put("x", g.aB(this.x));
      localJSONObject.put("y", g.aB(this.y));
      label54:
      AppMethodBeat.o(140687);
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      break label54;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(140688);
    String str = toJSONObject().toString();
    AppMethodBeat.o(140688);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.x.d.f
 * JD-Core Version:    0.7.0.1
 */
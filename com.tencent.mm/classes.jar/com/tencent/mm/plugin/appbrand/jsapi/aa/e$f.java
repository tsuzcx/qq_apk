package com.tencent.mm.plugin.appbrand.jsapi.aa;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.y.g;
import org.json.JSONException;
import org.json.JSONObject;

public final class e$f
{
  public int id;
  public float x;
  public float y;
  
  public e$f() {}
  
  public e$f(int paramInt, float paramFloat1, float paramFloat2)
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
      localJSONObject.put("x", g.aI(this.x));
      localJSONObject.put("y", g.aI(this.y));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.aa.e.f
 * JD-Core Version:    0.7.0.1
 */
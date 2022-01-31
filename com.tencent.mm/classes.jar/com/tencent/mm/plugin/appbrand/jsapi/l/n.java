package com.tencent.mm.plugin.appbrand.jsapi.l;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.page.b.d.a;
import com.tencent.mm.plugin.appbrand.s.g;
import org.json.JSONObject;

public final class n
  extends j<com.tencent.mm.plugin.appbrand.d, com.tencent.mm.plugin.appbrand.page.b.d>
{
  public static final int CTRL_INDEX = 453;
  public static final String NAME = "setBackgroundColor";
  
  public n()
  {
    super(com.tencent.mm.plugin.appbrand.page.b.d.class);
  }
  
  private String a(JSONObject paramJSONObject, com.tencent.mm.plugin.appbrand.page.b.d paramd)
  {
    AppMethodBeat.i(141751);
    paramJSONObject = paramJSONObject.optString("backgroundColor", "");
    try
    {
      int i = g.Fn(paramJSONObject);
      paramd.a(d.a.iAw, i);
      paramJSONObject = j("ok", null);
      AppMethodBeat.o(141751);
      return paramJSONObject;
    }
    catch (Exception paramJSONObject)
    {
      paramJSONObject = j("fail:invalid color", null);
      AppMethodBeat.o(141751);
    }
    return paramJSONObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.l.n
 * JD-Core Version:    0.7.0.1
 */
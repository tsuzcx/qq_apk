package com.tencent.mm.plugin.appbrand.luggage.export.functionalpage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;
import d.l;
import d.n.n;
import org.json.JSONException;
import org.json.JSONObject;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"makeReturnJson", "", "apiName", "plugin-appbrand-integration_release"})
public final class d
{
  static final String dU(String paramString1, String paramString2)
  {
    int i = 1;
    AppMethodBeat.i(189354);
    try
    {
      String str = new JSONObject(paramString1).getString("errMsg");
      p.g(str, "this.getString(\"errMsg\")");
      boolean bool = n.nz(str, paramString2 + ':');
      if (bool) {
        i = 0;
      }
    }
    catch (JSONException localJSONException)
    {
      label60:
      break label60;
    }
    if (i != 0)
    {
      paramString1 = new JSONObject().put("errMsg", paramString2 + ':' + paramString1).toString();
      p.g(paramString1, "JSONObject().put(\"errMsg…ame}:${this}\").toString()");
      AppMethodBeat.o(189354);
      return paramString1;
    }
    AppMethodBeat.o(189354);
    return paramString1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.d
 * JD-Core Version:    0.7.0.1
 */
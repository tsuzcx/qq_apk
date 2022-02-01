package com.tencent.mm.plugin.appbrand.luggage.export.functionalpage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;
import org.json.JSONException;
import org.json.JSONObject;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"makeReturnJson", "", "apiName", "plugin-appbrand-integration_release"})
public final class d
{
  static final String en(String paramString1, String paramString2)
  {
    int i = 0;
    AppMethodBeat.i(228833);
    for (;;)
    {
      try
      {
        String str = new JSONObject(paramString1).getString("errMsg");
        p.g(str, "this.getString(\"errMsg\")");
        boolean bool = n.J(str, paramString2 + ':', false);
        if (!bool) {
          break label129;
        }
      }
      catch (JSONException localJSONException)
      {
        i = 1;
        continue;
        AppMethodBeat.o(228833);
        return paramString1;
      }
      if (i != 0)
      {
        paramString1 = new JSONObject().put("errMsg", paramString2 + ':' + paramString1).toString();
        p.g(paramString1, "JSONObject().put(\"errMsg…ame}:${this}\").toString()");
        AppMethodBeat.o(228833);
        return paramString1;
      }
      label129:
      i = 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.d
 * JD-Core Version:    0.7.0.1
 */
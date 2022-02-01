package com.tencent.mm.plugin.appbrand.luggage.export.functionalpage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;
import org.json.JSONException;
import org.json.JSONObject;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"makeReturnJson", "", "apiName", "plugin-appbrand-integration_release"})
public final class d
{
  static final String eB(String paramString1, String paramString2)
  {
    int i = 0;
    AppMethodBeat.i(276611);
    for (;;)
    {
      try
      {
        String str = new JSONObject(paramString1).getString("errMsg");
        p.j(str, "this.getString(\"errMsg\")");
        boolean bool = n.M(str, paramString2 + ':', false);
        if (!bool) {
          break label129;
        }
      }
      catch (JSONException localJSONException)
      {
        i = 1;
        continue;
        AppMethodBeat.o(276611);
        return paramString1;
      }
      if (i != 0)
      {
        paramString1 = new JSONObject().put("errMsg", paramString2 + ':' + paramString1).toString();
        p.j(paramString1, "JSONObject().put(\"errMsg…ame}:${this}\").toString()");
        AppMethodBeat.o(276611);
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
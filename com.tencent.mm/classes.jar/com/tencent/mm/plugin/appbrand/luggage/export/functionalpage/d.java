package com.tencent.mm.plugin.appbrand.luggage.export.functionalpage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.n.n;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"makeReturnJson", "", "apiName", "plugin-appbrand-integration_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class d
{
  static final String eS(String paramString1, String paramString2)
  {
    int i = 0;
    AppMethodBeat.i(320023);
    for (;;)
    {
      try
      {
        String str = new JSONObject(paramString1).getString("errMsg");
        s.s(str, "this.getString(\"errMsg\")");
        boolean bool = n.U(str, s.X(paramString2, ":"), false);
        if (!bool) {
          break label116;
        }
      }
      catch (JSONException localJSONException)
      {
        i = 1;
        continue;
        AppMethodBeat.o(320023);
        return paramString1;
      }
      if (i != 0)
      {
        paramString1 = new JSONObject().put("errMsg", paramString2 + ':' + paramString1).toString();
        s.s(paramString1, "{\n        JSONObject().p…{this}\").toString()\n    }");
        AppMethodBeat.o(320023);
        return paramString1;
      }
      label116:
      i = 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.d
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.appbrand.jsapi.l;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.d;
import com.tencent.mm.plugin.appbrand.jsapi.bw;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.jsapi.u;
import com.tencent.mm.plugin.appbrand.s.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import org.json.JSONObject;

public final class q
  extends u<d>
{
  public static final int CTRL_INDEX = 198;
  public static final String NAME = "setNavigationBarColor";
  
  private String a(d paramd, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(141758);
    int j;
    int k;
    double d;
    int i;
    for (;;)
    {
      try
      {
        j = g.Fn(paramJSONObject.getString("frontColor"));
        k = g.Fn(paramJSONObject.getString("backgroundColor"));
        d = paramJSONObject.optDouble("alpha", 1.0D);
        paramJSONObject = paramJSONObject.optJSONObject("animation");
        if (paramJSONObject != null)
        {
          i = paramJSONObject.optInt("duration");
          paramJSONObject = paramJSONObject.optString("timingFunc");
          paramd = bw.l(paramd);
          if (paramd != null) {
            break;
          }
          paramd = j("fail:page don't exist", null);
          AppMethodBeat.o(141758);
          return paramd;
        }
      }
      catch (Exception paramd)
      {
        ab.e("MicroMsg.JsApiSetNavigationBarColor", "Color parse error");
        paramd = j("fail:invalid color", null);
        AppMethodBeat.o(141758);
        return paramd;
      }
      i = 0;
      paramJSONObject = "";
    }
    al.d(new q.1(this, paramd, paramJSONObject, k, i, j, d));
    paramd = j("ok", null);
    AppMethodBeat.o(141758);
    return paramd;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.l.q
 * JD-Core Version:    0.7.0.1
 */
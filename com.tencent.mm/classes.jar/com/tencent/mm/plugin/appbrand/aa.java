package com.tencent.mm.plugin.appbrand;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import org.json.JSONObject;

public final class aa
  implements com.tencent.mm.plugin.appbrand.jsapi.base.g
{
  public final e c(c paramc, JSONObject paramJSONObject)
  {
    int i = 1;
    AppMethodBeat.i(43977);
    if ((paramc instanceof e))
    {
      paramc = (e)paramc;
      AppMethodBeat.o(43977);
      return paramc;
    }
    if ((paramc instanceof r))
    {
      if (paramJSONObject != null) {
        if (paramJSONObject.optInt("dest", 0) != 1) {}
      }
      while (i != 0)
      {
        paramc = (r)paramc;
        if (paramc.jDh != null)
        {
          paramc = paramc.jDh;
          AppMethodBeat.o(43977);
          return paramc;
          i = 0;
          continue;
          i = 0;
        }
        else
        {
          paramc.jDh = new com.tencent.mm.plugin.appbrand.ad.g(paramc);
          paramc = paramc.jDh;
          AppMethodBeat.o(43977);
          return paramc;
        }
      }
      paramc = ((r)paramc).getCurrentPageView();
      AppMethodBeat.o(43977);
      return paramc;
    }
    AppMethodBeat.o(43977);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.aa
 * JD-Core Version:    0.7.0.1
 */
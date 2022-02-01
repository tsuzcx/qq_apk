package com.tencent.mm.plugin.appbrand;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.base.g;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import org.json.JSONObject;

final class z
  implements g
{
  public final e c(c paramc, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(134624);
    if ((paramc instanceof e))
    {
      paramc = (e)paramc;
      AppMethodBeat.o(134624);
      return paramc;
    }
    if ((paramc instanceof q))
    {
      paramc = ((q)paramc).getCurrentPageView();
      AppMethodBeat.o(134624);
      return paramc;
    }
    AppMethodBeat.o(134624);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.z
 * JD-Core Version:    0.7.0.1
 */
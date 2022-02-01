package com.tencent.mm.plugin.appbrand;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import org.json.JSONObject;

final class ae
  implements com.tencent.mm.plugin.appbrand.jsapi.base.g
{
  public final com.tencent.mm.plugin.appbrand.jsapi.g c(e parame, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(134624);
    if ((parame instanceof com.tencent.mm.plugin.appbrand.jsapi.g))
    {
      parame = (com.tencent.mm.plugin.appbrand.jsapi.g)parame;
      AppMethodBeat.o(134624);
      return parame;
    }
    if ((parame instanceof v))
    {
      parame = ((v)parame).getCurrentPageView();
      AppMethodBeat.o(134624);
      return parame;
    }
    AppMethodBeat.o(134624);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ae
 * JD-Core Version:    0.7.0.1
 */
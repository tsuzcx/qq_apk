package com.tencent.mm.plugin.appbrand;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.base.g;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.h;
import org.json.JSONObject;

final class aa
  implements g
{
  public final h c(f paramf, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(134624);
    if ((paramf instanceof h))
    {
      paramf = (h)paramf;
      AppMethodBeat.o(134624);
      return paramf;
    }
    if ((paramf instanceof s))
    {
      paramf = ((s)paramf).getCurrentPageView();
      AppMethodBeat.o(134624);
      return paramf;
    }
    AppMethodBeat.o(134624);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.aa
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.appbrand;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.h;
import com.tencent.mm.plugin.appbrand.page.ac;
import org.json.JSONObject;

public final class ab
  implements com.tencent.mm.plugin.appbrand.jsapi.base.g
{
  public final h c(f paramf, JSONObject paramJSONObject)
  {
    int j = 1;
    AppMethodBeat.i(43977);
    int i;
    if ((paramf instanceof ac))
    {
      if (paramJSONObject != null) {
        if (paramJSONObject.optInt("dest", 0) == 2) {
          i = 1;
        }
      }
      while (i != 0)
      {
        paramf = ((ac)paramf).bRo();
        AppMethodBeat.o(43977);
        return paramf;
        i = 0;
        continue;
        i = 0;
      }
    }
    if ((paramf instanceof h))
    {
      paramf = (h)paramf;
      AppMethodBeat.o(43977);
      return paramf;
    }
    if ((paramf instanceof s))
    {
      if (paramJSONObject != null) {
        if (paramJSONObject.optInt("dest", 0) == 1) {
          i = j;
        }
      }
      while (i != 0)
      {
        paramf = (s)paramf;
        if (paramf.kEi != null)
        {
          paramf = paramf.kEi;
          AppMethodBeat.o(43977);
          return paramf;
          i = 0;
          continue;
          i = 0;
        }
        else
        {
          paramf.kEi = new com.tencent.mm.plugin.appbrand.ad.g(paramf);
          paramf = paramf.kEi;
          AppMethodBeat.o(43977);
          return paramf;
        }
      }
      paramf = ((s)paramf).getCurrentPageView();
      AppMethodBeat.o(43977);
      return paramf;
    }
    AppMethodBeat.o(43977);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ab
 * JD-Core Version:    0.7.0.1
 */
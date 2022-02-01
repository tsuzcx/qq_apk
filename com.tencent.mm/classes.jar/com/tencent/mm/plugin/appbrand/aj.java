package com.tencent.mm.plugin.appbrand;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.h;
import com.tencent.mm.plugin.appbrand.page.ad;
import com.tencent.mm.plugin.appbrand.service.c;
import org.json.JSONObject;

public final class aj
  implements com.tencent.mm.plugin.appbrand.jsapi.base.g
{
  public final h c(f paramf, JSONObject paramJSONObject)
  {
    int j = 1;
    AppMethodBeat.i(43977);
    int i;
    if ((paramf instanceof ad))
    {
      if (paramJSONObject != null) {
        if (paramJSONObject.optInt("dest", 0) == 2) {
          i = 1;
        }
      }
      while (i != 0)
      {
        paramf = ((ad)paramf).cEK();
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
    if ((paramf instanceof y))
    {
      if (paramJSONObject != null) {
        if (paramJSONObject.optInt("dest", 0) == 1) {
          i = j;
        }
      }
      while (i != 0)
      {
        paramf = (c)paramf;
        if (paramf.tTs != null)
        {
          paramf = paramf.tTs;
          AppMethodBeat.o(43977);
          return paramf;
          i = 0;
          continue;
          i = 0;
        }
        else
        {
          paramf.tTs = new com.tencent.mm.plugin.appbrand.ad.g(paramf, paramf.getRuntime().qvK);
          paramf = paramf.tTs;
          AppMethodBeat.o(43977);
          return paramf;
        }
      }
      paramf = ((c)paramf).ccK();
      AppMethodBeat.o(43977);
      return paramf;
    }
    AppMethodBeat.o(43977);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.aj
 * JD-Core Version:    0.7.0.1
 */
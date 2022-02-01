package com.tencent.mm.plugin.appbrand;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.page.ad;
import com.tencent.mm.plugin.appbrand.service.c;
import org.json.JSONObject;

public final class af
  implements com.tencent.mm.plugin.appbrand.jsapi.base.g
{
  public final com.tencent.mm.plugin.appbrand.jsapi.g c(e parame, JSONObject paramJSONObject)
  {
    int j = 1;
    AppMethodBeat.i(43977);
    int i;
    if ((parame instanceof ad))
    {
      if (paramJSONObject != null) {
        if (paramJSONObject.optInt("dest", 0) == 2) {
          i = 1;
        }
      }
      while (i != 0)
      {
        parame = ((ad)parame).cef();
        AppMethodBeat.o(43977);
        return parame;
        i = 0;
        continue;
        i = 0;
      }
    }
    if ((parame instanceof com.tencent.mm.plugin.appbrand.jsapi.g))
    {
      parame = (com.tencent.mm.plugin.appbrand.jsapi.g)parame;
      AppMethodBeat.o(43977);
      return parame;
    }
    if ((parame instanceof v))
    {
      if (paramJSONObject != null) {
        if (paramJSONObject.optInt("dest", 0) == 1) {
          i = j;
        }
      }
      while (i != 0)
      {
        parame = (c)parame;
        if (parame.qOF != null)
        {
          parame = parame.qOF;
          AppMethodBeat.o(43977);
          return parame;
          i = 0;
          continue;
          i = 0;
        }
        else
        {
          parame.qOF = new com.tencent.mm.plugin.appbrand.ad.g(parame, parame.getRuntime().nwF);
          parame = parame.qOF;
          AppMethodBeat.o(43977);
          return parame;
        }
      }
      parame = ((c)parame).bDv();
      AppMethodBeat.o(43977);
      return parame;
    }
    AppMethodBeat.o(43977);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.af
 * JD-Core Version:    0.7.0.1
 */
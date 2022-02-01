package com.tencent.mm.plugin.lite.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.topstory.a.h;
import com.tencent.mm.sdk.platformtools.aj;
import org.json.JSONObject;

public class a
  extends com.tencent.mm.plugin.lite.jsapi.a
{
  public final int cXg()
  {
    return 1;
  }
  
  public final void j(String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(217196);
    com.tencent.mm.sdk.platformtools.ad.i("LiteAppJsApiDoGoToRecVideoList", "doGoToRecVideoList");
    try
    {
      paramString = h.aS(paramJSONObject);
      com.tencent.mm.plugin.websearch.api.ad.b(aj.getContext(), paramString);
      AppMethodBeat.o(217196);
      return;
    }
    catch (Exception paramString)
    {
      com.tencent.mm.sdk.platformtools.ad.printErrStackTrace("LiteAppJsApiDoGoToRecVideoList", paramString, "doGoToRecVideoList", new Object[0]);
      AppMethodBeat.o(217196);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.lite.e.a
 * JD-Core Version:    0.7.0.1
 */
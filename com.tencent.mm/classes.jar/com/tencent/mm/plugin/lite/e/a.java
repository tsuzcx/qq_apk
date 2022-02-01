package com.tencent.mm.plugin.lite.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.topstory.a.h;
import com.tencent.mm.plugin.websearch.api.ad;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import org.json.JSONObject;

public class a
  extends com.tencent.mm.plugin.lite.jsapi.a
{
  public final int cZP()
  {
    return 1;
  }
  
  public final void j(String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(217817);
    ae.i("LiteAppJsApiDoGoToRecVideoList", "doGoToRecVideoList");
    try
    {
      paramString = h.aS(paramJSONObject);
      ad.b(ak.getContext(), paramString);
      AppMethodBeat.o(217817);
      return;
    }
    catch (Exception paramString)
    {
      ae.printErrStackTrace("LiteAppJsApiDoGoToRecVideoList", paramString, "doGoToRecVideoList", new Object[0]);
      AppMethodBeat.o(217817);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.lite.e.a
 * JD-Core Version:    0.7.0.1
 */
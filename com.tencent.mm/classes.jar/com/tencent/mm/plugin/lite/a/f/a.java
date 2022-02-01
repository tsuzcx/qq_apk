package com.tencent.mm.plugin.lite.a.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.lite.api.e;
import com.tencent.mm.plugin.topstory.a.g;
import com.tencent.mm.plugin.websearch.api.aj;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import org.json.JSONObject;

public class a
  extends e
{
  public final void a(String paramString, JSONObject paramJSONObject, boolean paramBoolean)
  {
    AppMethodBeat.i(271495);
    Log.i("LiteAppJsApiDoGoToRecVideoList", "doGoToRecVideoList");
    try
    {
      paramString = g.bS(paramJSONObject);
      aj.b(MMApplicationContext.getContext(), paramString);
      AppMethodBeat.o(271495);
      return;
    }
    catch (Exception paramString)
    {
      Log.printErrStackTrace("LiteAppJsApiDoGoToRecVideoList", paramString, "doGoToRecVideoList", new Object[0]);
      AppMethodBeat.o(271495);
    }
  }
  
  public final int fEx()
  {
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.lite.a.f.a
 * JD-Core Version:    0.7.0.1
 */
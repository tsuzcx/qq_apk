package com.tencent.mm.plugin.lite.jsapi.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.lite.jsapi.b;
import com.tencent.mm.plugin.topstory.a.h;
import com.tencent.mm.plugin.websearch.api.ai;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import org.json.JSONObject;

public class a
  extends b
{
  public final void a(String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(198847);
    Log.i("LiteAppJsApiDoGoToRecVideoList", "doGoToRecVideoList");
    try
    {
      paramString = h.br(paramJSONObject);
      ai.b(MMApplicationContext.getContext(), paramString);
      AppMethodBeat.o(198847);
      return;
    }
    catch (Exception paramString)
    {
      Log.printErrStackTrace("LiteAppJsApiDoGoToRecVideoList", paramString, "doGoToRecVideoList", new Object[0]);
      AppMethodBeat.o(198847);
    }
  }
  
  public final int dTw()
  {
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.lite.jsapi.b.a
 * JD-Core Version:    0.7.0.1
 */
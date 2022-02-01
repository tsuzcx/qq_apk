package com.tencent.mm.plugin.lite.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.topstory.a.h;
import com.tencent.mm.plugin.websearch.api.z;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import org.json.JSONObject;

public class a
  extends com.tencent.mm.plugin.lite.jsapi.a
{
  public void invoke(String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(205717);
    ac.i("LiteAppJsApiDoGoToRecVideoList", "doGoToRecVideoList");
    try
    {
      paramString = h.aK(paramJSONObject);
      z.b(ai.getContext(), paramString);
      AppMethodBeat.o(205717);
      return;
    }
    catch (Exception paramString)
    {
      ac.printErrStackTrace("LiteAppJsApiDoGoToRecVideoList", paramString, "doGoToRecVideoList", new Object[0]);
      AppMethodBeat.o(205717);
    }
  }
  
  public int runModel()
  {
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.lite.e.a
 * JD-Core Version:    0.7.0.1
 */
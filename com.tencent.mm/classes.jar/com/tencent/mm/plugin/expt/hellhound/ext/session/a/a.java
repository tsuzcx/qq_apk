package com.tencent.mm.plugin.expt.hellhound.ext.session.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONException;
import org.json.JSONObject;

public final class a
{
  public static JSONObject ac(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(122089);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("businessId", paramString3);
      localJSONObject.put("dataPath", paramString1);
      localJSONObject.put("value", paramString2);
      AppMethodBeat.o(122089);
      return localJSONObject;
    }
    catch (JSONException paramString1)
    {
      Log.printErrStackTrace("HABBYGE-MALI.AsyncBizCollector", paramString1, "AsyncBizCollector, generateParamJSONOBject, %s", new Object[] { paramString1.getMessage() });
      AppMethodBeat.o(122089);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.ext.session.a.a
 * JD-Core Version:    0.7.0.1
 */
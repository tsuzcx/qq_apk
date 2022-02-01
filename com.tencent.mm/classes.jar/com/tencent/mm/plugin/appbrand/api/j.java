package com.tencent.mm.plugin.appbrand.api;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONException;
import org.json.JSONObject;

public final class j
  implements d
{
  public boolean nPb;
  
  public final String toJsonString()
  {
    AppMethodBeat.i(319280);
    try
    {
      new JSONObject();
      String str = new JSONObject().put("isPrivateMessage", this.nPb).toString();
      AppMethodBeat.o(319280);
      return str;
    }
    catch (JSONException localJSONException)
    {
      Log.printErrStackTrace("MicroMsg.WeAppPrivateMessageNativeExtraData", localJSONException, "", new Object[0]);
      AppMethodBeat.o(319280);
    }
    return "{}";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.api.j
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.appbrand.api;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONException;
import org.json.JSONObject;

public final class j
  implements d
{
  public boolean ivg;
  
  public final String bua()
  {
    AppMethodBeat.i(194335);
    try
    {
      new JSONObject();
      String str = new JSONObject().put("isPrivateMessage", this.ivg).toString();
      AppMethodBeat.o(194335);
      return str;
    }
    catch (JSONException localJSONException)
    {
      Log.printErrStackTrace("MicroMsg.WeAppPrivateMessageNativeExtraData", localJSONException, "", new Object[0]);
      AppMethodBeat.o(194335);
    }
    return "{}";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.api.j
 * JD-Core Version:    0.7.0.1
 */
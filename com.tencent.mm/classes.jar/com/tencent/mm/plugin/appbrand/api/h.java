package com.tencent.mm.plugin.appbrand.api;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import org.json.JSONException;
import org.json.JSONObject;

public final class h
  implements d
{
  public boolean hAZ;
  
  public final String aYO()
  {
    AppMethodBeat.i(200271);
    try
    {
      Object localObject = new JSONObject();
      ((JSONObject)localObject).put("isPrivateMessage", this.hAZ);
      localObject = new JSONObject().put("location", localObject).toString();
      AppMethodBeat.o(200271);
      return localObject;
    }
    catch (JSONException localJSONException)
    {
      ae.printErrStackTrace("MicroMsg.WeAppPrivateMessageNativeExtraData", localJSONException, "", new Object[0]);
      AppMethodBeat.o(200271);
    }
    return "{}";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.api.h
 * JD-Core Version:    0.7.0.1
 */
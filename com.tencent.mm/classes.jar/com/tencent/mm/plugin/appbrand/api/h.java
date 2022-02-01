package com.tencent.mm.plugin.appbrand.api;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import org.json.JSONException;
import org.json.JSONObject;

public final class h
  implements d
{
  public boolean hyl;
  
  public final String aYt()
  {
    AppMethodBeat.i(218879);
    try
    {
      Object localObject = new JSONObject();
      ((JSONObject)localObject).put("isPrivateMessage", this.hyl);
      localObject = new JSONObject().put("location", localObject).toString();
      AppMethodBeat.o(218879);
      return localObject;
    }
    catch (JSONException localJSONException)
    {
      ad.printErrStackTrace("MicroMsg.WeAppPrivateMessageNativeExtraData", localJSONException, "", new Object[0]);
      AppMethodBeat.o(218879);
    }
    return "{}";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.api.h
 * JD-Core Version:    0.7.0.1
 */
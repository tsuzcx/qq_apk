package com.tencent.mm.plugin.appbrand.api;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import org.json.JSONException;
import org.json.JSONObject;

public final class g
  implements d
{
  public float dBu;
  public float dzE;
  public String jGd;
  
  public final String aYO()
  {
    AppMethodBeat.i(153193);
    try
    {
      Object localObject = new JSONObject();
      ((JSONObject)localObject).put("latitude", this.dzE);
      ((JSONObject)localObject).put("longitude", this.dBu);
      ((JSONObject)localObject).put("name", this.jGd);
      localObject = new JSONObject().put("location", localObject).toString();
      AppMethodBeat.o(153193);
      return localObject;
    }
    catch (JSONException localJSONException)
    {
      ae.printErrStackTrace("MicroMsg.WeAppOpenPoiNativeExtraData", localJSONException, "", new Object[0]);
      AppMethodBeat.o(153193);
    }
    return "{}";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.api.g
 * JD-Core Version:    0.7.0.1
 */
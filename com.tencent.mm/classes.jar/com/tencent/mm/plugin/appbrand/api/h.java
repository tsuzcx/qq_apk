package com.tencent.mm.plugin.appbrand.api;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONException;
import org.json.JSONObject;

public final class h
  implements d
{
  public float latitude;
  public float longitude;
  public String poiName;
  
  public final String bFa()
  {
    AppMethodBeat.i(153193);
    try
    {
      Object localObject = new JSONObject();
      ((JSONObject)localObject).put("latitude", this.latitude);
      ((JSONObject)localObject).put("longitude", this.longitude);
      ((JSONObject)localObject).put("name", this.poiName);
      localObject = new JSONObject().put("location", localObject).toString();
      AppMethodBeat.o(153193);
      return localObject;
    }
    catch (JSONException localJSONException)
    {
      Log.printErrStackTrace("MicroMsg.WeAppOpenPoiNativeExtraData", localJSONException, "", new Object[0]);
      AppMethodBeat.o(153193);
    }
    return "{}";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.api.h
 * JD-Core Version:    0.7.0.1
 */
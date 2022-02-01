package com.tencent.mm.plugin.appbrand.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import org.json.JSONException;
import org.json.JSONObject;

public final class g
  implements d
{
  public float dmL;
  public float doB;
  public String gPy;
  
  public final String aUZ()
  {
    AppMethodBeat.i(153193);
    try
    {
      Object localObject = new JSONObject();
      ((JSONObject)localObject).put("latitude", this.dmL);
      ((JSONObject)localObject).put("longitude", this.doB);
      ((JSONObject)localObject).put("name", this.gPy);
      localObject = new JSONObject().put("location", localObject).toString();
      AppMethodBeat.o(153193);
      return localObject;
    }
    catch (JSONException localJSONException)
    {
      ac.printErrStackTrace("MicroMsg.WeAppOpenPoiNativeExtraData", localJSONException, "", new Object[0]);
      AppMethodBeat.o(153193);
    }
    return "{}";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.a.g
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.luckymoney.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bom;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import org.json.JSONException;
import org.json.JSONObject;

public final class av
{
  public au vCT;
  public bom vzN;
  
  public static av aqc(String paramString)
  {
    AppMethodBeat.i(65312);
    if (bu.isNullOrNil(paramString))
    {
      AppMethodBeat.o(65312);
      return null;
    }
    try
    {
      av localav = new av();
      paramString = new JSONObject(paramString);
      JSONObject localJSONObject = paramString.optJSONObject("operation");
      if (localJSONObject != null) {
        localav.vCT = x.aF(localJSONObject);
      }
      localav.vzN = x.aG(paramString.optJSONObject("source"));
      AppMethodBeat.o(65312);
      return localav;
    }
    catch (JSONException paramString)
    {
      ae.printErrStackTrace("MicroMsg.ShowSourceOpen", paramString, "", new Object[0]);
      AppMethodBeat.o(65312);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.model.av
 * JD-Core Version:    0.7.0.1
 */
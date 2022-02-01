package com.tencent.mm.plugin.luckymoney.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bfu;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import org.json.JSONException;
import org.json.JSONObject;

public final class av
{
  public bfu tcN;
  public au tfV;
  
  public static av afq(String paramString)
  {
    AppMethodBeat.i(65312);
    if (bt.isNullOrNil(paramString))
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
        localav.tfV = x.av(localJSONObject);
      }
      localav.tcN = x.aw(paramString.optJSONObject("source"));
      AppMethodBeat.o(65312);
      return localav;
    }
    catch (JSONException paramString)
    {
      ad.printErrStackTrace("MicroMsg.ShowSourceOpen", paramString, "", new Object[0]);
      AppMethodBeat.o(65312);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.model.av
 * JD-Core Version:    0.7.0.1
 */
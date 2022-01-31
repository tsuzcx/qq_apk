package com.tencent.mm.plugin.luckymoney.model;

import com.tencent.luggage.g.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.aus;
import com.tencent.mm.sdk.platformtools.bo;
import org.json.JSONException;
import org.json.JSONObject;

public final class at
{
  public aus omW;
  public as opQ;
  
  public static at Sv(String paramString)
  {
    AppMethodBeat.i(42424);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(42424);
      return null;
    }
    try
    {
      at localat = new at();
      paramString = new JSONObject(paramString);
      JSONObject localJSONObject = paramString.optJSONObject("operation");
      if (localJSONObject != null) {
        localat.opQ = v.ag(localJSONObject);
      }
      localat.omW = v.ah(paramString.optJSONObject("source"));
      AppMethodBeat.o(42424);
      return localat;
    }
    catch (JSONException paramString)
    {
      d.printErrStackTrace("MicroMsg.ShowSourceOpen", paramString, "", new Object[0]);
      AppMethodBeat.o(42424);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.model.at
 * JD-Core Version:    0.7.0.1
 */
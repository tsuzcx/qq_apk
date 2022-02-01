package com.tencent.mm.plugin.luckymoney.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bjm;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import org.json.JSONException;
import org.json.JSONObject;

public final class av
{
  public bjm ulc;
  public au uok;
  
  public static av akk(String paramString)
  {
    AppMethodBeat.i(65312);
    if (bs.isNullOrNil(paramString))
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
        localav.uok = x.aw(localJSONObject);
      }
      localav.ulc = x.ax(paramString.optJSONObject("source"));
      AppMethodBeat.o(65312);
      return localav;
    }
    catch (JSONException paramString)
    {
      ac.printErrStackTrace("MicroMsg.ShowSourceOpen", paramString, "", new Object[0]);
      AppMethodBeat.o(65312);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.model.av
 * JD-Core Version:    0.7.0.1
 */
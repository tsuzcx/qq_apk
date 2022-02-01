package com.tencent.mm.plugin.luckymoney.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.cbe;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import org.json.JSONException;
import org.json.JSONObject;

public final class bh
{
  public cbe yUC;
  public bg yXV;
  
  public static bh aDy(String paramString)
  {
    AppMethodBeat.i(65312);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(65312);
      return null;
    }
    try
    {
      bh localbh = new bh();
      paramString = new JSONObject(paramString);
      JSONObject localJSONObject = paramString.optJSONObject("operation");
      if (localJSONObject != null) {
        localbh.yXV = ac.ba(localJSONObject);
      }
      localbh.yUC = ac.bb(paramString.optJSONObject("source"));
      AppMethodBeat.o(65312);
      return localbh;
    }
    catch (JSONException paramString)
    {
      Log.printErrStackTrace("MicroMsg.ShowSourceOpen", paramString, "", new Object[0]);
      AppMethodBeat.o(65312);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.model.bh
 * JD-Core Version:    0.7.0.1
 */
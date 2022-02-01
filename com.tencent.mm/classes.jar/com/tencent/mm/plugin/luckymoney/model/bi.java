package com.tencent.mm.plugin.luckymoney.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.cjf;
import com.tencent.mm.protocal.protobuf.cjj;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

public final class bi
{
  public bh ECa;
  public ArrayList<cjj> ECb;
  public cjf Eyz;
  
  public static bi aNH(String paramString)
  {
    AppMethodBeat.i(65312);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(65312);
      return null;
    }
    try
    {
      bi localbi = new bi();
      paramString = new JSONObject(paramString);
      JSONObject localJSONObject = paramString.optJSONObject("operation");
      if (localJSONObject != null) {
        localbi.ECa = ad.bh(localJSONObject);
      }
      localbi.Eyz = ad.bi(paramString.optJSONObject("source"));
      localbi.ECb = ad.B(paramString.optJSONArray("upright_corner_list"));
      AppMethodBeat.o(65312);
      return localbi;
    }
    catch (JSONException paramString)
    {
      Log.printErrStackTrace("MicroMsg.ShowSourceOpen", paramString, "", new Object[0]);
      AppMethodBeat.o(65312);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.model.bi
 * JD-Core Version:    0.7.0.1
 */
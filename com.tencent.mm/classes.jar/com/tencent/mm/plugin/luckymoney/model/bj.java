package com.tencent.mm.plugin.luckymoney.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.czi;
import com.tencent.mm.protocal.protobuf.czm;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

public final class bj
{
  public czi Krm;
  public bi Kvb;
  public ArrayList<czm> Kvc;
  
  public static bj aKE(String paramString)
  {
    AppMethodBeat.i(65312);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(65312);
      return null;
    }
    try
    {
      bj localbj = new bj();
      paramString = new JSONObject(paramString);
      JSONObject localJSONObject = paramString.optJSONObject("operation");
      if (localJSONObject != null) {
        localbj.Kvb = ae.bv(localJSONObject);
      }
      localbj.Krm = ae.bx(paramString.optJSONObject("source"));
      localbj.Kvc = ae.F(paramString.optJSONArray("upright_corner_list"));
      AppMethodBeat.o(65312);
      return localbj;
    }
    catch (JSONException paramString)
    {
      Log.printErrStackTrace("MicroMsg.ShowSourceOpen", paramString, "", new Object[0]);
      AppMethodBeat.o(65312);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.model.bj
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.luckymoney.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bnu;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import org.json.JSONException;
import org.json.JSONObject;

public final class e
{
  public bnu vnI;
  public String vnJ;
  public boolean vnK;
  public String vnL;
  
  public static e aoS(String paramString)
  {
    AppMethodBeat.i(65164);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(65164);
      return null;
    }
    try
    {
      JSONObject localJSONObject = new JSONObject(paramString);
      paramString = new e();
      paramString.vnJ = localJSONObject.optString("showSourceMac");
      paramString.vnL = localJSONObject.optString("illegal_msg");
      paramString.vnK = localJSONObject.optBoolean("is_illegal");
      localJSONObject = localJSONObject.optJSONObject("showSource");
      if (localJSONObject != null) {
        paramString.vnI = x.aG(localJSONObject);
      }
      AppMethodBeat.o(65164);
      return paramString;
    }
    catch (JSONException paramString)
    {
      ad.printErrStackTrace("MicroMsg.EnvelopSourceMac", paramString, "", new Object[0]);
      AppMethodBeat.o(65164);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.model.e
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.luckymoney.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bfu;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import org.json.JSONException;
import org.json.JSONObject;

public final class e
{
  public bfu tcN;
  public String tcO;
  public boolean tcP;
  public String tcQ;
  
  public static e afl(String paramString)
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
      paramString.tcO = localJSONObject.optString("showSourceMac");
      paramString.tcQ = localJSONObject.optString("illegal_msg");
      paramString.tcP = localJSONObject.optBoolean("is_illegal");
      localJSONObject = localJSONObject.optJSONObject("showSource");
      if (localJSONObject != null) {
        paramString.tcN = x.aw(localJSONObject);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.model.e
 * JD-Core Version:    0.7.0.1
 */
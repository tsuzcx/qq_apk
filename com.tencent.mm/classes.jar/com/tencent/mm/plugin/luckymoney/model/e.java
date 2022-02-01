package com.tencent.mm.plugin.luckymoney.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bom;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import org.json.JSONException;
import org.json.JSONObject;

public final class e
{
  public bom vzN;
  public String vzO;
  public boolean vzP;
  public String vzQ;
  
  public static e apX(String paramString)
  {
    AppMethodBeat.i(65164);
    if (bu.isNullOrNil(paramString))
    {
      AppMethodBeat.o(65164);
      return null;
    }
    try
    {
      JSONObject localJSONObject = new JSONObject(paramString);
      paramString = new e();
      paramString.vzO = localJSONObject.optString("showSourceMac");
      paramString.vzQ = localJSONObject.optString("illegal_msg");
      paramString.vzP = localJSONObject.optBoolean("is_illegal");
      localJSONObject = localJSONObject.optJSONObject("showSource");
      if (localJSONObject != null) {
        paramString.vzN = x.aG(localJSONObject);
      }
      AppMethodBeat.o(65164);
      return paramString;
    }
    catch (JSONException paramString)
    {
      ae.printErrStackTrace("MicroMsg.EnvelopSourceMac", paramString, "", new Object[0]);
      AppMethodBeat.o(65164);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.model.e
 * JD-Core Version:    0.7.0.1
 */
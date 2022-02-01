package com.tencent.mm.plugin.luckymoney.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bjm;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import org.json.JSONException;
import org.json.JSONObject;

public final class e
{
  public bjm ulc;
  public String uld;
  public boolean ule;
  public String ulf;
  
  public static e akf(String paramString)
  {
    AppMethodBeat.i(65164);
    if (bs.isNullOrNil(paramString))
    {
      AppMethodBeat.o(65164);
      return null;
    }
    try
    {
      JSONObject localJSONObject = new JSONObject(paramString);
      paramString = new e();
      paramString.uld = localJSONObject.optString("showSourceMac");
      paramString.ulf = localJSONObject.optString("illegal_msg");
      paramString.ule = localJSONObject.optBoolean("is_illegal");
      localJSONObject = localJSONObject.optJSONObject("showSource");
      if (localJSONObject != null) {
        paramString.ulc = x.ax(localJSONObject);
      }
      AppMethodBeat.o(65164);
      return paramString;
    }
    catch (JSONException paramString)
    {
      ac.printErrStackTrace("MicroMsg.EnvelopSourceMac", paramString, "", new Object[0]);
      AppMethodBeat.o(65164);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.model.e
 * JD-Core Version:    0.7.0.1
 */
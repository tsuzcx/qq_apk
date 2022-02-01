package com.tencent.mm.plugin.luckymoney.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.cbe;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import org.json.JSONException;
import org.json.JSONObject;

public final class h
{
  public cbe yUC;
  public String yUD;
  public boolean yUE;
  public String yUF;
  
  public static h aDt(String paramString)
  {
    AppMethodBeat.i(65164);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(65164);
      return null;
    }
    try
    {
      JSONObject localJSONObject = new JSONObject(paramString);
      paramString = new h();
      paramString.yUD = localJSONObject.optString("showSourceMac");
      paramString.yUF = localJSONObject.optString("illegal_msg");
      paramString.yUE = localJSONObject.optBoolean("is_illegal");
      localJSONObject = localJSONObject.optJSONObject("showSource");
      if (localJSONObject != null) {
        paramString.yUC = ac.bb(localJSONObject);
      }
      AppMethodBeat.o(65164);
      return paramString;
    }
    catch (JSONException paramString)
    {
      Log.printErrStackTrace("MicroMsg.EnvelopSourceMac", paramString, "", new Object[0]);
      AppMethodBeat.o(65164);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.model.h
 * JD-Core Version:    0.7.0.1
 */
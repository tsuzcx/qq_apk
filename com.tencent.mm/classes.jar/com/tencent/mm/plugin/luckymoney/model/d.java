package com.tencent.mm.plugin.luckymoney.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.aus;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import org.json.JSONException;
import org.json.JSONObject;

public final class d
{
  public aus omW;
  public String omX;
  public boolean omY;
  public String omZ;
  
  public static d Sq(String paramString)
  {
    AppMethodBeat.i(42273);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(42273);
      return null;
    }
    try
    {
      JSONObject localJSONObject = new JSONObject(paramString);
      paramString = new d();
      paramString.omX = localJSONObject.optString("showSourceMac");
      paramString.omZ = localJSONObject.optString("illegal_msg");
      paramString.omY = localJSONObject.optBoolean("is_illegal");
      localJSONObject = localJSONObject.optJSONObject("showSource");
      if (localJSONObject != null) {
        paramString.omW = v.ah(localJSONObject);
      }
      AppMethodBeat.o(42273);
      return paramString;
    }
    catch (JSONException paramString)
    {
      ab.printErrStackTrace("MicroMsg.EnvelopSourceMac", paramString, "", new Object[0]);
      AppMethodBeat.o(42273);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.model.d
 * JD-Core Version:    0.7.0.1
 */
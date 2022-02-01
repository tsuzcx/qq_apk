package com.tencent.mm.plugin.mall.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONObject;

public final class d
{
  public String KIY;
  public int KIZ;
  public String KJa;
  
  public d(String paramString)
  {
    AppMethodBeat.i(65990);
    this.KIY = "";
    this.KIZ = 0;
    this.KJa = "";
    try
    {
      paramString = new JSONObject(paramString);
      this.KIY = paramString.optString("eu_protocol_url");
      this.KIZ = paramString.optInt("0");
      this.KJa = paramString.optString("wxpay_protocol_url");
      AppMethodBeat.o(65990);
      return;
    }
    catch (Exception paramString)
    {
      Log.printErrStackTrace("MciroMsg.EUInfo", paramString, "", new Object[0]);
      AppMethodBeat.o(65990);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.mall.a.d
 * JD-Core Version:    0.7.0.1
 */
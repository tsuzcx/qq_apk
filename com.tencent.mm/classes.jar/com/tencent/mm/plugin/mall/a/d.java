package com.tencent.mm.plugin.mall.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import org.json.JSONObject;

public final class d
{
  public String oxF;
  public int oxG;
  public String oxH;
  
  public d(String paramString)
  {
    AppMethodBeat.i(43095);
    this.oxF = "";
    this.oxG = 0;
    this.oxH = "";
    try
    {
      paramString = new JSONObject(paramString);
      this.oxF = paramString.optString("eu_protocol_url");
      this.oxG = paramString.optInt("0");
      this.oxH = paramString.optString("wxpay_protocol_url");
      AppMethodBeat.o(43095);
      return;
    }
    catch (Exception paramString)
    {
      ab.printErrStackTrace("MciroMsg.EUInfo", paramString, "", new Object[0]);
      AppMethodBeat.o(43095);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.mall.a.d
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.mall.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import org.json.JSONObject;

public final class d
{
  public String tsf;
  public int tsg;
  public String tsh;
  
  public d(String paramString)
  {
    AppMethodBeat.i(65990);
    this.tsf = "";
    this.tsg = 0;
    this.tsh = "";
    try
    {
      paramString = new JSONObject(paramString);
      this.tsf = paramString.optString("eu_protocol_url");
      this.tsg = paramString.optInt("0");
      this.tsh = paramString.optString("wxpay_protocol_url");
      AppMethodBeat.o(65990);
      return;
    }
    catch (Exception paramString)
    {
      ad.printErrStackTrace("MciroMsg.EUInfo", paramString, "", new Object[0]);
      AppMethodBeat.o(65990);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.mall.a.d
 * JD-Core Version:    0.7.0.1
 */
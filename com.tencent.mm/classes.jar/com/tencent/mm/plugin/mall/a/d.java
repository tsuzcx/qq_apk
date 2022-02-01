package com.tencent.mm.plugin.mall.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import org.json.JSONObject;

public final class d
{
  public String vDb;
  public int vDc;
  public String vDd;
  
  public d(String paramString)
  {
    AppMethodBeat.i(65990);
    this.vDb = "";
    this.vDc = 0;
    this.vDd = "";
    try
    {
      paramString = new JSONObject(paramString);
      this.vDb = paramString.optString("eu_protocol_url");
      this.vDc = paramString.optInt("0");
      this.vDd = paramString.optString("wxpay_protocol_url");
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
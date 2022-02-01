package com.tencent.mm.plugin.mall.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import org.json.JSONObject;

public final class d
{
  public String vPf;
  public int vPg;
  public String vPh;
  
  public d(String paramString)
  {
    AppMethodBeat.i(65990);
    this.vPf = "";
    this.vPg = 0;
    this.vPh = "";
    try
    {
      paramString = new JSONObject(paramString);
      this.vPf = paramString.optString("eu_protocol_url");
      this.vPg = paramString.optInt("0");
      this.vPh = paramString.optString("wxpay_protocol_url");
      AppMethodBeat.o(65990);
      return;
    }
    catch (Exception paramString)
    {
      ae.printErrStackTrace("MciroMsg.EUInfo", paramString, "", new Object[0]);
      AppMethodBeat.o(65990);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.mall.a.d
 * JD-Core Version:    0.7.0.1
 */
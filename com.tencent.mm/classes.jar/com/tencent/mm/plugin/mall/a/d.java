package com.tencent.mm.plugin.mall.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import org.json.JSONObject;

public final class d
{
  public String uAA;
  public String uAy;
  public int uAz;
  
  public d(String paramString)
  {
    AppMethodBeat.i(65990);
    this.uAy = "";
    this.uAz = 0;
    this.uAA = "";
    try
    {
      paramString = new JSONObject(paramString);
      this.uAy = paramString.optString("eu_protocol_url");
      this.uAz = paramString.optInt("0");
      this.uAA = paramString.optString("wxpay_protocol_url");
      AppMethodBeat.o(65990);
      return;
    }
    catch (Exception paramString)
    {
      ac.printErrStackTrace("MciroMsg.EUInfo", paramString, "", new Object[0]);
      AppMethodBeat.o(65990);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.mall.a.d
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.mall.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONObject;

public final class d
{
  public String zjj;
  public int zjk;
  public String zjl;
  
  public d(String paramString)
  {
    AppMethodBeat.i(65990);
    this.zjj = "";
    this.zjk = 0;
    this.zjl = "";
    try
    {
      paramString = new JSONObject(paramString);
      this.zjj = paramString.optString("eu_protocol_url");
      this.zjk = paramString.optInt("0");
      this.zjl = paramString.optString("wxpay_protocol_url");
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.mall.a.d
 * JD-Core Version:    0.7.0.1
 */
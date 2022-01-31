package com.tencent.mm.plugin.mall.a;

import com.tencent.mm.sdk.platformtools.y;
import org.json.JSONObject;

public final class a
{
  public String lYe = "";
  public int lYf = 0;
  public String lYg = "";
  
  public a(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString);
      this.lYe = paramString.optString("eu_protocol_url");
      this.lYf = paramString.optInt("0");
      this.lYg = paramString.optString("wxpay_protocol_url");
      return;
    }
    catch (Exception paramString)
    {
      y.printErrStackTrace("MciroMsg.EUInfo", paramString, "", new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.mall.a.a
 * JD-Core Version:    0.7.0.1
 */
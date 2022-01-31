package com.tencent.mm.plugin.collect.b;

import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.wallet_core.tenpay.model.j;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class s
  extends j
{
  public String bHY;
  public String desc;
  public String iHO = null;
  public double iHP;
  
  public s(double paramDouble, String paramString1, String paramString2)
  {
    HashMap localHashMap = new HashMap();
    try
    {
      localHashMap.put("fee", Math.round(100.0D * paramDouble));
      localHashMap.put("fee_type", paramString1);
      localHashMap.put("desc", URLEncoder.encode(paramString2, "UTF-8"));
      this.iHP = paramDouble;
      this.bHY = paramString1;
      this.desc = paramString2;
      D(localHashMap);
      return;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      for (;;)
      {
        y.printErrStackTrace("Micromsg.NetSceneTenpayRemittanceQuery", localUnsupportedEncodingException, "", new Object[0]);
      }
    }
  }
  
  public final int HH()
  {
    return 1623;
  }
  
  public final void a(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    y.d("Micromsg.NetSceneTenpayRemittanceQuery", "errCode " + paramInt + " errMsg: " + paramString);
    if (paramInt != 0) {
      return;
    }
    this.iHO = paramJSONObject.optString("pay_url");
  }
  
  public final int aEC()
  {
    return 0;
  }
  
  public final String getUri()
  {
    return "/cgi-bin/mmpay-bin/transfersetf2ffee";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.b.s
 * JD-Core Version:    0.7.0.1
 */
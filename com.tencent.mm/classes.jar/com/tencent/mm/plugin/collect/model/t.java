package com.tencent.mm.plugin.collect.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.wallet_core.c.ag;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class t
  extends m
{
  public String dem;
  public String desc;
  public String nUe;
  public double nUf;
  public int nUg;
  
  public t(double paramDouble, String paramString1, String paramString2)
  {
    AppMethodBeat.i(63848);
    this.nUe = null;
    HashMap localHashMap = new HashMap();
    try
    {
      localHashMap.put("fee", Math.round(100.0D * paramDouble));
      localHashMap.put("fee_type", paramString1);
      localHashMap.put("desc", URLEncoder.encode(paramString2, "UTF-8"));
      this.nUf = paramDouble;
      this.dem = paramString1;
      this.desc = paramString2;
      setRequestData(localHashMap);
      AppMethodBeat.o(63848);
      return;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      for (;;)
      {
        ad.printErrStackTrace("Micromsg.NetSceneTenpayRemittanceQuery", localUnsupportedEncodingException, "", new Object[0]);
      }
    }
  }
  
  public final int getFuncId()
  {
    return 1623;
  }
  
  public final int getTenpayCgicmd()
  {
    return 0;
  }
  
  public final String getUri()
  {
    return "/cgi-bin/mmpay-bin/transfersetf2ffee";
  }
  
  public final void onGYNetEnd(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(63849);
    ad.d("Micromsg.NetSceneTenpayRemittanceQuery", "errCode " + paramInt + " errMsg: " + paramString);
    if (paramInt != 0)
    {
      AppMethodBeat.o(63849);
      return;
    }
    this.nUe = paramJSONObject.optString("pay_url");
    this.nUg = ag.abv(paramJSONObject.optInt("qrcode_level"));
    ad.i("Micromsg.NetSceneTenpayRemittanceQuery", "qrcodeLevel:%s ", new Object[] { Integer.valueOf(this.nUg) });
    AppMethodBeat.o(63849);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.model.t
 * JD-Core Version:    0.7.0.1
 */
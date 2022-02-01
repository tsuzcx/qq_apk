package com.tencent.mm.plugin.collect.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.c.ag;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class u
  extends m
{
  public String desc;
  public String fyc;
  public String tVJ;
  public double tVK;
  public int tVL;
  
  public u(double paramDouble, String paramString1, String paramString2)
  {
    AppMethodBeat.i(63848);
    this.tVJ = null;
    HashMap localHashMap = new HashMap();
    try
    {
      localHashMap.put("fee", Math.round(100.0D * paramDouble));
      localHashMap.put("fee_type", paramString1);
      localHashMap.put("desc", URLEncoder.encode(paramString2, "UTF-8"));
      this.tVK = paramDouble;
      this.fyc = paramString1;
      this.desc = paramString2;
      setRequestData(localHashMap);
      AppMethodBeat.o(63848);
      return;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      for (;;)
      {
        Log.printErrStackTrace("Micromsg.NetSceneTenpayRemittanceQuery", localUnsupportedEncodingException, "", new Object[0]);
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
    Log.d("Micromsg.NetSceneTenpayRemittanceQuery", "errCode " + paramInt + " errMsg: " + paramString);
    if (paramInt != 0)
    {
      AppMethodBeat.o(63849);
      return;
    }
    this.tVJ = paramJSONObject.optString("pay_url");
    this.tVL = ag.azH(paramJSONObject.optInt("qrcode_level"));
    Log.i("Micromsg.NetSceneTenpayRemittanceQuery", "qrcodeLevel:%s ", new Object[] { Integer.valueOf(this.tVL) });
    AppMethodBeat.o(63849);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.model.u
 * JD-Core Version:    0.7.0.1
 */
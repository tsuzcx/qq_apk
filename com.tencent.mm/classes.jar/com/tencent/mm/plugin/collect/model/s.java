package com.tencent.mm.plugin.collect.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.utils.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class s
  extends m
{
  public String cpp;
  public String desc;
  public String kNR;
  public double kNS;
  public int kNT;
  
  public s(double paramDouble, String paramString1, String paramString2)
  {
    AppMethodBeat.i(40996);
    this.kNR = null;
    HashMap localHashMap = new HashMap();
    try
    {
      localHashMap.put("fee", Math.round(100.0D * paramDouble));
      localHashMap.put("fee_type", paramString1);
      localHashMap.put("desc", URLEncoder.encode(paramString2, "UTF-8"));
      this.kNS = paramDouble;
      this.cpp = paramString1;
      this.desc = paramString2;
      setRequestData(localHashMap);
      AppMethodBeat.o(40996);
      return;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      for (;;)
      {
        ab.printErrStackTrace("Micromsg.NetSceneTenpayRemittanceQuery", localUnsupportedEncodingException, "", new Object[0]);
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
    AppMethodBeat.i(40997);
    ab.d("Micromsg.NetSceneTenpayRemittanceQuery", "errCode " + paramInt + " errMsg: " + paramString);
    if (paramInt != 0)
    {
      AppMethodBeat.o(40997);
      return;
    }
    this.kNR = paramJSONObject.optString("pay_url");
    this.kNT = c.IK(paramJSONObject.optInt("qrcode_level"));
    ab.i("Micromsg.NetSceneTenpayRemittanceQuery", "qrcodeLevel:%s ", new Object[] { Integer.valueOf(this.kNT) });
    AppMethodBeat.o(40997);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.model.s
 * JD-Core Version:    0.7.0.1
 */
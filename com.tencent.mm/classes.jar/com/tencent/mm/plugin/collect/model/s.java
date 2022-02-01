package com.tencent.mm.plugin.collect.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.model.ah;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class s
  extends m
{
  public String desc;
  public String hCH;
  public String wZd;
  public double wZe;
  public int wZf;
  
  public s(double paramDouble, String paramString1, String paramString2)
  {
    AppMethodBeat.i(63848);
    this.wZd = null;
    HashMap localHashMap = new HashMap();
    try
    {
      localHashMap.put("fee", Math.round(100.0D * paramDouble));
      localHashMap.put("fee_type", paramString1);
      localHashMap.put("desc", URLEncoder.encode(paramString2, "UTF-8"));
      this.wZe = paramDouble;
      this.hCH = paramString1;
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
    this.wZd = paramJSONObject.optString("pay_url");
    this.wZf = ah.aGs(paramJSONObject.optInt("qrcode_level"));
    this.desc = paramJSONObject.optString("desc");
    Log.i("Micromsg.NetSceneTenpayRemittanceQuery", "qrcodeLevel:%s ", new Object[] { Integer.valueOf(this.wZf) });
    AppMethodBeat.o(63849);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.model.s
 * JD-Core Version:    0.7.0.1
 */
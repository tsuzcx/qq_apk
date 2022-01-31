package com.tencent.mm.plugin.appbrand.config;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.List;
import org.json.JSONObject;

public final class WxaAttributes$a
{
  public long bDL = 0L;
  public int fmF;
  public long hcP = 0L;
  public int hix;
  public String hiy;
  public String hjM;
  public int hjN;
  public List<String> hjO;
  public List<String> hjP;
  public List<String> hjQ;
  public List<String> hjR;
  public List<String> hjS;
  public String hjT;
  
  public static a AB(String paramString)
  {
    AppMethodBeat.i(96159);
    if (bo.isNullOrNil(paramString))
    {
      ab.e("MicroMsg.AppBrand.WxaAttributes", "getAppInfo, json is EMPTY");
      AppMethodBeat.o(96159);
      return null;
    }
    try
    {
      JSONObject localJSONObject1 = new JSONObject(paramString);
      a locala = new a();
      JSONObject localJSONObject2 = localJSONObject1.optJSONObject("RunningFlagInfo");
      if (localJSONObject2 != null)
      {
        locala.bDL = localJSONObject2.optLong("RunningFlag");
        locala.hjM = localJSONObject2.optString("AppOpenForbiddenUrl");
        locala.hcP = localJSONObject2.optLong("CanNotStarWxaBeforeTime", 0L);
      }
      localJSONObject2 = localJSONObject1.optJSONObject("Network");
      if (localJSONObject2 != null)
      {
        locala.hjO = u.m(localJSONObject2.optJSONArray("RequestDomain"));
        locala.hjP = u.m(localJSONObject2.optJSONArray("WsRequestDomain"));
        locala.hjQ = u.m(localJSONObject2.optJSONArray("UploadDomain"));
        locala.hjR = u.m(localJSONObject2.optJSONArray("DownloadDomain"));
        locala.hjS = u.m(localJSONObject2.optJSONArray("UDPDomain"));
      }
      locala.hjN = localJSONObject1.optInt("WechatPluginApp", 0);
      locala.fmF = localJSONObject1.optInt("AppServiceType", 0);
      locala.hjT = localJSONObject1.optString("fromBusinessUsername");
      locala.hix = localJSONObject1.optInt("OriginalFlag", 0);
      locala.hiy = localJSONObject1.optString("OriginalRedirectUrl");
      paramString = locala;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ab.e("MicroMsg.AppBrand.WxaAttributes", "getAppInfo, json(%s) parse failed ex = %s", new Object[] { paramString, localException });
        paramString = null;
      }
    }
    AppMethodBeat.o(96159);
    return paramString;
  }
  
  public final boolean ayH()
  {
    return this.hjN > 0;
  }
  
  public final boolean vY()
  {
    return this.fmF == 4;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.config.WxaAttributes.a
 * JD-Core Version:    0.7.0.1
 */
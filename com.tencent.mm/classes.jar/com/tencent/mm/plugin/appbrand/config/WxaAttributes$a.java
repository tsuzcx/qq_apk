package com.tencent.mm.plugin.appbrand.config;

import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.List;
import org.json.JSONObject;

public final class WxaAttributes$a
{
  public String dTW;
  public int dWx;
  public long fKa = 0L;
  public String fRb;
  public int fRc;
  public List<String> fRd;
  public List<String> fRe;
  public List<String> fRf;
  public List<String> fRg;
  public String fRh;
  
  public static a sH(String paramString)
  {
    if (bk.bl(paramString))
    {
      y.e("MicroMsg.AppBrand.WxaAttributes", "getAppInfo, json is EMPTY");
      return null;
    }
    try
    {
      JSONObject localJSONObject1 = new JSONObject(paramString);
      a locala = new a();
      JSONObject localJSONObject2 = localJSONObject1.optJSONObject("RunningFlagInfo");
      if (localJSONObject2 != null)
      {
        locala.fKa = localJSONObject2.optLong("RunningFlag");
        locala.fRb = localJSONObject2.optString("AppOpenForbiddenUrl");
      }
      localJSONObject2 = localJSONObject1.optJSONObject("Network");
      if (localJSONObject2 != null)
      {
        locala.fRd = t.j(localJSONObject2.optJSONArray("RequestDomain"));
        locala.fRe = t.j(localJSONObject2.optJSONArray("WsRequestDomain"));
        locala.fRf = t.j(localJSONObject2.optJSONArray("UploadDomain"));
        locala.fRg = t.j(localJSONObject2.optJSONArray("DownloadDomain"));
      }
      locala.dTW = localJSONObject1.optString("Template");
      locala.fRc = localJSONObject1.optInt("WechatPluginApp", 0);
      locala.dWx = localJSONObject1.optInt("AppServiceType", 0);
      locala.fRh = localJSONObject1.optString("fromBusinessUsername");
      paramString = locala;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        y.e("MicroMsg.AppBrand.WxaAttributes", "getAppInfo, json(%s) parse failed ex = %s", new Object[] { paramString, localException });
        paramString = null;
      }
    }
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.config.WxaAttributes.a
 * JD-Core Version:    0.7.0.1
 */
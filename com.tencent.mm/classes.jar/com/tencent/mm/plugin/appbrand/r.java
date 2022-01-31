package com.tencent.mm.plugin.appbrand;

import com.tencent.mm.compatible.util.q;
import com.tencent.mm.plugin.appbrand.config.WxaExposedParams;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.io.UnsupportedEncodingException;
import java.util.Locale;

public enum r
{
  public static String a(WxaExposedParams paramWxaExposedParams)
  {
    if ((paramWxaExposedParams == null) || (bk.bl(paramWxaExposedParams.appId)))
    {
      y.e("MicroMsg.AppBrandUrlBuilders", "buildExposeUrl fail, null or nil appId");
      return "";
    }
    try
    {
      paramWxaExposedParams = String.format("https://mp.weixin.qq.com/mp/wacomplain?action=show&appid=%s&pageid=%s&from=%d&version_type=%d&version_code=%d#wechat_redirect", new Object[] { paramWxaExposedParams.appId, q.encode(bk.pm(paramWxaExposedParams.bUo), "UTF-8"), Integer.valueOf(paramWxaExposedParams.from), Integer.valueOf(bk.e(Integer.valueOf(paramWxaExposedParams.fEM), -1)), Integer.valueOf(bk.e(Integer.valueOf(paramWxaExposedParams.fEN), -1)) });
      return paramWxaExposedParams;
    }
    catch (UnsupportedEncodingException paramWxaExposedParams)
    {
      y.e("MicroMsg.AppBrandUrlBuilders", "buildExposeUrl encode fail, invalid arguments");
    }
    return "";
  }
  
  public static String qL(String paramString)
  {
    return String.format(Locale.US, "https://mp.weixin.qq.com/mp/waerrpage?appid=%s&type=overseas#wechat_redirect", new Object[] { paramString });
  }
  
  public static String qM(String paramString)
  {
    if (bk.bl(paramString))
    {
      y.e("MicroMsg.AppBrandUrlBuilders", "buildEntityUrl fail, null or nil appId");
      return "";
    }
    return String.format("https://mp.weixin.qq.com/mp/waverifyinfo?action=get&appid=%s#wechat_redirect", new Object[] { paramString });
  }
  
  public static String qN(String paramString)
  {
    if (bk.bl(paramString))
    {
      y.e("MicroMsg.AppBrandUrlBuilders", "buildLowVersionUrl fail, invalid arguments");
      return "";
    }
    return String.format(Locale.US, "https://mp.weixin.qq.com/mp/waerrpage?appid=%s&type=upgrade&upgradetype=%d#wechat_redirect", new Object[] { paramString, Integer.valueOf(3) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.r
 * JD-Core Version:    0.7.0.1
 */
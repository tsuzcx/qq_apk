package com.tencent.mm.plugin.appbrand;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.p;
import com.tencent.mm.plugin.appbrand.config.WxaExposedParams;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.util.Locale;

public enum u
{
  public static String Ds(String paramString)
  {
    AppMethodBeat.i(43968);
    paramString = String.format(Locale.US, "https://mp.weixin.qq.com/mp/waerrpage?appid=%s&type=overseas#wechat_redirect", new Object[] { paramString });
    AppMethodBeat.o(43968);
    return paramString;
  }
  
  public static String Dt(String paramString)
  {
    AppMethodBeat.i(43971);
    if (bt.isNullOrNil(paramString))
    {
      ad.e("MicroMsg.AppBrandUrlBuilders", "buildEntityUrl fail, null or nil appId");
      AppMethodBeat.o(43971);
      return "";
    }
    paramString = String.format("https://mp.weixin.qq.com/mp/waverifyinfo?action=get&appid=%s#wechat_redirect", new Object[] { paramString });
    AppMethodBeat.o(43971);
    return paramString;
  }
  
  public static String Du(String paramString)
  {
    AppMethodBeat.i(43972);
    if (bt.isNullOrNil(paramString))
    {
      ad.e("MicroMsg.AppBrandUrlBuilders", "buildLowVersionUrl fail, invalid arguments");
      AppMethodBeat.o(43972);
      return "";
    }
    paramString = String.format(Locale.US, "https://mp.weixin.qq.com/mp/waerrpage?appid=%s&type=upgrade&upgradetype=%d#wechat_redirect", new Object[] { paramString, Integer.valueOf(3) });
    AppMethodBeat.o(43972);
    return paramString;
  }
  
  public static String a(WxaExposedParams paramWxaExposedParams)
  {
    AppMethodBeat.i(43969);
    if ((paramWxaExposedParams == null) || (bt.isNullOrNil(paramWxaExposedParams.appId)))
    {
      ad.e("MicroMsg.AppBrandUrlBuilders", "buildFeedbackUrl fail, null or nil appId");
      AppMethodBeat.o(43969);
      return "";
    }
    try
    {
      paramWxaExposedParams = String.format("https://mp.weixin.qq.com/wxawap/wapreportwxadevlog?action=complain_feedback&appid=%s&pageid=%s&from=%d&version_type=%d&version_code=%d&screenshot_localId=%s&sessionid=%s#wechat_redirect", new Object[] { paramWxaExposedParams.appId, p.encode(bt.nullAsNil(paramWxaExposedParams.pageId), "UTF-8"), Integer.valueOf(paramWxaExposedParams.from), Integer.valueOf(bt.i(Integer.valueOf(paramWxaExposedParams.iOQ), -1)), Integer.valueOf(bt.i(Integer.valueOf(paramWxaExposedParams.pkgVersion), -1)), p.encode(bt.nullAsNil(paramWxaExposedParams.jfV), "UTF-8"), bt.nullAsNil(paramWxaExposedParams.sessionId) });
      AppMethodBeat.o(43969);
      return paramWxaExposedParams;
    }
    catch (UnsupportedEncodingException paramWxaExposedParams)
    {
      ad.e("MicroMsg.AppBrandUrlBuilders", "buildFeedbackUrl encode fail, invalid arguments");
      AppMethodBeat.o(43969);
    }
    return "";
  }
  
  public static String b(WxaExposedParams paramWxaExposedParams)
  {
    AppMethodBeat.i(43970);
    if ((paramWxaExposedParams == null) || (bt.isNullOrNil(paramWxaExposedParams.appId)))
    {
      ad.e("MicroMsg.AppBrandUrlBuilders", "buildExposeUrl fail, null or nil appId");
      AppMethodBeat.o(43970);
      return "";
    }
    try
    {
      paramWxaExposedParams = String.format("https://mp.weixin.qq.com/mp/wacomplain?action=show&appid=%s&pageid=%s&from=%d&version_type=%d&version_code=%d#wechat_redirect", new Object[] { paramWxaExposedParams.appId, p.encode(bt.nullAsNil(paramWxaExposedParams.pageId), "UTF-8"), Integer.valueOf(paramWxaExposedParams.from), Integer.valueOf(bt.i(Integer.valueOf(paramWxaExposedParams.iOQ), -1)), Integer.valueOf(bt.i(Integer.valueOf(paramWxaExposedParams.pkgVersion), -1)) });
      AppMethodBeat.o(43970);
      return paramWxaExposedParams;
    }
    catch (UnsupportedEncodingException paramWxaExposedParams)
    {
      ad.e("MicroMsg.AppBrandUrlBuilders", "buildExposeUrl encode fail, invalid arguments");
      AppMethodBeat.o(43970);
    }
    return "";
  }
  
  public static String bO(String paramString1, String paramString2)
  {
    AppMethodBeat.i(43973);
    paramString1 = new URI(paramString1);
    String str = paramString1.getQuery();
    if (str == null) {}
    for (;;)
    {
      paramString1 = new URI(paramString1.getScheme(), paramString1.getAuthority(), paramString1.getPath(), paramString2, paramString1.getFragment()).toString();
      AppMethodBeat.o(43973);
      return paramString1;
      paramString2 = str + "&" + paramString2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.u
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.appbrand;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.q;
import com.tencent.mm.plugin.appbrand.config.WxaExposedParams;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.util.Locale;

public enum v
{
  public static String a(WxaExposedParams paramWxaExposedParams)
  {
    AppMethodBeat.i(129126);
    if ((paramWxaExposedParams == null) || (bo.isNullOrNil(paramWxaExposedParams.appId)))
    {
      ab.e("MicroMsg.AppBrandUrlBuilders", "buildFeedbackUrl fail, null or nil appId");
      AppMethodBeat.o(129126);
      return "";
    }
    try
    {
      paramWxaExposedParams = String.format("https://mp.weixin.qq.com/wxawap/wapreportwxadevlog?action=complain_feedback&appid=%s&pageid=%s&from=%d&version_type=%d&version_code=%d#wechat_redirect", new Object[] { paramWxaExposedParams.appId, q.encode(bo.nullAsNil(paramWxaExposedParams.pageId), "UTF-8"), Integer.valueOf(paramWxaExposedParams.from), Integer.valueOf(bo.f(Integer.valueOf(paramWxaExposedParams.gXe), -1)), Integer.valueOf(bo.f(Integer.valueOf(paramWxaExposedParams.gXf), -1)) });
      AppMethodBeat.o(129126);
      return paramWxaExposedParams;
    }
    catch (UnsupportedEncodingException paramWxaExposedParams)
    {
      ab.e("MicroMsg.AppBrandUrlBuilders", "buildFeedbackUrl encode fail, invalid arguments");
      AppMethodBeat.o(129126);
    }
    return "";
  }
  
  public static String b(WxaExposedParams paramWxaExposedParams)
  {
    AppMethodBeat.i(129127);
    if ((paramWxaExposedParams == null) || (bo.isNullOrNil(paramWxaExposedParams.appId)))
    {
      ab.e("MicroMsg.AppBrandUrlBuilders", "buildExposeUrl fail, null or nil appId");
      AppMethodBeat.o(129127);
      return "";
    }
    try
    {
      paramWxaExposedParams = String.format("https://mp.weixin.qq.com/mp/wacomplain?action=show&appid=%s&pageid=%s&from=%d&version_type=%d&version_code=%d#wechat_redirect", new Object[] { paramWxaExposedParams.appId, q.encode(bo.nullAsNil(paramWxaExposedParams.pageId), "UTF-8"), Integer.valueOf(paramWxaExposedParams.from), Integer.valueOf(bo.f(Integer.valueOf(paramWxaExposedParams.gXe), -1)), Integer.valueOf(bo.f(Integer.valueOf(paramWxaExposedParams.gXf), -1)) });
      AppMethodBeat.o(129127);
      return paramWxaExposedParams;
    }
    catch (UnsupportedEncodingException paramWxaExposedParams)
    {
      ab.e("MicroMsg.AppBrandUrlBuilders", "buildExposeUrl encode fail, invalid arguments");
      AppMethodBeat.o(129127);
    }
    return "";
  }
  
  public static String bs(String paramString1, String paramString2)
  {
    AppMethodBeat.i(129130);
    paramString1 = new URI(paramString1);
    String str = paramString1.getQuery();
    if (str == null) {}
    for (;;)
    {
      paramString1 = new URI(paramString1.getScheme(), paramString1.getAuthority(), paramString1.getPath(), paramString2, paramString1.getFragment()).toString();
      AppMethodBeat.o(129130);
      return paramString1;
      paramString2 = str + "&" + paramString2;
    }
  }
  
  public static String ye(String paramString)
  {
    AppMethodBeat.i(129125);
    paramString = String.format(Locale.US, "https://mp.weixin.qq.com/mp/waerrpage?appid=%s&type=overseas#wechat_redirect", new Object[] { paramString });
    AppMethodBeat.o(129125);
    return paramString;
  }
  
  public static String yf(String paramString)
  {
    AppMethodBeat.i(129128);
    if (bo.isNullOrNil(paramString))
    {
      ab.e("MicroMsg.AppBrandUrlBuilders", "buildEntityUrl fail, null or nil appId");
      AppMethodBeat.o(129128);
      return "";
    }
    paramString = String.format("https://mp.weixin.qq.com/mp/waverifyinfo?action=get&appid=%s#wechat_redirect", new Object[] { paramString });
    AppMethodBeat.o(129128);
    return paramString;
  }
  
  public static String yg(String paramString)
  {
    AppMethodBeat.i(129129);
    if (bo.isNullOrNil(paramString))
    {
      ab.e("MicroMsg.AppBrandUrlBuilders", "buildLowVersionUrl fail, invalid arguments");
      AppMethodBeat.o(129129);
      return "";
    }
    paramString = String.format(Locale.US, "https://mp.weixin.qq.com/mp/waerrpage?appid=%s&type=upgrade&upgradetype=%d#wechat_redirect", new Object[] { paramString, Integer.valueOf(3) });
    AppMethodBeat.o(129129);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.v
 * JD-Core Version:    0.7.0.1
 */
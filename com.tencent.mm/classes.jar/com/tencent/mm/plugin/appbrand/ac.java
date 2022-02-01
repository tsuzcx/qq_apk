package com.tencent.mm.plugin.appbrand;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.r;
import com.tencent.mm.plugin.appbrand.config.WxaExposedParams;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.util.Locale;

public enum ac
{
  private static final String qwX;
  private static final String qwY;
  private static final String qwZ;
  private static final String qxa;
  
  static
  {
    AppMethodBeat.i(316750);
    qxb = new ac[0];
    qwX = "https://" + WeChatHosts.domainString(ba.i.host_mp_weixin_qq_com) + "/wxawap/wapreportwxadevlog?action=complain_feedback&appid=%s&embeddedappid=%s&hostappid=%s&pageid=%s&from=%d&version_type=%d&version_code=%d&screenshot_localId=%s&sessionid=%s&business_appid=%s&msgid=%s#wechat_redirect";
    qwY = "https://" + WeChatHosts.domainString(ba.i.host_mp_weixin_qq_com) + "/mp/wacomplain?action=show&appid=%s&pageid=%s&from=%d&version_type=%d&version_code=%d#wechat_redirect";
    qwZ = "https://" + WeChatHosts.domainString(ba.i.host_mp_weixin_qq_com) + "/mp/waverifyinfo?action=get&appid=%s#wechat_redirect";
    qxa = "https://" + WeChatHosts.domainString(ba.i.host_mp_weixin_qq_com) + "/mp/waerrpage?appid=%s&type=upgrade&upgradetype=%d#wechat_redirect";
    AppMethodBeat.o(316750);
  }
  
  public static String UA(String paramString)
  {
    AppMethodBeat.i(43968);
    paramString = String.format(Locale.US, "https://" + WeChatHosts.domainString(ba.i.host_mp_weixin_qq_com) + "/mp/waerrpage?appid=%s&type=overseas#wechat_redirect", new Object[] { paramString });
    AppMethodBeat.o(43968);
    return paramString;
  }
  
  public static String UB(String paramString)
  {
    AppMethodBeat.i(43971);
    if (Util.isNullOrNil(paramString))
    {
      Log.e("MicroMsg.AppBrandUrlBuilders", "buildEntityUrl fail, null or nil appId");
      AppMethodBeat.o(43971);
      return "";
    }
    paramString = String.format(qwZ, new Object[] { paramString });
    AppMethodBeat.o(43971);
    return paramString;
  }
  
  public static String UC(String paramString)
  {
    AppMethodBeat.i(43972);
    if (Util.isNullOrNil(paramString))
    {
      Log.e("MicroMsg.AppBrandUrlBuilders", "buildLowVersionUrl fail, invalid arguments");
      AppMethodBeat.o(43972);
      return "";
    }
    paramString = String.format(Locale.US, qxa, new Object[] { paramString, Integer.valueOf(3) });
    AppMethodBeat.o(43972);
    return paramString;
  }
  
  public static String a(WxaExposedParams paramWxaExposedParams)
  {
    AppMethodBeat.i(43969);
    if ((paramWxaExposedParams == null) || (Util.isNullOrNil(paramWxaExposedParams.appId)))
    {
      Log.e("MicroMsg.AppBrandUrlBuilders", "buildFeedbackUrl fail, null or nil appId");
      AppMethodBeat.o(43969);
      return "";
    }
    try
    {
      paramWxaExposedParams = String.format(qwX, new Object[] { paramWxaExposedParams.appId, paramWxaExposedParams.rcK, paramWxaExposedParams.rcL, r.as(Util.nullAsNil(paramWxaExposedParams.hUf), "UTF-8"), Integer.valueOf(paramWxaExposedParams.from), Integer.valueOf(Util.nullAsInt(Integer.valueOf(paramWxaExposedParams.qHO), -1)), Integer.valueOf(Util.nullAsInt(Integer.valueOf(paramWxaExposedParams.pkgVersion), -1)), r.as(Util.nullAsNil(paramWxaExposedParams.rcO), "UTF-8"), Util.nullAsNil(paramWxaExposedParams.sessionId), r.as(Util.nullAsNil(paramWxaExposedParams.rcP), "UTF-8"), r.as(Util.nullAsNil(paramWxaExposedParams.msgId), "UTF-8") });
      AppMethodBeat.o(43969);
      return paramWxaExposedParams;
    }
    catch (UnsupportedEncodingException paramWxaExposedParams)
    {
      Log.e("MicroMsg.AppBrandUrlBuilders", "buildFeedbackUrl encode fail, invalid arguments");
      AppMethodBeat.o(43969);
    }
    return "";
  }
  
  public static String b(WxaExposedParams paramWxaExposedParams)
  {
    AppMethodBeat.i(43970);
    if ((paramWxaExposedParams == null) || (Util.isNullOrNil(paramWxaExposedParams.appId)))
    {
      Log.e("MicroMsg.AppBrandUrlBuilders", "buildExposeUrl fail, null or nil appId");
      AppMethodBeat.o(43970);
      return "";
    }
    try
    {
      paramWxaExposedParams = String.format(qwY, new Object[] { paramWxaExposedParams.appId, r.as(Util.nullAsNil(paramWxaExposedParams.hUf), "UTF-8"), Integer.valueOf(paramWxaExposedParams.from), Integer.valueOf(Util.nullAsInt(Integer.valueOf(paramWxaExposedParams.qHO), -1)), Integer.valueOf(Util.nullAsInt(Integer.valueOf(paramWxaExposedParams.pkgVersion), -1)) });
      AppMethodBeat.o(43970);
      return paramWxaExposedParams;
    }
    catch (UnsupportedEncodingException paramWxaExposedParams)
    {
      Log.e("MicroMsg.AppBrandUrlBuilders", "buildExposeUrl encode fail, invalid arguments");
      AppMethodBeat.o(43970);
    }
    return "";
  }
  
  public static String cG(String paramString1, String paramString2)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ac
 * JD-Core Version:    0.7.0.1
 */
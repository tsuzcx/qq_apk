package com.tencent.mm.plugin.appbrand;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.q;
import com.tencent.mm.plugin.appbrand.config.WxaExposedParams;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.util.Locale;

public enum z
{
  private static final String nxJ;
  private static final String nxK;
  private static final String nxL;
  private static final String nxM;
  
  static
  {
    AppMethodBeat.i(279851);
    nxN = new z[0];
    nxJ = "https://" + WeChatHosts.domainString(au.i.host_mp_weixin_qq_com) + "/wxawap/wapreportwxadevlog?action=complain_feedback&appid=%s&pageid=%s&from=%d&version_type=%d&version_code=%d&screenshot_localId=%s&sessionid=%s&business_appid=%s&msgid=%s#wechat_redirect";
    nxK = "https://" + WeChatHosts.domainString(au.i.host_mp_weixin_qq_com) + "/mp/wacomplain?action=show&appid=%s&pageid=%s&from=%d&version_type=%d&version_code=%d#wechat_redirect";
    nxL = "https://" + WeChatHosts.domainString(au.i.host_mp_weixin_qq_com) + "/mp/waverifyinfo?action=get&appid=%s#wechat_redirect";
    nxM = "https://" + WeChatHosts.domainString(au.i.host_mp_weixin_qq_com) + "/mp/waerrpage?appid=%s&type=upgrade&upgradetype=%d#wechat_redirect";
    AppMethodBeat.o(279851);
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
      paramWxaExposedParams = String.format(nxJ, new Object[] { paramWxaExposedParams.appId, q.an(Util.nullAsNil(paramWxaExposedParams.pageId), "UTF-8"), Integer.valueOf(paramWxaExposedParams.from), Integer.valueOf(Util.nullAsInt(Integer.valueOf(paramWxaExposedParams.nHY), -1)), Integer.valueOf(Util.nullAsInt(Integer.valueOf(paramWxaExposedParams.pkgVersion), -1)), q.an(Util.nullAsNil(paramWxaExposedParams.obY), "UTF-8"), Util.nullAsNil(paramWxaExposedParams.sessionId), q.an(Util.nullAsNil(paramWxaExposedParams.obZ), "UTF-8"), q.an(Util.nullAsNil(paramWxaExposedParams.msgId), "UTF-8") });
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
  
  public static String abY(String paramString)
  {
    AppMethodBeat.i(43968);
    paramString = String.format(Locale.US, "https://" + WeChatHosts.domainString(au.i.host_mp_weixin_qq_com) + "/mp/waerrpage?appid=%s&type=overseas#wechat_redirect", new Object[] { paramString });
    AppMethodBeat.o(43968);
    return paramString;
  }
  
  public static String abZ(String paramString)
  {
    AppMethodBeat.i(43971);
    if (Util.isNullOrNil(paramString))
    {
      Log.e("MicroMsg.AppBrandUrlBuilders", "buildEntityUrl fail, null or nil appId");
      AppMethodBeat.o(43971);
      return "";
    }
    paramString = String.format(nxL, new Object[] { paramString });
    AppMethodBeat.o(43971);
    return paramString;
  }
  
  public static String aca(String paramString)
  {
    AppMethodBeat.i(43972);
    if (Util.isNullOrNil(paramString))
    {
      Log.e("MicroMsg.AppBrandUrlBuilders", "buildLowVersionUrl fail, invalid arguments");
      AppMethodBeat.o(43972);
      return "";
    }
    paramString = String.format(Locale.US, nxM, new Object[] { paramString, Integer.valueOf(3) });
    AppMethodBeat.o(43972);
    return paramString;
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
      paramWxaExposedParams = String.format(nxK, new Object[] { paramWxaExposedParams.appId, q.an(Util.nullAsNil(paramWxaExposedParams.pageId), "UTF-8"), Integer.valueOf(paramWxaExposedParams.from), Integer.valueOf(Util.nullAsInt(Integer.valueOf(paramWxaExposedParams.nHY), -1)), Integer.valueOf(Util.nullAsInt(Integer.valueOf(paramWxaExposedParams.pkgVersion), -1)) });
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
  
  public static String cq(String paramString1, String paramString2)
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
 * Qualified Name:     com.tencent.mm.plugin.appbrand.z
 * JD-Core Version:    0.7.0.1
 */
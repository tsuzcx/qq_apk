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

public enum w
{
  private static final String kEt;
  private static final String kEu;
  private static final String kEv;
  private static final String kEw;
  
  static
  {
    AppMethodBeat.i(226244);
    kEx = new w[0];
    kEt = "https://" + WeChatHosts.domainString(2131761726) + "/wxawap/wapreportwxadevlog?action=complain_feedback&appid=%s&pageid=%s&from=%d&version_type=%d&version_code=%d&screenshot_localId=%s&sessionid=%s&business_appid=%s&msgid=%s#wechat_redirect";
    kEu = "https://" + WeChatHosts.domainString(2131761726) + "/mp/wacomplain?action=show&appid=%s&pageid=%s&from=%d&version_type=%d&version_code=%d#wechat_redirect";
    kEv = "https://" + WeChatHosts.domainString(2131761726) + "/mp/waverifyinfo?action=get&appid=%s#wechat_redirect";
    kEw = "https://" + WeChatHosts.domainString(2131761726) + "/mp/waerrpage?appid=%s&type=upgrade&upgradetype=%d#wechat_redirect";
    AppMethodBeat.o(226244);
  }
  
  public static String Up(String paramString)
  {
    AppMethodBeat.i(43968);
    paramString = String.format(Locale.US, "https://" + WeChatHosts.domainString(2131761726) + "/mp/waerrpage?appid=%s&type=overseas#wechat_redirect", new Object[] { paramString });
    AppMethodBeat.o(43968);
    return paramString;
  }
  
  public static String Uq(String paramString)
  {
    AppMethodBeat.i(43971);
    if (Util.isNullOrNil(paramString))
    {
      Log.e("MicroMsg.AppBrandUrlBuilders", "buildEntityUrl fail, null or nil appId");
      AppMethodBeat.o(43971);
      return "";
    }
    paramString = String.format(kEv, new Object[] { paramString });
    AppMethodBeat.o(43971);
    return paramString;
  }
  
  public static String Ur(String paramString)
  {
    AppMethodBeat.i(43972);
    if (Util.isNullOrNil(paramString))
    {
      Log.e("MicroMsg.AppBrandUrlBuilders", "buildLowVersionUrl fail, invalid arguments");
      AppMethodBeat.o(43972);
      return "";
    }
    paramString = String.format(Locale.US, kEw, new Object[] { paramString, Integer.valueOf(3) });
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
      paramWxaExposedParams = String.format(kEt, new Object[] { paramWxaExposedParams.appId, q.encode(Util.nullAsNil(paramWxaExposedParams.pageId), "UTF-8"), Integer.valueOf(paramWxaExposedParams.from), Integer.valueOf(Util.nullAsInt(Integer.valueOf(paramWxaExposedParams.kNW), -1)), Integer.valueOf(Util.nullAsInt(Integer.valueOf(paramWxaExposedParams.pkgVersion), -1)), q.encode(Util.nullAsNil(paramWxaExposedParams.lhp), "UTF-8"), Util.nullAsNil(paramWxaExposedParams.sessionId), q.encode(Util.nullAsNil(paramWxaExposedParams.lhq), "UTF-8"), q.encode(Util.nullAsNil(paramWxaExposedParams.msgId), "UTF-8") });
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
      paramWxaExposedParams = String.format(kEu, new Object[] { paramWxaExposedParams.appId, q.encode(Util.nullAsNil(paramWxaExposedParams.pageId), "UTF-8"), Integer.valueOf(paramWxaExposedParams.from), Integer.valueOf(Util.nullAsInt(Integer.valueOf(paramWxaExposedParams.kNW), -1)), Integer.valueOf(Util.nullAsInt(Integer.valueOf(paramWxaExposedParams.pkgVersion), -1)) });
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
  
  public static String cl(String paramString1, String paramString2)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.w
 * JD-Core Version:    0.7.0.1
 */
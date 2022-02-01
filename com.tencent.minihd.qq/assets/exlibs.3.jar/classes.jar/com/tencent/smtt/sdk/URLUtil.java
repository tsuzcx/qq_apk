package com.tencent.smtt.sdk;

public final class URLUtil
{
  public static String composeSearchUrl(String paramString1, String paramString2, String paramString3)
  {
    x localx = x.a();
    if ((localx != null) && (localx.b())) {
      return localx.c().a(paramString1, paramString2, paramString3);
    }
    return android.webkit.URLUtil.composeSearchUrl(paramString1, paramString2, paramString3);
  }
  
  public static byte[] decode(byte[] paramArrayOfByte)
    throws IllegalArgumentException
  {
    x localx = x.a();
    if ((localx != null) && (localx.b())) {
      return localx.c().a(paramArrayOfByte);
    }
    return android.webkit.URLUtil.decode(paramArrayOfByte);
  }
  
  public static final String guessFileName(String paramString1, String paramString2, String paramString3)
  {
    x localx = x.a();
    if ((localx != null) && (localx.b())) {
      return localx.c().b(paramString1, paramString2, paramString3);
    }
    return android.webkit.URLUtil.guessFileName(paramString1, paramString2, paramString3);
  }
  
  public static String guessUrl(String paramString)
  {
    x localx = x.a();
    if ((localx != null) && (localx.b())) {
      return localx.c().m(paramString);
    }
    return android.webkit.URLUtil.guessUrl(paramString);
  }
  
  public static boolean isAboutUrl(String paramString)
  {
    x localx = x.a();
    if ((localx != null) && (localx.b())) {
      return localx.c().q(paramString);
    }
    return android.webkit.URLUtil.isAboutUrl(paramString);
  }
  
  public static boolean isAssetUrl(String paramString)
  {
    x localx = x.a();
    if ((localx != null) && (localx.b())) {
      return localx.c().n(paramString);
    }
    return android.webkit.URLUtil.isAssetUrl(paramString);
  }
  
  public static boolean isContentUrl(String paramString)
  {
    x localx = x.a();
    if ((localx != null) && (localx.b())) {
      return localx.c().w(paramString);
    }
    return android.webkit.URLUtil.isContentUrl(paramString);
  }
  
  @Deprecated
  public static boolean isCookielessProxyUrl(String paramString)
  {
    x localx = x.a();
    if ((localx != null) && (localx.b())) {
      return localx.c().o(paramString);
    }
    return android.webkit.URLUtil.isCookielessProxyUrl(paramString);
  }
  
  public static boolean isDataUrl(String paramString)
  {
    x localx = x.a();
    if ((localx != null) && (localx.b())) {
      return localx.c().r(paramString);
    }
    return android.webkit.URLUtil.isDataUrl(paramString);
  }
  
  public static boolean isFileUrl(String paramString)
  {
    x localx = x.a();
    if ((localx != null) && (localx.b())) {
      return localx.c().p(paramString);
    }
    return android.webkit.URLUtil.isFileUrl(paramString);
  }
  
  public static boolean isHttpUrl(String paramString)
  {
    x localx = x.a();
    if ((localx != null) && (localx.b())) {
      return localx.c().t(paramString);
    }
    return android.webkit.URLUtil.isHttpUrl(paramString);
  }
  
  public static boolean isHttpsUrl(String paramString)
  {
    x localx = x.a();
    if ((localx != null) && (localx.b())) {
      return localx.c().u(paramString);
    }
    return android.webkit.URLUtil.isHttpsUrl(paramString);
  }
  
  public static boolean isJavaScriptUrl(String paramString)
  {
    x localx = x.a();
    if ((localx != null) && (localx.b())) {
      return localx.c().s(paramString);
    }
    return android.webkit.URLUtil.isJavaScriptUrl(paramString);
  }
  
  public static boolean isNetworkUrl(String paramString)
  {
    x localx = x.a();
    if ((localx != null) && (localx.b())) {
      return localx.c().v(paramString);
    }
    return android.webkit.URLUtil.isNetworkUrl(paramString);
  }
  
  public static boolean isValidUrl(String paramString)
  {
    x localx = x.a();
    if ((localx != null) && (localx.b())) {
      return localx.c().x(paramString);
    }
    return android.webkit.URLUtil.isValidUrl(paramString);
  }
  
  public static String stripAnchor(String paramString)
  {
    x localx = x.a();
    if ((localx != null) && (localx.b())) {
      return localx.c().y(paramString);
    }
    return android.webkit.URLUtil.stripAnchor(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     com.tencent.smtt.sdk.URLUtil
 * JD-Core Version:    0.7.0.1
 */
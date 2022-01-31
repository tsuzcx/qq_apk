package com.tencent.mm.plugin.appbrand.j.b;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.net.Uri;
import com.tencent.mm.modelappbrand.a.b.f;
import com.tencent.mm.plugin.appbrand.d.a.b;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.page.p;

public final class n
  extends com.tencent.luggage.bridge.impl.a.a
  implements com.tencent.mm.plugin.appbrand.d.b
{
  public final boolean a(c paramc, String paramString)
  {
    if ((paramc == null) || (paramString == null) || (paramString.length() == 0)) {}
    while ((paramString.startsWith("wxapkg://")) || (paramString.startsWith("http://")) || (paramString.startsWith("https://")) || (paramString.startsWith("wxfile://")) || (paramString.contains("://"))) {
      return false;
    }
    return true;
  }
  
  public final Bitmap b(String paramString, Rect paramRect, a.b paramb)
  {
    paramb = null;
    if (!match(paramString)) {
      paramString = paramb;
    }
    do
    {
      String str1;
      String str2;
      do
      {
        do
        {
          do
          {
            do
            {
              return paramString;
              paramString = Uri.parse(paramString);
              str1 = paramString.getQueryParameter("appId");
              str2 = paramString.getQueryParameter("path");
              paramString = paramb;
            } while (str1 == null);
            paramString = paramb;
          } while (str1.length() == 0);
          paramString = paramb;
        } while (str2 == null);
        paramString = paramb;
      } while (str2.length() == 0);
      paramb = p.i(com.tencent.mm.plugin.appbrand.a.qn(str1), Uri.decode(str2));
      paramString = paramb;
    } while (paramRect == null);
    return new com.tencent.mm.plugin.appbrand.j.a.b(paramRect.left, paramRect.top, paramRect.width(), paramRect.height()).q(paramb);
  }
  
  public final String b(c paramc, String paramString)
  {
    if (!a(paramc, paramString)) {
      return paramString;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("wxapkg://");
    localStringBuilder.append("icon?");
    localStringBuilder.append("appId=");
    localStringBuilder.append(paramc.getAppId());
    localStringBuilder.append("&");
    localStringBuilder.append("path=");
    localStringBuilder.append(Uri.encode(paramString));
    return localStringBuilder.toString();
  }
  
  public final boolean match(String paramString)
  {
    return (paramString != null) && (paramString.startsWith("wxapkg://"));
  }
  
  public final String pU()
  {
    return "WxaPkgImageReader";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.j.b.n
 * JD-Core Version:    0.7.0.1
 */
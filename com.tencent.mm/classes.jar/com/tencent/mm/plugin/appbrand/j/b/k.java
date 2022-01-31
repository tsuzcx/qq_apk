package com.tencent.mm.plugin.appbrand.j.b;

import android.graphics.Bitmap;
import android.graphics.Rect;
import com.tencent.mm.plugin.appbrand.appstorage.l;
import com.tencent.mm.plugin.appbrand.d.a.b;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.n;
import java.io.File;

public final class k
  extends com.tencent.luggage.bridge.impl.a.a
  implements com.tencent.mm.plugin.appbrand.d.b
{
  public final boolean a(c paramc, String paramString)
  {
    if ((paramc == null) || (paramString == null) || (paramString.length() == 0)) {
      return false;
    }
    return paramString.startsWith("wxfile://");
  }
  
  public final Bitmap b(String paramString, Rect paramRect, a.b paramb)
  {
    paramb = null;
    if (!match(paramString)) {}
    do
    {
      return null;
      int i = paramString.lastIndexOf("?appId=");
      str = paramString.substring(0, i);
      paramString = com.tencent.mm.plugin.appbrand.a.qn(paramString.substring(i + 7, paramString.length())).fzC.rx(str);
    } while ((paramString == null) || (!paramString.exists()));
    String str = paramString.getAbsolutePath();
    paramString = str;
    if (!str.startsWith("file://")) {
      paramString = "file://" + str;
    }
    if (paramRect != null) {
      paramb = new com.tencent.mm.plugin.appbrand.j.a.a(paramRect.left, paramRect.top, paramRect.width(), paramRect.height());
    }
    return com.tencent.mm.modelappbrand.a.b.JD().a(paramString, paramb);
  }
  
  public final String b(c paramc, String paramString)
  {
    if (!a(paramc, paramString)) {
      return paramString;
    }
    return paramString + "?appId=" + paramc.getAppId();
  }
  
  public final boolean match(String paramString)
  {
    return (paramString != null) && (paramString.startsWith("wxfile://"));
  }
  
  public final String pU()
  {
    return "WxFileImageReader";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.j.b.k
 * JD-Core Version:    0.7.0.1
 */
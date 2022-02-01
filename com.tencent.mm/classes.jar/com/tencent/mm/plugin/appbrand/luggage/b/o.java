package com.tencent.mm.plugin.appbrand.luggage.b;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.luggage.bridge.impl.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelappbrand.a.b.h;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.appcache.bf;
import com.tencent.mm.plugin.appbrand.f.a.b;
import com.tencent.mm.plugin.appbrand.f.a.c;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.page.x;

public final class o
  extends a
  implements com.tencent.mm.plugin.appbrand.f.b
{
  private final AppBrandRuntime jzY;
  
  o(AppBrandRuntime paramAppBrandRuntime)
  {
    this.jzY = paramAppBrandRuntime;
  }
  
  private static Pair<String, String> Sa(String paramString)
  {
    AppMethodBeat.i(197291);
    paramString = Uri.parse(paramString);
    paramString = Pair.create(paramString.getQueryParameter("appId"), paramString.getQueryParameter("path"));
    AppMethodBeat.o(197291);
    return paramString;
  }
  
  public final String BM()
  {
    return "WxaPkgImageReader";
  }
  
  public final void a(String paramString, a.c paramc)
  {
    AppMethodBeat.i(197292);
    if (paramc == null)
    {
      AppMethodBeat.o(197292);
      return;
    }
    paramString = (String)Sa(paramString).second;
    if (TextUtils.isEmpty(paramString))
    {
      paramc.D(null);
      AppMethodBeat.o(197292);
      return;
    }
    paramc.D(bf.f(this.jzY, paramString));
    AppMethodBeat.o(197292);
  }
  
  public final boolean a(c paramc, String paramString)
  {
    AppMethodBeat.i(134914);
    if ((paramc == null) || (paramString == null) || (paramString.length() == 0))
    {
      AppMethodBeat.o(134914);
      return false;
    }
    if ((!paramString.startsWith("wxapkg://")) && (!paramString.startsWith("http://")) && (!paramString.startsWith("https://")) && (!paramString.startsWith("wxfile://")) && (!paramString.contains("://")))
    {
      AppMethodBeat.o(134914);
      return true;
    }
    AppMethodBeat.o(134914);
    return false;
  }
  
  public final Bitmap b(String paramString, Rect paramRect, a.b paramb)
  {
    AppMethodBeat.i(134913);
    if (!match(paramString))
    {
      AppMethodBeat.o(134913);
      return null;
    }
    paramString = (String)Sa(paramString).second;
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(134913);
      return null;
    }
    paramb = x.k(this.jzY, Uri.decode(paramString));
    paramString = paramb;
    if (paramRect != null) {
      paramString = new com.tencent.mm.plugin.appbrand.luggage.a.b(paramRect.left, paramRect.top, paramRect.width(), paramRect.height()).F(paramb);
    }
    AppMethodBeat.o(134913);
    return paramString;
  }
  
  public final String b(c paramc, String paramString)
  {
    AppMethodBeat.i(134915);
    if (!a(paramc, paramString))
    {
      AppMethodBeat.o(134915);
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
    paramc = localStringBuilder.toString();
    AppMethodBeat.o(134915);
    return paramc;
  }
  
  public final boolean match(String paramString)
  {
    AppMethodBeat.i(134912);
    if ((paramString != null) && (paramString.startsWith("wxapkg://")))
    {
      AppMethodBeat.o(134912);
      return true;
    }
    AppMethodBeat.o(134912);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.luggage.b.o
 * JD-Core Version:    0.7.0.1
 */
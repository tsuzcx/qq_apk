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
import com.tencent.mm.plugin.appbrand.appcache.bl;
import com.tencent.mm.plugin.appbrand.f.a.b;
import com.tencent.mm.plugin.appbrand.f.a.c;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.page.aa;

public final class n
  extends a
  implements com.tencent.mm.plugin.appbrand.f.b
{
  private final AppBrandRuntime qwG;
  
  n(AppBrandRuntime paramAppBrandRuntime)
  {
    this.qwG = paramAppBrandRuntime;
  }
  
  private static Pair<String, String> adr(String paramString)
  {
    AppMethodBeat.i(319867);
    paramString = Uri.parse(paramString);
    paramString = Pair.create(paramString.getQueryParameter("appId"), paramString.getQueryParameter("path"));
    AppMethodBeat.o(319867);
    return paramString;
  }
  
  public final void a(String paramString, a.c paramc)
  {
    AppMethodBeat.i(319880);
    if (paramc == null)
    {
      AppMethodBeat.o(319880);
      return;
    }
    paramString = (String)adr(paramString).second;
    if (TextUtils.isEmpty(paramString))
    {
      paramc.N(null);
      AppMethodBeat.o(319880);
      return;
    }
    paramc.N(bl.f(this.qwG, paramString));
    AppMethodBeat.o(319880);
  }
  
  public final boolean a(f paramf, String paramString)
  {
    AppMethodBeat.i(134914);
    if ((paramf == null) || (paramString == null) || (paramString.length() == 0))
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
    paramString = (String)adr(paramString).second;
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(134913);
      return null;
    }
    paramb = aa.l(this.qwG, Uri.decode(paramString));
    paramString = paramb;
    if (paramRect != null) {
      paramString = new com.tencent.mm.plugin.appbrand.luggage.a.b(paramRect.left, paramRect.top, paramRect.width(), paramRect.height()).P(paramb);
    }
    AppMethodBeat.o(134913);
    return paramString;
  }
  
  public final String b(f paramf, String paramString)
  {
    AppMethodBeat.i(134915);
    if (!a(paramf, paramString))
    {
      AppMethodBeat.o(134915);
      return paramString;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("wxapkg://");
    localStringBuilder.append("icon?");
    localStringBuilder.append("appId=");
    localStringBuilder.append(paramf.getAppId());
    localStringBuilder.append("&");
    localStringBuilder.append("path=");
    localStringBuilder.append(Uri.encode(paramString));
    paramf = localStringBuilder.toString();
    AppMethodBeat.o(134915);
    return paramf;
  }
  
  public final String key()
  {
    return "WxaPkgImageReader";
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.luggage.b.n
 * JD-Core Version:    0.7.0.1
 */
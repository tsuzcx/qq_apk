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
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.page.aa;

public final class n
  extends a
  implements com.tencent.mm.plugin.appbrand.f.b
{
  private final AppBrandRuntime nxs;
  
  n(AppBrandRuntime paramAppBrandRuntime)
  {
    this.nxs = paramAppBrandRuntime;
  }
  
  private static Pair<String, String> akl(String paramString)
  {
    AppMethodBeat.i(243126);
    paramString = Uri.parse(paramString);
    paramString = Pair.create(paramString.getQueryParameter("appId"), paramString.getQueryParameter("path"));
    AppMethodBeat.o(243126);
    return paramString;
  }
  
  public final void a(String paramString, a.c paramc)
  {
    AppMethodBeat.i(243127);
    if (paramc == null)
    {
      AppMethodBeat.o(243127);
      return;
    }
    paramString = (String)akl(paramString).second;
    if (TextUtils.isEmpty(paramString))
    {
      paramc.A(null);
      AppMethodBeat.o(243127);
      return;
    }
    paramc.A(bl.f(this.nxs, paramString));
    AppMethodBeat.o(243127);
  }
  
  public final boolean a(e parame, String paramString)
  {
    AppMethodBeat.i(134914);
    if ((parame == null) || (paramString == null) || (paramString.length() == 0))
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
    if (!dq(paramString))
    {
      AppMethodBeat.o(134913);
      return null;
    }
    paramString = (String)akl(paramString).second;
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(134913);
      return null;
    }
    paramb = aa.l(this.nxs, Uri.decode(paramString));
    paramString = paramb;
    if (paramRect != null) {
      paramString = new com.tencent.mm.plugin.appbrand.luggage.a.b(paramRect.left, paramRect.top, paramRect.width(), paramRect.height()).H(paramb);
    }
    AppMethodBeat.o(134913);
    return paramString;
  }
  
  public final String b(e parame, String paramString)
  {
    AppMethodBeat.i(134915);
    if (!a(parame, paramString))
    {
      AppMethodBeat.o(134915);
      return paramString;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("wxapkg://");
    localStringBuilder.append("icon?");
    localStringBuilder.append("appId=");
    localStringBuilder.append(parame.getAppId());
    localStringBuilder.append("&");
    localStringBuilder.append("path=");
    localStringBuilder.append(Uri.encode(paramString));
    parame = localStringBuilder.toString();
    AppMethodBeat.o(134915);
    return parame;
  }
  
  public final boolean dq(String paramString)
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
  
  public final String key()
  {
    return "WxaPkgImageReader";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.luggage.b.n
 * JD-Core Version:    0.7.0.1
 */
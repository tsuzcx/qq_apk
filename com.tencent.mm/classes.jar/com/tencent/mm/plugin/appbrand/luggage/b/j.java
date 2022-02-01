package com.tencent.mm.plugin.appbrand.luggage.b;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.appstorage.q;
import com.tencent.mm.plugin.appbrand.f.a.b;
import com.tencent.mm.plugin.appbrand.f.a.c;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.vfs.k;
import com.tencent.mm.vfs.w;

public final class j
  extends com.tencent.luggage.bridge.impl.a.a
  implements com.tencent.mm.plugin.appbrand.f.b
{
  private final AppBrandRuntime jDb;
  
  public j(AppBrandRuntime paramAppBrandRuntime)
  {
    this.jDb = paramAppBrandRuntime;
  }
  
  private static Pair<String, String> SJ(String paramString)
  {
    AppMethodBeat.i(207764);
    int i = paramString.lastIndexOf("?appId=");
    String str = paramString.substring(0, i);
    paramString = Pair.create(paramString.substring(i + 7), str);
    AppMethodBeat.o(207764);
    return paramString;
  }
  
  public final String BN()
  {
    return "WxFileImageReader";
  }
  
  public final void a(String paramString, a.c paramc)
  {
    AppMethodBeat.i(207765);
    if (paramc == null)
    {
      AppMethodBeat.o(207765);
      return;
    }
    q localq = this.jDb.Fl();
    if (localq == null)
    {
      paramc.D(null);
      AppMethodBeat.o(207765);
      return;
    }
    paramc.D(localq.MT((String)SJ(paramString).second));
    AppMethodBeat.o(207765);
  }
  
  public final boolean a(c paramc, String paramString)
  {
    AppMethodBeat.i(134905);
    if ((paramc == null) || (paramString == null) || (paramString.length() == 0))
    {
      AppMethodBeat.o(134905);
      return false;
    }
    if ((paramString.startsWith("wxfile://")) && (!paramString.startsWith("wxfile://ad")))
    {
      AppMethodBeat.o(134905);
      return true;
    }
    AppMethodBeat.o(134905);
    return false;
  }
  
  public final Bitmap b(String paramString, Rect paramRect, a.b paramb)
  {
    AppMethodBeat.i(134904);
    if (!match(paramString))
    {
      AppMethodBeat.o(134904);
      return null;
    }
    paramb = this.jDb.Fl();
    if (paramb == null)
    {
      AppMethodBeat.o(134904);
      return null;
    }
    paramString = paramb.MP((String)SJ(paramString).second);
    if ((paramString == null) || (!paramString.exists()))
    {
      AppMethodBeat.o(134904);
      return null;
    }
    paramString = w.B(paramString.fTh());
    if (!paramString.startsWith("file://")) {
      paramString = "file://".concat(String.valueOf(paramString));
    }
    for (;;)
    {
      if (paramRect != null) {}
      for (paramRect = new com.tencent.mm.plugin.appbrand.luggage.a.a(paramRect.left, paramRect.top, paramRect.width(), paramRect.height());; paramRect = null)
      {
        paramString = com.tencent.mm.modelappbrand.a.b.aEl().a(paramString, paramRect);
        AppMethodBeat.o(134904);
        return paramString;
      }
    }
  }
  
  public final String b(c paramc, String paramString)
  {
    AppMethodBeat.i(134906);
    if (!a(paramc, paramString))
    {
      AppMethodBeat.o(134906);
      return paramString;
    }
    paramc = paramString + "?appId=" + paramc.getAppId();
    AppMethodBeat.o(134906);
    return paramc;
  }
  
  public final boolean match(String paramString)
  {
    AppMethodBeat.i(134903);
    if ((paramString != null) && (paramString.startsWith("wxfile://")) && (!paramString.startsWith("wxfile://ad")))
    {
      AppMethodBeat.o(134903);
      return true;
    }
    AppMethodBeat.o(134903);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.luggage.b.j
 * JD-Core Version:    0.7.0.1
 */
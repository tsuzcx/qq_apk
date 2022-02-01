package com.tencent.mm.plugin.appbrand.luggage.b;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.appstorage.w;
import com.tencent.mm.plugin.appbrand.f.a.b;
import com.tencent.mm.plugin.appbrand.f.a.c;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.vfs.ah;
import com.tencent.mm.vfs.u;

public final class h
  extends com.tencent.luggage.bridge.impl.a.a
  implements com.tencent.mm.plugin.appbrand.f.b
{
  private final AppBrandRuntime qwG;
  
  public h(AppBrandRuntime paramAppBrandRuntime)
  {
    this.qwG = paramAppBrandRuntime;
  }
  
  private static Pair<String, String> adr(String paramString)
  {
    AppMethodBeat.i(319884);
    int i = paramString.lastIndexOf("?appId=");
    String str = paramString.substring(0, i);
    paramString = Pair.create(paramString.substring(i + 7), str);
    AppMethodBeat.o(319884);
    return paramString;
  }
  
  public final void a(String paramString, a.c paramc)
  {
    AppMethodBeat.i(319897);
    if (paramc == null)
    {
      AppMethodBeat.o(319897);
      return;
    }
    w localw = this.qwG.getFileSystem();
    if (localw == null)
    {
      paramc.N(null);
      AppMethodBeat.o(319897);
      return;
    }
    paramc.N(localw.Wr((String)adr(paramString).second));
    AppMethodBeat.o(319897);
  }
  
  public final boolean a(f paramf, String paramString)
  {
    AppMethodBeat.i(134905);
    if ((paramf == null) || (paramString == null) || (paramString.length() == 0))
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
    paramb = this.qwG.getFileSystem();
    if (paramb == null)
    {
      AppMethodBeat.o(134904);
      return null;
    }
    paramString = paramb.Wm((String)adr(paramString).second);
    if ((paramString == null) || (!paramString.jKS()))
    {
      AppMethodBeat.o(134904);
      return null;
    }
    paramString = ah.v(paramString.jKT());
    if (!paramString.startsWith("file://")) {
      paramString = "file://".concat(String.valueOf(paramString));
    }
    for (;;)
    {
      if (paramRect != null) {}
      for (paramRect = new com.tencent.mm.plugin.appbrand.luggage.a.a(paramRect.left, paramRect.top, paramRect.width(), paramRect.height());; paramRect = null)
      {
        paramString = com.tencent.mm.modelappbrand.a.b.bEY().a(paramString, paramRect);
        AppMethodBeat.o(134904);
        return paramString;
      }
    }
  }
  
  public final String b(f paramf, String paramString)
  {
    AppMethodBeat.i(134906);
    if (!a(paramf, paramString))
    {
      AppMethodBeat.o(134906);
      return paramString;
    }
    paramf = paramString + "?appId=" + paramf.getAppId();
    AppMethodBeat.o(134906);
    return paramf;
  }
  
  public final String key()
  {
    return "WxFileImageReader";
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.luggage.b.h
 * JD-Core Version:    0.7.0.1
 */
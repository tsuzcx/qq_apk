package com.tencent.mm.plugin.appbrand.luggage.b;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.appstorage.r;
import com.tencent.mm.plugin.appbrand.f.a.b;
import com.tencent.mm.plugin.appbrand.f.a.c;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.vfs.q;

public final class h
  extends com.tencent.luggage.bridge.impl.a.a
  implements com.tencent.mm.plugin.appbrand.f.b
{
  private final AppBrandRuntime nxs;
  
  public h(AppBrandRuntime paramAppBrandRuntime)
  {
    this.nxs = paramAppBrandRuntime;
  }
  
  private static Pair<String, String> akl(String paramString)
  {
    AppMethodBeat.i(243522);
    int i = paramString.lastIndexOf("?appId=");
    String str = paramString.substring(0, i);
    paramString = Pair.create(paramString.substring(i + 7), str);
    AppMethodBeat.o(243522);
    return paramString;
  }
  
  public final void a(String paramString, a.c paramc)
  {
    AppMethodBeat.i(243523);
    if (paramc == null)
    {
      AppMethodBeat.o(243523);
      return;
    }
    r localr = this.nxs.getFileSystem();
    if (localr == null)
    {
      paramc.A(null);
      AppMethodBeat.o(243523);
      return;
    }
    paramc.A(localr.adQ((String)akl(paramString).second));
    AppMethodBeat.o(243523);
  }
  
  public final boolean a(e parame, String paramString)
  {
    AppMethodBeat.i(134905);
    if ((parame == null) || (paramString == null) || (paramString.length() == 0))
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
    if (!dq(paramString))
    {
      AppMethodBeat.o(134904);
      return null;
    }
    paramb = this.nxs.getFileSystem();
    if (paramb == null)
    {
      AppMethodBeat.o(134904);
      return null;
    }
    paramString = paramb.adL((String)akl(paramString).second);
    if ((paramString == null) || (!paramString.ifE()))
    {
      AppMethodBeat.o(134904);
      return null;
    }
    paramString = paramString.bOF();
    if (!paramString.startsWith("file://")) {
      paramString = "file://".concat(String.valueOf(paramString));
    }
    for (;;)
    {
      if (paramRect != null) {}
      for (paramRect = new com.tencent.mm.plugin.appbrand.luggage.a.a(paramRect.left, paramRect.top, paramRect.width(), paramRect.height());; paramRect = null)
      {
        paramString = com.tencent.mm.modelappbrand.a.b.bhh().a(paramString, paramRect);
        AppMethodBeat.o(134904);
        return paramString;
      }
    }
  }
  
  public final String b(e parame, String paramString)
  {
    AppMethodBeat.i(134906);
    if (!a(parame, paramString))
    {
      AppMethodBeat.o(134906);
      return paramString;
    }
    parame = paramString + "?appId=" + parame.getAppId();
    AppMethodBeat.o(134906);
    return parame;
  }
  
  public final boolean dq(String paramString)
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
  
  public final String key()
  {
    return "WxFileImageReader";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.luggage.b.h
 * JD-Core Version:    0.7.0.1
 */
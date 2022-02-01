package com.tencent.mm.plugin.appbrand.luggage.b;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.appstorage.w;
import com.tencent.mm.plugin.appbrand.f.a.b;
import com.tencent.mm.plugin.appbrand.f.a.c;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.ah;
import com.tencent.mm.vfs.u;

public final class f
  extends com.tencent.luggage.bridge.impl.a.a
  implements com.tencent.mm.plugin.appbrand.f.b
{
  private final AppBrandRuntime qwG;
  
  f(AppBrandRuntime paramAppBrandRuntime)
  {
    this.qwG = paramAppBrandRuntime;
  }
  
  private static Pair<String, String> adr(String paramString)
  {
    AppMethodBeat.i(319872);
    if (Util.isNullOrNil(paramString))
    {
      paramString = Pair.create(null, null);
      AppMethodBeat.o(319872);
      return paramString;
    }
    int i = paramString.lastIndexOf("wxblob://");
    if (i < 0)
    {
      paramString = Pair.create(null, null);
      AppMethodBeat.o(319872);
      return paramString;
    }
    paramString = Pair.create(paramString.substring(0, i), paramString.substring(i));
    AppMethodBeat.o(319872);
    return paramString;
  }
  
  public final void a(String paramString, a.c paramc)
  {
    AppMethodBeat.i(319887);
    if (paramc == null)
    {
      AppMethodBeat.o(319887);
      return;
    }
    w localw = this.qwG.getFileSystem();
    if (localw == null)
    {
      paramc.N(null);
      AppMethodBeat.o(319887);
      return;
    }
    paramc.N(localw.Wr((String)adr(paramString).second));
    AppMethodBeat.o(319887);
  }
  
  public final boolean a(com.tencent.mm.plugin.appbrand.jsapi.f paramf, String paramString)
  {
    AppMethodBeat.i(319895);
    if ((paramf == null) || (paramString == null) || (paramString.length() == 0))
    {
      AppMethodBeat.o(319895);
      return false;
    }
    if ((paramString.startsWith("wxblob://")) || (Util.nullAsNil((String)adr(paramString).second).startsWith("wxblob://")))
    {
      AppMethodBeat.o(319895);
      return true;
    }
    AppMethodBeat.o(319895);
    return false;
  }
  
  public final Bitmap b(String paramString, Rect paramRect, a.b paramb)
  {
    AppMethodBeat.i(319891);
    if (!match(paramString))
    {
      AppMethodBeat.o(319891);
      return null;
    }
    paramb = this.qwG.getFileSystem();
    if (paramb == null)
    {
      AppMethodBeat.o(319891);
      return null;
    }
    paramString = paramb.Wj((String)adr(paramString).second);
    if ((paramString == null) || (!paramString.jKS()))
    {
      AppMethodBeat.o(319891);
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
        AppMethodBeat.o(319891);
        return paramString;
      }
    }
  }
  
  public final String b(com.tencent.mm.plugin.appbrand.jsapi.f paramf, String paramString)
  {
    AppMethodBeat.i(319899);
    if (!a(paramf, paramString))
    {
      AppMethodBeat.o(319899);
      return paramString;
    }
    paramf = Util.nullAsNil((String)adr(paramString).second);
    AppMethodBeat.o(319899);
    return paramf;
  }
  
  public final String key()
  {
    return "WxBlobImageReader";
  }
  
  public final boolean match(String paramString)
  {
    AppMethodBeat.i(319881);
    if ((paramString != null) && (paramString.startsWith("wxblob://")))
    {
      AppMethodBeat.o(319881);
      return true;
    }
    AppMethodBeat.o(319881);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.luggage.b.f
 * JD-Core Version:    0.7.0.1
 */
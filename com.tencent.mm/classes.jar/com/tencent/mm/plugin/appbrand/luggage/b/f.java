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
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.q;

public final class f
  extends com.tencent.luggage.bridge.impl.a.a
  implements com.tencent.mm.plugin.appbrand.f.b
{
  private final AppBrandRuntime nxs;
  
  f(AppBrandRuntime paramAppBrandRuntime)
  {
    this.nxs = paramAppBrandRuntime;
  }
  
  private static Pair<String, String> akl(String paramString)
  {
    AppMethodBeat.i(246038);
    if (Util.isNullOrNil(paramString))
    {
      paramString = Pair.create(null, null);
      AppMethodBeat.o(246038);
      return paramString;
    }
    int i = paramString.lastIndexOf("wxblob://");
    if (i < 0)
    {
      paramString = Pair.create(null, null);
      AppMethodBeat.o(246038);
      return paramString;
    }
    paramString = Pair.create(paramString.substring(0, i), paramString.substring(i));
    AppMethodBeat.o(246038);
    return paramString;
  }
  
  public final void a(String paramString, a.c paramc)
  {
    AppMethodBeat.i(246040);
    if (paramc == null)
    {
      AppMethodBeat.o(246040);
      return;
    }
    r localr = this.nxs.getFileSystem();
    if (localr == null)
    {
      paramc.A(null);
      AppMethodBeat.o(246040);
      return;
    }
    paramc.A(localr.adQ((String)akl(paramString).second));
    AppMethodBeat.o(246040);
  }
  
  public final boolean a(e parame, String paramString)
  {
    AppMethodBeat.i(246043);
    if ((parame == null) || (paramString == null) || (paramString.length() == 0))
    {
      AppMethodBeat.o(246043);
      return false;
    }
    if ((paramString.startsWith("wxblob://")) || (Util.nullAsNil((String)akl(paramString).second).startsWith("wxblob://")))
    {
      AppMethodBeat.o(246043);
      return true;
    }
    AppMethodBeat.o(246043);
    return false;
  }
  
  public final Bitmap b(String paramString, Rect paramRect, a.b paramb)
  {
    AppMethodBeat.i(246041);
    if (!dq(paramString))
    {
      AppMethodBeat.o(246041);
      return null;
    }
    paramb = this.nxs.getFileSystem();
    if (paramb == null)
    {
      AppMethodBeat.o(246041);
      return null;
    }
    paramString = paramb.adI((String)akl(paramString).second);
    if ((paramString == null) || (!paramString.ifE()))
    {
      AppMethodBeat.o(246041);
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
        AppMethodBeat.o(246041);
        return paramString;
      }
    }
  }
  
  public final String b(e parame, String paramString)
  {
    AppMethodBeat.i(246045);
    if (!a(parame, paramString))
    {
      AppMethodBeat.o(246045);
      return paramString;
    }
    parame = Util.nullAsNil((String)akl(paramString).second);
    AppMethodBeat.o(246045);
    return parame;
  }
  
  public final boolean dq(String paramString)
  {
    AppMethodBeat.i(246036);
    if ((paramString != null) && (paramString.startsWith("wxblob://")))
    {
      AppMethodBeat.o(246036);
      return true;
    }
    AppMethodBeat.o(246036);
    return false;
  }
  
  public final String key()
  {
    return "WxBlobImageReader";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.luggage.b.f
 * JD-Core Version:    0.7.0.1
 */
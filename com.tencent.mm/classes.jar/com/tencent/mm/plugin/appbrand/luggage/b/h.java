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
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.vfs.k;
import com.tencent.mm.vfs.w;

public final class h
  extends com.tencent.luggage.bridge.impl.a.a
  implements com.tencent.mm.plugin.appbrand.f.b
{
  private final AppBrandRuntime jDb;
  
  h(AppBrandRuntime paramAppBrandRuntime)
  {
    this.jDb = paramAppBrandRuntime;
  }
  
  private static Pair<String, String> SJ(String paramString)
  {
    AppMethodBeat.i(207758);
    if (bu.isNullOrNil(paramString))
    {
      paramString = Pair.create(null, null);
      AppMethodBeat.o(207758);
      return paramString;
    }
    int i = paramString.lastIndexOf("wxblob://");
    if (i < 0)
    {
      paramString = Pair.create(null, null);
      AppMethodBeat.o(207758);
      return paramString;
    }
    paramString = Pair.create(paramString.substring(0, i), paramString.substring(i));
    AppMethodBeat.o(207758);
    return paramString;
  }
  
  public final String BN()
  {
    return "WxBlobImageReader";
  }
  
  public final void a(String paramString, a.c paramc)
  {
    AppMethodBeat.i(207759);
    if (paramc == null)
    {
      AppMethodBeat.o(207759);
      return;
    }
    q localq = this.jDb.Fl();
    if (localq == null)
    {
      paramc.D(null);
      AppMethodBeat.o(207759);
      return;
    }
    paramc.D(localq.MT((String)SJ(paramString).second));
    AppMethodBeat.o(207759);
  }
  
  public final boolean a(c paramc, String paramString)
  {
    AppMethodBeat.i(207761);
    if ((paramc == null) || (paramString == null) || (paramString.length() == 0))
    {
      AppMethodBeat.o(207761);
      return false;
    }
    if ((paramString.startsWith("wxblob://")) || (bu.nullAsNil((String)SJ(paramString).second).startsWith("wxblob://")))
    {
      AppMethodBeat.o(207761);
      return true;
    }
    AppMethodBeat.o(207761);
    return false;
  }
  
  public final Bitmap b(String paramString, Rect paramRect, a.b paramb)
  {
    AppMethodBeat.i(207760);
    if (!match(paramString))
    {
      AppMethodBeat.o(207760);
      return null;
    }
    paramb = this.jDb.Fl();
    if (paramb == null)
    {
      AppMethodBeat.o(207760);
      return null;
    }
    paramString = paramb.MM((String)SJ(paramString).second);
    if ((paramString == null) || (!paramString.exists()))
    {
      AppMethodBeat.o(207760);
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
        AppMethodBeat.o(207760);
        return paramString;
      }
    }
  }
  
  public final String b(c paramc, String paramString)
  {
    AppMethodBeat.i(207762);
    if (!a(paramc, paramString))
    {
      AppMethodBeat.o(207762);
      return paramString;
    }
    paramc = bu.nullAsNil((String)SJ(paramString).second);
    AppMethodBeat.o(207762);
    return paramc;
  }
  
  public final boolean match(String paramString)
  {
    AppMethodBeat.i(207757);
    if ((paramString != null) && (paramString.startsWith("wxblob://")))
    {
      AppMethodBeat.o(207757);
      return true;
    }
    AppMethodBeat.o(207757);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.luggage.b.h
 * JD-Core Version:    0.7.0.1
 */
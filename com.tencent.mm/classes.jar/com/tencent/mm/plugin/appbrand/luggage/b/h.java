package com.tencent.mm.plugin.appbrand.luggage.b;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.appstorage.q;
import com.tencent.mm.plugin.appbrand.f.a.b;
import com.tencent.mm.plugin.appbrand.f.a.c;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.o;

public final class h
  extends com.tencent.luggage.bridge.impl.a.a
  implements com.tencent.mm.plugin.appbrand.f.b
{
  private final AppBrandRuntime kEc;
  
  h(AppBrandRuntime paramAppBrandRuntime)
  {
    this.kEc = paramAppBrandRuntime;
  }
  
  private static Pair<String, String> acr(String paramString)
  {
    AppMethodBeat.i(219332);
    if (Util.isNullOrNil(paramString))
    {
      paramString = Pair.create(null, null);
      AppMethodBeat.o(219332);
      return paramString;
    }
    int i = paramString.lastIndexOf("wxblob://");
    if (i < 0)
    {
      paramString = Pair.create(null, null);
      AppMethodBeat.o(219332);
      return paramString;
    }
    paramString = Pair.create(paramString.substring(0, i), paramString.substring(i));
    AppMethodBeat.o(219332);
    return paramString;
  }
  
  public final String Lb()
  {
    return "WxBlobImageReader";
  }
  
  public final void a(String paramString, a.c paramc)
  {
    AppMethodBeat.i(219333);
    if (paramc == null)
    {
      AppMethodBeat.o(219333);
      return;
    }
    q localq = this.kEc.getFileSystem();
    if (localq == null)
    {
      paramc.C(null);
      AppMethodBeat.o(219333);
      return;
    }
    paramc.C(localq.Wc((String)acr(paramString).second));
    AppMethodBeat.o(219333);
  }
  
  public final boolean a(f paramf, String paramString)
  {
    AppMethodBeat.i(219335);
    if ((paramf == null) || (paramString == null) || (paramString.length() == 0))
    {
      AppMethodBeat.o(219335);
      return false;
    }
    if ((paramString.startsWith("wxblob://")) || (Util.nullAsNil((String)acr(paramString).second).startsWith("wxblob://")))
    {
      AppMethodBeat.o(219335);
      return true;
    }
    AppMethodBeat.o(219335);
    return false;
  }
  
  public final Bitmap b(String paramString, Rect paramRect, a.b paramb)
  {
    AppMethodBeat.i(219334);
    if (!match(paramString))
    {
      AppMethodBeat.o(219334);
      return null;
    }
    paramb = this.kEc.getFileSystem();
    if (paramb == null)
    {
      AppMethodBeat.o(219334);
      return null;
    }
    paramString = paramb.VV((String)acr(paramString).second);
    if ((paramString == null) || (!paramString.exists()))
    {
      AppMethodBeat.o(219334);
      return null;
    }
    paramString = aa.z(paramString.her());
    if (!paramString.startsWith("file://")) {
      paramString = "file://".concat(String.valueOf(paramString));
    }
    for (;;)
    {
      if (paramRect != null) {}
      for (paramRect = new com.tencent.mm.plugin.appbrand.luggage.a.a(paramRect.left, paramRect.top, paramRect.width(), paramRect.height());; paramRect = null)
      {
        paramString = com.tencent.mm.modelappbrand.a.b.aXY().a(paramString, paramRect);
        AppMethodBeat.o(219334);
        return paramString;
      }
    }
  }
  
  public final String b(f paramf, String paramString)
  {
    AppMethodBeat.i(219336);
    if (!a(paramf, paramString))
    {
      AppMethodBeat.o(219336);
      return paramString;
    }
    paramf = Util.nullAsNil((String)acr(paramString).second);
    AppMethodBeat.o(219336);
    return paramf;
  }
  
  public final boolean match(String paramString)
  {
    AppMethodBeat.i(219331);
    if ((paramString != null) && (paramString.startsWith("wxblob://")))
    {
      AppMethodBeat.o(219331);
      return true;
    }
    AppMethodBeat.o(219331);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.luggage.b.h
 * JD-Core Version:    0.7.0.1
 */
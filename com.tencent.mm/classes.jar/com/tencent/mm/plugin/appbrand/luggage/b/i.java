package com.tencent.mm.plugin.appbrand.luggage.b;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.appstorage.p;
import com.tencent.mm.plugin.appbrand.g.a.b;
import com.tencent.mm.plugin.appbrand.g.a.c;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.vfs.e;
import com.tencent.mm.vfs.q;

public final class i
  extends com.tencent.luggage.bridge.impl.a.a
  implements com.tencent.mm.plugin.appbrand.g.b
{
  private final AppBrandRuntime iGV;
  
  public i(AppBrandRuntime paramAppBrandRuntime)
  {
    this.iGV = paramAppBrandRuntime;
  }
  
  private static Pair<String, String> Ku(String paramString)
  {
    AppMethodBeat.i(194469);
    int i = paramString.lastIndexOf("?appId=");
    String str = paramString.substring(0, i);
    paramString = Pair.create(paramString.substring(i + 7), str);
    AppMethodBeat.o(194469);
    return paramString;
  }
  
  public final String AL()
  {
    return "WxFileImageReader";
  }
  
  public final void a(String paramString, a.c paramc)
  {
    AppMethodBeat.i(194470);
    if (paramc == null)
    {
      AppMethodBeat.o(194470);
      return;
    }
    p localp = this.iGV.Ee();
    if (localp == null)
    {
      paramc.A(null);
      AppMethodBeat.o(194470);
      return;
    }
    paramc.A(localp.ET((String)Ku(paramString).second));
    AppMethodBeat.o(194470);
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
    paramb = this.iGV.Ee();
    if (paramb == null)
    {
      AppMethodBeat.o(134904);
      return null;
    }
    paramString = paramb.EP((String)Ku(paramString).second);
    if ((paramString == null) || (!paramString.exists()))
    {
      AppMethodBeat.o(134904);
      return null;
    }
    paramString = q.B(paramString.fhU());
    if (!paramString.startsWith("file://")) {
      paramString = "file://".concat(String.valueOf(paramString));
    }
    for (;;)
    {
      if (paramRect != null) {}
      for (paramRect = new com.tencent.mm.plugin.appbrand.luggage.a.a(paramRect.left, paramRect.top, paramRect.width(), paramRect.height());; paramRect = null)
      {
        paramString = com.tencent.mm.modelappbrand.a.b.aub().a(paramString, paramRect);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.luggage.b.i
 * JD-Core Version:    0.7.0.1
 */
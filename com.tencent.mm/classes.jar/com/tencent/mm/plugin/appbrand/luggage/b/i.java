package com.tencent.mm.plugin.appbrand.luggage.b;

import android.graphics.Bitmap;
import android.graphics.Rect;
import com.tencent.luggage.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.q;
import com.tencent.mm.plugin.appbrand.f.a.b;
import com.tencent.mm.plugin.appbrand.f.a.c;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.vfs.w;

public final class i
  extends com.tencent.luggage.bridge.impl.a.a
  implements com.tencent.mm.plugin.appbrand.f.b
{
  public final String BN()
  {
    return "WxFileAdImageReader";
  }
  
  public final void a(String paramString, a.c paramc)
  {
    AppMethodBeat.i(207763);
    if (!match(paramString))
    {
      ae.w("MicroMsg.WxFileAdImageReader", "openRead, not match, url:%s", new Object[] { paramString });
      AppMethodBeat.o(207763);
      return;
    }
    if (paramc == null)
    {
      AppMethodBeat.o(207763);
      return;
    }
    Object localObject = (com.tencent.mm.plugin.appbrand.ad.k)e.K(com.tencent.mm.plugin.appbrand.ad.k.class);
    if (localObject == null)
    {
      ae.i("MicroMsg.WxFileAdImageReader", "openRead, no ad service");
      AppMethodBeat.o(207763);
      return;
    }
    localObject = ((com.tencent.mm.plugin.appbrand.ad.k)localObject).aYv();
    if (localObject == null)
    {
      ae.i("MicroMsg.WxFileAdImageReader", "openRead, no ad file system");
      AppMethodBeat.o(207763);
      return;
    }
    paramc.D(((q)localObject).MT(paramString));
    AppMethodBeat.o(207763);
  }
  
  public final boolean a(c paramc, String paramString)
  {
    AppMethodBeat.i(162082);
    if ((paramc == null) || (paramString == null) || (paramString.length() == 0))
    {
      AppMethodBeat.o(162082);
      return false;
    }
    boolean bool = paramString.startsWith("wxfile://ad");
    AppMethodBeat.o(162082);
    return bool;
  }
  
  public final Bitmap b(String paramString, Rect paramRect, a.b paramb)
  {
    Object localObject = null;
    AppMethodBeat.i(162081);
    if (!match(paramString))
    {
      ae.w("MicroMsg.WxFileAdImageReader", "read, not match, url:%s", new Object[] { paramString });
      AppMethodBeat.o(162081);
      return null;
    }
    paramb = (com.tencent.mm.plugin.appbrand.ad.k)e.K(com.tencent.mm.plugin.appbrand.ad.k.class);
    if (paramb == null)
    {
      ae.i("MicroMsg.WxFileAdImageReader", "read, no ad service");
      AppMethodBeat.o(162081);
      return null;
    }
    paramb = paramb.aYv();
    if (paramb == null)
    {
      ae.i("MicroMsg.WxFileAdImageReader", "read, no ad file system");
      AppMethodBeat.o(162081);
      return null;
    }
    paramb = paramb.MP(paramString);
    if ((paramb == null) || (!paramb.exists()))
    {
      ae.w("MicroMsg.WxFileAdImageReader", "read, file not exist, url:%s", new Object[] { paramString });
      AppMethodBeat.o(162081);
      return null;
    }
    String str = w.B(paramb.fTh());
    paramb = str;
    if (!str.startsWith("file://")) {
      paramb = "file://".concat(String.valueOf(str));
    }
    ae.w("MicroMsg.WxFileAdImageReader", "read, url:%s, path:%s", new Object[] { paramString, paramb });
    paramString = localObject;
    if (paramRect != null) {
      paramString = new com.tencent.mm.plugin.appbrand.luggage.a.a(paramRect.left, paramRect.top, paramRect.width(), paramRect.height());
    }
    paramString = com.tencent.mm.modelappbrand.a.b.aEl().a(paramb, paramString);
    AppMethodBeat.o(162081);
    return paramString;
  }
  
  public final String b(c paramc, String paramString)
  {
    AppMethodBeat.i(162083);
    if (!a(paramc, paramString))
    {
      AppMethodBeat.o(162083);
      return paramString;
    }
    AppMethodBeat.o(162083);
    return paramString;
  }
  
  public final boolean match(String paramString)
  {
    AppMethodBeat.i(162080);
    if ((paramString != null) && (paramString.startsWith("wxfile://ad")))
    {
      AppMethodBeat.o(162080);
      return true;
    }
    AppMethodBeat.o(162080);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.luggage.b.i
 * JD-Core Version:    0.7.0.1
 */
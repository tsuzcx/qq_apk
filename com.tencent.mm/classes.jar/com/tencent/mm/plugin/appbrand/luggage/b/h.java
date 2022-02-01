package com.tencent.mm.plugin.appbrand.luggage.b;

import android.graphics.Bitmap;
import android.graphics.Rect;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ad.g;
import com.tencent.mm.plugin.appbrand.appstorage.p;
import com.tencent.mm.plugin.appbrand.g.a.b;
import com.tencent.mm.plugin.appbrand.g.a.c;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.vfs.q;

public final class h
  extends com.tencent.luggage.bridge.impl.a.a
  implements com.tencent.mm.plugin.appbrand.g.b
{
  public final String Ap()
  {
    return "WxFileAdImageReader";
  }
  
  public final void a(String paramString, a.c paramc)
  {
    AppMethodBeat.i(193384);
    if (!match(paramString))
    {
      ac.w("MicroMsg.WxFileAdImageReader", "openRead, not match, url:%s", new Object[] { paramString });
      AppMethodBeat.o(193384);
      return;
    }
    if (paramc == null)
    {
      AppMethodBeat.o(193384);
      return;
    }
    Object localObject = (g)com.tencent.luggage.a.e.K(g.class);
    if (localObject == null)
    {
      ac.i("MicroMsg.WxFileAdImageReader", "openRead, no ad service");
      AppMethodBeat.o(193384);
      return;
    }
    localObject = ((g)localObject).aUO();
    if (localObject == null)
    {
      ac.i("MicroMsg.WxFileAdImageReader", "openRead, no ad file system");
      AppMethodBeat.o(193384);
      return;
    }
    paramc.z(((p)localObject).IW(paramString));
    AppMethodBeat.o(193384);
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
      ac.w("MicroMsg.WxFileAdImageReader", "read, not match, url:%s", new Object[] { paramString });
      AppMethodBeat.o(162081);
      return null;
    }
    paramb = (g)com.tencent.luggage.a.e.K(g.class);
    if (paramb == null)
    {
      ac.i("MicroMsg.WxFileAdImageReader", "read, no ad service");
      AppMethodBeat.o(162081);
      return null;
    }
    paramb = paramb.aUO();
    if (paramb == null)
    {
      ac.i("MicroMsg.WxFileAdImageReader", "read, no ad file system");
      AppMethodBeat.o(162081);
      return null;
    }
    paramb = paramb.IS(paramString);
    if ((paramb == null) || (!paramb.exists()))
    {
      ac.w("MicroMsg.WxFileAdImageReader", "read, file not exist, url:%s", new Object[] { paramString });
      AppMethodBeat.o(162081);
      return null;
    }
    String str = q.B(paramb.fxV());
    paramb = str;
    if (!str.startsWith("file://")) {
      paramb = "file://".concat(String.valueOf(str));
    }
    ac.w("MicroMsg.WxFileAdImageReader", "read, url:%s, path:%s", new Object[] { paramString, paramb });
    paramString = localObject;
    if (paramRect != null) {
      paramString = new com.tencent.mm.plugin.appbrand.luggage.a.a(paramRect.left, paramRect.top, paramRect.width(), paramRect.height());
    }
    paramString = com.tencent.mm.modelappbrand.a.b.aAS().a(paramb, paramString);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.luggage.b.h
 * JD-Core Version:    0.7.0.1
 */
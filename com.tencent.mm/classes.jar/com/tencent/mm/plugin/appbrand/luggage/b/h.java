package com.tencent.mm.plugin.appbrand.luggage.b;

import android.graphics.Bitmap;
import android.graphics.Rect;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ad.j;
import com.tencent.mm.plugin.appbrand.appstorage.p;
import com.tencent.mm.plugin.appbrand.f.a.b;
import com.tencent.mm.plugin.appbrand.f.a.c;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.vfs.q;

public final class h
  extends com.tencent.luggage.bridge.impl.a.a
  implements com.tencent.mm.plugin.appbrand.f.b
{
  public final String BM()
  {
    return "WxFileAdImageReader";
  }
  
  public final void a(String paramString, a.c paramc)
  {
    AppMethodBeat.i(197277);
    if (!match(paramString))
    {
      ad.w("MicroMsg.WxFileAdImageReader", "openRead, not match, url:%s", new Object[] { paramString });
      AppMethodBeat.o(197277);
      return;
    }
    if (paramc == null)
    {
      AppMethodBeat.o(197277);
      return;
    }
    Object localObject = (j)com.tencent.luggage.a.e.K(j.class);
    if (localObject == null)
    {
      ad.i("MicroMsg.WxFileAdImageReader", "openRead, no ad service");
      AppMethodBeat.o(197277);
      return;
    }
    localObject = ((j)localObject).aYb();
    if (localObject == null)
    {
      ad.i("MicroMsg.WxFileAdImageReader", "openRead, no ad file system");
      AppMethodBeat.o(197277);
      return;
    }
    paramc.D(((p)localObject).Mn(paramString));
    AppMethodBeat.o(197277);
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
      ad.w("MicroMsg.WxFileAdImageReader", "read, not match, url:%s", new Object[] { paramString });
      AppMethodBeat.o(162081);
      return null;
    }
    paramb = (j)com.tencent.luggage.a.e.K(j.class);
    if (paramb == null)
    {
      ad.i("MicroMsg.WxFileAdImageReader", "read, no ad service");
      AppMethodBeat.o(162081);
      return null;
    }
    paramb = paramb.aYb();
    if (paramb == null)
    {
      ad.i("MicroMsg.WxFileAdImageReader", "read, no ad file system");
      AppMethodBeat.o(162081);
      return null;
    }
    paramb = paramb.Mj(paramString);
    if ((paramb == null) || (!paramb.exists()))
    {
      ad.w("MicroMsg.WxFileAdImageReader", "read, file not exist, url:%s", new Object[] { paramString });
      AppMethodBeat.o(162081);
      return null;
    }
    String str = q.B(paramb.fOK());
    paramb = str;
    if (!str.startsWith("file://")) {
      paramb = "file://".concat(String.valueOf(str));
    }
    ad.w("MicroMsg.WxFileAdImageReader", "read, url:%s, path:%s", new Object[] { paramString, paramb });
    paramString = localObject;
    if (paramRect != null) {
      paramString = new com.tencent.mm.plugin.appbrand.luggage.a.a(paramRect.left, paramRect.top, paramRect.width(), paramRect.height());
    }
    paramString = com.tencent.mm.modelappbrand.a.b.aDV().a(paramb, paramString);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.luggage.b.h
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.appbrand.luggage.b;

import android.graphics.Bitmap;
import android.graphics.Rect;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ad.k;
import com.tencent.mm.plugin.appbrand.appstorage.r;
import com.tencent.mm.plugin.appbrand.f.a.b;
import com.tencent.mm.plugin.appbrand.f.a.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.q;

public final class g
  extends com.tencent.luggage.bridge.impl.a.a
  implements com.tencent.mm.plugin.appbrand.f.b
{
  public final void a(String paramString, a.c paramc)
  {
    AppMethodBeat.i(242898);
    if (!dq(paramString))
    {
      Log.w("MicroMsg.WxFileAdImageReader", "openRead, not match, url:%s", new Object[] { paramString });
      AppMethodBeat.o(242898);
      return;
    }
    if (paramc == null)
    {
      AppMethodBeat.o(242898);
      return;
    }
    Object localObject = (k)com.tencent.luggage.a.e.K(k.class);
    if (localObject == null)
    {
      Log.i("MicroMsg.WxFileAdImageReader", "openRead, no ad service");
      AppMethodBeat.o(242898);
      return;
    }
    localObject = ((k)localObject).bEH();
    if (localObject == null)
    {
      Log.i("MicroMsg.WxFileAdImageReader", "openRead, no ad file system");
      AppMethodBeat.o(242898);
      return;
    }
    paramc.A(((r)localObject).adQ(paramString));
    AppMethodBeat.o(242898);
  }
  
  public final boolean a(com.tencent.mm.plugin.appbrand.jsapi.e parame, String paramString)
  {
    AppMethodBeat.i(162082);
    if ((parame == null) || (paramString == null) || (paramString.length() == 0))
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
    if (!dq(paramString))
    {
      Log.w("MicroMsg.WxFileAdImageReader", "read, not match, url:%s", new Object[] { paramString });
      AppMethodBeat.o(162081);
      return null;
    }
    paramb = (k)com.tencent.luggage.a.e.K(k.class);
    if (paramb == null)
    {
      Log.i("MicroMsg.WxFileAdImageReader", "read, no ad service");
      AppMethodBeat.o(162081);
      return null;
    }
    paramb = paramb.bEH();
    if (paramb == null)
    {
      Log.i("MicroMsg.WxFileAdImageReader", "read, no ad file system");
      AppMethodBeat.o(162081);
      return null;
    }
    paramb = paramb.adL(paramString);
    if ((paramb == null) || (!paramb.ifE()))
    {
      Log.w("MicroMsg.WxFileAdImageReader", "read, file not exist, url:%s", new Object[] { paramString });
      AppMethodBeat.o(162081);
      return null;
    }
    String str = paramb.bOF();
    paramb = str;
    if (!str.startsWith("file://")) {
      paramb = "file://".concat(String.valueOf(str));
    }
    Log.w("MicroMsg.WxFileAdImageReader", "read, url:%s, path:%s", new Object[] { paramString, paramb });
    paramString = localObject;
    if (paramRect != null) {
      paramString = new com.tencent.mm.plugin.appbrand.luggage.a.a(paramRect.left, paramRect.top, paramRect.width(), paramRect.height());
    }
    paramString = com.tencent.mm.modelappbrand.a.b.bhh().a(paramb, paramString);
    AppMethodBeat.o(162081);
    return paramString;
  }
  
  public final String b(com.tencent.mm.plugin.appbrand.jsapi.e parame, String paramString)
  {
    AppMethodBeat.i(162083);
    if (!a(parame, paramString))
    {
      AppMethodBeat.o(162083);
      return paramString;
    }
    AppMethodBeat.o(162083);
    return paramString;
  }
  
  public final boolean dq(String paramString)
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
  
  public final String key()
  {
    return "WxFileAdImageReader";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.luggage.b.g
 * JD-Core Version:    0.7.0.1
 */
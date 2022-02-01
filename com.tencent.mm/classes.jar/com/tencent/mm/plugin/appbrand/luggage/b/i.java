package com.tencent.mm.plugin.appbrand.luggage.b;

import android.graphics.Bitmap;
import android.graphics.Rect;
import com.tencent.luggage.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ad.k;
import com.tencent.mm.plugin.appbrand.appstorage.q;
import com.tencent.mm.plugin.appbrand.f.a.b;
import com.tencent.mm.plugin.appbrand.f.a.c;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.o;

public final class i
  extends com.tencent.luggage.bridge.impl.a.a
  implements com.tencent.mm.plugin.appbrand.f.b
{
  public final String Lb()
  {
    return "WxFileAdImageReader";
  }
  
  public final void a(String paramString, a.c paramc)
  {
    AppMethodBeat.i(219337);
    if (!match(paramString))
    {
      Log.w("MicroMsg.WxFileAdImageReader", "openRead, not match, url:%s", new Object[] { paramString });
      AppMethodBeat.o(219337);
      return;
    }
    if (paramc == null)
    {
      AppMethodBeat.o(219337);
      return;
    }
    Object localObject = (k)e.M(k.class);
    if (localObject == null)
    {
      Log.i("MicroMsg.WxFileAdImageReader", "openRead, no ad service");
      AppMethodBeat.o(219337);
      return;
    }
    localObject = ((k)localObject).btJ();
    if (localObject == null)
    {
      Log.i("MicroMsg.WxFileAdImageReader", "openRead, no ad file system");
      AppMethodBeat.o(219337);
      return;
    }
    paramc.C(((q)localObject).Wc(paramString));
    AppMethodBeat.o(219337);
  }
  
  public final boolean a(f paramf, String paramString)
  {
    AppMethodBeat.i(162082);
    if ((paramf == null) || (paramString == null) || (paramString.length() == 0))
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
      Log.w("MicroMsg.WxFileAdImageReader", "read, not match, url:%s", new Object[] { paramString });
      AppMethodBeat.o(162081);
      return null;
    }
    paramb = (k)e.M(k.class);
    if (paramb == null)
    {
      Log.i("MicroMsg.WxFileAdImageReader", "read, no ad service");
      AppMethodBeat.o(162081);
      return null;
    }
    paramb = paramb.btJ();
    if (paramb == null)
    {
      Log.i("MicroMsg.WxFileAdImageReader", "read, no ad file system");
      AppMethodBeat.o(162081);
      return null;
    }
    paramb = paramb.VY(paramString);
    if ((paramb == null) || (!paramb.exists()))
    {
      Log.w("MicroMsg.WxFileAdImageReader", "read, file not exist, url:%s", new Object[] { paramString });
      AppMethodBeat.o(162081);
      return null;
    }
    String str = aa.z(paramb.her());
    paramb = str;
    if (!str.startsWith("file://")) {
      paramb = "file://".concat(String.valueOf(str));
    }
    Log.w("MicroMsg.WxFileAdImageReader", "read, url:%s, path:%s", new Object[] { paramString, paramb });
    paramString = localObject;
    if (paramRect != null) {
      paramString = new com.tencent.mm.plugin.appbrand.luggage.a.a(paramRect.left, paramRect.top, paramRect.width(), paramRect.height());
    }
    paramString = com.tencent.mm.modelappbrand.a.b.aXY().a(paramb, paramString);
    AppMethodBeat.o(162081);
    return paramString;
  }
  
  public final String b(f paramf, String paramString)
  {
    AppMethodBeat.i(162083);
    if (!a(paramf, paramString))
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.luggage.b.i
 * JD-Core Version:    0.7.0.1
 */
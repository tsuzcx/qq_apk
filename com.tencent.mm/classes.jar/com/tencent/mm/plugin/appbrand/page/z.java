package com.tencent.mm.plugin.appbrand.page;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelappbrand.a.b.d;
import com.tencent.mm.modelappbrand.a.b.l;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.ac.h;
import com.tencent.mm.plugin.appbrand.appcache.bg;
import com.tencent.mm.plugin.appbrand.appstorage.n;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.Set;

public final class z
{
  private static final b.l nqx;
  private static final h<AppBrandRuntime, String> nqy;
  
  static
  {
    AppMethodBeat.i(135112);
    nqx = new b.d();
    nqy = new h();
    AppMethodBeat.o(135112);
  }
  
  public static void af(AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(219429);
    paramAppBrandRuntime = nqy.cN(paramAppBrandRuntime);
    if (paramAppBrandRuntime != null)
    {
      paramAppBrandRuntime = paramAppBrandRuntime.iterator();
      while (paramAppBrandRuntime.hasNext())
      {
        String str = (String)paramAppBrandRuntime.next();
        nqx.remove(str);
      }
    }
    AppMethodBeat.o(219429);
  }
  
  public static Bitmap k(AppBrandRuntime paramAppBrandRuntime, String paramString)
  {
    AppMethodBeat.i(135111);
    if (paramAppBrandRuntime == null)
    {
      AppMethodBeat.o(135111);
      return null;
    }
    Object localObject = n.Wd(paramString);
    if (Util.isNullOrNil((String)localObject))
    {
      AppMethodBeat.o(135111);
      return null;
    }
    paramString = paramAppBrandRuntime.hashCode() + 35 + (String)localObject;
    nqy.r(paramAppBrandRuntime, paramString);
    Bitmap localBitmap = nqx.EP(paramString);
    if ((localBitmap != null) && (!localBitmap.isRecycled()))
    {
      AppMethodBeat.o(135111);
      return localBitmap;
    }
    paramAppBrandRuntime = bg.f(paramAppBrandRuntime, (String)localObject);
    if (paramAppBrandRuntime != null) {}
    try
    {
      int i = paramAppBrandRuntime.available();
      if (i <= 0) {
        return null;
      }
      localObject = BitmapUtil.decodeStream(paramAppBrandRuntime);
      if ((localObject != null) && (!((Bitmap)localObject).isRecycled()))
      {
        nqx.put(paramString, (Bitmap)localObject);
        return localObject;
      }
      if (paramAppBrandRuntime != null) {
        Util.qualityClose(paramAppBrandRuntime);
      }
    }
    catch (IOException paramString)
    {
      for (;;)
      {
        Log.e("MicroMsg.AppBrandPageIconCache", "try decode icon e = %s", new Object[] { paramString });
        if (paramAppBrandRuntime != null) {
          Util.qualityClose(paramAppBrandRuntime);
        }
      }
    }
    finally
    {
      if (paramAppBrandRuntime == null) {
        break label227;
      }
      Util.qualityClose(paramAppBrandRuntime);
      AppMethodBeat.o(135111);
    }
    AppMethodBeat.o(135111);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.z
 * JD-Core Version:    0.7.0.1
 */
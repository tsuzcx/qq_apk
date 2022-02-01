package com.tencent.mm.plugin.appbrand.page;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelappbrand.a.b.d;
import com.tencent.mm.modelappbrand.a.b.l;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.appcache.bf;
import com.tencent.mm.plugin.appbrand.appstorage.m;
import com.tencent.mm.plugin.appbrand.z.h;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.g;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.Set;

public final class x
{
  private static final b.l mbG;
  private static final h<AppBrandRuntime, String> mbH;
  
  static
  {
    AppMethodBeat.i(135112);
    mbG = new b.d();
    mbH = new h();
    AppMethodBeat.o(135112);
  }
  
  public static void af(AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(197330);
    paramAppBrandRuntime = mbH.cF(paramAppBrandRuntime);
    if (paramAppBrandRuntime != null)
    {
      paramAppBrandRuntime = paramAppBrandRuntime.iterator();
      while (paramAppBrandRuntime.hasNext())
      {
        String str = (String)paramAppBrandRuntime.next();
        mbG.remove(str);
      }
    }
    AppMethodBeat.o(197330);
  }
  
  public static Bitmap k(AppBrandRuntime paramAppBrandRuntime, String paramString)
  {
    AppMethodBeat.i(135111);
    if (paramAppBrandRuntime == null)
    {
      AppMethodBeat.o(135111);
      return null;
    }
    Object localObject = m.Mo(paramString);
    if (bt.isNullOrNil((String)localObject))
    {
      AppMethodBeat.o(135111);
      return null;
    }
    paramString = paramAppBrandRuntime.hashCode() + 35 + (String)localObject;
    mbH.j(paramAppBrandRuntime, paramString);
    Bitmap localBitmap = mbG.vT(paramString);
    if ((localBitmap != null) && (!localBitmap.isRecycled()))
    {
      AppMethodBeat.o(135111);
      return localBitmap;
    }
    paramAppBrandRuntime = bf.f(paramAppBrandRuntime, (String)localObject);
    if (paramAppBrandRuntime != null) {}
    try
    {
      int i = paramAppBrandRuntime.available();
      if (i <= 0) {
        return null;
      }
      localObject = g.decodeStream(paramAppBrandRuntime);
      if ((localObject != null) && (!((Bitmap)localObject).isRecycled()))
      {
        mbG.put(paramString, (Bitmap)localObject);
        return localObject;
      }
      if (paramAppBrandRuntime != null) {
        bt.d(paramAppBrandRuntime);
      }
    }
    catch (IOException paramString)
    {
      for (;;)
      {
        ad.e("MicroMsg.AppBrandPageIconCache", "try decode icon e = %s", new Object[] { paramString });
        if (paramAppBrandRuntime != null) {
          bt.d(paramAppBrandRuntime);
        }
      }
    }
    finally
    {
      if (paramAppBrandRuntime == null) {
        break label227;
      }
      bt.d(paramAppBrandRuntime);
      AppMethodBeat.o(135111);
    }
    AppMethodBeat.o(135111);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.x
 * JD-Core Version:    0.7.0.1
 */
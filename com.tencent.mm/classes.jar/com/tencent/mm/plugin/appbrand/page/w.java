package com.tencent.mm.plugin.appbrand.page;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelappbrand.a.b.d;
import com.tencent.mm.modelappbrand.a.b.l;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.appcache.bg;
import com.tencent.mm.plugin.appbrand.appstorage.n;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.Set;

public final class w
{
  private static final b.l mfZ;
  private static final com.tencent.mm.plugin.appbrand.y.h<AppBrandRuntime, String> mga;
  
  static
  {
    AppMethodBeat.i(135112);
    mfZ = new b.d();
    mga = new com.tencent.mm.plugin.appbrand.y.h();
    AppMethodBeat.o(135112);
  }
  
  public static void ae(AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(207842);
    paramAppBrandRuntime = mga.cG(paramAppBrandRuntime);
    if (paramAppBrandRuntime != null)
    {
      paramAppBrandRuntime = paramAppBrandRuntime.iterator();
      while (paramAppBrandRuntime.hasNext())
      {
        String str = (String)paramAppBrandRuntime.next();
        mfZ.remove(str);
      }
    }
    AppMethodBeat.o(207842);
  }
  
  public static Bitmap k(AppBrandRuntime paramAppBrandRuntime, String paramString)
  {
    AppMethodBeat.i(135111);
    if (paramAppBrandRuntime == null)
    {
      AppMethodBeat.o(135111);
      return null;
    }
    Object localObject = n.MU(paramString);
    if (bu.isNullOrNil((String)localObject))
    {
      AppMethodBeat.o(135111);
      return null;
    }
    paramString = paramAppBrandRuntime.hashCode() + 35 + (String)localObject;
    mga.j(paramAppBrandRuntime, paramString);
    Bitmap localBitmap = mfZ.wA(paramString);
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
      localObject = com.tencent.mm.sdk.platformtools.h.decodeStream(paramAppBrandRuntime);
      if ((localObject != null) && (!((Bitmap)localObject).isRecycled()))
      {
        mfZ.put(paramString, (Bitmap)localObject);
        return localObject;
      }
      if (paramAppBrandRuntime != null) {
        bu.d(paramAppBrandRuntime);
      }
    }
    catch (IOException paramString)
    {
      for (;;)
      {
        ae.e("MicroMsg.AppBrandPageIconCache", "try decode icon e = %s", new Object[] { paramString });
        if (paramAppBrandRuntime != null) {
          bu.d(paramAppBrandRuntime);
        }
      }
    }
    finally
    {
      if (paramAppBrandRuntime == null) {
        break label227;
      }
      bu.d(paramAppBrandRuntime);
      AppMethodBeat.o(135111);
    }
    AppMethodBeat.o(135111);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.w
 * JD-Core Version:    0.7.0.1
 */
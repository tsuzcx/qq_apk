package com.tencent.mm.plugin.appbrand.page;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelappbrand.a.b.c;
import com.tencent.mm.modelappbrand.a.b.j;
import com.tencent.mm.plugin.appbrand.appcache.ax;
import com.tencent.mm.plugin.appbrand.appstorage.k;
import com.tencent.mm.plugin.appbrand.i;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.d;
import java.io.IOException;
import java.io.InputStream;

public final class t
{
  private static final b.j ixc;
  
  static
  {
    AppMethodBeat.i(87156);
    ixc = new b.c();
    AppMethodBeat.o(87156);
  }
  
  public static Bitmap j(i parami, String paramString)
  {
    AppMethodBeat.i(87155);
    if (parami == null)
    {
      AppMethodBeat.o(87155);
      return null;
    }
    Object localObject = k.zk(paramString);
    if (bo.isNullOrNil((String)localObject))
    {
      AppMethodBeat.o(87155);
      return null;
    }
    paramString = parami.hashCode() + 35 + (String)localObject;
    Bitmap localBitmap = ixc.lK(paramString);
    if ((localBitmap != null) && (!localBitmap.isRecycled()))
    {
      AppMethodBeat.o(87155);
      return localBitmap;
    }
    parami = ax.f(parami, (String)localObject);
    if (parami != null) {}
    try
    {
      int i = parami.available();
      if (i <= 0) {
        return null;
      }
      localObject = d.decodeStream(parami);
      if ((localObject != null) && (!((Bitmap)localObject).isRecycled()))
      {
        ixc.c(paramString, (Bitmap)localObject);
        return localObject;
      }
      if (parami != null) {
        bo.b(parami);
      }
    }
    catch (IOException paramString)
    {
      for (;;)
      {
        ab.e("MicroMsg.AppBrandPageIconCache", "try decode icon e = %s", new Object[] { paramString });
        if (parami != null) {
          bo.b(parami);
        }
      }
    }
    finally
    {
      if (parami == null) {
        break label218;
      }
      bo.b(parami);
      AppMethodBeat.o(87155);
    }
    AppMethodBeat.o(87155);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.t
 * JD-Core Version:    0.7.0.1
 */
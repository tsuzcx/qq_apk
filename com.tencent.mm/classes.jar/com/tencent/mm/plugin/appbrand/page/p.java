package com.tencent.mm.plugin.appbrand.page;

import android.graphics.Bitmap;
import com.tencent.mm.modelappbrand.a.b.c;
import com.tencent.mm.modelappbrand.a.b.i;
import com.tencent.mm.plugin.appbrand.appcache.aq;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.c;
import com.tencent.mm.sdk.platformtools.y;
import java.io.IOException;
import java.io.InputStream;

public final class p
{
  private static final b.i gTu = new b.c();
  
  public static Bitmap i(com.tencent.mm.plugin.appbrand.i parami, String paramString)
  {
    if (parami == null) {}
    for (;;)
    {
      return null;
      Object localObject = com.tencent.mm.plugin.appbrand.appstorage.i.rz(paramString);
      if (bk.bl((String)localObject)) {
        continue;
      }
      paramString = parami.hashCode() + 35 + (String)localObject;
      Bitmap localBitmap = gTu.jK(paramString);
      if ((localBitmap != null) && (!localBitmap.isRecycled())) {
        return localBitmap;
      }
      parami = aq.d(parami, (String)localObject);
      if (parami != null) {}
      try
      {
        int i = parami.available();
        if (i <= 0) {
          return null;
        }
        localObject = c.decodeStream(parami);
        if ((localObject != null) && (!((Bitmap)localObject).isRecycled()))
        {
          gTu.c(paramString, (Bitmap)localObject);
          return localObject;
        }
        return null;
      }
      catch (IOException paramString)
      {
        y.e("MicroMsg.AppBrandPageIconCache", "try decode icon e = %s", new Object[] { paramString });
        return null;
      }
      finally
      {
        if (parami != null) {
          bk.b(parami);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.p
 * JD-Core Version:    0.7.0.1
 */
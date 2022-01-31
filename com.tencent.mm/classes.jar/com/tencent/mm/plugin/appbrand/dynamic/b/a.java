package com.tencent.mm.plugin.appbrand.dynamic.b;

import android.graphics.Bitmap;
import com.tencent.mm.modelappbrand.a.b.c;
import com.tencent.mm.modelappbrand.a.b.i;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.xweb.m;
import java.io.IOException;
import java.io.InputStream;

public final class a
{
  private static final b.i fUG = new b.c();
  
  public static Bitmap bo(String paramString1, String paramString2)
  {
    if ((bk.bl(paramString1)) || (bk.bl(paramString2))) {}
    for (;;)
    {
      return null;
      Object localObject = com.tencent.mm.plugin.appbrand.appcache.a.qQ(paramString2);
      if (bk.bl((String)localObject)) {
        continue;
      }
      paramString2 = paramString1 + '#' + (String)localObject;
      Bitmap localBitmap = fUG.jK(paramString2);
      if ((localBitmap != null) && (!localBitmap.isRecycled())) {
        return localBitmap;
      }
      paramString1 = com.tencent.mm.plugin.appbrand.dynamic.j.c.br(paramString1, (String)localObject);
      if (paramString1 != null) {}
      try
      {
        if (paramString1.mInputStream != null)
        {
          int i = paramString1.mInputStream.available();
          if (i > 0) {}
        }
        else
        {
          return null;
        }
        localObject = com.tencent.mm.sdk.platformtools.c.decodeStream(paramString1.mInputStream);
        if ((localObject != null) && (!((Bitmap)localObject).isRecycled()))
        {
          fUG.c(paramString2, (Bitmap)localObject);
          return localObject;
        }
        return null;
      }
      catch (IOException paramString2)
      {
        y.e("MicroMsg.CanvasImageCache", "try decode icon e = %s", new Object[] { paramString2 });
        return null;
      }
      finally
      {
        if (paramString1 != null) {
          bk.b(paramString1.mInputStream);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.b.a
 * JD-Core Version:    0.7.0.1
 */
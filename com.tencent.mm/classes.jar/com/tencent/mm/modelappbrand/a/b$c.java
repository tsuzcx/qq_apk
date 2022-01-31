package com.tencent.mm.modelappbrand.a;

import android.graphics.Bitmap;
import com.tencent.mm.a.f;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.lang.ref.Reference;
import java.lang.ref.SoftReference;

public final class b$c
  implements b.i
{
  final f<String, Reference<Bitmap>> eas = new b.c.1(this);
  
  public final void c(String paramString, Bitmap paramBitmap)
  {
    if ((bk.bl(paramString)) || (paramBitmap == null)) {
      return;
    }
    y.d("MicroMsg.AppBrandSimpleImageLoader.DefaultMemoryCache", "put, key %s, bmp %s", new Object[] { paramString, paramBitmap });
    this.eas.put(paramString, new SoftReference(paramBitmap));
  }
  
  public final Bitmap jK(String paramString)
  {
    Object localObject;
    if (bk.bl(paramString)) {
      localObject = null;
    }
    Bitmap localBitmap;
    do
    {
      return localObject;
      localObject = (Reference)this.eas.get(paramString);
      if (localObject == null) {
        return null;
      }
      localBitmap = (Bitmap)((Reference)localObject).get();
      if (localBitmap == null) {
        break;
      }
      localObject = localBitmap;
    } while (!localBitmap.isRecycled());
    this.eas.remove(paramString);
    return null;
  }
  
  public final void m(Bitmap paramBitmap)
  {
    y.d("MicroMsg.AppBrandSimpleImageLoader.DefaultMemoryCache", "release, bmp %s", new Object[] { paramBitmap });
    if (paramBitmap != null) {
      paramBitmap.isRecycled();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.modelappbrand.a.b.c
 * JD-Core Version:    0.7.0.1
 */
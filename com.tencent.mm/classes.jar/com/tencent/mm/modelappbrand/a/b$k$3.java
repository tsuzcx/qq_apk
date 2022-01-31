package com.tencent.mm.modelappbrand.a;

import android.graphics.Bitmap;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Map;

final class b$k$3
  implements Runnable
{
  b$k$3(b.k paramk, Bitmap paramBitmap) {}
  
  public final void run()
  {
    b.k localk = this.eaH;
    Object localObject = this.eaI;
    if ((localObject == null) || (((Bitmap)localObject).isRecycled()))
    {
      y.d("MicroMsg.AppBrandSimpleImageLoader.LoadTask", "postLoadInMainThread, onLoadFailed bmp %s", new Object[] { localObject });
      localObject = (b.h)b.b(localk.eay).remove(localk.JL());
      if (localObject != null)
      {
        ((b.h)localObject).JH();
        b.a(localk.eay).remove(localObject);
      }
      return;
    }
    y.d("MicroMsg.AppBrandSimpleImageLoader.LoadTask", "postLoadInMainThread, onBitmapLoaded bmp %s", new Object[] { localObject });
    localk.p((Bitmap)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.modelappbrand.a.b.k.3
 * JD-Core Version:    0.7.0.1
 */
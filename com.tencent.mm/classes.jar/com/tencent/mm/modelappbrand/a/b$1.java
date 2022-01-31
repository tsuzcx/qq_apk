package com.tencent.mm.modelappbrand.a;

import android.graphics.Bitmap;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Map;

final class b$1
  implements Runnable
{
  b$1(b paramb, String paramString1, b.h paramh, String paramString2, b.k paramk) {}
  
  public final void run()
  {
    Object localObject = this.eao.jG(this.eal);
    if (localObject != null)
    {
      this.eam.p((Bitmap)localObject);
      y.d("MicroMsg.AppBrandSimpleImageLoader", "load already cached, url %s, bitmap %s", new Object[] { this.val$url, localObject });
      return;
    }
    localObject = this.ean.JL();
    b.a(this.eao).put(this.eam, localObject);
    b.b(this.eao).put(localObject, this.eam);
    this.eam.JG();
    localObject = this.ean;
    b.d(((b.k)localObject).eay).f(new b.k.2((b.k)localObject));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.modelappbrand.a.b.1
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.modelappbrand.a;

import android.graphics.Bitmap;
import com.tencent.mm.a.f;
import com.tencent.mm.a.f.a;
import com.tencent.mm.sdk.platformtools.y;
import java.lang.ref.Reference;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

final class b$c$1
  extends f<String, Reference<Bitmap>>
{
  private final Map<Reference<Bitmap>, Integer> eat = new ConcurrentHashMap();
  
  b$c$1(b.c paramc)
  {
    super(31457280);
  }
  
  public final void a(f.a<String, Reference<Bitmap>> parama)
  {
    y.d("MicroMsg.AppBrandSimpleImageLoader.DefaultMemoryCache", "clear(OnClearListener)");
    super.a(parama);
    this.eat.clear();
  }
  
  public final void clear()
  {
    y.d("MicroMsg.AppBrandSimpleImageLoader.DefaultMemoryCache", "clear");
    super.clear();
    this.eat.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.modelappbrand.a.b.c.1
 * JD-Core Version:    0.7.0.1
 */
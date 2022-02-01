package com.tencent.mm.loader.b.b;

import android.graphics.Bitmap;
import com.tencent.mm.memory.a.b;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/loader/cache/memory/DefaultMemoryCacheMap;", "", "()V", "MAX_BIG_BITMAP_SIZE", "", "getMAX_BIG_BITMAP_SIZE", "()I", "MAX_DEFAULT_BITMAP_SIZE", "getMAX_DEFAULT_BITMAP_SIZE", "OVERSIZE_BITMAP_SIZE", "getOVERSIZE_BITMAP_SIZE", "bigImageMemoryCache", "Lcom/tencent/mm/memory/cache/BitmapResource;", "Landroid/graphics/Bitmap;", "getBigImageMemoryCache", "()Lcom/tencent/mm/memory/cache/BitmapResource;", "defaultImageMemoryCache", "getDefaultImageMemoryCache", "libimageloader_release"})
public final class d
{
  private static final b<Bitmap> hfQ;
  private static final int hfR = 50;
  private static final int hfT = 524288;
  private static final int hfU = 10;
  private static final b<Bitmap> hfZ;
  public static final d hga;
  
  static
  {
    d locald = new d();
    hga = locald;
    hfT = 524288;
    hfR = 50;
    hfU = 10;
    hfQ = new b(hfR, locald.getClass());
    hfZ = new b(hfU, locald.getClass());
  }
  
  public static int aqZ()
  {
    return hfT;
  }
  
  public static int ara()
  {
    return hfR;
  }
  
  public static int arb()
  {
    return hfU;
  }
  
  public static b<Bitmap> arc()
  {
    return hfQ;
  }
  
  public static b<Bitmap> ard()
  {
    return hfZ;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.loader.b.b.d
 * JD-Core Version:    0.7.0.1
 */
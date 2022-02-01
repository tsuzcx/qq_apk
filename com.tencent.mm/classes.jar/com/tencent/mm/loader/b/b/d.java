package com.tencent.mm.loader.b.b;

import android.graphics.Bitmap;
import com.tencent.mm.memory.a.b;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/loader/cache/memory/DefaultMemoryCacheMap;", "", "()V", "MAX_BIG_BITMAP_SIZE", "", "getMAX_BIG_BITMAP_SIZE", "()I", "MAX_DEFAULT_BITMAP_SIZE", "getMAX_DEFAULT_BITMAP_SIZE", "OVERSIZE_BITMAP_SIZE", "getOVERSIZE_BITMAP_SIZE", "bigImageMemoryCache", "Lcom/tencent/mm/memory/cache/BitmapResource;", "Landroid/graphics/Bitmap;", "getBigImageMemoryCache", "()Lcom/tencent/mm/memory/cache/BitmapResource;", "defaultImageMemoryCache", "getDefaultImageMemoryCache", "libimageloader_release"})
public final class d
{
  private static final b<Bitmap> hYL;
  private static final int hYM = 50;
  private static final int hYO = 524288;
  private static final int hYP = 10;
  private static final b<Bitmap> hYU;
  public static final d hYV;
  
  static
  {
    d locald = new d();
    hYV = locald;
    hYO = 524288;
    hYM = 50;
    hYP = 10;
    hYL = new b(hYM, locald.getClass());
    hYU = new b(hYP, locald.getClass());
  }
  
  public static int aJA()
  {
    return hYP;
  }
  
  public static b<Bitmap> aJB()
  {
    return hYL;
  }
  
  public static b<Bitmap> aJC()
  {
    return hYU;
  }
  
  public static int aJy()
  {
    return hYO;
  }
  
  public static int aJz()
  {
    return hYM;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.loader.b.b.d
 * JD-Core Version:    0.7.0.1
 */
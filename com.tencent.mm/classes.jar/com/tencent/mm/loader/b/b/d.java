package com.tencent.mm.loader.b.b;

import android.graphics.Bitmap;
import com.tencent.mm.memory.a.b;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/loader/cache/memory/DefaultMemoryCacheMap;", "", "()V", "MAX_BIG_BITMAP_SIZE", "", "getMAX_BIG_BITMAP_SIZE", "()I", "MAX_DEFAULT_BITMAP_SIZE", "getMAX_DEFAULT_BITMAP_SIZE", "OVERSIZE_BITMAP_SIZE", "getOVERSIZE_BITMAP_SIZE", "bigImageMemoryCache", "Lcom/tencent/mm/memory/cache/BitmapResource;", "Landroid/graphics/Bitmap;", "getBigImageMemoryCache", "()Lcom/tencent/mm/memory/cache/BitmapResource;", "defaultImageMemoryCache", "getDefaultImageMemoryCache", "libimageloader_release"})
public final class d
{
  private static final b<Bitmap> gJA;
  public static final d gJB;
  private static final b<Bitmap> gJr;
  private static final int gJs = 50;
  private static final int gJu = 524288;
  private static final int gJv = 10;
  
  static
  {
    d locald = new d();
    gJB = locald;
    gJu = 524288;
    gJs = 50;
    gJv = 10;
    gJr = new b(gJs, locald.getClass());
    gJA = new b(gJv, locald.getClass());
  }
  
  public static int anX()
  {
    return gJu;
  }
  
  public static int anY()
  {
    return gJs;
  }
  
  public static int anZ()
  {
    return gJv;
  }
  
  public static b<Bitmap> aoa()
  {
    return gJr;
  }
  
  public static b<Bitmap> aob()
  {
    return gJA;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.loader.b.b.d
 * JD-Core Version:    0.7.0.1
 */
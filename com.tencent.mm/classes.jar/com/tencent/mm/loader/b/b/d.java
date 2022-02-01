package com.tencent.mm.loader.b.b;

import android.graphics.Bitmap;
import com.tencent.mm.memory.a.b;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/loader/cache/memory/DefaultMemoryCacheMap;", "", "()V", "MAX_BIG_BITMAP_SIZE", "", "getMAX_BIG_BITMAP_SIZE", "()I", "MAX_DEFAULT_BITMAP_SIZE", "getMAX_DEFAULT_BITMAP_SIZE", "OVERSIZE_BITMAP_SIZE", "getOVERSIZE_BITMAP_SIZE", "bigImageMemoryCache", "Lcom/tencent/mm/memory/cache/BitmapResource;", "Landroid/graphics/Bitmap;", "getBigImageMemoryCache", "()Lcom/tencent/mm/memory/cache/BitmapResource;", "defaultImageMemoryCache", "getDefaultImageMemoryCache", "libimageloader_release"})
public final class d
{
  private static final b<Bitmap> kNA;
  public static final d kNB;
  private static final b<Bitmap> kNp;
  private static final int kNr = 50;
  private static final int kNu = 524288;
  private static final int kNv = 10;
  
  static
  {
    d locald = new d();
    kNB = locald;
    kNu = 524288;
    kNr = 50;
    kNv = 10;
    kNp = new b(kNr, locald.getClass());
    kNA = new b(kNv, locald.getClass());
  }
  
  public static int aRA()
  {
    return kNv;
  }
  
  public static b<Bitmap> aRB()
  {
    return kNp;
  }
  
  public static b<Bitmap> aRC()
  {
    return kNA;
  }
  
  public static int aRy()
  {
    return kNu;
  }
  
  public static int aRz()
  {
    return kNr;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.loader.b.b.d
 * JD-Core Version:    0.7.0.1
 */
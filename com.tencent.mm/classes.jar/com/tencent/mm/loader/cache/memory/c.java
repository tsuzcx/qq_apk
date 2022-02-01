package com.tencent.mm.loader.cache.memory;

import android.graphics.Bitmap;
import com.tencent.mm.memory.a.b;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/loader/cache/memory/DefaultMemoryCacheMap;", "", "()V", "MAX_BIG_BITMAP_SIZE", "", "getMAX_BIG_BITMAP_SIZE", "()I", "MAX_DEFAULT_BITMAP_SIZE", "getMAX_DEFAULT_BITMAP_SIZE", "OVERSIZE_BITMAP_SIZE", "getOVERSIZE_BITMAP_SIZE", "bigImageMemoryCache", "Lcom/tencent/mm/memory/cache/BitmapResource;", "Landroid/graphics/Bitmap;", "getBigImageMemoryCache", "()Lcom/tencent/mm/memory/cache/BitmapResource;", "defaultImageMemoryCache", "getDefaultImageMemoryCache", "libimageloader_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
{
  private static final b<Bitmap> npe = new b(npg, npo.getClass());
  private static final int npg;
  private static final int npi;
  private static final int npj;
  public static final c npo = new c();
  private static final b<Bitmap> npp = new b(npj, npo.getClass());
  
  static
  {
    npi = 524288;
    npg = 50;
    npj = 10;
  }
  
  public static int bln()
  {
    return npi;
  }
  
  public static int blo()
  {
    return npg;
  }
  
  public static int blp()
  {
    return npj;
  }
  
  public static b<Bitmap> blq()
  {
    return npe;
  }
  
  public static b<Bitmap> blr()
  {
    return npp;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.loader.cache.memory.c
 * JD-Core Version:    0.7.0.1
 */
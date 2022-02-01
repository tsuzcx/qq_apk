package com.tencent.mm.loader.b.b;

import android.graphics.Bitmap;
import com.tencent.mm.memory.a.b;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/loader/cache/memory/DefaultMemoryCacheMap;", "", "()V", "MAX_BIG_BITMAP_SIZE", "", "getMAX_BIG_BITMAP_SIZE", "()I", "MAX_DEFAULT_BITMAP_SIZE", "getMAX_DEFAULT_BITMAP_SIZE", "OVERSIZE_BITMAP_SIZE", "getOVERSIZE_BITMAP_SIZE", "bigImageMemoryCache", "Lcom/tencent/mm/memory/cache/BitmapResource;", "Landroid/graphics/Bitmap;", "getBigImageMemoryCache", "()Lcom/tencent/mm/memory/cache/BitmapResource;", "defaultImageMemoryCache", "getDefaultImageMemoryCache", "libimageloader_release"})
public final class d
{
  private static final b<Bitmap> giG;
  private static final int giH = 50;
  private static final int giJ = 524288;
  private static final int giK = 10;
  private static final b<Bitmap> giP;
  public static final d giQ;
  
  static
  {
    d locald = new d();
    giQ = locald;
    giJ = 524288;
    giH = 50;
    giK = 10;
    giG = new b(giH, locald.getClass());
    giP = new b(giK, locald.getClass());
  }
  
  public static int agV()
  {
    return giJ;
  }
  
  public static int agW()
  {
    return giH;
  }
  
  public static int agX()
  {
    return giK;
  }
  
  public static b<Bitmap> agY()
  {
    return giG;
  }
  
  public static b<Bitmap> agZ()
  {
    return giP;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.loader.b.b.d
 * JD-Core Version:    0.7.0.1
 */
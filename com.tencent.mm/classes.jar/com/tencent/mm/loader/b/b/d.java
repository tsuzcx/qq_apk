package com.tencent.mm.loader.b.b;

import android.graphics.Bitmap;
import com.tencent.mm.memory.a.b;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/loader/cache/memory/DefaultMemoryCacheMap;", "", "()V", "MAX_BIG_BITMAP_SIZE", "", "getMAX_BIG_BITMAP_SIZE", "()I", "MAX_DEFAULT_BITMAP_SIZE", "getMAX_DEFAULT_BITMAP_SIZE", "OVERSIZE_BITMAP_SIZE", "getOVERSIZE_BITMAP_SIZE", "bigImageMemoryCache", "Lcom/tencent/mm/memory/cache/BitmapResource;", "Landroid/graphics/Bitmap;", "getBigImageMemoryCache", "()Lcom/tencent/mm/memory/cache/BitmapResource;", "defaultImageMemoryCache", "getDefaultImageMemoryCache", "libimageloader_release"})
public final class d
{
  private static final b<Bitmap> hdc;
  private static final int hdd = 50;
  private static final int hdf = 524288;
  private static final int hdg = 10;
  private static final b<Bitmap> hdl;
  public static final d hdm;
  
  static
  {
    d locald = new d();
    hdm = locald;
    hdf = 524288;
    hdd = 50;
    hdg = 10;
    hdc = new b(hdd, locald.getClass());
    hdl = new b(hdg, locald.getClass());
  }
  
  public static int aqK()
  {
    return hdf;
  }
  
  public static int aqL()
  {
    return hdd;
  }
  
  public static int aqM()
  {
    return hdg;
  }
  
  public static b<Bitmap> aqN()
  {
    return hdc;
  }
  
  public static b<Bitmap> aqO()
  {
    return hdl;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.loader.b.b.d
 * JD-Core Version:    0.7.0.1
 */
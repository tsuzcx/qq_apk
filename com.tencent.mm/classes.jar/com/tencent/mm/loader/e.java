package com.tencent.mm.loader;

import android.graphics.Bitmap;
import d.g.b.k;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/loader/LoaderFactory;", "", "()V", "defaultImageLoader", "Lcom/tencent/mm/loader/DefaultImageLoader;", "instance", "Lcom/tencent/mm/loader/Loader;", "T", "Lcom/tencent/mm/loader/model/data/ILoaderData;", "configuration", "Lcom/tencent/mm/loader/cfg/ILoaderConfiguration;", "Landroid/graphics/Bitmap;", "instanceDefault", "", "newInstance", "libimageloader_release"})
public final class e
{
  private static a ghS = new a((com.tencent.mm.loader.c.d)new com.tencent.mm.loader.c.c());
  public static final e ghT = new e();
  
  public static <T extends com.tencent.mm.loader.h.a.c> d<T> a(com.tencent.mm.loader.c.d<T, Bitmap> paramd)
  {
    k.h(paramd, "configuration");
    return (d)new c(paramd);
  }
  
  public static a agS()
  {
    return ghS;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.loader.e
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.loader;

import a.f.b.j;
import a.l;
import android.graphics.Bitmap;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/loader/LoaderFactory;", "", "()V", "instance", "Lcom/tencent/mm/loader/DefaultImageLoader;", "Lcom/tencent/mm/loader/Loader;", "T", "Lcom/tencent/mm/loader/model/data/ILoaderData;", "configuration", "Lcom/tencent/mm/loader/cfg/ILoaderConfiguration;", "Landroid/graphics/Bitmap;", "libimageloader_release"})
public final class e
{
  public static final e eME = new e();
  
  public static a SX()
  {
    return new a((com.tencent.mm.loader.c.d)new com.tencent.mm.loader.c.c());
  }
  
  public static <T extends com.tencent.mm.loader.h.a.c> d<T> a(com.tencent.mm.loader.c.d<T, Bitmap> paramd)
  {
    j.q(paramd, "configuration");
    return (d)new c(paramd);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.loader.e
 * JD-Core Version:    0.7.0.1
 */
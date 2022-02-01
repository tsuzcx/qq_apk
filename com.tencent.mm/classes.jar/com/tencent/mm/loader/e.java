package com.tencent.mm.loader;

import android.graphics.Bitmap;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/loader/LoaderFactory;", "", "()V", "defaultImageLoader", "Lcom/tencent/mm/loader/DefaultImageLoader;", "instance", "Lcom/tencent/mm/loader/Loader;", "T", "Lcom/tencent/mm/loader/model/data/ILoaderData;", "configuration", "Lcom/tencent/mm/loader/cfg/ILoaderConfiguration;", "Landroid/graphics/Bitmap;", "instanceDefault", "", "newInstance", "libimageloader_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
{
  public static final e noo = new e();
  private static a nop = new a((com.tencent.mm.loader.b.d)new com.tencent.mm.loader.b.c());
  
  public static <T extends com.tencent.mm.loader.g.a.c> d<T> a(com.tencent.mm.loader.b.d<T, Bitmap> paramd)
  {
    s.u(paramd, "configuration");
    return (d)new c(paramd);
  }
  
  public static a blh()
  {
    return nop;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.loader.e
 * JD-Core Version:    0.7.0.1
 */
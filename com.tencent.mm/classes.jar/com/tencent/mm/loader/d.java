package com.tencent.mm.loader;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.mm.loader.a.b;
import com.tencent.mm.loader.c.e;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/loader/Loader;", "T", "", "configuration", "Lcom/tencent/mm/loader/cfg/ILoaderConfiguration;", "Landroid/graphics/Bitmap;", "(Lcom/tencent/mm/loader/cfg/ILoaderConfiguration;)V", "getConfiguration", "()Lcom/tencent/mm/loader/cfg/ILoaderConfiguration;", "load", "Lcom/tencent/mm/loader/builder/RequestBuilder;", "url", "(Ljava/lang/Object;)Lcom/tencent/mm/loader/builder/RequestBuilder;", "urlThumb", "view", "Landroid/widget/ImageView;", "options", "Lcom/tencent/mm/loader/cfg/ImageLoaderOptions;", "(Ljava/lang/Object;Ljava/lang/Object;Landroid/widget/ImageView;Lcom/tencent/mm/loader/cfg/ImageLoaderOptions;)Lcom/tencent/mm/loader/builder/RequestBuilder;", "", "(Ljava/lang/Object;Landroid/widget/ImageView;Lcom/tencent/mm/loader/cfg/ImageLoaderOptions;)V", "(Ljava/lang/Object;Lcom/tencent/mm/loader/cfg/ImageLoaderOptions;)Lcom/tencent/mm/loader/builder/RequestBuilder;", "loadLocal", "libimageloader_release"})
public abstract class d<T>
{
  final com.tencent.mm.loader.c.d<T, Bitmap> gis;
  
  public d(com.tencent.mm.loader.c.d<T, Bitmap> paramd)
  {
    this.gis = paramd;
  }
  
  public abstract b<T, Bitmap> a(T paramT, e parame);
  
  public abstract void a(T paramT, ImageView paramImageView, e parame);
  
  public abstract b<T, Bitmap> bH(T paramT);
  
  public abstract b<T, Bitmap> bI(T paramT);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.loader.d
 * JD-Core Version:    0.7.0.1
 */
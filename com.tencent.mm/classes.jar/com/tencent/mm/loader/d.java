package com.tencent.mm.loader;

import a.l;
import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.mm.loader.a.b;
import com.tencent.mm.loader.c.e;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/loader/Loader;", "T", "", "configuration", "Lcom/tencent/mm/loader/cfg/ILoaderConfiguration;", "Landroid/graphics/Bitmap;", "(Lcom/tencent/mm/loader/cfg/ILoaderConfiguration;)V", "getConfiguration", "()Lcom/tencent/mm/loader/cfg/ILoaderConfiguration;", "load", "Lcom/tencent/mm/loader/builder/RequestBuilder;", "url", "(Ljava/lang/Object;)Lcom/tencent/mm/loader/builder/RequestBuilder;", "", "view", "Landroid/widget/ImageView;", "options", "Lcom/tencent/mm/loader/cfg/ImageLoaderOptions;", "(Ljava/lang/Object;Landroid/widget/ImageView;Lcom/tencent/mm/loader/cfg/ImageLoaderOptions;)V", "loadLocal", "libimageloader_release"})
public abstract class d<T>
{
  final com.tencent.mm.loader.c.d<T, Bitmap> eMD;
  
  public d(com.tencent.mm.loader.c.d<T, Bitmap> paramd)
  {
    this.eMD = paramd;
  }
  
  public abstract void a(T paramT, ImageView paramImageView, e parame);
  
  public abstract b<T, Bitmap> aE(T paramT);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.loader.d
 * JD-Core Version:    0.7.0.1
 */
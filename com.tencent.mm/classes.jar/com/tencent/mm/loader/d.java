package com.tencent.mm.loader;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.mm.loader.a.b;
import com.tencent.mm.loader.b.e;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/loader/Loader;", "T", "", "configuration", "Lcom/tencent/mm/loader/cfg/ILoaderConfiguration;", "Landroid/graphics/Bitmap;", "(Lcom/tencent/mm/loader/cfg/ILoaderConfiguration;)V", "getConfiguration", "()Lcom/tencent/mm/loader/cfg/ILoaderConfiguration;", "load", "Lcom/tencent/mm/loader/builder/RequestBuilder;", "url", "(Ljava/lang/Object;)Lcom/tencent/mm/loader/builder/RequestBuilder;", "urlThumb", "view", "Landroid/widget/ImageView;", "options", "Lcom/tencent/mm/loader/cfg/ImageLoaderOptions;", "(Ljava/lang/Object;Ljava/lang/Object;Landroid/widget/ImageView;Lcom/tencent/mm/loader/cfg/ImageLoaderOptions;)Lcom/tencent/mm/loader/builder/RequestBuilder;", "", "(Ljava/lang/Object;Landroid/widget/ImageView;Lcom/tencent/mm/loader/cfg/ImageLoaderOptions;)V", "(Ljava/lang/Object;Lcom/tencent/mm/loader/cfg/ImageLoaderOptions;)Lcom/tencent/mm/loader/builder/RequestBuilder;", "loadLocal", "libimageloader_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class d<T>
{
  public final com.tencent.mm.loader.b.d<T, Bitmap> mgj;
  
  public d(com.tencent.mm.loader.b.d<T, Bitmap> paramd)
  {
    this.mgj = paramd;
  }
  
  public abstract b<T, Bitmap> a(T paramT, e parame);
  
  public abstract void a(T paramT, ImageView paramImageView, e parame);
  
  public abstract b<T, Bitmap> dj(T paramT);
  
  public abstract b<T, Bitmap> dk(T paramT);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.loader.d
 * JD-Core Version:    0.7.0.1
 */
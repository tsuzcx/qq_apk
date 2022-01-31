package com.tencent.mm.loader.a;

import a.f.b.j;
import a.l;
import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.mm.loader.e.b.c;
import com.tencent.mm.loader.e.b.g;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/loader/builder/BitmapRequestBuilder;", "T", "Lcom/tencent/mm/loader/builder/RequestBuilder;", "Landroid/graphics/Bitmap;", "reqValue", "Lcom/tencent/mm/loader/model/data/DataItem;", "mImageLoaderConfiguration", "Lcom/tencent/mm/loader/cfg/ILoaderConfiguration;", "(Lcom/tencent/mm/loader/model/data/DataItem;Lcom/tencent/mm/loader/cfg/ILoaderConfiguration;)V", "into", "", "imageView", "Landroid/widget/ImageView;", "needDefault", "", "withStruct", "Lcom/tencent/mm/loader/IRequestBuilder;", "V", "(Ljava/lang/Object;)Lcom/tencent/mm/loader/IRequestBuilder;", "libimageloader_release"})
public final class a<T>
  extends b<T, Bitmap>
{
  public a(com.tencent.mm.loader.h.a.a<T> parama, com.tencent.mm.loader.c.d<T, Bitmap> paramd)
  {
    super(parama, paramd);
  }
  
  public final void d(ImageView paramImageView)
  {
    j.q(paramImageView, "imageView");
    this.eNa = ((com.tencent.mm.loader.e.b.d)new c(new g(paramImageView)));
    ph();
  }
  
  public final void e(ImageView paramImageView)
  {
    j.q(paramImageView, "imageView");
    this.eNa = ((com.tencent.mm.loader.e.b.d)new c(new g(paramImageView), (byte)0));
    ph();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.loader.a.a
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.loader.a;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.mm.loader.e.b.c;
import com.tencent.mm.loader.e.b.g;
import d.g.b.k;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/loader/builder/BitmapRequestBuilder;", "T", "Lcom/tencent/mm/loader/builder/RequestBuilder;", "Landroid/graphics/Bitmap;", "reqValue", "Lcom/tencent/mm/loader/model/data/DataItem;", "mImageLoaderConfiguration", "Lcom/tencent/mm/loader/cfg/ILoaderConfiguration;", "(Lcom/tencent/mm/loader/model/data/DataItem;Lcom/tencent/mm/loader/cfg/ILoaderConfiguration;)V", "into", "", "imageView", "Landroid/widget/ImageView;", "needDefault", "", "withStruct", "Lcom/tencent/mm/loader/IRequestBuilder;", "V", "(Ljava/lang/Object;)Lcom/tencent/mm/loader/IRequestBuilder;", "libimageloader_release"})
public final class a<T>
  extends b<T, Bitmap>
{
  public a(com.tencent.mm.loader.h.a.a<T> parama, com.tencent.mm.loader.c.d<T, Bitmap> paramd)
  {
    super(parama, paramd);
  }
  
  public final void a(ImageView paramImageView, boolean paramBoolean)
  {
    k.h(paramImageView, "imageView");
    if (this.gir == null) {
      this.gir = ((com.tencent.mm.loader.e.b.d)new c(new g(paramImageView), paramBoolean));
    }
    tP();
  }
  
  public final void agR()
  {
    if (this.gir == null) {
      this.gir = ((com.tencent.mm.loader.e.b.d)new com.tencent.mm.loader.e.b.a());
    }
    tP();
  }
  
  public final void c(ImageView paramImageView)
  {
    k.h(paramImageView, "imageView");
    if (this.gir == null) {
      this.gir = ((com.tencent.mm.loader.e.b.d)new c(new g(paramImageView)));
    }
    tP();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.loader.a.a
 * JD-Core Version:    0.7.0.1
 */
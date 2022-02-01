package com.tencent.mm.loader.a;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.mm.loader.e.b.c;
import com.tencent.mm.loader.e.b.g;
import d.g.a.m;
import d.g.b.k;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/loader/builder/BitmapRequestBuilder;", "T", "Lcom/tencent/mm/loader/builder/RequestBuilder;", "Landroid/graphics/Bitmap;", "reqValue", "Lcom/tencent/mm/loader/model/data/DataItem;", "mImageLoaderConfiguration", "Lcom/tencent/mm/loader/cfg/ILoaderConfiguration;", "(Lcom/tencent/mm/loader/model/data/DataItem;Lcom/tencent/mm/loader/cfg/ILoaderConfiguration;)V", "into", "", "imageView", "Landroid/widget/ImageView;", "onTaskEnd", "Lkotlin/Function2;", "Lcom/tencent/mm/loader/impr/target/ViewWeakHolder;", "needDefault", "", "withStruct", "Lcom/tencent/mm/loader/IRequestBuilder;", "V", "(Ljava/lang/Object;)Lcom/tencent/mm/loader/IRequestBuilder;", "libimageloader_release"})
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
    if (this.gJa == null) {
      this.gJa = ((com.tencent.mm.loader.e.b.d)new c(new g(paramImageView), paramBoolean));
    }
    tX();
  }
  
  public final void anW()
  {
    if (this.gJa == null) {
      this.gJa = ((com.tencent.mm.loader.e.b.d)new com.tencent.mm.loader.e.b.a());
    }
    tX();
  }
  
  public final void c(ImageView paramImageView)
  {
    k.h(paramImageView, "imageView");
    if (this.gJa == null) {
      this.gJa = ((com.tencent.mm.loader.e.b.d)new c(new g(paramImageView)));
    }
    tX();
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/loader/builder/BitmapRequestBuilder$into$1", "Lcom/tencent/mm/loader/impr/target/ImageViewShowTarget;", "onResourceReadyUI", "", "resource", "Landroid/graphics/Bitmap;", "viewWeakHolder", "Lcom/tencent/mm/loader/impr/target/ViewWeakHolder;", "libimageloader_release"})
  public static final class a
    extends c
  {
    public a(m paramm, ImageView paramImageView, g paramg)
    {
      super();
    }
    
    public final boolean a(Bitmap paramBitmap, g<?> paramg)
    {
      k.h(paramg, "viewWeakHolder");
      boolean bool = super.a(paramBitmap, paramg);
      m localm = this.gJh;
      if (localm != null) {
        localm.n(paramg, paramBitmap);
      }
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.loader.a.a
 * JD-Core Version:    0.7.0.1
 */
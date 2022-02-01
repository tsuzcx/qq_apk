package com.tencent.mm.loader.a;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.mm.loader.d.b.c;
import com.tencent.mm.loader.d.b.g;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.m;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/loader/builder/BitmapRequestBuilder;", "T", "Lcom/tencent/mm/loader/builder/RequestBuilder;", "Landroid/graphics/Bitmap;", "reqValue", "Lcom/tencent/mm/loader/model/data/DataItem;", "mImageLoaderConfiguration", "Lcom/tencent/mm/loader/cfg/ILoaderConfiguration;", "(Lcom/tencent/mm/loader/model/data/DataItem;Lcom/tencent/mm/loader/cfg/ILoaderConfiguration;)V", "into", "", "imageView", "Landroid/widget/ImageView;", "onTaskEnd", "Lkotlin/Function2;", "Lcom/tencent/mm/loader/impr/target/ViewWeakHolder;", "needDefault", "", "withStruct", "Lcom/tencent/mm/loader/IRequestBuilder;", "V", "(Ljava/lang/Object;)Lcom/tencent/mm/loader/IRequestBuilder;", "libimageloader_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a<T>
  extends b<T, Bitmap>
{
  public a(com.tencent.mm.loader.g.a.a<T> parama, com.tencent.mm.loader.b.d<T, Bitmap> paramd)
  {
    super(parama, paramd);
  }
  
  public final void a(ImageView paramImageView, m<? super g<?>, ? super Bitmap, ah> paramm)
  {
    s.u(paramImageView, "imageView");
    if (this.noQ == null) {
      this.noQ = ((com.tencent.mm.loader.d.b.d)new a(paramm, new g(paramImageView)));
    }
    Td();
  }
  
  public final void a(ImageView paramImageView, boolean paramBoolean)
  {
    s.u(paramImageView, "imageView");
    if (this.noQ == null) {
      this.noQ = ((com.tencent.mm.loader.d.b.d)new c(new g(paramImageView, this.noW), paramBoolean));
    }
    Td();
  }
  
  public final void blg()
  {
    if (this.noQ == null) {
      this.noQ = ((com.tencent.mm.loader.d.b.d)new com.tencent.mm.loader.d.b.a());
    }
    Td();
  }
  
  public final void d(ImageView paramImageView)
  {
    s.u(paramImageView, "imageView");
    if (this.noQ == null) {
      this.noQ = ((com.tencent.mm.loader.d.b.d)new c(new g(paramImageView, this.noW)));
    }
    Td();
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/loader/builder/BitmapRequestBuilder$into$1", "Lcom/tencent/mm/loader/impr/target/ImageViewShowTarget;", "onResourceReadyUI", "", "resource", "Landroid/graphics/Bitmap;", "viewWeakHolder", "Lcom/tencent/mm/loader/impr/target/ViewWeakHolder;", "libimageloader_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    extends c
  {
    a(m<? super g<?>, ? super Bitmap, ah> paramm, g<ImageView> paramg)
    {
      super();
    }
    
    public final boolean a(Bitmap paramBitmap, g<?> paramg)
    {
      s.u(paramg, "viewWeakHolder");
      boolean bool = super.a(paramBitmap, paramg);
      m localm = this.noU;
      if (localm != null) {
        localm.invoke(paramg, paramBitmap);
      }
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.loader.a.a
 * JD-Core Version:    0.7.0.1
 */
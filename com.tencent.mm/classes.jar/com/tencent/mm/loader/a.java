package com.tencent.mm.loader;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.mm.loader.b.e;
import com.tencent.mm.loader.d.b.g;
import com.tencent.mm.loader.d.c.c;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.m;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/loader/DefaultImageLoader;", "Lcom/tencent/mm/loader/Loader;", "", "configuration", "Lcom/tencent/mm/loader/cfg/ILoaderConfiguration;", "Landroid/graphics/Bitmap;", "(Lcom/tencent/mm/loader/cfg/ILoaderConfiguration;)V", "load", "Lcom/tencent/mm/loader/builder/RequestBuilder;", "url", "", "view", "Landroid/widget/ImageView;", "options", "Lcom/tencent/mm/loader/cfg/ImageLoaderOptions;", "Lcom/tencent/mm/loader/builder/BitmapRequestBuilder;", "urlThumb", "loadAssert", "assertPath", "loadBitmap", "onTaskEnd", "Lkotlin/Function2;", "Lcom/tencent/mm/loader/impr/target/ViewWeakHolder;", "loadDrawable", "context", "Landroid/content/Context;", "drawable", "resId", "", "loadLocal", "loadLocalFile", "filePath", "libimageloader_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends d<String>
{
  public a(com.tencent.mm.loader.b.d<String, Bitmap> paramd)
  {
    super(paramd);
  }
  
  public final com.tencent.mm.loader.a.b<String, Bitmap> GC(String paramString)
  {
    s.u(paramString, "url");
    return (com.tencent.mm.loader.a.b)new com.tencent.mm.loader.a.a(new com.tencent.mm.loader.g.a.a(paramString), this.mgj);
  }
  
  public final com.tencent.mm.loader.a.b<String, Bitmap> GD(String paramString)
  {
    s.u(paramString, "assertPath");
    paramString = com.tencent.mm.loader.g.a.a.a(paramString, com.tencent.mm.loader.g.a.b.nsr);
    s.s(paramString, "create(assertPath, DataType.ASSET_DATA)");
    return (com.tencent.mm.loader.a.b)new com.tencent.mm.loader.a.a(paramString, this.mgj);
  }
  
  public final com.tencent.mm.loader.a.b<String, Bitmap> GE(String paramString)
  {
    s.u(paramString, "filePath");
    paramString = com.tencent.mm.loader.g.a.a.a(paramString, com.tencent.mm.loader.g.a.b.nss);
    s.s(paramString, "create(filePath, DataType.LOCAL_PATH)");
    return (com.tencent.mm.loader.a.b)new com.tencent.mm.loader.a.a(paramString, this.mgj);
  }
  
  public final void a(String paramString, ImageView paramImageView, e parame)
  {
    s.u(paramString, "url");
    s.u(paramImageView, "view");
    s.u(parame, "options");
    paramString = new com.tencent.mm.loader.a.a(new com.tencent.mm.loader.g.a.a(paramString), this.mgj);
    if (parame.npZ) {
      paramString.a((com.tencent.mm.loader.d.c.b)new com.tencent.mm.loader.d.c.a(new c(0.5F).blN()));
    }
    paramString.a(parame).d(paramImageView);
  }
  
  public final void a(String paramString, ImageView paramImageView, e parame, m<? super g<?>, ? super Bitmap, ah> paramm)
  {
    s.u(paramString, "url");
    s.u(paramImageView, "view");
    s.u(parame, "options");
    paramString = new com.tencent.mm.loader.a.a(new com.tencent.mm.loader.g.a.a(paramString), this.mgj);
    if (parame.npZ) {
      paramString.a((com.tencent.mm.loader.d.c.b)new com.tencent.mm.loader.d.c.a(new c(0.5F).blN()));
    }
    paramString.a(parame);
    paramString.a(paramImageView, paramm);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.loader.a
 * JD-Core Version:    0.7.0.1
 */
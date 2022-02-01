package com.tencent.mm.loader;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.mm.loader.c.e;
import com.tencent.mm.loader.e.b.g;
import com.tencent.mm.loader.e.c.c;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/loader/DefaultImageLoader;", "Lcom/tencent/mm/loader/Loader;", "", "configuration", "Lcom/tencent/mm/loader/cfg/ILoaderConfiguration;", "Landroid/graphics/Bitmap;", "(Lcom/tencent/mm/loader/cfg/ILoaderConfiguration;)V", "load", "Lcom/tencent/mm/loader/builder/RequestBuilder;", "url", "", "view", "Landroid/widget/ImageView;", "options", "Lcom/tencent/mm/loader/cfg/ImageLoaderOptions;", "Lcom/tencent/mm/loader/builder/BitmapRequestBuilder;", "urlThumb", "loadAssert", "assertPath", "loadBitmap", "onTaskEnd", "Lkotlin/Function2;", "Lcom/tencent/mm/loader/impr/target/ViewWeakHolder;", "loadDrawable", "context", "Landroid/content/Context;", "drawable", "resId", "", "loadLocal", "loadLocalFile", "filePath", "libimageloader_release"})
public final class a
  extends d<String>
{
  public a(com.tencent.mm.loader.c.d<String, Bitmap> paramd)
  {
    super(paramd);
  }
  
  public final com.tencent.mm.loader.a.b<String, Bitmap> He(String paramString)
  {
    p.h(paramString, "assertPath");
    paramString = com.tencent.mm.loader.h.a.a.a(paramString, com.tencent.mm.loader.h.a.b.ich);
    p.g(paramString, "DataItem.create(assertPath, DataType.ASSET_DATA)");
    return (com.tencent.mm.loader.a.b)new com.tencent.mm.loader.a.a(paramString, this.gVF);
  }
  
  public final com.tencent.mm.loader.a.b<String, Bitmap> Hf(String paramString)
  {
    p.h(paramString, "filePath");
    paramString = com.tencent.mm.loader.h.a.a.a(paramString, com.tencent.mm.loader.h.a.b.ici);
    p.g(paramString, "DataItem.create(filePath, DataType.LOCAL_PATH)");
    return (com.tencent.mm.loader.a.b)new com.tencent.mm.loader.a.a(paramString, this.gVF);
  }
  
  public final void a(String paramString, ImageView paramImageView, e parame)
  {
    p.h(paramString, "url");
    p.h(paramImageView, "view");
    p.h(parame, "options");
    paramString = new com.tencent.mm.loader.a.a(new com.tencent.mm.loader.h.a.a(paramString), this.gVF);
    if (parame.hZE) {
      paramString.a((com.tencent.mm.loader.e.c.b)new com.tencent.mm.loader.e.c.a(new c(0.5F).aJY()));
    }
    paramString.a(parame).c(paramImageView);
  }
  
  public final void a(String paramString, ImageView paramImageView, e parame, m<? super g<?>, ? super Bitmap, x> paramm)
  {
    p.h(paramString, "url");
    p.h(paramImageView, "view");
    p.h(parame, "options");
    paramString = new com.tencent.mm.loader.a.a(new com.tencent.mm.loader.h.a.a(paramString), this.gVF);
    if (parame.hZE) {
      paramString.a((com.tencent.mm.loader.e.c.b)new com.tencent.mm.loader.e.c.a(new c(0.5F).aJY()));
    }
    paramString.a(parame);
    paramString.a(paramImageView, paramm);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.loader.a
 * JD-Core Version:    0.7.0.1
 */
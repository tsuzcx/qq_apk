package com.tencent.mm.loader;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.mm.loader.c.e;
import com.tencent.mm.loader.e.c.c;
import d.g.b.k;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/loader/DefaultImageLoader;", "Lcom/tencent/mm/loader/Loader;", "", "configuration", "Lcom/tencent/mm/loader/cfg/ILoaderConfiguration;", "Landroid/graphics/Bitmap;", "(Lcom/tencent/mm/loader/cfg/ILoaderConfiguration;)V", "load", "Lcom/tencent/mm/loader/builder/RequestBuilder;", "url", "", "view", "Landroid/widget/ImageView;", "options", "Lcom/tencent/mm/loader/cfg/ImageLoaderOptions;", "Lcom/tencent/mm/loader/builder/BitmapRequestBuilder;", "urlThumb", "loadAssert", "assertPath", "loadDrawable", "context", "Landroid/content/Context;", "drawable", "resId", "", "loadLocal", "loadLocalFile", "filePath", "libimageloader_release"})
public final class a
  extends d<String>
{
  public a(com.tencent.mm.loader.c.d<String, Bitmap> paramd)
  {
    super(paramd);
  }
  
  public final void a(String paramString, ImageView paramImageView, e parame)
  {
    k.h(paramString, "url");
    k.h(paramImageView, "view");
    k.h(parame, "options");
    paramString = new com.tencent.mm.loader.a.a(new com.tencent.mm.loader.h.a.a(paramString), this.fLg);
    com.tencent.mm.loader.e.c.b localb;
    if (parame.gjz)
    {
      localb = (com.tencent.mm.loader.e.c.b)new com.tencent.mm.loader.e.c.a(new c(0.5F).ahw());
      k.h(localb, "_transcoder");
      if (paramString.gih != null) {
        break label108;
      }
      paramString.gih = new com.tencent.mm.loader.e.c.a(localb);
    }
    for (;;)
    {
      paramString.a(parame).c(paramImageView);
      return;
      label108:
      com.tencent.mm.loader.e.c.a locala = paramString.gih;
      if (locala != null) {
        locala.c(localb);
      }
    }
  }
  
  public final com.tencent.mm.loader.a.b<String, Bitmap> rd(String paramString)
  {
    k.h(paramString, "filePath");
    paramString = com.tencent.mm.loader.h.a.a.a(paramString, com.tencent.mm.loader.h.a.b.glN);
    k.g(paramString, "DataItem.create(filePath, DataType.LOCAL_PATH)");
    return (com.tencent.mm.loader.a.b)new com.tencent.mm.loader.a.a(paramString, this.fLg);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.loader.a
 * JD-Core Version:    0.7.0.1
 */
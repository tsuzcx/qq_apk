package com.tencent.mm.loader;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.mm.loader.c.e;
import com.tencent.mm.loader.e.c.c;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/loader/DefaultImageLoader;", "Lcom/tencent/mm/loader/Loader;", "", "configuration", "Lcom/tencent/mm/loader/cfg/ILoaderConfiguration;", "Landroid/graphics/Bitmap;", "(Lcom/tencent/mm/loader/cfg/ILoaderConfiguration;)V", "load", "Lcom/tencent/mm/loader/builder/RequestBuilder;", "url", "", "view", "Landroid/widget/ImageView;", "options", "Lcom/tencent/mm/loader/cfg/ImageLoaderOptions;", "Lcom/tencent/mm/loader/builder/BitmapRequestBuilder;", "urlThumb", "loadAssert", "assertPath", "loadDrawable", "context", "Landroid/content/Context;", "drawable", "resId", "", "loadLocal", "loadLocalFile", "filePath", "libimageloader_release"})
public final class a
  extends d<String>
{
  public a(com.tencent.mm.loader.c.d<String, Bitmap> paramd)
  {
    super(paramd);
  }
  
  public final void a(String paramString, ImageView paramImageView, e parame)
  {
    p.h(paramString, "url");
    p.h(paramImageView, "view");
    p.h(parame, "options");
    paramString = new com.tencent.mm.loader.a.a(new com.tencent.mm.loader.h.a.a(paramString), this.gis);
    if (parame.hdW) {
      paramString.a((com.tencent.mm.loader.e.c.b)new com.tencent.mm.loader.e.c.a(new c(0.5F).ark()));
    }
    paramString.a(parame).c(paramImageView);
  }
  
  public final com.tencent.mm.loader.a.b<String, Bitmap> xV(String paramString)
  {
    p.h(paramString, "assertPath");
    paramString = com.tencent.mm.loader.h.a.a.a(paramString, com.tencent.mm.loader.h.a.b.hgw);
    p.g(paramString, "DataItem.create(assertPath, DataType.ASSET_DATA)");
    return (com.tencent.mm.loader.a.b)new com.tencent.mm.loader.a.a(paramString, this.gis);
  }
  
  public final com.tencent.mm.loader.a.b<String, Bitmap> xW(String paramString)
  {
    p.h(paramString, "filePath");
    paramString = com.tencent.mm.loader.h.a.a.a(paramString, com.tencent.mm.loader.h.a.b.hgx);
    p.g(paramString, "DataItem.create(filePath, DataType.LOCAL_PATH)");
    return (com.tencent.mm.loader.a.b)new com.tencent.mm.loader.a.a(paramString, this.gis);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.loader.a
 * JD-Core Version:    0.7.0.1
 */
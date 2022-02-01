package com.tencent.mm.loader.b.b;

import android.graphics.Bitmap;
import com.tencent.mm.memory.a.b;
import d.g.b.k;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/loader/cache/memory/DefaultBitmapMemoryCache;", "T", "Lcom/tencent/mm/loader/cache/memory/IMemoryCache;", "Landroid/graphics/Bitmap;", "()V", "defaultImageMemoryCache", "Lcom/tencent/mm/memory/cache/BitmapResource;", "clear", "", "get", "Lcom/tencent/mm/loader/model/Resource;", "url", "Lcom/tencent/mm/loader/model/data/DataItem;", "head", "Lcom/tencent/mm/loader/impr/transcoder/HeadResourceTranscoder;", "put", "value", "remove", "Companion", "libimageloader_release"})
public final class a<T>
  extends e<T, Bitmap>
{
  private static final String TAG = "MicroMsg.Loader.DefaultImageMemoryCacheListener";
  private static final int gJs = 50;
  public static final a.a gJt = new a.a((byte)0);
  private final b<Bitmap> gJr = new b(gJs, getClass());
  
  public final com.tencent.mm.loader.h.e<Bitmap> a(com.tencent.mm.loader.h.a.a<T> parama, com.tencent.mm.loader.e.c.a<Bitmap> parama1)
  {
    k.h(parama, "url");
    parama = b(parama, parama1);
    parama = (Bitmap)this.gJr.get(parama);
    if (parama != null) {
      return new com.tencent.mm.loader.h.e(parama);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.loader.b.b.a
 * JD-Core Version:    0.7.0.1
 */
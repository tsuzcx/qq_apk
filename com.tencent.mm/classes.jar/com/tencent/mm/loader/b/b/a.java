package com.tencent.mm.loader.b.b;

import a.f.b.j;
import a.l;
import android.graphics.Bitmap;
import com.tencent.mm.loader.h.e;
import com.tencent.mm.memory.a.b;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/loader/cache/memory/DefaultBitmapMemoryCache;", "T", "Lcom/tencent/mm/loader/cache/memory/IMemoryCache;", "Landroid/graphics/Bitmap;", "()V", "defaultImageMemoryCache", "Lcom/tencent/mm/memory/cache/BitmapResource;", "clear", "", "get", "Lcom/tencent/mm/loader/model/Resource;", "url", "Lcom/tencent/mm/loader/model/data/DataItem;", "head", "Lcom/tencent/mm/loader/impr/transcoder/HeadResourceTranscoder;", "put", "value", "remove", "Companion", "libimageloader_release"})
public final class a<T>
  extends d<T, Bitmap>
{
  private static final String TAG = "MicroMsg.Loader.DefaultImageMemoryCacheListener";
  private static final int eNq = 50;
  public static final a.a eNr = new a.a((byte)0);
  private final b<Bitmap> eNp = new b(eNq, getClass());
  
  public final e<Bitmap> a(com.tencent.mm.loader.h.a.a<T> parama, com.tencent.mm.loader.e.c.a<Bitmap> parama1)
  {
    j.q(parama, "url");
    parama = b(parama, parama1);
    parama = (Bitmap)this.eNp.get(parama);
    if (parama != null) {
      return new e(parama);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.loader.b.b.a
 * JD-Core Version:    0.7.0.1
 */
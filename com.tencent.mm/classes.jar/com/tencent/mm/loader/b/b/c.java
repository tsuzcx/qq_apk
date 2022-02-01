package com.tencent.mm.loader.b.b;

import com.tencent.mm.loader.h.d;
import d.g.b.k;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/loader/cache/memory/DefaultMemoryCache;", "T", "R", "Lcom/tencent/mm/loader/cache/memory/IMemoryCache;", "()V", "defaultImageMemoryCache", "Lcom/tencent/mm/loader/model/MMLRUMap;", "", "clear", "", "get", "Lcom/tencent/mm/loader/model/Resource;", "url", "Lcom/tencent/mm/loader/model/data/DataItem;", "head", "Lcom/tencent/mm/loader/impr/transcoder/HeadResourceTranscoder;", "put", "value", "(Lcom/tencent/mm/loader/model/data/DataItem;Lcom/tencent/mm/loader/impr/transcoder/HeadResourceTranscoder;Ljava/lang/Object;)V", "remove", "Companion", "libimageloader_release"})
public final class c<T, R>
  extends e<T, R>
{
  private static final String TAG = "MicroMsg.Loader.DefaultImageMemoryCacheListener";
  private static final int gJs = 50;
  public static final c.a gJz = new c.a((byte)0);
  private final d<String, R> gJy = new d(gJs);
  
  public final com.tencent.mm.loader.h.e<R> a(com.tencent.mm.loader.h.a.a<T> parama, com.tencent.mm.loader.e.c.a<R> parama1)
  {
    k.h(parama, "url");
    parama = b(parama, parama1);
    parama = this.gJy.get(parama);
    if (parama != null) {
      return new com.tencent.mm.loader.h.e(parama);
    }
    return null;
  }
  
  public final void a(com.tencent.mm.loader.h.a.a<T> parama, com.tencent.mm.loader.e.c.a<R> parama1, R paramR)
  {
    k.h(parama, "url");
    parama = b(parama, parama1);
    this.gJy.put(parama, paramR);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.loader.b.b.c
 * JD-Core Version:    0.7.0.1
 */
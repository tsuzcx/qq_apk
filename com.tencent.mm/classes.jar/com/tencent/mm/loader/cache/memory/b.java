package com.tencent.mm.loader.cache.memory;

import com.tencent.mm.b.f;
import com.tencent.mm.loader.g.e;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/loader/cache/memory/DefaultMemoryCache;", "T", "R", "Lcom/tencent/mm/loader/cache/memory/IMemoryCache;", "()V", "defaultImageMemoryCache", "Lcom/tencent/mm/loader/model/MMLRUMap;", "", "clear", "", "get", "Lcom/tencent/mm/loader/model/Resource;", "url", "Lcom/tencent/mm/loader/model/data/DataItem;", "head", "Lcom/tencent/mm/loader/impr/transcoder/HeadResourceTranscoder;", "put", "value", "(Lcom/tencent/mm/loader/model/data/DataItem;Lcom/tencent/mm/loader/impr/transcoder/HeadResourceTranscoder;Ljava/lang/Object;)V", "remove", "Companion", "libimageloader_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b<T, R>
  extends d<T, R>
{
  private static final String TAG = "MicroMsg.Loader.DefaultImageMemoryCacheListener";
  private static final int npg = 50;
  public static final b.a npm = new b.a((byte)0);
  private final com.tencent.mm.loader.g.d<String, R> npn = new com.tencent.mm.loader.g.d(npg);
  
  public final e<R> a(com.tencent.mm.loader.g.a.a<T> parama, com.tencent.mm.loader.d.c.a<R> parama1)
  {
    s.u(parama, "url");
    parama = b(parama, parama1);
    parama = this.npn.get(parama);
    if (parama != null) {
      return new e(parama);
    }
    return null;
  }
  
  public final void a(com.tencent.mm.loader.g.a.a<T> parama, com.tencent.mm.loader.d.c.a<R> parama1, R paramR)
  {
    s.u(parama, "url");
    parama = b(parama, parama1);
    this.npn.put(parama, paramR);
  }
  
  public final void c(com.tencent.mm.loader.g.a.a<T> parama)
  {
    s.u(parama, "url");
    com.tencent.mm.loader.g.d locald = this.npn;
    parama = b(parama, null);
    if (locald.nsn == null) {
      throw new NullPointerException("mData == null");
    }
    locald.nsn.remove(parama);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.loader.cache.memory.b
 * JD-Core Version:    0.7.0.1
 */
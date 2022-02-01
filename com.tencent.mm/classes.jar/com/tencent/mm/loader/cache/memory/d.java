package com.tencent.mm.loader.cache.memory;

import com.tencent.mm.loader.g.e;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/loader/cache/memory/IMemoryCache;", "T", "R", "", "()V", "clear", "", "get", "Lcom/tencent/mm/loader/model/Resource;", "url", "Lcom/tencent/mm/loader/model/data/DataItem;", "head", "Lcom/tencent/mm/loader/impr/transcoder/HeadResourceTranscoder;", "getImageKey", "", "uriValue", "put", "key", "value", "(Lcom/tencent/mm/loader/model/data/DataItem;Lcom/tencent/mm/loader/impr/transcoder/HeadResourceTranscoder;Ljava/lang/Object;)V", "remove", "libimageloader_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class d<T, R>
{
  public static String b(com.tencent.mm.loader.g.a.a<T> parama, com.tencent.mm.loader.d.c.a<R> parama1)
  {
    Object localObject3 = null;
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (parama != null)
    {
      if (!parama.isLegal()) {
        localObject1 = localObject2;
      }
    }
    else {
      return localObject1;
    }
    if (parama1 == null) {}
    for (parama1 = localObject3;; parama1 = parama1.GH((String)localObject1))
    {
      localObject1 = parama1;
      if (parama1 != null) {
        break;
      }
      parama = parama.toString();
      s.s(parama, "uriValue.toString()");
      return parama;
      localObject1 = parama.toString();
      s.s(localObject1, "uriValue.toString()");
    }
  }
  
  public abstract e<R> a(com.tencent.mm.loader.g.a.a<T> parama, com.tencent.mm.loader.d.c.a<R> parama1);
  
  public abstract void a(com.tencent.mm.loader.g.a.a<T> parama, com.tencent.mm.loader.d.c.a<R> parama1, R paramR);
  
  public abstract void c(com.tencent.mm.loader.g.a.a<T> parama);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.loader.cache.memory.d
 * JD-Core Version:    0.7.0.1
 */
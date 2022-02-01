package com.tencent.mm.loader.b.b;

import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/loader/cache/memory/IMemoryCache;", "T", "R", "", "()V", "clear", "", "get", "Lcom/tencent/mm/loader/model/Resource;", "url", "Lcom/tencent/mm/loader/model/data/DataItem;", "head", "Lcom/tencent/mm/loader/impr/transcoder/HeadResourceTranscoder;", "getImageKey", "", "uriValue", "put", "key", "value", "(Lcom/tencent/mm/loader/model/data/DataItem;Lcom/tencent/mm/loader/impr/transcoder/HeadResourceTranscoder;Ljava/lang/Object;)V", "remove", "libimageloader_release"})
public abstract class e<T, R>
{
  public static String b(com.tencent.mm.loader.h.a.a<T> parama, com.tencent.mm.loader.e.c.a<R> parama1)
  {
    if ((parama == null) || (!parama.isLegal())) {
      parama1 = null;
    }
    String str;
    do
    {
      return parama1;
      if (parama1 == null) {
        break;
      }
      str = parama.toString();
      p.j(str, "uriValue.toString()");
      str = parama1.Ot(str);
      parama1 = str;
    } while (str != null);
    parama = parama.toString();
    p.j(parama, "uriValue.toString()");
    return parama;
  }
  
  public abstract com.tencent.mm.loader.h.e<R> a(com.tencent.mm.loader.h.a.a<T> parama, com.tencent.mm.loader.e.c.a<R> parama1);
  
  public abstract void a(com.tencent.mm.loader.h.a.a<T> parama);
  
  public abstract void a(com.tencent.mm.loader.h.a.a<T> parama, com.tencent.mm.loader.e.c.a<R> parama1, R paramR);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.loader.b.b.e
 * JD-Core Version:    0.7.0.1
 */
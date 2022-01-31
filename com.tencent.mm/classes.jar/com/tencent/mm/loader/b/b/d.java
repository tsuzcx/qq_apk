package com.tencent.mm.loader.b.b;

import a.f.b.j;
import a.l;
import com.tencent.mm.loader.h.e;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/loader/cache/memory/IMemoryCache;", "T", "R", "", "()V", "clear", "", "get", "Lcom/tencent/mm/loader/model/Resource;", "url", "Lcom/tencent/mm/loader/model/data/DataItem;", "head", "Lcom/tencent/mm/loader/impr/transcoder/HeadResourceTranscoder;", "getImageKey", "", "uriValue", "put", "key", "value", "(Lcom/tencent/mm/loader/model/data/DataItem;Lcom/tencent/mm/loader/impr/transcoder/HeadResourceTranscoder;Ljava/lang/Object;)V", "remove", "libimageloader_release"})
public abstract class d<T, R>
{
  public static String b(com.tencent.mm.loader.h.a.a<T> parama, com.tencent.mm.loader.e.c.a<R> parama1)
  {
    if ((parama == null) || (!parama.Ue())) {
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
      j.p(str, "uriValue.toString()");
      str = parama1.mK(str);
      parama1 = str;
    } while (str != null);
    parama = parama.toString();
    j.p(parama, "uriValue.toString()");
    return parama;
  }
  
  public abstract e<R> a(com.tencent.mm.loader.h.a.a<T> parama, com.tencent.mm.loader.e.c.a<R> parama1);
  
  public abstract void a(com.tencent.mm.loader.h.a.a<T> parama, com.tencent.mm.loader.e.c.a<R> parama1, R paramR);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.loader.b.b.d
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.loader.e.c;

import com.tencent.mm.loader.e.b.g;
import com.tencent.mm.loader.f;
import com.tencent.mm.loader.h.e;
import com.tencent.mm.loader.h.e<TT;>;
import d.g.b.k;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/loader/impr/transcoder/HeadResourceTranscoder;", "T", "Lcom/tencent/mm/loader/impr/transcoder/ResourceTranscoder;", "transcoder", "(Lcom/tencent/mm/loader/impr/transcoder/ResourceTranscoder;)V", "asResource", "Lcom/tencent/mm/loader/model/Resource;", "targetView", "Lcom/tencent/mm/loader/impr/target/ViewWeakHolder;", "reaper", "Lcom/tencent/mm/loader/Reaper;", "source", "when", "Lcom/tencent/mm/loader/impr/transcoder/ResourceTranscoder$WHENIF;", "asResourceName", "", "ishasTransCoderWhenDownload", "", "libimageloader_release"})
public final class a<T>
  extends b<T>
{
  public a(b<T> paramb)
  {
    c(paramb);
  }
  
  public final e<? extends T> a(g<?> paramg, f<?, T> paramf, e<T> parame)
  {
    k.h(paramg, "targetView");
    k.h(paramf, "reaper");
    k.h(parame, "source");
    return parame;
  }
  
  public final e<T> a(g<?> paramg, f<?, T> paramf, e<T> parame, b.b paramb)
  {
    k.h(paramg, "targetView");
    k.h(paramf, "reaper");
    k.h(parame, "source");
    k.h(paramb, "when");
    Object localObject1 = ((a)this).gkv;
    Object localObject2 = localObject1;
    if (!(localObject1 instanceof b)) {
      localObject2 = null;
    }
    Object localObject3 = localObject2;
    localObject1 = parame;
    if (localObject2 == null)
    {
      localObject1 = ((a)this).gkv;
      localObject2 = localObject1;
      if (!(localObject1 instanceof b)) {
        localObject2 = null;
      }
      localObject3 = localObject2;
      localObject1 = parame;
      if (localObject2 == null)
      {
        localObject1 = parame;
        parame = ((a)this).gkv;
        localObject2 = parame;
        if (!(parame instanceof b)) {
          localObject2 = null;
        }
        localObject3 = localObject2;
        parame = (e<T>)localObject1;
        if (localObject2 != null) {
          break label361;
        }
        return localObject1;
      }
    }
    else
    {
      label136:
      parame = (e<T>)localObject1;
      if (localObject3.gkw == b.a.gkA)
      {
        parame = (e<T>)localObject1;
        if (paramb == localObject3.gkx) {
          if ((localObject1 instanceof e)) {
            break label499;
          }
        }
      }
    }
    label361:
    label490:
    label499:
    for (parame = null;; parame = (e<T>)localObject1)
    {
      if (parame == null) {
        k.fvU();
      }
      localObject2 = localObject3.a(paramg, paramf, parame);
      parame = (e<T>)localObject2;
      if (!(localObject2 instanceof e)) {
        parame = null;
      }
      if (parame == null) {
        parame = (e<T>)localObject1;
      }
      for (;;)
      {
        localObject1 = localObject3.gkv;
        localObject2 = localObject1;
        if (!(localObject1 instanceof b)) {
          localObject2 = null;
        }
        localObject3 = localObject2;
        localObject1 = parame;
        if (localObject2 != null) {
          break label136;
        }
        break;
        label247:
        parame = (e<T>)localObject1;
        if (localObject3.gkw == b.a.gkz)
        {
          parame = (e<T>)localObject1;
          if (paramb == localObject3.gkx) {
            if ((localObject1 instanceof e)) {
              break label490;
            }
          }
        }
        for (parame = null;; parame = (e<T>)localObject1)
        {
          if (parame == null) {
            k.fvU();
          }
          localObject2 = localObject3.a(paramg, paramf, parame);
          parame = (e<T>)localObject2;
          if (!(localObject2 instanceof e)) {
            parame = null;
          }
          if (parame == null) {
            parame = (e<T>)localObject1;
          }
          for (;;)
          {
            localObject1 = localObject3.gkv;
            localObject2 = localObject1;
            if (!(localObject1 instanceof b)) {
              localObject2 = null;
            }
            localObject3 = localObject2;
            localObject1 = parame;
            if (localObject2 != null) {
              break label247;
            }
            localObject1 = parame;
            break;
            localObject2 = parame;
            if (localObject3.gkw == b.a.gky)
            {
              localObject2 = parame;
              if (paramb == localObject3.gkx) {
                if ((parame instanceof e)) {
                  break label481;
                }
              }
            }
            for (localObject1 = null;; localObject1 = parame)
            {
              if (localObject1 == null) {
                k.fvU();
              }
              localObject2 = localObject3.a(paramg, paramf, (e)localObject1);
              localObject1 = localObject2;
              if (!(localObject2 instanceof e)) {
                localObject1 = null;
              }
              if (localObject1 == null) {}
              for (localObject2 = parame;; localObject2 = localObject1)
              {
                parame = localObject3.gkv;
                localObject1 = parame;
                if (!(parame instanceof b)) {
                  localObject1 = null;
                }
                localObject3 = localObject1;
                parame = (e<T>)localObject2;
                if (localObject1 != null) {
                  break;
                }
                return localObject2;
              }
            }
          }
        }
      }
    }
  }
  
  public final String rg(String paramString)
  {
    k.h(paramString, "source");
    b localb2 = ((a)this).gkv;
    b localb1 = localb2;
    String str = paramString;
    if (localb2 == null)
    {
      localb2 = ((a)this).gkv;
      localb1 = localb2;
      str = paramString;
      if (localb2 != null) {
        break label131;
      }
    }
    for (;;)
    {
      localb2 = ((a)this).gkv;
      localb1 = localb2;
      str = paramString;
      if (localb2 != null) {
        break label197;
      }
      return paramString;
      do
      {
        paramString = str;
        if (localb1.gkw == b.a.gkA)
        {
          paramString = str;
          if (b.b.gkD == localb1.gkx) {
            paramString = str + localb1.rg(str);
          }
        }
        localb2 = localb1.gkv;
        localb1 = localb2;
        str = paramString;
      } while (localb2 != null);
      break;
      label131:
      do
      {
        paramString = str;
        if (localb1.gkw == b.a.gkz)
        {
          paramString = str;
          if (b.b.gkD == localb1.gkx) {
            paramString = str + localb1.rg(str);
          }
        }
        localb2 = localb1.gkv;
        localb1 = localb2;
        str = paramString;
      } while (localb2 != null);
    }
    label197:
    do
    {
      paramString = str;
      if (localb1.gkw == b.a.gky)
      {
        paramString = str;
        if (b.b.gkD == localb1.gkx) {
          paramString = str + localb1.rg(str);
        }
      }
      localb2 = localb1.gkv;
      localb1 = localb2;
      str = paramString;
    } while (localb2 != null);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.loader.e.c.a
 * JD-Core Version:    0.7.0.1
 */
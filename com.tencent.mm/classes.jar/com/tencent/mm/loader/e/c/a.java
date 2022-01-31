package com.tencent.mm.loader.e.c;

import a.f.b.j;
import a.l;
import com.tencent.mm.loader.e.b.g;
import com.tencent.mm.loader.f;
import com.tencent.mm.loader.h.e;
import com.tencent.mm.loader.h.e<TT;>;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/loader/impr/transcoder/HeadResourceTranscoder;", "T", "Lcom/tencent/mm/loader/impr/transcoder/ResourceTranscoder;", "transcoder", "(Lcom/tencent/mm/loader/impr/transcoder/ResourceTranscoder;)V", "asResource", "Lcom/tencent/mm/loader/model/Resource;", "targetView", "Lcom/tencent/mm/loader/impr/target/ViewWeakHolder;", "reaper", "Lcom/tencent/mm/loader/Reaper;", "source", "when", "Lcom/tencent/mm/loader/impr/transcoder/ResourceTranscoder$WHENIF;", "asResourceName", "", "ishasTransCoderWhenDownload", "", "libimageloader_release"})
public final class a<T>
  extends b<T>
{
  public final e<? extends T> a(g<?> paramg, f<?, T> paramf, e<T> parame)
  {
    j.q(paramg, "targetView");
    j.q(paramf, "reaper");
    j.q(parame, "source");
    return parame;
  }
  
  public final e<T> a(g<?> paramg, f<?, T> paramf, e<T> parame, b.b paramb)
  {
    j.q(paramg, "targetView");
    j.q(paramf, "reaper");
    j.q(parame, "source");
    j.q(paramb, "when");
    Object localObject1 = ((a)this).eOS;
    Object localObject2 = localObject1;
    if (!(localObject1 instanceof b)) {
      localObject2 = null;
    }
    Object localObject3 = localObject2;
    localObject1 = parame;
    if (localObject2 == null)
    {
      localObject1 = ((a)this).eOS;
      localObject2 = localObject1;
      if (!(localObject1 instanceof b)) {
        localObject2 = null;
      }
      localObject3 = localObject2;
      localObject1 = parame;
      if (localObject2 == null)
      {
        localObject1 = parame;
        parame = ((a)this).eOS;
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
      if (localObject3.eOT == b.a.eOX)
      {
        parame = (e<T>)localObject1;
        if (paramb == localObject3.eOU) {
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
        j.ebi();
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
        localObject1 = localObject3.eOS;
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
        if (localObject3.eOT == b.a.eOW)
        {
          parame = (e<T>)localObject1;
          if (paramb == localObject3.eOU) {
            if ((localObject1 instanceof e)) {
              break label490;
            }
          }
        }
        for (parame = null;; parame = (e<T>)localObject1)
        {
          if (parame == null) {
            j.ebi();
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
            localObject1 = localObject3.eOS;
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
            if (localObject3.eOT == b.a.eOV)
            {
              localObject2 = parame;
              if (paramb == localObject3.eOU) {
                if ((parame instanceof e)) {
                  break label481;
                }
              }
            }
            for (localObject1 = null;; localObject1 = parame)
            {
              if (localObject1 == null) {
                j.ebi();
              }
              localObject2 = localObject3.a(paramg, paramf, (e)localObject1);
              localObject1 = localObject2;
              if (!(localObject2 instanceof e)) {
                localObject1 = null;
              }
              if (localObject1 == null) {}
              for (localObject2 = parame;; localObject2 = localObject1)
              {
                parame = localObject3.eOS;
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
  
  public final String mK(String paramString)
  {
    j.q(paramString, "source");
    b localb2 = ((a)this).eOS;
    b localb1 = localb2;
    String str = paramString;
    if (localb2 == null)
    {
      localb2 = ((a)this).eOS;
      localb1 = localb2;
      str = paramString;
      if (localb2 != null) {
        break label131;
      }
    }
    for (;;)
    {
      localb2 = ((a)this).eOS;
      localb1 = localb2;
      str = paramString;
      if (localb2 != null) {
        break label197;
      }
      return paramString;
      do
      {
        paramString = str;
        if (localb1.eOT == b.a.eOX)
        {
          paramString = str;
          if (b.b.ePa == localb1.eOU) {
            paramString = str + localb1.mK(str);
          }
        }
        localb2 = localb1.eOS;
        localb1 = localb2;
        str = paramString;
      } while (localb2 != null);
      break;
      label131:
      do
      {
        paramString = str;
        if (localb1.eOT == b.a.eOW)
        {
          paramString = str;
          if (b.b.ePa == localb1.eOU) {
            paramString = str + localb1.mK(str);
          }
        }
        localb2 = localb1.eOS;
        localb1 = localb2;
        str = paramString;
      } while (localb2 != null);
    }
    label197:
    do
    {
      paramString = str;
      if (localb1.eOT == b.a.eOV)
      {
        paramString = str;
        if (b.b.ePa == localb1.eOU) {
          paramString = str + localb1.mK(str);
        }
      }
      localb2 = localb1.eOS;
      localb1 = localb2;
      str = paramString;
    } while (localb2 != null);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.loader.e.c.a
 * JD-Core Version:    0.7.0.1
 */
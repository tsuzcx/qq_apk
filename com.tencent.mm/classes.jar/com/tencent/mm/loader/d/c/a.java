package com.tencent.mm.loader.d.c;

import com.tencent.mm.loader.d.b.g;
import com.tencent.mm.loader.f;
import com.tencent.mm.loader.g.e;
import com.tencent.mm.loader.g.e<TT;>;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/loader/impr/transcoder/HeadResourceTranscoder;", "T", "Lcom/tencent/mm/loader/impr/transcoder/ResourceTranscoder;", "transcoder", "(Lcom/tencent/mm/loader/impr/transcoder/ResourceTranscoder;)V", "asResource", "Lcom/tencent/mm/loader/model/Resource;", "targetView", "Lcom/tencent/mm/loader/impr/target/ViewWeakHolder;", "reaper", "Lcom/tencent/mm/loader/Reaper;", "source", "when", "Lcom/tencent/mm/loader/impr/transcoder/ResourceTranscoder$WHENIF;", "asResourceName", "", "ishasTransCoderWhenDownload", "", "libimageloader_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a<T>
  extends b<T>
{
  public a(b<T> paramb)
  {
    c(paramb);
  }
  
  public final String GH(String paramString)
  {
    s.u(paramString, "source");
    b localb = ((a)this).nqR;
    Object localObject1 = paramString;
    Object localObject2;
    if (localb != null)
    {
      localObject2 = paramString;
      paramString = localb;
      do
      {
        localObject1 = localObject2;
        if (paramString.nqS == b.a.nqW)
        {
          localObject1 = localObject2;
          if (b.b.nqZ == paramString.nqT) {
            localObject1 = s.X((String)localObject2, paramString.GH((String)localObject2));
          }
        }
        localb = paramString.nqR;
        paramString = localb;
        localObject2 = localObject1;
      } while (localb != null);
    }
    localb = ((a)this).nqR;
    paramString = (String)localObject1;
    if (localb != null)
    {
      localObject2 = localObject1;
      localObject1 = localb;
      do
      {
        paramString = (String)localObject2;
        if (((b)localObject1).nqS == b.a.nqV)
        {
          paramString = (String)localObject2;
          if (b.b.nqZ == ((b)localObject1).nqT) {
            paramString = s.X((String)localObject2, ((b)localObject1).GH((String)localObject2));
          }
        }
        localb = ((b)localObject1).nqR;
        localObject1 = localb;
        localObject2 = paramString;
      } while (localb != null);
    }
    localb = ((a)this).nqR;
    localObject1 = paramString;
    if (localb != null)
    {
      localObject2 = paramString;
      localObject1 = localb;
      do
      {
        paramString = (String)localObject2;
        if (((b)localObject1).nqS == b.a.nqU)
        {
          paramString = (String)localObject2;
          if (b.b.nqZ == ((b)localObject1).nqT) {
            paramString = s.X((String)localObject2, ((b)localObject1).GH((String)localObject2));
          }
        }
        localb = ((b)localObject1).nqR;
        localObject1 = localb;
        localObject2 = paramString;
      } while (localb != null);
      localObject1 = paramString;
    }
    return localObject1;
  }
  
  public final e<? extends T> a(g<?> paramg, f<?, T> paramf, e<T> parame)
  {
    s.u(paramg, "targetView");
    s.u(paramf, "reaper");
    s.u(parame, "source");
    return parame;
  }
  
  public final e<T> a(g<?> paramg, f<?, T> paramf, e<T> parame, b.b paramb)
  {
    s.u(paramg, "targetView");
    s.u(paramf, "reaper");
    s.u(parame, "source");
    s.u(paramb, "when");
    Object localObject2 = ((a)this).nqR;
    Object localObject1;
    Object localObject3;
    if ((localObject2 instanceof b))
    {
      localObject1 = parame;
      label138:
      if (localObject2 != null)
      {
        localObject3 = localObject2;
        label91:
        label115:
        label123:
        do
        {
          localObject1 = parame;
          if (localObject3.nqS == b.a.nqW)
          {
            localObject1 = parame;
            if (paramb == localObject3.nqT)
            {
              if (!(parame instanceof e)) {
                break;
              }
              localObject1 = parame;
              s.checkNotNull(localObject1);
              localObject1 = localObject3.a(paramg, paramf, (e)localObject1);
              if (!(localObject1 instanceof e)) {
                break label415;
              }
              if (localObject1 != null) {
                break label421;
              }
              localObject1 = parame;
            }
          }
          localObject2 = localObject3.nqR;
          if (!(localObject2 instanceof b)) {
            break label424;
          }
          localObject3 = localObject2;
          parame = (e<T>)localObject1;
        } while (localObject2 != null);
      }
      localObject2 = ((a)this).nqR;
      if (!(localObject2 instanceof b)) {
        break label430;
      }
      label167:
      parame = (e<T>)localObject1;
      label259:
      if (localObject2 != null)
      {
        localObject3 = localObject2;
        label217:
        label237:
        label244:
        do
        {
          parame = (e<T>)localObject1;
          if (localObject3.nqS == b.a.nqV)
          {
            parame = (e<T>)localObject1;
            if (paramb == localObject3.nqT)
            {
              if (!(localObject1 instanceof e)) {
                break;
              }
              parame = (e<T>)localObject1;
              s.checkNotNull(parame);
              parame = localObject3.a(paramg, paramf, parame);
              if (!(parame instanceof e)) {
                break label441;
              }
              if (parame != null) {
                break label446;
              }
              parame = (e<T>)localObject1;
            }
          }
          localObject2 = localObject3.nqR;
          if (!(localObject2 instanceof b)) {
            break label449;
          }
          localObject3 = localObject2;
          localObject1 = parame;
        } while (localObject2 != null);
      }
      localObject1 = ((a)this).nqR;
      if (!(localObject1 instanceof b)) {
        break label455;
      }
      label288:
      localObject2 = parame;
      if (localObject1 != null)
      {
        localObject3 = localObject1;
        label300:
        localObject1 = parame;
        if (localObject3.nqS == b.a.nqU)
        {
          localObject1 = parame;
          if (paramb == localObject3.nqT)
          {
            if (!(parame instanceof e)) {
              break label461;
            }
            localObject1 = parame;
            label337:
            s.checkNotNull(localObject1);
            localObject1 = localObject3.a(paramg, paramf, (e)localObject1);
            if (!(localObject1 instanceof e)) {
              break label467;
            }
            label361:
            if (localObject1 != null) {
              break label473;
            }
            localObject1 = parame;
          }
        }
        label369:
        localObject2 = localObject3.nqR;
        if (!(localObject2 instanceof b)) {
          break label476;
        }
      }
    }
    for (;;)
    {
      localObject3 = localObject2;
      parame = (e<T>)localObject1;
      if (localObject2 != null) {
        break label300;
      }
      localObject2 = localObject1;
      return localObject2;
      localObject2 = null;
      break;
      localObject1 = null;
      break label91;
      label415:
      localObject1 = null;
      break label115;
      label421:
      break label123;
      label424:
      localObject2 = null;
      break label138;
      label430:
      localObject2 = null;
      break label167;
      parame = null;
      break label217;
      label441:
      parame = null;
      break label237;
      label446:
      break label244;
      label449:
      localObject2 = null;
      break label259;
      label455:
      localObject1 = null;
      break label288;
      label461:
      localObject1 = null;
      break label337;
      label467:
      localObject1 = null;
      break label361;
      label473:
      break label369;
      label476:
      localObject2 = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.loader.d.c.a
 * JD-Core Version:    0.7.0.1
 */
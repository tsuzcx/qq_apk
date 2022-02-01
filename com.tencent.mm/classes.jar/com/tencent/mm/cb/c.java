package com.tencent.mm.cb;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aa.f;
import com.tencent.mm.api.g;
import com.tencent.mm.api.u;
import com.tencent.mm.cache.ArtistCacheManager;
import com.tencent.mm.cache.d;
import com.tencent.mm.cache.i;
import java.util.Iterator;
import java.util.Stack;

public final class c
  implements u
{
  private boolean cBX = true;
  private com.tencent.mm.bu.b cRz;
  
  public c(com.tencent.mm.bu.b paramb)
  {
    this.cRz = paramb;
  }
  
  public final int JT()
  {
    AppMethodBeat.i(9333);
    d locald = (d)ArtistCacheManager.Ur().a(com.tencent.mm.e.a.cRu);
    if (locald == null)
    {
      AppMethodBeat.o(9333);
      return 0;
    }
    int i = locald.cB(this.cBX)[1];
    AppMethodBeat.o(9333);
    return i;
  }
  
  public final int JU()
  {
    AppMethodBeat.i(9334);
    d locald = (d)ArtistCacheManager.Ur().a(com.tencent.mm.e.a.cRu);
    if (locald == null)
    {
      AppMethodBeat.o(9334);
      return 0;
    }
    int i = locald.cB(this.cBX)[0];
    AppMethodBeat.o(9334);
    return i;
  }
  
  public final int JV()
  {
    AppMethodBeat.i(9335);
    i locali = (i)ArtistCacheManager.Ur().a(com.tencent.mm.e.a.cRt);
    if (locali == null)
    {
      AppMethodBeat.o(9335);
      return 0;
    }
    int i = locali.aj(this.cBX);
    AppMethodBeat.o(9335);
    return i;
  }
  
  public final int JW()
  {
    AppMethodBeat.i(9336);
    com.tencent.mm.cache.b localb = (com.tencent.mm.cache.b)ArtistCacheManager.Ur().a(com.tencent.mm.e.a.cRs);
    if (localb == null)
    {
      AppMethodBeat.o(9336);
      return 0;
    }
    int i = localb.aj(this.cBX);
    AppMethodBeat.o(9336);
    return i;
  }
  
  public final int JX()
  {
    AppMethodBeat.i(9337);
    int i = 0;
    Object localObject = (com.tencent.mm.cache.b)ArtistCacheManager.Ur().a(com.tencent.mm.e.a.cRs);
    if (localObject != null) {
      i = ((com.tencent.mm.cache.b)localObject).fmF + 0;
    }
    localObject = (i)ArtistCacheManager.Ur().a(com.tencent.mm.e.a.cRt);
    int j = i;
    if (localObject != null) {
      j = i + ((i)localObject).fmF;
    }
    AppMethodBeat.o(9337);
    return j;
  }
  
  public final boolean JY()
  {
    boolean bool2 = false;
    AppMethodBeat.i(9339);
    com.tencent.mm.e.b localb = this.cRz.c(g.cJw);
    boolean bool1 = bool2;
    if (localb != null)
    {
      bool1 = bool2;
      if (localb.Mb() == com.tencent.mm.e.a.cRv) {
        if (((com.tencent.mm.e.c)localb).getRotation() == 0.0F) {
          break label61;
        }
      }
    }
    label61:
    for (bool1 = true;; bool1 = false)
    {
      AppMethodBeat.o(9339);
      return bool1;
    }
  }
  
  public final int JZ()
  {
    AppMethodBeat.i(9341);
    Object localObject = (com.tencent.mm.cache.b)ArtistCacheManager.Ur().a(com.tencent.mm.e.a.cRs);
    if (localObject == null)
    {
      AppMethodBeat.o(9341);
      return 0;
    }
    int[] arrayOfInt1 = new int[com.tencent.mm.view.footer.a.HZA.length];
    if (this.cBX)
    {
      localObject = ((com.tencent.mm.cache.b)localObject).fmC;
      if (localObject != null) {
        localObject = ((Stack)localObject).iterator();
      }
    }
    else
    {
      label143:
      for (;;)
      {
        label67:
        if (!((Iterator)localObject).hasNext()) {
          break label145;
        }
        com.tencent.mm.aa.b localb = (com.tencent.mm.aa.b)((Iterator)localObject).next();
        int[] arrayOfInt2 = com.tencent.mm.view.footer.a.HZA;
        i = 0;
        for (;;)
        {
          if (i >= arrayOfInt2.length) {
            break label143;
          }
          if (localb.mColor == arrayOfInt2[i])
          {
            arrayOfInt1[i] += 1;
            break label67;
            localObject = ((com.tencent.mm.cache.b)localObject).fmD;
            break;
          }
          i += 1;
        }
      }
    }
    label145:
    int m = arrayOfInt1.length;
    int i = 0;
    int k;
    for (int j = 0; i < m; j = k)
    {
      k = j;
      if (arrayOfInt1[i] > 0) {
        k = j + 1;
      }
      i += 1;
    }
    AppMethodBeat.o(9341);
    return j;
  }
  
  public final boolean Ka()
  {
    AppMethodBeat.i(9342);
    com.tencent.mm.cache.b localb = (com.tencent.mm.cache.b)ArtistCacheManager.Ur().a(com.tencent.mm.e.a.cRs);
    i locali = (i)ArtistCacheManager.Ur().a(com.tencent.mm.e.a.cRt);
    com.tencent.mm.cache.a locala = (com.tencent.mm.cache.a)ArtistCacheManager.Ur().a(com.tencent.mm.e.a.cRv);
    d locald = (d)ArtistCacheManager.Ur().a(com.tencent.mm.e.a.cRu);
    if (((localb != null) && (localb.aj(true) > 0)) || ((locali != null) && (locali.aj(true) > 0)) || ((locald != null) && (locald.aj(true) > 0)) || ((locala != null) && (locala.aj(true) > 0)))
    {
      AppMethodBeat.o(9342);
      return true;
    }
    AppMethodBeat.o(9342);
    return false;
  }
  
  public final String Kb()
  {
    AppMethodBeat.i(9343);
    String str = ((d)ArtistCacheManager.Ur().a(com.tencent.mm.e.a.cRu)).oJ(",")[0];
    AppMethodBeat.o(9343);
    return str;
  }
  
  public final String Kc()
  {
    AppMethodBeat.i(9344);
    String str = ((d)ArtistCacheManager.Ur().a(com.tencent.mm.e.a.cRu)).oJ("||")[1];
    AppMethodBeat.o(9344);
    return str;
  }
  
  public final int getTextColor()
  {
    AppMethodBeat.i(9340);
    Object localObject1 = (d)ArtistCacheManager.Ur().a(com.tencent.mm.e.a.cRu);
    if (localObject1 == null)
    {
      AppMethodBeat.o(9340);
      return 0;
    }
    int i;
    if (this.cBX)
    {
      localObject1 = ((d)localObject1).fmC;
      if (localObject1 != null)
      {
        localObject1 = ((Stack)localObject1).iterator();
        i = 0;
      }
    }
    else
    {
      label139:
      for (;;)
      {
        label54:
        j = i;
        if (!((Iterator)localObject1).hasNext()) {
          break label143;
        }
        Object localObject2 = (com.tencent.mm.aa.c)((Iterator)localObject1).next();
        if ((localObject2 instanceof f))
        {
          localObject2 = (f)localObject2;
          int[] arrayOfInt = com.tencent.mm.view.footer.a.HZA;
          j = 0;
          for (;;)
          {
            if (j >= arrayOfInt.length) {
              break label139;
            }
            if (((f)localObject2).mColor == arrayOfInt[j])
            {
              i = 1 << j | i;
              break label54;
              localObject1 = ((d)localObject1).fmD;
              break;
            }
            j += 1;
          }
        }
      }
    }
    int j = 0;
    label143:
    AppMethodBeat.o(9340);
    return j;
  }
  
  public final boolean isCropped()
  {
    AppMethodBeat.i(9338);
    com.tencent.mm.cache.a locala = (com.tencent.mm.cache.a)ArtistCacheManager.Ur().a(com.tencent.mm.e.a.cRv);
    if (locala == null)
    {
      AppMethodBeat.o(9338);
      return false;
    }
    if (locala.aj(this.cBX) > 0)
    {
      AppMethodBeat.o(9338);
      return true;
    }
    AppMethodBeat.o(9338);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.cb.c
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.cg;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ab.f;
import com.tencent.mm.api.h;
import com.tencent.mm.api.x;
import com.tencent.mm.cache.ArtistCacheManager;
import com.tencent.mm.cache.d;
import com.tencent.mm.cache.i;
import java.util.Iterator;
import java.util.Stack;

public final class c
  implements x
{
  private boolean dfl = true;
  private com.tencent.mm.ca.b fkE;
  
  public c(com.tencent.mm.ca.b paramb)
  {
    this.fkE = paramb;
  }
  
  public final int ZS()
  {
    AppMethodBeat.i(9333);
    d locald = (d)ArtistCacheManager.arz().a(com.tencent.mm.e.a.fkz);
    if (locald == null)
    {
      AppMethodBeat.o(9333);
      return 0;
    }
    int i = locald.dM(this.dfl)[1];
    AppMethodBeat.o(9333);
    return i;
  }
  
  public final int ZT()
  {
    AppMethodBeat.i(9334);
    d locald = (d)ArtistCacheManager.arz().a(com.tencent.mm.e.a.fkz);
    if (locald == null)
    {
      AppMethodBeat.o(9334);
      return 0;
    }
    int i = locald.dM(this.dfl)[0];
    AppMethodBeat.o(9334);
    return i;
  }
  
  public final int ZU()
  {
    AppMethodBeat.i(9335);
    i locali = (i)ArtistCacheManager.arz().a(com.tencent.mm.e.a.fky);
    if (locali == null)
    {
      AppMethodBeat.o(9335);
      return 0;
    }
    int i = locali.ai(this.dfl);
    AppMethodBeat.o(9335);
    return i;
  }
  
  public final int ZV()
  {
    AppMethodBeat.i(9336);
    com.tencent.mm.cache.b localb = (com.tencent.mm.cache.b)ArtistCacheManager.arz().a(com.tencent.mm.e.a.fkx);
    if (localb == null)
    {
      AppMethodBeat.o(9336);
      return 0;
    }
    int i = localb.ai(this.dfl);
    AppMethodBeat.o(9336);
    return i;
  }
  
  public final int ZW()
  {
    AppMethodBeat.i(9337);
    int i = 0;
    Object localObject = (com.tencent.mm.cache.b)ArtistCacheManager.arz().a(com.tencent.mm.e.a.fkx);
    if (localObject != null) {
      i = ((com.tencent.mm.cache.b)localObject).iTI + 0;
    }
    localObject = (i)ArtistCacheManager.arz().a(com.tencent.mm.e.a.fky);
    int j = i;
    if (localObject != null) {
      j = i + ((i)localObject).iTI;
    }
    AppMethodBeat.o(9337);
    return j;
  }
  
  public final boolean ZX()
  {
    boolean bool2 = false;
    AppMethodBeat.i(9339);
    com.tencent.mm.e.b localb = this.fkE.c(h.far);
    boolean bool1 = bool2;
    if (localb != null)
    {
      bool1 = bool2;
      if (localb.acy() == com.tencent.mm.e.a.fkA) {
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
  
  public final int ZY()
  {
    AppMethodBeat.i(9341);
    Object localObject = (com.tencent.mm.cache.b)ArtistCacheManager.arz().a(com.tencent.mm.e.a.fkx);
    if (localObject == null)
    {
      AppMethodBeat.o(9341);
      return 0;
    }
    int[] arrayOfInt1 = new int[com.tencent.mm.view.footer.a.YQk.length];
    if (this.dfl)
    {
      localObject = ((com.tencent.mm.cache.b)localObject).iTF;
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
        com.tencent.mm.ab.b localb = (com.tencent.mm.ab.b)((Iterator)localObject).next();
        int[] arrayOfInt2 = com.tencent.mm.view.footer.a.YQk;
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
            localObject = ((com.tencent.mm.cache.b)localObject).iTG;
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
  
  public final boolean ZZ()
  {
    AppMethodBeat.i(9342);
    com.tencent.mm.cache.b localb = (com.tencent.mm.cache.b)ArtistCacheManager.arz().a(com.tencent.mm.e.a.fkx);
    i locali = (i)ArtistCacheManager.arz().a(com.tencent.mm.e.a.fky);
    com.tencent.mm.cache.a locala = (com.tencent.mm.cache.a)ArtistCacheManager.arz().a(com.tencent.mm.e.a.fkA);
    d locald = (d)ArtistCacheManager.arz().a(com.tencent.mm.e.a.fkz);
    if (((localb != null) && (localb.ai(true) > 0)) || ((locali != null) && (locali.ai(true) > 0)) || ((locald != null) && (locald.ai(true) > 0)) || ((locala != null) && (locala.ai(true) > 0)))
    {
      AppMethodBeat.o(9342);
      return true;
    }
    AppMethodBeat.o(9342);
    return false;
  }
  
  public final String aaa()
  {
    AppMethodBeat.i(9343);
    String str = ((d)ArtistCacheManager.arz().a(com.tencent.mm.e.a.fkz)).Kh(",")[0];
    AppMethodBeat.o(9343);
    return str;
  }
  
  public final String aab()
  {
    AppMethodBeat.i(9344);
    String str = ((d)ArtistCacheManager.arz().a(com.tencent.mm.e.a.fkz)).Kh("||")[1];
    AppMethodBeat.o(9344);
    return str;
  }
  
  public final int getTextColor()
  {
    AppMethodBeat.i(9340);
    Object localObject1 = (d)ArtistCacheManager.arz().a(com.tencent.mm.e.a.fkz);
    if (localObject1 == null)
    {
      AppMethodBeat.o(9340);
      return 0;
    }
    int i;
    if (this.dfl)
    {
      localObject1 = ((d)localObject1).iTF;
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
        Object localObject2 = (com.tencent.mm.ab.c)((Iterator)localObject1).next();
        if ((localObject2 instanceof f))
        {
          localObject2 = (f)localObject2;
          int[] arrayOfInt = com.tencent.mm.view.footer.a.YQk;
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
              localObject1 = ((d)localObject1).iTG;
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
    com.tencent.mm.cache.a locala = (com.tencent.mm.cache.a)ArtistCacheManager.arz().a(com.tencent.mm.e.a.fkA);
    if (locala == null)
    {
      AppMethodBeat.o(9338);
      return false;
    }
    if (locala.ai(this.dfl) > 0)
    {
      AppMethodBeat.o(9338);
      return true;
    }
    AppMethodBeat.o(9338);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.cg.c
 * JD-Core Version:    0.7.0.1
 */
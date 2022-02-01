package com.tencent.mm.bz;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.g;
import com.tencent.mm.api.u;
import com.tencent.mm.cache.ArtistCacheManager;
import com.tencent.mm.cache.d;
import com.tencent.mm.cache.i;
import com.tencent.mm.z.f;
import java.util.Iterator;
import java.util.Stack;

public final class c
  implements u
{
  private boolean cKL = true;
  private com.tencent.mm.bt.b dbm;
  
  public c(com.tencent.mm.bt.b paramb)
  {
    this.dbm = paramb;
  }
  
  public final int Lk()
  {
    AppMethodBeat.i(9333);
    d locald = (d)ArtistCacheManager.XN().a(com.tencent.mm.e.a.dbh);
    if (locald == null)
    {
      AppMethodBeat.o(9333);
      return 0;
    }
    int i = locald.cD(this.cKL)[1];
    AppMethodBeat.o(9333);
    return i;
  }
  
  public final int Ll()
  {
    AppMethodBeat.i(9334);
    d locald = (d)ArtistCacheManager.XN().a(com.tencent.mm.e.a.dbh);
    if (locald == null)
    {
      AppMethodBeat.o(9334);
      return 0;
    }
    int i = locald.cD(this.cKL)[0];
    AppMethodBeat.o(9334);
    return i;
  }
  
  public final int Lm()
  {
    AppMethodBeat.i(9335);
    i locali = (i)ArtistCacheManager.XN().a(com.tencent.mm.e.a.dbg);
    if (locali == null)
    {
      AppMethodBeat.o(9335);
      return 0;
    }
    int i = locali.aj(this.cKL);
    AppMethodBeat.o(9335);
    return i;
  }
  
  public final int Ln()
  {
    AppMethodBeat.i(9336);
    com.tencent.mm.cache.b localb = (com.tencent.mm.cache.b)ArtistCacheManager.XN().a(com.tencent.mm.e.a.dbf);
    if (localb == null)
    {
      AppMethodBeat.o(9336);
      return 0;
    }
    int i = localb.aj(this.cKL);
    AppMethodBeat.o(9336);
    return i;
  }
  
  public final int Lo()
  {
    AppMethodBeat.i(9337);
    int i = 0;
    Object localObject = (com.tencent.mm.cache.b)ArtistCacheManager.XN().a(com.tencent.mm.e.a.dbf);
    if (localObject != null) {
      i = ((com.tencent.mm.cache.b)localObject).fKl + 0;
    }
    localObject = (i)ArtistCacheManager.XN().a(com.tencent.mm.e.a.dbg);
    int j = i;
    if (localObject != null) {
      j = i + ((i)localObject).fKl;
    }
    AppMethodBeat.o(9337);
    return j;
  }
  
  public final boolean Lp()
  {
    boolean bool2 = false;
    AppMethodBeat.i(9339);
    com.tencent.mm.e.b localb = this.dbm.c(g.cSr);
    boolean bool1 = bool2;
    if (localb != null)
    {
      bool1 = bool2;
      if (localb.NG() == com.tencent.mm.e.a.dbi) {
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
  
  public final int Lq()
  {
    AppMethodBeat.i(9341);
    Object localObject = (com.tencent.mm.cache.b)ArtistCacheManager.XN().a(com.tencent.mm.e.a.dbf);
    if (localObject == null)
    {
      AppMethodBeat.o(9341);
      return 0;
    }
    int[] arrayOfInt1 = new int[com.tencent.mm.view.footer.a.LQk.length];
    if (this.cKL)
    {
      localObject = ((com.tencent.mm.cache.b)localObject).fKi;
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
        com.tencent.mm.z.b localb = (com.tencent.mm.z.b)((Iterator)localObject).next();
        int[] arrayOfInt2 = com.tencent.mm.view.footer.a.LQk;
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
            localObject = ((com.tencent.mm.cache.b)localObject).fKj;
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
  
  public final boolean Lr()
  {
    AppMethodBeat.i(9342);
    com.tencent.mm.cache.b localb = (com.tencent.mm.cache.b)ArtistCacheManager.XN().a(com.tencent.mm.e.a.dbf);
    i locali = (i)ArtistCacheManager.XN().a(com.tencent.mm.e.a.dbg);
    com.tencent.mm.cache.a locala = (com.tencent.mm.cache.a)ArtistCacheManager.XN().a(com.tencent.mm.e.a.dbi);
    d locald = (d)ArtistCacheManager.XN().a(com.tencent.mm.e.a.dbh);
    if (((localb != null) && (localb.aj(true) > 0)) || ((locali != null) && (locali.aj(true) > 0)) || ((locald != null) && (locald.aj(true) > 0)) || ((locala != null) && (locala.aj(true) > 0)))
    {
      AppMethodBeat.o(9342);
      return true;
    }
    AppMethodBeat.o(9342);
    return false;
  }
  
  public final String Ls()
  {
    AppMethodBeat.i(9343);
    String str = ((d)ArtistCacheManager.XN().a(com.tencent.mm.e.a.dbh)).va(",")[0];
    AppMethodBeat.o(9343);
    return str;
  }
  
  public final String Lt()
  {
    AppMethodBeat.i(9344);
    String str = ((d)ArtistCacheManager.XN().a(com.tencent.mm.e.a.dbh)).va("||")[1];
    AppMethodBeat.o(9344);
    return str;
  }
  
  public final int getTextColor()
  {
    AppMethodBeat.i(9340);
    Object localObject1 = (d)ArtistCacheManager.XN().a(com.tencent.mm.e.a.dbh);
    if (localObject1 == null)
    {
      AppMethodBeat.o(9340);
      return 0;
    }
    int i;
    if (this.cKL)
    {
      localObject1 = ((d)localObject1).fKi;
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
        Object localObject2 = (com.tencent.mm.z.c)((Iterator)localObject1).next();
        if ((localObject2 instanceof f))
        {
          localObject2 = (f)localObject2;
          int[] arrayOfInt = com.tencent.mm.view.footer.a.LQk;
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
              localObject1 = ((d)localObject1).fKj;
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
    com.tencent.mm.cache.a locala = (com.tencent.mm.cache.a)ArtistCacheManager.XN().a(com.tencent.mm.e.a.dbi);
    if (locala == null)
    {
      AppMethodBeat.o(9338);
      return false;
    }
    if (locala.aj(this.cKL) > 0)
    {
      AppMethodBeat.o(9338);
      return true;
    }
    AppMethodBeat.o(9338);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.bz.c
 * JD-Core Version:    0.7.0.1
 */
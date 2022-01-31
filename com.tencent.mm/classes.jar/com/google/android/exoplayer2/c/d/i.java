package com.google.android.exoplayer2.c.d;

import com.google.android.exoplayer2.c.f;
import com.google.android.exoplayer2.i.m;
import com.google.android.exoplayer2.i.x;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class i
{
  private static final int[] aHT;
  
  static
  {
    AppMethodBeat.i(95012);
    aHT = new int[] { x.aS("isom"), x.aS("iso2"), x.aS("iso3"), x.aS("iso4"), x.aS("iso5"), x.aS("iso6"), x.aS("avc1"), x.aS("hvc1"), x.aS("hev1"), x.aS("mp41"), x.aS("mp42"), x.aS("3g2a"), x.aS("3g2b"), x.aS("3gr6"), x.aS("3gs6"), x.aS("3ge6"), x.aS("3gg6"), x.aS("M4V "), x.aS("M4A "), x.aS("f4v "), x.aS("kddi"), x.aS("M4VP"), x.aS("qt  "), x.aS("MSNV") };
    AppMethodBeat.o(95012);
  }
  
  private static boolean b(f paramf, boolean paramBoolean)
  {
    AppMethodBeat.i(95010);
    long l2 = paramf.getLength();
    long l1;
    if (l2 != -1L)
    {
      l1 = l2;
      if (l2 <= 4096L) {}
    }
    else
    {
      l1 = 4096L;
    }
    int n = (int)l1;
    m localm = new m(64);
    int j = 0;
    boolean bool2 = false;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      int m;
      int i1;
      if (i < n)
      {
        m = 8;
        localm.reset(8);
        paramf.b(localm.data, 0, 8);
        l2 = localm.cc();
        i1 = localm.readInt();
        if (l2 == 1L)
        {
          k = 16;
          paramf.b(localm.data, 8, 8);
          localm.em(16);
          l1 = localm.qV();
        }
        while (l1 < k)
        {
          AppMethodBeat.o(95010);
          return false;
          l1 = l2;
          k = m;
          if (l2 == 0L)
          {
            long l3 = paramf.getLength();
            l1 = l2;
            k = m;
            if (l3 != -1L)
            {
              l1 = l3 - paramf.getPosition() + 8L;
              k = m;
            }
          }
        }
        m = i + k;
        i = m;
        if (i1 == a.aEQ) {
          continue;
        }
        if ((i1 != a.aEZ) && (i1 != a.aFb)) {
          break label283;
        }
        bool1 = true;
      }
      label283:
      do
      {
        if ((j == 0) || (paramBoolean != bool1)) {
          break;
        }
        AppMethodBeat.o(95010);
        return true;
        bool1 = bool2;
      } while (m + l1 - k >= n);
      int k = (int)(l1 - k);
      i = m + k;
      if (i1 == a.aEp)
      {
        if (k < 8)
        {
          AppMethodBeat.o(95010);
          return false;
        }
        localm.reset(k);
        paramf.b(localm.data, 0, k);
        i1 = k / 4;
        m = 0;
        k = j;
        if (m < i1)
        {
          if (m == 1) {
            localm.en(4);
          }
          while (!dy(localm.readInt()))
          {
            m += 1;
            break;
          }
          k = 1;
        }
        if (k == 0)
        {
          AppMethodBeat.o(95010);
          return false;
        }
        j = k;
      }
      else if (k != 0)
      {
        paramf.dh(k);
      }
    }
    AppMethodBeat.o(95010);
    return false;
  }
  
  private static boolean dy(int paramInt)
  {
    AppMethodBeat.i(95011);
    if (paramInt >>> 8 == x.aS("3gp"))
    {
      AppMethodBeat.o(95011);
      return true;
    }
    int[] arrayOfInt = aHT;
    int j = arrayOfInt.length;
    int i = 0;
    while (i < j)
    {
      if (arrayOfInt[i] == paramInt)
      {
        AppMethodBeat.o(95011);
        return true;
      }
      i += 1;
    }
    AppMethodBeat.o(95011);
    return false;
  }
  
  public static boolean g(f paramf)
  {
    AppMethodBeat.i(95008);
    boolean bool = b(paramf, true);
    AppMethodBeat.o(95008);
    return bool;
  }
  
  public static boolean h(f paramf)
  {
    AppMethodBeat.i(95009);
    boolean bool = b(paramf, false);
    AppMethodBeat.o(95009);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.exoplayer2.c.d.i
 * JD-Core Version:    0.7.0.1
 */
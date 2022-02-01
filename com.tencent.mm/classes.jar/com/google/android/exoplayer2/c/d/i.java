package com.google.android.exoplayer2.c.d;

import com.google.android.exoplayer2.c.f;
import com.google.android.exoplayer2.i.m;
import com.google.android.exoplayer2.i.x;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class i
{
  private static final int[] cRL;
  
  static
  {
    AppMethodBeat.i(92128);
    cRL = new int[] { x.du("isom"), x.du("iso2"), x.du("iso3"), x.du("iso4"), x.du("iso5"), x.du("iso6"), x.du("avc1"), x.du("hvc1"), x.du("hev1"), x.du("mp41"), x.du("mp42"), x.du("3g2a"), x.du("3g2b"), x.du("3gr6"), x.du("3gs6"), x.du("3ge6"), x.du("3gg6"), x.du("M4V "), x.du("M4A "), x.du("f4v "), x.du("kddi"), x.du("M4VP"), x.du("qt  "), x.du("MSNV") };
    AppMethodBeat.o(92128);
  }
  
  private static boolean b(f paramf, boolean paramBoolean)
  {
    AppMethodBeat.i(92126);
    long l2 = paramf.RU();
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
        localm.iF(8);
        paramf.b(localm.data, 0, 8);
        l2 = localm.FT();
        i1 = localm.readInt();
        if (l2 == 1L)
        {
          k = 16;
          paramf.b(localm.data, 8, 8);
          localm.iG(16);
          l1 = localm.UP();
        }
        while (l1 < k)
        {
          AppMethodBeat.o(92126);
          return false;
          l1 = l2;
          k = m;
          if (l2 == 0L)
          {
            long l3 = paramf.RU();
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
        if (i1 == a.cOI) {
          continue;
        }
        if ((i1 != a.cOR) && (i1 != a.cOT)) {
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
        AppMethodBeat.o(92126);
        return true;
        bool1 = bool2;
      } while (m + l1 - k >= n);
      int k = (int)(l1 - k);
      i = m + k;
      if (i1 == a.cOh)
      {
        if (k < 8)
        {
          AppMethodBeat.o(92126);
          return false;
        }
        localm.iF(k);
        paramf.b(localm.data, 0, k);
        i1 = k / 4;
        m = 0;
        k = j;
        if (m < i1)
        {
          if (m == 1) {
            localm.iH(4);
          }
          while (!hL(localm.readInt()))
          {
            m += 1;
            break;
          }
          k = 1;
        }
        if (k == 0)
        {
          AppMethodBeat.o(92126);
          return false;
        }
        j = k;
      }
      else if (k != 0)
      {
        paramf.hu(k);
      }
    }
    AppMethodBeat.o(92126);
    return false;
  }
  
  public static boolean g(f paramf)
  {
    AppMethodBeat.i(92124);
    boolean bool = b(paramf, true);
    AppMethodBeat.o(92124);
    return bool;
  }
  
  public static boolean h(f paramf)
  {
    AppMethodBeat.i(92125);
    boolean bool = b(paramf, false);
    AppMethodBeat.o(92125);
    return bool;
  }
  
  private static boolean hL(int paramInt)
  {
    AppMethodBeat.i(92127);
    if (paramInt >>> 8 == x.du("3gp"))
    {
      AppMethodBeat.o(92127);
      return true;
    }
    int[] arrayOfInt = cRL;
    int j = arrayOfInt.length;
    int i = 0;
    while (i < j)
    {
      if (arrayOfInt[i] == paramInt)
      {
        AppMethodBeat.o(92127);
        return true;
      }
      i += 1;
    }
    AppMethodBeat.o(92127);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.google.android.exoplayer2.c.d.i
 * JD-Core Version:    0.7.0.1
 */
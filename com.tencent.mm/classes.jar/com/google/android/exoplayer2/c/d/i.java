package com.google.android.exoplayer2.c.d;

import com.google.android.exoplayer2.c.f;
import com.google.android.exoplayer2.i.m;
import com.google.android.exoplayer2.i.x;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class i
{
  private static final int[] bdX;
  
  static
  {
    AppMethodBeat.i(92128);
    bdX = new int[] { x.aQ("isom"), x.aQ("iso2"), x.aQ("iso3"), x.aQ("iso4"), x.aQ("iso5"), x.aQ("iso6"), x.aQ("avc1"), x.aQ("hvc1"), x.aQ("hev1"), x.aQ("mp41"), x.aQ("mp42"), x.aQ("3g2a"), x.aQ("3g2b"), x.aQ("3gr6"), x.aQ("3gs6"), x.aQ("3ge6"), x.aQ("3gg6"), x.aQ("M4V "), x.aQ("M4A "), x.aQ("f4v "), x.aQ("kddi"), x.aQ("M4VP"), x.aQ("qt  "), x.aQ("MSNV") };
    AppMethodBeat.o(92128);
  }
  
  private static boolean b(f paramf, boolean paramBoolean)
  {
    AppMethodBeat.i(92126);
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
        l2 = localm.dm();
        i1 = localm.readInt();
        if (l2 == 1L)
        {
          k = 16;
          paramf.b(localm.data, 8, 8);
          localm.eW(16);
          l1 = localm.vH();
        }
        while (l1 < k)
        {
          AppMethodBeat.o(92126);
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
        if (i1 == a.baU) {
          continue;
        }
        if ((i1 != a.bbd) && (i1 != a.bbf)) {
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
      if (i1 == a.bat)
      {
        if (k < 8)
        {
          AppMethodBeat.o(92126);
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
            localm.eX(4);
          }
          while (!ej(localm.readInt()))
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
        paramf.dR(k);
      }
    }
    AppMethodBeat.o(92126);
    return false;
  }
  
  private static boolean ej(int paramInt)
  {
    AppMethodBeat.i(92127);
    if (paramInt >>> 8 == x.aQ("3gp"))
    {
      AppMethodBeat.o(92127);
      return true;
    }
    int[] arrayOfInt = bdX;
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.c.d.i
 * JD-Core Version:    0.7.0.1
 */
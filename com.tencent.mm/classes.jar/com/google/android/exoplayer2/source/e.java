package com.google.android.exoplayer2.source;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class e
  implements m
{
  private final m[] bvI;
  
  public e(m[] paramArrayOfm)
  {
    this.bvI = paramArrayOfm;
  }
  
  public final boolean X(long paramLong)
  {
    AppMethodBeat.i(92642);
    boolean bool3 = false;
    boolean bool4;
    boolean bool1;
    do
    {
      long l = vl();
      bool4 = bool3;
      if (l == -9223372036854775808L) {
        break;
      }
      m[] arrayOfm = this.bvI;
      int j = arrayOfm.length;
      int i = 0;
      boolean bool2;
      for (bool1 = false; i < j; bool1 = bool2)
      {
        m localm = arrayOfm[i];
        bool2 = bool1;
        if (localm.vl() == l) {
          bool2 = bool1 | localm.X(paramLong);
        }
        i += 1;
      }
      bool4 = bool3 | bool1;
      bool3 = bool4;
    } while (bool1);
    AppMethodBeat.o(92642);
    return bool4;
  }
  
  public final long vk()
  {
    AppMethodBeat.i(92640);
    m[] arrayOfm = this.bvI;
    int j = arrayOfm.length;
    int i = 0;
    long l2;
    for (long l1 = 9223372036854775807L; i < j; l1 = l2)
    {
      long l3 = arrayOfm[i].vk();
      l2 = l1;
      if (l3 != -9223372036854775808L) {
        l2 = Math.min(l1, l3);
      }
      i += 1;
    }
    if (l1 == 9223372036854775807L)
    {
      AppMethodBeat.o(92640);
      return -9223372036854775808L;
    }
    AppMethodBeat.o(92640);
    return l1;
  }
  
  public final long vl()
  {
    AppMethodBeat.i(92641);
    m[] arrayOfm = this.bvI;
    int j = arrayOfm.length;
    int i = 0;
    long l2;
    for (long l1 = 9223372036854775807L; i < j; l1 = l2)
    {
      long l3 = arrayOfm[i].vl();
      l2 = l1;
      if (l3 != -9223372036854775808L) {
        l2 = Math.min(l1, l3);
      }
      i += 1;
    }
    if (l1 == 9223372036854775807L)
    {
      AppMethodBeat.o(92641);
      return -9223372036854775808L;
    }
    AppMethodBeat.o(92641);
    return l1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.source.e
 * JD-Core Version:    0.7.0.1
 */
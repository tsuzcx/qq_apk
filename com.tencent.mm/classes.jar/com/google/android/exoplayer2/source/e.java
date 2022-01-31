package com.google.android.exoplayer2.source;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class e
  implements m
{
  private final m[] aPi;
  
  public e(m[] paramArrayOfm)
  {
    this.aPi = paramArrayOfm;
  }
  
  public final boolean Q(long paramLong)
  {
    AppMethodBeat.i(95476);
    boolean bool3 = false;
    boolean bool4;
    boolean bool1;
    do
    {
      long l = oW();
      bool4 = bool3;
      if (l == -9223372036854775808L) {
        break;
      }
      m[] arrayOfm = this.aPi;
      int j = arrayOfm.length;
      int i = 0;
      boolean bool2;
      for (bool1 = false; i < j; bool1 = bool2)
      {
        m localm = arrayOfm[i];
        bool2 = bool1;
        if (localm.oW() == l) {
          bool2 = bool1 | localm.Q(paramLong);
        }
        i += 1;
      }
      bool4 = bool3 | bool1;
      bool3 = bool4;
    } while (bool1);
    AppMethodBeat.o(95476);
    return bool4;
  }
  
  public final long oV()
  {
    AppMethodBeat.i(95474);
    m[] arrayOfm = this.aPi;
    int j = arrayOfm.length;
    int i = 0;
    long l2;
    for (long l1 = 9223372036854775807L; i < j; l1 = l2)
    {
      long l3 = arrayOfm[i].oV();
      l2 = l1;
      if (l3 != -9223372036854775808L) {
        l2 = Math.min(l1, l3);
      }
      i += 1;
    }
    if (l1 == 9223372036854775807L)
    {
      AppMethodBeat.o(95474);
      return -9223372036854775808L;
    }
    AppMethodBeat.o(95474);
    return l1;
  }
  
  public final long oW()
  {
    AppMethodBeat.i(95475);
    m[] arrayOfm = this.aPi;
    int j = arrayOfm.length;
    int i = 0;
    long l2;
    for (long l1 = 9223372036854775807L; i < j; l1 = l2)
    {
      long l3 = arrayOfm[i].oW();
      l2 = l1;
      if (l3 != -9223372036854775808L) {
        l2 = Math.min(l1, l3);
      }
      i += 1;
    }
    if (l1 == 9223372036854775807L)
    {
      AppMethodBeat.o(95475);
      return -9223372036854775808L;
    }
    AppMethodBeat.o(95475);
    return l1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.google.android.exoplayer2.source.e
 * JD-Core Version:    0.7.0.1
 */
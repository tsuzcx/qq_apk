package com.google.android.exoplayer2.source;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class f
  implements o
{
  private final o[] cYY;
  
  public f(o[] paramArrayOfo)
  {
    this.cYY = paramArrayOfo;
  }
  
  public final long SR()
  {
    AppMethodBeat.i(92640);
    o[] arrayOfo = this.cYY;
    int j = arrayOfo.length;
    int i = 0;
    long l2;
    for (long l1 = 9223372036854775807L; i < j; l1 = l2)
    {
      long l3 = arrayOfo[i].SR();
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
  
  public final long SS()
  {
    AppMethodBeat.i(92641);
    o[] arrayOfo = this.cYY;
    int j = arrayOfo.length;
    int i = 0;
    long l2;
    for (long l1 = 9223372036854775807L; i < j; l1 = l2)
    {
      long l3 = arrayOfo[i].SS();
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
  
  public final boolean co(long paramLong)
  {
    AppMethodBeat.i(92642);
    boolean bool3 = false;
    boolean bool4;
    boolean bool1;
    do
    {
      long l = SS();
      bool4 = bool3;
      if (l == -9223372036854775808L) {
        break;
      }
      o[] arrayOfo = this.cYY;
      int j = arrayOfo.length;
      int i = 0;
      boolean bool2;
      for (bool1 = false; i < j; bool1 = bool2)
      {
        o localo = arrayOfo[i];
        bool2 = bool1;
        if (localo.SS() == l) {
          bool2 = bool1 | localo.co(paramLong);
        }
        i += 1;
      }
      bool4 = bool3 | bool1;
      bool3 = bool4;
    } while (bool1);
    AppMethodBeat.o(92642);
    return bool4;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.google.android.exoplayer2.source.f
 * JD-Core Version:    0.7.0.1
 */
package com.google.android.exoplayer2.f.c;

import com.google.android.exoplayer2.f.d;
import com.google.android.exoplayer2.i.x;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collections;
import java.util.List;

final class b
  implements d
{
  private final com.google.android.exoplayer2.f.a[] buk;
  private final long[] bul;
  
  public b(com.google.android.exoplayer2.f.a[] paramArrayOfa, long[] paramArrayOfLong)
  {
    this.buk = paramArrayOfa;
    this.bul = paramArrayOfLong;
  }
  
  public final int am(long paramLong)
  {
    AppMethodBeat.i(92811);
    int i = x.a(this.bul, paramLong, false, false);
    if (i < this.bul.length)
    {
      AppMethodBeat.o(92811);
      return i;
    }
    AppMethodBeat.o(92811);
    return -1;
  }
  
  public final List<com.google.android.exoplayer2.f.a> an(long paramLong)
  {
    AppMethodBeat.i(92813);
    int i = x.a(this.bul, paramLong, false);
    if ((i == -1) || (this.buk[i] == null))
    {
      localList = Collections.emptyList();
      AppMethodBeat.o(92813);
      return localList;
    }
    List localList = Collections.singletonList(this.buk[i]);
    AppMethodBeat.o(92813);
    return localList;
  }
  
  public final long eR(int paramInt)
  {
    boolean bool2 = true;
    AppMethodBeat.i(92812);
    if (paramInt >= 0)
    {
      bool1 = true;
      com.google.android.exoplayer2.i.a.checkArgument(bool1);
      if (paramInt >= this.bul.length) {
        break label53;
      }
    }
    label53:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      com.google.android.exoplayer2.i.a.checkArgument(bool1);
      long l = this.bul[paramInt];
      AppMethodBeat.o(92812);
      return l;
      bool1 = false;
      break;
    }
  }
  
  public final int uB()
  {
    return this.bul.length;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.f.c.b
 * JD-Core Version:    0.7.0.1
 */
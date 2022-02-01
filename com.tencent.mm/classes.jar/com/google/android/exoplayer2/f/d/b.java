package com.google.android.exoplayer2.f.d;

import com.google.android.exoplayer2.f.d;
import com.google.android.exoplayer2.i.x;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collections;
import java.util.List;

final class b
  implements d
{
  private final com.google.android.exoplayer2.f.a[] bsi;
  private final long[] bsj;
  
  public b(com.google.android.exoplayer2.f.a[] paramArrayOfa, long[] paramArrayOfLong)
  {
    this.bsi = paramArrayOfa;
    this.bsj = paramArrayOfLong;
  }
  
  public final int ai(long paramLong)
  {
    AppMethodBeat.i(92819);
    int i = x.a(this.bsj, paramLong, false, false);
    if (i < this.bsj.length)
    {
      AppMethodBeat.o(92819);
      return i;
    }
    AppMethodBeat.o(92819);
    return -1;
  }
  
  public final List<com.google.android.exoplayer2.f.a> aj(long paramLong)
  {
    AppMethodBeat.i(92821);
    int i = x.a(this.bsj, paramLong, false);
    if ((i == -1) || (this.bsi[i] == null))
    {
      localList = Collections.emptyList();
      AppMethodBeat.o(92821);
      return localList;
    }
    List localList = Collections.singletonList(this.bsi[i]);
    AppMethodBeat.o(92821);
    return localList;
  }
  
  public final long eE(int paramInt)
  {
    boolean bool2 = true;
    AppMethodBeat.i(92820);
    if (paramInt >= 0)
    {
      bool1 = true;
      com.google.android.exoplayer2.i.a.checkArgument(bool1);
      if (paramInt >= this.bsj.length) {
        break label53;
      }
    }
    label53:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      com.google.android.exoplayer2.i.a.checkArgument(bool1);
      long l = this.bsj[paramInt];
      AppMethodBeat.o(92820);
      return l;
      bool1 = false;
      break;
    }
  }
  
  public final int uw()
  {
    return this.bsj.length;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.f.d.b
 * JD-Core Version:    0.7.0.1
 */
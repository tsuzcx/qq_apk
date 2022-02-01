package com.google.android.exoplayer2.g;

import com.google.android.exoplayer2.i.x;
import com.google.android.exoplayer2.source.q;
import com.google.android.exoplayer2.t;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class i
{
  public final q bwp;
  public final g bwq;
  public final t[] bwr;
  public final Object info;
  
  public i(q paramq, g paramg, Object paramObject, t[] paramArrayOft)
  {
    this.bwp = paramq;
    this.bwq = paramg;
    this.info = paramObject;
    this.bwr = paramArrayOft;
  }
  
  public final boolean a(i parami)
  {
    AppMethodBeat.i(92953);
    if (parami == null)
    {
      AppMethodBeat.o(92953);
      return false;
    }
    int i = 0;
    while (i < this.bwq.length)
    {
      if (!a(parami, i))
      {
        AppMethodBeat.o(92953);
        return false;
      }
      i += 1;
    }
    AppMethodBeat.o(92953);
    return true;
  }
  
  public final boolean a(i parami, int paramInt)
  {
    AppMethodBeat.i(92954);
    if (parami == null)
    {
      AppMethodBeat.o(92954);
      return false;
    }
    if ((x.g(this.bwq.bwn[paramInt], parami.bwq.bwn[paramInt])) && (x.g(this.bwr[paramInt], parami.bwr[paramInt])))
    {
      AppMethodBeat.o(92954);
      return true;
    }
    AppMethodBeat.o(92954);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.g.i
 * JD-Core Version:    0.7.0.1
 */
package com.google.android.exoplayer2.g;

import com.google.android.exoplayer2.i.x;
import com.google.android.exoplayer2.source.r;
import com.google.android.exoplayer2.t;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class i
{
  public final r boh;
  public final g boi;
  public final t[] boj;
  public final Object info;
  
  public i(r paramr, g paramg, Object paramObject, t[] paramArrayOft)
  {
    this.boh = paramr;
    this.boi = paramg;
    this.info = paramObject;
    this.boj = paramArrayOft;
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
    while (i < this.boi.length)
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
    if ((x.h(this.boi.bof[paramInt], parami.boi.bof[paramInt])) && (x.h(this.boj[paramInt], parami.boj[paramInt])))
    {
      AppMethodBeat.o(92954);
      return true;
    }
    AppMethodBeat.o(92954);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.exoplayer2.g.i
 * JD-Core Version:    0.7.0.1
 */
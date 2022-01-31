package com.google.android.exoplayer2.g;

import com.google.android.exoplayer2.i.x;
import com.google.android.exoplayer2.source.p;
import com.google.android.exoplayer2.t;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class i
{
  public final p aYm;
  public final g aYn;
  public final t[] aYo;
  public final Object info;
  
  public i(p paramp, g paramg, Object paramObject, t[] paramArrayOft)
  {
    this.aYm = paramp;
    this.aYn = paramg;
    this.info = paramObject;
    this.aYo = paramArrayOft;
  }
  
  public final boolean a(i parami)
  {
    AppMethodBeat.i(95785);
    if (parami == null)
    {
      AppMethodBeat.o(95785);
      return false;
    }
    int i = 0;
    while (i < this.aYn.length)
    {
      if (!a(parami, i))
      {
        AppMethodBeat.o(95785);
        return false;
      }
      i += 1;
    }
    AppMethodBeat.o(95785);
    return true;
  }
  
  public final boolean a(i parami, int paramInt)
  {
    AppMethodBeat.i(95786);
    if (parami == null)
    {
      AppMethodBeat.o(95786);
      return false;
    }
    if ((x.e(this.aYn.aYk[paramInt], parami.aYn.aYk[paramInt])) && (x.e(this.aYo[paramInt], parami.aYo[paramInt])))
    {
      AppMethodBeat.o(95786);
      return true;
    }
    AppMethodBeat.o(95786);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.google.android.exoplayer2.g.i
 * JD-Core Version:    0.7.0.1
 */
package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.h.a;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class k$a
{
  public final long aGe;
  public final long aIy;
  public a aQA;
  public boolean aQy;
  public a aQz;
  
  public k$a(long paramLong, int paramInt)
  {
    AppMethodBeat.i(95528);
    this.aIy = paramLong;
    this.aGe = (paramInt + paramLong);
    AppMethodBeat.o(95528);
  }
  
  public final int X(long paramLong)
  {
    return (int)(paramLong - this.aIy) + this.aQz.offset;
  }
  
  public final void a(a parama, a parama1)
  {
    this.aQz = parama;
    this.aQA = parama1;
    this.aQy = true;
  }
  
  public final a ps()
  {
    this.aQz = null;
    a locala = this.aQA;
    this.aQA = null;
    return locala;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.google.android.exoplayer2.source.k.a
 * JD-Core Version:    0.7.0.1
 */
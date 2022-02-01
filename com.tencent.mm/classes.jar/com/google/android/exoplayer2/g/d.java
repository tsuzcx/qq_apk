package com.google.android.exoplayer2.g;

import com.google.android.exoplayer2.source.q;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class d
  extends b
{
  private final Object cpt;
  private final int reason;
  
  public d(q paramq, int paramInt)
  {
    this(paramq, paramInt, (byte)0);
  }
  
  private d(q paramq, int paramInt, byte paramByte)
  {
    super(paramq, new int[] { paramInt });
    AppMethodBeat.i(92947);
    this.reason = 0;
    this.cpt = null;
    AppMethodBeat.o(92947);
  }
  
  public final int Tq()
  {
    return this.reason;
  }
  
  public final Object Tr()
  {
    return this.cpt;
  }
  
  public final void cw(long paramLong) {}
  
  public final int getSelectedIndex()
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.exoplayer2.g.d
 * JD-Core Version:    0.7.0.1
 */
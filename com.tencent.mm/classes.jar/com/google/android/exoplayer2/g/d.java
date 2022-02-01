package com.google.android.exoplayer2.g;

import com.google.android.exoplayer2.source.o;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class d
  extends b
{
  private final Object data;
  private final int reason;
  
  public d(o paramo, int paramInt)
  {
    this(paramo, paramInt, (byte)0);
  }
  
  private d(o paramo, int paramInt, byte paramByte)
  {
    super(paramo, new int[] { paramInt });
    AppMethodBeat.i(92947);
    this.reason = 0;
    this.data = null;
    AppMethodBeat.o(92947);
  }
  
  public final void af(long paramLong) {}
  
  public final int getSelectedIndex()
  {
    return 0;
  }
  
  public final int ul()
  {
    return this.reason;
  }
  
  public final Object um()
  {
    return this.data;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.g.d
 * JD-Core Version:    0.7.0.1
 */
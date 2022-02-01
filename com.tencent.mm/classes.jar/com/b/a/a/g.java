package com.b.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class g
  extends e
{
  private final long cBA;
  
  public g(long paramLong)
  {
    AppMethodBeat.i(183628);
    if (paramLong <= 0L)
    {
      IllegalArgumentException localIllegalArgumentException = new IllegalArgumentException("Max size must be positive number!");
      AppMethodBeat.o(183628);
      throw localIllegalArgumentException;
    }
    this.cBA = paramLong;
    AppMethodBeat.o(183628);
  }
  
  protected final boolean bG(long paramLong)
  {
    return paramLong <= this.cBA;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.b.a.a.g
 * JD-Core Version:    0.7.0.1
 */
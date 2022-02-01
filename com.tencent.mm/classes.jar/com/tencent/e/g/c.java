package com.tencent.e.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.TimeUnit;

public final class c
  extends b
{
  private long KaM = 1000L;
  
  public c(int paramInt1, int paramInt2)
  {
    super(paramInt1, paramInt2);
  }
  
  public final long a(g paramg, TimeUnit paramTimeUnit)
  {
    AppMethodBeat.i(183325);
    long l = paramTimeUnit.convert(this.KaM, TimeUnit.MILLISECONDS);
    AppMethodBeat.o(183325);
    return l;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.e.g.c
 * JD-Core Version:    0.7.0.1
 */
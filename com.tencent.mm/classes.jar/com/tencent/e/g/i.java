package com.tencent.e.g;

import com.tencent.e.g.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.TimeUnit;

public final class i
  extends a
{
  private volatile int limit;
  
  public i(int paramInt)
  {
    this.limit = paramInt;
  }
  
  public final long a(g paramg, TimeUnit paramTimeUnit)
  {
    return -1L;
  }
  
  public final boolean c(g paramg)
  {
    AppMethodBeat.i(183340);
    if (this.limit >= paramg.gaj())
    {
      AppMethodBeat.o(183340);
      return true;
    }
    AppMethodBeat.o(183340);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.e.g.i
 * JD-Core Version:    0.7.0.1
 */
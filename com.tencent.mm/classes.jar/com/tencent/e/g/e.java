package com.tencent.e.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.TimeUnit;

public class e
  extends b
{
  public e(int paramInt1, int paramInt2)
  {
    super(paramInt1, paramInt2);
  }
  
  public final long a(g paramg, TimeUnit paramTimeUnit)
  {
    AppMethodBeat.i(183326);
    long l1 = paramg.getLong("INCREMENT", 1L);
    long l2 = paramg.getLong("LAST_INCREMENT", 0L) + l1;
    paramg.put("LAST_INCREMENT", l1);
    paramg.put("INCREMENT", l2);
    l1 = paramTimeUnit.convert(l2, TimeUnit.MILLISECONDS);
    AppMethodBeat.o(183326);
    return l1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.e.g.e
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.e.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public final class f
  extends b
{
  private final long LUJ = 1000L;
  private final float deH = 500.0F;
  
  public f(int paramInt1, int paramInt2)
  {
    super(paramInt1, paramInt2);
  }
  
  public final long a(g paramg, TimeUnit paramTimeUnit)
  {
    AppMethodBeat.i(183327);
    Object localObject = paramg.cDF.get("incrementCount");
    if (localObject == null) {}
    for (int i = 1;; i = ((Integer)localObject).intValue())
    {
      long l = ((float)this.LUJ + i * this.deH);
      paramg.cDF.put("incrementCount", Integer.valueOf(i + 1));
      l = paramTimeUnit.convert(l, TimeUnit.MILLISECONDS);
      AppMethodBeat.o(183327);
      return l;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.e.g.f
 * JD-Core Version:    0.7.0.1
 */
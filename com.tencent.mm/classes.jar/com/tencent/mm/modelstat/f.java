package com.tencent.mm.modelstat;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.memory.a.c;

public final class f
{
  private static f isK = null;
  public com.tencent.mm.b.f<String, Long> isL;
  public String isM;
  
  private f()
  {
    AppMethodBeat.i(151076);
    this.isL = new c(10);
    AppMethodBeat.o(151076);
  }
  
  public static f aMd()
  {
    AppMethodBeat.i(151075);
    if (isK == null) {
      isK = new f();
    }
    f localf = isK;
    AppMethodBeat.o(151075);
    return localf;
  }
  
  public final void I(String paramString, long paramLong)
  {
    AppMethodBeat.i(151077);
    if (this.isL != null)
    {
      this.isM = paramString;
      this.isL.put(paramString, Long.valueOf(paramLong));
    }
    AppMethodBeat.o(151077);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.modelstat.f
 * JD-Core Version:    0.7.0.1
 */
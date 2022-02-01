package com.tencent.mm.modelstat;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.memory.a.c;

public final class f
{
  private static f hvT = null;
  public com.tencent.mm.b.f<String, Long> hvU;
  public String hvV;
  
  private f()
  {
    AppMethodBeat.i(151076);
    this.hvU = new c(10);
    AppMethodBeat.o(151076);
  }
  
  public static f aBG()
  {
    AppMethodBeat.i(151075);
    if (hvT == null) {
      hvT = new f();
    }
    f localf = hvT;
    AppMethodBeat.o(151075);
    return localf;
  }
  
  public final void C(String paramString, long paramLong)
  {
    AppMethodBeat.i(151077);
    if (this.hvU != null)
    {
      this.hvV = paramString;
      this.hvU.put(paramString, Long.valueOf(paramLong));
    }
    AppMethodBeat.o(151077);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.modelstat.f
 * JD-Core Version:    0.7.0.1
 */
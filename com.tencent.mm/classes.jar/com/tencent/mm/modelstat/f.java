package com.tencent.mm.modelstat;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.memory.a.c;

public final class f
{
  private static f ipP = null;
  public com.tencent.mm.b.f<String, Long> ipQ;
  public String ipR;
  
  private f()
  {
    AppMethodBeat.i(151076);
    this.ipQ = new c(10);
    AppMethodBeat.o(151076);
  }
  
  public static f aLG()
  {
    AppMethodBeat.i(151075);
    if (ipP == null) {
      ipP = new f();
    }
    f localf = ipP;
    AppMethodBeat.o(151075);
    return localf;
  }
  
  public final void I(String paramString, long paramLong)
  {
    AppMethodBeat.i(151077);
    if (this.ipQ != null)
    {
      this.ipR = paramString;
      this.ipQ.put(paramString, Long.valueOf(paramLong));
    }
    AppMethodBeat.o(151077);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.modelstat.f
 * JD-Core Version:    0.7.0.1
 */
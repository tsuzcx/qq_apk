package com.tencent.mm.modelstat;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.f;
import com.tencent.mm.memory.a.c;

public final class e
{
  private static e oWf = null;
  public f<String, Long> oWg;
  public String oWh;
  
  private e()
  {
    AppMethodBeat.i(151076);
    this.oWg = new c(10);
    AppMethodBeat.o(151076);
  }
  
  public static e bNb()
  {
    AppMethodBeat.i(151075);
    if (oWf == null) {
      oWf = new e();
    }
    e locale = oWf;
    AppMethodBeat.o(151075);
    return locale;
  }
  
  public final void J(String paramString, long paramLong)
  {
    AppMethodBeat.i(151077);
    if (this.oWg != null)
    {
      this.oWh = paramString;
      this.oWg.put(paramString, Long.valueOf(paramLong));
    }
    AppMethodBeat.o(151077);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.modelstat.e
 * JD-Core Version:    0.7.0.1
 */
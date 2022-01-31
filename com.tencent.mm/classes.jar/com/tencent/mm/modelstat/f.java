package com.tencent.mm.modelstat;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.memory.a.c;

public final class f
{
  private static f fTk = null;
  public com.tencent.mm.a.f<String, Long> fTl;
  public String fTm;
  
  private f()
  {
    AppMethodBeat.i(78732);
    this.fTl = new c(10);
    AppMethodBeat.o(78732);
  }
  
  public static f akB()
  {
    AppMethodBeat.i(78731);
    if (fTk == null) {
      fTk = new f();
    }
    f localf = fTk;
    AppMethodBeat.o(78731);
    return localf;
  }
  
  public final void B(String paramString, long paramLong)
  {
    AppMethodBeat.i(78733);
    if (this.fTl != null)
    {
      this.fTm = paramString;
      this.fTl.put(paramString, Long.valueOf(paramLong));
    }
    AppMethodBeat.o(78733);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.modelstat.f
 * JD-Core Version:    0.7.0.1
 */
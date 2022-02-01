package com.tencent.mm.modelstat;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.memory.a.c;

public final class f
{
  private static f hWu = null;
  public com.tencent.mm.b.f<String, Long> hWv;
  public String hWw;
  
  private f()
  {
    AppMethodBeat.i(151076);
    this.hWv = new c(10);
    AppMethodBeat.o(151076);
  }
  
  public static f aIw()
  {
    AppMethodBeat.i(151075);
    if (hWu == null) {
      hWu = new f();
    }
    f localf = hWu;
    AppMethodBeat.o(151075);
    return localf;
  }
  
  public final void D(String paramString, long paramLong)
  {
    AppMethodBeat.i(151077);
    if (this.hWv != null)
    {
      this.hWw = paramString;
      this.hWv.put(paramString, Long.valueOf(paramLong));
    }
    AppMethodBeat.o(151077);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.modelstat.f
 * JD-Core Version:    0.7.0.1
 */
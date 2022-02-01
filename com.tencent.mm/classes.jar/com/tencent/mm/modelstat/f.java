package com.tencent.mm.modelstat;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.memory.a.c;

public final class f
{
  private static f jnX = null;
  public com.tencent.mm.b.f<String, Long> jnY;
  public String jnZ;
  
  private f()
  {
    AppMethodBeat.i(151076);
    this.jnY = new c(10);
    AppMethodBeat.o(151076);
  }
  
  public static f bgg()
  {
    AppMethodBeat.i(151075);
    if (jnX == null) {
      jnX = new f();
    }
    f localf = jnX;
    AppMethodBeat.o(151075);
    return localf;
  }
  
  public final void J(String paramString, long paramLong)
  {
    AppMethodBeat.i(151077);
    if (this.jnY != null)
    {
      this.jnZ = paramString;
      this.jnY.put(paramString, Long.valueOf(paramLong));
    }
    AppMethodBeat.o(151077);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.modelstat.f
 * JD-Core Version:    0.7.0.1
 */
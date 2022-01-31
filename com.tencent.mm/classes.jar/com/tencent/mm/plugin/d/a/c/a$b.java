package com.tencent.mm.plugin.d.a.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;

public final class a$b
  implements Runnable
{
  private long jNZ = 0L;
  private long jOa = 0L;
  
  public a$b(a parama, long paramLong1, long paramLong2)
  {
    this.jNZ = paramLong1;
    this.jOa = paramLong2;
  }
  
  public final void run()
  {
    AppMethodBeat.i(18477);
    a locala = this.jQO;
    b localb1 = new b(this.jNZ);
    long l = localb1.mSessionId;
    b localb2 = (b)locala.jNO.remove(Long.valueOf(l));
    if (localb2 != null) {
      localb2.disconnect();
    }
    locala.jNO.put(Long.valueOf(l), localb1);
    if (this.jQO.jQL != null) {
      this.jQO.jQL.f(l, this.jNZ, this.jOa);
    }
    AppMethodBeat.o(18477);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.d.a.c.a.b
 * JD-Core Version:    0.7.0.1
 */
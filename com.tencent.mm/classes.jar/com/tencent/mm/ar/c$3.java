package com.tencent.mm.ar;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.ao.b.a;
import java.util.Map;

final class c$3
  implements Runnable
{
  c$3(c paramc, String paramString, boolean paramBoolean) {}
  
  public final void run()
  {
    AppMethodBeat.i(16472);
    if (this.fCU.fCM.containsKey(this.fCV))
    {
      ao.b.a locala = (ao.b.a)this.fCU.fCM.get(this.fCV);
      if (locala != null) {
        locala.p(this.fCV, this.fCW);
      }
      this.fCU.fCM.remove(this.fCV);
    }
    AppMethodBeat.o(16472);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ar.c.3
 * JD-Core Version:    0.7.0.1
 */
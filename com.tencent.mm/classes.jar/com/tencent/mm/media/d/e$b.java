package com.tencent.mm.media.d;

import a.l;
import a.y;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "run"})
final class e$b
  implements Runnable
{
  e$b(e parame) {}
  
  public final void run()
  {
    AppMethodBeat.i(12943);
    long l = bo.yB();
    synchronized (e.a(this.eUD))
    {
      if (e.b(this.eUD))
      {
        ab.i(e.c(this.eUD), "post encode frame, already finish");
        AppMethodBeat.o(12943);
        return;
      }
      y localy = y.BMg;
      e.d(this.eUD);
      ab.d(e.c(this.eUD), "drainEncoder cost " + bo.av(l));
      AppMethodBeat.o(12943);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.media.d.e.b
 * JD-Core Version:    0.7.0.1
 */
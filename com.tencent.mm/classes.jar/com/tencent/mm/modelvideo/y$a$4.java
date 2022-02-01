package com.tencent.mm.modelvideo;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;

final class y$a$4
  implements Runnable
{
  y$a$4(y.a parama, String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(127041);
    u.at(this.cNj, this.ibz);
    s locals = u.Ej(this.cNj);
    if ((locals != null) && (locals.status != 199))
    {
      if (locals.aJM())
      {
        ac.i("MicroMsg.VideoService", "start complete online video");
        u.Eq(this.cNj);
        AppMethodBeat.o(127041);
        return;
      }
      ac.i("MicroMsg.VideoService", "start complete offline video");
      u.Ee(this.cNj);
    }
    AppMethodBeat.o(127041);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.modelvideo.y.a.4
 * JD-Core Version:    0.7.0.1
 */
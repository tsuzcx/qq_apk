package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.kernel.h;
import com.tencent.mm.loader.i.b;
import com.tencent.mm.sdk.thread.ThreadPool;

final class c$4
  implements com.tencent.mm.kernel.api.f
{
  c$4(c paramc) {}
  
  public final void FD(String paramString)
  {
    AppMethodBeat.i(20245);
    if (e.aPU())
    {
      h.baF();
      if (h.baE().mCI.equals(b.bmz()))
      {
        h.baF();
        ThreadPool.post(new c.b(h.baE().cachePath, paramString), "AccountStorage_moveDataFiles");
      }
    }
    AppMethodBeat.o(20245);
  }
  
  public final void baN()
  {
    AppMethodBeat.i(20244);
    bh.bCy();
    AppMethodBeat.o(20244);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.model.c.4
 * JD-Core Version:    0.7.0.1
 */
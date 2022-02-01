package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.kernel.h;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.sdk.thread.ThreadPool;

final class c$4
  implements com.tencent.mm.kernel.api.f
{
  c$4(c paramc) {}
  
  public final void MU(String paramString)
  {
    AppMethodBeat.i(20245);
    if (e.avA())
    {
      h.aHH();
      if (h.aHG().kcA.equals(b.aSL()))
      {
        h.aHH();
        ThreadPool.post(new c.b(h.aHG().cachePath, paramString), "AccountStorage_moveDataFiles");
      }
    }
    AppMethodBeat.o(20245);
  }
  
  public final void aHQ()
  {
    AppMethodBeat.i(20244);
    bh.beH();
    AppMethodBeat.o(20244);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.model.c.4
 * JD-Core Version:    0.7.0.1
 */
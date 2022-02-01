package com.tencent.mm.plugin.backup.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.backup.h.d;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.threadpool.i.h;

final class c$15
  implements h
{
  c$15(c paramc) {}
  
  public final String getKey()
  {
    return "getMsgCount";
  }
  
  public final void run()
  {
    AppMethodBeat.i(300745);
    c.c(this.uZf, d.cWK().cWL().bzD().gbq());
    b.cVs().cUJ().uWq = c.o(this.uZf);
    AppMethodBeat.o(300745);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.d.c.15
 * JD-Core Version:    0.7.0.1
 */
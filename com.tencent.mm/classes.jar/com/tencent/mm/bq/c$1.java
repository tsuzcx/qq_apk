package com.tencent.mm.bq;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.a.c.a;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.model.q;

final class c$1
  extends a
{
  c$1(String paramString, q paramq) {}
  
  public final void execute(g paramg)
  {
    AppMethodBeat.i(114680);
    String str = this.wgS;
    q localq = this.wgT;
    d.a(str, c.wgQ, c.wgR);
    paramg = localq;
    if (localq == null) {
      paramg = new q(c.anc(str));
    }
    q.a("plugin.".concat(String.valueOf(str)), paramg);
    AppMethodBeat.o(114680);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.bq.c.1
 * JD-Core Version:    0.7.0.1
 */
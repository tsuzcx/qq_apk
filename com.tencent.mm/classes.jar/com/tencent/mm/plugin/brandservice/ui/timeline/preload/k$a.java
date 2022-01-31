package com.tencent.mm.plugin.brandservice.ui.timeline.preload;

import a.f.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

@a.l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "PROPTYPE", "invoke", "()Ljava/lang/Object;"})
final class k$a
  extends a.f.b.k
  implements a<PROPTYPE>
{
  k$a(k paramk)
  {
    super(0);
  }
  
  public final PROPTYPE invoke()
  {
    AppMethodBeat.i(152702);
    l locall = this.kcs.kcq;
    j localj = (j)this.kcs;
    a.f.b.j.q(localj, "managed");
    synchronized (locall.kct)
    {
      locall.kct.add(localj);
      ??? = this.kcs.kcr.invoke();
      AppMethodBeat.o(152702);
      return ???;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.preload.k.a
 * JD-Core Version:    0.7.0.1
 */
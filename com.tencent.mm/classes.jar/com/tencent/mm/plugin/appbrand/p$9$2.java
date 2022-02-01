package com.tencent.mm.plugin.appbrand;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.launching.AppBrandPrepareTask;

final class p$9$2
  implements Runnable
{
  p$9$2(p.9 param9) {}
  
  public final void run()
  {
    AppMethodBeat.i(224339);
    if (this.jCN.jPi.jCV)
    {
      AppMethodBeat.o(224339);
      return;
    }
    n.a(6, this.jCN.jCE.aXx());
    this.jCN.jCE.a(null, "CommLibReaderInconsistent");
    AppMethodBeat.o(224339);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.p.9.2
 * JD-Core Version:    0.7.0.1
 */
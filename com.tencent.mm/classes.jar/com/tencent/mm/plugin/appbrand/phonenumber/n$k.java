package com.tencent.mm.plugin.appbrand.phonenumber;

import a.l;
import a.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.MMActivity;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "run"})
final class n$k
  implements Runnable
{
  n$k(n paramn) {}
  
  public final void run()
  {
    AppMethodBeat.i(134913);
    Object localObject = this.iEE.context;
    if (localObject == null)
    {
      localObject = new v("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
      AppMethodBeat.o(134913);
      throw ((Throwable)localObject);
    }
    ((MMActivity)localObject).showVKB();
    AppMethodBeat.o(134913);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.phonenumber.n.k
 * JD-Core Version:    0.7.0.1
 */
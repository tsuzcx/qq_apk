package com.tencent.mm.plugin.appbrand.pip;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.page.q;
import com.tencent.mm.plugin.appbrand.page.t;
import com.tencent.mm.plugin.appbrand.page.t.i;
import com.tencent.mm.plugin.appbrand.page.z;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.Map;

final class f$2
  implements t.i
{
  f$2(f paramf) {}
  
  public final void q(q paramq)
  {
    AppMethodBeat.i(207911);
    ae.i(this.msR.crG, "onPageDestroy, page: " + f.r(paramq));
    if (!paramq.mew)
    {
      z localz = paramq.getCurrentPageView();
      ae.i(this.msR.crG, "onPageDestroy, remove " + localz + " from mPageView2PageScopedPipInfoMap");
      this.msR.msu.remove(Integer.valueOf(localz.hashCode()));
    }
    while (this.msR.msz == null)
    {
      AppMethodBeat.o(207911);
      return;
      ae.i(this.msR.crG, "onPageDestroy, " + f.r(paramq) + " is PipVideoRelated");
    }
    if (paramq == this.msR.msz)
    {
      this.msR.msA = false;
      this.msR.jzE.setPipVideoRelatedPage(this.msR.msz);
    }
    AppMethodBeat.o(207911);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.pip.f.2
 * JD-Core Version:    0.7.0.1
 */
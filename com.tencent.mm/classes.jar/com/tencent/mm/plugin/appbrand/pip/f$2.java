package com.tencent.mm.plugin.appbrand.pip;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.page.ac;
import com.tencent.mm.plugin.appbrand.page.t;
import com.tencent.mm.plugin.appbrand.page.w;
import com.tencent.mm.plugin.appbrand.page.w.i;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Map;

final class f$2
  implements w.i
{
  f$2(f paramf) {}
  
  public final void r(t paramt)
  {
    AppMethodBeat.i(219513);
    Log.i(this.nDA.cDW, "onPageDestroy, page: " + f.s(paramt));
    if (!paramt.noQ)
    {
      ac localac = paramt.getCurrentPageView();
      Log.i(this.nDA.cDW, "onPageDestroy, remove " + localac + " from mPageView2PageScopedPipInfoMap");
      this.nDA.nDe.remove(Integer.valueOf(localac.hashCode()));
    }
    while (this.nDA.nDj == null)
    {
      AppMethodBeat.o(219513);
      return;
      Log.i(this.nDA.cDW, "onPageDestroy, " + f.s(paramt) + " is PipVideoRelated");
    }
    if (paramt == this.nDA.nDj)
    {
      this.nDA.nDk = false;
      this.nDA.kAs.setPipVideoRelatedPage(this.nDA.nDj);
    }
    AppMethodBeat.o(219513);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.pip.f.2
 * JD-Core Version:    0.7.0.1
 */
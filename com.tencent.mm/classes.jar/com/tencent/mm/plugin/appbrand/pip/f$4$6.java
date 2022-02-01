package com.tencent.mm.plugin.appbrand.pip;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;

final class f$4$6
  implements Runnable
{
  f$4$6(f.4 param4, boolean paramBoolean) {}
  
  public final void run()
  {
    AppMethodBeat.i(221150);
    d locald;
    c localc;
    if (this.mnW.mnT.hv(false)) {
      if ((this.mnW.mnT.mnR != null) && (this.mnW.mnT.mnD != null))
      {
        locald = this.mnW.mnT.mnR;
        localc = this.mnW.mnT.mnD.mmp;
        if (!this.nbM) {
          break label122;
        }
      }
    }
    label122:
    for (e locale = e.mnp;; locale = e.mnq)
    {
      locald.a(localc, locale);
      ad.i(this.mnW.mnT.crd, "processTransferFromOnPlay, clearPipVideoRelated");
      this.mnW.mnT.y(true, true);
      AppMethodBeat.o(221150);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.pip.f.4.6
 * JD-Core Version:    0.7.0.1
 */
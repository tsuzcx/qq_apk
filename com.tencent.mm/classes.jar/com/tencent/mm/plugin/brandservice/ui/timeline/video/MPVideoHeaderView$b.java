package com.tencent.mm.plugin.brandservice.ui.timeline.video;

import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.b;
import com.tencent.mm.ah.h;
import com.tencent.mm.ah.i;
import com.tencent.mm.ah.o;
import com.tencent.mm.plugin.brandservice.b.a;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "run"})
final class MPVideoHeaderView$b
  implements Runnable
{
  MPVideoHeaderView$b(MPVideoHeaderView paramMPVideoHeaderView, ad paramad) {}
  
  public final void run()
  {
    AppMethodBeat.i(138521);
    if (b.qR(MPVideoHeaderView.c(this.kgT)) == null)
    {
      h localh = o.adg().rj(MPVideoHeaderView.c(this.kgT));
      if ((localh != null) && (!bo.isNullOrNil(localh.acY()))) {
        a.a(MPVideoHeaderView.d(this.kgT), this.kgV, localh.acY(), true);
      }
    }
    AppMethodBeat.o(138521);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.video.MPVideoHeaderView.b
 * JD-Core Version:    0.7.0.1
 */
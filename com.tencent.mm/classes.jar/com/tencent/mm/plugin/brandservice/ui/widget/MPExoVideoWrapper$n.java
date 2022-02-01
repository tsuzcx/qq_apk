package com.tencent.mm.plugin.brandservice.ui.widget;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.i.b;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
final class MPExoVideoWrapper$n
  implements Runnable
{
  MPExoVideoWrapper$n(MPExoVideoWrapper paramMPExoVideoWrapper, String paramString, int paramInt1, int paramInt2) {}
  
  public final void run()
  {
    AppMethodBeat.i(7403);
    this.ozS.GB();
    this.ozS.hideLoading();
    if (MPExoVideoWrapper.s(this.ozS) != null)
    {
      i.b localb = MPExoVideoWrapper.s(this.ozS);
      if (localb == null) {
        p.gkB();
      }
      localb.c("", "", this.ozU, this.ozV, this.ozW);
    }
    AppMethodBeat.o(7403);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.widget.MPExoVideoWrapper.n
 * JD-Core Version:    0.7.0.1
 */
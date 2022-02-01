package com.tencent.mm.plugin.brandservice.ui.widget;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.h;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
final class MPExoVideoWrapper$ad
  implements Runnable
{
  MPExoVideoWrapper$ad(MPExoVideoWrapper paramMPExoVideoWrapper, int paramInt) {}
  
  public final void run()
  {
    AppMethodBeat.i(7418);
    h localh = MPExoVideoWrapper.w(this.ozS);
    if (localh == null) {
      p.gkB();
    }
    localh.tx(this.ozZ);
    AppMethodBeat.o(7418);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.widget.MPExoVideoWrapper.ad
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.brandservice.ui.widget;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.i.b;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
final class MPExoVideoWrapper$v
  implements Runnable
{
  MPExoVideoWrapper$v(MPExoVideoWrapper paramMPExoVideoWrapper) {}
  
  public final void run()
  {
    AppMethodBeat.i(7410);
    if (MPExoVideoWrapper.s(this.ozS) != null)
    {
      i.b localb = MPExoVideoWrapper.s(this.ozS);
      if (localb == null) {
        p.gkB();
      }
      localb.dw("", "");
    }
    AppMethodBeat.o(7410);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.widget.MPExoVideoWrapper.v
 * JD-Core Version:    0.7.0.1
 */
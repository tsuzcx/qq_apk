package com.tencent.mm.plugin.brandservice.ui.widget;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.i.b;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
final class MPExoVideoWrapper$w
  implements Runnable
{
  MPExoVideoWrapper$w(MPExoVideoWrapper paramMPExoVideoWrapper) {}
  
  public final void run()
  {
    AppMethodBeat.i(7411);
    if (MPExoVideoWrapper.s(this.ozS) != null)
    {
      i.b localb = MPExoVideoWrapper.s(this.ozS);
      if (localb == null) {
        p.gkB();
      }
      localb.dx("", "");
    }
    AppMethodBeat.o(7411);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.widget.MPExoVideoWrapper.w
 * JD-Core Version:    0.7.0.1
 */
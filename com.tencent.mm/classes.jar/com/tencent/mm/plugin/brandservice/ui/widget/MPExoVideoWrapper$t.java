package com.tencent.mm.plugin.brandservice.ui.widget;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.d;
import com.tencent.mm.pluginsdk.ui.i.b;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
final class MPExoVideoWrapper$t
  implements Runnable
{
  MPExoVideoWrapper$t(MPExoVideoWrapper paramMPExoVideoWrapper) {}
  
  public final void run()
  {
    AppMethodBeat.i(7408);
    this.ozS.setKeepScreenOn(false);
    MPExoVideoWrapper.x(this.ozS).abn();
    if (MPExoVideoWrapper.s(this.ozS) != null)
    {
      i.b localb = MPExoVideoWrapper.s(this.ozS);
      if (localb == null) {
        p.gkB();
      }
      localb.du("", "");
    }
    AppMethodBeat.o(7408);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.widget.MPExoVideoWrapper.t
 * JD-Core Version:    0.7.0.1
 */
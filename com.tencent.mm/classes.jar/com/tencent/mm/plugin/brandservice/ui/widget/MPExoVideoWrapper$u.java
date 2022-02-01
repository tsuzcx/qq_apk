package com.tencent.mm.plugin.brandservice.ui.widget;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.d;
import com.tencent.mm.model.d.a;
import com.tencent.mm.pluginsdk.ui.i.b;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
final class MPExoVideoWrapper$u
  implements Runnable
{
  MPExoVideoWrapper$u(MPExoVideoWrapper paramMPExoVideoWrapper) {}
  
  public final void run()
  {
    AppMethodBeat.i(7409);
    this.ozS.setKeepScreenOn(true);
    MPExoVideoWrapper.x(this.ozS).a((d.a)this.ozS);
    if (MPExoVideoWrapper.s(this.ozS) != null)
    {
      i.b localb = MPExoVideoWrapper.s(this.ozS);
      if (localb == null) {
        p.gkB();
      }
      localb.dv("", "");
    }
    MPExoVideoWrapper.b(this.ozS, true);
    this.ozS.startTimer();
    AppMethodBeat.o(7409);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.widget.MPExoVideoWrapper.u
 * JD-Core Version:    0.7.0.1
 */
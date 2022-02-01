package com.tencent.mm.plugin.brandservice.ui.widget;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.h;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
final class MPExoVideoWrapper$z
  implements Runnable
{
  MPExoVideoWrapper$z(MPExoVideoWrapper paramMPExoVideoWrapper, int paramInt) {}
  
  public final void run()
  {
    AppMethodBeat.i(7414);
    if (MPExoVideoWrapper.w(this.ozS) != null)
    {
      h localh = MPExoVideoWrapper.w(this.ozS);
      if (localh == null) {
        p.gkB();
      }
      if (localh.getVideoTotalTime() != this.ozY)
      {
        localh = MPExoVideoWrapper.w(this.ozS);
        if (localh == null) {
          p.gkB();
        }
        localh.setVideoTotalTime(this.ozY);
      }
    }
    AppMethodBeat.o(7414);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.widget.MPExoVideoWrapper.z
 * JD-Core Version:    0.7.0.1
 */
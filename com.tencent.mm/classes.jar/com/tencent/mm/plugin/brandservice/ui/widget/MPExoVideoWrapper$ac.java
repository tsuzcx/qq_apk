package com.tencent.mm.plugin.brandservice.ui.widget;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
final class MPExoVideoWrapper$ac
  implements Runnable
{
  MPExoVideoWrapper$ac(MPExoVideoWrapper paramMPExoVideoWrapper) {}
  
  public final void run()
  {
    AppMethodBeat.i(7417);
    ae.i(MPExoVideoWrapper.access$getTAG$cp(), "video stop");
    this.ozS.tK(0);
    MPExoVideoWrapper.b(this.ozS, false);
    MPExoVideoWrapper.f(this.ozS);
    this.ozS.onVideoPause();
    AppMethodBeat.o(7417);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.widget.MPExoVideoWrapper.ac
 * JD-Core Version:    0.7.0.1
 */
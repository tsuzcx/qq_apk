package com.tencent.mm.plugin.brandservice.ui.widget;

import android.widget.ProgressBar;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
final class MPExoVideoWrapper$l
  implements Runnable
{
  MPExoVideoWrapper$l(MPExoVideoWrapper paramMPExoVideoWrapper) {}
  
  public final void run()
  {
    AppMethodBeat.i(7397);
    if (this.ozS.getLoading() != null)
    {
      Object localObject = this.ozS.getLoading();
      if (localObject == null) {
        p.gkB();
      }
      if (((ProgressBar)localObject).getVisibility() != 8)
      {
        ae.i(MPExoVideoWrapper.access$getTAG$cp(), "hide loading");
        localObject = this.ozS.getLoading();
        if (localObject != null) {
          ((ProgressBar)localObject).setVisibility(8);
        }
        localObject = this.ozS;
        ((MPExoVideoWrapper)localObject).gKO.postDelayed((Runnable)new MPExoVideoWrapper.w((MPExoVideoWrapper)localObject), 500L);
      }
    }
    AppMethodBeat.o(7397);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.widget.MPExoVideoWrapper.l
 * JD-Core Version:    0.7.0.1
 */
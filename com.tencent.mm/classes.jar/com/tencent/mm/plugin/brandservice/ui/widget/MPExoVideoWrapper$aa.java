package com.tencent.mm.plugin.brandservice.ui.widget;

import android.widget.ProgressBar;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
final class MPExoVideoWrapper$aa
  implements Runnable
{
  MPExoVideoWrapper$aa(MPExoVideoWrapper paramMPExoVideoWrapper) {}
  
  public final void run()
  {
    AppMethodBeat.i(7415);
    if (this.ozS.getLoading() != null)
    {
      Object localObject = this.ozS.getLoading();
      if (localObject == null) {
        p.gkB();
      }
      if (((ProgressBar)localObject).getVisibility() != 0)
      {
        ae.i(MPExoVideoWrapper.access$getTAG$cp(), "show loading");
        localObject = this.ozS.getLoading();
        if (localObject != null) {
          ((ProgressBar)localObject).setVisibility(0);
        }
        localObject = this.ozS;
        ((MPExoVideoWrapper)localObject).gKO.post((Runnable)new MPExoVideoWrapper.v((MPExoVideoWrapper)localObject));
      }
    }
    AppMethodBeat.o(7415);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.widget.MPExoVideoWrapper.aa
 * JD-Core Version:    0.7.0.1
 */
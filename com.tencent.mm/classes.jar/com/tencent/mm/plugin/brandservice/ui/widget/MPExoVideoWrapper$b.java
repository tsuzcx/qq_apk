package com.tencent.mm.plugin.brandservice.ui.widget;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.h.e;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
final class MPExoVideoWrapper$b
  implements Runnable
{
  MPExoVideoWrapper$b(MPExoVideoWrapper paramMPExoVideoWrapper) {}
  
  public final void run()
  {
    AppMethodBeat.i(7387);
    MPExoVideoTextureView localMPExoVideoTextureView = MPExoVideoWrapper.h(this.nQK);
    if (localMPExoVideoTextureView != null) {
      localMPExoVideoTextureView.setVideoSize(MPExoVideoWrapper.y(this.nQK), MPExoVideoWrapper.z(this.nQK));
    }
    localMPExoVideoTextureView = MPExoVideoWrapper.h(this.nQK);
    if (localMPExoVideoTextureView != null) {
      localMPExoVideoTextureView.bNN();
    }
    localMPExoVideoTextureView = MPExoVideoWrapper.h(this.nQK);
    if (localMPExoVideoTextureView != null)
    {
      localMPExoVideoTextureView.setScaleType(h.e.DnJ);
      AppMethodBeat.o(7387);
      return;
    }
    AppMethodBeat.o(7387);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.widget.MPExoVideoWrapper.b
 * JD-Core Version:    0.7.0.1
 */
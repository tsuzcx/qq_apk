package com.tencent.mm.plugin.brandservice.ui.widget;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.i.e;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
final class MPExoVideoWrapper$b
  implements Runnable
{
  MPExoVideoWrapper$b(MPExoVideoWrapper paramMPExoVideoWrapper) {}
  
  public final void run()
  {
    AppMethodBeat.i(7387);
    MPExoVideoTextureView localMPExoVideoTextureView = MPExoVideoWrapper.h(this.ozS);
    if (localMPExoVideoTextureView != null) {
      localMPExoVideoTextureView.setVideoSize(MPExoVideoWrapper.y(this.ozS), MPExoVideoWrapper.z(this.ozS));
    }
    localMPExoVideoTextureView = MPExoVideoWrapper.h(this.ozS);
    if (localMPExoVideoTextureView != null) {
      localMPExoVideoTextureView.bTA();
    }
    localMPExoVideoTextureView = MPExoVideoWrapper.h(this.ozS);
    if (localMPExoVideoTextureView != null)
    {
      localMPExoVideoTextureView.setScaleType(i.e.Flj);
      AppMethodBeat.o(7387);
      return;
    }
    AppMethodBeat.o(7387);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.widget.MPExoVideoWrapper.b
 * JD-Core Version:    0.7.0.1
 */
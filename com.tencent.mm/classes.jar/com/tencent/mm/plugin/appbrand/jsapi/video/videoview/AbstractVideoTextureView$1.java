package com.tencent.mm.plugin.appbrand.jsapi.video.videoview;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.b;
import com.tencent.mm.sdk.platformtools.ad;

final class AbstractVideoTextureView$1
  extends Thread
{
  AbstractVideoTextureView$1(AbstractVideoTextureView paramAbstractVideoTextureView, b paramb) {}
  
  public final void run()
  {
    AppMethodBeat.i(206456);
    try
    {
      if (this.lsW != null)
      {
        ad.i("MicroMsg.Video.AbstractVideoTextureView", "%d another thread to release player[%s]", new Object[] { Integer.valueOf(this.lsX.hashCode()), this.lsW });
        this.lsW.stop();
        this.lsW.release();
      }
      AppMethodBeat.o(206456);
      return;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(206456);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.videoview.AbstractVideoTextureView.1
 * JD-Core Version:    0.7.0.1
 */
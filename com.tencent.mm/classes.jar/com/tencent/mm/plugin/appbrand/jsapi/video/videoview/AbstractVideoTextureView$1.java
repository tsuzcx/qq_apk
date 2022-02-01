package com.tencent.mm.plugin.appbrand.jsapi.video.videoview;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.b;
import com.tencent.mm.sdk.platformtools.ac;

final class AbstractVideoTextureView$1
  extends Thread
{
  AbstractVideoTextureView$1(AbstractVideoTextureView paramAbstractVideoTextureView, b paramb) {}
  
  public final void run()
  {
    AppMethodBeat.i(194642);
    try
    {
      if (this.kVX != null)
      {
        ac.i("MicroMsg.Video.AbstractVideoTextureView", "%d another thread to release player[%s]", new Object[] { Integer.valueOf(this.kVY.hashCode()), this.kVX });
        this.kVX.stop();
        this.kVX.release();
      }
      AppMethodBeat.o(194642);
      return;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(194642);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.videoview.AbstractVideoTextureView.1
 * JD-Core Version:    0.7.0.1
 */
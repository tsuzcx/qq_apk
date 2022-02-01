package com.tencent.mm.plugin.appbrand.jsapi.video.videoview;

import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;

final class AbstractVideoTextureView$2
  implements Runnable
{
  AbstractVideoTextureView$2(AbstractVideoTextureView paramAbstractVideoTextureView, Surface paramSurface) {}
  
  public final void run()
  {
    AppMethodBeat.i(194643);
    try
    {
      if ((this.kVZ != null) && (this.kVZ.isValid()))
      {
        ac.i("MicroMsg.Video.AbstractVideoTextureView", "%d release surface [%d]", new Object[] { Integer.valueOf(this.kVY.hashCode()), Integer.valueOf(this.kVZ.hashCode()) });
        this.kVZ.release();
      }
      AppMethodBeat.o(194643);
      return;
    }
    catch (Exception localException)
    {
      ac.printErrStackTrace("MicroMsg.Video.AbstractVideoTextureView", localException, "release Surface error", new Object[0]);
      AppMethodBeat.o(194643);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.videoview.AbstractVideoTextureView.2
 * JD-Core Version:    0.7.0.1
 */
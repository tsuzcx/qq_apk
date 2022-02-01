package com.tencent.mm.plugin.appbrand.jsapi.video.videoview;

import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;

final class AbstractVideoTextureView$2
  implements Runnable
{
  AbstractVideoTextureView$2(AbstractVideoTextureView paramAbstractVideoTextureView, Surface paramSurface) {}
  
  public final void run()
  {
    AppMethodBeat.i(206457);
    try
    {
      if ((this.lsY != null) && (this.lsY.isValid()))
      {
        ad.i("MicroMsg.Video.AbstractVideoTextureView", "%d release surface [%d]", new Object[] { Integer.valueOf(this.lsX.hashCode()), Integer.valueOf(this.lsY.hashCode()) });
        this.lsY.release();
      }
      AppMethodBeat.o(206457);
      return;
    }
    catch (Exception localException)
    {
      ad.printErrStackTrace("MicroMsg.Video.AbstractVideoTextureView", localException, "release Surface error", new Object[0]);
      AppMethodBeat.o(206457);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.videoview.AbstractVideoTextureView.2
 * JD-Core Version:    0.7.0.1
 */
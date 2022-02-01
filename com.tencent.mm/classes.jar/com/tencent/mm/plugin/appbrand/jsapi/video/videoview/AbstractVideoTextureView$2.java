package com.tencent.mm.plugin.appbrand.jsapi.video.videoview;

import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;

final class AbstractVideoTextureView$2
  implements Runnable
{
  AbstractVideoTextureView$2(AbstractVideoTextureView paramAbstractVideoTextureView, Surface paramSurface) {}
  
  public final void run()
  {
    AppMethodBeat.i(211487);
    try
    {
      if ((this.lxx != null) && (this.lxx.isValid()))
      {
        ae.i("MicroMsg.Video.AbstractVideoTextureView", "%d release surface [%d]", new Object[] { Integer.valueOf(this.lxw.hashCode()), Integer.valueOf(this.lxx.hashCode()) });
        this.lxx.release();
      }
      AppMethodBeat.o(211487);
      return;
    }
    catch (Exception localException)
    {
      ae.printErrStackTrace("MicroMsg.Video.AbstractVideoTextureView", localException, "release Surface error", new Object[0]);
      AppMethodBeat.o(211487);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.videoview.AbstractVideoTextureView.2
 * JD-Core Version:    0.7.0.1
 */
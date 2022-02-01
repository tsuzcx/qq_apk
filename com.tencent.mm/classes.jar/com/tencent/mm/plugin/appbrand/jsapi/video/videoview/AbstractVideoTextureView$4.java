package com.tencent.mm.plugin.appbrand.jsapi.video.videoview;

import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

final class AbstractVideoTextureView$4
  implements Runnable
{
  AbstractVideoTextureView$4(AbstractVideoTextureView paramAbstractVideoTextureView, Surface paramSurface) {}
  
  public final void run()
  {
    AppMethodBeat.i(235169);
    try
    {
      if ((this.mEu != null) && (this.mEu.isValid()))
      {
        Log.i("MicroMsg.Video.AbstractVideoTextureView", "%d release surface [%d]", new Object[] { Integer.valueOf(this.mEt.hashCode()), Integer.valueOf(this.mEu.hashCode()) });
        this.mEu.release();
      }
      AppMethodBeat.o(235169);
      return;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.Video.AbstractVideoTextureView", localException, "release Surface error", new Object[0]);
      AppMethodBeat.o(235169);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.videoview.AbstractVideoTextureView.4
 * JD-Core Version:    0.7.0.1
 */
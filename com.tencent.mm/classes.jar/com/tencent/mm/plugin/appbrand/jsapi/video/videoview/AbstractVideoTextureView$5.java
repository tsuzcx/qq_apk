package com.tencent.mm.plugin.appbrand.jsapi.video.videoview;

import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

final class AbstractVideoTextureView$5
  implements Runnable
{
  AbstractVideoTextureView$5(AbstractVideoTextureView paramAbstractVideoTextureView, Surface paramSurface) {}
  
  public final void run()
  {
    AppMethodBeat.i(227731);
    try
    {
      if ((this.pDF != null) && (this.pDF.isValid()))
      {
        Log.i("MicroMsg.Video.AbstractVideoTextureView", "%d release surface [%d]", new Object[] { Integer.valueOf(this.pDE.hashCode()), Integer.valueOf(this.pDF.hashCode()) });
        this.pDF.release();
      }
      AppMethodBeat.o(227731);
      return;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.Video.AbstractVideoTextureView", localException, "release Surface error", new Object[0]);
      AppMethodBeat.o(227731);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.videoview.AbstractVideoTextureView.5
 * JD-Core Version:    0.7.0.1
 */
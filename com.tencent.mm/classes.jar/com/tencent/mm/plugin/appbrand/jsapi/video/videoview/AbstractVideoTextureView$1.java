package com.tencent.mm.plugin.appbrand.jsapi.video.videoview;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.g;
import com.tencent.mm.sdk.platformtools.Log;

final class AbstractVideoTextureView$1
  implements Runnable
{
  AbstractVideoTextureView$1(AbstractVideoTextureView paramAbstractVideoTextureView, g paramg) {}
  
  public final void run()
  {
    AppMethodBeat.i(328855);
    try
    {
      this.sIP.reset();
      this.sIP.release();
      AppMethodBeat.o(328855);
      return;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.Video.AbstractVideoTextureView", localException, "reset media player error", new Object[0]);
      AppMethodBeat.o(328855);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.videoview.AbstractVideoTextureView.1
 * JD-Core Version:    0.7.0.1
 */
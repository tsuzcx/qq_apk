package com.tencent.mm.plugin.appbrand.jsapi.video.videoview;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.g;
import com.tencent.mm.sdk.platformtools.Log;

final class AbstractVideoTextureView$6
  extends Thread
{
  AbstractVideoTextureView$6(AbstractVideoTextureView paramAbstractVideoTextureView, g paramg) {}
  
  public final void run()
  {
    AppMethodBeat.i(328849);
    try
    {
      if (this.sIS != null)
      {
        Log.i("MicroMsg.Video.AbstractVideoTextureView", "%d another thread to release player[%s]", new Object[] { Integer.valueOf(this.sIQ.hashCode()), this.sIS });
        this.sIS.stop();
        this.sIS.release();
      }
      AppMethodBeat.o(328849);
      return;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(328849);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.videoview.AbstractVideoTextureView.6
 * JD-Core Version:    0.7.0.1
 */
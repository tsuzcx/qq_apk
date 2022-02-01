package com.tencent.mm.plugin.appbrand.jsapi.video.videoview;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.g.c;
import com.tencent.mm.sdk.platformtools.Log;

final class AbstractVideoTextureView$8
  implements g.c
{
  AbstractVideoTextureView$8(AbstractVideoTextureView paramAbstractVideoTextureView, Runnable paramRunnable) {}
  
  public final void cwA()
  {
    AppMethodBeat.i(328834);
    Log.i("MicroMsg.Video.AbstractVideoTextureView", "onDataSourceSet#openVideo");
    if (Looper.getMainLooper() == Looper.myLooper())
    {
      this.sIT.run();
      AppMethodBeat.o(328834);
      return;
    }
    this.sIQ.post(this.sIT);
    AppMethodBeat.o(328834);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.videoview.AbstractVideoTextureView.8
 * JD-Core Version:    0.7.0.1
 */
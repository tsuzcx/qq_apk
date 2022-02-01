package com.tencent.mm.plugin.appbrand.jsapi.video.videoview;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.g;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.g.a;
import com.tencent.mm.sdk.platformtools.Log;

final class AbstractVideoTextureView$12
  implements g.a
{
  AbstractVideoTextureView$12(AbstractVideoTextureView paramAbstractVideoTextureView) {}
  
  public final void onBufferingUpdate(g paramg, int paramInt)
  {
    AppMethodBeat.i(328862);
    Log.d("MicroMsg.Video.AbstractVideoTextureView", "onBufferingUpdate percent[%d]", new Object[] { Integer.valueOf(paramInt) });
    AbstractVideoTextureView.c(this.sIQ, paramInt);
    AppMethodBeat.o(328862);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.videoview.AbstractVideoTextureView.12
 * JD-Core Version:    0.7.0.1
 */
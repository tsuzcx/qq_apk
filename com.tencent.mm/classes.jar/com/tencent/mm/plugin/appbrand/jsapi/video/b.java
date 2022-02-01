package com.tencent.mm.plugin.appbrand.jsapi.video;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.video.videoview.a.c;
import com.tencent.mm.sdk.platformtools.ad;

public final class b
{
  public static void init()
  {
    AppMethodBeat.i(188534);
    AppBrandVideoWrapper.setVideoViewFactory(new f()
    {
      public final e dv(Context paramAnonymousContext)
      {
        AppMethodBeat.i(188533);
        ad.i("MicroMsg.NonSameLayer.AppBrandVideoNonSameLayerStrategy", "init, use ExoVideoViewWrapper");
        paramAnonymousContext = new c(paramAnonymousContext);
        AppMethodBeat.o(188533);
        return paramAnonymousContext;
      }
    });
    AppMethodBeat.o(188534);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.b
 * JD-Core Version:    0.7.0.1
 */
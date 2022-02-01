package com.tencent.mm.plugin.appbrand.jsapi.video;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.video.videoview.a.c;
import com.tencent.mm.sdk.platformtools.ae;

public final class b
{
  public static void init()
  {
    AppMethodBeat.i(222693);
    AppBrandVideoWrapper.setVideoViewFactory(new f()
    {
      public final e dz(Context paramAnonymousContext)
      {
        AppMethodBeat.i(222692);
        ae.i("MicroMsg.NonSameLayer.AppBrandVideoNonSameLayerStrategy", "init, use ExoVideoViewWrapper");
        paramAnonymousContext = new c(paramAnonymousContext);
        AppMethodBeat.o(222692);
        return paramAnonymousContext;
      }
    });
    AppMethodBeat.o(222693);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.b
 * JD-Core Version:    0.7.0.1
 */
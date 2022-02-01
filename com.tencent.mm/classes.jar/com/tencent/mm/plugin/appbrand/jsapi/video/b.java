package com.tencent.mm.plugin.appbrand.jsapi.video;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.video.videoview.a.c;
import com.tencent.mm.sdk.platformtools.ac;

public final class b
{
  public static void init()
  {
    AppMethodBeat.i(186771);
    AppBrandVideoWrapper.setVideoViewFactory(new f()
    {
      public final e dx(Context paramAnonymousContext)
      {
        AppMethodBeat.i(186770);
        ac.i("MicroMsg.NonSameLayer.AppBrandVideoNonSameLayerStrategy", "init, use ExoVideoViewWrapper");
        paramAnonymousContext = new c(paramAnonymousContext);
        AppMethodBeat.o(186770);
        return paramAnonymousContext;
      }
    });
    AppMethodBeat.o(186771);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.b
 * JD-Core Version:    0.7.0.1
 */
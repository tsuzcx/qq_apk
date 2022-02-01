package com.tencent.mm.plugin.appbrand.jsapi.video;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.video.videoview.a.c;
import com.tencent.mm.sdk.platformtools.Log;

public final class b
{
  public static void init()
  {
    AppMethodBeat.i(227004);
    AppBrandVideoWrapper.setVideoViewFactory(new f()
    {
      public final e dU(Context paramAnonymousContext)
      {
        AppMethodBeat.i(227003);
        Log.i("MicroMsg.NonSameLayer.AppBrandVideoNonSameLayerStrategy", "init, use AppBrandExoVideoViewWrapper");
        paramAnonymousContext = new c(paramAnonymousContext, (byte)0);
        AppMethodBeat.o(227003);
        return paramAnonymousContext;
      }
      
      public final String getName()
      {
        return "Factory#AppBrandVideoNonSameLayerStrategy";
      }
    });
    AppMethodBeat.o(227004);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.b
 * JD-Core Version:    0.7.0.1
 */
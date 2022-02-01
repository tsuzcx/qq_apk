package com.tencent.mm.plugin.appbrand.jsapi.video;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.appbrand.ag.c.a.f;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.sdk.platformtools.Log;

public final class b
{
  public static void init()
  {
    AppMethodBeat.i(328224);
    AppBrandVideoWrapper.setVideoViewFactory(new e()
    {
      public final d V(Context paramAnonymousContext, int paramAnonymousInt)
      {
        AppMethodBeat.i(328614);
        com.tencent.mm.plugin.expt.b.c localc = (com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class);
        if (localc != null) {}
        for (boolean bool = localc.a(c.a.yPM, true);; bool = true)
        {
          Log.i("MicroMsg.SameLayer.AppBrandAVABTests", "canRewardVideoUseThumbPlayer, ".concat(String.valueOf(bool)));
          Log.i("MicroMsg.NonSameLayer.AppBrandVideoNonSameLayerStrategy", "createVideoView, playerHint: %d, canRewardVideoUseThumbPlayer: %b", new Object[] { Integer.valueOf(paramAnonymousInt), Boolean.valueOf(bool) });
          if (!bool)
          {
            Log.i("MicroMsg.NonSameLayer.AppBrandVideoNonSameLayerStrategy", "createVideoView, use AppBrandExoVideoViewWrapper");
            paramAnonymousContext = new com.tencent.mm.plugin.appbrand.jsapi.video.videoview.a.c(paramAnonymousContext, (byte)0);
            AppMethodBeat.o(328614);
            return paramAnonymousContext;
          }
          if ((paramAnonymousInt & 0x1) != 0)
          {
            if ((paramAnonymousInt & 0x2) != 0)
            {
              Log.i("MicroMsg.NonSameLayer.AppBrandVideoNonSameLayerStrategy", "createVideoView, use ThumbVideoViewWrapper");
              paramAnonymousContext = new f(paramAnonymousContext, (byte)0);
              AppMethodBeat.o(328614);
              return paramAnonymousContext;
            }
            Log.i("MicroMsg.NonSameLayer.AppBrandVideoNonSameLayerStrategy", "createVideoView, use AppBrandThumbVideoViewWrapper");
            paramAnonymousContext = new com.tencent.mm.plugin.appbrand.ag.c.a.c(paramAnonymousContext, (byte)0);
            AppMethodBeat.o(328614);
            return paramAnonymousContext;
          }
          paramAnonymousInt = com.tencent.mm.plugin.appbrand.utils.d.cNu();
          Log.i("MicroMsg.NonSameLayer.AppBrandVideoNonSameLayerStrategy", "createVideoView, playerType: ".concat(String.valueOf(paramAnonymousInt)));
          switch (paramAnonymousInt)
          {
          case 4: 
          default: 
            Log.i("MicroMsg.NonSameLayer.AppBrandVideoNonSameLayerStrategy", "createVideoView, use AppBrandExoVideoViewWrapper");
            paramAnonymousContext = new com.tencent.mm.plugin.appbrand.jsapi.video.videoview.a.c(paramAnonymousContext, (byte)0);
            AppMethodBeat.o(328614);
            return paramAnonymousContext;
          case 5: 
            Log.i("MicroMsg.NonSameLayer.AppBrandVideoNonSameLayerStrategy", "createVideoView, use AppBrandThumbVideoViewWrapper");
            paramAnonymousContext = new com.tencent.mm.plugin.appbrand.ag.c.a.c(paramAnonymousContext, (byte)0);
            AppMethodBeat.o(328614);
            return paramAnonymousContext;
          }
          Log.i("MicroMsg.NonSameLayer.AppBrandVideoNonSameLayerStrategy", "createVideoView, use SystemVideoViewWrapper");
          paramAnonymousContext = new com.tencent.mm.plugin.appbrand.jsapi.video.videoview.b.c(paramAnonymousContext);
          AppMethodBeat.o(328614);
          return paramAnonymousContext;
        }
      }
      
      public final String getName()
      {
        return "Factory#AppBrandVideoNonSameLayerStrategy";
      }
    });
    AppMethodBeat.o(328224);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.b
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.appbrand.jsapi.video;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.appbrand.ae.b.f;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.sdk.platformtools.Log;

public final class b
{
  public static void init()
  {
    AppMethodBeat.i(272889);
    AppBrandVideoWrapper.setVideoViewFactory(new e()
    {
      public final d Q(Context paramAnonymousContext, int paramAnonymousInt)
      {
        AppMethodBeat.i(270484);
        com.tencent.mm.plugin.expt.b.b localb = (com.tencent.mm.plugin.expt.b.b)h.ae(com.tencent.mm.plugin.expt.b.b.class);
        boolean bool;
        if (localb != null)
        {
          bool = localb.a(b.a.vBJ, true);
          Log.i("MicroMsg.SameLayer.AppBrandAVABTests", "canRewardVideoUseThumbPlayer, expt is ".concat(String.valueOf(bool)));
        }
        for (;;)
        {
          Log.i("MicroMsg.NonSameLayer.AppBrandVideoNonSameLayerStrategy", "createVideoView, playerHint: %d, canRewardVideoUseThumbPlayer: %b", new Object[] { Integer.valueOf(paramAnonymousInt), Boolean.valueOf(bool) });
          if (!bool)
          {
            Log.i("MicroMsg.NonSameLayer.AppBrandVideoNonSameLayerStrategy", "createVideoView, use AppBrandExoVideoViewWrapper");
            paramAnonymousContext = new com.tencent.mm.plugin.appbrand.jsapi.video.videoview.a.c(paramAnonymousContext, (byte)0);
            AppMethodBeat.o(270484);
            return paramAnonymousContext;
          }
          if ((paramAnonymousInt & 0x1) != 0)
          {
            if ((paramAnonymousInt & 0x2) != 0)
            {
              Log.i("MicroMsg.NonSameLayer.AppBrandVideoNonSameLayerStrategy", "createVideoView, use ThumbVideoViewWrapper");
              paramAnonymousContext = new f(paramAnonymousContext, (byte)0);
              AppMethodBeat.o(270484);
              return paramAnonymousContext;
            }
            Log.i("MicroMsg.NonSameLayer.AppBrandVideoNonSameLayerStrategy", "createVideoView, use AppBrandThumbVideoViewWrapper");
            paramAnonymousContext = new com.tencent.mm.plugin.appbrand.ae.b.c(paramAnonymousContext, (byte)0);
            AppMethodBeat.o(270484);
            return paramAnonymousContext;
          }
          paramAnonymousInt = com.tencent.mm.plugin.appbrand.utils.c.cmd();
          Log.i("MicroMsg.NonSameLayer.AppBrandVideoNonSameLayerStrategy", "createVideoView, playerType: ".concat(String.valueOf(paramAnonymousInt)));
          switch (paramAnonymousInt)
          {
          case 4: 
          default: 
            Log.i("MicroMsg.NonSameLayer.AppBrandVideoNonSameLayerStrategy", "createVideoView, use AppBrandExoVideoViewWrapper");
            paramAnonymousContext = new com.tencent.mm.plugin.appbrand.jsapi.video.videoview.a.c(paramAnonymousContext, (byte)0);
            AppMethodBeat.o(270484);
            return paramAnonymousContext;
          case 5: 
            Log.i("MicroMsg.NonSameLayer.AppBrandVideoNonSameLayerStrategy", "createVideoView, use AppBrandThumbVideoViewWrapper");
            paramAnonymousContext = new com.tencent.mm.plugin.appbrand.ae.b.c(paramAnonymousContext, (byte)0);
            AppMethodBeat.o(270484);
            return paramAnonymousContext;
          }
          Log.i("MicroMsg.NonSameLayer.AppBrandVideoNonSameLayerStrategy", "createVideoView, use SystemVideoViewWrapper");
          paramAnonymousContext = new com.tencent.mm.plugin.appbrand.jsapi.video.videoview.b.c(paramAnonymousContext);
          AppMethodBeat.o(270484);
          return paramAnonymousContext;
          bool = true;
        }
      }
      
      public final String getName()
      {
        return "Factory#AppBrandVideoNonSameLayerStrategy";
      }
    });
    AppMethodBeat.o(272889);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.b
 * JD-Core Version:    0.7.0.1
 */
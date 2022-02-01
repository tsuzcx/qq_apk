package com.tencent.mm.plugin.appbrand.xweb_ext.video;

import android.os.Handler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.c.q;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.g;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.j;
import com.tencent.mm.plugin.appbrand.utils.d;
import com.tencent.mm.plugin.expt.b.c;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public class e$a
  implements com.tencent.mm.plugin.appbrand.jsapi.al.e.h
{
  private static a uUF;
  
  public static a cTG()
  {
    AppMethodBeat.i(50048);
    if (uUF == null) {}
    try
    {
      if (uUF == null) {
        uUF = new a();
      }
      a locala = uUF;
      AppMethodBeat.o(50048);
      return locala;
    }
    finally
    {
      AppMethodBeat.o(50048);
    }
  }
  
  public final g a(com.tencent.luggage.xweb_ext.extendplugin.a parama, final Handler paramHandler)
  {
    int i = 15000;
    AppMethodBeat.i(317164);
    Object localObject2 = null;
    int j = d.cNu();
    Object localObject1 = localObject2;
    if (-1 != j) {
      localObject1 = localObject2;
    }
    label202:
    int k;
    switch (j)
    {
    default: 
      localObject1 = localObject2;
    case 4: 
      localObject2 = localObject1;
      if ((parama instanceof com.tencent.mm.plugin.appbrand.h.b))
      {
        parama = parama.aqX();
        localObject2 = localObject1;
        if (parama != null)
        {
          localObject2 = localObject1;
          if ("wxfe02ecfe70800f46".equalsIgnoreCase(parama.getAppId()))
          {
            if (com.tencent.mm.kernel.h.ax(c.class) != null)
            {
              i = ((c)com.tencent.mm.kernel.h.ax(c.class)).a(c.a.yPX, 15000);
              Log.i("MicroMsg.SameLayer.AppBrandAVABTests", "getXWebVideoWeishiMinBufferMS, expt is %s", new Object[] { Integer.valueOf(i) });
            }
            if (com.tencent.mm.kernel.h.ax(c.class) == null) {
              break label409;
            }
            j = ((c)com.tencent.mm.kernel.h.ax(c.class)).a(c.a.yPY, 30000);
            Log.i("MicroMsg.SameLayer.AppBrandAVABTests", "getXWebVideoWeishiMaxBufferMS, expt is %s", new Object[] { Integer.valueOf(j) });
            if (com.tencent.mm.kernel.h.ax(c.class) == null) {
              break label417;
            }
            k = ((c)com.tencent.mm.kernel.h.ax(c.class)).a(c.a.yPZ, 2500);
            Log.i("MicroMsg.SameLayer.AppBrandAVABTests", "getXWebVideoWeishiBufferForPlaybackMS, expt is %s", new Object[] { Integer.valueOf(k) });
          }
        }
      }
      break;
    }
    for (;;)
    {
      Log.i("MicroMsg.SameLayer.AppBrandXWebVideoStrategy", "createMediaPlayer, weishi use weishi exo media player, minBufferMs:%s, maxBufferMs:%s, bufferForPlaybackMs:%s", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k) });
      localObject2 = new q(paramHandler, i, j, k);
      parama = (com.tencent.luggage.xweb_ext.extendplugin.a)localObject2;
      if (localObject2 == null) {
        parama = new com.tencent.mm.plugin.appbrand.ag.b.a(new kotlin.g.a.a()new kotlin.g.a.a {}, new kotlin.g.a.a() {});
      }
      AppMethodBeat.o(317164);
      return parama;
      Log.i("MicroMsg.SameLayer.AppBrandXWebVideoStrategy", "createMediaPlayer, use MediaPlayer");
      localObject1 = new j();
      break;
      Log.i("MicroMsg.SameLayer.AppBrandXWebVideoStrategy", "createMediaPlayer, use AppBrandThumbMediaPlayer");
      localObject2 = com.tencent.mm.plugin.appbrand.ag.c.b.b(MMApplicationContext.getContext(), paramHandler.getLooper());
      localObject1 = localObject2;
      if (localObject2 != null) {
        break;
      }
      Log.i("MicroMsg.SameLayer.AppBrandXWebVideoStrategy", "createMediaPlayer, use SystemMediaPlayer fallback");
      parama = new j();
      AppMethodBeat.o(317164);
      return parama;
      label409:
      j = 30000;
      break label202;
      label417:
      k = 2500;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.xweb_ext.video.e.a
 * JD-Core Version:    0.7.0.1
 */
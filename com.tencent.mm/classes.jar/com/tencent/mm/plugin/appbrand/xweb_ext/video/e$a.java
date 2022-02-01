package com.tencent.mm.plugin.appbrand.xweb_ext.video;

import android.os.Handler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.b.l;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.i;
import com.tencent.mm.plugin.appbrand.utils.c;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public class e$a
  implements com.tencent.mm.plugin.appbrand.jsapi.ai.e.h
{
  private static a rJp;
  
  public static a cqZ()
  {
    AppMethodBeat.i(50048);
    if (rJp == null) {}
    try
    {
      if (rJp == null) {
        rJp = new a();
      }
      a locala = rJp;
      AppMethodBeat.o(50048);
      return locala;
    }
    finally
    {
      AppMethodBeat.o(50048);
    }
  }
  
  public final com.tencent.mm.plugin.appbrand.jsapi.video.e.e a(com.tencent.luggage.xweb_ext.extendplugin.a parama, Handler paramHandler)
  {
    int n = 30000;
    int i1 = 15000;
    int m = 2500;
    AppMethodBeat.i(282432);
    Object localObject2 = null;
    int i = c.cmd();
    Object localObject1 = localObject2;
    if (-1 != i) {
      localObject1 = localObject2;
    }
    label162:
    int j;
    label210:
    int k;
    switch (i)
    {
    default: 
      localObject1 = localObject2;
    case 4: 
      localObject2 = localObject1;
      if ((parama instanceof com.tencent.mm.plugin.appbrand.h.b))
      {
        parama = parama.QK();
        localObject2 = localObject1;
        if (parama != null)
        {
          localObject2 = localObject1;
          if ("wxfe02ecfe70800f46".equalsIgnoreCase(parama.getAppId()))
          {
            if (com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class) == null) {
              break label564;
            }
            i = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vBQ, 15000);
            Log.i("MicroMsg.SameLayer.AppBrandAVABTests", "getXWebVideoWeishiMinBufferMS, expt is %s", new Object[] { Integer.valueOf(i) });
            if (com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class) == null) {
              break label571;
            }
            j = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vBR, 30000);
            Log.i("MicroMsg.SameLayer.AppBrandAVABTests", "getXWebVideoWeishiMaxBufferMS, expt is %s", new Object[] { Integer.valueOf(j) });
            if (com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class) == null) {
              break label579;
            }
            k = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vBS, 2500);
            Log.i("MicroMsg.SameLayer.AppBrandAVABTests", "getXWebVideoWeishiBufferForPlaybackMS, expt is %s", new Object[] { Integer.valueOf(k) });
          }
        }
      }
      break;
    }
    for (;;)
    {
      Log.i("MicroMsg.SameLayer.AppBrandXWebVideoStrategy", "createMediaPlayer, weishi use weishi exo media player, minBufferMs:%s, maxBufferMs:%s, bufferForPlaybackMs:%s", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k) });
      localObject2 = new l(paramHandler, i, j, k);
      parama = (com.tencent.luggage.xweb_ext.extendplugin.a)localObject2;
      if (localObject2 == null)
      {
        i = i1;
        if (com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class) != null)
        {
          i = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vBN, 15000);
          Log.i("MicroMsg.SameLayer.AppBrandAVABTests", "getXWebVideoMinBufferDuration, expt is %s", new Object[] { Integer.valueOf(i) });
        }
        j = n;
        if (com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class) != null)
        {
          j = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vBO, 30000);
          Log.i("MicroMsg.SameLayer.AppBrandAVABTests", "getXWebVideoMaxBufferMS, expt is %s", new Object[] { Integer.valueOf(j) });
        }
        k = m;
        if (com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class) != null)
        {
          k = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vBP, 2500);
          Log.i("MicroMsg.SameLayer.AppBrandAVABTests", "getXWebVideoBufferForPlaybackMS, expt is %s", new Object[] { Integer.valueOf(k) });
        }
        Log.i("MicroMsg.SameLayer.AppBrandXWebVideoStrategy", "createMediaPlayer, use exo media player, minBufferMs:%s, maxBufferMs:%s, bufferForPlaybackMs:%s", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k) });
        parama = new com.tencent.mm.plugin.appbrand.jsapi.video.e.b.a(paramHandler, i, j, k);
      }
      AppMethodBeat.o(282432);
      return parama;
      Log.i("MicroMsg.SameLayer.AppBrandXWebVideoStrategy", "createMediaPlayer, use MediaPlayer");
      localObject1 = new i();
      break;
      Log.i("MicroMsg.SameLayer.AppBrandXWebVideoStrategy", "createMediaPlayer, use AppBrandThumbMediaPlayer");
      localObject1 = new com.tencent.mm.plugin.appbrand.ae.a(MMApplicationContext.getContext());
      break;
      label564:
      i = 15000;
      break label162;
      label571:
      j = 30000;
      break label210;
      label579:
      k = 2500;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.xweb_ext.video.e.a
 * JD-Core Version:    0.7.0.1
 */
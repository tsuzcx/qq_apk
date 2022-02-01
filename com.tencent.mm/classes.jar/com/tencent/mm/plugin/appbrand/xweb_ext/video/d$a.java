package com.tencent.mm.plugin.appbrand.xweb_ext.video;

import android.os.Handler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.jsapi.ag.e.h;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.b.m;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.c;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.sdk.platformtools.Log;

public class d$a
  implements h
{
  private static a oHz;
  
  public static a cdQ()
  {
    AppMethodBeat.i(50048);
    if (oHz == null) {}
    try
    {
      if (oHz == null) {
        oHz = new a();
      }
      a locala = oHz;
      AppMethodBeat.o(50048);
      return locala;
    }
    finally
    {
      AppMethodBeat.o(50048);
    }
  }
  
  public final c a(com.tencent.luggage.xweb_ext.extendplugin.a parama, Handler paramHandler)
  {
    int n = 30000;
    int i1 = 15000;
    int m = 2500;
    AppMethodBeat.i(227870);
    Object localObject2 = null;
    Object localObject1 = localObject2;
    int i;
    int j;
    label161:
    int k;
    if ((parama instanceof com.tencent.mm.plugin.appbrand.h.b))
    {
      parama = parama.NN();
      localObject1 = localObject2;
      if (parama != null)
      {
        localObject1 = localObject2;
        if ("wxfe02ecfe70800f46".equalsIgnoreCase(parama.getAppId()))
        {
          if (g.af(com.tencent.mm.plugin.expt.b.b.class) == null) {
            break label474;
          }
          i = ((com.tencent.mm.plugin.expt.b.b)g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.rVv, 15000);
          Log.i("MicroMsg.SameLayer.AppBrandXWebVideoABTests", "getXWebVideoWeishiMinBufferMS, expt is %s", new Object[] { Integer.valueOf(i) });
          if (g.af(com.tencent.mm.plugin.expt.b.b.class) == null) {
            break label481;
          }
          j = ((com.tencent.mm.plugin.expt.b.b)g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.rVw, 30000);
          Log.i("MicroMsg.SameLayer.AppBrandXWebVideoABTests", "getXWebVideoWeishiMaxBufferMS, expt is %s", new Object[] { Integer.valueOf(j) });
          if (g.af(com.tencent.mm.plugin.expt.b.b.class) == null) {
            break label489;
          }
          k = ((com.tencent.mm.plugin.expt.b.b)g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.rVx, 2500);
          Log.i("MicroMsg.SameLayer.AppBrandXWebVideoABTests", "getXWebVideoWeishiBufferForPlaybackMS, expt is %s", new Object[] { Integer.valueOf(k) });
        }
      }
    }
    for (;;)
    {
      Log.i("MicroMsg.SameLayer.AppBrandXWebVideoStrategy", "createMediaPlayer, weishi use weishi exo media player, minBufferMs:%s, maxBufferMs:%s, bufferForPlaybackMs:%s", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k) });
      localObject1 = new m(paramHandler, i, j, k);
      parama = (com.tencent.luggage.xweb_ext.extendplugin.a)localObject1;
      if (localObject1 == null)
      {
        i = i1;
        if (g.af(com.tencent.mm.plugin.expt.b.b.class) != null)
        {
          i = ((com.tencent.mm.plugin.expt.b.b)g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.rVs, 15000);
          Log.i("MicroMsg.SameLayer.AppBrandXWebVideoABTests", "getXWebVideoMinBufferDuration, expt is %s", new Object[] { Integer.valueOf(i) });
        }
        j = n;
        if (g.af(com.tencent.mm.plugin.expt.b.b.class) != null)
        {
          j = ((com.tencent.mm.plugin.expt.b.b)g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.rVt, 30000);
          Log.i("MicroMsg.SameLayer.AppBrandXWebVideoABTests", "getXWebVideoMaxBufferMS, expt is %s", new Object[] { Integer.valueOf(j) });
        }
        k = m;
        if (g.af(com.tencent.mm.plugin.expt.b.b.class) != null)
        {
          k = ((com.tencent.mm.plugin.expt.b.b)g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.rVu, 2500);
          Log.i("MicroMsg.SameLayer.AppBrandXWebVideoABTests", "getXWebVideoBufferForPlaybackMS, expt is %s", new Object[] { Integer.valueOf(k) });
        }
        Log.i("MicroMsg.SameLayer.AppBrandXWebVideoStrategy", "createMediaPlayer, use exo media player, minBufferMs:%s, maxBufferMs:%s, bufferForPlaybackMs:%s", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k) });
        parama = new com.tencent.mm.plugin.appbrand.jsapi.video.e.b.a(paramHandler, i, j, k);
      }
      AppMethodBeat.o(227870);
      return parama;
      label474:
      i = 15000;
      break;
      label481:
      j = 30000;
      break label161;
      label489:
      k = 2500;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.xweb_ext.video.d.a
 * JD-Core Version:    0.7.0.1
 */
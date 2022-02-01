package com.tencent.mm.plugin.appbrand.xweb_ext.video;

import android.os.Handler;
import com.tencent.luggage.k.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.z.e.h;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.sdk.platformtools.ac;

public class d$a
  implements h
{
  private static a mQR;
  
  public static a bCn()
  {
    AppMethodBeat.i(50048);
    if (mQR == null) {}
    try
    {
      if (mQR == null) {
        mQR = new a();
      }
      a locala = mQR;
      AppMethodBeat.o(50048);
      return locala;
    }
    finally
    {
      AppMethodBeat.o(50048);
    }
  }
  
  public final com.tencent.mm.plugin.appbrand.jsapi.video.e.b a(a parama, Handler paramHandler)
  {
    int n = 30000;
    int i1 = 15000;
    int m = 2500;
    AppMethodBeat.i(187070);
    Object localObject2 = null;
    Object localObject1 = localObject2;
    int i;
    int j;
    label161:
    int k;
    if ((parama instanceof com.tencent.mm.plugin.appbrand.i.b))
    {
      parama = parama.CM();
      localObject1 = localObject2;
      if (parama != null)
      {
        localObject1 = localObject2;
        if ("wxfe02ecfe70800f46".equalsIgnoreCase(parama.getAppId()))
        {
          if (com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class) == null) {
            break label474;
          }
          i = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pRl, 15000);
          ac.i("MicroMsg.SameLayer.AppBrandXWebVideoABTests", "getXWebVideoWeishiMinBufferMS, expt is %s", new Object[] { Integer.valueOf(i) });
          if (com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class) == null) {
            break label481;
          }
          j = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pRm, 30000);
          ac.i("MicroMsg.SameLayer.AppBrandXWebVideoABTests", "getXWebVideoWeishiMaxBufferMS, expt is %s", new Object[] { Integer.valueOf(j) });
          if (com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class) == null) {
            break label489;
          }
          k = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pRn, 2500);
          ac.i("MicroMsg.SameLayer.AppBrandXWebVideoABTests", "getXWebVideoWeishiBufferForPlaybackMS, expt is %s", new Object[] { Integer.valueOf(k) });
        }
      }
    }
    for (;;)
    {
      ac.i("MicroMsg.SameLayer.AppBrandXWebVideoStrategy", "createMediaPlayer, weishi use weishi exo media player, minBufferMs:%s, maxBufferMs:%s, bufferForPlaybackMs:%s", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k) });
      localObject1 = new com.tencent.mm.plugin.appbrand.jsapi.video.e.a.g(paramHandler, i, j, k);
      parama = (a)localObject1;
      if (localObject1 == null)
      {
        i = i1;
        if (com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class) != null)
        {
          i = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pRi, 15000);
          ac.i("MicroMsg.SameLayer.AppBrandXWebVideoABTests", "getXWebVideoMinBufferDuration, expt is %s", new Object[] { Integer.valueOf(i) });
        }
        j = n;
        if (com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class) != null)
        {
          j = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pRj, 30000);
          ac.i("MicroMsg.SameLayer.AppBrandXWebVideoABTests", "getXWebVideoMaxBufferMS, expt is %s", new Object[] { Integer.valueOf(j) });
        }
        k = m;
        if (com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class) != null)
        {
          k = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pRk, 2500);
          ac.i("MicroMsg.SameLayer.AppBrandXWebVideoABTests", "getXWebVideoBufferForPlaybackMS, expt is %s", new Object[] { Integer.valueOf(k) });
        }
        ac.i("MicroMsg.SameLayer.AppBrandXWebVideoStrategy", "createMediaPlayer, use exo media player, minBufferMs:%s, maxBufferMs:%s, bufferForPlaybackMs:%s", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k) });
        parama = new com.tencent.mm.plugin.appbrand.jsapi.video.e.a.c(paramHandler, i, j, k);
      }
      AppMethodBeat.o(187070);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.xweb_ext.video.d.a
 * JD-Core Version:    0.7.0.1
 */
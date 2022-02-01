package com.tencent.mm.plugin.appbrand.pip;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.lp;
import com.tencent.mm.plugin.appbrand.jsapi.s.b.a;
import com.tencent.mm.sdk.platformtools.Log;

public enum g
  implements d
{
  static
  {
    AppMethodBeat.i(227361);
    nDK = new g("INSTANCE");
    nDL = new g[] { nDK };
    AppMethodBeat.o(227361);
  }
  
  private g() {}
  
  private static lp a(c paramc)
  {
    AppMethodBeat.i(227360);
    paramc = new lp().yW(paramc.appId).yX(paramc.dCx).yY(paramc.videoUrl);
    AppMethodBeat.o(227360);
    return paramc;
  }
  
  public final void a(c paramc, b.a parama)
  {
    int i = 1;
    AppMethodBeat.i(227357);
    Log.d("MicroMsg.AppBrand.AppBrandPipReporter", "onVideoSupportPip, baseInfo: %s, mode: %s", new Object[] { paramc, parama });
    paramc = a(paramc);
    paramc.eZk = 1L;
    switch (1.nDM[parama.ordinal()])
    {
    default: 
      i = 0;
    }
    for (;;)
    {
      paramc.eZl = i;
      paramc.bfK();
      AppMethodBeat.o(227357);
      return;
      i = 2;
      continue;
      i = 3;
    }
  }
  
  public final void a(c paramc, e parame)
  {
    int j = 4;
    AppMethodBeat.i(227359);
    Log.d("MicroMsg.AppBrand.AppBrandPipReporter", "onPipHide, baseInfo: %s, hideReason: %s", new Object[] { paramc, parame });
    paramc = a(paramc);
    int i;
    switch (1.nDN[parame.ordinal()])
    {
    default: 
      i = 6;
      paramc.eZk = i;
      if (6 == i)
      {
        i = j;
        switch (1.nDN[parame.ordinal()])
        {
        default: 
          i = 0;
        }
      }
      break;
    }
    for (;;)
    {
      paramc.eZl = i;
      paramc.bfK();
      AppMethodBeat.o(227359);
      return;
      i = 4;
      break;
      i = 5;
      break;
      i = 1;
      continue;
      i = 2;
      continue;
      i = 3;
    }
  }
  
  public final void b(c paramc, b.a parama)
  {
    AppMethodBeat.i(227358);
    Log.d("MicroMsg.AppBrand.AppBrandPipReporter", "onPipShow, baseInfo: %s, mode: %s", new Object[] { paramc, parama });
    paramc = a(paramc);
    if (b.a.mnr == parama) {}
    for (long l = 2L;; l = 3L)
    {
      paramc.eZk = l;
      paramc.bfK();
      AppMethodBeat.o(227358);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.pip.g
 * JD-Core Version:    0.7.0.1
 */
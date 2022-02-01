package com.tencent.mm.plugin.appbrand.pip;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.gp;
import com.tencent.mm.plugin.appbrand.jsapi.n.b.a;
import com.tencent.mm.sdk.platformtools.ac;

public enum g
  implements d
{
  static
  {
    AppMethodBeat.i(186911);
    lOo = new g("INSTANCE");
    lOp = new g[] { lOo };
    AppMethodBeat.o(186911);
  }
  
  private g() {}
  
  private static gp a(c paramc)
  {
    AppMethodBeat.i(186910);
    paramc = new gp().nZ(paramc.appId).oa(paramc.cYQ).ob(paramc.videoUrl);
    AppMethodBeat.o(186910);
    return paramc;
  }
  
  public final void a(c paramc, b.a parama)
  {
    int i = 1;
    AppMethodBeat.i(186907);
    ac.d("MicroMsg.AppBrand.AppBrandPipReporter", "onVideoSupportPip, baseInfo: %s, mode: %s", new Object[] { paramc, parama });
    paramc = a(paramc);
    paramc.ecC = 1L;
    switch (1.lOq[parama.ordinal()])
    {
    default: 
      i = 0;
    }
    for (;;)
    {
      paramc.ecD = i;
      paramc.aHZ();
      AppMethodBeat.o(186907);
      return;
      i = 2;
      continue;
      i = 3;
    }
  }
  
  public final void a(c paramc, e parame)
  {
    int j = 4;
    AppMethodBeat.i(186909);
    ac.d("MicroMsg.AppBrand.AppBrandPipReporter", "onPipHide, baseInfo: %s, hideReason: %s", new Object[] { paramc, parame });
    paramc = a(paramc);
    int i;
    switch (1.lOr[parame.ordinal()])
    {
    default: 
      i = 6;
      paramc.ecC = i;
      if (6 == i)
      {
        i = j;
        switch (1.lOr[parame.ordinal()])
        {
        default: 
          i = 0;
        }
      }
      break;
    }
    for (;;)
    {
      paramc.ecD = i;
      paramc.aHZ();
      AppMethodBeat.o(186909);
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
    AppMethodBeat.i(186908);
    ac.d("MicroMsg.AppBrand.AppBrandPipReporter", "onPipShow, baseInfo: %s, mode: %s", new Object[] { paramc, parama });
    paramc = a(paramc);
    if (b.a.kHO == parama) {}
    for (long l = 2L;; l = 3L)
    {
      paramc.ecC = l;
      paramc.aHZ();
      AppMethodBeat.o(186908);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.pip.g
 * JD-Core Version:    0.7.0.1
 */
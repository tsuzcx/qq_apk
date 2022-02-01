package com.tencent.mm.plugin.appbrand.pip;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.hu;
import com.tencent.mm.plugin.appbrand.jsapi.q.b.a;
import com.tencent.mm.sdk.platformtools.ae;

public enum g
  implements d
{
  static
  {
    AppMethodBeat.i(222924);
    mtc = new g("INSTANCE");
    mtd = new g[] { mtc };
    AppMethodBeat.o(222924);
  }
  
  private g() {}
  
  private static hu a(c paramc)
  {
    AppMethodBeat.i(222923);
    paramc = new hu().qT(paramc.appId).qU(paramc.dlk).qV(paramc.videoUrl);
    AppMethodBeat.o(222923);
    return paramc;
  }
  
  public final void a(c paramc, b.a parama)
  {
    int i = 1;
    AppMethodBeat.i(222920);
    ae.d("MicroMsg.AppBrand.AppBrandPipReporter", "onVideoSupportPip, baseInfo: %s, mode: %s", new Object[] { paramc, parama });
    paramc = a(paramc);
    paramc.euO = 1L;
    switch (1.mte[parama.ordinal()])
    {
    default: 
      i = 0;
    }
    for (;;)
    {
      paramc.euP = i;
      paramc.aLH();
      AppMethodBeat.o(222920);
      return;
      i = 2;
      continue;
      i = 3;
    }
  }
  
  public final void a(c paramc, e parame)
  {
    int j = 4;
    AppMethodBeat.i(222922);
    ae.d("MicroMsg.AppBrand.AppBrandPipReporter", "onPipHide, baseInfo: %s, hideReason: %s", new Object[] { paramc, parame });
    paramc = a(paramc);
    int i;
    switch (1.mtf[parame.ordinal()])
    {
    default: 
      i = 6;
      paramc.euO = i;
      if (6 == i)
      {
        i = j;
        switch (1.mtf[parame.ordinal()])
        {
        default: 
          i = 0;
        }
      }
      break;
    }
    for (;;)
    {
      paramc.euP = i;
      paramc.aLH();
      AppMethodBeat.o(222922);
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
    AppMethodBeat.i(222921);
    ae.d("MicroMsg.AppBrand.AppBrandPipReporter", "onPipShow, baseInfo: %s, mode: %s", new Object[] { paramc, parama });
    paramc = a(paramc);
    if (b.a.lhT == parama) {}
    for (long l = 2L;; l = 3L)
    {
      paramc.euO = l;
      paramc.aLH();
      AppMethodBeat.o(222921);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.pip.g
 * JD-Core Version:    0.7.0.1
 */
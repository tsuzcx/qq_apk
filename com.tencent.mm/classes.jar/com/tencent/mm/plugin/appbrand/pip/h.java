package com.tencent.mm.plugin.appbrand.pip;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.mmdata.rpt.sg;
import com.tencent.mm.plugin.appbrand.jsapi.w.b.a;
import com.tencent.mm.sdk.platformtools.Log;

public enum h
  implements d
{
  static
  {
    AppMethodBeat.i(319645);
    tKL = new h("INSTANCE");
    tKM = new h[] { tKL };
    AppMethodBeat.o(319645);
  }
  
  private h() {}
  
  private static sg a(c paramc)
  {
    AppMethodBeat.i(319639);
    paramc = new sg().yT(paramc.appId).yU(paramc.hzy).yV(paramc.videoUrl);
    AppMethodBeat.o(319639);
    return paramc;
  }
  
  public final void a(c paramc, b.a parama)
  {
    int i = 1;
    AppMethodBeat.i(319649);
    Log.d("MicroMsg.AppBrand.AppBrandPipReporter", "onVideoSupportPip, baseInfo: %s, mode: %s", new Object[] { paramc, parama });
    paramc = a(paramc);
    paramc.jxP = 1L;
    switch (1.tKN[parama.ordinal()])
    {
    default: 
      i = 0;
    }
    for (;;)
    {
      paramc.jxQ = i;
      paramc.bMH();
      AppMethodBeat.o(319649);
      return;
      i = 2;
      continue;
      i = 3;
    }
  }
  
  public final void a(c paramc, f paramf)
  {
    int j = 4;
    AppMethodBeat.i(319661);
    Log.d("MicroMsg.AppBrand.AppBrandPipReporter", "onPipHide, baseInfo: %s, hideReason: %s", new Object[] { paramc, paramf });
    paramc = a(paramc);
    int i;
    switch (1.tKO[paramf.ordinal()])
    {
    default: 
      i = 6;
      paramc.jxP = i;
      if (6 == i)
      {
        i = j;
        switch (1.tKO[paramf.ordinal()])
        {
        default: 
          i = 0;
        }
      }
      break;
    }
    for (;;)
    {
      paramc.jxQ = i;
      paramc.bMH();
      AppMethodBeat.o(319661);
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
    AppMethodBeat.i(319656);
    Log.d("MicroMsg.AppBrand.AppBrandPipReporter", "onPipShow, baseInfo: %s, mode: %s", new Object[] { paramc, parama });
    paramc = a(paramc);
    if (b.a.sqz == parama) {}
    for (long l = 2L;; l = 3L)
    {
      paramc.jxP = l;
      paramc.bMH();
      AppMethodBeat.o(319656);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.pip.h
 * JD-Core Version:    0.7.0.1
 */
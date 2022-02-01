package com.tencent.mm.plugin.appbrand.pip;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.b.a.on;
import com.tencent.mm.plugin.appbrand.jsapi.t.b.a;
import com.tencent.mm.sdk.platformtools.Log;

public enum g
  implements d
{
  static
  {
    AppMethodBeat.i(279863);
    qFV = new g("INSTANCE");
    qFW = new g[] { qFV };
    AppMethodBeat.o(279863);
  }
  
  private g() {}
  
  private static on a(c paramc)
  {
    AppMethodBeat.i(279861);
    paramc = new on().FC(paramc.appId).FD(paramc.fve).FE(paramc.videoUrl);
    AppMethodBeat.o(279861);
    return paramc;
  }
  
  public final void a(c paramc, b.a parama)
  {
    int i = 1;
    AppMethodBeat.i(279858);
    Log.d("MicroMsg.AppBrand.AppBrandPipReporter", "onVideoSupportPip, baseInfo: %s, mode: %s", new Object[] { paramc, parama });
    paramc = a(paramc);
    paramc.hcb = 1L;
    switch (1.qFX[parama.ordinal()])
    {
    default: 
      i = 0;
    }
    for (;;)
    {
      paramc.hcc = i;
      paramc.bpa();
      AppMethodBeat.o(279858);
      return;
      i = 2;
      continue;
      i = 3;
    }
  }
  
  public final void a(c paramc, e parame)
  {
    int j = 4;
    AppMethodBeat.i(279860);
    Log.d("MicroMsg.AppBrand.AppBrandPipReporter", "onPipHide, baseInfo: %s, hideReason: %s", new Object[] { paramc, parame });
    paramc = a(paramc);
    int i;
    switch (1.qFY[parame.ordinal()])
    {
    default: 
      i = 6;
      paramc.hcb = i;
      if (6 == i)
      {
        i = j;
        switch (1.qFY[parame.ordinal()])
        {
        default: 
          i = 0;
        }
      }
      break;
    }
    for (;;)
    {
      paramc.hcc = i;
      paramc.bpa();
      AppMethodBeat.o(279860);
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
    AppMethodBeat.i(279859);
    Log.d("MicroMsg.AppBrand.AppBrandPipReporter", "onPipShow, baseInfo: %s, mode: %s", new Object[] { paramc, parama });
    paramc = a(paramc);
    if (b.a.plx == parama) {}
    for (long l = 2L;; l = 3L)
    {
      paramc.hcb = l;
      paramc.bpa();
      AppMethodBeat.o(279859);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.pip.g
 * JD-Core Version:    0.7.0.1
 */
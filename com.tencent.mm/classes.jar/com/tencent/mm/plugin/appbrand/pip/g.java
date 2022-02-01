package com.tencent.mm.plugin.appbrand.pip;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.hs;
import com.tencent.mm.plugin.appbrand.jsapi.q.b.a;
import com.tencent.mm.sdk.platformtools.ad;

public enum g
  implements d
{
  static
  {
    AppMethodBeat.i(188708);
    moe = new g("INSTANCE");
    mof = new g[] { moe };
    AppMethodBeat.o(188708);
  }
  
  private g() {}
  
  private static hs a(c paramc)
  {
    AppMethodBeat.i(188707);
    paramc = new hs().qy(paramc.appId).qz(paramc.dki).qA(paramc.videoUrl);
    AppMethodBeat.o(188707);
    return paramc;
  }
  
  public final void a(c paramc, b.a parama)
  {
    int i = 1;
    AppMethodBeat.i(188704);
    ad.d("MicroMsg.AppBrand.AppBrandPipReporter", "onVideoSupportPip, baseInfo: %s, mode: %s", new Object[] { paramc, parama });
    paramc = a(paramc);
    paramc.eth = 1L;
    switch (1.mog[parama.ordinal()])
    {
    default: 
      i = 0;
    }
    for (;;)
    {
      paramc.eti = i;
      paramc.aLk();
      AppMethodBeat.o(188704);
      return;
      i = 2;
      continue;
      i = 3;
    }
  }
  
  public final void a(c paramc, e parame)
  {
    int j = 4;
    AppMethodBeat.i(188706);
    ad.d("MicroMsg.AppBrand.AppBrandPipReporter", "onPipHide, baseInfo: %s, hideReason: %s", new Object[] { paramc, parame });
    paramc = a(paramc);
    int i;
    switch (1.moh[parame.ordinal()])
    {
    default: 
      i = 6;
      paramc.eth = i;
      if (6 == i)
      {
        i = j;
        switch (1.moh[parame.ordinal()])
        {
        default: 
          i = 0;
        }
      }
      break;
    }
    for (;;)
    {
      paramc.eti = i;
      paramc.aLk();
      AppMethodBeat.o(188706);
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
    AppMethodBeat.i(188705);
    ad.d("MicroMsg.AppBrand.AppBrandPipReporter", "onPipShow, baseInfo: %s, mode: %s", new Object[] { paramc, parama });
    paramc = a(paramc);
    if (b.a.leh == parama) {}
    for (long l = 2L;; l = 3L)
    {
      paramc.eth = l;
      paramc.aLk();
      AppMethodBeat.o(188705);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.pip.g
 * JD-Core Version:    0.7.0.1
 */
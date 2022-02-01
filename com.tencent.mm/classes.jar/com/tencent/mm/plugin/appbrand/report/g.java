package com.tencent.mm.plugin.appbrand.report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.ex;
import com.tencent.mm.plugin.appbrand.jsapi.o.b.a;
import com.tencent.mm.plugin.appbrand.page.ag;
import com.tencent.mm.plugin.appbrand.page.ah;
import com.tencent.mm.plugin.appbrand.page.ai;
import com.tencent.mm.sdk.platformtools.ad;

public enum g
  implements ah
{
  static
  {
    AppMethodBeat.i(175058);
    lpr = new g("INSTANCE");
    lps = new g[] { lpr };
    AppMethodBeat.o(175058);
  }
  
  private g() {}
  
  private static ex a(ag paramag)
  {
    AppMethodBeat.i(175057);
    paramag = new ex().kU(paramag.appId).kV(paramag.dbu).kW(paramag.videoUrl);
    AppMethodBeat.o(175057);
    return paramag;
  }
  
  public final void a(ag paramag, b.a parama)
  {
    int i = 1;
    AppMethodBeat.i(175054);
    ad.d("MicroMsg.AppBrand.AppBrandPipReporter", "onVideoSupportPip, baseInfo: %s, mode: %s", new Object[] { paramag, parama });
    paramag = a(paramag);
    paramag.eaw = 1L;
    switch (1.lpt[parama.ordinal()])
    {
    default: 
      i = 0;
    }
    for (;;)
    {
      paramag.eax = i;
      paramag.aBj();
      AppMethodBeat.o(175054);
      return;
      i = 2;
      continue;
      i = 3;
    }
  }
  
  public final void a(ag paramag, ai paramai)
  {
    int j = 4;
    AppMethodBeat.i(175056);
    ad.d("MicroMsg.AppBrand.AppBrandPipReporter", "onPipHide, baseInfo: %s, hideReason: %s", new Object[] { paramag, paramai });
    paramag = a(paramag);
    int i;
    switch (1.lpu[paramai.ordinal()])
    {
    default: 
      i = 6;
      paramag.eaw = i;
      if (6 == i)
      {
        i = j;
        switch (1.lpu[paramai.ordinal()])
        {
        default: 
          i = 0;
        }
      }
      break;
    }
    for (;;)
    {
      paramag.eax = i;
      paramag.aBj();
      AppMethodBeat.o(175056);
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
  
  public final void b(ag paramag, b.a parama)
  {
    AppMethodBeat.i(175055);
    ad.d("MicroMsg.AppBrand.AppBrandPipReporter", "onPipShow, baseInfo: %s, mode: %s", new Object[] { paramag, parama });
    paramag = a(paramag);
    if (b.a.kgY == parama) {}
    for (long l = 2L;; l = 3L)
    {
      paramag.eaw = l;
      paramag.aBj();
      AppMethodBeat.o(175055);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.g
 * JD-Core Version:    0.7.0.1
 */
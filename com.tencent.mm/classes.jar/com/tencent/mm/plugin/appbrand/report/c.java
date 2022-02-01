package com.tencent.mm.plugin.appbrand.report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.service.n;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public final class c
  implements n
{
  public final String chm()
  {
    AppMethodBeat.i(268100);
    String str = j.getNetworkType(MMApplicationContext.getContext());
    AppMethodBeat.o(268100);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.c
 * JD-Core Version:    0.7.0.1
 */
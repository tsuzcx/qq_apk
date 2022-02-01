package com.tencent.mm.plugin.appbrand.report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.service.p;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public final class c
  implements p
{
  public final String getNetworkType()
  {
    AppMethodBeat.i(321383);
    String str = j.getNetworkType(MMApplicationContext.getContext());
    AppMethodBeat.o(321383);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.c
 * JD-Core Version:    0.7.0.1
 */
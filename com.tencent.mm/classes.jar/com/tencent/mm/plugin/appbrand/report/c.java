package com.tencent.mm.plugin.appbrand.report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.service.n;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public final class c
  implements n
{
  public final String bUg()
  {
    AppMethodBeat.i(227364);
    String str = i.getNetworkType(MMApplicationContext.getContext());
    AppMethodBeat.o(227364);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.c
 * JD-Core Version:    0.7.0.1
 */
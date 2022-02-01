package com.tencent.mm.plugin.appbrand.report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.service.l;
import com.tencent.mm.sdk.platformtools.aj;

public final class c
  implements l
{
  public final String bxa()
  {
    AppMethodBeat.i(188710);
    String str = h.getNetworkType(aj.getContext());
    AppMethodBeat.o(188710);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.c
 * JD-Core Version:    0.7.0.1
 */
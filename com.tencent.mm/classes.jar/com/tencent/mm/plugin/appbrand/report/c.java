package com.tencent.mm.plugin.appbrand.report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.service.l;
import com.tencent.mm.sdk.platformtools.ak;

public final class c
  implements l
{
  public final String bxT()
  {
    AppMethodBeat.i(222926);
    String str = h.getNetworkType(ak.getContext());
    AppMethodBeat.o(222926);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.c
 * JD-Core Version:    0.7.0.1
 */
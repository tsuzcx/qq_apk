package com.tencent.mm.plugin.appbrand.jsapi.nfc.hce.a;

import com.tencent.luggage.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.s.b;
import com.tencent.mm.sdk.platformtools.ae;

public final class c
{
  public static void O(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(136184);
    ae.i("MicroMsg.HCEReportManager", "alvinluo reportStartHCEResult appId: %s, result: %d, diff: %d", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    ((b)e.L(b.class)).f(14837, new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    AppMethodBeat.o(136184);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.nfc.hce.a.c
 * JD-Core Version:    0.7.0.1
 */
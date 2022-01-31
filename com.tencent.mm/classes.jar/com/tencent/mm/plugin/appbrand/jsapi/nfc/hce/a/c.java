package com.tencent.mm.plugin.appbrand.jsapi.nfc.hce.a;

import com.tencent.luggage.b.e;
import com.tencent.mm.plugin.appbrand.p.b;
import com.tencent.mm.sdk.platformtools.y;

public final class c
{
  public static void E(String paramString, int paramInt1, int paramInt2)
  {
    y.i("MicroMsg.HCEReportManager", "alvinluo reportStartHCEResult appId: %s, result: %d, diff: %d", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    ((b)e.j(b.class)).f(14837, new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.nfc.hce.a.c
 * JD-Core Version:    0.7.0.1
 */
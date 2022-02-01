package com.tencent.mm.plugin.appbrand.report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.debugger.n;
import com.tencent.mm.plugin.appbrand.jsruntime.i;
import com.tencent.mm.plugin.appbrand.jsruntime.x;
import com.tencent.mm.plugin.appbrand.page.aw;
import com.tencent.mm.plugin.appbrand.page.bd;
import com.tencent.mm.sdk.platformtools.h;
import com.tencent.xweb.WebView;

public enum c
{
  public static final c[] lpf;
  
  static
  {
    AppMethodBeat.i(48043);
    loV = new c("X5", 0);
    loW = new c("MMV8", 1);
    loX = new c("WebViewBased", 2);
    loY = new c("NativeScript", 3);
    loZ = new c("NodeJS", 4);
    lpa = new c("J2V8", 5);
    lpb = new c("WebViewX5", 6);
    lpc = new c("WebViewXW", 7);
    lpd = new c("WebViewSystem", 8);
    lpe = new c("Invalid", 9);
    lpg = new c[] { loV, loW, loX, loY, loZ, lpa, lpb, lpc, lpd, lpe };
    lpf = new c[] { loW, lpa, loZ };
    AppMethodBeat.o(48043);
  }
  
  private c() {}
  
  public static c d(i parami)
  {
    AppMethodBeat.i(48041);
    if ((parami instanceof com.tencent.mm.plugin.appbrand.jsruntime.c))
    {
      parami = lpa;
      AppMethodBeat.o(48041);
      return parami;
    }
    if ((parami instanceof x))
    {
      parami = loZ;
      AppMethodBeat.o(48041);
      return parami;
    }
    if ((parami instanceof n))
    {
      parami = lpe;
      AppMethodBeat.o(48041);
      return parami;
    }
    if ((parami instanceof bd))
    {
      if (!(parami instanceof aw)) {
        break label221;
      }
      parami = ((aw)parami).leN;
    }
    label221:
    for (;;)
    {
      if ((parami instanceof WebView))
      {
        parami = (WebView)parami;
        if (parami.isSysKernel())
        {
          parami = lpd;
          AppMethodBeat.o(48041);
          return parami;
        }
        if (parami.isXWalkKernel())
        {
          parami = lpc;
          AppMethodBeat.o(48041);
          return parami;
        }
        if (parami.getX5WebViewExtension() != null)
        {
          parami = lpb;
          AppMethodBeat.o(48041);
          return parami;
        }
      }
      parami = lpe;
      AppMethodBeat.o(48041);
      return parami;
      if (h.DEBUG)
      {
        if (parami == null) {}
        for (parami = "null";; parami = parami.getClass().getSimpleName())
        {
          parami = new IllegalStateException(String.format("Unrecognized JsRuntime %s", new Object[] { parami }));
          AppMethodBeat.o(48041);
          throw parami;
        }
      }
      parami = lpe;
      AppMethodBeat.o(48041);
      return parami;
    }
  }
  
  public static String e(i parami)
  {
    AppMethodBeat.i(48042);
    String str2 = d(parami).name();
    String str1 = str2;
    if ((parami instanceof n)) {
      str1 = str2 + "(remote_debug)";
    }
    AppMethodBeat.o(48042);
    return str1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.c
 * JD-Core Version:    0.7.0.1
 */
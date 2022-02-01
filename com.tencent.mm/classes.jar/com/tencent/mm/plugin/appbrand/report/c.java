package com.tencent.mm.plugin.appbrand.report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.debugger.n;
import com.tencent.mm.plugin.appbrand.jsruntime.i;
import com.tencent.mm.plugin.appbrand.jsruntime.x;
import com.tencent.mm.plugin.appbrand.page.ar;
import com.tencent.mm.plugin.appbrand.page.ay;
import com.tencent.mm.sdk.platformtools.h;
import com.tencent.xweb.WebView;

public enum c
{
  public static final c[] lRf;
  
  static
  {
    AppMethodBeat.i(48043);
    lQV = new c("X5", 0);
    lQW = new c("MMV8", 1);
    lQX = new c("WebViewBased", 2);
    lQY = new c("NativeScript", 3);
    lQZ = new c("NodeJS", 4);
    lRa = new c("J2V8", 5);
    lRb = new c("WebViewX5", 6);
    lRc = new c("WebViewXW", 7);
    lRd = new c("WebViewSystem", 8);
    lRe = new c("Invalid", 9);
    lRg = new c[] { lQV, lQW, lQX, lQY, lQZ, lRa, lRb, lRc, lRd, lRe };
    lRf = new c[] { lQW, lRa, lQZ };
    AppMethodBeat.o(48043);
  }
  
  private c() {}
  
  public static c d(i parami)
  {
    AppMethodBeat.i(48041);
    if ((parami instanceof com.tencent.mm.plugin.appbrand.jsruntime.c))
    {
      parami = lRa;
      AppMethodBeat.o(48041);
      return parami;
    }
    if ((parami instanceof x))
    {
      parami = lQZ;
      AppMethodBeat.o(48041);
      return parami;
    }
    if ((parami instanceof n))
    {
      parami = lRe;
      AppMethodBeat.o(48041);
      return parami;
    }
    if ((parami instanceof ay))
    {
      if (!(parami instanceof ar)) {
        break label221;
      }
      parami = ((ar)parami).lED;
    }
    label221:
    for (;;)
    {
      if ((parami instanceof WebView))
      {
        parami = (WebView)parami;
        if (parami.isSysKernel())
        {
          parami = lRd;
          AppMethodBeat.o(48041);
          return parami;
        }
        if (parami.isXWalkKernel())
        {
          parami = lRc;
          AppMethodBeat.o(48041);
          return parami;
        }
        if (parami.getX5WebViewExtension() != null)
        {
          parami = lRb;
          AppMethodBeat.o(48041);
          return parami;
        }
      }
      parami = lRe;
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
      parami = lRe;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.c
 * JD-Core Version:    0.7.0.1
 */
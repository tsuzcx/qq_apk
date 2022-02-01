package com.tencent.mm.plugin.appbrand.report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.debugger.q;
import com.tencent.mm.plugin.appbrand.m.c;
import com.tencent.mm.plugin.appbrand.m.i;
import com.tencent.mm.plugin.appbrand.m.x;
import com.tencent.mm.plugin.appbrand.page.av;
import com.tencent.mm.plugin.appbrand.page.bd;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.xweb.WebView;

public enum e
{
  public static final e[] qJc;
  
  static
  {
    AppMethodBeat.i(48043);
    qIS = new e("X5", 0);
    qIT = new e("MMV8", 1);
    qIU = new e("WebViewBased", 2);
    qIV = new e("NativeScript", 3);
    qIW = new e("NodeJS", 4);
    qIX = new e("J2V8", 5);
    qIY = new e("WebViewX5", 6);
    qIZ = new e("WebViewXW", 7);
    qJa = new e("WebViewSystem", 8);
    qJb = new e("Invalid", 9);
    qJd = new e[] { qIS, qIT, qIU, qIV, qIW, qIX, qIY, qIZ, qJa, qJb };
    qJc = new e[] { qIT, qIX, qIW };
    AppMethodBeat.o(48043);
  }
  
  private e() {}
  
  public static e f(i parami)
  {
    AppMethodBeat.i(48041);
    if ((parami instanceof c))
    {
      parami = qIX;
      AppMethodBeat.o(48041);
      return parami;
    }
    if ((parami instanceof x))
    {
      parami = qIW;
      AppMethodBeat.o(48041);
      return parami;
    }
    if ((parami instanceof q))
    {
      parami = qJb;
      AppMethodBeat.o(48041);
      return parami;
    }
    if ((parami instanceof bd))
    {
      if (!(parami instanceof av)) {
        break label221;
      }
      parami = ((av)parami).quO;
    }
    label221:
    for (;;)
    {
      if ((parami instanceof WebView))
      {
        parami = (WebView)parami;
        if (parami.isSysKernel())
        {
          parami = qJa;
          AppMethodBeat.o(48041);
          return parami;
        }
        if (parami.isXWalkKernel())
        {
          parami = qIZ;
          AppMethodBeat.o(48041);
          return parami;
        }
        if (parami.getX5WebViewExtension() != null)
        {
          parami = qIY;
          AppMethodBeat.o(48041);
          return parami;
        }
      }
      parami = qJb;
      AppMethodBeat.o(48041);
      return parami;
      if (BuildInfo.DEBUG)
      {
        if (parami == null) {}
        for (parami = "null";; parami = parami.getClass().getSimpleName())
        {
          parami = new IllegalStateException(String.format("Unrecognized JsRuntime %s", new Object[] { parami }));
          AppMethodBeat.o(48041);
          throw parami;
        }
      }
      parami = qJb;
      AppMethodBeat.o(48041);
      return parami;
    }
  }
  
  public static String g(i parami)
  {
    AppMethodBeat.i(48042);
    String str2 = f(parami).name();
    String str1 = str2;
    if ((parami instanceof q)) {
      str1 = str2 + "(remote_debug)";
    }
    AppMethodBeat.o(48042);
    return str1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.e
 * JD-Core Version:    0.7.0.1
 */
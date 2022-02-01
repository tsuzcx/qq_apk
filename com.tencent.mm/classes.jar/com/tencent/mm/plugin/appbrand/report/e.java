package com.tencent.mm.plugin.appbrand.report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.debugger.q;
import com.tencent.mm.plugin.appbrand.n.c;
import com.tencent.mm.plugin.appbrand.n.i;
import com.tencent.mm.plugin.appbrand.n.x;
import com.tencent.mm.plugin.appbrand.page.av;
import com.tencent.mm.plugin.appbrand.page.bd;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.xweb.WebView;

public enum e
{
  public static final e[] tNF;
  
  static
  {
    AppMethodBeat.i(48043);
    tNv = new e("X5", 0);
    tNw = new e("MMV8", 1);
    tNx = new e("WebViewBased", 2);
    tNy = new e("NativeScript", 3);
    tNz = new e("NodeJS", 4);
    tNA = new e("J2V8", 5);
    tNB = new e("WebViewX5", 6);
    tNC = new e("WebViewXW", 7);
    tND = new e("WebViewSystem", 8);
    tNE = new e("Invalid", 9);
    tNG = new e[] { tNv, tNw, tNx, tNy, tNz, tNA, tNB, tNC, tND, tNE };
    tNF = new e[] { tNw, tNA, tNz };
    AppMethodBeat.o(48043);
  }
  
  private e() {}
  
  public static e f(i parami)
  {
    AppMethodBeat.i(48041);
    if ((parami instanceof c))
    {
      parami = tNA;
      AppMethodBeat.o(48041);
      return parami;
    }
    if ((parami instanceof x))
    {
      parami = tNz;
      AppMethodBeat.o(48041);
      return parami;
    }
    if ((parami instanceof q))
    {
      parami = tNE;
      AppMethodBeat.o(48041);
      return parami;
    }
    if ((parami instanceof bd))
    {
      if (!(parami instanceof av)) {
        break label221;
      }
      parami = ((av)parami).tzF;
    }
    label221:
    for (;;)
    {
      if ((parami instanceof WebView))
      {
        parami = (WebView)parami;
        if (parami.isSysKernel())
        {
          parami = tND;
          AppMethodBeat.o(48041);
          return parami;
        }
        if (parami.isXWalkKernel())
        {
          parami = tNC;
          AppMethodBeat.o(48041);
          return parami;
        }
        if (parami.getX5WebViewExtension() != null)
        {
          parami = tNB;
          AppMethodBeat.o(48041);
          return parami;
        }
      }
      parami = tNE;
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
      parami = tNE;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.e
 * JD-Core Version:    0.7.0.1
 */
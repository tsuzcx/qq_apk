package com.tencent.mm.plugin.appbrand.report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.debugger.o;
import com.tencent.mm.plugin.appbrand.m.c;
import com.tencent.mm.plugin.appbrand.m.i;
import com.tencent.mm.plugin.appbrand.m.x;
import com.tencent.mm.plugin.appbrand.page.at;
import com.tencent.mm.plugin.appbrand.page.bb;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.xweb.WebView;

public enum e
{
  public static final e[] nGR;
  
  static
  {
    AppMethodBeat.i(48043);
    nGH = new e("X5", 0);
    nGI = new e("MMV8", 1);
    nGJ = new e("WebViewBased", 2);
    nGK = new e("NativeScript", 3);
    nGL = new e("NodeJS", 4);
    nGM = new e("J2V8", 5);
    nGN = new e("WebViewX5", 6);
    nGO = new e("WebViewXW", 7);
    nGP = new e("WebViewSystem", 8);
    nGQ = new e("Invalid", 9);
    nGS = new e[] { nGH, nGI, nGJ, nGK, nGL, nGM, nGN, nGO, nGP, nGQ };
    nGR = new e[] { nGI, nGM, nGL };
    AppMethodBeat.o(48043);
  }
  
  private e() {}
  
  public static e d(i parami)
  {
    AppMethodBeat.i(48041);
    if ((parami instanceof c))
    {
      parami = nGM;
      AppMethodBeat.o(48041);
      return parami;
    }
    if ((parami instanceof x))
    {
      parami = nGL;
      AppMethodBeat.o(48041);
      return parami;
    }
    if ((parami instanceof o))
    {
      parami = nGQ;
      AppMethodBeat.o(48041);
      return parami;
    }
    if ((parami instanceof bb))
    {
      if (!(parami instanceof at)) {
        break label221;
      }
      parami = ((at)parami).nsV;
    }
    label221:
    for (;;)
    {
      if ((parami instanceof WebView))
      {
        parami = (WebView)parami;
        if (parami.isSysKernel())
        {
          parami = nGP;
          AppMethodBeat.o(48041);
          return parami;
        }
        if (parami.isXWalkKernel())
        {
          parami = nGO;
          AppMethodBeat.o(48041);
          return parami;
        }
        if (parami.getX5WebViewExtension() != null)
        {
          parami = nGN;
          AppMethodBeat.o(48041);
          return parami;
        }
      }
      parami = nGQ;
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
      parami = nGQ;
      AppMethodBeat.o(48041);
      return parami;
    }
  }
  
  public static String e(i parami)
  {
    AppMethodBeat.i(48042);
    String str2 = d(parami).name();
    String str1 = str2;
    if ((parami instanceof o)) {
      str1 = str2 + "(remote_debug)";
    }
    AppMethodBeat.o(48042);
    return str1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.e
 * JD-Core Version:    0.7.0.1
 */
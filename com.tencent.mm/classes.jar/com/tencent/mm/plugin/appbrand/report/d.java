package com.tencent.mm.plugin.appbrand.report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.debugger.o;
import com.tencent.mm.plugin.appbrand.jsruntime.c;
import com.tencent.mm.plugin.appbrand.jsruntime.i;
import com.tencent.mm.plugin.appbrand.jsruntime.x;
import com.tencent.mm.plugin.appbrand.page.aq;
import com.tencent.mm.plugin.appbrand.page.ax;
import com.tencent.mm.sdk.platformtools.j;
import com.tencent.xweb.WebView;

public enum d
{
  public static final d[] mvT;
  
  static
  {
    AppMethodBeat.i(48043);
    mvJ = new d("X5", 0);
    mvK = new d("MMV8", 1);
    mvL = new d("WebViewBased", 2);
    mvM = new d("NativeScript", 3);
    mvN = new d("NodeJS", 4);
    mvO = new d("J2V8", 5);
    mvP = new d("WebViewX5", 6);
    mvQ = new d("WebViewXW", 7);
    mvR = new d("WebViewSystem", 8);
    mvS = new d("Invalid", 9);
    mvU = new d[] { mvJ, mvK, mvL, mvM, mvN, mvO, mvP, mvQ, mvR, mvS };
    mvT = new d[] { mvK, mvO, mvN };
    AppMethodBeat.o(48043);
  }
  
  private d() {}
  
  public static d d(i parami)
  {
    AppMethodBeat.i(48041);
    if ((parami instanceof c))
    {
      parami = mvO;
      AppMethodBeat.o(48041);
      return parami;
    }
    if ((parami instanceof x))
    {
      parami = mvN;
      AppMethodBeat.o(48041);
      return parami;
    }
    if ((parami instanceof o))
    {
      parami = mvS;
      AppMethodBeat.o(48041);
      return parami;
    }
    if ((parami instanceof ax))
    {
      if (!(parami instanceof aq)) {
        break label221;
      }
      parami = ((aq)parami).miB;
    }
    label221:
    for (;;)
    {
      if ((parami instanceof WebView))
      {
        parami = (WebView)parami;
        if (parami.isSysKernel())
        {
          parami = mvR;
          AppMethodBeat.o(48041);
          return parami;
        }
        if (parami.isXWalkKernel())
        {
          parami = mvQ;
          AppMethodBeat.o(48041);
          return parami;
        }
        if (parami.getX5WebViewExtension() != null)
        {
          parami = mvP;
          AppMethodBeat.o(48041);
          return parami;
        }
      }
      parami = mvS;
      AppMethodBeat.o(48041);
      return parami;
      if (j.DEBUG)
      {
        if (parami == null) {}
        for (parami = "null";; parami = parami.getClass().getSimpleName())
        {
          parami = new IllegalStateException(String.format("Unrecognized JsRuntime %s", new Object[] { parami }));
          AppMethodBeat.o(48041);
          throw parami;
        }
      }
      parami = mvS;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.d
 * JD-Core Version:    0.7.0.1
 */
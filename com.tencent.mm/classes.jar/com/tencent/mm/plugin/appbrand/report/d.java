package com.tencent.mm.plugin.appbrand.report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.debugger.o;
import com.tencent.mm.plugin.appbrand.jsruntime.c;
import com.tencent.mm.plugin.appbrand.jsruntime.x;
import com.tencent.mm.plugin.appbrand.page.ar;
import com.tencent.mm.plugin.appbrand.page.ay;
import com.tencent.xweb.WebView;

public enum d
{
  public static final d[] mqV;
  
  static
  {
    AppMethodBeat.i(48043);
    mqL = new d("X5", 0);
    mqM = new d("MMV8", 1);
    mqN = new d("WebViewBased", 2);
    mqO = new d("NativeScript", 3);
    mqP = new d("NodeJS", 4);
    mqQ = new d("J2V8", 5);
    mqR = new d("WebViewX5", 6);
    mqS = new d("WebViewXW", 7);
    mqT = new d("WebViewSystem", 8);
    mqU = new d("Invalid", 9);
    mqW = new d[] { mqL, mqM, mqN, mqO, mqP, mqQ, mqR, mqS, mqT, mqU };
    mqV = new d[] { mqM, mqQ, mqP };
    AppMethodBeat.o(48043);
  }
  
  private d() {}
  
  public static d d(com.tencent.mm.plugin.appbrand.jsruntime.i parami)
  {
    AppMethodBeat.i(48041);
    if ((parami instanceof c))
    {
      parami = mqQ;
      AppMethodBeat.o(48041);
      return parami;
    }
    if ((parami instanceof x))
    {
      parami = mqP;
      AppMethodBeat.o(48041);
      return parami;
    }
    if ((parami instanceof o))
    {
      parami = mqU;
      AppMethodBeat.o(48041);
      return parami;
    }
    if ((parami instanceof ay))
    {
      if (!(parami instanceof ar)) {
        break label221;
      }
      parami = ((ar)parami).meh;
    }
    label221:
    for (;;)
    {
      if ((parami instanceof WebView))
      {
        parami = (WebView)parami;
        if (parami.isSysKernel())
        {
          parami = mqT;
          AppMethodBeat.o(48041);
          return parami;
        }
        if (parami.isXWalkKernel())
        {
          parami = mqS;
          AppMethodBeat.o(48041);
          return parami;
        }
        if (parami.getX5WebViewExtension() != null)
        {
          parami = mqR;
          AppMethodBeat.o(48041);
          return parami;
        }
      }
      parami = mqU;
      AppMethodBeat.o(48041);
      return parami;
      if (com.tencent.mm.sdk.platformtools.i.DEBUG)
      {
        if (parami == null) {}
        for (parami = "null";; parami = parami.getClass().getSimpleName())
        {
          parami = new IllegalStateException(String.format("Unrecognized JsRuntime %s", new Object[] { parami }));
          AppMethodBeat.o(48041);
          throw parami;
        }
      }
      parami = mqU;
      AppMethodBeat.o(48041);
      return parami;
    }
  }
  
  public static String e(com.tencent.mm.plugin.appbrand.jsruntime.i parami)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.d
 * JD-Core Version:    0.7.0.1
 */
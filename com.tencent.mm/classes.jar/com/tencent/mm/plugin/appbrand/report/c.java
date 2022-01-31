package com.tencent.mm.plugin.appbrand.report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.debugger.n;
import com.tencent.mm.plugin.appbrand.i.i;
import com.tencent.mm.plugin.appbrand.i.u;
import com.tencent.mm.plugin.appbrand.i.v;
import com.tencent.mm.sdk.platformtools.f;

public enum c
{
  static
  {
    AppMethodBeat.i(132542);
    iFy = new c("X5", 0);
    iFz = new c("MMV8", 1);
    iFA = new c("WebViewBased", 2);
    iFB = new c("NativeScript", 3);
    iFC = new c("NodeJS", 4);
    iFD = new c("J2V8", 5);
    iFE = new c("Invalid", 6);
    iFF = new c[] { iFy, iFz, iFA, iFB, iFC, iFD, iFE };
    AppMethodBeat.o(132542);
  }
  
  private c() {}
  
  public static c g(i parami)
  {
    AppMethodBeat.i(132540);
    if ((parami instanceof com.tencent.mm.plugin.appbrand.i.c))
    {
      parami = iFD;
      AppMethodBeat.o(132540);
      return parami;
    }
    if ((parami instanceof v))
    {
      parami = iFA;
      AppMethodBeat.o(132540);
      return parami;
    }
    if ((parami instanceof u))
    {
      parami = iFC;
      AppMethodBeat.o(132540);
      return parami;
    }
    if ((parami instanceof n))
    {
      parami = iFE;
      AppMethodBeat.o(132540);
      return parami;
    }
    if (f.DEBUG)
    {
      if (parami == null) {}
      for (parami = "null";; parami = parami.getClass().getSimpleName())
      {
        parami = new IllegalStateException(String.format("Unrecognized JsRuntime %s", new Object[] { parami }));
        AppMethodBeat.o(132540);
        throw parami;
      }
    }
    parami = iFE;
    AppMethodBeat.o(132540);
    return parami;
  }
  
  public static String h(i parami)
  {
    AppMethodBeat.i(132541);
    String str2 = g(parami).name();
    String str1 = str2;
    if ((parami instanceof n)) {
      str1 = str2 + "(remote_debug)";
    }
    AppMethodBeat.o(132541);
    return str1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.c
 * JD-Core Version:    0.7.0.1
 */
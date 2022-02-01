package com.tencent.mm.plugin.appbrand.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.h.a;
import com.tencent.mm.ak.h.b;
import com.tencent.mm.g.a.fw;
import com.tencent.mm.sdk.b.a;

public enum b
{
  static
  {
    AppMethodBeat.i(174719);
    jYv = new b("INSTANCE");
    jYw = new b[] { jYv };
    AppMethodBeat.o(174719);
  }
  
  private b() {}
  
  public static void a(String paramString, h.a parama, h.b paramb)
  {
    AppMethodBeat.i(102763);
    fw localfw = new fw();
    localfw.dso.op = 1;
    localfw.dso.fileName = paramString;
    localfw.dso.dsq = true;
    localfw.dso.dcN = true;
    localfw.dso.dsr = parama;
    localfw.dso.dss = paramb;
    a.IvT.l(localfw);
    AppMethodBeat.o(102763);
  }
  
  public static void pause()
  {
    AppMethodBeat.i(102764);
    fw localfw = new fw();
    localfw.dso.op = 4;
    a.IvT.l(localfw);
    AppMethodBeat.o(102764);
  }
  
  public static void stop()
  {
    AppMethodBeat.i(102765);
    fw localfw = new fw();
    localfw.dso.op = 2;
    a.IvT.l(localfw);
    AppMethodBeat.o(102765);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.c.b
 * JD-Core Version:    0.7.0.1
 */
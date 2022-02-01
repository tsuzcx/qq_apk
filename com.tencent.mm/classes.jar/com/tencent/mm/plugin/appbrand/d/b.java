package com.tencent.mm.plugin.appbrand.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.j.a;
import com.tencent.mm.am.j.b;
import com.tencent.mm.autogen.a.gr;

public enum b
{
  static
  {
    AppMethodBeat.i(174719);
    qVm = new b("INSTANCE");
    qVn = new b[] { qVm };
    AppMethodBeat.o(174719);
  }
  
  private b() {}
  
  public static void a(String paramString, j.a parama, j.b paramb)
  {
    AppMethodBeat.i(102763);
    gr localgr = new gr();
    localgr.hHe.op = 1;
    localgr.hHe.fileName = paramString;
    localgr.hHe.hHg = true;
    localgr.hHe.hqB = true;
    localgr.hHe.hHh = parama;
    localgr.hHe.hHi = paramb;
    localgr.publish();
    AppMethodBeat.o(102763);
  }
  
  public static void pause()
  {
    AppMethodBeat.i(102764);
    gr localgr = new gr();
    localgr.hHe.op = 4;
    localgr.publish();
    AppMethodBeat.o(102764);
  }
  
  public static void stop()
  {
    AppMethodBeat.i(102765);
    gr localgr = new gr();
    localgr.hHe.op = 2;
    localgr.publish();
    AppMethodBeat.o(102765);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.d.b
 * JD-Core Version:    0.7.0.1
 */
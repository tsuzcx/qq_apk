package com.tencent.mm.plugin.appbrand.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.i.a;
import com.tencent.mm.al.i.b;
import com.tencent.mm.g.a.fr;
import com.tencent.mm.sdk.b.a;

public enum b
{
  static
  {
    AppMethodBeat.i(174719);
    jaW = new b("INSTANCE");
    jaX = new b[] { jaW };
    AppMethodBeat.o(174719);
  }
  
  private b() {}
  
  public static void a(String paramString, i.a parama, i.b paramb)
  {
    AppMethodBeat.i(102763);
    fr localfr = new fr();
    localfr.dis.op = 1;
    localfr.dis.fileName = paramString;
    localfr.dis.diu = true;
    localfr.dis.cSY = true;
    localfr.dis.div = parama;
    localfr.dis.diw = paramb;
    a.ESL.l(localfr);
    AppMethodBeat.o(102763);
  }
  
  public static void pause()
  {
    AppMethodBeat.i(102764);
    fr localfr = new fr();
    localfr.dis.op = 4;
    a.ESL.l(localfr);
    AppMethodBeat.o(102764);
  }
  
  public static void stop()
  {
    AppMethodBeat.i(102765);
    fr localfr = new fr();
    localfr.dis.op = 2;
    a.ESL.l(localfr);
    AppMethodBeat.o(102765);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.d.b
 * JD-Core Version:    0.7.0.1
 */
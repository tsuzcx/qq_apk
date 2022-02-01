package com.tencent.mm.plugin.appbrand.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.k.a;
import com.tencent.mm.ak.k.b;
import com.tencent.mm.g.a.fz;
import com.tencent.mm.sdk.event.EventCenter;

public enum b
{
  static
  {
    AppMethodBeat.i(174719);
    lbt = new b("INSTANCE");
    lbu = new b[] { lbt };
    AppMethodBeat.o(174719);
  }
  
  private b() {}
  
  public static void a(String paramString, k.a parama, k.b paramb)
  {
    AppMethodBeat.i(102763);
    fz localfz = new fz();
    localfz.dJA.op = 1;
    localfz.dJA.fileName = paramString;
    localfz.dJA.dJC = true;
    localfz.dJA.dtE = true;
    localfz.dJA.dJD = parama;
    localfz.dJA.dJE = paramb;
    EventCenter.instance.publish(localfz);
    AppMethodBeat.o(102763);
  }
  
  public static void pause()
  {
    AppMethodBeat.i(102764);
    fz localfz = new fz();
    localfz.dJA.op = 4;
    EventCenter.instance.publish(localfz);
    AppMethodBeat.o(102764);
  }
  
  public static void stop()
  {
    AppMethodBeat.i(102765);
    fz localfz = new fz();
    localfz.dJA.op = 2;
    EventCenter.instance.publish(localfz);
    AppMethodBeat.o(102765);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.c.b
 * JD-Core Version:    0.7.0.1
 */
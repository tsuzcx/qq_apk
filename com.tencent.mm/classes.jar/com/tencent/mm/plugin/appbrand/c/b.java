package com.tencent.mm.plugin.appbrand.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.k.a;
import com.tencent.mm.an.k.b;
import com.tencent.mm.f.a.gg;
import com.tencent.mm.sdk.event.EventCenter;

public enum b
{
  static
  {
    AppMethodBeat.i(174719);
    nVC = new b("INSTANCE");
    nVD = new b[] { nVC };
    AppMethodBeat.o(174719);
  }
  
  private b() {}
  
  public static void a(String paramString, k.a parama, k.b paramb)
  {
    AppMethodBeat.i(102763);
    gg localgg = new gg();
    localgg.fCp.op = 1;
    localgg.fCp.fileName = paramString;
    localgg.fCp.fCr = true;
    localgg.fCp.fmm = true;
    localgg.fCp.fCs = parama;
    localgg.fCp.fCt = paramb;
    EventCenter.instance.publish(localgg);
    AppMethodBeat.o(102763);
  }
  
  public static void pause()
  {
    AppMethodBeat.i(102764);
    gg localgg = new gg();
    localgg.fCp.op = 4;
    EventCenter.instance.publish(localgg);
    AppMethodBeat.o(102764);
  }
  
  public static void stop()
  {
    AppMethodBeat.i(102765);
    gg localgg = new gg();
    localgg.fCp.op = 2;
    EventCenter.instance.publish(localgg);
    AppMethodBeat.o(102765);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.c.b
 * JD-Core Version:    0.7.0.1
 */
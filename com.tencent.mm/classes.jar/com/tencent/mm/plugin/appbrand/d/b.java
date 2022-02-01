package com.tencent.mm.plugin.appbrand.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i.a;
import com.tencent.mm.ak.i.b;
import com.tencent.mm.g.a.fs;
import com.tencent.mm.sdk.b.a;

public enum b
{
  static
  {
    AppMethodBeat.i(174719);
    jBj = new b("INSTANCE");
    jBk = new b[] { jBj };
    AppMethodBeat.o(174719);
  }
  
  private b() {}
  
  public static void a(String paramString, i.a parama, i.b paramb)
  {
    AppMethodBeat.i(102763);
    fs localfs = new fs();
    localfs.dfN.op = 1;
    localfs.dfN.fileName = paramString;
    localfs.dfN.dfP = true;
    localfs.dfN.cQv = true;
    localfs.dfN.dfQ = parama;
    localfs.dfN.dfR = paramb;
    a.GpY.l(localfs);
    AppMethodBeat.o(102763);
  }
  
  public static void pause()
  {
    AppMethodBeat.i(102764);
    fs localfs = new fs();
    localfs.dfN.op = 4;
    a.GpY.l(localfs);
    AppMethodBeat.o(102764);
  }
  
  public static void stop()
  {
    AppMethodBeat.i(102765);
    fs localfs = new fs();
    localfs.dfN.op = 2;
    a.GpY.l(localfs);
    AppMethodBeat.o(102765);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.d.b
 * JD-Core Version:    0.7.0.1
 */
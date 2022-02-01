package com.tencent.mm.plugin.appbrand.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.h.a;
import com.tencent.mm.al.h.b;
import com.tencent.mm.g.a.fv;
import com.tencent.mm.sdk.b.a;

public enum b
{
  static
  {
    AppMethodBeat.i(174719);
    jVe = new b("INSTANCE");
    jVf = new b[] { jVe };
    AppMethodBeat.o(174719);
  }
  
  private b() {}
  
  public static void a(String paramString, h.a parama, h.b paramb)
  {
    AppMethodBeat.i(102763);
    fv localfv = new fv();
    localfv.drj.op = 1;
    localfv.drj.fileName = paramString;
    localfv.drj.drl = true;
    localfv.drj.dbL = true;
    localfv.drj.drm = parama;
    localfv.drj.drn = paramb;
    a.IbL.l(localfv);
    AppMethodBeat.o(102763);
  }
  
  public static void pause()
  {
    AppMethodBeat.i(102764);
    fv localfv = new fv();
    localfv.drj.op = 4;
    a.IbL.l(localfv);
    AppMethodBeat.o(102764);
  }
  
  public static void stop()
  {
    AppMethodBeat.i(102765);
    fv localfv = new fv();
    localfv.drj.op = 2;
    a.IbL.l(localfv);
    AppMethodBeat.o(102765);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.c.b
 * JD-Core Version:    0.7.0.1
 */
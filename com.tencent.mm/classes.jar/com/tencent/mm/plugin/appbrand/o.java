package com.tencent.mm.plugin.appbrand;

import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.d;
import com.tencent.mm.plugin.appbrand.utils.a;
import com.tencent.mm.sdk.event.IListener;

public final class o
{
  private static final IListener<d> ntt;
  
  static
  {
    AppMethodBeat.i(43798);
    ntt = new IListener() {};
    AppMethodBeat.o(43798);
  }
  
  public static void bBS()
  {
    AppMethodBeat.i(278126);
    h.ZvG.f(new a(new o.2()), "MicroMsg.AppBrandPruner");
    AppMethodBeat.o(278126);
  }
  
  public static void release()
  {
    AppMethodBeat.i(43797);
    ntt.dead();
    AppMethodBeat.o(43797);
  }
  
  public static void setup()
  {
    AppMethodBeat.i(43796);
    ntt.alive();
    AppMethodBeat.o(43796);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.o
 * JD-Core Version:    0.7.0.1
 */
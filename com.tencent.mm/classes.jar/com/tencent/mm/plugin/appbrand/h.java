package com.tencent.mm.plugin.appbrand;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.d;
import com.tencent.mm.sdk.b.c;

public final class h
{
  private static final c<d> gPu;
  
  static
  {
    AppMethodBeat.i(128954);
    gPu = new h.1();
    AppMethodBeat.o(128954);
  }
  
  public static void release()
  {
    AppMethodBeat.i(128953);
    gPu.dead();
    AppMethodBeat.o(128953);
  }
  
  public static void setup()
  {
    AppMethodBeat.i(128952);
    gPu.alive();
    AppMethodBeat.o(128952);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.h
 * JD-Core Version:    0.7.0.1
 */
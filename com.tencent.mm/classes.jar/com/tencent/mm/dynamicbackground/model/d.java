package com.tencent.mm.dynamicbackground.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(bv={1, 0, 2}, d1={""}, d2={"Lcom/tencent/mm/dynamicbackground/model/DynamicBgServiceManager;", "", "()V", "TAG", "", "service", "Lcom/tencent/mm/dynamicbackground/model/DynamicBgService;", "getDynamicBgService", "setDynamicBgService", "", "dynamicBgService", "dynamicbg_release"}, k=1, mv={1, 1, 11})
public final class d
{
  private static c mbr;
  public static final d mbs;
  
  static
  {
    AppMethodBeat.i(103080);
    mbs = new d();
    mbr = (c)new a();
    AppMethodBeat.o(103080);
  }
  
  public static void a(c paramc)
  {
    AppMethodBeat.i(103079);
    s.t(paramc, "dynamicBgService");
    com.tencent.mm.dynamicbackground.a.c.i("MicroMsg.DynamicBgServiceManager", "alvinluo setDynamicBgService", new Object[0]);
    mbr = paramc;
    AppMethodBeat.o(103079);
  }
  
  public static c aTA()
  {
    return mbr;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.dynamicbackground.model.d
 * JD-Core Version:    0.7.0.1
 */
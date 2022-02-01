package com.tencent.mm.dynamicbackground.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 11}, gfy={""}, gfz={"Lcom/tencent/mm/dynamicbackground/model/DynamicBgServiceManager;", "", "()V", "TAG", "", "service", "Lcom/tencent/mm/dynamicbackground/model/DynamicBgService;", "getDynamicBgService", "setDynamicBgService", "", "dynamicBgService", "dynamicbg_release"})
public final class d
{
  private static c gfy;
  public static final d gfz;
  
  static
  {
    AppMethodBeat.i(103080);
    gfz = new d();
    gfy = (c)new a();
    AppMethodBeat.o(103080);
  }
  
  public static void a(c paramc)
  {
    AppMethodBeat.i(103079);
    p.h(paramc, "dynamicBgService");
    com.tencent.mm.dynamicbackground.a.c.i("MicroMsg.DynamicBgServiceManager", "alvinluo setDynamicBgService", new Object[0]);
    gfy = paramc;
    AppMethodBeat.o(103079);
  }
  
  public static c adU()
  {
    return gfy;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.dynamicbackground.model.d
 * JD-Core Version:    0.7.0.1
 */
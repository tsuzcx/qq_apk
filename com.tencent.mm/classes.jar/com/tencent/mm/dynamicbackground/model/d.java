package com.tencent.mm.dynamicbackground.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.k;
import d.l;

@l(fNY={1, 1, 11}, fNZ={""}, fOa={"Lcom/tencent/mm/dynamicbackground/model/DynamicBgServiceManager;", "", "()V", "TAG", "", "service", "Lcom/tencent/mm/dynamicbackground/model/DynamicBgService;", "getDynamicBgService", "setDynamicBgService", "", "dynamicBgService", "dynamicbg_release"})
public final class d
{
  private static c fLY;
  public static final d fLZ;
  
  static
  {
    AppMethodBeat.i(103080);
    fLZ = new d();
    fLY = (c)new a();
    AppMethodBeat.o(103080);
  }
  
  public static void a(c paramc)
  {
    AppMethodBeat.i(103079);
    k.h(paramc, "dynamicBgService");
    com.tencent.mm.dynamicbackground.a.c.i("MicroMsg.DynamicBgServiceManager", "alvinluo setDynamicBgService", new Object[0]);
    fLY = paramc;
    AppMethodBeat.o(103079);
  }
  
  public static c abq()
  {
    return fLY;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.dynamicbackground.model.d
 * JD-Core Version:    0.7.0.1
 */
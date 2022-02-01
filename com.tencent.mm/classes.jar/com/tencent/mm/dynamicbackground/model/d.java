package com.tencent.mm.dynamicbackground.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 11}, gka={""}, gkb={"Lcom/tencent/mm/dynamicbackground/model/DynamicBgServiceManager;", "", "()V", "TAG", "", "service", "Lcom/tencent/mm/dynamicbackground/model/DynamicBgService;", "getDynamicBgService", "setDynamicBgService", "", "dynamicBgService", "dynamicbg_release"})
public final class d
{
  private static c ghQ;
  public static final d ghR;
  
  static
  {
    AppMethodBeat.i(103080);
    ghR = new d();
    ghQ = (c)new a();
    AppMethodBeat.o(103080);
  }
  
  public static void a(c paramc)
  {
    AppMethodBeat.i(103079);
    p.h(paramc, "dynamicBgService");
    com.tencent.mm.dynamicbackground.a.c.i("MicroMsg.DynamicBgServiceManager", "alvinluo setDynamicBgService", new Object[0]);
    ghQ = paramc;
    AppMethodBeat.o(103079);
  }
  
  public static c aeg()
  {
    return ghQ;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.dynamicbackground.model.d
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.dynamicbackground.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 11}, hxE={""}, hxF={"Lcom/tencent/mm/dynamicbackground/model/DynamicBgServiceManager;", "", "()V", "TAG", "", "service", "Lcom/tencent/mm/dynamicbackground/model/DynamicBgService;", "getDynamicBgService", "setDynamicBgService", "", "dynamicBgService", "dynamicbg_release"})
public final class d
{
  private static c gRi;
  public static final d gRj;
  
  static
  {
    AppMethodBeat.i(103080);
    gRj = new d();
    gRi = (c)new a();
    AppMethodBeat.o(103080);
  }
  
  public static void a(c paramc)
  {
    AppMethodBeat.i(103079);
    p.h(paramc, "dynamicBgService");
    com.tencent.mm.dynamicbackground.a.c.i("MicroMsg.DynamicBgServiceManager", "alvinluo setDynamicBgService", new Object[0]);
    gRi = paramc;
    AppMethodBeat.o(103079);
  }
  
  public static c atN()
  {
    return gRi;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.dynamicbackground.model.d
 * JD-Core Version:    0.7.0.1
 */
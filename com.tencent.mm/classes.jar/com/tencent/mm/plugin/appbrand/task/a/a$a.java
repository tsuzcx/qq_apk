package com.tencent.mm.plugin.appbrand.task.a;

import a.f.b.j;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.task.g;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/appbrand/task/preload/PreloadIntervalLimiter$PRELOAD_TYPE;", "", "(Ljava/lang/String;I)V", "WASERVICE", "WAGAME", "WASERVICE_FAKE_NATIVE", "NIL", "Companion", "plugin-appbrand-integration_release"})
public enum a$a
{
  @Deprecated
  public static final a.a.a iLt;
  
  static
  {
    AppMethodBeat.i(143977);
    a locala1 = new a("WASERVICE", 0);
    iLo = locala1;
    a locala2 = new a("WAGAME", 1);
    iLp = locala2;
    a locala3 = new a("WASERVICE_FAKE_NATIVE", 2);
    iLq = locala3;
    a locala4 = new a("NIL", 3);
    iLr = locala4;
    iLs = new a[] { locala1, locala2, locala3, locala4 };
    iLt = new a.a.a((byte)0);
    AppMethodBeat.o(143977);
  }
  
  private a$a() {}
  
  public static final a g(g paramg)
  {
    AppMethodBeat.i(143980);
    j.q(paramg, "type");
    switch (b.bLo[paramg.ordinal()])
    {
    default: 
      paramg = iLr;
      AppMethodBeat.o(143980);
      return paramg;
    case 1: 
      paramg = iLo;
      AppMethodBeat.o(143980);
      return paramg;
    }
    paramg = iLp;
    AppMethodBeat.o(143980);
    return paramg;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.task.a.a.a
 * JD-Core Version:    0.7.0.1
 */
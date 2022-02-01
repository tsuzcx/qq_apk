package com.tencent.mm.aj;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.u;
import com.tencent.mm.g.a.u.a;
import com.tencent.mm.g.a.u.b;
import com.tencent.mm.plugin.music.b.a;

public final class c
{
  public static boolean vC(String paramString)
  {
    AppMethodBeat.i(136979);
    u localu = new u();
    localu.dbH.action = 7;
    localu.dbH.cTr = paramString;
    a.a(localu);
    boolean bool = localu.dbI.result;
    AppMethodBeat.o(136979);
    return bool;
  }
  
  public static b vD(String paramString)
  {
    AppMethodBeat.i(136980);
    u localu = new u();
    localu.dbH.action = 16;
    localu.dbH.cTr = paramString;
    a.a(localu);
    paramString = localu.dbH.dbK;
    AppMethodBeat.o(136980);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.aj.c
 * JD-Core Version:    0.7.0.1
 */
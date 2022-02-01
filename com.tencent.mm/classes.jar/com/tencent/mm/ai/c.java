package com.tencent.mm.ai;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.x;
import com.tencent.mm.g.a.x.a;
import com.tencent.mm.g.a.x.b;
import com.tencent.mm.plugin.music.b.a;

public final class c
{
  public static boolean LT(String paramString)
  {
    AppMethodBeat.i(136979);
    x localx = new x();
    localx.dCQ.action = 7;
    localx.dCQ.dtX = paramString;
    a.a(localx);
    boolean bool = localx.dCR.result;
    AppMethodBeat.o(136979);
    return bool;
  }
  
  public static b LU(String paramString)
  {
    AppMethodBeat.i(136980);
    x localx = new x();
    localx.dCQ.action = 16;
    localx.dCQ.dtX = paramString;
    a.a(localx);
    paramString = localx.dCQ.dCT;
    AppMethodBeat.o(136980);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ai.c
 * JD-Core Version:    0.7.0.1
 */
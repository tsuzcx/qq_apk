package com.tencent.mm.ai;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.v;
import com.tencent.mm.g.a.v.a;
import com.tencent.mm.g.a.v.b;
import com.tencent.mm.plugin.music.b.a;

public final class c
{
  public static boolean Dj(String paramString)
  {
    AppMethodBeat.i(136979);
    v localv = new v();
    localv.dlA.action = 7;
    localv.dlA.ddg = paramString;
    a.a(localv);
    boolean bool = localv.dlB.result;
    AppMethodBeat.o(136979);
    return bool;
  }
  
  public static b Dk(String paramString)
  {
    AppMethodBeat.i(136980);
    v localv = new v();
    localv.dlA.action = 16;
    localv.dlA.ddg = paramString;
    a.a(localv);
    paramString = localv.dlA.dlD;
    AppMethodBeat.o(136980);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ai.c
 * JD-Core Version:    0.7.0.1
 */
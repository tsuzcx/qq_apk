package com.tencent.mm.ai;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.v;
import com.tencent.mm.g.a.v.a;
import com.tencent.mm.g.a.v.b;
import com.tencent.mm.plugin.music.b.a;

public final class c
{
  public static boolean zI(String paramString)
  {
    AppMethodBeat.i(136979);
    v localv = new v();
    localv.cZg.action = 7;
    localv.cZg.cQO = paramString;
    a.a(localv);
    boolean bool = localv.cZh.result;
    AppMethodBeat.o(136979);
    return bool;
  }
  
  public static b zJ(String paramString)
  {
    AppMethodBeat.i(136980);
    v localv = new v();
    localv.cZg.action = 16;
    localv.cZg.cQO = paramString;
    a.a(localv);
    paramString = localv.cZg.cZj;
    AppMethodBeat.o(136980);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ai.c
 * JD-Core Version:    0.7.0.1
 */
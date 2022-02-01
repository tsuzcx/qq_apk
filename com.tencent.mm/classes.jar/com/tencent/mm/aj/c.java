package com.tencent.mm.aj;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.v;
import com.tencent.mm.g.a.v.a;
import com.tencent.mm.g.a.v.b;
import com.tencent.mm.plugin.music.b.a;

public final class c
{
  public static boolean CH(String paramString)
  {
    AppMethodBeat.i(136979);
    v localv = new v();
    localv.dky.action = 7;
    localv.dky.dce = paramString;
    a.a(localv);
    boolean bool = localv.dkz.result;
    AppMethodBeat.o(136979);
    return bool;
  }
  
  public static b CI(String paramString)
  {
    AppMethodBeat.i(136980);
    v localv = new v();
    localv.dky.action = 16;
    localv.dky.dce = paramString;
    a.a(localv);
    paramString = localv.dky.dkB;
    AppMethodBeat.o(136980);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.aj.c
 * JD-Core Version:    0.7.0.1
 */
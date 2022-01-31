package com.tencent.mm.ag;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.s;
import com.tencent.mm.g.a.s.a;
import com.tencent.mm.g.a.s.b;
import com.tencent.mm.plugin.music.b.a;

public final class c
{
  public static boolean qI(String paramString)
  {
    AppMethodBeat.i(137230);
    s locals = new s();
    locals.cmS.action = 7;
    locals.cmS.ceu = paramString;
    a.a(locals);
    boolean bool = locals.cmT.cmX;
    AppMethodBeat.o(137230);
    return bool;
  }
  
  public static b qJ(String paramString)
  {
    AppMethodBeat.i(137231);
    s locals = new s();
    locals.cmS.action = 16;
    locals.cmS.ceu = paramString;
    a.a(locals);
    paramString = locals.cmS.cmV;
    AppMethodBeat.o(137231);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ag.c
 * JD-Core Version:    0.7.0.1
 */
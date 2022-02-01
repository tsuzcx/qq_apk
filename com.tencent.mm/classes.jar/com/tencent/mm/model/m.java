package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.ag;
import com.tencent.mm.al.f;
import com.tencent.mm.al.g;
import com.tencent.mm.api.c;
import com.tencent.mm.api.o;

public final class m
  implements o
{
  public final boolean a(c paramc)
  {
    AppMethodBeat.i(123965);
    boolean bool = ag.aGp().g(paramc);
    AppMethodBeat.o(123965);
    return bool;
  }
  
  public final boolean b(c paramc)
  {
    AppMethodBeat.i(123968);
    boolean bool = ag.aGp().f(paramc);
    AppMethodBeat.o(123968);
    return bool;
  }
  
  public final c eX(String paramString)
  {
    AppMethodBeat.i(123966);
    paramString = g.eX(paramString);
    AppMethodBeat.o(123966);
    return paramString;
  }
  
  public final void eY(String paramString)
  {
    AppMethodBeat.i(123967);
    ag.aGp().delete(paramString);
    AppMethodBeat.o(123967);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.model.m
 * JD-Core Version:    0.7.0.1
 */
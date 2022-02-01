package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ao.af;
import com.tencent.mm.ao.f;
import com.tencent.mm.ao.g;
import com.tencent.mm.api.c;
import com.tencent.mm.api.p;

public final class m
  implements p
{
  public final boolean a(c paramc)
  {
    AppMethodBeat.i(123965);
    boolean bool = af.bjv().h(paramc);
    AppMethodBeat.o(123965);
    return bool;
  }
  
  public final boolean b(c paramc)
  {
    AppMethodBeat.i(123968);
    boolean bool = af.bjv().g(paramc);
    AppMethodBeat.o(123968);
    return bool;
  }
  
  public final c gu(String paramString)
  {
    AppMethodBeat.i(123966);
    paramString = g.gu(paramString);
    AppMethodBeat.o(123966);
    return paramString;
  }
  
  public final void gv(String paramString)
  {
    AppMethodBeat.i(123967);
    af.bjv().Up(paramString);
    AppMethodBeat.o(123967);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.model.m
 * JD-Core Version:    0.7.0.1
 */
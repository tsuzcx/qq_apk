package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.af;
import com.tencent.mm.an.f;
import com.tencent.mm.an.g;
import com.tencent.mm.api.c;
import com.tencent.mm.api.q;

public final class m
  implements q
{
  public final boolean a(c paramc)
  {
    AppMethodBeat.i(123965);
    boolean bool = af.bHf().h(paramc);
    AppMethodBeat.o(123965);
    return bool;
  }
  
  public final boolean b(c paramc)
  {
    AppMethodBeat.i(123968);
    boolean bool = af.bHf().g(paramc);
    AppMethodBeat.o(123968);
    return bool;
  }
  
  public final c hU(String paramString)
  {
    AppMethodBeat.i(123966);
    paramString = g.hU(paramString);
    AppMethodBeat.o(123966);
    return paramString;
  }
  
  public final void hV(String paramString)
  {
    AppMethodBeat.i(123967);
    af.bHf().Mo(paramString);
    AppMethodBeat.o(123967);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.model.m
 * JD-Core Version:    0.7.0.1
 */
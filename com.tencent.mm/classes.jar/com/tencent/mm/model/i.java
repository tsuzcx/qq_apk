package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.a.k;
import com.tencent.mm.an.a.l;
import com.tencent.mm.an.af;
import com.tencent.mm.api.m;

public final class i
  implements m
{
  public final k hM(String paramString)
  {
    AppMethodBeat.i(123954);
    paramString = af.bHj().hM(paramString);
    AppMethodBeat.o(123954);
    return paramString;
  }
  
  public final String hN(String paramString)
  {
    AppMethodBeat.i(123955);
    paramString = af.bHj().hN(paramString);
    AppMethodBeat.o(123955);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.model.i
 * JD-Core Version:    0.7.0.1
 */
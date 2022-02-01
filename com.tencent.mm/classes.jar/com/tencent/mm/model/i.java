package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ao.a.k;
import com.tencent.mm.ao.af;

public final class i
  implements com.tencent.mm.api.l
{
  public final k gm(String paramString)
  {
    AppMethodBeat.i(123954);
    paramString = af.bjz().gm(paramString);
    AppMethodBeat.o(123954);
    return paramString;
  }
  
  public final String gn(String paramString)
  {
    AppMethodBeat.i(123955);
    paramString = af.bjz().gn(paramString);
    AppMethodBeat.o(123955);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.model.i
 * JD-Core Version:    0.7.0.1
 */
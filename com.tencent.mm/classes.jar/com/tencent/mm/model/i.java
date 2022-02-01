package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.a.k;
import com.tencent.mm.al.ag;

public final class i
  implements com.tencent.mm.api.l
{
  public final k fB(String paramString)
  {
    AppMethodBeat.i(123954);
    paramString = ag.bal().fB(paramString);
    AppMethodBeat.o(123954);
    return paramString;
  }
  
  public final String fC(String paramString)
  {
    AppMethodBeat.i(123955);
    paramString = ag.bal().fC(paramString);
    AppMethodBeat.o(123955);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.model.i
 * JD-Core Version:    0.7.0.1
 */
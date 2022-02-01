package com.tencent.mm.aa.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aa.b.e;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.HashMap;
import java.util.Map;

public final class g
{
  private final Map<String, e> ggq;
  
  public g()
  {
    AppMethodBeat.i(144820);
    this.ggq = new HashMap();
    AppMethodBeat.o(144820);
  }
  
  public final void a(e parame)
  {
    AppMethodBeat.i(144821);
    this.ggq.put(parame.getName(), parame);
    AppMethodBeat.o(144821);
  }
  
  public final e tN(String paramString)
  {
    AppMethodBeat.i(144822);
    if (bs.isNullOrNil(paramString))
    {
      AppMethodBeat.o(144822);
      return null;
    }
    paramString = (e)this.ggq.get(paramString);
    AppMethodBeat.o(144822);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.aa.c.g
 * JD-Core Version:    0.7.0.1
 */
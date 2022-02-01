package com.tencent.mm.aa.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aa.b.e;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.HashMap;
import java.util.Map;

public final class g
{
  private final Map<String, e> gCH;
  
  public g()
  {
    AppMethodBeat.i(144820);
    this.gCH = new HashMap();
    AppMethodBeat.o(144820);
  }
  
  public final void a(e parame)
  {
    AppMethodBeat.i(144821);
    this.gCH.put(parame.getName(), parame);
    AppMethodBeat.o(144821);
  }
  
  public final e xm(String paramString)
  {
    AppMethodBeat.i(144822);
    if (bu.isNullOrNil(paramString))
    {
      AppMethodBeat.o(144822);
      return null;
    }
    paramString = (e)this.gCH.get(paramString);
    AppMethodBeat.o(144822);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.aa.c.g
 * JD-Core Version:    0.7.0.1
 */
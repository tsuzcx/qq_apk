package com.tencent.mm.ac.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.b.e;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import java.util.Map;

public final class g
{
  private final Map<String, e> kbm;
  
  public g()
  {
    AppMethodBeat.i(144820);
    this.kbm = new HashMap();
    AppMethodBeat.o(144820);
  }
  
  public final e My(String paramString)
  {
    AppMethodBeat.i(144822);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(144822);
      return null;
    }
    paramString = (e)this.kbm.get(paramString);
    AppMethodBeat.o(144822);
    return paramString;
  }
  
  public final void a(e parame)
  {
    AppMethodBeat.i(144821);
    this.kbm.put(parame.getName(), parame);
    AppMethodBeat.o(144821);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ac.c.g
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.aa.a.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.vending.g.c;
import com.tencent.mm.vending.g.f;
import com.tencent.mm.vending.h.e;
import com.tencent.mm.vending.j.d;

public final class g$c
  implements e<Void, d<Long, String, String>>
{
  public g$c(g paramg) {}
  
  public final String HY()
  {
    return "Vending.LOGIC";
  }
  
  public final c<Void> a(long paramLong, String paramString1, String paramString2)
  {
    AppMethodBeat.i(141974);
    paramString1 = f.h(Long.valueOf(paramLong), paramString1, paramString2).c(this);
    AppMethodBeat.o(141974);
    return paramString1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.a.c.g.c
 * JD-Core Version:    0.7.0.1
 */
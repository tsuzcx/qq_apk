package com.tencent.mm.plugin.appbrand.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.d.a.c;
import com.tencent.mm.d.a.g;
import com.tencent.mm.d.a.i;
import com.tencent.mm.d.a.i.3;
import com.tencent.mm.d.a.l;

public final class u
  extends a
{
  public u()
  {
    super(null, null);
  }
  
  public u(String paramString, byte[] paramArrayOfByte)
  {
    super(paramString, paramArrayOfByte);
  }
  
  protected final l a(c paramc, int paramInt)
  {
    AppMethodBeat.i(113945);
    paramc = (i)paramc;
    if (paramc.cbr == null) {
      paramc.cbr = new l(paramc, paramc.Ck(), new i.3(paramc));
    }
    paramc = paramc.cbr;
    AppMethodBeat.o(113945);
    return paramc;
  }
  
  protected final c r(String paramString, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(113944);
    paramString = g.g(paramString, paramArrayOfByte);
    AppMethodBeat.o(113944);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.i.u
 * JD-Core Version:    0.7.0.1
 */
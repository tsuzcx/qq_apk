package com.tencent.mm.plugin.appbrand.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.d.a.g;
import com.tencent.mm.d.a.l;
import com.tencent.mm.d.a.l.7;

public class c
  extends a
{
  public c()
  {
    this(null, null);
  }
  
  public c(String paramString, byte[] paramArrayOfByte)
  {
    super(paramString, paramArrayOfByte);
  }
  
  protected final l a(com.tencent.mm.d.a.c paramc, int paramInt)
  {
    AppMethodBeat.i(113933);
    paramc = paramc.gg(paramInt);
    AppMethodBeat.o(113933);
    return paramc;
  }
  
  public final void a(w paramw)
  {
    AppMethodBeat.i(145892);
    if (this.ijd != null)
    {
      l locall = this.ijd;
      locall.cbC.k(new l.7(locall, paramw));
    }
    AppMethodBeat.o(145892);
  }
  
  protected com.tencent.mm.d.a.c r(String paramString, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(113932);
    paramString = g.h(paramString, paramArrayOfByte);
    AppMethodBeat.o(113932);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.i.c
 * JD-Core Version:    0.7.0.1
 */
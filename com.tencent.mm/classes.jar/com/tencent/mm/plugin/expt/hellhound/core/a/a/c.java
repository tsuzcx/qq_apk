package com.tencent.mm.plugin.expt.hellhound.core.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class c
{
  private static c zBg;
  public e zBh;
  
  private c()
  {
    AppMethodBeat.i(121868);
    this.zBh = new e();
    AppMethodBeat.o(121868);
  }
  
  public static c dJd()
  {
    AppMethodBeat.i(121867);
    if (zBg == null) {}
    try
    {
      if (zBg == null) {
        zBg = new c();
      }
      c localc = zBg;
      AppMethodBeat.o(121867);
      return localc;
    }
    finally
    {
      AppMethodBeat.o(121867);
    }
  }
  
  public final void I(int paramInt, Object paramObject)
  {
    AppMethodBeat.i(121870);
    a locala = new a();
    locala.msgType = paramInt;
    locala.zBd = paramObject;
    this.zBh.b(locala);
    AppMethodBeat.o(121870);
  }
  
  public final void Lz(int paramInt)
  {
    AppMethodBeat.i(121869);
    a locala = new a();
    locala.msgType = paramInt;
    this.zBh.b(locala);
    AppMethodBeat.o(121869);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.core.a.a.c
 * JD-Core Version:    0.7.0.1
 */
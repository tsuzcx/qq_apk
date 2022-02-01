package com.tencent.mm.plugin.expt.hellhound.core.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class c
{
  private static c szk;
  public e szl;
  
  private c()
  {
    AppMethodBeat.i(121868);
    this.szl = new e();
    AppMethodBeat.o(121868);
  }
  
  public static c cNJ()
  {
    AppMethodBeat.i(121867);
    if (szk == null) {}
    try
    {
      if (szk == null) {
        szk = new c();
      }
      c localc = szk;
      AppMethodBeat.o(121867);
      return localc;
    }
    finally
    {
      AppMethodBeat.o(121867);
    }
  }
  
  public final void GP(int paramInt)
  {
    AppMethodBeat.i(121869);
    a locala = new a();
    locala.msgType = paramInt;
    this.szl.b(locala);
    AppMethodBeat.o(121869);
  }
  
  public final void m(int paramInt, Object paramObject)
  {
    AppMethodBeat.i(121870);
    a locala = new a();
    locala.msgType = paramInt;
    locala.szh = paramObject;
    this.szl.b(locala);
    AppMethodBeat.o(121870);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.core.a.a.c
 * JD-Core Version:    0.7.0.1
 */
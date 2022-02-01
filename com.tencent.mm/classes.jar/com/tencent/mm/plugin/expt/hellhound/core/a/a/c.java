package com.tencent.mm.plugin.expt.hellhound.core.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class c
{
  private static c pEi;
  public e pEj;
  
  private c()
  {
    AppMethodBeat.i(121868);
    this.pEj = new e();
    AppMethodBeat.o(121868);
  }
  
  public static c cbD()
  {
    AppMethodBeat.i(121867);
    if (pEi == null) {}
    try
    {
      if (pEi == null) {
        pEi = new c();
      }
      c localc = pEi;
      AppMethodBeat.o(121867);
      return localc;
    }
    finally
    {
      AppMethodBeat.o(121867);
    }
  }
  
  public final void Bo(int paramInt)
  {
    AppMethodBeat.i(121869);
    a locala = new a();
    locala.msgType = paramInt;
    this.pEj.b(locala);
    AppMethodBeat.o(121869);
  }
  
  public final void l(int paramInt, Object paramObject)
  {
    AppMethodBeat.i(121870);
    a locala = new a();
    locala.msgType = paramInt;
    locala.pEf = paramObject;
    this.pEj.b(locala);
    AppMethodBeat.o(121870);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.core.a.a.c
 * JD-Core Version:    0.7.0.1
 */
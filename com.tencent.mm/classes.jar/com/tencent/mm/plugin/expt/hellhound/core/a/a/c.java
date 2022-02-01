package com.tencent.mm.plugin.expt.hellhound.core.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class c
{
  private static c qYT;
  public e qYU;
  
  private c()
  {
    AppMethodBeat.i(121868);
    this.qYU = new e();
    AppMethodBeat.o(121868);
  }
  
  public static c cpq()
  {
    AppMethodBeat.i(121867);
    if (qYT == null) {}
    try
    {
      if (qYT == null) {
        qYT = new c();
      }
      c localc = qYT;
      AppMethodBeat.o(121867);
      return localc;
    }
    finally
    {
      AppMethodBeat.o(121867);
    }
  }
  
  public final void De(int paramInt)
  {
    AppMethodBeat.i(121869);
    a locala = new a();
    locala.msgType = paramInt;
    this.qYU.b(locala);
    AppMethodBeat.o(121869);
  }
  
  public final void l(int paramInt, Object paramObject)
  {
    AppMethodBeat.i(121870);
    a locala = new a();
    locala.msgType = paramInt;
    locala.qYQ = paramObject;
    this.qYU.b(locala);
    AppMethodBeat.o(121870);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.core.a.a.c
 * JD-Core Version:    0.7.0.1
 */
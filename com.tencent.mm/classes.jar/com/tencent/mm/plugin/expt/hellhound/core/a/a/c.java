package com.tencent.mm.plugin.expt.hellhound.core.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class c
{
  private static c qQV;
  public e qQW;
  
  private c()
  {
    AppMethodBeat.i(121868);
    this.qQW = new e();
    AppMethodBeat.o(121868);
  }
  
  public static c cnO()
  {
    AppMethodBeat.i(121867);
    if (qQV == null) {}
    try
    {
      if (qQV == null) {
        qQV = new c();
      }
      c localc = qQV;
      AppMethodBeat.o(121867);
      return localc;
    }
    finally
    {
      AppMethodBeat.o(121867);
    }
  }
  
  public final void CR(int paramInt)
  {
    AppMethodBeat.i(121869);
    a locala = new a();
    locala.msgType = paramInt;
    this.qQW.b(locala);
    AppMethodBeat.o(121869);
  }
  
  public final void l(int paramInt, Object paramObject)
  {
    AppMethodBeat.i(121870);
    a locala = new a();
    locala.msgType = paramInt;
    locala.qQS = paramObject;
    this.qQW.b(locala);
    AppMethodBeat.o(121870);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.core.a.a.c
 * JD-Core Version:    0.7.0.1
 */
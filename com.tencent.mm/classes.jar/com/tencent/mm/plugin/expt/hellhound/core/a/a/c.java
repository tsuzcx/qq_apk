package com.tencent.mm.plugin.expt.hellhound.core.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class c
{
  private static c wfg;
  public e wfh;
  
  private c()
  {
    AppMethodBeat.i(121868);
    this.wfh = new e();
    AppMethodBeat.o(121868);
  }
  
  public static c dcB()
  {
    AppMethodBeat.i(121867);
    if (wfg == null) {}
    try
    {
      if (wfg == null) {
        wfg = new c();
      }
      c localc = wfg;
      AppMethodBeat.o(121867);
      return localc;
    }
    finally
    {
      AppMethodBeat.o(121867);
    }
  }
  
  public final void Kz(int paramInt)
  {
    AppMethodBeat.i(121869);
    a locala = new a();
    locala.msgType = paramInt;
    this.wfh.b(locala);
    AppMethodBeat.o(121869);
  }
  
  public final void p(int paramInt, Object paramObject)
  {
    AppMethodBeat.i(121870);
    a locala = new a();
    locala.msgType = paramInt;
    locala.wfd = paramObject;
    this.wfh.b(locala);
    AppMethodBeat.o(121870);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.core.a.a.c
 * JD-Core Version:    0.7.0.1
 */
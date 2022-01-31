package com.tencent.mm.plugin.gwallet.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
  extends Exception
{
  c nGm;
  
  public a(int paramInt, String paramString)
  {
    this(new c(paramInt, paramString));
    AppMethodBeat.i(41689);
    AppMethodBeat.o(41689);
  }
  
  private a(c paramc)
  {
    this(paramc, null);
  }
  
  private a(c paramc, Exception paramException)
  {
    super(paramc.nGF, paramException);
    this.nGm = paramc;
  }
  
  public a(String paramString, Exception paramException)
  {
    this(new c(-1001, paramString), paramException);
    AppMethodBeat.i(41690);
    AppMethodBeat.o(41690);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.gwallet.a.a
 * JD-Core Version:    0.7.0.1
 */
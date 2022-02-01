package com.tencent.mm.plugin.gwallet.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
  extends Exception
{
  c uDj;
  
  public a(int paramInt, String paramString)
  {
    this(new c(paramInt, paramString));
    AppMethodBeat.i(64585);
    AppMethodBeat.o(64585);
  }
  
  private a(c paramc)
  {
    this(paramc, null);
  }
  
  private a(c paramc, Exception paramException)
  {
    super(paramc.uDD, paramException);
    this.uDj = paramc;
  }
  
  public a(String paramString, Exception paramException)
  {
    this(new c(-1001, paramString), paramException);
    AppMethodBeat.i(64586);
    AppMethodBeat.o(64586);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.gwallet.a.a
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mapsdk.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class qd
  extends lc
{
  private qe a;
  
  public qd(qe paramqe)
  {
    this.a = paramqe;
  }
  
  public final byte[] f(String paramString)
  {
    AppMethodBeat.i(226042);
    if ((gz.a(paramString)) || (!paramString.startsWith("tileOverlay")) || (this.a == null))
    {
      AppMethodBeat.o(226042);
      return null;
    }
    paramString = this.a.a(paramString);
    AppMethodBeat.o(226042);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mapsdk.internal.qd
 * JD-Core Version:    0.7.0.1
 */
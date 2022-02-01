package com.tencent.mm.openglapihook.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
{
  private static a mxP = null;
  
  public static void a(a parama)
  {
    mxP = parama;
  }
  
  public static void i(String paramString1, String paramString2)
  {
    AppMethodBeat.i(204107);
    if (mxP != null) {
      mxP.i(paramString1, paramString2);
    }
    AppMethodBeat.o(204107);
  }
  
  public static abstract interface a
  {
    public abstract void i(String paramString1, String paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.openglapihook.a.a
 * JD-Core Version:    0.7.0.1
 */
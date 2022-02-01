package com.google.c;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class d
  extends f
{
  private static final d bRA;
  
  static
  {
    AppMethodBeat.i(12283);
    d locald = new d();
    bRA = locald;
    locald.setStackTrace(bRD);
    AppMethodBeat.o(12283);
  }
  
  public static d zr()
  {
    AppMethodBeat.i(12282);
    if (bRC)
    {
      locald = new d();
      AppMethodBeat.o(12282);
      return locald;
    }
    d locald = bRA;
    AppMethodBeat.o(12282);
    return locald;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.google.c.d
 * JD-Core Version:    0.7.0.1
 */
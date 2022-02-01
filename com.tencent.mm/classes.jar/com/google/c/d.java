package com.google.c;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class d
  extends f
{
  private static final d cdC;
  
  static
  {
    AppMethodBeat.i(12283);
    d locald = new d();
    cdC = locald;
    locald.setStackTrace(cdF);
    AppMethodBeat.o(12283);
  }
  
  public static d JH()
  {
    AppMethodBeat.i(12282);
    if (cdE)
    {
      locald = new d();
      AppMethodBeat.o(12282);
      return locald;
    }
    d locald = cdC;
    AppMethodBeat.o(12282);
    return locald;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.google.c.d
 * JD-Core Version:    0.7.0.1
 */
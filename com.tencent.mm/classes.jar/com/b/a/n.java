package com.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class n
  extends Exception
{
  public n(String paramString)
  {
    super(paramString + ". Version: ");
    AppMethodBeat.i(183611);
    AppMethodBeat.o(183611);
  }
  
  public n(String paramString, Throwable paramThrowable)
  {
    super(paramString + ". Version: ", paramThrowable);
    AppMethodBeat.i(183612);
    AppMethodBeat.o(183612);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.b.a.n
 * JD-Core Version:    0.7.0.1
 */
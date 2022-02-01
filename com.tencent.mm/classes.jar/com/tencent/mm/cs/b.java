package com.tencent.mm.cs;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class b
  extends RuntimeException
{
  public b(String paramString)
  {
    super(paramString);
  }
  
  public b(String paramString, Throwable paramThrowable)
  {
    super(paramString, paramThrowable);
  }
  
  public b(Throwable paramThrowable)
  {
    super(paramThrowable.getMessage(), paramThrowable);
    AppMethodBeat.i(231614);
    AppMethodBeat.o(231614);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.cs.b
 * JD-Core Version:    0.7.0.1
 */
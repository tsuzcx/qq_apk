package com.google.b.b.a;

import com.google.b.a.b;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class a$c
{
  static final c dAZ;
  final Throwable exception;
  
  static
  {
    AppMethodBeat.i(208713);
    dAZ = new c(new Throwable("Failure occurred while trying to finish a future.")
    {
      public final Throwable fillInStackTrace()
      {
        return this;
      }
    });
    AppMethodBeat.o(208713);
  }
  
  a$c(Throwable paramThrowable)
  {
    AppMethodBeat.i(208709);
    this.exception = ((Throwable)b.checkNotNull(paramThrowable));
    AppMethodBeat.o(208709);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.b.b.a.a.c
 * JD-Core Version:    0.7.0.1
 */
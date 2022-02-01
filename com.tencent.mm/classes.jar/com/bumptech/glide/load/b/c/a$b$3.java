package com.bumptech.glide.load.b.c;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class a$b$3
  implements a.b
{
  public final void c(Throwable paramThrowable)
  {
    AppMethodBeat.i(77174);
    paramThrowable = new RuntimeException("Request threw uncaught throwable", paramThrowable);
    AppMethodBeat.o(77174);
    throw paramThrowable;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.bumptech.glide.load.b.c.a.b.3
 * JD-Core Version:    0.7.0.1
 */
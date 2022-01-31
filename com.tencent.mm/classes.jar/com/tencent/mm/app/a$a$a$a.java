package com.tencent.mm.app;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class a$a$a$a
  extends Throwable
{
  private a$a$a$a(a.a.a parama, a parama1)
  {
    super(parama.name, parama1);
  }
  
  public final Throwable fillInStackTrace()
  {
    AppMethodBeat.i(15351);
    setStackTrace(this.bXf.bXe);
    AppMethodBeat.o(15351);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.app.a.a.a.a
 * JD-Core Version:    0.7.0.1
 */
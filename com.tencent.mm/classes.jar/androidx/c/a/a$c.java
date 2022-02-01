package androidx.c.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class a$c
{
  static final c bfL;
  final Throwable exception;
  
  static
  {
    AppMethodBeat.i(195307);
    bfL = new c(new Throwable("Failure occurred while trying to finish a future.")
    {
      public final Throwable fillInStackTrace()
      {
        return this;
      }
    });
    AppMethodBeat.o(195307);
  }
  
  a$c(Throwable paramThrowable)
  {
    AppMethodBeat.i(195302);
    this.exception = ((Throwable)a.checkNotNull(paramThrowable));
    AppMethodBeat.o(195302);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     androidx.c.a.a.c
 * JD-Core Version:    0.7.0.1
 */
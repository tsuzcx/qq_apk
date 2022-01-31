package a.j.b.a.c.n;

import a.f.b.j;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class c
{
  public static final boolean r(Throwable paramThrowable)
  {
    AppMethodBeat.i(122927);
    j.q(paramThrowable, "receiver$0");
    paramThrowable = paramThrowable.getClass();
    Class localClass;
    do
    {
      if (j.e(paramThrowable.getCanonicalName(), "com.intellij.openapi.progress.ProcessCanceledException"))
      {
        AppMethodBeat.o(122927);
        return true;
      }
      localClass = paramThrowable.getSuperclass();
      paramThrowable = localClass;
    } while (localClass != null);
    AppMethodBeat.o(122927);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     a.j.b.a.c.n.c
 * JD-Core Version:    0.7.0.1
 */
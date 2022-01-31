package a.d.a;

import a.f.b.j;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lkotlin/internal/jdk7/JDK7PlatformImplementations;", "Lkotlin/internal/PlatformImplementations;", "()V", "addSuppressed", "", "cause", "", "exception", "kotlin-stdlib-jdk7"})
public class a
  extends a.d.a
{
  public final void a(Throwable paramThrowable1, Throwable paramThrowable2)
  {
    AppMethodBeat.i(123227);
    j.q(paramThrowable1, "cause");
    j.q(paramThrowable2, "exception");
    paramThrowable1.addSuppressed(paramThrowable2);
    AppMethodBeat.o(123227);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     a.d.a.a
 * JD-Core Version:    0.7.0.1
 */
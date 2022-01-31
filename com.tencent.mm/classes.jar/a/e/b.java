package a.e;

import a.a;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Closeable;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"closeFinally", "", "Ljava/io/Closeable;", "cause", "", "use", "R", "T", "block", "Lkotlin/Function1;", "Requires newer compiler version to be inlined correctly.", "(Ljava/io/Closeable;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "kotlin-stdlib"})
public final class b
{
  public static final void a(Closeable paramCloseable, Throwable paramThrowable)
  {
    AppMethodBeat.i(56259);
    if (paramCloseable != null)
    {
      if (paramThrowable == null)
      {
        paramCloseable.close();
        AppMethodBeat.o(56259);
        return;
      }
      try
      {
        paramCloseable.close();
        AppMethodBeat.o(56259);
        return;
      }
      catch (Throwable paramCloseable)
      {
        a.a(paramThrowable, paramCloseable);
      }
    }
    AppMethodBeat.o(56259);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     a.e.b
 * JD-Core Version:    0.7.0.1
 */
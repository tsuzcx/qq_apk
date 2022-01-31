package a.c.b.a;

import a.c.c;
import a.c.e;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lkotlin/coroutines/jvm/internal/CompletedContinuation;", "Lkotlin/coroutines/Continuation;", "", "()V", "context", "Lkotlin/coroutines/CoroutineContext;", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "resumeWith", "", "result", "Lkotlin/Result;", "(Ljava/lang/Object;)V", "toString", "", "kotlin-stdlib"})
public final class b
  implements c<Object>
{
  public static final b BNb;
  
  static
  {
    AppMethodBeat.i(56383);
    BNb = new b();
    AppMethodBeat.o(56383);
  }
  
  public final void dg(Object paramObject)
  {
    AppMethodBeat.i(56382);
    paramObject = (Throwable)new IllegalStateException("This continuation is already complete".toString());
    AppMethodBeat.o(56382);
    throw paramObject;
  }
  
  public final e eaV()
  {
    AppMethodBeat.i(56381);
    Throwable localThrowable = (Throwable)new IllegalStateException("This continuation is already complete".toString());
    AppMethodBeat.o(56381);
    throw localThrowable;
  }
  
  public final String toString()
  {
    return "This continuation is already complete";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     a.c.b.a.b
 * JD-Core Version:    0.7.0.1
 */
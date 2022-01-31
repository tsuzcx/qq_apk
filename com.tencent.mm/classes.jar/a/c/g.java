package a.c;

import a.c.a.a;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lkotlin/coroutines/SafeContinuation;", "T", "Lkotlin/coroutines/Continuation;", "Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "delegate", "(Lkotlin/coroutines/Continuation;)V", "initialResult", "", "(Lkotlin/coroutines/Continuation;Ljava/lang/Object;)V", "callerFrame", "getCallerFrame", "()Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "context", "Lkotlin/coroutines/CoroutineContext;", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "result", "getOrThrow", "getStackTraceElement", "Ljava/lang/StackTraceElement;", "resumeWith", "", "Lkotlin/Result;", "(Ljava/lang/Object;)V", "toString", "", "Companion", "kotlin-stdlib"})
public final class g<T>
  implements c<T>
{
  public static final AtomicReferenceFieldUpdater<g<?>, Object> BMQ;
  private static final g.a BMR;
  private final c<T> BMP;
  public volatile Object result;
  
  static
  {
    AppMethodBeat.i(142972);
    BMR = new g.a((byte)0);
    BMQ = AtomicReferenceFieldUpdater.newUpdater(g.class, Object.class, "result");
    AppMethodBeat.o(142972);
  }
  
  public g(c<? super T> paramc)
  {
    this(paramc, a.BMT);
    AppMethodBeat.i(142971);
    AppMethodBeat.o(142971);
  }
  
  private g(c<? super T> paramc, Object paramObject)
  {
    AppMethodBeat.i(142970);
    this.BMP = paramc;
    this.result = paramObject;
    AppMethodBeat.o(142970);
  }
  
  public final void dg(Object paramObject)
  {
    AppMethodBeat.i(142968);
    do
    {
      Object localObject;
      do
      {
        localObject = this.result;
        if (localObject != a.BMT) {
          break;
        }
      } while (!BMQ.compareAndSet(this, a.BMT, paramObject));
      AppMethodBeat.o(142968);
      return;
      if (localObject != a.BMS) {
        break;
      }
    } while (!BMQ.compareAndSet(this, a.BMS, a.BMU));
    this.BMP.dg(paramObject);
    AppMethodBeat.o(142968);
    return;
    paramObject = (Throwable)new IllegalStateException("Already resumed");
    AppMethodBeat.o(142968);
    throw paramObject;
  }
  
  public final e eaV()
  {
    AppMethodBeat.i(142967);
    e locale = this.BMP.eaV();
    AppMethodBeat.o(142967);
    return locale;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(142969);
    String str = "SafeContinuation for " + this.BMP;
    AppMethodBeat.o(142969);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     a.c.g
 * JD-Core Version:    0.7.0.1
 */
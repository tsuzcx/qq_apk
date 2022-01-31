package a.c;

import a.f.a.m;
import a.f.b.j;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Serializable;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lkotlin/coroutines/EmptyCoroutineContext;", "Lkotlin/coroutines/CoroutineContext;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "()V", "serialVersionUID", "", "fold", "R", "initial", "operation", "Lkotlin/Function2;", "Lkotlin/coroutines/CoroutineContext$Element;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "get", "E", "key", "Lkotlin/coroutines/CoroutineContext$Key;", "(Lkotlin/coroutines/CoroutineContext$Key;)Lkotlin/coroutines/CoroutineContext$Element;", "hashCode", "", "minusKey", "plus", "context", "readResolve", "", "toString", "", "kotlin-stdlib"})
public final class f
  implements e, Serializable
{
  public static final f BMO;
  
  static
  {
    AppMethodBeat.i(56407);
    BMO = new f();
    AppMethodBeat.o(56407);
  }
  
  private final Object readResolve()
  {
    return BMO;
  }
  
  public final <R> R fold(R paramR, m<? super R, ? super e.b, ? extends R> paramm)
  {
    AppMethodBeat.i(56404);
    j.q(paramm, "operation");
    AppMethodBeat.o(56404);
    return paramR;
  }
  
  public final <E extends e.b> E get(e.c<E> paramc)
  {
    AppMethodBeat.i(56403);
    j.q(paramc, "key");
    AppMethodBeat.o(56403);
    return null;
  }
  
  public final int hashCode()
  {
    return 0;
  }
  
  public final e minusKey(e.c<?> paramc)
  {
    AppMethodBeat.i(56406);
    j.q(paramc, "key");
    paramc = (e)this;
    AppMethodBeat.o(56406);
    return paramc;
  }
  
  public final e plus(e parame)
  {
    AppMethodBeat.i(56405);
    j.q(parame, "context");
    AppMethodBeat.o(56405);
    return parame;
  }
  
  public final String toString()
  {
    return "EmptyCoroutineContext";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     a.c.f
 * JD-Core Version:    0.7.0.1
 */
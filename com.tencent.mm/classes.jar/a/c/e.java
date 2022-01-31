package a.c;

import a.f.a.m;
import a.f.b.k;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lkotlin/coroutines/CoroutineContext;", "", "fold", "R", "initial", "operation", "Lkotlin/Function2;", "Lkotlin/coroutines/CoroutineContext$Element;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "get", "E", "key", "Lkotlin/coroutines/CoroutineContext$Key;", "(Lkotlin/coroutines/CoroutineContext$Key;)Lkotlin/coroutines/CoroutineContext$Element;", "minusKey", "plus", "context", "Element", "Key", "kotlin-stdlib"})
public abstract interface e
{
  public abstract <R> R fold(R paramR, m<? super R, ? super e.b, ? extends R> paramm);
  
  public abstract <E extends e.b> E get(e.c<E> paramc);
  
  public abstract e minusKey(e.c<?> paramc);
  
  public abstract e plus(e parame);
  
  @l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "Lkotlin/coroutines/CoroutineContext;", "acc", "element", "Lkotlin/coroutines/CoroutineContext$Element;", "invoke"})
  static final class a$a
    extends k
    implements m<e, e.b, e>
  {
    public static final a BMN;
    
    static
    {
      AppMethodBeat.i(56379);
      BMN = new a();
      AppMethodBeat.o(56379);
    }
    
    a$a()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     a.c.e
 * JD-Core Version:    0.7.0.1
 */
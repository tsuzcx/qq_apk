package a.c.b.a;

import a.c.c;
import a.c.e;
import a.l;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lkotlin/coroutines/jvm/internal/RestrictedContinuationImpl;", "Lkotlin/coroutines/jvm/internal/BaseContinuationImpl;", "completion", "Lkotlin/coroutines/Continuation;", "", "(Lkotlin/coroutines/Continuation;)V", "context", "Lkotlin/coroutines/CoroutineContext;", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "kotlin-stdlib"})
public abstract class f
  extends a
{
  public f(c<Object> paramc)
  {
    super(paramc);
    if (paramc != null)
    {
      if (paramc.eaV() == a.c.f.BMO) {}
      for (int i = 1; i == 0; i = 0) {
        throw ((Throwable)new IllegalArgumentException("Coroutines with restricted suspension must have EmptyCoroutineContext".toString()));
      }
    }
  }
  
  public final e eaV()
  {
    return (e)a.c.f.BMO;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     a.c.b.a.f
 * JD-Core Version:    0.7.0.1
 */
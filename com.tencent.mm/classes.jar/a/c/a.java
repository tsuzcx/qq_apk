package a.c;

import a.f.a.m;
import a.f.b.j;
import a.l;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lkotlin/coroutines/AbstractCoroutineContextElement;", "Lkotlin/coroutines/CoroutineContext$Element;", "key", "Lkotlin/coroutines/CoroutineContext$Key;", "(Lkotlin/coroutines/CoroutineContext$Key;)V", "getKey", "()Lkotlin/coroutines/CoroutineContext$Key;", "kotlin-stdlib"})
public abstract class a
  implements e.b
{
  private final e.c<?> key;
  
  public a(e.c<?> paramc)
  {
    this.key = paramc;
  }
  
  public <R> R fold(R paramR, m<? super R, ? super e.b, ? extends R> paramm)
  {
    j.q(paramm, "operation");
    return e.b.a.a(this, paramR, paramm);
  }
  
  public <E extends e.b> E get(e.c<E> paramc)
  {
    j.q(paramc, "key");
    return e.b.a.a(this, paramc);
  }
  
  public e.c<?> getKey()
  {
    return this.key;
  }
  
  public e minusKey(e.c<?> paramc)
  {
    j.q(paramc, "key");
    return e.b.a.b(this, paramc);
  }
  
  public e plus(e parame)
  {
    j.q(parame, "context");
    return e.b.a.a(this, parame);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     a.c.a
 * JD-Core Version:    0.7.0.1
 */
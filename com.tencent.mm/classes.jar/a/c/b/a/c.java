package a.c.b.a;

import a.c.d;
import a.c.e;
import a.c.e.b;
import a.c.e.c;
import a.f.b.j;
import a.l;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lkotlin/coroutines/jvm/internal/ContinuationImpl;", "Lkotlin/coroutines/jvm/internal/BaseContinuationImpl;", "completion", "Lkotlin/coroutines/Continuation;", "", "(Lkotlin/coroutines/Continuation;)V", "_context", "Lkotlin/coroutines/CoroutineContext;", "(Lkotlin/coroutines/Continuation;Lkotlin/coroutines/CoroutineContext;)V", "context", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "intercepted", "releaseIntercepted", "", "kotlin-stdlib"})
public abstract class c
  extends a
{
  private transient a.c.c<Object> BNc;
  private final e BNd;
  
  public c(a.c.c<Object> paramc) {}
  
  public c(a.c.c<Object> paramc, e parame)
  {
    super(paramc);
    this.BNd = parame;
  }
  
  public final e eaV()
  {
    e locale = this.BNd;
    if (locale == null) {
      j.ebi();
    }
    return locale;
  }
  
  protected final void eaW()
  {
    a.c.c localc = this.BNc;
    if ((localc != null) && (localc != (c)this))
    {
      e.b localb = eaV().get((e.c)d.BML);
      if (localb == null) {
        j.ebi();
      }
      ((d)localb).b(localc);
    }
    this.BNc = ((a.c.c)b.BNb);
  }
  
  public final a.c.c<Object> eaX()
  {
    a.c.c localc = this.BNc;
    Object localObject = localc;
    if (localc == null)
    {
      localObject = (d)eaV().get((e.c)d.BML);
      if (localObject == null) {
        break label52;
      }
    }
    label52:
    for (localObject = ((d)localObject).a((a.c.c)this);; localObject = (a.c.c)this)
    {
      this.BNc = ((a.c.c)localObject);
      return localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     a.c.b.a.c
 * JD-Core Version:    0.7.0.1
 */
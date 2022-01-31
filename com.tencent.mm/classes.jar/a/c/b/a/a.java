package a.c.b.a;

import a.c.c;
import a.f.b.j;
import a.l;
import a.p;
import a.p.a;
import a.q;
import a.y;
import java.io.Serializable;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lkotlin/coroutines/jvm/internal/BaseContinuationImpl;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "Ljava/io/Serializable;", "completion", "(Lkotlin/coroutines/Continuation;)V", "callerFrame", "getCallerFrame", "()Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "getCompletion", "()Lkotlin/coroutines/Continuation;", "create", "", "value", "getStackTraceElement", "Ljava/lang/StackTraceElement;", "invokeSuspend", "result", "Lkotlin/Result;", "(Ljava/lang/Object;)Ljava/lang/Object;", "releaseIntercepted", "resumeWith", "(Ljava/lang/Object;)V", "toString", "", "kotlin-stdlib"})
public abstract class a
  implements c<Object>, Serializable
{
  final c<Object> BNa;
  
  public a(c<Object> paramc)
  {
    this.BNa = paramc;
  }
  
  public c<y> a(Object paramObject, c<?> paramc)
  {
    j.q(paramc, "completion");
    throw ((Throwable)new UnsupportedOperationException("create(Any?;Continuation) has not been overridden"));
  }
  
  protected abstract Object bD(Object paramObject);
  
  public final void dg(Object paramObject)
  {
    j.q((c)this, "frame");
    c localc;
    for (a locala = (a)this;; locala = (a)localc)
    {
      localc = locala.BNa;
      if (localc == null) {
        j.ebi();
      }
      try
      {
        paramObject = locala.bD(paramObject);
        if (paramObject == a.c.a.a.BMS) {
          return;
        }
        locala1 = p.BLX;
        paramObject = p.de(paramObject);
      }
      catch (Throwable paramObject)
      {
        for (;;)
        {
          p.a locala1 = p.BLX;
          paramObject = p.de(q.n(paramObject));
        }
        localc.dg(paramObject);
      }
      locala.eaW();
      if (!(localc instanceof a)) {
        break;
      }
    }
  }
  
  protected void eaW() {}
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("Continuation at ");
    j.q(this, "receiver$0");
    Object localObject = (d)getClass().getAnnotation(d.class);
    if (localObject == null)
    {
      localObject = null;
      if (localObject == null) {
        break label153;
      }
    }
    label153:
    for (localObject = (Serializable)localObject;; localObject = (Serializable)getClass().getName())
    {
      return localObject;
      int i = ((d)localObject).v();
      if (i > 1) {
        throw ((Throwable)new IllegalStateException(("Debug metadata version mismatch. Expected: 1, got " + i + ". Please update the Kotlin standard library.").toString()));
      }
      i = e.a(this);
      if (i < 0) {}
      for (i = -1;; i = localObject.l()[i])
      {
        localObject = new StackTraceElement(((d)localObject).c(), ((d)localObject).m(), ((d)localObject).f(), i);
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     a.c.b.a.a
 * JD-Core Version:    0.7.0.1
 */
package a.c.a;

import a.c.b.a.a;
import a.c.e;
import a.c.f;
import a.f.a.m;
import a.f.b.j;
import a.f.b.z;
import a.l;
import a.v;
import a.y;
import com.tencent.matrix.trace.core.AppMethodBeat;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"createCoroutineFromSuspendFunction", "Lkotlin/coroutines/Continuation;", "", "T", "completion", "block", "Lkotlin/Function1;", "", "createCoroutineFromSuspendFunction$IntrinsicsKt__IntrinsicsJvmKt", "createCoroutineUnintercepted", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;", "R", "Lkotlin/Function2;", "Lkotlin/ExtensionFunctionType;", "receiver", "(Lkotlin/jvm/functions/Function2;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;", "intercepted", "startCoroutineUninterceptedOrReturn", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "(Lkotlin/jvm/functions/Function2;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlin-stdlib"}, eaR=1)
public class c
{
  public static final <R, T> a.c.c<y> a(final m<? super R, ? super a.c.c<? super T>, ? extends Object> paramm, final R paramR, a.c.c<? super T> paramc)
  {
    AppMethodBeat.i(56389);
    j.q(paramm, "receiver$0");
    j.q(paramc, "completion");
    j.q(paramc, "completion");
    if ((paramm instanceof a))
    {
      paramm = ((a)paramm).a(paramR, paramc);
      AppMethodBeat.o(56389);
      return paramm;
    }
    final e locale = paramc.eaV();
    if (locale == f.BMO)
    {
      if (paramc == null)
      {
        paramm = new v("null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
        AppMethodBeat.o(56389);
        throw paramm;
      }
      paramm = (a.c.c)new c.a(paramc, paramc, paramm, paramR);
      AppMethodBeat.o(56389);
      return paramm;
    }
    if (paramc == null)
    {
      paramm = new v("null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
      AppMethodBeat.o(56389);
      throw paramm;
    }
    paramm = (a.c.c)new b(paramc, locale, paramc, locale, paramm, paramR);
    AppMethodBeat.o(56389);
    return paramm;
  }
  
  public static final <T> a.c.c<T> c(a.c.c<? super T> paramc)
  {
    AppMethodBeat.i(56390);
    j.q(paramc, "receiver$0");
    if (!(paramc instanceof a.c.b.a.c)) {}
    for (Object localObject = null;; localObject = paramc)
    {
      a.c.b.a.c localc = (a.c.b.a.c)localObject;
      localObject = paramc;
      if (localc != null)
      {
        localObject = localc.eaX();
        if (localObject != null) {
          break label49;
        }
        localObject = paramc;
      }
      label49:
      for (;;)
      {
        AppMethodBeat.o(56390);
        return localObject;
      }
    }
  }
  
  @l(eaO={1, 1, 13}, eaP={""}, eaQ={"kotlin/coroutines/intrinsics/IntrinsicsKt__IntrinsicsJvmKt$createCoroutineFromSuspendFunction$2", "Lkotlin/coroutines/jvm/internal/ContinuationImpl;", "label", "", "invokeSuspend", "", "result", "Lkotlin/Result;", "(Ljava/lang/Object;)Ljava/lang/Object;", "kotlin-stdlib"})
  public static final class b
    extends a.c.b.a.c
  {
    private int label;
    
    public b(a.c.c paramc1, e parame1, a.c.c paramc2, e parame2, m paramm, Object paramObject)
    {
      super(parame2);
    }
    
    public final Object bD(Object paramObject)
    {
      AppMethodBeat.i(56388);
      switch (this.label)
      {
      default: 
        paramObject = (Throwable)new IllegalStateException("This coroutine had already completed".toString());
        AppMethodBeat.o(56388);
        throw paramObject;
      case 0: 
        this.label = 1;
        paramObject = (a.c.c)this;
        m localm = paramm;
        if (localm == null)
        {
          paramObject = new v("null cannot be cast to non-null type (R, kotlin.coroutines.Continuation<T>) -> kotlin.Any?");
          AppMethodBeat.o(56388);
          throw paramObject;
        }
        paramObject = ((m)z.jdMethod_do(localm)).h(paramR, paramObject);
        AppMethodBeat.o(56388);
        return paramObject;
      }
      this.label = 2;
      AppMethodBeat.o(56388);
      return paramObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     a.c.a.c
 * JD-Core Version:    0.7.0.1
 */
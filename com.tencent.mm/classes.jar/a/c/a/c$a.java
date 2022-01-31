package a.c.a;

import a.c.b.a.f;
import a.c.c;
import a.f.a.m;
import a.f.b.z;
import a.l;
import a.v;
import com.tencent.matrix.trace.core.AppMethodBeat;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"kotlin/coroutines/intrinsics/IntrinsicsKt__IntrinsicsJvmKt$createCoroutineFromSuspendFunction$1", "Lkotlin/coroutines/jvm/internal/RestrictedContinuationImpl;", "label", "", "invokeSuspend", "", "result", "Lkotlin/Result;", "(Ljava/lang/Object;)Ljava/lang/Object;", "kotlin-stdlib"})
public final class c$a
  extends f
{
  private int label;
  
  public c$a(c paramc1, c paramc2, m paramm, Object paramObject)
  {
    super(paramc2);
  }
  
  public final Object bD(Object paramObject)
  {
    AppMethodBeat.i(56391);
    switch (this.label)
    {
    default: 
      paramObject = (Throwable)new IllegalStateException("This coroutine had already completed".toString());
      AppMethodBeat.o(56391);
      throw paramObject;
    case 0: 
      this.label = 1;
      paramObject = (c)this;
      m localm = this.BMX;
      if (localm == null)
      {
        paramObject = new v("null cannot be cast to non-null type (R, kotlin.coroutines.Continuation<T>) -> kotlin.Any?");
        AppMethodBeat.o(56391);
        throw paramObject;
      }
      paramObject = ((m)z.jdMethod_do(localm)).h(this.BMY, paramObject);
      AppMethodBeat.o(56391);
      return paramObject;
    }
    this.label = 2;
    AppMethodBeat.o(56391);
    return paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     a.c.a.c.a
 * JD-Core Version:    0.7.0.1
 */
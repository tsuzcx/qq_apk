package androidx.compose.runtime;

import android.view.Choreographer;
import android.view.Choreographer.FrameCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Result.Companion;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.d.a.a;
import kotlin.d.d;
import kotlin.d.f;
import kotlin.d.f.b;
import kotlin.d.f.c;
import kotlin.g.a.m;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlinx.coroutines.aq;
import kotlinx.coroutines.bg;
import kotlinx.coroutines.cm;
import kotlinx.coroutines.p;
import kotlinx.coroutines.q;

@Metadata(d1={""}, d2={"Landroidx/compose/runtime/DefaultChoreographerFrameClock;", "Landroidx/compose/runtime/MonotonicFrameClock;", "()V", "choreographer", "Landroid/view/Choreographer;", "kotlin.jvm.PlatformType", "withFrameNanos", "R", "onFrame", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "frameTimeNanos", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "runtime_release"}, k=1, mv={1, 5, 1}, xi=48)
final class t
  implements al
{
  public static final t anK;
  private static final Choreographer choreographer;
  
  static
  {
    AppMethodBeat.i(202208);
    anK = new t();
    choreographer = (Choreographer)kotlinx.coroutines.k.b((f)bg.kCh().kCK(), (m)new a(null));
    AppMethodBeat.o(202208);
  }
  
  public final <R> Object b(final kotlin.g.a.b<? super Long, ? extends R> paramb, d<? super R> paramd)
  {
    AppMethodBeat.i(202217);
    q localq = new q(kotlin.d.a.b.au(paramd), 1);
    localq.kBA();
    p localp = (p)localq;
    paramb = (Choreographer.FrameCallback)new c(localp, paramb);
    choreographer.postFrameCallback(paramb);
    localp.bg((kotlin.g.a.b)new b(paramb));
    paramb = localq.getResult();
    if (paramb == a.aiwj) {
      s.u(paramd, "frame");
    }
    AppMethodBeat.o(202217);
    return paramb;
  }
  
  public final <R> R fold(R paramR, m<? super R, ? super f.b, ? extends R> paramm)
  {
    AppMethodBeat.i(202229);
    paramR = al.a.a((al)this, paramR, paramm);
    AppMethodBeat.o(202229);
    return paramR;
  }
  
  public final <E extends f.b> E get(f.c<E> paramc)
  {
    AppMethodBeat.i(202223);
    paramc = al.a.a((al)this, paramc);
    AppMethodBeat.o(202223);
    return paramc;
  }
  
  public final f.c<?> getKey()
  {
    AppMethodBeat.i(202246);
    f.c localc = al.a.a(this);
    AppMethodBeat.o(202246);
    return localc;
  }
  
  public final f minusKey(f.c<?> paramc)
  {
    AppMethodBeat.i(202235);
    paramc = al.a.b((al)this, paramc);
    AppMethodBeat.o(202235);
    return paramc;
  }
  
  public final f plus(f paramf)
  {
    AppMethodBeat.i(202240);
    paramf = al.a.a((al)this, paramf);
    AppMethodBeat.o(202240);
    return paramf;
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/view/Choreographer;", "kotlin.jvm.PlatformType", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends kotlin.d.b.a.k
    implements m<aq, d<? super Choreographer>, Object>
  {
    int label;
    
    a(d<? super a> paramd)
    {
      super(paramd);
    }
    
    public final d<ah> create(Object paramObject, d<?> paramd)
    {
      AppMethodBeat.i(202227);
      paramObject = (d)new a(paramd);
      AppMethodBeat.o(202227);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(202219);
      a locala = a.aiwj;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(202219);
        throw paramObject;
      }
      ResultKt.throwOnFailure(paramObject);
      paramObject = Choreographer.getInstance();
      AppMethodBeat.o(202219);
      return paramObject;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "R", "it", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.b<Throwable, ah>
  {
    b(Choreographer.FrameCallback paramFrameCallback)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "R", "frameTimeNanos", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    implements Choreographer.FrameCallback
  {
    c(p<? super R> paramp, kotlin.g.a.b<? super Long, ? extends R> paramb) {}
    
    public final void doFrame(long paramLong)
    {
      AppMethodBeat.i(202205);
      p localp = this.anM;
      Object localObject1 = t.anK;
      localObject1 = paramb;
      try
      {
        localCompanion = Result.Companion;
        localObject1 = Result.constructor-impl(((kotlin.g.a.b)localObject1).invoke(Long.valueOf(paramLong)));
        localp.resumeWith(localObject1);
        AppMethodBeat.o(202205);
        return;
      }
      finally
      {
        for (;;)
        {
          Result.Companion localCompanion = Result.Companion;
          Object localObject2 = Result.constructor-impl(ResultKt.createFailure(localThrowable));
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.runtime.t
 * JD-Core Version:    0.7.0.1
 */
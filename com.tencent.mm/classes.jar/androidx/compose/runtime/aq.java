package androidx.compose.runtime;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.d.a.a;
import kotlin.d.d<-TR;>;
import kotlin.d.f;
import kotlin.d.f.b;
import kotlin.d.f.c;
import kotlin.g.a.b;
import kotlin.g.a.b<-Ljava.lang.Long;+TR;>;
import kotlin.g.a.m;

@Metadata(d1={""}, d2={"Landroidx/compose/runtime/PausableMonotonicFrameClock;", "Landroidx/compose/runtime/MonotonicFrameClock;", "frameClock", "(Landroidx/compose/runtime/MonotonicFrameClock;)V", "isPaused", "", "()Z", "latch", "Landroidx/compose/runtime/Latch;", "pause", "", "resume", "withFrameNanos", "R", "onFrame", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "frameTimeNanos", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "runtime_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class aq
  implements al
{
  public static final int Ue = 8;
  private final al aox;
  public final ai aoy;
  
  public aq(al paramal)
  {
    AppMethodBeat.i(201882);
    this.aox = paramal;
    this.aoy = new ai();
    AppMethodBeat.o(201882);
  }
  
  public final <R> Object b(b<? super Long, ? extends R> paramb, kotlin.d.d<? super R> paramd)
  {
    AppMethodBeat.i(201905);
    if ((paramd instanceof a))
    {
      localObject1 = (a)paramd;
      if ((((a)localObject1).label & 0x80000000) != 0) {
        ((a)localObject1).label += -2147483648;
      }
    }
    a locala;
    for (paramd = (kotlin.d.d<? super R>)localObject1;; paramd = new a(this, paramd))
    {
      localObject1 = paramd.result;
      locala = a.aiwj;
      switch (paramd.label)
      {
      default: 
        paramb = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(201905);
        throw paramb;
      }
    }
    ResultKt.throwOnFailure(localObject1);
    Object localObject2 = this.aoy;
    paramd.L$0 = this;
    paramd.Uf = paramb;
    paramd.label = 1;
    Object localObject1 = this;
    if (((ai)localObject2).e(paramd) == locala)
    {
      AppMethodBeat.o(201905);
      return locala;
      paramb = (b)paramd.Uf;
      localObject2 = (aq)paramd.L$0;
      ResultKt.throwOnFailure(localObject1);
      localObject1 = localObject2;
    }
    localObject1 = ((aq)localObject1).aox;
    paramd.L$0 = null;
    paramd.Uf = null;
    paramd.label = 2;
    paramd = ((al)localObject1).b(paramb, paramd);
    paramb = paramd;
    if (paramd == locala)
    {
      AppMethodBeat.o(201905);
      return locala;
      ResultKt.throwOnFailure(localObject1);
      paramb = (b<? super Long, ? extends R>)localObject1;
    }
    AppMethodBeat.o(201905);
    return paramb;
  }
  
  public final <R> R fold(R paramR, m<? super R, ? super f.b, ? extends R> paramm)
  {
    AppMethodBeat.i(201919);
    paramR = al.a.a((al)this, paramR, paramm);
    AppMethodBeat.o(201919);
    return paramR;
  }
  
  public final <E extends f.b> E get(f.c<E> paramc)
  {
    AppMethodBeat.i(201911);
    paramc = al.a.a((al)this, paramc);
    AppMethodBeat.o(201911);
    return paramc;
  }
  
  public final f.c<?> getKey()
  {
    AppMethodBeat.i(201934);
    f.c localc = al.a.a(this);
    AppMethodBeat.o(201934);
    return localc;
  }
  
  public final f minusKey(f.c<?> paramc)
  {
    AppMethodBeat.i(201925);
    paramc = al.a.b((al)this, paramc);
    AppMethodBeat.o(201925);
    return paramc;
  }
  
  public final void pause()
  {
    Object localObject2 = this.aoy;
    synchronized (((ai)localObject2).lock)
    {
      ((ai)localObject2).aop = false;
      localObject2 = ah.aiuX;
      return;
    }
  }
  
  public final f plus(f paramf)
  {
    AppMethodBeat.i(201929);
    paramf = al.a.a((al)this, paramf);
    AppMethodBeat.o(201929);
    return paramf;
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class a<R>
    extends kotlin.d.b.a.d
  {
    Object L$0;
    Object Uf;
    int label;
    
    a(aq paramaq, kotlin.d.d<? super a> paramd)
    {
      super();
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(202404);
      this.result = paramObject;
      this.label |= 0x80000000;
      paramObject = this.aoz.b(null, (kotlin.d.d)this);
      AppMethodBeat.o(202404);
      return paramObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.runtime.aq
 * JD-Core Version:    0.7.0.1
 */
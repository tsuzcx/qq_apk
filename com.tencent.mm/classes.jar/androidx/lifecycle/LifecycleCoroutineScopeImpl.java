package androidx.lifecycle;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.d.a.a;
import kotlin.d.b.a.k;
import kotlin.d.d;
import kotlin.d.f;
import kotlin.g.a.m;
import kotlin.g.b.s;
import kotlinx.coroutines.aq;
import kotlinx.coroutines.cg;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Landroidx/lifecycle/LifecycleCoroutineScopeImpl;", "Landroidx/lifecycle/LifecycleCoroutineScope;", "Landroidx/lifecycle/LifecycleEventObserver;", "lifecycle", "Landroidx/lifecycle/Lifecycle;", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "(Landroidx/lifecycle/Lifecycle;Lkotlin/coroutines/CoroutineContext;)V", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "getLifecycle$lifecycle_runtime_ktx_release", "()Landroidx/lifecycle/Lifecycle;", "onStateChanged", "", "source", "Landroidx/lifecycle/LifecycleOwner;", "event", "Landroidx/lifecycle/Lifecycle$Event;", "register", "lifecycle-runtime-ktx_release"}, k=1, mv={1, 4, 1})
public final class LifecycleCoroutineScopeImpl
  extends l
  implements o
{
  private final f bGV;
  final j lifecycle;
  
  public LifecycleCoroutineScopeImpl(j paramj, f paramf)
  {
    AppMethodBeat.i(194474);
    this.lifecycle = paramj;
    this.bGV = paramf;
    if (this.lifecycle.getCurrentState() == j.b.bHg) {
      cg.a(getCoroutineContext(), null);
    }
    AppMethodBeat.o(194474);
  }
  
  public final f getCoroutineContext()
  {
    return this.bGV;
  }
  
  public final void onStateChanged(q paramq, j.a parama)
  {
    AppMethodBeat.i(194487);
    s.u(paramq, "source");
    s.u(parama, "event");
    if (this.lifecycle.getCurrentState().compareTo((Enum)j.b.bHg) <= 0)
    {
      this.lifecycle.removeObserver((p)this);
      cg.a(getCoroutineContext(), null);
    }
    AppMethodBeat.o(194487);
  }
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k=3, mv={1, 4, 1})
  static final class a
    extends k
    implements m<aq, d<? super ah>, Object>
  {
    int label;
    
    a(LifecycleCoroutineScopeImpl paramLifecycleCoroutineScopeImpl, d paramd)
    {
      super(paramd);
    }
    
    public final d<ah> create(Object paramObject, d<?> paramd)
    {
      AppMethodBeat.i(194373);
      s.u(paramd, "completion");
      paramd = new a(this.bHn, paramd);
      paramd.L$0 = paramObject;
      AppMethodBeat.o(194373);
      return paramd;
    }
    
    public final Object invoke(Object paramObject1, Object paramObject2)
    {
      AppMethodBeat.i(194376);
      paramObject1 = ((a)create(paramObject1, (d)paramObject2)).invokeSuspend(ah.aiuX);
      AppMethodBeat.o(194376);
      return paramObject1;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(194365);
      a locala = a.aiwj;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(194365);
        throw paramObject;
      }
      ResultKt.throwOnFailure(paramObject);
      paramObject = (aq)this.L$0;
      if (this.bHn.lifecycle.getCurrentState().compareTo((Enum)j.b.bHh) >= 0) {
        this.bHn.lifecycle.addObserver((p)this.bHn);
      }
      for (;;)
      {
        paramObject = ah.aiuX;
        AppMethodBeat.o(194365);
        return paramObject;
        cg.a(paramObject.getCoroutineContext(), null);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.lifecycle.LifecycleCoroutineScopeImpl
 * JD-Core Version:    0.7.0.1
 */
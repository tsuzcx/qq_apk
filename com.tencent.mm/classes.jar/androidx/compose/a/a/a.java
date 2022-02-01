package androidx.compose.a.a;

import androidx.compose.runtime.an;
import androidx.compose.runtime.bj;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.g.a.b;
import kotlin.g.b.ah.a;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Landroidx/compose/animation/core/Animatable;", "T", "V", "Landroidx/compose/animation/core/AnimationVector;", "", "initialValue", "typeConverter", "Landroidx/compose/animation/core/TwoWayConverter;", "visibilityThreshold", "(Ljava/lang/Object;Landroidx/compose/animation/core/TwoWayConverter;Ljava/lang/Object;)V", "defaultSpringSpec", "Landroidx/compose/animation/core/SpringSpec;", "getDefaultSpringSpec$animation_core_release", "()Landroidx/compose/animation/core/SpringSpec;", "internalState", "Landroidx/compose/animation/core/AnimationState;", "getInternalState$animation_core_release", "()Landroidx/compose/animation/core/AnimationState;", "<set-?>", "", "isRunning", "()Z", "setRunning", "(Z)V", "isRunning$delegate", "Landroidx/compose/runtime/MutableState;", "lowerBound", "getLowerBound", "()Ljava/lang/Object;", "Ljava/lang/Object;", "lowerBoundVector", "Landroidx/compose/animation/core/AnimationVector;", "mutatorMutex", "Landroidx/compose/animation/core/MutatorMutex;", "negativeInfinityBounds", "positiveInfinityBounds", "targetValue", "getTargetValue", "setTargetValue", "(Ljava/lang/Object;)V", "targetValue$delegate", "getTypeConverter", "()Landroidx/compose/animation/core/TwoWayConverter;", "upperBound", "getUpperBound", "upperBoundVector", "value", "getValue", "velocity", "getVelocity", "velocityVector", "getVelocityVector", "()Landroidx/compose/animation/core/AnimationVector;", "animateDecay", "Landroidx/compose/animation/core/AnimationResult;", "initialVelocity", "animationSpec", "Landroidx/compose/animation/core/DecayAnimationSpec;", "block", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "(Ljava/lang/Object;Landroidx/compose/animation/core/DecayAnimationSpec;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "animateTo", "Landroidx/compose/animation/core/AnimationSpec;", "(Ljava/lang/Object;Landroidx/compose/animation/core/AnimationSpec;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "asState", "Landroidx/compose/runtime/State;", "clampToBounds", "(Ljava/lang/Object;)Ljava/lang/Object;", "endAnimation", "runAnimation", "animation", "Landroidx/compose/animation/core/Animation;", "(Landroidx/compose/animation/core/Animation;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "snapTo", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "stop", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateBounds", "(Ljava/lang/Object;Ljava/lang/Object;)V", "createVector", "", "(Ljava/lang/Object;F)Landroidx/compose/animation/core/AnimationVector;", "animation-core_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a<T, V extends k>
{
  public static final int Ue = 8;
  final aw<T, V> TT;
  private final T TU;
  public final i<T, V> TV;
  private final an TW;
  private final an TX;
  private final al TY;
  private final aq<T> TZ;
  private final V Ua;
  private final V Ub;
  private V Uc;
  private V Ud;
  
  public a(T paramT1, aw<T, V> paramaw, T paramT2)
  {
    AppMethodBeat.i(203426);
    this.TT = paramaw;
    this.TU = paramT2;
    this.TV = new i(this.TT, paramT1, null, 0L, 0L, 60);
    this.TW = bj.T(Boolean.FALSE);
    this.TX = bj.T(paramT1);
    this.TY = new al();
    this.TZ = new aq(0.0F, 0.0F, this.TU, 3);
    this.Ua = a(paramT1, (1.0F / -1.0F));
    this.Ub = a(paramT1, (1.0F / 1.0F));
    this.Uc = this.Ua;
    this.Ud = this.Ub;
    AppMethodBeat.o(203426);
  }
  
  private final V a(T paramT, float paramFloat)
  {
    AppMethodBeat.i(203435);
    paramT = (k)this.TT.md().invoke(paramT);
    int i = 0;
    int k = paramT.lK();
    if (k > 0) {}
    for (;;)
    {
      int j = i + 1;
      paramT.e(i, paramFloat);
      if (j >= k)
      {
        AppMethodBeat.o(203435);
        return paramT;
      }
      i = j;
    }
  }
  
  private final void ag(boolean paramBoolean)
  {
    AppMethodBeat.i(203430);
    this.TW.setValue(Boolean.valueOf(paramBoolean));
    AppMethodBeat.o(203430);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroidx/compose/animation/core/AnimationResult;", "T", "V", "Landroidx/compose/animation/core/AnimationVector;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends kotlin.d.b.a.k
    implements b<kotlin.d.d<? super e<T, V>>, Object>
  {
    Object L$0;
    Object Uf;
    int label;
    
    a(a<T, V> parama, T paramT, c<T, V> paramc, long paramLong, b<? super a<T, V>, ah> paramb, kotlin.d.d<? super a> paramd)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<ah> create(kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(203262);
      paramd = (kotlin.d.d)new a(this.Ug, this.Uh, this.Ui, this.Uj, this.Uk, paramd);
      AppMethodBeat.o(203262);
      return paramd;
    }
    
    public final Object invokeSuspend(final Object paramObject)
    {
      AppMethodBeat.i(203258);
      Object localObject2 = kotlin.d.a.a.aiwj;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(203258);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
      }
      try
      {
        paramObject = this.Ug.TV;
        localObject1 = (k)this.Ug.TT.md().invoke(this.Uh);
        s.u(localObject1, "<set-?>");
        paramObject.Uw = ((k)localObject1);
        a.a(this.Ug, this.Ui.lE());
        a.a(this.Ug);
        paramObject = this.Ug.TV;
        localObject1 = paramObject.getValue();
        Object localObject3 = o.c(paramObject.Uw);
        long l = paramObject.Ux;
        boolean bool = paramObject.Uz;
        s.u(paramObject, "<this>");
        paramObject = new i(paramObject.TT, localObject1, (k)localObject3, l, -9223372036854775808L, bool);
        localObject1 = new ah.a();
        localObject3 = this.Ui;
        l = this.Uj;
        b localb = (b)new u(this.Ug) {};
        kotlin.d.d locald = (kotlin.d.d)this;
        this.L$0 = paramObject;
        this.Uf = localObject1;
        this.label = 1;
        localObject3 = ar.a(paramObject, (c)localObject3, l, localb, locald);
        if (localObject3 != localObject2) {
          break label368;
        }
        AppMethodBeat.o(203258);
        return localObject2;
      }
      catch (CancellationException paramObject)
      {
        Object localObject1;
        a.b(this.Ug);
        AppMethodBeat.o(203258);
        throw paramObject;
      }
      localObject1 = (ah.a)this.Uf;
      localObject2 = (i)this.L$0;
      ResultKt.throwOnFailure(paramObject);
      paramObject = localObject2;
      label368:
      for (;;)
      {
        if (((ah.a)localObject1).aiwY) {}
        for (localObject1 = d.Un;; localObject1 = d.Uo)
        {
          a.b(this.Ug);
          paramObject = new e(paramObject, (d)localObject1);
          AppMethodBeat.o(203258);
          return paramObject;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.a.a.a
 * JD-Core Version:    0.7.0.1
 */
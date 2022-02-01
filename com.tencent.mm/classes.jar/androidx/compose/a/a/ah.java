package androidx.compose.a.a;

import androidx.compose.runtime.a.e;
import androidx.compose.runtime.aa;
import androidx.compose.runtime.an;
import androidx.compose.runtime.ba;
import androidx.compose.runtime.bj;
import androidx.compose.runtime.bm;
import androidx.compose.runtime.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.d.a.a;
import kotlin.d.d;
import kotlin.g.a.b;
import kotlin.g.a.m;
import kotlin.g.b.q;
import kotlin.g.b.u;
import kotlinx.coroutines.aq;

@Metadata(d1={""}, d2={"Landroidx/compose/animation/core/InfiniteTransition;", "", "()V", "animations", "Landroidx/compose/runtime/collection/MutableVector;", "Landroidx/compose/animation/core/InfiniteTransition$TransitionAnimationState;", "getAnimations$animation_core_release", "()Landroidx/compose/runtime/collection/MutableVector;", "<set-?>", "", "isRunning", "()Z", "setRunning", "(Z)V", "isRunning$delegate", "Landroidx/compose/runtime/MutableState;", "refreshChildNeeded", "getRefreshChildNeeded", "setRefreshChildNeeded", "refreshChildNeeded$delegate", "startTimeNanos", "", "addAnimation", "", "animation", "addAnimation$animation_core_release", "onFrame", "frameTimeNanos", "removeAnimation", "removeAnimation$animation_core_release", "run", "run$animation_core_release", "(Landroidx/compose/runtime/Composer;I)V", "TransitionAnimationState", "animation-core_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ah
{
  public static final int Ue = 8;
  private final an TW;
  private long Ut;
  final e<a<?, ?>> Ve;
  private final an Vf;
  
  public ah()
  {
    AppMethodBeat.i(203387);
    this.Ve = new e(new a[16]);
    this.Vf = bj.T(Boolean.FALSE);
    this.Ut = -9223372036854775808L;
    this.TW = bj.T(Boolean.TRUE);
    AppMethodBeat.o(203387);
  }
  
  public final void a(h paramh, final int paramInt)
  {
    AppMethodBeat.i(203415);
    paramh = paramh.by(2102343854);
    if ((((Boolean)((bm)this.TW).getValue()).booleanValue()) || (((Boolean)((bm)this.Vf).getValue()).booleanValue()))
    {
      paramh.bx(2102343911);
      aa.a(this, (m)new b(this, null), paramh);
      paramh.od();
    }
    for (;;)
    {
      paramh = paramh.oh();
      if (paramh != null) {
        paramh.b((m)new c(this, paramInt));
      }
      AppMethodBeat.o(203415);
      return;
      paramh.bx(2102344083);
      paramh.od();
    }
  }
  
  final void ah(boolean paramBoolean)
  {
    AppMethodBeat.i(203408);
    this.Vf.setValue(Boolean.valueOf(paramBoolean));
    AppMethodBeat.o(203408);
  }
  
  @Metadata(d1={""}, d2={"Landroidx/compose/animation/core/InfiniteTransition$TransitionAnimationState;", "T", "V", "Landroidx/compose/animation/core/AnimationVector;", "Landroidx/compose/runtime/State;", "initialValue", "targetValue", "typeConverter", "Landroidx/compose/animation/core/TwoWayConverter;", "animationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "(Landroidx/compose/animation/core/InfiniteTransition;Ljava/lang/Object;Ljava/lang/Object;Landroidx/compose/animation/core/TwoWayConverter;Landroidx/compose/animation/core/AnimationSpec;)V", "animation", "Landroidx/compose/animation/core/TargetBasedAnimation;", "getAnimation", "()Landroidx/compose/animation/core/TargetBasedAnimation;", "setAnimation", "(Landroidx/compose/animation/core/TargetBasedAnimation;)V", "getAnimationSpec", "()Landroidx/compose/animation/core/AnimationSpec;", "setAnimationSpec", "(Landroidx/compose/animation/core/AnimationSpec;)V", "getInitialValue", "()Ljava/lang/Object;", "setInitialValue", "(Ljava/lang/Object;)V", "Ljava/lang/Object;", "isFinished", "", "()Z", "setFinished", "(Z)V", "playTimeNanosOffset", "", "getPlayTimeNanosOffset", "()J", "setPlayTimeNanosOffset", "(J)V", "startOnTheNextFrame", "getStartOnTheNextFrame", "setStartOnTheNextFrame", "getTargetValue", "setTargetValue", "getTypeConverter", "()Landroidx/compose/animation/core/TwoWayConverter;", "<set-?>", "value", "getValue", "setValue$animation_core_release", "value$delegate", "Landroidx/compose/runtime/MutableState;", "onPlayTimeChanged", "", "playTimeNanos", "updateValues", "(Ljava/lang/Object;Ljava/lang/Object;Landroidx/compose/animation/core/AnimationSpec;)V", "animation-core_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class a<T, V extends k>
    implements bm<T>
  {
    final aw<T, V> TT;
    T UH;
    T Us;
    final an Uv;
    g<T> Vg;
    as<T, V> Vh;
    boolean Vi;
    long Vj;
    boolean isFinished;
    
    public a(T paramT, aw<T, V> paramaw, g<T> paramg)
    {
      AppMethodBeat.i(203247);
      this.UH = paramT;
      this.Us = paramaw;
      this.TT = paramg;
      this.Vg = localObject;
      this.Uv = bj.T(this.UH);
      this.Vh = new as(this.Vg, this.TT, this.UH, this.Us);
      AppMethodBeat.o(203247);
    }
    
    public final T getValue()
    {
      AppMethodBeat.i(203250);
      Object localObject = ((bm)this.Uv).getValue();
      AppMethodBeat.o(203250);
      return localObject;
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends kotlin.d.b.a.k
    implements m<aq, d<? super kotlin.ah>, Object>
  {
    int label;
    
    b(ah paramah, d<? super b> paramd)
    {
      super(paramd);
    }
    
    public final d<kotlin.ah> create(Object paramObject, d<?> paramd)
    {
      AppMethodBeat.i(203249);
      paramObject = (d)new b(this.Vk, paramd);
      AppMethodBeat.o(203249);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(203243);
      a locala = a.aiwj;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(203243);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
      }
      for (;;)
      {
        paramObject = (b)new q() {};
        d locald = (d)this;
        this.label = 1;
        if (af.a(paramObject, locald) == locala)
        {
          AppMethodBeat.o(203243);
          return locala;
          ResultKt.throwOnFailure(paramObject);
        }
      }
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements m<h, Integer, kotlin.ah>
  {
    c(ah paramah, int paramInt)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.a.a.ah
 * JD-Core Version:    0.7.0.1
 */
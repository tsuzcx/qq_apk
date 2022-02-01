package androidx.compose.a.a;

import androidx.compose.runtime.an;
import androidx.compose.runtime.bj;
import androidx.compose.runtime.bm;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.a;
import kotlin.g.a.b;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Landroidx/compose/animation/core/AnimationScope;", "T", "V", "Landroidx/compose/animation/core/AnimationVector;", "", "initialValue", "typeConverter", "Landroidx/compose/animation/core/TwoWayConverter;", "initialVelocityVector", "lastFrameTimeNanos", "", "targetValue", "startTimeNanos", "isRunning", "", "onCancel", "Lkotlin/Function0;", "", "(Ljava/lang/Object;Landroidx/compose/animation/core/TwoWayConverter;Landroidx/compose/animation/core/AnimationVector;JLjava/lang/Object;JZLkotlin/jvm/functions/Function0;)V", "<set-?>", "finishedTimeNanos", "getFinishedTimeNanos", "()J", "setFinishedTimeNanos$animation_core_release", "(J)V", "()Z", "setRunning$animation_core_release", "(Z)V", "isRunning$delegate", "Landroidx/compose/runtime/MutableState;", "getLastFrameTimeNanos", "setLastFrameTimeNanos$animation_core_release", "getStartTimeNanos", "getTargetValue", "()Ljava/lang/Object;", "Ljava/lang/Object;", "getTypeConverter", "()Landroidx/compose/animation/core/TwoWayConverter;", "value", "getValue", "setValue$animation_core_release", "(Ljava/lang/Object;)V", "value$delegate", "velocity", "getVelocity", "velocityVector", "getVelocityVector", "()Landroidx/compose/animation/core/AnimationVector;", "setVelocityVector$animation_core_release", "(Landroidx/compose/animation/core/AnimationVector;)V", "Landroidx/compose/animation/core/AnimationVector;", "cancelAnimation", "toAnimationState", "Landroidx/compose/animation/core/AnimationState;", "animation-core_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class f<T, V extends k>
{
  public static final int Ue = 8;
  private final aw<T, V> TT;
  private final an TW;
  private final T Us;
  final long Ut;
  private final a<ah> Uu;
  private final an Uv;
  V Uw;
  long Ux;
  long Uy;
  
  public f(T paramT1, aw<T, V> paramaw, V paramV, long paramLong1, T paramT2, long paramLong2, a<ah> parama)
  {
    AppMethodBeat.i(203254);
    this.TT = paramaw;
    this.Us = paramT2;
    this.Ut = paramLong2;
    this.Uu = parama;
    this.Uv = bj.T(paramT1);
    this.Uw = o.c(paramV);
    this.Ux = paramLong1;
    this.Uy = -9223372036854775808L;
    this.TW = bj.T(Boolean.TRUE);
    AppMethodBeat.o(203254);
  }
  
  public final void A(T paramT)
  {
    AppMethodBeat.i(203270);
    this.Uv.setValue(paramT);
    AppMethodBeat.o(203270);
  }
  
  public final void a(V paramV)
  {
    AppMethodBeat.i(203276);
    s.u(paramV, "<set-?>");
    this.Uw = paramV;
    AppMethodBeat.o(203276);
  }
  
  public final void cancelAnimation()
  {
    AppMethodBeat.i(203290);
    lG();
    this.Uu.invoke();
    AppMethodBeat.o(203290);
  }
  
  public final T getValue()
  {
    AppMethodBeat.i(203265);
    Object localObject = ((bm)this.Uv).getValue();
    AppMethodBeat.o(203265);
    return localObject;
  }
  
  public final boolean isRunning()
  {
    AppMethodBeat.i(203282);
    boolean bool = ((Boolean)((bm)this.TW).getValue()).booleanValue();
    AppMethodBeat.o(203282);
    return bool;
  }
  
  public final void lG()
  {
    AppMethodBeat.i(203285);
    this.TW.setValue(Boolean.FALSE);
    AppMethodBeat.o(203285);
  }
  
  public final T lH()
  {
    AppMethodBeat.i(203289);
    Object localObject = this.TT.me().invoke(this.Uw);
    AppMethodBeat.o(203289);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.a.a.f
 * JD-Core Version:    0.7.0.1
 */
package androidx.compose.a.a;

import androidx.compose.runtime.an;
import androidx.compose.runtime.bj;
import androidx.compose.runtime.bm;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.a.b;

@Metadata(d1={""}, d2={"Landroidx/compose/animation/core/AnimationState;", "T", "V", "Landroidx/compose/animation/core/AnimationVector;", "Landroidx/compose/runtime/State;", "typeConverter", "Landroidx/compose/animation/core/TwoWayConverter;", "initialValue", "initialVelocityVector", "lastFrameTimeNanos", "", "finishedTimeNanos", "isRunning", "", "(Landroidx/compose/animation/core/TwoWayConverter;Ljava/lang/Object;Landroidx/compose/animation/core/AnimationVector;JJZ)V", "<set-?>", "getFinishedTimeNanos", "()J", "setFinishedTimeNanos$animation_core_release", "(J)V", "()Z", "setRunning$animation_core_release", "(Z)V", "getLastFrameTimeNanos", "setLastFrameTimeNanos$animation_core_release", "getTypeConverter", "()Landroidx/compose/animation/core/TwoWayConverter;", "value", "getValue", "()Ljava/lang/Object;", "setValue$animation_core_release", "(Ljava/lang/Object;)V", "value$delegate", "Landroidx/compose/runtime/MutableState;", "velocity", "getVelocity", "velocityVector", "getVelocityVector", "()Landroidx/compose/animation/core/AnimationVector;", "setVelocityVector$animation_core_release", "(Landroidx/compose/animation/core/AnimationVector;)V", "Landroidx/compose/animation/core/AnimationVector;", "animation-core_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class i<T, V extends k>
  implements bm<T>
{
  final aw<T, V> TT;
  private final an Uv;
  V Uw;
  long Ux;
  long Uy;
  boolean Uz;
  
  public i(aw<T, V> paramaw, T paramT, V paramV, long paramLong1, long paramLong2, boolean paramBoolean)
  {
    AppMethodBeat.i(203253);
    this.TT = paramaw;
    this.Uv = bj.T(paramT);
    if (paramV == null) {}
    for (paramaw = null;; paramaw = o.c(paramV))
    {
      paramV = paramaw;
      if (paramaw == null) {
        paramV = j.a(this.TT, paramT);
      }
      this.Uw = paramV;
      this.Ux = paramLong1;
      this.Uy = paramLong2;
      this.Uz = paramBoolean;
      AppMethodBeat.o(203253);
      return;
    }
  }
  
  public final void A(T paramT)
  {
    AppMethodBeat.i(203266);
    this.Uv.setValue(paramT);
    AppMethodBeat.o(203266);
  }
  
  public final T getValue()
  {
    AppMethodBeat.i(203260);
    Object localObject = ((bm)this.Uv).getValue();
    AppMethodBeat.o(203260);
    return localObject;
  }
  
  public final T lH()
  {
    AppMethodBeat.i(203273);
    Object localObject = this.TT.me().invoke(this.Uw);
    AppMethodBeat.o(203273);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.a.a.i
 * JD-Core Version:    0.7.0.1
 */
package androidx.compose.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Landroidx/compose/animation/core/VectorizedAnimationSpec;", "V", "Landroidx/compose/animation/core/AnimationVector;", "", "isInfinite", "", "()Z", "getDurationNanos", "", "initialValue", "targetValue", "initialVelocity", "(Landroidx/compose/animation/core/AnimationVector;Landroidx/compose/animation/core/AnimationVector;Landroidx/compose/animation/core/AnimationVector;)J", "getEndVelocity", "(Landroidx/compose/animation/core/AnimationVector;Landroidx/compose/animation/core/AnimationVector;Landroidx/compose/animation/core/AnimationVector;)Landroidx/compose/animation/core/AnimationVector;", "getValueFromNanos", "playTimeNanos", "(JLandroidx/compose/animation/core/AnimationVector;Landroidx/compose/animation/core/AnimationVector;Landroidx/compose/animation/core/AnimationVector;)Landroidx/compose/animation/core/AnimationVector;", "getVelocityFromNanos", "animation-core_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract interface az<V extends k>
{
  public abstract long a(V paramV1, V paramV2, V paramV3);
  
  public abstract V a(long paramLong, V paramV1, V paramV2, V paramV3);
  
  public abstract V b(long paramLong, V paramV1, V paramV2, V paramV3);
  
  public abstract V b(V paramV1, V paramV2, V paramV3);
  
  public abstract boolean lF();
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public static <V extends k> V a(az<V> paramaz, V paramV1, V paramV2, V paramV3)
    {
      AppMethodBeat.i(203410);
      s.u(paramaz, "this");
      s.u(paramV1, "initialValue");
      s.u(paramV2, "targetValue");
      s.u(paramV3, "initialVelocity");
      paramaz = paramaz.b(paramaz.a(paramV1, paramV2, paramV3), paramV1, paramV2, paramV3);
      AppMethodBeat.o(203410);
      return paramaz;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.a.a.az
 * JD-Core Version:    0.7.0.1
 */
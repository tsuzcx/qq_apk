package androidx.compose.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Landroidx/compose/animation/core/FloatAnimationSpec;", "Landroidx/compose/animation/core/AnimationSpec;", "", "getDurationNanos", "", "initialValue", "targetValue", "initialVelocity", "getEndVelocity", "getValueFromNanos", "playTimeNanos", "getVelocityFromNanos", "vectorize", "Landroidx/compose/animation/core/VectorizedFloatAnimationSpec;", "V", "Landroidx/compose/animation/core/AnimationVector;", "converter", "Landroidx/compose/animation/core/TwoWayConverter;", "animation-core_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract interface ab
  extends g<Float>
{
  public abstract float a(long paramLong, float paramFloat1, float paramFloat2, float paramFloat3);
  
  public abstract float b(long paramLong, float paramFloat1, float paramFloat2, float paramFloat3);
  
  public abstract float d(float paramFloat1, float paramFloat2, float paramFloat3);
  
  public abstract long e(float paramFloat1, float paramFloat2, float paramFloat3);
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public static <V extends k> be<V> a(ab paramab, aw<Float, V> paramaw)
    {
      AppMethodBeat.i(203183);
      s.u(paramab, "this");
      s.u(paramaw, "converter");
      paramab = new be(paramab);
      AppMethodBeat.o(203183);
      return paramab;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.a.a.ab
 * JD-Core Version:    0.7.0.1
 */